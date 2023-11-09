package com.autel.camera.protocol.protocol20.parser;

import com.autel.camera.protocol.protocol20.entity.CameraHttpParamFactory;
import com.autel.camera.protocol.protocol20.entity.base.RequestBean;
import com.autel.camera.protocol.protocol20.request.RequestManager;
import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.FailedCallback;
import com.autel.common.error.AutelError;
import com.autel.downloader.bean.DownloadTask;
import com.autel.internal.sdk.camera.BaseCameraMsgParser;
import com.autel.util.log.AutelLog;
import com.autel.util.okhttp.callback.CameraMsgResponseCallback;

public class BaseRequest {
    private static final String TAG = "RequestManager";
    protected RequestManager requestManager = RequestManager.instance();

    public boolean checkCallBack(Object obj) {
        return obj != null;
    }

    public <T> void query(String str, Class<T> cls, CallbackWithOneParam<T> callbackWithOneParam) {
        RequestBean requestBean = new RequestBean();
        requestBean.setMethod(str);
        int i = CameraHttpParamFactory.f8461id;
        CameraHttpParamFactory.f8461id = i + 1;
        requestBean.setId(i);
        this.requestManager.request(requestBean, cls, callbackWithOneParam);
    }

    public <P> void request(String str, P p, final CallbackWithNoParam callbackWithNoParam) {
        RequestBean requestBean = new RequestBean();
        requestBean.setMethod(str);
        requestBean.setParams(p);
        int i = CameraHttpParamFactory.f8461id;
        CameraHttpParamFactory.f8461id = i + 1;
        requestBean.setId(i);
        this.requestManager.requestSetParams(requestBean, new CallbackWithOneParam<Boolean>() {
            public void onSuccess(Boolean bool) {
                if (callbackWithNoParam == null) {
                    return;
                }
                if (bool.booleanValue()) {
                    callbackWithNoParam.onSuccess();
                } else {
                    callbackWithNoParam.onFailure(AutelError.COMMAND_FAILED);
                }
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public <P, T> void query(String str, P p, Class<T> cls, CallbackWithOneParam<T> callbackWithOneParam) {
        RequestBean requestBean = new RequestBean();
        requestBean.setMethod(str);
        requestBean.setParams(p);
        int i = CameraHttpParamFactory.f8461id;
        CameraHttpParamFactory.f8461id = i + 1;
        requestBean.setId(i);
        this.requestManager.request(requestBean, cls, callbackWithOneParam);
    }

    public void request(String str, final CallbackWithNoParam callbackWithNoParam) {
        this.requestManager.doPost(str, new CameraMsgResponseCallback<BaseCameraMsgParser>() {
            /* access modifiers changed from: protected */
            public BaseCameraMsgParser convertFromParser(BaseCameraMsgParser baseCameraMsgParser) {
                return baseCameraMsgParser;
            }

            public void onSuccess(BaseCameraMsgParser baseCameraMsgParser) {
                BaseRequest.this.onCallbackSuc(baseCameraMsgParser, callbackWithNoParam);
            }

            public void onFailure(Throwable th) {
                AutelLog.debug_i(BaseRequest.TAG, "onFailure-->> " + th.getMessage());
                BaseRequest.this.onCallbackFailed(callbackWithNoParam);
            }
        });
    }

    public void request(String str, final CallbackWithOneParam<BaseCameraMsgParser> callbackWithOneParam) {
        this.requestManager.doPost(str, new CameraMsgResponseCallback<BaseCameraMsgParser>() {
            /* access modifiers changed from: protected */
            public BaseCameraMsgParser convertFromParser(BaseCameraMsgParser baseCameraMsgParser) {
                return baseCameraMsgParser;
            }

            public void onSuccess(BaseCameraMsgParser baseCameraMsgParser) {
                CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                if (callbackWithOneParam != null) {
                    callbackWithOneParam.onSuccess(baseCameraMsgParser);
                }
            }

            public void onFailure(Throwable th) {
                AutelLog.debug_i(BaseRequest.TAG, "onFailure-->> " + th.getMessage());
                BaseRequest.this.onCallbackFailed(callbackWithOneParam);
            }
        });
    }

    public <T> void callbackSuccess(CallbackWithOneParam<T> callbackWithOneParam, T t) {
        if (callbackWithOneParam != null) {
            callbackWithOneParam.onSuccess(t);
        }
    }

    public <T> void callbackFailed(CallbackWithOneParam<T> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            callbackWithOneParam.onFailure(AutelError.COMMON_TIMEOUT);
        }
    }

    public void callbackSuccess(CallbackWithNoParam callbackWithNoParam) {
        if (callbackWithNoParam != null) {
            callbackWithNoParam.onSuccess();
        }
    }

    public void onCallbackFailed(FailedCallback failedCallback) {
        if (failedCallback != null) {
            failedCallback.onFailure(AutelError.COMMON_TIMEOUT);
        }
    }

    public void onCallbackSuc(BaseCameraMsgParser baseCameraMsgParser, CallbackWithNoParam callbackWithNoParam) {
        if (callbackWithNoParam == null) {
            return;
        }
        if (baseCameraMsgParser.getIntParam(DownloadTask.STATUS) == 0) {
            callbackWithNoParam.onSuccess();
        } else {
            callbackWithNoParam.onFailure(AutelError.COMMAND_FAILED);
        }
    }
}

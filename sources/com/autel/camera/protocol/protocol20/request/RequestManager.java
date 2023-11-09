package com.autel.camera.protocol.protocol20.request;

import com.autel.camera.utils.IpConstantUtils;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.error.AutelError;
import com.autel.downloader.bean.DownloadTask;
import com.autel.internal.sdk.camera.BaseCameraMsgParser;
import com.autel.internal.sdk.error.AutelErrorUtil;
import com.autel.util.log.AutelLog;
import com.autel.util.okhttp.OkHttpManager;
import com.autel.util.okhttp.callback.CameraMsgResponseCallback;
import com.autel.util.okhttp.callback.ResponseCallBack;
import com.autel.util.okhttp.model.Headers;
import com.autel.util.okhttp.model.HttpMediaType;
import com.autel.util.okhttp.utils.MessageParser;
import com.google.gson.Gson;
import java.lang.reflect.Type;
import java.util.concurrent.TimeUnit;

public class RequestManager {
    private static final String TAG = "RequestManager";
    private static RequestManager s_instance;
    private Gson gsonParser = new Gson();
    private Headers headers = new Headers();
    private OkHttpManager mOkHttpManager = null;
    public MessageParser messageParser = new MessageParser();

    private RequestManager() {
        this.headers.put("connection", Headers.HEAD_VALUE_CONNECTION_CLOSE);
        if (this.mOkHttpManager == null) {
            this.mOkHttpManager = new OkHttpManager.Builder().setRetryCount(1).setConnectTimeout(3000, TimeUnit.MILLISECONDS).setReadTimeout(6000, TimeUnit.MILLISECONDS).build();
        }
    }

    public static RequestManager instance() {
        if (s_instance == null) {
            s_instance = new RequestManager();
        }
        return s_instance;
    }

    public <T> void doPost(String str, ResponseCallBack<T> responseCallBack) {
        AutelLog.debug_i(TAG, "send msg-->> " + str);
        this.mOkHttpManager.post(IpConstantUtils.getCameraHttpUrl(), this.headers, HttpMediaType.MEDIA_TYPE_JSON, str, responseCallBack);
    }

    public <P, T> void request(P p, final Class<T> cls, final CallbackWithOneParam<T> callbackWithOneParam) {
        String json = this.gsonParser.toJson((Object) p, (Type) p.getClass());
        AutelLog.debug_i(TAG, "send msg-->> " + json);
        this.mOkHttpManager.post(IpConstantUtils.getCameraHttpUrl(), this.headers, HttpMediaType.MEDIA_TYPE_JSON, json, new CameraMsgResponseCallback<T>() {
            public void onSuccess(T t) {
                CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                if (callbackWithOneParam != null) {
                    callbackWithOneParam.onSuccess(t);
                }
            }

            public void onFailure(Throwable th) {
                CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                if (callbackWithOneParam != null) {
                    callbackWithOneParam.onFailure(AutelErrorUtil.createAlbumHttpFetchError(th.getMessage()));
                }
            }

            /* access modifiers changed from: protected */
            public T convertFromParser(BaseCameraMsgParser baseCameraMsgParser) {
                if (baseCameraMsgParser.getIntParam(DownloadTask.STATUS) == 0) {
                    return RequestManager.this.messageParser.getObject(baseCameraMsgParser.getParam("result"), cls);
                }
                AutelLog.debug_i(RequestManager.TAG, "onSuccess convertFromParser-->> status = -1 ");
                throw new Exception("receiver camera status -1");
            }
        });
    }

    public <P> void requestSetParams(P p, final CallbackWithOneParam<Boolean> callbackWithOneParam) {
        String json = this.gsonParser.toJson((Object) p, (Type) p.getClass());
        AutelLog.debug_i(TAG, "send msg-->> " + json);
        this.mOkHttpManager.post(IpConstantUtils.getCameraHttpUrl(), this.headers, HttpMediaType.MEDIA_TYPE_JSON, json, new CameraMsgResponseCallback<Boolean>() {
            public void onSuccess(Boolean bool) {
                CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                if (callbackWithOneParam != null) {
                    callbackWithOneParam.onSuccess(bool);
                }
            }

            public void onFailure(Throwable th) {
                CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                if (callbackWithOneParam != null) {
                    callbackWithOneParam.onFailure(AutelError.COMMON_TIMEOUT);
                }
            }

            /* access modifiers changed from: protected */
            public Boolean convertFromParser(BaseCameraMsgParser baseCameraMsgParser) {
                return Boolean.valueOf(baseCameraMsgParser.getIntParam(DownloadTask.STATUS) == 0);
            }
        });
    }
}

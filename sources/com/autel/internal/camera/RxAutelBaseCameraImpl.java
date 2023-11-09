package com.autel.internal.camera;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.CallbackWithTwoParams;
import com.autel.common.camera.CameraProduct;
import com.autel.common.camera.base.BaseStateInfo;
import com.autel.common.camera.base.CameraPattern;
import com.autel.common.camera.base.MediaMode;
import com.autel.common.camera.base.MediaStatus;
import com.autel.common.camera.base.SDCardState;
import com.autel.common.camera.base.WorkState;
import com.autel.common.error.AutelError;
import com.autel.internal.sdk.camera.base.AutelSwitchState;
import com.autel.internal.sdk.p002rx.RxLock;
import com.autel.sdk.camera.AutelBaseCamera;
import com.autel.sdk.camera.p005rx.RxAutelBaseCamera;
import io.reactivex.Observable;

public class RxAutelBaseCameraImpl implements RxAutelBaseCamera {
    /* access modifiers changed from: private */
    public AutelBaseCamera mAutelBaseCamera;

    public RxAutelBaseCameraImpl(AutelBaseCamera autelBaseCamera) {
        this.mAutelBaseCamera = autelBaseCamera;
    }

    public void setSDCardStateListener(CallbackWithOneParam<SDCardState> callbackWithOneParam) {
        this.mAutelBaseCamera.setSDCardStateListener(callbackWithOneParam);
    }

    public void setMediaModeListener(CallbackWithOneParam<MediaMode> callbackWithOneParam) {
        this.mAutelBaseCamera.setMediaModeListener(callbackWithOneParam);
    }

    public void setMediaStateListener(CallbackWithTwoParams<MediaStatus, String> callbackWithTwoParams) {
        this.mAutelBaseCamera.setMediaStateListener(callbackWithTwoParams);
    }

    public Observable<Boolean> formatSDCard() {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelBaseCameraImpl.this.mAutelBaseCamera.formatSDCard(new CallbackWithNoParam() {
                    public void onSuccess() {
                        C28421.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C28421.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> resetDefaults() {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelBaseCameraImpl.this.mAutelBaseCamera.resetDefaults(new CallbackWithNoParam() {
                    public void onSuccess() {
                        C28622.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C28622.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<WorkState> getWorkStatus() {
        return new RxLock<WorkState>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelBaseCameraImpl.this.mAutelBaseCamera.getWorkState(new CallbackWithOneParam<WorkState>() {
                    public void onSuccess(WorkState workState) {
                        C28643.this.setData(workState);
                    }

                    public void onFailure(AutelError autelError) {
                        C28643.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<SDCardState> getSDCardStatus() {
        return new RxLock<SDCardState>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelBaseCameraImpl.this.mAutelBaseCamera.getSDCardState(new CallbackWithOneParam<SDCardState>() {
                    public void onSuccess(SDCardState sDCardState) {
                        C28664.this.setData(sDCardState);
                    }

                    public void onFailure(AutelError autelError) {
                        C28664.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Long> getSDCardFreeSpace() {
        return new RxLock<Long>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelBaseCameraImpl.this.mAutelBaseCamera.getSDCardFreeSpace(new CallbackWithOneParam<Long>() {
                    public void onSuccess(Long l) {
                        C28685.this.setData(l);
                    }

                    public void onFailure(AutelError autelError) {
                        C28685.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<CameraProduct> getProduct() {
        return new RxLock<CameraProduct>() {
            /* access modifiers changed from: protected */
            public void run() {
                CameraProduct product = RxAutelBaseCameraImpl.this.mAutelBaseCamera.getProduct();
                if (product == null) {
                    setException(AutelError.COMMAND_FAILED);
                } else {
                    setData(product);
                }
            }
        }.fire();
    }

    public Observable<String> getVersion() {
        return new RxLock<String>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelBaseCameraImpl.this.mAutelBaseCamera.getVersion(new CallbackWithOneParam<String>() {
                    public void onSuccess(String str) {
                        C28717.this.setData(str);
                    }

                    public void onFailure(AutelError autelError) {
                        C28717.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setMediaMode(final MediaMode mediaMode) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelBaseCameraImpl.this.mAutelBaseCamera.setMediaMode(mediaMode, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C28738.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C28738.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<MediaMode> getMediaMode() {
        return new RxLock<MediaMode>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelBaseCameraImpl.this.mAutelBaseCamera.getMediaMode(new CallbackWithOneParam<MediaMode>() {
                    public void onSuccess(MediaMode mediaMode) {
                        C28759.this.setData(mediaMode);
                    }

                    public void onFailure(AutelError autelError) {
                        C28759.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> startTakePhoto() {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelBaseCameraImpl.this.mAutelBaseCamera.startTakePhoto(new CallbackWithNoParam() {
                    public void onSuccess() {
                        C284410.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C284410.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> startRecordVideo() {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelBaseCameraImpl.this.mAutelBaseCamera.startRecordVideo(new CallbackWithNoParam() {
                    public void onSuccess() {
                        C284611.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C284611.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> stopRecordVideo() {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelBaseCameraImpl.this.mAutelBaseCamera.stopRecordVideo(new CallbackWithNoParam() {
                    public void onSuccess() {
                        C284812.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C284812.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> stopTakePhoto() {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelBaseCameraImpl.this.mAutelBaseCamera.stopTakePhoto(new CallbackWithNoParam() {
                    public void onSuccess() {
                        C285013.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C285013.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<BaseStateInfo> getStateInfo() {
        return new RxLock<BaseStateInfo>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelBaseCameraImpl.this.mAutelBaseCamera.getStateInfo(new CallbackWithOneParam<BaseStateInfo>() {
                    public void onSuccess(BaseStateInfo baseStateInfo) {
                        C285214.this.setData(baseStateInfo);
                    }

                    public void onFailure(AutelError autelError) {
                        C285214.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setCameraPattern(final CameraPattern cameraPattern) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelBaseCameraImpl.this.mAutelBaseCamera.setCameraPattern(cameraPattern, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C285415.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C285415.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> lockGimbalWhenTakePhoto(final AutelSwitchState autelSwitchState) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelBaseCameraImpl.this.mAutelBaseCamera.lockGimbalWhenTakePhoto(autelSwitchState, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C285616.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C285616.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setGpsCoordinateType(final int i) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelBaseCameraImpl.this.mAutelBaseCamera.setGpsCoordinateType(i, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C285817.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C285817.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Integer> getGpsCoordinateType() {
        return new RxLock<Integer>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelBaseCameraImpl.this.mAutelBaseCamera.getGpsCoordinateType(new CallbackWithOneParam<Integer>() {
                    public void onSuccess(Integer num) {
                        C286018.this.setData(num);
                    }

                    public void onFailure(AutelError autelError) {
                        C286018.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }
}

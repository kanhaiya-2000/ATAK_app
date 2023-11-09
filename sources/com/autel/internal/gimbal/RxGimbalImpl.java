package com.autel.internal.gimbal;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.error.AutelError;
import com.autel.common.gimbal.GimbalVersionInfo;
import com.autel.common.gimbal.GimbalWorkMode;
import com.autel.internal.sdk.p002rx.RxLock;
import com.autel.sdk.gimbal.C4931AutelGimbal;
import com.autel.sdk.gimbal.p008rx.RxAutelGimbal;
import io.reactivex.Observable;

public abstract class RxGimbalImpl implements RxAutelGimbal {
    /* access modifiers changed from: private */
    public C4931AutelGimbal mAutelGimbal;

    public RxGimbalImpl(C4931AutelGimbal autelGimbal) {
        this.mAutelGimbal = autelGimbal;
    }

    public Observable<Boolean> setGimbalLimitUpward(final boolean z) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxGimbalImpl.this.mAutelGimbal.setGimbalLimitUpward(z, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C45871.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C45871.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> getGimbalLimitUpward() {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxGimbalImpl.this.mAutelGimbal.getGimbalLimitUpward(new CallbackWithOneParam<Boolean>() {
                    public void onSuccess(Boolean bool) {
                        C45892.this.setData(bool);
                    }

                    public void onFailure(AutelError autelError) {
                        C45892.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setGimbalWorkMode(final GimbalWorkMode gimbalWorkMode) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxGimbalImpl.this.mAutelGimbal.setGimbalWorkMode(gimbalWorkMode, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C45913.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C45913.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<GimbalWorkMode> getGimbalWorkMode() {
        return new RxLock<GimbalWorkMode>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxGimbalImpl.this.mAutelGimbal.getGimbalWorkMode(new CallbackWithOneParam<GimbalWorkMode>() {
                    public void onSuccess(GimbalWorkMode gimbalWorkMode) {
                        C45934.this.setData(gimbalWorkMode);
                    }

                    public void onFailure(AutelError autelError) {
                        C45934.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<GimbalVersionInfo> getVersionInfo() {
        return new RxLock<GimbalVersionInfo>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxGimbalImpl.this.mAutelGimbal.getVersionInfo(new CallbackWithOneParam<GimbalVersionInfo>() {
                    public void onSuccess(GimbalVersionInfo gimbalVersionInfo) {
                        C45955.this.setData(gimbalVersionInfo);
                    }

                    public void onFailure(AutelError autelError) {
                        C45955.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }
}

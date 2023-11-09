package com.autel.internal.dsp.xstar;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.dsp.WiFiInfo;
import com.autel.common.error.AutelError;
import com.autel.internal.dsp.RxAutelDspImpl;
import com.autel.internal.sdk.p002rx.RxLock;
import com.autel.sdk.dsp.XStarDsp;
import com.autel.sdk.dsp.p006rx.RxXStarDsp;
import io.reactivex.Observable;

public class RxXStarDspImpl extends RxAutelDspImpl implements RxXStarDsp {
    /* access modifiers changed from: private */
    public XStarDsp mXStarDsp;

    public RxXStarDspImpl(XStarDsp xStarDsp) {
        super(xStarDsp);
    }

    public Observable<Boolean> updateNewSSIDInfo(final String str, final String str2) {
        return new RxLock<Boolean>() {
            public void run() {
                RxXStarDspImpl.this.mXStarDsp.updateNewSSIDInfo(str, str2, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C42551.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C42551.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<WiFiInfo> getCurrentSSIDInfo() {
        return new RxLock<WiFiInfo>() {
            public void run() {
                WiFiInfo currentSSIDInfo = RxXStarDspImpl.this.mXStarDsp.getCurrentSSIDInfo();
                if (currentSSIDInfo == null) {
                    setException(AutelError.COMMAND_FAILED);
                } else {
                    setData(currentSSIDInfo);
                }
            }
        }.fire();
    }

    public void resetWifi() {
        this.mXStarDsp.resetWifi();
    }

    public Observable<Boolean> isUSBEnable() {
        return new RxLock<Boolean>() {
            public void run() {
                setData(Boolean.valueOf(RxXStarDspImpl.this.mXStarDsp.isUSBEnable()));
            }
        }.fire();
    }
}

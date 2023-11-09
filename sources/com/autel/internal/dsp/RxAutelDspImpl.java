package com.autel.internal.dsp;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.dsp.DspVersionInfo;
import com.autel.common.dsp.RFData;
import com.autel.common.error.AutelError;
import com.autel.internal.sdk.p002rx.RxLock;
import com.autel.sdk.dsp.C4929AutelDsp;
import com.autel.sdk.dsp.p006rx.RxAutelDsp;
import io.reactivex.Observable;
import java.util.List;

public class RxAutelDspImpl implements RxAutelDsp {
    /* access modifiers changed from: private */
    public C4929AutelDsp mAutelDsp;

    public RxAutelDspImpl(C4929AutelDsp autelDsp) {
        this.mAutelDsp = autelDsp;
    }

    public Observable<List<RFData>> getRFDataList(final int i) {
        return new RxLock<List<RFData>>() {
            public void run() {
                RxAutelDspImpl.this.mAutelDsp.getRFDataList(i, new CallbackWithOneParam<List<RFData>>() {
                    public void onSuccess(List<RFData> list) {
                        C42321.this.setData(list);
                    }

                    public void onFailure(AutelError autelError) {
                        C42321.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<RFData> getCurrentRFData(final int i) {
        return new RxLock<RFData>() {
            public void run() {
                RxAutelDspImpl.this.mAutelDsp.getCurrentRFData(i, new CallbackWithOneParam<RFData>() {
                    public void onSuccess(RFData rFData) {
                        C42342.this.setData(rFData);
                    }

                    public void onFailure(AutelError autelError) {
                        C42342.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setCurrentRFData(final int i, final int i2) {
        return new RxLock<Boolean>() {
            public void run() {
                RxAutelDspImpl.this.mAutelDsp.setCurrentRFData(i, i2, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C42363.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C42363.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<DspVersionInfo> getVersionInfo() {
        return new RxLock<DspVersionInfo>() {
            public void run() {
                RxAutelDspImpl.this.mAutelDsp.getVersionInfo(new CallbackWithOneParam<DspVersionInfo>() {
                    public void onSuccess(DspVersionInfo dspVersionInfo) {
                        C42384.this.setData(dspVersionInfo);
                    }

                    public void onFailure(AutelError autelError) {
                        C42384.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }
}

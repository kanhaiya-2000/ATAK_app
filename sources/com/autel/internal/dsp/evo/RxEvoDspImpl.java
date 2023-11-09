package com.autel.internal.dsp.evo;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.dsp.evo.BandMode;
import com.autel.common.dsp.evo.Bandwidth;
import com.autel.common.dsp.evo.DeviceVersionInfo;
import com.autel.common.dsp.evo.EvoDspInfo;
import com.autel.common.dsp.evo.TransferMode;
import com.autel.common.error.AutelError;
import com.autel.internal.dsp.RxAutelDspImpl;
import com.autel.internal.sdk.p002rx.RxLock;
import com.autel.sdk.dsp.EvoDsp;
import com.autel.sdk.dsp.p006rx.RxEvoDsp;
import io.reactivex.Observable;
import java.util.List;

public class RxEvoDspImpl extends RxAutelDspImpl implements RxEvoDsp {
    /* access modifiers changed from: private */
    public EvoDsp mAutelDsp;

    public RxEvoDspImpl(EvoDsp evoDsp) {
        super(evoDsp);
        this.mAutelDsp = evoDsp;
    }

    public void setDspInfoListener(CallbackWithOneParam<EvoDspInfo> callbackWithOneParam) {
        this.mAutelDsp.setDspInfoListener(callbackWithOneParam);
    }

    public void setBandwidthInfo(BandMode bandMode, Bandwidth bandwidth) {
        this.mAutelDsp.setBandwidthInfo(bandMode, bandwidth);
    }

    public Observable<Boolean> setTransferMode(final TransferMode transferMode) {
        return new RxLock<Boolean>() {
            public void run() {
                RxEvoDspImpl.this.mAutelDsp.setTransferMode(transferMode, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C42471.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C42471.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<TransferMode> getTransferMode() {
        return new RxLock<TransferMode>() {
            public void run() {
                RxEvoDspImpl.this.mAutelDsp.getTransferMode(new CallbackWithOneParam<TransferMode>() {
                    public void onSuccess(TransferMode transferMode) {
                        C42492.this.setData(transferMode);
                    }

                    public void onFailure(AutelError autelError) {
                        C42492.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<List<DeviceVersionInfo>> getDeviceVersionInfo() {
        return new RxLock<List<DeviceVersionInfo>>() {
            public void run() {
                RxEvoDspImpl.this.mAutelDsp.getDeviceVersionInfo(new CallbackWithOneParam<List<DeviceVersionInfo>>() {
                    public void onSuccess(List<DeviceVersionInfo> list) {
                        C42513.this.setData(list);
                    }

                    public void onFailure(AutelError autelError) {
                        C42513.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setVideoLinkState(final boolean z) {
        return new RxLock<Boolean>() {
            public void run() {
                RxEvoDspImpl.this.mAutelDsp.setVideoLinkState(z, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C42534.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C42534.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }
}

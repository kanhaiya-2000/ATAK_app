package com.autel.sdk.dsp.p006rx;

import com.autel.common.CallbackWithOneParam;
import com.autel.common.dsp.evo.BandMode;
import com.autel.common.dsp.evo.Bandwidth;
import com.autel.common.dsp.evo.DeviceVersionInfo;
import com.autel.common.dsp.evo.EvoDspInfo;
import com.autel.common.dsp.evo.TransferMode;
import io.reactivex.Observable;
import java.util.List;

/* renamed from: com.autel.sdk.dsp.rx.RxEvoDsp */
public interface RxEvoDsp extends RxAutelDsp {
    Observable<List<DeviceVersionInfo>> getDeviceVersionInfo();

    Observable<TransferMode> getTransferMode();

    void setBandwidthInfo(BandMode bandMode, Bandwidth bandwidth);

    void setDspInfoListener(CallbackWithOneParam<EvoDspInfo> callbackWithOneParam);

    Observable<Boolean> setTransferMode(TransferMode transferMode);

    Observable<Boolean> setVideoLinkState(boolean z);
}

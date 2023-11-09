package com.autel.sdk.dsp;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.dsp.evo.BandMode;
import com.autel.common.dsp.evo.Bandwidth;
import com.autel.common.dsp.evo.DeviceVersionInfo;
import com.autel.common.dsp.evo.EvoDspInfo;
import com.autel.common.dsp.evo.TransferMode;
import com.autel.sdk.dsp.p006rx.RxEvoDsp;
import java.util.List;

public interface EvoDsp extends C4929AutelDsp {
    void getDeviceVersionInfo(CallbackWithOneParam<List<DeviceVersionInfo>> callbackWithOneParam);

    void getTransferMode(CallbackWithOneParam<TransferMode> callbackWithOneParam);

    void setBandwidthInfo(BandMode bandMode, Bandwidth bandwidth);

    void setDspInfoListener(CallbackWithOneParam<EvoDspInfo> callbackWithOneParam);

    void setTransferMode(TransferMode transferMode, CallbackWithNoParam callbackWithNoParam);

    void setVideoLinkState(boolean z, CallbackWithNoParam callbackWithNoParam);

    RxEvoDsp toRx();
}

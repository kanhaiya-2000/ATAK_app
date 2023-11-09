package com.autel.internal.dsp.evo;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.FailedCallback;
import com.autel.common.dsp.evo.BandMode;
import com.autel.common.dsp.evo.Bandwidth;
import com.autel.common.dsp.evo.DeviceVersionInfo;
import com.autel.common.dsp.evo.EvoDspInfo;
import com.autel.common.dsp.evo.TransferMode;
import com.autel.internal.AutelListenerManager;
import com.autel.internal.AutelModuleService;
import com.autel.internal.AutelServiceVersion;
import com.autel.internal.dsp.DspFactory;
import com.autel.internal.dsp.DspInitializeProxy;
import com.autel.sdk.dsp.p006rx.RxEvoDsp;
import java.util.List;

public class EvoDspInitializeProxy extends DspInitializeProxy implements EvoDspService4Initialize {
    private EvoDspService mG2DspService;
    private RxEvoDsp mRxG2Dsp;

    /* access modifiers changed from: protected */
    public AutelModuleService buildConnection(AutelServiceVersion autelServiceVersion) {
        EvoDspService createG2DspService = DspFactory.createG2DspService();
        this.mG2DspService = createG2DspService;
        this.dspService = createG2DspService;
        return this.mG2DspService;
    }

    /* access modifiers changed from: protected */
    public void initListener() {
        Object obj = this.listenerManager.get(AutelListenerManager.DspInfoListener);
        if (obj instanceof CallbackWithOneParam) {
            this.mG2DspService.setDspInfoListener((CallbackWithOneParam) obj);
        }
    }

    public void setDspInfoListener(CallbackWithOneParam<EvoDspInfo> callbackWithOneParam) {
        this.listenerManager.put(AutelListenerManager.DspInfoListener, callbackWithOneParam);
        EvoDspService evoDspService = this.mG2DspService;
        if (evoDspService != null) {
            evoDspService.setDspInfoListener(callbackWithOneParam);
        }
    }

    public void setBandwidthInfo(BandMode bandMode, Bandwidth bandwidth) {
        if (checkStateEnable((FailedCallback) null)) {
            this.mG2DspService.setBandwidthInfo(bandMode, bandwidth);
        }
    }

    public void setTransferMode(TransferMode transferMode, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.mG2DspService.setTransferMode(transferMode, callbackWithNoParam);
        }
    }

    public void getTransferMode(CallbackWithOneParam<TransferMode> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.mG2DspService.getTransferMode(callbackWithOneParam);
        }
    }

    public void setVideoLinkState(boolean z, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.mG2DspService.setVideoLinkState(z, callbackWithNoParam);
        }
    }

    public void getDeviceVersionInfo(CallbackWithOneParam<List<DeviceVersionInfo>> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam) && callbackWithOneParam != null) {
            this.mG2DspService.getDeviceVersionInfo(callbackWithOneParam);
        }
    }

    public RxEvoDsp toRx() {
        if (this.mRxG2Dsp == null) {
            this.mRxG2Dsp = new RxEvoDspImpl(this);
        }
        return this.mRxG2Dsp;
    }
}

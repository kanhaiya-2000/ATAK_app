package com.autel.sdk.camera;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.camera.XT706.ImageMode;
import com.autel.common.camera.XT706.IrImageModeParam;
import com.autel.common.camera.media.IrEnhanceParam;
import com.autel.common.camera.media.IrGainMode;
import com.autel.common.camera.media.IrIsoThermMode;
import com.autel.common.camera.media.IrThresholdParam;
import com.autel.sdk.camera.p005rx.RxAutelXT709;

public interface AutelXT709 extends AutelXT706 {
    void getIrDeNoise(CallbackWithOneParam<Boolean> callbackWithOneParam);

    void getIrEnhance(CallbackWithOneParam<IrEnhanceParam> callbackWithOneParam);

    void getIrGain(CallbackWithOneParam<IrGainMode> callbackWithOneParam);

    void getIrImageMode(CallbackWithOneParam<IrImageModeParam> callbackWithOneParam);

    void getIrIsoTherm(CallbackWithOneParam<IrThresholdParam> callbackWithOneParam);

    void setIrDeNoise(boolean z, CallbackWithNoParam callbackWithNoParam);

    void setIrEnhance(boolean z, int i, CallbackWithNoParam callbackWithNoParam);

    void setIrGain(IrGainMode irGainMode, CallbackWithNoParam callbackWithNoParam);

    void setIrImageMode(ImageMode imageMode, int i, int i2, CallbackWithNoParam callbackWithNoParam);

    void setIrIsoTherm(IrIsoThermMode irIsoThermMode, int i, int i2, CallbackWithNoParam callbackWithNoParam);

    RxAutelXT709 toRx();
}

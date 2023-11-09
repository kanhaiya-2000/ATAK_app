package com.autel.sdk.camera.p005rx;

import com.autel.common.camera.XT706.ImageMode;
import com.autel.common.camera.XT706.IrImageModeParam;
import com.autel.common.camera.media.IrEnhanceParam;
import com.autel.common.camera.media.IrGainMode;
import com.autel.common.camera.media.IrIsoThermMode;
import com.autel.common.camera.media.IrThresholdParam;
import io.reactivex.Observable;

/* renamed from: com.autel.sdk.camera.rx.RxAutelXT709 */
public interface RxAutelXT709 extends RxAutelXT706 {
    Observable<Boolean> getIrDeNoise();

    Observable<IrEnhanceParam> getIrEnhance();

    Observable<IrGainMode> getIrGain();

    Observable<IrImageModeParam> getIrImageMode();

    Observable<IrThresholdParam> getIrIsoTherm();

    Observable<Boolean> setIrDeNoise(boolean z);

    Observable<Boolean> setIrEnhance(boolean z, int i);

    Observable<Boolean> setIrGain(IrGainMode irGainMode);

    Observable<Boolean> setIrImageMode(ImageMode imageMode, int i, int i2);

    Observable<Boolean> setIrIsoTherm(IrIsoThermMode irIsoThermMode, int i, int i2);
}

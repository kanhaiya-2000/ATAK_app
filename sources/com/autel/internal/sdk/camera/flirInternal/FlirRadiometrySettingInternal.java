package com.autel.internal.sdk.camera.flirInternal;

public class FlirRadiometrySettingInternal extends FLIRRadiometrySetting {
    boolean spotMeterEnableValidate = false;

    public boolean isSpotMeterEnableValidate() {
        return this.spotMeterEnableValidate;
    }

    public void setSpotMeter(boolean z) {
        super.setSpotMeter(z);
        this.spotMeterEnableValidate = true;
    }

    public void clear() {
        super.clear();
        this.spotMeterEnableValidate = false;
    }
}

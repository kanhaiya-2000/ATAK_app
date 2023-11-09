package com.autel.camera.protocol.protocol20.flir;

import com.autel.bean.camera.FlirCameraAllSettings;
import com.autel.camera.protocol.protocol20.interfaces.flir.CameraFlirDuoRService;
import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.error.AutelError;
import com.autel.internal.sdk.camera.flir.FLIRSkyCondition;
import com.autel.internal.sdk.camera.flir.TemperatureUnit;
import com.autel.internal.sdk.camera.flirInternal.FLIRRadiometrySetting;

public class FlirDuoR extends FlirDuo implements CameraFlirDuoRService {
    public void getRadiometrySetting(final CallbackWithOneParam<FLIRRadiometrySetting> callbackWithOneParam) {
        this.request.getRadiometrySettings(new CallbackWithOneParam<FlirCameraAllSettings.RadiometrySettings>() {
            public void onSuccess(FlirCameraAllSettings.RadiometrySettings radiometrySettings) {
                if (callbackWithOneParam != null) {
                    FLIRRadiometrySetting fLIRRadiometrySetting = new FLIRRadiometrySetting();
                    int airTemp = radiometrySettings.getAirTemp();
                    if (airTemp >= -50 && airTemp <= 127) {
                        fLIRRadiometrySetting.setAirTemp(airTemp);
                    }
                    int emissivity = radiometrySettings.getEmissivity();
                    if (emissivity >= 50 && emissivity <= 100) {
                        fLIRRadiometrySetting.setEmissivity(emissivity);
                    }
                    int humidity = radiometrySettings.getHumidity();
                    if (humidity >= 0 && humidity <= 100) {
                        fLIRRadiometrySetting.setHumidity(humidity);
                    }
                    int subjectDistance = radiometrySettings.getSubjectDistance();
                    if (subjectDistance >= 0 && subjectDistance <= 2000) {
                        fLIRRadiometrySetting.setSubjectDistance(subjectDistance);
                    }
                    fLIRRadiometrySetting.setTempUnit(TemperatureUnit.find(radiometrySettings.getTempUnit()));
                    fLIRRadiometrySetting.setSkyCond(FLIRSkyCondition.find(radiometrySettings.getSkyCond()));
                    boolean z = true;
                    if (radiometrySettings.getSpotMeter() != 1) {
                        z = false;
                    }
                    fLIRRadiometrySetting.setSpotMeter(z);
                    callbackWithOneParam.onSuccess(fLIRRadiometrySetting);
                }
            }

            public void onFailure(AutelError autelError) {
                CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                if (callbackWithOneParam != null) {
                    callbackWithOneParam.onFailure(autelError);
                }
            }
        });
    }

    public void setRadiometrySetting(FLIRRadiometrySetting fLIRRadiometrySetting, CallbackWithNoParam callbackWithNoParam) {
        this.request.setRadiometrySettings(fLIRRadiometrySetting, callbackWithNoParam);
    }
}

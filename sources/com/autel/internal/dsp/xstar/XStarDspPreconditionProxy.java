package com.autel.internal.dsp.xstar;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.dsp.WiFiInfo;
import com.autel.common.error.AutelError;
import com.autel.internal.dsp.DspPreconditionProxy;
import com.autel.sdk.dsp.p006rx.RxXStarDsp;

public class XStarDspPreconditionProxy extends DspPreconditionProxy implements XStarDspService {
    private XStarDspService mXStarDspService;

    private boolean isSSIDNameLegitimate(char c) {
        return (c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z') || ((c >= 'a' && c <= 'z') || c == '_' || c == '-');
    }

    private boolean isSSIDPwdLegitimate(char c) {
        return c >= '!' && c <= '~';
    }

    public RxXStarDsp toRx() {
        return null;
    }

    public XStarDspPreconditionProxy(XStarDspService xStarDspService) {
        super(xStarDspService);
        this.mXStarDspService = xStarDspService;
    }

    public void updateNewSSIDInfo(String str, String str2, CallbackWithNoParam callbackWithNoParam) {
        if (str == null || "".equals(str) || str2 == null || "".equals(str2)) {
            if (callbackWithNoParam != null) {
                callbackWithNoParam.onFailure(AutelError.ALBUM_PARAMS_ARE_NULL);
            }
        } else if (str.length() < 8 || str.length() > 16) {
            if (callbackWithNoParam != null) {
                callbackWithNoParam.onFailure(AutelError.DSP_UPDATE_SSID_LENGTH_NOT_MATCH);
            }
        } else if (str2.length() < 8 || str2.length() > 16) {
            if (callbackWithNoParam != null) {
                callbackWithNoParam.onFailure(AutelError.DSP_UPDATE_WIFI_PASSWORD_LENGTH_NOT_MATCH);
            }
        } else if (!isSSIDNameLegitimate(str)) {
            if (callbackWithNoParam != null) {
                callbackWithNoParam.onFailure(AutelError.DSP_UPDATE_SSID_IS_ILLEGAL);
            }
        } else if (isSSIDPwdLegitimate(str)) {
            this.mXStarDspService.updateNewSSIDInfo(str, str2, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.DSP_UPDATE_WIFI_PWD_IS_ILLEGAL);
        }
    }

    public WiFiInfo getCurrentSSIDInfo() {
        return this.mXStarDspService.getCurrentSSIDInfo();
    }

    public void resetWifi() {
        this.mXStarDspService.resetWifi();
    }

    public boolean isUSBEnable() {
        return this.mXStarDspService.isUSBEnable();
    }

    private boolean isSSIDNameLegitimate(String str) {
        for (char isSSIDNameLegitimate : str.toCharArray()) {
            if (!isSSIDNameLegitimate(isSSIDNameLegitimate)) {
                return false;
            }
        }
        return true;
    }

    private boolean isSSIDPwdLegitimate(String str) {
        if (str == null || "".equals(str) || str.length() < 8 || str.length() > 16) {
            return false;
        }
        for (char isSSIDPwdLegitimate : str.toCharArray()) {
            if (!isSSIDPwdLegitimate(isSSIDPwdLegitimate)) {
                return false;
            }
        }
        return true;
    }
}

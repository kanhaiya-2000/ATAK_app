package com.autel.internal.dsp;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.dsp.DspVersionInfo;
import com.autel.common.dsp.RFData;
import com.autel.internal.autel.IAutelStateManager;
import com.autel.sdk.dsp.p006rx.RxAutelDsp;
import java.util.List;

public class DspPreconditionProxy implements DspService {
    private DspService dsp;

    private boolean isSSIDNameLegitimate(char c) {
        return (c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z') || ((c >= 'a' && c <= 'z') || c == '_' || c == '-');
    }

    private boolean isSSIDPwdLegitimate(char c) {
        return c >= '!' && c <= '~';
    }

    public void connect() {
    }

    public void disconnect() {
    }

    public RxAutelDsp toRx() {
        return null;
    }

    public DspPreconditionProxy(DspService dspService) {
        this.dsp = dspService;
    }

    public void getRFDataList(int i, CallbackWithOneParam<List<RFData>> callbackWithOneParam) {
        this.dsp.getRFDataList(i, callbackWithOneParam);
    }

    public void getCurrentRFData(int i, CallbackWithOneParam<RFData> callbackWithOneParam) {
        this.dsp.getCurrentRFData(i, callbackWithOneParam);
    }

    public void setCurrentRFData(int i, int i2, CallbackWithNoParam callbackWithNoParam) {
        this.dsp.setCurrentRFData(i, i2, callbackWithNoParam);
    }

    public void getVersionInfo(CallbackWithOneParam<DspVersionInfo> callbackWithOneParam) {
        this.dsp.getVersionInfo(callbackWithOneParam);
    }

    public void init(IAutelStateManager iAutelStateManager) {
        this.dsp.init(iAutelStateManager);
    }

    public void destroy() {
        this.dsp.destroy();
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

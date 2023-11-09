package com.autel.sdk.dsp;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.dsp.DspVersionInfo;
import com.autel.common.dsp.RFData;
import com.autel.sdk.dsp.p006rx.RxAutelDsp;
import java.util.List;

/* renamed from: com.autel.sdk.dsp.AutelDsp */
public interface C4929AutelDsp {
    void getCurrentRFData(int i, CallbackWithOneParam<RFData> callbackWithOneParam);

    void getRFDataList(int i, CallbackWithOneParam<List<RFData>> callbackWithOneParam);

    void getVersionInfo(CallbackWithOneParam<DspVersionInfo> callbackWithOneParam);

    void setCurrentRFData(int i, int i2, CallbackWithNoParam callbackWithNoParam);

    RxAutelDsp toRx();
}

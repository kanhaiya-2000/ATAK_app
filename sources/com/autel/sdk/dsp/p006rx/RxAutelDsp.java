package com.autel.sdk.dsp.p006rx;

import com.autel.common.dsp.DspVersionInfo;
import com.autel.common.dsp.RFData;
import io.reactivex.Observable;
import java.util.List;

/* renamed from: com.autel.sdk.dsp.rx.RxAutelDsp */
public interface RxAutelDsp {
    Observable<RFData> getCurrentRFData(int i);

    Observable<List<RFData>> getRFDataList(int i);

    Observable<DspVersionInfo> getVersionInfo();

    Observable<Boolean> setCurrentRFData(int i, int i2);
}

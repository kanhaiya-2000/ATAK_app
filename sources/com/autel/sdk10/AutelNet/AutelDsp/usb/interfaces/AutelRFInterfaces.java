package com.autel.sdk10.AutelNet.AutelDsp.usb.interfaces;

import com.autel.common.dsp.RFData;
import java.util.ArrayList;

public class AutelRFInterfaces {

    public interface OnGetCurRFTaskListener {
        void onCurRFData(RFData rFData);
    }

    public interface OnGetRFTaskListener {
        void onRFData(ArrayList<RFData> arrayList);
    }

    public interface OnSetRFTaskListener {
        void onResult(boolean z);
    }
}

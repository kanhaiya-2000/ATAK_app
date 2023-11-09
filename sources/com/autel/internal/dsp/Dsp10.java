package com.autel.internal.dsp;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.dsp.DspVersionInfo;
import com.autel.common.dsp.RFData;
import com.autel.common.error.AutelError;
import com.autel.internal.sdk.firmware.AircraftComponentVersionInfo;
import com.autel.sdk.dsp.p006rx.RxAutelDsp;
import com.autel.sdk10.AutelNet.AutelDsp.usb.AutelDspRFManager;
import com.autel.sdk10.AutelNet.AutelDsp.usb.interfaces.AutelRFInterfaces;
import com.autel.sdk10.AutelNet.AutelDsp.wifi.AutelDspWifiManager;
import com.autel.sdk10.AutelNet.AutelFirmWareInfo.controller.AutelFirmVersionRequestManager;
import com.autel.sdk10.AutelNet.AutelFirmWareInfo.interfaces.IAutelFirmVersionCallback;
import java.util.ArrayList;
import java.util.List;

public abstract class Dsp10 implements DspService {
    public void connect() {
    }

    public void disconnect() {
    }

    public RxAutelDsp toRx() {
        return null;
    }

    public void destroy() {
        AutelDspWifiManager.closeSsidConnection();
    }

    public void getRFDataList(int i, final CallbackWithOneParam<List<RFData>> callbackWithOneParam) {
        AutelDspRFManager.getInstance().startScanRFTask(i, new AutelRFInterfaces.OnGetRFTaskListener() {
            public void onRFData(ArrayList<RFData> arrayList) {
                callbackWithOneParam.onSuccess(arrayList);
            }
        });
    }

    public void getCurrentRFData(int i, final CallbackWithOneParam<RFData> callbackWithOneParam) {
        AutelDspRFManager.getInstance().startGetCurRFTask(i, new AutelRFInterfaces.OnGetCurRFTaskListener() {
            public void onCurRFData(RFData rFData) {
                callbackWithOneParam.onSuccess(rFData);
            }
        });
    }

    public void setCurrentRFData(int i, int i2, final CallbackWithNoParam callbackWithNoParam) {
        AutelDspRFManager.getInstance().startSetCurRFTask(i, i2, new AutelRFInterfaces.OnSetRFTaskListener() {
            public void onResult(boolean z) {
                callbackWithNoParam.onSuccess();
            }
        });
    }

    public void getVersionInfo(final CallbackWithOneParam<DspVersionInfo> callbackWithOneParam) {
        AutelFirmVersionRequestManager.getInstance().requestAutelAircraftComponentVersion(new IAutelFirmVersionCallback<AircraftComponentVersionInfo>() {
            public void onReceiveVersion(final AircraftComponentVersionInfo aircraftComponentVersionInfo) {
                callbackWithOneParam.onSuccess(new DspVersionInfo() {
                    public String getDSPVersion() {
                        return aircraftComponentVersionInfo.getDSPVersion();
                    }

                    public String getTransferBoardVersion() {
                        return aircraftComponentVersionInfo.getTransferBoardVersion();
                    }

                    public String toString() {
                        return "DSPVersion : " + getDSPVersion() + ", TransferBoardVersion : " + getTransferBoardVersion();
                    }
                });
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }
}

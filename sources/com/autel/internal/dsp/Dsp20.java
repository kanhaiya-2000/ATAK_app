package com.autel.internal.dsp;

import com.autel.AutelNet2.aircraft.firmware.FirmwareManager;
import com.autel.AutelNet2.aircraft.firmware.bean.FirmwareDeviceInfo;
import com.autel.AutelNet2.dsp.controller.DspRFManager2;
import com.autel.bean.dsp.SignalStrengthReport;
import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.dsp.DspVersionInfo;
import com.autel.common.dsp.RFData;
import com.autel.common.error.AutelError;
import com.autel.internal.autel.IAutelStateManager;
import com.autel.sdk.dsp.p006rx.RxAutelDsp;
import java.util.Arrays;
import java.util.List;

public class Dsp20 implements DspService {
    static final String getCurrentRFDataTag = "getCurrentRFData";
    static final String getRFDataListTag = "getRFDataList";
    private int retryCount4Current;
    /* access modifiers changed from: private */
    public int retryCount4List;

    public void connect() {
    }

    public void disconnect() {
    }

    public RxAutelDsp toRx() {
        return null;
    }

    static /* synthetic */ int access$008(Dsp20 dsp20) {
        int i = dsp20.retryCount4List;
        dsp20.retryCount4List = i + 1;
        return i;
    }

    static /* synthetic */ int access$108(Dsp20 dsp20) {
        int i = dsp20.retryCount4Current;
        dsp20.retryCount4Current = i + 1;
        return i;
    }

    public void getRFDataList(final int i, final CallbackWithOneParam<List<RFData>> callbackWithOneParam) {
        DspRFManager2.getInstance().addSignalStregthListener(getRFDataListTag, new CallbackWithOneParam<SignalStrengthReport>() {
            public void onSuccess(SignalStrengthReport signalStrengthReport) {
                DspRFManager2.getInstance().removeSignalStregthListener(Dsp20.getRFDataListTag);
                if (signalStrengthReport.getRFDataList() == null) {
                    callbackWithOneParam.onFailure(AutelError.COMMAND_FAILED);
                    return;
                }
                callbackWithOneParam.onSuccess(Arrays.asList(signalStrengthReport.getRFDataList()));
                int unused = Dsp20.this.retryCount4List = 0;
            }

            public void onFailure(AutelError autelError) {
                int access$008 = Dsp20.access$008(Dsp20.this);
                int i = i;
                if (access$008 < i) {
                    Dsp20.this.getRFDataList(i, callbackWithOneParam);
                } else {
                    callbackWithOneParam.onFailure(autelError);
                }
            }
        });
    }

    public void getCurrentRFData(final int i, final CallbackWithOneParam<RFData> callbackWithOneParam) {
        DspRFManager2.getInstance().addSignalStregthListener(getCurrentRFDataTag, new CallbackWithOneParam<SignalStrengthReport>() {
            public void onSuccess(SignalStrengthReport signalStrengthReport) {
                DspRFManager2.getInstance().removeSignalStregthListener(Dsp20.getCurrentRFDataTag);
                if (signalStrengthReport.getCurrentRFData() == null) {
                    callbackWithOneParam.onFailure(AutelError.COMMAND_FAILED);
                } else {
                    callbackWithOneParam.onSuccess(signalStrengthReport.getCurrentRFData());
                }
            }

            public void onFailure(AutelError autelError) {
                int access$108 = Dsp20.access$108(Dsp20.this);
                int i = i;
                if (access$108 < i) {
                    Dsp20.this.getCurrentRFData(i, callbackWithOneParam);
                } else {
                    callbackWithOneParam.onFailure(autelError);
                }
            }
        });
    }

    public void setCurrentRFData(int i, int i2, final CallbackWithNoParam callbackWithNoParam) {
        DspRFManager2.getInstance().setCurrentRF(i, new CallbackWithOneParam<Boolean>() {
            public void onSuccess(Boolean bool) {
                CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                if (callbackWithNoParam != null) {
                    callbackWithNoParam.onSuccess();
                }
            }

            public void onFailure(AutelError autelError) {
                CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                if (callbackWithNoParam != null) {
                    callbackWithNoParam.onFailure(autelError);
                }
            }
        });
    }

    public void getVersionInfo(final CallbackWithOneParam<DspVersionInfo> callbackWithOneParam) {
        FirmwareManager.instance().getDeviceFirmwareInfo(new CallbackWithOneParam<List<FirmwareDeviceInfo.VersionBean>>() {
            public void onSuccess(final List<FirmwareDeviceInfo.VersionBean> list) {
                callbackWithOneParam.onSuccess(new DspVersionInfo() {
                    public String getDSPVersion() {
                        for (FirmwareDeviceInfo.VersionBean versionBean : list) {
                            if (FirmwareManager.DEV_DSP.equals(versionBean.getComponentName())) {
                                return versionBean.getSoftware();
                            }
                        }
                        return "";
                    }

                    public String getTransferBoardVersion() {
                        for (FirmwareDeviceInfo.VersionBean versionBean : list) {
                            if (FirmwareManager.DEV_SWITCHER.equals(versionBean.getComponentName())) {
                                return versionBean.getSoftware();
                            }
                        }
                        return "";
                    }
                });
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void init(IAutelStateManager iAutelStateManager) {
        DspRFManager2.getInstance().init();
        FirmwareManager.instance().init();
    }

    public void destroy() {
        DspRFManager2.getInstance().destroy();
        FirmwareManager.instance().destroy();
    }
}

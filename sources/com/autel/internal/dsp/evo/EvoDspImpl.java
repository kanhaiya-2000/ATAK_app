package com.autel.internal.dsp.evo;

import com.autel.AutelNet2.aircraft.firmware.FirmwareManager;
import com.autel.AutelNet2.aircraft.firmware.bean.FirmwareDeviceInfo;
import com.autel.AutelNet2.dsp.controller.DspRFManager2;
import com.autel.AutelNet2.dsp.data.BandwidthInfoImpl;
import com.autel.AutelNet2.dsp.data.G2DspInfoImpl;
import com.autel.bean.dsp.BandModeWidthInfo;
import com.autel.bean.dsp.ReportBertInfo;
import com.autel.bean.dsp.SignalStrengthReport;
import com.autel.bean.dsp.VideoRateInfoImpl;
import com.autel.bean.dsp.VideoTransferModeInfo;
import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.dsp.evo.BandMode;
import com.autel.common.dsp.evo.Bandwidth;
import com.autel.common.dsp.evo.DeviceVersionInfo;
import com.autel.common.dsp.evo.EvoDspInfo;
import com.autel.common.dsp.evo.TransferMode;
import com.autel.common.error.AutelError;
import com.autel.internal.dsp.Dsp20;
import com.autel.sdk.dsp.p006rx.RxEvoDsp;
import java.util.ArrayList;
import java.util.List;

public class EvoDspImpl extends Dsp20 implements EvoDspService {
    /* access modifiers changed from: private */
    public G2DspInfoImpl mG2DspInfoImpl = new G2DspInfoImpl();

    public void disconnect() {
    }

    public RxEvoDsp toRx() {
        return null;
    }

    public void setDspInfoListener(final CallbackWithOneParam<EvoDspInfo> callbackWithOneParam) {
        if (callbackWithOneParam == null) {
            DspRFManager2.getInstance().removeSignalStregthListener("addSignalStregthListener");
            DspRFManager2.getInstance().setReportBertInfoListener((CallbackWithOneParam<ReportBertInfo>) null);
            DspRFManager2.getInstance().setVideoRateInfoListener((CallbackWithOneParam<VideoRateInfoImpl>) null);
            DspRFManager2.getInstance().setBandModeWidthInfoListener((CallbackWithOneParam<BandModeWidthInfo>) null);
            return;
        }
        DspRFManager2.getInstance().addSignalStregthListener("addSignalStregthListener", new CallbackWithOneParam<SignalStrengthReport>() {
            public void onSuccess(SignalStrengthReport signalStrengthReport) {
                EvoDspImpl.this.mG2DspInfoImpl.mSignalStrengthInfo = signalStrengthReport;
                callbackWithOneParam.onSuccess(EvoDspImpl.this.mG2DspInfoImpl);
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
        DspRFManager2.getInstance().setReportBertInfoListener(new CallbackWithOneParam<ReportBertInfo>() {
            public void onSuccess(ReportBertInfo reportBertInfo) {
                ((BandwidthInfoImpl) EvoDspImpl.this.mG2DspInfoImpl.mBandwidthInfo).mReportBertInfo = reportBertInfo;
                callbackWithOneParam.onSuccess(EvoDspImpl.this.mG2DspInfoImpl);
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
        DspRFManager2.getInstance().setVideoRateInfoListener(new CallbackWithOneParam<VideoRateInfoImpl>() {
            public void onSuccess(VideoRateInfoImpl videoRateInfoImpl) {
                EvoDspImpl.this.mG2DspInfoImpl.mFrameRateInfo = videoRateInfoImpl;
                callbackWithOneParam.onSuccess(EvoDspImpl.this.mG2DspInfoImpl);
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
        DspRFManager2.getInstance().setBandModeWidthInfoListener(new CallbackWithOneParam<BandModeWidthInfo>() {
            public void onSuccess(BandModeWidthInfo bandModeWidthInfo) {
                ((BandwidthInfoImpl) EvoDspImpl.this.mG2DspInfoImpl.mBandwidthInfo).mBandModeWidthInfo = bandModeWidthInfo;
                callbackWithOneParam.onSuccess(EvoDspImpl.this.mG2DspInfoImpl);
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void setBandwidthInfo(BandMode bandMode, Bandwidth bandwidth) {
        DspRFManager2.getInstance().setBandModeWidthInfo(bandMode, bandwidth);
    }

    public void setTransferMode(TransferMode transferMode, CallbackWithNoParam callbackWithNoParam) {
        DspRFManager2.getInstance().setVideoTransferMode(transferMode, callbackWithNoParam);
    }

    public void getTransferMode(final CallbackWithOneParam<TransferMode> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            DspRFManager2.getInstance().getVideoTransferMode(new CallbackWithOneParam<VideoTransferModeInfo>() {
                public void onSuccess(VideoTransferModeInfo videoTransferModeInfo) {
                    callbackWithOneParam.onSuccess(TransferMode.find(videoTransferModeInfo.getTransfMode()));
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        }
    }

    public void setVideoLinkState(boolean z, final CallbackWithNoParam callbackWithNoParam) {
        DspRFManager2.getInstance().setVideoLinkStatus(z, new CallbackWithOneParam<Boolean>() {
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

    public void getDeviceVersionInfo(final CallbackWithOneParam<List<DeviceVersionInfo>> callbackWithOneParam) {
        FirmwareManager.instance().getDeviceFirmwareInfo(new CallbackWithOneParam<List<FirmwareDeviceInfo.VersionBean>>() {
            public void onSuccess(List<FirmwareDeviceInfo.VersionBean> list) {
                callbackWithOneParam.onSuccess(new ArrayList(list));
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }
}

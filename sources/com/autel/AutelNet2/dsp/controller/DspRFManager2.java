package com.autel.AutelNet2.dsp.controller;

import com.autel.AutelNet2.aircraft.base.RequestBean;
import com.autel.AutelNet2.aircraft.flycontroller.message.SystemDateAndTimePacket;
import com.autel.AutelNet2.constant.MsgType;
import com.autel.AutelNet2.core.BaseController;
import com.autel.AutelNet2.core.PacketDisPatcher;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.dsp.data.UserInfo;
import com.autel.AutelNet2.dsp.message.AirRemoteBindingPacket;
import com.autel.AutelNet2.dsp.message.BandModeWidthInfoPacket;
import com.autel.AutelNet2.dsp.message.DspAppMsgPacket;
import com.autel.AutelNet2.dsp.message.DspFactoryPacket;
import com.autel.AutelNet2.dsp.message.LogManagerPacket;
import com.autel.AutelNet2.dsp.message.ReportBertInfoPacket;
import com.autel.AutelNet2.dsp.message.RequestZteRemoteLogPacket;
import com.autel.AutelNet2.dsp.message.SetFrepPacket;
import com.autel.AutelNet2.dsp.message.SetVideoTransferModePacket;
import com.autel.AutelNet2.dsp.message.SetZteRemoteLogPacket;
import com.autel.AutelNet2.dsp.message.SignalStrengthPacket;
import com.autel.AutelNet2.dsp.message.VideoRateInfoPacket;
import com.autel.AutelNet2.dsp.message.VideoStreamAckPacket;
import com.autel.AutelNet2.dsp.message.VideoStreamPacket;
import com.autel.AutelNet2.dsp.message.VideoTransferModePacket;
import com.autel.AutelNet2.utils.AutelMathUtils;
import com.autel.bean.dsp.BandModeWidthInfo;
import com.autel.bean.dsp.ReportBertInfo;
import com.autel.bean.dsp.SignalStrengthReport;
import com.autel.bean.dsp.VideoRateInfoImpl;
import com.autel.bean.dsp.VideoTransferModeInfo;
import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.CallbackWithTwoParams;
import com.autel.common.dsp.AppAction;
import com.autel.common.dsp.AppActionParam;
import com.autel.common.dsp.AutelCancellable;
import com.autel.common.dsp.DeviceType;
import com.autel.common.dsp.RFData;
import com.autel.common.dsp.evo.BandMode;
import com.autel.common.dsp.evo.Bandwidth;
import com.autel.common.dsp.evo.TransferMode;
import com.autel.common.error.AutelError;
import java.util.concurrent.ConcurrentHashMap;

public class DspRFManager2 extends BaseController<Integer> implements AutelCancellable {
    private static final String REGISTER_MESSAGE_KEY = "DspRFManager2";
    private static final short REGISTER_MESSAGE_TYPE = 2048;
    private static final short REGISTER_MESSAGE_TYPE_AU_VIDEO_PLAY_ACK = 513;
    private static final short REGISTER_MESSAGE_TYPE_BANDWIDTH_NOTIFY = 2053;
    private static final short REGISTER_MESSAGE_TYPE_TRANS_INFO = 2060;
    private static final short REGISTER_MESSAGE_TYPE_VIDEO_RATE = 2056;
    private static final short REGISTER_SET_MESSAGE_TYPE = 2051;
    private static final String TAG = "DspRFManager2";
    private static DspRFManager2 instance;
    private ConcurrentHashMap<String, CallbackWithTwoParams<AppAction, AppActionParam>> mAppMsgListener = new ConcurrentHashMap<>();
    private CallbackWithOneParam<BandModeWidthInfo> mBandModeWidthInfoListener;
    private CallbackWithOneParam<RFData> mCurrentListener = null;
    private boolean mGetCurrent = false;
    private CallbackWithOneParam<ReportBertInfo> mReportBertInfoListener;
    private CallbackWithOneParam<Boolean> mSetCallback = null;
    private ConcurrentHashMap<String, CallbackWithOneParam<SignalStrengthReport>> mSignalStrengthListener = new ConcurrentHashMap<>();
    private CallbackWithOneParam<VideoRateInfoImpl> mVideoRateInfoListener;
    private CallbackWithOneParam<byte[]> mZteLogListener;

    public static synchronized DspRFManager2 getInstance() {
        DspRFManager2 dspRFManager2;
        synchronized (DspRFManager2.class) {
            if (instance == null) {
                instance = new DspRFManager2();
            }
            dspRFManager2 = instance;
        }
        return dspRFManager2;
    }

    private DspRFManager2() {
        init();
    }

    public void init() {
        PacketDisPatcher.getInstance().registerReceiveListener("DspRFManager2", 57, this);
        PacketDisPatcher.getInstance().registerReceiveListener("DspRFManager2", 53, this);
        PacketDisPatcher.getInstance().registerReceiveListener("DspRFManager2", 54, this);
        PacketDisPatcher.getInstance().registerReceiveListener("DspRFManager2", 55, this);
        PacketDisPatcher.getInstance().registerReceiveListener("DspRFManager2", 43, this);
        PacketDisPatcher.getInstance().registerReceiveListener("DspRFManager2", MsgType.AU_VIDEO_STOP_ACK, this);
        PacketDisPatcher.getInstance().registerReceiveListener("DspRFManager2", 513, this);
        PacketDisPatcher.getInstance().registerReceiveListener("DspRFManager2", MsgType.AU_VIDEO_SET_TRANSF_MODE_REQ, this);
        PacketDisPatcher.getInstance().registerReceiveListener("DspRFManager2", MsgType.AU_VIDEO_GET_TRANSF_MODE_REQ, this);
        PacketDisPatcher.getInstance().registerReceiveListener("DspRFManager2", 2060, this);
        PacketDisPatcher.getInstance().registerReceiveListener("DspRFManager2", 2051, this);
        PacketDisPatcher.getInstance().registerReceiveListener("DspRFManager2", 2048, this);
        PacketDisPatcher.getInstance().registerReceiveListener("DspRFManager2", 2056, this);
        PacketDisPatcher.getInstance().registerReceiveListener("DspRFManager2", 2053, this);
        PacketDisPatcher.getInstance().registerReceiveListener("DspRFManager2", MsgType.AU_SIGNAL_QUERY_REP1, this);
        PacketDisPatcher.getInstance().registerReceiveListener("DspRFManager2", 4, this);
    }

    public void destroy() {
        super.destroy();
        PacketDisPatcher.getInstance().unRegisterReceiveListener("DspRFManager2", 57);
        PacketDisPatcher.getInstance().unRegisterReceiveListener("DspRFManager2", 53);
        PacketDisPatcher.getInstance().unRegisterReceiveListener("DspRFManager2", 54);
        PacketDisPatcher.getInstance().unRegisterReceiveListener("DspRFManager2", 55);
        PacketDisPatcher.getInstance().unRegisterReceiveListener("DspRFManager2", 43);
        PacketDisPatcher.getInstance().unRegisterReceiveListener("DspRFManager2", MsgType.AU_VIDEO_STOP_ACK);
        PacketDisPatcher.getInstance().unRegisterReceiveListener("DspRFManager2", 513);
        PacketDisPatcher.getInstance().unRegisterReceiveListener("DspRFManager2", MsgType.AU_VIDEO_GET_TRANSF_MODE_REQ);
        PacketDisPatcher.getInstance().unRegisterReceiveListener("DspRFManager2", MsgType.AU_VIDEO_SET_TRANSF_MODE_REQ);
        PacketDisPatcher.getInstance().unRegisterReceiveListener("DspRFManager2", 2060);
        PacketDisPatcher.getInstance().unRegisterReceiveListener("DspRFManager2", 2048);
        PacketDisPatcher.getInstance().unRegisterReceiveListener("DspRFManager2", 2051);
        PacketDisPatcher.getInstance().unRegisterReceiveListener("DspRFManager2", 2056);
        PacketDisPatcher.getInstance().unRegisterReceiveListener("DspRFManager2", 2053);
        PacketDisPatcher.getInstance().unRegisterReceiveListener("DspRFManager2", MsgType.AU_SIGNAL_QUERY_REP1);
        this.mSetCallback = null;
        this.mCurrentListener = null;
    }

    public void setSynMsgBroadcast(AppAction appAction, AppActionParam appActionParam) {
        sendPacket(new DspAppMsgPacket(appAction, appActionParam), (CallbackWithOneParam) null);
    }

    public void setSynMsgBroadcastListener(String str, CallbackWithTwoParams<AppAction, AppActionParam> callbackWithTwoParams) {
        if (!this.mAppMsgListener.containsKey(str) && callbackWithTwoParams != null) {
            this.mAppMsgListener.put(str, callbackWithTwoParams);
        }
    }

    public void removeSynMsgBroadcastListener(String str) {
        this.mAppMsgListener.remove(str);
    }

    public void resetFactoryAll(CallbackWithOneParam<Boolean> callbackWithOneParam) {
        sendPacket(new DspFactoryPacket(DeviceType.ALL.getValue()), callbackWithOneParam);
    }

    public void resetFactory(DeviceType deviceType, CallbackWithOneParam<Boolean> callbackWithOneParam) {
        sendPacket(new DspFactoryPacket(deviceType.getValue()), callbackWithOneParam);
    }

    public void openZteNormalLog(CallbackWithOneParam<Boolean> callbackWithOneParam, CallbackWithOneParam<byte[]> callbackWithOneParam2) {
        this.mZteLogListener = callbackWithOneParam2;
        sendPacket(new SetZteRemoteLogPacket(true), callbackWithOneParam);
    }

    public void openNormalLog(int i, int i2, CallbackWithOneParam<Boolean> callbackWithOneParam) {
        sendPacket(new LogManagerPacket(i, i2), callbackWithOneParam);
    }

    public void stopZteNormalLog(CallbackWithOneParam<Boolean> callbackWithOneParam) {
        sendPacket(new SetZteRemoteLogPacket(false), callbackWithOneParam);
    }

    public void setVideoRateInfoListener(CallbackWithOneParam<VideoRateInfoImpl> callbackWithOneParam) {
        this.mVideoRateInfoListener = callbackWithOneParam;
    }

    public void setReportBertInfoListener(CallbackWithOneParam<ReportBertInfo> callbackWithOneParam) {
        this.mReportBertInfoListener = callbackWithOneParam;
    }

    public void setBandModeWidthInfoListener(CallbackWithOneParam<BandModeWidthInfo> callbackWithOneParam) {
        this.mBandModeWidthInfoListener = callbackWithOneParam;
    }

    public void setSystemDateAndTime() {
        sendPacket(new SystemDateAndTimePacket(), (CallbackWithOneParam) null);
    }

    public void addSignalStregthListener(String str, CallbackWithOneParam<SignalStrengthReport> callbackWithOneParam) {
        this.mGetCurrent = false;
        this.mSignalStrengthListener.put(str, callbackWithOneParam);
    }

    public void removeSignalStregthListener(String str) {
        this.mSignalStrengthListener.remove(str);
    }

    public void setAppVersion(final String str) {
        sendPacket(new BaseMsgPacket() {
            public BaseMsgPacket parseBody() {
                return null;
            }

            /* access modifiers changed from: protected */
            public void loadHead() {
                this.msg_head.msg_type = 56;
                this.msg_head.msg_dst = 1024;
            }

            public String loadBody() {
                return "{\"method\":\"APPVersionInfo\",\"params\": {\"APPType\": 0,\"Version\":" + str + "}}";
            }
        }, (CallbackWithOneParam) null, true);
    }

    public void setBandModeWidthInfo(BandMode bandMode, Bandwidth bandwidth) {
        BandModeWidthInfo bandModeWidthInfo = new BandModeWidthInfo();
        String str = "";
        bandModeWidthInfo.setBandMode((bandMode == null || BandMode.UNKNOWN == bandMode) ? str : bandMode.getValue());
        if (!(bandwidth == null || Bandwidth.UNKNOWN == bandwidth)) {
            str = bandwidth.getValue();
        }
        bandModeWidthInfo.setBandWidth(str);
        sendPacket(new BandModeWidthInfoPacket(bandModeWidthInfo), (CallbackWithOneParam) null);
    }

    public void bingAircraftToRemote(UserInfo userInfo) {
        AirRemoteBindingPacket airRemoteBindingPacket = new AirRemoteBindingPacket();
        airRemoteBindingPacket.setUserInfo(userInfo);
        sendPacket(airRemoteBindingPacket, (CallbackWithOneParam) null);
    }

    public void setVideoTransferMode(TransferMode transferMode, final CallbackWithNoParam callbackWithNoParam) {
        VideoTransferModeInfo videoTransferModeInfo = new VideoTransferModeInfo();
        videoTransferModeInfo.setTransfMode(transferMode.getValue());
        sendPacket(new SetVideoTransferModePacket(new RequestBean(videoTransferModeInfo)), new CallbackWithOneParam<Boolean>() {
            public void onSuccess(Boolean bool) {
                if (bool.booleanValue()) {
                    callbackWithNoParam.onSuccess();
                } else {
                    callbackWithNoParam.onFailure(AutelError.COMMAND_FAILED);
                }
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void getVideoTransferMode(CallbackWithOneParam<VideoTransferModeInfo> callbackWithOneParam) {
        sendPacket(new VideoTransferModePacket(), callbackWithOneParam);
    }

    public void setVideoLinkStatus(boolean z, CallbackWithOneParam<Boolean> callbackWithOneParam) {
        sendPacket(new VideoStreamPacket(z), callbackWithOneParam);
    }

    public AutelCancellable getCurRFTask(CallbackWithOneParam<RFData> callbackWithOneParam) {
        this.mGetCurrent = true;
        this.mCurrentListener = callbackWithOneParam;
        return this;
    }

    public AutelCancellable setCurrentRF(int i, CallbackWithOneParam<Boolean> callbackWithOneParam) {
        this.mSetCallback = callbackWithOneParam;
        SetFrepPacket setFrepPacket = new SetFrepPacket();
        setFrepPacket.setFrep(i);
        sendPacket(setFrepPacket, this.mSetCallback);
        return this;
    }

    /* access modifiers changed from: protected */
    public void checkTimeOut() {
        super.checkTimeOut();
    }

    /* access modifiers changed from: protected */
    public Integer getTimeOutItem(BaseMsgPacket baseMsgPacket) {
        return Integer.valueOf(baseMsgPacket.getType());
    }

    public void onReceiveMessage(BaseMsgPacket baseMsgPacket) {
        boolean z = false;
        if (baseMsgPacket instanceof SignalStrengthPacket) {
            SignalStrengthReport signalStrengthReport = ((SignalStrengthPacket) baseMsgPacket).getSignalStrengthReport();
            if (signalStrengthReport != null) {
                if (!this.mGetCurrent) {
                    for (CallbackWithOneParam<SignalStrengthReport> onSuccess : this.mSignalStrengthListener.values()) {
                        onSuccess.onSuccess(signalStrengthReport);
                    }
                    return;
                }
                this.mGetCurrent = false;
                int currentFrequencyChannel = signalStrengthReport.getCurrentFrequencyChannel();
                if (signalStrengthReport.getChannelList() != null) {
                    int i = currentFrequencyChannel - 1;
                    this.mCurrentListener.onSuccess(new RFData(signalStrengthReport.getChannelList().get(i).getFreq(), signalStrengthReport.getChannelList().get(i).getStrength()));
                } else if (signalStrengthReport.getSignalStrengthList() != null) {
                    int i2 = currentFrequencyChannel - 1;
                    this.mCurrentListener.onSuccess(new RFData(signalStrengthReport.getFreq()[i2], signalStrengthReport.getSignalStrengthList()[i2]));
                }
            }
        } else if (baseMsgPacket instanceof VideoRateInfoPacket) {
            CallbackWithOneParam<VideoRateInfoImpl> callbackWithOneParam = this.mVideoRateInfoListener;
            if (callbackWithOneParam != null) {
                callbackWithOneParam.onSuccess(((VideoRateInfoPacket) baseMsgPacket).getVideoRateInfo());
            }
        } else if (baseMsgPacket instanceof ReportBertInfoPacket) {
            CallbackWithOneParam<ReportBertInfo> callbackWithOneParam2 = this.mReportBertInfoListener;
            if (callbackWithOneParam2 != null) {
                callbackWithOneParam2.onSuccess(((ReportBertInfoPacket) baseMsgPacket).getReportBertInfo());
            }
        } else if (baseMsgPacket instanceof BandModeWidthInfoPacket) {
            CallbackWithOneParam<BandModeWidthInfo> callbackWithOneParam3 = this.mBandModeWidthInfoListener;
            if (callbackWithOneParam3 != null) {
                callbackWithOneParam3.onSuccess(((BandModeWidthInfoPacket) baseMsgPacket).getModeWidthInfo());
            }
        } else if (baseMsgPacket instanceof SetFrepPacket) {
            CallbackWithOneParam<Boolean> callbackWithOneParam4 = this.mSetCallback;
            if (callbackWithOneParam4 != null) {
                callbackWithOneParam4.onSuccess(Boolean.valueOf(((SetFrepPacket) baseMsgPacket).isSetSucc()));
                this.mSetCallback = null;
            }
        } else if (baseMsgPacket instanceof SetVideoTransferModePacket) {
            callbackSucc(baseMsgPacket.getType(), Boolean.valueOf(((SetVideoTransferModePacket) baseMsgPacket).isSuccess()));
        } else if (baseMsgPacket instanceof VideoTransferModePacket) {
            callbackSucc(baseMsgPacket.getType(), ((VideoTransferModePacket) baseMsgPacket).getVideoTransfMode());
        } else if (baseMsgPacket instanceof VideoStreamAckPacket) {
            callbackSucc(baseMsgPacket.getType(), Boolean.valueOf(((VideoStreamAckPacket) baseMsgPacket).isSuccess()));
        } else if (baseMsgPacket instanceof SetZteRemoteLogPacket) {
            int type = baseMsgPacket.getType();
            if (((SetZteRemoteLogPacket) baseMsgPacket).getStatus() == 0) {
                z = true;
            }
            callbackSucc(type, Boolean.valueOf(z));
        } else if (baseMsgPacket instanceof RequestZteRemoteLogPacket) {
            byte[] data = ((RequestZteRemoteLogPacket) baseMsgPacket).getData();
            CallbackWithOneParam<byte[]> callbackWithOneParam5 = this.mZteLogListener;
            if (callbackWithOneParam5 != null) {
                callbackWithOneParam5.onSuccess(data);
            }
        } else if (baseMsgPacket instanceof DspFactoryPacket) {
            int type2 = baseMsgPacket.getType();
            if (((DspFactoryPacket) baseMsgPacket).getStatus() == 0) {
                z = true;
            }
            callbackSucc(type2, Boolean.valueOf(z));
        } else if (baseMsgPacket instanceof DspAppMsgPacket) {
            DspAppMsgPacket dspAppMsgPacket = (DspAppMsgPacket) baseMsgPacket;
            if (!AutelMathUtils.getUUID().equals(dspAppMsgPacket.getUuid())) {
                iteratorCallback(this.mAppMsgListener, dspAppMsgPacket.getAppAction(), dspAppMsgPacket.getAppActionParam());
            }
        } else if (baseMsgPacket instanceof LogManagerPacket) {
            int type3 = baseMsgPacket.getType();
            if (((LogManagerPacket) baseMsgPacket).getStatus() == 0) {
                z = true;
            }
            callbackSucc(type3, Boolean.valueOf(z));
        }
    }

    public boolean cancel() {
        destroy();
        return true;
    }
}

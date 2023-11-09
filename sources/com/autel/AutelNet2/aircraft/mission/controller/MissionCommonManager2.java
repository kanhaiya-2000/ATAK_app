package com.autel.AutelNet2.aircraft.mission.controller;

import android.text.TextUtils;
import com.autel.AutelNet2.aircraft.base.CommandAckPacket;
import com.autel.AutelNet2.aircraft.base.CommonCmdRequest;
import com.autel.AutelNet2.aircraft.base.RequestBean;
import com.autel.AutelNet2.aircraft.engine.FmuCmdParams;
import com.autel.AutelNet2.aircraft.firmware.message.UpgradeNotifyPacket;
import com.autel.AutelNet2.aircraft.flycontroller.engine.CommandInfoInternal;
import com.autel.AutelNet2.aircraft.flycontroller.util.TransformUtils;
import com.autel.AutelNet2.aircraft.mission.engine.BreakPointFlyInfo;
import com.autel.AutelNet2.aircraft.mission.engine.CurrentMission;
import com.autel.AutelNet2.aircraft.mission.engine.FollowMeInfoInternal;
import com.autel.AutelNet2.aircraft.mission.engine.GpsFollowMeInfo;
import com.autel.AutelNet2.aircraft.mission.engine.GpsTargetInfo;
import com.autel.AutelNet2.aircraft.mission.engine.HotPointInfoInternal;
import com.autel.AutelNet2.aircraft.mission.engine.MissionAllInternal;
import com.autel.AutelNet2.aircraft.mission.engine.MissionFileInfo;
import com.autel.AutelNet2.aircraft.mission.engine.MissionSingleInfo;
import com.autel.AutelNet2.aircraft.mission.engine.MotionDelayInfo;
import com.autel.AutelNet2.aircraft.mission.engine.PanoramaInfo;
import com.autel.AutelNet2.aircraft.mission.engine.TransferNotifyInfo;
import com.autel.AutelNet2.aircraft.mission.engine.TripodInfo;
import com.autel.AutelNet2.aircraft.mission.message.BreakPointMissionPacket;
import com.autel.AutelNet2.aircraft.mission.message.CurrentFollowMePacket;
import com.autel.AutelNet2.aircraft.mission.message.CurrentHotPointPacket;
import com.autel.AutelNet2.aircraft.mission.message.CurrentMissionPacket;
import com.autel.AutelNet2.aircraft.mission.message.GpsFollowMePacket;
import com.autel.AutelNet2.aircraft.mission.message.MissionSinglePacket;
import com.autel.AutelNet2.aircraft.mission.message.MissionTransferPacket;
import com.autel.AutelNet2.aircraft.mission.message.MotionDelaySettingPacket;
import com.autel.AutelNet2.aircraft.mission.message.PanoramaPacket;
import com.autel.AutelNet2.aircraft.mission.message.RequestMissionAllSettingsPacket;
import com.autel.AutelNet2.aircraft.mission.message.TrackingGpsPacket;
import com.autel.AutelNet2.aircraft.mission.message.TripodSettingPacket;
import com.autel.AutelNet2.aircraft.mission.message.UploadMissionAllSettingsPacket;
import com.autel.AutelNet2.aircraft.mission.message.UploadMissionFileNotifyPacket;
import com.autel.AutelNet2.aircraft.mission.message.UploadMissionFilePacket;
import com.autel.AutelNet2.constant.FmuCmdConstant;
import com.autel.AutelNet2.constant.MsgType;
import com.autel.AutelNet2.core.BaseController;
import com.autel.AutelNet2.core.ConnectionManager2;
import com.autel.AutelNet2.core.PacketDisPatcher;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.CallbackWithOneParamProgress;
import com.autel.common.error.AutelError;
import com.autel.common.mission.MissionType;
import com.autel.internal.sdk.mission.evo.OperateDataType;
import com.autel.util.log.AutelLog;
import com.google.common.net.HttpHeaders;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.ConcurrentHashMap;

public class MissionCommonManager2 extends BaseController<Integer> {
    public static String FILE_PATH = null;
    private static final String REGISTER_MESSAGE_KEY = "MissionCommonManager2";
    private static final short REGISTER_MESSAGE_TYPE = 263;
    private static final short REGISTER_MISSION_CURRENT = 310;
    private static final short REGISTER_MISSION_FOLLOW_ME_CURRENT = 314;
    private static final short REGISTER_MISSION_HOT_POINT_CURRENT = 312;
    private static MissionCommonManager2 instance_;
    private CallbackWithOneParam<MissionAllInternal> downloadAllMissionListener;
    private final ConcurrentHashMap<String, CallbackWithOneParam<BreakPointFlyInfo>> mBreakPointListeners = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, CallbackWithOneParam<FollowMeInfoInternal>> mCurrentMissionFollowMeListeners = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, CallbackWithOneParam<HotPointInfoInternal>> mCurrentMissionHotPointListeners = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, CallbackWithOneParam<CurrentMission>> mCurrentMissionListeners = new ConcurrentHashMap<>();
    private UploadMissionAllSettingsPacket missionAllSettingsPacket;
    private CallbackWithOneParamProgress<Integer> transferCallbackWithProgress;
    private CallbackWithOneParam<Boolean> uploadCallbackWithOneParam;

    public static synchronized MissionCommonManager2 getInstance() {
        MissionCommonManager2 missionCommonManager2;
        synchronized (MissionCommonManager2.class) {
            if (instance_ == null) {
                instance_ = new MissionCommonManager2();
            }
            missionCommonManager2 = instance_;
        }
        return missionCommonManager2;
    }

    private MissionCommonManager2() {
        init();
    }

    public void setMissionSingleTask(MissionSingleInfo missionSingleInfo, CallbackWithOneParam<CommandInfoInternal> callbackWithOneParam) {
        MissionSinglePacket missionSinglePacket = new MissionSinglePacket();
        missionSinglePacket.setRequestBean(missionSingleInfo);
        sendPacket(missionSinglePacket, callbackWithOneParam);
    }

    public void uploadMission(MissionAllInternal missionAllInternal, CallbackWithOneParam<Boolean> callbackWithOneParam) {
        UploadMissionAllSettingsPacket uploadMissionAllSettingsPacket = new UploadMissionAllSettingsPacket();
        this.missionAllSettingsPacket = uploadMissionAllSettingsPacket;
        uploadMissionAllSettingsPacket.setRequestBean(new RequestBean(missionAllInternal));
        sendPacket(this.missionAllSettingsPacket, callbackWithOneParam);
    }

    public void unRegisterUploadMission() {
        UploadMissionAllSettingsPacket uploadMissionAllSettingsPacket = this.missionAllSettingsPacket;
        if (uploadMissionAllSettingsPacket != null) {
            unRegisterMessageListener(uploadMissionAllSettingsPacket.getType());
        }
    }

    public void startUploadFileCmd(MissionFileInfo missionFileInfo, String str, CallbackWithOneParam<Boolean> callbackWithOneParam) {
        FILE_PATH = str;
        this.uploadCallbackWithOneParam = callbackWithOneParam;
        sendPacket(new MissionTransferPacket(missionFileInfo), (CallbackWithOneParam) null);
    }

    public void uploadMissionFile(FileInputStream fileInputStream, CallbackWithOneParamProgress<Integer> callbackWithOneParamProgress) {
        this.transferCallbackWithProgress = callbackWithOneParamProgress;
        sendPacket(new UploadMissionFilePacket(fileInputStream), (CallbackWithOneParam) null);
    }

    public void downloadAllMissionInfo(CallbackWithOneParam<MissionAllInternal> callbackWithOneParam) {
        this.downloadAllMissionListener = callbackWithOneParam;
        operateMissionByCmd(OperateDataType.ALL, FmuCmdConstant.MAV_CMD_MISSION_DATA_REQUIRE, (CallbackWithOneParam<Boolean>) null);
    }

    public void operateMissionByCmd(OperateDataType operateDataType, String str, CallbackWithOneParam<Boolean> callbackWithOneParam) {
        sendPacket(new CommonCmdRequest(TransformUtils.getRequestCmdParamBean(new FmuCmdParams(operateDataType.getValue()), str)), callbackWithOneParam);
    }

    public void operateMissionByCmd(MissionType missionType, String str, CallbackWithOneParam<Boolean> callbackWithOneParam) {
        sendPacket(new CommonCmdRequest(TransformUtils.getRequestCmdParamBean(new FmuCmdParams(missionType.getValue()), str)), callbackWithOneParam);
    }

    public void operateMissionByCmd(String str, CallbackWithOneParam<Boolean> callbackWithOneParam) {
        sendPacket(new CommonCmdRequest(TransformUtils.getRequestCmdBean(str)), callbackWithOneParam);
    }

    public void operateStopMissionByCmd(int i, CallbackWithOneParam<Boolean> callbackWithOneParam) {
        sendPacket(new CommonCmdRequest(TransformUtils.getRequestCmdParamBean(new FmuCmdParams(i), FmuCmdConstant.MAV_CMD_MISSION_STOP)), callbackWithOneParam);
    }

    public void panoramaMission(PanoramaInfo panoramaInfo) {
        sendPacket(new PanoramaPacket(panoramaInfo), (CallbackWithOneParam) null);
    }

    public void gpsFollowMeMission(GpsFollowMeInfo gpsFollowMeInfo, CallbackWithOneParam<Boolean> callbackWithOneParam) {
        sendPacket(new GpsFollowMePacket(gpsFollowMeInfo), callbackWithOneParam);
    }

    public void setTripodSetting(TripodInfo tripodInfo, CallbackWithOneParam<Boolean> callbackWithOneParam) {
        sendPacket(new TripodSettingPacket(tripodInfo), callbackWithOneParam);
    }

    public void setMotionDelaySetting(MotionDelayInfo motionDelayInfo, CallbackWithOneParam<Boolean> callbackWithOneParam) {
        sendPacket(new MotionDelaySettingPacket(motionDelayInfo), callbackWithOneParam);
    }

    public void gpsTargetMission(GpsTargetInfo gpsTargetInfo) {
        sendPacket(new TrackingGpsPacket(gpsTargetInfo), (CallbackWithOneParam) null);
    }

    public void addBreakPointEventListener(String str, CallbackWithOneParam<BreakPointFlyInfo> callbackWithOneParam) {
        if (str != null && !TextUtils.isEmpty(str) && callbackWithOneParam != null) {
            this.mBreakPointListeners.put(str, callbackWithOneParam);
            PacketDisPatcher.getInstance().registerReceiveListener(REGISTER_MESSAGE_KEY, MsgType.AU_MAV_FMU_BP_CONTINUE_FLY_INFO, this);
        }
    }

    public void addMissionCurrentInfoListener(String str, CallbackWithOneParam<CurrentMission> callbackWithOneParam) {
        if (str != null && !TextUtils.isEmpty(str) && callbackWithOneParam != null) {
            this.mCurrentMissionListeners.put(str, callbackWithOneParam);
            PacketDisPatcher.getInstance().registerReceiveListener(REGISTER_MESSAGE_KEY, 310, this);
        }
    }

    public void addMissionFollowMeListener(String str, CallbackWithOneParam<FollowMeInfoInternal> callbackWithOneParam) {
        if (str != null && !TextUtils.isEmpty(str) && callbackWithOneParam != null) {
            this.mCurrentMissionFollowMeListeners.put(str, callbackWithOneParam);
            PacketDisPatcher.getInstance().registerReceiveListener(REGISTER_MESSAGE_KEY, 314, this);
        }
    }

    public void addMissionHotPointListener(String str, CallbackWithOneParam<HotPointInfoInternal> callbackWithOneParam) {
        if (str != null && !TextUtils.isEmpty(str) && callbackWithOneParam != null) {
            this.mCurrentMissionHotPointListeners.put(str, callbackWithOneParam);
            PacketDisPatcher.getInstance().registerReceiveListener(REGISTER_MESSAGE_KEY, 312, this);
        }
    }

    public void removeBreakPointInfoListener(String str) {
        if (str != null && !TextUtils.isEmpty(str)) {
            this.mBreakPointListeners.remove(str);
            if (this.mBreakPointListeners.isEmpty()) {
                PacketDisPatcher.getInstance().unRegisterReceiveListener(REGISTER_MESSAGE_KEY, MsgType.AU_MAV_FMU_BP_CONTINUE_FLY_INFO);
            }
        }
    }

    public void removeMissionCurrentInfoListener(String str) {
        if (str != null && !TextUtils.isEmpty(str)) {
            this.mCurrentMissionListeners.remove(str);
            if (this.mCurrentMissionListeners.isEmpty()) {
                PacketDisPatcher.getInstance().unRegisterReceiveListener(REGISTER_MESSAGE_KEY, 310);
            }
        }
    }

    public void removeMissionFollowMeListener(String str) {
        if (str != null && !TextUtils.isEmpty(str)) {
            this.mCurrentMissionFollowMeListeners.remove(str);
            if (this.mCurrentMissionFollowMeListeners.isEmpty()) {
                PacketDisPatcher.getInstance().unRegisterReceiveListener(REGISTER_MESSAGE_KEY, 314);
            }
        }
    }

    public void removeMissionHotPointListener(String str) {
        if (str != null && !TextUtils.isEmpty(str)) {
            this.mCurrentMissionHotPointListeners.remove(str);
            if (this.mCurrentMissionHotPointListeners.isEmpty()) {
                PacketDisPatcher.getInstance().unRegisterReceiveListener(REGISTER_MESSAGE_KEY, 312);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void checkTimeOut() {
        super.checkTimeOut();
    }

    /* access modifiers changed from: protected */
    public Integer getTimeOutItem(BaseMsgPacket baseMsgPacket) {
        if (baseMsgPacket.getType() == -569294973) {
            if ((baseMsgPacket instanceof UploadMissionAllSettingsPacket) && ((UploadMissionAllSettingsPacket) baseMsgPacket).getRequestBean().getParams().getWaypoints() != null) {
                return null;
            }
        } else if (baseMsgPacket.getType() == -1954054139) {
            AutelLog.debug_i("downloadMission", "getTimeOutItem return null");
            return null;
        }
        return Integer.valueOf(baseMsgPacket.getType());
    }

    public void init() {
        PacketDisPatcher.getInstance().registerReceiveListener(REGISTER_MESSAGE_KEY, MsgType.AU_UPGRADE_RETRANSMIT, this);
        PacketDisPatcher.getInstance().registerReceiveListener(REGISTER_MESSAGE_KEY, MsgType.AU_MAV_FMU_ALL_MISSION_DATA, this);
        PacketDisPatcher.getInstance().registerReceiveListener(REGISTER_MESSAGE_KEY, MsgType.AU_MAV_FMU_ALL_MISSION_DATA_ACK, this);
        PacketDisPatcher.getInstance().registerReceiveListener(REGISTER_MESSAGE_KEY, 263, this);
        PacketDisPatcher.getInstance().registerReceiveListener(REGISTER_MESSAGE_KEY, MsgType.AU_MAV_FMU_SET_TRIPOD_INFO, this);
        PacketDisPatcher.getInstance().registerReceiveListener(REGISTER_MESSAGE_KEY, MsgType.AU_TRANSFER_FILE_INFO_RESP, this);
        PacketDisPatcher.getInstance().registerReceiveListener(REGISTER_MESSAGE_KEY, MsgType.AU_TRANSFER_NOTIFY_PROGRESS, this);
    }

    public void destroy() {
        super.destroy();
        this.mCurrentMissionHotPointListeners.clear();
        this.mCurrentMissionFollowMeListeners.clear();
        this.mCurrentMissionListeners.clear();
        PacketDisPatcher.getInstance().unRegisterReceiveListener(REGISTER_MESSAGE_KEY, MsgType.AU_MAV_FMU_ALL_MISSION_DATA);
        PacketDisPatcher.getInstance().unRegisterReceiveListener(REGISTER_MESSAGE_KEY, MsgType.AU_MAV_FMU_ALL_MISSION_DATA_ACK);
        PacketDisPatcher.getInstance().unRegisterReceiveListener(REGISTER_MESSAGE_KEY, 263);
        PacketDisPatcher.getInstance().unRegisterReceiveListener(REGISTER_MESSAGE_KEY, MsgType.AU_MAV_FMU_SET_TRIPOD_INFO);
        PacketDisPatcher.getInstance().unRegisterReceiveListener(REGISTER_MESSAGE_KEY, MsgType.AU_TRANSFER_FILE_INFO_RESP);
        PacketDisPatcher.getInstance().unRegisterReceiveListener(REGISTER_MESSAGE_KEY, MsgType.AU_TRANSFER_NOTIFY_PROGRESS);
        PacketDisPatcher.getInstance().unRegisterReceiveListener(REGISTER_MESSAGE_KEY, MsgType.AU_UPGRADE_RETRANSMIT);
    }

    public void onReceiveMessage(BaseMsgPacket baseMsgPacket) {
        CallbackWithOneParam<MissionAllInternal> callbackWithOneParam;
        if (baseMsgPacket instanceof CommandAckPacket) {
            CommandInfoInternal commandInfoInternal = ((CommandAckPacket) baseMsgPacket).getCommandInfoInternal();
            if (commandInfoInternal != null) {
                callbackSucc(baseMsgPacket.getType(), Boolean.valueOf(commandInfoInternal.isSuccess()));
            }
        } else if (baseMsgPacket instanceof CurrentMissionPacket) {
            iteratorCallback(this.mCurrentMissionListeners, ((CurrentMissionPacket) baseMsgPacket).getCurrentMission());
        } else if (baseMsgPacket instanceof BreakPointMissionPacket) {
            iteratorCallback(this.mBreakPointListeners, ((BreakPointMissionPacket) baseMsgPacket).getBreakPointFlyInfo());
        } else if (baseMsgPacket instanceof CurrentFollowMePacket) {
            iteratorCallback(this.mCurrentMissionFollowMeListeners, ((CurrentFollowMePacket) baseMsgPacket).getFollowMeInfoInternal());
        } else if (baseMsgPacket instanceof CurrentHotPointPacket) {
            iteratorCallback(this.mCurrentMissionHotPointListeners, ((CurrentHotPointPacket) baseMsgPacket).getHotPointInfoInternal());
        } else {
            boolean z = false;
            if (baseMsgPacket instanceof UploadMissionAllSettingsPacket) {
                int type = baseMsgPacket.getType();
                if (((UploadMissionAllSettingsPacket) baseMsgPacket).getStatus() == 0) {
                    z = true;
                }
                callbackSucc(type, Boolean.valueOf(z));
            } else if (baseMsgPacket instanceof RequestMissionAllSettingsPacket) {
                MissionAllInternal missionAllInternal = ((RequestMissionAllSettingsPacket) baseMsgPacket).getMissionAllInternal();
                if (missionAllInternal != null && (callbackWithOneParam = this.downloadAllMissionListener) != null) {
                    callbackWithOneParam.onSuccess(missionAllInternal);
                }
            } else if (baseMsgPacket instanceof TripodSettingPacket) {
                int type2 = baseMsgPacket.getType();
                if (((TripodSettingPacket) baseMsgPacket).getStatus() == 0) {
                    z = true;
                }
                callbackSucc(type2, Boolean.valueOf(z));
            } else if (baseMsgPacket instanceof MissionTransferPacket) {
                if (this.uploadCallbackWithOneParam != null) {
                    dealCallbackData(((MissionTransferPacket) baseMsgPacket).getStatus());
                }
            } else if (baseMsgPacket instanceof UploadMissionFileNotifyPacket) {
                if (this.transferCallbackWithProgress != null) {
                    TransferNotifyInfo transferNotifyInfo = ((UploadMissionFileNotifyPacket) baseMsgPacket).getTransferNotifyInfo();
                    if (transferNotifyInfo != null && transferNotifyInfo.getStatus() == 0) {
                        this.transferCallbackWithProgress.onProgress((float) transferNotifyInfo.getPercent());
                    } else if (transferNotifyInfo != null && transferNotifyInfo.getStatus() == 4) {
                        AutelLog.debug_i(HttpHeaders.UPGRADE, "upload progress status = 4 failed");
                        ConnectionManager2.getInstance_().stopSendFile();
                        this.transferCallbackWithProgress.onFailure(AutelError.COMMAND_FAILED);
                    }
                }
            } else if (baseMsgPacket instanceof UpgradeNotifyPacket) {
                StringBuilder sb = new StringBuilder();
                sb.append("onReceiveMessage:retry ");
                sb.append(baseMsgPacket.toString());
                sb.append(" seekPosition:");
                UpgradeNotifyPacket upgradeNotifyPacket = (UpgradeNotifyPacket) baseMsgPacket;
                sb.append(upgradeNotifyPacket.getSeekPosition());
                AutelLog.debug_i(HttpHeaders.UPGRADE, sb.toString());
                if (upgradeNotifyPacket.getSeekPosition() >= 0) {
                    ConnectionManager2.getInstance_().stopSendFile();
                    ConnectionManager2.getInstance_().setRetry(true);
                    ConnectionManager2.getInstance_().setSeekPosition((long) upgradeNotifyPacket.getSeekPosition());
                    if (!TextUtils.isEmpty(FILE_PATH)) {
                        try {
                            File file = new File(FILE_PATH);
                            AutelLog.m15082d(HttpHeaders.UPGRADE, "retry send data: ");
                            uploadMissionFile(new FileInputStream(file), this.transferCallbackWithProgress);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    private void dealCallbackData(int i) {
        if (i != 0) {
            switch (i) {
                case 9:
                    this.uploadCallbackWithOneParam.onFailure(AutelError.FLY_UPLOAD_FILE_MD5_ERROR);
                    return;
                case 10:
                    this.uploadCallbackWithOneParam.onFailure(AutelError.FLY_UPLOAD_FILE_NOT_ENOUGHT_SPACE);
                    return;
                case 11:
                    this.uploadCallbackWithOneParam.onFailure(AutelError.FLY_UPLOAD_FILE_CREATE_FAILED);
                    return;
                case 12:
                    this.uploadCallbackWithOneParam.onFailure(AutelError.FLY_UPLOAD_FILE_WRITE_FAILED);
                    return;
                case 13:
                    this.uploadCallbackWithOneParam.onFailure(AutelError.FLY_UPLOAD_FILE_READ_FAILED);
                    return;
                case 14:
                    this.uploadCallbackWithOneParam.onFailure(AutelError.FLY_UPLOAD_FILE_NOT_EXIST);
                    return;
                case 15:
                    this.uploadCallbackWithOneParam.onFailure(AutelError.FLY_UPLOAD_FILE_MD5_SAME);
                    return;
                case 16:
                    this.uploadCallbackWithOneParam.onFailure(AutelError.FLY_UPLOAD_FILE_MD5_NOT_SAME);
                    return;
                default:
                    this.uploadCallbackWithOneParam.onFailure(AutelError.COMMAND_FAILED);
                    return;
            }
        } else {
            this.uploadCallbackWithOneParam.onSuccess(true);
        }
    }
}

package com.autel.AutelNet2.aircraft.flycontroller;

import android.text.TextUtils;
import com.autel.AutelNet2.aircraft.base.CommandAckPacket;
import com.autel.AutelNet2.aircraft.base.CommonCmdRequest;
import com.autel.AutelNet2.aircraft.base.ParamsAckPacket;
import com.autel.AutelNet2.aircraft.base.ParamsSetPacket;
import com.autel.AutelNet2.aircraft.base.RequestBeanNoID;
import com.autel.AutelNet2.aircraft.engine.BoatModeInfo;
import com.autel.AutelNet2.aircraft.engine.FmuCmdParams;
import com.autel.AutelNet2.aircraft.engine.FmuNFZParams;
import com.autel.AutelNet2.aircraft.engine.FmuSetHomeParams;
import com.autel.AutelNet2.aircraft.engine.LedPilotInfo;
import com.autel.AutelNet2.aircraft.flycontroller.engine.AttitudeInfoInternal;
import com.autel.AutelNet2.aircraft.flycontroller.engine.AuthenInfo;
import com.autel.AutelNet2.aircraft.flycontroller.engine.CommandInfoInternal;
import com.autel.AutelNet2.aircraft.flycontroller.engine.ImuCalibrationStateInfo;
import com.autel.AutelNet2.aircraft.flycontroller.engine.ImuStateInfoImpl;
import com.autel.AutelNet2.aircraft.flycontroller.engine.LocalCoordinateInfoImpl;
import com.autel.AutelNet2.aircraft.flycontroller.engine.ParamsAckInfo;
import com.autel.AutelNet2.aircraft.flycontroller.engine.RtkIntenal;
import com.autel.AutelNet2.aircraft.flycontroller.message.AttitudePacket;
import com.autel.AutelNet2.aircraft.flycontroller.message.FlightControlPacket;
import com.autel.AutelNet2.aircraft.flycontroller.message.GPSInfoPacket;
import com.autel.AutelNet2.aircraft.flycontroller.message.IMUCalibrationStatusPacket;
import com.autel.AutelNet2.aircraft.flycontroller.message.IMUStatusPacket;
import com.autel.AutelNet2.aircraft.flycontroller.message.LocalCoordinateInfoPacket;
import com.autel.AutelNet2.aircraft.flycontroller.message.RtkDataPacket;
import com.autel.AutelNet2.aircraft.flycontroller.message.RtkInfoReportPacket;
import com.autel.AutelNet2.aircraft.flycontroller.parser.GPSInfoInternal;
import com.autel.AutelNet2.aircraft.flycontroller.util.SensitiveUtil2;
import com.autel.AutelNet2.aircraft.flycontroller.util.TransformUtils;
import com.autel.AutelNet2.aircraft.mission.enmus.ArmStatus;
import com.autel.AutelNet2.aircraft.mission.enmus.LocationStatus;
import com.autel.AutelNet2.aircraft.mission.enmus.ReturnStatus;
import com.autel.AutelNet2.constant.FmuCmdConstant;
import com.autel.AutelNet2.constant.MsgType;
import com.autel.AutelNet2.core.BaseController;
import com.autel.AutelNet2.core.PacketDisPatcher;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.remotecontroller.engine.FlightcontrolInfo;
import com.autel.AutelNet2.utils.AutelMathUtils;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.CallbackWithTwoParams;
import com.autel.common.flycontroller.BoatMode;
import com.autel.common.flycontroller.FmuParameterEvent;
import com.autel.common.flycontroller.LedPilotLamp;
import com.autel.internal.sdk.camera.base.AutelSwitchState;
import com.autel.internal.sdk.flycontroller.BeginnerMode;
import java.util.concurrent.ConcurrentHashMap;

public class FlyControllerManager2 extends BaseController<Integer> {
    private static final short REGISTER_COMMAND_TYPE = 263;
    private static final String REGISTER_MESSAGE_KEY = "FlyControllerManager2";
    private static final short REGISTER_PARAMS_TYPE = 267;
    private static final String TAG = "FlyController";
    private static FlyControllerManager2 instance_;
    private CallbackWithOneParam<Boolean> callbackWithOneParam;
    private final ConcurrentHashMap<String, CallbackWithOneParam<AttitudeInfoInternal>> mAttitudeInfoListeners = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, CallbackWithOneParam<ImuStateInfoImpl>> mFmuImuListeners = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, CallbackWithTwoParams<FmuParameterEvent, Float>> mFmuParameterEvents = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, CallbackWithOneParam<GPSInfoInternal>> mGPSInfoListeners = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, CallbackWithOneParam<ImuCalibrationStateInfo>> mIMUStateListeners = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, CallbackWithOneParam<LocalCoordinateInfoImpl>> mLocalCoordinateInfoListeners = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, CallbackWithOneParam<byte[]>> mRTKDataListeners = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, CallbackWithOneParam<RtkIntenal>> mRTKReportListeners = new ConcurrentHashMap<>();

    public void setFmuSaveParameter(CallbackWithOneParam<CommandInfoInternal> callbackWithOneParam2) {
    }

    public static synchronized FlyControllerManager2 getInstance() {
        FlyControllerManager2 flyControllerManager2;
        synchronized (FlyControllerManager2.class) {
            if (instance_ == null) {
                instance_ = new FlyControllerManager2();
            }
            flyControllerManager2 = instance_;
        }
        return flyControllerManager2;
    }

    private FlyControllerManager2() {
        init();
    }

    public void takeOff(CallbackWithOneParam<CommandInfoInternal> callbackWithOneParam2) {
        sendPacket(new CommonCmdRequest(TransformUtils.getRequestCmdBean(FmuCmdConstant.MAV_CMD_NAV_TAKEOFF)), callbackWithOneParam2);
    }

    public void DoArmAction(ArmStatus armStatus, CallbackWithOneParam<CommandInfoInternal> callbackWithOneParam2) {
        sendPacket(new CommonCmdRequest(TransformUtils.getRequestCmdParamBean(new FmuCmdParams(armStatus.getValue()), FmuCmdConstant.MAV_CMD_COMPONENT_ARM_DISARM)), callbackWithOneParam2);
    }

    public void land(CallbackWithOneParam<CommandInfoInternal> callbackWithOneParam2) {
        sendPacket(new CommonCmdRequest(TransformUtils.getRequestCmdBean(FmuCmdConstant.MAV_CMD_NAV_LAND)), callbackWithOneParam2);
    }

    public void setNFZEnable(AutelSwitchState autelSwitchState, CallbackWithOneParam<CommandInfoInternal> callbackWithOneParam2) {
        sendPacket(new CommonCmdRequest(TransformUtils.getRequestCmdParamBean(new FmuCmdParams(autelSwitchState == AutelSwitchState.ON ? 1 : 0), FmuCmdConstant.MAV_CMD_SET_NFZ_ENABLE)), callbackWithOneParam2);
    }

    public void startImuCalibration(CallbackWithOneParam<CommandInfoInternal> callbackWithOneParam2) {
        sendPacket(new CommonCmdRequest(TransformUtils.getRequestCmdBean(FmuCmdConstant.MAV_CMD_IMU_USER_CALIBRATION)), callbackWithOneParam2);
    }

    public void returnToLaunch(ReturnStatus returnStatus, CallbackWithOneParam<CommandInfoInternal> callbackWithOneParam2) {
        sendPacket(new CommonCmdRequest(TransformUtils.getRequestCmdParamBean(new FmuCmdParams(returnStatus.getValue()), FmuCmdConstant.MAV_CMD_NAV_RETURN_TO_LAUNCH)), callbackWithOneParam2);
    }

    public void setBoatMode(BoatMode boatMode, CallbackWithOneParam<CommandInfoInternal> callbackWithOneParam2) {
        sendPacket(new CommonCmdRequest(TransformUtils.getRequestCmdParamBean(new FmuCmdParams(boatMode.getValue()), FmuCmdConstant.MAV_CMD_NAV_FORCE_TAKEOFF)), callbackWithOneParam2);
    }

    public void getBoatMode(CallbackWithOneParam<BoatModeInfo> callbackWithOneParam2) {
        sendPacket(new CommonCmdRequest(TransformUtils.getRequestCmdBean(FmuCmdConstant.MAV_CMD_NAV_GET_TAKEOFF)), callbackWithOneParam2);
    }

    public void setLocationToHome(LocationStatus locationStatus, int i, int i2, CallbackWithOneParam<CommandInfoInternal> callbackWithOneParam2) {
        sendPacket(new CommonCmdRequest(TransformUtils.getRequestCmdParamBean((FmuCmdParams) new FmuSetHomeParams(locationStatus.getValue(), (float) i, (float) i2), FmuCmdConstant.MAV_CMD_DO_SET_HOME)), callbackWithOneParam2);
    }

    public void goHome(CallbackWithOneParam<CommandInfoInternal> callbackWithOneParam2) {
        returnToLaunch(ReturnStatus.LAND, callbackWithOneParam2);
    }

    public void setBeginnerMode(boolean z, CallbackWithOneParam<BeginnerMode> callbackWithOneParam2) {
        sendPacket(TransformUtils.getParamsSetPacketT(z ? 1.0f : 0.0f, "SM_Beginner_Mode"), callbackWithOneParam2, true);
    }

    public void uploadRTKData(byte[] bArr, CallbackWithOneParam<Boolean> callbackWithOneParam2) {
        sendPacket(new RtkDataPacket(bArr), callbackWithOneParam2);
    }

    public void setHeartBeat() {
        sendPacket(new BaseMsgPacket() {
            /* access modifiers changed from: protected */
            public String loadBody() {
                return null;
            }

            public BaseMsgPacket parseBody() {
                return null;
            }

            /* access modifiers changed from: protected */
            public void loadHead() {
                this.msg_head.msg_type = 20;
                this.msg_head.msg_dst = 1;
                this.msg_head.version = 2;
            }
        }, (CallbackWithOneParam) null, true);
    }

    public void setFlightControllerDirect(int i, CallbackWithOneParam<Boolean> callbackWithOneParam2) {
        this.callbackWithOneParam = callbackWithOneParam2;
        FlightcontrolInfo flightcontrolInfo = new FlightcontrolInfo();
        flightcontrolInfo.setLeftHorizonPole(AutelMathUtils.convertT(i));
        sendPacket(new FlightControlPacket(new RequestBeanNoID(flightcontrolInfo)), (CallbackWithOneParam) null);
    }

    public void queryBeginnerMode(CallbackWithOneParam<BeginnerMode> callbackWithOneParam2) {
        sendPacket(TransformUtils.getParamsGetPacket("SM_Beginner_Mode"), callbackWithOneParam2);
    }

    public void restoreSDLogFrequency(CallbackWithOneParam<Integer> callbackWithOneParam2) {
        sendPacket(TransformUtils.getParamsSetPacket(0.0f, "SM_SDLOG_SEN"), callbackWithOneParam2, true);
    }

    public void setFlyIncidence(float f, CallbackWithOneParam<CommandInfoInternal> callbackWithOneParam2) {
        sendPacket(TransformUtils.getParamsSetPacket(f, FmuCmdConstant.SM_Max_rp), callbackWithOneParam2, true);
    }

    public void queryFlyIncidence(CallbackWithOneParam<Float> callbackWithOneParam2) {
        sendPacket(TransformUtils.getParamsGetPacket(FmuCmdConstant.SM_Max_rp), callbackWithOneParam2);
    }

    public void setGasPedalSensitivity(float f, CallbackWithOneParam<Float> callbackWithOneParam2) {
        sendPacket(TransformUtils.getParamsSetPacket(SensitiveUtil2.coefficient2Sensitive(f), FmuCmdConstant.SM_THRUST_SEN), callbackWithOneParam2, true);
    }

    public void getGasPedalSensitivity(CallbackWithOneParam<Float> callbackWithOneParam2) {
        sendPacket(TransformUtils.getParamsGetPacket(FmuCmdConstant.SM_THRUST_SEN), callbackWithOneParam2);
    }

    public void setATTISensitivity(float f, CallbackWithOneParam<Float> callbackWithOneParam2) {
        sendPacket(TransformUtils.getParamsSetPacket(f, FmuCmdConstant.SM_ATT_SEN), callbackWithOneParam2, true);
    }

    public void getATTISensitivity(CallbackWithOneParam<Float> callbackWithOneParam2) {
        sendPacket(TransformUtils.getParamsGetPacket(FmuCmdConstant.SM_ATT_SEN), callbackWithOneParam2);
    }

    public void setBrakeSensitivity(float f, CallbackWithOneParam<Float> callbackWithOneParam2) {
        sendPacket(TransformUtils.getParamsSetPacket(f, FmuCmdConstant.SM_BRAKE_SEN), callbackWithOneParam2, true);
    }

    public void getBrakeSensitivity(CallbackWithOneParam<Float> callbackWithOneParam2) {
        sendPacket(TransformUtils.getParamsGetPacket(FmuCmdConstant.SM_BRAKE_SEN), callbackWithOneParam2);
    }

    public void setYawStrokeSensitivity(float f, CallbackWithOneParam<Float> callbackWithOneParam2) {
        sendPacket(TransformUtils.getParamsSetPacket(f, FmuCmdConstant.SM_YAW_SCH_SEN), callbackWithOneParam2, true);
    }

    public void getYawStrokeSensitivity(CallbackWithOneParam<Float> callbackWithOneParam2) {
        sendPacket(TransformUtils.getParamsGetPacket(FmuCmdConstant.SM_YAW_SCH_SEN), callbackWithOneParam2);
    }

    public void setPitchAndRollSenCoefficient(float f, CallbackWithOneParam<Float> callbackWithOneParam2) {
        sendPacket(TransformUtils.getParamsSetPacket(SensitiveUtil2.coefficient2Sensitive(f), FmuCmdConstant.SM_PIT_ROLL_SEN), callbackWithOneParam2, true);
    }

    public void getPitchAndRollSenCoefficient(CallbackWithOneParam<Float> callbackWithOneParam2) {
        sendPacket(TransformUtils.getParamsGetPacket(FmuCmdConstant.SM_PIT_ROLL_SEN), callbackWithOneParam2);
    }

    public void setMaxHeight(float f, CallbackWithOneParam<Float> callbackWithOneParam2) {
        ParamsSetPacket paramsSetPacket;
        if (AircraftHeatBeatManager2.getInstance().getHeartBeatInfo().getVersionId() > 0) {
            paramsSetPacket = TransformUtils.getParamsSetPacket(f, "SM_Max_Height");
        } else {
            paramsSetPacket = TransformUtils.getParamsSetPacketT(f, "SM_Max_Height");
        }
        sendPacket(paramsSetPacket, callbackWithOneParam2, true);
    }

    public void queryMaxHeight(CallbackWithOneParam<Float> callbackWithOneParam2) {
        sendPacket(TransformUtils.getParamsGetPacket("SM_Max_Height"), callbackWithOneParam2);
    }

    public void setMaxRange(float f, CallbackWithOneParam<Float> callbackWithOneParam2) {
        ParamsSetPacket paramsSetPacket;
        if (AircraftHeatBeatManager2.getInstance().getHeartBeatInfo().getVersionId() > 0) {
            paramsSetPacket = TransformUtils.getParamsSetPacket(f, "SM_Max_Range");
        } else {
            paramsSetPacket = TransformUtils.getParamsSetPacketT(f, "SM_Max_Range");
        }
        sendPacket(paramsSetPacket, callbackWithOneParam2, true);
    }

    public void queryMaxRange(CallbackWithOneParam<Float> callbackWithOneParam2) {
        sendPacket(TransformUtils.getParamsGetPacket("SM_Max_Range"), callbackWithOneParam2);
    }

    public void setReturnHeight(float f, CallbackWithOneParam<Float> callbackWithOneParam2) {
        sendPacket(TransformUtils.getParamsSetPacket(f, "SM_RTH_Height"), callbackWithOneParam2, true);
    }

    public void queryReturnHeight(CallbackWithOneParam<Float> callbackWithOneParam2) {
        sendPacket(TransformUtils.getParamsGetPacket("SM_RTH_Height"), callbackWithOneParam2);
    }

    public void setHorizontalSpeed(float f, CallbackWithOneParam<Float> callbackWithOneParam2) {
        sendPacket(TransformUtils.getParamsSetPacket(f, "SM_Max_v_xy"), callbackWithOneParam2, true);
    }

    public void queryHorizontalSpeed(CallbackWithOneParam<Float> callbackWithOneParam2) {
        sendPacket(TransformUtils.getParamsGetPacket("SM_Max_v_xy"), callbackWithOneParam2);
    }

    public void setAscendSpeed(float f, CallbackWithOneParam<Float> callbackWithOneParam2) {
        sendPacket(TransformUtils.getParamsSetPacket(f, "SM_Max_v_z"), callbackWithOneParam2, true);
    }

    public void queryAscendSpeed(CallbackWithOneParam<Float> callbackWithOneParam2) {
        sendPacket(TransformUtils.getParamsGetPacket("SM_Max_v_z"), callbackWithOneParam2);
    }

    public void setDescendSpeed(float f, CallbackWithOneParam<Float> callbackWithOneParam2) {
        sendPacket(TransformUtils.getParamsSetPacket(f, "SM_Min_v_z"), callbackWithOneParam2, true);
    }

    public void queryDescendSpeed(CallbackWithOneParam<Float> callbackWithOneParam2) {
        sendPacket(TransformUtils.getParamsGetPacket("SM_Min_v_z"), callbackWithOneParam2);
    }

    public void setAttiModeSwitch(boolean z, CallbackWithOneParam<Boolean> callbackWithOneParam2) {
        sendPacket(TransformUtils.getParamsSetPacketT(z ? 1.0f : 0.0f, "SM_EN_ATT_MODE"), callbackWithOneParam2, true);
    }

    public void queryAttiModeSwitch(CallbackWithOneParam<Boolean> callbackWithOneParam2) {
        sendPacket(TransformUtils.getParamsGetPacket("SM_EN_ATT_MODE"), callbackWithOneParam2);
    }

    public void setYawSenCoefficient(float f, CallbackWithOneParam<Float> callbackWithOneParam2) {
        sendPacket(TransformUtils.getParamsSetPacket(SensitiveUtil2.coefficient2Sensitive(f), FmuCmdConstant.RC_YAW_SEN), callbackWithOneParam2, true);
    }

    public void queryYawSenCoefficient(CallbackWithOneParam<Float> callbackWithOneParam2) {
        sendPacket(TransformUtils.getParamsGetPacket(FmuCmdConstant.RC_YAW_SEN), callbackWithOneParam2);
    }

    public void checkNFZDigest(String str, String str2, CallbackWithOneParam<CommandInfoInternal> callbackWithOneParam2) {
        sendPacket(new CommonCmdRequest(TransformUtils.getRequestCmdParamBean(new FmuNFZParams(str, str2), FmuCmdConstant.MAV_CMD_CHECK_NFZ_DIGEST)), callbackWithOneParam2);
    }

    public void setFmuControllerLedlamp(LedPilotLamp ledPilotLamp, CallbackWithOneParam<CommandInfoInternal> callbackWithOneParam2) {
        sendPacket(new CommonCmdRequest(TransformUtils.getRequestCmdParamBean(new FmuCmdParams(ledPilotLamp.getValue()), FmuCmdConstant.MAV_CMD_CONTROL_LED)), callbackWithOneParam2);
    }

    public void startCalibrateCompass(CallbackWithOneParam<CommandInfoInternal> callbackWithOneParam2) {
        sendPacket(new CommonCmdRequest(TransformUtils.getRequestCmdBean(FmuCmdConstant.MAV_CMD_COMPASS_CALIBRATION)), callbackWithOneParam2);
    }

    public void openFmuUsb(CallbackWithOneParam<CommandInfoInternal> callbackWithOneParam2) {
        sendPacket(new CommonCmdRequest(TransformUtils.getRequestCmdBean(FmuCmdConstant.MAV_CMD_OPEN_USB)), callbackWithOneParam2);
    }

    public void getLedPilotLamp(CallbackWithOneParam<LedPilotInfo> callbackWithOneParam2) {
        sendPacket(new CommonCmdRequest(TransformUtils.getRequestCmdBean(FmuCmdConstant.MAV_CMD_GET_LED)), callbackWithOneParam2);
    }

    public void addGPSInfoListener(String str, CallbackWithOneParam<GPSInfoInternal> callbackWithOneParam2) {
        if (str != null && !TextUtils.isEmpty(str) && callbackWithOneParam2 != null) {
            PacketDisPatcher.getInstance().registerReceiveListener(REGISTER_MESSAGE_KEY, MsgType.AU_MAV_FMU_RAW_GPS, this);
            this.mGPSInfoListeners.put(str, callbackWithOneParam2);
        }
    }

    public void removeGPSInfoListener(String str) {
        if (str != null && !TextUtils.isEmpty(str)) {
            this.mGPSInfoListeners.remove(str);
            if (this.mGPSInfoListeners.isEmpty()) {
                PacketDisPatcher.getInstance().unRegisterReceiveListener(REGISTER_MESSAGE_KEY, MsgType.AU_MAV_FMU_RAW_GPS);
            }
        }
    }

    public void addAttitudeInfoListener(String str, CallbackWithOneParam<AttitudeInfoInternal> callbackWithOneParam2) {
        if (str != null && !TextUtils.isEmpty(str) && callbackWithOneParam2 != null) {
            PacketDisPatcher.getInstance().registerReceiveListener(REGISTER_MESSAGE_KEY, MsgType.AU_MAV_FMU_ATTITUDE, this);
            this.mAttitudeInfoListeners.put(str, callbackWithOneParam2);
        }
    }

    public void removeAttitudeInfoListener(String str) {
        if (str != null && !TextUtils.isEmpty(str)) {
            this.mAttitudeInfoListeners.remove(str);
            if (this.mAttitudeInfoListeners.isEmpty()) {
                PacketDisPatcher.getInstance().unRegisterReceiveListener(REGISTER_MESSAGE_KEY, MsgType.AU_MAV_FMU_ATTITUDE);
            }
        }
    }

    public void addIMUCalibrationStateListener(String str, CallbackWithOneParam<ImuCalibrationStateInfo> callbackWithOneParam2) {
        if (str != null && !TextUtils.isEmpty(str) && callbackWithOneParam2 != null) {
            PacketDisPatcher.getInstance().registerReceiveListener(REGISTER_MESSAGE_KEY, MsgType.AU_MAV_FMU_USER_CALIBRATION, this);
            this.mIMUStateListeners.put(str, callbackWithOneParam2);
        }
    }

    public void removeIMUCalibrationStateListener(String str) {
        if (str != null && !TextUtils.isEmpty(str)) {
            this.mIMUStateListeners.remove(str);
            if (this.mIMUStateListeners.isEmpty()) {
                PacketDisPatcher.getInstance().unRegisterReceiveListener(REGISTER_MESSAGE_KEY, MsgType.AU_MAV_FMU_USER_CALIBRATION);
            }
        }
    }

    public void addRTKInfoListener(String str, CallbackWithOneParam<byte[]> callbackWithOneParam2) {
        if (str != null && !TextUtils.isEmpty(str) && callbackWithOneParam2 != null) {
            this.mRTKDataListeners.put(str, callbackWithOneParam2);
        }
    }

    public void removeRTKInfoListener(String str) {
        if (str != null && !TextUtils.isEmpty(str)) {
            this.mRTKDataListeners.remove(str);
        }
    }

    public void addRTKReportListener(String str, CallbackWithOneParam<RtkIntenal> callbackWithOneParam2) {
        if (str != null && !TextUtils.isEmpty(str) && callbackWithOneParam2 != null) {
            PacketDisPatcher.getInstance().registerReceiveListener(REGISTER_MESSAGE_KEY, MsgType.AU_MAV_FMU_RTK_REPORT_INFO, this);
            this.mRTKReportListeners.put(str, callbackWithOneParam2);
        }
    }

    public void removeRTKReportListener(String str) {
        if (str != null && !TextUtils.isEmpty(str)) {
            this.mRTKReportListeners.remove(str);
            if (this.mRTKReportListeners.isEmpty()) {
                PacketDisPatcher.getInstance().unRegisterReceiveListener(REGISTER_MESSAGE_KEY, MsgType.AU_MAV_FMU_RTK_REPORT_INFO);
            }
        }
    }

    public void addLocalCoordinateInfoListener(String str, CallbackWithOneParam<LocalCoordinateInfoImpl> callbackWithOneParam2) {
        if (str != null && !TextUtils.isEmpty(str) && callbackWithOneParam2 != null) {
            PacketDisPatcher.getInstance().registerReceiveListener(REGISTER_MESSAGE_KEY, MsgType.AU_MAV_FMU_LOCAL_POSITION_NED, this);
            this.mLocalCoordinateInfoListeners.put(str, callbackWithOneParam2);
        }
    }

    public void removeLocalCoordinateInfoListener(String str) {
        if (str != null && !TextUtils.isEmpty(str)) {
            this.mLocalCoordinateInfoListeners.remove(str);
            if (this.mLocalCoordinateInfoListeners.isEmpty()) {
                PacketDisPatcher.getInstance().unRegisterReceiveListener(REGISTER_MESSAGE_KEY, MsgType.AU_MAV_FMU_LOCAL_POSITION_NED);
            }
        }
    }

    public void addImuStatusListener(String str, CallbackWithOneParam<ImuStateInfoImpl> callbackWithOneParam2) {
        if (str != null && callbackWithOneParam2 != null) {
            PacketDisPatcher.getInstance().registerReceiveListener(REGISTER_MESSAGE_KEY, MsgType.AU_MAV_FMU_HEIGHT_IMU, this);
            this.mFmuImuListeners.put(str, callbackWithOneParam2);
        }
    }

    public void removeImuStatusListener(String str) {
        if (str != null) {
            this.mFmuImuListeners.remove(str);
            if (this.mFmuImuListeners.isEmpty()) {
                PacketDisPatcher.getInstance().unRegisterReceiveListener(REGISTER_MESSAGE_KEY, MsgType.AU_MAV_FMU_HEIGHT_IMU);
            }
        }
    }

    public void addFmuParameterListener(String str, CallbackWithTwoParams<FmuParameterEvent, Float> callbackWithTwoParams) {
        if (str != null && callbackWithTwoParams != null) {
            this.mFmuParameterEvents.put(str, callbackWithTwoParams);
        }
    }

    public void removeFmuParameterListener(String str) {
        if (str != null) {
            this.mFmuParameterEvents.remove(str);
        }
    }

    public void getRtkAuthenInfo(CallbackWithOneParam<AuthenInfo> callbackWithOneParam2) {
        sendPacket(new CommonCmdRequest(TransformUtils.getRequestCmdBean(FmuCmdConstant.MAV_CMD_GET_RTK_AUTH_INFO)), callbackWithOneParam2);
    }

    public void setUseRTK(boolean z, CallbackWithOneParam<Integer> callbackWithOneParam2) {
        sendPacket(TransformUtils.getParamsSetPacketT(z ? 1.0f : 0.0f, FmuCmdConstant.SM_RTK_USED), callbackWithOneParam2, true);
    }

    public void getUseRTK(CallbackWithOneParam<Integer> callbackWithOneParam2) {
        sendPacket(TransformUtils.getParamsGetPacket(FmuCmdConstant.SM_RTK_USED), callbackWithOneParam2);
    }

    public void setRTKCoordinateSys(int i, CallbackWithOneParam<Integer> callbackWithOneParam2) {
        sendPacket(TransformUtils.getParamsSetPacketT((float) i, FmuCmdConstant.SM_RTK_CO_SYS), callbackWithOneParam2, true);
    }

    public void getRTKCoordinateSys(CallbackWithOneParam<Integer> callbackWithOneParam2) {
        sendPacket(TransformUtils.getParamsGetPacket(FmuCmdConstant.SM_RTK_CO_SYS), callbackWithOneParam2);
    }

    public void setRTKRecvType(int i, CallbackWithOneParam<Integer> callbackWithOneParam2) {
        sendPacket(TransformUtils.getParamsSetPacketT((float) i, FmuCmdConstant.RECV_RTK_TYPE), callbackWithOneParam2, true);
    }

    public void getRTKRecvType(CallbackWithOneParam<Integer> callbackWithOneParam2) {
        sendPacket(TransformUtils.getParamsGetPacket(FmuCmdConstant.RECV_RTK_TYPE), callbackWithOneParam2);
    }

    /* access modifiers changed from: protected */
    public void checkTimeOut() {
        super.checkTimeOut();
    }

    /* access modifiers changed from: protected */
    public Integer getTimeOutItem(BaseMsgPacket baseMsgPacket) {
        return Integer.valueOf(baseMsgPacket.getType());
    }

    public void init() {
        PacketDisPatcher.getInstance().registerReceiveListener(REGISTER_MESSAGE_KEY, 263, this);
        PacketDisPatcher.getInstance().registerReceiveListener(REGISTER_MESSAGE_KEY, 267, this);
        PacketDisPatcher.getInstance().registerReceiveListener(REGISTER_MESSAGE_KEY, MsgType.AU_MAV_FLIGHT_CONTROL_ACK, this);
        PacketDisPatcher.getInstance().registerReceiveListener(REGISTER_MESSAGE_KEY, MsgType.AU_MAV_FMU_RTK_DATA, this);
    }

    public void destroy() {
        super.destroy();
        PacketDisPatcher.getInstance().unRegisterReceiveListener(REGISTER_MESSAGE_KEY, 263);
        PacketDisPatcher.getInstance().unRegisterReceiveListener(REGISTER_MESSAGE_KEY, 267);
        PacketDisPatcher.getInstance().unRegisterReceiveListener(REGISTER_MESSAGE_KEY, MsgType.AU_MAV_FMU_LOCAL_POSITION_NED);
        PacketDisPatcher.getInstance().unRegisterReceiveListener(REGISTER_MESSAGE_KEY, MsgType.AU_MAV_FMU_ATTITUDE);
        PacketDisPatcher.getInstance().unRegisterReceiveListener(REGISTER_MESSAGE_KEY, MsgType.AU_MAV_FMU_RAW_GPS);
        PacketDisPatcher.getInstance().unRegisterReceiveListener(REGISTER_MESSAGE_KEY, MsgType.AU_MAV_FMU_HEIGHT_IMU);
        PacketDisPatcher.getInstance().unRegisterReceiveListener(REGISTER_MESSAGE_KEY, MsgType.AU_MAV_FLIGHT_CONTROL_ACK);
        PacketDisPatcher.getInstance().unRegisterReceiveListener(REGISTER_MESSAGE_KEY, MsgType.AU_MAV_FMU_RTK_DATA);
        this.mGPSInfoListeners.clear();
        this.mAttitudeInfoListeners.clear();
        this.mLocalCoordinateInfoListeners.clear();
        this.mFmuImuListeners.clear();
        this.mIMUStateListeners.clear();
    }

    public void onReceiveMessage(BaseMsgPacket baseMsgPacket) {
        CallbackWithOneParam<Boolean> callbackWithOneParam2;
        if (baseMsgPacket instanceof GPSInfoPacket) {
            iteratorCallback(this.mGPSInfoListeners, ((GPSInfoPacket) baseMsgPacket).getGPSInfo());
        } else if (baseMsgPacket instanceof AttitudePacket) {
            iteratorCallback(this.mAttitudeInfoListeners, ((AttitudePacket) baseMsgPacket).getAttitudeInfo());
        } else if (baseMsgPacket instanceof LocalCoordinateInfoPacket) {
            iteratorCallback(this.mLocalCoordinateInfoListeners, ((LocalCoordinateInfoPacket) baseMsgPacket).getLocalCoordinateInfo());
        } else if (baseMsgPacket instanceof IMUCalibrationStatusPacket) {
            iteratorCallback(this.mIMUStateListeners, ((IMUCalibrationStatusPacket) baseMsgPacket).getImuCalibrationStateInfo());
        } else if (baseMsgPacket instanceof IMUStatusPacket) {
            iteratorCallback(this.mFmuImuListeners, ((IMUStatusPacket) baseMsgPacket).getImuStatusInfo());
        } else if (baseMsgPacket instanceof RtkDataPacket) {
            iteratorCallback(this.mRTKDataListeners, ((RtkDataPacket) baseMsgPacket).getData());
        } else if (baseMsgPacket instanceof RtkInfoReportPacket) {
            iteratorCallback(this.mRTKReportListeners, ((RtkInfoReportPacket) baseMsgPacket).getRtkIntenal());
        } else if (baseMsgPacket instanceof CommandAckPacket) {
            processCommandAckPacket((CommandAckPacket) baseMsgPacket);
        } else if (baseMsgPacket instanceof ParamsAckPacket) {
            processParamsPacket((ParamsAckPacket) baseMsgPacket);
        } else if ((baseMsgPacket instanceof FlightControlPacket) && (callbackWithOneParam2 = this.callbackWithOneParam) != null) {
            callbackWithOneParam2.onSuccess(Boolean.valueOf(((FlightControlPacket) baseMsgPacket).isSuccess()));
        }
    }

    private void processCommandAckPacket(CommandAckPacket commandAckPacket) {
        CommandInfoInternal commandInfoInternal;
        if (commandAckPacket != null && (commandInfoInternal = commandAckPacket.getCommandInfoInternal()) != null) {
            int type = commandAckPacket.getType();
            if (((CallbackWithOneParam) this.mListeners.get(Integer.valueOf(type))) != null) {
                callbackSucc(type, commandInfoInternal);
            }
        }
    }

    private void processParamsPacket(ParamsAckPacket paramsAckPacket) {
        ParamsAckInfo paramsAckInfo;
        Object obj;
        int type = paramsAckPacket.getType();
        String paramId = paramsAckPacket.getParamsAckInfo().getParamId();
        ConcurrentHashMap<String, CallbackWithTwoParams<FmuParameterEvent, Float>> concurrentHashMap = this.mFmuParameterEvents;
        if (concurrentHashMap != null && concurrentHashMap.size() > 0) {
            iteratorCallback(this.mFmuParameterEvents, FmuParameterEvent.find(paramId), Float.valueOf(paramsAckPacket.getParamsAckInfo().getParamValue()));
        }
        if (((CallbackWithOneParam) this.mListeners.get(Integer.valueOf(type))) != null && (paramsAckInfo = paramsAckPacket.getParamsAckInfo()) != null) {
            float paramValue = paramsAckInfo.getParamValue();
            if (type == getHashCode("SM_Beginner_Mode")) {
                obj = BeginnerMode.find((int) paramValue);
            } else if (type == getHashCode("SM_SDLOG_SEN")) {
                obj = Integer.valueOf((int) paramValue);
            } else if (type == getHashCode("SM_Max_Height") || type == getHashCode("SM_Max_Range") || type == getHashCode("SM_RTH_Height") || type == getHashCode("SM_Max_v_xy") || type == getHashCode("SM_Max_v_z") || type == getHashCode("SM_Min_v_z") || type == getHashCode(FmuCmdConstant.SM_ATT_SEN) || type == getHashCode(FmuCmdConstant.SM_BRAKE_SEN) || type == getHashCode(FmuCmdConstant.SM_YAW_SCH_SEN)) {
                obj = Float.valueOf(paramValue);
            } else if (type == getHashCode("SM_EN_ATT_MODE")) {
                obj = Boolean.valueOf(paramValue == 1.0f);
            } else if (type == getHashCode(FmuCmdConstant.SM_RTK_USED) || type == getHashCode(FmuCmdConstant.SM_RTK_CO_SYS) || type == getHashCode(FmuCmdConstant.RECV_RTK_TYPE)) {
                obj = Integer.valueOf((int) paramValue);
            } else if (type == getHashCode(FmuCmdConstant.RC_YAW_SEN) || type == getHashCode(FmuCmdConstant.SM_THRUST_SEN) || type == getHashCode(FmuCmdConstant.SM_PIT_ROLL_SEN)) {
                obj = Float.valueOf((float) SensitiveUtil2.sensitive2Coefficient(paramValue));
            } else {
                return;
            }
            callbackSucc(type, obj);
        }
    }

    private int getHashCode(String str) {
        if (str == null || TextUtils.isEmpty(str)) {
            return 0;
        }
        return str.hashCode();
    }

    public LedPilotLamp parseLedPilotLamp(int i) {
        return LedPilotLamp.find((i >> 20) & 3);
    }
}

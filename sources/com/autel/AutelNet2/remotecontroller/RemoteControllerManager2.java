package com.autel.AutelNet2.remotecontroller;

import com.autel.AutelNet2.constant.MsgType;
import com.autel.AutelNet2.core.BaseController;
import com.autel.AutelNet2.core.PacketDisPatcher;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.remotecontroller.engine.CustomKeyInfo;
import com.autel.AutelNet2.remotecontroller.message.RCAckToTeachInfoPacket;
import com.autel.AutelNet2.remotecontroller.message.RCCalibrationPacket;
import com.autel.AutelNet2.remotecontroller.message.RCCommandStickModePacket;
import com.autel.AutelNet2.remotecontroller.message.RCGimbalAnglePacket;
import com.autel.AutelNet2.remotecontroller.message.RCGimbalWheelAdjustSpeedPacket;
import com.autel.AutelNet2.remotecontroller.message.RCInfoPacket;
import com.autel.AutelNet2.remotecontroller.message.RCLanguagePacket;
import com.autel.AutelNet2.remotecontroller.message.RCLengthUnitPacket;
import com.autel.AutelNet2.remotecontroller.message.RCMsgPacket;
import com.autel.AutelNet2.remotecontroller.message.RCPairModePacket;
import com.autel.AutelNet2.remotecontroller.message.RCRFPowerPacket;
import com.autel.AutelNet2.remotecontroller.message.RCStickCalibratePacket;
import com.autel.AutelNet2.remotecontroller.message.RCTeachStuModePacket;
import com.autel.AutelNet2.remotecontroller.message.RCUploadDataPacket;
import com.autel.AutelNet2.remotecontroller.message.RCUploadPhoneCompassAnglePacket;
import com.autel.AutelNet2.remotecontroller.message.RCVersionDataPacket;
import com.autel.AutelNet2.remotecontroller.message.RCresetWifiPacket;
import com.autel.AutelNet2.remotecontroller.message.RcGetCustomKeyPacket;
import com.autel.AutelNet2.remotecontroller.message.RcSetCustomKeyPacket;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.remotecontroller.CustomFunction;
import com.autel.common.remotecontroller.CustomKey;
import com.autel.common.remotecontroller.RFPower;
import com.autel.common.remotecontroller.RemoteControllerCommandStickMode;
import com.autel.common.remotecontroller.RemoteControllerLanguage;
import com.autel.common.remotecontroller.RemoteControllerPairState;
import com.autel.common.remotecontroller.RemoteControllerParameterUnit;
import com.autel.common.remotecontroller.RemoteControllerStickCalibration;
import com.autel.common.remotecontroller.TeachingMode;
import java.util.concurrent.ConcurrentHashMap;

public class RemoteControllerManager2 extends BaseController<Integer> {
    private static final String REGISTER_MESSAGE_KEY = "RemoteController";
    private static final short REGISTER_MESSAGE_TYPE = 1027;
    private static final String TAG = "RemoteController";
    private static RemoteControllerManager2 instance_;
    private final ConcurrentHashMap<String, CallbackWithOneParam<Integer>> mRCGimbalAngleDataListeners = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, CallbackWithOneParam<int[]>> mRCInfoDataListeners = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, CallbackWithOneParam<int[]>> mRCUploadDataListeners = new ConcurrentHashMap<>();

    public static synchronized RemoteControllerManager2 getInstance() {
        RemoteControllerManager2 remoteControllerManager2;
        synchronized (RemoteControllerManager2.class) {
            if (instance_ == null) {
                instance_ = new RemoteControllerManager2();
            }
            remoteControllerManager2 = instance_;
        }
        return remoteControllerManager2;
    }

    private RemoteControllerManager2() {
        init();
    }

    public void init() {
        PacketDisPatcher.getInstance().registerReceiveListener("RemoteController", 1027, this);
        PacketDisPatcher.getInstance().registerReceiveListener("RemoteController", MsgType.AU_CUSTOM_BUTTON_SET_FUNC, this);
        PacketDisPatcher.getInstance().registerReceiveListener("RemoteController", MsgType.AU_CUSTOM_BUTTON_GET_FUNC, this);
        RemoteControllerButtonManager2.getInstance().init();
    }

    public void destroy() {
        super.destroy();
        this.mListeners.clear();
        this.mRCInfoDataListeners.clear();
        this.mRCGimbalAngleDataListeners.clear();
        this.mRCUploadDataListeners.clear();
        PacketDisPatcher.getInstance().unRegisterReceiveListener("RemoteController", MsgType.AU_CUSTOM_BUTTON_SET_FUNC);
        PacketDisPatcher.getInstance().unRegisterReceiveListener("RemoteController", MsgType.AU_CUSTOM_BUTTON_GET_FUNC);
    }

    public void registeRCInfoDataCallback(String str, CallbackWithOneParam<int[]> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.mRCInfoDataListeners.put(str, callbackWithOneParam);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0023, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0028, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void unRegisteRCInfoDataCallback(java.lang.String r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            if (r3 == 0) goto L_0x0027
            boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0024 }
            if (r0 == 0) goto L_0x000a
            goto L_0x0027
        L_0x000a:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.autel.common.CallbackWithOneParam<int[]>> r0 = r2.mRCInfoDataListeners     // Catch:{ all -> 0x0024 }
            r0.remove(r3)     // Catch:{ all -> 0x0024 }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.autel.common.CallbackWithOneParam<int[]>> r3 = r2.mRCInfoDataListeners     // Catch:{ all -> 0x0024 }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x0024 }
            if (r3 == 0) goto L_0x0022
            com.autel.AutelNet2.core.PacketDisPatcher r3 = com.autel.AutelNet2.core.PacketDisPatcher.getInstance()     // Catch:{ all -> 0x0024 }
            java.lang.String r0 = "RemoteController"
            r1 = 1027(0x403, float:1.439E-42)
            r3.unRegisterReceiveListener(r0, r1)     // Catch:{ all -> 0x0024 }
        L_0x0022:
            monitor-exit(r2)
            return
        L_0x0024:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        L_0x0027:
            monitor-exit(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autel.AutelNet2.remotecontroller.RemoteControllerManager2.unRegisteRCInfoDataCallback(java.lang.String):void");
    }

    public void registeRCGimbalAngleDataCallback(String str, CallbackWithOneParam<Integer> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.mRCGimbalAngleDataListeners.put(str, callbackWithOneParam);
        }
    }

    public void unRegistRCGimbalAngleDataCallback(String str) {
        this.mRCGimbalAngleDataListeners.remove(str);
    }

    public void registeRCUploadDataCallback(String str, CallbackWithOneParam<int[]> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            setUploadRemoteData(true);
            this.mRCUploadDataListeners.put(str, callbackWithOneParam);
        }
    }

    public void unRegistRCUploadDataCallback(String str) {
        this.mRCUploadDataListeners.remove(str);
        if (this.mRCUploadDataListeners.size() == 0) {
            setUploadRemoteData(false);
        }
    }

    public void setRCLanguage(RemoteControllerLanguage remoteControllerLanguage, CallbackWithOneParam<Boolean> callbackWithOneParam) {
        RCLanguagePacket rCLanguagePacket = new RCLanguagePacket();
        rCLanguagePacket.setLanguage(remoteControllerLanguage);
        sendPacket(rCLanguagePacket, callbackWithOneParam);
    }

    public void queryRCLanguage(CallbackWithOneParam<RemoteControllerLanguage> callbackWithOneParam) {
        sendPacket(new RCLanguagePacket(), callbackWithOneParam);
    }

    public void setGimbalWheelAdjustSpeed(int i, CallbackWithOneParam<Boolean> callbackWithOneParam) {
        RCGimbalWheelAdjustSpeedPacket rCGimbalWheelAdjustSpeedPacket = new RCGimbalWheelAdjustSpeedPacket();
        rCGimbalWheelAdjustSpeedPacket.setSpeed(i);
        sendPacket(rCGimbalWheelAdjustSpeedPacket, callbackWithOneParam);
    }

    public void queryGimbalWheelAdjustSpeed(CallbackWithOneParam<Integer> callbackWithOneParam) {
        sendPacket(new RCGimbalWheelAdjustSpeedPacket(), callbackWithOneParam);
    }

    public void startRCBinding(CallbackWithOneParam<Boolean> callbackWithOneParam) {
        RCPairModePacket rCPairModePacket = new RCPairModePacket();
        rCPairModePacket.setRCBind(true);
        sendPacket(rCPairModePacket, callbackWithOneParam);
    }

    public void queryRCBindMode(CallbackWithOneParam<RemoteControllerPairState> callbackWithOneParam) {
        sendPacket(new RCPairModePacket(), callbackWithOneParam);
    }

    public void setRFPower(RFPower rFPower, CallbackWithOneParam<Boolean> callbackWithOneParam) {
        RCRFPowerPacket rCRFPowerPacket = new RCRFPowerPacket();
        rCRFPowerPacket.setRFPower(rFPower);
        sendPacket(rCRFPowerPacket, callbackWithOneParam);
    }

    public void queryRFPower(CallbackWithOneParam<RFPower> callbackWithOneParam) {
        sendPacket(new RCRFPowerPacket(), callbackWithOneParam);
    }

    public void setTeacherStudentMode(TeachingMode teachingMode, CallbackWithOneParam<Boolean> callbackWithOneParam) {
        RCTeachStuModePacket rCTeachStuModePacket = new RCTeachStuModePacket();
        rCTeachStuModePacket.setTeachStuMode(teachingMode);
        sendPacket(rCTeachStuModePacket, callbackWithOneParam);
    }

    public void queryTeacherStudentMode(CallbackWithOneParam<TeachingMode> callbackWithOneParam) {
        sendPacket(new RCTeachStuModePacket(), callbackWithOneParam);
    }

    public void SetGimbalAngle(int i) {
        RCGimbalAnglePacket rCGimbalAnglePacket = new RCGimbalAnglePacket();
        rCGimbalAnglePacket.setAngle(i);
        sendPacket(rCGimbalAnglePacket, (CallbackWithOneParam) null);
    }

    public void QueryGimbalAngle() {
        sendPacket(new RCGimbalAnglePacket(), (CallbackWithOneParam) null);
    }

    public void setRCCalibrationStep(RemoteControllerStickCalibration remoteControllerStickCalibration, CallbackWithOneParam<int[]> callbackWithOneParam) {
        RCCalibrationPacket rCCalibrationPacket = new RCCalibrationPacket();
        rCCalibrationPacket.setStep(remoteControllerStickCalibration);
        sendPacket(rCCalibrationPacket, callbackWithOneParam);
    }

    public void setUploadRemoteData(boolean z) {
        RCUploadDataPacket rCUploadDataPacket = new RCUploadDataPacket();
        rCUploadDataPacket.setMode(z ? 1 : 0);
        sendPacket(rCUploadDataPacket, (CallbackWithOneParam) null);
    }

    public void queryRCVersionData(CallbackWithOneParam<int[]> callbackWithOneParam) {
        sendPacket(new RCVersionDataPacket(), callbackWithOneParam);
    }

    public void setRCLengthUnit(RemoteControllerParameterUnit remoteControllerParameterUnit, CallbackWithOneParam<Boolean> callbackWithOneParam) {
        RCLengthUnitPacket rCLengthUnitPacket = new RCLengthUnitPacket();
        rCLengthUnitPacket.setLengthUnit(remoteControllerParameterUnit);
        sendPacket(rCLengthUnitPacket, callbackWithOneParam);
    }

    public void queryRCLengthUnit(CallbackWithOneParam<RemoteControllerParameterUnit> callbackWithOneParam) {
        sendPacket(new RCLengthUnitPacket(), callbackWithOneParam);
    }

    public void setRCCommandStickMode(RemoteControllerCommandStickMode remoteControllerCommandStickMode, CallbackWithOneParam<Boolean> callbackWithOneParam) {
        RCCommandStickModePacket rCCommandStickModePacket = new RCCommandStickModePacket();
        rCCommandStickModePacket.setCommandStickMode(remoteControllerCommandStickMode);
        sendPacket(rCCommandStickModePacket, callbackWithOneParam);
    }

    public void queryRCCommandStickMode(CallbackWithOneParam<RemoteControllerCommandStickMode> callbackWithOneParam) {
        sendPacket(new RCCommandStickModePacket(), callbackWithOneParam);
    }

    public void queryRCStickCalibrateStatus(CallbackWithOneParam<RemoteControllerStickCalibration> callbackWithOneParam) {
        sendPacket(new RCStickCalibratePacket(), callbackWithOneParam);
    }

    public void resetWifi(CallbackWithOneParam<Boolean> callbackWithOneParam) {
        sendPacket(new RCresetWifiPacket(), callbackWithOneParam);
    }

    public void uploadPhoneCompassAngle(int i) {
        RCUploadPhoneCompassAnglePacket rCUploadPhoneCompassAnglePacket = new RCUploadPhoneCompassAnglePacket();
        rCUploadPhoneCompassAnglePacket.setPhoneCompassAngle(i);
        sendPacket(rCUploadPhoneCompassAnglePacket, (CallbackWithOneParam) null);
    }

    public void ackToTeachInfo() {
        sendPacket(new RCAckToTeachInfoPacket(), (CallbackWithOneParam) null);
    }

    public void setCustomKey(CustomKey customKey, CustomFunction customFunction, CallbackWithOneParam<Boolean> callbackWithOneParam) {
        RcSetCustomKeyPacket rcSetCustomKeyPacket = new RcSetCustomKeyPacket();
        rcSetCustomKeyPacket.setCustomKey(customKey.getValue());
        rcSetCustomKeyPacket.setCustomFunction(customFunction.getValue());
        sendPacket(rcSetCustomKeyPacket, callbackWithOneParam);
    }

    public void getCustomKey(CallbackWithOneParam<CustomKeyInfo> callbackWithOneParam) {
        sendPacket(new RcGetCustomKeyPacket(), callbackWithOneParam);
    }

    public void onReceiveMessage(BaseMsgPacket baseMsgPacket) {
        if (baseMsgPacket != null) {
            if (baseMsgPacket.getHead().msg_type == 1027) {
                reportMessage((RCMsgPacket) baseMsgPacket);
            } else if (baseMsgPacket instanceof RcSetCustomKeyPacket) {
                callbackSucc(baseMsgPacket.getType(), Boolean.valueOf(((RcSetCustomKeyPacket) baseMsgPacket).isSuc()));
            } else if (baseMsgPacket instanceof RcGetCustomKeyPacket) {
                callbackSucc(baseMsgPacket.getType(), ((RcGetCustomKeyPacket) baseMsgPacket).getCustomKeyInfo());
            }
        }
    }

    private void reportMessage(RCMsgPacket rCMsgPacket) {
        int type = rCMsgPacket.getType();
        if (type == 15) {
            disPatchMessage(type, ((RCInfoPacket) rCMsgPacket).getInfo());
        } else if (type == 12) {
            disPatchMessage(type, Integer.valueOf(((RCGimbalAnglePacket) rCMsgPacket).getAngle()));
        } else if (type == 14) {
            disPatchMessage(type, ((RCUploadDataPacket) rCMsgPacket).getInfo());
        } else if (((CallbackWithOneParam) this.mListeners.get(Integer.valueOf(type))) == null) {
        } else {
            if (type == 13) {
                callbackSucc(type, new int[]{((RCCalibrationPacket) rCMsgPacket).getResultData().getValue()});
            } else if (type != 25) {
                switch (type) {
                    case 1:
                        callbackSucc(type, Boolean.valueOf(((RCGimbalWheelAdjustSpeedPacket) rCMsgPacket).isSucc()));
                        return;
                    case 2:
                        callbackSucc(type, Integer.valueOf(((RCGimbalWheelAdjustSpeedPacket) rCMsgPacket).getSpeed()));
                        return;
                    case 3:
                        callbackSucc(type, Boolean.valueOf(((RCLanguagePacket) rCMsgPacket).isSetLanguageSucc()));
                        return;
                    case 4:
                        callbackSucc(type, ((RCLanguagePacket) rCMsgPacket).getLanguage());
                        return;
                    case 5:
                        callbackSucc(type, Boolean.valueOf(((RCPairModePacket) rCMsgPacket).isRCBindSucc()));
                        return;
                    case 6:
                        callbackSucc(type, ((RCPairModePacket) rCMsgPacket).getPairMode());
                        return;
                    case 7:
                        callbackSucc(type, Boolean.valueOf(((RCRFPowerPacket) rCMsgPacket).isRFPowerSetSucc()));
                        return;
                    case 8:
                        callbackSucc(type, ((RCRFPowerPacket) rCMsgPacket).getRFPower());
                        return;
                    case 9:
                        callbackSucc(type, Boolean.valueOf(((RCTeachStuModePacket) rCMsgPacket).isSetTeachStuModeSucc()));
                        return;
                    case 10:
                        callbackSucc(type, ((RCTeachStuModePacket) rCMsgPacket).getMode());
                        return;
                    default:
                        switch (type) {
                            case 16:
                                callbackSucc(type, ((RCVersionDataPacket) rCMsgPacket).getVersion());
                                return;
                            case 17:
                                callbackSucc(type, Boolean.valueOf(((RCLengthUnitPacket) rCMsgPacket).isSetUnitSucc()));
                                return;
                            case 18:
                                callbackSucc(type, Boolean.valueOf(((RCCommandStickModePacket) rCMsgPacket).isSetModeSucc()));
                                return;
                            case 19:
                                callbackSucc(type, ((RCCommandStickModePacket) rCMsgPacket).getMode());
                                return;
                            case 20:
                                callbackSucc(type, ((RCLengthUnitPacket) rCMsgPacket).getRCLengthUnit());
                                return;
                            case 21:
                                callbackSucc(type, Boolean.valueOf(((RCresetWifiPacket) rCMsgPacket).isResetSucc()));
                                return;
                            default:
                                return;
                        }
                }
            } else {
                callbackSucc(type, ((RCStickCalibratePacket) rCMsgPacket).getRemoteControllerStickCalibration());
            }
        }
    }

    private void disPatchMessage(int i, Object obj) {
        if (i == 12) {
            iteratorCallback(this.mRCGimbalAngleDataListeners, obj);
        } else if (i == 14) {
            iteratorCallback(this.mRCUploadDataListeners, obj);
        } else if (i == 15) {
            iteratorCallback(this.mRCInfoDataListeners, obj);
        }
    }

    /* access modifiers changed from: protected */
    public void checkTimeOut() {
        super.checkTimeOut();
    }

    /* access modifiers changed from: protected */
    public Integer getTimeOutItem(BaseMsgPacket baseMsgPacket) {
        return Integer.valueOf(baseMsgPacket.getType());
    }
}

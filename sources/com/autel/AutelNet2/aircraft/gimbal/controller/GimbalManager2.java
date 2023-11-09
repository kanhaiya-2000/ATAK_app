package com.autel.AutelNet2.aircraft.gimbal.controller;

import android.util.Log;
import com.autel.AutelNet2.aircraft.flycontroller.message.GimbalPryAnglePacket;
import com.autel.AutelNet2.aircraft.gimbal.engine.GimbalAngle;
import com.autel.AutelNet2.aircraft.gimbal.engine.GimbalAngleRangeImpl;
import com.autel.AutelNet2.aircraft.gimbal.engine.GimbalCmdInfo;
import com.autel.AutelNet2.aircraft.gimbal.engine.GimbalCmdType;
import com.autel.AutelNet2.aircraft.gimbal.message.GimbalAngleRangeAckPacket;
import com.autel.AutelNet2.aircraft.gimbal.message.GimbalAngleSetPacket;
import com.autel.AutelNet2.aircraft.gimbal.message.GimbalAngleSpeedPacket;
import com.autel.AutelNet2.aircraft.gimbal.message.GimbalCmdAckPacket;
import com.autel.AutelNet2.aircraft.gimbal.message.GimbalCmdPacket;
import com.autel.AutelNet2.constant.MsgType;
import com.autel.AutelNet2.core.BaseController;
import com.autel.AutelNet2.core.PacketDisPatcher;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.gimbal.GimbalAxisType;
import com.autel.common.gimbal.GimbalWorkMode;
import com.autel.common.gimbal.evo.GimbalAngleData;
import com.autel.common.gimbal.evo.GimbalAngleSpeed;
import java.util.concurrent.ConcurrentHashMap;

public class GimbalManager2 extends BaseController<Integer> {
    private static final short REGISTER_AU_MAV_GIMBAL_CMD_ACK = 331;
    private static final String REGISTER_MESSAGE_KEY = "GimbalManager2";
    private static final String TAG = "GimbalManager2";
    private static GimbalManager2 instance_;
    private CallbackWithOneParam<GimbalAngleRangeImpl> angleRangeallbackWithOneParam;
    private final ConcurrentHashMap<String, CallbackWithOneParam<GimbalAngle>> mFCGimbalAngleListeners = new ConcurrentHashMap<>();

    public static synchronized GimbalManager2 getInstance() {
        GimbalManager2 gimbalManager2;
        synchronized (GimbalManager2.class) {
            if (instance_ == null) {
                instance_ = new GimbalManager2();
            }
            gimbalManager2 = instance_;
        }
        return gimbalManager2;
    }

    private GimbalManager2() {
        init();
    }

    public void addGimbalAngleListener(String str, CallbackWithOneParam<GimbalAngle> callbackWithOneParam) {
        if (str != null && callbackWithOneParam != null) {
            this.mFCGimbalAngleListeners.put(str, callbackWithOneParam);
        }
    }

    public void setGimbalAngle(GimbalAngleData gimbalAngleData) {
        sendPacket(new GimbalAngleSetPacket(gimbalAngleData), (CallbackWithOneParam) null);
    }

    public void setGimbalAngleSpeed(GimbalAngleSpeed gimbalAngleSpeed) {
        sendPacket(new GimbalAngleSpeedPacket(gimbalAngleSpeed), (CallbackWithOneParam) null);
    }

    public void removeGimbalAngleListener(String str) {
        if (str != null) {
            this.mFCGimbalAngleListeners.remove(str);
        }
    }

    public void setGimbalLimitUpward(boolean z, CallbackWithOneParam<GimbalCmdInfo> callbackWithOneParam) {
        GimbalCmdPacket gimbalCmdPacket = new GimbalCmdPacket();
        gimbalCmdPacket.setCommand(GimbalCmdType.CMD_SET_PITCH_LIMIT_UPWARD);
        gimbalCmdPacket.setData(z ? 1 : 0);
        sendPacket(gimbalCmdPacket, callbackWithOneParam);
    }

    public void getGimbalLimitUpward(CallbackWithOneParam<GimbalCmdInfo> callbackWithOneParam) {
        GimbalCmdPacket gimbalCmdPacket = new GimbalCmdPacket();
        gimbalCmdPacket.setCommand(GimbalCmdType.CMD_GET_PITCH_LIMIT_UPWARD);
        sendPacket(gimbalCmdPacket, callbackWithOneParam);
    }

    public void setGimbalWorkMode(GimbalWorkMode gimbalWorkMode, CallbackWithOneParam<GimbalCmdInfo> callbackWithOneParam) {
        GimbalCmdPacket gimbalCmdPacket = new GimbalCmdPacket();
        gimbalCmdPacket.setCommand(GimbalCmdType.SET_MODE);
        gimbalCmdPacket.setData(gimbalWorkMode.getValue20());
        sendPacket(gimbalCmdPacket, callbackWithOneParam);
    }

    public void queryGimbalWorkMode(CallbackWithOneParam<GimbalCmdInfo> callbackWithOneParam) {
        GimbalCmdPacket gimbalCmdPacket = new GimbalCmdPacket();
        gimbalCmdPacket.setCommand(GimbalCmdType.QUERY_MODE);
        sendPacket(gimbalCmdPacket, callbackWithOneParam);
    }

    public void queryGimbalAngleRange(CallbackWithOneParam<GimbalAngleRangeImpl> callbackWithOneParam) {
        this.angleRangeallbackWithOneParam = callbackWithOneParam;
        GimbalCmdPacket gimbalCmdPacket = new GimbalCmdPacket();
        gimbalCmdPacket.setCommand(GimbalCmdType.RANGE);
        sendPacket(gimbalCmdPacket, (CallbackWithOneParam) null);
    }

    public void setRollAdjustData(int i, CallbackWithOneParam<GimbalCmdInfo> callbackWithOneParam) {
        Log.d("GimbalManager2", "setRollAdjustData " + i);
        GimbalCmdPacket gimbalCmdPacket = new GimbalCmdPacket();
        gimbalCmdPacket.setCommand(GimbalCmdType.SET_GIMBAL_ADJUSTMENT);
        gimbalCmdPacket.setRollData(i);
        sendPacket(gimbalCmdPacket, (CallbackWithOneParam) null);
    }

    public void setYawAdjustData(int i, CallbackWithOneParam<GimbalCmdInfo> callbackWithOneParam) {
        Log.d("GimbalManager2", "setRollAdjustData " + i);
        GimbalCmdPacket gimbalCmdPacket = new GimbalCmdPacket();
        gimbalCmdPacket.setCommand(GimbalCmdType.SET_GIMBAL_ADJUSTMENT);
        gimbalCmdPacket.setYawData(i);
        sendPacket(gimbalCmdPacket, (CallbackWithOneParam) null);
    }

    public void setSaveParams(CallbackWithOneParam<GimbalCmdInfo> callbackWithOneParam) {
        Log.d("GimbalManager2", "setSaveParams gimbal params ");
        GimbalCmdPacket gimbalCmdPacket = new GimbalCmdPacket();
        gimbalCmdPacket.setCommand(GimbalCmdType.SET_GIMBAL_ADJUSTMENT);
        gimbalCmdPacket.saveParams();
        sendPacket(gimbalCmdPacket, callbackWithOneParam);
    }

    public void setPitchAdjustData(int i, CallbackWithOneParam<GimbalCmdInfo> callbackWithOneParam) {
        Log.d("GimbalManager2", "setRollAdjustData " + i);
        GimbalCmdPacket gimbalCmdPacket = new GimbalCmdPacket();
        gimbalCmdPacket.setCommand(GimbalCmdType.SET_GIMBAL_ADJUSTMENT);
        gimbalCmdPacket.setPitchData(i);
        sendPacket(gimbalCmdPacket, (CallbackWithOneParam) null);
    }

    public void getRollAdjustData(CallbackWithOneParam<GimbalCmdInfo> callbackWithOneParam) {
        GimbalCmdPacket gimbalCmdPacket = new GimbalCmdPacket();
        gimbalCmdPacket.setCommand(GimbalCmdType.GET_GIMBAL_ADJUSTMENT);
        sendPacket(gimbalCmdPacket, callbackWithOneParam);
    }

    public void getPitchAdjustData(CallbackWithOneParam<GimbalCmdInfo> callbackWithOneParam) {
        GimbalCmdPacket gimbalCmdPacket = new GimbalCmdPacket();
        gimbalCmdPacket.setCommand(GimbalCmdType.GET_GIMBAL_ADJUSTMENT);
        sendPacket(gimbalCmdPacket, callbackWithOneParam);
    }

    public void getYawAdjustData(CallbackWithOneParam<GimbalCmdInfo> callbackWithOneParam) {
        GimbalCmdPacket gimbalCmdPacket = new GimbalCmdPacket();
        gimbalCmdPacket.setCommand(GimbalCmdType.GET_GIMBAL_ADJUSTMENT);
        sendPacket(gimbalCmdPacket, callbackWithOneParam);
    }

    public void resetGimbalAngle(GimbalAxisType gimbalAxisType, CallbackWithOneParam<GimbalCmdInfo> callbackWithOneParam) {
        GimbalCmdPacket gimbalCmdPacket = new GimbalCmdPacket();
        gimbalCmdPacket.setCommand(GimbalCmdType.CMD_ANGLE_RESET);
        gimbalCmdPacket.setGimbalAngleCmdData(gimbalAxisType);
        sendPacket(gimbalCmdPacket, callbackWithOneParam);
    }

    public void setGimbalAngleMin(GimbalAxisType gimbalAxisType, CallbackWithOneParam<GimbalCmdInfo> callbackWithOneParam) {
        GimbalCmdPacket gimbalCmdPacket = new GimbalCmdPacket();
        gimbalCmdPacket.setCommand(GimbalCmdType.CMD_SET_MIN_ANGLE);
        gimbalCmdPacket.setGimbalAngleCmdData(gimbalAxisType);
        sendPacket(gimbalCmdPacket, callbackWithOneParam);
    }

    public void setGimbalAngleMax(GimbalAxisType gimbalAxisType, CallbackWithOneParam<GimbalCmdInfo> callbackWithOneParam) {
        GimbalCmdPacket gimbalCmdPacket = new GimbalCmdPacket();
        gimbalCmdPacket.setCommand(GimbalCmdType.CMD_SET_MAX_ANGLE);
        gimbalCmdPacket.setGimbalAngleCmdData(gimbalAxisType);
        sendPacket(gimbalCmdPacket, callbackWithOneParam);
    }

    public void setGimbalCalibration(CallbackWithOneParam<GimbalCmdInfo> callbackWithOneParam) {
        GimbalCmdPacket gimbalCmdPacket = new GimbalCmdPacket();
        gimbalCmdPacket.setCommand(GimbalCmdType.CMD_CALIBRATION);
        sendPacket(gimbalCmdPacket, callbackWithOneParam);
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
        PacketDisPatcher.getInstance().registerReceiveListener("GimbalManager2", MsgType.AU_MAV_GIMBAL_GET_ANGLE_ACK, this);
        PacketDisPatcher.getInstance().registerReceiveListener("GimbalManager2", MsgType.AU_MAV_GIMBAL_GET_ANGLE, this);
        PacketDisPatcher.getInstance().registerReceiveListener("GimbalManager2", 331, this);
    }

    public void destroy() {
        super.destroy();
        PacketDisPatcher.getInstance().unRegisterReceiveListener("GimbalManager2", MsgType.AU_MAV_GIMBAL_GET_ANGLE_ACK);
        PacketDisPatcher.getInstance().unRegisterReceiveListener("GimbalManager2", MsgType.AU_MAV_GIMBAL_GET_ANGLE);
        PacketDisPatcher.getInstance().unRegisterReceiveListener("GimbalManager2", 331);
    }

    public void onReceiveMessage(BaseMsgPacket baseMsgPacket) {
        CallbackWithOneParam<GimbalAngleRangeImpl> callbackWithOneParam;
        int type = baseMsgPacket.getType();
        if (baseMsgPacket instanceof GimbalCmdAckPacket) {
            callbackSuccOnCurrentThread(type, ((GimbalCmdAckPacket) baseMsgPacket).getGimbalCmdInfo());
        } else if (baseMsgPacket instanceof GimbalPryAnglePacket) {
            iteratorCallback(this.mFCGimbalAngleListeners, ((GimbalPryAnglePacket) baseMsgPacket).getGimbalAngle());
        } else if ((baseMsgPacket instanceof GimbalAngleRangeAckPacket) && (callbackWithOneParam = this.angleRangeallbackWithOneParam) != null) {
            callbackWithOneParam.onSuccess(((GimbalAngleRangeAckPacket) baseMsgPacket).getGimbalAngleRange());
        }
    }
}

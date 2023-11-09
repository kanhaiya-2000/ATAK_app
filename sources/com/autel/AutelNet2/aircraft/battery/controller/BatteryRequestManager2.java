package com.autel.AutelNet2.aircraft.battery.controller;

import android.util.Base64;
import com.autel.AutelNet2.aircraft.base.CommandAckPacket;
import com.autel.AutelNet2.aircraft.base.CommonCmdRequest;
import com.autel.AutelNet2.aircraft.base.ParamsAckPacket;
import com.autel.AutelNet2.aircraft.battery.engine.BatteryInfoInternal;
import com.autel.AutelNet2.aircraft.battery.message.BatteryStatusPacket;
import com.autel.AutelNet2.aircraft.battery.utils.BatteryUtils;
import com.autel.AutelNet2.aircraft.engine.BatteryHistoryInfo;
import com.autel.AutelNet2.aircraft.engine.BatteryInfoCmdParams;
import com.autel.AutelNet2.aircraft.engine.FmuCmdParams;
import com.autel.AutelNet2.aircraft.flycontroller.engine.CommandInfoInternal;
import com.autel.AutelNet2.aircraft.flycontroller.util.TransformUtils;
import com.autel.AutelNet2.constant.FmuCmdConstant;
import com.autel.AutelNet2.core.BaseController;
import com.autel.AutelNet2.core.PacketDisPatcher;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.utils.BytesUtils;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.error.AutelError;
import java.util.concurrent.ConcurrentHashMap;

public class BatteryRequestManager2 extends BaseController<Integer> {
    private static final short REGISTER_BATTERYSTATUS_TYPE = 308;
    private static final short REGISTER_COMMAND_TYPE = 263;
    private static final String REGISTER_MESSAGE_KEY = "BatteryRequestManager";
    private static final short REGISTER_MESSAGE_TYPE = 267;
    private static String TAG = "BatteryRequestManager2";
    private static BatteryRequestManager2 instance_;
    private final ConcurrentHashMap<String, CallbackWithOneParam<BatteryInfoInternal>> mBatteryStatusDataListeners = new ConcurrentHashMap<>();

    public static synchronized BatteryRequestManager2 getInstance() {
        BatteryRequestManager2 batteryRequestManager2;
        synchronized (BatteryRequestManager2.class) {
            if (instance_ == null) {
                instance_ = new BatteryRequestManager2();
            }
            batteryRequestManager2 = instance_;
        }
        return batteryRequestManager2;
    }

    private BatteryRequestManager2() {
        init();
    }

    public void queryBatteryInfo(CallbackWithOneParam<BatteryInfoCmdParams> callbackWithOneParam) {
        sendPacket(new CommonCmdRequest(TransformUtils.getRequestBatteryCmdBean(FmuCmdConstant.MAV_CMD_GET_BATTERY_ALL_INFO)), callbackWithOneParam);
    }

    public void setBatteryDisCharge(int i, CallbackWithOneParam<CommandInfoInternal> callbackWithOneParam) {
        sendPacket(new CommonCmdRequest(TransformUtils.getRequestBatteryCmdParamBean(new FmuCmdParams(i), FmuCmdConstant.MAV_CMD_SET_BATTERY_DISCHARGE)), callbackWithOneParam);
    }

    public void queryBatteryHistory(final CallbackWithOneParam<int[]> callbackWithOneParam) {
        sendPacket(new CommonCmdRequest(TransformUtils.getRequestBatteryCmdBean(FmuCmdConstant.MAV_CMD_GET_BATTERY_HISTORY)), new CallbackWithOneParam<BatteryHistoryInfo>() {
            public void onSuccess(BatteryHistoryInfo batteryHistoryInfo) {
                callbackWithOneParam.onSuccess(BytesUtils.bytes2Ints(Base64.decode(batteryHistoryInfo.getData(), 0)));
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void setLowBatteryWarning(float f, CallbackWithOneParam<Float> callbackWithOneParam) {
        sendPacket(TransformUtils.getParamsSetPacket(f, FmuCmdConstant.LOW_BATTERY_WARNING), callbackWithOneParam, false);
    }

    public void setCriticalBatteryWarning(float f, CallbackWithOneParam<Float> callbackWithOneParam) {
        sendPacket(TransformUtils.getParamsSetPacket(f, FmuCmdConstant.CRITICAL_BATTERY_WARNING), callbackWithOneParam, true);
    }

    public void queryLowBatteryWarning(CallbackWithOneParam<Float> callbackWithOneParam) {
        sendPacket(TransformUtils.getParamsGetPacket(FmuCmdConstant.LOW_BATTERY_WARNING), callbackWithOneParam);
    }

    public void queryCriticalBatteryWarning(CallbackWithOneParam<Float> callbackWithOneParam) {
        sendPacket(TransformUtils.getParamsGetPacket(FmuCmdConstant.CRITICAL_BATTERY_WARNING), callbackWithOneParam);
    }

    public void addBatteryRealTimeDataListener(String str, CallbackWithOneParam<BatteryInfoInternal> callbackWithOneParam) {
        if (callbackWithOneParam != null && !this.mBatteryStatusDataListeners.containsKey(str)) {
            if (this.mBatteryStatusDataListeners.isEmpty()) {
                PacketDisPatcher.getInstance().registerReceiveListener(REGISTER_MESSAGE_KEY, 308, this);
            }
            this.mBatteryStatusDataListeners.put(str, callbackWithOneParam);
        }
    }

    public void removeBatteryRealTimeDataListener(String str) {
        this.mBatteryStatusDataListeners.remove(str);
        if (this.mBatteryStatusDataListeners.isEmpty()) {
            PacketDisPatcher.getInstance().unRegisterReceiveListener(REGISTER_MESSAGE_KEY, 308);
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

    public void init() {
        PacketDisPatcher.getInstance().registerReceiveListener(REGISTER_MESSAGE_KEY, 263, this);
        PacketDisPatcher.getInstance().registerReceiveListener(REGISTER_MESSAGE_KEY, 267, this);
    }

    public void destroy() {
        super.destroy();
        PacketDisPatcher.getInstance().unRegisterReceiveListener(REGISTER_MESSAGE_KEY, 263);
        PacketDisPatcher.getInstance().unRegisterReceiveListener(REGISTER_MESSAGE_KEY, 267);
    }

    public void onReceiveMessage(BaseMsgPacket baseMsgPacket) {
        if (baseMsgPacket instanceof BatteryStatusPacket) {
            iteratorCallback(this.mBatteryStatusDataListeners, ((BatteryStatusPacket) baseMsgPacket).getBatteryInfoInternal());
        } else if (baseMsgPacket instanceof CommandAckPacket) {
            CommandInfoInternal commandInfoInternal = ((CommandAckPacket) baseMsgPacket).getCommandInfoInternal();
            if (commandInfoInternal != null) {
                int type = baseMsgPacket.getType();
                if (((CallbackWithOneParam) this.mListeners.get(Integer.valueOf(type))) != null) {
                    callbackSucc(type, commandInfoInternal);
                }
            }
        } else {
            int type2 = baseMsgPacket.getType();
            if (((CallbackWithOneParam) this.mListeners.get(Integer.valueOf(type2))) != null && (baseMsgPacket instanceof ParamsAckPacket)) {
                ParamsAckPacket paramsAckPacket = (ParamsAckPacket) baseMsgPacket;
                if (BatteryUtils.isBatteryRequestCmdName(paramsAckPacket.getParamsAckInfo().getParamId())) {
                    callbackSuccOnCurrentThread(type2, Float.valueOf(paramsAckPacket.getParamsAckInfo().getParamValue()));
                }
            }
        }
    }
}

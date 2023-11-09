package com.autel.AutelNet2.aircraft.firmware;

import com.autel.AutelNet2.aircraft.firmware.bean.FirmwareDeviceInfo;
import com.autel.AutelNet2.aircraft.firmware.message.DeviceInfoStatusPacket;
import com.autel.AutelNet2.aircraft.firmware.message.FirmwarePacket;
import com.autel.AutelNet2.constant.MsgType;
import com.autel.AutelNet2.core.BaseController;
import com.autel.AutelNet2.core.PacketDisPatcher;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.error.AutelError;
import com.autel.util.log.AutelLog;
import java.util.List;

public class FirmwareManager extends BaseController<Integer> {
    public static final String DEV_APP = "DEV_APP";
    public static final String DEV_BATTERY = "DEV_BATTERY";
    public static final String DEV_CAMERA = "DEV_CAMERA";
    public static final String DEV_DSP = "DEV_DSP";
    public static final String DEV_DSP_RC = "DEV_DSP_RC";
    public static final String DEV_ESC1 = "DEV_ESC1";
    public static final String DEV_ESC2 = "DEV_ESC2";
    public static final String DEV_ESC3 = "DEV_ESC3";
    public static final String DEV_ESC4 = "DEV_ESC4";
    public static final String DEV_ESC_PITCH = "DEV_ESC_PITCH";
    public static final String DEV_ESC_ROLL = "DEV_ESC_ROLL";
    public static final String DEV_ESC_YAW = "DEV_ESC_YAW";
    public static final String DEV_FLOW = "DEV_FLOW";
    public static final String DEV_GIMBAL = "DEV_GIMBAL";
    public static final String DEV_MOVIDIUS_1 = "DEV_MOVIDIUS_1";
    public static final String DEV_MOVIDIUS_2 = "DEV_MOVIDIUS_2";
    public static final String DEV_MOVIDIUS_3 = "DEV_MOVIDIUS_3";
    public static final String DEV_PC = "DEV_PC";
    public static final String DEV_RADAR = "DEV_RADAR";
    public static final String DEV_RC = "DEV_RC";
    public static final String DEV_RC_ANDROID = "DEV_RC_ANDROID";
    public static final String DEV_SONAR = "DEV_SONAR";
    public static final String DEV_SWITCHER = "DEV_SWITCHER";
    public static final String DEV_TOF = "DEV_TOF";
    public static final String DEV_UAV = "DEV_UAV";
    private static final String TAG = "FirmwareManager";
    /* access modifiers changed from: private */
    public volatile List<FirmwareDeviceInfo.VersionBean> mFirmwareDeviceInfo;

    private FirmwareManager() {
        init();
    }

    public static FirmwareManager instance() {
        return FirmwareManagerHolder.s_instance;
    }

    private static class FirmwareManagerHolder {
        public static FirmwareManager s_instance = new FirmwareManager();

        private FirmwareManagerHolder() {
        }
    }

    private void getFirmwareDeviceInfo(CallbackWithOneParam<FirmwareDeviceInfo> callbackWithOneParam) {
        sendPacket(new FirmwarePacket(), callbackWithOneParam);
    }

    public void getDeviceFirmwareInfo(final CallbackWithOneParam<List<FirmwareDeviceInfo.VersionBean>> callbackWithOneParam) {
        getFirmwareDeviceInfo(new CallbackWithOneParam<FirmwareDeviceInfo>() {
            public void onSuccess(FirmwareDeviceInfo firmwareDeviceInfo) {
                List unused = FirmwareManager.this.mFirmwareDeviceInfo = firmwareDeviceInfo.getVersion();
                AutelLog.m15084e("CYK:getDeviceFirmwareInfo:", ((FirmwareDeviceInfo.VersionBean) FirmwareManager.this.mFirmwareDeviceInfo.get(0)).getComponentName());
                callbackWithOneParam.onSuccess(FirmwareManager.this.mFirmwareDeviceInfo);
            }

            public void onFailure(AutelError autelError) {
                AutelLog.m15084e("CYK:getDeviceFirmwareInfo:error:", autelError.getDescription());
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void getComponentInfo(final String str, final CallbackWithOneParam<FirmwareDeviceInfo.VersionBean> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            getFirmwareDeviceInfo(new CallbackWithOneParam<FirmwareDeviceInfo>() {
                public void onSuccess(FirmwareDeviceInfo firmwareDeviceInfo) {
                    List unused = FirmwareManager.this.mFirmwareDeviceInfo = firmwareDeviceInfo.getVersion();
                    FirmwareDeviceInfo.VersionBean access$200 = FirmwareManager.this.getVersionBean(str);
                    if (access$200 != null) {
                        callbackWithOneParam.onSuccess(access$200);
                    } else {
                        callbackWithOneParam.onFailure(AutelError.COMMAND_FAILED);
                    }
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        }
    }

    public void init() {
        PacketDisPatcher.getInstance().registerReceiveListener(TAG, 770, this);
        PacketDisPatcher.getInstance().registerReceiveListener(TAG, MsgType.AU_UPGRADE_DEVICE_INFO_RESP, this);
    }

    public void onReceiveMessage(BaseMsgPacket baseMsgPacket) {
        AutelLog.m15082d(TAG, "packet:" + baseMsgPacket.toString());
        if (baseMsgPacket instanceof FirmwarePacket) {
            callbackSucc(baseMsgPacket.getType(), ((FirmwarePacket) baseMsgPacket).getFirmwareDeviceInfo());
        } else {
            boolean z = baseMsgPacket instanceof DeviceInfoStatusPacket;
        }
    }

    public void destroy() {
        super.destroy();
        this.mFirmwareDeviceInfo = null;
        PacketDisPatcher.getInstance().unRegisterReceiveListener(TAG, 770);
        PacketDisPatcher.getInstance().unRegisterReceiveListener(TAG, MsgType.AU_UPGRADE_DEVICE_INFO_RESP);
    }

    /* access modifiers changed from: protected */
    public Integer getTimeOutItem(BaseMsgPacket baseMsgPacket) {
        return Integer.valueOf(baseMsgPacket.getType());
    }

    /* access modifiers changed from: private */
    public FirmwareDeviceInfo.VersionBean getVersionBean(String str) {
        if (!(this.mFirmwareDeviceInfo == null || str == null)) {
            for (FirmwareDeviceInfo.VersionBean next : this.mFirmwareDeviceInfo) {
                if (str.equals(next.getComponentName())) {
                    return next;
                }
            }
        }
        return null;
    }
}

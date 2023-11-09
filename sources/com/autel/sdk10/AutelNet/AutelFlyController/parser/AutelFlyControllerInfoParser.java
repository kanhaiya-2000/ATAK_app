package com.autel.sdk10.AutelNet.AutelFlyController.parser;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.ardupilotmega.msg_sys_status;
import com.autel.common.flycontroller.LedPilotLamp;
import com.autel.internal.sdk.flycontroller.BeginnerMode;
import com.autel.sdk10.AutelNet.AutelFlyController.enums.FlyControllerRequestCmdName;
import com.autel.sdk10.AutelNet.AutelFlyController.info.AutelFlyControllerInfo;
import com.autel.sdk10.AutelNet.AutelFlyController.util.SensitiveUtil;
import com.autel.sdk10.AutelNet.AutelMavlinkCore.core.mavlinkcmds.mavlinkparameter.Parameter;

public class AutelFlyControllerInfoParser extends AutelFlyControllerInfo {
    private static AutelFlyControllerInfoParser instance_;
    private long updateTime_SN_DISABLE;
    private long updateTime_SN_SAVED;
    private long updateTime_ascendSpeed;
    private long updateTime_attiModeSwitch;
    private long updateTime_descendSpeed;
    private long updateTime_freshManMode;
    private long updateTime_horizontalSpeed;
    private long updateTime_ledlamp;
    private long updateTime_maxHeight;
    private long updateTime_maxRange;
    private long updateTime_returnHeight;
    private long updateTime_sdLogFrequency;
    private long updateTime_yaw_sen;

    public static AutelFlyControllerInfoParser getInstance_() {
        if (instance_ == null) {
            instance_ = new AutelFlyControllerInfoParser();
        }
        return instance_;
    }

    private void setParams(String str, String str2) {
        str.hashCode();
        boolean z = false;
        char c = 65535;
        switch (str.hashCode()) {
            case -1702941621:
                if (str.equals("SM_Beginner_Mode")) {
                    c = 0;
                    break;
                }
                break;
            case -1189782254:
                if (str.equals("SM_EN_ATT_MODE")) {
                    c = 1;
                    break;
                }
                break;
            case -673142389:
                if (str.equals("SM_SDLOG_SEN")) {
                    c = 2;
                    break;
                }
                break;
            case -506431030:
                if (str.equals("SM_Max_v_xy")) {
                    c = 3;
                    break;
                }
                break;
            case -293431151:
                if (str.equals("SM_Max_v_z")) {
                    c = 4;
                    break;
                }
                break;
            case -73633153:
                if (str.equals("SM_Min_v_z")) {
                    c = 5;
                    break;
                }
                break;
            case 623177829:
                if (str.equals("SM_RTH_Height")) {
                    c = 6;
                    break;
                }
                break;
            case 1447310013:
                if (str.equals("SM_Max_Range")) {
                    c = 7;
                    break;
                }
                break;
            case 1634191271:
                if (str.equals("SM_Max_Height")) {
                    c = 8;
                    break;
                }
                break;
            case 1911223870:
                if (str.equals(FlyControllerRequestCmdName.RC_YAW_SEN)) {
                    c = 9;
                    break;
                }
                break;
            case 1928622979:
                if (str.equals(FlyControllerRequestCmdName.SN_SAVED)) {
                    c = 10;
                    break;
                }
                break;
            case 2074268900:
                if (str.equals(FlyControllerRequestCmdName.SN_DISABLE)) {
                    c = 11;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                this.autelBeginnerMode = Integer.valueOf(str2).intValue() == BeginnerMode.ENABLED.getValue() ? BeginnerMode.ENABLED : BeginnerMode.DISABLED;
                this.updateTime_freshManMode = System.currentTimeMillis();
                return;
            case 1:
                if (Integer.valueOf(str2).intValue() == 1) {
                    z = true;
                }
                this.attiEnable = z;
                this.updateTime_attiModeSwitch = System.currentTimeMillis();
                return;
            case 2:
                this.sdLogFrequency = Integer.valueOf(str2).intValue();
                this.updateTime_sdLogFrequency = System.currentTimeMillis();
                return;
            case 3:
                this.horizontalSpeed = Float.valueOf(str2).floatValue();
                this.updateTime_horizontalSpeed = System.currentTimeMillis();
                return;
            case 4:
                this.ascendSpeed = Float.valueOf(str2).floatValue();
                this.updateTime_ascendSpeed = System.currentTimeMillis();
                return;
            case 5:
                this.descendSpeed = Float.valueOf(str2).floatValue();
                this.updateTime_descendSpeed = System.currentTimeMillis();
                return;
            case 6:
                this.returnHeight = Float.valueOf(str2).floatValue();
                this.updateTime_returnHeight = System.currentTimeMillis();
                return;
            case 7:
                this.maxRange = Float.valueOf(str2).floatValue();
                this.updateTime_maxRange = System.currentTimeMillis();
                return;
            case 8:
                this.maxHeight = Float.valueOf(str2).floatValue();
                this.updateTime_maxHeight = System.currentTimeMillis();
                return;
            case 9:
                this.yawSensitive = (float) SensitiveUtil.sensitive2Coefficient(Double.valueOf(str2).doubleValue());
                this.updateTime_yaw_sen = System.currentTimeMillis();
                return;
            case 10:
                this.SN_Code = Integer.valueOf(str2).intValue();
                this.updateTime_SN_SAVED = System.currentTimeMillis();
                return;
            case 11:
                this.SN_Disable_Code = Integer.valueOf(str2).intValue();
                this.updateTime_SN_DISABLE = System.currentTimeMillis();
                return;
            default:
                return;
        }
    }

    public boolean isNewInfo(int i, long j) {
        switch (i) {
            case 0:
                if (this.updateTime_maxHeight > j) {
                    return true;
                }
                return false;
            case 1:
                if (this.updateTime_maxRange > j) {
                    return true;
                }
                return false;
            case 2:
                if (this.updateTime_returnHeight > j) {
                    return true;
                }
                return false;
            case 3:
                if (this.updateTime_horizontalSpeed > j) {
                    return true;
                }
                return false;
            case 4:
                if (this.updateTime_ascendSpeed > j) {
                    return true;
                }
                return false;
            case 5:
                if (this.updateTime_descendSpeed > j) {
                    return true;
                }
                return false;
            case 6:
                if (this.updateTime_freshManMode > j) {
                    return true;
                }
                return false;
            case 7:
                if (this.updateTime_sdLogFrequency > j) {
                    return true;
                }
                return false;
            case 8:
                if (this.updateTime_attiModeSwitch > j) {
                    return true;
                }
                return false;
            case 9:
                if (this.updateTime_ledlamp > j) {
                    return true;
                }
                return false;
            case 10:
                if (this.updateTime_SN_DISABLE > j) {
                    return true;
                }
                return false;
            case 11:
                if (this.updateTime_SN_SAVED > j) {
                    return true;
                }
                return false;
            case 12:
                return this.updateTime_yaw_sen > j;
            default:
                return false;
        }
    }

    public void parseParamValue(Parameter parameter) {
        try {
            setParams(parameter.getName(), parameter.getValueStr());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parseMAVLinkMessage(MAVLinkMessage mAVLinkMessage) {
        int i = (((msg_sys_status) mAVLinkMessage).flight_warning >> 20) & 3;
        if (i == 0) {
            this.autelLedPilotLamp = LedPilotLamp.ALL_OFF;
        } else if (i == 1) {
            this.autelLedPilotLamp = LedPilotLamp.BACK_ONLY;
        } else if (i == 2) {
            this.autelLedPilotLamp = LedPilotLamp.FRONT_ONLY;
        } else if (i == 3) {
            this.autelLedPilotLamp = LedPilotLamp.ALL_ON;
        }
        this.updateTime_ledlamp = System.currentTimeMillis();
    }
}

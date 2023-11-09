package com.autel.sdk10.AutelNet.AutelGimbal.parser;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.ardupilotmega.msg_ptz_frame_cmd;
import com.autel.common.gimbal.GimbalWorkMode;
import com.autel.internal.sdk.gimbal.AutelGimbalInfo;
import com.autel.sdk10.AutelNet.AutelFlyController.parser.ErrorWarningInternalParser;
import com.autel.sdk10.AutelNet.AutelGimbal.enums.GimbalRequestCmdName;
import com.autel.sdk10.AutelNet.AutelMavlinkCore.core.mavlinkcmds.mavlinkparameter.Parameter;
import com.autel.sdk10.utils.BytesUtils;

public class GimbalInfoParser extends AutelGimbalInfo {
    private static GimbalInfoParser instance_;
    private long lastGimbalInfoRevTime;
    private long updateTime_rollAdjust;
    private long updateTime_workMode;

    public static GimbalInfoParser getInstance_() {
        if (instance_ == null) {
            instance_ = new GimbalInfoParser();
        }
        return instance_;
    }

    private GimbalInfoParser() {
    }

    private void setUpdateTime(int i) {
        if (i == 0) {
            this.updateTime_workMode = System.currentTimeMillis();
        } else if (i == 1) {
            this.updateTime_rollAdjust = System.currentTimeMillis();
        }
    }

    /* access modifiers changed from: protected */
    public void setDatas(msg_ptz_frame_cmd msg_ptz_frame_cmd) {
        int i = (int) msg_ptz_frame_cmd.index;
        if (i == 1) {
            this.pitch = msg_ptz_frame_cmd.data;
        } else if (i == 2) {
            this.roll = msg_ptz_frame_cmd.data;
        } else if (i == 3) {
            this.yaw = msg_ptz_frame_cmd.data;
        }
    }

    public boolean isNewInfo(int i, long j) {
        if (i != 0) {
            return i == 1 && this.updateTime_rollAdjust > j;
        }
        if (this.updateTime_workMode > j) {
            return true;
        }
        return false;
    }

    public void parseParamValue(Parameter parameter) {
        String name = parameter.getName();
        name.hashCode();
        if (name.equals(GimbalRequestCmdName.GIMBAL_WORK_MODE)) {
            setGimbalWorkMode(((int) parameter.getValue()) == GimbalWorkMode.FPV.getValue10() ? GimbalWorkMode.FPV : GimbalWorkMode.STABILIZED);
            setUpdateTime(0);
        }
    }

    public boolean parseMAVLinkMessage(MAVLinkMessage mAVLinkMessage) {
        if (mAVLinkMessage.msgid != 200) {
            return false;
        }
        msg_ptz_frame_cmd msg_ptz_frame_cmd = (msg_ptz_frame_cmd) mAVLinkMessage;
        if (msg_ptz_frame_cmd.fram_id == 890) {
            int i = BytesUtils.getInt(new byte[]{msg_ptz_frame_cmd.frame_date[4], msg_ptz_frame_cmd.frame_date[5], msg_ptz_frame_cmd.frame_date[6], msg_ptz_frame_cmd.frame_date[7]});
            if (BytesUtils.getInt(new byte[]{msg_ptz_frame_cmd.frame_date[3], msg_ptz_frame_cmd.frame_date[2], msg_ptz_frame_cmd.frame_date[1], msg_ptz_frame_cmd.frame_date[0]}) == 0) {
                setRollAdjust(i);
                setUpdateTime(1);
            }
        } else if (msg_ptz_frame_cmd.fram_id == 888) {
            this.lastGimbalInfoRevTime = System.currentTimeMillis();
            ErrorWarningInternalParser.getInstance().parseGimbalErrorCode(msg_ptz_frame_cmd);
            setDatas(msg_ptz_frame_cmd);
        }
        return true;
    }

    public boolean isNewGimbalInfo(long j) {
        return this.lastGimbalInfoRevTime - j > 0;
    }
}

package com.autel.AutelNet2.aircraft.base;

import android.text.TextUtils;
import com.atakmap.android.uastool.flightlog.FlightLogger;
import com.autel.AutelNet2.aircraft.engine.BatteryHistoryInfo;
import com.autel.AutelNet2.aircraft.engine.BatteryInfoCmdParams;
import com.autel.AutelNet2.aircraft.engine.BoatModeInfo;
import com.autel.AutelNet2.aircraft.engine.CommonCmdParams;
import com.autel.AutelNet2.aircraft.engine.HomeCmdParams;
import com.autel.AutelNet2.aircraft.engine.LedPilotInfo;
import com.autel.AutelNet2.aircraft.flycontroller.engine.AuthenInfo;
import com.autel.AutelNet2.aircraft.flycontroller.engine.CommandInfoInternal;
import com.autel.AutelNet2.constant.FmuCmdConstant;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.core.message.MsgHead;
import com.autel.util.log.AutelLog;

public class CommandAckPacket extends BaseMsgPacket {
    private CommandInfoInternal mBaseCmdParams;
    private String mCommand;

    public String loadBody() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
    }

    public CommandAckPacket(MsgHead msgHead, byte[] bArr) {
        setHead(msgHead);
        setBody(bArr);
    }

    public CommandInfoInternal getCommandInfoInternal() {
        return this.mBaseCmdParams;
    }

    public BaseMsgPacket parseBody() {
        AutelLog.debug_i("CommonCmdRequestAck", "Command receiver " + getBodyString());
        this.mCommand = getBodyJson().getString(FlightLogger.LOCS_COMMAND);
        String string = getBodyJson().getString("params");
        if (FmuCmdConstant.MAV_CMD_DO_SET_HOME.equals(this.mCommand)) {
            this.mBaseCmdParams = (CommandInfoInternal) this.messageParser.getObject(string, HomeCmdParams.class);
        } else if (FmuCmdConstant.MAV_CMD_GET_BATTERY_ALL_INFO.equals(this.mCommand)) {
            this.mBaseCmdParams = (CommandInfoInternal) this.messageParser.getObject(string, BatteryInfoCmdParams.class);
        } else if (FmuCmdConstant.MAV_CMD_GET_BATTERY_HISTORY.equals(this.mCommand)) {
            this.mBaseCmdParams = (CommandInfoInternal) this.messageParser.getObject(string, BatteryHistoryInfo.class);
        } else if (FmuCmdConstant.MAV_CMD_GET_LED.equals(this.mCommand)) {
            this.mBaseCmdParams = (CommandInfoInternal) this.messageParser.getObject(string, LedPilotInfo.class);
        } else if (FmuCmdConstant.MAV_CMD_NAV_GET_TAKEOFF.equals(this.mCommand)) {
            this.mBaseCmdParams = (CommandInfoInternal) this.messageParser.getObject(string, BoatModeInfo.class);
        } else if (FmuCmdConstant.MAV_CMD_GET_RTK_AUTH_INFO.equals(this.mCommand)) {
            this.mBaseCmdParams = (CommandInfoInternal) this.messageParser.getObject(string, AuthenInfo.class);
        } else {
            this.mBaseCmdParams = (CommandInfoInternal) this.messageParser.getObject(string, CommonCmdParams.class);
        }
        return this;
    }

    public int getType() {
        if (TextUtils.isEmpty(this.mCommand)) {
            return 0;
        }
        return this.mCommand.hashCode();
    }
}

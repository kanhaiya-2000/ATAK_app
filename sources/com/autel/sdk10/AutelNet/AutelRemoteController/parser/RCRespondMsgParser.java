package com.autel.sdk10.AutelNet.AutelRemoteController.parser;

import com.autel.common.remotecontroller.RFPower;
import com.autel.common.remotecontroller.RemoteControllerCommandStickMode;
import com.autel.common.remotecontroller.RemoteControllerLanguage;
import com.autel.common.remotecontroller.RemoteControllerParameterUnit;
import com.autel.common.remotecontroller.TeachingMode;
import com.autel.sdk10.AutelNet.AutelRemoteController.engine.RCCommandMessage;
import com.autel.sdk10.AutelNet.AutelRemoteController.engine.RCRecMessageDecoder;

public class RCRespondMsgParser {
    private static RCRespondMsgParser instance;
    private RCCommandMessage mRevMessage;

    public static RCRespondMsgParser getInstance() {
        if (instance == null) {
            instance = new RCRespondMsgParser();
        }
        return instance;
    }

    private RCRespondMsgParser() {
    }

    public void parseRemoteCommandMessage(RCCommandMessage rCCommandMessage) {
        this.mRevMessage = rCCommandMessage;
    }

    public int getMsgId() {
        return this.mRevMessage.getMsgId();
    }

    public String getByteStr() {
        String str = "";
        for (byte b : this.mRevMessage.getData()) {
            str = str + " " + b;
        }
        return str;
    }

    public boolean isGimbalAdjustSpeedSetSucc() {
        return getBooleanResult();
    }

    public boolean isRCLanguageSetSucc() {
        return getBooleanResult();
    }

    public boolean isRCBindSucc() {
        return ((Integer) RCRecMessageDecoder.getResult(this.mRevMessage)).intValue() == 2;
    }

    public boolean isRFPowerSetSucc() {
        return getBooleanResult();
    }

    public boolean isTeacherStudentModeSetSucc() {
        return getBooleanResult();
    }

    public boolean isRCLengthUnitSetSucc() {
        return getBooleanResult();
    }

    public boolean isRCControlModelSetSucc() {
        return getBooleanResult();
    }

    private boolean getBooleanResult() {
        return ((Integer) RCRecMessageDecoder.getResult(this.mRevMessage)).intValue() == 0;
    }

    public int getGimbalAdjustSpeed() {
        return getIntResult();
    }

    public int getGimbalAngle() {
        return getIntResult();
    }

    public int getRCBindMode() {
        return getIntResult();
    }

    public RFPower getRFPower() {
        return getIntResult() == RFPower.FCC.getValue() ? RFPower.FCC : RFPower.CE;
    }

    public TeachingMode getTeacherStudentMode() {
        int intResult = getIntResult();
        if (intResult == TeachingMode.TEACHER.getValue()) {
            return TeachingMode.TEACHER;
        }
        if (intResult == TeachingMode.STUDENT.getValue()) {
            return TeachingMode.STUDENT;
        }
        return TeachingMode.DISABLED;
    }

    public RemoteControllerCommandStickMode getRCControlModel() {
        int intResult = getIntResult();
        if (intResult == RemoteControllerCommandStickMode.USA.getValue()) {
            return RemoteControllerCommandStickMode.USA;
        }
        if (intResult == RemoteControllerCommandStickMode.CHINA.getValue()) {
            return RemoteControllerCommandStickMode.CHINA;
        }
        if (intResult == RemoteControllerCommandStickMode.JAPAN.getValue()) {
            return RemoteControllerCommandStickMode.JAPAN;
        }
        return RemoteControllerCommandStickMode.USA;
    }

    public RemoteControllerParameterUnit getRCLengthUnit() {
        return getIntResult() == RemoteControllerParameterUnit.METRIC.getValue() ? RemoteControllerParameterUnit.METRIC : RemoteControllerParameterUnit.IMPERIAL;
    }

    private int getIntResult() {
        return ((Integer) RCRecMessageDecoder.getResult(this.mRevMessage)).intValue();
    }

    public RemoteControllerLanguage getRCLanguage() {
        return getIntAyyayResult()[0] == RemoteControllerLanguage.ENGLISH.getValue() ? RemoteControllerLanguage.ENGLISH : RemoteControllerLanguage.CHINESE;
    }

    public int[] getRCUploadData() {
        return getIntAyyayResult();
    }

    public int[] getRCInfoData() {
        return getIntAyyayResult();
    }

    public int[] getRCVersionData() {
        return getIntAyyayResult();
    }

    public int[] getRCAdjustStep() {
        return getIntAyyayResult();
    }

    private int[] getIntAyyayResult() {
        return (int[]) RCRecMessageDecoder.getResult(this.mRevMessage);
    }
}

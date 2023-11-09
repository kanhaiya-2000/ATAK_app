package com.autel.sdk10.AutelNet.AutelRemoteController.info;

import com.autel.common.remotecontroller.RFPower;
import com.autel.common.remotecontroller.RemoteControllerCommandStickMode;
import com.autel.common.remotecontroller.RemoteControllerLanguage;
import com.autel.common.remotecontroller.RemoteControllerParameterUnit;
import com.autel.common.remotecontroller.TeachingMode;

public class AutelRemoteControllerInfo {
    private static AutelRemoteControllerInfo instance;
    private RFPower autelRFPower;
    private RemoteControllerCommandStickMode autelRcCommandStickMode;
    private RemoteControllerLanguage autelRcLanguage;
    private int gimbalAdjustSpeed;
    private int gimbalAngle;
    private RemoteControllerParameterUnit lengthUnit;
    private TeachingMode tsMode;

    public static AutelRemoteControllerInfo getInstance() {
        if (instance == null) {
            instance = new AutelRemoteControllerInfo();
        }
        return instance;
    }

    private AutelRemoteControllerInfo() {
    }

    public int getGimbalAdjustSpeed() {
        return this.gimbalAdjustSpeed;
    }

    public int getGimbalAngle() {
        return this.gimbalAngle;
    }

    public RFPower getAutelRFPower() {
        return this.autelRFPower;
    }

    public TeachingMode getTeacherStudentMode() {
        return this.tsMode;
    }

    public RemoteControllerCommandStickMode getRCCommandStickMode() {
        return this.autelRcCommandStickMode;
    }

    public RemoteControllerParameterUnit getRCLengthUnit() {
        return this.lengthUnit;
    }

    public RemoteControllerLanguage getRCLanguage() {
        return this.autelRcLanguage;
    }

    public void setGimbalAdjustSpeed(int i) {
        this.gimbalAdjustSpeed = i;
    }

    public void setGimbalAngle(int i) {
        this.gimbalAngle = i;
    }

    public void setAutelRFPower(RFPower rFPower) {
        this.autelRFPower = rFPower;
    }

    public void setTeacherStudentMode(TeachingMode teachingMode) {
        this.tsMode = teachingMode;
    }

    public void setRCCommandStickMode(RemoteControllerCommandStickMode remoteControllerCommandStickMode) {
        this.autelRcCommandStickMode = remoteControllerCommandStickMode;
    }

    public void setRCLengthUnit(RemoteControllerParameterUnit remoteControllerParameterUnit) {
        this.lengthUnit = remoteControllerParameterUnit;
    }

    public void setRCLanguage(RemoteControllerLanguage remoteControllerLanguage) {
        this.autelRcLanguage = remoteControllerLanguage;
    }
}

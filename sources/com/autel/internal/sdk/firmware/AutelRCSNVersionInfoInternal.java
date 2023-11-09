package com.autel.internal.sdk.firmware;

public class AutelRCSNVersionInfoInternal extends AutelVersionInfo implements RemoteControllerSerialNumberVersionInfo {
    private String RemoteControl;

    public void setRemoteControl(String str) {
        this.RemoteControl = str;
    }

    public String getRemoteControl() {
        return this.RemoteControl;
    }

    public String getRemoteControlSerialNumber() {
        return getRemoteControl();
    }

    public String toString() {
        return "RemoteControlSN : " + this.RemoteControl;
    }
}

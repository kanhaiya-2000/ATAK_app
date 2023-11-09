package com.autel.internal.sdk.firmware;

import com.autel.internal.sdk.remotecontroller.RemoteControllerVersionPartInfo;

public class AutelRCVersionInfoInternal extends AutelVersionInfo implements RemoteControllerVersionPartInfo {
    private String RemoteControl;
    private String Repeater;
    private String RfTx;
    private String Rootfs;

    public void setRepeaterVersion(String str) {
        this.Repeater = str;
    }

    public String getRepeaterVersion() {
        return this.Repeater;
    }

    public String getRFTXVersion() {
        return getRfTx();
    }

    public void setRfTx(String str) {
        this.RfTx = str;
    }

    public String getRfTx() {
        return this.RfTx;
    }

    public void setRemoteControl(String str) {
        this.RemoteControl = str;
    }

    public String getRemoteControlVersion() {
        return this.RemoteControl;
    }

    public void setRootfs(String str) {
        this.Rootfs = str;
    }

    public String getRootFileSystemVersion() {
        return this.Rootfs;
    }

    public String toString() {
        return "Repeater : " + this.Repeater + ", RfTx : " + this.RfTx + ", RemoteControl :" + this.RemoteControl + ", Rootfs : " + this.Rootfs;
    }
}

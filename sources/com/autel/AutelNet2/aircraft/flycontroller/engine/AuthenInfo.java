package com.autel.AutelNet2.aircraft.flycontroller.engine;

public class AuthenInfo implements CommandInfoInternal {
    private int command_ack;
    private String device_id;
    private String device_type;
    private String service_key;
    private String service_secret;

    public String getServiceKey() {
        return this.service_key;
    }

    public void setServiceKey(String str) {
        this.service_key = str;
    }

    public String getServiceSecret() {
        return this.service_secret;
    }

    public void setServiceSecret(String str) {
        this.service_secret = str;
    }

    public String getDeviceId() {
        return this.device_id;
    }

    public void setDeviceId(String str) {
        this.device_id = str;
    }

    public String getDeviceType() {
        return this.device_type;
    }

    public void setDeviceType(String str) {
        this.device_type = str;
    }

    public int errorCode() {
        return this.command_ack;
    }

    public boolean isSuccess() {
        return this.command_ack == 0;
    }
}

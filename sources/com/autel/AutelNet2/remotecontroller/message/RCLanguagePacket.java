package com.autel.AutelNet2.remotecontroller.message;

import com.autel.common.remotecontroller.RemoteControllerLanguage;
import org.json.JSONArray;

public class RCLanguagePacket extends RCMsgPacket {
    private boolean isSucc = false;
    private RemoteControllerLanguage language;

    public RCLanguagePacket() {
        setType(4);
    }

    public void setLanguage(RemoteControllerLanguage remoteControllerLanguage) {
        this.language = remoteControllerLanguage;
        setType(3);
        addData(remoteControllerLanguage.getValue());
    }

    public RemoteControllerLanguage getLanguage() {
        return this.language;
    }

    public boolean isSetLanguageSucc() {
        return this.isSucc;
    }

    public void parseData(int i, JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            if (i == 3) {
                this.isSucc = isResultSucc(jSONArray);
            } else if (i == 4) {
                this.language = jSONArray.getInt(0) == RemoteControllerLanguage.ENGLISH.getValue() ? RemoteControllerLanguage.ENGLISH : RemoteControllerLanguage.CHINESE;
            }
        }
    }
}

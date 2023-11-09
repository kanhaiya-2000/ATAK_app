package com.autel.camera.protocol.protocol20.entity;

import java.util.HashMap;

public class CameraEvents {
    private HashMap<String, String> map = new HashMap<>();
    private String type;

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public HashMap<String, String> getMap() {
        return this.map;
    }

    public void setMap(HashMap<String, String> hashMap) {
        this.map = hashMap;
    }
}

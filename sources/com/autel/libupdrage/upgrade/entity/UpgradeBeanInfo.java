package com.autel.libupdrage.upgrade.entity;

import java.util.List;

public class UpgradeBeanInfo {
    private String DeviceType = "EVO";
    private List<ModelBean> Items;
    private String Language = "";
    private String action = "checkUpgrade";

    public String getAction() {
        return this.action;
    }

    public void setAction(String str) {
        this.action = str;
    }

    public String getDeviceType() {
        return this.DeviceType;
    }

    public void setDeviceType(String str) {
        this.DeviceType = str;
    }

    public List<ModelBean> getItems() {
        return this.Items;
    }

    public void setItems(List<ModelBean> list) {
        this.Items = list;
    }

    public String getLanguage() {
        return this.Language;
    }

    public void setLanguage(String str) {
        this.Language = str;
    }
}

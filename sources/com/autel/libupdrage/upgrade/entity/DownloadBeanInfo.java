package com.autel.libupdrage.upgrade.entity;

public class DownloadBeanInfo {
    private String header_info;
    private String itemmd5;
    private int itemmodule;
    private long itemsize;
    private String itemurl;
    private String package_version;
    private String release_notes;

    public int getItemmodule() {
        return this.itemmodule;
    }

    public void setItemmodule(int i) {
        this.itemmodule = i;
    }

    public long getItemsize() {
        return this.itemsize;
    }

    public void setItemsize(long j) {
        this.itemsize = j;
    }

    public String getItemurl() {
        return this.itemurl;
    }

    public void setItemurl(String str) {
        this.itemurl = str;
    }

    public String getItemmd5() {
        return this.itemmd5;
    }

    public void setItemmd5(String str) {
        this.itemmd5 = str;
    }

    public String getRelease_notes() {
        return this.release_notes;
    }

    public void setRelease_notes(String str) {
        this.release_notes = str;
    }

    public String getHeader_info() {
        return this.header_info;
    }

    public void setHeader_info(String str) {
        this.header_info = str;
    }

    public String getPackage_version() {
        return this.package_version;
    }

    public void setPackage_version(String str) {
        this.package_version = str;
    }
}

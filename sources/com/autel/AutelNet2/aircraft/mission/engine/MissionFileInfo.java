package com.autel.AutelNet2.aircraft.mission.engine;

public class MissionFileInfo {
    private String fileName;
    private String md5;
    private long size;
    private int type;

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public long getSize() {
        return this.size;
    }

    public void setSize(long j) {
        this.size = j;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String getMd5() {
        return this.md5;
    }

    public void setMd5(String str) {
        this.md5 = str;
    }
}

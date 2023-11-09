package com.autel.AutelNet2.aircraft.mission.engine;

public class BreakPointFlyInfo {
    private int ExecuteIndex;
    private String GUID;
    private int MissionId;
    private int MissionType;

    public int getMissionType() {
        return this.MissionType;
    }

    public void setMissionType(int i) {
        this.MissionType = i;
    }

    public int getMissionId() {
        return this.MissionId;
    }

    public void setMissionId(int i) {
        this.MissionId = i;
    }

    public int getExecuteIndex() {
        return this.ExecuteIndex;
    }

    public void setExecuteIndex(int i) {
        this.ExecuteIndex = i;
    }

    public String getGUID() {
        return this.GUID;
    }

    public void setGUID(String str) {
        this.GUID = str;
    }
}

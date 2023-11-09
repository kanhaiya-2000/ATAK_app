package com.autel.AutelNet2.aircraft.mission.engine;

import java.util.List;

public class WaypointActionInfo {
    private int ActionId;
    private List<Float> ActionParameters;
    private int ActionTimeout;
    private int ActionType;
    private int MissionId;
    private int WaypointId;

    public int getMissionId() {
        return this.MissionId;
    }

    public void setMissionId(int i) {
        this.MissionId = i;
    }

    public int getWaypointId() {
        return this.WaypointId;
    }

    public void setWaypointId(int i) {
        this.WaypointId = i;
    }

    public int getActionId() {
        return this.ActionId;
    }

    public void setActionId(int i) {
        this.ActionId = i;
    }

    public int getActionType() {
        return this.ActionType;
    }

    public void setActionType(int i) {
        this.ActionType = i;
    }

    public int getActionTimeout() {
        return this.ActionTimeout;
    }

    public void setActionTimeout(int i) {
        this.ActionTimeout = i;
    }

    public List<Float> getActionParameters() {
        return this.ActionParameters;
    }

    public void setActionParameters(List<Float> list) {
        this.ActionParameters = list;
    }
}

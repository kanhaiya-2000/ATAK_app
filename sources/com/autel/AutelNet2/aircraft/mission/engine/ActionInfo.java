package com.autel.AutelNet2.aircraft.mission.engine;

public class ActionInfo {
    private int ActionId;
    private int[] ActionParameters;
    private int ActionTimeout;
    private int ActionType;

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

    public int[] getActionParameters() {
        return this.ActionParameters;
    }

    public void setActionParameters(int[] iArr) {
        this.ActionParameters = iArr;
    }
}

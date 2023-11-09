package com.autel.AutelNet2.aircraft.mission.engine;

public class PanoramaInfo {
    private int HeadingBegin;
    private int HeadingEnd;
    private int MissionId;
    private int NadirNumber;
    private int NumberColumns;
    private int NumberRows;
    private int PitchMax;
    private int PitchMin;
    private int RotateDirection;
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

    public int getNumberRows() {
        return this.NumberRows;
    }

    public void setNumberRows(int i) {
        this.NumberRows = i;
    }

    public int getNumberColumns() {
        return this.NumberColumns;
    }

    public void setNumberColumns(int i) {
        this.NumberColumns = i;
    }

    public int getHeadingBegin() {
        return this.HeadingBegin;
    }

    public void setHeadingBegin(int i) {
        this.HeadingBegin = i;
    }

    public int getHeadingEnd() {
        return this.HeadingEnd;
    }

    public void setHeadingEnd(int i) {
        this.HeadingEnd = i;
    }

    public int getRotateDirection() {
        return this.RotateDirection;
    }

    public void setRotateDirection(int i) {
        this.RotateDirection = i;
    }

    public int getNadirNumber() {
        return this.NadirNumber;
    }

    public void setNadirNumber(int i) {
        this.NadirNumber = i;
    }

    public int getPitchMax() {
        return this.PitchMax;
    }

    public void setPitchMax(int i) {
        this.PitchMax = i;
    }

    public int getPitchMin() {
        return this.PitchMin;
    }

    public void setPitchMin(int i) {
        this.PitchMin = i;
    }
}

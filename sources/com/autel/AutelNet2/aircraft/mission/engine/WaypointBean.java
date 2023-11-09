package com.autel.AutelNet2.aircraft.mission.engine;

import java.util.List;

public class WaypointBean {
    private List<ActionInfo> Actions;
    private int Altitude;
    private int AltitudePriorityMode;
    private int BeizerParameter;
    private int CameraPitch;
    private int CameraYaw;
    private int CurFlyDistance;
    private int CurFlyTime;
    private int FocusAltitude;
    private int FocusLatitude;
    private int FocusLongitude;
    private int HeadingMode;
    private int HoverTime;
    private int Latitude;
    private int Longitude;
    private int NumberOfActions;
    private OrbitInfo OrbitInfo;
    private int Param1;
    private int Param2;
    private int Param3;
    private int Param4;
    private int Param5;
    private int Param6;
    private int Param7;
    private int PoiIndex;
    private int Speed;
    private int UserdefinedHeading;
    private int WaypointId;
    private int WaypointType;
    private float wSpeed = -1.0f;

    public int getCurFlyTime() {
        return this.CurFlyTime;
    }

    public void setCurFlyTime(int i) {
        this.CurFlyTime = i;
    }

    public int getCurFlyDistance() {
        return this.CurFlyDistance;
    }

    public void setCurFlyDistance(int i) {
        this.CurFlyDistance = i;
    }

    public int getHoverTime() {
        return this.HoverTime;
    }

    public void setHoverTime(int i) {
        this.HoverTime = i;
    }

    public int getPoiIndex() {
        return this.PoiIndex;
    }

    public void setPoiIndex(int i) {
        this.PoiIndex = i;
    }

    public void setwSpeed(float f) {
        this.wSpeed = f;
    }

    public float getwSpeed() {
        return this.wSpeed;
    }

    public int getWaypointId() {
        return this.WaypointId;
    }

    public void setWaypointId(int i) {
        this.WaypointId = i;
    }

    public int getWaypointType() {
        return this.WaypointType;
    }

    public void setWaypointType(int i) {
        this.WaypointType = i;
    }

    public int getLatitude() {
        return this.Latitude;
    }

    public void setLatitude(int i) {
        this.Latitude = i;
    }

    public int getLongitude() {
        return this.Longitude;
    }

    public void setLongitude(int i) {
        this.Longitude = i;
    }

    public int getAltitude() {
        return this.Altitude;
    }

    public void setAltitude(int i) {
        this.Altitude = i;
    }

    public int getSpeed() {
        return this.Speed;
    }

    public void setSpeed(int i) {
        this.Speed = i;
    }

    public int getFocusLatitude() {
        return this.FocusLatitude;
    }

    public void setFocusLatitude(int i) {
        this.FocusLatitude = i;
    }

    public int getFocusLongitude() {
        return this.FocusLongitude;
    }

    public void setFocusLongitude(int i) {
        this.FocusLongitude = i;
    }

    public int getFocusAltitude() {
        return this.FocusAltitude;
    }

    public void setFocusAltitude(int i) {
        this.FocusAltitude = i;
    }

    public int getBeizerParameter() {
        return this.BeizerParameter;
    }

    public void setBeizerParameter(int i) {
        this.BeizerParameter = i;
    }

    public int getAltitudePriorityMode() {
        return this.AltitudePriorityMode;
    }

    public void setAltitudePriorityMode(int i) {
        this.AltitudePriorityMode = i;
    }

    public int getHeadingMode() {
        return this.HeadingMode;
    }

    public void setHeadingMode(int i) {
        this.HeadingMode = i;
    }

    public int getUserdefinedHeading() {
        return this.UserdefinedHeading;
    }

    public void setUserdefinedHeading(int i) {
        this.UserdefinedHeading = i;
    }

    public int getCameraPitch() {
        return this.CameraPitch;
    }

    public void setCameraPitch(int i) {
        this.CameraPitch = i;
    }

    public int getCameraYaw() {
        return this.CameraYaw;
    }

    public void setCameraYaw(int i) {
        this.CameraYaw = i;
    }

    public OrbitInfo getOrbitInfo() {
        return this.OrbitInfo;
    }

    public void setOrbitInfo(OrbitInfo orbitInfo) {
        this.OrbitInfo = orbitInfo;
    }

    public int getNumberOfActions() {
        return this.NumberOfActions;
    }

    public void setNumberOfActions(int i) {
        this.NumberOfActions = i;
    }

    public List<ActionInfo> getActions() {
        return this.Actions;
    }

    public void setActions(List<ActionInfo> list) {
        this.Actions = list;
    }

    public int getParam1() {
        return this.Param1;
    }

    public void setParam1(int i) {
        this.Param1 = i;
    }

    public int getParam2() {
        return this.Param2;
    }

    public void setParam2(int i) {
        this.Param2 = i;
    }

    public int getParam3() {
        return this.Param3;
    }

    public void setParam3(int i) {
        this.Param3 = i;
    }

    public int getParam4() {
        return this.Param4;
    }

    public void setParam4(int i) {
        this.Param4 = i;
    }

    public int getParam5() {
        return this.Param5;
    }

    public void setParam5(int i) {
        this.Param5 = i;
    }

    public int getParam6() {
        return this.Param6;
    }

    public void setParam6(int i) {
        this.Param6 = i;
    }

    public int getParam7() {
        return this.Param7;
    }

    public void setParam7(int i) {
        this.Param7 = i;
    }
}

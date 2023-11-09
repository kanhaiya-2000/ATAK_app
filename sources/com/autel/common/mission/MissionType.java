package com.autel.common.mission;

public enum MissionType {
    Waypoint(1),
    Orbit(2),
    Cylinder(3),
    Panorama(4),
    GPS_Follow(5),
    RECTANGLE(6),
    POLYGON(7),
    ONE_SHORT_VIDEO(8),
    TRIPOD(9),
    IMAGE_STABILITY(10),
    MOTION_DELAY(11),
    UNKNOWN(-1);
    
    private int value;

    private MissionType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static MissionType find(int i) {
        MissionType missionType = Waypoint;
        if (missionType.value == i) {
            return missionType;
        }
        MissionType missionType2 = Orbit;
        if (missionType2.value == i) {
            return missionType2;
        }
        MissionType missionType3 = Cylinder;
        if (missionType3.value == i) {
            return missionType3;
        }
        MissionType missionType4 = Panorama;
        if (missionType4.value == i) {
            return missionType4;
        }
        MissionType missionType5 = GPS_Follow;
        if (missionType5.value == i) {
            return missionType5;
        }
        MissionType missionType6 = RECTANGLE;
        if (missionType6.value == i) {
            return missionType6;
        }
        MissionType missionType7 = POLYGON;
        if (missionType7.value == i) {
            return missionType7;
        }
        MissionType missionType8 = ONE_SHORT_VIDEO;
        if (missionType8.value == i) {
            return missionType8;
        }
        MissionType missionType9 = TRIPOD;
        if (missionType9.value == i) {
            return missionType9;
        }
        MissionType missionType10 = IMAGE_STABILITY;
        if (missionType10.value == i) {
            return missionType10;
        }
        MissionType missionType11 = MOTION_DELAY;
        if (missionType11.value == i) {
            return missionType11;
        }
        return UNKNOWN;
    }
}

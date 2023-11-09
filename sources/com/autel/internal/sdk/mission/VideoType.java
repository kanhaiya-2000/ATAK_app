package com.autel.internal.sdk.mission;

public enum VideoType {
    TYPE_360_SHOOT(0),
    EPIC(1),
    RISE(2),
    FADE_AWAY(3),
    INTO_SKY(4),
    BOOMERANG(5),
    SCREW(6),
    PARABOLA(7),
    ASTEROID(8),
    CIRCLE_ROUND(9),
    UNKNOWN(-1);
    
    private int value;

    private VideoType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static VideoType find(int i) {
        VideoType videoType = TYPE_360_SHOOT;
        if (videoType.getValue() == i) {
            return videoType;
        }
        VideoType videoType2 = EPIC;
        if (videoType2.getValue() == i) {
            return videoType2;
        }
        VideoType videoType3 = RISE;
        if (videoType3.getValue() == i) {
            return videoType3;
        }
        VideoType videoType4 = FADE_AWAY;
        if (videoType4.getValue() == i) {
            return videoType4;
        }
        VideoType videoType5 = INTO_SKY;
        if (videoType5.getValue() == i) {
            return videoType5;
        }
        VideoType videoType6 = BOOMERANG;
        if (videoType6.getValue() == i) {
            return videoType6;
        }
        VideoType videoType7 = SCREW;
        if (videoType7.getValue() == i) {
            return videoType7;
        }
        VideoType videoType8 = PARABOLA;
        if (videoType8.getValue() == i) {
            return videoType8;
        }
        VideoType videoType9 = ASTEROID;
        if (videoType9.getValue() == i) {
            return videoType9;
        }
        VideoType videoType10 = CIRCLE_ROUND;
        if (videoType10.getValue() == i) {
            return videoType10;
        }
        return UNKNOWN;
    }
}

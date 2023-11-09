package com.autel.common.remotecontroller;

public enum TeachingMode {
    DISABLED(0),
    TEACHER(1),
    STUDENT(2),
    UNKNOWN(-1);
    
    private int value;

    private TeachingMode(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static TeachingMode find(int i) {
        TeachingMode teachingMode = DISABLED;
        if (teachingMode.getValue() == i) {
            return teachingMode;
        }
        TeachingMode teachingMode2 = TEACHER;
        if (teachingMode2.getValue() == i) {
            return teachingMode2;
        }
        TeachingMode teachingMode3 = STUDENT;
        if (teachingMode3.getValue() == i) {
            return teachingMode3;
        }
        return UNKNOWN;
    }
}

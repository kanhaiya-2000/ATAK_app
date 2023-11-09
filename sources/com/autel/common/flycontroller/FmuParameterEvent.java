package com.autel.common.flycontroller;

import com.autel.AutelNet2.constant.FmuCmdConstant;

public enum FmuParameterEvent {
    MaxHeight("SM_Max_Height"),
    MaxRange("SM_Max_Range"),
    ReturnHeight("SM_RTH_Height"),
    HorizontalSpeed("SM_Max_v_xy"),
    AscendSpeed("SM_Max_v_z"),
    DescendSpeed("SM_Min_v_z"),
    FreshManMode("SM_Beginner_Mode"),
    AttiModeSwitch("SM_EN_ATT_MODE"),
    RC_YAW_SEN(FmuCmdConstant.RC_YAW_SEN),
    CRITICAL_BATTERY_WARNING(FmuCmdConstant.CRITICAL_BATTERY_WARNING),
    LOW_BATTERY_WARNING(FmuCmdConstant.LOW_BATTERY_WARNING),
    UNKNOWN("UNKNOWN");
    
    private String value;

    private FmuParameterEvent(String str) {
        this.value = str;
    }

    public static FmuParameterEvent find(String str) {
        FmuParameterEvent fmuParameterEvent = MaxHeight;
        if (fmuParameterEvent.value.equals(str)) {
            return fmuParameterEvent;
        }
        FmuParameterEvent fmuParameterEvent2 = MaxRange;
        if (fmuParameterEvent2.value.equals(str)) {
            return fmuParameterEvent2;
        }
        FmuParameterEvent fmuParameterEvent3 = ReturnHeight;
        if (fmuParameterEvent3.value.equals(str)) {
            return fmuParameterEvent3;
        }
        FmuParameterEvent fmuParameterEvent4 = HorizontalSpeed;
        if (fmuParameterEvent4.value.equals(str)) {
            return fmuParameterEvent4;
        }
        FmuParameterEvent fmuParameterEvent5 = AscendSpeed;
        if (fmuParameterEvent5.value.equals(str)) {
            return fmuParameterEvent5;
        }
        FmuParameterEvent fmuParameterEvent6 = DescendSpeed;
        if (fmuParameterEvent6.value.equals(str)) {
            return fmuParameterEvent6;
        }
        FmuParameterEvent fmuParameterEvent7 = FreshManMode;
        if (fmuParameterEvent7.value.equals(str)) {
            return fmuParameterEvent7;
        }
        FmuParameterEvent fmuParameterEvent8 = AttiModeSwitch;
        if (fmuParameterEvent8.value.equals(str)) {
            return fmuParameterEvent8;
        }
        FmuParameterEvent fmuParameterEvent9 = RC_YAW_SEN;
        if (fmuParameterEvent9.value.equals(str)) {
            return fmuParameterEvent9;
        }
        FmuParameterEvent fmuParameterEvent10 = CRITICAL_BATTERY_WARNING;
        if (fmuParameterEvent10.value.equals(str)) {
            return fmuParameterEvent10;
        }
        FmuParameterEvent fmuParameterEvent11 = LOW_BATTERY_WARNING;
        if (fmuParameterEvent11.value.equals(str)) {
            return fmuParameterEvent11;
        }
        return UNKNOWN;
    }
}

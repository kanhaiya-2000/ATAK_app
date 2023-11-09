package com.autel.common.remotecontroller;

public enum CustomFunction {
    NONE(0),
    OA(1),
    AE(2),
    GIMBAL_RESET(3),
    CODEC_SW_MAP(4),
    UNKNOWN(-1);
    
    private int value;

    private CustomFunction(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static CustomFunction find(int i) {
        CustomFunction customFunction = NONE;
        if (customFunction.getValue() == i) {
            return customFunction;
        }
        CustomFunction customFunction2 = OA;
        if (customFunction2.getValue() == i) {
            return customFunction2;
        }
        CustomFunction customFunction3 = AE;
        if (customFunction3.getValue() == i) {
            return customFunction3;
        }
        CustomFunction customFunction4 = GIMBAL_RESET;
        if (customFunction4.getValue() == i) {
            return customFunction4;
        }
        CustomFunction customFunction5 = CODEC_SW_MAP;
        if (customFunction5.getValue() == i) {
            return customFunction5;
        }
        return UNKNOWN;
    }
}

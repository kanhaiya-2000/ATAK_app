package com.autel.common.product;

import com.o3dr.services.android.lib.drone.companion.solo.controller.SoloControllerUnits;

public enum AutelProductType {
    UNKNOWN(SoloControllerUnits.UNKNOWN, -1),
    PREMIUM("X-Star Premium", 0),
    X_STAR("X-Star", 0),
    EVO("EVO", 1),
    EVO_2("EVO_2", 3),
    LIVE_DECK("LiveDeck", 4);
    
    private String desValue;
    private int value;

    private AutelProductType(String str, int i) {
        this.desValue = str;
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public String getDescription() {
        return this.desValue;
    }

    public static AutelProductType find(int i) {
        AutelProductType autelProductType = PREMIUM;
        if (autelProductType.getValue() == i) {
            return autelProductType;
        }
        AutelProductType autelProductType2 = X_STAR;
        if (autelProductType2.getValue() == i) {
            return autelProductType2;
        }
        AutelProductType autelProductType3 = EVO;
        if (autelProductType3.getValue() == i) {
            return autelProductType3;
        }
        AutelProductType autelProductType4 = EVO_2;
        if (autelProductType4.getValue() == i) {
            return autelProductType4;
        }
        AutelProductType autelProductType5 = LIVE_DECK;
        if (autelProductType5.getValue() == i) {
            return autelProductType5;
        }
        return UNKNOWN;
    }
}

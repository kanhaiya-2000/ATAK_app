package com.autel.common.dsp.evo;

public enum RcType {
    EVO(0),
    EVO_2(1),
    LIVE_DECK(3),
    UNKNOWN(-1);
    
    private int value;

    private RcType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static RcType find(int i) {
        RcType rcType = EVO;
        if (rcType.getValue() == i) {
            return rcType;
        }
        RcType rcType2 = EVO_2;
        if (rcType2.getValue() == i) {
            return rcType2;
        }
        RcType rcType3 = LIVE_DECK;
        if (rcType3.getValue() == i) {
            return rcType3;
        }
        return UNKNOWN;
    }
}

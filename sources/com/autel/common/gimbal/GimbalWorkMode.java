package com.autel.common.gimbal;

public enum GimbalWorkMode {
    STABILIZED(21845, 2),
    FPV(43690, 3),
    UNKNOWN(-1, -1);
    

    /* renamed from: g2 */
    private int f8469g2;
    private int xStar;

    private GimbalWorkMode(int i, int i2) {
        this.xStar = i;
        this.f8469g2 = i2;
    }

    public int getValue10() {
        return this.xStar;
    }

    public int getValue20() {
        return this.f8469g2;
    }

    public static GimbalWorkMode find(int i) {
        GimbalWorkMode gimbalWorkMode = STABILIZED;
        if (!(gimbalWorkMode.getValue10() == i || gimbalWorkMode.getValue20() == i)) {
            gimbalWorkMode = FPV;
            if (!(gimbalWorkMode.getValue10() == i || gimbalWorkMode.getValue20() == i)) {
                return UNKNOWN;
            }
        }
        return gimbalWorkMode;
    }
}

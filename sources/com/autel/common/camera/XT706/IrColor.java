package com.autel.common.camera.XT706;

import com.o3dr.services.android.lib.drone.companion.solo.controller.SoloControllerUnits;

public enum IrColor {
    WhiteHot("WhiteHot"),
    BlackHot("BlackHot"),
    RainBow("RainBow"),
    RainHC("RaingHC"),
    IronBow("IronBow"),
    Lava("Lava"),
    Arctic("Arctic"),
    GlowBow("GlowBow"),
    GradedFire("GradedFire"),
    HotTest("HotTest"),
    UNKNOWN(SoloControllerUnits.UNKNOWN);
    
    private final String value;

    private IrColor(String str) {
        this.value = str;
    }

    public String value() {
        return this.value;
    }

    public static IrColor find(String str) {
        IrColor irColor = WhiteHot;
        if (irColor.value().equals(str)) {
            return irColor;
        }
        IrColor irColor2 = BlackHot;
        if (irColor2.value().equals(str)) {
            return irColor2;
        }
        IrColor irColor3 = RainBow;
        if (irColor3.value().equals(str)) {
            return irColor3;
        }
        IrColor irColor4 = RainHC;
        if (irColor4.value().equals(str)) {
            return irColor4;
        }
        IrColor irColor5 = Arctic;
        if (irColor5.value().equals(str)) {
            return irColor5;
        }
        IrColor irColor6 = Lava;
        if (irColor6.value().equals(str)) {
            return irColor6;
        }
        IrColor irColor7 = IronBow;
        if (irColor7.value().equals(str)) {
            return irColor7;
        }
        IrColor irColor8 = GlowBow;
        if (irColor8.value().equals(str)) {
            return irColor8;
        }
        IrColor irColor9 = GradedFire;
        if (irColor9.value().equals(str)) {
            return irColor9;
        }
        IrColor irColor10 = HotTest;
        if (irColor10.value().equals(str)) {
            return irColor10;
        }
        return UNKNOWN;
    }
}

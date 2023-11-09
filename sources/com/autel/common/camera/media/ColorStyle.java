package com.autel.common.camera.media;

import com.o3dr.services.android.lib.drone.companion.solo.controller.SoloControllerUnits;

public enum ColorStyle {
    None("None", "None"),
    Vivid("Vivid", "Vivid"),
    BlackAndWhite("B&W", "B&W"),
    Art("Art", "Art"),
    Film("Film", "Film"),
    Beach("Beach", "Beach"),
    Dream("Dream", "Dream"),
    Classic("Classic", "Classic"),
    Log("Log", "LOG"),
    Nostalgic("Nostalgic", "Nostalgic"),
    UNKNOWN(SoloControllerUnits.UNKNOWN, SoloControllerUnits.UNKNOWN);
    
    private final String value10;
    private final String value20;

    private ColorStyle(String str, String str2) {
        this.value10 = str;
        this.value20 = str2;
    }

    public String value10() {
        return this.value10;
    }

    public String value20() {
        return this.value20;
    }

    public static ColorStyle find(String str) {
        ColorStyle colorStyle = None;
        if (!colorStyle.value10().equals(str) && !colorStyle.value20().equals(str)) {
            colorStyle = Vivid;
            if (!colorStyle.value10().equals(str) && !colorStyle.value20().equals(str)) {
                colorStyle = BlackAndWhite;
                if (!colorStyle.value10().equals(str) && !colorStyle.value20().equals(str)) {
                    colorStyle = Art;
                    if (!colorStyle.value10().equals(str) && !colorStyle.value20().equals(str)) {
                        colorStyle = Film;
                        if (!colorStyle.value10().equals(str) && !colorStyle.value20().equals(str)) {
                            colorStyle = Beach;
                            if (!colorStyle.value10().equals(str) && !colorStyle.value20().equals(str)) {
                                colorStyle = Dream;
                                if (!colorStyle.value10().equals(str) && !colorStyle.value20().equals(str)) {
                                    colorStyle = Classic;
                                    if (!colorStyle.value10().equals(str) && !colorStyle.value20().equals(str)) {
                                        colorStyle = Log;
                                        if (!colorStyle.value10().equals(str) && !colorStyle.value20().equals(str)) {
                                            colorStyle = Nostalgic;
                                            if (!colorStyle.value10().equals(str) && !colorStyle.value20().equals(str)) {
                                                return UNKNOWN;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return colorStyle;
    }
}

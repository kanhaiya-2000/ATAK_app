package com.autel.common.camera.media;

import com.atakmap.android.uastool.prefs.UIPreferenceFragment;
import com.atakmap.android.uastool.trillium.TrilliumPrefHandler;
import com.o3dr.services.android.lib.drone.companion.solo.controller.SoloControllerUnits;

public enum ShutterSpeed {
    ShutterSpeed_15("15s", 0.067f),
    ShutterSpeed_13("13s", 0.077f),
    ShutterSpeed_10("10s", 0.1f),
    ShutterSpeed_9("9s", 0.1112f),
    ShutterSpeed_8("8s", 0.125f),
    ShutterSpeed_6("6s", 0.167f),
    ShutterSpeed_5("5s", 0.2f),
    ShutterSpeed_4("4s", 0.25f),
    ShutterSpeed_3dot2("3.2s", 0.313f),
    ShutterSpeed_3("3s", 0.3334f),
    ShutterSpeed_2dot5("2.5s", 0.4f),
    ShutterSpeed_2("2s", 0.5f),
    ShutterSpeed_1dot6("1.6s", 0.625f),
    ShutterSpeed_1dot3("1.3s", 0.7693f),
    ShutterSpeed_1("1s", 1.0f),
    ShutterSpeed_1_1dot25("1.25", 1.25f),
    ShutterSpeed_1_1dot67("1.67", 1.67f),
    ShutterSpeed_1_2("2", 2.0f),
    ShutterSpeed_1_2dot5("2.5", 2.5f),
    ShutterSpeed_1_3("3", 3.0f),
    ShutterSpeed_1_4("4", 4.0f),
    ShutterSpeed_1_5("5", 5.0f),
    ShutterSpeed_1_6dot25("6.25", 6.25f),
    ShutterSpeed_1_8("8", 8.0f),
    ShutterSpeed_1_10("10", 10.0f),
    ShutterSpeed_1_12dot5("12.5", 12.5f),
    ShutterSpeed_1_15("15", 15.0f),
    ShutterSpeed_1_20("20", 20.0f),
    ShutterSpeed_1_25("25", 25.0f),
    ShutterSpeed_1_30("30", 30.0f),
    ShutterSpeed_1_40("40", 40.0f),
    ShutterSpeed_1_50("50", 50.0f),
    ShutterSpeed_1_60("60", 60.0f),
    ShutterSpeed_1_80("80", 80.0f),
    ShutterSpeed_1_100(UIPreferenceFragment.DEFAULT_UI_SCALE, 100.0f),
    ShutterSpeed_1_120("120", 120.0f),
    ShutterSpeed_1_160("160", 160.0f),
    ShutterSpeed_1_200("200", 200.0f),
    ShutterSpeed_1_240("240", 240.0f),
    ShutterSpeed_1_320("320", 320.0f),
    ShutterSpeed_1_400("400", 400.0f),
    ShutterSpeed_1_500(TrilliumPrefHandler.DEFAULT_PLATFORM_TRILLIUM_VIDEO_BUFFERING, 500.0f),
    ShutterSpeed_1_640("640", 640.0f),
    ShutterSpeed_1_800("800", 800.0f),
    ShutterSpeed_1_1000("1000", 1000.0f),
    ShutterSpeed_1_1250("1250", 1250.0f),
    ShutterSpeed_1_1600("1600", 1600.0f),
    ShutterSpeed_1_2000("2000", 2000.0f),
    ShutterSpeed_1_2500("2500", 2500.0f),
    ShutterSpeed_1_3200("3200", 3200.0f),
    ShutterSpeed_1_4000("4000", 4000.0f),
    ShutterSpeed_1_5000("5000", 5000.0f),
    ShutterSpeed_1_6000("6000", 6000.0f),
    ShutterSpeed_1_8000("8000", 8000.0f),
    UNKNOWN(SoloControllerUnits.UNKNOWN, -1.0f);
    

    /* renamed from: hz */
    private float f8466hz;
    private String value;

    private ShutterSpeed(String str, float f) {
        this.value = str;
        this.f8466hz = f;
    }

    public String getValue() {
        return this.value;
    }

    public float getFrequency() {
        return this.f8466hz;
    }

    public static ShutterSpeed find(String str) {
        ShutterSpeed shutterSpeed = ShutterSpeed_15;
        if (shutterSpeed.getValue().equals(str)) {
            return shutterSpeed;
        }
        ShutterSpeed shutterSpeed2 = ShutterSpeed_13;
        if (shutterSpeed2.getValue().equals(str)) {
            return shutterSpeed2;
        }
        ShutterSpeed shutterSpeed3 = ShutterSpeed_10;
        if (shutterSpeed3.getValue().equals(str)) {
            return shutterSpeed3;
        }
        ShutterSpeed shutterSpeed4 = ShutterSpeed_9;
        if (shutterSpeed4.getValue().equals(str)) {
            return shutterSpeed4;
        }
        ShutterSpeed shutterSpeed5 = ShutterSpeed_8;
        if (shutterSpeed5.getValue().equals(str)) {
            return shutterSpeed5;
        }
        ShutterSpeed shutterSpeed6 = ShutterSpeed_6;
        if (shutterSpeed6.getValue().equals(str)) {
            return shutterSpeed6;
        }
        ShutterSpeed shutterSpeed7 = ShutterSpeed_5;
        if (shutterSpeed7.getValue().equals(str)) {
            return shutterSpeed7;
        }
        ShutterSpeed shutterSpeed8 = ShutterSpeed_4;
        if (shutterSpeed8.getValue().equals(str)) {
            return shutterSpeed8;
        }
        ShutterSpeed shutterSpeed9 = ShutterSpeed_3dot2;
        if (shutterSpeed9.getValue().equals(str)) {
            return shutterSpeed9;
        }
        ShutterSpeed shutterSpeed10 = ShutterSpeed_3;
        if (shutterSpeed10.getValue().equals(str)) {
            return shutterSpeed10;
        }
        ShutterSpeed shutterSpeed11 = ShutterSpeed_2dot5;
        if (shutterSpeed11.getValue().equals(str)) {
            return shutterSpeed11;
        }
        ShutterSpeed shutterSpeed12 = ShutterSpeed_2;
        if (shutterSpeed12.getValue().equals(str)) {
            return shutterSpeed12;
        }
        ShutterSpeed shutterSpeed13 = ShutterSpeed_1dot6;
        if (shutterSpeed13.getValue().equals(str)) {
            return shutterSpeed13;
        }
        ShutterSpeed shutterSpeed14 = ShutterSpeed_1dot3;
        if (shutterSpeed14.getValue().equals(str)) {
            return shutterSpeed14;
        }
        ShutterSpeed shutterSpeed15 = ShutterSpeed_1;
        if (shutterSpeed15.getValue().equals(str)) {
            return shutterSpeed15;
        }
        ShutterSpeed shutterSpeed16 = ShutterSpeed_1_1dot25;
        if (shutterSpeed16.getValue().equals(str)) {
            return shutterSpeed16;
        }
        ShutterSpeed shutterSpeed17 = ShutterSpeed_1_1dot67;
        if (shutterSpeed17.getValue().equals(str)) {
            return shutterSpeed17;
        }
        ShutterSpeed shutterSpeed18 = ShutterSpeed_1_2;
        if (shutterSpeed18.getValue().equals(str)) {
            return shutterSpeed18;
        }
        ShutterSpeed shutterSpeed19 = ShutterSpeed_1_2dot5;
        if (shutterSpeed19.getValue().equals(str)) {
            return shutterSpeed19;
        }
        ShutterSpeed shutterSpeed20 = ShutterSpeed_1_3;
        if (shutterSpeed20.getValue().equals(str)) {
            return shutterSpeed20;
        }
        ShutterSpeed shutterSpeed21 = ShutterSpeed_1_4;
        if (shutterSpeed21.getValue().equals(str)) {
            return shutterSpeed21;
        }
        ShutterSpeed shutterSpeed22 = ShutterSpeed_1_5;
        if (shutterSpeed22.getValue().equals(str)) {
            return shutterSpeed22;
        }
        ShutterSpeed shutterSpeed23 = ShutterSpeed_1_6dot25;
        if (shutterSpeed23.getValue().equals(str)) {
            return shutterSpeed23;
        }
        ShutterSpeed shutterSpeed24 = ShutterSpeed_1_8;
        if (shutterSpeed24.getValue().equals(str)) {
            return shutterSpeed24;
        }
        ShutterSpeed shutterSpeed25 = ShutterSpeed_1_10;
        if (shutterSpeed25.getValue().equals(str)) {
            return shutterSpeed25;
        }
        ShutterSpeed shutterSpeed26 = ShutterSpeed_1_12dot5;
        if (shutterSpeed26.getValue().equals(str)) {
            return shutterSpeed26;
        }
        ShutterSpeed shutterSpeed27 = ShutterSpeed_1_15;
        if (shutterSpeed27.getValue().equals(str)) {
            return shutterSpeed27;
        }
        ShutterSpeed shutterSpeed28 = ShutterSpeed_1_20;
        if (shutterSpeed28.getValue().equals(str)) {
            return shutterSpeed28;
        }
        ShutterSpeed shutterSpeed29 = ShutterSpeed_1_25;
        if (shutterSpeed29.getValue().equals(str)) {
            return shutterSpeed29;
        }
        ShutterSpeed shutterSpeed30 = ShutterSpeed_1_30;
        if (shutterSpeed30.getValue().equals(str)) {
            return shutterSpeed30;
        }
        ShutterSpeed shutterSpeed31 = ShutterSpeed_1_40;
        if (shutterSpeed31.getValue().equals(str)) {
            return shutterSpeed31;
        }
        ShutterSpeed shutterSpeed32 = ShutterSpeed_1_50;
        if (shutterSpeed32.getValue().equals(str)) {
            return shutterSpeed32;
        }
        ShutterSpeed shutterSpeed33 = ShutterSpeed_1_60;
        if (shutterSpeed33.getValue().equals(str)) {
            return shutterSpeed33;
        }
        ShutterSpeed shutterSpeed34 = ShutterSpeed_1_80;
        if (shutterSpeed34.getValue().equals(str)) {
            return shutterSpeed34;
        }
        ShutterSpeed shutterSpeed35 = ShutterSpeed_1_100;
        if (shutterSpeed35.getValue().equals(str)) {
            return shutterSpeed35;
        }
        ShutterSpeed shutterSpeed36 = ShutterSpeed_1_120;
        if (shutterSpeed36.getValue().equals(str)) {
            return shutterSpeed36;
        }
        ShutterSpeed shutterSpeed37 = ShutterSpeed_1_160;
        if (shutterSpeed37.getValue().equals(str)) {
            return shutterSpeed37;
        }
        ShutterSpeed shutterSpeed38 = ShutterSpeed_1_200;
        if (shutterSpeed38.getValue().equals(str)) {
            return shutterSpeed38;
        }
        ShutterSpeed shutterSpeed39 = ShutterSpeed_1_240;
        if (shutterSpeed39.getValue().equals(str)) {
            return shutterSpeed39;
        }
        ShutterSpeed shutterSpeed40 = ShutterSpeed_1_320;
        if (shutterSpeed40.getValue().equals(str)) {
            return shutterSpeed40;
        }
        ShutterSpeed shutterSpeed41 = ShutterSpeed_1_400;
        if (shutterSpeed41.getValue().equals(str)) {
            return shutterSpeed41;
        }
        ShutterSpeed shutterSpeed42 = ShutterSpeed_1_500;
        if (shutterSpeed42.getValue().equals(str)) {
            return shutterSpeed42;
        }
        ShutterSpeed shutterSpeed43 = ShutterSpeed_1_640;
        if (shutterSpeed43.getValue().equals(str)) {
            return shutterSpeed43;
        }
        ShutterSpeed shutterSpeed44 = ShutterSpeed_1_800;
        if (shutterSpeed44.getValue().equals(str)) {
            return shutterSpeed44;
        }
        ShutterSpeed shutterSpeed45 = ShutterSpeed_1_1000;
        if (shutterSpeed45.getValue().equals(str)) {
            return shutterSpeed45;
        }
        ShutterSpeed shutterSpeed46 = ShutterSpeed_1_1250;
        if (shutterSpeed46.getValue().equals(str)) {
            return shutterSpeed46;
        }
        ShutterSpeed shutterSpeed47 = ShutterSpeed_1_1600;
        if (shutterSpeed47.getValue().equals(str)) {
            return shutterSpeed47;
        }
        ShutterSpeed shutterSpeed48 = ShutterSpeed_1_2000;
        if (shutterSpeed48.getValue().equals(str)) {
            return shutterSpeed48;
        }
        ShutterSpeed shutterSpeed49 = ShutterSpeed_1_2500;
        if (shutterSpeed49.getValue().equals(str)) {
            return shutterSpeed49;
        }
        ShutterSpeed shutterSpeed50 = ShutterSpeed_1_3200;
        if (shutterSpeed50.getValue().equals(str)) {
            return shutterSpeed50;
        }
        ShutterSpeed shutterSpeed51 = ShutterSpeed_1_4000;
        if (shutterSpeed51.getValue().equals(str)) {
            return shutterSpeed51;
        }
        ShutterSpeed shutterSpeed52 = ShutterSpeed_1_5000;
        if (shutterSpeed52.getValue().equals(str)) {
            return shutterSpeed52;
        }
        ShutterSpeed shutterSpeed53 = ShutterSpeed_1_6000;
        if (shutterSpeed53.getValue().equals(str)) {
            return shutterSpeed53;
        }
        ShutterSpeed shutterSpeed54 = ShutterSpeed_1_8000;
        return shutterSpeed54.getValue().equals(str) ? shutterSpeed54 : shutterSpeed15;
    }
}

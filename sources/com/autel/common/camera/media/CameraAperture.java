package com.autel.common.camera.media;

public enum CameraAperture {
    Aperture_1p8("1.8"),
    Aperture_2p0("2.0"),
    Aperture_2p2("2.2"),
    Aperture_2p4("2.4"),
    Aperture_2p5("2.5"),
    Aperture_2p8("2.8"),
    Aperture_3p2("3.2"),
    Aperture_3p5("3.5"),
    Aperture_3p6("3.6"),
    Aperture_4p0("4.0"),
    Aperture_4p5("4.5"),
    Aperture_5p0("5.0"),
    Aperture_5p1("5.1"),
    Aperture_5p6("5.6"),
    Aperture_5p7("5.7"),
    Aperture_6p3("6.3"),
    Aperture_6p4("6.4"),
    Aperture_7p1("7.1"),
    Aperture_7p2("7.2"),
    Aperture_8p0("8.0"),
    Aperture_9p0("9.0"),
    Aperture_10("10"),
    Aperture_11("11"),
    UNKNOWN("-1");
    
    private String value;

    private CameraAperture(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }

    public static CameraAperture find(String str) {
        CameraAperture cameraAperture = Aperture_1p8;
        if (cameraAperture.getValue().equals(str)) {
            return cameraAperture;
        }
        CameraAperture cameraAperture2 = Aperture_2p0;
        if (cameraAperture2.getValue().equals(str)) {
            return cameraAperture2;
        }
        CameraAperture cameraAperture3 = Aperture_2p2;
        if (cameraAperture3.getValue().equals(str)) {
            return cameraAperture3;
        }
        CameraAperture cameraAperture4 = Aperture_2p5;
        if (cameraAperture4.getValue().equals(str)) {
            return cameraAperture4;
        }
        CameraAperture cameraAperture5 = Aperture_2p8;
        if (cameraAperture5.getValue().equals(str)) {
            return cameraAperture5;
        }
        CameraAperture cameraAperture6 = Aperture_3p2;
        if (cameraAperture6.getValue().equals(str)) {
            return cameraAperture6;
        }
        CameraAperture cameraAperture7 = Aperture_3p5;
        if (cameraAperture7.getValue().equals(str)) {
            return cameraAperture7;
        }
        CameraAperture cameraAperture8 = Aperture_3p6;
        if (cameraAperture8.getValue().equals(str)) {
            return cameraAperture8;
        }
        CameraAperture cameraAperture9 = Aperture_4p0;
        if (cameraAperture9.getValue().equals(str)) {
            return cameraAperture9;
        }
        CameraAperture cameraAperture10 = Aperture_4p5;
        if (cameraAperture10.getValue().equals(str)) {
            return cameraAperture10;
        }
        CameraAperture cameraAperture11 = Aperture_5p0;
        if (cameraAperture11.getValue().equals(str)) {
            return cameraAperture11;
        }
        CameraAperture cameraAperture12 = Aperture_5p1;
        if (cameraAperture12.getValue().equals(str)) {
            return cameraAperture12;
        }
        CameraAperture cameraAperture13 = Aperture_5p6;
        if (cameraAperture13.getValue().equals(str)) {
            return cameraAperture13;
        }
        CameraAperture cameraAperture14 = Aperture_5p7;
        if (cameraAperture14.getValue().equals(str)) {
            return cameraAperture14;
        }
        CameraAperture cameraAperture15 = Aperture_6p3;
        if (cameraAperture15.getValue().equals(str)) {
            return cameraAperture15;
        }
        CameraAperture cameraAperture16 = Aperture_6p4;
        if (cameraAperture16.getValue().equals(str)) {
            return cameraAperture16;
        }
        CameraAperture cameraAperture17 = Aperture_7p1;
        if (cameraAperture17.getValue().equals(str)) {
            return cameraAperture17;
        }
        CameraAperture cameraAperture18 = Aperture_7p2;
        if (cameraAperture18.getValue().equals(str)) {
            return cameraAperture18;
        }
        CameraAperture cameraAperture19 = Aperture_8p0;
        if (cameraAperture19.getValue().equals(str)) {
            return cameraAperture19;
        }
        CameraAperture cameraAperture20 = Aperture_9p0;
        if (cameraAperture20.getValue().equals(str)) {
            return cameraAperture20;
        }
        CameraAperture cameraAperture21 = Aperture_10;
        if (cameraAperture21.getValue().equals(str)) {
            return cameraAperture21;
        }
        CameraAperture cameraAperture22 = Aperture_11;
        if (cameraAperture22.getValue().equals(str)) {
            return cameraAperture22;
        }
        CameraAperture cameraAperture23 = Aperture_2p4;
        if (cameraAperture23.getValue().equals(str)) {
            return cameraAperture23;
        }
        return UNKNOWN;
    }
}

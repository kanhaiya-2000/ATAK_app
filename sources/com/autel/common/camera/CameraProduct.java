package com.autel.common.camera;

public enum CameraProduct {
    R12("XB004") {
    },
    XB015("XB015") {
    },
    XT701("XT701") {
    },
    XT702("XT702") {
    },
    XT705("XT705") {
    },
    XT706("XT706") {
    },
    XT709("XT709") {
    },
    UNKNOWN("UNKNOWN") {
    };
    
    private String moduleName;

    private CameraProduct(String str) {
        this.moduleName = str;
    }

    public String getValue() {
        return this.moduleName;
    }

    public static CameraProduct find(String str) {
        CameraProduct cameraProduct = R12;
        if (cameraProduct.getValue().equals(str)) {
            return cameraProduct;
        }
        CameraProduct cameraProduct2 = XB015;
        if (cameraProduct2.getValue().equals(str)) {
            return cameraProduct2;
        }
        CameraProduct cameraProduct3 = XT701;
        if (cameraProduct3.getValue().equals(str)) {
            return cameraProduct3;
        }
        if (XT702.getValue().equals(str)) {
            return cameraProduct2;
        }
        CameraProduct cameraProduct4 = XT705;
        if (cameraProduct4.getValue().equals(str)) {
            return cameraProduct4;
        }
        CameraProduct cameraProduct5 = XT706;
        if (cameraProduct5.getValue().equals(str)) {
            return cameraProduct5;
        }
        CameraProduct cameraProduct6 = XT709;
        if (cameraProduct6.getValue().equals(str)) {
            return cameraProduct6;
        }
        return UNKNOWN;
    }
}

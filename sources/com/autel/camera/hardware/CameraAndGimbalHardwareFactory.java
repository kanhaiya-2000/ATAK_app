package com.autel.camera.hardware;

import com.autel.common.camera.CameraProduct;

public final class CameraAndGimbalHardwareFactory {

    /* renamed from: com.autel.camera.hardware.CameraAndGimbalHardwareFactory$1 */
    /* synthetic */ class C22861 {
        static final /* synthetic */ int[] $SwitchMap$com$autel$common$camera$CameraProduct;

        static {
            int[] iArr = new int[CameraProduct.values().length];
            $SwitchMap$com$autel$common$camera$CameraProduct = iArr;
            try {
                iArr[CameraProduct.XB015.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static BaseCameraAndGimbalHardware getCameraAndGimbal(CameraProduct cameraProduct) {
        if (C22861.$SwitchMap$com$autel$common$camera$CameraProduct[cameraProduct.ordinal()] != 1) {
            return null;
        }
        return new XB015CameraAndGimbalHardware();
    }
}

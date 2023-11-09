package com.autel.internal.camera;

import com.autel.common.CallbackWithOneParam;
import com.autel.common.camera.CameraProduct;
import com.autel.common.camera.base.BaseStateInfo;
import com.autel.internal.AutelModuleService;
import com.autel.internal.AutelServiceVersion;
import com.autel.sdk.camera.p005rx.RxAutelBaseCamera;

public class UnknownCamera extends BaseCameraInitializeProxy {
    /* access modifiers changed from: protected */
    public AutelModuleService buildConnection(AutelServiceVersion autelServiceVersion) {
        return null;
    }

    public void getCurrentRecordTime(CallbackWithOneParam<Integer> callbackWithOneParam) {
    }

    public void getStateInfo(CallbackWithOneParam<BaseStateInfo> callbackWithOneParam) {
    }

    public RxAutelBaseCamera toRx() {
        return null;
    }

    public CameraProduct getProduct() {
        return CameraProduct.UNKNOWN;
    }
}

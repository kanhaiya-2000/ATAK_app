package com.autel.internal.camera;

import com.autel.common.camera.CameraProduct;
import com.autel.internal.AutelListenerManager;
import com.autel.internal.AutelServiceVersion;
import com.autel.internal.camera.flir.CameraFlirDuo;
import com.autel.internal.camera.flir.CameraFlirDuoPreconditionProxy;
import com.autel.internal.camera.flir.CameraFlirDuoService;
import com.autel.internal.camera.flirR.CameraFlirDuoR;
import com.autel.internal.camera.flirR.CameraFlirDuoRPreconditionProxy;
import com.autel.internal.camera.flirR.CameraFlirDuoRService;
import com.autel.internal.camera.product.CameraManager;
import com.autel.internal.camera.product.CameraManagerService;
import com.autel.internal.camera.r12.CameraR12;
import com.autel.internal.camera.r12.CameraR12InitializeProxy;
import com.autel.internal.camera.r12.CameraR12PreconditionProxy;
import com.autel.internal.camera.r12.CameraR12Service;
import com.autel.internal.camera.xbbasic.xb015.CameraXb015Impl;
import com.autel.internal.camera.xbbasic.xb015.CameraXb015InitializeProxy;
import com.autel.internal.camera.xbbasic.xb015.CameraXb015PreconditionProxy;
import com.autel.internal.camera.xbbasic.xb015.CameraXb015Service;
import com.autel.internal.camera.xbbasic.xt701.CameraXT701Impl;
import com.autel.internal.camera.xbbasic.xt701.CameraXT701InitializeProxy;
import com.autel.internal.camera.xbbasic.xt701.CameraXT701PreconditionProxy;
import com.autel.internal.camera.xbbasic.xt701.CameraXT701Service;
import com.autel.internal.camera.xbbasic.xt705.CameraXT705Impl;
import com.autel.internal.camera.xbbasic.xt705.CameraXT705InitializeProxy;
import com.autel.internal.camera.xbbasic.xt705.CameraXT705PreconditionProxy;
import com.autel.internal.camera.xbbasic.xt705.CameraXT705Service;
import com.autel.internal.camera.xbbasic.xt706.CameraXT706Impl;
import com.autel.internal.camera.xbbasic.xt706.CameraXT706InitializeProxy;
import com.autel.internal.camera.xbbasic.xt706.CameraXT706PreconditionProxy;
import com.autel.internal.camera.xbbasic.xt706.CameraXT706Service;
import com.autel.internal.camera.xbbasic.xt709.CameraXT709Impl;
import com.autel.internal.camera.xbbasic.xt709.CameraXT709InitializeProxy;
import com.autel.internal.camera.xbbasic.xt709.CameraXT709PreconditionProxy;
import com.autel.internal.camera.xbbasic.xt709.CameraXT709Service;

public class CameraFactory {
    public static CameraManagerService createCameraManager() {
        return CameraManager.instance();
    }

    public static BaseCameraService4Initialize createCameraServer4Initialize(CameraProduct cameraProduct, AutelListenerManager autelListenerManager) {
        switch (C28411.$SwitchMap$com$autel$common$camera$CameraProduct[cameraProduct.ordinal()]) {
            case 1:
                return new CameraR12InitializeProxy(autelListenerManager);
            case 2:
                return new CameraXb015InitializeProxy(autelListenerManager);
            case 3:
                return new CameraXT701InitializeProxy(autelListenerManager);
            case 4:
                return new CameraXT705InitializeProxy(autelListenerManager);
            case 5:
                return new CameraXT706InitializeProxy(autelListenerManager);
            case 6:
                return new CameraXT709InitializeProxy(autelListenerManager);
            default:
                return new UnknownCamera();
        }
    }

    /* renamed from: com.autel.internal.camera.CameraFactory$1 */
    /* synthetic */ class C28411 {
        static final /* synthetic */ int[] $SwitchMap$com$autel$common$camera$CameraProduct;
        static final /* synthetic */ int[] $SwitchMap$com$autel$internal$AutelServiceVersion;

        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|(3:19|20|22)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(19:0|1|2|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0038 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0059 */
        static {
            /*
                com.autel.internal.AutelServiceVersion[] r0 = com.autel.internal.AutelServiceVersion.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$autel$internal$AutelServiceVersion = r0
                r1 = 1
                com.autel.internal.AutelServiceVersion r2 = com.autel.internal.AutelServiceVersion.SERVICE_10     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$com$autel$internal$AutelServiceVersion     // Catch:{ NoSuchFieldError -> 0x001d }
                com.autel.internal.AutelServiceVersion r3 = com.autel.internal.AutelServiceVersion.SERVICE_20     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                com.autel.common.camera.CameraProduct[] r2 = com.autel.common.camera.CameraProduct.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                $SwitchMap$com$autel$common$camera$CameraProduct = r2
                com.autel.common.camera.CameraProduct r3 = com.autel.common.camera.CameraProduct.R12     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r1 = $SwitchMap$com$autel$common$camera$CameraProduct     // Catch:{ NoSuchFieldError -> 0x0038 }
                com.autel.common.camera.CameraProduct r2 = com.autel.common.camera.CameraProduct.XB015     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                int[] r0 = $SwitchMap$com$autel$common$camera$CameraProduct     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.autel.common.camera.CameraProduct r1 = com.autel.common.camera.CameraProduct.XT701     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = $SwitchMap$com$autel$common$camera$CameraProduct     // Catch:{ NoSuchFieldError -> 0x004e }
                com.autel.common.camera.CameraProduct r1 = com.autel.common.camera.CameraProduct.XT705     // Catch:{ NoSuchFieldError -> 0x004e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r0 = $SwitchMap$com$autel$common$camera$CameraProduct     // Catch:{ NoSuchFieldError -> 0x0059 }
                com.autel.common.camera.CameraProduct r1 = com.autel.common.camera.CameraProduct.XT706     // Catch:{ NoSuchFieldError -> 0x0059 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0059 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0059 }
            L_0x0059:
                int[] r0 = $SwitchMap$com$autel$common$camera$CameraProduct     // Catch:{ NoSuchFieldError -> 0x0064 }
                com.autel.common.camera.CameraProduct r1 = com.autel.common.camera.CameraProduct.XT709     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.autel.internal.camera.CameraFactory.C28411.<clinit>():void");
        }
    }

    public static CameraR12Service createXb004(AutelServiceVersion autelServiceVersion) {
        int i = C28411.$SwitchMap$com$autel$internal$AutelServiceVersion[autelServiceVersion.ordinal()];
        if (i == 1 || i == 2) {
            return new CameraR12PreconditionProxy(new CameraR12());
        }
        return new CameraR12PreconditionProxy(new CameraR12());
    }

    public static CameraFlirDuoService createFlir(AutelServiceVersion autelServiceVersion) {
        int i = C28411.$SwitchMap$com$autel$internal$AutelServiceVersion[autelServiceVersion.ordinal()];
        if (i == 1 || i == 2) {
            return new CameraFlirDuoPreconditionProxy(new CameraFlirDuo());
        }
        return new CameraFlirDuoPreconditionProxy(new CameraFlirDuo());
    }

    public static CameraFlirDuoRService createFlirR(AutelServiceVersion autelServiceVersion) {
        int i = C28411.$SwitchMap$com$autel$internal$AutelServiceVersion[autelServiceVersion.ordinal()];
        if (i == 1 || i == 2) {
            return new CameraFlirDuoRPreconditionProxy(new CameraFlirDuoR());
        }
        return new CameraFlirDuoRPreconditionProxy(new CameraFlirDuoR());
    }

    public static CameraXb015Service createXb015(AutelServiceVersion autelServiceVersion) {
        return new CameraXb015PreconditionProxy(new CameraXb015Impl());
    }

    public static CameraXT701Service createXT701(AutelServiceVersion autelServiceVersion) {
        return new CameraXT701PreconditionProxy(new CameraXT701Impl());
    }

    public static CameraXT706Service createXT706(AutelServiceVersion autelServiceVersion) {
        return new CameraXT706PreconditionProxy(new CameraXT706Impl());
    }

    public static CameraXT709Service createXT709(AutelServiceVersion autelServiceVersion) {
        return new CameraXT709PreconditionProxy(new CameraXT709Impl());
    }

    public static CameraXT705Service createXT705(AutelServiceVersion autelServiceVersion) {
        return new CameraXT705PreconditionProxy(new CameraXT705Impl());
    }
}

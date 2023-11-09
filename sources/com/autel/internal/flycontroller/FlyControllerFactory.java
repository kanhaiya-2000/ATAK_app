package com.autel.internal.flycontroller;

import com.autel.internal.AutelServiceVersion;
import com.autel.internal.flycontroller.evo.EvoFlyController;
import com.autel.internal.flycontroller.evo.EvoFlyControllerInitializeProxy;
import com.autel.internal.flycontroller.evo.EvoFlyControllerService;
import com.autel.internal.flycontroller.evo.EvoFlyControllerService4Initialize;
import com.autel.internal.flycontroller.evo2.Evo2FlyController;
import com.autel.internal.flycontroller.evo2.Evo2FlyControllerInitializeProxy;
import com.autel.internal.flycontroller.evo2.Evo2FlyControllerService;
import com.autel.internal.flycontroller.evo2.Evo2FlyControllerService4Initialize;
import com.autel.internal.flycontroller.xstar.XStarFlyController;
import com.autel.internal.flycontroller.xstar.XStarFlyControllerInitializeProxy;
import com.autel.internal.flycontroller.xstar.XStarFlyControllerService;
import com.autel.internal.flycontroller.xstar.XStarFlyControllerService4Initialize;
import com.autel.sdk10.AutelNet.AutelFlyController.parser.FlyControllerStatusInternalParser;
import com.autel.sdk10.AutelNet.AutelFlyController.parser.GPSInfoInternalParser;

public class FlyControllerFactory {

    /* renamed from: com.autel.internal.flycontroller.FlyControllerFactory$1 */
    /* synthetic */ class C43181 {
        static final /* synthetic */ int[] $SwitchMap$com$autel$internal$AutelServiceVersion;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.autel.internal.AutelServiceVersion[] r0 = com.autel.internal.AutelServiceVersion.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$autel$internal$AutelServiceVersion = r0
                com.autel.internal.AutelServiceVersion r1 = com.autel.internal.AutelServiceVersion.SERVICE_10     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$autel$internal$AutelServiceVersion     // Catch:{ NoSuchFieldError -> 0x001d }
                com.autel.internal.AutelServiceVersion r1 = com.autel.internal.AutelServiceVersion.SERVICE_20     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.autel.internal.flycontroller.FlyControllerFactory.C43181.<clinit>():void");
        }
    }

    public static XStarFlyControllerService createXStarFlyController(AutelServiceVersion autelServiceVersion) {
        if (C43181.$SwitchMap$com$autel$internal$AutelServiceVersion[autelServiceVersion.ordinal()] != 1) {
            return new XStarFlyController();
        }
        return new XStarFlyController();
    }

    public static EvoFlyControllerService createG2FlyController(AutelServiceVersion autelServiceVersion) {
        int i = C43181.$SwitchMap$com$autel$internal$AutelServiceVersion[autelServiceVersion.ordinal()];
        if (i == 1) {
            return new EvoFlyController();
        }
        if (i != 2) {
            return new EvoFlyController();
        }
        return new EvoFlyController();
    }

    public static Evo2FlyControllerService createEvo2FlyController(AutelServiceVersion autelServiceVersion) {
        return new Evo2FlyController();
    }

    public static XStarFlyControllerService4Initialize createXStarFlyController() {
        return new XStarFlyControllerInitializeProxy(FlyControllerStatusInternalParser.getInstance_(), GPSInfoInternalParser.getInstance_());
    }

    public static EvoFlyControllerService4Initialize createG2FlyController() {
        return new EvoFlyControllerInitializeProxy();
    }

    public static Evo2FlyControllerService4Initialize createEvo2FlyController() {
        return new Evo2FlyControllerInitializeProxy();
    }
}

package com.autel.internal.gimbal;

import com.autel.internal.AutelServiceVersion;
import com.autel.internal.gimbal.evo.EvoGimbalImpl;
import com.autel.internal.gimbal.evo.EvoGimbalInitializeProxy;
import com.autel.internal.gimbal.evo.EvoGimbalService;
import com.autel.internal.gimbal.evo.EvoGimbalService4Initialize;
import com.autel.internal.gimbal.xstar.XStarGimbalImpl;
import com.autel.internal.gimbal.xstar.XStarGimbalInitializeProxy;
import com.autel.internal.gimbal.xstar.XStarGimbalService;
import com.autel.internal.gimbal.xstar.XStarGimbalService4Initialize;

public class GimbalFactory {

    /* renamed from: com.autel.internal.gimbal.GimbalFactory$1 */
    /* synthetic */ class C45861 {
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
            throw new UnsupportedOperationException("Method not decompiled: com.autel.internal.gimbal.GimbalFactory.C45861.<clinit>():void");
        }
    }

    public static GimbalService createGimbal(AutelServiceVersion autelServiceVersion) {
        int i = C45861.$SwitchMap$com$autel$internal$AutelServiceVersion[autelServiceVersion.ordinal()];
        if (i == 1) {
            return new XStarGimbalImpl();
        }
        if (i != 2) {
            return new XStarGimbalImpl();
        }
        return new XStarGimbalImpl();
    }

    public static XStarGimbalService createXStarGimbal(AutelServiceVersion autelServiceVersion) {
        return new XStarGimbalImpl();
    }

    public static EvoGimbalService createG2Gimbal(AutelServiceVersion autelServiceVersion) {
        return new EvoGimbalImpl();
    }

    public static EvoGimbalService4Initialize createG2Gimbal() {
        return new EvoGimbalInitializeProxy();
    }

    public static XStarGimbalService4Initialize createXStarGimbal() {
        return new XStarGimbalInitializeProxy();
    }
}

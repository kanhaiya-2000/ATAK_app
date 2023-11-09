package com.autel.internal.product;

import com.autel.common.product.AutelProductType;
import com.autel.internal.AutelServiceVersion;
import com.autel.internal.autel.IAutelStateManager;

public class ProductFactory {
    public static XStarAircraftImpl createXStar(AutelServiceVersion autelServiceVersion, IAutelStateManager iAutelStateManager) {
        return new XStarAircraftImpl(iAutelStateManager, autelServiceVersion);
    }

    /* renamed from: com.autel.internal.product.ProductFactory$1 */
    /* synthetic */ class C47951 {
        static final /* synthetic */ int[] $SwitchMap$com$autel$common$product$AutelProductType;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.autel.common.product.AutelProductType[] r0 = com.autel.common.product.AutelProductType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$autel$common$product$AutelProductType = r0
                com.autel.common.product.AutelProductType r1 = com.autel.common.product.AutelProductType.X_STAR     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$autel$common$product$AutelProductType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.autel.common.product.AutelProductType r1 = com.autel.common.product.AutelProductType.PREMIUM     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$autel$common$product$AutelProductType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.autel.common.product.AutelProductType r1 = com.autel.common.product.AutelProductType.EVO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$autel$common$product$AutelProductType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.autel.common.product.AutelProductType r1 = com.autel.common.product.AutelProductType.EVO_2     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.autel.internal.product.ProductFactory.C47951.<clinit>():void");
        }
    }

    public static BaseProductImpl createProduct(AutelProductType autelProductType, AutelServiceVersion autelServiceVersion, IAutelStateManager iAutelStateManager) {
        int i = C47951.$SwitchMap$com$autel$common$product$AutelProductType[autelProductType.ordinal()];
        if (i == 1) {
            return new XStarAircraftImpl(iAutelStateManager, autelServiceVersion);
        }
        if (i == 2) {
            return new XStarPremAircraftImpl(iAutelStateManager, autelServiceVersion);
        }
        if (i == 3) {
            return new EvoAircraftImpl(iAutelStateManager, autelServiceVersion);
        }
        if (i != 4) {
            return new UnknownProduct(iAutelStateManager, autelServiceVersion);
        }
        return new Evo2AircraftImpl(iAutelStateManager, autelServiceVersion);
    }
}

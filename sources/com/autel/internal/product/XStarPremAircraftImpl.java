package com.autel.internal.product;

import com.autel.common.product.AutelProductType;
import com.autel.internal.AutelServiceVersion;
import com.autel.internal.autel.IAutelStateManager;
import com.autel.sdk.product.XStarPremiumAircraft;

public class XStarPremAircraftImpl extends XStarAircraftImpl implements XStarPremiumAircraft {
    public XStarPremAircraftImpl(IAutelStateManager iAutelStateManager, AutelServiceVersion autelServiceVersion) {
        super(iAutelStateManager, autelServiceVersion);
    }

    public AutelProductType getType() {
        return AutelProductType.PREMIUM;
    }
}

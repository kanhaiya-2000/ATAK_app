package com.autel.sdk10.AutelNet.AutelFlyController.interfaces;

import com.autel.internal.sdk.flycontroller.AutelFlyControllerStatusInternal;
import com.autel.internal.sdk.flycontroller.AutelWarningInternal;

public class IAutelFlyControllerInterfaces {

    public interface IFlyControllerErrorWarningListener {
        void onErrorWarning(AutelWarningInternal autelWarningInternal);
    }

    public interface IFlyControllerStatusListener {
        void onFlyControllerStatus(AutelFlyControllerStatusInternal autelFlyControllerStatusInternal);
    }
}

package com.autel.sdk10.AutelNet.AutelRemoteController.interfaces;

import com.autel.common.remotecontroller.RemoteControllerNavigateButtonEvent;

public interface IUdpRcvCallback {
    void receiverData(RemoteControllerNavigateButtonEvent remoteControllerNavigateButtonEvent);
}

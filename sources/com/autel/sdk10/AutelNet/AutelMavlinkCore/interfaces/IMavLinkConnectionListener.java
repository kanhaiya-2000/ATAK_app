package com.autel.sdk10.AutelNet.AutelMavlinkCore.interfaces;

import com.MAVLink.Messages.MAVLinkMessage;

public interface IMavLinkConnectionListener {
    void onComError(String str);

    void onConnect();

    void onDisconnect();

    void onReceiveMessage(MAVLinkMessage mAVLinkMessage);
}

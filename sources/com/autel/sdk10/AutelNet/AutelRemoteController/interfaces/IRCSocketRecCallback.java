package com.autel.sdk10.AutelNet.AutelRemoteController.interfaces;

import com.autel.sdk10.interfaces.IAutelConnectionStatusListener;

public interface IRCSocketRecCallback extends IAutelConnectionStatusListener {
    void getRecData(byte[] bArr);
}

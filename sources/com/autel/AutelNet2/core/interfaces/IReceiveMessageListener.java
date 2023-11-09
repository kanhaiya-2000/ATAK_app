package com.autel.AutelNet2.core.interfaces;

import com.autel.AutelNet2.core.message.BaseMsgPacket;

public interface IReceiveMessageListener {
    void onReceiveMessage(BaseMsgPacket baseMsgPacket);
}

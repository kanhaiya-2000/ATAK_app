package com.autel.internal.autel.heartbeat;

import com.autel.common.product.AutelProductType;
import com.autel.internal.AutelServiceVersion;

public interface HeartBeatListener {
    void connect(AutelServiceVersion autelServiceVersion, AutelProductType autelProductType);

    void disconnect();
}

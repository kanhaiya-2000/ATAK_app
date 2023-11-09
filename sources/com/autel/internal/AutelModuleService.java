package com.autel.internal;

import com.autel.internal.autel.IAutelStateManager;

public interface AutelModuleService {
    void connect();

    void destroy();

    void disconnect();

    void init(IAutelStateManager iAutelStateManager);
}

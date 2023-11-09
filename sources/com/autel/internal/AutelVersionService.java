package com.autel.internal;

import com.autel.internal.autel.IAutelStateManager;

public interface AutelVersionService {
    void connect(AutelServiceVersion autelServiceVersion);

    void destroy();

    void disconnect();

    void init(IAutelStateManager iAutelStateManager);
}

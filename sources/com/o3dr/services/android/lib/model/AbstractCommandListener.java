package com.o3dr.services.android.lib.model;

import com.o3dr.services.android.lib.model.ICommandListener;

public abstract class AbstractCommandListener extends ICommandListener.Stub {
    public abstract void onError(int i);

    public abstract void onSuccess();

    public abstract void onTimeout();
}

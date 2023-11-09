package com.o3dr.android.client.apis;

import com.o3dr.android.client.Drone;
import com.o3dr.services.android.lib.model.AbstractCommandListener;
import java.util.concurrent.ConcurrentHashMap;

public abstract class Api {

    protected interface Builder<T extends Api> {
        T build(Drone drone);
    }

    protected static <T extends Api> T getApi(Drone drone, ConcurrentHashMap<Drone, T> concurrentHashMap, Builder<T> builder) {
        if (drone == null || concurrentHashMap == null) {
            return null;
        }
        T t = (Api) concurrentHashMap.get(drone);
        if (t != null || builder == null) {
            return t;
        }
        T build = builder.build(drone);
        T t2 = (Api) concurrentHashMap.putIfAbsent(drone, build);
        return t2 != null ? t2 : build;
    }

    protected static void postSuccessEvent(AbstractCommandListener abstractCommandListener) {
        if (abstractCommandListener != null) {
            abstractCommandListener.onSuccess();
        }
    }

    protected static void postErrorEvent(int i, AbstractCommandListener abstractCommandListener) {
        if (abstractCommandListener != null) {
            abstractCommandListener.onError(i);
        }
    }

    protected static void postTimeoutEvent(AbstractCommandListener abstractCommandListener) {
        if (abstractCommandListener != null) {
            abstractCommandListener.onTimeout();
        }
    }
}

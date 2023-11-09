package com.autel.internal;

import java.util.HashMap;
import java.util.Map;

public class AutelListenerCache {
    Map<String, Object> listeners = new HashMap();

    /* access modifiers changed from: protected */
    public void cacheListener(String str, Object obj) {
        this.listeners.put(str, obj);
    }

    public Object pop(String str) {
        return this.listeners.remove(str);
    }

    public void clear() {
        this.listeners.clear();
    }

    public void cache(String str, Object obj) {
        if (obj == null) {
            pop(str);
        } else {
            cacheListener(str, obj);
        }
    }
}

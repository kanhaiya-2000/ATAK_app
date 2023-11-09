package com.atakmap.android.uastool.p000av;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.atakmap.android.uastool.av.GCSUplinkMessageSet */
class GCSUplinkMessageSet {
    private final List<GCSUplinkMessage> messageSet = new ArrayList();

    GCSUplinkMessageSet() {
    }

    /* access modifiers changed from: package-private */
    public void addMessage(GCSUplinkMessage gCSUplinkMessage) {
        this.messageSet.add(gCSUplinkMessage);
    }

    public List<GCSUplinkMessage> getSet() {
        return this.messageSet;
    }
}

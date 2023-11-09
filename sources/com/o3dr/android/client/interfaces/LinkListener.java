package com.o3dr.android.client.interfaces;

import com.o3dr.services.android.lib.gcs.link.LinkConnectionStatus;

public interface LinkListener {
    void onLinkStateUpdated(LinkConnectionStatus linkConnectionStatus);
}

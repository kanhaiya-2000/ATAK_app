package com.autel.sdk10.products;

import com.autel.sdk10.AutelNet.AutelMavlinkCore.controller.StarLinkClientManager;
import com.autel.sdk10.products.requestmanager.AutelProductRequestManager;

public final class AutelProductManager extends AutelProductRequestManager {
    private AutelProductManager() {
    }

    public static synchronized void openConnection() {
        synchronized (AutelProductManager.class) {
            StarLinkClientManager.getInstance_().openConnection();
        }
    }

    public static synchronized void closeConnection() {
        synchronized (AutelProductManager.class) {
            StarLinkClientManager.getInstance_().closeConnection();
        }
    }
}

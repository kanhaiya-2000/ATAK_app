package com.autel.libupdrage.upgrade;

import com.autel.libupdrage.upgrade.impl.AutelUpgradeImpl;

public class UpgradeManager extends AutelUpgradeImpl {
    private static UpgradeManager instance;

    public static UpgradeManager getInstance() {
        if (instance == null) {
            instance = new UpgradeManager();
        }
        return instance;
    }

    private UpgradeManager() {
        init();
    }
}

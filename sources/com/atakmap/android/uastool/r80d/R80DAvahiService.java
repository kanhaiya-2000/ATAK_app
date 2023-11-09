package com.atakmap.android.uastool.r80d;

import android.content.Context;
import com.atakmap.android.uastool.UASConfigSelector;
import com.atakmap.android.uastool.pagers.avahi.AvahiServiceInfo;
import com.atakmap.android.uastool.utils.AvahiService;
import java.util.ArrayList;

public class R80DAvahiService extends AvahiService {
    public R80DAvahiService(Context context) {
        super(context, (ArrayList<String>) null);
    }

    public void start() {
        listChanged();
        R80dMonitor.avahiService = this;
    }

    public void clear() {
        UASConfigSelector.cyclePlatformMonitor();
    }

    public void stop() {
        R80dMonitor.avahiService = null;
    }

    public ArrayList<AvahiServiceInfo> getList() {
        return R80dMonitor.getAvailableDevices();
    }

    public void dispose() {
        this.listChangeListeners.clear();
        stop();
    }
}

package com.atakmap.android.uastool.generic;

import android.content.Context;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.plugin.PlatformMonitor;
import java.util.ArrayList;
import java.util.List;

public class GenericMonitor extends PlatformMonitor {
    private final List<UASItem> uasList = new ArrayList();

    public void setCaptureToStorage(boolean z) {
    }

    public GenericMonitor(Context context) {
        super(context, GenericUASItem.DISPLAY_NAME);
    }

    public boolean monitors(String str) {
        return str.equals(GenericUASItem.DISPLAY_NAME);
    }

    public List<UASItem> getDetectedUasList() {
        String str = "UAS-" + UASToolDropDownReceiver.getInstance().getMapView().getDeviceCallsign();
        this.uasList.add(new GenericUASItem(str, str, false));
        return this.uasList;
    }

    public void beginMonitoring(boolean z) {
        super.beginMonitoring(z);
    }

    public void endMonitoring() {
        super.endMonitoring();
    }
}

package com.atakmap.android.uastool;

import com.atakmap.android.maps.MapView;
import com.atakmap.android.maps.af;

class UASToolMapListener {
    public static final String TAG = "UASToolMapListener";
    private final af mapDispatcher = MapView.getMapView().getMapEventDispatcher();

    public void addOnMapEventListener(af.a aVar, String str) {
        this.mapDispatcher.c(str, aVar);
    }

    public void removeOnMapEventListener(af.a aVar, String str) {
        this.mapDispatcher.d(str, aVar);
    }
}

package com.atakmap.android.uastool.tasks;

import android.graphics.Color;
import com.atakmap.android.maps.ai;
import com.atakmap.android.maps.ao;
import com.atakmap.android.maps.av;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.utils.UasMapItemIconUtil;
import com.atakmap.android.uastool.utils.Utils;
import com.atakmap.android.util.j;
import com.atakmap.coremap.maps.coords.GeoPoint;
import com.atakmap.map.elevation.ElevationManager;
import java.util.UUID;

public class QuickTaskMarker extends ao implements av.a {
    protected av.a markerChangedListener;
    private final UASItem parentUasItem;
    /* access modifiers changed from: private */
    public final j quickWaypointCircle;
    protected av.a wayPointChangedListener;

    public QuickTaskMarker(UASItem uASItem) {
        super(UUID.randomUUID().toString() + "_waypoint");
        this.parentUasItem = uASItem;
        mo10277a(new GeoPoint(0.0d, 0.0d));
        setZOrder(-10000.0d);
        setTitle("Quick FlyTo");
        setVisible(false);
        setMovable(true);
        setClickable(true);
        setMetaString("how", "h-e");
        setTouchable(true);
        setEditable(true);
        setMetaBoolean("movable", true);
        setMetaBoolean("clickable", true);
        setWaypointIcon(C1877R.drawable.waypoint, "#00FF00");
        j jVar = new j(F(), 1.0d);
        this.quickWaypointCircle = jVar;
        jVar.setStrokeColor(Color.parseColor("#00FF00"));
        jVar.setStrokeWeight(2.0d);
        jVar.setBasicLineStyle(1);
        jVar.setVisible(false);
        jVar.setTouchable(false);
        jVar.setClickable(false);
        jVar.setEditable(false);
        jVar.setMovable(false);
        a(new av.a() {
            public void onPointChanged(av avVar) {
                QuickTaskMarker.this.quickWaypointCircle.a(avVar.F());
            }
        });
    }

    public void setWayPointVisible(GeoPoint geoPoint, double d, av.a aVar) {
        UASItem uASItem;
        av.a aVar2 = this.wayPointChangedListener;
        if (aVar2 != null) {
            b(aVar2);
            this.wayPointChangedListener = null;
        }
        if (!(this.markerChangedListener == null || (uASItem = this.parentUasItem) == null || uASItem.getMarker() == null)) {
            this.parentUasItem.getMarker().b(this.markerChangedListener);
            this.markerChangedListener = null;
        }
        if (geoPoint == null) {
            setVisible(this, false);
            setVisible(this.quickWaypointCircle, false);
        } else {
            mo10277a(geoPoint);
            setVisible(this, true);
            if (d > 0.0d) {
                this.quickWaypointCircle.a(d);
                setTitle("Quick Orbit");
                setWaypointIcon(C1877R.drawable.orbitpoint, "#00FF00");
                setVisible(this.quickWaypointCircle, true);
            } else {
                setTitle("Quick FlyTo");
                setWaypointIcon(C1877R.drawable.waypoint, "#00FF00");
                setVisible(this.quickWaypointCircle, false);
            }
            UASItem uASItem2 = this.parentUasItem;
            if (!(uASItem2 == null || uASItem2.getMarker() == null)) {
                ao marker = this.parentUasItem.getMarker();
                this.markerChangedListener = this;
                marker.a(this);
            }
        }
        if (aVar != null) {
            this.wayPointChangedListener = aVar;
            a(aVar);
        }
    }

    public void updateDtedAltitude(GeoPoint geoPoint) {
        double a = ElevationManager.a(geoPoint.getLatitude(), geoPoint.getLongitude(), (ElevationManager.b) null);
        if (!Double.isNaN(a)) {
            a(String.format("%s AGL", new Object[]{Utils.formatAlt(geoPoint.getAltitude() - a)}));
            return;
        }
        a(String.format("%s HAE", new Object[]{Utils.formatAlt(geoPoint.getAltitude())}));
    }

    private void setWaypointIcon(int i, String str) {
        a(UasMapItemIconUtil.buildIcon(i, UasMapItemIconUtil.ICON_SIZE.SMALL, UasMapItemIconUtil.ICON_ANCHOR.MIDDLE_CENTER, Color.parseColor(str)));
    }

    public void onPointChanged(av avVar) {
        UASItem uASItem;
        if (avVar.C().distanceTo(C()) < 3.0d) {
            setVisible(this, false);
            setVisible(this.quickWaypointCircle, false);
            if (!(this.markerChangedListener == null || (uASItem = this.parentUasItem) == null || uASItem.getMarker() == null)) {
                this.parentUasItem.getMarker().b(this.markerChangedListener);
                this.markerChangedListener = null;
            }
            av.a aVar = this.wayPointChangedListener;
            if (aVar != null) {
                b(aVar);
                this.wayPointChangedListener = null;
            }
        }
    }

    private void setVisible(ai aiVar, boolean z) {
        aiVar.setVisible(z);
        if (z) {
            UASItem.getUASToolGroup().d(aiVar);
        } else {
            UASItem.getUASToolGroup().g(aiVar);
        }
    }

    /* renamed from: a */
    public void mo10277a(GeoPoint geoPoint) {
        av.a aVar = this.wayPointChangedListener;
        if (aVar != null) {
            b(aVar);
        }
        QuickTaskMarker.super.a(geoPoint);
        av.a aVar2 = this.wayPointChangedListener;
        if (aVar2 != null) {
            a(aVar2);
        }
        updateDtedAltitude(geoPoint);
    }
}

package com.atakmap.android.uastool.tasks.route;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListView;
import atak.core.rd;
import com.atakmap.android.maps.DoghouseReceiver;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.maps.ae;
import com.atakmap.android.maps.af;
import com.atakmap.android.maps.av;
import com.atakmap.android.maps.q;
import com.atakmap.android.routes.RouteMapReceiver;
import com.atakmap.android.routes.e;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.UASToolScreen;
import com.atakmap.android.uastool.pagers.TasksFragment;
import com.atakmap.android.uastool.plugin.C1877R;
import java.util.Iterator;

public class UASRouteImport extends UASToolScreen {
    private static final String TAG = "UASRouteImport";
    private UASRouteImportAdapter atakAdapter;
    private e drawnRoute;
    /* access modifiers changed from: private */
    public String platform;
    private final Context pluginContext;
    private final af.a routeClickListener = new af.a() {
        public void onMapEvent(ae aeVar) {
            e eVar;
            if (aeVar != null && aeVar.b() != null) {
                e eVar2 = null;
                if (aeVar.b() instanceof e) {
                    eVar = (e) aeVar.b();
                } else if (aeVar.b() instanceof av) {
                    av b = aeVar.b();
                    if (UASRoute.WAYPOINT_TYPE.equals(b.getType()) || UASRoute.CHECKPOINT_TYPE.equals(b.getType())) {
                        eVar = RouteMapReceiver.a().a(b);
                    } else {
                        UASToolDropDownReceiver.toast("Not a Route Point", 0);
                        return;
                    }
                } else if (aeVar.b() instanceof q) {
                    String metaString = aeVar.b().getMetaString("routeUID", "");
                    if (metaString.length() > 0) {
                        Iterator it = RouteMapReceiver.a().g().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            e eVar3 = (e) it.next();
                            if (eVar3.getUID().equals(metaString)) {
                                eVar2 = eVar3;
                                break;
                            }
                        }
                    }
                    eVar = eVar2;
                } else {
                    UASToolDropDownReceiver.toast("Not a Route Item", 0);
                    return;
                }
                if (eVar == null) {
                    UASToolDropDownReceiver.toast("Failed to get Route from Selection", 0);
                    return;
                }
                ((TasksFragment) UASRouteImport.this.myParentFragment).createATAKRouteTask(eVar, UASRouteImport.this.platform);
                UASToolDropDownReceiver.toast("Successfully Imported Route", 0);
                UASRouteImport.this.closeScreen();
            }
        }
    };

    public UASRouteImport(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.pluginContext = context;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setFocusableInTouchMode(true);
        requestFocus();
        setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 1 && i == 4) {
                    return UASRouteImport.this.onBackButton();
                }
                return false;
            }
        });
        UASRouteImportAdapter uASRouteImportAdapter = new UASRouteImportAdapter(this.pluginContext, this, RouteMapReceiver.a().g());
        this.atakAdapter = uASRouteImportAdapter;
        ((ListView) findViewById(C1877R.C1878id.routeimport_atak_list)).setAdapter(uASRouteImportAdapter);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void init(String str) {
        this.platform = str;
        MapView.getMapView().getMapEventDispatcher().a();
        clearExtraListeners();
        rd.a().a("Select Route from Map");
        MapView.getMapView().getMapEventDispatcher().c("item_click", this.routeClickListener);
    }

    /* access modifiers changed from: protected */
    public void clearExtraListeners() {
        MapView.getMapView().getMapEventDispatcher().a("item_click");
        MapView.getMapView().getMapEventDispatcher().a("map_click");
        MapView.getMapView().getMapEventDispatcher().a("map_confirmed_click");
        MapView.getMapView().getMapEventDispatcher().a("map_lngpress");
        MapView.getMapView().getMapEventDispatcher().a("item_lngpress");
        MapView.getMapView().getMapEventDispatcher().a("item_press");
        MapView.getMapView().getMapEventDispatcher().a("item_release");
    }

    private void stopMapListener() {
        MapView.getMapView().getMapEventDispatcher().b();
        rd.a().d();
    }

    /* access modifiers changed from: protected */
    public av getFirstPoint(e eVar) {
        int numPoints = eVar.getNumPoints();
        if (numPoints <= 0) {
            return null;
        }
        if (eVar.k()) {
            return eVar.getPointMapItem(numPoints - 1);
        }
        return eVar.getPointMapItem(0);
    }

    /* access modifiers changed from: protected */
    public void panToView(e eVar) {
        av firstPoint = getFirstPoint(eVar);
        if (firstPoint == null || firstPoint.C() == null) {
            UASToolDropDownReceiver.toast("Unable to pan to first route point", 0);
        } else {
            MapView.getMapView().getMapController().panTo(firstPoint.C(), true);
        }
        e eVar2 = this.drawnRoute;
        if (eVar2 != null) {
            eVar2.setVisible(false);
        }
        eVar.setMetaBoolean("showDoghouses", false);
        DoghouseReceiver.b().d(eVar);
        eVar.setVisible(true);
        this.drawnRoute = eVar;
    }

    /* access modifiers changed from: protected */
    public void importRoute(e eVar) {
        ((TasksFragment) this.myParentFragment).createATAKRouteTask(eVar, this.platform);
        closeScreen();
    }

    /* access modifiers changed from: private */
    public boolean onBackButton() {
        closeScreen();
        return true;
    }

    /* access modifiers changed from: private */
    public void closeScreen() {
        e eVar = this.drawnRoute;
        if (eVar != null) {
            eVar.setVisible(false);
        }
        stopMapListener();
        this.myParentFragment.removeCurrentScreen();
    }
}

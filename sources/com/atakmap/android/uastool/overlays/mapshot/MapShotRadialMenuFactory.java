package com.atakmap.android.uastool.overlays.mapshot;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import atak.core.d;
import atak.core.lj;
import com.atakmap.android.ipc.AtakBroadcast;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.maps.ai;
import com.atakmap.android.menu.a;
import com.atakmap.android.menu.c;
import com.atakmap.android.menu.e;
import com.atakmap.android.menu.i;
import com.atakmap.android.menu.j;
import com.atakmap.android.menu.k;
import com.atakmap.android.widgets.ad;
import com.atakmap.android.widgets.ae;
import com.atakmap.android.widgets.q;
import java.io.IOException;
import java.util.Iterator;

public class MapShotRadialMenuFactory implements c {
    private static final String TAG = "MapShotRadialMenuFactory";
    private final Context appContext;
    private final j defaultFactory;
    private final Context pluginContext;

    public MapShotRadialMenuFactory(Context context) {
        MapView mapView = MapView.getMapView();
        this.pluginContext = context;
        Context context2 = mapView.getContext();
        this.appContext = context2;
        lj ljVar = new lj(context2);
        i iVar = new i();
        try {
            iVar.a(ljVar, "filters/menu_filters.xml");
        } catch (IOException e) {
            Log.d(TAG, "Unable to create adapter for MapShotRadialMenuFactory", e);
        }
        this.defaultFactory = new j(mapView, mapView.getMapData(), ljVar, iVar);
    }

    /* renamed from: a */
    public e mo8940a(ai aiVar) {
        ad adVar;
        float f;
        float f2;
        int i;
        int i2;
        if (!aiVar.getMetaString("type", "").equals("b-i-x-i")) {
            return null;
        }
        e a = this.defaultFactory.a(aiVar);
        if (a != null) {
            Iterator it = a.j().iterator();
            while (true) {
                if (!it.hasNext()) {
                    adVar = null;
                    f = 0.0f;
                    f2 = 0.0f;
                    i = 0;
                    i2 = 0;
                    break;
                }
                a aVar = (q) it.next();
                if (aVar instanceof a) {
                    a aVar2 = aVar;
                    ad j = aVar2.j();
                    int a2 = aVar2.i().a();
                    int b = aVar2.i().b();
                    f2 = aVar2.r();
                    f = aVar2.q();
                    i = a2;
                    adVar = j;
                    i2 = b;
                    break;
                }
            }
            a.a(createButton("icons/camera_map_light.png", new d() {
                /* renamed from: a */
                public void mo8941a(MapView mapView, ai aiVar) {
                    MapShotController.toggleOrWriteLayer(aiVar.getUID());
                    AtakBroadcast.a().a(new Intent("com.atakmap.android.maps.UNFOCUS"));
                    AtakBroadcast.a().a(new Intent("com.atakmap.android.maps.HIDE_DETAILS"));
                    AtakBroadcast.a().a(new Intent("com.atakmap.android.maps.HIDE_MENU"));
                }
            }, adVar, i, i2));
            float f3 = 0.0f;
            float f4 = 0.0f;
            float f5 = 0.0f;
            for (a aVar3 : a.j()) {
                if (aVar3 instanceof a) {
                    a aVar4 = aVar3;
                    f3 += aVar4.D();
                    f5 += aVar4.E();
                    f4 += 1.0f;
                }
            }
            float f6 = f3 / f4;
            float f7 = f5 / f4;
            a.e(90.0f);
            a.c(-90.0f);
            a.d(60.0f);
            a.b(false);
            for (a aVar5 : a.j()) {
                if (aVar5 instanceof a) {
                    a aVar6 = aVar5;
                    aVar6.a(f6);
                    aVar6.e(f6, f7);
                    aVar5.a(0.0f, 0.0f);
                    aVar6.c(f, f2);
                }
            }
        }
        return a;
    }

    private a createButton(String str, d dVar, ad adVar, int i, int i2) {
        a aVar = new a(this.appContext);
        aVar.a(createWidgetIcon(str, i, i2));
        aVar.a(dVar);
        aVar.a(adVar);
        return aVar;
    }

    private ae createWidgetIcon(String str, int i, int i2) {
        String b = k.b(this.pluginContext, str);
        if (b.length() == 0) {
            b = "asset://" + str;
        }
        Log.d("WidgetIconPath", b);
        return new ae.a().a(0, com.atakmap.android.maps.ad.b(b)).a(i, i2).b(32, 32).a();
    }
}

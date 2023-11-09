package com.atakmap.android.uastool.overlays.mapshot;

import android.content.Context;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Toast;
import atak.core.es;
import atak.core.ev;
import atak.core.ex;
import atak.core.ey;
import atak.core.fi;
import atak.core.fm;
import com.atakmap.android.hierarchy.c;
import com.atakmap.android.hierarchy.d;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.maps.ag;
import com.atakmap.android.maps.ai;
import com.atakmap.android.maps.ar;
import com.atakmap.android.maps.n;
import com.atakmap.android.maps.o;
import com.atakmap.android.menu.MapMenuReceiver;
import com.atakmap.android.menu.h;
import com.atakmap.android.menu.k;
import com.atakmap.android.overlay.a;
import com.atakmap.android.uastool.overlays.moasic.SurfaceLayer;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.util.b;
import com.atakmap.coremap.maps.coords.GeoBounds;
import com.atakmap.coremap.maps.coords.GeoPoint;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class UASToolMapLayerOverlay extends a {
    private static final String TAG = "UASToolMapOverlay";
    private static final String mapGroupName = "UAS Tool Items";
    private final o _group;
    private UASToolListModel _listModel;
    /* access modifiers changed from: private */
    public final MapView _mapView;
    /* access modifiers changed from: private */
    public final Context _plugin;
    private final UASToolDeepMapItemQuery _query = new UASToolDeepMapItemQuery();

    public String getIdentifier() {
        return TAG;
    }

    public UASToolMapLayerOverlay(MapView mapView, Context context) {
        this._mapView = mapView;
        this._plugin = context;
        o oVar = new o(mapGroupName);
        this._group = oVar;
        oVar.setMetaBoolean("addToObjList", false);
    }

    public String getName() {
        return this._plugin.getResources().getString(C1877R.string.uas_tool_imaging_overlay_name);
    }

    public ag getRootGroup() {
        return this._group;
    }

    public n getQueryFunction() {
        return this._query;
    }

    public d getListModel(BaseAdapter baseAdapter, long j, c cVar) {
        if (this._listModel == null) {
            this._listModel = new UASToolListModel();
        }
        this._listModel.refresh(baseAdapter, cVar);
        return this._listModel;
    }

    /* access modifiers changed from: private */
    public List<SurfaceLayer> getLayers() {
        ArrayList arrayList = new ArrayList();
        for (SurfaceLayer surfaceLayer : this._mapView.c(MapView.a.c)) {
            if (surfaceLayer instanceof SurfaceLayer) {
                SurfaceLayer surfaceLayer2 = surfaceLayer;
                ar metaShape = surfaceLayer2.getMetaShape();
                if (metaShape.getGroup() == null) {
                    this._group.d(metaShape);
                }
                arrayList.add(surfaceLayer2);
            }
        }
        return arrayList;
    }

    public SurfaceLayer findLayer(String str) {
        SurfaceLayer layerFromQueue = MapShotController.getLayerFromQueue(str);
        if (layerFromQueue instanceof SurfaceLayer) {
            return layerFromQueue;
        }
        SurfaceLayer layerFromMapView = MapShotController.getLayerFromMapView(str);
        if (layerFromMapView instanceof SurfaceLayer) {
            return layerFromMapView;
        }
        return null;
    }

    public class UASToolListModel extends fi implements View.OnClickListener, ev, ey {
        private static final String TAG = "UASToolListModel";
        private View _footer;
        private View _header;

        public int getDescendantCount() {
            return 0;
        }

        public View getExtraView() {
            return null;
        }

        public View getFooterView() {
            return null;
        }

        public View getHeaderView() {
            return null;
        }

        public int getPreferredListIndex() {
            return 5;
        }

        public Object getUserObject() {
            return this;
        }

        public boolean hideIfEmpty() {
            return true;
        }

        public boolean isMultiSelectSupported() {
            return false;
        }

        public UASToolListModel() {
            this.asyncRefresh = true;
        }

        public String getTitle() {
            return UASToolMapLayerOverlay.this.getName();
        }

        public String getIconUri() {
            return k.b(UASToolMapLayerOverlay.this._plugin, "icons/camera_map_light.png");
        }

        public void refreshImpl() {
            ArrayList arrayList = new ArrayList();
            for (SurfaceLayer layerHierarchyListItem : UASToolMapLayerOverlay.this.getLayers()) {
                LayerHierarchyListItem layerHierarchyListItem2 = new LayerHierarchyListItem(layerHierarchyListItem);
                if (this.filter.accept(layerHierarchyListItem2)) {
                    arrayList.add(layerHierarchyListItem2);
                }
            }
            sortItems(arrayList);
            updateChildren(arrayList);
        }

        public void dispose() {
            disposeChildren();
        }

        public boolean setVisible(boolean z) {
            List<ex> childActions = getChildActions(ex.class);
            boolean z2 = !childActions.isEmpty();
            for (ex visible : childActions) {
                z2 &= visible.setVisible(z);
            }
            return z2;
        }

        public Set<d> find(String str) {
            String lowerCase = str.toLowerCase();
            HashSet hashSet = new HashSet();
            for (d dVar : getChildren()) {
                if (dVar.getTitle().toLowerCase().contains(lowerCase)) {
                    hashSet.add(dVar);
                }
            }
            return hashSet;
        }

        public void onClick(View view) {
            if (view instanceof Button) {
                Toast.makeText(UASToolMapLayerOverlay.this._mapView.getContext(), ((Button) view).getText(), 1).show();
            }
        }
    }

    private class LayerHierarchyListItem extends fi implements es, ex, fm {
        private final SurfaceLayer _layer;

        public int getDescendantCount() {
            return 0;
        }

        public boolean hideIfEmpty() {
            return false;
        }

        public boolean isChildSupported() {
            return false;
        }

        public void refreshImpl() {
        }

        LayerHierarchyListItem(SurfaceLayer surfaceLayer) {
            this._layer = surfaceLayer;
        }

        public String getTitle() {
            SurfaceLayer surfaceLayer = this._layer;
            return surfaceLayer != null ? surfaceLayer.getFriendlyName() : "";
        }

        public String getDescription() {
            return this._layer.getName();
        }

        public String getIconUri() {
            return k.b(UASToolMapLayerOverlay.this._plugin, "icons/camera_map_light.png");
        }

        public Object getUserObject() {
            return this._layer;
        }

        public boolean setVisible(boolean z) {
            SurfaceLayer surfaceLayer = this._layer;
            if (surfaceLayer == null || z == surfaceLayer.isVisible()) {
                return false;
            }
            MapShotController.toggleOrWriteLayer(this._layer.getName());
            return true;
        }

        public boolean isVisible() {
            SurfaceLayer surfaceLayer = this._layer;
            if (surfaceLayer != null) {
                return surfaceLayer.isVisible();
            }
            return false;
        }

        public ai getMapItem() {
            SurfaceLayer surfaceLayer = this._layer;
            if (surfaceLayer != null) {
                return surfaceLayer.getMetaShape();
            }
            return null;
        }

        public boolean goTo(boolean z) {
            h c;
            if (this._layer == null) {
                return false;
            }
            b.a(UASToolMapLayerOverlay.this._mapView, this._layer.getPoints(), UASToolMapLayerOverlay.this._mapView.getWidth(), UASToolMapLayerOverlay.this._mapView.getHeight());
            if (!z || (c = MapMenuReceiver.c()) == null) {
                return false;
            }
            c.a(this._layer.getMetaShape());
            return true;
        }
    }

    private class UASToolDeepMapItemQuery implements n {
        public ai deepFindClosestItem(GeoPoint geoPoint, double d, Map<String, String> map) {
            return null;
        }

        public ai deepFindItem(Map<String, String> map) {
            return null;
        }

        public Collection<ai> deepFindItems(GeoPoint geoPoint, double d, Map<String, String> map) {
            return null;
        }

        public List<ai> deepFindItems(Map<String, String> map) {
            return null;
        }

        private UASToolDeepMapItemQuery() {
        }

        public ai deepHitTest(int i, int i2, GeoPoint geoPoint, MapView mapView) {
            for (SurfaceLayer surfaceLayer : UASToolMapLayerOverlay.this.getLayers()) {
                if (surfaceLayer.isVisible() && surfaceLayer.getBounds().contains(geoPoint)) {
                    return surfaceLayer.getMetaShape();
                }
            }
            return null;
        }

        public SortedSet<ai> deepHitTestItems(int i, int i2, GeoPoint geoPoint, MapView mapView) {
            TreeSet treeSet = new TreeSet(ai.ZORDER_HITTEST_COMPARATOR);
            for (SurfaceLayer surfaceLayer : UASToolMapLayerOverlay.this.getLayers()) {
                if (surfaceLayer.isVisible() && surfaceLayer.getBounds().contains(geoPoint)) {
                    treeSet.add(surfaceLayer.getMetaShape());
                }
            }
            return treeSet;
        }

        public Collection<ai> deepFindItems(GeoBounds geoBounds, Map<String, String> map) {
            TreeSet treeSet = new TreeSet(ai.ZORDER_HITTEST_COMPARATOR);
            for (SurfaceLayer surfaceLayer : UASToolMapLayerOverlay.this.getLayers()) {
                if (surfaceLayer.isVisible() && surfaceLayer.getBounds().intersects(geoBounds)) {
                    treeSet.add(surfaceLayer.getMetaShape());
                }
            }
            return treeSet;
        }
    }
}

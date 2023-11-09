package com.atakmap.android.uastool.tasks.route;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.maps.av;
import com.atakmap.android.routes.e;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.prefs.AtakPrefConstants;
import com.atakmap.coremap.conversions.CoordinateFormat;
import com.atakmap.coremap.conversions.CoordinateFormatUtilities;
import java.util.ArrayList;

public class UASRouteImportAdapter extends ArrayAdapter<e> {
    private static final String TAG = UASPointAdapter.class.getSimpleName();
    private final SharedPreferences atakPrefs = UASToolDropDownReceiver.getInstance().getAtakPrefs();
    /* access modifiers changed from: private */
    public final UASRouteImport myScreen;
    /* access modifiers changed from: private */
    public final Context pluginContext;
    /* access modifiers changed from: private */
    public ImageView visibleView;

    public UASRouteImportAdapter(Context context, UASRouteImport uASRouteImport, ArrayList<e> arrayList) {
        super(context, 0, arrayList);
        this.pluginContext = context;
        this.myScreen = uASRouteImport;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        final e eVar = (e) getItem(i);
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(C1877R.layout.uasroute_import_item, viewGroup, false);
        }
        final ImageView imageView = (ImageView) view.findViewById(C1877R.C1878id.routeimport_item_visible);
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                UASRouteImportAdapter.this.myScreen.panToView(eVar);
                if (UASRouteImportAdapter.this.visibleView != null) {
                    UASRouteImportAdapter.this.visibleView.setImageDrawable(UASRouteImportAdapter.this.pluginContext.getDrawable(C1877R.drawable.item_unselected));
                }
                imageView.setImageDrawable(UASRouteImportAdapter.this.pluginContext.getDrawable(C1877R.drawable.item_selected));
                ImageView unused = UASRouteImportAdapter.this.visibleView = imageView;
            }
        });
        ((TextView) view.findViewById(C1877R.C1878id.routeimport_item_name)).setText(eVar.getTitle());
        ((TextView) view.findViewById(C1877R.C1878id.routeimport_item_desc)).setText(getDescription(eVar));
        ((ImageButton) view.findViewById(C1877R.C1878id.routeimport_item_select)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                UASRouteImportAdapter.this.myScreen.importRoute(eVar);
            }
        });
        return view;
    }

    private String getDescription(e eVar) {
        av firstPoint = this.myScreen.getFirstPoint(eVar);
        if (firstPoint == null || firstPoint.C() == null) {
            return this.pluginContext.getResources().getString(C1877R.string.routeimport_nodesc);
        }
        return CoordinateFormatUtilities.formatToString(firstPoint.C(), CoordinateFormat.find(this.atakPrefs.getString(AtakPrefConstants.COORD_DISP_PREF, MapView.getMapView().getContext().getString(2131624580))));
    }
}

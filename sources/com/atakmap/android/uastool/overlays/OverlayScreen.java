package com.atakmap.android.uastool.overlays;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.AttributeSet;
import android.widget.ListView;
import android.widget.TextView;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolScreen;
import com.atakmap.android.uastool.pagers.UASToolFragment;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.prefs.UASToolPreferenceFragment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class OverlayScreen extends UASToolScreen implements SharedPreferences.OnSharedPreferenceChangeListener {
    public static final String PREF_OVERLAY = "uastool.overlay.";
    private static Map<String, String> optionMap;
    private SharedPreferences sharedPrefs;

    public OverlayScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TAG = OverlayScreen.class.getSimpleName();
    }

    public static String getOptionName(String str) {
        return PREF_OVERLAY + optionMap.get(str);
    }

    public void init(UASItem uASItem, UASToolFragment uASToolFragment) {
        super.init(uASItem, uASToolFragment);
        this.sharedPrefs = PreferenceManager.getDefaultSharedPreferences(MapView.getMapView().getContext());
        optionMap = uASItem.getOverlayTypes();
        ((TextView) findViewById(C1877R.C1878id.overlay_title_text)).setText("Labels");
        ListView listView = (ListView) findViewById(C1877R.C1878id.overlay_listview);
        OverlayOption[] overlayOptionArr = new OverlayOption[optionMap.size()];
        int i = 0;
        for (Map.Entry next : optionMap.entrySet()) {
            overlayOptionArr[i] = new OverlayOption((String) next.getKey(), this.sharedPrefs.getBoolean(getOptionName((String) next.getKey()), false));
            i++;
        }
        listView.setAdapter(new OverlayAdapter(this.pluginContext, new ArrayList(Arrays.asList(overlayOptionArr))));
        this.sharedPrefs.registerOnSharedPreferenceChangeListener(this);
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (str.equals(UASToolPreferenceFragment.PREF_CALLSIGN)) {
            TextView textView = (TextView) findViewById(C1877R.C1878id.overlay_title_text);
            textView.setText(sharedPreferences.getString(UASToolPreferenceFragment.PREF_CALLSIGN, "???") + " - Labels");
            textView.invalidate();
        }
    }

    public void destroy() {
        this.sharedPrefs.unregisterOnSharedPreferenceChangeListener(this);
        super.destroy();
    }
}

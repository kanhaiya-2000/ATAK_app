package com.atakmap.android.uastool.pagers.video_ui.default_ui.operator;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.pagers.ControlFragment;
import com.atakmap.android.uastool.pagers.UASToolPager;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.MapWidget;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.PipVideoWidget;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.prefs.UIPreferenceFragment;

public class OperatorFullUIView extends OperatorUIView {
    public static final String TAG = "OperatorFullUIView";
    protected MapWidget mapWidget;
    protected PipVideoWidget pipVideoWidget;

    public OperatorFullUIView(Context context) {
        super(context);
    }

    public OperatorFullUIView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public OperatorFullUIView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mapWidget = (MapWidget) findViewById(C1877R.C1878id.video_ui_mapwidget);
        this.pipVideoWidget = (PipVideoWidget) findViewById(C1877R.C1878id.video_ui_pip_videowidget);
    }

    public void init(ControlFragment controlFragment, UASToolPager uASToolPager, UASItem uASItem) {
        MapWidget mapWidget2 = (MapWidget) findViewById(C1877R.C1878id.video_ui_mapwidget);
        this.mapWidget = mapWidget2;
        if (mapWidget2 != null) {
            mapWidget2.init(this, uASItem);
        }
        PipVideoWidget pipVideoWidget2 = this.pipVideoWidget;
        if (pipVideoWidget2 != null) {
            pipVideoWidget2.init(this, uASItem);
        }
        super.init(controlFragment, uASToolPager, uASItem);
    }

    public void updateOSDImpl() {
        super.updateOSDImpl();
        if (this.uasItem != null) {
            this.mapWidget.updateOSD();
            this.pipVideoWidget.updateOSD();
        }
    }

    /* access modifiers changed from: protected */
    public void showOSD(final boolean z) {
        super.showOSD(z);
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                SharedPreferences sharedPrefs = UASToolDropDownReceiver.getSharedPrefs();
                int i = 0;
                OperatorFullUIView.this.mapWidget.setVisibility((!z || !sharedPrefs.getBoolean(UIPreferenceFragment.PREF_UI_MINI_MAP_ON, UIPreferenceFragment.DEFAULT_UI_MINI_MAP_ON.booleanValue())) ? 4 : 0);
                PipVideoWidget pipVideoWidget = OperatorFullUIView.this.pipVideoWidget;
                if (!z || !sharedPrefs.getBoolean(UIPreferenceFragment.PREF_UI_PIP_ON, UIPreferenceFragment.DEFAULT_UI_PIP_ON.booleanValue())) {
                    i = 4;
                }
                pipVideoWidget.setVisibility(i);
                OperatorFullUIView.this.invalidate();
            }
        });
    }

    public void onAccessoryChange() {
        super.onAccessoryChange();
        this.mapWidget.onAccessoryChange();
        this.pipVideoWidget.onAccessoryChange();
    }

    /* access modifiers changed from: protected */
    public void showMap(final boolean z) {
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                OperatorFullUIView.this.mapWidget.setVisibility((!z || !UASToolDropDownReceiver.getSharedPrefs().getBoolean(UIPreferenceFragment.PREF_UI_MINI_MAP_ON, UIPreferenceFragment.DEFAULT_UI_MINI_MAP_ON.booleanValue())) ? 4 : 0);
                OperatorFullUIView.this.invalidate();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void showPip(final boolean z) {
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                OperatorFullUIView.this.pipVideoWidget.setVisibility((!z || !UASToolDropDownReceiver.getSharedPrefs().getBoolean(UIPreferenceFragment.PREF_UI_PIP_ON, UIPreferenceFragment.DEFAULT_UI_PIP_ON.booleanValue())) ? 4 : 0);
                OperatorFullUIView.this.invalidate();
            }
        });
    }
}

package com.atakmap.android.uastool.pagers.video_ui.default_ui;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.prefs.UIPreferenceFragment;

public abstract class BackgroundWidget extends VideoWidget {
    public static final String TAG = "BackgroundWidget";
    protected int backColor;
    protected GradientDrawable backDrawable;

    public BackgroundWidget(Context context) {
        super(context);
    }

    public BackgroundWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BackgroundWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode()) {
            this.backDrawable = (GradientDrawable) getBackground().mutate();
            setColor(Color.parseColor(UASToolDropDownReceiver.getSharedPrefs().getString(UIPreferenceFragment.PREF_OSD_BACKGROUND_COLOR, UIPreferenceFragment.DEFAULT_OSD_BACKGROUND_COLOR)));
        }
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        super.onSharedPreferenceChanged(sharedPreferences, str);
        str.hashCode();
        if (str.equals(UIPreferenceFragment.PREF_OSD_BACKGROUND_COLOR)) {
            osdColorChanged(sharedPreferences.getString(UIPreferenceFragment.PREF_OSD_BACKGROUND_COLOR, UIPreferenceFragment.DEFAULT_OSD_BACKGROUND_COLOR));
        }
    }

    public void osdColorChanged(String str) {
        setColor(Color.parseColor(str));
    }

    public void setColor(int i) {
        this.backColor = i;
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                BackgroundWidget.this.backDrawable.setColor(BackgroundWidget.this.backColor);
            }
        });
    }
}

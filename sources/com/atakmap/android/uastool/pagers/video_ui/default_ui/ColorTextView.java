package com.atakmap.android.uastool.pagers.video_ui.default_ui;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.TextView;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.prefs.UIPreferenceFragment;

public class ColorTextView extends TextView implements SharedPreferences.OnSharedPreferenceChangeListener {
    public static final String TAG = "ColorTextView";

    public ColorTextView(Context context) {
        super(context);
    }

    public ColorTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ColorTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public ColorTextView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode()) {
            SharedPreferences sharedPrefs = UASToolDropDownReceiver.getSharedPrefs();
            setTextColor(Color.parseColor(sharedPrefs.getString(UIPreferenceFragment.PREF_OSD_TEXT_COLOR, UIPreferenceFragment.DEFAULT_OSD_TEXT_COLOR)));
            sharedPrefs.registerOnSharedPreferenceChangeListener(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        UASToolDropDownReceiver.getSharedPrefs().unregisterOnSharedPreferenceChangeListener(this);
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        str.hashCode();
        if (str.equals(UIPreferenceFragment.PREF_OSD_TEXT_COLOR)) {
            osdTextColorChanged(sharedPreferences.getString(UIPreferenceFragment.PREF_OSD_TEXT_COLOR, UIPreferenceFragment.PREF_OSD_TEXT_COLOR));
        }
    }

    private void osdTextColorChanged(final String str) {
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                ColorTextView.this.setTextColor(Color.parseColor(str));
                ColorTextView.this.invalidate();
            }
        });
    }
}

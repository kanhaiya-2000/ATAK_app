package com.atakmap.android.uastool.pagers.video_ui.default_ui;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import android.widget.TextView;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.pagers.video_ui.VideoUIBase;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.prefs.UASToolPreferenceFragment;

public class TextLeftWidget extends MovableWidget {
    public static final String TAG = "TextLeftWidget";
    /* access modifiers changed from: private */
    public TextView uasAltitudeText;
    private TextView uasCallsignText;
    private TextView uasCoordinatesText;
    private TextView uasRangeBearingText;

    public TextLeftWidget(Context context) {
        super(context);
    }

    public TextLeftWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TextLeftWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.uasCallsignText = (TextView) findViewById(C1877R.C1878id.textleft_uas_callsign);
        this.uasCoordinatesText = (TextView) findViewById(C1877R.C1878id.textleft_uas_coordinates);
        this.uasRangeBearingText = (TextView) findViewById(C1877R.C1878id.textleft_uas_rangebearing);
        this.uasAltitudeText = (TextView) findViewById(C1877R.C1878id.textleft_uas_altitude);
        if (!isInEditMode()) {
            UASToolDropDownReceiver.getSharedPrefs().registerOnSharedPreferenceChangeListener(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        UASToolDropDownReceiver.getSharedPrefs().unregisterOnSharedPreferenceChangeListener(this);
    }

    public void init(VideoUIView videoUIView, final UASItem uASItem) {
        super.init(videoUIView, uASItem);
        if (!isInEditMode()) {
            ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
                public void run() {
                    TextLeftWidget.this.setCallsign();
                    if (uASItem.supportsAltitude()) {
                        TextLeftWidget.this.uasAltitudeText.setVisibility(0);
                    } else {
                        TextLeftWidget.this.uasAltitudeText.setVisibility(8);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void setCallsign() {
        this.uasCallsignText.setText(this.uasItem.getCallsign());
    }

    public void updateOSD() {
        if (this.uasItem == null || this.uasItem.isStale()) {
            this.uasCoordinatesText.setText(C1877R.string.dashdashdash);
            this.uasRangeBearingText.setText(C1877R.string.dashdashdash);
            this.uasAltitudeText.setText(C1877R.string.dashdashdash);
            return;
        }
        if (this.uasItem.getBatteryPercent() <= 0.2d) {
            this.uasCallsignText.setTextColor(-65536);
        } else {
            this.uasCallsignText.setTextColor(this.defaultTextColor);
        }
        this.uasCoordinatesText.setText(VideoUIBase.getAircraftCoordsDisplay(this.uasItem));
        this.uasRangeBearingText.setText(VideoUIBase.getRaBToAircraftDisplay(this.uasItem));
        this.uasAltitudeText.setText(VideoUIBase.getAltitudeDisplay(this.uasItem));
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        super.onSharedPreferenceChanged(sharedPreferences, str);
        str.hashCode();
        if (str.equals(UASToolPreferenceFragment.PREF_CALLSIGN)) {
            setCallsign();
        }
    }
}

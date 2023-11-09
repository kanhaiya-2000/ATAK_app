package com.atakmap.android.uastool;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.prefs.AtakPrefConstants;
import com.atakmap.android.uastool.utils.UASToolConstants;
import com.atakmap.coremap.conversions.Span;

public abstract class SettingsScreen extends UASToolScreen {
    protected float altMultiplier;
    protected Span altUnits;
    protected float percentMultiplier = 100.0f;
    protected float rangeMultiplier;
    protected Span rangeUnits;
    protected float speedMultiplier;
    protected String speedUnits;

    public SettingsScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TAG = "SettingsScreen";
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        SharedPreferences sharedPrefs = !isInEditMode() ? UASToolDropDownReceiver.getSharedPrefs() : null;
        if (sharedPrefs != null) {
            if (Integer.parseInt(sharedPrefs.getString(AtakPrefConstants.ALT_UNIT_PREF, String.valueOf(0))) != 1) {
                this.altUnits = Span.FOOT;
                this.altMultiplier = 3.28084f;
            } else {
                this.altUnits = Span.METER;
                this.altMultiplier = 1.0f;
            }
            int parseInt = Integer.parseInt(sharedPrefs.getString(AtakPrefConstants.RAB_UNIT_PREF, String.valueOf(1)));
            if (parseInt == 1) {
                this.rangeUnits = Span.METER;
                this.rangeMultiplier = 1.0f;
            } else if (parseInt != 2) {
                this.rangeUnits = Span.FOOT;
                this.rangeMultiplier = 3.28084f;
            } else {
                this.rangeUnits = Span.NAUTICALMILE;
                this.rangeMultiplier = 5.39957E-4f;
            }
            String[] stringArray = MapView.getMapView().getContext().getResources().getStringArray(2130903139);
            int parseInt2 = Integer.parseInt(sharedPrefs.getString("speed_unit_pref", String.valueOf(0)));
            if (parseInt2 == 1) {
                this.speedMultiplier = 3.6f;
                this.speedUnits = stringArray[1];
            } else if (parseInt2 == 2) {
                this.speedMultiplier = 1.94384f;
                this.speedUnits = stringArray[2];
            } else if (parseInt2 != 3) {
                this.speedMultiplier = 2.2369363f;
                this.speedUnits = stringArray[0];
            } else {
                this.speedMultiplier = 1.0f;
                this.speedUnits = stringArray[3];
            }
        }
    }

    public static String printableValue(double d, double d2) {
        if (Double.isNaN(d)) {
            return UASToolConstants.DASHES;
        }
        return ((int) Math.round(d2 * d)) + "";
    }
}

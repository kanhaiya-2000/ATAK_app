package com.atakmap.android.uastool.pagers.video_ui.default_ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.atakmap.android.uastool.plugin.C1877R;

public class ThermalColdSpot extends ThermalSpot {
    public static final String TAG = "ThermalColdSpot";

    public ThermalColdSpot(Context context) {
        super(context);
    }

    public ThermalColdSpot(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ThermalColdSpot(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode()) {
            this.aboveText = (TextView) findViewById(C1877R.C1878id.thermal_cold_above_text);
            this.aboveText.setVisibility(8);
            this.belowText = (TextView) findViewById(C1877R.C1878id.thermal_cold_below_text);
            this.belowText.setVisibility(8);
        }
    }
}

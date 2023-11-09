package com.atakmap.android.uastool.pagers.video_ui.default_ui;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.atakmap.android.maps.MapView;
import java.math.BigDecimal;

public abstract class ThermalSpot extends RelativeLayout {
    public static final String TAG = "ThermalSpot";
    protected TextView aboveText;
    protected TextView belowText;

    public ThermalSpot(Context context) {
        super(context);
    }

    public ThermalSpot(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ThermalSpot(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setElevation(20.0f);
    }

    /* access modifiers changed from: protected */
    public void update(final float f, final String str, final boolean z) {
        if (!isInEditMode()) {
            ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
                public void run() {
                    float floatValue = BigDecimal.valueOf((double) f).setScale(1, 4).floatValue();
                    String str = "";
                    if (z) {
                        ThermalSpot.this.belowText.setVisibility(8);
                        TextView textView = ThermalSpot.this.aboveText;
                        StringBuilder sb = new StringBuilder();
                        sb.append(floatValue);
                        if (str != null) {
                            str = " " + str;
                        }
                        sb.append(str);
                        textView.setText(sb.toString());
                        ThermalSpot.this.aboveText.setVisibility(0);
                        return;
                    }
                    ThermalSpot.this.aboveText.setVisibility(8);
                    TextView textView2 = ThermalSpot.this.belowText;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(floatValue);
                    if (str != null) {
                        str = " " + str;
                    }
                    sb2.append(str);
                    textView2.setText(sb2.toString());
                    ThermalSpot.this.belowText.setVisibility(0);
                }
            });
        }
    }
}

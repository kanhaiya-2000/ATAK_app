package com.atakmap.android.uastool.pagers.video_ui.default_ui.observer;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.pagers.ControlFragment;
import com.atakmap.android.uastool.pagers.UASToolPager;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.TextLeftWidget;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.TextRightWidget;
import com.atakmap.android.uastool.plugin.C1877R;

public class ObserverHalfUIView extends ObserverUIView {
    public static final String TAG = "ObserverHalfUIView";
    /* access modifiers changed from: private */
    public TextLeftWidget textLeftWidget;
    /* access modifiers changed from: private */
    public TextRightWidget textRightWidget;

    public ObserverHalfUIView(Context context) {
        super(context);
    }

    public ObserverHalfUIView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ObserverHalfUIView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.textLeftWidget = (TextLeftWidget) findViewById(C1877R.C1878id.video_ui_textleft);
        this.textRightWidget = (TextRightWidget) findViewById(C1877R.C1878id.video_ui_textright);
    }

    public void init(ControlFragment controlFragment, UASToolPager uASToolPager, UASItem uASItem) {
        this.textLeftWidget.init(this, uASItem);
        this.textRightWidget.init(this, uASItem);
        super.init(controlFragment, uASToolPager, uASItem);
    }

    public void updateOSDImpl() {
        super.updateOSDImpl();
        this.textLeftWidget.updateOSD();
        this.textRightWidget.updateOSD();
    }

    /* access modifiers changed from: protected */
    public void showOSD(final boolean z) {
        super.showOSD(z);
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                int i = 0;
                ObserverHalfUIView.this.textLeftWidget.setVisibility(z ? 0 : 8);
                TextRightWidget access$100 = ObserverHalfUIView.this.textRightWidget;
                if (!z) {
                    i = 8;
                }
                access$100.setVisibility(i);
                ObserverHalfUIView.this.invalidate();
            }
        });
    }
}

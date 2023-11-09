package com.atakmap.android.uastool.pagers.video_ui.default_ui.operator;

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

public class OperatorHalfUIView extends OperatorUIView {
    public static final String TAG = "OperatorHalfUIView";
    /* access modifiers changed from: private */
    public TextLeftWidget textLeftWidget;
    /* access modifiers changed from: private */
    public TextRightWidget textRightWidget;

    public OperatorHalfUIView(Context context) {
        super(context);
    }

    public OperatorHalfUIView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public OperatorHalfUIView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.textLeftWidget = (TextLeftWidget) findViewById(C1877R.C1878id.video_ui_textleft);
        this.textRightWidget = (TextRightWidget) findViewById(C1877R.C1878id.video_ui_textright);
    }

    public void init(ControlFragment controlFragment, UASToolPager uASToolPager, UASItem uASItem) {
        this.textLeftWidget = (TextLeftWidget) findViewById(C1877R.C1878id.video_ui_textleft);
        this.textRightWidget = (TextRightWidget) findViewById(C1877R.C1878id.video_ui_textright);
        TextLeftWidget textLeftWidget2 = this.textLeftWidget;
        if (textLeftWidget2 != null) {
            textLeftWidget2.init(this, uASItem);
        }
        TextRightWidget textRightWidget2 = this.textRightWidget;
        if (textRightWidget2 != null) {
            textRightWidget2.init(this, uASItem);
        }
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
                OperatorHalfUIView.this.textLeftWidget.setVisibility(z ? 0 : 8);
                TextRightWidget access$100 = OperatorHalfUIView.this.textRightWidget;
                if (!z) {
                    i = 8;
                }
                access$100.setVisibility(i);
                OperatorHalfUIView.this.invalidate();
            }
        });
    }
}

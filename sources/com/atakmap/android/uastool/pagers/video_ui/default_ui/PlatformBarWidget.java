package com.atakmap.android.uastool.pagers.video_ui.default_ui;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.RelativeLayout;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.plugin.C1877R;

public class PlatformBarWidget extends BackgroundWidget {
    public static final float DIV_HEIGHT_FULL = ((float) UIConstants.PLAT_DIV_HEIGHT_FULL);
    public static final float DIV_HEIGHT_HALF = ((float) UIConstants.PLAT_DIV_HEIGHT_HALF);
    public static final float DIV_LR_MARGIN = ((float) UIConstants.BUTTON_MARGIN);
    public static final float DIV_WIDTH_FULL = ((float) UIConstants.PLAT_DIV_WIDTH_FULL);
    public static final float DIV_WIDTH_HALF = ((float) UIConstants.PLAT_DIV_WIDTH_HALF);
    public static final float LAYOUT_HEIGHT_FULL;
    public static final float LAYOUT_HEIGHT_HALF;
    public static final float LAYOUT_WIDTH_FULL;
    public static final float LAYOUT_WIDTH_HALF;
    public static final int NUM_BUTTONS_VIS = 3;
    public static final String TAG = PlatformBarWidget.class.getSimpleName();
    /* access modifiers changed from: private */
    public View leftDivider;
    private ButtonBar platformButtons;
    private RelativeLayout platformLayout;
    /* access modifiers changed from: private */
    public View rightDivider;
    /* access modifiers changed from: private */
    public HorizontalScrollView scrollView;

    static {
        float f = (float) UIConstants.BUTTON_SIZE_FULL;
        LAYOUT_HEIGHT_FULL = f;
        LAYOUT_WIDTH_FULL = (f + ((float) (UIConstants.BUTTON_MARGIN * 3))) * 3.0f;
        float f2 = (float) UIConstants.BUTTON_SIZE_HALF;
        LAYOUT_HEIGHT_HALF = f2;
        LAYOUT_WIDTH_HALF = (f2 + ((float) (UIConstants.BUTTON_MARGIN * 3))) * 3.0f;
    }

    public PlatformBarWidget(Context context) {
        super(context);
    }

    public PlatformBarWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PlatformBarWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.leftDivider = findViewById(C1877R.C1878id.platform_op_divider_left);
        this.rightDivider = findViewById(C1877R.C1878id.platform_op_divider_right);
        this.scrollView = (HorizontalScrollView) findViewById(C1877R.C1878id.platform_op_scroll);
        this.platformLayout = (RelativeLayout) findViewById(C1877R.C1878id.platform_op_layout);
    }

    public void init(VideoUIView videoUIView, UASItem uASItem) {
        super.init(videoUIView, uASItem);
    }

    /* access modifiers changed from: protected */
    public void updateSize() {
        super.updateSize();
        if (!isInEditMode()) {
            ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
                public void run() {
                    if (PlatformBarWidget.this.isFullScreen()) {
                        PlatformBarWidget.this.leftDivider.getLayoutParams().width = (int) PlatformBarWidget.DIV_WIDTH_FULL;
                        PlatformBarWidget.this.leftDivider.getLayoutParams().height = (int) PlatformBarWidget.DIV_HEIGHT_FULL;
                        ((RelativeLayout.LayoutParams) PlatformBarWidget.this.leftDivider.getLayoutParams()).leftMargin = (int) PlatformBarWidget.DIV_LR_MARGIN;
                        ((RelativeLayout.LayoutParams) PlatformBarWidget.this.leftDivider.getLayoutParams()).rightMargin = (int) PlatformBarWidget.DIV_LR_MARGIN;
                        PlatformBarWidget.this.rightDivider.getLayoutParams().width = (int) PlatformBarWidget.DIV_WIDTH_FULL;
                        PlatformBarWidget.this.rightDivider.getLayoutParams().height = (int) PlatformBarWidget.DIV_HEIGHT_FULL;
                        ((RelativeLayout.LayoutParams) PlatformBarWidget.this.rightDivider.getLayoutParams()).leftMargin = (int) PlatformBarWidget.DIV_LR_MARGIN;
                        ((RelativeLayout.LayoutParams) PlatformBarWidget.this.rightDivider.getLayoutParams()).rightMargin = (int) PlatformBarWidget.DIV_LR_MARGIN;
                        PlatformBarWidget.this.scrollView.getLayoutParams().width = (int) PlatformBarWidget.LAYOUT_WIDTH_FULL;
                        PlatformBarWidget.this.scrollView.getLayoutParams().height = (int) PlatformBarWidget.LAYOUT_HEIGHT_FULL;
                    } else {
                        PlatformBarWidget.this.leftDivider.getLayoutParams().width = (int) PlatformBarWidget.DIV_WIDTH_HALF;
                        PlatformBarWidget.this.leftDivider.getLayoutParams().height = (int) PlatformBarWidget.DIV_HEIGHT_HALF;
                        ((RelativeLayout.LayoutParams) PlatformBarWidget.this.leftDivider.getLayoutParams()).leftMargin = (int) PlatformBarWidget.DIV_LR_MARGIN;
                        ((RelativeLayout.LayoutParams) PlatformBarWidget.this.leftDivider.getLayoutParams()).rightMargin = (int) PlatformBarWidget.DIV_LR_MARGIN;
                        PlatformBarWidget.this.rightDivider.getLayoutParams().width = (int) PlatformBarWidget.DIV_WIDTH_HALF;
                        PlatformBarWidget.this.rightDivider.getLayoutParams().height = (int) PlatformBarWidget.DIV_HEIGHT_HALF;
                        ((RelativeLayout.LayoutParams) PlatformBarWidget.this.rightDivider.getLayoutParams()).leftMargin = (int) PlatformBarWidget.DIV_LR_MARGIN;
                        ((RelativeLayout.LayoutParams) PlatformBarWidget.this.rightDivider.getLayoutParams()).rightMargin = (int) PlatformBarWidget.DIV_LR_MARGIN;
                        PlatformBarWidget.this.scrollView.getLayoutParams().width = (int) PlatformBarWidget.LAYOUT_WIDTH_HALF;
                        PlatformBarWidget.this.scrollView.getLayoutParams().height = (int) PlatformBarWidget.LAYOUT_HEIGHT_HALF;
                    }
                    PlatformBarWidget.this.invalidate();
                }
            });
        }
    }

    public void updateOSD() {
        ButtonBar buttonBar = this.platformButtons;
        if (buttonBar != null) {
            buttonBar.updateOSD();
        }
    }

    public void onAccessoryChange() {
        ButtonBar buttonBar = this.platformButtons;
        if (buttonBar != null) {
            buttonBar.onAccessoryChange();
        }
    }

    public void addButtons(ButtonBar buttonBar) {
        removeButtons();
        this.platformButtons = buttonBar;
        this.platformLayout.addView(buttonBar);
        invalidate();
    }

    public void removeButtons() {
        this.platformLayout.removeAllViews();
        this.platformButtons = null;
        invalidate();
    }

    public void setColor(final int i) {
        super.setColor(i);
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                PlatformBarWidget.this.backDrawable.setColor(i);
            }
        });
    }
}

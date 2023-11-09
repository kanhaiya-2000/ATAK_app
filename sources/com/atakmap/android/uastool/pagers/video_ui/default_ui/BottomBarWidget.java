package com.atakmap.android.uastool.pagers.video_ui.default_ui;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.plugin.C1877R;

public abstract class BottomBarWidget extends MovableWidget {
    public static final String TAG = "BottomBarWidget";
    protected VideoUIButton panToButton;
    protected PlatformBarWidget platformBar;
    protected VideoUIButton resizeButton;

    public BottomBarWidget(Context context) {
        super(context);
    }

    public BottomBarWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BottomBarWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode()) {
            this.halfLayoutParams.width = -1;
            this.halfLayoutParams.height = -2;
            this.platformBar = (PlatformBarWidget) findViewById(C1877R.C1878id.bottom_platformbar);
            VideoUIButton videoUIButton = (VideoUIButton) findViewById(C1877R.C1878id.bottom_panto_button);
            this.panToButton = videoUIButton;
            videoUIButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    BottomBarWidget.this.panTo();
                }
            });
            VideoUIButton videoUIButton2 = (VideoUIButton) findViewById(C1877R.C1878id.bottom_resize_button);
            this.resizeButton = videoUIButton2;
            videoUIButton2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    BottomBarWidget.this.toggleSize();
                }
            });
            if (UASToolDropDownReceiver.getInstance().getPluginContext().getResources().getConfiguration().orientation == 1) {
                this.resizeButton.setEnabled(false);
            }
        }
        setElevation(100.0f);
    }

    public void init(VideoUIView videoUIView, final UASItem uASItem) {
        this.panToButton.init();
        this.resizeButton.init();
        this.platformBar.init(this.videoUIView, uASItem);
        super.init(videoUIView, uASItem);
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                ButtonBar videoUIButtons = ButtonBar.getVideoUIButtons(uASItem);
                if (videoUIButtons != null) {
                    BottomBarWidget.this.platformBar.addButtons(videoUIButtons);
                    videoUIButtons.init(BottomBarWidget.this.videoUIView, uASItem);
                    BottomBarWidget.this.platformBar.setVisibility(0);
                } else {
                    BottomBarWidget.this.platformBar.removeButtons();
                    BottomBarWidget.this.platformBar.setVisibility(8);
                }
                BottomBarWidget.this.invalidate();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void updateSize() {
        super.updateSize();
        if (!isInEditMode()) {
            ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
                public void run() {
                    if (BottomBarWidget.this.isFullScreen()) {
                        BottomBarWidget bottomBarWidget = BottomBarWidget.this;
                        bottomBarWidget.setPadding(bottomBarWidget.fullStartPad, BottomBarWidget.this.fullTopPad, BottomBarWidget.this.fullEndPad, BottomBarWidget.this.fullBottomPad);
                    } else {
                        BottomBarWidget.this.setPadding(UIConstants.WIDGET_PAD_HALF, UIConstants.WIDGET_PAD_HALF, UIConstants.WIDGET_PAD_HALF, UIConstants.WIDGET_PAD_HALF);
                    }
                    BottomBarWidget.this.invalidate();
                }
            });
        }
    }

    public void updateOSD() {
        PlatformBarWidget platformBarWidget = this.platformBar;
        if (platformBarWidget != null) {
            platformBarWidget.updateOSD();
        }
    }

    public void onAccessoryChange() {
        PlatformBarWidget platformBarWidget = this.platformBar;
        if (platformBarWidget != null) {
            platformBarWidget.onAccessoryChange();
        }
    }

    /* access modifiers changed from: protected */
    public void panTo() {
        this.videoUIView.panTo();
    }

    /* access modifiers changed from: protected */
    public void toggleSize() {
        this.videoUIView.toggleSize();
    }
}

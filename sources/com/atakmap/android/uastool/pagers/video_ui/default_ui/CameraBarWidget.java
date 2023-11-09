package com.atakmap.android.uastool.pagers.video_ui.default_ui;

import android.content.Context;
import android.util.AttributeSet;
import com.atakmap.android.uastool.UASItem;

public class CameraBarWidget extends PopupWidget {
    public static final String TAG = "CameraBarWidget";
    protected VideoUIButton mapShotButton;
    protected VideoUIButton zoomInButton;
    protected VideoUIButton zoomOutButton;

    public CameraBarWidget(Context context) {
        super(context);
    }

    public CameraBarWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CameraBarWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void init(VideoUIView videoUIView, UASItem uASItem) {
        this.zoomInButton.init();
        this.zoomOutButton.init();
        this.mapShotButton.init();
        if (uASItem != null && !uASItem.canZoomCamera()) {
            this.zoomInButton.setVisibility(8);
            this.zoomOutButton.setVisibility(8);
        }
        super.init(videoUIView, uASItem);
    }

    /* access modifiers changed from: protected */
    public void mapShot() {
        this.videoUIView.mapShot();
    }
}

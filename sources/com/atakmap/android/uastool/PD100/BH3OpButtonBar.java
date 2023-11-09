package com.atakmap.android.uastool.PD100;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.ButtonBar;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.VideoUIButton;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.VideoUIView;
import com.atakmap.android.uastool.plugin.C1877R;

public class BH3OpButtonBar extends ButtonBar {
    public static final String TAG = "BH3OpButtonBar";
    private VideoUIButton cameraButton;

    public BH3OpButtonBar(Context context) {
        super(context);
    }

    public BH3OpButtonBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BH3OpButtonBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        VideoUIButton videoUIButton = (VideoUIButton) findViewById(C1877R.C1878id.bottom_op_bh3_camera);
        this.cameraButton = videoUIButton;
        videoUIButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BH3OpButtonBar.this.toggleCameraBar();
            }
        });
    }

    public void init(VideoUIView videoUIView, UASItem uASItem) {
        this.cameraButton.init();
        super.init(videoUIView, uASItem);
        updateButtons();
    }

    public void updateOSD() {
        super.updateOSD();
    }

    public void onAccessoryChange() {
        updateButtons();
    }

    private void updateButtons() {
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                BH3OpButtonBar.this.invalidate();
            }
        });
    }

    /* access modifiers changed from: private */
    public void toggleCameraBar() {
        this.videoUIView.toggleSideBar(Integer.valueOf(C1877R.layout.video_ui_bh3_camerabar));
    }
}

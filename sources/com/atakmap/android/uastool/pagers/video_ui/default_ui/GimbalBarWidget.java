package com.atakmap.android.uastool.pagers.video_ui.default_ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.plugin.C1877R;

public abstract class GimbalBarWidget extends PopupWidget {
    public static final String TAG = "GimbalBarWidget";
    protected VideoUIButton controlButton;
    protected VideoUIButton resetButton;
    protected VideoUIButton snapButton;

    public GimbalBarWidget(Context context) {
        super(context);
    }

    public GimbalBarWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GimbalBarWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        VideoUIButton videoUIButton = (VideoUIButton) findViewById(C1877R.C1878id.gimbal_control_button);
        this.controlButton = videoUIButton;
        videoUIButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GimbalBarWidget.this.toggleControl();
            }
        });
        VideoUIButton videoUIButton2 = (VideoUIButton) findViewById(C1877R.C1878id.gimbal_reset_button);
        this.resetButton = videoUIButton2;
        videoUIButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GimbalBarWidget.this.resetGimbal();
            }
        });
        VideoUIButton videoUIButton3 = (VideoUIButton) findViewById(C1877R.C1878id.gimbal_snap_button);
        this.snapButton = videoUIButton3;
        videoUIButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GimbalBarWidget.this.snapGimbal();
            }
        });
    }

    public void init(VideoUIView videoUIView, UASItem uASItem) {
        this.controlButton.init();
        this.resetButton.init();
        this.snapButton.init();
        if (uASItem != null && !uASItem.supportsGimbalControl()) {
            this.controlButton.setVisibility(8);
        }
        super.init(videoUIView, uASItem);
        updateButtons();
    }

    /* access modifiers changed from: protected */
    public void toggleControl() {
        this.videoUIView.toggleGimbalControl();
        updateButtons();
    }

    /* access modifiers changed from: protected */
    public void resetGimbal() {
        this.videoUIView.resetGimbal();
    }

    /* access modifiers changed from: protected */
    public void snapGimbal() {
        this.videoUIView.snapGimbal();
    }

    public void onAccessoryChange() {
        super.onAccessoryChange();
        updateButtons();
    }

    /* access modifiers changed from: protected */
    public void updateButtons() {
        if (this.uasItem != null) {
            if (!this.uasItem.supportsGimbalControl()) {
                this.controlButton.setEnabled(false);
            } else if (this.uasItem == null) {
                this.controlButton.setEnabled(false);
            } else if (this.uasItem.isGimbalControlEnabled()) {
                this.controlButton.setOn(true);
            } else if (this.uasItem.waitingForLtclcTaskResponse != null) {
                this.controlButton.setPending(true);
            } else {
                this.controlButton.setOn(false);
            }
        }
    }
}

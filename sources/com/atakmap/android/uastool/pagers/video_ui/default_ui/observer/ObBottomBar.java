package com.atakmap.android.uastool.pagers.video_ui.default_ui.observer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.BottomBarWidget;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.VideoUIButton;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.VideoUIView;
import com.atakmap.android.uastool.plugin.C1877R;

public class ObBottomBar extends BottomBarWidget {
    public static final String TAG = "ObBottomBar";
    protected VideoUIButton gimbalButton;
    protected VideoUIButton mapshotButton;

    public ObBottomBar(Context context) {
        super(context);
    }

    public ObBottomBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ObBottomBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode()) {
            VideoUIButton videoUIButton = (VideoUIButton) findViewById(C1877R.C1878id.bottom_mapshot_button);
            this.mapshotButton = videoUIButton;
            videoUIButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    ObBottomBar.this.doMapshot();
                }
            });
            VideoUIButton videoUIButton2 = (VideoUIButton) findViewById(C1877R.C1878id.bottom_gimbal_button);
            this.gimbalButton = videoUIButton2;
            videoUIButton2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    ObBottomBar.this.toggleControl();
                }
            });
        }
    }

    public void init(VideoUIView videoUIView, UASItem uASItem) {
        this.mapshotButton.init();
        this.gimbalButton.init();
        super.init(videoUIView, uASItem);
        updateButtons();
    }

    /* access modifiers changed from: protected */
    public void toggleControl() {
        boolean z;
        boolean z2;
        if (this.uasItem != null) {
            z2 = this.uasItem.isGimbalControlEnabled();
            z = this.uasItem.isLtclcRemoteRequestPending();
        } else {
            z2 = false;
            z = false;
        }
        if (z2 || z) {
            this.uasItem.sendLtclcRemoteCancel();
            this.gimbalButton.setPending(false);
            return;
        }
        if (this.uasItem != null) {
            this.uasItem.sendLtclcRemoteRequest();
        }
        this.gimbalButton.setPending(true);
    }

    /* access modifiers changed from: protected */
    public void updateButtons() {
        if (this.uasItem != null) {
            if (!this.uasItem.supportsGimbalControl()) {
                this.gimbalButton.setEnabled(false);
            } else if (this.uasItem == null) {
                this.gimbalButton.setEnabled(false);
            } else if (this.uasItem.isGimbalControlEnabled()) {
                this.gimbalButton.setOn(true);
            } else if (this.uasItem.waitingForLtclcTaskResponse != null) {
                this.gimbalButton.setPending(true);
            } else {
                this.gimbalButton.setOn(false);
            }
        }
    }

    public void onGimbalControlChanged(boolean z) {
        this.gimbalButton.setOn(z);
        updateButtons();
    }

    /* access modifiers changed from: protected */
    public void doMapshot() {
        this.videoUIView.mapShot();
    }
}

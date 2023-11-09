package com.atakmap.android.uastool.pagers.video_ui.default_ui.operator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.atakmap.android.uastool.Reflector;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.BottomBarWidget;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.VideoUIButton;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.VideoUIView;
import com.atakmap.android.uastool.plugin.C1877R;

public class OpBottomBar extends BottomBarWidget {
    public static final String TAG = "OpBottomBar";
    private VideoUIButton broadcastButton;
    protected VideoUIButton cameraButton;
    protected VideoUIButton gimbalButton;

    public OpBottomBar(Context context) {
        super(context);
    }

    public OpBottomBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public OpBottomBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode()) {
            VideoUIButton videoUIButton = (VideoUIButton) findViewById(C1877R.C1878id.bottom_gimbal_button);
            this.gimbalButton = videoUIButton;
            videoUIButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    OpBottomBar.this.toggleGimbalBar();
                }
            });
            VideoUIButton videoUIButton2 = (VideoUIButton) findViewById(C1877R.C1878id.bottom_camera_button);
            this.cameraButton = videoUIButton2;
            videoUIButton2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    OpBottomBar.this.toggleCameraBar();
                }
            });
            VideoUIButton videoUIButton3 = (VideoUIButton) findViewById(C1877R.C1878id.bottom_broadcast_button);
            this.broadcastButton = videoUIButton3;
            videoUIButton3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    OpBottomBar.this.toggleBroadcast();
                }
            });
        }
    }

    public void init(VideoUIView videoUIView, UASItem uASItem) {
        this.broadcastButton.init();
        this.gimbalButton.init();
        this.cameraButton.init();
        super.init(videoUIView, uASItem);
        if (uASItem != null) {
            UASToolDropDownReceiver.getInstance();
            Reflector reflector = UASToolDropDownReceiver.getReflector();
            if (reflector != null) {
                this.broadcastButton.setOn(reflector.isBroadcasting());
                return;
            }
            return;
        }
        this.broadcastButton.setEnabled(false);
        this.broadcastButton.setOn(false);
    }

    /* access modifiers changed from: private */
    public void toggleBroadcast() {
        this.videoUIView.toggleBroadcasting();
    }

    /* access modifiers changed from: protected */
    public void toggleGimbalBar() {
        ((OperatorUIView) this.videoUIView).toggleGimbalBar();
    }

    /* access modifiers changed from: protected */
    public void toggleCameraBar() {
        ((OperatorUIView) this.videoUIView).toggleCameraBar();
    }

    public void onBroadcastStopped() {
        this.broadcastButton.setOn(false);
    }

    public void onBroadcastStarted() {
        this.broadcastButton.setOn(true);
    }
}

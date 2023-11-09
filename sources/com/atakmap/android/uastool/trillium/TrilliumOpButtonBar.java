package com.atakmap.android.uastool.trillium;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.ButtonBar;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.VideoUIButton;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.VideoUIView;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.coremap.log.Log;
import com.trilliumeng.android.orion.sdk.OrionSdk;

public class TrilliumOpButtonBar extends ButtonBar {
    public static final String TAG = "TrilliumOpButtonBar";
    private VideoUIButton cameraButton;
    private VideoUIButton focusButton;

    public void onAccessoryChange() {
    }

    public TrilliumOpButtonBar(Context context) {
        super(context);
    }

    public TrilliumOpButtonBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TrilliumOpButtonBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        VideoUIButton videoUIButton = (VideoUIButton) findViewById(C1877R.C1878id.bottom_op_trillium_camera);
        this.cameraButton = videoUIButton;
        videoUIButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                TrilliumOpButtonBar.this.toggleCameraBar();
            }
        });
        VideoUIButton videoUIButton2 = (VideoUIButton) findViewById(C1877R.C1878id.bottom_op_trillium_autofocus);
        this.focusButton = videoUIButton2;
        videoUIButton2.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 1) {
                    return false;
                }
                view.setPressed(false);
                UASToolDropDownReceiver.toast("Auto Focus");
                try {
                    OrionSdk orionSdk = TrilliumMonitor.getOrionSdk();
                    if (orionSdk != null) {
                        if (orionSdk.focusAvailable()) {
                            orionSdk.autoFocus();
                        } else {
                            Log.d(TrilliumOpButtonBar.TAG, "Active camera doesn't support auto focus.");
                        }
                    }
                } catch (Exception e) {
                    Log.d(TrilliumOpButtonBar.TAG, "Failed to execute camera focus: ", e);
                }
                return true;
            }
        });
    }

    public void init(VideoUIView videoUIView, UASItem uASItem) {
        super.init(videoUIView, uASItem);
        this.cameraButton.init();
        this.focusButton.init();
    }

    public void updateOSD() {
        super.updateOSD();
    }

    /* access modifiers changed from: private */
    public void toggleCameraBar() {
        this.videoUIView.toggleSideBar(Integer.valueOf(C1877R.layout.video_ui_trillium_camerabar));
    }
}

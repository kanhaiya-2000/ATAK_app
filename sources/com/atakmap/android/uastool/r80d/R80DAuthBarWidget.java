package com.atakmap.android.uastool.r80d;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.PopupWidget;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.VideoUIButton;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.VideoUIView;
import com.atakmap.android.uastool.plugin.C1877R;

public class R80DAuthBarWidget extends PopupWidget {
    public static final String TAG = "R80DAuthBarWidget";
    public VideoUIButton navButton;
    public VideoUIButton payloadButton;

    public R80DAuthBarWidget(Context context) {
        super(context);
    }

    public R80DAuthBarWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public R80DAuthBarWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.navButton = (VideoUIButton) findViewById(C1877R.C1878id.r80d_camera_auth_nav_button);
        this.payloadButton = (VideoUIButton) findViewById(C1877R.C1878id.r80d_camera_auth_payload_button);
    }

    public void init(VideoUIView videoUIView, final UASItem uASItem) {
        super.init(videoUIView, uASItem);
        this.navButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                try {
                    R80dUASItem r80dUASItem = (R80dUASItem) uASItem;
                    if (r80dUASItem.isNavAuthorized()) {
                        r80dUASItem.releaseNavigationControl();
                    } else {
                        r80dUASItem.requestNavigationControl();
                    }
                } catch (Exception unused) {
                    UASToolDropDownReceiver.toast("Camera does not support palette");
                }
            }
        });
        this.payloadButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                try {
                    R80dUASItem r80dUASItem = (R80dUASItem) uASItem;
                    if (r80dUASItem.isPayloadAuthorized()) {
                        r80dUASItem.releaseCameraControl();
                    } else {
                        r80dUASItem.requestCameraControl();
                    }
                } catch (Exception unused) {
                    UASToolDropDownReceiver.toast("Camera does not support palette");
                }
            }
        });
        updateButtons();
    }

    public void updateButtons() {
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                R80dUASItem r80dUASItem = (R80dUASItem) R80DAuthBarWidget.this.uasItem;
                R80DAuthBarWidget.this.payloadButton.setOn(r80dUASItem.isPayloadAuthorized());
                R80DAuthBarWidget.this.navButton.setOn(r80dUASItem.isNavAuthorized());
            }
        });
    }

    public void onAccessoryChange() {
        updateButtons();
    }
}

package com.atakmap.android.uastool.r80d;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.aeryon.java.types.CameraStream;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.PopupWidget;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.VideoUIButton;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.VideoUIView;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.utils.FieldOfView;
import com.atakmap.coremap.filesystem.FileSystemUtils;
import java.util.HashMap;

public class R80DCameraBarWidget extends PopupWidget {
    public static final String TAG = "R80DCameraBarWidget";
    static HashMap<String, String> cameraNameMap;
    public VideoUIButton[] buttons = new VideoUIButton[6];

    public R80DCameraBarWidget(Context context) {
        super(context);
    }

    public R80DCameraBarWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public R80DCameraBarWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.buttons[0] = (VideoUIButton) findViewById(C1877R.C1878id.r80d_camera_eo_button);
        this.buttons[1] = (VideoUIButton) findViewById(C1877R.C1878id.r80d_camera_ir_button);
        this.buttons[2] = (VideoUIButton) findViewById(C1877R.C1878id.r80d_camera_front_button);
        this.buttons[3] = (VideoUIButton) findViewById(C1877R.C1878id.r80d_camera_sct_button);
        this.buttons[4] = (VideoUIButton) findViewById(C1877R.C1878id.r80d_camera_nav_button);
        this.buttons[5] = (VideoUIButton) findViewById(C1877R.C1878id.r80d_camera_hdz_button);
    }

    public void init(VideoUIView videoUIView, UASItem uASItem) {
        super.init(videoUIView, uASItem);
        updateButtons();
    }

    public void updateButtons() {
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                CameraStream[] cameraStreams = ((R80dUASItem) R80DCameraBarWidget.this.uasItem).getCameraStreams();
                for (int i = 0; i < R80DCameraBarWidget.this.buttons.length; i++) {
                    if (i > cameraStreams.length - 1) {
                        R80DCameraBarWidget.this.buttons[i].setVisibility(8);
                    } else {
                        R80DCameraBarWidget r80DCameraBarWidget = R80DCameraBarWidget.this;
                        r80DCameraBarWidget.setupCameraButton(r80DCameraBarWidget.buttons[i], cameraStreams[i]);
                    }
                }
            }
        });
    }

    static {
        HashMap<String, String> hashMap = new HashMap<>();
        cameraNameMap = hashMap;
        hashMap.put(R80dPrefHandler.DEFAULT_VIDEO_ID, "FRT");
        cameraNameMap.put("navcams", "NAV");
        cameraNameMap.put("hdz", "HDZ");
        cameraNameMap.put("eo", "EO");
        cameraNameMap.put("ir", "IR");
        cameraNameMap.put("eo0", "EO0");
        cameraNameMap.put("ir0", "IR0");
        cameraNameMap.put("eo2", "EO2");
        cameraNameMap.put("ir2", "IR2");
        cameraNameMap.put("boson", "SCT");
        cameraNameMap.put("boson_18", "SCW");
        cameraNameMap.put("boson_75", "SCN");
    }

    /* access modifiers changed from: private */
    public void setupCameraButton(final VideoUIButton videoUIButton, final CameraStream cameraStream) {
        if (videoUIButton != null) {
            videoUIButton.setVisibility(0);
            if (cameraNameMap.containsKey(cameraStream.getNamePretty())) {
                videoUIButton.setImageDrawable(VideoUIButton.getButtonWithText(cameraNameMap.get(cameraStream.getNamePretty())));
            } else {
                videoUIButton.setImageDrawable(VideoUIButton.getButtonWithText(cameraStream.getNamePretty()));
            }
            videoUIButton.setOn(cameraStream.getUrl().equals(this.uasItem.getVideoUrl()));
            videoUIButton.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() != 1) {
                        return false;
                    }
                    SharedPreferences.Editor edit = UASToolDropDownReceiver.getSharedPrefs().edit();
                    edit.putString(R80dPrefHandler.PREF_VIDEO_ID, cameraStream.getNamePretty());
                    String cameraURI = ((R80dUASItem) R80DCameraBarWidget.this.uasItem).getCameraURI(cameraStream.getUrl());
                    if (!FileSystemUtils.isEmpty(cameraURI)) {
                        edit.putString(R80dPrefHandler.PREF_VIDEO_URI, cameraURI);
                    }
                    edit.apply();
                    UASToolDropDownReceiver.toast(cameraStream.getNamePretty() + " selected", 0);
                    FieldOfView fov = R80DCameraBarWidget.this.uasItem.getFov();
                    if (fov != null) {
                        fov.invalidate();
                        fov.center.set((Object) null);
                    }
                    R80DCameraBarWidget.this.toggleCameraOn(videoUIButton);
                    return true;
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void toggleCameraOn(VideoUIButton videoUIButton) {
        VideoUIButton[] videoUIButtonArr = this.buttons;
        int length = videoUIButtonArr.length;
        for (int i = 0; i < length; i++) {
            VideoUIButton videoUIButton2 = videoUIButtonArr[i];
            videoUIButton2.setOn(videoUIButton == videoUIButton2);
        }
        invalidate();
    }

    public void onAccessoryChange() {
        updateButtons();
    }
}

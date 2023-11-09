package com.atakmap.android.uastool.pagers.operator;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import atak.core.agl;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.Reflector;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.pagers.ControlFragment;
import com.atakmap.android.uastool.pagers.UASToolPager;
import com.atakmap.android.uastool.pagers.operator.PreviewTextureView;
import com.atakmap.android.uastool.pagers.video_ui.ArOverlayView;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.operator.OperatorUIView;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.prefs.UIPreferenceFragment;
import com.atakmap.android.uastool.tflite.customview.OverlayView;
import com.atakmap.android.uastool.utils.SurveyScreen;
import com.atakmap.coremap.log.Log;
import com.partech.mobilevid.e;
import com.partech.mobilevid.h;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

public class OperatorControlFragment extends ControlFragment implements SharedPreferences.OnSharedPreferenceChangeListener, Reflector.StatusUpdateListener {
    /* access modifiers changed from: private */
    public static final String TAG = "OperatorControlFragment";
    /* access modifiers changed from: private */
    public PreviewTextureView previewTexture;
    /* access modifiers changed from: private */
    public Reflector reflector;

    public interface StatusChangeCallback {
        void onFinished(boolean z);
    }

    /* access modifiers changed from: private */
    public boolean getSendVideo() {
        return true;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.layoutView = (ViewGroup) LayoutInflater.from(this.pluginContext).inflate(C1877R.layout.operator_control_layout, (ViewGroup) null);
        this.mainView = this.layoutView.findViewById(C1877R.C1878id.operator_main_layout);
        this.trackingView = (OverlayView) this.layoutView.findViewById(C1877R.C1878id.tracking_overlay);
        this.trackingView.setUASItem(this.selectedUASItem);
        this.failedLayout = (RelativeLayout) this.layoutView.findViewById(C1877R.C1878id.failed);
        this.connectingLayout = (RelativeLayout) this.layoutView.findViewById(C1877R.C1878id.connecting);
        this.videoDisconnectOverlay = (RelativeLayout) this.layoutView.findViewById(C1877R.C1878id.video_disconnect_overlay);
        showScreen(ControlFragment.Screen.CONNECTING);
        this.videoReconnectBtn = (Button) this.layoutView.findViewById(C1877R.C1878id.video_try_connect);
        this.videoReconnectBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                OperatorControlFragment.this.startPreview();
            }
        });
        this.arOverlayView = (ArOverlayView) this.layoutView.findViewById(C1877R.C1878id.ar_overlay_view);
        this.arOverlayView.setIsOperator(true);
        PreviewTextureView previewTextureView = (PreviewTextureView) this.layoutView.findViewById(C1877R.C1878id.operator_preview);
        this.previewTexture = previewTextureView;
        try {
            previewTextureView.a(UASToolDropDownReceiver.getInstance().getOffscreenDirector().c(), (e.a) null);
        } catch (agl e) {
            Log.e(TAG, "GL initialization failure", e);
        }
        UASToolDropDownReceiver.getInstance().getOffscreenDirector().a(this.previewTexture);
        this.previewTexture.setVisibility(4);
        this.previewTexture.setControlFragment(this);
        this.previewTexture.setZOrderMediaOverlay(true);
        this.previewTexture.setOnScaleChangedCallback(new PreviewTextureView.ScaleCallback() {
            public void onScaleChanged(float f) {
                OperatorControlFragment.this.arOverlayView.setScale(f);
            }
        });
        this.uiLayout = (RelativeLayout) this.layoutView.findViewById(C1877R.C1878id.ui_layout);
        this.joystickLayout = (RelativeLayout) this.layoutView.findViewById(C1877R.C1878id.joystick_layout);
        applyJoystickUIVisibility();
        UASToolDropDownReceiver.getSharedPrefs().registerOnSharedPreferenceChangeListener(this);
        return this.layoutView;
    }

    public void onDestroy() {
        super.onDestroy();
        UASToolDropDownReceiver.getSharedPrefs().unregisterOnSharedPreferenceChangeListener(this);
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        str.hashCode();
        if (str.equals(UIPreferenceFragment.PREF_JOYSTICK_VIRTUAL_TYPE)) {
            switchJoystickUI();
        } else if (str.equals(UIPreferenceFragment.PREF_UI_JOYSTICK_VIRTUAL_ON)) {
            applyJoystickUIVisibility();
        }
    }

    public void pause() {
        try {
            if (this.trackingView != null) {
                this.trackingView.stopOSD();
            }
            stopOSD();
            UASToolDropDownReceiver.getInstance().getOffscreenDirector().b(this.previewTexture);
            this.previewTexture.onPause();
        } catch (Exception e) {
            Log.d(TAG, "Exception on OperatorControlFragment.pause(): ", e);
        }
    }

    public void resume() {
        startOSD();
        if (this.trackingView != null) {
            this.trackingView.startOSD();
        }
        if (this.previewTexture != null) {
            UASToolDropDownReceiver.getInstance().getOffscreenDirector().a(this.previewTexture);
            this.previewTexture.onResume();
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (isBroadcasting()) {
            stopBroadcast();
        }
        stopPreview();
        if (this.osdScheduler != null) {
            this.osdScheduler.shutdownNow();
        }
    }

    public boolean isBroadcasting() {
        Reflector reflector2 = this.reflector;
        if (reflector2 != null) {
            return reflector2.isBroadcasting();
        }
        return false;
    }

    private void updateArCallsign() {
        if (this.selectedUASItem != null) {
            UASToolDropDownReceiver.getInstance().getOperatorArOverlay().setDroneCallsign(this.selectedUASItem.getCallsign());
        }
    }

    public void callsignChanged(String str) {
        updateArCallsign();
    }

    public void setParentPager(UASToolPager uASToolPager) {
        this.parentPager = uASToolPager;
    }

    public void gotUASConnection() {
        super.gotUASConnection();
        if (this.layoutView != null) {
            ((Activity) getContext()).runOnUiThread(new Runnable() {
                public void run() {
                    if (OperatorControlFragment.this.layoutView.isShown()) {
                        OperatorControlFragment.this.startPreview();
                    }
                }
            });
        }
    }

    public void lostUASConnection() {
        super.lostUASConnection();
        try {
            ((Activity) getContext()).runOnUiThread(new Runnable() {
                public void run() {
                    OperatorControlFragment.this.showScreen(ControlFragment.Screen.FAILED);
                    OperatorControlFragment.this.stopPreview();
                }
            });
        } catch (Exception e) {
            UASToolDropDownReceiver.toast("Exception on lost UAS connection: " + e.getLocalizedMessage(), 0);
            String str = TAG;
            Log.d(str, "Exception on lost UAS connection: " + e.getLocalizedMessage());
        }
    }

    public void setUASItem(UASItem uASItem, Reflector reflector2) {
        if (uASItem == null) {
            UASToolDropDownReceiver.toast("UAS not connected or selected", 1);
            return;
        }
        this.reflector = reflector2;
        reflector2.setStatusUpdateListener(this);
        if (this.selectedUASItem != null && !this.selectedUASItem.equals(uASItem)) {
            stopPreview();
            stopBroadcast();
        }
        super.setUASItem(uASItem);
        this.previewTexture.setUASItem(this.selectedUASItem);
        this.previewTexture.setYUV(reflector2.usesYUVTexture());
        updateArCallsign();
        if (this.trackingView != null) {
            this.trackingView.setUASItem(this.selectedUASItem);
        }
    }

    /* access modifiers changed from: private */
    public void startPreview() {
        String str = TAG;
        Log.d(str, "startPreview " + this.reflector);
        Reflector reflector2 = this.reflector;
        if (reflector2 == null) {
            Log.d(str, "Platform reflector NULL");
        } else if (!reflector2.isPreviewActive() && this.selectedUASItem.isConnected()) {
            showScreen(ControlFragment.Screen.CONNECTING);
            if (!UASToolDropDownReceiver.getInstance().setPreviewEnabled(true)) {
                showScreen(ControlFragment.Screen.FAILED);
            }
            this.previewTexture.setVisibility(0);
        }
        if (this.trackingView != null) {
            this.trackingView.startOSD();
        }
    }

    /* access modifiers changed from: private */
    public void stopPreview() {
        Reflector reflector2 = this.reflector;
        if (reflector2 != null) {
            if (reflector2.isBroadcasting()) {
                stopBroadcast();
            }
            if (UASToolDropDownReceiver.getInstance() != null) {
                UASToolDropDownReceiver.getInstance().setPreviewEnabled(false);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void startOSD() {
        if (!this.osdScheduler.isShutdown()) {
            try {
                this.osdSchedulerHandle = this.osdScheduler.scheduleAtFixedRate(new Runnable() {
                    public void run() {
                        try {
                            if (OperatorControlFragment.this.previewTexture == null || OperatorControlFragment.this.reflector == null || UASToolDropDownReceiver.getInstance() == null) {
                                Log.d(OperatorControlFragment.TAG, "Unable to update OSD - preview or reflector is null");
                            } else if (OperatorControlFragment.this.videoUI == null || !OperatorControlFragment.this.videoUI.isOSDVisible()) {
                                Log.d(OperatorControlFragment.TAG, "Unable to update OSD - overlay is null");
                            } else {
                                OperatorControlFragment.this.videoUI.updateOSD();
                            }
                        } catch (Exception e) {
                            Log.d(OperatorControlFragment.TAG, "OSD Scheduler Exception: ", e);
                        }
                    }
                }, 0, 500, TimeUnit.MILLISECONDS);
            } catch (RejectedExecutionException e) {
                Log.e(TAG, "OSD scheduleAtFixedRate Exception: ", e);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void stopOSD() {
        if (this.osdSchedulerHandle != null) {
            this.osdSchedulerHandle.cancel(false);
            this.osdSchedulerHandle = null;
        }
    }

    public void onBroadcastChanged(boolean z, final StatusChangeCallback statusChangeCallback) {
        if (!z) {
            stopBroadcast();
            if (statusChangeCallback != null) {
                statusChangeCallback.onFinished(false);
            }
        } else if (this.reflector.getLocalUri() != null) {
            new AlertDialog.Builder(getContext()).setTitle("Rebroadcast Video").setMessage("This UAS is directly broadcasting video to the network. There may be no need to rebroadcast the video unless it needs to be downsampled. If intending to broadcast to a different network or wowza server check the video broadcast settings.").setPositiveButton("Rebroadcast Video", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    OperatorControlFragment.this.startBroadcast();
                    StatusChangeCallback statusChangeCallback = statusChangeCallback;
                    if (statusChangeCallback != null) {
                        statusChangeCallback.onFinished(true);
                    }
                }
            }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    StatusChangeCallback statusChangeCallback = statusChangeCallback;
                    if (statusChangeCallback != null) {
                        statusChangeCallback.onFinished(false);
                    }
                }
            }).create().show();
        } else {
            startBroadcast();
            if (statusChangeCallback != null) {
                statusChangeCallback.onFinished(true);
            }
        }
    }

    public void startBroadcast() {
        Reflector reflector2 = this.reflector;
        if (reflector2 != null) {
            String readyToBroadcast = reflector2.readyToBroadcast();
            if (TextUtils.isEmpty(readyToBroadcast)) {
                new Thread(new Runnable() {
                    public void run() {
                        if (OperatorControlFragment.this.getSendVideo()) {
                            try {
                                UASToolDropDownReceiver.getInstance().startEncoder();
                            } catch (h.b e) {
                                UASToolDropDownReceiver.toast("Video broadcast failed to start: " + e.getMessage(), 1);
                                return;
                            }
                        }
                        Thread thread = new Thread(OperatorControlFragment.this.reflector);
                        thread.setPriority(10);
                        thread.start();
                        OperatorControlFragment.this.updateUIOnBroadcastChange(true);
                    }
                }).start();
            } else {
                UASToolDropDownReceiver.toast(readyToBroadcast, 1);
            }
        } else {
            UASToolDropDownReceiver.toast("Null reflector", 1);
        }
    }

    public void stopBroadcast() {
        updateUIOnBroadcastChange(false);
        if (this.reflector != null) {
            if (UASToolDropDownReceiver.getInstance() != null) {
                UASToolDropDownReceiver.getInstance().stopEncoder();
            }
            this.reflector.stop();
        }
    }

    public void updateUIOnBroadcastChange(final boolean z) {
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                if (OperatorControlFragment.this.videoUI == null) {
                    return;
                }
                if (z) {
                    ((OperatorUIView) OperatorControlFragment.this.videoUI).broadcastStarted();
                } else {
                    ((OperatorUIView) OperatorControlFragment.this.videoUI).broadcastStopped();
                }
            }
        });
    }

    public boolean onBackPressed() {
        if (!UASToolDropDownReceiver.getInstance().isFullscreenVideo()) {
            return super.onBackPressed();
        }
        UASToolDropDownReceiver.getInstance().resizeHalf();
        return true;
    }

    public void resizeFull() {
        if (this.selectedUASItem.supportsVirtualJoystick()) {
            this.selectedUASItem.setVirtualStickMode(UASToolDropDownReceiver.getSharedPrefs().getBoolean(UIPreferenceFragment.PREF_UI_JOYSTICK_VIRTUAL_ON, UIPreferenceFragment.DEFAULT_UI_JOYSTICK_VIRTUAL_ON.booleanValue()));
        }
        super.resizeFull();
        this.trackingView.resize();
    }

    public void resizeHalf() {
        if (this.selectedUASItem.supportsVirtualJoystick()) {
            this.selectedUASItem.setVirtualStickMode(false);
        }
        super.resizeHalf();
        this.trackingView.resize();
    }

    public PreviewTextureView getPreviewTexture() {
        return this.previewTexture;
    }

    public void onPageSelected() {
        super.onPageSelected();
        startPreview();
    }

    private void showSurveySelection(UASItem uASItem) {
        if (uASItem != null) {
            setCurrentScreen((SurveyScreen) LayoutInflater.from(this.pluginContext).inflate(C1877R.layout.survey_layout, (ViewGroup) null), uASItem, this);
        } else {
            UASToolDropDownReceiver.toast("UAS not connected or selected", 0);
        }
    }

    public void onStartupFailed() {
        showScreen(ControlFragment.Screen.FAILED);
    }

    public void onStreamStopped() {
        showScreen(ControlFragment.Screen.FAILED);
        stopPreview();
    }

    public void onStreamStarted() {
        showScreen(ControlFragment.Screen.VIDEO);
    }

    public Bitmap getPreviewSnapshot(boolean z, boolean z2) {
        int i;
        int i2;
        Bitmap bitmap;
        int i3;
        Bitmap bitmap2;
        PreviewTextureView previewTextureView = this.previewTexture;
        if (previewTextureView == null) {
            return null;
        }
        Bitmap bitmap3 = previewTextureView.getBitmap();
        if (!z && !z2) {
            return bitmap3;
        }
        int width = bitmap3.getWidth();
        int height = bitmap3.getHeight();
        int i4 = 0;
        if (z2) {
            bitmap = UASToolDropDownReceiver.loadBitmapFromView(getArOverlay());
            i2 = bitmap.getWidth();
            i = bitmap.getHeight();
        } else {
            bitmap = null;
            i2 = 0;
            i = 0;
        }
        if (z) {
            Bitmap bitmap4 = getVideoUI().getBitmap();
            int width2 = bitmap4.getWidth();
            i3 = bitmap4.getHeight();
            int i5 = width2;
            bitmap2 = bitmap4;
            i4 = i5;
        } else {
            bitmap2 = null;
            i3 = 0;
        }
        int max = Math.max(i4, Math.max(i2, width));
        int max2 = Math.max(i3, Math.max(i, width));
        Bitmap createBitmap = Bitmap.createBitmap(max, max2, bitmap3.getConfig());
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap3, width < max ? ((float) (max - width)) * 0.5f : 0.0f, height < max2 ? ((float) (max2 - height)) * 0.5f : 0.0f, (Paint) null);
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, i2 < max ? ((float) (max - i2)) * 0.5f : 0.0f, i < max2 ? ((float) (max2 - i)) * 0.5f : 0.0f, (Paint) null);
        }
        if (bitmap2 != null) {
            canvas.drawBitmap(bitmap2, i4 < max ? ((float) (max - i4)) * 0.5f : 0.0f, i3 < max2 ? ((float) (max2 - i3)) * 0.5f : 0.0f, (Paint) null);
        }
        return createBitmap;
    }

    public boolean previewSnapshotReady() {
        return this.previewTexture != null;
    }
}

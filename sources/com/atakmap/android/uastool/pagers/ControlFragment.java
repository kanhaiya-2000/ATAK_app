package com.atakmap.android.uastool.pagers;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.pagers.joystick_ui.JoystickUIBase;
import com.atakmap.android.uastool.pagers.observer.ObserverControlFragment;
import com.atakmap.android.uastool.pagers.video_ui.ArOverlayView;
import com.atakmap.android.uastool.pagers.video_ui.VideoUIBase;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.UIConstants;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.prefs.UIPreferenceFragment;
import com.atakmap.android.uastool.tflite.customview.OverlayView;
import com.atakmap.coremap.log.Log;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

public abstract class ControlFragment extends UASToolFragment {
    /* access modifiers changed from: private */
    public static final String TAG = "ControlFragment";
    /* access modifiers changed from: protected */
    public ArOverlayView arOverlayView;
    protected RelativeLayout connectingLayout;
    protected RelativeLayout failedLayout;
    public RelativeLayout joystickLayout;
    protected JoystickUIBase joystickUI;
    public Screen lastScreen;
    protected final ScheduledExecutorService osdScheduler = Executors.newSingleThreadScheduledExecutor();
    protected Future<?> osdSchedulerHandle = null;
    protected UASToolPager parentPager;
    public OverlayView trackingView;
    public RelativeLayout uiLayout;
    protected RelativeLayout videoDisconnectOverlay;
    protected Button videoReconnectBtn;
    /* access modifiers changed from: protected */
    public VideoUIBase videoUI;

    public enum Screen {
        CONNECTING,
        VIDEO,
        FAILED
    }

    public abstract Bitmap getPreviewSnapshot(boolean z, boolean z2);

    public abstract boolean previewSnapshotReady();

    /* access modifiers changed from: protected */
    public abstract void startOSD();

    /* access modifiers changed from: protected */
    public abstract void stopOSD();

    public void setUASItem(UASItem uASItem) {
        super.setUASItem(uASItem);
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                ControlFragment.this.arOverlayView.setUASItem(ControlFragment.this.selectedUASItem);
                ControlFragment.this.switchVideoUI();
            }
        });
    }

    public void switchVideoUI() {
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                if (ControlFragment.this.videoUI != null) {
                    ViewGroup viewGroup = (ViewGroup) ControlFragment.this.videoUI.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(ControlFragment.this.videoUI);
                    }
                    ControlFragment.this.videoUI = null;
                }
                UIConstants.init(ControlFragment.this.pluginContext);
                if (ControlFragment.this.selectedUASItem != null) {
                    ControlFragment controlFragment = ControlFragment.this;
                    controlFragment.videoUI = VideoUIBase.getVideoUI(controlFragment.selectedUASItem);
                    ControlFragment.this.uiLayout.addView(ControlFragment.this.videoUI);
                    ControlFragment.this.videoUI.init(this, ControlFragment.this.parentPager, ControlFragment.this.selectedUASItem);
                }
            }
        });
        switchJoystickUI();
    }

    public void switchJoystickUI() {
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                if (ControlFragment.this.joystickLayout != null) {
                    ControlFragment.this.joystickLayout.setVisibility(8);
                }
                if (ControlFragment.this.joystickUI != null) {
                    ViewGroup viewGroup = (ViewGroup) ControlFragment.this.joystickUI.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(ControlFragment.this.joystickUI);
                    }
                    ControlFragment.this.joystickUI = null;
                }
                if (ControlFragment.this.selectedUASItem != null && ControlFragment.this.selectedUASItem.isDefault() && UASToolDropDownReceiver.getInstance().isFullscreenVideo() && ControlFragment.this.selectedUASItem.supportsVirtualJoystick()) {
                    ControlFragment.this.joystickUI = JoystickUIBase.getJoystickUI();
                    if (!(ControlFragment.this.joystickLayout == null || ControlFragment.this.joystickUI == null)) {
                        ControlFragment.this.joystickLayout.addView(ControlFragment.this.joystickUI);
                        ControlFragment.this.joystickUI.init(ControlFragment.this.selectedUASItem);
                    }
                    ControlFragment.this.applyJoystickUIVisibility();
                }
            }
        });
    }

    public void applyJoystickUIVisibility() {
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                if (ControlFragment.this.joystickLayout != null) {
                    if (UASToolDropDownReceiver.getSharedPrefs().getBoolean(UIPreferenceFragment.PREF_UI_JOYSTICK_VIRTUAL_ON, UIPreferenceFragment.DEFAULT_UI_JOYSTICK_VIRTUAL_ON.booleanValue())) {
                        ControlFragment.this.joystickLayout.setVisibility(0);
                        if (ControlFragment.this.joystickUI != null) {
                            ControlFragment.this.joystickUI.setVisibility(0);
                        }
                    } else {
                        ControlFragment.this.joystickLayout.setVisibility(8);
                        if (ControlFragment.this.joystickUI != null) {
                            ControlFragment.this.joystickUI.setVisibility(8);
                        }
                    }
                    ControlFragment.this.joystickLayout.invalidate();
                }
            }
        });
    }

    public void gotUASConnection() {
        startOSD();
    }

    public void lostUASConnection() {
        stopOSD();
    }

    public void onGimbalControlChanged(boolean z) {
        if (this.selectedUASItem != null) {
            this.selectedUASItem.onGimbalControlChanged(z);
            if (this instanceof ObserverControlFragment) {
                UASToolDropDownReceiver.onObserverUasItemStatusChanged();
            } else {
                UASToolDropDownReceiver.onUasItemStatusChanged();
            }
        }
    }

    public void resizeFull() {
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                ControlFragment.this.switchVideoUI();
            }
        });
    }

    public void resizeHalf() {
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                ControlFragment.this.switchVideoUI();
            }
        });
    }

    public boolean onBackPressed() {
        return super.onBackPressed();
    }

    public VideoUIBase getVideoUI() {
        return this.videoUI;
    }

    public ArOverlayView getArOverlay() {
        return this.arOverlayView;
    }

    public JoystickUIBase getJoystickUI() {
        return this.joystickUI;
    }

    public void showScreen(final Screen screen) {
        if (this.lastScreen != screen && this.selectedUASItem != null) {
            this.lastScreen = screen;
            MapView.getMapView().post(new Runnable() {
                public void run() {
                    if (ControlFragment.this.layoutView != null) {
                        TextView textView = (TextView) ControlFragment.this.layoutView.findViewById(C1877R.C1878id.failed_text);
                        TextView textView2 = (TextView) ControlFragment.this.layoutView.findViewById(C1877R.C1878id.progress);
                        String str = null;
                        if (ControlFragment.this.selectedUASItem != null) {
                            try {
                                str = ControlFragment.this.selectedUASItem.getVideoUrl();
                            } catch (Exception e) {
                                Log.e(ControlFragment.TAG, "Error getting video URI: ", e);
                            }
                        }
                        int i = C15828.f8394x7c048095[screen.ordinal()];
                        if (i == 1) {
                            ControlFragment.this.connectingLayout.bringToFront();
                            ControlFragment.this.connectingLayout.setVisibility(0);
                            ControlFragment.this.failedLayout.setVisibility(4);
                            ControlFragment.this.videoDisconnectOverlay.setVisibility(0);
                            if (str != null) {
                                textView2.setText(str);
                            } else {
                                textView2.setText(ControlFragment.this.pluginContext.getResources().getString(C1877R.string.connecting));
                            }
                        } else if (i == 2) {
                            ControlFragment.this.connectingLayout.setVisibility(8);
                            ControlFragment.this.failedLayout.setVisibility(8);
                            ControlFragment.this.videoDisconnectOverlay.setVisibility(8);
                            ControlFragment.this.arOverlayView.bringToFront();
                        } else if (i == 3) {
                            ControlFragment.this.failedLayout.bringToFront();
                            ControlFragment.this.connectingLayout.setVisibility(4);
                            ControlFragment.this.failedLayout.setVisibility(0);
                            ControlFragment.this.videoDisconnectOverlay.setVisibility(0);
                            if (str == null || str.isEmpty()) {
                                textView.setText(ControlFragment.this.pluginContext.getResources().getString(C1877R.string.video_not_broadcast));
                            } else {
                                textView.setText(ControlFragment.this.pluginContext.getResources().getString(C1877R.string.lost_connection));
                            }
                        }
                    }
                }
            });
        }
    }

    /* renamed from: com.atakmap.android.uastool.pagers.ControlFragment$8 */
    /* synthetic */ class C15828 {

        /* renamed from: $SwitchMap$com$atakmap$android$uastool$pagers$ControlFragment$Screen */
        static final /* synthetic */ int[] f8394x7c048095;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.atakmap.android.uastool.pagers.ControlFragment$Screen[] r0 = com.atakmap.android.uastool.pagers.ControlFragment.Screen.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8394x7c048095 = r0
                com.atakmap.android.uastool.pagers.ControlFragment$Screen r1 = com.atakmap.android.uastool.pagers.ControlFragment.Screen.CONNECTING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8394x7c048095     // Catch:{ NoSuchFieldError -> 0x001d }
                com.atakmap.android.uastool.pagers.ControlFragment$Screen r1 = com.atakmap.android.uastool.pagers.ControlFragment.Screen.VIDEO     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f8394x7c048095     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.atakmap.android.uastool.pagers.ControlFragment$Screen r1 = com.atakmap.android.uastool.pagers.ControlFragment.Screen.FAILED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.pagers.ControlFragment.C15828.<clinit>():void");
        }
    }
}

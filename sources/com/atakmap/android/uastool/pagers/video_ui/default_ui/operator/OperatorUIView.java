package com.atakmap.android.uastool.pagers.video_ui.default_ui.operator;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.pagers.ControlFragment;
import com.atakmap.android.uastool.pagers.UASToolPager;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.TaskWidget;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.UASHealthWidget;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.VideoUIView;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.prefs.UIPreferenceFragment;

public abstract class OperatorUIView extends VideoUIView {
    public static final String TAG = "OperatorUIView";
    protected static String opSideBarName;
    protected UASHealthWidget healthWidget;
    protected TaskWidget taskWidget;

    public OperatorUIView(Context context) {
        super(context);
    }

    public OperatorUIView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public OperatorUIView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.taskWidget = (TaskWidget) findViewById(C1877R.C1878id.video_ui_taskwidget);
        if (!isInEditMode()) {
            this.taskWidget.setVisibility(8);
        }
        this.healthWidget = (UASHealthWidget) findViewById(C1877R.C1878id.video_ui_healthwidget);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        closeSideBar();
    }

    public void init(ControlFragment controlFragment, UASToolPager uASToolPager, UASItem uASItem) {
        this.taskWidget.init(this, uASItem);
        this.healthWidget.init(this, uASItem);
        super.init(controlFragment, uASToolPager, uASItem);
    }

    /* access modifiers changed from: protected */
    public void updateSize() {
        super.updateSize();
        this.healthWidget.updateSize();
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                if (OperatorUIView.opSideBarName != null) {
                    String str = OperatorUIView.opSideBarName;
                    str.hashCode();
                    if (str.equals(OpGimbalBar.TAG)) {
                        OperatorUIView.opSideBarName = null;
                        OperatorUIView.this.toggleGimbalBar();
                    } else if (str.equals("OpCameraBar")) {
                        OperatorUIView.opSideBarName = null;
                        OperatorUIView.this.toggleCameraBar();
                    }
                }
                OperatorUIView.this.invalidate();
            }
        });
    }

    public void stopShowing() {
        super.stopShowing();
        closeSideBar();
    }

    private void closeSideBar() {
        if (this.sideBar != null) {
            opSideBarName = this.sideBar.getClass().getSimpleName();
            if (this.sideBar.isPoppedUp() && this.sideBar.getPopup() != null) {
                this.sideBar.getPopup().dismiss();
            }
        }
        this.sideBar = null;
    }

    public String getSideBarName() {
        return opSideBarName;
    }

    public void setSideBarName(String str) {
        opSideBarName = str;
    }

    public void updateOSDImpl() {
        super.updateOSDImpl();
        if (this.uasItem != null) {
            this.taskWidget.updateOSD();
            this.healthWidget.updateOSD();
        }
    }

    /* access modifiers changed from: protected */
    public void showOSD(final boolean z) {
        super.showOSD(z);
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                int i = 0;
                OperatorUIView.this.taskWidget.setVisibility(z ? 0 : 8);
                SharedPreferences sharedPrefs = UASToolDropDownReceiver.getSharedPrefs();
                UASHealthWidget uASHealthWidget = OperatorUIView.this.healthWidget;
                if (!z || !sharedPrefs.getBoolean(UIPreferenceFragment.PREF_UI_HEALTH_ON, UIPreferenceFragment.DEFAULT_UI_HEALTH_ON.booleanValue())) {
                    i = 4;
                }
                uASHealthWidget.setVisibility(i);
                OperatorUIView.this.invalidate();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void showAR(boolean z) {
        super.showAR(z);
    }

    /* access modifiers changed from: protected */
    public void showHealth(final boolean z) {
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                OperatorUIView.this.healthWidget.setVisibility((!z || !UASToolDropDownReceiver.getSharedPrefs().getBoolean(UIPreferenceFragment.PREF_UI_HEALTH_ON, UIPreferenceFragment.DEFAULT_UI_HEALTH_ON.booleanValue())) ? 4 : 0);
                OperatorUIView.this.invalidate();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void toggleGimbalBar() {
        toggleSideBar(Integer.valueOf(C1877R.layout.video_ui_op_gimbalbar));
    }

    /* access modifiers changed from: protected */
    public void toggleCameraBar() {
        toggleSideBar(Integer.valueOf(C1877R.layout.video_ui_op_camerabar));
    }

    public void onAccessoryChange() {
        super.onAccessoryChange();
        this.taskWidget.onAccessoryChange();
        this.healthWidget.onAccessoryChange();
    }

    public void broadcastStarted() {
        toast("Broadcast started");
        ((OpBottomBar) this.bottomBar).onBroadcastStarted();
    }

    public void broadcastStopped() {
        toast("Broadcast stopped");
        ((OpBottomBar) this.bottomBar).onBroadcastStopped();
    }
}

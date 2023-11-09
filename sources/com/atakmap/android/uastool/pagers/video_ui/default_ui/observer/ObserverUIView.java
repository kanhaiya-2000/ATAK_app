package com.atakmap.android.uastool.pagers.video_ui.default_ui.observer;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.VideoUIView;

public abstract class ObserverUIView extends VideoUIView {
    public static final String TAG = "ObserverUIView";
    protected static String obSideBarName;

    public ObserverUIView(Context context) {
        super(context);
    }

    public ObserverUIView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ObserverUIView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        closeSideBar();
    }

    /* access modifiers changed from: protected */
    public void updateSize() {
        super.updateSize();
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                if (ObserverUIView.obSideBarName != null) {
                    ObserverUIView.obSideBarName.getClass();
                }
                ObserverUIView.this.invalidate();
            }
        });
    }

    public void stopShowing() {
        super.stopShowing();
        closeSideBar();
    }

    private void closeSideBar() {
        if (this.sideBar != null) {
            obSideBarName = this.sideBar.getClass().getSimpleName();
            if (this.sideBar.isPoppedUp() && this.sideBar.getPopup() != null) {
                this.sideBar.getPopup().dismiss();
            }
        }
        this.sideBar = null;
    }

    public String getSideBarName() {
        return obSideBarName;
    }

    public void setSideBarName(String str) {
        obSideBarName = str;
    }

    public void onGimbalControlChanged(boolean z) {
        ((ObBottomBar) this.bottomBar).onGimbalControlChanged(z);
    }
}

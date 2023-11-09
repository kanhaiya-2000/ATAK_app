package com.atakmap.android.uastool.pagers.video_ui.default_ui;

import android.graphics.drawable.ColorDrawable;
import android.widget.PopupWindow;
import com.atakmap.android.maps.MapView;

public class SideBarPopup extends PopupWindow {
    public static final String TAG = "SideBarPopup";
    private final PopupWidget widget;

    public SideBarPopup(PopupWidget popupWidget) {
        super(MapView.getMapView().getContext());
        this.widget = popupWidget;
        setContentView(popupWidget);
        setBackgroundDrawable(new ColorDrawable(0));
        setElevation(40.0f);
        setWidth(-2);
        setHeight(-2);
        setOutsideTouchable(false);
        setClippingEnabled(true);
    }

    public void show() {
        if (this.widget.getNumberButtonsVisible() <= 5) {
            showAtLocation(MapView.getMapView(), 19, 0, 0);
        } else {
            showAtLocation(MapView.getMapView(), 83, 0, 0);
        }
    }

    public void showAt(int i, int i2) {
        if (this.widget.getNumberButtonsVisible() <= 5) {
            showAtLocation(MapView.getMapView(), 19, i, i2);
        } else {
            showAtLocation(MapView.getMapView(), 83, i, i2);
        }
    }
}

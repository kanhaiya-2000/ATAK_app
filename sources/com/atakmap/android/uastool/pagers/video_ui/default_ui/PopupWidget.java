package com.atakmap.android.uastool.pagers.video_ui.default_ui;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.atakmap.android.maps.MapView;

public abstract class PopupWidget extends MovableWidget {
    public static final String TAG = "PopupWidget";
    protected SideBarPopup popup;

    public PopupWidget(Context context) {
        super(context);
    }

    public PopupWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PopupWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode()) {
            if (this.fullLayoutParams != null) {
                this.fullLayoutParams.width = -2;
                this.fullLayoutParams.height = -2;
            }
            if (this.halfLayoutParams != null) {
                this.halfLayoutParams.width = -2;
                this.halfLayoutParams.height = -2;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void applyFull() {
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                PopupWidget popupWidget = PopupWidget.this;
                popupWidget.setLayoutParams(popupWidget.fullLayoutParams);
                PopupWidget.this.setPadding(UIConstants.VERTBAR_PAD_START, UIConstants.VERTBAR_PAD_TOP, UIConstants.VERTBAR_PAD_END, UIConstants.VERTBAR_PAD_BOTTOM);
                PopupWidget popupWidget2 = PopupWidget.this;
                popupWidget2.setTranslationX(popupWidget2.getSavedPositionX());
                PopupWidget popupWidget3 = PopupWidget.this;
                popupWidget3.setTranslationY(popupWidget3.getSavedPositionY());
                for (int i = 0; i < PopupWidget.this.getChildCount(); i++) {
                    View childAt = PopupWidget.this.getChildAt(i);
                    if (childAt instanceof VideoUIButton) {
                        VideoUIButton videoUIButton = (VideoUIButton) childAt;
                        videoUIButton.setBackground(videoUIButton.fullBackground);
                        videoUIButton.setLayoutParams(videoUIButton.fullLayoutParams);
                    }
                }
                PopupWidget.this.requestLayout();
                PopupWidget.this.invalidate();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void applyHalf() {
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                PopupWidget.this.setPadding(UIConstants.WIDGET_PAD_HALF, UIConstants.WIDGET_PAD_HALF, UIConstants.WIDGET_PAD_HALF, UIConstants.WIDGET_PAD_HALF);
                PopupWidget.this.setTranslationX(0.0f);
                PopupWidget.this.setTranslationY(0.0f);
                for (int i = 0; i < PopupWidget.this.getChildCount(); i++) {
                    View childAt = PopupWidget.this.getChildAt(i);
                    if (childAt instanceof VideoUIButton) {
                        VideoUIButton videoUIButton = (VideoUIButton) childAt;
                        videoUIButton.setBackground(videoUIButton.halfBackground);
                        videoUIButton.setLayoutParams(videoUIButton.halfLayoutParams);
                    }
                }
                PopupWidget.this.requestLayout();
                PopupWidget.this.invalidate();
            }
        });
    }

    public boolean isPoppedUp() {
        return this.popup != null;
    }

    public PopupWindow getPopup() {
        return this.popup;
    }

    public void showPopup() {
        if (!isInEditMode()) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
            this.popup = new SideBarPopup(this);
            setVisibility(0);
            this.popup.show();
        }
    }

    public void showPopupAt(int i, int i2) {
        if (!isInEditMode()) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
            this.popup = new SideBarPopup(this);
            setVisibility(0);
            this.popup.showAt(i, i2);
        }
    }

    public void hidePopup() {
        if (!isInEditMode()) {
            ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        if (PopupWidget.this.popup != null) {
                            PopupWidget.this.popup.dismiss();
                            PopupWidget.this.setVisibility(8);
                            if (PopupWidget.this.getParent() != null) {
                                ((ViewGroup) PopupWidget.this.getParent()).removeView(this);
                            }
                            PopupWidget.this.popup = null;
                            PopupWidget.this.videoUIView.addView(this);
                        }
                    } catch (Exception e) {
                        PopupWidget popupWidget = PopupWidget.this;
                        popupWidget.toast("Exception hiding popup: " + e.getLocalizedMessage());
                    }
                }
            });
        }
    }

    public int getNumberButtonsVisible() {
        int i = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if ((childAt instanceof VideoUIButton) && childAt.getVisibility() == 0) {
                i++;
            }
        }
        return i;
    }
}

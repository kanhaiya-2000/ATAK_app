package com.atakmap.android.uastool.pagers.video_ui.default_ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.HealthScreen;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.pagers.UASToolFragment;
import com.atakmap.android.uastool.plugin.C1877R;

public class UASHealthWidget extends MovableWidget {
    public static final String TAG = "UASHealthWidget";
    /* access modifiers changed from: private */
    public HEALTH health;
    /* access modifiers changed from: private */
    public ImageView heartImage;
    /* access modifiers changed from: private */
    public String text;
    /* access modifiers changed from: private */
    public TextView textText;
    /* access modifiers changed from: private */
    public String title;
    /* access modifiers changed from: private */
    public TextView titleText;

    public enum HEALTH {
        NONE("None", -1),
        GOOD("Good", Color.rgb(0, 220, 0)),
        WARN("Warn", Color.rgb(220, 220, 0)),
        ERROR("Error", Color.rgb(220, 0, 0));
        
        private final int color;
        private final String name;

        private HEALTH(String str, int i) {
            this.name = str;
            this.color = i;
        }

        public String getName() {
            return this.name;
        }

        public int getColor() {
            return this.color;
        }

        public String toString() {
            return this.name;
        }
    }

    public UASHealthWidget(Context context) {
        super(context);
    }

    public UASHealthWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public UASHealthWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.health = HEALTH.NONE;
        ImageView imageView = (ImageView) findViewById(C1877R.C1878id.health_image);
        this.heartImage = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                UASHealthWidget.this.showHealth();
            }
        });
        this.titleText = (TextView) findViewById(C1877R.C1878id.health_title);
        this.textText = (TextView) findViewById(C1877R.C1878id.health_text);
    }

    public void init(VideoUIView videoUIView, UASItem uASItem) {
        super.init(videoUIView, uASItem);
        this.health = HEALTH.NONE;
    }

    public void updateSize() {
        super.updateSize();
        if (!isInEditMode()) {
            ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
                public void run() {
                    if (UASHealthWidget.this.isFullScreen()) {
                        UASHealthWidget.this.titleText.setVisibility(0);
                        UASHealthWidget.this.textText.setVisibility(0);
                        UASHealthWidget uASHealthWidget = UASHealthWidget.this;
                        uASHealthWidget.setPadding(uASHealthWidget.fullStartPad, UASHealthWidget.this.fullTopPad, UASHealthWidget.this.fullEndPad, UASHealthWidget.this.fullBottomPad);
                    } else {
                        UASHealthWidget.this.titleText.setVisibility(8);
                        UASHealthWidget.this.textText.setVisibility(8);
                        UASHealthWidget.this.setPadding(UIConstants.WIDGET_PAD_HALF, UIConstants.WIDGET_PAD_HALF, UIConstants.WIDGET_PAD_HALF, UIConstants.WIDGET_PAD_HALF);
                    }
                    UASHealthWidget.this.invalidate();
                }
            });
        }
    }

    public void setVisibility(int i) {
        if (this.uasItem == null || !this.uasItem.supportsHealth()) {
            super.setVisibility(8);
        } else {
            super.setVisibility(i);
        }
    }

    public void updateOSD() {
        super.updateOSD();
        if (this.uasItem != null) {
            if (!(this.uasItem.getHealth() == null || this.uasItem.getHealth() == this.health)) {
                setHealth(this.uasItem.getHealth());
            }
            if (!TextUtils.isEmpty(this.uasItem.getHealthTitle()) && this.uasItem.getHealthTitle() != this.title) {
                setTitle(this.uasItem.getHealthTitle());
            }
            if (!TextUtils.isEmpty(this.uasItem.getHealthText()) && this.uasItem.getHealthText() != this.text) {
                setText(this.uasItem.getHealthText());
            }
        }
    }

    /* access modifiers changed from: private */
    public void showHealth() {
        if (this.uasItem != null) {
            if (UASToolDropDownReceiver.getInstance().isFullscreenVideo()) {
                UASToolDropDownReceiver.getInstance().resizeHalf();
            }
            HealthScreen platformHealthScreen = this.uasItem.getPlatformHealthScreen(LayoutInflater.from(UASToolDropDownReceiver.getInstance().getPluginContext()));
            UASToolFragment currentFragment = UASToolDropDownReceiver.getInstance().getActivePager().getCurrentFragment();
            if (currentFragment != null) {
                currentFragment.setCurrentScreen(platformHealthScreen, this.uasItem, currentFragment);
            } else {
                toast("Unable to show Health screen: bad fragment");
            }
        } else {
            toast("Unable to show Health screen: no connected uas");
        }
    }

    private void setHealth(HEALTH health2) {
        this.health = health2;
        if (!isInEditMode()) {
            ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
                public void run() {
                    UASHealthWidget.this.heartImage.setColorFilter(UASHealthWidget.this.health.getColor(), PorterDuff.Mode.MULTIPLY);
                    UASHealthWidget.this.invalidate();
                }
            });
        }
    }

    public HEALTH getHealth() {
        return this.health;
    }

    private void setTitle(String str) {
        this.title = str;
        if (!isInEditMode() && !TextUtils.isEmpty(this.title)) {
            ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
                public void run() {
                    UASHealthWidget.this.titleText.setText(UASHealthWidget.this.title);
                    UASHealthWidget.this.invalidate();
                }
            });
        }
    }

    private void setText(String str) {
        this.text = str;
        if (!isInEditMode() && !TextUtils.isEmpty(this.text)) {
            ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
                public void run() {
                    UASHealthWidget.this.textText.setText(UASHealthWidget.this.text);
                    UASHealthWidget.this.invalidate();
                }
            });
        }
    }
}

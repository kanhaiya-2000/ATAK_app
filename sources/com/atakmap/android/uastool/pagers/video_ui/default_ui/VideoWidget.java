package com.atakmap.android.uastool.pagers.video_ui.default_ui;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.prefs.UIPreferenceFragment;

public abstract class VideoWidget extends RelativeLayout implements SharedPreferences.OnSharedPreferenceChangeListener {
    public static final int BLACK = Color.parseColor("#000000");
    public static final int DARK_GRAY = Color.parseColor("#333333");
    public static final int GREEN = Color.parseColor("#00FF00");
    public static final int LITE_GRAY = Color.parseColor("#c8c8c8");
    public static final int RED = Color.parseColor("#FF0000");
    public static final String TAG = VideoWidget.class.getSimpleName();
    public static final int WHITE = Color.parseColor("#FFFFFF");
    public static final int YELLOW = Color.parseColor("#FFFF00");
    protected int defaultTextColor;
    protected int fullBottomPad;
    protected int fullEndPad;
    protected RelativeLayout.LayoutParams fullLayoutParams;
    protected int fullStartPad;
    protected int fullTopPad;
    protected RelativeLayout.LayoutParams halfLayoutParams;
    protected Context myContext;
    /* access modifiers changed from: protected */
    public UASItem uasItem;
    /* access modifiers changed from: protected */
    public VideoUIView videoUIView;

    public void onAccessoryChange() {
    }

    public void updateOSD() {
    }

    public VideoWidget(Context context) {
        super(context);
        this.myContext = context;
    }

    public VideoWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.myContext = context;
    }

    public VideoWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.myContext = context;
    }

    public void toast(String str) {
        if (!isInEditMode()) {
            UASToolDropDownReceiver.toast(str);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode()) {
            try {
                this.fullLayoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
                this.halfLayoutParams = new RelativeLayout.LayoutParams(this.fullLayoutParams);
            } catch (Exception unused) {
            }
        }
        this.fullStartPad = getPaddingStart();
        this.fullTopPad = getPaddingTop();
        this.fullEndPad = getPaddingEnd();
        this.fullBottomPad = getPaddingBottom();
        setElevation(10.0f);
        if (!isInEditMode()) {
            this.defaultTextColor = Color.parseColor(UASToolDropDownReceiver.getSharedPrefs().getString(UIPreferenceFragment.PREF_OSD_TEXT_COLOR, UIPreferenceFragment.DEFAULT_OSD_TEXT_COLOR));
            UASToolDropDownReceiver.getSharedPrefs().registerOnSharedPreferenceChangeListener(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        UASToolDropDownReceiver.getSharedPrefs().unregisterOnSharedPreferenceChangeListener(this);
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        str.hashCode();
        if (str.equals(UIPreferenceFragment.PREF_OSD_TEXT_COLOR)) {
            setTextColor(Color.parseColor(sharedPreferences.getString(UIPreferenceFragment.PREF_OSD_TEXT_COLOR, UIPreferenceFragment.DEFAULT_OSD_TEXT_COLOR)));
        }
    }

    public void init(VideoUIView videoUIView2, UASItem uASItem) {
        this.videoUIView = videoUIView2;
        this.uasItem = uASItem;
        updateSize();
    }

    /* access modifiers changed from: protected */
    public void updateSize() {
        if (!isInEditMode()) {
            ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
                public void run() {
                    if (VideoWidget.this.isFullScreen()) {
                        VideoWidget videoWidget = VideoWidget.this;
                        videoWidget.setLayoutParams(videoWidget.fullLayoutParams);
                    } else {
                        VideoWidget videoWidget2 = VideoWidget.this;
                        videoWidget2.setLayoutParams(videoWidget2.halfLayoutParams);
                    }
                    VideoWidget.this.invalidate();
                }
            });
        }
    }

    public boolean isFullScreen() {
        if (!isInEditMode()) {
            return UASToolDropDownReceiver.getInstance().isFullscreenVideo();
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void setTextColor(int i) {
        this.defaultTextColor = i;
    }
}

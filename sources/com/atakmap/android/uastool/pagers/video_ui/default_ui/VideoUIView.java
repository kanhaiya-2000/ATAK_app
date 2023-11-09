package com.atakmap.android.uastool.pagers.video_ui.default_ui;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.atak.plugins.impl.PluginLayoutInflater;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.pagers.ControlFragment;
import com.atakmap.android.uastool.pagers.UASToolPager;
import com.atakmap.android.uastool.pagers.observer.ObserverFmvComponent;
import com.atakmap.android.uastool.pagers.observer.ObserverPager;
import com.atakmap.android.uastool.pagers.operator.OperatorPager;
import com.atakmap.android.uastool.pagers.operator.PreviewTextureView;
import com.atakmap.android.uastool.pagers.video_ui.VideoUIBase;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.coremap.log.Log;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public abstract class VideoUIView extends VideoUIBase implements SharedPreferences.OnSharedPreferenceChangeListener {
    public static float SCALE;
    public static final String TAG = VideoUIView.class.getSimpleName();
    private static final ScheduledExecutorService thermalScheduler = Executors.newSingleThreadScheduledExecutor();
    private static Future<?> thermalSchedulerHandle = null;
    protected BottomBarWidget bottomBar;
    protected ThermalColdSpot coldspot;
    protected ThermalHotSpot hotspot;
    protected ReticleWidget reticleWidget;
    protected PopupWidget sideBar;
    protected TopBarWidget topBarWidget;
    protected UASHeadingWidget uasHeadingWidget;

    public VideoUIView(Context context) {
        super(context);
    }

    public VideoUIView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VideoUIView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode()) {
            SCALE = UASToolDropDownReceiver.getInstance().getPluginContext().getResources().getDisplayMetrics().density;
        }
        this.topBarWidget = (TopBarWidget) findViewById(C1877R.C1878id.video_ui_topbar);
        this.uasHeadingWidget = (UASHeadingWidget) findViewById(C1877R.C1878id.video_ui_uasheadingwidget);
        this.reticleWidget = (ReticleWidget) findViewById(C1877R.C1878id.video_ui_reticlewidget);
        this.bottomBar = (BottomBarWidget) findViewById(C1877R.C1878id.video_ui_bottombar);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Future<?> future = thermalSchedulerHandle;
        if (future != null) {
            future.cancel(false);
            thermalSchedulerHandle = null;
        }
    }

    public void init(ControlFragment controlFragment, UASToolPager uASToolPager, UASItem uASItem) {
        this.uasItem = uASItem;
        this.topBarWidget.init(this, uASItem);
        this.uasHeadingWidget.init(this, uASItem);
        this.reticleWidget.init(this, uASItem);
        this.bottomBar.init(this, uASItem);
        if (uASItem == null || !uASItem.supportsUASHeading()) {
            this.uasHeadingWidget.setVisibility(8);
        } else {
            this.uasHeadingWidget.setVisibility(0);
        }
        super.init(controlFragment, uASToolPager, uASItem);
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        super.onSharedPreferenceChanged(sharedPreferences, str);
        str.getClass();
    }

    /* access modifiers changed from: protected */
    public void updateSize() {
        super.updateSize();
    }

    public void updateOSDImpl() {
        if (this.uasItem != null) {
            this.topBarWidget.updateOSD();
            this.uasHeadingWidget.updateOSD();
            this.reticleWidget.updateOSD();
            this.bottomBar.updateOSD();
            PopupWidget popupWidget = this.sideBar;
            if (popupWidget != null) {
                popupWidget.updateOSD();
            }
        }
    }

    public int getTopBarBottom() {
        this.topBarWidget.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.topBarWidget.getMeasuredHeight();
    }

    /* access modifiers changed from: protected */
    public void showOSD(final boolean z) {
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                int i = 0;
                VideoUIView.this.topBarWidget.setVisibility(z ? 0 : 8);
                VideoUIView.this.reticleWidget.setVisibility(z ? 0 : 8);
                if (VideoUIView.this.uasItem == null || !VideoUIView.this.uasItem.supportsUASHeading()) {
                    VideoUIView.this.uasHeadingWidget.setVisibility(8);
                } else {
                    UASHeadingWidget uASHeadingWidget = VideoUIView.this.uasHeadingWidget;
                    if (!z) {
                        i = 8;
                    }
                    uASHeadingWidget.setVisibility(i);
                }
                VideoUIView.this.invalidate();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void showAR(boolean z) {
        this.controlFragment.getArOverlay().setArEnabled(z);
    }

    public PopupWidget buildSideBar(Integer num) {
        PopupWidget popupWidget = (PopupWidget) PluginLayoutInflater.inflate(this.pluginContext, num.intValue(), (ViewGroup) null);
        addView(popupWidget);
        popupWidget.init(this, this.uasItem);
        popupWidget.setVisibility(8);
        popupWidget.setX(0.0f);
        popupWidget.setTranslationX(popupWidget.getSavedPositionX());
        popupWidget.setY(0.0f);
        float savedPositionY = popupWidget.getSavedPositionY();
        if (savedPositionY <= 0.0f) {
            savedPositionY = (float) getTopBarBottom();
        }
        popupWidget.setTranslationY(savedPositionY);
        popupWidget.setSavedPosition(true);
        return popupWidget;
    }

    public void toggleSideBar(final Integer num) {
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                Integer num = num;
                PopupWidget buildSideBar = num != null ? VideoUIView.this.buildSideBar(num) : null;
                if (buildSideBar == null) {
                    if (VideoUIView.this.sideBar != null) {
                        if (VideoUIView.this.sideBar.isPoppedUp()) {
                            VideoUIView.this.sideBar.hidePopup();
                        } else {
                            VideoUIView.this.sideBar.setVisibility(8);
                        }
                        VideoUIView.this.sideBar = null;
                    }
                } else if (VideoUIView.this.sideBar != null) {
                    if (VideoUIView.this.sideBar.getClass().equals(buildSideBar.getClass())) {
                        if (VideoUIView.this.sideBar.isPoppedUp()) {
                            VideoUIView.this.sideBar.hidePopup();
                        } else {
                            VideoUIView.this.sideBar.setVisibility(8);
                        }
                        VideoUIView.this.sideBar = null;
                    } else if (VideoUIView.this.sideBar.isPoppedUp()) {
                        VideoUIView.this.sideBar.hidePopup();
                        VideoUIView.this.sideBar = buildSideBar;
                        VideoUIView.this.sideBar.applyHalf();
                        VideoUIView.this.sideBar.showPopup();
                    } else {
                        VideoUIView.this.sideBar.setVisibility(8);
                        VideoUIView.this.sideBar = buildSideBar;
                        VideoUIView.this.sideBar.applyFull();
                        VideoUIView.this.sideBar.setVisibility(0);
                    }
                } else if (VideoUIView.this.isFullScreen()) {
                    VideoUIView.this.sideBar = buildSideBar;
                    VideoUIView.this.sideBar.applyFull();
                    VideoUIView.this.sideBar.setVisibility(0);
                } else {
                    VideoUIView.this.sideBar = buildSideBar;
                    VideoUIView.this.sideBar.applyHalf();
                    VideoUIView.this.sideBar.showPopup();
                }
            }
        });
    }

    public PopupWidget getSideBar() {
        return this.sideBar;
    }

    public void onAccessoryChange() {
        this.topBarWidget.onAccessoryChange();
        this.uasHeadingWidget.onAccessoryChange();
        this.reticleWidget.onAccessoryChange();
        this.bottomBar.onAccessoryChange();
        PopupWidget popupWidget = this.sideBar;
        if (popupWidget != null) {
            popupWidget.onAccessoryChange();
        }
    }

    public void startThermalMetering() {
        Future<?> future = thermalSchedulerHandle;
        if (future != null) {
            future.cancel(false);
            thermalSchedulerHandle = null;
        }
        thermalSchedulerHandle = thermalScheduler.scheduleAtFixedRate(new Runnable() {
            public void run() {
                try {
                    if (!VideoUIView.this.isInEditMode()) {
                        VideoUIView videoUIView = VideoUIView.this;
                        videoUIView.updateThermalData(videoUIView.uasItem.getThermalData());
                    }
                } catch (Exception e) {
                    UASToolDropDownReceiver.toast("Thermal Metering crash: " + e.getLocalizedMessage(), 1);
                    Log.e(VideoUIView.TAG, "Thermal Metering crash: ", e);
                }
            }
        }, 1000, 1000, TimeUnit.MILLISECONDS);
    }

    public void stopThermalMetering() {
        Future<?> future = thermalSchedulerHandle;
        if (future != null) {
            future.cancel(false);
            thermalSchedulerHandle = null;
        }
        if (!isInEditMode()) {
            updateThermalData((ThermalData) null);
        }
    }

    public void updateThermalData(final ThermalData thermalData) {
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                int width;
                int height;
                float width2;
                int height2;
                if (thermalData == null) {
                    if (VideoUIView.this.hotspot != null) {
                        VideoUIView.this.hotspot.setVisibility(8);
                        VideoUIView videoUIView = VideoUIView.this;
                        videoUIView.removeView(videoUIView.hotspot);
                        VideoUIView.this.hotspot = null;
                    }
                    if (VideoUIView.this.coldspot != null) {
                        VideoUIView.this.coldspot.setVisibility(8);
                        VideoUIView videoUIView2 = VideoUIView.this;
                        videoUIView2.removeView(videoUIView2.coldspot);
                        VideoUIView.this.coldspot = null;
                    }
                } else {
                    if (VideoUIView.this.parentPager instanceof OperatorPager) {
                        PreviewTextureView previewTexture = ((OperatorPager) VideoUIView.this.parentPager).getPreviewTexture();
                        width = previewTexture.getWidth();
                        height = previewTexture.getHeight();
                        width2 = ((float) (this.getWidth() - width)) / 2.0f;
                        height2 = this.getHeight();
                    } else if (VideoUIView.this.parentPager instanceof ObserverPager) {
                        ObserverFmvComponent fMVComponent = ((ObserverPager) VideoUIView.this.parentPager).getFMVComponent();
                        width = fMVComponent.getWidth();
                        height = fMVComponent.getHeight();
                        width2 = ((float) (this.getWidth() - width)) / 2.0f;
                        height2 = this.getHeight();
                    } else {
                        VideoUIView.this.toast("Unexpected pager type in VideoUIView.updateThermalData()");
                        return;
                    }
                    float f = ((float) (height2 - height)) / 2.0f;
                    boolean z = false;
                    if (VideoUIView.this.hotspot == null) {
                        VideoUIView videoUIView3 = VideoUIView.this;
                        videoUIView3.hotspot = (ThermalHotSpot) PluginLayoutInflater.inflate(videoUIView3.pluginContext, C1877R.layout.video_ui_thermal_hotspot, (ViewGroup) null);
                        VideoUIView.this.hotspot.setX(0.0f);
                        VideoUIView.this.hotspot.setY(0.0f);
                        VideoUIView videoUIView4 = VideoUIView.this;
                        videoUIView4.addView(videoUIView4.hotspot);
                        VideoUIView.this.hotspot.setVisibility(0);
                    }
                    VideoUIView.this.hotspot.update(thermalData.maxTemp, thermalData.tempUnitsLabel, ((double) thermalData.maxY) > 0.8d);
                    float f2 = (float) width;
                    VideoUIView.this.hotspot.setTranslationX(((thermalData.maxX * f2) + width2) - (((float) VideoUIView.this.hotspot.getWidth()) / 2.0f));
                    float f3 = (float) height;
                    VideoUIView.this.hotspot.setTranslationY(((thermalData.maxY * f3) + f) - (((float) VideoUIView.this.hotspot.getHeight()) / 2.0f));
                    if (VideoUIView.this.coldspot == null) {
                        VideoUIView videoUIView5 = VideoUIView.this;
                        videoUIView5.coldspot = (ThermalColdSpot) PluginLayoutInflater.inflate(videoUIView5.pluginContext, C1877R.layout.video_ui_thermal_coldspot, (ViewGroup) null);
                        VideoUIView.this.coldspot.setX(0.0f);
                        VideoUIView.this.coldspot.setY(0.0f);
                        VideoUIView videoUIView6 = VideoUIView.this;
                        videoUIView6.addView(videoUIView6.coldspot);
                        VideoUIView.this.coldspot.setVisibility(0);
                    }
                    if (((double) thermalData.minY) > 0.8d) {
                        z = true;
                    }
                    VideoUIView.this.coldspot.update(thermalData.minTemp, thermalData.tempUnitsLabel, z);
                    VideoUIView.this.coldspot.setTranslationX((width2 + (f2 * thermalData.minX)) - (((float) VideoUIView.this.coldspot.getWidth()) / 2.0f));
                    VideoUIView.this.coldspot.setTranslationY((f + (f3 * thermalData.minY)) - (((float) VideoUIView.this.coldspot.getHeight()) / 2.0f));
                }
                VideoUIView.this.invalidate();
            }
        });
    }
}

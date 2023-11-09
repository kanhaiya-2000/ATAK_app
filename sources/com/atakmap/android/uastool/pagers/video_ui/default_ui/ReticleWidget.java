package com.atakmap.android.uastool.pagers.video_ui.default_ui;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.pagers.video_ui.VideoUIBase;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.prefs.UIPreferenceFragment;

public class ReticleWidget extends VideoWidget {
    public static final String TAG = "ReticleWidget";
    /* access modifiers changed from: private */
    public ImageView reticleImage;
    /* access modifiers changed from: private */
    public ViewGroup.LayoutParams reticleImageParams;
    /* access modifiers changed from: private */
    public TextView spoiCoordinatesText;
    /* access modifiers changed from: private */
    public TextView spoiSRBText;

    public ReticleWidget(Context context) {
        super(context);
    }

    public ReticleWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ReticleWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ImageView imageView = (ImageView) findViewById(C1877R.C1878id.reticle_image);
        this.reticleImage = imageView;
        this.reticleImageParams = imageView.getLayoutParams();
        if (!isInEditMode()) {
            SharedPreferences sharedPrefs = UASToolDropDownReceiver.getSharedPrefs();
            reticleImageChanged(sharedPrefs.getInt(UIPreferenceFragment.PREF_RETICLE_IMAGE, UIPreferenceFragment.getDefaultReticleId()));
            reticleSizeChanged(sharedPrefs.getString(UIPreferenceFragment.PREF_RETICLE_SIZE, UIPreferenceFragment.DEFAULT_RETICLE_SIZE));
            reticleColorChanged(Color.parseColor(sharedPrefs.getString(UIPreferenceFragment.PREF_RETICLE_COLOR, UIPreferenceFragment.DEFAULT_RETICLE_COLOR)));
        }
        this.spoiCoordinatesText = (TextView) findViewById(C1877R.C1878id.reticle_spoi_coordinates);
        this.spoiSRBText = (TextView) findViewById(C1877R.C1878id.reticle_spoi_rangebearing);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void updateSize() {
        super.updateSize();
        if (!isInEditMode()) {
            reticleSizeChanged(UASToolDropDownReceiver.getSharedPrefs().getString(UIPreferenceFragment.PREF_RETICLE_SIZE, UIPreferenceFragment.DEFAULT_RETICLE_SIZE));
            ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
                public void run() {
                    if (ReticleWidget.this.isFullScreen()) {
                        ReticleWidget.this.spoiCoordinatesText.setVisibility(0);
                        ReticleWidget.this.spoiSRBText.setVisibility(0);
                    } else {
                        ReticleWidget.this.spoiCoordinatesText.setVisibility(8);
                        ReticleWidget.this.spoiSRBText.setVisibility(8);
                    }
                    ReticleWidget.this.invalidate();
                }
            });
        }
    }

    public void updateOSD() {
        if (this.uasItem == null || this.uasItem.isStale()) {
            this.spoiCoordinatesText.setText(C1877R.string.dashdashdash);
            this.spoiSRBText.setText(C1877R.string.dashdashdash);
            return;
        }
        this.spoiCoordinatesText.setText(VideoUIBase.getSPoICoordsDisplay(this.uasItem));
        this.spoiSRBText.setText(VideoUIBase.getSRaBToTargetDisplay(this.uasItem));
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        super.onSharedPreferenceChanged(sharedPreferences, str);
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1197213927:
                if (str.equals(UIPreferenceFragment.PREF_RETICLE_SIZE)) {
                    c = 0;
                    break;
                }
                break;
            case 1526463307:
                if (str.equals(UIPreferenceFragment.PREF_RETICLE_COLOR)) {
                    c = 1;
                    break;
                }
                break;
            case 1531934019:
                if (str.equals(UIPreferenceFragment.PREF_RETICLE_IMAGE)) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                reticleSizeChanged(sharedPreferences.getString(UIPreferenceFragment.PREF_RETICLE_SIZE, UIPreferenceFragment.DEFAULT_RETICLE_SIZE));
                return;
            case 1:
                reticleColorChanged(Color.parseColor(sharedPreferences.getString(UIPreferenceFragment.PREF_RETICLE_COLOR, UIPreferenceFragment.DEFAULT_RETICLE_COLOR)));
                return;
            case 2:
                reticleImageChanged(sharedPreferences.getInt(UIPreferenceFragment.PREF_RETICLE_IMAGE, UIPreferenceFragment.getDefaultReticleId()));
                return;
            default:
                return;
        }
    }

    public void reticleColorChanged(final int i) {
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                ReticleWidget.this.reticleImage.setColorFilter(i, PorterDuff.Mode.MULTIPLY);
            }
        });
    }

    public void reticleImageChanged(final int i) {
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                ReticleWidget.this.reticleImage.setImageResource(i);
            }
        });
    }

    public void reticleSizeChanged(final String str) {
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                String str = str;
                str.hashCode();
                char c = 65535;
                switch (str.hashCode()) {
                    case -1994163307:
                        if (str.equals(UIPreferenceFragment.DEFAULT_RETICLE_SIZE)) {
                            c = 0;
                            break;
                        }
                        break;
                    case 73190171:
                        if (str.equals("Large")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 79996135:
                        if (str.equals("Small")) {
                            c = 2;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        if (!ReticleWidget.this.isFullScreen()) {
                            ReticleWidget.this.reticleImageParams.width = UIConstants.RETICLE_SIZE_HALF_MEDIUM;
                            ReticleWidget.this.reticleImageParams.height = UIConstants.RETICLE_SIZE_HALF_MEDIUM;
                            break;
                        } else {
                            ReticleWidget.this.reticleImageParams.width = UIConstants.RETICLE_SIZE_FULL_MEDIUM;
                            ReticleWidget.this.reticleImageParams.height = UIConstants.RETICLE_SIZE_FULL_MEDIUM;
                            break;
                        }
                    case 1:
                        if (!ReticleWidget.this.isFullScreen()) {
                            ReticleWidget.this.reticleImageParams.width = UIConstants.RETICLE_SIZE_HALF_LARGE;
                            ReticleWidget.this.reticleImageParams.height = UIConstants.RETICLE_SIZE_HALF_LARGE;
                            break;
                        } else {
                            ReticleWidget.this.reticleImageParams.width = UIConstants.RETICLE_SIZE_FULL_LARGE;
                            ReticleWidget.this.reticleImageParams.height = UIConstants.RETICLE_SIZE_FULL_LARGE;
                            break;
                        }
                    case 2:
                        if (!ReticleWidget.this.isFullScreen()) {
                            ReticleWidget.this.reticleImageParams.width = UIConstants.RETICLE_SIZE_HALF_SMALL;
                            ReticleWidget.this.reticleImageParams.height = UIConstants.RETICLE_SIZE_HALF_SMALL;
                            break;
                        } else {
                            ReticleWidget.this.reticleImageParams.width = UIConstants.RETICLE_SIZE_FULL_SMALL;
                            ReticleWidget.this.reticleImageParams.height = UIConstants.RETICLE_SIZE_FULL_SMALL;
                            break;
                        }
                }
                ReticleWidget.this.reticleImage.setLayoutParams(ReticleWidget.this.reticleImageParams);
                ReticleWidget.this.invalidate();
            }
        });
    }
}

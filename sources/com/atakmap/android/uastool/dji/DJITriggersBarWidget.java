package com.atakmap.android.uastool.dji;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.PopupWidget;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.VideoUIButton;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.VideoUIView;
import com.atakmap.android.uastool.plugin.BuildConfig;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.util.a;

public class DJITriggersBarWidget extends PopupWidget {
    public static final String TAG = "DJITriggersBarWidget";
    public VideoUIButton leftButton;
    public VideoUIButton rightButton;
    public VideoUIButton settingsButton;

    public DJITriggersBarWidget(Context context) {
        super(context);
    }

    public DJITriggersBarWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DJITriggersBarWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        SharedPreferences sharedPrefs = !isInEditMode() ? UASToolDropDownReceiver.getSharedPrefs() : null;
        if (sharedPrefs != null) {
            SharedPreferences.Editor edit = sharedPrefs.edit();
            edit.putString(DJITriggersSettingsLayout.SHOW_TRIGGERS_PREF, Boolean.toString(true));
            edit.apply();
            VideoUIButton videoUIButton = (VideoUIButton) findViewById(C1877R.C1878id.dji_triggers_settings_button);
            this.settingsButton = videoUIButton;
            videoUIButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DJITriggersBarWidget.this.showSettings();
                }
            });
            VideoUIButton videoUIButton2 = (VideoUIButton) findViewById(C1877R.C1878id.dji_triggers_left_button);
            this.leftButton = videoUIButton2;
            videoUIButton2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DJITriggersBarWidget.this.actuateLeftTrigger();
                }
            });
            VideoUIButton videoUIButton3 = (VideoUIButton) findViewById(C1877R.C1878id.dji_triggers_right_button);
            this.rightButton = videoUIButton3;
            videoUIButton3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DJITriggersBarWidget.this.actuateRightTrigger();
                }
            });
        }
    }

    public void init(VideoUIView videoUIView, UASItem uASItem) {
        super.init(videoUIView, uASItem);
        updateButtons();
    }

    public void onAccessoryChange() {
        updateButtons();
        if (!hasTriggers()) {
            setVisibility(8);
            hidePopup();
        }
    }

    private void updateButtons() {
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                if (OnboardSdkHelper.getInstance().getTriggersEnabled()) {
                    DJITriggersBarWidget.this.leftButton.setEnabled(true);
                    DJITriggersBarWidget.this.rightButton.setEnabled(true);
                    return;
                }
                DJITriggersBarWidget.this.leftButton.setEnabled(false);
                DJITriggersBarWidget.this.rightButton.setEnabled(false);
            }
        });
    }

    private boolean checkOnboardSdkCIV() {
        String j = a.j();
        return j == null || j.equalsIgnoreCase(BuildConfig.FLAVOR);
    }

    /* access modifiers changed from: private */
    public void showSettings() {
        if (checkOnboardSdkCIV()) {
            toast("Not available for CIV versions of ATAK");
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(MapView.getMapView().getContext());
        builder.setCancelable(true);
        builder.setView((DJITriggersSettingsLayout) LayoutInflater.from(getContext()).inflate(C1877R.layout.video_ui_dji_triggers_settings, (ViewGroup) null));
        builder.show();
    }

    /* access modifiers changed from: private */
    public void actuateLeftTrigger() {
        if (checkOnboardSdkCIV()) {
            toast("Not available for CIV versions of ATAK");
        } else if (OnboardSdkHelper.getInstance().getTriggersEnabled()) {
            OnboardSdkHelper.getInstance().actuateLeftTrigger();
        } else {
            UASToolDropDownReceiver.toast("Triggers are not enabled", 1);
        }
    }

    /* access modifiers changed from: private */
    public void actuateRightTrigger() {
        if (checkOnboardSdkCIV()) {
            toast("Not available for CIV versions of ATAK");
        } else if (OnboardSdkHelper.getInstance().getTriggersEnabled()) {
            OnboardSdkHelper.getInstance().actuateRightTrigger();
        } else {
            UASToolDropDownReceiver.toast("Triggers are not enabled", 1);
        }
    }

    public static boolean hasTriggers() {
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null) {
            return serviceConnection.getOnboardSdkAvailable();
        }
        return false;
    }
}

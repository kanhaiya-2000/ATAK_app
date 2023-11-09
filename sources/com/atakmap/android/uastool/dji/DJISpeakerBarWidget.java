package com.atakmap.android.uastool.dji;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.atak.plugins.impl.PluginLayoutInflater;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.dji.sound.OnUASSpeakerListener;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.PopupWidget;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.VideoUIButton;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.VideoUIView;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.prefs.DJIPreferenceFragment;
import java.io.File;
import java.util.concurrent.atomic.AtomicReference;

public class DJISpeakerBarWidget extends PopupWidget implements SharedPreferences.OnSharedPreferenceChangeListener, OnUASSpeakerListener {
    public static final String TAG = DJISpeakerBarWidget.class.getSimpleName();
    private static String[] playModes;
    private static final AtomicReference<String> uasFileState = new AtomicReference<>((Object) null);
    /* access modifiers changed from: private */
    public VideoUIButton playStopButton;
    /* access modifiers changed from: private */
    public VideoUIButton quickRecordButton;
    /* access modifiers changed from: private */
    public DJISpeakerQuickRecordWidget quickRecordWidget;
    /* access modifiers changed from: private */
    public VideoUIButton settingsButton;
    private AlertDialog settingsDialog;
    private String uasSoundName;

    public void onUASFileDeleted(boolean z, String str, String str2) {
    }

    public void onUASFileRefreshComplete(boolean z, String str) {
    }

    public void onUASFileStateChange(String str) {
    }

    public void onUASFileUploadComplete(boolean z, String str) {
    }

    public DJISpeakerBarWidget(Context context) {
        super(context);
    }

    public DJISpeakerBarWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DJISpeakerBarWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode()) {
            Context pluginContext = UASToolDropDownReceiver.getInstance().getPluginContext();
            UASToolDropDownReceiver.getSharedPrefs().registerOnSharedPreferenceChangeListener(this);
            playModes = pluginContext.getResources().getStringArray(C1877R.array.dji_speaker_repeat_modes);
            VideoUIButton videoUIButton = (VideoUIButton) findViewById(C1877R.C1878id.dji_speaker_playstop_button);
            this.playStopButton = videoUIButton;
            videoUIButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DJISpeakerBarWidget.this.togglePlay();
                }
            });
            VideoUIButton videoUIButton2 = (VideoUIButton) findViewById(C1877R.C1878id.dji_speaker_quickrecord_button);
            this.quickRecordButton = videoUIButton2;
            videoUIButton2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DJISpeakerBarWidget.this.toggleQuickRecord();
                }
            });
            VideoUIButton videoUIButton3 = (VideoUIButton) findViewById(C1877R.C1878id.dji_speaker_settings_button);
            this.settingsButton = videoUIButton3;
            videoUIButton3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DJISpeakerBarWidget.this.showSettings();
                }
            });
            if (isUASPlaying()) {
                this.quickRecordButton.setEnabled(false);
            } else {
                this.quickRecordButton.setEnabled(true);
            }
            DJIMonitor.addUASFileListener(this);
        }
    }

    public void setVisibility(int i) {
        if (i != 0) {
            AlertDialog alertDialog = this.settingsDialog;
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
            if (this.quickRecordWidget != null) {
                hideQuickRecord();
            }
        }
        super.setVisibility(i);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        AlertDialog alertDialog = this.settingsDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        DJISpeakerQuickRecordWidget dJISpeakerQuickRecordWidget = this.quickRecordWidget;
        if (dJISpeakerQuickRecordWidget != null && dJISpeakerQuickRecordWidget.isPoppedUp()) {
            this.quickRecordWidget.hidePopup();
        }
        UASToolDropDownReceiver.getSharedPrefs().unregisterOnSharedPreferenceChangeListener(this);
        DJIMonitor.removeUASFileListener(this);
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        super.onSharedPreferenceChanged(sharedPreferences, str);
        str.hashCode();
        if (str.equals(DJIPreferenceFragment.DJIPREF_SPEAKER_SOUNDNAME)) {
            this.uasSoundName = sharedPreferences.getString(DJIPreferenceFragment.DJIPREF_SPEAKER_SOUNDNAME, "");
        }
    }

    public void init(VideoUIView videoUIView, UASItem uASItem) {
        super.init(videoUIView, uASItem);
        updateButtons();
    }

    public void onAccessoryChange() {
        updateButtons();
        if (!hasSpeaker()) {
            setVisibility(8);
            hideQuickRecord();
            hidePopup();
        }
    }

    private void updateButtons() {
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                if (DJISpeakerBarWidget.hasSpeaker()) {
                    DJISpeakerBarWidget.this.playStopButton.setEnabled(true);
                    DJISpeakerBarWidget.this.quickRecordButton.setEnabled(true);
                    DJISpeakerBarWidget.this.settingsButton.setEnabled(true);
                    return;
                }
                DJISpeakerBarWidget.this.playStopButton.setEnabled(false);
                DJISpeakerBarWidget.this.quickRecordButton.setEnabled(false);
                DJISpeakerBarWidget.this.settingsButton.setEnabled(false);
            }
        });
    }

    /* access modifiers changed from: private */
    public void togglePlay() {
        if (isUASPlaying()) {
            stop();
        } else {
            play();
        }
    }

    private void play() {
        if (!TextUtils.isEmpty(this.uasSoundName)) {
            AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
            if (serviceConnection != null) {
                if (this.settingsDialog == null) {
                    toast("Playing sound on UAS: " + this.uasSoundName);
                }
                serviceConnection.playSound(this.uasSoundName);
                return;
            }
            toast("ERROR: unable to get connection to UAS");
            return;
        }
        toast("No sound selected. Open settings to select a sound to play");
    }

    private void stop() {
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null) {
            toast("Stopped sound on UAS");
            serviceConnection.stopSound();
            return;
        }
        toast("ERROR: unable to get connection to UAS");
    }

    /* access modifiers changed from: private */
    public void toggleQuickRecord() {
        if (isInEditMode()) {
            return;
        }
        if (this.quickRecordWidget == null) {
            showQuickRecord();
        } else {
            hideQuickRecord();
        }
    }

    private void showQuickRecord() {
        DJISpeakerQuickRecordWidget dJISpeakerQuickRecordWidget = (DJISpeakerQuickRecordWidget) PluginLayoutInflater.inflate(UASToolDropDownReceiver.getInstance().getPluginContext(), C1877R.layout.video_ui_dji_speaker_quickrecord, (ViewGroup) null);
        this.quickRecordWidget = dJISpeakerQuickRecordWidget;
        dJISpeakerQuickRecordWidget.setVisibility(8);
        this.videoUIView.addView(this.quickRecordWidget);
        this.quickRecordWidget.init(this.videoUIView, this.uasItem);
        if (isFullScreen()) {
            this.quickRecordWidget.setX(0.0f);
            float savedPositionX = this.quickRecordWidget.getSavedPositionX();
            if (savedPositionX <= 0.0f) {
                savedPositionX = getTranslationX() + ((float) getWidth()) + 50.0f;
            }
            this.quickRecordWidget.setTranslationX(savedPositionX);
            this.quickRecordWidget.setY(0.0f);
            float savedPositionY = this.quickRecordWidget.getSavedPositionY();
            if (savedPositionY <= 0.0f) {
                savedPositionY = getTranslationY() + 50.0f;
            }
            this.quickRecordWidget.setTranslationY(savedPositionY);
            this.quickRecordWidget.setSavedPosition(true);
            this.quickRecordWidget.setVisibility(0);
            return;
        }
        this.quickRecordWidget.showPopupAt((int) (getTranslationX() + ((float) getWidth()) + 50.0f), 0);
    }

    private void hideQuickRecord() {
        if (!isInEditMode()) {
            ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        if (DJISpeakerBarWidget.this.quickRecordWidget != null) {
                            if (DJISpeakerBarWidget.this.isFullScreen()) {
                                DJISpeakerBarWidget.this.quickRecordWidget.setVisibility(8);
                            } else {
                                DJISpeakerBarWidget.this.quickRecordWidget.hidePopup();
                            }
                            DJISpeakerBarWidget.this.videoUIView.removeView(DJISpeakerBarWidget.this.quickRecordWidget);
                            DJISpeakerQuickRecordWidget unused = DJISpeakerBarWidget.this.quickRecordWidget = null;
                        }
                    } catch (Exception e) {
                        DJISpeakerBarWidget dJISpeakerBarWidget = DJISpeakerBarWidget.this;
                        dJISpeakerBarWidget.toast("Exception hiding quick record: " + e.getLocalizedMessage());
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void showSettings() {
        if (!isInEditMode()) {
            hideQuickRecord();
            DJISpeakerSettingsLayout dJISpeakerSettingsLayout = (DJISpeakerSettingsLayout) LayoutInflater.from(getContext()).inflate(C1877R.layout.video_ui_dji_speaker_settings, (ViewGroup) null);
            dJISpeakerSettingsLayout.init(this.videoUIView);
            AlertDialog.Builder builder = new AlertDialog.Builder(MapView.getMapView().getContext());
            builder.setCancelable(true);
            builder.setView(dJISpeakerSettingsLayout);
            AlertDialog create = builder.create();
            this.settingsDialog = create;
            create.show();
        }
    }

    public static String uploadSound(String str) {
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection == null) {
            return "ERROR: unable to get connection to UAS";
        }
        serviceConnection.loadSound(str);
        return null;
    }

    public static boolean isUASPlaying() {
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null) {
            return serviceConnection.isSoundPlaying();
        }
        return false;
    }

    public static String playUASSound(String str) {
        if (TextUtils.isEmpty(str)) {
            return "No sound selected to play";
        }
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection == null) {
            return "ERROR: unable to get connection to UAS";
        }
        serviceConnection.playSound(str);
        return null;
    }

    public static String refreshUASFiles() {
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection == null) {
            return "ERROR: unable to get connection to UAS";
        }
        serviceConnection.refreshSoundList();
        return null;
    }

    public static String stopUASSound() {
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection == null) {
            return "ERROR: unable to get connection to UAS";
        }
        serviceConnection.stopSound();
        return null;
    }

    public static String deleteUASSound(String str) {
        if (TextUtils.isEmpty(str)) {
            return "No sound selected to delete";
        }
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection == null) {
            return "ERROR: unable to get connection to UAS";
        }
        serviceConnection.deleteSound(str);
        return null;
    }

    public static String[] getPlayModes() {
        return playModes;
    }

    public static String getPlayMode() {
        String str = playModes[0];
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection == null) {
            return str;
        }
        String playMode = serviceConnection.getPlayMode();
        return playMode == null ? playModes[0] : playMode;
    }

    public static String setPlayMode(String str) {
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection == null) {
            return "ERROR: unable to get connection to UAS";
        }
        serviceConnection.setPlayMode(str);
        return null;
    }

    public void onUASSoundPlaying(boolean z, String str, String str2) {
        this.playStopButton.setOn(true);
    }

    public void onUASSoundStopped(boolean z, String str) {
        this.playStopButton.setOn(false);
    }

    public static File createSoundFileDir() {
        File file = new File(DJIMonitor.SOUND_DIR_PATH);
        if (file.exists()) {
            return file;
        }
        try {
            if (file.mkdir()) {
                return file;
            }
            UASToolDropDownReceiver.toast("Unable to create DJI sound file directory: " + DJIMonitor.SOUND_DIR_PATH);
            return null;
        } catch (Exception e) {
            UASToolDropDownReceiver.toast("Unable to create DJI sound file directory: " + e.getLocalizedMessage());
            return null;
        }
    }

    public static File createQuickSoundFileDir() {
        File file = new File(DJIMonitor.QUICKSOUND_DIR_PATH);
        if (file.exists()) {
            return file;
        }
        try {
            if (file.mkdir()) {
                return file;
            }
            UASToolDropDownReceiver.toast("Unable to create DJI sound file directory: " + DJIMonitor.SOUND_DIR_PATH);
            return null;
        } catch (Exception e) {
            UASToolDropDownReceiver.toast("Unable to create DJI sound file directory: " + e.getLocalizedMessage());
            return null;
        }
    }

    public static boolean hasSpeaker() {
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null) {
            return serviceConnection.hasSpeaker();
        }
        return false;
    }
}

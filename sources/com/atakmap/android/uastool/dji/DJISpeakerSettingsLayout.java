package com.atakmap.android.uastool.dji;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.atak.plugins.impl.PluginLayoutInflater;
import com.atakmap.android.gui.PluginSpinner;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.dji.sound.MediaRecorderHandler;
import com.atakmap.android.uastool.dji.sound.MediaRecorderOptions;
import com.atakmap.android.uastool.dji.sound.OnUASSpeakerListener;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.VideoUIButton;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.VideoUIView;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.VideoWidget;
import com.atakmap.android.uastool.plugin.C1877R;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class DJISpeakerSettingsLayout extends RelativeLayout implements OnUASSpeakerListener {
    public static final String TAG = "DJISpeakerSettingsLayout";
    /* access modifiers changed from: private */
    public ArrayAdapter<String> eudAdapter;
    private VideoUIButton eudDeleteButton;
    private VideoUIButton eudLoadButton;
    private VideoUIButton eudPlayButton;
    /* access modifiers changed from: private */
    public VideoUIButton eudRecordButton;
    /* access modifiers changed from: private */
    public PluginSpinner eudSpinner;
    /* access modifiers changed from: private */
    public File lastLoadedFile;
    /* access modifiers changed from: private */
    public File lastRecordedFile;
    private MediaPlayer mediaPlayer;
    private MediaRecorderHandler mediaRecorderHandler;
    private Context pluginContext;
    private SharedPreferences prefs;
    /* access modifiers changed from: private */
    public ProgressBar statusProgress;
    /* access modifiers changed from: private */
    public TextView statusText;
    /* access modifiers changed from: private */
    public ArrayAdapter<String> uasAdapter;
    private VideoUIButton uasDeleteButton;
    private final AtomicReference<String> uasFileState = new AtomicReference<>((Object) null);
    /* access modifiers changed from: private */
    public TextView uasFileStateText;
    private VideoUIButton uasPlayButton;
    private VideoUIButton uasRefreshButton;
    /* access modifiers changed from: private */
    public PluginSpinner uasSpinner;
    private VideoUIView videoUIView;

    public DJISpeakerSettingsLayout(Context context) {
        super(context);
    }

    public DJISpeakerSettingsLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DJISpeakerSettingsLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode()) {
            this.pluginContext = UASToolDropDownReceiver.getInstance().getPluginContext();
            this.prefs = UASToolDropDownReceiver.getSharedPrefs();
            this.eudSpinner = findViewById(C1877R.C1878id.djispeaker_eudfiles_value);
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), C1877R.layout.spinner_text_white_view);
            this.eudAdapter = arrayAdapter;
            arrayAdapter.setDropDownViewResource(17367049);
            this.eudSpinner.setAdapter(this.eudAdapter);
            this.eudSpinner.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    DJISpeakerSettingsLayout.this.showHelp("EUD Sound Files List", "A list of sound files stored on the EUD in the location /sdcard/atak/tools/uastool/speaker");
                    return true;
                }
            });
            VideoUIButton videoUIButton = (VideoUIButton) findViewById(C1877R.C1878id.djispeaker_eudfiles_play);
            this.eudPlayButton = videoUIButton;
            videoUIButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DJISpeakerSettingsLayout.this.toggleEUDPlay();
                }
            });
            this.eudPlayButton.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    DJISpeakerSettingsLayout.this.showHelp("EUD Play Sound", "Play the selected EUD sound file on the device");
                    return true;
                }
            });
            VideoUIButton videoUIButton2 = (VideoUIButton) findViewById(C1877R.C1878id.djispeaker_eudfiles_record);
            this.eudRecordButton = videoUIButton2;
            videoUIButton2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DJISpeakerSettingsLayout.this.toggleEUDRecord();
                }
            });
            this.eudRecordButton.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    DJISpeakerSettingsLayout.this.showHelp("EUD Record New Sound", "Record a new sound file on the EUD");
                    return true;
                }
            });
            VideoUIButton videoUIButton3 = (VideoUIButton) findViewById(C1877R.C1878id.djispeaker_eudfiles_load);
            this.eudLoadButton = videoUIButton3;
            videoUIButton3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DJISpeakerSettingsLayout.this.uploadEUDFile();
                }
            });
            this.eudLoadButton.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    DJISpeakerSettingsLayout.this.showHelp("EUD Load Sound", "Load an EUD sound file to the UAS for playing on the UAS");
                    return true;
                }
            });
            VideoUIButton videoUIButton4 = (VideoUIButton) findViewById(C1877R.C1878id.djispeaker_eudfiles_delete);
            this.eudDeleteButton = videoUIButton4;
            videoUIButton4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DJISpeakerSettingsLayout.this.askDeleteEUDFile();
                }
            });
            this.eudDeleteButton.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    DJISpeakerSettingsLayout.this.showHelp("EUD Delete Sound", "Delete a saved sound file from the EUD");
                    return true;
                }
            });
            this.uasSpinner = findViewById(C1877R.C1878id.djispeaker_uasfiles_value);
            ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<>(getContext(), C1877R.layout.spinner_text_white_view);
            this.uasAdapter = arrayAdapter2;
            arrayAdapter2.setDropDownViewResource(17367049);
            this.uasSpinner.setAdapter(this.uasAdapter);
            this.uasSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                    DJISpeakerSettingsLayout.this.saveCurrentUASSound();
                }

                public void onNothingSelected(AdapterView<?> adapterView) {
                    DJISpeakerSettingsLayout.this.saveCurrentUASSound();
                }
            });
            this.uasSpinner.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    DJISpeakerSettingsLayout.this.showHelp("UAS Sound Files List", "A list of sound files stored on the UAS");
                    return true;
                }
            });
            this.uasSpinner.setEnabled(false);
            VideoUIButton videoUIButton5 = (VideoUIButton) findViewById(C1877R.C1878id.djispeaker_uasfiles_play);
            this.uasPlayButton = videoUIButton5;
            videoUIButton5.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DJISpeakerSettingsLayout.this.toggleUASPlay();
                }
            });
            this.uasPlayButton.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    DJISpeakerSettingsLayout.this.showHelp("UAS Play Sound", "Play the selected UAS sound file on the UAS");
                    return true;
                }
            });
            VideoUIButton videoUIButton6 = (VideoUIButton) findViewById(C1877R.C1878id.djispeaker_uasfiles_refresh);
            this.uasRefreshButton = videoUIButton6;
            videoUIButton6.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DJISpeakerSettingsLayout.this.refreshUASFiles();
                }
            });
            this.uasRefreshButton.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    DJISpeakerSettingsLayout.this.showHelp("UAS Refresh Sound Files List", "Refreshes the UAS sound system state");
                    return true;
                }
            });
            this.uasFileStateText = (TextView) findViewById(C1877R.C1878id.djispeaker_uasfiles_state);
            VideoUIButton videoUIButton7 = (VideoUIButton) findViewById(C1877R.C1878id.djispeaker_uasfiles_delete);
            this.uasDeleteButton = videoUIButton7;
            videoUIButton7.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DJISpeakerSettingsLayout.this.askDeleteUASFile();
                }
            });
            this.uasDeleteButton.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    DJISpeakerSettingsLayout.this.showHelp("UAS Delete Sound", "Delete a sound file from the UAS");
                    return true;
                }
            });
            ProgressBar progressBar = (ProgressBar) findViewById(C1877R.C1878id.djispeaker_refresh_progress);
            this.statusProgress = progressBar;
            progressBar.setVisibility(8);
            TextView textView = (TextView) findViewById(C1877R.C1878id.djispeaker_status);
            this.statusText = textView;
            textView.setText("");
            final String[] playModes = DJISpeakerBarWidget.getPlayModes();
            String playMode = DJISpeakerBarWidget.getPlayMode();
            PluginSpinner findViewById = findViewById(C1877R.C1878id.djispeaker_playmode_value);
            ArrayAdapter arrayAdapter3 = new ArrayAdapter(this.pluginContext, C1877R.layout.spinner_text_white_view, playModes);
            arrayAdapter3.setDropDownViewResource(17367049);
            findViewById.setAdapter(arrayAdapter3);
            findViewById.setSelection(Arrays.asList(playModes).indexOf(playMode), true);
            findViewById.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                public void onNothingSelected(AdapterView<?> adapterView) {
                }

                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                    DJISpeakerBarWidget.setPlayMode(playModes[i]);
                }
            });
            final SeekBar seekBar = (SeekBar) findViewById(C1877R.C1878id.djispeaker_volume_seek);
            seekBar.setMax(100);
            seekBar.setProgress(getVolume());
            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                    if (z) {
                        DJISpeakerSettingsLayout.this.setVolume(i, false);
                    }
                }

                public void onStopTrackingTouch(SeekBar seekBar) {
                    DJISpeakerSettingsLayout.this.setVolume(seekBar.getProgress(), true);
                }
            });
            if (DJISpeakerBarWidget.isUASPlaying()) {
                this.uasPlayButton.setSelected(true);
            } else {
                this.uasPlayButton.setSelected(false);
            }
            refreshEUDFiles();
            onUASFileStateChange(DJIMonitor.getUASFileState());
            DJIMonitor.addUASFileListener(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopMedia();
        DJIMonitor.removeUASFileListener(this);
    }

    /* access modifiers changed from: protected */
    public void init(VideoUIView videoUIView2) {
        this.videoUIView = videoUIView2;
    }

    /* access modifiers changed from: private */
    public void toast(String str) {
        if (!isInEditMode()) {
            UASToolDropDownReceiver.toast(str);
        }
    }

    private void setUASStateText(int i, Integer num) {
        setUASStateText(this.pluginContext.getResources().getString(i, new Object[]{num}), num);
    }

    private void setUASStateText(final String str, final Integer num) {
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                if (!TextUtils.isEmpty(str)) {
                    DJISpeakerSettingsLayout.this.uasFileStateText.setText(str);
                } else {
                    DJISpeakerSettingsLayout.this.uasFileStateText.setText("");
                }
                if (num != null) {
                    DJISpeakerSettingsLayout.this.uasFileStateText.setTextColor(num.intValue());
                } else {
                    DJISpeakerSettingsLayout.this.uasFileStateText.setTextColor(VideoWidget.WHITE);
                }
                DJISpeakerSettingsLayout.this.invalidate();
            }
        });
    }

    /* access modifiers changed from: private */
    public void setStatusText(final String str) {
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                if (!TextUtils.isEmpty(str)) {
                    DJISpeakerSettingsLayout.this.statusText.setText(str);
                } else {
                    DJISpeakerSettingsLayout.this.statusText.setText("");
                }
                DJISpeakerSettingsLayout.this.invalidate();
            }
        });
    }

    private void showProgress(final boolean z) {
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                if (z) {
                    ((RelativeLayout.LayoutParams) DJISpeakerSettingsLayout.this.statusText.getLayoutParams()).removeRule(20);
                    DJISpeakerSettingsLayout.this.statusProgress.setVisibility(0);
                    ((RelativeLayout.LayoutParams) DJISpeakerSettingsLayout.this.statusText.getLayoutParams()).addRule(19, DJISpeakerSettingsLayout.this.statusProgress.getId());
                    return;
                }
                DJISpeakerSettingsLayout.this.statusProgress.setVisibility(8);
                ((RelativeLayout.LayoutParams) DJISpeakerSettingsLayout.this.statusText.getLayoutParams()).addRule(20);
            }
        });
    }

    public void onUASFileStateChange(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.uasFileState.set(str);
            String str2 = this.uasFileState.get();
            char c = 65535;
            switch (str2.hashCode()) {
                case -1024508089:
                    if (str2.equals("SYNCING")) {
                        c = 5;
                        break;
                    }
                    break;
                case -524929698:
                    if (str2.equals("INCOMPLETE")) {
                        c = 1;
                        break;
                    }
                    break;
                case -435564210:
                    if (str2.equals("UP_TO_DATE")) {
                        c = 0;
                        break;
                    }
                    break;
                case 77866287:
                    if (str2.equals("RESET")) {
                        c = 2;
                        break;
                    }
                    break;
                case 285240443:
                    if (str2.equals("RENAMING")) {
                        c = 4;
                        break;
                    }
                    break;
                case 433141802:
                    if (str2.equals("UNKNOWN")) {
                        c = 6;
                        break;
                    }
                    break;
                case 1602343848:
                    if (str2.equals("DELETING")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                setUASStateText((int) C1877R.string.dji_speaker_settings_up_to_date, Integer.valueOf(VideoWidget.WHITE));
                rebuildUASFileList();
            } else if (c == 1) {
                setUASStateText((int) C1877R.string.dji_speaker_settings_incomplete, Integer.valueOf(VideoWidget.YELLOW));
                refreshUASFiles();
            } else if (c == 2) {
                setUASStateText((int) C1877R.string.dji_speaker_settings_reset, Integer.valueOf(VideoWidget.RED));
                refreshUASFiles();
            } else if (c == 3 || c == 4 || c == 5) {
                setUASStateText((int) C1877R.string.dji_speaker_settings_syncing, Integer.valueOf(VideoWidget.YELLOW));
            } else {
                setUASStateText((int) C1877R.string.dji_speaker_settings_unknown, Integer.valueOf(VideoWidget.RED));
            }
        } else {
            toast("Null speaker file list state received");
        }
    }

    private void refreshEUDFiles() {
        if (!isInEditMode()) {
            ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
                public void run() {
                    DJISpeakerSettingsLayout.this.eudAdapter.clear();
                    File createSoundFileDir = DJISpeakerBarWidget.createSoundFileDir();
                    int i = 0;
                    if (createSoundFileDir != null) {
                        for (File file : createSoundFileDir.listFiles()) {
                            if (!file.isDirectory() && !file.getName().startsWith(DJISpeakerQuickRecordWidget.SOUNDFILE_PREFIX)) {
                                DJISpeakerSettingsLayout.this.eudAdapter.add(file.getName());
                            }
                        }
                    } else {
                        DJISpeakerSettingsLayout.this.toast("DJI speaker settings failed to create sound directory");
                    }
                    if (DJISpeakerSettingsLayout.this.lastRecordedFile != null) {
                        while (true) {
                            if (i >= DJISpeakerSettingsLayout.this.eudSpinner.getCount()) {
                                break;
                            } else if (DJISpeakerSettingsLayout.this.eudSpinner.getItemAtPosition(i).equals(DJISpeakerSettingsLayout.this.lastRecordedFile.getName())) {
                                DJISpeakerSettingsLayout.this.eudSpinner.setSelection(i);
                                break;
                            } else {
                                i++;
                            }
                        }
                        File unused = DJISpeakerSettingsLayout.this.lastRecordedFile = null;
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void toggleEUDPlay() {
        MediaPlayer mediaPlayer2 = this.mediaPlayer;
        if (mediaPlayer2 == null || !mediaPlayer2.isPlaying()) {
            playEUDFile(new File(DJIMonitor.SOUND_DIR_PATH, (String) this.eudSpinner.getSelectedItem()));
        } else {
            stopEUDFile();
        }
    }

    private void playEUDFile(File file) {
        if (file == null || !file.exists()) {
            setStatusText("No sound selected to play");
            return;
        }
        MediaRecorderHandler mediaRecorderHandler2 = this.mediaRecorderHandler;
        if (mediaRecorderHandler2 == null || !mediaRecorderHandler2.isRecording()) {
            MediaPlayer mediaPlayer2 = this.mediaPlayer;
            if (mediaPlayer2 == null || !mediaPlayer2.isPlaying()) {
                try {
                    setStatusText("Playing EUD sound " + file.getName() + "...");
                    this.eudPlayButton.setOn(true);
                    MediaPlayer mediaPlayer3 = new MediaPlayer();
                    this.mediaPlayer = mediaPlayer3;
                    mediaPlayer3.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            DJISpeakerSettingsLayout.this.stopEUDFile();
                        }
                    });
                    this.mediaPlayer.setDataSource(file.getAbsolutePath());
                    this.mediaPlayer.prepare();
                    this.mediaPlayer.start();
                } catch (Exception e) {
                    setStatusText("ERROR: unable to play " + e.getLocalizedMessage());
                    this.eudPlayButton.setOn(false);
                    this.mediaPlayer.release();
                    this.mediaPlayer = null;
                }
            } else {
                setStatusText("ERROR: unable to play - already playing");
                this.eudPlayButton.setOn(false);
            }
        } else {
            setStatusText("ERROR: unable to play while recording");
        }
    }

    /* access modifiers changed from: private */
    public void stopEUDFile() {
        MediaPlayer mediaPlayer2 = this.mediaPlayer;
        if (mediaPlayer2 != null || mediaPlayer2.isPlaying()) {
            setStatusText("EUD sound playing completed");
            stopMedia();
            return;
        }
        setStatusText("No sound playing");
    }

    private void stopMedia() {
        MediaPlayer mediaPlayer2 = this.mediaPlayer;
        if (mediaPlayer2 != null) {
            if (mediaPlayer2.isPlaying()) {
                this.mediaPlayer.stop();
            }
            this.mediaPlayer.release();
            this.mediaPlayer = null;
        }
        MediaRecorderHandler mediaRecorderHandler2 = this.mediaRecorderHandler;
        if (mediaRecorderHandler2 != null && mediaRecorderHandler2.isRecording()) {
            this.mediaRecorderHandler.stopAndRelease();
            this.mediaRecorderHandler = null;
        }
        this.eudPlayButton.setOn(false);
        this.eudRecordButton.setDanger(false);
    }

    /* access modifiers changed from: private */
    public void toggleEUDRecord() {
        MediaPlayer mediaPlayer2 = this.mediaPlayer;
        if (mediaPlayer2 == null || !mediaPlayer2.isPlaying()) {
            MediaRecorderHandler mediaRecorderHandler2 = this.mediaRecorderHandler;
            if (mediaRecorderHandler2 == null || !mediaRecorderHandler2.isRecording()) {
                askForNewFilename();
            } else {
                stopEUDRecord();
            }
        } else {
            setStatusText("Unable to record while playing");
        }
    }

    private void askForNewFilename() {
        if (DJISpeakerBarWidget.createSoundFileDir() != null) {
            View inflate = PluginLayoutInflater.inflate(getContext(), C1877R.layout.video_ui_dji_speaker_newfile, (ViewGroup) null);
            final EditText editText = (EditText) inflate.findViewById(C1877R.C1878id.djispeaker_newfile_value);
            AlertDialog.Builder builder = new AlertDialog.Builder(MapView.getMapView().getContext());
            builder.setView(inflate);
            builder.setCancelable(false);
            builder.setPositiveButton("Start Recording", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    DJISpeakerSettingsLayout.this.checkIfNewFileExists(new File(DJIMonitor.SOUND_DIR_PATH, editText.getText().toString()));
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    DJISpeakerSettingsLayout.this.eudRecordButton.setDanger(false);
                }
            });
            builder.create().show();
            return;
        }
        toast("DJI speaker settings failed to create sound directory");
        this.eudRecordButton.setDanger(false);
    }

    /* access modifiers changed from: private */
    public void checkIfNewFileExists(File file) {
        if (file.exists()) {
            askToOverwrite(file);
        } else {
            eudRecord(file);
        }
    }

    private void askToOverwrite(final File file) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MapView.getMapView().getContext());
        builder.setTitle("Overwrite?");
        builder.setMessage("A file with the name " + file.getName() + " already exists on the EUD. Do you want to overwrite it?");
        builder.setCancelable(false);
        builder.setPositiveButton("Overwrite", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                DJISpeakerSettingsLayout.this.eudRecord(file);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                DJISpeakerSettingsLayout.this.eudRecordButton.setDanger(false);
            }
        });
        builder.create().show();
    }

    /* access modifiers changed from: private */
    public void eudRecord(File file) {
        setStatusText("Recording new sound...");
        this.lastRecordedFile = file;
        this.eudRecordButton.setDanger(true);
        MediaRecorderHandler mediaRecorderHandler2 = new MediaRecorderHandler(DJIMonitor.SOUND_DIR_PATH, new MediaRecorderOptions.Builder().build());
        this.mediaRecorderHandler = mediaRecorderHandler2;
        mediaRecorderHandler2.startRecord(file.getName());
    }

    private void stopEUDRecord() {
        setStatusText("New sound recording completed");
        stopMedia();
        refreshEUDFiles();
    }

    /* access modifiers changed from: private */
    public void uploadEUDFile() {
        if (!this.uasFileState.get().equals("UP_TO_DATE")) {
            setStatusText("UAS sound system not ready");
            return;
        }
        File file = new File(DJIMonitor.SOUND_DIR_PATH, (String) this.eudSpinner.getSelectedItem());
        if (!file.exists()) {
            setStatusText("ERROR: file doesn't exist on EUD");
        } else if (doesUASListHaveFile(file.getName())) {
            setStatusText("ERROR: file with name " + file.getName() + " already exists on UAS");
        } else if (file.getName().length() <= 20) {
            this.lastLoadedFile = file;
            setStatusText("Loading sound " + file.getName() + " to UAS...");
            showProgress(true);
            String uploadSound = DJISpeakerBarWidget.uploadSound(file.getAbsolutePath());
            if (!TextUtils.isEmpty(uploadSound)) {
                setStatusText(uploadSound);
            }
        } else {
            setStatusText("ERROR: filename must not be more than 20 characters");
        }
    }

    public void onUASFileUploadComplete(boolean z, String str) {
        showProgress(false);
        if (z) {
            refreshUASFiles();
        } else if (!TextUtils.isEmpty(str)) {
            setStatusText("ERROR: " + str);
        } else {
            setStatusText("ERROR: failed to load sound to UAS");
        }
    }

    /* access modifiers changed from: private */
    public void askDeleteEUDFile() {
        final File file = new File(DJIMonitor.SOUND_DIR_PATH, (String) this.eudSpinner.getSelectedItem());
        if (!file.exists()) {
            setStatusText("No sound selected to delete");
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(MapView.getMapView().getContext());
        String string = getContext().getResources().getString(C1877R.string.dji_speaker_eudfiles_delete1);
        String string2 = getContext().getResources().getString(C1877R.string.dji_speaker_eudfiles_delete2);
        builder.setMessage(string + " " + file.getName() + " " + string2);
        builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                DJISpeakerSettingsLayout.this.deleteEUDFile(file);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        builder.setCancelable(false);
        builder.create().show();
    }

    /* access modifiers changed from: private */
    public void deleteEUDFile(File file) {
        if (file.delete()) {
            setStatusText("EUD sound deleted: " + file.getName());
            refreshEUDFiles();
            return;
        }
        setStatusText("ERROR: failed to delete EUD sound: " + file.getName());
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r4.prefs.edit().putString(com.atakmap.android.uastool.prefs.DJIPreferenceFragment.DJIPREF_SPEAKER_SOUNDNAME, "").apply();
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0044 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void saveCurrentUASSound() {
        /*
            r4 = this;
            monitor-enter(r4)
            com.atakmap.android.gui.PluginSpinner r0 = r4.uasSpinner     // Catch:{ Exception -> 0x0044 }
            java.lang.Object r0 = r0.getSelectedItem()     // Catch:{ Exception -> 0x0044 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x0044 }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0044 }
            if (r1 != 0) goto L_0x001f
            android.content.SharedPreferences r1 = r4.prefs     // Catch:{ Exception -> 0x0044 }
            android.content.SharedPreferences$Editor r1 = r1.edit()     // Catch:{ Exception -> 0x0044 }
            java.lang.String r2 = "uastool.dji.pref_speaker_soundname"
            android.content.SharedPreferences$Editor r1 = r1.putString(r2, r0)     // Catch:{ Exception -> 0x0044 }
            r1.apply()     // Catch:{ Exception -> 0x0044 }
            goto L_0x0032
        L_0x001f:
            java.lang.String r0 = ""
            android.content.SharedPreferences r1 = r4.prefs     // Catch:{ Exception -> 0x0044 }
            android.content.SharedPreferences$Editor r1 = r1.edit()     // Catch:{ Exception -> 0x0044 }
            java.lang.String r2 = "uastool.dji.pref_speaker_soundname"
            java.lang.String r3 = ""
            android.content.SharedPreferences$Editor r1 = r1.putString(r2, r3)     // Catch:{ Exception -> 0x0044 }
            r1.apply()     // Catch:{ Exception -> 0x0044 }
        L_0x0032:
            com.atakmap.android.uastool.dji.AtakGoServiceConnection r1 = com.atakmap.android.uastool.dji.DJIMonitor.getServiceConnection()     // Catch:{ Exception -> 0x0044 }
            if (r1 == 0) goto L_0x003c
            r1.setCurrentSound(r0)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0055
        L_0x003c:
            java.lang.String r0 = "ERROR: unable to get connection to UAS"
            r4.toast(r0)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0055
        L_0x0042:
            r0 = move-exception
            goto L_0x0057
        L_0x0044:
            android.content.SharedPreferences r0 = r4.prefs     // Catch:{ all -> 0x0042 }
            android.content.SharedPreferences$Editor r0 = r0.edit()     // Catch:{ all -> 0x0042 }
            java.lang.String r1 = "uastool.dji.pref_speaker_soundname"
            java.lang.String r2 = ""
            android.content.SharedPreferences$Editor r0 = r0.putString(r1, r2)     // Catch:{ all -> 0x0042 }
            r0.apply()     // Catch:{ all -> 0x0042 }
        L_0x0055:
            monitor-exit(r4)
            return
        L_0x0057:
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.dji.DJISpeakerSettingsLayout.saveCurrentUASSound():void");
    }

    /* access modifiers changed from: private */
    public void toggleUASPlay() {
        if (DJISpeakerBarWidget.isUASPlaying()) {
            stopUASSound();
        } else {
            playUASSound((String) this.uasSpinner.getSelectedItem());
        }
    }

    private void playUASSound(String str) {
        if (TextUtils.isEmpty(str)) {
            setStatusText("No sound selected to play");
        } else if (!this.uasFileState.get().equals("UP_TO_DATE")) {
            setStatusText("UAS sound system not ready");
        } else {
            String playUASSound = DJISpeakerBarWidget.playUASSound(str);
            if (!TextUtils.isEmpty(playUASSound)) {
                setStatusText(playUASSound);
            }
        }
    }

    public void onUASSoundPlaying(boolean z, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            if (z) {
                setStatusText(str2);
            } else {
                setStatusText("ERROR: " + str2);
            }
        }
        if (z) {
            this.uasPlayButton.setOn(true);
        } else {
            this.uasPlayButton.setOn(false);
        }
    }

    /* access modifiers changed from: private */
    public void refreshUASFiles() {
        if (!isInEditMode()) {
            String str = this.uasFileState.get();
            if (!str.equals("UP_TO_DATE") && !str.equals("DELETING") && !str.equals("RENAMING") && !str.equals("SYNCING")) {
                showProgress(true);
                setStatusText("Refreshing UAS file list...");
                String refreshUASFiles = DJISpeakerBarWidget.refreshUASFiles();
                if (!TextUtils.isEmpty(refreshUASFiles)) {
                    setStatusText(refreshUASFiles);
                }
            }
        }
    }

    public void onUASFileRefreshComplete(boolean z, String str) {
        if (TextUtils.isEmpty(str)) {
            setStatusText("");
        } else if (z) {
            setStatusText(str);
        } else {
            setStatusText("ERROR: " + str);
        }
        showProgress(false);
    }

    private boolean doesUASListHaveFile(String str) {
        for (int i = 0; i < this.uasSpinner.getCount(); i++) {
            if (this.uasSpinner.getItemAtPosition(i).equals(str)) {
                return true;
            }
        }
        return false;
    }

    private void rebuildUASFileList() {
        if (!isInEditMode()) {
            ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
                public void run() {
                    DJISpeakerSettingsLayout.this.uasAdapter.clear();
                    AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
                    if (serviceConnection != null) {
                        List<String> loadedSoundNames = serviceConnection.getLoadedSoundNames();
                        int i = 0;
                        if (loadedSoundNames == null) {
                            DJISpeakerSettingsLayout.this.uasSpinner.setEnabled(false);
                        } else if (loadedSoundNames.size() > 0) {
                            int i2 = 0;
                            for (String next : loadedSoundNames) {
                                if (!next.startsWith(DJISpeakerQuickRecordWidget.SOUNDFILE_PREFIX)) {
                                    DJISpeakerSettingsLayout.this.uasAdapter.add(next);
                                    i2++;
                                }
                            }
                            if (i2 > 0) {
                                if (DJISpeakerSettingsLayout.this.lastLoadedFile != null) {
                                    while (true) {
                                        if (i >= DJISpeakerSettingsLayout.this.uasSpinner.getCount()) {
                                            break;
                                        } else if (DJISpeakerSettingsLayout.this.uasSpinner.getItemAtPosition(i).equals(DJISpeakerSettingsLayout.this.lastLoadedFile.getName())) {
                                            DJISpeakerSettingsLayout.this.uasSpinner.setSelection(i);
                                            File unused = DJISpeakerSettingsLayout.this.lastLoadedFile = null;
                                            break;
                                        } else {
                                            i++;
                                        }
                                    }
                                }
                                DJISpeakerSettingsLayout.this.saveCurrentUASSound();
                                DJISpeakerSettingsLayout.this.uasSpinner.setEnabled(true);
                                return;
                            }
                            DJISpeakerSettingsLayout.this.uasSpinner.setEnabled(false);
                        } else {
                            DJISpeakerSettingsLayout.this.uasSpinner.setEnabled(false);
                        }
                    } else {
                        DJISpeakerSettingsLayout.this.setStatusText("ERROR: unable to get connection to UAS");
                    }
                }
            });
        }
    }

    private void stopUASSound() {
        String stopUASSound = DJISpeakerBarWidget.stopUASSound();
        if (!TextUtils.isEmpty(stopUASSound)) {
            setStatusText(stopUASSound);
        }
    }

    public void onUASSoundStopped(boolean z, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                setStatusText(str);
            } else {
                setStatusText("ERROR: " + str);
            }
        }
        this.uasPlayButton.setOn(false);
    }

    /* access modifiers changed from: private */
    public void askDeleteUASFile() {
        final String str = (String) this.uasSpinner.getSelectedItem();
        if (TextUtils.isEmpty(str)) {
            setStatusText("No sound selected to delete");
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(MapView.getMapView().getContext());
        String string = getContext().getResources().getString(C1877R.string.dji_speaker_uasfiles_delete1);
        String string2 = getContext().getResources().getString(C1877R.string.dji_speaker_uasfiles_delete2);
        builder.setMessage(string + " " + str + " " + string2);
        builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                DJISpeakerSettingsLayout.this.deleteUASFile(str);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        builder.setCancelable(false);
        builder.create().show();
    }

    /* access modifiers changed from: private */
    public void deleteUASFile(String str) {
        String deleteUASSound = DJISpeakerBarWidget.deleteUASSound(str);
        if (!TextUtils.isEmpty(deleteUASSound)) {
            setStatusText(deleteUASSound);
        }
    }

    public void onUASFileDeleted(boolean z, String str, String str2) {
        if (z) {
            setStatusText("UAS sound " + str + " deleted");
            refreshUASFiles();
        } else if (!TextUtils.isEmpty(str2)) {
            setStatusText("ERROR: " + str2);
        }
    }

    /* access modifiers changed from: private */
    public void showHelp(String str, String str2) {
        UASToolDropDownReceiver.getInstance().helpPopup(str, str2);
    }

    private int getVolume() {
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null) {
            return serviceConnection.getSpeakerVolume();
        }
        return 0;
    }

    /* access modifiers changed from: private */
    public void setVolume(int i, boolean z) {
        AtakGoServiceConnection serviceConnection;
        if (!isInEditMode() && (serviceConnection = DJIMonitor.getServiceConnection()) != null) {
            serviceConnection.setSpeakerVolume(i, z);
        }
    }
}

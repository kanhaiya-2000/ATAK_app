package com.atakmap.android.uastool.dji;

import android.app.Activity;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.dji.sound.MediaRecorderHandler;
import com.atakmap.android.uastool.dji.sound.MediaRecorderOptions;
import com.atakmap.android.uastool.dji.sound.OnUASSpeakerListener;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.PopupWidget;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.VideoWidget;
import com.atakmap.android.uastool.plugin.C1877R;
import com.autel.camera.protocol.protocol20.constant.CameraConstant20;
import java.io.File;

public class DJISpeakerQuickRecordWidget extends PopupWidget implements OnUASSpeakerListener {
    public static final String SOUNDFILE_PREFIX = "quick_";
    public static final String TAG = "DJISpeakerQuickRecordWidget";
    private MediaRecorderHandler mediaRecorderHandler;
    /* access modifiers changed from: private */
    public QUICKRECORD_MODE mode;
    public Drawable playDrawable;
    private Context pluginContext;
    public Drawable recordDrawable;
    public Drawable resetDrawable;
    private File soundFile;
    public Drawable uploadDrawable;
    /* access modifiers changed from: private */
    public QUICKRECORD_MODE waitMode;
    public Drawable waitingDrawable;
    /* access modifiers changed from: private */
    public ImageButton widgetButton;
    /* access modifiers changed from: private */
    public TextView widgetText;

    public void onUASFileDeleted(boolean z, String str, String str2) {
    }

    public enum QUICKRECORD_MODE {
        WAITING("Waiting"),
        RESET("Reset"),
        RECORD_READY("Record  Ready"),
        RECORDING(CameraConstant20.RECORDING),
        OTHER_PLAYING("Other Playing"),
        UPLOADING("Uploading"),
        PLAY_READY("Play Ready"),
        PLAYING("Playing");
        
        private final String name;

        private QUICKRECORD_MODE(String str) {
            this.name = str;
        }

        public String toString() {
            return this.name;
        }
    }

    public DJISpeakerQuickRecordWidget(Context context) {
        super(context);
    }

    public DJISpeakerQuickRecordWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DJISpeakerQuickRecordWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mode = QUICKRECORD_MODE.RECORD_READY;
        if (!isInEditMode()) {
            Context pluginContext2 = UASToolDropDownReceiver.getInstance().getPluginContext();
            this.pluginContext = pluginContext2;
            this.waitingDrawable = pluginContext2.getDrawable(C1877R.drawable.video_ui_dji_speaker_waiting).mutate();
            this.recordDrawable = this.pluginContext.getDrawable(C1877R.drawable.video_ui_dji_speaker_record).mutate();
            this.uploadDrawable = this.pluginContext.getDrawable(C1877R.drawable.video_ui_dji_speaker_load).mutate();
            this.playDrawable = this.pluginContext.getDrawable(C1877R.drawable.video_ui_dji_speaker_play).mutate();
            this.resetDrawable = this.pluginContext.getDrawable(C1877R.drawable.video_ui_dji_speaker_reset).mutate();
            ImageButton imageButton = (ImageButton) findViewById(C1877R.C1878id.dji_speaker_quickrecord_button);
            this.widgetButton = imageButton;
            imageButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DJISpeakerQuickRecordWidget.this.toggleMode();
                }
            });
            TextView textView = (TextView) findViewById(C1877R.C1878id.dji_speaker_quickrecord_text);
            this.widgetText = textView;
            textView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DJISpeakerQuickRecordWidget.this.toggleMode();
                }
            });
            if (DJISpeakerBarWidget.isUASPlaying()) {
                otherIsPlaying();
            }
            onUASFileStateChange(DJIMonitor.getUASFileState());
            DJIMonitor.addUASFileListener(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopMedia();
        this.soundFile = null;
        deleteQuickSounds(new File(DJIMonitor.QUICKSOUND_DIR_PATH));
        DJIMonitor.removeUASFileListener(this);
    }

    public void hidePopup() {
        super.hidePopup();
        DJIMonitor.removeUASFileListener(this);
    }

    private void setText(int i, Integer num) {
        setText(this.pluginContext.getResources().getString(i, new Object[]{num}), num);
    }

    private void setText(final String str, final Integer num) {
        if (TextUtils.isEmpty(str)) {
            this.widgetText.setText("");
            this.widgetText.setTextColor(VideoWidget.WHITE);
            return;
        }
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                DJISpeakerQuickRecordWidget.this.widgetText.setText(str);
                if (num != null) {
                    DJISpeakerQuickRecordWidget.this.widgetText.setTextColor(num.intValue());
                } else {
                    DJISpeakerQuickRecordWidget.this.widgetText.setTextColor(VideoWidget.WHITE);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void setDrawable(final Drawable drawable, final Integer num) {
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                DJISpeakerQuickRecordWidget.this.widgetButton.setImageDrawable(drawable);
                if (num != null) {
                    DJISpeakerQuickRecordWidget.this.widgetButton.setColorFilter(num.intValue(), PorterDuff.Mode.MULTIPLY);
                } else {
                    DJISpeakerQuickRecordWidget.this.widgetButton.setColorFilter((ColorFilter) null);
                }
            }
        });
    }

    /* renamed from: com.atakmap.android.uastool.dji.DJISpeakerQuickRecordWidget$6 */
    /* synthetic */ class C13636 {

        /* renamed from: $SwitchMap$com$atakmap$android$uastool$dji$DJISpeakerQuickRecordWidget$QUICKRECORD_MODE */
        static final /* synthetic */ int[] f8389xfbf10565;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.atakmap.android.uastool.dji.DJISpeakerQuickRecordWidget$QUICKRECORD_MODE[] r0 = com.atakmap.android.uastool.dji.DJISpeakerQuickRecordWidget.QUICKRECORD_MODE.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8389xfbf10565 = r0
                com.atakmap.android.uastool.dji.DJISpeakerQuickRecordWidget$QUICKRECORD_MODE r1 = com.atakmap.android.uastool.dji.DJISpeakerQuickRecordWidget.QUICKRECORD_MODE.WAITING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8389xfbf10565     // Catch:{ NoSuchFieldError -> 0x001d }
                com.atakmap.android.uastool.dji.DJISpeakerQuickRecordWidget$QUICKRECORD_MODE r1 = com.atakmap.android.uastool.dji.DJISpeakerQuickRecordWidget.QUICKRECORD_MODE.RESET     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f8389xfbf10565     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.atakmap.android.uastool.dji.DJISpeakerQuickRecordWidget$QUICKRECORD_MODE r1 = com.atakmap.android.uastool.dji.DJISpeakerQuickRecordWidget.QUICKRECORD_MODE.RECORD_READY     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f8389xfbf10565     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.atakmap.android.uastool.dji.DJISpeakerQuickRecordWidget$QUICKRECORD_MODE r1 = com.atakmap.android.uastool.dji.DJISpeakerQuickRecordWidget.QUICKRECORD_MODE.RECORDING     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f8389xfbf10565     // Catch:{ NoSuchFieldError -> 0x003e }
                com.atakmap.android.uastool.dji.DJISpeakerQuickRecordWidget$QUICKRECORD_MODE r1 = com.atakmap.android.uastool.dji.DJISpeakerQuickRecordWidget.QUICKRECORD_MODE.OTHER_PLAYING     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f8389xfbf10565     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.atakmap.android.uastool.dji.DJISpeakerQuickRecordWidget$QUICKRECORD_MODE r1 = com.atakmap.android.uastool.dji.DJISpeakerQuickRecordWidget.QUICKRECORD_MODE.UPLOADING     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f8389xfbf10565     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.atakmap.android.uastool.dji.DJISpeakerQuickRecordWidget$QUICKRECORD_MODE r1 = com.atakmap.android.uastool.dji.DJISpeakerQuickRecordWidget.QUICKRECORD_MODE.PLAY_READY     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f8389xfbf10565     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.atakmap.android.uastool.dji.DJISpeakerQuickRecordWidget$QUICKRECORD_MODE r1 = com.atakmap.android.uastool.dji.DJISpeakerQuickRecordWidget.QUICKRECORD_MODE.PLAYING     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.dji.DJISpeakerQuickRecordWidget.C13636.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    public void toggleMode() {
        switch (C13636.f8389xfbf10565[this.mode.ordinal()]) {
            case 1:
            case 2:
            case 6:
                return;
            case 3:
                startRecording();
                return;
            case 4:
                stopRecording();
                return;
            case 5:
                DJISpeakerBarWidget.stopUASSound();
                File file = this.soundFile;
                if (file == null || !file.exists()) {
                    readyToRecord();
                    return;
                } else {
                    readyToPlay();
                    return;
                }
            case 7:
                startPlaying();
                return;
            case 8:
                stopPlaying();
                return;
            default:
                toast("Unexpected quick record mode: " + this.mode.toString());
                startRecording();
                return;
        }
    }

    private void setWaiting() {
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                if (!DJISpeakerQuickRecordWidget.this.mode.equals(QUICKRECORD_MODE.WAITING)) {
                    DJISpeakerQuickRecordWidget dJISpeakerQuickRecordWidget = DJISpeakerQuickRecordWidget.this;
                    QUICKRECORD_MODE unused = dJISpeakerQuickRecordWidget.waitMode = dJISpeakerQuickRecordWidget.mode;
                }
                QUICKRECORD_MODE unused2 = DJISpeakerQuickRecordWidget.this.mode = QUICKRECORD_MODE.WAITING;
                DJISpeakerQuickRecordWidget dJISpeakerQuickRecordWidget2 = DJISpeakerQuickRecordWidget.this;
                dJISpeakerQuickRecordWidget2.setDrawable(dJISpeakerQuickRecordWidget2.waitingDrawable, Integer.valueOf(VideoWidget.YELLOW));
            }
        });
    }

    private void readyToRecord() {
        this.mode = QUICKRECORD_MODE.RECORD_READY;
        setDrawable(this.recordDrawable, (Integer) null);
        setText((int) C1877R.string.dji_speaker_quickrecord_readyrecord, Integer.valueOf(VideoWidget.WHITE));
    }

    private void startRecording() {
        this.mode = QUICKRECORD_MODE.RECORDING;
        setDrawable(this.recordDrawable, Integer.valueOf(VideoWidget.RED));
        setText((int) C1877R.string.dji_speaker_quickrecord_stoprecord, Integer.valueOf(VideoWidget.RED));
        File createQuickSoundFileDir = DJISpeakerBarWidget.createQuickSoundFileDir();
        if (createQuickSoundFileDir != null) {
            this.soundFile = new File(createQuickSoundFileDir, SOUNDFILE_PREFIX + System.currentTimeMillis());
            MediaRecorderHandler mediaRecorderHandler2 = new MediaRecorderHandler(DJIMonitor.QUICKSOUND_DIR_PATH, new MediaRecorderOptions.Builder().build());
            this.mediaRecorderHandler = mediaRecorderHandler2;
            mediaRecorderHandler2.startRecord(this.soundFile.getName());
            return;
        }
        toast("DJI speaker settings failed to create quick sound directory");
        stopRecording();
    }

    private void stopRecording() {
        this.mode = QUICKRECORD_MODE.UPLOADING;
        setDrawable(this.uploadDrawable, (Integer) null);
        setText((int) C1877R.string.dji_speaker_quickrecord_uploading, Integer.valueOf(VideoWidget.WHITE));
        stopMedia();
        File file = this.soundFile;
        if (file == null || !file.exists()) {
            toast("ERROR: recorded file not found");
            readyToRecord();
            return;
        }
        upload();
    }

    private void stopMedia() {
        MediaRecorderHandler mediaRecorderHandler2 = this.mediaRecorderHandler;
        if (mediaRecorderHandler2 != null && mediaRecorderHandler2.isRecording()) {
            this.mediaRecorderHandler.stopAndRelease();
            this.mediaRecorderHandler = null;
        }
    }

    private void upload() {
        String uploadSound = DJISpeakerBarWidget.uploadSound(this.soundFile.getAbsolutePath());
        if (!TextUtils.isEmpty(uploadSound)) {
            toast(uploadSound);
            readyToRecord();
        }
    }

    private void readyToPlay() {
        this.mode = QUICKRECORD_MODE.PLAY_READY;
        setDrawable(this.playDrawable, (Integer) null);
        setText((int) C1877R.string.dji_speaker_quickrecord_readyplay, Integer.valueOf(VideoWidget.WHITE));
    }

    private void otherIsPlaying() {
        this.mode = QUICKRECORD_MODE.OTHER_PLAYING;
        setDrawable(this.playDrawable, Integer.valueOf(VideoWidget.GREEN));
        setText((int) C1877R.string.dji_speaker_quickrecord_stopplay, Integer.valueOf(VideoWidget.GREEN));
    }

    private void startPlaying() {
        File file = this.soundFile;
        if (file != null) {
            String playUASSound = DJISpeakerBarWidget.playUASSound(file.getName());
            if (!TextUtils.isEmpty(playUASSound)) {
                toast(playUASSound);
                readyToRecord();
                return;
            }
            return;
        }
        toast("No sound file loaded");
    }

    private void readyToStop() {
        this.mode = QUICKRECORD_MODE.PLAYING;
        setDrawable(this.playDrawable, Integer.valueOf(VideoWidget.GREEN));
        setText((int) C1877R.string.dji_speaker_quickrecord_stopplay, Integer.valueOf(VideoWidget.GREEN));
    }

    private void stopPlaying() {
        this.mode = QUICKRECORD_MODE.PLAY_READY;
        setDrawable(this.playDrawable, (Integer) null);
        setText((int) C1877R.string.dji_speaker_quickrecord_readyplay, Integer.valueOf(VideoWidget.WHITE));
        String stopUASSound = DJISpeakerBarWidget.stopUASSound();
        if (!TextUtils.isEmpty(stopUASSound)) {
            toast(stopUASSound);
            readyToRecord();
        }
    }

    private void deleteQuickSounds(File file) {
        if (file.exists()) {
            for (File file2 : file.listFiles()) {
                if (file2.isDirectory()) {
                    deleteQuickSounds(file2);
                }
                file2.delete();
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onUASFileStateChange(java.lang.String r7) {
        /*
            r6 = this;
            int r0 = r7.hashCode()
            r1 = 5
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            switch(r0) {
                case -1024508089: goto L_0x0049;
                case -524929698: goto L_0x003f;
                case -435564210: goto L_0x0035;
                case 77866287: goto L_0x002b;
                case 285240443: goto L_0x0021;
                case 433141802: goto L_0x0017;
                case 1602343848: goto L_0x000d;
                default: goto L_0x000c;
            }
        L_0x000c:
            goto L_0x0053
        L_0x000d:
            java.lang.String r0 = "DELETING"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0053
            r7 = 3
            goto L_0x0054
        L_0x0017:
            java.lang.String r0 = "UNKNOWN"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0053
            r7 = 6
            goto L_0x0054
        L_0x0021:
            java.lang.String r0 = "RENAMING"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0053
            r7 = 4
            goto L_0x0054
        L_0x002b:
            java.lang.String r0 = "RESET"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0053
            r7 = 2
            goto L_0x0054
        L_0x0035:
            java.lang.String r0 = "UP_TO_DATE"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0053
            r7 = 0
            goto L_0x0054
        L_0x003f:
            java.lang.String r0 = "INCOMPLETE"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0053
            r7 = 1
            goto L_0x0054
        L_0x0049:
            java.lang.String r0 = "SYNCING"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0053
            r7 = 5
            goto L_0x0054
        L_0x0053:
            r7 = -1
        L_0x0054:
            if (r7 == 0) goto L_0x00b3
            if (r7 == r5) goto L_0x009c
            if (r7 == r4) goto L_0x0081
            if (r7 == r3) goto L_0x0071
            if (r7 == r2) goto L_0x0071
            if (r7 == r1) goto L_0x0071
            r6.setWaiting()
            r7 = 2131361930(0x7f0a008a, float:1.8343626E38)
            int r0 = com.atakmap.android.uastool.pagers.video_ui.default_ui.VideoWidget.YELLOW
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r6.setText((int) r7, (java.lang.Integer) r0)
            goto L_0x00e5
        L_0x0071:
            r6.setWaiting()
            r7 = 2131361929(0x7f0a0089, float:1.8343624E38)
            int r0 = com.atakmap.android.uastool.pagers.video_ui.default_ui.VideoWidget.YELLOW
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r6.setText((int) r7, (java.lang.Integer) r0)
            goto L_0x00e5
        L_0x0081:
            android.graphics.drawable.Drawable r7 = r6.resetDrawable
            int r0 = com.atakmap.android.uastool.pagers.video_ui.default_ui.VideoWidget.RED
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r6.setDrawable(r7, r0)
            r7 = 2131361926(0x7f0a0086, float:1.8343618E38)
            int r0 = com.atakmap.android.uastool.pagers.video_ui.default_ui.VideoWidget.RED
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r6.setText((int) r7, (java.lang.Integer) r0)
            com.atakmap.android.uastool.dji.DJISpeakerBarWidget.refreshUASFiles()
            goto L_0x00e5
        L_0x009c:
            r6.setWaiting()
            java.lang.String r7 = com.atakmap.android.uastool.dji.DJISpeakerBarWidget.refreshUASFiles()
            boolean r0 = android.text.TextUtils.isEmpty(r7)
            if (r0 != 0) goto L_0x00e5
            int r0 = com.atakmap.android.uastool.pagers.video_ui.default_ui.VideoWidget.RED
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r6.setText((java.lang.String) r7, (java.lang.Integer) r0)
            goto L_0x00e5
        L_0x00b3:
            com.atakmap.android.uastool.dji.DJISpeakerQuickRecordWidget$QUICKRECORD_MODE r7 = r6.waitMode
            if (r7 == 0) goto L_0x00bc
            r6.mode = r7
            r7 = 0
            r6.waitMode = r7
        L_0x00bc:
            com.atakmap.android.uastool.dji.DJISpeakerQuickRecordWidget$QUICKRECORD_MODE r7 = r6.mode
            com.atakmap.android.uastool.dji.DJISpeakerQuickRecordWidget$QUICKRECORD_MODE r0 = com.atakmap.android.uastool.dji.DJISpeakerQuickRecordWidget.QUICKRECORD_MODE.RECORD_READY
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x00ca
            r6.readyToRecord()
            goto L_0x00e5
        L_0x00ca:
            com.atakmap.android.uastool.dji.DJISpeakerQuickRecordWidget$QUICKRECORD_MODE r7 = r6.mode
            com.atakmap.android.uastool.dji.DJISpeakerQuickRecordWidget$QUICKRECORD_MODE r0 = com.atakmap.android.uastool.dji.DJISpeakerQuickRecordWidget.QUICKRECORD_MODE.UPLOADING
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x00d8
            r6.readyToPlay()
            goto L_0x00e5
        L_0x00d8:
            com.atakmap.android.uastool.dji.DJISpeakerQuickRecordWidget$QUICKRECORD_MODE r7 = r6.mode
            com.atakmap.android.uastool.dji.DJISpeakerQuickRecordWidget$QUICKRECORD_MODE r0 = com.atakmap.android.uastool.dji.DJISpeakerQuickRecordWidget.QUICKRECORD_MODE.PLAY_READY
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x00e5
            r6.readyToPlay()
        L_0x00e5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.dji.DJISpeakerQuickRecordWidget.onUASFileStateChange(java.lang.String):void");
    }

    public void onUASFileRefreshComplete(boolean z, String str) {
        if (!TextUtils.isEmpty(str)) {
            toast(str);
        }
    }

    public void onUASFileUploadComplete(boolean z, String str) {
        if (!z) {
            if (!TextUtils.isEmpty(str)) {
                toast(str);
            }
            readyToRecord();
        }
    }

    public void onUASSoundPlaying(boolean z, String str, String str2) {
        if (z) {
            toast("Playing sound on UAS");
            readyToStop();
            return;
        }
        if (!TextUtils.isEmpty(str2)) {
            toast(str2);
        }
        readyToRecord();
    }

    public void onUASSoundStopped(boolean z, String str) {
        if (!z && !TextUtils.isEmpty(str)) {
            toast(str);
        }
        File file = this.soundFile;
        if (file == null || !file.exists()) {
            readyToRecord();
        } else {
            readyToPlay();
        }
    }
}

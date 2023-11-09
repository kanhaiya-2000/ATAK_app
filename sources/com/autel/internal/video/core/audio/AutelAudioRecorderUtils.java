package com.autel.internal.video.core.audio;

import android.media.AudioRecord;
import android.os.AsyncTask;
import com.autel.video.AutelPlayer;

public class AutelAudioRecorderUtils {
    private static AutelAudioRecorderUtils s_instance;
    /* access modifiers changed from: private */
    public boolean isRecording = false;
    /* access modifiers changed from: private */
    public short[] mBuffer;
    /* access modifiers changed from: private */
    public AudioRecord mRecorder;
    private final int mSamples = 1152;

    private AutelAudioRecorderUtils() {
    }

    public static AutelAudioRecorderUtils instance_() {
        if (s_instance == null) {
            s_instance = new AutelAudioRecorderUtils();
        }
        return s_instance;
    }

    private void initRecorder() {
        int minBufferSize = AudioRecord.getMinBufferSize(44100, 16, 2);
        this.mBuffer = new short[(minBufferSize * 10)];
        AudioRecord audioRecord = this.mRecorder;
        if (audioRecord != null) {
            audioRecord.release();
            this.mRecorder = null;
        }
        this.mRecorder = new AudioRecord(1, 44100, 16, 2, minBufferSize);
    }

    public void startRecording() {
        try {
            initRecorder();
            this.isRecording = true;
            this.mRecorder.startRecording();
            new preLoadSound().execute(new Void[0]);
        } catch (Exception unused) {
        }
    }

    public class preLoadSound extends AsyncTask<Void, Void, Void> {
        public preLoadSound() {
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... voidArr) {
            while (AutelAudioRecorderUtils.this.isRecording) {
                try {
                    int read = AutelAudioRecorderUtils.this.mRecorder.read(AutelAudioRecorderUtils.this.mBuffer, 0, 1152);
                    if (read > 0) {
                        AutelPlayer.writeAudioData(AutelAudioRecorderUtils.this.mBuffer, read);
                    }
                } catch (Exception unused) {
                }
            }
            return null;
        }
    }

    public void stopRecording() {
        try {
            if (this.isRecording) {
                this.isRecording = false;
                this.mRecorder.stop();
                this.mRecorder.release();
                this.mRecorder = null;
            }
        } catch (Exception unused) {
        }
    }
}

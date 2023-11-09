package com.atakmap.android.uastool.dji.sound;

import android.media.MediaRecorder;
import com.atakmap.coremap.log.Log;
import java.io.File;

public class MediaRecorderHandler {
    private static final String TAG = "MediaRecorderHandler";
    private String fileAbsolutePath;
    private String fileName;
    private final String fileSavePath;
    private boolean isRecording;
    private MediaRecorder mediaRecorder;
    private final MediaRecorderOptions options;

    public MediaRecorderHandler(String str, MediaRecorderOptions mediaRecorderOptions) {
        this.fileSavePath = str;
        this.options = mediaRecorderOptions;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public synchronized void startRecord(String str) {
        try {
            if (!this.isRecording) {
                this.mediaRecorder = new MediaRecorder();
                this.fileName = str;
                String absolutePath = new File(this.fileSavePath, this.fileName).getAbsolutePath();
                this.fileAbsolutePath = absolutePath;
                this.mediaRecorder.setOutputFile(absolutePath);
                this.mediaRecorder.setAudioSource(1);
                this.mediaRecorder.setOutputFormat(6);
                this.mediaRecorder.setAudioEncoder(3);
                this.mediaRecorder.setAudioEncodingBitRate(this.options.getAudioEncodingBitRate());
                this.mediaRecorder.setAudioChannels(this.options.getAudioChannels());
                this.mediaRecorder.setAudioSamplingRate(this.options.getAudioSamplingRate());
                this.mediaRecorder.prepare();
                this.mediaRecorder.start();
                this.isRecording = true;
            }
        } catch (Exception e) {
            Log.e(TAG, "error", e);
        }
        return;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void stopAndRelease() {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.isRecording     // Catch:{ all -> 0x001b }
            if (r0 == 0) goto L_0x0019
            android.media.MediaRecorder r0 = r1.mediaRecorder     // Catch:{ all -> 0x001b }
            if (r0 != 0) goto L_0x000b
            monitor-exit(r1)
            return
        L_0x000b:
            r0.stop()     // Catch:{ all -> 0x001b }
            android.media.MediaRecorder r0 = r1.mediaRecorder     // Catch:{ all -> 0x001b }
            r0.release()     // Catch:{ all -> 0x001b }
            r0 = 0
            r1.mediaRecorder = r0     // Catch:{ all -> 0x001b }
            r0 = 0
            r1.isRecording = r0     // Catch:{ all -> 0x001b }
        L_0x0019:
            monitor-exit(r1)
            return
        L_0x001b:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.dji.sound.MediaRecorderHandler.stopAndRelease():void");
    }

    public void cancel() {
        stopAndRelease();
        if (this.fileAbsolutePath != null) {
            new File(this.fileAbsolutePath).delete();
            this.fileAbsolutePath = null;
        }
    }

    public String getFileName() {
        return this.fileName;
    }

    public boolean isRecording() {
        return this.isRecording;
    }

    public String getCurrentFilePath() {
        return this.fileAbsolutePath;
    }
}

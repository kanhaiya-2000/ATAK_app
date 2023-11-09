package org.droidplanner.services.android.impl.utils.video;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import atakplugin.UASTool.C0695nz;
import atakplugin.UASTool.C1009wu;
import atakplugin.UASTool.C1022xf;
import atakplugin.UASTool.C1026xj;
import atakplugin.UASTool.C1030xn;
import atakplugin.UASTool.C1088zi;
import atakplugin.UASTool.cqb;
import com.o3dr.android.client.utils.video.MediaCodecManager;
import com.o3dr.android.client.utils.video.NaluChunk;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

class StreamRecorder implements MediaCodecManager.NaluChunkListener {
    private final AtomicBoolean areParametersSet = new AtomicBoolean(false);
    private ExecutorService asyncExecutor;
    /* access modifiers changed from: private */
    public final Context context;
    private BufferedOutputStream h264Writer;
    private final File mediaRootDir;
    private final AtomicReference<String> recordingFilename = new AtomicReference<>();
    /* access modifiers changed from: private */
    public final MediaScannerConnection.OnScanCompletedListener scanCompletedListener = new MediaScannerConnection.OnScanCompletedListener() {
        public void onScanCompleted(String str, Uri uri) {
            cqb.m12010c("Media file %s was scanned successfully: %s", str, uri);
        }
    };

    StreamRecorder(Context context2) {
        this.context = context2;
        File file = new File(context2.getExternalFilesDir(Environment.DIRECTORY_MOVIES), "stream");
        this.mediaRootDir = file;
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    /* access modifiers changed from: package-private */
    public String getRecordingFilename() {
        return this.recordingFilename.get();
    }

    /* access modifiers changed from: package-private */
    public void startConverterThread() {
        ExecutorService executorService = this.asyncExecutor;
        if (executorService == null || executorService.isShutdown()) {
            this.asyncExecutor = Executors.newSingleThreadExecutor();
        }
    }

    /* access modifiers changed from: package-private */
    public void stopConverterThread() {
        ExecutorService executorService = this.asyncExecutor;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isRecordingEnabled() {
        return !TextUtils.isEmpty(this.recordingFilename.get());
    }

    /* access modifiers changed from: package-private */
    public boolean enableRecording(String str) {
        if (!isRecordingEnabled()) {
            this.areParametersSet.set(false);
            this.recordingFilename.set(str);
            cqb.m12010c("Enabling local recording to %s", str);
            File file = new File(this.mediaRootDir, str);
            if (file.exists()) {
                file.delete();
            }
            try {
                this.h264Writer = new BufferedOutputStream(new FileOutputStream(file));
                return true;
            } catch (FileNotFoundException e) {
                cqb.m12015e(e, e.getMessage(), new Object[0]);
                this.recordingFilename.set((Object) null);
                return false;
            }
        } else {
            cqb.m12012d("Video stream recording is already enabled", new Object[0]);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean disableRecording() {
        if (isRecordingEnabled()) {
            cqb.m12010c("Disabling local recording", new Object[0]);
            BufferedOutputStream bufferedOutputStream = this.h264Writer;
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    cqb.m12015e(e, e.getMessage(), new Object[0]);
                } catch (Throwable th) {
                    this.h264Writer = null;
                    convertToMp4(this.recordingFilename.get());
                    this.recordingFilename.set((Object) null);
                    throw th;
                }
                this.h264Writer = null;
                convertToMp4(this.recordingFilename.get());
                this.recordingFilename.set((Object) null);
            }
        }
        this.areParametersSet.set(false);
        return true;
    }

    public void onNaluChunkUpdated(NaluChunk naluChunk, NaluChunk naluChunk2) {
        if (isRecordingEnabled() && this.h264Writer != null) {
            if (this.areParametersSet.get()) {
                try {
                    writeNaluChunk(this.h264Writer, naluChunk2);
                } catch (IOException e) {
                    cqb.m12015e(e, e.getMessage(), new Object[0]);
                }
            } else {
                try {
                    this.areParametersSet.set(writeNaluChunk(this.h264Writer, naluChunk));
                } catch (IOException e2) {
                    cqb.m12015e(e2, e2.getMessage(), new Object[0]);
                }
            }
        }
    }

    private boolean writeNaluChunk(BufferedOutputStream bufferedOutputStream, NaluChunk naluChunk) {
        if (naluChunk == null) {
            return false;
        }
        for (ByteBuffer byteBuffer : naluChunk.payloads) {
            if (byteBuffer.capacity() != 0) {
                bufferedOutputStream.write(byteBuffer.array(), 0, byteBuffer.position());
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void convertToMp4(final String str) {
        if (TextUtils.isEmpty(str)) {
            cqb.m12012d("Invalid media filename.", new Object[0]);
            return;
        }
        final File file = new File(this.mediaRootDir, str);
        if (!file.exists()) {
            cqb.m12012d("Media file doesn't exists.", new Object[0]);
        } else if (file.length() == 0) {
            cqb.m12012d("Media file is empty.", new Object[0]);
        } else {
            this.asyncExecutor.execute(new Runnable() {
                public void run() {
                    cqb.m12010c("Starting h264 conversion process for media file %s.", str);
                    try {
                        C1088zi ziVar = new C1088zi(new C1009wu(file));
                        C1022xf xfVar = new C1022xf();
                        xfVar.mo6161a((C1026xj) ziVar);
                        C0695nz a = new C1030xn().mo6195a(xfVar);
                        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES);
                        File file = new File(externalStoragePublicDirectory, str + ".mp4");
                        cqb.m12010c("Generating the mp4 file @ %s", file.getAbsolutePath());
                        FileChannel channel = new FileOutputStream(file).getChannel();
                        a.mo209b(channel);
                        channel.close();
                        cqb.m12010c("Deleting raw h264 media file.", new Object[0]);
                        file.delete();
                        cqb.m12010c("Adding the generated mp4 file to the media store.", new Object[0]);
                        MediaScannerConnection.scanFile(StreamRecorder.this.context, new String[]{file.getAbsolutePath()}, (String[]) null, StreamRecorder.this.scanCompletedListener);
                    } catch (IOException | NullPointerException e) {
                        cqb.m12015e(e, e.getMessage(), new Object[0]);
                    }
                }
            });
        }
    }
}

package com.autel.downloader;

import android.text.TextUtils;
import com.autel.downloader.bean.DownloadTask;
import com.autel.downloader.bean.HttpDownloadCallback;
import com.autel.downloader.client.IHttpClientInterface;
import com.autel.downloader.databases.IDownloadTaskDBHelper;
import com.autel.downloader.enums.HttpDownloadStatus;
import com.autel.downloader.utils.DownloadUtils;
import com.autel.util.log.AutelLog;
import java.io.File;
import java.io.RandomAccessFile;

public class HttpdownloadTaskRunnable implements Runnable {
    private static final String TAG = "HttpdownloadTaskRunnable";
    private HttpDownloadCallback Callback;
    private boolean canContines = false;
    private IHttpClientInterface client;
    private long duration = 1000;
    private volatile boolean isCanceled = false;
    private boolean isRunning = false;
    private long lastProgressTime = 0;
    private IDownloadTaskDBHelper mDownloadTaskDBManager;
    private File mFile = null;
    private long recevie_length = 0;
    private boolean repeat = true;
    private DownloadTask taskBean;

    public HttpdownloadTaskRunnable(IHttpClientInterface iHttpClientInterface, DownloadTask downloadTask, IDownloadTaskDBHelper iDownloadTaskDBHelper, HttpDownloadCallback httpDownloadCallback, boolean z) {
        this.taskBean = downloadTask;
        this.mDownloadTaskDBManager = iDownloadTaskDBHelper;
        this.Callback = httpDownloadCallback;
        this.client = iHttpClientInterface;
        this.repeat = z;
        this.isRunning = true;
    }

    public int getTaskId() {
        return this.taskBean.getId();
    }

    public void OnCancel() {
        OnPaused();
        this.isCanceled = true;
    }

    private void OnPaused() {
        if (!this.isCanceled) {
            this.taskBean.setStatus(HttpDownloadStatus.PAUSE);
            updateStatus();
            this.Callback.paused(this.taskBean.getId(), this.taskBean.getReceiveLength(), this.taskBean.getTotalLength());
        }
    }

    private void OnStarted() {
        if (!this.isCanceled) {
            this.taskBean.setStatus(HttpDownloadStatus.RUNNING);
            updateStatus();
            this.Callback.started(this.taskBean.getId());
        }
    }

    public void OnWaitting() {
        if (!this.isCanceled) {
            if (this.taskBean.getStatus() == HttpDownloadStatus.COMPLETE) {
                this.taskBean.setReceiveLength(0);
            }
            this.taskBean.setStatus(HttpDownloadStatus.WAITTING);
            updateStatus();
            this.Callback.waitting(this.taskBean.getId(), this.taskBean.getReceiveLength(), this.taskBean.getTotalLength());
        }
    }

    private void OnError(Throwable th) {
        if (!this.isCanceled) {
            if (this.taskBean.getStatus() == HttpDownloadStatus.RUNNING || this.taskBean.getStatus() == HttpDownloadStatus.WAITTING) {
                this.taskBean.setStatus(HttpDownloadStatus.ERROR);
                updateStatus();
                this.Callback.error(this.taskBean.getId(), th);
            }
        }
    }

    private void OnComplete() {
        if (!this.isCanceled) {
            if (checkDownFile()) {
                this.taskBean.setStatus(HttpDownloadStatus.COMPLETE);
                updateStatus();
                this.Callback.completed(this.taskBean.getId(), this.taskBean.getPath());
                return;
            }
            OnError(new Throwable("download finish,but check file error."));
        }
    }

    private void OnProgress(long j, long j2) {
        if (!this.isCanceled && this.taskBean.getStatus() == HttpDownloadStatus.RUNNING) {
            this.taskBean.setReceiveLength(j2);
            long currentTimeMillis = System.currentTimeMillis();
            if (j == j2 || currentTimeMillis >= this.lastProgressTime + this.duration) {
                this.lastProgressTime = currentTimeMillis;
                this.Callback.progress(this.taskBean.getId(), this.taskBean.getReceiveLength(), this.taskBean.getTotalLength());
            }
        }
    }

    public boolean isAlive() {
        return this.isRunning;
    }

    public void run() {
        int isTaskCanContinue;
        String str;
        String str2;
        RandomAccessFile generateDownloadFile;
        if (!this.isCanceled) {
            synchronized (this.taskBean.mLock) {
                isTaskCanContinue = DownloadUtils.isTaskCanContinue(this.taskBean, this.repeat);
            }
            this.canContines = isTaskCanContinue == 0;
            try {
                if (this.taskBean.getStatus() != HttpDownloadStatus.WAITTING) {
                    OnError(new Throwable("cannot run,beacuse status is not waitting."));
                } else {
                    OnStarted();
                    if (isTaskCanContinue != 1 || this.repeat || this.isCanceled) {
                        try {
                            if (this.taskBean != null) {
                                this.mFile = new File(this.taskBean.getPath() + ".temp");
                            }
                            synchronized (this.taskBean.mLock) {
                                generateDownloadFile = generateDownloadFile(this.taskBean, this.canContines);
                            }
                            this.taskBean.setReceiveLength(generateDownloadFile.length());
                            this.client.download(getTaskId(), this.taskBean.getUrl(), this.taskBean.getReceiveLength(), this.canContines);
                            if (!this.client.isSuccessful(getTaskId())) {
                                OnError(new Throwable("connect fail."));
                            }
                            processResponse(generateDownloadFile);
                        } catch (Exception e) {
                            e.printStackTrace();
                            OnError(e);
                        }
                        AutelLog.m15082d(TAG, "task " + this.taskBean.getId() + " running finish on thread" + Thread.currentThread().getName());
                        this.isRunning = false;
                        try {
                            this.client.close(getTaskId());
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    } else {
                        AutelLog.m15082d(TAG, "task had complete and repeat was " + this.repeat + ",so not continue.");
                        OnProgress(this.taskBean.getTotalLength(), this.taskBean.getTotalLength());
                        renameFile(this.mFile, "");
                        OnComplete();
                        AutelLog.m15082d(TAG, "task " + this.taskBean.getId() + " running finish on thread" + Thread.currentThread().getName());
                        this.isRunning = false;
                        try {
                            this.client.close(getTaskId());
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                }
            } finally {
                String str3 = TAG;
                StringBuilder sb = new StringBuilder();
                str = "task ";
                sb.append(str);
                sb.append(this.taskBean.getId());
                str2 = " running finish on thread";
                sb.append(str2);
                sb.append(Thread.currentThread().getName());
                AutelLog.m15082d(str3, sb.toString());
                this.isRunning = false;
                try {
                    this.client.close(getTaskId());
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        }
    }

    private File renameFile(File file, String str) {
        File file2 = new File(file.getParentFile(), file.getName().replace(".temp", str));
        if (file.renameTo(file2)) {
            return file2;
        }
        return null;
    }

    private boolean checkFileExist() {
        File file = this.mFile;
        return file != null && file.exists();
    }

    private void updateStatus() {
        try {
            this.mDownloadTaskDBManager.update(this.taskBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00db, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x011d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0132, code lost:
        if (r6 != null) goto L_0x0134;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0134, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0138, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x013a, code lost:
        if (r13 != null) goto L_0x013c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x013c, code lost:
        r13.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x013f, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0141, code lost:
        throw r13;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:42:0x00d2, B:68:0x0120] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean processResponse(java.io.RandomAccessFile r13) {
        /*
            r12 = this;
            boolean r0 = r12.isCanceled
            r1 = 1
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            com.autel.downloader.client.IHttpClientInterface r0 = r12.client
            int r2 = r12.getTaskId()
            int r0 = r0.code(r2)
            r2 = 200(0xc8, float:2.8E-43)
            r3 = 0
            if (r0 != r2) goto L_0x0017
            r0 = 1
            goto L_0x0018
        L_0x0017:
            r0 = 0
        L_0x0018:
            com.autel.downloader.client.IHttpClientInterface r2 = r12.client
            int r4 = r12.getTaskId()
            int r2 = r2.code(r4)
            r4 = 206(0xce, float:2.89E-43)
            if (r2 != r4) goto L_0x002c
            boolean r2 = r12.canContines
            if (r2 == 0) goto L_0x002c
            r2 = 1
            goto L_0x002d
        L_0x002c:
            r2 = 0
        L_0x002d:
            if (r0 != 0) goto L_0x0031
            if (r2 == 0) goto L_0x00e7
        L_0x0031:
            com.autel.downloader.bean.DownloadTask r4 = r12.taskBean
            long r4 = r4.getTotalLength()
            com.autel.downloader.client.IHttpClientInterface r6 = r12.client
            int r7 = r12.getTaskId()
            java.lang.String r8 = "Transfer-VideoEncodeFormat"
            java.lang.String r6 = r6.header(r7, r8)
            r7 = 0
            if (r0 != 0) goto L_0x004b
            int r0 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r0 > 0) goto L_0x0061
        L_0x004b:
            com.autel.downloader.client.IHttpClientInterface r0 = r12.client
            int r4 = r12.getTaskId()
            long r4 = r0.contentLength(r4)
            if (r6 != 0) goto L_0x0061
            com.autel.downloader.client.IHttpClientInterface r0 = r12.client
            int r4 = r12.getTaskId()
            long r4 = r0.contentLength(r4)
        L_0x0061:
            r0 = 4096(0x1000, float:5.74E-42)
            byte[] r0 = new byte[r0]
            com.autel.downloader.client.IHttpClientInterface r6 = r12.client
            int r9 = r12.getTaskId()
            java.io.InputStream r6 = r6.byteStream(r9)
            int r9 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r9 > 0) goto L_0x0078
            int r4 = r6.available()
            long r4 = (long) r4
        L_0x0078:
            int r9 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r9 <= 0) goto L_0x0142
            com.autel.downloader.bean.DownloadTask r9 = r12.taskBean
            r9.setTotalLength(r4)
            com.autel.downloader.databases.IDownloadTaskDBHelper r9 = r12.mDownloadTaskDBManager
            com.autel.downloader.bean.DownloadTask r10 = r12.taskBean
            r9.update((com.autel.downloader.bean.DownloadTask) r10)
            if (r2 == 0) goto L_0x00ae
            com.autel.downloader.bean.DownloadTask r2 = r12.taskBean
            long r7 = r2.getReceiveLength()
            r12.recevie_length = r7
            r13.seek(r7)
            java.lang.String r2 = "HttpdownloadTaskRunnable"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Success Resume :"
            r7.append(r8)
            long r8 = r12.recevie_length
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            com.autel.util.log.AutelLog.m15082d(r2, r7)
            goto L_0x00b0
        L_0x00ae:
            r12.recevie_length = r7
        L_0x00b0:
            com.autel.downloader.bean.DownloadTask r2 = r12.taskBean
            java.lang.Object r2 = r2.mLock
            monitor-enter(r2)
        L_0x00b5:
            boolean r7 = r12.isCanceled     // Catch:{ IOException -> 0x011f }
            if (r7 != 0) goto L_0x0115
            int r7 = r6.read(r0)     // Catch:{ IOException -> 0x011f }
            r8 = -1
            if (r7 != r8) goto L_0x00e8
            long r7 = r12.recevie_length     // Catch:{ IOException -> 0x011f }
            int r0 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r0 != 0) goto L_0x00dc
            java.io.File r0 = r12.mFile     // Catch:{ IOException -> 0x011f }
            java.lang.String r3 = ""
            r12.renameFile(r0, r3)     // Catch:{ IOException -> 0x011f }
            r12.OnComplete()     // Catch:{ IOException -> 0x011f }
            if (r6 == 0) goto L_0x00d5
            r6.close()     // Catch:{ all -> 0x0138 }
        L_0x00d5:
            if (r13 == 0) goto L_0x00da
            r13.close()     // Catch:{ all -> 0x0138 }
        L_0x00da:
            monitor-exit(r2)     // Catch:{ all -> 0x0138 }
            return r1
        L_0x00dc:
            if (r6 == 0) goto L_0x00e1
            r6.close()     // Catch:{ all -> 0x0138 }
        L_0x00e1:
            if (r13 == 0) goto L_0x00e6
            r13.close()     // Catch:{ all -> 0x0138 }
        L_0x00e6:
            monitor-exit(r2)     // Catch:{ all -> 0x0138 }
        L_0x00e7:
            return r3
        L_0x00e8:
            boolean r8 = r12.checkFileExist()     // Catch:{ IOException -> 0x011f }
            if (r8 == 0) goto L_0x010d
            long r8 = r12.recevie_length     // Catch:{ IOException -> 0x011f }
            long r10 = (long) r7     // Catch:{ IOException -> 0x011f }
            long r8 = r8 + r10
            r12.recevie_length = r8     // Catch:{ IOException -> 0x011f }
            r13.write(r0, r3, r7)     // Catch:{ IOException -> 0x011f }
            long r7 = r13.length()     // Catch:{ IOException -> 0x011f }
            long r9 = r12.recevie_length     // Catch:{ IOException -> 0x011f }
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 < 0) goto L_0x0105
            r12.OnProgress(r4, r9)     // Catch:{ IOException -> 0x011f }
            goto L_0x00b5
        L_0x0105:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ IOException -> 0x011f }
            java.lang.String r3 = "output file length error when downloading."
            r0.<init>(r3)     // Catch:{ IOException -> 0x011f }
            throw r0     // Catch:{ IOException -> 0x011f }
        L_0x010d:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ IOException -> 0x011f }
            java.lang.String r3 = "output file not exist."
            r0.<init>(r3)     // Catch:{ IOException -> 0x011f }
            throw r0     // Catch:{ IOException -> 0x011f }
        L_0x0115:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x011f }
            java.lang.String r3 = "UserCanceled"
            r0.<init>(r3)     // Catch:{ IOException -> 0x011f }
            throw r0     // Catch:{ IOException -> 0x011f }
        L_0x011d:
            r0 = move-exception
            goto L_0x0132
        L_0x011f:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x011d }
            r12.OnError(r0)     // Catch:{ all -> 0x011d }
            if (r6 == 0) goto L_0x012b
            r6.close()     // Catch:{ all -> 0x0138 }
        L_0x012b:
            if (r13 == 0) goto L_0x0130
            r13.close()     // Catch:{ all -> 0x0138 }
        L_0x0130:
            monitor-exit(r2)     // Catch:{ all -> 0x0138 }
            return r1
        L_0x0132:
            if (r6 == 0) goto L_0x013a
            r6.close()     // Catch:{ all -> 0x0138 }
            goto L_0x013a
        L_0x0138:
            r13 = move-exception
            goto L_0x0140
        L_0x013a:
            if (r13 == 0) goto L_0x013f
            r13.close()     // Catch:{ all -> 0x0138 }
        L_0x013f:
            throw r0     // Catch:{ all -> 0x0138 }
        L_0x0140:
            monitor-exit(r2)     // Catch:{ all -> 0x0138 }
            throw r13
        L_0x0142:
            java.lang.RuntimeException r13 = new java.lang.RuntimeException
            java.lang.String r0 = "File length <=0 error."
            r13.<init>(r0)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autel.downloader.HttpdownloadTaskRunnable.processResponse(java.io.RandomAccessFile):boolean");
    }

    private RandomAccessFile generateDownloadFile(DownloadTask downloadTask, boolean z) {
        if (downloadTask.getPath() == null || TextUtils.isEmpty(downloadTask.getPath())) {
            throw new Exception("targe path invalid.");
        }
        if (this.mFile == null) {
            this.mFile = new File(downloadTask.getPath());
        }
        if (!this.mFile.exists() || !this.mFile.isDirectory()) {
            if (!this.mFile.exists()) {
                File parentFile = this.mFile.getParentFile();
                AutelLog.m15082d(TAG, "parent path:" + parentFile.getAbsolutePath());
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                if (!this.mFile.createNewFile()) {
                    throw new Exception("create new file error " + this.mFile.getAbsolutePath());
                }
            } else if (!z) {
                this.mFile.delete();
            }
            return new RandomAccessFile(this.mFile, "rw");
        }
        throw new Exception("targe path is a directory. ");
    }

    private boolean checkDownFile() {
        File file = new File(this.taskBean.getPath());
        if (!file.exists()) {
            AutelLog.m15082d(TAG, "checkDownFile fail,because file isn't exist");
            return false;
        } else if (file.length() == this.taskBean.getTotalLength()) {
            return true;
        } else {
            AutelLog.m15082d(TAG, "checkDownFile fail,because file's length  error,file length is :" + file.length() + ",total length :" + this.taskBean.getTotalLength());
            return false;
        }
    }
}

package com.autel.downloader;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import atakplugin.UASTool.brw;
import com.autel.downloader.bean.DownloadTask;
import com.autel.downloader.bean.HttpDownloadCallback;
import com.autel.downloader.client.IHttpClientInterface;
import com.autel.downloader.client.OkHttpClientManager;
import com.autel.downloader.databases.DownloadTaskQueueManager;
import com.autel.downloader.databases.IDownloadTaskDBHelper;
import com.autel.downloader.utils.DownloadUtils;
import com.autel.internal.sdk.product.datapost.MsgPostManager;
import com.autel.internal.sdk.product.datapost.PostRunnable;
import com.autel.util.log.AutelLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class HttpDownloadManager implements IDownloadInterface {
    private static final String TAG = "HttpDownloadManager";
    /* access modifiers changed from: private */
    public boolean isDestroy;
    /* access modifiers changed from: private */
    public boolean isInit;
    /* access modifiers changed from: private */
    public ArrayList<HttpDownloadCallback> mCallBacks;
    /* access modifiers changed from: private */
    public IDownloadTaskDBHelper mDownloadTaskDBManager;
    /* access modifiers changed from: private */
    public DownloadThreadPool mDownloadThreadPool;
    private IHttpClientInterface mHttpClient;
    /* access modifiers changed from: private */
    public final Object mLock;
    /* access modifiers changed from: private */
    public int mMaxThread;
    /* access modifiers changed from: private */
    public MessageListener mMessageListener;
    private Executor singleThreadPool;

    public HttpDownloadManager() {
        this.mDownloadThreadPool = null;
        this.mDownloadTaskDBManager = null;
        this.mHttpClient = null;
        this.mCallBacks = new ArrayList<>();
        this.mMaxThread = 5;
        this.mMessageListener = null;
        this.isInit = false;
        this.isDestroy = false;
        this.mLock = new Object();
        this.singleThreadPool = Executors.newSingleThreadExecutor();
        this.mMessageListener = new MessageListener();
    }

    public boolean isInit() {
        return this.isInit;
    }

    public void init(final Context context, final HttpDownloadConfig httpDownloadConfig) {
        IHttpClientInterface client = httpDownloadConfig.getClient();
        this.mHttpClient = client;
        if (client == null) {
            this.mHttpClient = new OkHttpClientManager();
        }
        this.singleThreadPool.execute(new Runnable() {
            public void run() {
                synchronized (HttpDownloadManager.this.mLock) {
                    if (!HttpDownloadManager.this.isInit) {
                        AutelLog.m15084e("Ivanwu", "init downloader");
                        int unused = HttpDownloadManager.this.mMaxThread = httpDownloadConfig.getMaxThread();
                        DownloadThreadPool unused2 = HttpDownloadManager.this.mDownloadThreadPool = new DownloadThreadPool(HttpDownloadManager.this.mMaxThread);
                        IDownloadTaskDBHelper unused3 = HttpDownloadManager.this.mDownloadTaskDBManager = new DownloadTaskQueueManager(context.getApplicationContext());
                        boolean unused4 = HttpDownloadManager.this.isInit = true;
                        boolean unused5 = HttpDownloadManager.this.isDestroy = false;
                    }
                }
            }
        });
    }

    public brw getOkHttpClient() {
        return ((OkHttpClientManager) this.mHttpClient).getOkHttpClient();
    }

    public void destroy() {
        if (this.isInit) {
            AutelLog.m15084e("Ivanwu", "destroy");
            synchronized (this.mLock) {
                this.isInit = false;
                this.isDestroy = true;
            }
            AutelLog.m15084e("Ivanwu", "destroy##");
            this.singleThreadPool.execute(new Runnable() {
                public void run() {
                    HttpDownloadManager.this.release();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void release() {
        boolean z;
        synchronized (this.mLock) {
            DownloadThreadPool downloadThreadPool = this.mDownloadThreadPool;
            if (downloadThreadPool != null && (z = this.isDestroy)) {
                if (z) {
                    downloadThreadPool.destroy();
                    if (this.mDownloadThreadPool != null) {
                        this.mDownloadThreadPool = null;
                    }
                    IDownloadTaskDBHelper iDownloadTaskDBHelper = this.mDownloadTaskDBManager;
                    if (iDownloadTaskDBHelper != null) {
                        try {
                            iDownloadTaskDBHelper.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        this.mDownloadTaskDBManager = null;
                    }
                    if (this.mHttpClient != null) {
                        this.mHttpClient = null;
                    }
                    ArrayList<HttpDownloadCallback> arrayList = this.mCallBacks;
                    if (arrayList != null) {
                        arrayList.clear();
                    }
                    AutelLog.m15082d(TAG, Thread.currentThread().getName() + "realease impl");
                } else {
                    pauseAll();
                }
            }
        }
    }

    public void addDownloadCallback(final HttpDownloadCallback httpDownloadCallback) {
        if (httpDownloadCallback != null && this.mCallBacks != null) {
            this.singleThreadPool.execute(new Runnable() {
                public void run() {
                    synchronized (HttpDownloadManager.this.mLock) {
                        if (!HttpDownloadManager.this.mCallBacks.contains(httpDownloadCallback)) {
                            HttpDownloadManager.this.mCallBacks.add(httpDownloadCallback);
                        }
                    }
                }
            });
        }
    }

    public void removeDownloadCallback(final HttpDownloadCallback httpDownloadCallback) {
        if (httpDownloadCallback != null && this.mCallBacks != null) {
            this.singleThreadPool.execute(new Runnable() {
                public void run() {
                    synchronized (HttpDownloadManager.this.mLock) {
                        if (HttpDownloadManager.this.mCallBacks.contains(httpDownloadCallback)) {
                            HttpDownloadManager.this.mCallBacks.remove(httpDownloadCallback);
                        }
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void adjustInThreadPool(DownloadTask downloadTask, boolean z) {
        if (isRunning(downloadTask)) {
            AutelLog.m15082d(TAG, "task is running,don't fire again.");
            return;
        }
        AutelLog.m15082d(TAG, "add task :\"" + downloadTask.getId() + "\" ,url:" + downloadTask.getUrl() + " ,path:" + downloadTask.getPath());
        this.mDownloadThreadPool.execute(new HttpdownloadTaskRunnable(this.mHttpClient, downloadTask, this.mDownloadTaskDBManager, this.mMessageListener, z));
    }

    public DownloadTask createTask(String str, String str2) {
        DownloadTask taskBeanById;
        synchronized (this.mLock) {
            if (!this.isInit) {
                AutelLog.m15090w(TAG, "Downloadmanager is not init");
                return null;
            }
            if (str != null && !TextUtils.isEmpty(str)) {
                if (str.startsWith("http") || str.startsWith("https")) {
                    int taskId = DownloadUtils.getTaskId(str, str2);
                    taskBeanById = this.mDownloadTaskDBManager.getTaskBeanById(taskId);
                    if (taskBeanById == null) {
                        taskBeanById = new DownloadTask();
                        taskBeanById.setId(taskId);
                        taskBeanById.setUrl(str);
                        taskBeanById.setPath(str2);
                        try {
                            this.mDownloadTaskDBManager.insert(taskBeanById);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            AutelLog.m15090w(TAG, "url 不合法");
            return null;
        }
        return taskBeanById;
    }

    public void createTaskAsyn(final String str, final String str2, final Object obj) {
        this.singleThreadPool.execute(new Runnable() {
            public void run() {
                synchronized (HttpDownloadManager.this.mLock) {
                    AutelLog.m15090w("Ivanwu", "createTaskAsyn");
                    HttpDownloadManager.this.mMessageListener.createdTask(HttpDownloadManager.this.createTask(str, str2), obj);
                }
            }
        });
    }

    public void start(DownloadTask downloadTask) {
        start(downloadTask, true);
    }

    public void start(final DownloadTask downloadTask, final boolean z) {
        this.singleThreadPool.execute(new Runnable() {
            public void run() {
                synchronized (HttpDownloadManager.this.mLock) {
                    if (downloadTask != null) {
                        if (!HttpDownloadManager.this.isInit) {
                            AutelLog.m15090w(HttpDownloadManager.TAG, "Downloadmanager is not init,can not fire");
                        }
                        HttpDownloadManager.this.adjustInThreadPool(downloadTask, z);
                    }
                }
            }
        });
    }

    public void resume(final int i) {
        this.singleThreadPool.execute(new Runnable() {
            /* JADX WARNING: Code restructure failed: missing block: B:13:0x004b, code lost:
                return;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r4 = this;
                    com.autel.downloader.HttpDownloadManager r0 = com.autel.downloader.HttpDownloadManager.this
                    java.lang.Object r0 = r0.mLock
                    monitor-enter(r0)
                    com.autel.downloader.HttpDownloadManager r1 = com.autel.downloader.HttpDownloadManager.this     // Catch:{ all -> 0x004c }
                    boolean r1 = r1.isInit     // Catch:{ all -> 0x004c }
                    if (r1 != 0) goto L_0x0018
                    java.lang.String r1 = "HttpDownloadManager"
                    java.lang.String r2 = "Downloadmanager is not init,can not resume"
                    com.autel.util.log.AutelLog.m15090w(r1, r2)     // Catch:{ all -> 0x004c }
                    monitor-exit(r0)     // Catch:{ all -> 0x004c }
                    return
                L_0x0018:
                    com.autel.downloader.HttpDownloadManager r1 = com.autel.downloader.HttpDownloadManager.this     // Catch:{ all -> 0x004c }
                    com.autel.downloader.databases.IDownloadTaskDBHelper r1 = r1.mDownloadTaskDBManager     // Catch:{ all -> 0x004c }
                    int r2 = r3     // Catch:{ all -> 0x004c }
                    com.autel.downloader.bean.DownloadTask r1 = r1.getTaskBeanById(r2)     // Catch:{ all -> 0x004c }
                    if (r1 != 0) goto L_0x0044
                    java.lang.String r1 = "HttpDownloadManager"
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x004c }
                    r2.<init>()     // Catch:{ all -> 0x004c }
                    java.lang.String r3 = "resume fail,task "
                    r2.append(r3)     // Catch:{ all -> 0x004c }
                    int r3 = r3     // Catch:{ all -> 0x004c }
                    r2.append(r3)     // Catch:{ all -> 0x004c }
                    java.lang.String r3 = " not exist,please check!"
                    r2.append(r3)     // Catch:{ all -> 0x004c }
                    java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x004c }
                    com.autel.util.log.AutelLog.m15090w(r1, r2)     // Catch:{ all -> 0x004c }
                    goto L_0x004a
                L_0x0044:
                    com.autel.downloader.HttpDownloadManager r2 = com.autel.downloader.HttpDownloadManager.this     // Catch:{ all -> 0x004c }
                    r3 = 1
                    r2.adjustInThreadPool(r1, r3)     // Catch:{ all -> 0x004c }
                L_0x004a:
                    monitor-exit(r0)     // Catch:{ all -> 0x004c }
                    return
                L_0x004c:
                    r1 = move-exception
                    monitor-exit(r0)     // Catch:{ all -> 0x004c }
                    throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.autel.downloader.HttpDownloadManager.C27107.run():void");
            }
        });
    }

    public void pause(final int i) {
        this.singleThreadPool.execute(new Runnable() {
            public void run() {
                synchronized (HttpDownloadManager.this.mLock) {
                    if (!HttpDownloadManager.this.isInit) {
                        AutelLog.m15090w(HttpDownloadManager.TAG, "Downloadmanager is not init,cannot pause");
                    } else {
                        HttpDownloadManager.this.mDownloadThreadPool.cancel(i, true);
                    }
                }
            }
        });
    }

    public void pauseAll() {
        this.singleThreadPool.execute(new Runnable() {
            public void run() {
                synchronized (HttpDownloadManager.this.mLock) {
                    if (!HttpDownloadManager.this.isInit) {
                        AutelLog.m15090w(HttpDownloadManager.TAG, "Downloadmanager is not init,can not pause all");
                        return;
                    }
                    AutelLog.m15090w(HttpDownloadManager.TAG, "pauseAll");
                    HttpDownloadManager.this.mDownloadThreadPool.stopAllTask();
                }
            }
        });
    }

    public void cancel(final int i) {
        this.singleThreadPool.execute(new Runnable() {
            public void run() {
                synchronized (HttpDownloadManager.this.mLock) {
                    if (!HttpDownloadManager.this.isInit) {
                        AutelLog.m15090w(HttpDownloadManager.TAG, "Downloadmanager is not init,can not cancel");
                        return;
                    }
                    try {
                        HttpDownloadManager.this.mDownloadTaskDBManager.remove(i);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    HttpDownloadManager.this.mDownloadThreadPool.cancel(i, true);
                }
            }
        });
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001b, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isDownloading(int r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.mLock
            monitor-enter(r0)
            boolean r1 = r3.isInit     // Catch:{ all -> 0x001c }
            r2 = 0
            if (r1 != 0) goto L_0x0011
            java.lang.String r4 = "HttpDownloadManager"
            java.lang.String r1 = "Downloadmanager is not init,can not get isDownloading"
            com.autel.util.log.AutelLog.m15090w(r4, r1)     // Catch:{ all -> 0x001c }
            monitor-exit(r0)     // Catch:{ all -> 0x001c }
            return r2
        L_0x0011:
            com.autel.downloader.enums.HttpDownloadStatus r4 = r3.getStatus(r4)     // Catch:{ all -> 0x001c }
            com.autel.downloader.enums.HttpDownloadStatus r1 = com.autel.downloader.enums.HttpDownloadStatus.RUNNING     // Catch:{ all -> 0x001c }
            if (r4 != r1) goto L_0x001a
            r2 = 1
        L_0x001a:
            monitor-exit(r0)     // Catch:{ all -> 0x001c }
            return r2
        L_0x001c:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001c }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autel.downloader.HttpDownloadManager.isDownloading(int):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003d, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.autel.downloader.enums.HttpDownloadStatus getStatus(int r6) {
        /*
            r5 = this;
            java.lang.Object r0 = r5.mLock
            monitor-enter(r0)
            boolean r1 = r5.isInit     // Catch:{ all -> 0x003e }
            if (r1 != 0) goto L_0x0012
            java.lang.String r6 = "HttpDownloadManager"
            java.lang.String r1 = "Downloadmanager is not init, can not get status"
            com.autel.util.log.AutelLog.m15090w(r6, r1)     // Catch:{ all -> 0x003e }
            com.autel.downloader.enums.HttpDownloadStatus r6 = com.autel.downloader.enums.HttpDownloadStatus.INVALID_STATUS     // Catch:{ all -> 0x003e }
            monitor-exit(r0)     // Catch:{ all -> 0x003e }
            return r6
        L_0x0012:
            com.autel.downloader.databases.IDownloadTaskDBHelper r1 = r5.mDownloadTaskDBManager     // Catch:{ all -> 0x003e }
            com.autel.downloader.bean.DownloadTask r1 = r1.getTaskBeanById(r6)     // Catch:{ all -> 0x003e }
            if (r1 != 0) goto L_0x0038
            com.autel.downloader.enums.HttpDownloadStatus r1 = com.autel.downloader.enums.HttpDownloadStatus.INVALID_STATUS     // Catch:{ all -> 0x003e }
            java.lang.String r2 = "HttpDownloadManager"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x003e }
            r3.<init>()     // Catch:{ all -> 0x003e }
            java.lang.String r4 = "task "
            r3.append(r4)     // Catch:{ all -> 0x003e }
            r3.append(r6)     // Catch:{ all -> 0x003e }
            java.lang.String r6 = " not exist,please check!"
            r3.append(r6)     // Catch:{ all -> 0x003e }
            java.lang.String r6 = r3.toString()     // Catch:{ all -> 0x003e }
            com.autel.util.log.AutelLog.m15090w(r2, r6)     // Catch:{ all -> 0x003e }
            goto L_0x003c
        L_0x0038:
            com.autel.downloader.enums.HttpDownloadStatus r1 = r1.getStatus()     // Catch:{ all -> 0x003e }
        L_0x003c:
            monitor-exit(r0)     // Catch:{ all -> 0x003e }
            return r1
        L_0x003e:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003e }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autel.downloader.HttpDownloadManager.getStatus(int):com.autel.downloader.enums.HttpDownloadStatus");
    }

    public DownloadTask getTaskInfo(int i) {
        synchronized (this.mLock) {
            if (!this.isInit) {
                AutelLog.m15090w(TAG, "Downloadmanager is not init, can not get taskinfo");
                return null;
            }
            DownloadTask taskBeanById = this.mDownloadTaskDBManager.getTaskBeanById(i);
            return taskBeanById;
        }
    }

    public SparseArray<DownloadTask> getTastList() {
        synchronized (this.mLock) {
            if (!this.isInit) {
                AutelLog.m15090w(TAG, "Downloadmanager is not init,can not get list");
                return null;
            }
            SparseArray<DownloadTask> taskList = this.mDownloadTaskDBManager.getTaskList();
            return taskList;
        }
    }

    private boolean isRunning(DownloadTask downloadTask) {
        synchronized (this.mLock) {
            if (downloadTask == null) {
                return false;
            }
            boolean checkTaskExist = this.mDownloadThreadPool.checkTaskExist(downloadTask.getId());
            return checkTaskExist;
        }
    }

    private class MessageListener implements HttpDownloadCallback {
        private MessageListener() {
        }

        public void createdTask(DownloadTask downloadTask, Object obj) {
            if (!HttpDownloadManager.this.isDestroy) {
                synchronized (HttpDownloadManager.this.mLock) {
                    Iterator it = HttpDownloadManager.this.mCallBacks.iterator();
                    while (it.hasNext()) {
                        ((HttpDownloadCallback) it.next()).createdTask(downloadTask, obj);
                    }
                }
            }
        }

        public void waitting(int i, long j, long j2) {
            if (!HttpDownloadManager.this.isDestroy) {
                synchronized (HttpDownloadManager.this.mLock) {
                    Iterator it = HttpDownloadManager.this.mCallBacks.iterator();
                    while (it.hasNext()) {
                        final HttpDownloadCallback httpDownloadCallback = (HttpDownloadCallback) it.next();
                        final int i2 = i;
                        final long j3 = j;
                        final long j4 = j2;
                        MsgPostManager.instance().post(new PostRunnable() {
                            /* access modifiers changed from: protected */
                            public void task() {
                                httpDownloadCallback.waitting(i2, j3, j4);
                            }
                        });
                    }
                }
            }
        }

        public void started(final int i) {
            if (!HttpDownloadManager.this.isDestroy) {
                synchronized (HttpDownloadManager.this.mLock) {
                    Iterator it = HttpDownloadManager.this.mCallBacks.iterator();
                    while (it.hasNext()) {
                        final HttpDownloadCallback httpDownloadCallback = (HttpDownloadCallback) it.next();
                        MsgPostManager.instance().post(new PostRunnable() {
                            /* access modifiers changed from: protected */
                            public void task() {
                                httpDownloadCallback.started(i);
                            }
                        });
                    }
                }
            }
        }

        public void progress(int i, long j, long j2) {
            if (!HttpDownloadManager.this.isDestroy) {
                synchronized (HttpDownloadManager.this.mLock) {
                    Iterator it = HttpDownloadManager.this.mCallBacks.iterator();
                    while (it.hasNext()) {
                        final HttpDownloadCallback httpDownloadCallback = (HttpDownloadCallback) it.next();
                        final int i2 = i;
                        final long j3 = j;
                        final long j4 = j2;
                        MsgPostManager.instance().post(new PostRunnable() {
                            /* access modifiers changed from: protected */
                            public void task() {
                                httpDownloadCallback.progress(i2, j3, j4);
                            }
                        });
                    }
                }
            }
        }

        public void completed(final int i, final String str) {
            if (!HttpDownloadManager.this.isDestroy) {
                synchronized (HttpDownloadManager.this.mLock) {
                    Iterator it = HttpDownloadManager.this.mCallBacks.iterator();
                    while (it.hasNext()) {
                        final HttpDownloadCallback httpDownloadCallback = (HttpDownloadCallback) it.next();
                        MsgPostManager.instance().post(new PostRunnable() {
                            /* access modifiers changed from: protected */
                            public void task() {
                                httpDownloadCallback.completed(i, str);
                            }
                        });
                    }
                }
            }
        }

        public void paused(int i, long j, long j2) {
            if (!HttpDownloadManager.this.isDestroy) {
                synchronized (HttpDownloadManager.this.mLock) {
                    Iterator it = HttpDownloadManager.this.mCallBacks.iterator();
                    while (it.hasNext()) {
                        final HttpDownloadCallback httpDownloadCallback = (HttpDownloadCallback) it.next();
                        final int i2 = i;
                        final long j3 = j;
                        final long j4 = j2;
                        MsgPostManager.instance().post(new PostRunnable() {
                            /* access modifiers changed from: protected */
                            public void task() {
                                httpDownloadCallback.paused(i2, j3, j4);
                            }
                        });
                    }
                }
            }
        }

        public void error(final int i, final Throwable th) {
            if (!HttpDownloadManager.this.isDestroy) {
                synchronized (HttpDownloadManager.this.mLock) {
                    Iterator it = HttpDownloadManager.this.mCallBacks.iterator();
                    while (it.hasNext()) {
                        final HttpDownloadCallback httpDownloadCallback = (HttpDownloadCallback) it.next();
                        MsgPostManager.instance().post(new PostRunnable() {
                            /* access modifiers changed from: protected */
                            public void task() {
                                httpDownloadCallback.error(i, th);
                            }
                        });
                    }
                }
            }
        }
    }
}

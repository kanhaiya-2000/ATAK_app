package com.autel.downloader;

import android.util.Log;
import com.autel.downloader.utils.DownloadUtils;
import com.autel.util.log.AutelLog;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

public class DownloadThreadPool {
    private static final String TAG = "DownloadThreadPool";
    private static final ThreadFactory sThreadFactory = new ThreadFactory() {
        private final AtomicInteger mCount = new AtomicInteger(1);

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "HttpDownloadManager Task #" + this.mCount.getAndIncrement());
            thread.setPriority(4);
            return thread;
        }
    };
    private Map<Integer, HttpdownloadTaskRunnable> mTaskQueue = new HashMap();
    private ThreadPoolExecutor threadPool;

    DownloadThreadPool(int i) {
        this.threadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(DownloadUtils.getValidNetworkThreadCount(i), sThreadFactory);
    }

    public void destroy() {
        stopAllTask();
        this.threadPool.shutdown();
    }

    public void execute(HttpdownloadTaskRunnable httpdownloadTaskRunnable) {
        try {
            synchronized (this) {
                if (!checkTaskExist(httpdownloadTaskRunnable.getTaskId())) {
                    httpdownloadTaskRunnable.OnWaitting();
                    this.mTaskQueue.remove(Integer.valueOf(httpdownloadTaskRunnable.getTaskId()));
                    this.mTaskQueue.put(Integer.valueOf(httpdownloadTaskRunnable.getTaskId()), httpdownloadTaskRunnable);
                    this.threadPool.execute(httpdownloadTaskRunnable);
                }
            }
            AutelLog.m15082d(TAG, "execute task :" + httpdownloadTaskRunnable.getTaskId());
        } catch (Exception e) {
            Log.e(TAG, "execute exception:" + e.toString());
        }
    }

    public void cancel(int i, boolean z) {
        synchronized (this) {
            HttpdownloadTaskRunnable httpdownloadTaskRunnable = this.mTaskQueue.get(Integer.valueOf(i));
            if (httpdownloadTaskRunnable != null) {
                httpdownloadTaskRunnable.OnCancel();
                boolean remove = this.threadPool.remove(httpdownloadTaskRunnable);
                AutelLog.m15082d(TAG, "cancel task :" + i);
                AutelLog.m15090w(TAG, "remove from threadpool result: " + remove + ",if result is false,because it was running on threadpool");
            } else {
                AutelLog.m15090w(TAG, "task: " + i + " is not exist,please check and try again!");
            }
            if (z) {
                this.mTaskQueue.remove(Integer.valueOf(i));
            }
        }
    }

    public boolean checkTaskExist(int i) {
        boolean z;
        synchronized (this) {
            HttpdownloadTaskRunnable httpdownloadTaskRunnable = this.mTaskQueue.get(Integer.valueOf(i));
            z = httpdownloadTaskRunnable != null && httpdownloadTaskRunnable.isAlive();
        }
        return z;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x006a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void stopAllTask() {
        /*
            r5 = this;
            java.lang.String r0 = "DownloadThreadPool"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "stopAllTask count:"
            r1.append(r2)
            java.util.Map<java.lang.Integer, com.autel.downloader.HttpdownloadTaskRunnable> r2 = r5.mTaskQueue
            int r2 = r2.size()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.autel.util.log.AutelLog.m15082d(r0, r1)
            monitor-enter(r5)
            java.util.Map<java.lang.Integer, com.autel.downloader.HttpdownloadTaskRunnable> r0 = r5.mTaskQueue     // Catch:{ Exception -> 0x006a }
            java.util.Set r0 = r0.entrySet()     // Catch:{ Exception -> 0x006a }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x006a }
        L_0x0027:
            boolean r1 = r0.hasNext()     // Catch:{ Exception -> 0x006a }
            if (r1 == 0) goto L_0x006a
            java.lang.Object r1 = r0.next()     // Catch:{ Exception -> 0x006a }
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ Exception -> 0x006a }
            java.lang.Object r1 = r1.getValue()     // Catch:{ Exception -> 0x006a }
            com.autel.downloader.HttpdownloadTaskRunnable r1 = (com.autel.downloader.HttpdownloadTaskRunnable) r1     // Catch:{ Exception -> 0x006a }
            java.lang.String r2 = "DownloadThreadPool"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x006a }
            r3.<init>()     // Catch:{ Exception -> 0x006a }
            java.lang.String r4 = "stopTask:"
            r3.append(r4)     // Catch:{ Exception -> 0x006a }
            int r4 = r1.getTaskId()     // Catch:{ Exception -> 0x006a }
            r3.append(r4)     // Catch:{ Exception -> 0x006a }
            boolean r4 = r0.hasNext()     // Catch:{ Exception -> 0x006a }
            r3.append(r4)     // Catch:{ Exception -> 0x006a }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x006a }
            com.autel.util.log.AutelLog.m15082d(r2, r3)     // Catch:{ Exception -> 0x006a }
            if (r1 == 0) goto L_0x0064
            int r1 = r1.getTaskId()     // Catch:{ Exception -> 0x006a }
            r2 = 0
            r5.cancel(r1, r2)     // Catch:{ Exception -> 0x006a }
        L_0x0064:
            r0.remove()     // Catch:{ Exception -> 0x006a }
            goto L_0x0027
        L_0x0068:
            r0 = move-exception
            goto L_0x006c
        L_0x006a:
            monitor-exit(r5)     // Catch:{ all -> 0x0068 }
            return
        L_0x006c:
            monitor-exit(r5)     // Catch:{ all -> 0x0068 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autel.downloader.DownloadThreadPool.stopAllTask():void");
    }

    public void removeTask(int i) {
        synchronized (this) {
            HttpdownloadTaskRunnable httpdownloadTaskRunnable = this.mTaskQueue.get(Integer.valueOf(i));
            if (httpdownloadTaskRunnable != null && !httpdownloadTaskRunnable.isAlive()) {
                AutelLog.m15082d(TAG, "removeTask  :" + i);
                this.mTaskQueue.remove(Integer.valueOf(i));
            }
        }
    }

    public int getRunningTaskCount() {
        int size;
        synchronized (this) {
            Map<Integer, HttpdownloadTaskRunnable> map = this.mTaskQueue;
            size = map == null ? 0 : map.size();
        }
        return size;
    }
}

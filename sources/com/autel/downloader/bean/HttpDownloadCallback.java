package com.autel.downloader.bean;

public interface HttpDownloadCallback {
    void completed(int i, String str);

    void createdTask(DownloadTask downloadTask, Object obj);

    void error(int i, Throwable th);

    void paused(int i, long j, long j2);

    void progress(int i, long j, long j2);

    void started(int i);

    void waitting(int i, long j, long j2);
}

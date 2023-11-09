package com.autel.downloader;

import android.util.SparseArray;
import com.autel.downloader.bean.DownloadTask;
import com.autel.downloader.enums.HttpDownloadStatus;

public interface IDownloadInterface {
    void cancel(int i);

    DownloadTask createTask(String str, String str2);

    void createTaskAsyn(String str, String str2, Object obj);

    HttpDownloadStatus getStatus(int i);

    DownloadTask getTaskInfo(int i);

    SparseArray<DownloadTask> getTastList();

    boolean isDownloading(int i);

    void pause(int i);

    void pauseAll();

    void resume(int i);

    void start(DownloadTask downloadTask);

    void start(DownloadTask downloadTask, boolean z);
}

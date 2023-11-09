package com.autel.downloader.databases;

import android.util.SparseArray;
import com.autel.downloader.bean.DownloadTask;
import java.util.List;

public interface IDownloadTaskDBHelper {
    void close();

    DownloadTask getTaskBeanById(int i);

    SparseArray<DownloadTask> getTaskList();

    void insert(DownloadTask downloadTask);

    void remove(int i);

    void update(DownloadTask downloadTask);

    void update(List<DownloadTask> list);
}

package com.autel.downloader.databases;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.SparseArray;
import com.autel.downloader.bean.DownloadTask;
import com.autel.downloader.enums.HttpDownloadStatus;
import java.io.File;
import java.util.List;

public class DownloadTaskQueueManager implements IDownloadTaskDBHelper {
    public static final String TABLE_NAME = "DownloadQueue";

    /* renamed from: db */
    private SQLiteDatabase f8477db;
    private DownloadTaskDBOpenHelper mDownloadTaskDBOpenHelper = null;
    private SparseArray<DownloadTask> mTaskList = new SparseArray<>();

    public void update(List<DownloadTask> list) {
    }

    public DownloadTaskQueueManager(Context context) {
        synchronized (this) {
            DownloadTaskDBOpenHelper downloadTaskDBOpenHelper = new DownloadTaskDBOpenHelper(context);
            this.mDownloadTaskDBOpenHelper = downloadTaskDBOpenHelper;
            this.f8477db = downloadTaskDBOpenHelper.getWritableDatabase();
            initQueue();
        }
    }

    private void initQueue() {
        boolean z;
        this.mTaskList.clear();
        Cursor query = this.f8477db.query(TABLE_NAME, (String[]) null, (String) null, (String[]) null, (String) null, (String) null, (String) null);
        while (query.moveToNext()) {
            DownloadTask downloadTask = new DownloadTask();
            downloadTask.setId(query.getInt(query.getColumnIndex(DownloadTask.f8475ID)));
            downloadTask.setUrl(query.getString(query.getColumnIndex(DownloadTask.URL)));
            downloadTask.setPath(query.getString(query.getColumnIndex(DownloadTask.PATH)));
            downloadTask.setStatus(HttpDownloadStatus.values()[query.getInt(query.getColumnIndex(DownloadTask.STATUS))]);
            File file = new File(downloadTask.getPath());
            if (!file.exists()) {
                downloadTask.setReceiveLength(0);
                try {
                    remove(downloadTask.getId());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                downloadTask.setReceiveLength(file.length());
                downloadTask.setTotalLength((long) query.getInt(query.getColumnIndex(DownloadTask.TOTAL_LENGTH)));
                if (downloadTask.getStatus() == HttpDownloadStatus.RUNNING) {
                    downloadTask.setStatus(HttpDownloadStatus.PAUSE);
                    z = true;
                } else {
                    z = false;
                }
                if (downloadTask.getReceiveLength() == downloadTask.getTotalLength() && downloadTask.getStatus() != HttpDownloadStatus.COMPLETE) {
                    downloadTask.setStatus(HttpDownloadStatus.COMPLETE);
                    z = true;
                }
                if (z) {
                    this.f8477db.update(TABLE_NAME, downloadTask.toContentValues(), "_id = ? ", new String[]{String.valueOf(downloadTask.getId())});
                }
                this.mTaskList.put(downloadTask.getId(), downloadTask);
            }
        }
        query.close();
    }

    public synchronized DownloadTask getTaskBeanById(int i) {
        return this.mTaskList.get(i);
    }

    public void insert(DownloadTask downloadTask) {
        if (downloadTask != null) {
            if (getTaskBeanById(downloadTask.getId()) == null) {
                this.mTaskList.put(downloadTask.getId(), downloadTask);
                this.f8477db.insert(TABLE_NAME, (String) null, downloadTask.toContentValues());
                return;
            }
            update(downloadTask);
        }
    }

    public void update(DownloadTask downloadTask) {
        if (downloadTask != null) {
            if (getTaskBeanById(downloadTask.getId()) != null) {
                this.mTaskList.remove(downloadTask.getId());
                this.mTaskList.put(downloadTask.getId(), downloadTask);
                this.f8477db.update(TABLE_NAME, downloadTask.toContentValues(), "_id = ? ", new String[]{String.valueOf(downloadTask.getId())});
                return;
            }
            insert(downloadTask);
        }
    }

    public synchronized void remove(int i) {
        this.f8477db.delete(TABLE_NAME, "_id = ?", new String[]{String.valueOf(i)});
        this.mTaskList.remove(i);
    }

    public synchronized void close() {
        this.f8477db.close();
    }

    public synchronized SparseArray<DownloadTask> getTaskList() {
        return this.mTaskList;
    }
}

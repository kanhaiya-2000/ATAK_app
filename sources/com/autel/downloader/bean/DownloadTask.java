package com.autel.downloader.bean;

import android.content.ContentValues;
import com.autel.downloader.enums.HttpDownloadStatus;
import com.autel.downloader.utils.DownloadUtils;

public class DownloadTask {

    /* renamed from: ID */
    public static final String f8475ID = "_id";
    public static final String PATH = "path";
    public static final String RECIIVE_LENGTH = "receive_length";
    public static final String STATUS = "status";
    public static final String TOTAL_LENGTH = "total_length";
    public static final String URL = "url";

    /* renamed from: id */
    private int f8476id;
    public final Object mLock = new Object();
    private String path;
    private long receive_length = 0;
    private HttpDownloadStatus status = HttpDownloadStatus.INVALID_STATUS;
    private long total_length = 0;
    private String url;

    public void setId(int i) {
        this.f8476id = i;
    }

    public int getId() {
        return this.f8476id;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public String getPath() {
        return this.path;
    }

    public void setStatus(HttpDownloadStatus httpDownloadStatus) {
        this.status = httpDownloadStatus;
    }

    public HttpDownloadStatus getStatus() {
        return this.status;
    }

    public void setReceiveLength(long j) {
        this.receive_length = j;
    }

    public long getReceiveLength() {
        return this.receive_length;
    }

    public void setTotalLength(long j) {
        this.total_length = j;
    }

    public long getTotalLength() {
        return this.total_length;
    }

    public DownloadTask(String str, String str2) {
        this.url = str;
        this.path = str2;
        this.f8476id = DownloadUtils.getTaskId(str, str2);
    }

    public DownloadTask() {
    }

    public ContentValues toContentValues() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(f8475ID, Integer.valueOf(getId()));
        contentValues.put(URL, getUrl());
        contentValues.put(PATH, getPath());
        contentValues.put(STATUS, Integer.valueOf(getStatus().getValue()));
        contentValues.put(RECIIVE_LENGTH, Long.valueOf(getReceiveLength()));
        contentValues.put(TOTAL_LENGTH, Long.valueOf(getTotalLength()));
        return contentValues;
    }
}

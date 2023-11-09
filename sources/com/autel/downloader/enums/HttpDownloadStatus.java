package com.autel.downloader.enums;

public enum HttpDownloadStatus {
    WAITTING(0),
    RUNNING(1),
    PAUSE(2),
    COMPLETE(3),
    ERROR(4),
    INVALID_STATUS(5);
    
    private int status;

    private HttpDownloadStatus(int i) {
        this.status = i;
    }

    public int getValue() {
        return this.status;
    }
}

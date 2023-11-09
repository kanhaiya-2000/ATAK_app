package com.autel.downloader.error;

public class HttpDownloadError extends Exception {
    public final int code;

    public HttpDownloadError(int i) {
        this.code = i;
    }
}

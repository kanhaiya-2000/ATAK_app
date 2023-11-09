package com.autel.downloader.client;

import java.io.InputStream;

public interface IHttpClientInterface {
    InputStream byteStream(int i);

    void close(int i);

    int code(int i);

    long contentLength(int i);

    void download(int i, String str, long j, boolean z);

    String header(int i, String str);

    boolean isSuccessful(int i);
}

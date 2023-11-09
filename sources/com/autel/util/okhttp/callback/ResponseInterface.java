package com.autel.util.okhttp.callback;

import java.io.InputStream;

public interface ResponseInterface {
    byte[] getBytes();

    int getCode();

    long getContentLength();

    String getHead(String str);

    InputStream getInputStream();

    String getString();

    boolean isSuccess();
}

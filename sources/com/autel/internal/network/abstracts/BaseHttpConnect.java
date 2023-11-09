package com.autel.internal.network.abstracts;

import java.io.BufferedReader;
import java.net.HttpURLConnection;

public abstract class BaseHttpConnect {
    /* access modifiers changed from: protected */
    public abstract void closeHttpConnection();

    /* access modifiers changed from: protected */
    public abstract BufferedReader getBufferedReader();

    public abstract boolean isConnected();

    /* access modifiers changed from: protected */
    public abstract String loadUrl();

    /* access modifiers changed from: protected */
    public abstract HttpURLConnection openConnection(String str);

    /* access modifiers changed from: protected */
    public abstract void parserData(String str);

    /* access modifiers changed from: protected */
    public abstract boolean reConnect();
}

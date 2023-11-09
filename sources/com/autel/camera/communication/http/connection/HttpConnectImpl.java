package com.autel.camera.communication.http.connection;

import com.autel.camera.communication.http.events.CameraMessageDisPatcher;
import com.autel.camera.utils.IpConstantUtils;
import com.autel.util.log.AutelLog;
import com.autel.util.okhttp.model.Headers;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class HttpConnectImpl extends AbsHttpConnection {
    private static final String TAG = "HttpConnectImpl";
    private InputStream inputStream = null;
    private InputStreamReader inputStreamReader = null;
    private HttpURLConnection urlConnection = null;

    /* access modifiers changed from: protected */
    public boolean reConnect() {
        return true;
    }

    /* access modifiers changed from: protected */
    public HttpURLConnection openConnection(String str) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        this.urlConnection = httpURLConnection;
        httpURLConnection.setRequestProperty("connection", Headers.HEAD_VALUE_CONNECTION_CLOSE);
        this.urlConnection.setConnectTimeout(5000);
        this.urlConnection.setReadTimeout(5000);
        this.urlConnection.connect();
        return this.urlConnection;
    }

    /* access modifiers changed from: protected */
    public BufferedReader getBufferedReader() {
        this.inputStream = this.urlConnection.getInputStream();
        this.inputStreamReader = new InputStreamReader(this.inputStream, StandardCharsets.UTF_8);
        return new BufferedReader(this.inputStreamReader);
    }

    /* access modifiers changed from: protected */
    public void closeHttpConnection() {
        InputStream inputStream2 = this.inputStream;
        if (inputStream2 != null) {
            inputStream2.close();
        }
        InputStreamReader inputStreamReader2 = this.inputStreamReader;
        if (inputStreamReader2 != null) {
            inputStreamReader2.close();
        }
        HttpURLConnection httpURLConnection = this.urlConnection;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        AutelLog.m15084e(TAG, "closeHttpConnection ");
    }

    /* access modifiers changed from: protected */
    public void parserData(String str) {
        CameraMessageDisPatcher.instance().onDisPatchPacket(str);
    }

    public boolean isConnected() {
        try {
            if (this.urlConnection != null) {
                AutelLog.m15084e(TAG, "isConnected getResponseCode " + this.urlConnection.getResponseCode());
                if (this.urlConnection.getResponseCode() == 200) {
                    return true;
                }
                return false;
            }
        } catch (Exception e) {
            AutelLog.m15084e(TAG, "isConnected Exception " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public String loadUrl() {
        return IpConstantUtils.getCameraHttpEventsUrl();
    }
}

package com.autel.util.okhttp;

import android.content.Context;
import atakplugin.UASTool.bqm;
import atakplugin.UASTool.brw;
import com.autel.util.okhttp.callback.ProgressCallBack;
import com.autel.util.okhttp.callback.ResponseCallBack;
import com.autel.util.okhttp.model.FormParams;
import com.autel.util.okhttp.model.Headers;
import com.autel.util.okhttp.model.Mutlipart;
import com.autel.util.okhttp.request.DeleteRequest;
import com.autel.util.okhttp.request.GetRequest;
import com.autel.util.okhttp.request.HeadRequest;
import com.autel.util.okhttp.request.OKCancelable;
import com.autel.util.okhttp.request.PostRequest;
import com.autel.util.okhttp.request.PutRequest;
import java.io.File;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

public class OkHttpManager implements HttpInterface {
    private static final int MAX_CACHESIZE = 10485760;
    private static final int MAX_QEQUEST = 2;
    private int mRetryCount;
    private brw okHttpClient;

    private OkHttpManager(Builder builder) {
        this.okHttpClient = null;
        this.mRetryCount = 0;
        brw c = builder.config.mo3323c();
        this.okHttpClient = c;
        c.mo3290t().mo3134a(2);
        this.mRetryCount = builder.RetryCount;
    }

    public <T> void head(String str, Headers headers, ResponseCallBack<T> responseCallBack) {
        HeadRequest headRequest = new HeadRequest(str, headers);
        headRequest.setRetryCount(this.mRetryCount);
        headRequest.execute(this.okHttpClient, responseCallBack);
    }

    public <T> void get(String str, Headers headers, ResponseCallBack<T> responseCallBack) {
        GetRequest getRequest = new GetRequest(str, headers);
        getRequest.setRetryCount(this.mRetryCount);
        getRequest.execute(this.okHttpClient, responseCallBack);
    }

    public <T> void get(String str, Headers headers, FormParams formParams, ResponseCallBack<T> responseCallBack) {
        GetRequest getRequest = new GetRequest(str, headers, formParams);
        getRequest.setRetryCount(this.mRetryCount);
        getRequest.execute(this.okHttpClient, responseCallBack);
    }

    public <T> void post(String str, Headers headers, FormParams formParams, ResponseCallBack<T> responseCallBack) {
        PostRequest postRequest = new PostRequest(str, headers, formParams);
        postRequest.setRetryCount(this.mRetryCount);
        postRequest.execute(this.okHttpClient, responseCallBack);
    }

    public <T> void post(String str, Headers headers, String str2, String str3, ResponseCallBack<T> responseCallBack) {
        PostRequest postRequest = new PostRequest(str, headers, str2, str3);
        postRequest.setRetryCount(this.mRetryCount);
        postRequest.execute(this.okHttpClient, responseCallBack);
    }

    public <T> void post(String str, Headers headers, String str2, File file, ResponseCallBack<T> responseCallBack) {
        PostRequest postRequest = new PostRequest(str, headers, str2, file, responseCallBack instanceof ProgressCallBack);
        postRequest.setRetryCount(this.mRetryCount);
        postRequest.execute(this.okHttpClient, responseCallBack);
    }

    public <T> void post(String str, Headers headers, String str2, byte[] bArr, ResponseCallBack<T> responseCallBack) {
        PostRequest postRequest = new PostRequest(str, headers, str2, bArr);
        postRequest.setRetryCount(this.mRetryCount);
        postRequest.execute(this.okHttpClient, responseCallBack);
    }

    public <T> void post(String str, Headers headers, Mutlipart mutlipart, ResponseCallBack<T> responseCallBack) {
        PostRequest postRequest = new PostRequest(str, headers, mutlipart, responseCallBack instanceof ProgressCallBack);
        postRequest.setRetryCount(this.mRetryCount);
        postRequest.execute(this.okHttpClient, responseCallBack);
    }

    public <T> void put(String str, Headers headers, FormParams formParams, ResponseCallBack<T> responseCallBack) {
        PutRequest putRequest = new PutRequest(str, headers, formParams);
        putRequest.setRetryCount(this.mRetryCount);
        putRequest.execute(this.okHttpClient, responseCallBack);
    }

    public <T> void put(String str, Headers headers, String str2, String str3, ResponseCallBack<T> responseCallBack) {
        PutRequest putRequest = new PutRequest(str, headers, str2, str3);
        putRequest.setRetryCount(this.mRetryCount);
        putRequest.execute(this.okHttpClient, responseCallBack);
    }

    public <T> void put(String str, Headers headers, String str2, File file, ResponseCallBack<T> responseCallBack) {
        PutRequest putRequest = new PutRequest(str, headers, str2, file, responseCallBack instanceof ProgressCallBack);
        putRequest.setRetryCount(this.mRetryCount);
        putRequest.execute(this.okHttpClient, responseCallBack);
    }

    public <T> void put(String str, Headers headers, String str2, byte[] bArr, ResponseCallBack<T> responseCallBack) {
        PutRequest putRequest = new PutRequest(str, headers, str2, bArr);
        putRequest.setRetryCount(this.mRetryCount);
        putRequest.execute(this.okHttpClient, responseCallBack);
    }

    public <T> void put(String str, Headers headers, Mutlipart mutlipart, ResponseCallBack<T> responseCallBack) {
        PutRequest putRequest = new PutRequest(str, headers, mutlipart, responseCallBack instanceof ProgressCallBack);
        putRequest.setRetryCount(this.mRetryCount);
        putRequest.execute(this.okHttpClient, responseCallBack);
    }

    public <T> void delete(String str, Headers headers, ResponseCallBack<T> responseCallBack) {
        DeleteRequest deleteRequest = new DeleteRequest(str, headers);
        deleteRequest.setRetryCount(this.mRetryCount);
        deleteRequest.execute(this.okHttpClient, responseCallBack);
    }

    public <T> void delete(String str, Headers headers, FormParams formParams, ResponseCallBack<T> responseCallBack) {
        DeleteRequest deleteRequest = new DeleteRequest(str, headers, formParams);
        deleteRequest.setRetryCount(this.mRetryCount);
        deleteRequest.execute(this.okHttpClient, responseCallBack);
    }

    public <T> void delete(String str, Headers headers, String str2, String str3, ResponseCallBack<T> responseCallBack) {
        DeleteRequest deleteRequest = new DeleteRequest(str, headers, str2, str3);
        deleteRequest.setRetryCount(this.mRetryCount);
        deleteRequest.execute(this.okHttpClient, responseCallBack);
    }

    public <T> void delete(String str, Headers headers, String str2, byte[] bArr, ResponseCallBack<T> responseCallBack) {
        DeleteRequest deleteRequest = new DeleteRequest(str, headers, str2, bArr);
        deleteRequest.setRetryCount(this.mRetryCount);
        deleteRequest.execute(this.okHttpClient, responseCallBack);
    }

    public void download(String str, String str2, ResponseCallBack<File> responseCallBack) {
        GetRequest getRequest = new GetRequest(str, (Headers) null);
        getRequest.setRetryCount(this.mRetryCount);
        getRequest.download(this.okHttpClient, str2, true, responseCallBack);
    }

    public void download(String str, String str2, FormParams formParams, ResponseCallBack<File> responseCallBack) {
        download(str, str2, formParams, true, responseCallBack);
    }

    public void download(String str, String str2, boolean z, ResponseCallBack<File> responseCallBack) {
        GetRequest getRequest = new GetRequest(str, (Headers) null);
        getRequest.setRetryCount(this.mRetryCount);
        getRequest.download(this.okHttpClient, str2, z, responseCallBack);
    }

    public void download(String str, String str2, FormParams formParams, boolean z, ResponseCallBack<File> responseCallBack) {
        download(getUrlWithQueryString(str, formParams), str2, z, responseCallBack);
    }

    public OKCancelable downloadCancelable(String str, String str2, ResponseCallBack<File> responseCallBack) {
        GetRequest getRequest = new GetRequest(str, (Headers) null);
        getRequest.setRetryCount(this.mRetryCount);
        getRequest.setCancelable(true);
        getRequest.download(this.okHttpClient, str2, true, responseCallBack);
        return getRequest;
    }

    public OKCancelable downloadCancelable(String str, String str2, FormParams formParams, ResponseCallBack<File> responseCallBack) {
        return downloadCancelable(str, str2, formParams, true, responseCallBack);
    }

    public OKCancelable downloadCancelable(String str, String str2, boolean z, ResponseCallBack<File> responseCallBack) {
        GetRequest getRequest = new GetRequest(str, (Headers) null);
        getRequest.setRetryCount(this.mRetryCount);
        getRequest.setCancelable(true);
        getRequest.download(this.okHttpClient, str2, z, responseCallBack);
        return getRequest;
    }

    public OKCancelable downloadCancelable(String str, String str2, FormParams formParams, boolean z, ResponseCallBack<File> responseCallBack) {
        return downloadCancelable(getUrlWithQueryString(str, formParams), str2, z, responseCallBack);
    }

    public <T> OKCancelable uploadCancelable(String str, Headers headers, FormParams formParams, ResponseCallBack<T> responseCallBack) {
        PostRequest postRequest = new PostRequest(str, headers, formParams);
        postRequest.setRetryCount(this.mRetryCount);
        postRequest.setCancelable(true);
        postRequest.execute(this.okHttpClient, responseCallBack);
        return postRequest;
    }

    public <T> OKCancelable uploadCancelable(String str, Headers headers, String str2, String str3, ResponseCallBack<T> responseCallBack) {
        PostRequest postRequest = new PostRequest(str, headers, str2, str3);
        postRequest.setRetryCount(this.mRetryCount);
        postRequest.setCancelable(true);
        postRequest.execute(this.okHttpClient, responseCallBack);
        return postRequest;
    }

    public <T> OKCancelable uploadCancelable(String str, Headers headers, String str2, File file, ResponseCallBack<T> responseCallBack) {
        PostRequest postRequest = new PostRequest(str, headers, str2, file, responseCallBack instanceof ProgressCallBack);
        postRequest.setRetryCount(this.mRetryCount);
        postRequest.setCancelable(true);
        postRequest.execute(this.okHttpClient, responseCallBack);
        return postRequest;
    }

    public <T> OKCancelable uploadCancelable(String str, Headers headers, String str2, byte[] bArr, ResponseCallBack<T> responseCallBack) {
        PostRequest postRequest = new PostRequest(str, headers, str2, bArr);
        postRequest.setRetryCount(this.mRetryCount);
        postRequest.setCancelable(true);
        postRequest.execute(this.okHttpClient, responseCallBack);
        return postRequest;
    }

    public <T> OKCancelable uploadCancelable(String str, Headers headers, Mutlipart mutlipart, ResponseCallBack<T> responseCallBack) {
        PostRequest postRequest = new PostRequest(str, headers, mutlipart, responseCallBack instanceof ProgressCallBack);
        postRequest.setRetryCount(this.mRetryCount);
        postRequest.setCancelable(true);
        postRequest.execute(this.okHttpClient, responseCallBack);
        return postRequest;
    }

    private String getUrlWithQueryString(String str, FormParams formParams) {
        if (formParams == null) {
            return str;
        }
        String paramString = formParams.getParamString();
        return str + "?" + paramString;
    }

    public static class Builder {
        public int RetryCount = 0;
        public brw.C0231a config = new brw.C0231a();

        public Builder setRetryCount(int i) {
            this.RetryCount = i;
            this.config.mo3322c(true);
            return this;
        }

        public Builder setConnectTimeout(long j, TimeUnit timeUnit) {
            this.config.mo3296a(j, timeUnit);
            return this;
        }

        public Builder setReadTimeout(long j, TimeUnit timeUnit) {
            this.config.mo3315b(j, timeUnit);
            return this;
        }

        public Builder setWriteTimeout(long j, TimeUnit timeUnit) {
            this.config.mo3321c(j, timeUnit);
            return this;
        }

        public Builder setCache(Context context, File file, int i) {
            if (file != null) {
                if (i <= 0 || i > OkHttpManager.MAX_CACHESIZE) {
                    i = OkHttpManager.MAX_CACHESIZE;
                }
                this.config.mo3298a(new bqm(file, (long) i));
            }
            return this;
        }

        public Builder proxy(Proxy proxy) {
            this.config.mo3305a(proxy);
            return this;
        }

        public Builder proxySelector(ProxySelector proxySelector) {
            this.config.mo3306a(proxySelector);
            return this;
        }

        public Builder socketFactory(SocketFactory socketFactory) {
            this.config.mo3308a(socketFactory);
            return this;
        }

        public Builder sslSocketFactory(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
            this.config.mo3311a(sSLSocketFactory, x509TrustManager);
            return this;
        }

        public Builder hostnameVerifier(HostnameVerifier hostnameVerifier) {
            this.config.mo3309a(hostnameVerifier);
            return this;
        }

        public OkHttpManager build() {
            return new OkHttpManager(this);
        }
    }
}

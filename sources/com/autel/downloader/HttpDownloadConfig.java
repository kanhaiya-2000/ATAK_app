package com.autel.downloader;

import com.autel.downloader.client.IHttpClientInterface;

public class HttpDownloadConfig {
    private IHttpClientInterface mHttpClient;
    private int mMaxThread;

    /* access modifiers changed from: private */
    public void setDebug(boolean z) {
    }

    private HttpDownloadConfig() {
        this.mMaxThread = 0;
    }

    /* access modifiers changed from: private */
    public void setMaxThread(int i) {
        this.mMaxThread = i;
    }

    public int getMaxThread() {
        return this.mMaxThread;
    }

    /* access modifiers changed from: private */
    public void setClient(IHttpClientInterface iHttpClientInterface) {
        this.mHttpClient = iHttpClientInterface;
    }

    public IHttpClientInterface getClient() {
        return this.mHttpClient;
    }

    public static class Builder {
        private IHttpClientInterface client = null;
        private boolean debug = false;
        private int maxThread = 0;

        public Builder setMaxThread(int i) {
            this.maxThread = i;
            return this;
        }

        public Builder setDebug(boolean z) {
            this.debug = z;
            return this;
        }

        public Builder setClient(IHttpClientInterface iHttpClientInterface) {
            this.client = iHttpClientInterface;
            return this;
        }

        public HttpDownloadConfig build() {
            HttpDownloadConfig httpDownloadConfig = new HttpDownloadConfig();
            httpDownloadConfig.setMaxThread(this.maxThread);
            httpDownloadConfig.setDebug(this.debug);
            httpDownloadConfig.setClient(this.client);
            return httpDownloadConfig;
        }
    }
}

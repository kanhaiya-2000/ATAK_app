package com.autel.util.okhttp.model;

import android.util.Log;
import atakplugin.UASTool.bru;
import atakplugin.UASTool.bsd;
import atakplugin.UASTool.bwl;
import atakplugin.UASTool.bwo;
import atakplugin.UASTool.bws;
import atakplugin.UASTool.bxb;
import atakplugin.UASTool.bxp;

public class UploadRequestBody extends bsd {
    /* access modifiers changed from: private */
    public ProgressListener callBack;
    protected bsd delegate;

    public interface ProgressListener {
        void Progress(long j, long j2);
    }

    public UploadRequestBody(bsd bsd, ProgressListener progressListener) {
        this.delegate = bsd;
        this.callBack = progressListener;
    }

    public long contentLength() {
        return this.delegate.contentLength();
    }

    public bru contentType() {
        return this.delegate.contentType();
    }

    public void writeTo(bwo bwo) {
        bwo a = bxb.m10329a((bxp) new UploadSink(bwo, contentLength()));
        this.delegate.writeTo(a);
        a.flush();
    }

    private class UploadSink extends bws {
        private static final String TAG = "UploadSink";
        private long sendLength = 0;
        private long totalLength = 0;

        public UploadSink(bxp bxp, long j) {
            super(bxp);
            this.totalLength = j;
        }

        public void write(bwl bwl, long j) {
            super.write(bwl, j);
            this.sendLength += j;
            Log.d(TAG, "uploading...,send:" + this.sendLength + ",totalLength:" + this.totalLength);
            if (UploadRequestBody.this.callBack != null) {
                UploadRequestBody.this.callBack.Progress(this.sendLength, this.totalLength);
            }
        }
    }
}

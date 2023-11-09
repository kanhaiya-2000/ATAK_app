package com.autel.util.okhttp.request;

import android.util.Log;
import atakplugin.UASTool.bqt;
import atakplugin.UASTool.bqu;
import atakplugin.UASTool.brw;
import atakplugin.UASTool.bsb;
import com.autel.internal.sdk.product.datapost.MsgPostManager;
import com.autel.internal.sdk.product.datapost.PostRunnable;
import com.autel.util.okhttp.callback.ProgressCallBack;
import com.autel.util.okhttp.callback.ResponseCallBack;
import com.autel.util.okhttp.callback.ResponseInterface;
import com.autel.util.okhttp.model.Headers;
import com.autel.util.okhttp.model.UploadRequestBody;
import com.autel.util.okhttp.utils.RequestFactory;
import java.io.File;
import java.io.IOException;

public abstract class BaseRequest implements UploadRequestBody.ProgressListener, OKCancelable {
    private static final String TAG = "BaseRequest";
    /* access modifiers changed from: private */
    public ResponseCallBack callBack = null;
    private boolean cancelable = false;
    private Boolean hasCancel = false;
    protected bqt httpCall;
    private int mRetryCount = 0;
    private int mRetryNum = 0;
    private bsb request = null;

    /* access modifiers changed from: protected */
    public abstract bsb getRequest();

    /* access modifiers changed from: protected */
    public bsb.C0234a generateRequestBuilder(String str, Headers headers) {
        bsb.C0234a aVar = new bsb.C0234a();
        aVar.mo3360a(str);
        if (headers != null) {
            aVar.mo3356a(RequestFactory.generateHeaders(headers));
        }
        return aVar;
    }

    /* access modifiers changed from: private */
    public boolean retry(brw brw, bqu bqu) {
        int i = this.mRetryNum;
        if (i >= this.mRetryCount) {
            return false;
        }
        this.mRetryNum = i + 1;
        brw.mo3060a(this.request).mo3055a(bqu);
        return true;
    }

    public void setRetryCount(int i) {
        this.mRetryCount = i;
    }

    public <T> void download(brw brw, String str, boolean z, ResponseCallBack<T> responseCallBack) {
        execute(brw, str, z, responseCallBack);
    }

    /* access modifiers changed from: private */
    public boolean executeDownload(String str, boolean z, ResponseInterface responseInterface, final ResponseCallBack responseCallBack) {
        if (responseCallBack == null) {
            return false;
        }
        final File file = new File(str);
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            Log.d(TAG, "parent path:" + parentFile.getAbsolutePath());
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            if (!file.createNewFile()) {
                return false;
            }
        } else if (!z && responseInterface.getContentLength() == file.length()) {
            MsgPostManager.instance().post(new PostRunnable() {
                /* access modifiers changed from: protected */
                public void task() {
                    Log.d(BaseRequest.TAG, "file is exist, and repeat is false, not download again!");
                    ResponseCallBack responseCallBack = responseCallBack;
                    if (responseCallBack != null) {
                        responseCallBack.onSuccess(file);
                    }
                }
            });
            return true;
        }
        return executeDownload(file, responseInterface, responseCallBack);
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x008a A[SYNTHETIC, Splitter:B:32:0x008a] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0094 A[SYNTHETIC, Splitter:B:37:0x0094] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a3 A[SYNTHETIC, Splitter:B:46:0x00a3] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00ad A[SYNTHETIC, Splitter:B:51:0x00ad] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b8 A[SYNTHETIC, Splitter:B:57:0x00b8] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00c2 A[SYNTHETIC, Splitter:B:62:0x00c2] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:29:0x0085=Splitter:B:29:0x0085, B:43:0x009e=Splitter:B:43:0x009e} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean executeDownload(final java.io.File r12, com.autel.util.okhttp.callback.ResponseInterface r13, final com.autel.util.okhttp.callback.ResponseCallBack r14) {
        /*
            r11 = this;
            java.io.InputStream r0 = r13.getInputStream()
            java.lang.String r1 = "BaseRequest"
            java.lang.String r2 = "executeDownload"
            android.util.Log.d(r1, r2)
            r2 = 0
            r3 = 0
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x009d, IOException -> 0x0084 }
            r4.<init>(r12)     // Catch:{ FileNotFoundException -> 0x009d, IOException -> 0x0084 }
            long r5 = r13.getContentLength()     // Catch:{ FileNotFoundException -> 0x007f, IOException -> 0x007c, all -> 0x0079 }
            r13 = 1024(0x400, float:1.435E-42)
            byte[] r3 = new byte[r13]     // Catch:{ FileNotFoundException -> 0x007f, IOException -> 0x007c, all -> 0x0079 }
            r7 = 0
        L_0x001b:
            int r8 = r0.read(r3, r2, r13)     // Catch:{ FileNotFoundException -> 0x007f, IOException -> 0x007c, all -> 0x0079 }
            if (r8 <= 0) goto L_0x0047
            r4.write(r3, r2, r8)     // Catch:{ FileNotFoundException -> 0x007f, IOException -> 0x007c, all -> 0x0079 }
            int r7 = r7 + r8
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x007f, IOException -> 0x007c, all -> 0x0079 }
            r8.<init>()     // Catch:{ FileNotFoundException -> 0x007f, IOException -> 0x007c, all -> 0x0079 }
            java.lang.String r9 = ""
            r8.append(r9)     // Catch:{ FileNotFoundException -> 0x007f, IOException -> 0x007c, all -> 0x0079 }
            int r9 = r7 * 100
            long r9 = (long) r9     // Catch:{ FileNotFoundException -> 0x007f, IOException -> 0x007c, all -> 0x0079 }
            long r9 = r9 / r5
            r8.append(r9)     // Catch:{ FileNotFoundException -> 0x007f, IOException -> 0x007c, all -> 0x0079 }
            java.lang.String r9 = "%"
            r8.append(r9)     // Catch:{ FileNotFoundException -> 0x007f, IOException -> 0x007c, all -> 0x0079 }
            java.lang.String r8 = r8.toString()     // Catch:{ FileNotFoundException -> 0x007f, IOException -> 0x007c, all -> 0x0079 }
            android.util.Log.d(r1, r8)     // Catch:{ FileNotFoundException -> 0x007f, IOException -> 0x007c, all -> 0x0079 }
            long r8 = (long) r7     // Catch:{ FileNotFoundException -> 0x007f, IOException -> 0x007c, all -> 0x0079 }
            r11.Progress(r8, r5)     // Catch:{ FileNotFoundException -> 0x007f, IOException -> 0x007c, all -> 0x0079 }
            goto L_0x001b
        L_0x0047:
            long r7 = (long) r7     // Catch:{ FileNotFoundException -> 0x007f, IOException -> 0x007c, all -> 0x0079 }
            int r13 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r13 != 0) goto L_0x0059
            com.autel.internal.sdk.product.datapost.MsgPostManager r13 = com.autel.internal.sdk.product.datapost.MsgPostManager.instance()     // Catch:{ FileNotFoundException -> 0x007f, IOException -> 0x007c, all -> 0x0079 }
            com.autel.util.okhttp.request.BaseRequest$2 r1 = new com.autel.util.okhttp.request.BaseRequest$2     // Catch:{ FileNotFoundException -> 0x007f, IOException -> 0x007c, all -> 0x0079 }
            r1.<init>(r14, r12)     // Catch:{ FileNotFoundException -> 0x007f, IOException -> 0x007c, all -> 0x0079 }
            r13.post(r1)     // Catch:{ FileNotFoundException -> 0x007f, IOException -> 0x007c, all -> 0x0079 }
            goto L_0x0065
        L_0x0059:
            com.autel.internal.sdk.product.datapost.MsgPostManager r12 = com.autel.internal.sdk.product.datapost.MsgPostManager.instance()     // Catch:{ FileNotFoundException -> 0x007f, IOException -> 0x007c, all -> 0x0079 }
            com.autel.util.okhttp.request.BaseRequest$3 r13 = new com.autel.util.okhttp.request.BaseRequest$3     // Catch:{ FileNotFoundException -> 0x007f, IOException -> 0x007c, all -> 0x0079 }
            r13.<init>(r14)     // Catch:{ FileNotFoundException -> 0x007f, IOException -> 0x007c, all -> 0x0079 }
            r12.post(r13)     // Catch:{ FileNotFoundException -> 0x007f, IOException -> 0x007c, all -> 0x0079 }
        L_0x0065:
            r4.close()     // Catch:{ IOException -> 0x0069 }
            goto L_0x006d
        L_0x0069:
            r12 = move-exception
            r12.printStackTrace()
        L_0x006d:
            if (r0 == 0) goto L_0x0077
            r0.close()     // Catch:{ IOException -> 0x0073 }
            goto L_0x0077
        L_0x0073:
            r12 = move-exception
            r12.printStackTrace()
        L_0x0077:
            r12 = 1
            return r12
        L_0x0079:
            r12 = move-exception
            r3 = r4
            goto L_0x00b6
        L_0x007c:
            r12 = move-exception
            r3 = r4
            goto L_0x0085
        L_0x007f:
            r12 = move-exception
            r3 = r4
            goto L_0x009e
        L_0x0082:
            r12 = move-exception
            goto L_0x00b6
        L_0x0084:
            r12 = move-exception
        L_0x0085:
            r12.printStackTrace()     // Catch:{ all -> 0x0082 }
            if (r3 == 0) goto L_0x0092
            r3.close()     // Catch:{ IOException -> 0x008e }
            goto L_0x0092
        L_0x008e:
            r12 = move-exception
            r12.printStackTrace()
        L_0x0092:
            if (r0 == 0) goto L_0x009c
            r0.close()     // Catch:{ IOException -> 0x0098 }
            goto L_0x009c
        L_0x0098:
            r12 = move-exception
            r12.printStackTrace()
        L_0x009c:
            return r2
        L_0x009d:
            r12 = move-exception
        L_0x009e:
            r12.printStackTrace()     // Catch:{ all -> 0x0082 }
            if (r3 == 0) goto L_0x00ab
            r3.close()     // Catch:{ IOException -> 0x00a7 }
            goto L_0x00ab
        L_0x00a7:
            r12 = move-exception
            r12.printStackTrace()
        L_0x00ab:
            if (r0 == 0) goto L_0x00b5
            r0.close()     // Catch:{ IOException -> 0x00b1 }
            goto L_0x00b5
        L_0x00b1:
            r12 = move-exception
            r12.printStackTrace()
        L_0x00b5:
            return r2
        L_0x00b6:
            if (r3 == 0) goto L_0x00c0
            r3.close()     // Catch:{ IOException -> 0x00bc }
            goto L_0x00c0
        L_0x00bc:
            r13 = move-exception
            r13.printStackTrace()
        L_0x00c0:
            if (r0 == 0) goto L_0x00ca
            r0.close()     // Catch:{ IOException -> 0x00c6 }
            goto L_0x00ca
        L_0x00c6:
            r13 = move-exception
            r13.printStackTrace()
        L_0x00ca:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autel.util.okhttp.request.BaseRequest.executeDownload(java.io.File, com.autel.util.okhttp.callback.ResponseInterface, com.autel.util.okhttp.callback.ResponseCallBack):boolean");
    }

    public <T> void execute(brw brw, ResponseCallBack<T> responseCallBack) {
        execute(brw, (String) null, false, responseCallBack);
    }

    private <T> void execute(brw brw, String str, boolean z, ResponseCallBack<T> responseCallBack) {
        this.callBack = responseCallBack;
        this.request = getRequest();
        if (brw != null) {
            responseCallBack.onStart();
            final brw brw2 = brw;
            final ResponseCallBack<T> responseCallBack2 = responseCallBack;
            final String str2 = str;
            final boolean z2 = z;
            brw.mo3060a(this.request).mo3055a(new bqu() {
                public void onFailure(bqt bqt, final IOException iOException) {
                    Log.d(BaseRequest.TAG, bqt.toString() + " -----onFailure: : " + iOException.toString());
                    if (!BaseRequest.this.retry(brw2, this)) {
                        MsgPostManager.instance().post(new PostRunnable() {
                            /* access modifiers changed from: protected */
                            public void task() {
                                if (responseCallBack2 != null) {
                                    responseCallBack2.onFailure(iOException);
                                }
                            }
                        });
                    }
                }

                /* JADX WARNING: Removed duplicated region for block: B:32:0x00ae  */
                /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void onResponse(atakplugin.UASTool.bqt r5, final atakplugin.UASTool.bsh r6) {
                    /*
                        r4 = this;
                        if (r6 == 0) goto L_0x0074
                        boolean r5 = r6.mo3380d()     // Catch:{ all -> 0x0072 }
                        if (r5 == 0) goto L_0x0074
                        com.autel.util.okhttp.model.OkHttpResponse r5 = new com.autel.util.okhttp.model.OkHttpResponse     // Catch:{ all -> 0x0072 }
                        r5.<init>(r6)     // Catch:{ all -> 0x0072 }
                        com.autel.util.okhttp.callback.ResponseCallBack r0 = r4     // Catch:{ all -> 0x0072 }
                        boolean r0 = r0.onInterrupt(r5)     // Catch:{ all -> 0x0072 }
                        if (r0 != 0) goto L_0x00ac
                        java.lang.String r0 = r5     // Catch:{ all -> 0x0072 }
                        if (r0 == 0) goto L_0x0044
                        com.autel.util.okhttp.request.BaseRequest r1 = com.autel.util.okhttp.request.BaseRequest.this     // Catch:{ Exception -> 0x0033 }
                        boolean r2 = r6     // Catch:{ Exception -> 0x0033 }
                        com.autel.util.okhttp.callback.ResponseCallBack r3 = r4     // Catch:{ Exception -> 0x0033 }
                        boolean r5 = r1.executeDownload(r0, r2, r5, r3)     // Catch:{ Exception -> 0x0033 }
                        if (r5 != 0) goto L_0x00ac
                        com.autel.util.okhttp.callback.ResponseCallBack r5 = r4     // Catch:{ Exception -> 0x0033 }
                        java.lang.Throwable r0 = new java.lang.Throwable     // Catch:{ Exception -> 0x0033 }
                        java.lang.String r1 = "##download fail."
                        r0.<init>(r1)     // Catch:{ Exception -> 0x0033 }
                        r5.onFailure(r0)     // Catch:{ Exception -> 0x0033 }
                        goto L_0x00ac
                    L_0x0033:
                        r5 = move-exception
                        r5.printStackTrace()     // Catch:{ all -> 0x0072 }
                        com.autel.internal.sdk.product.datapost.MsgPostManager r0 = com.autel.internal.sdk.product.datapost.MsgPostManager.instance()     // Catch:{ all -> 0x0072 }
                        com.autel.util.okhttp.request.BaseRequest$4$2 r1 = new com.autel.util.okhttp.request.BaseRequest$4$2     // Catch:{ all -> 0x0072 }
                        r1.<init>(r5)     // Catch:{ all -> 0x0072 }
                        r0.post(r1)     // Catch:{ all -> 0x0072 }
                        goto L_0x00ac
                    L_0x0044:
                        com.autel.util.okhttp.callback.ResponseCallBack r0 = r4     // Catch:{ Exception -> 0x0057 }
                        java.lang.Object r5 = r0.convert(r5)     // Catch:{ Exception -> 0x0057 }
                        com.autel.internal.sdk.product.datapost.MsgPostManager r0 = com.autel.internal.sdk.product.datapost.MsgPostManager.instance()     // Catch:{ Exception -> 0x0057 }
                        com.autel.util.okhttp.request.BaseRequest$4$3 r1 = new com.autel.util.okhttp.request.BaseRequest$4$3     // Catch:{ Exception -> 0x0057 }
                        r1.<init>(r5)     // Catch:{ Exception -> 0x0057 }
                        r0.post(r1)     // Catch:{ Exception -> 0x0057 }
                        goto L_0x00ac
                    L_0x0057:
                        r5 = move-exception
                        r5.printStackTrace()     // Catch:{ all -> 0x0072 }
                        com.autel.util.okhttp.request.BaseRequest r0 = com.autel.util.okhttp.request.BaseRequest.this     // Catch:{ all -> 0x0072 }
                        atakplugin.UASTool.brw r1 = r3     // Catch:{ all -> 0x0072 }
                        boolean r0 = r0.retry(r1, r4)     // Catch:{ all -> 0x0072 }
                        if (r0 != 0) goto L_0x00ac
                        com.autel.internal.sdk.product.datapost.MsgPostManager r0 = com.autel.internal.sdk.product.datapost.MsgPostManager.instance()     // Catch:{ all -> 0x0072 }
                        com.autel.util.okhttp.request.BaseRequest$4$4 r1 = new com.autel.util.okhttp.request.BaseRequest$4$4     // Catch:{ all -> 0x0072 }
                        r1.<init>(r5)     // Catch:{ all -> 0x0072 }
                        r0.post(r1)     // Catch:{ all -> 0x0072 }
                        goto L_0x00ac
                    L_0x0072:
                        r5 = move-exception
                        goto L_0x00b2
                    L_0x0074:
                        java.lang.String r5 = "BaseRequest"
                        if (r6 == 0) goto L_0x0091
                        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0072 }
                        r0.<init>()     // Catch:{ all -> 0x0072 }
                        java.lang.String r1 = "response fail"
                        r0.append(r1)     // Catch:{ all -> 0x0072 }
                        int r1 = r6.mo3378c()     // Catch:{ all -> 0x0072 }
                        r0.append(r1)     // Catch:{ all -> 0x0072 }
                        java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0072 }
                        android.util.Log.d(r5, r0)     // Catch:{ all -> 0x0072 }
                        goto L_0x0096
                    L_0x0091:
                        java.lang.String r0 = "response fail : response == null"
                        android.util.Log.d(r5, r0)     // Catch:{ all -> 0x0072 }
                    L_0x0096:
                        com.autel.util.okhttp.request.BaseRequest r5 = com.autel.util.okhttp.request.BaseRequest.this     // Catch:{ all -> 0x0072 }
                        atakplugin.UASTool.brw r0 = r3     // Catch:{ all -> 0x0072 }
                        boolean r5 = r5.retry(r0, r4)     // Catch:{ all -> 0x0072 }
                        if (r5 != 0) goto L_0x00ac
                        com.autel.internal.sdk.product.datapost.MsgPostManager r5 = com.autel.internal.sdk.product.datapost.MsgPostManager.instance()     // Catch:{ all -> 0x0072 }
                        com.autel.util.okhttp.request.BaseRequest$4$5 r0 = new com.autel.util.okhttp.request.BaseRequest$4$5     // Catch:{ all -> 0x0072 }
                        r0.<init>(r6)     // Catch:{ all -> 0x0072 }
                        r5.post(r0)     // Catch:{ all -> 0x0072 }
                    L_0x00ac:
                        if (r6 == 0) goto L_0x00b1
                        r6.close()
                    L_0x00b1:
                        return
                    L_0x00b2:
                        if (r6 == 0) goto L_0x00b7
                        r6.close()
                    L_0x00b7:
                        throw r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.autel.util.okhttp.request.BaseRequest.C50804.onResponse(atakplugin.UASTool.bqt, atakplugin.UASTool.bsh):void");
                }
            });
        }
    }

    public void Progress(long j, long j2) {
        ResponseCallBack responseCallBack = this.callBack;
        if (responseCallBack != null && (responseCallBack instanceof ProgressCallBack)) {
            final long j3 = j;
            final long j4 = j2;
            MsgPostManager.instance().post(new PostRunnable() {
                /* access modifiers changed from: protected */
                public void task() {
                    Log.d(BaseRequest.TAG, "" + ((j3 * 100) / j4) + "%");
                    if (BaseRequest.this.callBack != null) {
                        ((ProgressCallBack) BaseRequest.this.callBack).Progress(j3, j4);
                    }
                }
            });
        }
    }

    public boolean isCancelable() {
        return this.cancelable;
    }

    public void setCancelable(boolean z) {
        this.cancelable = z;
    }

    public void cancel() {
        synchronized (this.hasCancel) {
            if (this.cancelable) {
                this.hasCancel = true;
                bqt bqt = this.httpCall;
                if (bqt != null) {
                    bqt.mo3057c();
                }
            }
        }
    }
}

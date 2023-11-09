package com.autel.util.okhttp.request;

import atakplugin.UASTool.bsb;
import atakplugin.UASTool.bsd;
import com.autel.util.okhttp.model.FormParams;
import com.autel.util.okhttp.model.Headers;
import com.autel.util.okhttp.model.Mutlipart;
import com.autel.util.okhttp.model.UploadRequestBody;
import com.autel.util.okhttp.utils.RequestFactory;
import java.io.File;

public class PostRequest extends BaseRequest {
    private static final String TAG = "PostRequest";
    private bsb.C0234a mBuilder = null;

    public PostRequest(String str, Headers headers, FormParams formParams) {
        this.mBuilder = generateRequestBuilder(str, headers);
        this.mBuilder.mo3358a(RequestFactory.generateRequestBody((String) null, formParams));
    }

    public PostRequest(String str, Headers headers, String str2, String str3) {
        this.mBuilder = generateRequestBuilder(str, headers);
        this.mBuilder.mo3358a(RequestFactory.generateRequestBody(str2, str3));
    }

    public PostRequest(String str, Headers headers, String str2, File file, boolean z) {
        this.mBuilder = generateRequestBuilder(str, headers);
        bsd generateRequestBody = RequestFactory.generateRequestBody(str2, file);
        this.mBuilder.mo3358a(z ? new UploadRequestBody(generateRequestBody, this) : generateRequestBody);
    }

    public PostRequest(String str, Headers headers, String str2, byte[] bArr) {
        this.mBuilder = generateRequestBuilder(str, headers);
        this.mBuilder.mo3358a(RequestFactory.generateRequestBody(str2, bArr));
    }

    public PostRequest(String str, Headers headers, Mutlipart mutlipart, boolean z) {
        this.mBuilder = generateRequestBuilder(str, headers);
        if (mutlipart != null) {
            bsd generateBody = mutlipart.generateBody();
            this.mBuilder.mo3358a(z ? new UploadRequestBody(generateBody, this) : generateBody);
        }
    }

    /* access modifiers changed from: protected */
    public bsb getRequest() {
        return this.mBuilder.mo3371d();
    }
}

package com.autel.util.okhttp.request;

import atakplugin.UASTool.bsb;
import com.autel.util.okhttp.model.FormParams;
import com.autel.util.okhttp.model.Headers;
import com.autel.util.okhttp.utils.RequestFactory;

public class DeleteRequest extends BaseRequest {
    private static final String TAG = "PutRequest";
    private bsb.C0234a mBuilder = null;

    public DeleteRequest(String str, Headers headers) {
        bsb.C0234a generateRequestBuilder = generateRequestBuilder(str, headers);
        this.mBuilder = generateRequestBuilder;
        generateRequestBuilder.mo3368c();
    }

    public DeleteRequest(String str, Headers headers, FormParams formParams) {
        this.mBuilder = generateRequestBuilder(str, headers);
        this.mBuilder.mo3365b(RequestFactory.generateRequestBody((String) null, formParams));
    }

    public DeleteRequest(String str, Headers headers, String str2, String str3) {
        this.mBuilder = generateRequestBuilder(str, headers);
        this.mBuilder.mo3365b(RequestFactory.generateRequestBody(str2, str3));
    }

    public DeleteRequest(String str, Headers headers, String str2, byte[] bArr) {
        this.mBuilder = generateRequestBuilder(str, headers);
        this.mBuilder.mo3365b(RequestFactory.generateRequestBody(str2, bArr));
    }

    /* access modifiers changed from: protected */
    public bsb getRequest() {
        return this.mBuilder.mo3371d();
    }
}

package com.autel.util.okhttp.request;

import atakplugin.UASTool.bsb;
import com.autel.util.okhttp.model.FormParams;
import com.autel.util.okhttp.model.Headers;

public class HeadRequest extends BaseRequest {
    private static final String TAG = "GetRequest";
    private bsb.C0234a mBuilder = null;

    public HeadRequest(String str, Headers headers) {
        bsb.C0234a generateRequestBuilder = generateRequestBuilder(str, headers);
        this.mBuilder = generateRequestBuilder;
        generateRequestBuilder.mo3364b();
    }

    public HeadRequest(String str, Headers headers, FormParams formParams) {
        bsb.C0234a generateRequestBuilder = generateRequestBuilder(getUrlWithQueryString(str, formParams), headers);
        this.mBuilder = generateRequestBuilder;
        generateRequestBuilder.mo3364b();
    }

    private String getUrlWithQueryString(String str, FormParams formParams) {
        if (formParams == null) {
            return str;
        }
        String paramString = formParams.getParamString();
        return str + "?" + paramString;
    }

    /* access modifiers changed from: protected */
    public bsb getRequest() {
        return this.mBuilder.mo3371d();
    }
}

package com.autel.util.okhttp.request;

import atakplugin.UASTool.bsb;
import com.autel.util.okhttp.model.FormParams;
import com.autel.util.okhttp.model.Headers;

public class GetRequest extends BaseRequest {
    private static final String TAG = "GetRequest";
    private bsb.C0234a mBuilder = null;

    public GetRequest(String str, Headers headers) {
        this.mBuilder = generateRequestBuilder(str, headers);
    }

    public GetRequest(String str, Headers headers, FormParams formParams) {
        this.mBuilder = generateRequestBuilder(getUrlWithQueryString(str, formParams), headers);
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

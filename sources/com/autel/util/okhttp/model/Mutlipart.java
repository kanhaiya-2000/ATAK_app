package com.autel.util.okhttp.model;

import atakplugin.UASTool.bru;
import atakplugin.UASTool.brv;
import atakplugin.UASTool.bsd;
import com.autel.util.okhttp.utils.RequestFactory;
import java.io.File;
import java.io.InputStream;

public class Mutlipart {
    private brv.C0229a mBuilder;

    public Mutlipart() {
        this.mBuilder = new brv.C0229a();
    }

    public Mutlipart(String str) {
        this.mBuilder = new brv.C0229a(str);
    }

    public Mutlipart setType(String str) {
        this.mBuilder.mo3265a(bru.m8896a(str));
        return this;
    }

    public Mutlipart addPart(String str, String str2) {
        this.mBuilder.mo3268a(str, str2);
        return this;
    }

    public Mutlipart addPart(Headers headers, String str, String str2) {
        bsd generateRequestBody = RequestFactory.generateRequestBody(str, str2);
        if (headers != null) {
            this.mBuilder.mo3264a(RequestFactory.generateHeaders(headers), generateRequestBody);
        } else {
            this.mBuilder.mo3267a(generateRequestBody);
        }
        return this;
    }

    public Mutlipart addPart(Headers headers, String str, byte[] bArr) {
        bsd generateRequestBody = RequestFactory.generateRequestBody(str, bArr);
        if (headers != null) {
            this.mBuilder.mo3264a(RequestFactory.generateHeaders(headers), generateRequestBody);
        } else {
            this.mBuilder.mo3267a(generateRequestBody);
        }
        return this;
    }

    public Mutlipart addPart(String str, String str2, String str3, File file) {
        this.mBuilder.mo3269a(str, str2, RequestFactory.generateRequestBody(str3, file));
        return this;
    }

    public Mutlipart addPart(String str, String str2, String str3, InputStream inputStream) {
        this.mBuilder.mo3269a(str, str2, RequestFactory.generateRequestBody(str3, inputStream));
        return this;
    }

    public brv generateBody() {
        return this.mBuilder.mo3270a();
    }
}

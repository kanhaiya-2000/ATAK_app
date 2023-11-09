package com.autel.util.okhttp.model;

import atakplugin.UASTool.bsh;
import atakplugin.UASTool.bsp;
import com.autel.util.okhttp.callback.ResponseInterface;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class OkHttpResponse implements ResponseInterface {
    private bsh response = null;
    private byte[] responseByte = null;
    private long responseLength = 0;
    private String responseStr = null;
    private InputStream responseStream = null;

    public OkHttpResponse(bsh bsh) {
        this.response = bsh;
        this.responseLength = bsh.mo3384h().mo3017b();
    }

    public boolean isSuccess() {
        bsh bsh = this.response;
        if (bsh != null) {
            return bsh.mo3380d();
        }
        return false;
    }

    public int getCode() {
        bsh bsh = this.response;
        if (bsh != null) {
            return bsh.mo3378c();
        }
        return 0;
    }

    public long getContentLength() {
        return this.responseLength;
    }

    public String getHead(String str) {
        bsh bsh = this.response;
        return bsh != null ? bsh.mo3377b(str) : "";
    }

    public String getString() {
        if (this.responseStr == null) {
            this.responseStr = new String(getBytes(), bsp.f3584c);
        }
        return this.responseStr;
    }

    public InputStream getInputStream() {
        if (this.responseStream == null) {
            this.responseStream = this.response.mo3384h().mo3412d();
            if (this.response.mo3384h().mo3017b() <= 0) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(getBytes());
                this.responseStream = byteArrayInputStream;
                this.responseLength = (long) byteArrayInputStream.available();
            }
        }
        return this.responseStream;
    }

    public byte[] getBytes() {
        if (this.responseByte == null) {
            this.responseByte = this.response.mo3384h().mo3413e();
        }
        return this.responseByte;
    }
}

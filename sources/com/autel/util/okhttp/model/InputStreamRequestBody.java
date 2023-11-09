package com.autel.util.okhttp.model;

import atakplugin.UASTool.bru;
import atakplugin.UASTool.bsd;
import atakplugin.UASTool.bsp;
import atakplugin.UASTool.bwo;
import atakplugin.UASTool.bxb;
import atakplugin.UASTool.bxr;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class InputStreamRequestBody {
    public static bsd create(final bru bru, final InputStream inputStream) {
        Objects.requireNonNull(inputStream, "content == null");
        return new bsd() {
            public bru contentType() {
                return bru.this;
            }

            public long contentLength() {
                try {
                    return (long) inputStream.available();
                } catch (IOException e) {
                    e.printStackTrace();
                    return 0;
                }
            }

            public void writeTo(bwo bwo) {
                bxr bxr = null;
                try {
                    bxr = bxb.m10338a(inputStream);
                    bwo.mo3789a(bxr);
                } finally {
                    bsp.m9158a((Closeable) bxr);
                }
            }
        };
    }
}

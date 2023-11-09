package com.google.common.p011io;

import atakplugin.UASTool.cij;
import com.google.common.base.Preconditions;
import java.io.InputStream;
import java.util.Iterator;

/* renamed from: com.google.common.io.MultiInputStream */
final class MultiInputStream extends InputStream {
    @cij

    /* renamed from: in */
    private InputStream f8591in;

    /* renamed from: it */
    private Iterator<? extends ByteSource> f8592it;

    public boolean markSupported() {
        return false;
    }

    public MultiInputStream(Iterator<? extends ByteSource> it) {
        this.f8592it = (Iterator) Preconditions.checkNotNull(it);
        advance();
    }

    public void close() {
        InputStream inputStream = this.f8591in;
        if (inputStream != null) {
            try {
                inputStream.close();
            } finally {
                this.f8591in = null;
            }
        }
    }

    private void advance() {
        close();
        if (this.f8592it.hasNext()) {
            this.f8591in = ((ByteSource) this.f8592it.next()).openStream();
        }
    }

    public int available() {
        InputStream inputStream = this.f8591in;
        if (inputStream == null) {
            return 0;
        }
        return inputStream.available();
    }

    public int read() {
        while (true) {
            InputStream inputStream = this.f8591in;
            if (inputStream == null) {
                return -1;
            }
            int read = inputStream.read();
            if (read != -1) {
                return read;
            }
            advance();
        }
    }

    public int read(@cij byte[] bArr, int i, int i2) {
        while (true) {
            InputStream inputStream = this.f8591in;
            if (inputStream == null) {
                return -1;
            }
            int read = inputStream.read(bArr, i, i2);
            if (read != -1) {
                return read;
            }
            advance();
        }
    }

    public long skip(long j) {
        InputStream inputStream = this.f8591in;
        if (inputStream == null || j <= 0) {
            return 0;
        }
        long skip = inputStream.skip(j);
        if (skip != 0) {
            return skip;
        }
        if (read() == -1) {
            return 0;
        }
        return this.f8591in.skip(j - 1) + 1;
    }
}

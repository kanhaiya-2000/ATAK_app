package com.google.common.p011io;

import atakplugin.UASTool.cij;
import com.google.common.base.Preconditions;
import java.io.Reader;
import java.util.Iterator;

/* renamed from: com.google.common.io.MultiReader */
class MultiReader extends Reader {
    @cij
    private Reader current;

    /* renamed from: it */
    private final Iterator<? extends CharSource> f8593it;

    MultiReader(Iterator<? extends CharSource> it) {
        this.f8593it = it;
        advance();
    }

    private void advance() {
        close();
        if (this.f8593it.hasNext()) {
            this.current = ((CharSource) this.f8593it.next()).openStream();
        }
    }

    public int read(@cij char[] cArr, int i, int i2) {
        Reader reader = this.current;
        if (reader == null) {
            return -1;
        }
        int read = reader.read(cArr, i, i2);
        if (read != -1) {
            return read;
        }
        advance();
        return read(cArr, i, i2);
    }

    public long skip(long j) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        Preconditions.checkArgument(i >= 0, "n is negative");
        if (i > 0) {
            while (true) {
                Reader reader = this.current;
                if (reader == null) {
                    break;
                }
                long skip = reader.skip(j);
                if (skip > 0) {
                    return skip;
                }
                advance();
            }
        }
        return 0;
    }

    public boolean ready() {
        Reader reader = this.current;
        return reader != null && reader.ready();
    }

    public void close() {
        Reader reader = this.current;
        if (reader != null) {
            try {
                reader.close();
            } finally {
                this.current = null;
            }
        }
    }
}

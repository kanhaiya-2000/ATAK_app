package com.google.common.p011io;

import atakplugin.UASTool.cij;
import com.google.common.base.Preconditions;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

/* renamed from: com.google.common.io.AppendableWriter */
class AppendableWriter extends Writer {
    private boolean closed;
    private final Appendable target;

    AppendableWriter(Appendable appendable) {
        this.target = (Appendable) Preconditions.checkNotNull(appendable);
    }

    public void write(char[] cArr, int i, int i2) {
        checkNotClosed();
        this.target.append(new String(cArr, i, i2));
    }

    public void write(int i) {
        checkNotClosed();
        this.target.append((char) i);
    }

    public void write(@cij String str) {
        checkNotClosed();
        this.target.append(str);
    }

    public void write(@cij String str, int i, int i2) {
        checkNotClosed();
        this.target.append(str, i, i2 + i);
    }

    public void flush() {
        checkNotClosed();
        Appendable appendable = this.target;
        if (appendable instanceof Flushable) {
            ((Flushable) appendable).flush();
        }
    }

    public void close() {
        this.closed = true;
        Appendable appendable = this.target;
        if (appendable instanceof Closeable) {
            ((Closeable) appendable).close();
        }
    }

    public Writer append(char c) {
        checkNotClosed();
        this.target.append(c);
        return this;
    }

    public Writer append(@cij CharSequence charSequence) {
        checkNotClosed();
        this.target.append(charSequence);
        return this;
    }

    public Writer append(@cij CharSequence charSequence, int i, int i2) {
        checkNotClosed();
        this.target.append(charSequence, i, i2);
        return this;
    }

    private void checkNotClosed() {
        if (this.closed) {
            throw new IOException("Cannot write to a closed writer.");
        }
    }
}

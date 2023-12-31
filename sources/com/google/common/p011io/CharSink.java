package com.google.common.p011io;

import com.google.common.base.Preconditions;
import java.io.BufferedWriter;
import java.io.Writer;

/* renamed from: com.google.common.io.CharSink */
public abstract class CharSink {
    public abstract Writer openStream();

    protected CharSink() {
    }

    public Writer openBufferedStream() {
        Writer openStream = openStream();
        return openStream instanceof BufferedWriter ? (BufferedWriter) openStream : new BufferedWriter(openStream);
    }

    public void write(CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        Closer create = Closer.create();
        try {
            Writer writer = (Writer) create.register(openStream());
            writer.append(charSequence);
            writer.flush();
            create.close();
        } catch (Throwable th) {
            create.close();
            throw th;
        }
    }

    public void writeLines(Iterable<? extends CharSequence> iterable) {
        writeLines(iterable, System.getProperty("line.separator"));
    }

    public void writeLines(Iterable<? extends CharSequence> iterable, String str) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkNotNull(str);
        Closer create = Closer.create();
        try {
            Writer writer = (Writer) create.register(openBufferedStream());
            for (CharSequence append : iterable) {
                writer.append(append).append(str);
            }
            writer.flush();
            create.close();
        } catch (Throwable th) {
            create.close();
            throw th;
        }
    }

    public long writeFrom(Readable readable) {
        Preconditions.checkNotNull(readable);
        Closer create = Closer.create();
        try {
            Writer writer = (Writer) create.register(openStream());
            long copy = CharStreams.copy(readable, writer);
            writer.flush();
            create.close();
            return copy;
        } catch (Throwable th) {
            create.close();
            throw th;
        }
    }
}

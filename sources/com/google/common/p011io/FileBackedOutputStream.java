package com.google.common.p011io;

import atakplugin.UASTool.cij;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.google.common.io.FileBackedOutputStream */
public final class FileBackedOutputStream extends OutputStream {
    @cij
    private File file;
    private final int fileThreshold;
    private MemoryOutput memory;
    private OutputStream out;
    @cij
    private final File parentDirectory;
    private final boolean resetOnFinalize;
    private final ByteSource source;

    /* renamed from: com.google.common.io.FileBackedOutputStream$MemoryOutput */
    private static class MemoryOutput extends ByteArrayOutputStream {
        private MemoryOutput() {
        }

        /* access modifiers changed from: package-private */
        public byte[] getBuffer() {
            return this.buf;
        }

        /* access modifiers changed from: package-private */
        public int getCount() {
            return this.count;
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized File getFile() {
        return this.file;
    }

    public FileBackedOutputStream(int i) {
        this(i, false);
    }

    public FileBackedOutputStream(int i, boolean z) {
        this(i, z, (File) null);
    }

    private FileBackedOutputStream(int i, boolean z, @cij File file2) {
        this.fileThreshold = i;
        this.resetOnFinalize = z;
        this.parentDirectory = file2;
        MemoryOutput memoryOutput = new MemoryOutput();
        this.memory = memoryOutput;
        this.out = memoryOutput;
        if (z) {
            this.source = new ByteSource() {
                public InputStream openStream() {
                    return FileBackedOutputStream.this.openInputStream();
                }

                /* access modifiers changed from: protected */
                public void finalize() {
                    try {
                        FileBackedOutputStream.this.reset();
                    } catch (Throwable th) {
                        th.printStackTrace(System.err);
                    }
                }
            };
        } else {
            this.source = new ByteSource() {
                public InputStream openStream() {
                    return FileBackedOutputStream.this.openInputStream();
                }
            };
        }
    }

    public ByteSource asByteSource() {
        return this.source;
    }

    /* access modifiers changed from: private */
    public synchronized InputStream openInputStream() {
        if (this.file != null) {
            return new FileInputStream(this.file);
        }
        return new ByteArrayInputStream(this.memory.getBuffer(), 0, this.memory.getCount());
    }

    public synchronized void reset() {
        try {
            close();
            MemoryOutput memoryOutput = this.memory;
            if (memoryOutput == null) {
                this.memory = new MemoryOutput();
            } else {
                memoryOutput.reset();
            }
            this.out = this.memory;
            File file2 = this.file;
            if (file2 != null) {
                this.file = null;
                if (!file2.delete()) {
                    throw new IOException("Could not delete: " + file2);
                }
            }
        } catch (Throwable th) {
            if (this.memory == null) {
                this.memory = new MemoryOutput();
            } else {
                this.memory.reset();
            }
            this.out = this.memory;
            File file3 = this.file;
            if (file3 != null) {
                this.file = null;
                if (!file3.delete()) {
                    throw new IOException("Could not delete: " + file3);
                }
            }
            throw th;
        }
    }

    public synchronized void write(int i) {
        update(1);
        this.out.write(i);
    }

    public synchronized void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public synchronized void write(byte[] bArr, int i, int i2) {
        update(i2);
        this.out.write(bArr, i, i2);
    }

    public synchronized void close() {
        this.out.close();
    }

    public synchronized void flush() {
        this.out.flush();
    }

    private void update(int i) {
        if (this.file == null && this.memory.getCount() + i > this.fileThreshold) {
            File createTempFile = File.createTempFile("FileBackedOutputStream", (String) null, this.parentDirectory);
            if (this.resetOnFinalize) {
                createTempFile.deleteOnExit();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
            fileOutputStream.write(this.memory.getBuffer(), 0, this.memory.getCount());
            fileOutputStream.flush();
            this.out = fileOutputStream;
            this.file = createTempFile;
            this.memory = null;
        }
    }
}

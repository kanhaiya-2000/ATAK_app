package atakplugin.UASTool;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* renamed from: atakplugin.UASTool.wt */
public class C1008wt implements C1007ws {

    /* renamed from: a */
    private static final int f7527a = 8192;

    /* renamed from: b */
    private RandomAccessFile f7528b;

    /* renamed from: c */
    private String f7529c;

    public C1008wt(File file) {
        this.f7528b = new RandomAccessFile(file, "r");
        this.f7529c = file.getName();
    }

    /* renamed from: a */
    public int mo5650a(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        byte[] bArr = new byte[8192];
        int i = 0;
        int i2 = 0;
        while (i < remaining) {
            i2 = this.f7528b.read(bArr, 0, Math.min(remaining - i, 8192));
            if (i2 < 0) {
                break;
            }
            i += i2;
            byteBuffer.put(bArr, 0, i2);
        }
        if (i2 >= 0 || i != 0) {
            return i;
        }
        return -1;
    }

    /* renamed from: b */
    public int mo6132b(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[byteBuffer.remaining()];
        int read = this.f7528b.read(bArr);
        byteBuffer.put(bArr, 0, read);
        return read;
    }

    /* renamed from: a */
    public long mo5651a() {
        return this.f7528b.length();
    }

    /* renamed from: b */
    public long mo5655b() {
        return this.f7528b.getFilePointer();
    }

    /* renamed from: a */
    public void mo5654a(long j) {
        this.f7528b.seek(j);
    }

    /* renamed from: a */
    public long mo5652a(long j, long j2, WritableByteChannel writableByteChannel) {
        return (long) writableByteChannel.write(mo5653a(j, j2));
    }

    /* renamed from: a */
    public ByteBuffer mo5653a(long j, long j2) {
        this.f7528b.seek(j);
        byte[] bArr = new byte[afi.m847a(j2)];
        this.f7528b.readFully(bArr);
        return ByteBuffer.wrap(bArr);
    }

    public void close() {
        this.f7528b.close();
    }

    public String toString() {
        return this.f7529c;
    }
}

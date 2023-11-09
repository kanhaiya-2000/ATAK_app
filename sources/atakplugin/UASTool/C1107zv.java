package atakplugin.UASTool;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

/* renamed from: atakplugin.UASTool.zv */
class C1107zv implements C1024xh {

    /* renamed from: a */
    ByteBuffer f8101a = null;

    /* renamed from: b */
    final /* synthetic */ C1106zu f8102b;

    /* renamed from: c */
    private final /* synthetic */ int f8103c;

    C1107zv(C1106zu zuVar, int i) {
        this.f8102b = zuVar;
        this.f8103c = i;
    }

    /* renamed from: a */
    public void mo8a(WritableByteChannel writableByteChannel) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(this.f8102b.f8100a.f8095d[this.f8103c], "r");
        randomAccessFile.getChannel().transferTo(0, randomAccessFile.length(), writableByteChannel);
        randomAccessFile.close();
    }

    /* renamed from: a */
    public long mo7a() {
        return this.f8102b.f8100a.f8095d[this.f8103c].length();
    }

    /* renamed from: b */
    public ByteBuffer mo9b() {
        if (this.f8101a == null) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(this.f8102b.f8100a.f8095d[this.f8103c], "r");
                this.f8101a = randomAccessFile.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, randomAccessFile.length());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return this.f8101a;
    }
}

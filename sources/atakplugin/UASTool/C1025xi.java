package atakplugin.UASTool;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* renamed from: atakplugin.UASTool.xi */
public class C1025xi implements C1024xh {

    /* renamed from: a */
    private final long f7571a;

    /* renamed from: b */
    private final long f7572b;

    /* renamed from: c */
    private ByteBuffer[] f7573c;

    /* renamed from: d */
    private final C0695nz f7574d;

    public C1025xi(ByteBuffer byteBuffer) {
        this.f7571a = -1;
        this.f7572b = (long) byteBuffer.limit();
        this.f7573c = new ByteBuffer[]{byteBuffer};
        this.f7574d = null;
    }

    public C1025xi(ByteBuffer[] byteBufferArr) {
        this.f7571a = -1;
        int i = 0;
        for (ByteBuffer remaining : byteBufferArr) {
            i += remaining.remaining();
        }
        this.f7572b = (long) i;
        this.f7573c = byteBufferArr;
        this.f7574d = null;
    }

    public C1025xi(long j, long j2, ByteBuffer byteBuffer) {
        this.f7571a = j;
        this.f7572b = j2;
        this.f7573c = new ByteBuffer[]{byteBuffer};
        this.f7574d = null;
    }

    public C1025xi(long j, long j2, C0695nz nzVar) {
        this.f7571a = j;
        this.f7572b = j2;
        this.f7573c = null;
        this.f7574d = nzVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo6168c() {
        if (this.f7573c == null) {
            C0695nz nzVar = this.f7574d;
            if (nzVar != null) {
                try {
                    this.f7573c = new ByteBuffer[]{nzVar.mo201a(this.f7571a, this.f7572b)};
                } catch (IOException e) {
                    throw new RuntimeException("couldn't read sample " + this, e);
                }
            } else {
                throw new RuntimeException("Missing parent container, can't read sample " + this);
            }
        }
    }

    /* renamed from: a */
    public void mo8a(WritableByteChannel writableByteChannel) {
        mo6168c();
        for (ByteBuffer duplicate : this.f7573c) {
            writableByteChannel.write(duplicate.duplicate());
        }
    }

    /* renamed from: a */
    public long mo7a() {
        return this.f7572b;
    }

    /* renamed from: b */
    public ByteBuffer mo9b() {
        mo6168c();
        ByteBuffer wrap = ByteBuffer.wrap(new byte[afi.m847a(this.f7572b)]);
        for (ByteBuffer duplicate : this.f7573c) {
            wrap.put(duplicate.duplicate());
        }
        wrap.rewind();
        return wrap;
    }

    public String toString() {
        return "SampleImpl" + "{offset=" + this.f7571a + "{size=" + this.f7572b + '}';
    }
}

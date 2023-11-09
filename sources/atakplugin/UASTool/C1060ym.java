package atakplugin.UASTool;

import atakplugin.UASTool.C1058yl;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* renamed from: atakplugin.UASTool.ym */
class C1060ym implements C1024xh {

    /* renamed from: a */
    final /* synthetic */ C1058yl.C1059a f7711a;

    /* renamed from: b */
    private final /* synthetic */ ByteBuffer f7712b;

    /* renamed from: c */
    private final /* synthetic */ int f7713c;

    /* renamed from: d */
    private final /* synthetic */ C1024xh f7714d;

    C1060ym(C1058yl.C1059a aVar, ByteBuffer byteBuffer, int i, C1024xh xhVar) {
        this.f7711a = aVar;
        this.f7712b = byteBuffer;
        this.f7713c = i;
        this.f7714d = xhVar;
    }

    /* renamed from: a */
    public void mo8a(WritableByteChannel writableByteChannel) {
        for (byte[] next : C1058yl.this.f7707c.mo1224k()) {
            C0682nn.m12524a((long) next.length, (ByteBuffer) this.f7712b.rewind(), this.f7713c);
            writableByteChannel.write((ByteBuffer) this.f7712b.rewind());
            writableByteChannel.write(ByteBuffer.wrap(next));
        }
        for (byte[] next2 : C1058yl.this.f7707c.mo1229p()) {
            C0682nn.m12524a((long) next2.length, (ByteBuffer) this.f7712b.rewind(), this.f7713c);
            writableByteChannel.write((ByteBuffer) this.f7712b.rewind());
            writableByteChannel.write(ByteBuffer.wrap(next2));
        }
        for (byte[] next3 : C1058yl.this.f7707c.mo1225l()) {
            C0682nn.m12524a((long) next3.length, (ByteBuffer) this.f7712b.rewind(), this.f7713c);
            writableByteChannel.write((ByteBuffer) this.f7712b.rewind());
            writableByteChannel.write(ByteBuffer.wrap(next3));
        }
        this.f7714d.mo8a(writableByteChannel);
    }

    /* renamed from: a */
    public long mo7a() {
        int i = 0;
        for (byte[] length : C1058yl.this.f7707c.mo1224k()) {
            i += this.f7713c + length.length;
        }
        for (byte[] length2 : C1058yl.this.f7707c.mo1229p()) {
            i += this.f7713c + length2.length;
        }
        for (byte[] length3 : C1058yl.this.f7707c.mo1225l()) {
            i += this.f7713c + length3.length;
        }
        return this.f7714d.mo7a() + ((long) i);
    }

    /* renamed from: b */
    public ByteBuffer mo9b() {
        int i = 0;
        for (byte[] length : C1058yl.this.f7707c.mo1224k()) {
            i += this.f7713c + length.length;
        }
        for (byte[] length2 : C1058yl.this.f7707c.mo1229p()) {
            i += this.f7713c + length2.length;
        }
        for (byte[] length3 : C1058yl.this.f7707c.mo1225l()) {
            i += this.f7713c + length3.length;
        }
        ByteBuffer allocate = ByteBuffer.allocate(afi.m847a(this.f7714d.mo7a()) + i);
        for (byte[] next : C1058yl.this.f7707c.mo1224k()) {
            C0682nn.m12524a((long) next.length, allocate, this.f7713c);
            allocate.put(next);
        }
        for (byte[] next2 : C1058yl.this.f7707c.mo1229p()) {
            C0682nn.m12524a((long) next2.length, allocate, this.f7713c);
            allocate.put(next2);
        }
        for (byte[] next3 : C1058yl.this.f7707c.mo1225l()) {
            C0682nn.m12524a((long) next3.length, allocate, this.f7713c);
            allocate.put(next3);
        }
        allocate.put(this.f7714d.mo9b());
        return (ByteBuffer) allocate.rewind();
    }
}

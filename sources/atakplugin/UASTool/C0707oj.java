package atakplugin.UASTool;

import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.LinkedList;
import java.util.List;

/* renamed from: atakplugin.UASTool.oj */
public class C0707oj implements C0688nt {

    /* renamed from: a */
    public static final String f5452a = "free";

    /* renamed from: d */
    static final /* synthetic */ boolean f5453d = true;

    /* renamed from: b */
    ByteBuffer f5454b;

    /* renamed from: c */
    List<C0688nt> f5455c;

    /* renamed from: e */
    private C0695nz f5456e;

    /* renamed from: f */
    private long f5457f;

    /* renamed from: h */
    public String mo1476h() {
        return f5452a;
    }

    public C0707oj() {
        this.f5455c = new LinkedList();
        this.f5454b = ByteBuffer.wrap(new byte[0]);
    }

    public C0707oj(int i) {
        this.f5455c = new LinkedList();
        this.f5454b = ByteBuffer.allocate(i);
    }

    /* renamed from: g */
    public long mo1475g() {
        return this.f5457f;
    }

    /* renamed from: a */
    public ByteBuffer mo5181a() {
        ByteBuffer byteBuffer = this.f5454b;
        if (byteBuffer != null) {
            return (ByteBuffer) byteBuffer.duplicate().rewind();
        }
        return null;
    }

    /* renamed from: a */
    public void mo5183a(ByteBuffer byteBuffer) {
        this.f5454b = byteBuffer;
    }

    /* renamed from: a */
    public void mo18a(WritableByteChannel writableByteChannel) {
        for (C0688nt a : this.f5455c) {
            a.mo18a(writableByteChannel);
        }
        ByteBuffer allocate = ByteBuffer.allocate(8);
        C0681nm.m12515b(allocate, (long) (this.f5454b.limit() + 8));
        allocate.put(f5452a.getBytes());
        allocate.rewind();
        writableByteChannel.write(allocate);
        allocate.rewind();
        this.f5454b.rewind();
        writableByteChannel.write(this.f5454b);
        this.f5454b.rewind();
    }

    /* renamed from: e */
    public C0695nz mo1474e() {
        return this.f5456e;
    }

    /* renamed from: a */
    public void mo1473a(C0695nz nzVar) {
        this.f5456e = nzVar;
    }

    /* renamed from: f */
    public long mo19f() {
        long j = 8;
        for (C0688nt f : this.f5455c) {
            j += f.mo19f();
        }
        return j + ((long) this.f5454b.limit());
    }

    /* renamed from: a */
    public void mo105a(C1007ws wsVar, ByteBuffer byteBuffer, long j, C0675ng ngVar) {
        this.f5457f = wsVar.mo5655b() - ((long) byteBuffer.remaining());
        if (j > 1048576) {
            this.f5454b = wsVar.mo5653a(wsVar.mo5655b(), j);
            wsVar.mo5654a(wsVar.mo5655b() + j);
        } else if (f5453d || j < 2147483647L) {
            ByteBuffer allocate = ByteBuffer.allocate(afi.m847a(j));
            this.f5454b = allocate;
            wsVar.mo5650a(allocate);
        } else {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    public void mo5182a(C0688nt ntVar) {
        this.f5454b.position(afi.m847a(ntVar.mo19f()));
        this.f5454b = this.f5454b.slice();
        this.f5455c.add(ntVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0707oj ojVar = (C0707oj) obj;
        return mo5181a() == null ? ojVar.mo5181a() == null : mo5181a().equals(ojVar.mo5181a());
    }

    public int hashCode() {
        ByteBuffer byteBuffer = this.f5454b;
        if (byteBuffer != null) {
            return byteBuffer.hashCode();
        }
        return 0;
    }
}

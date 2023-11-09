package atakplugin.UASTool;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class aeo extends aeh {

    /* renamed from: b */
    public static UUID f705b = UUID.fromString("9A04F079-9840-4286-AB92-E65BE0885F95");

    /* renamed from: c */
    private long f706c;

    /* renamed from: d */
    private List<C0020a> f707d;

    static {
        aeh.f649a.put(f705b, aeo.class);
    }

    /* renamed from: a */
    public UUID mo457a() {
        return f705b;
    }

    /* renamed from: a */
    public void mo458a(ByteBuffer byteBuffer) {
        this.f706c = C0679nk.m12493a(byteBuffer);
        this.f707d = C0020a.m753a(byteBuffer, C0679nk.m12498e(byteBuffer));
    }

    /* renamed from: b */
    public ByteBuffer mo459b() {
        int i = 6;
        for (C0020a a : this.f707d) {
            i = i + 4 + a.mo505a().rewind().limit();
        }
        ByteBuffer allocate = ByteBuffer.allocate(i);
        C0681nm.m12519c(allocate, (long) i);
        C0681nm.m12518c(allocate, this.f707d.size());
        for (C0020a next : this.f707d) {
            C0681nm.m12518c(allocate, next.f708a);
            C0681nm.m12518c(allocate, next.mo505a().limit());
            allocate.put(next.mo505a());
        }
        return allocate;
    }

    /* renamed from: a */
    public void mo503a(List<C0020a> list) {
        this.f707d = list;
    }

    /* renamed from: c */
    public List<C0020a> mo504c() {
        return Collections.unmodifiableList(this.f707d);
    }

    public String toString() {
        return "PlayReadyHeader" + "{length=" + this.f706c + ", recordCount=" + this.f707d.size() + ", records=" + this.f707d + '}';
    }

    /* renamed from: atakplugin.UASTool.aeo$a */
    public static abstract class C0020a {

        /* renamed from: a */
        int f708a;

        /* renamed from: a */
        public abstract ByteBuffer mo505a();

        /* renamed from: a */
        public abstract void mo506a(ByteBuffer byteBuffer);

        public C0020a(int i) {
            this.f708a = i;
        }

        /* renamed from: a */
        public static List<C0020a> m753a(ByteBuffer byteBuffer, int i) {
            C0020a aVar;
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 < i; i2++) {
                int e = C0679nk.m12498e(byteBuffer);
                int e2 = C0679nk.m12498e(byteBuffer);
                if (e == 1) {
                    aVar = new C0023c();
                } else if (e == 2) {
                    aVar = new C0021a(2);
                } else if (e != 3) {
                    aVar = new C0021a(e);
                } else {
                    aVar = new C0022b();
                }
                aVar.mo506a((ByteBuffer) byteBuffer.slice().limit(e2));
                byteBuffer.position(byteBuffer.position() + e2);
                arrayList.add(aVar);
            }
            return arrayList;
        }

        public String toString() {
            return "PlayReadyRecord" + "{type=" + this.f708a + ", length=" + mo505a().limit() + '}';
        }

        /* renamed from: atakplugin.UASTool.aeo$a$c */
        public static class C0023c extends C0020a {

            /* renamed from: b */
            String f711b;

            public C0023c() {
                super(1);
            }

            /* renamed from: a */
            public void mo506a(ByteBuffer byteBuffer) {
                try {
                    byte[] bArr = new byte[byteBuffer.slice().limit()];
                    byteBuffer.get(bArr);
                    this.f711b = new String(bArr, bxz.f4233e);
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException(e);
                }
            }

            /* renamed from: a */
            public ByteBuffer mo505a() {
                try {
                    return ByteBuffer.wrap(this.f711b.getBytes(bxz.f4233e));
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException(e);
                }
            }

            /* renamed from: a */
            public void mo508a(String str) {
                this.f711b = str;
            }

            /* renamed from: b */
            public String mo509b() {
                return this.f711b;
            }

            public String toString() {
                return "RMHeader" + "{length=" + mo505a().limit() + ", header='" + this.f711b + '\'' + '}';
            }
        }

        /* renamed from: atakplugin.UASTool.aeo$a$b */
        public static class C0022b extends C0020a {

            /* renamed from: b */
            ByteBuffer f710b;

            public C0022b() {
                super(3);
            }

            /* renamed from: a */
            public void mo506a(ByteBuffer byteBuffer) {
                this.f710b = byteBuffer.duplicate();
            }

            /* renamed from: a */
            public ByteBuffer mo505a() {
                return this.f710b;
            }

            public String toString() {
                return "EmeddedLicenseStore" + "{length=" + mo505a().limit() + '}';
            }
        }

        /* renamed from: atakplugin.UASTool.aeo$a$a */
        public static class C0021a extends C0020a {

            /* renamed from: b */
            ByteBuffer f709b;

            public C0021a(int i) {
                super(i);
            }

            /* renamed from: a */
            public void mo506a(ByteBuffer byteBuffer) {
                this.f709b = byteBuffer.duplicate();
            }

            /* renamed from: a */
            public ByteBuffer mo505a() {
                return this.f709b;
            }
        }
    }
}

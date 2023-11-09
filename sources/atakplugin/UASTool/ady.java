package atakplugin.UASTool;

import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;

public class ady extends adx {

    /* renamed from: a */
    public static final String f599a = "rash";

    /* renamed from: b */
    private short f600b;

    /* renamed from: c */
    private short f601c;

    /* renamed from: d */
    private List<C0014a> f602d = new LinkedList();

    /* renamed from: e */
    private int f603e;

    /* renamed from: f */
    private int f604f;

    /* renamed from: g */
    private short f605g;

    /* renamed from: a */
    public String mo377a() {
        return f599a;
    }

    /* JADX WARNING: type inference failed for: r1v1, types: [int] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo379a(java.nio.ByteBuffer r6) {
        /*
            r5 = this;
            short r0 = r6.getShort()
            r5.f600b = r0
            r1 = 1
            if (r0 != r1) goto L_0x0010
            short r0 = r6.getShort()
            r5.f601c = r0
            goto L_0x0014
        L_0x0010:
            int r1 = r0 + -1
            if (r0 > 0) goto L_0x0030
        L_0x0014:
            long r0 = atakplugin.UASTool.C0679nk.m12495b(r6)
            int r0 = atakplugin.UASTool.afi.m847a(r0)
            r5.f603e = r0
            long r0 = atakplugin.UASTool.C0679nk.m12495b(r6)
            int r0 = atakplugin.UASTool.afi.m847a(r0)
            r5.f604f = r0
            int r6 = atakplugin.UASTool.C0679nk.m12499f(r6)
            short r6 = (short) r6
            r5.f605g = r6
            return
        L_0x0030:
            java.util.List<atakplugin.UASTool.ady$a> r0 = r5.f602d
            atakplugin.UASTool.ady$a r2 = new atakplugin.UASTool.ady$a
            long r3 = atakplugin.UASTool.C0679nk.m12495b(r6)
            int r3 = atakplugin.UASTool.afi.m847a(r3)
            short r4 = r6.getShort()
            r2.<init>(r3, r4)
            r0.add(r2)
            r0 = r1
            goto L_0x0010
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.ady.mo379a(java.nio.ByteBuffer):void");
    }

    /* renamed from: b */
    public ByteBuffer mo382b() {
        short s = this.f600b;
        ByteBuffer allocate = ByteBuffer.allocate(s == 1 ? 13 : (s * 6) + 11);
        allocate.putShort(this.f600b);
        if (this.f600b == 1) {
            allocate.putShort(this.f601c);
        } else {
            for (C0014a next : this.f602d) {
                allocate.putInt(next.mo404a());
                allocate.putShort(next.mo407b());
            }
        }
        allocate.putInt(this.f603e);
        allocate.putInt(this.f604f);
        C0681nm.m12521d(allocate, (int) this.f605g);
        allocate.rewind();
        return allocate;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ady ady = (ady) obj;
        if (this.f605g != ady.f605g || this.f603e != ady.f603e || this.f604f != ady.f604f || this.f600b != ady.f600b || this.f601c != ady.f601c) {
            return false;
        }
        List<C0014a> list = this.f602d;
        List<C0014a> list2 = ady.f602d;
        return list == null ? list2 == null : list.equals(list2);
    }

    public int hashCode() {
        int i = ((this.f600b * 31) + this.f601c) * 31;
        List<C0014a> list = this.f602d;
        return ((((((i + (list != null ? list.hashCode() : 0)) * 31) + this.f603e) * 31) + this.f604f) * 31) + this.f605g;
    }

    /* renamed from: c */
    public short mo395c() {
        return this.f600b;
    }

    /* renamed from: a */
    public void mo392a(short s) {
        this.f600b = s;
    }

    /* renamed from: d */
    public short mo397d() {
        return this.f601c;
    }

    /* renamed from: b */
    public void mo394b(short s) {
        this.f601c = s;
    }

    /* renamed from: e */
    public List<C0014a> mo398e() {
        return this.f602d;
    }

    /* renamed from: a */
    public void mo391a(List<C0014a> list) {
        this.f602d = list;
    }

    /* renamed from: g */
    public int mo400g() {
        return this.f603e;
    }

    /* renamed from: a */
    public void mo390a(int i) {
        this.f603e = i;
    }

    /* renamed from: h */
    public int mo401h() {
        return this.f604f;
    }

    /* renamed from: b */
    public void mo393b(int i) {
        this.f604f = i;
    }

    /* renamed from: i */
    public short mo403i() {
        return this.f605g;
    }

    /* renamed from: c */
    public void mo396c(short s) {
        this.f605g = s;
    }

    /* renamed from: atakplugin.UASTool.ady$a */
    public static class C0014a {

        /* renamed from: a */
        int f606a;

        /* renamed from: b */
        short f607b;

        public C0014a(int i, short s) {
            this.f606a = i;
            this.f607b = s;
        }

        public String toString() {
            return "{availableBitrate=" + this.f606a + ", targetRateShare=" + this.f607b + '}';
        }

        /* renamed from: a */
        public int mo404a() {
            return this.f606a;
        }

        /* renamed from: a */
        public void mo405a(int i) {
            this.f606a = i;
        }

        /* renamed from: b */
        public short mo407b() {
            return this.f607b;
        }

        /* renamed from: a */
        public void mo406a(short s) {
            this.f607b = s;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C0014a aVar = (C0014a) obj;
            return this.f606a == aVar.f606a && this.f607b == aVar.f607b;
        }

        public int hashCode() {
            return (this.f606a * 31) + this.f607b;
        }
    }
}

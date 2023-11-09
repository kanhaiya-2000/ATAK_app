package atakplugin.UASTool;

import atakplugin.UASTool.alo;
import atakplugin.UASTool.can;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class aan extends C1004wp {

    /* renamed from: e */
    private static final /* synthetic */ can.C0296b f49e = null;

    /* renamed from: f */
    private static final /* synthetic */ can.C0296b f50f = null;

    /* renamed from: o */
    private static final /* synthetic */ can.C0296b f51o = null;

    /* renamed from: p */
    private static final /* synthetic */ can.C0296b f52p = null;

    /* renamed from: q */
    private static final /* synthetic */ can.C0296b f53q = null;

    /* renamed from: r */
    private static final /* synthetic */ can.C0296b f54r = null;

    /* renamed from: a */
    protected int f55a = -1;

    /* renamed from: b */
    protected int f56b = -1;

    /* renamed from: c */
    protected byte[] f57c = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

    /* renamed from: d */
    List<alo> f58d = Collections.emptyList();

    static {
        mo453n();
    }

    /* renamed from: n */
    private static /* synthetic */ void mo453n() {
        cdj cdj = new cdj("AbstractSampleEncryptionBox.java", aan.class);
        f49e = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getOffsetToFirstIV", "com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox", "", "", "", "int"), 29);
        f50f = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getEntries", "com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox", "", "", "", "java.util.List"), 89);
        f51o = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setEntries", "com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox", "java.util.List", "entries", "", "void"), 93);
        f52p = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "equals", "com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox", "java.lang.Object", "o", "", "boolean"), 173);
        f53q = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "hashCode", "com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox", "", "", "", "int"), 200);
        f54r = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getEntrySizes", "com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox", "", "", "", "java.util.List"), 208);
    }

    protected aan(String str) {
        super(str);
    }

    /* renamed from: c */
    public int mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f49e, (Object) this, (Object) this));
        return (mo19f() > 4294967296L ? 16 : 8) + (mo53k() ? this.f57c.length + 4 : 0) + 4;
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        if ((mo456b_() & 1) > 0) {
            this.f55a = C0679nk.m12496c(byteBuffer);
            this.f56b = C0679nk.m12499f(byteBuffer);
            byte[] bArr = new byte[16];
            this.f57c = bArr;
            byteBuffer.get(bArr);
        }
        long b = C0679nk.m12495b(byteBuffer);
        ByteBuffer duplicate = byteBuffer.duplicate();
        ByteBuffer duplicate2 = byteBuffer.duplicate();
        List<alo> a = m55a(duplicate, b, 8);
        this.f58d = a;
        if (a == null) {
            this.f58d = m55a(duplicate2, b, 16);
            byteBuffer.position((byteBuffer.position() + byteBuffer.remaining()) - duplicate2.remaining());
        } else {
            byteBuffer.position((byteBuffer.position() + byteBuffer.remaining()) - duplicate.remaining());
        }
        if (this.f58d == null) {
            throw new RuntimeException("Cannot parse SampleEncryptionBox");
        }
    }

    /* renamed from: a */
    private List<alo> m55a(ByteBuffer byteBuffer, long j, int i) {
        ArrayList arrayList = new ArrayList();
        while (true) {
            long j2 = j - 1;
            if (j <= 0) {
                return arrayList;
            }
            try {
                alo alo = new alo();
                alo.f1972a = new byte[i];
                byteBuffer.get(alo.f1972a);
                if ((mo456b_() & 2) > 0) {
                    alo.f1973b = new alo.C0065j[C0679nk.m12497d(byteBuffer)];
                    for (int i2 = 0; i2 < alo.f1973b.length; i2++) {
                        alo.f1973b[i2] = alo.mo1402a(C0679nk.m12497d(byteBuffer), C0679nk.m12495b(byteBuffer));
                    }
                }
                arrayList.add(alo);
                j = j2;
            } catch (BufferUnderflowException unused) {
                return null;
            }
        }
    }

    /* renamed from: i */
    public List<alo> mo43i() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f50f, (Object) this, (Object) this));
        return this.f58d;
    }

    /* renamed from: a */
    public void mo48a(List<alo> list) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f51o, (Object) this, (Object) this, (Object) list));
        this.f58d = list;
    }

    @C1016xa
    /* renamed from: j */
    public boolean mo52j() {
        return (mo456b_() & 2) > 0;
    }

    @C1016xa
    /* renamed from: a */
    public void mo49a(boolean z) {
        if (z) {
            mo5159b(mo456b_() | 2);
        } else {
            mo5159b(mo456b_() & 16777213);
        }
    }

    /* access modifiers changed from: protected */
    @C1016xa
    /* renamed from: k */
    public boolean mo53k() {
        return (mo456b_() & 1) > 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        if (mo53k()) {
            C0681nm.m12510a(byteBuffer, this.f55a);
            C0681nm.m12521d(byteBuffer, this.f56b);
            byteBuffer.put(this.f57c);
        }
        C0681nm.m12515b(byteBuffer, (long) mo452m());
        for (alo next : this.f58d) {
            if (next.mo1401a() > 0) {
                if (next.f1972a.length == 8 || next.f1972a.length == 16) {
                    byteBuffer.put(next.f1972a);
                    if (mo52j()) {
                        C0681nm.m12514b(byteBuffer, next.f1973b.length);
                        for (alo.C0065j jVar : next.f1973b) {
                            C0681nm.m12514b(byteBuffer, jVar.mo1408a());
                            C0681nm.m12515b(byteBuffer, jVar.mo1409b());
                        }
                    }
                } else {
                    throw new RuntimeException("IV must be either 8 or 16 bytes");
                }
            }
        }
    }

    /* renamed from: m */
    private int mo452m() {
        int i = 0;
        for (alo a : this.f58d) {
            if (a.mo1401a() > 0) {
                i++;
            }
        }
        return i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        long length = (mo53k() ? 8 + ((long) this.f57c.length) : 4) + 4;
        for (alo a : this.f58d) {
            length += (long) a.mo1401a();
        }
        return length;
    }

    /* renamed from: a */
    public void mo18a(WritableByteChannel writableByteChannel) {
        super.mo18a(writableByteChannel);
    }

    public boolean equals(Object obj) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f52p, (Object) this, (Object) this, obj));
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        aan aan = (aan) obj;
        if (this.f55a != aan.f55a || this.f56b != aan.f56b) {
            return false;
        }
        List<alo> list = this.f58d;
        if (list == null ? aan.f58d == null : list.equals(aan.f58d)) {
            return Arrays.equals(this.f57c, aan.f57c);
        }
        return false;
    }

    public int hashCode() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f53q, (Object) this, (Object) this));
        int i = ((this.f55a * 31) + this.f56b) * 31;
        byte[] bArr = this.f57c;
        int i2 = 0;
        int hashCode = (i + (bArr != null ? Arrays.hashCode(bArr) : 0)) * 31;
        List<alo> list = this.f58d;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode + i2;
    }

    /* renamed from: l */
    public List<Short> mo54l() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f54r, (Object) this, (Object) this));
        ArrayList arrayList = new ArrayList(this.f58d.size());
        for (alo next : this.f58d) {
            short length = (short) next.f1972a.length;
            if (mo52j()) {
                length = (short) (((short) (length + 2)) + (next.f1973b.length * 6));
            }
            arrayList.add(Short.valueOf(length));
        }
        return arrayList;
    }
}

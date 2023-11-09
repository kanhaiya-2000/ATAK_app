package atakplugin.UASTool;

import java.io.EOFException;
import java.nio.ByteBuffer;
import java.util.logging.Logger;

/* renamed from: atakplugin.UASTool.nd */
public abstract class C0672nd implements C0675ng {

    /* renamed from: b */
    private static Logger f5330b = Logger.getLogger(C0672nd.class.getName());

    /* renamed from: a */
    ThreadLocal<ByteBuffer> f5331a = new C0673ne(this);

    /* renamed from: a */
    public abstract C0688nt mo5102a(String str, byte[] bArr, String str2);

    /* renamed from: a */
    public C0688nt mo5101a(C1007ws wsVar, C0695nz nzVar) {
        int a;
        long j;
        byte[] bArr;
        C1007ws wsVar2 = wsVar;
        C0695nz nzVar2 = nzVar;
        long b = wsVar.mo5655b();
        this.f5331a.get().rewind().limit(8);
        do {
            a = wsVar2.mo5650a(this.f5331a.get());
            if (a == 8) {
                this.f5331a.get().rewind();
                long b2 = C0679nk.m12495b(this.f5331a.get());
                if (b2 >= 8 || b2 <= 1) {
                    String m = C0679nk.m12506m(this.f5331a.get());
                    if (b2 == 1) {
                        this.f5331a.get().limit(16);
                        wsVar2.mo5650a(this.f5331a.get());
                        this.f5331a.get().position(8);
                        j = C0679nk.m12501h(this.f5331a.get()) - 16;
                    } else {
                        j = b2 == 0 ? wsVar.mo5651a() - wsVar.mo5655b() : b2 - 8;
                    }
                    if (C0758pz.f5795b.equals(m)) {
                        this.f5331a.get().limit(this.f5331a.get().limit() + 16);
                        wsVar2.mo5650a(this.f5331a.get());
                        bArr = new byte[16];
                        for (int position = this.f5331a.get().position() - 16; position < this.f5331a.get().position(); position++) {
                            bArr[position - (this.f5331a.get().position() - 16)] = this.f5331a.get().get(position);
                        }
                        j -= 16;
                    } else {
                        bArr = null;
                    }
                    long j2 = j;
                    C0688nt a2 = mo5102a(m, bArr, nzVar2 instanceof C0688nt ? ((C0688nt) nzVar2).mo1476h() : "");
                    a2.mo1473a(nzVar2);
                    this.f5331a.get().rewind();
                    a2.mo105a(wsVar, this.f5331a.get(), j2, this);
                    return a2;
                }
                f5330b.severe("Plausibility check failed: size < 8 (size = " + b2 + "). Stop parsing!");
                return null;
            }
        } while (a >= 0);
        wsVar2.mo5654a(b);
        throw new EOFException();
    }
}

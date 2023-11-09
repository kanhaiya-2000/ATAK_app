package atakplugin.UASTool;

import atakplugin.UASTool.C0693ny;
import atakplugin.UASTool.C0735ph;
import com.google.common.base.Ascii;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* renamed from: atakplugin.UASTool.ze */
public class C1083ze implements C1026xj {

    /* renamed from: a */
    C1026xj f7855a;

    /* renamed from: b */
    List<C1024xh> f7856b = new LinkedList();

    /* renamed from: c */
    long[] f7857c;

    /* renamed from: d */
    String f7858d;

    /* renamed from: a */
    public List<C0693ny.C0694a> mo6139a() {
        return null;
    }

    /* renamed from: b */
    public long[] mo6140b() {
        return null;
    }

    /* renamed from: c */
    public List<C0735ph.C0736a> mo6141c() {
        return null;
    }

    public void close() {
    }

    /* renamed from: d */
    public C0746pq mo6142d() {
        return null;
    }

    /* renamed from: g */
    public List<C1021xe> mo6145g() {
        return null;
    }

    public C1083ze(C1026xj xjVar, long j) {
        this.f7855a = xjVar;
        this.f7858d = j + "ms silence";
        if (C0793rd.f6034d.equals(xjVar.mo13n().mo5316d().mo1476h())) {
            int a = afi.m847a(((mo14o().mo6178b() * j) / 1000) / 1024);
            long[] jArr = new long[a];
            this.f7857c = jArr;
            Arrays.fill(jArr, ((mo14o().mo6178b() * j) / ((long) a)) / 1000);
            while (true) {
                int i = a - 1;
                if (a > 0) {
                    this.f7856b.add(new C1025xi((ByteBuffer) ByteBuffer.wrap(new byte[]{33, 16, 4, 96, -116, Ascii.f8517FS}).rewind()));
                    a = i;
                } else {
                    return;
                }
            }
        } else {
            throw new RuntimeException("Tracks of type " + xjVar.getClass().getSimpleName() + " are not supported");
        }
    }

    /* renamed from: n */
    public C0737pi mo13n() {
        return this.f7855a.mo13n();
    }

    /* renamed from: m */
    public long[] mo12m() {
        return this.f7857c;
    }

    /* renamed from: e */
    public long mo6143e() {
        long j = 0;
        for (long j2 : this.f7857c) {
            j += j2;
        }
        return j;
    }

    /* renamed from: o */
    public C1027xk mo14o() {
        return this.f7855a.mo14o();
    }

    /* renamed from: p */
    public String mo15p() {
        return this.f7855a.mo15p();
    }

    /* renamed from: l */
    public List<C1024xh> mo11l() {
        return this.f7856b;
    }

    /* renamed from: f */
    public String mo6144f() {
        return this.f7858d;
    }

    /* renamed from: h */
    public Map<adx, long[]> mo6146h() {
        return this.f7855a.mo6146h();
    }
}

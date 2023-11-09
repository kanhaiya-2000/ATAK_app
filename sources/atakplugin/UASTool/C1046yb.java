package atakplugin.UASTool;

import atakplugin.UASTool.C0786qy;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: atakplugin.UASTool.yb */
public class C1046yb extends AbstractList<C1024xh> {

    /* renamed from: a */
    C0695nz f7634a;

    /* renamed from: b */
    C0678nj[] f7635b;

    /* renamed from: c */
    C0754pv f7636c = null;

    /* renamed from: d */
    C0780qt f7637d = null;

    /* renamed from: e */
    private SoftReference<C1024xh>[] f7638e;

    /* renamed from: f */
    private List<C0782qv> f7639f;

    /* renamed from: g */
    private Map<C0786qy, SoftReference<ByteBuffer>> f7640g = new HashMap();

    /* renamed from: h */
    private int[] f7641h;

    /* renamed from: i */
    private int f7642i = -1;

    public C1046yb(long j, C0695nz nzVar, C0678nj... njVarArr) {
        this.f7634a = nzVar;
        this.f7635b = njVarArr;
        for (C0754pv pvVar : aft.m890b(nzVar, "moov[0]/trak")) {
            if (pvVar.mo5377a().mo5394j() == j) {
                this.f7636c = pvVar;
            }
        }
        if (this.f7636c != null) {
            for (C0780qt qtVar : aft.m890b(nzVar, "moov[0]/mvex[0]/trex")) {
                if (qtVar.mo36c() == this.f7636c.mo5377a().mo5394j()) {
                    this.f7637d = qtVar;
                }
            }
            this.f7638e = (SoftReference[]) Array.newInstance(SoftReference.class, size());
            m14677a();
            return;
        }
        throw new RuntimeException("This MP4 does not contain track " + j);
    }

    /* renamed from: a */
    private List<C0782qv> m14677a() {
        List<C0782qv> list = this.f7639f;
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (C0774qn a : this.f7634a.mo202a(C0774qn.class)) {
            for (C0782qv next : a.mo202a(C0782qv.class)) {
                if (next.mo5492a().mo5504m() == this.f7636c.mo5377a().mo5394j()) {
                    arrayList.add(next);
                }
            }
        }
        C0678nj[] njVarArr = this.f7635b;
        if (njVarArr != null) {
            for (C0678nj a2 : njVarArr) {
                for (C0774qn a3 : a2.mo202a(C0774qn.class)) {
                    for (C0782qv next2 : a3.mo202a(C0782qv.class)) {
                        if (next2.mo5492a().mo5504m() == this.f7636c.mo5377a().mo5394j()) {
                            arrayList.add(next2);
                        }
                    }
                }
            }
        }
        this.f7639f = arrayList;
        this.f7641h = new int[arrayList.size()];
        int i = 1;
        for (int i2 = 0; i2 < this.f7639f.size(); i2++) {
            this.f7641h[i2] = i;
            i += m14676a(this.f7639f.get(i2));
        }
        return arrayList;
    }

    /* renamed from: a */
    private int m14676a(C0782qv qvVar) {
        List<C0688nt> c = qvVar.mo36c();
        int i = 0;
        for (int i2 = 0; i2 < c.size(); i2++) {
            C0688nt ntVar = c.get(i2);
            if (ntVar instanceof C0786qy) {
                i += afi.m847a(((C0786qy) ntVar).mo5545j());
            }
        }
        return i;
    }

    /* renamed from: a */
    public C1024xh get(int i) {
        long j;
        ByteBuffer byteBuffer;
        long k;
        C1024xh xhVar;
        SoftReference<C1024xh>[] softReferenceArr = this.f7638e;
        if (softReferenceArr[i] != null && (xhVar = softReferenceArr[i].get()) != null) {
            return xhVar;
        }
        int i2 = i + 1;
        int length = this.f7641h.length;
        while (true) {
            length--;
            if (i2 - this.f7641h[length] >= 0) {
                break;
            }
        }
        C0782qv qvVar = this.f7639f.get(length);
        int i3 = i2 - this.f7641h[length];
        C0774qn qnVar = (C0774qn) qvVar.mo1474e();
        int i4 = 0;
        for (C0688nt next : qvVar.mo36c()) {
            if (next instanceof C0786qy) {
                C0786qy qyVar = (C0786qy) next;
                int i5 = i3 - i4;
                if (qyVar.mo36c().size() < i5) {
                    i4 += qyVar.mo36c().size();
                } else {
                    List<C0786qy.C0787a> c = qyVar.mo36c();
                    C0783qw a = qvVar.mo5492a();
                    boolean m = qyVar.mo5548m();
                    boolean k2 = a.mo5502k();
                    long j2 = 0;
                    if (!m) {
                        if (k2) {
                            k = a.mo5508q();
                        } else {
                            C0780qt qtVar = this.f7637d;
                            if (qtVar != null) {
                                k = qtVar.mo5487k();
                            } else {
                                throw new RuntimeException("File doesn't contain trex box but track fragments aren't fully self contained. Cannot determine sample size.");
                            }
                        }
                        j = k;
                    } else {
                        j = 0;
                    }
                    SoftReference softReference = this.f7640g.get(qyVar);
                    ByteBuffer byteBuffer2 = softReference != null ? (ByteBuffer) softReference.get() : null;
                    if (byteBuffer2 == null) {
                        C0695nz nzVar = qnVar;
                        if (a.mo36c()) {
                            j2 = 0 + a.mo5505n();
                            nzVar = qnVar.mo1474e();
                        }
                        if (qyVar.mo5546k()) {
                            j2 += (long) qyVar.mo5552q();
                        }
                        int i6 = 0;
                        for (C0786qy.C0787a b : c) {
                            i6 = m ? (int) (((long) i6) + b.mo5559b()) : (int) (((long) i6) + j);
                        }
                        try {
                            ByteBuffer a2 = nzVar.mo201a(j2, (long) i6);
                            this.f7640g.put(qyVar, new SoftReference(a2));
                            byteBuffer = a2;
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        byteBuffer = byteBuffer2;
                    }
                    int i7 = 0;
                    for (int i8 = 0; i8 < i5; i8++) {
                        i7 = (int) (m ? ((long) i7) + c.get(i8).mo5559b() : ((long) i7) + j);
                    }
                    C1047yc ycVar = new C1047yc(this, m ? c.get(i5).mo5559b() : j, byteBuffer, i7);
                    this.f7638e[i] = new SoftReference<>(ycVar);
                    return ycVar;
                }
            }
        }
        throw new RuntimeException("Couldn't find sample in the traf I was looking");
    }

    public int size() {
        int i = this.f7642i;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (C0774qn a : this.f7634a.mo202a(C0774qn.class)) {
            for (C0782qv next : a.mo202a(C0782qv.class)) {
                if (next.mo5492a().mo5504m() == this.f7636c.mo5377a().mo5394j()) {
                    i2 = (int) (((long) i2) + next.mo202a(C0786qy.class).get(0).mo5545j());
                }
            }
        }
        for (C0678nj a2 : this.f7635b) {
            for (C0774qn a3 : a2.mo202a(C0774qn.class)) {
                for (C0782qv next2 : a3.mo202a(C0782qv.class)) {
                    if (next2.mo5492a().mo5504m() == this.f7636c.mo5377a().mo5394j()) {
                        i2 = (int) (((long) i2) + next2.mo202a(C0786qy.class).get(0).mo5545j());
                    }
                }
            }
        }
        this.f7642i = i2;
        return i2;
    }
}

package atakplugin.UASTool;

import atakplugin.UASTool.C0693ny;
import atakplugin.UASTool.C0735ph;
import atakplugin.UASTool.C0751pt;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/* renamed from: atakplugin.UASTool.yt */
public class C1067yt extends C1018xc {

    /* renamed from: e */
    static final /* synthetic */ boolean f7738e = true;

    /* renamed from: d */
    C1026xj f7739d;

    /* renamed from: f */
    private int f7740f;

    /* renamed from: g */
    private int f7741g;

    public C1067yt(C1026xj xjVar, long j, long j2) {
        super("crop(" + xjVar.mo6144f() + ")");
        this.f7739d = xjVar;
        boolean z = f7738e;
        if (!z && j > 2147483647L) {
            throw new AssertionError();
        } else if (z || j2 <= 2147483647L) {
            this.f7740f = (int) j;
            this.f7741g = (int) j2;
        } else {
            throw new AssertionError();
        }
    }

    public void close() {
        this.f7739d.close();
    }

    /* renamed from: l */
    public List<C1024xh> mo11l() {
        return this.f7739d.mo11l().subList(this.f7740f, this.f7741g);
    }

    /* renamed from: n */
    public C0737pi mo13n() {
        return this.f7739d.mo13n();
    }

    /* renamed from: m */
    public synchronized long[] mo12m() {
        long[] jArr;
        int i = this.f7741g - this.f7740f;
        jArr = new long[i];
        System.arraycopy(this.f7739d.mo12m(), this.f7740f, jArr, 0, i);
        return jArr;
    }

    /* renamed from: a */
    static List<C0751pt.C0752a> m14802a(List<C0751pt.C0752a> list, long j, long j2) {
        C0751pt.C0752a next;
        if (list == null || list.isEmpty()) {
            return null;
        }
        long j3 = 0;
        ListIterator<C0751pt.C0752a> listIterator = list.listIterator();
        LinkedList linkedList = new LinkedList();
        while (true) {
            next = listIterator.next();
            if (next.mo5369a() + j3 > j) {
                break;
            }
            j3 += next.mo5369a();
        }
        if (next.mo5369a() + j3 >= j2) {
            linkedList.add(new C0751pt.C0752a(j2 - j, next.mo5371b()));
            return linkedList;
        }
        linkedList.add(new C0751pt.C0752a((next.mo5369a() + j3) - j, next.mo5371b()));
        long a = next.mo5369a();
        while (true) {
            j3 += a;
            if (!listIterator.hasNext()) {
                break;
            }
            next = listIterator.next();
            if (next.mo5369a() + j3 >= j2) {
                break;
            }
            linkedList.add(next);
            a = next.mo5369a();
        }
        linkedList.add(new C0751pt.C0752a(j2 - j3, next.mo5371b()));
        return linkedList;
    }

    /* renamed from: a */
    public List<C0693ny.C0694a> mo6139a() {
        return m14803b(this.f7739d.mo6139a(), (long) this.f7740f, (long) this.f7741g);
    }

    /* renamed from: b */
    static List<C0693ny.C0694a> m14803b(List<C0693ny.C0694a> list, long j, long j2) {
        C0693ny.C0694a next;
        if (list == null || list.isEmpty()) {
            return null;
        }
        long j3 = 0;
        ListIterator<C0693ny.C0694a> listIterator = list.listIterator();
        ArrayList arrayList = new ArrayList();
        while (true) {
            next = listIterator.next();
            if (((long) next.mo5142a()) + j3 > j) {
                break;
            }
            j3 += (long) next.mo5142a();
        }
        if (((long) next.mo5142a()) + j3 >= j2) {
            arrayList.add(new C0693ny.C0694a((int) (j2 - j), next.mo5144b()));
            return arrayList;
        }
        arrayList.add(new C0693ny.C0694a((int) ((((long) next.mo5142a()) + j3) - j), next.mo5144b()));
        int a = next.mo5142a();
        while (true) {
            j3 += (long) a;
            if (!listIterator.hasNext()) {
                break;
            }
            next = listIterator.next();
            if (((long) next.mo5142a()) + j3 >= j2) {
                break;
            }
            arrayList.add(next);
            a = next.mo5142a();
        }
        arrayList.add(new C0693ny.C0694a((int) (j2 - j3), next.mo5144b()));
        return arrayList;
    }

    /* renamed from: b */
    public synchronized long[] mo6140b() {
        if (this.f7739d.mo6140b() == null) {
            return null;
        }
        long[] b = this.f7739d.mo6140b();
        int length = b.length;
        int i = 0;
        while (true) {
            if (i >= b.length) {
                break;
            } else if (b[i] >= ((long) this.f7740f)) {
                break;
            } else {
                i++;
            }
        }
        while (true) {
            if (length <= 0) {
                break;
            } else if (((long) this.f7741g) >= b[length - 1]) {
                break;
            } else {
                length--;
            }
        }
        int i2 = length - i;
        long[] jArr = new long[i2];
        System.arraycopy(this.f7739d.mo6140b(), i, jArr, 0, i2);
        for (int i3 = 0; i3 < i2; i3++) {
            jArr[i3] = jArr[i3] - ((long) this.f7740f);
        }
        return jArr;
    }

    /* renamed from: c */
    public List<C0735ph.C0736a> mo6141c() {
        if (this.f7739d.mo6141c() == null || this.f7739d.mo6141c().isEmpty()) {
            return null;
        }
        return this.f7739d.mo6141c().subList(this.f7740f, this.f7741g);
    }

    /* renamed from: o */
    public C1027xk mo14o() {
        return this.f7739d.mo14o();
    }

    /* renamed from: p */
    public String mo15p() {
        return this.f7739d.mo15p();
    }

    /* renamed from: d */
    public C0746pq mo6142d() {
        return this.f7739d.mo6142d();
    }
}

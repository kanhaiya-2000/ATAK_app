package atakplugin.UASTool;

import atakplugin.UASTool.C0693ny;
import atakplugin.UASTool.C0735ph;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/* renamed from: atakplugin.UASTool.yr */
public class C1065yr implements C1026xj {

    /* renamed from: e */
    private static final Logger f7731e = Logger.getLogger(C1065yr.class.getName());

    /* renamed from: a */
    C1026xj f7732a;

    /* renamed from: b */
    List<C0693ny.C0694a> f7733b;

    /* renamed from: c */
    long[] f7734c;

    /* renamed from: d */
    long f7735d;

    public C1065yr(C1026xj xjVar, long j, long[] jArr) {
        this.f7732a = xjVar;
        this.f7735d = j;
        double b = ((double) j) / ((double) xjVar.mo14o().mo6178b());
        this.f7733b = m14786a(xjVar.mo6139a(), b);
        this.f7734c = m14788a(xjVar.mo12m(), b, jArr, m14787a(xjVar, jArr, j));
    }

    /* renamed from: a */
    private static long[] m14787a(C1026xj xjVar, long[] jArr, long j) {
        long[] jArr2 = new long[jArr.length];
        long j2 = 0;
        int i = 0;
        int i2 = 1;
        while (true) {
            long j3 = (long) i2;
            if (j3 > jArr[jArr.length - 1]) {
                return jArr2;
            }
            if (j3 == jArr[i]) {
                jArr2[i] = (j2 * j) / xjVar.mo14o().mo6178b();
                i++;
            }
            j2 += xjVar.mo12m()[i2 - 1];
            i2++;
        }
    }

    /* renamed from: a */
    static List<C0693ny.C0694a> m14786a(List<C0693ny.C0694a> list, double d) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (C0693ny.C0694a next : list) {
            arrayList.add(new C0693ny.C0694a(next.mo5142a(), (int) Math.round(((double) next.mo5144b()) * d)));
        }
        return arrayList;
    }

    /* renamed from: a */
    static long[] m14788a(long[] jArr, double d, long[] jArr2, long[] jArr3) {
        long[] jArr4 = jArr;
        long[] jArr5 = new long[jArr4.length];
        long j = 0;
        int i = 1;
        while (i <= jArr4.length) {
            int i2 = i - 1;
            long round = Math.round(((double) jArr4[i2]) * d);
            int i3 = i + 1;
            int binarySearch = Arrays.binarySearch(jArr2, (long) i3);
            if (binarySearch >= 0 && jArr3[binarySearch] != j) {
                long j2 = jArr3[binarySearch] - (j + round);
                f7731e.finest(String.format("Sample %d %d / %d - correct by %d", new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(jArr3[binarySearch]), Long.valueOf(j2)}));
                round += j2;
            }
            j += round;
            jArr5[i2] = round;
            i = i3;
        }
        return jArr5;
    }

    public void close() {
        this.f7732a.close();
    }

    /* renamed from: n */
    public C0737pi mo13n() {
        return this.f7732a.mo13n();
    }

    /* renamed from: m */
    public long[] mo12m() {
        return this.f7734c;
    }

    /* renamed from: a */
    public List<C0693ny.C0694a> mo6139a() {
        return this.f7733b;
    }

    /* renamed from: b */
    public long[] mo6140b() {
        return this.f7732a.mo6140b();
    }

    /* renamed from: c */
    public List<C0735ph.C0736a> mo6141c() {
        return this.f7732a.mo6141c();
    }

    /* renamed from: o */
    public C1027xk mo14o() {
        C1027xk xkVar = (C1027xk) this.f7732a.mo14o().clone();
        xkVar.mo6174a(this.f7735d);
        return xkVar;
    }

    /* renamed from: p */
    public String mo15p() {
        return this.f7732a.mo15p();
    }

    /* renamed from: l */
    public List<C1024xh> mo11l() {
        return this.f7732a.mo11l();
    }

    /* renamed from: d */
    public C0746pq mo6142d() {
        return this.f7732a.mo6142d();
    }

    /* renamed from: e */
    public long mo6143e() {
        long j = 0;
        for (long j2 : this.f7734c) {
            j += j2;
        }
        return j;
    }

    public String toString() {
        return "ChangeTimeScaleTrack{source=" + this.f7732a + '}';
    }

    /* renamed from: f */
    public String mo6144f() {
        return "timeScale(" + this.f7732a.mo6144f() + ")";
    }

    /* renamed from: g */
    public List<C1021xe> mo6145g() {
        return this.f7732a.mo6145g();
    }

    /* renamed from: h */
    public Map<adx, long[]> mo6146h() {
        return this.f7732a.mo6146h();
    }
}

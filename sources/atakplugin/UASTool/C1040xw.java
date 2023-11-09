package atakplugin.UASTool;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

/* renamed from: atakplugin.UASTool.xw */
public class C1040xw implements C1037xt {

    /* renamed from: a */
    private static Logger f7614a = Logger.getLogger(C1040xw.class.getName());

    /* renamed from: b */
    private final int f7615b;

    /* renamed from: c */
    private C1022xf f7616c;

    /* renamed from: d */
    private C1026xj f7617d;

    public C1040xw(C1022xf xfVar, C1026xj xjVar, int i) {
        this.f7616c = xfVar;
        this.f7617d = xjVar;
        this.f7615b = i;
    }

    /* renamed from: b */
    static String m14663b(C1026xj xjVar) {
        C0737pi n = xjVar.mo13n();
        C0728pb pbVar = (C0728pb) aft.m883a((C1003wo) n, "enc./sinf/frma");
        if (pbVar != null) {
            return pbVar.mo5280a();
        }
        return n.mo5316d().mo1476h();
    }

    /* renamed from: a */
    public long[] mo6257a(C1026xj xjVar) {
        C1026xj xjVar2 = xjVar;
        if (!"vide".equals(xjVar.mo15p())) {
            int i = 0;
            if ("soun".equals(xjVar.mo15p())) {
                if (this.f7617d == null) {
                    for (C1026xj next : this.f7616c.mo6159a()) {
                        if (next.mo6140b() != null && "vide".equals(next.mo15p()) && next.mo6140b().length > 0) {
                            this.f7617d = next;
                        }
                    }
                }
                C1026xj xjVar3 = this.f7617d;
                if (xjVar3 != null) {
                    long[] a = mo6257a(xjVar3);
                    int size = this.f7617d.mo11l().size();
                    int length = a.length;
                    long[] jArr = new long[length];
                    long j = 192000;
                    Iterator<C1026xj> it = this.f7616c.mo6159a().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        C1026xj next2 = it.next();
                        if (m14663b(xjVar).equals(m14663b(next2))) {
                            C0793rd rdVar = (C0793rd) next2.mo13n().mo5316d();
                            if (rdVar.mo5589i() < 192000) {
                                long i2 = rdVar.mo5589i();
                                double size2 = ((double) ((long) next2.mo11l().size())) / ((double) size);
                                long j2 = next2.mo12m()[0];
                                int i3 = 0;
                                while (i3 < length) {
                                    jArr[i3] = (long) Math.ceil(((double) (a[i3] - 1)) * size2 * ((double) j2));
                                    i3++;
                                    C1026xj xjVar4 = xjVar;
                                    a = a;
                                    length = length;
                                    i = 0;
                                }
                                j = i2;
                            }
                        }
                        C1026xj xjVar5 = xjVar;
                    }
                    long j3 = xjVar.mo12m()[i];
                    double i4 = ((double) ((C0793rd) xjVar.mo13n().mo5316d()).mo5589i()) / ((double) j);
                    if (i4 == Math.rint(i4)) {
                        while (i < length) {
                            jArr[i] = (long) (((((double) jArr[i]) * i4) / ((double) j3)) + 1.0d);
                            i++;
                        }
                        return jArr;
                    }
                    throw new RuntimeException("Sample rates must be a multiple of the lowest sample rate to create a correct file!");
                }
                throw new RuntimeException("There was absolutely no Track with sync samples. I can't work with that!");
            }
            for (C1026xj next3 : this.f7616c.mo6159a()) {
                if (next3.mo6140b() != null && next3.mo6140b().length > 0) {
                    long[] a2 = mo6257a(next3);
                    int size3 = next3.mo11l().size();
                    int length2 = a2.length;
                    long[] jArr2 = new long[length2];
                    double size4 = ((double) ((long) xjVar.mo11l().size())) / ((double) size3);
                    for (int i5 = 0; i5 < length2; i5++) {
                        jArr2[i5] = ((long) Math.ceil(((double) (a2[i5] - 1)) * size4)) + 1;
                    }
                    return jArr2;
                }
            }
            throw new RuntimeException("There was absolutely no Track with sync samples. I can't work with that!");
        } else if (xjVar.mo6140b() == null || xjVar.mo6140b().length <= 0) {
            throw new RuntimeException("Video Tracks need sync samples. Only tracks other than video may have no sync samples.");
        } else {
            List<long[]> a3 = m14660a(this.f7616c, xjVar2);
            return mo6258a(xjVar.mo6140b(), m14661a(xjVar2, this.f7616c), xjVar.mo14o().mo6178b(), (long[][]) a3.toArray(new long[a3.size()][]));
        }
    }

    /* renamed from: a */
    public static List<long[]> m14660a(C1022xf xfVar, C1026xj xjVar) {
        long[] b;
        LinkedList linkedList = new LinkedList();
        for (C1026xj next : xfVar.mo6159a()) {
            if (next.mo15p().equals(xjVar.mo15p()) && (b = next.mo6140b()) != null && b.length > 0) {
                linkedList.add(m14661a(next, xfVar));
            }
        }
        return linkedList;
    }

    /* renamed from: a */
    public long[] mo6258a(long[] jArr, long[] jArr2, long j, long[]... jArr3) {
        LinkedList linkedList;
        long[] jArr4 = jArr;
        long[] jArr5 = jArr2;
        long[][] jArr6 = jArr3;
        LinkedList<Long> linkedList2 = new LinkedList<>();
        LinkedList linkedList3 = new LinkedList();
        for (int i = 0; i < jArr5.length; i++) {
            int length = jArr6.length;
            boolean z = true;
            for (int i2 = 0; i2 < length; i2++) {
                z &= Arrays.binarySearch(jArr6[i2], jArr5[i]) >= 0;
            }
            if (z) {
                linkedList2.add(Long.valueOf(jArr4[i]));
                linkedList3.add(Long.valueOf(jArr5[i]));
            }
        }
        if (((double) linkedList2.size()) < ((double) jArr4.length) * 0.25d) {
            String str = "" + String.format("%5d - Common:  [", new Object[]{Integer.valueOf(linkedList2.size())});
            for (Long longValue : linkedList2) {
                long longValue2 = longValue.longValue();
                str = String.valueOf(str) + String.format("%10d,", new Object[]{Long.valueOf(longValue2)});
            }
            f7614a.warning(String.valueOf(str) + "]");
            String str2 = "" + String.format("%5d - In    :  [", new Object[]{Integer.valueOf(jArr4.length)});
            for (long j2 : jArr4) {
                str2 = String.valueOf(str2) + String.format("%10d,", new Object[]{Long.valueOf(j2)});
            }
            f7614a.warning(String.valueOf(str2) + "]");
            f7614a.warning("There are less than 25% of common sync samples in the given track.");
            throw new RuntimeException("There are less than 25% of common sync samples in the given track.");
        }
        if (((double) linkedList2.size()) < ((double) jArr4.length) * 0.5d) {
            f7614a.fine("There are less than 50% of common sync samples in the given track. This is implausible but I'm ok to continue.");
        } else if (linkedList2.size() < jArr4.length) {
            f7614a.finest("Common SyncSample positions vs. this tracks SyncSample positions: " + linkedList2.size() + " vs. " + jArr4.length);
        }
        LinkedList linkedList4 = new LinkedList();
        if (this.f7615b > 0) {
            Iterator it = linkedList2.iterator();
            Iterator it2 = linkedList3.iterator();
            long j3 = -1;
            long j4 = -1;
            while (it.hasNext() && it2.hasNext()) {
                long longValue3 = ((Long) it.next()).longValue();
                long longValue4 = ((Long) it2.next()).longValue();
                if (j4 == j3 || (longValue4 - j4) / j >= ((long) this.f7615b)) {
                    linkedList4.add(Long.valueOf(longValue3));
                    j4 = longValue4;
                }
                j3 = -1;
            }
            linkedList = linkedList4;
        } else {
            linkedList = linkedList2;
        }
        int size = linkedList.size();
        long[] jArr7 = new long[size];
        for (int i3 = 0; i3 < size; i3++) {
            jArr7[i3] = ((Long) linkedList.get(i3)).longValue();
        }
        return jArr7;
    }

    /* renamed from: a */
    private static long[] m14661a(C1026xj xjVar, C1022xf xfVar) {
        long[] b = xjVar.mo6140b();
        long[] jArr = new long[b.length];
        long b2 = m14662b(xfVar, xjVar);
        long j = 0;
        int i = 0;
        int i2 = 1;
        while (true) {
            long j2 = (long) i2;
            if (j2 > b[b.length - 1]) {
                return jArr;
            }
            if (j2 == b[i]) {
                jArr[i] = j * b2;
                i++;
            }
            j += xjVar.mo12m()[i2 - 1];
            i2++;
        }
    }

    /* renamed from: b */
    private static long m14662b(C1022xf xfVar, C1026xj xjVar) {
        long j = 1;
        for (C1026xj next : xfVar.mo6159a()) {
            if (next.mo15p().equals(xjVar.mo15p()) && next.mo14o().mo6178b() != xjVar.mo14o().mo6178b()) {
                j = afq.m875b(j, next.mo14o().mo6178b());
            }
        }
        return j;
    }
}

package atakplugin.UASTool;

import atakplugin.UASTool.C0740pl;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/* renamed from: atakplugin.UASTool.xz */
public class C1043xz extends AbstractList<C1024xh> {

    /* renamed from: j */
    private static final long f7620j = 268435456;

    /* renamed from: a */
    C0695nz f7621a;

    /* renamed from: b */
    C0754pv f7622b = null;

    /* renamed from: c */
    SoftReference<ByteBuffer[]>[] f7623c = null;

    /* renamed from: d */
    int[] f7624d;

    /* renamed from: e */
    long[] f7625e;

    /* renamed from: f */
    long[] f7626f;

    /* renamed from: g */
    long[][] f7627g;

    /* renamed from: h */
    C0738pj f7628h;

    /* renamed from: i */
    int f7629i;

    public C1043xz(long j, C0695nz nzVar) {
        int i;
        long j2 = j;
        C0695nz nzVar2 = nzVar;
        int i2 = 0;
        this.f7629i = 0;
        this.f7621a = nzVar2;
        for (C0754pv next : nzVar2.mo202a(C0723ox.class).get(0).mo202a(C0754pv.class)) {
            if (next.mo5377a().mo5394j() == j2) {
                this.f7622b = next;
            }
        }
        C0754pv pvVar = this.f7622b;
        if (pvVar != null) {
            long[] a = pvVar.mo5378b().mo5325i().mo5123a();
            this.f7625e = a;
            this.f7626f = new long[a.length];
            this.f7623c = (SoftReference[]) Array.newInstance(SoftReference.class, a.length);
            this.f7627g = new long[this.f7625e.length][];
            this.f7628h = this.f7622b.mo5378b().mo5323b();
            List<C0740pl.C0741a> c = this.f7622b.mo5378b().mo5324d().mo36c();
            C0740pl.C0741a[] aVarArr = (C0740pl.C0741a[]) c.toArray(new C0740pl.C0741a[c.size()]);
            C0740pl.C0741a aVar = aVarArr[0];
            long a2 = aVar.mo5333a();
            int a3 = afi.m847a(aVar.mo5335b());
            int size = size();
            int i3 = 0;
            int i4 = 1;
            int i5 = 0;
            int i6 = 1;
            do {
                i3++;
                if (((long) i3) == a2) {
                    if (aVarArr.length > i4) {
                        C0740pl.C0741a aVar2 = aVarArr[i4];
                        i5 = a3;
                        a3 = afi.m847a(aVar2.mo5335b());
                        i4++;
                        a2 = aVar2.mo5333a();
                    } else {
                        i5 = a3;
                        a3 = -1;
                        a2 = bfu.f2629b;
                    }
                }
                this.f7627g[i3 - 1] = new long[i5];
                i6 += i5;
            } while (i6 <= size);
            this.f7624d = new int[(i3 + 1)];
            C0740pl.C0741a aVar3 = aVarArr[0];
            long a4 = aVar3.mo5333a();
            int a5 = afi.m847a(aVar3.mo5335b());
            int i7 = 0;
            int i8 = 1;
            int i9 = 1;
            int i10 = 0;
            while (true) {
                i = i7 + 1;
                this.f7624d[i7] = i8;
                if (((long) i) == a4) {
                    if (aVarArr.length > i9) {
                        C0740pl.C0741a aVar4 = aVarArr[i9];
                        i10 = a5;
                        i9++;
                        a5 = afi.m847a(aVar4.mo5335b());
                        a4 = aVar4.mo5333a();
                    } else {
                        i10 = a5;
                        a5 = -1;
                        a4 = bfu.f2629b;
                    }
                }
                i8 += i10;
                if (i8 > size) {
                    break;
                }
                i7 = i;
            }
            this.f7624d[i] = Integer.MAX_VALUE;
            long j3 = 0;
            for (int i11 = 1; ((long) i11) <= this.f7628h.mo43i(); i11++) {
                while (i11 == this.f7624d[i2]) {
                    i2++;
                    j3 = 0;
                }
                long[] jArr = this.f7626f;
                int i12 = i2 - 1;
                int i13 = i11 - 1;
                jArr[i12] = jArr[i12] + this.f7628h.mo5319c(i13);
                this.f7627g[i12][i11 - this.f7624d[i12]] = j3;
                j3 += this.f7628h.mo5319c(i13);
            }
            return;
        }
        throw new RuntimeException("This MP4 does not contain track " + j2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized int mo6259a(int i) {
        int i2 = i + 1;
        int[] iArr = this.f7624d;
        int i3 = this.f7629i;
        if (i2 >= iArr[i3] && i2 < iArr[i3 + 1]) {
            return i3;
        }
        if (i2 < iArr[i3]) {
            this.f7629i = 0;
            while (true) {
                int[] iArr2 = this.f7624d;
                int i4 = this.f7629i;
                if (iArr2[i4 + 1] > i2) {
                    return i4;
                }
                this.f7629i = i4 + 1;
            }
        } else {
            this.f7629i = i3 + 1;
            while (true) {
                int[] iArr3 = this.f7624d;
                int i5 = this.f7629i;
                if (iArr3[i5 + 1] > i2) {
                    return i5;
                }
                this.f7629i = i5 + 1;
            }
        }
    }

    /* renamed from: b */
    public C1024xh get(int i) {
        ByteBuffer byteBuffer;
        long j;
        int i2 = i;
        if (((long) i2) < this.f7628h.mo43i()) {
            int a = mo6259a(i);
            int i3 = this.f7624d[a] - 1;
            long j2 = (long) a;
            long j3 = this.f7625e[afi.m847a(j2)];
            long[] jArr = this.f7627g[afi.m847a(j2)];
            long j4 = jArr[i2 - i3];
            SoftReference<ByteBuffer[]> softReference = this.f7623c[afi.m847a(j2)];
            ByteBuffer[] byteBufferArr = softReference != null ? softReference.get() : null;
            if (byteBufferArr == null) {
                ArrayList arrayList = new ArrayList();
                long j5 = 0;
                int i4 = 0;
                while (i4 < jArr.length) {
                    try {
                        if ((jArr[i4] + this.f7628h.mo5319c(i4 + i3)) - j5 > f7620j) {
                            j = j2;
                            arrayList.add(this.f7621a.mo201a(j3 + j5, jArr[i4] - j5));
                            j5 = jArr[i4];
                        } else {
                            j = j2;
                        }
                        i4++;
                        j2 = j;
                    } catch (IOException e) {
                        throw new IndexOutOfBoundsException(e.getMessage());
                    }
                }
                arrayList.add(this.f7621a.mo201a(j3 + j5, (-j5) + jArr[jArr.length - 1] + this.f7628h.mo5319c((i3 + jArr.length) - 1)));
                byteBufferArr = (ByteBuffer[]) arrayList.toArray(new ByteBuffer[arrayList.size()]);
                this.f7623c[afi.m847a(j2)] = new SoftReference<>(byteBufferArr);
            }
            int length = byteBufferArr.length;
            long j6 = j4;
            int i5 = 0;
            while (true) {
                if (i5 >= length) {
                    byteBuffer = null;
                    break;
                }
                ByteBuffer byteBuffer2 = byteBufferArr[i5];
                if (j6 < ((long) byteBuffer2.limit())) {
                    byteBuffer = byteBuffer2;
                    break;
                }
                j6 -= (long) byteBuffer2.limit();
                i5++;
            }
            return new C1045ya(this, this.f7628h.mo5319c(i2), byteBuffer, j6);
        }
        throw new IndexOutOfBoundsException();
    }

    public int size() {
        return afi.m847a(this.f7622b.mo5378b().mo5323b().mo43i());
    }
}

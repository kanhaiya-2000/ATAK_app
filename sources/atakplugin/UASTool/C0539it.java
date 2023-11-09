package atakplugin.UASTool;

import atakplugin.UASTool.C0560jd;
import java.util.Arrays;
import java.util.Iterator;

/* renamed from: atakplugin.UASTool.it */
final class C0539it {

    /* renamed from: a */
    static final int f5013a = 4;

    /* renamed from: b */
    static final int f5014b = 16;

    /* renamed from: c */
    static final int f5015c = 8;

    /* renamed from: d */
    private static final int f5016d = 30;

    private C0539it() {
    }

    /* renamed from: atakplugin.UASTool.it$d */
    static abstract class C0543d<E, T_ARR, T_CONS> implements Iterable<E> {

        /* renamed from: a */
        final int f5017a;

        /* renamed from: b */
        int f5018b;

        /* renamed from: c */
        int f5019c;

        /* renamed from: d */
        long[] f5020d;

        /* renamed from: e */
        T_ARR f5021e;

        /* renamed from: f */
        T_ARR[] f5022f;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract int mo4957a(T_ARR t_arr);

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public abstract T_ARR mo4962c(int i);

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public abstract T_ARR[] mo4963d(int i);

        public abstract Iterator<E> iterator();

        C0543d(int i) {
            if (i >= 0) {
                int max = Math.max(4, 32 - Integer.numberOfLeadingZeros(i - 1));
                this.f5017a = max;
                this.f5021e = mo4962c(1 << max);
                return;
            }
            throw new IllegalArgumentException("Illegal Capacity: " + i);
        }

        C0543d() {
            this.f5017a = 4;
            this.f5021e = mo4962c(1 << 4);
        }

        /* renamed from: b */
        public boolean mo4974b() {
            return this.f5019c == 0 && this.f5018b == 0;
        }

        /* renamed from: c */
        public long mo4975c() {
            int i = this.f5019c;
            return i == 0 ? (long) this.f5018b : this.f5020d[i] + ((long) this.f5018b);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: f */
        public int mo4980f(int i) {
            int i2;
            if (i == 0 || i == 1) {
                i2 = this.f5017a;
            } else {
                i2 = Math.min((this.f5017a + i) - 1, 30);
            }
            return 1 << i2;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public long mo4978d() {
            int i = this.f5019c;
            if (i == 0) {
                return (long) mo4957a(this.f5021e);
            }
            return ((long) mo4957a(this.f5022f[i])) + this.f5020d[i];
        }

        /* renamed from: a */
        private void mo4959a() {
            if (this.f5022f == null) {
                T_ARR[] d = mo4963d(8);
                this.f5022f = d;
                this.f5020d = new long[8];
                d[0] = this.f5021e;
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public final void mo4976c(long j) {
            long d = mo4978d();
            if (j > d) {
                mo4959a();
                int i = this.f5019c;
                while (true) {
                    i++;
                    if (j > d) {
                        T_ARR[] t_arrArr = this.f5022f;
                        if (i >= t_arrArr.length) {
                            int length = t_arrArr.length * 2;
                            this.f5022f = Arrays.copyOf(t_arrArr, length);
                            this.f5020d = Arrays.copyOf(this.f5020d, length);
                        }
                        int f = mo4980f(i);
                        this.f5022f[i] = mo4962c(f);
                        long[] jArr = this.f5020d;
                        int i2 = i - 1;
                        jArr[i] = jArr[i2] + ((long) mo4957a(this.f5022f[i2]));
                        d += (long) f;
                    } else {
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public void mo4979e() {
            mo4976c(mo4978d() + 1);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public int mo4977d(long j) {
            if (this.f5019c == 0) {
                if (j < ((long) this.f5018b)) {
                    return 0;
                }
                throw new IndexOutOfBoundsException(Long.toString(j));
            } else if (j < mo4975c()) {
                for (int i = 0; i <= this.f5019c; i++) {
                    if (j < this.f5020d[i] + ((long) mo4957a(this.f5022f[i]))) {
                        return i;
                    }
                }
                throw new IndexOutOfBoundsException(Long.toString(j));
            } else {
                throw new IndexOutOfBoundsException(Long.toString(j));
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo4973a(T_ARR t_arr, int i) {
            long j = (long) i;
            long c = mo4975c() + j;
            if (c > ((long) mo4957a(t_arr)) || c < j) {
                throw new IndexOutOfBoundsException("does not fit");
            } else if (this.f5019c == 0) {
                System.arraycopy(this.f5021e, 0, t_arr, i, this.f5018b);
            } else {
                for (int i2 = 0; i2 < this.f5019c; i2++) {
                    T_ARR[] t_arrArr = this.f5022f;
                    System.arraycopy(t_arrArr[i2], 0, t_arr, i, mo4957a(t_arrArr[i2]));
                    i += mo4957a(this.f5022f[i2]);
                }
                int i3 = this.f5018b;
                if (i3 > 0) {
                    System.arraycopy(this.f5021e, 0, t_arr, i, i3);
                }
            }
        }

        /* renamed from: f */
        public T_ARR mo4981f() {
            long c = mo4975c();
            C0533in.m12277a(c);
            T_ARR c2 = mo4962c((int) c);
            mo4973a(c2, 0);
            return c2;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: g */
        public void mo4982g() {
            if (this.f5018b == mo4957a(this.f5021e)) {
                mo4959a();
                int i = this.f5019c;
                int i2 = i + 1;
                T_ARR[] t_arrArr = this.f5022f;
                if (i2 >= t_arrArr.length || t_arrArr[i + 1] == null) {
                    mo4979e();
                }
                this.f5018b = 0;
                int i3 = this.f5019c + 1;
                this.f5019c = i3;
                this.f5021e = this.f5022f[i3];
            }
        }

        /* renamed from: h */
        public void mo4983h() {
            T_ARR[] t_arrArr = this.f5022f;
            if (t_arrArr != null) {
                this.f5021e = t_arrArr[0];
                this.f5022f = null;
                this.f5020d = null;
            }
            this.f5018b = 0;
            this.f5019c = 0;
        }
    }

    /* renamed from: atakplugin.UASTool.it$b */
    static class C0541b extends C0543d<Integer, int[], C0446fu> implements C0446fu {
        C0541b() {
        }

        C0541b(int i) {
            super(i);
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public int[][] mo4963d(int i) {
            return new int[i][];
        }

        /* renamed from: e */
        public int[] mo4962c(int i) {
            return new int[i];
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int mo4957a(int[] iArr) {
            return iArr.length;
        }

        /* renamed from: a */
        public void mo4921a(int i) {
            mo4982g();
            int i2 = this.f5018b;
            this.f5018b = i2 + 1;
            ((int[]) this.f5021e)[i2] = i;
        }

        /* renamed from: a */
        public int mo4965a(long j) {
            int d = mo4977d(j);
            if (this.f5019c == 0 && d == 0) {
                return ((int[]) this.f5021e)[(int) j];
            }
            return ((int[][]) this.f5022f)[d][(int) (j - this.f5020d[d])];
        }

        /* renamed from: a */
        public C0560jd.C0562b iterator() {
            return new C0545iv(this);
        }
    }

    /* renamed from: atakplugin.UASTool.it$c */
    static class C0542c extends C0543d<Long, long[], C0470gm> implements C0470gm {
        C0542c() {
        }

        C0542c(int i) {
            super(i);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public long[][] mo4963d(int i) {
            return new long[i][];
        }

        /* renamed from: b */
        public long[] mo4962c(int i) {
            return new long[i];
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int mo4957a(long[] jArr) {
            return jArr.length;
        }

        /* renamed from: a */
        public void mo4927a(long j) {
            mo4982g();
            int i = this.f5018b;
            this.f5018b = i + 1;
            ((long[]) this.f5021e)[i] = j;
        }

        /* renamed from: b */
        public long mo4971b(long j) {
            int d = mo4977d(j);
            if (this.f5019c == 0 && d == 0) {
                return ((long[]) this.f5021e)[(int) j];
            }
            return ((long[][]) this.f5022f)[d][(int) (j - this.f5020d[d])];
        }

        /* renamed from: a */
        public C0560jd.C0563c iterator() {
            return new C0546iw(this);
        }
    }

    /* renamed from: atakplugin.UASTool.it$a */
    static class C0540a extends C0543d<Double, double[], C0368dr> implements C0368dr {
        C0540a() {
        }

        C0540a(int i) {
            super(i);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public double[][] mo4963d(int i) {
            return new double[i][];
        }

        /* renamed from: b */
        public double[] mo4962c(int i) {
            return new double[i];
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int mo4957a(double[] dArr) {
            return dArr.length;
        }

        /* renamed from: a */
        public void mo4899a(double d) {
            mo4982g();
            int i = this.f5018b;
            this.f5018b = i + 1;
            ((double[]) this.f5021e)[i] = d;
        }

        /* renamed from: a */
        public double mo4956a(long j) {
            int d = mo4977d(j);
            if (this.f5019c == 0 && d == 0) {
                return ((double[]) this.f5021e)[(int) j];
            }
            return ((double[][]) this.f5022f)[d][(int) (j - this.f5020d[d])];
        }

        /* renamed from: a */
        public C0560jd.C0561a iterator() {
            return new C0544iu(this);
        }
    }
}

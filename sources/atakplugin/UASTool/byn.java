package atakplugin.UASTool;

public abstract class byn implements bxx, bxy {

    /* renamed from: a */
    private static final int f4268a = 2;

    /* renamed from: b */
    public static final int f4269b = 76;

    /* renamed from: c */
    public static final int f4270c = 64;

    /* renamed from: d */
    protected static final int f4271d = 255;

    /* renamed from: e */
    protected static final byte f4272e = 61;

    /* renamed from: m */
    private static final int f4273m = 8192;

    /* renamed from: f */
    protected final byte f4274f = f4272e;

    /* renamed from: g */
    protected final int f4275g;

    /* renamed from: h */
    protected byte[] f4276h;

    /* renamed from: i */
    protected int f4277i;

    /* renamed from: j */
    protected boolean f4278j;

    /* renamed from: k */
    protected int f4279k;

    /* renamed from: l */
    protected int f4280l;

    /* renamed from: n */
    private final int f4281n;

    /* renamed from: o */
    private final int f4282o;

    /* renamed from: p */
    private final int f4283p;

    /* renamed from: q */
    private int f4284q;

    /* renamed from: c */
    protected static boolean m10573c(byte b) {
        return b == 9 || b == 10 || b == 13 || b == 32;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo4077a(byte[] bArr, int i, int i2);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract boolean mo4078a(byte b);

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public abstract void mo4079b(byte[] bArr, int i, int i2);

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public int mo4087d() {
        return 8192;
    }

    protected byn(int i, int i2, int i3, int i4) {
        this.f4281n = i;
        this.f4282o = i2;
        this.f4275g = (i3 <= 0 || i4 <= 0) ? 0 : (i3 / i2) * i2;
        this.f4283p = i4;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo4082b() {
        return this.f4276h != null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo4084c() {
        if (this.f4276h != null) {
            return this.f4277i - this.f4284q;
        }
        return 0;
    }

    /* renamed from: a */
    private void mo4080a() {
        byte[] bArr = this.f4276h;
        if (bArr == null) {
            this.f4276h = new byte[mo4087d()];
            this.f4277i = 0;
            this.f4284q = 0;
            return;
        }
        byte[] bArr2 = new byte[(bArr.length * 2)];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        this.f4276h = bArr2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4081a(int i) {
        byte[] bArr = this.f4276h;
        if (bArr == null || bArr.length < this.f4277i + i) {
            mo4080a();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo4085c(byte[] bArr, int i, int i2) {
        if (this.f4276h == null) {
            return this.f4278j ? -1 : 0;
        }
        int min = Math.min(mo4084c(), i2);
        System.arraycopy(this.f4276h, this.f4284q, bArr, i, min);
        int i3 = this.f4284q + min;
        this.f4284q = i3;
        if (i3 >= this.f4277i) {
            this.f4276h = null;
        }
        return min;
    }

    /* renamed from: e */
    private void m10574e() {
        this.f4276h = null;
        this.f4277i = 0;
        this.f4284q = 0;
        this.f4279k = 0;
        this.f4280l = 0;
        this.f4278j = false;
    }

    /* renamed from: b */
    public Object mo4073b(Object obj) {
        if (obj instanceof byte[]) {
            return mo4071b((byte[]) obj);
        }
        throw new byd("Parameter supplied to Base-N encode is not a byte[]");
    }

    /* renamed from: l */
    public String mo4089l(byte[] bArr) {
        return bys.m10630f(mo4071b(bArr));
    }

    /* renamed from: a */
    public Object mo4072a(Object obj) {
        if (obj instanceof byte[]) {
            return mo4070a((byte[]) obj);
        }
        if (obj instanceof String) {
            return mo4086c((String) obj);
        }
        throw new byb("Parameter supplied to Base-N decode is not a byte[] or a String");
    }

    /* renamed from: c */
    public byte[] mo4086c(String str) {
        return mo4070a(bys.m10631f(str));
    }

    /* renamed from: a */
    public byte[] mo4070a(byte[] bArr) {
        m10574e();
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        mo4077a(bArr, 0, bArr.length);
        mo4077a(bArr, 0, -1);
        int i = this.f4277i;
        byte[] bArr2 = new byte[i];
        mo4085c(bArr2, 0, i);
        return bArr2;
    }

    /* renamed from: b */
    public byte[] mo4071b(byte[] bArr) {
        m10574e();
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        mo4079b(bArr, 0, bArr.length);
        mo4079b(bArr, 0, -1);
        int i = this.f4277i - this.f4284q;
        byte[] bArr2 = new byte[i];
        mo4085c(bArr2, 0, i);
        return bArr2;
    }

    /* renamed from: m */
    public String mo4090m(byte[] bArr) {
        return bys.m10630f(mo4071b(bArr));
    }

    /* renamed from: b */
    public boolean mo4083b(byte[] bArr, boolean z) {
        for (int i = 0; i < bArr.length; i++) {
            if (!mo4078a(bArr[i]) && (!z || (bArr[i] != 61 && !m10573c(bArr[i])))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: d */
    public boolean mo4088d(String str) {
        return mo4083b(bys.m10631f(str), true);
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public boolean mo4091n(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        for (int i = 0; i < bArr.length; i++) {
            if (61 == bArr[i] || mo4078a(bArr[i])) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: o */
    public long mo4092o(byte[] bArr) {
        int length = bArr.length;
        int i = this.f4281n;
        long j = ((long) (((length + i) - 1) / i)) * ((long) this.f4282o);
        int i2 = this.f4275g;
        return i2 > 0 ? j + ((((((long) i2) + j) - 1) / ((long) i2)) * ((long) this.f4283p)) : j;
    }
}

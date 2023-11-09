package atakplugin.UASTool;

import atakplugin.UASTool.can;

class cdm implements cap {

    /* renamed from: n */
    Object f4539n;

    /* renamed from: o */
    Object f4540o;

    /* renamed from: p */
    Object[] f4541p;

    /* renamed from: q */
    can.C0296b f4542q;

    /* renamed from: r */
    private ccs f4543r;

    /* renamed from: atakplugin.UASTool.cdm$b */
    static class C0307b implements can.C0296b {

        /* renamed from: a */
        String f4544a;

        /* renamed from: b */
        caq f4545b;

        /* renamed from: c */
        ccn f4546c;

        /* renamed from: d */
        private int f4547d;

        public C0307b(int i, String str, caq caq, ccn ccn) {
            this.f4544a = str;
            this.f4545b = caq;
            this.f4546c = ccn;
            this.f4547d = i;
        }

        /* renamed from: d */
        public int mo4336d() {
            return this.f4547d;
        }

        /* renamed from: c */
        public String mo4335c() {
            return this.f4544a;
        }

        /* renamed from: a */
        public caq mo4333a() {
            return this.f4545b;
        }

        /* renamed from: b */
        public ccn mo4334b() {
            return this.f4546c;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public String mo4539a(cds cds) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(cds.mo4560a(mo4335c()));
            stringBuffer.append("(");
            stringBuffer.append(((cdq) mo4333a()).mo4546b(cds));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return mo4539a(cds.f4568k);
        }

        /* renamed from: e */
        public final String mo4337e() {
            return mo4539a(cds.f4567j);
        }

        /* renamed from: f */
        public final String mo4338f() {
            return mo4539a(cds.f4569l);
        }
    }

    /* renamed from: atakplugin.UASTool.cdm$a */
    static class C0306a extends C0307b implements can.C0295a {
        public C0306a(int i, String str, caq caq, ccn ccn) {
            super(i, str, caq, ccn);
        }
    }

    public cdm(can.C0296b bVar, Object obj, Object obj2, Object[] objArr) {
        this.f4542q = bVar;
        this.f4539n = obj;
        this.f4540o = obj2;
        this.f4541p = objArr;
    }

    /* renamed from: c */
    public Object mo4325c() {
        return this.f4539n;
    }

    /* renamed from: d */
    public Object mo4326d() {
        return this.f4540o;
    }

    /* renamed from: e */
    public Object[] mo4327e() {
        if (this.f4541p == null) {
            this.f4541p = new Object[0];
        }
        Object[] objArr = this.f4541p;
        Object[] objArr2 = new Object[objArr.length];
        System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
        return objArr2;
    }

    /* renamed from: i */
    public can.C0296b mo4331i() {
        return this.f4542q;
    }

    /* renamed from: h */
    public String mo4330h() {
        return this.f4542q.mo4335c();
    }

    /* renamed from: f */
    public caq mo4328f() {
        return this.f4542q.mo4333a();
    }

    /* renamed from: g */
    public ccn mo4329g() {
        return this.f4542q.mo4334b();
    }

    public final String toString() {
        return this.f4542q.toString();
    }

    /* renamed from: a */
    public final String mo4323a() {
        return this.f4542q.mo4337e();
    }

    /* renamed from: b */
    public final String mo4324b() {
        return this.f4542q.mo4338f();
    }

    /* renamed from: a */
    public void mo4342a(ccs ccs) {
        this.f4543r = ccs;
    }

    /* renamed from: j */
    public Object mo4343j() {
        ccs ccs = this.f4543r;
        if (ccs == null) {
            return null;
        }
        return ccs.mo4454a(ccs.mo4455b());
    }

    /* renamed from: a */
    public Object mo4341a(Object[] objArr) {
        ccs ccs = this.f4543r;
        if (ccs == null) {
            return null;
        }
        int a = ccs.mo4452a();
        int i = 1048576 & a;
        int i2 = 1;
        boolean z = (65536 & a) != 0;
        int i3 = (a & 4096) != 0 ? 1 : 0;
        int i4 = (a & 256) != 0 ? 1 : 0;
        boolean z2 = (a & 16) != 0;
        boolean z3 = (a & 1) != 0;
        Object[] b = this.f4543r.mo4455b();
        int i5 = i3 + 0 + ((!z2 || z) ? 0 : 1);
        if (i3 == 0 || i4 == 0) {
            i2 = 0;
        } else {
            b[0] = objArr[0];
        }
        if (z2 && z3) {
            if (z) {
                i2 = i4 + 1;
                b[0] = objArr[i4];
            } else {
                i2 = i3 + 1;
                b[i3] = objArr[i3];
            }
        }
        for (int i6 = i2; i6 < objArr.length; i6++) {
            b[(i6 - i2) + i5] = objArr[i6];
        }
        return this.f4543r.mo4454a(b);
    }
}

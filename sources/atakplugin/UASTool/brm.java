package atakplugin.UASTool;

import java.util.ArrayList;
import java.util.List;

public final class brm extends bsd {

    /* renamed from: a */
    private static final bru f3386a = bru.m8896a("application/x-www-form-urlencoded");

    /* renamed from: b */
    private final List<String> f3387b;

    /* renamed from: c */
    private final List<String> f3388c;

    private brm(List<String> list, List<String> list2) {
        this.f3387b = bsp.m9153a(list);
        this.f3388c = bsp.m9153a(list2);
    }

    /* renamed from: a */
    public int mo3149a() {
        return this.f3387b.size();
    }

    /* renamed from: a */
    public String mo3150a(int i) {
        return this.f3387b.get(i);
    }

    /* renamed from: b */
    public String mo3151b(int i) {
        return brr.m8809a(mo3150a(i), true);
    }

    /* renamed from: c */
    public String mo3152c(int i) {
        return this.f3388c.get(i);
    }

    /* renamed from: d */
    public String mo3155d(int i) {
        return brr.m8809a(mo3152c(i), true);
    }

    public bru contentType() {
        return f3386a;
    }

    public long contentLength() {
        return m8762a((bwo) null, true);
    }

    public void writeTo(bwo bwo) {
        m8762a(bwo, false);
    }

    /* renamed from: a */
    private long m8762a(bwo bwo, boolean z) {
        bwl bwl;
        if (z) {
            bwl = new bwl();
        } else {
            bwl = bwo.mo3811b();
        }
        int size = this.f3387b.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                bwl.mo3833d(38);
            }
            bwl.mo3817b(this.f3387b.get(i));
            bwl.mo3833d(61);
            bwl.mo3817b(this.f3388c.get(i));
        }
        if (!z) {
            return 0;
        }
        long a = bwl.mo3783a();
        bwl.mo3769B();
        return a;
    }

    /* renamed from: atakplugin.UASTool.brm$a */
    public static final class C0224a {

        /* renamed from: a */
        private final List<String> f3389a = new ArrayList();

        /* renamed from: b */
        private final List<String> f3390b = new ArrayList();

        /* renamed from: a */
        public C0224a mo3157a(String str, String str2) {
            this.f3389a.add(brr.m8808a(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true));
            this.f3390b.add(brr.m8808a(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true));
            return this;
        }

        /* renamed from: b */
        public C0224a mo3159b(String str, String str2) {
            this.f3389a.add(brr.m8808a(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true));
            this.f3390b.add(brr.m8808a(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true));
            return this;
        }

        /* renamed from: a */
        public brm mo3158a() {
            return new brm(this.f3389a, this.f3390b);
        }
    }
}

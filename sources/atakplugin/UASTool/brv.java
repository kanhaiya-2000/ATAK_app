package atakplugin.UASTool;

import com.autel.util.okhttp.model.HttpMediaType;
import com.google.common.base.Ascii;
import com.google.common.net.HttpHeaders;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public final class brv extends bsd {

    /* renamed from: a */
    public static final bru f3440a = bru.m8896a(HttpMediaType.MEDIA_TYPE_MULTI_MIXED);

    /* renamed from: b */
    public static final bru f3441b = bru.m8896a(HttpMediaType.MEDIA_TYPE_MULTI_ALTERNATIVE);

    /* renamed from: c */
    public static final bru f3442c = bru.m8896a(HttpMediaType.MEDIA_TYPE_MULTI_DIGEST);

    /* renamed from: d */
    public static final bru f3443d = bru.m8896a(HttpMediaType.MEDIA_TYPE_MULTI_PARALLEL);

    /* renamed from: e */
    public static final bru f3444e = bru.m8896a(HttpMediaType.MEDIA_TYPE_MULTI_FORM);

    /* renamed from: f */
    private static final byte[] f3445f = {58, 32};

    /* renamed from: g */
    private static final byte[] f3446g = {Ascii.f8514CR, 10};

    /* renamed from: h */
    private static final byte[] f3447h = {45, 45};

    /* renamed from: i */
    private final bwq f3448i;

    /* renamed from: j */
    private final bru f3449j;

    /* renamed from: k */
    private final bru f3450k;

    /* renamed from: l */
    private final List<C0230b> f3451l;

    /* renamed from: m */
    private long f3452m = -1;

    brv(bwq bwq, bru bru, List<C0230b> list) {
        this.f3448i = bwq;
        this.f3449j = bru;
        this.f3450k = bru.m8896a(bru + "; boundary=" + bwq.mo3929c());
        this.f3451l = bsp.m9153a(list);
    }

    /* renamed from: a */
    public bru mo3259a() {
        return this.f3449j;
    }

    /* renamed from: b */
    public String mo3261b() {
        return this.f3448i.mo3929c();
    }

    /* renamed from: c */
    public int mo3262c() {
        return this.f3451l.size();
    }

    /* renamed from: d */
    public List<C0230b> mo3263d() {
        return this.f3451l;
    }

    /* renamed from: a */
    public C0230b mo3260a(int i) {
        return this.f3451l.get(i);
    }

    public bru contentType() {
        return this.f3450k;
    }

    public long contentLength() {
        long j = this.f3452m;
        if (j != -1) {
            return j;
        }
        long a = m8901a((bwo) null, true);
        this.f3452m = a;
        return a;
    }

    public void writeTo(bwo bwo) {
        m8901a(bwo, false);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v1, resolved type: atakplugin.UASTool.bwo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: atakplugin.UASTool.bwl} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: atakplugin.UASTool.bwl} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v3, resolved type: atakplugin.UASTool.bwo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: atakplugin.UASTool.bwl} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private long m8901a(atakplugin.UASTool.bwo r13, boolean r14) {
        /*
            r12 = this;
            if (r14 == 0) goto L_0x0009
            atakplugin.UASTool.bwl r13 = new atakplugin.UASTool.bwl
            r13.<init>()
            r0 = r13
            goto L_0x000a
        L_0x0009:
            r0 = 0
        L_0x000a:
            java.util.List<atakplugin.UASTool.brv$b> r1 = r12.f3451l
            int r1 = r1.size()
            r2 = 0
            r3 = 0
            r5 = 0
        L_0x0014:
            if (r5 >= r1) goto L_0x00a8
            java.util.List<atakplugin.UASTool.brv$b> r6 = r12.f3451l
            java.lang.Object r6 = r6.get(r5)
            atakplugin.UASTool.brv$b r6 = (atakplugin.UASTool.brv.C0230b) r6
            atakplugin.UASTool.brp r7 = r6.f3456a
            atakplugin.UASTool.bsd r6 = r6.f3457b
            byte[] r8 = f3447h
            r13.mo3834d((byte[]) r8)
            atakplugin.UASTool.bwq r8 = r12.f3448i
            r13.mo3816b((atakplugin.UASTool.bwq) r8)
            byte[] r8 = f3446g
            r13.mo3834d((byte[]) r8)
            if (r7 == 0) goto L_0x005c
            int r8 = r7.mo3168a()
            r9 = 0
        L_0x003c:
            if (r9 >= r8) goto L_0x005c
            java.lang.String r10 = r7.mo3169a((int) r9)
            atakplugin.UASTool.bwo r10 = r13.mo3817b((java.lang.String) r10)
            byte[] r11 = f3445f
            atakplugin.UASTool.bwo r10 = r10.mo3834d((byte[]) r11)
            java.lang.String r11 = r7.mo3171b((int) r9)
            atakplugin.UASTool.bwo r10 = r10.mo3817b((java.lang.String) r11)
            byte[] r11 = f3446g
            r10.mo3834d((byte[]) r11)
            int r9 = r9 + 1
            goto L_0x003c
        L_0x005c:
            atakplugin.UASTool.bru r7 = r6.contentType()
            if (r7 == 0) goto L_0x0075
            java.lang.String r8 = "Content-Type: "
            atakplugin.UASTool.bwo r8 = r13.mo3817b((java.lang.String) r8)
            java.lang.String r7 = r7.toString()
            atakplugin.UASTool.bwo r7 = r8.mo3817b((java.lang.String) r7)
            byte[] r8 = f3446g
            r7.mo3834d((byte[]) r8)
        L_0x0075:
            long r7 = r6.contentLength()
            r9 = -1
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 == 0) goto L_0x008f
            java.lang.String r9 = "Content-Length: "
            atakplugin.UASTool.bwo r9 = r13.mo3817b((java.lang.String) r9)
            atakplugin.UASTool.bwo r9 = r9.mo3875p(r7)
            byte[] r10 = f3446g
            r9.mo3834d((byte[]) r10)
            goto L_0x0095
        L_0x008f:
            if (r14 == 0) goto L_0x0095
            r0.mo3769B()
            return r9
        L_0x0095:
            byte[] r9 = f3446g
            r13.mo3834d((byte[]) r9)
            if (r14 == 0) goto L_0x009e
            long r3 = r3 + r7
            goto L_0x00a1
        L_0x009e:
            r6.writeTo(r13)
        L_0x00a1:
            r13.mo3834d((byte[]) r9)
            int r5 = r5 + 1
            goto L_0x0014
        L_0x00a8:
            byte[] r1 = f3447h
            r13.mo3834d((byte[]) r1)
            atakplugin.UASTool.bwq r2 = r12.f3448i
            r13.mo3816b((atakplugin.UASTool.bwq) r2)
            r13.mo3834d((byte[]) r1)
            byte[] r1 = f3446g
            r13.mo3834d((byte[]) r1)
            if (r14 == 0) goto L_0x00c4
            long r13 = r0.mo3783a()
            long r3 = r3 + r13
            r0.mo3769B()
        L_0x00c4:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.brv.m8901a(atakplugin.UASTool.bwo, boolean):long");
    }

    /* renamed from: a */
    static StringBuilder m8902a(StringBuilder sb, String str) {
        sb.append(bpg.f3093a);
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == 10) {
                sb.append("%0A");
            } else if (charAt == 13) {
                sb.append("%0D");
            } else if (charAt != '\"') {
                sb.append(charAt);
            } else {
                sb.append("%22");
            }
        }
        sb.append(bpg.f3093a);
        return sb;
    }

    /* renamed from: atakplugin.UASTool.brv$b */
    public static final class C0230b {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final brp f3456a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final bsd f3457b;

        /* renamed from: a */
        public static C0230b m8917a(bsd bsd) {
            return m8916a((brp) null, bsd);
        }

        /* renamed from: a */
        public static C0230b m8916a(brp brp, bsd bsd) {
            Objects.requireNonNull(bsd, "body == null");
            if (brp != null && brp.mo3170a("Content-Type") != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Type");
            } else if (brp == null || brp.mo3170a("Content-Length") == null) {
                return new C0230b(brp, bsd);
            } else {
                throw new IllegalArgumentException("Unexpected header: Content-Length");
            }
        }

        /* renamed from: a */
        public static C0230b m8918a(String str, String str2) {
            return m8919a(str, (String) null, bsd.create((bru) null, str2));
        }

        /* renamed from: a */
        public static C0230b m8919a(String str, String str2, bsd bsd) {
            Objects.requireNonNull(str, "name == null");
            StringBuilder sb = new StringBuilder("form-data; name=");
            brv.m8902a(sb, str);
            if (str2 != null) {
                sb.append("; filename=");
                brv.m8902a(sb, str2);
            }
            return m8916a(brp.m8780a(HttpHeaders.CONTENT_DISPOSITION, sb.toString()), bsd);
        }

        private C0230b(brp brp, bsd bsd) {
            this.f3456a = brp;
            this.f3457b = bsd;
        }
    }

    /* renamed from: atakplugin.UASTool.brv$a */
    public static final class C0229a {

        /* renamed from: a */
        private final bwq f3453a;

        /* renamed from: b */
        private bru f3454b;

        /* renamed from: c */
        private final List<C0230b> f3455c;

        public C0229a() {
            this(UUID.randomUUID().toString());
        }

        public C0229a(String str) {
            this.f3454b = brv.f3440a;
            this.f3455c = new ArrayList();
            this.f3453a = bwq.m10196b(str);
        }

        /* renamed from: a */
        public C0229a mo3265a(bru bru) {
            Objects.requireNonNull(bru, "type == null");
            if (bru.mo3252a().equals("multipart")) {
                this.f3454b = bru;
                return this;
            }
            throw new IllegalArgumentException("multipart != " + bru);
        }

        /* renamed from: a */
        public C0229a mo3267a(bsd bsd) {
            return mo3266a(C0230b.m8917a(bsd));
        }

        /* renamed from: a */
        public C0229a mo3264a(brp brp, bsd bsd) {
            return mo3266a(C0230b.m8916a(brp, bsd));
        }

        /* renamed from: a */
        public C0229a mo3268a(String str, String str2) {
            return mo3266a(C0230b.m8918a(str, str2));
        }

        /* renamed from: a */
        public C0229a mo3269a(String str, String str2, bsd bsd) {
            return mo3266a(C0230b.m8919a(str, str2, bsd));
        }

        /* renamed from: a */
        public C0229a mo3266a(C0230b bVar) {
            Objects.requireNonNull(bVar, "part == null");
            this.f3455c.add(bVar);
            return this;
        }

        /* renamed from: a */
        public brv mo3270a() {
            if (!this.f3455c.isEmpty()) {
                return new brv(this.f3453a, this.f3454b, this.f3455c);
            }
            throw new IllegalStateException("Multipart body must have at least one part.");
        }
    }
}

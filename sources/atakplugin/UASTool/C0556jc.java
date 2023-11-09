package atakplugin.UASTool;

import atakplugin.UASTool.C0560jd;

/* renamed from: atakplugin.UASTool.jc */
public final class C0556jc {
    private C0556jc() {
    }

    /* renamed from: atakplugin.UASTool.jc$b */
    public static class C0558b extends C0560jd.C0562b {

        /* renamed from: a */
        private final C0560jd.C0562b f5050a;

        /* renamed from: b */
        private final int f5051b;

        /* renamed from: c */
        private int f5052c;

        public C0558b(C0560jd.C0562b bVar) {
            this(0, 1, bVar);
        }

        public C0558b(int i, int i2, C0560jd.C0562b bVar) {
            this.f5050a = bVar;
            this.f5051b = i2;
            this.f5052c = i;
        }

        /* renamed from: b */
        public int mo5010b() {
            return this.f5052c;
        }

        public boolean hasNext() {
            return this.f5050a.hasNext();
        }

        /* renamed from: a */
        public int mo2940a() {
            int intValue = this.f5050a.next().intValue();
            this.f5052c += this.f5051b;
            return intValue;
        }
    }

    /* renamed from: atakplugin.UASTool.jc$c */
    public static class C0559c extends C0560jd.C0563c {

        /* renamed from: a */
        private final C0560jd.C0563c f5053a;

        /* renamed from: b */
        private final int f5054b;

        /* renamed from: c */
        private int f5055c;

        public C0559c(C0560jd.C0563c cVar) {
            this(0, 1, cVar);
        }

        public C0559c(int i, int i2, C0560jd.C0563c cVar) {
            this.f5053a = cVar;
            this.f5054b = i2;
            this.f5055c = i;
        }

        /* renamed from: b */
        public int mo5012b() {
            return this.f5055c;
        }

        public boolean hasNext() {
            return this.f5053a.hasNext();
        }

        /* renamed from: a */
        public long mo3698a() {
            long longValue = this.f5053a.next().longValue();
            this.f5055c += this.f5054b;
            return longValue;
        }
    }

    /* renamed from: atakplugin.UASTool.jc$a */
    public static class C0557a extends C0560jd.C0561a {

        /* renamed from: a */
        private final C0560jd.C0561a f5047a;

        /* renamed from: b */
        private final int f5048b;

        /* renamed from: c */
        private int f5049c;

        public C0557a(C0560jd.C0561a aVar) {
            this(0, 1, aVar);
        }

        public C0557a(int i, int i2, C0560jd.C0561a aVar) {
            this.f5047a = aVar;
            this.f5048b = i2;
            this.f5049c = i;
        }

        /* renamed from: b */
        public int mo5008b() {
            return this.f5049c;
        }

        public boolean hasNext() {
            return this.f5047a.hasNext();
        }

        /* renamed from: a */
        public double mo2515a() {
            double doubleValue = this.f5047a.next().doubleValue();
            this.f5049c += this.f5048b;
            return doubleValue;
        }
    }
}

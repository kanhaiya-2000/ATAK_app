package atakplugin.UASTool;

import atakplugin.UASTool.C0560jd;
import java.util.NoSuchElementException;

/* renamed from: atakplugin.UASTool.jb */
public final class C0552jb {
    private C0552jb() {
    }

    /* renamed from: atakplugin.UASTool.jb$b */
    public static abstract class C0554b extends C0560jd.C0562b {

        /* renamed from: a */
        protected int f5041a;

        /* renamed from: b */
        protected boolean f5042b;

        /* renamed from: c */
        protected boolean f5043c;

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public abstract void mo5004b();

        public boolean hasNext() {
            if (!this.f5043c) {
                mo5004b();
                this.f5043c = true;
            }
            return this.f5042b;
        }

        /* renamed from: a */
        public int mo2940a() {
            if (!this.f5043c) {
                hasNext();
            }
            if (this.f5042b) {
                int i = this.f5041a;
                mo5004b();
                return i;
            }
            throw new NoSuchElementException();
        }
    }

    /* renamed from: atakplugin.UASTool.jb$c */
    public static abstract class C0555c extends C0560jd.C0563c {

        /* renamed from: a */
        protected long f5044a;

        /* renamed from: b */
        protected boolean f5045b;

        /* renamed from: c */
        protected boolean f5046c;

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public abstract void mo5006b();

        public boolean hasNext() {
            if (!this.f5046c) {
                mo5006b();
                this.f5046c = true;
            }
            return this.f5045b;
        }

        /* renamed from: a */
        public long mo3698a() {
            if (!this.f5046c) {
                hasNext();
            }
            if (this.f5045b) {
                long j = this.f5044a;
                mo5006b();
                return j;
            }
            throw new NoSuchElementException();
        }
    }

    /* renamed from: atakplugin.UASTool.jb$a */
    public static abstract class C0553a extends C0560jd.C0561a {

        /* renamed from: a */
        protected double f5038a;

        /* renamed from: b */
        protected boolean f5039b;

        /* renamed from: c */
        protected boolean f5040c;

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public abstract void mo5002b();

        public boolean hasNext() {
            if (!this.f5040c) {
                mo5002b();
                this.f5040c = true;
            }
            return this.f5039b;
        }

        /* renamed from: a */
        public double mo2515a() {
            if (!this.f5040c) {
                hasNext();
            }
            if (this.f5039b) {
                double d = this.f5038a;
                mo5002b();
                return d;
            }
            throw new NoSuchElementException();
        }
    }
}

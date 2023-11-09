package atakplugin.UASTool;

import java.util.Stack;

public class cdc implements cdb {

    /* renamed from: atakplugin.UASTool.cdc$1 */
    class C03021 {
    }

    /* renamed from: atakplugin.UASTool.cdc$b */
    private static class C0305b extends ThreadLocal implements cda {
        private C0305b() {
        }

        C0305b(C03021 r1) {
            this();
        }

        public Object initialValue() {
            return new Stack();
        }

        /* renamed from: a */
        public Stack mo4498a() {
            return (Stack) get();
        }

        /* renamed from: b */
        public void mo4499b() {
            remove();
        }
    }

    /* renamed from: a */
    public cda mo4500a() {
        return new C0305b((C03021) null);
    }

    /* renamed from: atakplugin.UASTool.cdc$a */
    private static class C0303a extends ThreadLocal implements ccy {
        private C0303a() {
        }

        C0303a(C03021 r1) {
            this();
        }

        public Object initialValue() {
            return new C0304a();
        }

        /* renamed from: e */
        public C0304a mo4502e() {
            return (C0304a) get();
        }

        /* renamed from: d */
        public void mo4474d() {
            remove();
        }

        /* renamed from: a */
        public void mo4471a() {
            mo4502e().f4514a++;
        }

        /* renamed from: b */
        public void mo4472b() {
            C0304a e = mo4502e();
            e.f4514a--;
        }

        /* renamed from: c */
        public boolean mo4473c() {
            return mo4502e().f4514a != 0;
        }

        /* renamed from: atakplugin.UASTool.cdc$a$a */
        static class C0304a {

            /* renamed from: a */
            protected int f4514a = 0;

            C0304a() {
            }
        }
    }

    /* renamed from: b */
    public ccy mo4501b() {
        return new C0303a((C03021) null);
    }
}

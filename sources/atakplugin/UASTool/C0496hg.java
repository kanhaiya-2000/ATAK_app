package atakplugin.UASTool;

import java.util.Arrays;

/* renamed from: atakplugin.UASTool.hg */
public interface C0496hg<T> {
    boolean test(T t);

    /* renamed from: atakplugin.UASTool.hg$a */
    public static class C0497a {
        private C0497a() {
        }

        /* renamed from: a */
        public static <T> C0496hg<T> m12243a(C0496hg<? super T> hgVar, C0496hg<? super T> hgVar2) {
            return new C0498hh(hgVar, hgVar2);
        }

        /* renamed from: a */
        public static <T> C0496hg<T> m12244a(C0496hg<? super T> hgVar, C0496hg<? super T> hgVar2, C0496hg<? super T>... hgVarArr) {
            C0293ca.m10962b(hgVar);
            C0293ca.m10962b(hgVar2);
            C0293ca.m10962b(hgVarArr);
            C0293ca.m10960a(Arrays.asList(hgVarArr));
            return new C0499hi(hgVar, hgVar2, hgVarArr);
        }

        /* renamed from: b */
        public static <T> C0496hg<T> m12247b(C0496hg<? super T> hgVar, C0496hg<? super T> hgVar2) {
            return new C0500hj(hgVar, hgVar2);
        }

        /* renamed from: b */
        public static <T> C0496hg<T> m12248b(C0496hg<? super T> hgVar, C0496hg<? super T> hgVar2, C0496hg<? super T>... hgVarArr) {
            C0293ca.m10962b(hgVar);
            C0293ca.m10962b(hgVar2);
            C0293ca.m10962b(hgVarArr);
            C0293ca.m10960a(Arrays.asList(hgVarArr));
            return new C0501hk(hgVar, hgVar2, hgVarArr);
        }

        /* renamed from: c */
        public static <T> C0496hg<T> m12249c(C0496hg<? super T> hgVar, C0496hg<? super T> hgVar2) {
            return new C0502hl(hgVar, hgVar2);
        }

        /* renamed from: a */
        public static <T> C0496hg<T> m12242a(C0496hg<? super T> hgVar) {
            return new C0503hm(hgVar);
        }

        /* renamed from: a */
        public static <T> C0496hg<T> m12241a() {
            return new C0504hn();
        }

        /* renamed from: a */
        public static <T> C0496hg<T> m12245a(C0524if<? super T, Throwable> ifVar) {
            return m12246a(ifVar, false);
        }

        /* renamed from: a */
        public static <T> C0496hg<T> m12246a(C0524if<? super T, Throwable> ifVar, boolean z) {
            return new C0505ho(ifVar, z);
        }
    }
}

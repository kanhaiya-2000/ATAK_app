package atakplugin.UASTool;

/* renamed from: atakplugin.UASTool.ei */
public interface C0391ei<T, R> {
    R apply(T t);

    /* renamed from: atakplugin.UASTool.ei$a */
    public static class C0392a {
        private C0392a() {
        }

        /* renamed from: a */
        public static <V, T, R> C0391ei<V, R> m12112a(C0391ei<? super T, ? extends R> eiVar, C0391ei<? super V, ? extends T> eiVar2) {
            return m12115b(eiVar2, eiVar);
        }

        /* renamed from: b */
        public static <T, R, V> C0391ei<T, V> m12115b(C0391ei<? super T, ? extends R> eiVar, C0391ei<? super R, ? extends V> eiVar2) {
            return new C0393ej(eiVar2, eiVar);
        }

        /* renamed from: a */
        public static <T, R> C0391ei<T, R> m12113a(C0514hw<? super T, ? extends R, Throwable> hwVar) {
            return m12114a(hwVar, (Object) null);
        }

        /* renamed from: a */
        public static <T, R> C0391ei<T, R> m12114a(C0514hw<? super T, ? extends R, Throwable> hwVar, R r) {
            return new C0394ek(hwVar, r);
        }
    }
}

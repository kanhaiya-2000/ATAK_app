package atakplugin.UASTool;

import atakplugin.UASTool.ayh;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fJ(\u0010\u0002\u001a\u0004\u0018\u0001H\u0003\"\b\b\u0000\u0010\u0003*\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0005H\u0002¢\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\t0\b\"\u0004\b\u0000\u0010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\bH&J\u0014\u0010\u000b\u001a\u00020\f2\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0016J\u0014\u0010\r\u001a\u00020\u000e2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\bH\u0016¨\u0006\u0010"}, mo1538e = {"Lkotlin/coroutines/ContinuationInterceptor;", "Lkotlin/coroutines/CoroutineContext$Element;", "get", "E", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "interceptContinuation", "Lkotlin/coroutines/Continuation;", "T", "continuation", "minusKey", "Lkotlin/coroutines/CoroutineContext;", "releaseInterceptedContinuation", "", "Key", "kotlin-stdlib"})
public interface aye extends ayh.C0115b {

    /* renamed from: a */
    public static final C0113b f2381a = C0113b.f2382a;

    /* renamed from: a */
    <T> ayd<T> mo2155a(ayd<? super T> ayd);

    /* renamed from: a */
    <E extends ayh.C0115b> E mo2141a(ayh.C0117c<E> cVar);

    /* renamed from: b */
    ayh mo2145b(ayh.C0117c<?> cVar);

    /* renamed from: b */
    void mo2156b(ayd<?> ayd);

    @aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, mo1538e = {"Lkotlin/coroutines/ContinuationInterceptor$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlin/coroutines/ContinuationInterceptor;", "()V", "kotlin-stdlib"})
    /* renamed from: atakplugin.UASTool.aye$b */
    public static final class C0113b implements ayh.C0117c<aye> {

        /* renamed from: a */
        static final /* synthetic */ C0113b f2382a = new C0113b();

        private C0113b() {
        }
    }

    @aot(mo1534a = 3, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3})
    /* renamed from: atakplugin.UASTool.aye$a */
    public static final class C0112a {
        /* renamed from: a */
        public static ayh m5860a(aye aye, ayh ayh) {
            bfq.m6567f(ayh, "context");
            return ayh.C0115b.C0116a.m5886a((ayh.C0115b) aye, ayh);
        }

        /* renamed from: a */
        public static <R> R m5861a(aye aye, R r, bdw<? super R, ? super ayh.C0115b, ? extends R> bdw) {
            bfq.m6567f(bdw, "operation");
            return ayh.C0115b.C0116a.m5887a(aye, r, bdw);
        }

        /* renamed from: a */
        public static void m5862a(aye aye, ayd<?> ayd) {
            bfq.m6567f(ayd, "continuation");
        }

        /* renamed from: a */
        public static <E extends ayh.C0115b> E m5859a(aye aye, ayh.C0117c<E> cVar) {
            bfq.m6567f(cVar, "key");
            if (cVar != aye.f2381a) {
                return null;
            }
            if (aye != null) {
                return aye;
            }
            throw new apx("null cannot be cast to non-null type E");
        }

        /* renamed from: b */
        public static ayh m5863b(aye aye, ayh.C0117c<?> cVar) {
            bfq.m6567f(cVar, "key");
            ayh ayh = aye;
            if (cVar == aye.f2381a) {
                ayh = ayj.f2386a;
            }
            return ayh;
        }
    }
}

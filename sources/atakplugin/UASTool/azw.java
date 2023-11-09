package atakplugin.UASTool;

@aot(mo1534a = 5, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001aF\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00012\u001c\b\u0004\u0010\u0005\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\b¢\u0006\u0002\b\b\u001aD\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u0003*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a]\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\u0003*#\b\u0001\u0012\u0004\u0012\u0002H\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f¢\u0006\u0002\b\r2\u0006\u0010\u000e\u001a\u0002H\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0001H\u0007\u001aA\u0010\u0011\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0003*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001H\bø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001aZ\u0010\u0011\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\u0003*#\b\u0001\u0012\u0004\u0012\u0002H\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f¢\u0006\u0002\b\r2\u0006\u0010\u000e\u001a\u0002H\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001H\bø\u0001\u0000¢\u0006\u0002\u0010\u0013\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, mo1538e = {"createCoroutineFromSuspendFunction", "Lkotlin/coroutines/Continuation;", "", "T", "completion", "block", "Lkotlin/Function1;", "", "createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt", "createCoroutineUnintercepted", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "intercepted", "startCoroutineUninterceptedOrReturn", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlin-stdlib"}, mo1539f = "kotlin/coroutines/intrinsics/IntrinsicsKt", mo1541h = 1)
class azw {
    /* renamed from: b */
    private static final <T> Object m6053b(bdl<? super ayd<? super T>, ? extends Object> bdl, ayd<? super T> ayd) {
        if (bdl != null) {
            return ((bdl) bgv.m6753b((Object) bdl, 1)).invoke(ayd);
        }
        throw new apx("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
    }

    /* renamed from: b */
    private static final <R, T> Object m6054b(bdw<? super R, ? super ayd<? super T>, ? extends Object> bdw, R r, ayd<? super T> ayd) {
        if (bdw != null) {
            return ((bdw) bgv.m6753b((Object) bdw, 2)).mo2065a(r, ayd);
        }
        throw new apx("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
    }

    /* renamed from: a */
    public static final <T> ayd<aqr> m6051a(bdl<? super ayd<? super T>, ? extends Object> bdl, ayd<? super T> ayd) {
        ayd<aqr> ayd2;
        bfq.m6567f(bdl, "$this$createCoroutineUnintercepted");
        bfq.m6567f(ayd, "completion");
        ayd<? super T> a = bal.m6146a(ayd);
        if (bdl instanceof bae) {
            return ((bae) bdl).mo2216a((ayd<?>) a);
        }
        ayh a2 = a.mo2153a();
        if (a2 == ayj.f2386a) {
            if (a != null) {
                ayd2 = new azz(a, a, bdl);
            } else {
                throw new apx("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            }
        } else if (a != null) {
            ayd2 = new baa(a, a2, a, a2, bdl);
        } else {
            throw new apx("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }
        return ayd2;
    }

    /* renamed from: a */
    public static final <R, T> ayd<aqr> m6052a(bdw<? super R, ? super ayd<? super T>, ? extends Object> bdw, R r, ayd<? super T> ayd) {
        ayd<aqr> ayd2;
        bfq.m6567f(bdw, "$this$createCoroutineUnintercepted");
        bfq.m6567f(ayd, "completion");
        ayd<? super T> a = bal.m6146a(ayd);
        if (bdw instanceof bae) {
            return ((bae) bdw).mo2063a(r, a);
        }
        ayh a2 = a.mo2153a();
        if (a2 == ayj.f2386a) {
            if (a != null) {
                ayd2 = new bab(a, a, bdw, r);
            } else {
                throw new apx("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            }
        } else if (a != null) {
            ayd2 = new bac(a, a2, a, a2, bdw, r);
        } else {
            throw new apx("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }
        return ayd2;
    }

    /* renamed from: a */
    public static final <T> ayd<T> m6049a(ayd<? super T> ayd) {
        ayd<Object> f;
        bfq.m6567f(ayd, "$this$intercepted");
        bah bah = (bah) (!(ayd instanceof bah) ? null : ayd);
        return (bah == null || (f = bah.mo2221f()) == null) ? ayd : f;
    }

    /* renamed from: a */
    private static final <T> ayd<aqr> m6050a(ayd<? super T> ayd, bdl<? super ayd<? super T>, ? extends Object> bdl) {
        ayh a = ayd.mo2153a();
        if (a == ayj.f2386a) {
            if (ayd != null) {
                return new azx(bdl, ayd, ayd);
            }
            throw new apx("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        } else if (ayd != null) {
            return new azy(bdl, ayd, a, ayd, a);
        } else {
            throw new apx("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }
    }
}

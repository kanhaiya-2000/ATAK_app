package atakplugin.UASTool;

import java.util.Iterator;

@aot(mo1534a = 3, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H@¢\u0006\u0004\b\u0005\u0010\u0006"}, mo1538e = {"<anonymous>", "", "T", "R", "Lkotlin/sequences/SequenceScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
@baj(mo2223b = "_Sequences.kt", mo2224c = {1702}, mo2225d = {"$this$result", "iterator", "current", "next"}, mo2226e = {"L$0", "L$1", "L$2", "L$3"}, mo2227f = {0, 0, 0, 0}, mo2228g = "invokeSuspend", mo2229h = "kotlin.sequences.SequencesKt___SequencesKt$zipWithNext$2")
final class bml extends bao implements bdw<bkw<? super R>, ayd<? super aqr>, Object> {

    /* renamed from: a */
    Object f2897a;

    /* renamed from: b */
    Object f2898b;

    /* renamed from: c */
    Object f2899c;

    /* renamed from: d */
    Object f2900d;

    /* renamed from: e */
    int f2901e;

    /* renamed from: f */
    final /* synthetic */ bku f2902f;

    /* renamed from: g */
    final /* synthetic */ bdw f2903g;

    /* renamed from: h */
    private bkw f2904h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    bml(bku bku, bdw bdw, ayd ayd) {
        super(2, ayd);
        this.f2902f = bku;
        this.f2903g = bdw;
    }

    /* renamed from: a */
    public final ayd<aqr> mo2063a(Object obj, ayd<?> ayd) {
        bfq.m6567f(ayd, "completion");
        bml bml = new bml(this.f2902f, this.f2903g, ayd);
        bml.f2904h = (bkw) obj;
        return bml;
    }

    /* renamed from: a */
    public final Object mo2065a(Object obj, Object obj2) {
        return ((bml) mo2063a(obj, (ayd<?>) (ayd) obj2)).mo2064a(aqr.f2177a);
    }

    /* renamed from: a */
    public final Object mo2064a(Object obj) {
        Object obj2;
        bkw bkw;
        Iterator it;
        Object b = azv.m6108b();
        int i = this.f2901e;
        if (i == 0) {
            apk.m2620a(obj);
            bkw bkw2 = this.f2904h;
            Iterator a = this.f2902f.mo1859a();
            if (!a.hasNext()) {
                return aqr.f2177a;
            }
            bkw = bkw2;
            obj2 = a.next();
            it = a;
        } else if (i == 1) {
            Object obj3 = this.f2900d;
            it = (Iterator) this.f2898b;
            bkw = (bkw) this.f2897a;
            apk.m2620a(obj);
            obj2 = obj3;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        while (it.hasNext()) {
            Object next = it.next();
            Object a2 = this.f2903g.mo2065a(obj2, next);
            this.f2897a = bkw;
            this.f2898b = it;
            this.f2899c = obj2;
            this.f2900d = next;
            this.f2901e = 1;
            if (bkw.mo2727a(a2, (ayd<? super aqr>) this) == b) {
                return b;
            }
            obj2 = next;
        }
        return aqr.f2177a;
    }
}

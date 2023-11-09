package atakplugin.UASTool;

import java.util.Iterator;

@aot(mo1534a = 3, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H@¢\u0006\u0004\b\u0004\u0010\u0005"}, mo1538e = {"<anonymous>", "", "T", "Lkotlin/sequences/SequenceScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
@baj(mo2223b = "Sequences.kt", mo2224c = {67, 69}, mo2225d = {"$this$sequence", "iterator", "$this$sequence", "iterator"}, mo2226e = {"L$0", "L$1", "L$0", "L$1"}, mo2227f = {0, 0, 1, 1}, mo2228g = "invokeSuspend", mo2229h = "kotlin.sequences.SequencesKt__SequencesKt$ifEmpty$1")
final class blk extends bao implements bdw<bkw<? super T>, ayd<? super aqr>, Object> {

    /* renamed from: a */
    Object f2858a;

    /* renamed from: b */
    Object f2859b;

    /* renamed from: c */
    int f2860c;

    /* renamed from: d */
    final /* synthetic */ bku f2861d;

    /* renamed from: e */
    final /* synthetic */ bdk f2862e;

    /* renamed from: f */
    private bkw f2863f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    blk(bku bku, bdk bdk, ayd ayd) {
        super(2, ayd);
        this.f2861d = bku;
        this.f2862e = bdk;
    }

    /* renamed from: a */
    public final ayd<aqr> mo2063a(Object obj, ayd<?> ayd) {
        bfq.m6567f(ayd, "completion");
        blk blk = new blk(this.f2861d, this.f2862e, ayd);
        blk.f2863f = (bkw) obj;
        return blk;
    }

    /* renamed from: a */
    public final Object mo2065a(Object obj, Object obj2) {
        return ((blk) mo2063a(obj, (ayd<?>) (ayd) obj2)).mo2064a(aqr.f2177a);
    }

    /* renamed from: a */
    public final Object mo2064a(Object obj) {
        Object b = azv.m6108b();
        int i = this.f2860c;
        if (i == 0) {
            apk.m2620a(obj);
            bkw bkw = this.f2863f;
            Iterator a = this.f2861d.mo1859a();
            if (a.hasNext()) {
                this.f2858a = bkw;
                this.f2859b = a;
                this.f2860c = 1;
                if (bkw.mo2728a(a, (ayd<? super aqr>) this) == b) {
                    return b;
                }
            } else {
                this.f2858a = bkw;
                this.f2859b = a;
                this.f2860c = 2;
                if (bkw.mo2734a((bku) this.f2862e.invoke(), (ayd<? super aqr>) this) == b) {
                    return b;
                }
            }
        } else if (i == 1 || i == 2) {
            Iterator it = (Iterator) this.f2859b;
            bkw bkw2 = (bkw) this.f2858a;
            apk.m2620a(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return aqr.f2177a;
    }
}

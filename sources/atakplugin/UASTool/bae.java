package atakplugin.UASTool;

import atakplugin.UASTool.apj;
import java.io.Serializable;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b!\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u00032\u00020\u0004B\u0017\u0012\u0010\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001¢\u0006\u0002\u0010\u0006J$\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00012\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0016J\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\"\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0013H$ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\rH\u0014J\u001e\u0010\u0016\u001a\u00020\r2\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0013ø\u0001\u0000¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001b\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, mo1538e = {"Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Ljava/io/Serializable;", "completion", "(Lkotlin/coroutines/Continuation;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getCompletion", "()Lkotlin/coroutines/Continuation;", "create", "", "value", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "invokeSuspend", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Object;", "releaseIntercepted", "resumeWith", "(Ljava/lang/Object;)V", "toString", "", "kotlin-stdlib"})
public abstract class bae implements ayd<Object>, bai, Serializable {

    /* renamed from: a */
    private final ayd<Object> f2482a;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract Object mo2064a(Object obj);

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo2217b() {
    }

    public bae(ayd<Object> ayd) {
        this.f2482a = ayd;
    }

    /* renamed from: e */
    public final ayd<Object> mo2218e() {
        return this.f2482a;
    }

    /* renamed from: b */
    public final void mo2154b(Object obj) {
        ayd ayd = this;
        while (true) {
            bae bae = (bae) ayd;
            bal.m6147b(bae);
            ayd ayd2 = bae.f2482a;
            if (ayd2 == null) {
                bfq.m6538a();
            }
            try {
                Object a = bae.mo2064a(obj);
                if (a != azv.m6108b()) {
                    apj.C0082a aVar = apj.f2126a;
                    obj = apj.m2608e(a);
                    bae.mo2217b();
                    if (ayd2 instanceof bae) {
                        ayd = ayd2;
                    } else {
                        ayd2.mo2154b(obj);
                        return;
                    }
                } else {
                    return;
                }
            } catch (Throwable th) {
                apj.C0082a aVar2 = apj.f2126a;
                obj = apj.m2608e(apk.m2619a(th));
            }
        }
    }

    /* renamed from: a */
    public ayd<aqr> mo2216a(ayd<?> ayd) {
        bfq.m6567f(ayd, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    /* renamed from: a */
    public ayd<aqr> mo2063a(Object obj, ayd<?> ayd) {
        bfq.m6567f(ayd, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Continuation at ");
        Serializable d = mo2162d();
        if (d == null) {
            d = getClass().getName();
        }
        sb.append(d);
        return sb.toString();
    }

    /* renamed from: c */
    public bai mo2161c() {
        ayd<Object> ayd = this.f2482a;
        if (!(ayd instanceof bai)) {
            ayd = null;
        }
        return (bai) ayd;
    }

    /* renamed from: d */
    public StackTraceElement mo2162d() {
        return bak.m6141a(this);
    }
}

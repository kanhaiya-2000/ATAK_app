package atakplugin.UASTool;

import java.util.Iterator;
import java.util.NoSuchElementException;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004B\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\t\u0010\u0018\u001a\u00020\u0019H\u0002J\u000e\u0010\u001a\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001bJ\r\u0010\u001c\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001bJ\u0015\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u001fJ\u0010\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0017H\u0016J\u0019\u0010\"\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010#J\u001f\u0010$\u001a\u00020\u00052\f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010&R\u0014\u0010\u0007\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u0012\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\t¨\u0006'"}, mo1538e = {"Lkotlin/coroutines/experimental/SequenceBuilderIterator;", "T", "Lkotlin/coroutines/experimental/SequenceBuilder;", "", "Lkotlin/coroutines/experimental/Continuation;", "", "()V", "context", "Lkotlin/coroutines/experimental/CoroutineContext;", "getContext", "()Lkotlin/coroutines/experimental/CoroutineContext;", "nextIterator", "nextStep", "getNextStep", "()Lkotlin/coroutines/experimental/Continuation;", "setNextStep", "(Lkotlin/coroutines/experimental/Continuation;)V", "nextValue", "Ljava/lang/Object;", "state", "", "Lkotlin/coroutines/experimental/State;", "exceptionalState", "", "hasNext", "", "next", "()Ljava/lang/Object;", "nextNotReady", "resume", "value", "(Lkotlin/Unit;)V", "resumeWithException", "exception", "yield", "(Ljava/lang/Object;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "yieldAll", "iterator", "(Ljava/util/Iterator;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "kotlin-stdlib-coroutines"})
final class ayy<T> extends ayx<T> implements ayp<aqr>, bgz, Iterator<T> {

    /* renamed from: a */
    private int f2407a;

    /* renamed from: b */
    private T f2408b;

    /* renamed from: c */
    private Iterator<? extends T> f2409c;

    /* renamed from: d */
    private ayp<? super aqr> f2410d;

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: a */
    public final void mo2189a(ayp<? super aqr> ayp) {
        this.f2410d = ayp;
    }

    /* renamed from: b */
    public final ayp<aqr> mo2190b() {
        return this.f2410d;
    }

    public boolean hasNext() {
        while (true) {
            int i = this.f2407a;
            if (i != 0) {
                if (i == 1) {
                    Iterator<? extends T> it = this.f2409c;
                    if (it == null) {
                        bfq.m6538a();
                    }
                    if (it.hasNext()) {
                        this.f2407a = 2;
                        return true;
                    }
                    this.f2409c = null;
                } else if (i == 2 || i == 3) {
                    return true;
                } else {
                    if (i == 4) {
                        return false;
                    }
                    throw m5965d();
                }
            }
            this.f2407a = 5;
            ayp<? super aqr> ayp = this.f2410d;
            if (ayp == null) {
                bfq.m6538a();
            }
            this.f2410d = null;
            ayp.mo2176a(aqr.f2177a);
        }
    }

    public T next() {
        int i = this.f2407a;
        if (i == 0 || i == 1) {
            return m5964c();
        }
        if (i == 2) {
            this.f2407a = 1;
            Iterator<? extends T> it = this.f2409c;
            if (it == null) {
                bfq.m6538a();
            }
            return it.next();
        } else if (i == 3) {
            this.f2407a = 0;
            T t = this.f2408b;
            this.f2408b = null;
            return t;
        } else {
            throw m5965d();
        }
    }

    /* renamed from: c */
    private final T m5964c() {
        if (hasNext()) {
            return next();
        }
        throw new NoSuchElementException();
    }

    /* renamed from: d */
    private final Throwable m5965d() {
        int i = this.f2407a;
        if (i == 4) {
            return new NoSuchElementException();
        }
        if (i == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.f2407a);
    }

    /* renamed from: a */
    public Object mo2186a(T t, ayp<? super aqr> ayp) {
        this.f2408b = t;
        this.f2407a = 3;
        mo2189a(azj.m6006a(ayp));
        return azc.m5981b();
    }

    /* renamed from: a */
    public Object mo2187a(Iterator<? extends T> it, ayp<? super aqr> ayp) {
        if (!it.hasNext()) {
            return aqr.f2177a;
        }
        this.f2409c = it;
        this.f2407a = 2;
        mo2189a(azj.m6006a(ayp));
        return azc.m5981b();
    }

    /* renamed from: a */
    public void mo2176a(aqr aqr) {
        bfq.m6567f(aqr, "value");
        this.f2407a = 4;
    }

    /* renamed from: a */
    public void mo2177a(Throwable th) {
        bfq.m6567f(th, "exception");
        throw th;
    }

    /* renamed from: a */
    public ayr mo2175a() {
        return ayu.f2399a;
    }
}

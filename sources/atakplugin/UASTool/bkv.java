package atakplugin.UASTool;

import atakplugin.UASTool.apj;
import java.util.Iterator;
import java.util.NoSuchElementException;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004B\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\t\u0010\u0018\u001a\u00020\u0019H\u0002J\u000e\u0010\u001a\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001bJ\r\u0010\u001c\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001bJ\u001e\u0010\u001d\u001a\u00020\u00052\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u001fH\u0016ø\u0001\u0000¢\u0006\u0002\u0010 J\u0019\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010#J\u001f\u0010$\u001a\u00020\u00052\f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010&R\u0014\u0010\u0007\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u0012\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006'"}, mo1538e = {"Lkotlin/sequences/SequenceBuilderIterator;", "T", "Lkotlin/sequences/SequenceScope;", "", "Lkotlin/coroutines/Continuation;", "", "()V", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "nextIterator", "nextStep", "getNextStep", "()Lkotlin/coroutines/Continuation;", "setNextStep", "(Lkotlin/coroutines/Continuation;)V", "nextValue", "Ljava/lang/Object;", "state", "", "Lkotlin/sequences/State;", "exceptionalState", "", "hasNext", "", "next", "()Ljava/lang/Object;", "nextNotReady", "resumeWith", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "yield", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "yieldAll", "iterator", "(Ljava/util/Iterator;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlin-stdlib"})
final class bkv<T> extends bkw<T> implements ayd<aqr>, bgz, Iterator<T> {

    /* renamed from: a */
    private int f2839a;

    /* renamed from: b */
    private T f2840b;

    /* renamed from: c */
    private Iterator<? extends T> f2841c;

    /* renamed from: d */
    private ayd<? super aqr> f2842d;

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: a */
    public final void mo2729a(ayd<? super aqr> ayd) {
        this.f2842d = ayd;
    }

    /* renamed from: b */
    public final ayd<aqr> mo2730b() {
        return this.f2842d;
    }

    public boolean hasNext() {
        while (true) {
            int i = this.f2839a;
            if (i != 0) {
                if (i == 1) {
                    Iterator<? extends T> it = this.f2841c;
                    if (it == null) {
                        bfq.m6538a();
                    }
                    if (it.hasNext()) {
                        this.f2839a = 2;
                        return true;
                    }
                    this.f2841c = null;
                } else if (i == 2 || i == 3) {
                    return true;
                } else {
                    if (i == 4) {
                        return false;
                    }
                    throw m7439d();
                }
            }
            this.f2839a = 5;
            ayd<? super aqr> ayd = this.f2842d;
            if (ayd == null) {
                bfq.m6538a();
            }
            this.f2842d = null;
            aqr aqr = aqr.f2177a;
            apj.C0082a aVar = apj.f2126a;
            ayd.mo2154b(apj.m2608e(aqr));
        }
    }

    public T next() {
        int i = this.f2839a;
        if (i == 0 || i == 1) {
            return m7438c();
        }
        if (i == 2) {
            this.f2839a = 1;
            Iterator<? extends T> it = this.f2841c;
            if (it == null) {
                bfq.m6538a();
            }
            return it.next();
        } else if (i == 3) {
            this.f2839a = 0;
            T t = this.f2840b;
            this.f2840b = null;
            return t;
        } else {
            throw m7439d();
        }
    }

    /* renamed from: c */
    private final T m7438c() {
        if (hasNext()) {
            return next();
        }
        throw new NoSuchElementException();
    }

    /* renamed from: d */
    private final Throwable m7439d() {
        int i = this.f2839a;
        if (i == 4) {
            return new NoSuchElementException();
        }
        if (i == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.f2839a);
    }

    /* renamed from: a */
    public Object mo2727a(T t, ayd<? super aqr> ayd) {
        this.f2840b = t;
        this.f2839a = 3;
        this.f2842d = ayd;
        Object b = azv.m6108b();
        if (b == azv.m6108b()) {
            bal.m6148c(ayd);
        }
        return b;
    }

    /* renamed from: a */
    public Object mo2728a(Iterator<? extends T> it, ayd<? super aqr> ayd) {
        if (!it.hasNext()) {
            return aqr.f2177a;
        }
        this.f2841c = it;
        this.f2839a = 2;
        this.f2842d = ayd;
        Object b = azv.m6108b();
        if (b == azv.m6108b()) {
            bal.m6148c(ayd);
        }
        return b;
    }

    /* renamed from: b */
    public void mo2154b(Object obj) {
        apk.m2620a(obj);
        this.f2839a = 4;
    }

    /* renamed from: a */
    public ayh mo2153a() {
        return ayj.f2386a;
    }
}

package atakplugin.UASTool;

import java.util.concurrent.TimeUnit;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\nJ\b\u0010\r\u001a\u00020\u0004H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, mo1538e = {"Lkotlin/time/TestClock;", "Lkotlin/time/AbstractLongClock;", "()V", "reading", "", "overflow", "", "duration", "Lkotlin/time/Duration;", "overflow-LRDsOJo", "(D)V", "plusAssign", "plusAssign-LRDsOJo", "read", "kotlin-stdlib"})
public final class bpy extends bpj {

    /* renamed from: a */
    private long f3139a;

    public bpy() {
        super(TimeUnit.NANOSECONDS);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public long mo2951a() {
        return this.f3139a;
    }

    /* renamed from: a */
    public final void mo2968a(double d) {
        long j;
        double a = bpo.m8430a(d, mo2952c());
        long j2 = (long) a;
        if (j2 == Long.MIN_VALUE || j2 == bfu.f2629b) {
            double d2 = ((double) this.f3139a) + a;
            if (d2 > ((double) bfu.f2629b) || d2 < ((double) Long.MIN_VALUE)) {
                m8545b(d);
            }
            j = (long) d2;
        } else {
            long j3 = this.f3139a;
            j = j3 + j2;
            if ((j2 ^ j3) >= 0 && (j3 ^ j) < 0) {
                m8545b(d);
            }
        }
        this.f3139a = j;
    }

    /* renamed from: b */
    private final void m8545b(double d) {
        throw new IllegalStateException("TestClock will overflow if its reading " + this.f3139a + "ns is advanced by " + bpo.m8473u(d) + '.');
    }
}

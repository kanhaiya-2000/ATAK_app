package atakplugin.UASTool;

import java.util.Random;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0014J\b\u0010\f\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\nH\u0016J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nH\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0018H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, mo1538e = {"Lkotlin/random/KotlinRandom;", "Ljava/util/Random;", "impl", "Lkotlin/random/Random;", "(Lkotlin/random/Random;)V", "getImpl", "()Lkotlin/random/Random;", "seedInitialized", "", "next", "", "bits", "nextBoolean", "nextBytes", "", "bytes", "", "nextDouble", "", "nextFloat", "", "nextInt", "bound", "nextLong", "", "setSeed", "seed", "kotlin-stdlib"})
final class bhz extends Random {

    /* renamed from: a */
    private boolean f2704a;

    /* renamed from: b */
    private final bic f2705b;

    public bhz(bic bic) {
        bfq.m6567f(bic, "impl");
        this.f2705b = bic;
    }

    /* renamed from: a */
    public final bic mo2536a() {
        return this.f2705b;
    }

    /* access modifiers changed from: protected */
    public int next(int i) {
        return this.f2705b.mo2525a(i);
    }

    public int nextInt() {
        return this.f2705b.mo2528b();
    }

    public int nextInt(int i) {
        return this.f2705b.mo2529b(i);
    }

    public boolean nextBoolean() {
        return this.f2705b.mo2531d();
    }

    public long nextLong() {
        return this.f2705b.mo2530c();
    }

    public float nextFloat() {
        return this.f2705b.mo2533f();
    }

    public double nextDouble() {
        return this.f2705b.mo2532e();
    }

    public void nextBytes(byte[] bArr) {
        bfq.m6567f(bArr, "bytes");
        this.f2705b.mo2527a(bArr);
    }

    public void setSeed(long j) {
        if (!this.f2704a) {
            this.f2704a = true;
            return;
        }
        throw new UnsupportedOperationException("Setting seed is not supported.");
    }
}

package atakplugin.UASTool;

import java.util.Random;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b \u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\bH\u0016J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\bH\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, mo1538e = {"Lkotlin/random/AbstractPlatformRandom;", "Lkotlin/random/Random;", "()V", "impl", "Ljava/util/Random;", "getImpl", "()Ljava/util/Random;", "nextBits", "", "bitCount", "nextBoolean", "", "nextBytes", "", "array", "nextDouble", "", "nextFloat", "", "nextInt", "until", "nextLong", "", "kotlin-stdlib"})
public abstract class bhw extends bic {
    /* renamed from: a */
    public abstract Random mo2526a();

    /* renamed from: a */
    public int mo2525a(int i) {
        return bid.m6975a(mo2526a().nextInt(), i);
    }

    /* renamed from: b */
    public int mo2528b() {
        return mo2526a().nextInt();
    }

    /* renamed from: b */
    public int mo2529b(int i) {
        return mo2526a().nextInt(i);
    }

    /* renamed from: c */
    public long mo2530c() {
        return mo2526a().nextLong();
    }

    /* renamed from: d */
    public boolean mo2531d() {
        return mo2526a().nextBoolean();
    }

    /* renamed from: e */
    public double mo2532e() {
        return mo2526a().nextDouble();
    }

    /* renamed from: f */
    public float mo2533f() {
        return mo2526a().nextFloat();
    }

    /* renamed from: a */
    public byte[] mo2527a(byte[] bArr) {
        bfq.m6567f(bArr, "array");
        mo2526a().nextBytes(bArr);
        return bArr;
    }
}

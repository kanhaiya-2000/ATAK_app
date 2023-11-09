package atakplugin.UASTool;

import java.util.Random;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0014¨\u0006\u0004"}, mo1538e = {"kotlin/random/FallbackThreadLocalRandom$implStorage$1", "Ljava/lang/ThreadLocal;", "Ljava/util/Random;", "initialValue", "kotlin-stdlib"})
public final class bhy extends ThreadLocal<Random> {
    bhy() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Random initialValue() {
        return new Random();
    }
}

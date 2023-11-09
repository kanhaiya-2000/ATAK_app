package atakplugin.UASTool;

import java.io.BufferedInputStream;
import java.util.NoSuchElementException;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\t\u0010\u0011\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0002R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0005\"\u0004\b\u0010\u0010\u0007¨\u0006\u0015"}, mo1538e = {"kotlin/io/ByteStreamsKt$iterator$1", "Lkotlin/collections/ByteIterator;", "finished", "", "getFinished", "()Z", "setFinished", "(Z)V", "nextByte", "", "getNextByte", "()I", "setNextByte", "(I)V", "nextPrepared", "getNextPrepared", "setNextPrepared", "hasNext", "", "prepareNext", "", "kotlin-stdlib"})
public final class bbo extends atm {

    /* renamed from: a */
    final /* synthetic */ BufferedInputStream f2504a;

    /* renamed from: b */
    private int f2505b = -1;

    /* renamed from: c */
    private boolean f2506c;

    /* renamed from: d */
    private boolean f2507d;

    bbo(BufferedInputStream bufferedInputStream) {
        this.f2504a = bufferedInputStream;
    }

    /* renamed from: a */
    public final void mo2244a(int i) {
        this.f2505b = i;
    }

    /* renamed from: c */
    public final int mo2247c() {
        return this.f2505b;
    }

    /* renamed from: a */
    public final void mo2245a(boolean z) {
        this.f2506c = z;
    }

    /* renamed from: d */
    public final boolean mo2248d() {
        return this.f2506c;
    }

    /* renamed from: b */
    public final void mo2246b(boolean z) {
        this.f2507d = z;
    }

    /* renamed from: e */
    public final boolean mo2249e() {
        return this.f2507d;
    }

    /* renamed from: f */
    private final void m6209f() {
        if (!this.f2506c && !this.f2507d) {
            int read = this.f2504a.read();
            this.f2505b = read;
            boolean z = true;
            this.f2506c = true;
            if (read != -1) {
                z = false;
            }
            this.f2507d = z;
        }
    }

    public boolean hasNext() {
        m6209f();
        return !this.f2507d;
    }

    /* renamed from: b */
    public byte mo1878b() {
        m6209f();
        if (!this.f2507d) {
            byte b = (byte) this.f2505b;
            this.f2506c = false;
            return b;
        }
        throw new NoSuchElementException("Input stream is over.");
    }
}

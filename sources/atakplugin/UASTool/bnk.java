package atakplugin.UASTool;

import java.util.Iterator;
import java.util.NoSuchElementException;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000%\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\t\u0010\u0019\u001a\u00020\u001aH\u0002J\t\u0010\u001b\u001a\u00020\u0002H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR\u001a\u0010\u0014\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\b¨\u0006\u001c"}, mo1538e = {"kotlin/text/DelimitedRangesSequence$iterator$1", "", "Lkotlin/ranges/IntRange;", "counter", "", "getCounter", "()I", "setCounter", "(I)V", "currentStartIndex", "getCurrentStartIndex", "setCurrentStartIndex", "nextItem", "getNextItem", "()Lkotlin/ranges/IntRange;", "setNextItem", "(Lkotlin/ranges/IntRange;)V", "nextSearchIndex", "getNextSearchIndex", "setNextSearchIndex", "nextState", "getNextState", "setNextState", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"})
public final class bnk implements bgz, Iterator<biq> {

    /* renamed from: a */
    final /* synthetic */ bnj f3010a;

    /* renamed from: b */
    private int f3011b = -1;

    /* renamed from: c */
    private int f3012c;

    /* renamed from: d */
    private int f3013d;

    /* renamed from: e */
    private biq f3014e;

    /* renamed from: f */
    private int f3015f;

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    bnk(bnj bnj) {
        this.f3010a = bnj;
        int a = biu.m7095a(bnj.f3007b, 0, bnj.f3006a.length());
        this.f3012c = a;
        this.f3013d = a;
    }

    /* renamed from: a */
    public final int mo2821a() {
        return this.f3011b;
    }

    /* renamed from: a */
    public final void mo2822a(int i) {
        this.f3011b = i;
    }

    /* renamed from: b */
    public final int mo2824b() {
        return this.f3012c;
    }

    /* renamed from: b */
    public final void mo2825b(int i) {
        this.f3012c = i;
    }

    /* renamed from: c */
    public final int mo2826c() {
        return this.f3013d;
    }

    /* renamed from: c */
    public final void mo2827c(int i) {
        this.f3013d = i;
    }

    /* renamed from: a */
    public final void mo2823a(biq biq) {
        this.f3014e = biq;
    }

    /* renamed from: d */
    public final biq mo2828d() {
        return this.f3014e;
    }

    /* renamed from: d */
    public final void mo2829d(int i) {
        this.f3015f = i;
    }

    /* renamed from: e */
    public final int mo2830e() {
        return this.f3015f;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0023, code lost:
        if (r0 < r6.f3010a.f3008c) goto L_0x0025;
     */
    /* renamed from: g */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m7763g() {
        /*
            r6 = this;
            int r0 = r6.f3013d
            r1 = 0
            if (r0 >= 0) goto L_0x000e
            r6.f3011b = r1
            r0 = 0
            atakplugin.UASTool.biq r0 = (atakplugin.UASTool.biq) r0
            r6.f3014e = r0
            goto L_0x00a0
        L_0x000e:
            atakplugin.UASTool.bnj r0 = r6.f3010a
            int r0 = r0.f3008c
            r2 = -1
            r3 = 1
            if (r0 <= 0) goto L_0x0025
            int r0 = r6.f3015f
            int r0 = r0 + r3
            r6.f3015f = r0
            atakplugin.UASTool.bnj r4 = r6.f3010a
            int r4 = r4.f3008c
            if (r0 >= r4) goto L_0x0033
        L_0x0025:
            int r0 = r6.f3013d
            atakplugin.UASTool.bnj r4 = r6.f3010a
            java.lang.CharSequence r4 = r4.f3006a
            int r4 = r4.length()
            if (r0 <= r4) goto L_0x0049
        L_0x0033:
            int r0 = r6.f3012c
            atakplugin.UASTool.biq r1 = new atakplugin.UASTool.biq
            atakplugin.UASTool.bnj r4 = r6.f3010a
            java.lang.CharSequence r4 = r4.f3006a
            int r4 = atakplugin.UASTool.boc.m8224g(r4)
            r1.<init>(r0, r4)
            r6.f3014e = r1
            r6.f3013d = r2
            goto L_0x009e
        L_0x0049:
            atakplugin.UASTool.bnj r0 = r6.f3010a
            atakplugin.UASTool.bdw r0 = r0.f3009d
            atakplugin.UASTool.bnj r4 = r6.f3010a
            java.lang.CharSequence r4 = r4.f3006a
            int r5 = r6.f3013d
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.Object r0 = r0.mo2065a(r4, r5)
            atakplugin.UASTool.apc r0 = (atakplugin.UASTool.apc) r0
            if (r0 != 0) goto L_0x0079
            int r0 = r6.f3012c
            atakplugin.UASTool.biq r1 = new atakplugin.UASTool.biq
            atakplugin.UASTool.bnj r4 = r6.f3010a
            java.lang.CharSequence r4 = r4.f3006a
            int r4 = atakplugin.UASTool.boc.m8224g(r4)
            r1.<init>(r0, r4)
            r6.f3014e = r1
            r6.f3013d = r2
            goto L_0x009e
        L_0x0079:
            java.lang.Object r2 = r0.mo1546c()
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            java.lang.Object r0 = r0.mo1547d()
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            int r4 = r6.f3012c
            atakplugin.UASTool.biq r4 = atakplugin.UASTool.biu.m7151b((int) r4, (int) r2)
            r6.f3014e = r4
            int r2 = r2 + r0
            r6.f3012c = r2
            if (r0 != 0) goto L_0x009b
            r1 = 1
        L_0x009b:
            int r2 = r2 + r1
            r6.f3013d = r2
        L_0x009e:
            r6.f3011b = r3
        L_0x00a0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.bnk.m7763g():void");
    }

    /* renamed from: f */
    public biq next() {
        if (this.f3011b == -1) {
            m7763g();
        }
        if (this.f3011b != 0) {
            biq biq = this.f3014e;
            if (biq != null) {
                this.f3014e = null;
                this.f3011b = -1;
                return biq;
            }
            throw new apx("null cannot be cast to non-null type kotlin.ranges.IntRange");
        }
        throw new NoSuchElementException();
    }

    public boolean hasNext() {
        if (this.f3011b == -1) {
            m7763g();
        }
        return this.f3011b == 1;
    }
}

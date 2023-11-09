package atakplugin.UASTool;

import java.io.Closeable;

@aot(mo1534a = 2, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0018\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0001\u001a;\u0010\u0005\u001a\u0002H\u0006\"\n\b\u0000\u0010\u0007*\u0004\u0018\u00010\u0002\"\u0004\b\u0001\u0010\u0006*\u0002H\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u00060\tH\bø\u0001\u0000¢\u0006\u0002\u0010\u000b\u0002\b\n\u0006\b\u0011(\n0\u0001¨\u0006\f"}, mo1538e = {"closeFinally", "", "Ljava/io/Closeable;", "cause", "", "use", "R", "T", "block", "Lkotlin/Function1;", "Requires newer compiler version to be inlined correctly.", "(Ljava/io/Closeable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlin-stdlib"})
public final class bbp {
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0022, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0023, code lost:
        atakplugin.UASTool.bfn.m6527b(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002a, code lost:
        if (atakplugin.UASTool.bbg.m6171a(1, 1, 0) == false) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002c, code lost:
        if (r3 != null) goto L_0x002e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0032, code lost:
        m6218a((java.io.Closeable) r3, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0035, code lost:
        atakplugin.UASTool.bfn.m6528c(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0038, code lost:
        throw r0;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final <T extends java.io.Closeable, R> R m6217a(T r3, atakplugin.UASTool.bdl<? super T, ? extends R> r4) {
        /*
            r0 = 0
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            r1 = 0
            r2 = 1
            java.lang.Object r4 = r4.invoke(r3)     // Catch:{ all -> 0x0020 }
            atakplugin.UASTool.bfn.m6527b(r2)
            boolean r1 = atakplugin.UASTool.bbg.m6171a(r2, r2, r1)
            if (r1 == 0) goto L_0x0016
            m6218a((java.io.Closeable) r3, (java.lang.Throwable) r0)
            goto L_0x001c
        L_0x0016:
            if (r3 != 0) goto L_0x0019
            goto L_0x001c
        L_0x0019:
            r3.close()
        L_0x001c:
            atakplugin.UASTool.bfn.m6528c(r2)
            return r4
        L_0x0020:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0022 }
        L_0x0022:
            r0 = move-exception
            atakplugin.UASTool.bfn.m6527b(r2)
            boolean r1 = atakplugin.UASTool.bbg.m6171a(r2, r2, r1)
            if (r1 != 0) goto L_0x0032
            if (r3 == 0) goto L_0x0035
            r3.close()     // Catch:{ all -> 0x0035 }
            goto L_0x0035
        L_0x0032:
            m6218a((java.io.Closeable) r3, (java.lang.Throwable) r4)
        L_0x0035:
            atakplugin.UASTool.bfn.m6528c(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.bbp.m6217a(java.io.Closeable, atakplugin.UASTool.bdl):java.lang.Object");
    }

    /* renamed from: a */
    public static final void m6218a(Closeable closeable, Throwable th) {
        if (closeable != null) {
            if (th == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th2) {
                aoa.m2473a(th, th2);
            }
        }
    }
}

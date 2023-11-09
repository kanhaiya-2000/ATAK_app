package atakplugin.UASTool;

@aot(mo1534a = 1, mo1535b = {1, 1, 11}, mo1536c = {1, 0, 2}, mo1537d = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo1538e = {"Lokio/PeekSource;", "Lokio/Source;", "upstream", "Lokio/BufferedSource;", "(Lokio/BufferedSource;)V", "buffer", "Lokio/Buffer;", "closed", "", "expectedPos", "", "expectedSegment", "Lokio/Segment;", "pos", "", "close", "", "read", "sink", "byteCount", "timeout", "Lokio/Timeout;", "jvm"})
public final class bxe implements bxr {

    /* renamed from: a */
    private final bwl f4172a;

    /* renamed from: b */
    private bxm f4173b;

    /* renamed from: c */
    private int f4174c;

    /* renamed from: d */
    private boolean f4175d;

    /* renamed from: e */
    private long f4176e;

    /* renamed from: f */
    private final bwp f4177f;

    public bxe(bwp bwp) {
        bfq.m6567f(bwp, "upstream");
        this.f4177f = bwp;
        bwl c = bwp.mo3825c();
        this.f4172a = c;
        this.f4173b = c.f4122a;
        bxm bxm = c.f4122a;
        this.f4174c = bxm != null ? bxm.f4200b : -1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0022, code lost:
        if (r0 == r2.f4200b) goto L_0x0026;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long mo3425a(atakplugin.UASTool.bwl r9, long r10) {
        /*
            r8 = this;
            java.lang.String r0 = "sink"
            atakplugin.UASTool.bfq.m6567f(r9, r0)
            boolean r0 = r8.f4175d
            r1 = 1
            r0 = r0 ^ r1
            if (r0 == 0) goto L_0x0080
            atakplugin.UASTool.bxm r0 = r8.f4173b
            if (r0 == 0) goto L_0x0026
            atakplugin.UASTool.bwl r2 = r8.f4172a
            atakplugin.UASTool.bxm r2 = r2.f4122a
            if (r0 != r2) goto L_0x0025
            int r0 = r8.f4174c
            atakplugin.UASTool.bwl r2 = r8.f4172a
            atakplugin.UASTool.bxm r2 = r2.f4122a
            if (r2 != 0) goto L_0x0020
            atakplugin.UASTool.bfq.m6538a()
        L_0x0020:
            int r2 = r2.f4200b
            if (r0 != r2) goto L_0x0025
            goto L_0x0026
        L_0x0025:
            r1 = 0
        L_0x0026:
            if (r1 == 0) goto L_0x0072
            atakplugin.UASTool.bwp r0 = r8.f4177f
            long r1 = r8.f4176e
            long r1 = r1 + r10
            r0.mo3829c((long) r1)
            atakplugin.UASTool.bxm r0 = r8.f4173b
            if (r0 != 0) goto L_0x004d
            atakplugin.UASTool.bwl r0 = r8.f4172a
            atakplugin.UASTool.bxm r0 = r0.f4122a
            if (r0 == 0) goto L_0x004d
            atakplugin.UASTool.bwl r0 = r8.f4172a
            atakplugin.UASTool.bxm r0 = r0.f4122a
            r8.f4173b = r0
            atakplugin.UASTool.bwl r0 = r8.f4172a
            atakplugin.UASTool.bxm r0 = r0.f4122a
            if (r0 != 0) goto L_0x0049
            atakplugin.UASTool.bfq.m6538a()
        L_0x0049:
            int r0 = r0.f4200b
            r8.f4174c = r0
        L_0x004d:
            atakplugin.UASTool.bwl r0 = r8.f4172a
            long r0 = r0.mo3783a()
            long r2 = r8.f4176e
            long r0 = r0 - r2
            long r10 = java.lang.Math.min(r10, r0)
            r0 = 0
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r2 > 0) goto L_0x0063
            r9 = -1
            return r9
        L_0x0063:
            atakplugin.UASTool.bwl r2 = r8.f4172a
            long r4 = r8.f4176e
            r3 = r9
            r6 = r10
            r2.mo3792a((atakplugin.UASTool.bwl) r3, (long) r4, (long) r6)
            long r0 = r8.f4176e
            long r0 = r0 + r10
            r8.f4176e = r0
            return r10
        L_0x0072:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "Peek source is invalid because upstream source was used"
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            throw r9
        L_0x0080:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "closed"
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.bxe.mo3425a(atakplugin.UASTool.bwl, long):long");
    }

    public bxs timeout() {
        return this.f4177f.timeout();
    }

    public void close() {
        this.f4175d = true;
    }
}

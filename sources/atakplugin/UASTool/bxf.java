package atakplugin.UASTool;

@aot(mo1534a = 1, mo1535b = {1, 1, 11}, mo1536c = {1, 0, 2}, mo1537d = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\r\u0010\u000b\u001a\u00020\fH\u0007¢\u0006\u0002\b\u001aJ\r\u0010\u0014\u001a\u00020\u0015H\u0007¢\u0006\u0002\b\u001bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u000b\u001a\u00020\f8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u00020\u00158\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013¨\u0006\u001c"}, mo1538e = {"Lokio/Pipe;", "", "maxBufferSize", "", "(J)V", "buffer", "Lokio/Buffer;", "getBuffer$jvm", "()Lokio/Buffer;", "getMaxBufferSize$jvm", "()J", "sink", "Lokio/Sink;", "()Lokio/Sink;", "sinkClosed", "", "getSinkClosed$jvm", "()Z", "setSinkClosed$jvm", "(Z)V", "source", "Lokio/Source;", "()Lokio/Source;", "sourceClosed", "getSourceClosed$jvm", "setSourceClosed$jvm", "-deprecated_sink", "-deprecated_source", "jvm"})
public final class bxf {

    /* renamed from: a */
    private final bwl f4178a = new bwl();

    /* renamed from: b */
    private boolean f4179b;

    /* renamed from: c */
    private boolean f4180c;

    /* renamed from: d */
    private final bxp f4181d;

    /* renamed from: e */
    private final bxr f4182e;

    /* renamed from: f */
    private final long f4183f;

    public bxf(long j) {
        this.f4183f = j;
        if (j >= 1) {
            this.f4181d = new bxg(this);
            this.f4182e = new bxh(this);
            return;
        }
        throw new IllegalArgumentException(("maxBufferSize < 1: " + j).toString());
    }

    /* renamed from: h */
    public final long mo4042h() {
        return this.f4183f;
    }

    /* renamed from: a */
    public final bwl mo4033a() {
        return this.f4178a;
    }

    /* renamed from: a */
    public final void mo4034a(boolean z) {
        this.f4179b = z;
    }

    /* renamed from: b */
    public final boolean mo4036b() {
        return this.f4179b;
    }

    /* renamed from: b */
    public final void mo4035b(boolean z) {
        this.f4180c = z;
    }

    /* renamed from: c */
    public final boolean mo4037c() {
        return this.f4180c;
    }

    /* renamed from: d */
    public final bxp mo4038d() {
        return this.f4181d;
    }

    /* renamed from: e */
    public final bxr mo4039e() {
        return this.f4182e;
    }

    @anx(mo1516a = "moved to val", mo1517b = @C0081api(mo1552a = "sink", mo1553b = {}), mo1518c = any.ERROR)
    /* renamed from: f */
    public final bxp mo4040f() {
        return this.f4181d;
    }

    @anx(mo1516a = "moved to val", mo1517b = @C0081api(mo1552a = "source", mo1553b = {}), mo1518c = any.ERROR)
    /* renamed from: g */
    public final bxr mo4041g() {
        return this.f4182e;
    }
}

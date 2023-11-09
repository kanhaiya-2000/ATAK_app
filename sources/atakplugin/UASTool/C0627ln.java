package atakplugin.UASTool;

import atakplugin.UASTool.C0560jd;

/* renamed from: atakplugin.UASTool.ln */
public class C0627ln extends C0560jd.C0563c {

    /* renamed from: a */
    private final long f5215a;

    /* renamed from: b */
    private long f5216b;

    /* renamed from: c */
    private boolean f5217c;

    public C0627ln(long j, long j2) {
        this.f5215a = j2;
        this.f5216b = j;
        this.f5217c = j <= j2;
    }

    public boolean hasNext() {
        return this.f5217c;
    }

    /* renamed from: a */
    public long mo3698a() {
        long j = this.f5216b;
        long j2 = this.f5215a;
        if (j >= j2) {
            this.f5217c = false;
            return j2;
        }
        this.f5216b = 1 + j;
        return j;
    }
}

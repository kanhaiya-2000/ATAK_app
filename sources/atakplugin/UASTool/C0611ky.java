package atakplugin.UASTool;

import atakplugin.UASTool.C0560jd;

/* renamed from: atakplugin.UASTool.ky */
public class C0611ky extends C0560jd.C0563c {

    /* renamed from: a */
    private final long[] f5176a;

    /* renamed from: b */
    private int f5177b = 0;

    public C0611ky(long[] jArr) {
        this.f5176a = jArr;
    }

    /* renamed from: a */
    public long mo3698a() {
        long[] jArr = this.f5176a;
        int i = this.f5177b;
        this.f5177b = i + 1;
        return jArr[i];
    }

    public boolean hasNext() {
        return this.f5177b < this.f5176a.length;
    }
}

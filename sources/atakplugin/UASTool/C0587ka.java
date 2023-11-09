package atakplugin.UASTool;

import atakplugin.UASTool.C0560jd;

/* renamed from: atakplugin.UASTool.ka */
public class C0587ka extends C0560jd.C0562b {

    /* renamed from: a */
    private final int[] f5113a;

    /* renamed from: b */
    private int f5114b = 0;

    public C0587ka(int[] iArr) {
        this.f5113a = iArr;
    }

    public boolean hasNext() {
        return this.f5114b < this.f5113a.length;
    }

    /* renamed from: a */
    public int mo2940a() {
        int[] iArr = this.f5113a;
        int i = this.f5114b;
        this.f5114b = i + 1;
        return iArr[i];
    }
}

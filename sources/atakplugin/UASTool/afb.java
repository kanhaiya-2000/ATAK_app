package atakplugin.UASTool;

import java.io.InputStream;

public class afb {

    /* renamed from: b */
    protected static int f843b;

    /* renamed from: a */
    int f844a;

    /* renamed from: c */
    protected aeq f845c = new aeq(50);

    /* renamed from: d */
    private InputStream f846d;

    /* renamed from: e */
    private int f847e;

    /* renamed from: f */
    private int f848f;

    /* renamed from: h */
    public void mo545h() {
    }

    public afb(InputStream inputStream) {
        this.f846d = inputStream;
        this.f847e = inputStream.read();
        this.f848f = inputStream.read();
    }

    /* renamed from: a */
    public boolean mo537a() {
        return mo538b() == 1;
    }

    /* renamed from: b */
    public int mo538b() {
        if (this.f844a == 8) {
            mo557j();
            if (this.f847e == -1) {
                return -1;
            }
        }
        int i = this.f847e;
        int i2 = this.f844a;
        int i3 = (i >> (7 - i2)) & 1;
        this.f844a = i2 + 1;
        this.f845c.mo514a(i3 == 0 ? '0' : '1');
        f843b++;
        return i3;
    }

    /* renamed from: a */
    public long mo536a(int i) {
        if (i <= 64) {
            long j = 0;
            for (int i2 = 0; i2 < i; i2++) {
                j = (j << 1) | ((long) mo538b());
            }
            return j;
        }
        throw new IllegalArgumentException("Can not readByte more then 64 bit");
    }

    /* renamed from: j */
    private void mo557j() {
        this.f847e = this.f848f;
        this.f848f = this.f846d.read();
        this.f844a = 0;
    }

    /* renamed from: c */
    public int mo540c() {
        if (this.f844a > 0) {
            mo557j();
        }
        int i = this.f847e;
        mo557j();
        return i;
    }

    /* renamed from: d */
    public boolean mo541d() {
        if (this.f844a == 8) {
            mo557j();
        }
        int i = 1 << ((8 - this.f844a) - 1);
        int i2 = this.f847e;
        boolean z = (((i << 1) - 1) & i2) == i;
        if (i2 == -1 || (this.f848f == -1 && z)) {
            return false;
        }
        return true;
    }

    /* renamed from: e */
    public long mo542e() {
        return (long) ((f843b * 8) + (this.f844a % 8));
    }

    /* renamed from: f */
    public long mo543f() {
        return mo536a(8 - this.f844a);
    }

    /* renamed from: b */
    public int mo539b(int i) {
        if (i <= 8) {
            if (this.f844a == 8) {
                mo557j();
                if (this.f847e == -1) {
                    return -1;
                }
            }
            int i2 = this.f844a;
            int[] iArr = new int[(16 - i2)];
            int i3 = 0;
            while (i2 < 8) {
                iArr[i3] = (this.f847e >> (7 - i2)) & 1;
                i2++;
                i3++;
            }
            int i4 = 0;
            while (i4 < 8) {
                iArr[i3] = (this.f848f >> (7 - i4)) & 1;
                i4++;
                i3++;
            }
            int i5 = 0;
            for (int i6 = 0; i6 < i; i6++) {
                i5 = (i5 << 1) | iArr[i6];
            }
            return i5;
        }
        throw new IllegalArgumentException("N should be less then 8");
    }

    /* renamed from: g */
    public boolean mo544g() {
        return this.f844a % 8 == 0;
    }

    /* renamed from: i */
    public int mo546i() {
        return this.f844a;
    }
}

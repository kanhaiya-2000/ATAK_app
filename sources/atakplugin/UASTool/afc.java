package atakplugin.UASTool;

import java.io.InputStream;

public class afc extends afb {
    public afc(InputStream inputStream) {
        super(inputStream);
    }

    /* renamed from: a */
    public long mo548a(int i, String str) {
        long a = mo536a(i);
        m812a(str, String.valueOf(a));
        return a;
    }

    /* renamed from: m */
    private int m813m() {
        int i = 0;
        while (mo538b() == 0) {
            i++;
        }
        if (i <= 0) {
            return 0;
        }
        return (int) (((long) ((1 << i) - 1)) + mo536a(i));
    }

    /* renamed from: a */
    public int mo547a(String str) {
        int m = m813m();
        m812a(str, String.valueOf(m));
        return m;
    }

    /* renamed from: b */
    public int mo551b(String str) {
        int m = m813m();
        int i = m & 1;
        int i2 = ((m >> 1) + i) * ((i << 1) - 1);
        m812a(str, String.valueOf(i2));
        return i2;
    }

    /* renamed from: c */
    public boolean mo552c(String str) {
        boolean z = mo538b() != 0;
        m812a(str, z ? "1" : "0");
        return z;
    }

    /* renamed from: b */
    public int mo550b(int i, String str) {
        return (int) mo548a(i, str);
    }

    /* renamed from: c */
    public byte[] mo553c(int i) {
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) mo540c();
        }
        return bArr;
    }

    /* renamed from: j */
    public boolean mo557j() {
        throw new UnsupportedOperationException("Stan");
    }

    /* renamed from: d */
    public int mo554d(int i) {
        if (i > 1) {
            return m813m();
        }
        return (~mo538b()) & 1;
    }

    /* renamed from: k */
    public int mo558k() {
        throw new UnsupportedOperationException("Stan");
    }

    /* renamed from: d */
    public int mo555d(String str) {
        return mo547a(str);
    }

    /* renamed from: a */
    public Object mo549a(aep aep, String str) {
        Object a;
        do {
            aep = aep.mo510a(mo538b());
            if (aep != null) {
                a = aep.mo511a();
            } else {
                throw new RuntimeException("Illegal code");
            }
        } while (a == null);
        m812a(str, a.toString());
        return a;
    }

    /* renamed from: e */
    public int mo556e(String str) {
        int i = 0;
        while (mo538b() == 0) {
            i++;
        }
        m812a(str, String.valueOf(i));
        return i;
    }

    /* renamed from: l */
    public void mo559l() {
        mo538b();
        mo543f();
    }

    /* renamed from: a */
    private void m812a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        String valueOf = String.valueOf(afb.f843b - this.f845c.mo516b());
        int length = 8 - valueOf.length();
        sb.append("@" + valueOf);
        for (int i = 0; i < length; i++) {
            sb.append(' ');
        }
        sb.append(str);
        int length2 = (100 - sb.length()) - this.f845c.mo516b();
        for (int i2 = 0; i2 < length2; i2++) {
            sb.append(' ');
        }
        sb.append(this.f845c);
        sb.append(" (" + str2 + ")");
        this.f845c.mo513a();
        aer.m777b(sb.toString());
    }
}

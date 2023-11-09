package atakplugin.UASTool;

import java.io.OutputStream;

public class afe extends afd {
    public afe(OutputStream outputStream) {
        super(outputStream);
    }

    /* renamed from: a */
    public void mo566a(int i, int i2, String str) {
        aer.m772a(String.valueOf(str) + "\t");
        mo562a((long) i, i2);
        aer.m777b("\t" + i);
    }

    /* renamed from: c */
    public void mo572c(int i) {
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= 15) {
                break;
            }
            int i5 = (1 << i3) + i4;
            if (i < i5) {
                i2 = i3;
                break;
            } else {
                i3++;
                i4 = i5;
            }
        }
        mo562a(0, i2);
        mo561a(1);
        mo562a((long) (i - i4), i2);
    }

    /* renamed from: a */
    public void mo567a(int i, String str) {
        aer.m772a(String.valueOf(str) + "\t");
        mo572c(i);
        aer.m777b("\t" + i);
    }

    /* renamed from: b */
    public void mo570b(int i, String str) {
        aer.m772a(String.valueOf(str) + "\t");
        int i2 = 1;
        int i3 = (i << 1) * (i < 0 ? -1 : 1);
        if (i <= 0) {
            i2 = 0;
        }
        mo572c(i3 + i2);
        aer.m777b("\t" + i);
    }

    /* renamed from: a */
    public void mo569a(boolean z, String str) {
        aer.m772a(String.valueOf(str) + "\t");
        mo561a(z ? 1 : 0);
        aer.m777b("\t" + z);
    }

    /* renamed from: a */
    public void mo565a(int i, int i2) {
        mo562a((long) i, i2);
    }

    /* renamed from: a */
    public void mo568a(long j, int i, String str) {
        aer.m772a(String.valueOf(str) + "\t");
        for (int i2 = 0; i2 < i; i2++) {
            mo561a(((int) (j >> ((i - i2) - 1))) & 1);
        }
        aer.m777b("\t" + j);
    }

    /* renamed from: c */
    public void mo571c() {
        mo561a(1);
        mo563b();
        mo560a();
    }

    /* renamed from: d */
    public void mo573d() {
        throw new IllegalStateException("todo");
    }
}

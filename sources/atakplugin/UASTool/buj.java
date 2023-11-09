package atakplugin.UASTool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

class buj {

    /* renamed from: a */
    private final bwz f3914a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f3915b;

    /* renamed from: c */
    private final bwp f3916c;

    public buj(bwp bwp) {
        bwz bwz = new bwz((bxr) new buk(this, bwp), (Inflater) new bul(this));
        this.f3914a = bwz;
        this.f3916c = bxb.m10330a((bxr) bwz);
    }

    /* renamed from: a */
    public List<bue> mo3643a(int i) {
        this.f3915b += i;
        int o = this.f3916c.mo3872o();
        if (o < 0) {
            throw new IOException("numberOfPairs < 0: " + o);
        } else if (o <= 1024) {
            ArrayList arrayList = new ArrayList(o);
            int i2 = 0;
            while (i2 < o) {
                bwq k = m9651b().mo3948k();
                bwq b = m9651b();
                if (k.mo3951n() != 0) {
                    arrayList.add(new bue(k, b));
                    i2++;
                } else {
                    throw new IOException("name.size == 0");
                }
            }
            m9652c();
            return arrayList;
        } else {
            throw new IOException("numberOfPairs > 1024: " + o);
        }
    }

    /* renamed from: b */
    private bwq m9651b() {
        return this.f3916c.mo3838e((long) this.f3916c.mo3872o());
    }

    /* renamed from: c */
    private void m9652c() {
        if (this.f3915b > 0) {
            this.f3914a.mo4013a();
            if (this.f3915b != 0) {
                throw new IOException("compressedLimit > 0: " + this.f3915b);
            }
        }
    }

    /* renamed from: a */
    public void mo3644a() {
        this.f3916c.close();
    }
}

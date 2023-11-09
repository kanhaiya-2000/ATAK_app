package atakplugin.UASTool;

import java.util.Arrays;

@aot(mo1534a = 1, mo1535b = {1, 1, 11}, mo1536c = {1, 0, 2}, mo1537d = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B/\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u0004\u0018\u00010\u0000J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0000J\u0006\u0010\u0013\u001a\u00020\u0000J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0006J\u0006\u0010\u0016\u001a\u00020\u0000J\u0016\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0006R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u0004\u0018\u00010\u00008\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0004\u0018\u00010\u00008\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, mo1538e = {"Lokio/Segment;", "", "()V", "data", "", "pos", "", "limit", "shared", "", "owner", "([BIIZZ)V", "next", "prev", "compact", "", "pop", "push", "segment", "sharedCopy", "split", "byteCount", "unsharedCopy", "writeTo", "sink", "Companion", "jvm"})
public final class bxm {

    /* renamed from: h */
    public static final int f4196h = 8192;

    /* renamed from: i */
    public static final int f4197i = 1024;

    /* renamed from: j */
    public static final C0282a f4198j = new C0282a((bfd) null);

    /* renamed from: a */
    public final byte[] f4199a;

    /* renamed from: b */
    public int f4200b;

    /* renamed from: c */
    public int f4201c;

    /* renamed from: d */
    public boolean f4202d;

    /* renamed from: e */
    public boolean f4203e;

    /* renamed from: f */
    public bxm f4204f;

    /* renamed from: g */
    public bxm f4205g;

    public bxm() {
        this.f4199a = new byte[8192];
        this.f4203e = true;
        this.f4202d = false;
    }

    public bxm(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        bfq.m6567f(bArr, "data");
        this.f4199a = bArr;
        this.f4200b = i;
        this.f4201c = i2;
        this.f4202d = z;
        this.f4203e = z2;
    }

    /* renamed from: a */
    public final bxm mo4059a() {
        this.f4202d = true;
        return new bxm(this.f4199a, this.f4200b, this.f4201c, true, false);
    }

    /* renamed from: b */
    public final bxm mo4063b() {
        byte[] bArr = this.f4199a;
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        bfq.m6554b(copyOf, "java.util.Arrays.copyOf(this, size)");
        return new bxm(copyOf, this.f4200b, this.f4201c, false, true);
    }

    /* renamed from: c */
    public final bxm mo4064c() {
        bxm bxm = this.f4204f;
        if (bxm == this) {
            bxm = null;
        }
        bxm bxm2 = this.f4205g;
        if (bxm2 == null) {
            bfq.m6538a();
        }
        bxm2.f4204f = this.f4204f;
        bxm bxm3 = this.f4204f;
        if (bxm3 == null) {
            bfq.m6538a();
        }
        bxm3.f4205g = this.f4205g;
        bxm bxm4 = null;
        this.f4204f = bxm4;
        this.f4205g = bxm4;
        return bxm;
    }

    /* renamed from: a */
    public final bxm mo4061a(bxm bxm) {
        bfq.m6567f(bxm, "segment");
        bxm.f4205g = this;
        bxm.f4204f = this.f4204f;
        bxm bxm2 = this.f4204f;
        if (bxm2 == null) {
            bfq.m6538a();
        }
        bxm2.f4205g = bxm;
        this.f4204f = bxm;
        return bxm;
    }

    /* renamed from: a */
    public final bxm mo4060a(int i) {
        bxm bxm;
        if (i > 0 && i <= this.f4201c - this.f4200b) {
            if (i >= 1024) {
                bxm = mo4059a();
            } else {
                bxm a = bxn.m10449a();
                bwf.m9943a(this.f4199a, this.f4200b, a.f4199a, 0, i);
                bxm = a;
            }
            bxm.f4201c = bxm.f4200b + i;
            this.f4200b += i;
            bxm bxm2 = this.f4205g;
            if (bxm2 == null) {
                bfq.m6538a();
            }
            bxm2.mo4061a(bxm);
            return bxm;
        }
        throw new IllegalArgumentException("byteCount out of range".toString());
    }

    /* renamed from: d */
    public final void mo4065d() {
        bxm bxm = this.f4205g;
        int i = 0;
        if (bxm != this) {
            if (bxm == null) {
                bfq.m6538a();
            }
            if (bxm.f4203e) {
                int i2 = this.f4201c - this.f4200b;
                bxm bxm2 = this.f4205g;
                if (bxm2 == null) {
                    bfq.m6538a();
                }
                int i3 = 8192 - bxm2.f4201c;
                bxm bxm3 = this.f4205g;
                if (bxm3 == null) {
                    bfq.m6538a();
                }
                if (!bxm3.f4202d) {
                    bxm bxm4 = this.f4205g;
                    if (bxm4 == null) {
                        bfq.m6538a();
                    }
                    i = bxm4.f4200b;
                }
                if (i2 <= i3 + i) {
                    bxm bxm5 = this.f4205g;
                    if (bxm5 == null) {
                        bfq.m6538a();
                    }
                    mo4062a(bxm5, i2);
                    mo4064c();
                    bxn.m10450a(this);
                    return;
                }
                return;
            }
            return;
        }
        throw new IllegalStateException("cannot compact".toString());
    }

    /* renamed from: a */
    public final void mo4062a(bxm bxm, int i) {
        bfq.m6567f(bxm, "sink");
        if (bxm.f4203e) {
            int i2 = bxm.f4201c;
            if (i2 + i > 8192) {
                if (!bxm.f4202d) {
                    int i3 = bxm.f4200b;
                    if ((i2 + i) - i3 <= 8192) {
                        byte[] bArr = bxm.f4199a;
                        bwf.m9943a(bArr, i3, bArr, 0, i2 - i3);
                        bxm.f4201c -= bxm.f4200b;
                        bxm.f4200b = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            bwf.m9943a(this.f4199a, this.f4200b, bxm.f4199a, bxm.f4201c, i);
            bxm.f4201c += i;
            this.f4200b += i;
            return;
        }
        throw new IllegalStateException("only owner can write".toString());
    }

    @aot(mo1534a = 1, mo1535b = {1, 1, 11}, mo1536c = {1, 0, 2}, mo1537d = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo1538e = {"Lokio/Segment$Companion;", "", "()V", "SHARE_MINIMUM", "", "SIZE", "jvm"})
    /* renamed from: atakplugin.UASTool.bxm$a */
    public static final class C0282a {
        private C0282a() {
        }

        public /* synthetic */ C0282a(bfd bfd) {
            this();
        }
    }
}

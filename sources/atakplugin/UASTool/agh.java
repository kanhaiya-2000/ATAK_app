package atakplugin.UASTool;

import atakplugin.UASTool.agf;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

class agh extends InputStream {

    /* renamed from: a */
    long f1105a;

    /* renamed from: b */
    boolean f1106b = false;

    /* renamed from: c */
    int f1107c = 0;

    /* renamed from: d */
    byte[] f1108d = new byte[1];

    /* renamed from: e */
    byte[] f1109e = new byte[1024];

    /* renamed from: f */
    agf.C0035a f1110f;

    /* renamed from: g */
    int f1111g;

    /* renamed from: h */
    long f1112h;

    /* renamed from: i */
    final /* synthetic */ long f1113i;

    /* renamed from: j */
    final /* synthetic */ aiu f1114j;

    /* renamed from: k */
    final /* synthetic */ byte[] f1115k;

    /* renamed from: l */
    final /* synthetic */ agf f1116l;

    agh(agf agf, long j, aiu aiu, byte[] bArr) {
        this.f1116l = agf;
        this.f1113i = j;
        this.f1114j = aiu;
        this.f1115k = bArr;
        this.f1105a = j;
        this.f1110f = new agf.C0035a();
        this.f1111g = 1;
        this.f1112h = this.f1105a;
    }

    public int read() {
        if (!this.f1106b && read(this.f1108d, 0, 1) != -1) {
            return this.f1108d[0] & 255;
        }
        return -1;
    }

    public int read(byte[] bArr) {
        if (this.f1106b) {
            return -1;
        }
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) {
        byte[] bArr2 = bArr;
        int i3 = i;
        int i4 = i2;
        if (this.f1106b) {
            return -1;
        }
        Objects.requireNonNull(bArr);
        if (i3 < 0 || i4 < 0 || i3 + i4 > bArr2.length) {
            throw new IndexOutOfBoundsException();
        }
        int i5 = 0;
        if (i4 == 0) {
            return 0;
        }
        int i6 = this.f1107c;
        if (i6 > 0) {
            if (i6 <= i4) {
                i4 = i6;
            }
            System.arraycopy(this.f1109e, 0, bArr2, i3, i4);
            int i7 = this.f1107c;
            if (i4 != i7) {
                byte[] bArr3 = this.f1109e;
                System.arraycopy(bArr3, i4, bArr3, 0, i7 - i4);
            }
            aiu aiu = this.f1114j;
            if (aiu == null || aiu.mo1137a((long) i4)) {
                this.f1107c -= i4;
                return i4;
            }
            close();
            return -1;
        }
        if (this.f1116l.f1054aP.f888b.length - 13 < i4) {
            i4 = this.f1116l.f1054aP.f888b.length - 13;
        }
        int i8 = 1024;
        if (this.f1116l.f1059aU == 0 && i4 > 1024) {
            i4 = 1024;
        }
        if (this.f1116l.f1071bk.mo788b() == 0) {
            int length = this.f1116l.f1054aP.f888b.length - 13;
            if (this.f1116l.f1059aU != 0) {
                i8 = length;
            }
            while (this.f1116l.f1071bk.mo788b() < this.f1111g) {
                try {
                    agf agf = this.f1116l;
                    agf.m1060a(this.f1115k, this.f1112h, i8, agf.f1071bk);
                    this.f1112h += (long) i8;
                } catch (Exception unused) {
                    throw new IOException("error");
                }
            }
        }
        agf agf2 = this.f1116l;
        agf.C0035a a = agf2.m1046a(agf2.f1054aP, this.f1110f);
        this.f1110f = a;
        this.f1107c = a.f1072a;
        int i9 = this.f1110f.f1073b;
        int i10 = this.f1110f.f1074c;
        try {
            agf.C0038d.C0040b a2 = this.f1116l.f1071bk.mo784a(this.f1110f.f1074c);
            if (i9 != 101 && i9 != 103) {
                throw new IOException("error");
            } else if (i9 == 101) {
                agf agf3 = this.f1116l;
                agf3.m1069b(agf3.f1054aP, this.f1107c);
                int d = this.f1116l.f1054aP.mo633d();
                this.f1107c = 0;
                if (d == 1) {
                    close();
                    return -1;
                }
                throw new IOException("error");
            } else {
                this.f1116l.f1054aP.mo646m();
                agf agf4 = this.f1116l;
                int unused2 = agf4.m1079d(agf4.f1054aP.f888b, 0, 4);
                int d2 = this.f1116l.f1054aP.mo633d();
                int i11 = this.f1107c - 4;
                this.f1107c = i11;
                int i12 = i11 - d2;
                long j = (long) d2;
                this.f1105a += j;
                if (d2 <= 0) {
                    return 0;
                }
                if (d2 <= i4) {
                    i4 = d2;
                }
                int read = this.f1116l.f1062aX.read(bArr2, i3, i4);
                if (read < 0) {
                    return -1;
                }
                int i13 = d2 - read;
                this.f1107c = i13;
                if (i13 > 0) {
                    if (this.f1109e.length < i13) {
                        this.f1109e = new byte[i13];
                    }
                    while (i13 > 0) {
                        int read2 = this.f1116l.f1062aX.read(this.f1109e, i5, i13);
                        if (read2 <= 0) {
                            break;
                        }
                        i5 += read2;
                        i13 -= read2;
                    }
                }
                if (i12 > 0) {
                    this.f1116l.f1062aX.skip((long) i12);
                }
                if (j < a2.f1090c) {
                    this.f1116l.f1071bk.mo787a(this.f1110f, this.f1116l.f1054aP);
                    try {
                        this.f1116l.m1060a(this.f1115k, a2.f1089b + j, (int) (a2.f1090c - j), this.f1116l.f1071bk);
                        this.f1112h = a2.f1089b + a2.f1090c;
                    } catch (Exception unused3) {
                        throw new IOException("error");
                    }
                }
                if (this.f1111g < this.f1116l.f1071bk.mo789c()) {
                    this.f1111g++;
                }
                aiu aiu2 = this.f1114j;
                if (aiu2 == null || aiu2.mo1137a((long) read)) {
                    return read;
                }
                close();
                return -1;
            }
        } catch (agf.C0038d.C0039a e) {
            this.f1112h = e.f1086a;
            skip((long) this.f1110f.f1072a);
            this.f1116l.f1071bk.mo787a(this.f1110f, this.f1116l.f1054aP);
            return 0;
        } catch (ait e2) {
            throw new IOException("error: " + e2.toString());
        }
    }

    public void close() {
        if (!this.f1106b) {
            this.f1106b = true;
            aiu aiu = this.f1114j;
            if (aiu != null) {
                aiu.mo1135a();
            }
            this.f1116l.f1071bk.mo787a(this.f1110f, this.f1116l.f1054aP);
            try {
                boolean unused = this.f1116l.m1065a(this.f1115k, this.f1110f);
            } catch (Exception unused2) {
                throw new IOException("error");
            }
        }
    }
}

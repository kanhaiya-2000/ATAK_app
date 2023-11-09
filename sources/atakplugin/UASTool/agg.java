package atakplugin.UASTool;

import atakplugin.UASTool.agf;
import java.io.IOException;
import java.io.OutputStream;

class agg extends OutputStream {

    /* renamed from: a */
    byte[] f1092a;

    /* renamed from: b */
    final /* synthetic */ byte[] f1093b;

    /* renamed from: c */
    final /* synthetic */ long[] f1094c;

    /* renamed from: d */
    final /* synthetic */ aiu f1095d;

    /* renamed from: e */
    final /* synthetic */ agf f1096e;

    /* renamed from: f */
    private boolean f1097f = true;

    /* renamed from: g */
    private boolean f1098g = false;

    /* renamed from: h */
    private int[] f1099h = new int[1];

    /* renamed from: i */
    private int f1100i = 0;

    /* renamed from: j */
    private int f1101j = 0;

    /* renamed from: k */
    private int f1102k = 0;

    /* renamed from: l */
    private int f1103l = 0;

    /* renamed from: m */
    private agf.C0035a f1104m;

    agg(agf agf, byte[] bArr, long[] jArr, aiu aiu) {
        this.f1096e = agf;
        this.f1093b = bArr;
        this.f1094c = jArr;
        this.f1095d = aiu;
        this.f1104m = new agf.C0035a();
        this.f1092a = new byte[1];
    }

    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) {
        if (this.f1097f) {
            this.f1100i = this.f1096e.f1052aN;
            this.f1101j = this.f1096e.f1052aN;
            this.f1097f = false;
        }
        if (!this.f1098g) {
            int i3 = i2;
            while (i3 > 0) {
                try {
                    int a = this.f1096e.m1045a(this.f1093b, this.f1094c[0], bArr, i, i3);
                    this.f1103l++;
                    long[] jArr = this.f1094c;
                    jArr[0] = jArr[0] + ((long) a);
                    i += a;
                    i3 -= a;
                    if (this.f1096e.f1052aN - 1 == this.f1100i || this.f1096e.f1062aX.available() >= 1024) {
                        while (this.f1096e.f1062aX.available() > 0 && this.f1096e.m1066a(this.f1099h, this.f1104m)) {
                            int i4 = this.f1099h[0];
                            this.f1101j = i4;
                            if (this.f1100i > i4 || i4 > this.f1096e.f1052aN - 1) {
                                throw new ait(4, "");
                            }
                            this.f1102k++;
                        }
                    }
                } catch (IOException e) {
                    throw e;
                } catch (Exception e2) {
                    throw new IOException(e2.toString());
                }
            }
            aiu aiu = this.f1095d;
            if (aiu == null) {
                return;
            }
            if (!aiu.mo1137a((long) i2)) {
                close();
                throw new IOException("canceled");
            }
            return;
        }
        throw new IOException("stream already closed");
    }

    public void write(int i) {
        byte[] bArr = this.f1092a;
        bArr[0] = (byte) i;
        write(bArr, 0, 1);
    }

    public void flush() {
        if (this.f1098g) {
            throw new IOException("stream already closed");
        } else if (!this.f1097f) {
            while (this.f1103l > this.f1102k) {
                try {
                    if (this.f1096e.m1066a((int[]) null, this.f1104m)) {
                        this.f1102k++;
                    } else {
                        return;
                    }
                } catch (ait e) {
                    throw new IOException(e.toString());
                }
            }
        }
    }

    public void close() {
        if (!this.f1098g) {
            flush();
            aiu aiu = this.f1095d;
            if (aiu != null) {
                aiu.mo1135a();
            }
            try {
                boolean unused = this.f1096e.m1065a(this.f1093b, this.f1104m);
                this.f1098g = true;
            } catch (IOException e) {
                throw e;
            } catch (Exception e2) {
                throw new IOException(e2.toString());
            }
        }
    }
}

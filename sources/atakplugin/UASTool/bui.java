package atakplugin.UASTool;

import atakplugin.UASTool.C0915uj;
import com.google.common.base.Ascii;
import java.io.ByteArrayOutputStream;

class bui {

    /* renamed from: a */
    private static final int[] f3907a = {8184, 8388568, 268435426, 268435427, 268435428, 268435429, 268435430, 268435431, 268435432, 16777194, 1073741820, 268435433, 268435434, 1073741821, 268435435, 268435436, 268435437, 268435438, 268435439, 268435440, 268435441, 268435442, 1073741822, 268435443, 268435444, 268435445, 268435446, 268435447, 268435448, 268435449, 268435450, 268435451, 20, C0915uj.C0923h.f7220K, C0915uj.C0923h.f7221L, 4090, 8185, 21, 248, 2042, C0915uj.C0923h.f7222M, C0915uj.C0923h.f7223N, 249, 2043, 250, 22, 23, 24, 0, 1, 2, 25, 26, 27, 28, 29, 30, 31, 92, 251, 32764, 32, 4091, C0915uj.C0923h.f7224O, 8186, 33, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 252, 115, 253, 8187, 524272, 8188, 16380, 34, 32765, 3, 35, 4, 36, 5, 37, 38, 39, 6, 116, 117, 40, 41, 42, 7, 43, 118, 44, 8, 9, 45, 119, 120, 121, 122, 123, 32766, 2044, 16381, 8189, 268435452, 1048550, 4194258, 1048551, 1048552, 4194259, 4194260, 4194261, 8388569, 4194262, 8388570, 8388571, 8388572, 8388573, 8388574, 16777195, 8388575, 16777196, 16777197, 4194263, 8388576, 16777198, 8388577, 8388578, 8388579, 8388580, 2097116, 4194264, 8388581, 4194265, 8388582, 8388583, 16777199, 4194266, 2097117, 1048553, 4194267, 4194268, 8388584, 8388585, 2097118, 8388586, 4194269, 4194270, 16777200, 2097119, 4194271, 8388587, 8388588, 2097120, 2097121, 4194272, 2097122, 8388589, 4194273, 8388590, 8388591, 1048554, 4194274, 4194275, 4194276, 8388592, 4194277, 4194278, 8388593, 67108832, 67108833, 1048555, 524273, 4194279, 8388594, 4194280, 33554412, 67108834, 67108835, 67108836, 134217694, 134217695, 67108837, 16777201, 33554413, 524274, 2097123, 67108838, 134217696, 134217697, 67108839, 134217698, 16777202, 2097124, 2097125, 67108840, 67108841, 268435453, 134217699, 134217700, 134217701, 1048556, 16777203, 1048557, 2097126, 4194281, 2097127, 2097128, 8388595, 4194282, 4194283, 33554414, 33554415, 16777204, 16777205, 67108842, 8388596, 67108843, 134217702, 67108844, 67108845, 134217703, 134217704, 134217705, 134217706, 134217707, 268435454, 134217708, 134217709, 134217710, 134217711, 134217712, 67108846};

    /* renamed from: b */
    private static final byte[] f3908b = {Ascii.f8514CR, Ascii.ETB, Ascii.f8517FS, Ascii.f8517FS, Ascii.f8517FS, Ascii.f8517FS, Ascii.f8517FS, Ascii.f8517FS, Ascii.f8517FS, Ascii.CAN, Ascii.f8522RS, Ascii.f8517FS, Ascii.f8517FS, Ascii.f8522RS, Ascii.f8517FS, Ascii.f8517FS, Ascii.f8517FS, Ascii.f8517FS, Ascii.f8517FS, Ascii.f8517FS, Ascii.f8517FS, Ascii.f8517FS, Ascii.f8522RS, Ascii.f8517FS, Ascii.f8517FS, Ascii.f8517FS, Ascii.f8517FS, Ascii.f8517FS, Ascii.f8517FS, Ascii.f8517FS, Ascii.f8517FS, Ascii.f8517FS, 6, 10, 10, Ascii.f8516FF, Ascii.f8514CR, 6, 8, Ascii.f8527VT, 10, 10, 8, Ascii.f8527VT, 8, 6, 6, 6, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 8, Ascii.f8523SI, 6, Ascii.f8516FF, 10, Ascii.f8514CR, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 7, 8, Ascii.f8514CR, 19, Ascii.f8514CR, Ascii.f8524SO, 6, Ascii.f8523SI, 5, 6, 5, 6, 5, 6, 6, 6, 5, 7, 7, 6, 6, 6, 5, 6, 7, 6, 5, 5, 6, 7, 7, 7, 7, 7, Ascii.f8523SI, Ascii.f8527VT, Ascii.f8524SO, Ascii.f8514CR, Ascii.f8517FS, Ascii.DC4, Ascii.SYN, Ascii.DC4, Ascii.DC4, Ascii.SYN, Ascii.SYN, Ascii.SYN, Ascii.ETB, Ascii.SYN, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.CAN, Ascii.ETB, Ascii.CAN, Ascii.CAN, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.SYN, Ascii.ETB, Ascii.ETB, Ascii.CAN, Ascii.SYN, Ascii.NAK, Ascii.DC4, Ascii.SYN, Ascii.SYN, Ascii.ETB, Ascii.ETB, Ascii.NAK, Ascii.ETB, Ascii.SYN, Ascii.SYN, Ascii.CAN, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.ETB, Ascii.NAK, Ascii.NAK, Ascii.SYN, Ascii.NAK, Ascii.ETB, Ascii.SYN, Ascii.ETB, Ascii.ETB, Ascii.DC4, Ascii.SYN, Ascii.SYN, Ascii.SYN, Ascii.ETB, Ascii.SYN, Ascii.SYN, Ascii.ETB, Ascii.SUB, Ascii.SUB, Ascii.DC4, 19, Ascii.SYN, Ascii.ETB, Ascii.SYN, Ascii.f8515EM, Ascii.SUB, Ascii.SUB, Ascii.SUB, Ascii.ESC, Ascii.ESC, Ascii.SUB, Ascii.CAN, Ascii.f8515EM, 19, Ascii.NAK, Ascii.SUB, Ascii.ESC, Ascii.ESC, Ascii.SUB, Ascii.ESC, Ascii.CAN, Ascii.NAK, Ascii.NAK, Ascii.SUB, Ascii.SUB, Ascii.f8517FS, Ascii.ESC, Ascii.ESC, Ascii.ESC, Ascii.DC4, Ascii.CAN, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.NAK, Ascii.NAK, Ascii.ETB, Ascii.SYN, Ascii.SYN, Ascii.f8515EM, Ascii.f8515EM, Ascii.CAN, Ascii.CAN, Ascii.SUB, Ascii.ETB, Ascii.SUB, Ascii.ESC, Ascii.SUB, Ascii.SUB, Ascii.ESC, Ascii.ESC, Ascii.ESC, Ascii.ESC, Ascii.ESC, Ascii.f8517FS, Ascii.ESC, Ascii.ESC, Ascii.ESC, Ascii.ESC, Ascii.ESC, Ascii.SUB};

    /* renamed from: c */
    private static final bui f3909c = new bui();

    /* renamed from: d */
    private final C0255a f3910d = new C0255a();

    /* renamed from: a */
    public static bui m9640a() {
        return f3909c;
    }

    private bui() {
        m9642b();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: byte} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo3641a(byte[] r8, java.io.OutputStream r9) {
        /*
            r7 = this;
            r0 = 0
            r1 = 0
            r2 = r1
            r1 = 0
        L_0x0005:
            int r4 = r8.length
            r5 = 255(0xff, float:3.57E-43)
            if (r0 >= r4) goto L_0x0029
            byte r4 = r8[r0]
            r4 = r4 & r5
            int[] r5 = f3907a
            r5 = r5[r4]
            byte[] r6 = f3908b
            byte r4 = r6[r4]
            long r2 = r2 << r4
            long r5 = (long) r5
            long r2 = r2 | r5
            int r1 = r1 + r4
        L_0x0019:
            r4 = 8
            if (r1 < r4) goto L_0x0026
            int r1 = r1 + -8
            long r4 = r2 >> r1
            int r5 = (int) r4
            r9.write(r5)
            goto L_0x0019
        L_0x0026:
            int r0 = r0 + 1
            goto L_0x0005
        L_0x0029:
            if (r1 <= 0) goto L_0x0036
            int r8 = 8 - r1
            long r2 = r2 << r8
            int r8 = r5 >>> r1
            long r0 = (long) r8
            long r0 = r0 | r2
            int r8 = (int) r0
            r9.write(r8)
        L_0x0036:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.bui.mo3641a(byte[], java.io.OutputStream):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo3640a(byte[] bArr) {
        long j = 0;
        for (byte b : bArr) {
            j += (long) f3908b[b & 255];
        }
        return (int) ((j + 7) >> 3);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public byte[] mo3642b(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        C0255a aVar = this.f3910d;
        byte b = 0;
        int i = 0;
        for (byte b2 : bArr) {
            b = (b << 8) | (b2 & 255);
            i += 8;
            while (i >= 8) {
                aVar = aVar.f3911a[(b >>> (i - 8)) & 255];
                if (aVar.f3911a == null) {
                    byteArrayOutputStream.write(aVar.f3912b);
                    i -= aVar.f3913c;
                    aVar = this.f3910d;
                } else {
                    i -= 8;
                }
            }
        }
        while (i > 0) {
            C0255a aVar2 = aVar.f3911a[(b << (8 - i)) & 255];
            if (aVar2.f3911a != null || aVar2.f3913c > i) {
                break;
            }
            byteArrayOutputStream.write(aVar2.f3912b);
            i -= aVar2.f3913c;
            aVar = this.f3910d;
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: b */
    private void m9642b() {
        int i = 0;
        while (true) {
            byte[] bArr = f3908b;
            if (i < bArr.length) {
                m9641a(i, f3907a[i], bArr[i]);
                i++;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    private void m9641a(int i, int i2, byte b) {
        C0255a aVar = new C0255a(i, b);
        C0255a aVar2 = this.f3910d;
        while (b > 8) {
            b = (byte) (b - 8);
            int i3 = (i2 >>> b) & 255;
            if (aVar2.f3911a != null) {
                if (aVar2.f3911a[i3] == null) {
                    aVar2.f3911a[i3] = new C0255a();
                }
                aVar2 = aVar2.f3911a[i3];
            } else {
                throw new IllegalStateException("invalid dictionary: prefix not unique");
            }
        }
        int i4 = 8 - b;
        int i5 = (i2 << i4) & 255;
        int i6 = 1 << i4;
        for (int i7 = i5; i7 < i5 + i6; i7++) {
            aVar2.f3911a[i7] = aVar;
        }
    }

    /* renamed from: atakplugin.UASTool.bui$a */
    private static final class C0255a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final C0255a[] f3911a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final int f3912b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public final int f3913c;

        C0255a() {
            this.f3911a = new C0255a[256];
            this.f3912b = 0;
            this.f3913c = 0;
        }

        C0255a(int i, int i2) {
            this.f3911a = null;
            this.f3912b = i;
            int i3 = i2 & 7;
            this.f3913c = i3 == 0 ? 8 : i3;
        }
    }
}

package atakplugin.UASTool;

import com.jcraft.jzlib.ZStream;
import java.io.PrintStream;

public class akn implements ago {

    /* renamed from: c */
    private static final int f1704c = 4096;

    /* renamed from: d */
    private final int f1705d = 52;

    /* renamed from: e */
    private int f1706e;

    /* renamed from: f */
    private ZStream f1707f = new ZStream();

    /* renamed from: g */
    private byte[] f1708g = new byte[4096];

    /* renamed from: h */
    private byte[] f1709h;

    /* renamed from: a */
    public void mo808a(int i, int i2) {
        if (i == 1) {
            this.f1707f.deflateInit(i2);
            this.f1706e = 1;
        } else if (i == 0) {
            this.f1707f.inflateInit();
            this.f1709h = new byte[4096];
            this.f1706e = 0;
        }
    }

    /* renamed from: a */
    public byte[] mo809a(byte[] bArr, int i, int[] iArr) {
        this.f1707f.next_in = bArr;
        this.f1707f.next_in_index = i;
        this.f1707f.avail_in = iArr[0] - i;
        do {
            this.f1707f.next_out = this.f1708g;
            this.f1707f.next_out_index = 0;
            this.f1707f.avail_out = 4096;
            int deflate = this.f1707f.deflate(1);
            if (deflate != 0) {
                PrintStream printStream = System.err;
                printStream.println("compress: deflate returnd " + deflate);
            } else {
                int i2 = 4096 - this.f1707f.avail_out;
                int i3 = i + i2;
                int i4 = i3 + 52;
                if (bArr.length < i4) {
                    byte[] bArr2 = new byte[(i4 * 2)];
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    bArr = bArr2;
                }
                System.arraycopy(this.f1708g, 0, bArr, i, i2);
                i = i3;
            }
        } while (this.f1707f.avail_out == 0);
        iArr[0] = i;
        return bArr;
    }

    /* renamed from: b */
    public byte[] mo810b(byte[] bArr, int i, int[] iArr) {
        this.f1707f.next_in = bArr;
        this.f1707f.next_in_index = i;
        this.f1707f.avail_in = iArr[0];
        int i2 = 0;
        while (true) {
            this.f1707f.next_out = this.f1708g;
            this.f1707f.next_out_index = 0;
            this.f1707f.avail_out = 4096;
            int inflate = this.f1707f.inflate(1);
            if (inflate == -5) {
                if (i2 > bArr.length - i) {
                    byte[] bArr2 = new byte[(i2 + i)];
                    System.arraycopy(bArr, 0, bArr2, 0, i);
                    System.arraycopy(this.f1709h, 0, bArr2, i, i2);
                    bArr = bArr2;
                } else {
                    System.arraycopy(this.f1709h, 0, bArr, i, i2);
                }
                iArr[0] = i2;
                return bArr;
            } else if (inflate != 0) {
                PrintStream printStream = System.err;
                printStream.println("uncompress: inflate returnd " + inflate);
                return null;
            } else {
                int i3 = i2 + 4096;
                if (this.f1709h.length < i3 - this.f1707f.avail_out) {
                    int length = this.f1709h.length * 2;
                    if (length < i3 - this.f1707f.avail_out) {
                        length = i3 - this.f1707f.avail_out;
                    }
                    byte[] bArr3 = new byte[length];
                    System.arraycopy(this.f1709h, 0, bArr3, 0, i2);
                    this.f1709h = bArr3;
                }
                System.arraycopy(this.f1708g, 0, this.f1709h, i2, 4096 - this.f1707f.avail_out);
                i2 += 4096 - this.f1707f.avail_out;
                iArr[0] = i2;
            }
        }
    }
}

package atakplugin.UASTool;

import com.atakmap.android.uastool.MAVLink.enums.MAV_CMD;
import com.google.common.base.Ascii;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class cpv {

    /* renamed from: A */
    public static final byte[] f4771A = {Ascii.DC2};

    /* renamed from: B */
    public static final int f4772B = 4;

    /* renamed from: C */
    public static final byte[] f4773C = {19};

    /* renamed from: D */
    public static final int f4774D = 2;

    /* renamed from: E */
    public static final byte[] f4775E = {59};

    /* renamed from: F */
    public static final int f4776F = 127;

    /* renamed from: G */
    public static final byte[] f4777G = {Ascii.ETB};

    /* renamed from: H */
    public static final int f4778H = 4;

    /* renamed from: I */
    public static final byte[] f4779I = {6, Ascii.f8524SO, 43, 52, 1, 1, 1, 1, 7, 1, 2, 1, 3, 2, 0, 0};

    /* renamed from: J */
    public static final byte[] f4780J = {Ascii.CAN};

    /* renamed from: K */
    public static final int f4781K = 4;

    /* renamed from: L */
    public static final byte[] f4782L = {6, Ascii.f8524SO, 43, 52, 1, 1, 1, 1, 7, 1, 2, 1, 3, 4, 0, 0};

    /* renamed from: M */
    public static final byte[] f4783M = {6, Ascii.f8524SO, 43, 52, 1, 1, 1, 1, Ascii.f8524SO, 1, 2, 3, 72, 0, 0, 0};

    /* renamed from: N */
    public static final byte[] f4784N = {Ascii.f8515EM};

    /* renamed from: O */
    public static final int f4785O = 4;

    /* renamed from: P */
    public static final byte[] f4786P = {6, Ascii.f8524SO, 43, 52, 1, 1, 1, 10, 7, 1, 2, 1, 3, Ascii.SYN, 0, 0};

    /* renamed from: Q */
    public static final byte[] f4787Q = {6, Ascii.f8524SO, 43, 52, 1, 1, 1, 1, Ascii.f8524SO, 1, 2, 1, -126, 71, 0, 0};

    /* renamed from: R */
    public static final byte[] f4788R = {6, Ascii.f8524SO, 43, 52, 1, 1, 1, 2, 4, 32, 2, 1, 1, 8, 0, 0};

    /* renamed from: S */
    public static final byte[] f4789S = {6, Ascii.f8524SO, 43, 52, 1, 1, 1, 1, Ascii.f8524SO, 1, 1, 2, 6, 0, 0, 0};

    /* renamed from: T */
    public static final byte[] f4790T = {6, Ascii.f8524SO, 43, 52, 1, 1, 1, 1, 1, 1, 32, 1, 0, 0, 0, 0};

    /* renamed from: U */
    public static final byte[] f4791U = {56};

    /* renamed from: V */
    public static final byte[] f4792V = {6, Ascii.f8524SO, 43, 52, 1, 1, 1, 1, Ascii.f8524SO, 1, 4, 1, 2, 0, 0, 0};

    /* renamed from: W */
    public static final byte[] f4793W = {6, Ascii.f8524SO, 43, 52, 1, 1, 1, 3, 7, 1, 2, 1, 3, 7, 1, 0};

    /* renamed from: X */
    public static final byte[] f4794X = {6, Ascii.f8524SO, 43, 52, 1, 1, 1, 3, 7, 1, 2, 1, 3, Ascii.f8527VT, 1, 0};

    /* renamed from: Y */
    public static final byte[] f4795Y = {6, Ascii.f8524SO, 43, 52, 1, 1, 1, 3, 7, 1, 2, 1, 3, 8, 1, 0};

    /* renamed from: Z */
    public static final byte[] f4796Z = {6, Ascii.f8524SO, 43, 52, 1, 1, 1, 3, 7, 1, 2, 1, 3, Ascii.f8516FF, 1, 0};

    /* renamed from: a */
    public static final byte[] f4797a = {6, Ascii.f8524SO, 43, 52, 2, Ascii.f8527VT, 1, 1, Ascii.f8524SO, 1, 3, 1, 1, 0, 0, 0};

    /* renamed from: aa */
    public static final byte[] f4798aa = {6, Ascii.f8524SO, 43, 52, 1, 1, 1, 3, 7, 1, 2, 1, 3, 9, 1, 0};

    /* renamed from: ab */
    public static final byte[] f4799ab = {6, Ascii.f8524SO, 43, 52, 1, 1, 1, 3, 7, 1, 2, 1, 3, Ascii.f8514CR, 1, 0};

    /* renamed from: ac */
    public static final byte[] f4800ac = {6, Ascii.f8524SO, 43, 52, 1, 1, 1, 3, 7, 1, 2, 1, 3, 10, 1, 0};

    /* renamed from: ad */
    public static final byte[] f4801ad = {6, Ascii.f8524SO, 43, 52, 1, 1, 1, 3, 7, 1, 2, 1, 3, Ascii.f8524SO, 1, 0};

    /* renamed from: ae */
    public static final byte[] f4802ae = {82};

    /* renamed from: af */
    public static final byte[] f4803af = {83};

    /* renamed from: ag */
    public static final byte[] f4804ag = {84};

    /* renamed from: ah */
    public static final byte[] f4805ah = {85};

    /* renamed from: ai */
    public static final byte[] f4806ai = {86};

    /* renamed from: aj */
    public static final byte[] f4807aj = {87};

    /* renamed from: ak */
    public static final byte[] f4808ak = {88};

    /* renamed from: al */
    public static final byte[] f4809al = {89};

    /* renamed from: am */
    static final /* synthetic */ boolean f4810am = true;

    /* renamed from: an */
    private static final C0330a f4811an = C0330a.FourBytes;

    /* renamed from: ao */
    private static final C0331b f4812ao = C0331b.BER;

    /* renamed from: ap */
    private static final String f4813ap = "UTF-8";

    /* renamed from: b */
    public static final byte[] f4814b = {6, Ascii.f8524SO, 43, 52, 1, 1, 1, 1, Ascii.f8524SO, 1, 2, 3, 1, 0, 0, 0};

    /* renamed from: c */
    public static final byte[] f4815c = {1};

    /* renamed from: d */
    public static final int f4816d = 2;

    /* renamed from: e */
    public static final byte[] f4817e = {6, Ascii.f8524SO, 43, 52, 1, 1, 1, 3, 7, 2, 1, 1, 1, 5, 0, 0};

    /* renamed from: f */
    public static final byte[] f4818f = {2};

    /* renamed from: g */
    public static final int f4819g = 8;

    /* renamed from: h */
    public static final byte[] f4820h = new byte[0];

    /* renamed from: i */
    public static final byte[] f4821i = {65};

    /* renamed from: j */
    public static final byte[] f4822j = {6, Ascii.f8524SO, 43, 52, 1, 1, 1, 3, 7, 1, 2, 1, 2, 4, 2, 0};

    /* renamed from: k */
    public static final int f4823k = 4;

    /* renamed from: l */
    public static final byte[] f4824l = {Ascii.f8514CR};

    /* renamed from: m */
    public static final byte[] f4825m = {6, Ascii.f8524SO, 43, 52, 1, 1, 1, 3, 7, 1, 2, 1, 2, 6, 2, 0};

    /* renamed from: n */
    public static final int f4826n = 4;

    /* renamed from: o */
    public static final byte[] f4827o = {Ascii.f8524SO};

    /* renamed from: p */
    public static final byte[] f4828p = {6, Ascii.f8524SO, 43, 52, 1, 1, 1, 1, 7, 1, 2, 1, 2, 2, 0, 0};

    /* renamed from: q */
    public static final byte[] f4829q = {Ascii.f8523SI};

    /* renamed from: r */
    public static final int f4830r = 2;

    /* renamed from: s */
    public static final byte[] f4831s = {5};

    /* renamed from: t */
    public static final int f4832t = 2;

    /* renamed from: u */
    public static final byte[] f4833u = {6};

    /* renamed from: v */
    public static final int f4834v = 2;

    /* renamed from: w */
    public static final byte[] f4835w = {16};

    /* renamed from: x */
    public static final int f4836x = 2;

    /* renamed from: y */
    public static final byte[] f4837y = {17};

    /* renamed from: z */
    public static final int f4838z = 4;

    /* renamed from: aq */
    private C0330a f4839aq;

    /* renamed from: ar */
    private byte[] f4840ar;

    /* renamed from: as */
    private int f4841as;

    /* renamed from: at */
    private C0331b f4842at;

    /* renamed from: au */
    private byte[] f4843au;

    /* renamed from: av */
    private int f4844av;

    public cpv() {
        this.f4839aq = f4811an;
        this.f4842at = f4812ao;
        this.f4843au = new byte[0];
    }

    public cpv(byte[] bArr, C0330a aVar, C0331b bVar) {
        this(bArr, 0, aVar, bVar);
    }

    private cpv(byte[] bArr, int i, C0330a aVar, C0331b bVar) {
        Objects.requireNonNull(bArr, "KLV byte array must not be null.");
        Objects.requireNonNull(aVar, "Key length must not be null.");
        Objects.requireNonNull(bVar, "Length encoding must not be null.");
        if (i < 0 || i >= bArr.length) {
            throw new ArrayIndexOutOfBoundsException(String.format("Offset %d is out of range (byte array length: %d).", new Object[]{Integer.valueOf(i), Integer.valueOf(bArr.length)}));
        }
        m11934a(bArr, i, aVar);
        int a = m11928a(bArr, i + aVar.mo4866a(), bVar);
        int length = bArr.length - a;
        byte[] bArr2 = this.f4843au;
        if (length >= bArr2.length) {
            System.arraycopy(bArr, a, bArr2, 0, bArr2.length);
            this.f4844av = a + this.f4843au.length;
            return;
        }
        throw new ArrayIndexOutOfBoundsException(String.format("Not enough bytes left in array (%d) for the declared length (%d).", new Object[]{Integer.valueOf(length), Integer.valueOf(this.f4843au.length)}));
    }

    public cpv(int i, C0330a aVar, C0331b bVar, byte[] bArr) {
        this(i, aVar, bVar, bArr, 0, bArr.length);
    }

    private cpv(int i, C0330a aVar, C0331b bVar, byte[] bArr, int i2, int i3) {
        Objects.requireNonNull(aVar, "Key length must not be null.");
        Objects.requireNonNull(bVar, "Length encoding must not be null.");
        if (bArr != null) {
            if (i2 < 0) {
                throw new ArrayIndexOutOfBoundsException("Offset must not be negative: " + i2);
            } else if (bArr.length > 0 && i2 >= bArr.length) {
                throw new ArrayIndexOutOfBoundsException(String.format("Offset %d is out of range (byte array length: %d).", new Object[]{Integer.valueOf(i2), Integer.valueOf(bArr.length)}));
            } else if (i3 - i2 < bArr.length) {
                throw new ArrayIndexOutOfBoundsException(String.format("Not enough bytes in array (%d) for declared length (%d).", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i3)}));
            }
        }
        this.f4839aq = aVar;
        this.f4841as = i;
        this.f4842at = bVar;
        if (bArr == null) {
            this.f4843au = new byte[0];
            return;
        }
        int i4 = cpw.f4857a[bVar.ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 == 3 || i4 == 4) {
                    byte[] bArr2 = new byte[i3];
                    this.f4843au = bArr2;
                    System.arraycopy(bArr, i2, bArr2, 0, i3);
                } else if (!f4810am) {
                    throw new AssertionError(bVar);
                }
            } else if (i3 <= 65535) {
                byte[] bArr3 = new byte[i3];
                this.f4843au = bArr3;
                System.arraycopy(bArr, i2, bArr3, 0, i3);
            } else {
                throw new IllegalArgumentException(String.format("%s encoding cannot support a %d-byte value.", new Object[]{bVar, Integer.valueOf(i3)}));
            }
        } else if (i3 <= 255) {
            byte[] bArr4 = new byte[i3];
            this.f4843au = bArr4;
            System.arraycopy(bArr, i2, bArr4, 0, i3);
        } else {
            throw new IllegalArgumentException(String.format("%s encoding cannot support a %d-byte value.", new Object[]{bVar, Integer.valueOf(i3)}));
        }
    }

    public cpv(byte[] bArr, C0331b bVar, byte[] bArr2, int i, int i2) {
        Objects.requireNonNull(bArr, "Key must not be null.");
        Objects.requireNonNull(bVar, "Length encoding must not be null.");
        if (bArr.length == 1 || bArr.length == 2 || bArr.length == 4 || bArr.length == 16) {
            if (bArr2 != null) {
                if (i < 0 || i >= bArr2.length) {
                    throw new ArrayIndexOutOfBoundsException(String.format("Offset %d is out of range (byte array length: %d).", new Object[]{Integer.valueOf(i), Integer.valueOf(bArr2.length)}));
                } else if (i + i2 >= bArr2.length) {
                    throw new ArrayIndexOutOfBoundsException(String.format("Not enough bytes in array for declared length of %d.", new Object[]{Integer.valueOf(i2)}));
                }
            }
            m11934a(bArr, 0, C0330a.m11975a(bArr.length));
            this.f4842at = bVar;
            if (bArr2 == null) {
                this.f4843au = new byte[0];
                return;
            }
            int i3 = cpw.f4857a[bVar.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3 || i3 == 4) {
                        byte[] bArr3 = new byte[i2];
                        this.f4843au = bArr3;
                        System.arraycopy(bArr2, i, bArr3, 0, i2);
                    } else if (!f4810am) {
                        throw new AssertionError(bVar);
                    }
                } else if (i2 <= 65535) {
                    byte[] bArr4 = new byte[i2];
                    this.f4843au = bArr4;
                    System.arraycopy(bArr2, i, bArr4, 0, i2);
                } else {
                    throw new IllegalArgumentException(String.format("%s encoding cannot support a %d-byte value.", new Object[]{bVar, Integer.valueOf(i2)}));
                }
            } else if (i2 <= 255) {
                byte[] bArr5 = new byte[i2];
                this.f4843au = bArr5;
                System.arraycopy(bArr2, i, bArr5, 0, i2);
            } else {
                throw new IllegalArgumentException(String.format("%s encoding cannot support a %d-byte value.", new Object[]{bVar, Integer.valueOf(i2)}));
            }
        } else {
            throw new IllegalArgumentException("Key length must be 1, 2, 4, or 16 bytes, not " + bArr.length);
        }
    }

    /* renamed from: a */
    public static void m11938a(String[] strArr) {
        for (int i = 0; i < 255; i++) {
            cpv cpv = new cpv();
            cpv.m11929a(42, (byte) i);
            cpv.m11929a(23, (byte) ((i + 10) % 255));
            cpv cpv2 = cpv.m11943l().get(42);
            cpv cpv3 = cpv.m11943l().get(23);
        }
    }

    /* renamed from: a */
    private static List<cpv> m11937a(byte[] bArr, int i, int i2, C0330a aVar, C0331b bVar) {
        LinkedList linkedList = new LinkedList();
        int i3 = i;
        while (i3 < i + i2) {
            try {
                cpv cpv = new cpv(bArr, i3, aVar, bVar);
                i3 = cpv.f4844av;
                linkedList.add(cpv);
            } catch (Exception e) {
                PrintStream printStream = System.err;
                printStream.println("Stopped parsing with exception: " + e.getMessage());
            }
        }
        return linkedList;
    }

    /* renamed from: b */
    private static Map<Integer, cpv> m11942b(byte[] bArr, int i, int i2, C0330a aVar, C0331b bVar) {
        HashMap hashMap = new HashMap();
        for (cpv next : m11937a(bArr, i, i2, aVar, bVar)) {
            hashMap.put(Integer.valueOf(next.m11944m()), next);
        }
        return hashMap;
    }

    /* renamed from: a */
    private static byte[] m11939a(C0331b bVar, int i) {
        int i2 = cpw.f4857a[bVar.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    return new byte[]{(byte) (i >> 24), (byte) (i >> 16), (byte) (i >> 8), (byte) i};
                } else if (i2 != 4) {
                    throw new IllegalStateException("Unknown length field encoding flag: " + bVar);
                } else if (i <= 127) {
                    return new byte[]{(byte) i};
                } else if (i <= 255) {
                    return new byte[]{-127, (byte) i};
                } else if (i <= 65535) {
                    return new byte[]{-126, (byte) (i >> 8), (byte) i};
                } else {
                    return new byte[]{-124, (byte) (i >> 24), (byte) (i >> 16), (byte) (i >> 8), (byte) i};
                }
            } else if (i <= 65535) {
                return new byte[]{(byte) (i >> 8), (byte) i};
            } else {
                throw new IllegalArgumentException(String.format("Too much data (%d bytes) for two-byte length field encoding.", new Object[]{Integer.valueOf(i)}));
            }
        } else if (i <= 255) {
            return new byte[]{(byte) i};
        } else {
            throw new IllegalArgumentException(String.format("Too much data (%d bytes) for one-byte length field encoding.", new Object[]{Integer.valueOf(i)}));
        }
    }

    /* renamed from: a */
    public byte[] mo4851a() {
        byte[] n = m11945n();
        byte[] a = m11939a(this.f4842at, this.f4843au.length);
        byte[] bArr = new byte[(n.length + a.length + this.f4843au.length)];
        System.arraycopy(n, 0, bArr, 0, n.length);
        System.arraycopy(a, 0, bArr, n.length, a.length);
        byte[] bArr2 = this.f4843au;
        System.arraycopy(bArr2, 0, bArr, n.length + a.length, bArr2.length);
        return bArr;
    }

    /* renamed from: b */
    public List<cpv> mo4854b() {
        return m11936a(this.f4839aq, this.f4842at);
    }

    /* renamed from: a */
    private List<cpv> m11936a(C0330a aVar, C0331b bVar) {
        byte[] bArr = this.f4843au;
        return m11937a(bArr, 0, bArr.length, aVar, bVar);
    }

    /* renamed from: l */
    private Map<Integer, cpv> m11943l() {
        return m11941b(this.f4839aq, this.f4842at);
    }

    /* renamed from: b */
    private Map<Integer, cpv> m11941b(C0330a aVar, C0331b bVar) {
        byte[] bArr = this.f4843au;
        return m11942b(bArr, 0, bArr.length, aVar, bVar);
    }

    /* renamed from: c */
    public C0330a mo4855c() {
        return this.f4839aq;
    }

    /* renamed from: a */
    public cpv mo4846a(C0330a aVar) {
        if (this.f4839aq == aVar) {
            return this;
        }
        if (aVar == C0330a.SixteenBytes) {
            this.f4841as = 0;
            this.f4840ar = new byte[16];
        } else if (this.f4839aq == C0330a.SixteenBytes) {
            this.f4841as = 0;
            this.f4840ar = null;
        }
        this.f4839aq = aVar;
        return this;
    }

    /* renamed from: m */
    private int m11944m() {
        int i = cpw.f4858b[this.f4839aq.ordinal()];
        if (i == 1) {
            return this.f4841as & 255;
        }
        if (i == 2) {
            return this.f4841as & 65535;
        }
        if (i == 3) {
            return this.f4841as;
        }
        if (i == 4) {
            boolean z = f4810am;
            if (!z && this.f4840ar == null) {
                throw new AssertionError();
            } else if (z || 16 == this.f4840ar.length) {
                int i2 = 0;
                for (int i3 = 0; i3 < 4; i3++) {
                    i2 |= (this.f4840ar[i3 + 13] & 255) << ((4 - i3) * 8);
                }
                return i2;
            } else {
                throw new AssertionError(this.f4840ar.length);
            }
        } else if (f4810am) {
            return 0;
        } else {
            throw new AssertionError(this.f4839aq);
        }
    }

    /* renamed from: n */
    private byte[] m11945n() {
        byte[] bArr = new byte[this.f4839aq.f4850e];
        int i = cpw.f4858b[this.f4839aq.ordinal()];
        if (i == 1) {
            bArr[0] = (byte) this.f4841as;
        } else if (i == 2) {
            int i2 = this.f4841as;
            bArr[0] = (byte) (i2 >> 8);
            bArr[1] = (byte) i2;
        } else if (i == 3) {
            int i3 = this.f4841as;
            bArr[0] = (byte) (i3 >> 24);
            bArr[1] = (byte) (i3 >> 16);
            bArr[2] = (byte) (i3 >> 8);
            bArr[3] = (byte) i3;
        } else if (i == 4) {
            boolean z = f4810am;
            if (!z && this.f4840ar == null) {
                throw new AssertionError();
            } else if (z || 16 == this.f4840ar.length) {
                System.arraycopy(this.f4840ar, 0, bArr, 0, 16);
            } else {
                throw new AssertionError(this.f4840ar.length);
            }
        } else if (!f4810am) {
            throw new AssertionError(this.f4839aq);
        }
        return bArr;
    }

    /* renamed from: d */
    public C0331b mo4857d() {
        return this.f4842at;
    }

    /* renamed from: a */
    public cpv mo4847a(C0331b bVar) {
        int i = cpw.f4857a[bVar.ordinal()];
        if (i == 1) {
            byte[] bArr = this.f4843au;
            if (bArr.length > 511) {
                byte[] bArr2 = new byte[MAV_CMD.MAV_CMD_SET_MESSAGE_INTERVAL];
                System.arraycopy(bArr, 0, bArr2, 0, MAV_CMD.MAV_CMD_SET_MESSAGE_INTERVAL);
                this.f4843au = bArr2;
            }
            this.f4842at = bVar;
        } else if (i == 2) {
            byte[] bArr3 = this.f4843au;
            if (bArr3.length > 131071) {
                byte[] bArr4 = new byte[131071];
                System.arraycopy(bArr3, 0, bArr4, 0, 131071);
                this.f4843au = bArr4;
            }
            this.f4842at = bVar;
        } else if (i == 3 || i == 4) {
            this.f4842at = bVar;
        } else if (!f4810am) {
            throw new AssertionError(bVar);
        }
        return this;
    }

    /* renamed from: o */
    private int m11946o() {
        return this.f4843au.length;
    }

    /* renamed from: a */
    public cpv mo4841a(int i) {
        return m11932a(i, this.f4842at);
    }

    /* renamed from: p */
    private byte[] m11947p() {
        return this.f4843au;
    }

    /* renamed from: a */
    public cpv mo4849a(byte[] bArr) {
        return mo4850a(bArr, 0, bArr.length);
    }

    /* renamed from: e */
    public int mo4858e() {
        byte[] p = m11947p();
        if (p.length > 0) {
            return p[0];
        }
        return 0;
    }

    /* renamed from: f */
    public int mo4859f() {
        byte[] p = m11947p();
        if (p.length > 0) {
            return p[0] & 255;
        }
        return 0;
    }

    /* renamed from: g */
    public int mo4860g() {
        byte[] p = m11947p();
        int min = Math.min(p.length, 2);
        short s = 0;
        for (int i = 0; i < min; i++) {
            s = (short) (s | ((p[i] & 255) << (((min * 8) - (i * 8)) - 8)));
        }
        return s;
    }

    /* renamed from: h */
    public int mo4861h() {
        byte[] p = m11947p();
        int min = Math.min(p.length, 2);
        int i = 0;
        for (int i2 = 0; i2 < min; i2++) {
            i |= (p[i2] & 255) << (((min * 8) - (i2 * 8)) - 8);
        }
        return i;
    }

    /* renamed from: q */
    private int m11948q() {
        byte[] p = m11947p();
        int min = Math.min(p.length, 4);
        int i = 0;
        for (int i2 = 0; i2 < min; i2++) {
            i |= (p[i2] & 255) << (((min * 8) - (i2 * 8)) - 8);
        }
        return i;
    }

    /* renamed from: r */
    private long m11949r() {
        byte[] p = m11947p();
        int min = Math.min(p.length, 8);
        long j = 0;
        for (int i = 0; i < min; i++) {
            j |= ((long) (p[i] & 255)) << (((min * 8) - (i * 8)) - 8);
        }
        return j;
    }

    /* renamed from: i */
    public float mo4862i() {
        if (m11947p().length < 4) {
            return Float.NaN;
        }
        return Float.intBitsToFloat(m11948q());
    }

    /* renamed from: j */
    public double mo4863j() {
        if (m11947p().length < 8) {
            return Double.NaN;
        }
        return Double.longBitsToDouble(m11949r());
    }

    /* renamed from: k */
    public String mo4864k() {
        try {
            return m11935a("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return new String(m11947p());
        }
    }

    /* renamed from: a */
    private String m11935a(String str) {
        return new String(m11947p(), str);
    }

    /* renamed from: b */
    public cpv mo4853b(byte[] bArr) {
        Objects.requireNonNull(bArr, "Key must not be null.");
        int length = bArr.length;
        if (length == 1 || length == 2 || length == 4 || length == 16) {
            return m11934a(bArr, 0, C0330a.m11975a(bArr.length));
        }
        throw new IllegalArgumentException("Invalid key size: " + bArr.length);
    }

    /* renamed from: a */
    private cpv m11934a(byte[] bArr, int i, C0330a aVar) {
        Objects.requireNonNull(bArr, "Byte array must not be null.");
        Objects.requireNonNull(aVar, "Key length must not be null.");
        if (i < 0 || i >= bArr.length) {
            throw new ArrayIndexOutOfBoundsException(String.format("Offset %d is out of range (byte array length: %d).", new Object[]{Integer.valueOf(i), Integer.valueOf(bArr.length)}));
        } else if (bArr.length - i >= aVar.mo4866a()) {
            this.f4839aq = aVar;
            int i2 = cpw.f4858b[aVar.ordinal()];
            if (i2 == 1) {
                this.f4841as = bArr[i] & 255;
                this.f4840ar = null;
            } else if (i2 == 2) {
                int i3 = (bArr[i] & 255) << 8;
                this.f4841as = i3;
                this.f4841as = (bArr[i + 1] & 255) | i3;
                this.f4840ar = null;
            } else if (i2 == 3) {
                int i4 = (bArr[i] & 255) << Ascii.CAN;
                this.f4841as = i4;
                byte b = i4 | ((bArr[i + 1] & 255) << 16);
                this.f4841as = b;
                byte b2 = b | ((bArr[i + 2] & 255) << 8);
                this.f4841as = b2;
                this.f4841as = (bArr[i + 3] & 255) | b2;
                this.f4840ar = null;
            } else if (i2 == 4) {
                byte[] bArr2 = new byte[16];
                this.f4840ar = bArr2;
                System.arraycopy(bArr, i, bArr2, 0, 16);
                this.f4841as = 0;
            } else {
                throw new IllegalArgumentException("Unknown key length: " + aVar);
            }
            return this;
        } else {
            throw new ArrayIndexOutOfBoundsException(String.format("Not enough bytes for %d-byte key.", new Object[]{Integer.valueOf(aVar.mo4866a())}));
        }
    }

    /* renamed from: b */
    public cpv mo4852b(int i) {
        return m11930a(i, this.f4839aq);
    }

    /* renamed from: a */
    private cpv m11930a(int i, C0330a aVar) {
        int i2 = cpw.f4858b[aVar.ordinal()];
        if (i2 == 1 || i2 == 2 || i2 == 3) {
            this.f4841as = i;
            this.f4840ar = null;
            this.f4839aq = aVar;
        } else if (i2 == 4) {
            byte[] bArr = new byte[16];
            for (int i3 = 0; i3 < 4; i3++) {
                bArr[i3 + 13] = (byte) (i >> ((3 - i3) * 8));
            }
            this.f4839aq = aVar;
        } else if (!f4810am) {
            throw new AssertionError(aVar);
        }
        return this;
    }

    /* renamed from: a */
    private int m11928a(byte[] bArr, int i, C0331b bVar) {
        Objects.requireNonNull(bArr, "Byte array must not be null.");
        Objects.requireNonNull(bVar, "Length encoding must not be null.");
        if (i < 0 || i >= bArr.length) {
            throw new ArrayIndexOutOfBoundsException(String.format("Offset %d is out of range (byte array length: %d).", new Object[]{Integer.valueOf(i), Integer.valueOf(bArr.length)}));
        }
        int i2 = cpw.f4857a[bVar.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (f4810am) {
                            return 0;
                        }
                        throw new AssertionError(bVar);
                    } else if (bArr.length - i >= 1) {
                        byte b = bArr[i] & 255;
                        if ((b & 128) == 0) {
                            m11932a((int) b, bVar);
                        } else {
                            byte b2 = b & Byte.MAX_VALUE;
                            if (bArr.length - i >= b2 + 1) {
                                int i3 = 0;
                                for (int i4 = 0; i4 < b2; i4++) {
                                    i3 |= (bArr[(i + 1) + i4] & 255) << (((b2 - 1) - i4) * 8);
                                }
                                m11932a(i3, bVar);
                                return i + 1 + b2;
                            }
                            throw new ArrayIndexOutOfBoundsException(String.format("Not enough bytes for %s length encoding.", new Object[]{bVar}));
                        }
                    } else {
                        throw new ArrayIndexOutOfBoundsException(String.format("Not enough bytes for %s length encoding.", new Object[]{bVar}));
                    }
                } else if (bArr.length - i >= 4) {
                    m11932a((int) (bArr[i + 3] & 255) | ((bArr[i] & 255) << Ascii.CAN) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8), bVar);
                    return i + 4;
                } else {
                    throw new ArrayIndexOutOfBoundsException(String.format("Not enough bytes for %s length encoding.", new Object[]{bVar}));
                }
            } else if (bArr.length - i >= 2) {
                m11932a((int) (bArr[i + 1] & 255) | ((bArr[i] & 255) << 8), bVar);
                return i + 2;
            } else {
                throw new ArrayIndexOutOfBoundsException(String.format("Not enough bytes for %s length encoding.", new Object[]{bVar}));
            }
        } else if (bArr.length - i >= 1) {
            m11932a((int) bArr[i] & 255, bVar);
        } else {
            throw new ArrayIndexOutOfBoundsException(String.format("Not enough bytes for %s length encoding.", new Object[]{bVar}));
        }
        return i + 1;
    }

    /* renamed from: a */
    private cpv m11932a(int i, C0331b bVar) {
        if (i >= 0) {
            int i2 = cpw.f4857a[bVar.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (!(i2 == 3 || i2 == 4 || f4810am)) {
                        throw new AssertionError(bVar);
                    }
                } else if (i > 65535) {
                    throw new IllegalArgumentException(String.format("%s encoding cannot support a %d-byte value.", new Object[]{bVar, Integer.valueOf(i)}));
                }
            } else if (i > 255) {
                throw new IllegalArgumentException(String.format("%s encoding cannot support a %d-byte value.", new Object[]{bVar, Integer.valueOf(i)}));
            }
            byte[] bArr = new byte[i];
            byte[] bArr2 = this.f4843au;
            if (bArr2 != null) {
                System.arraycopy(bArr2, 0, bArr, 0, Math.min(i, bArr2.length));
            }
            this.f4843au = bArr;
            return this;
        }
        throw new IllegalArgumentException("Length must not be negative: " + i);
    }

    /* renamed from: a */
    public cpv mo4850a(byte[] bArr, int i, int i2) {
        Objects.requireNonNull(bArr, "Byte array must not be null.");
        if (i >= 0) {
            byte[] bArr2 = this.f4843au;
            if (bArr2.length > 0 && i >= bArr2.length) {
                throw new ArrayIndexOutOfBoundsException(String.format("Offset %d is out of range (byte array length: %d).", new Object[]{Integer.valueOf(i), Integer.valueOf(this.f4843au.length)}));
            } else if (bArr.length - i >= i2) {
                int i3 = cpw.f4857a[this.f4842at.ordinal()];
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (!(i3 == 3 || i3 == 4 || f4810am)) {
                            throw new AssertionError(this.f4842at);
                        }
                    } else if (i2 > 65535) {
                        throw new IllegalArgumentException(String.format("%s encoding cannot support a %d-byte value.", new Object[]{this.f4842at, Integer.valueOf(i2)}));
                    }
                } else if (i2 > 255) {
                    throw new IllegalArgumentException(String.format("%s encoding cannot support a %d-byte value.", new Object[]{this.f4842at, Integer.valueOf(i2)}));
                }
                byte[] bArr3 = new byte[i2];
                System.arraycopy(bArr, i, bArr3, 0, i2);
                this.f4843au = bArr3;
                return this;
            } else {
                throw new IllegalArgumentException(String.format("Number of bytes (%d) and offset (%d) not sufficient for declared length (%d).", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)}));
            }
        } else {
            throw new ArrayIndexOutOfBoundsException("Offset must not be negative: " + i);
        }
    }

    /* renamed from: a */
    private cpv m11929a(int i, byte b) {
        return m11933a(i, new byte[]{b});
    }

    /* renamed from: a */
    public cpv mo4845a(int i, short s) {
        return m11933a(i, new byte[]{(byte) (s >> 8), (byte) s});
    }

    /* renamed from: a */
    public cpv mo4842a(int i, int i2) {
        return m11933a(i, new byte[]{(byte) (i2 >> 24), (byte) (i2 >> 16), (byte) (i2 >> 8), (byte) i2});
    }

    /* renamed from: a */
    public cpv mo4843a(int i, long j) {
        return m11933a(i, new byte[]{(byte) ((int) (j >> 56)), (byte) ((int) (j >> 48)), (byte) ((int) (j >> 40)), (byte) ((int) (j >> 32)), (byte) ((int) (j >> 24)), (byte) ((int) (j >> 16)), (byte) ((int) (j >> 8)), (byte) ((int) j)});
    }

    /* renamed from: a */
    public cpv mo4844a(int i, String str) {
        if (str == null) {
            return m11933a(i, new byte[0]);
        }
        try {
            return m11933a(i, str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException unused) {
            return m11933a(i, str.getBytes());
        }
    }

    /* renamed from: a */
    private cpv m11933a(int i, byte[] bArr) {
        return m11931a(i, this.f4839aq, this.f4842at, bArr);
    }

    /* renamed from: a */
    private cpv m11931a(int i, C0330a aVar, C0331b bVar, byte[] bArr) {
        return mo4848a(new cpv(i, aVar, bVar, bArr, 0, bArr.length));
    }

    /* renamed from: a */
    public cpv mo4848a(cpv cpv) {
        return mo4856c(cpv.mo4851a());
    }

    /* renamed from: c */
    public cpv mo4856c(byte[] bArr) {
        m11940b(bArr, 0, bArr.length);
        return this;
    }

    /* renamed from: b */
    private cpv m11940b(byte[] bArr, int i, int i2) {
        Objects.requireNonNull(bArr, "Byte array must not be null.");
        if (i < 0 || i >= bArr.length) {
            throw new ArrayIndexOutOfBoundsException(String.format("Offset %d is out of range (byte array length: %d).", new Object[]{Integer.valueOf(i), Integer.valueOf(bArr.length)}));
        } else if (bArr.length - i >= i2) {
            int length = this.f4843au.length + i2;
            int i3 = cpw.f4857a[this.f4842at.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (!(i3 == 3 || i3 == 4 || f4810am)) {
                        throw new AssertionError(this.f4842at);
                    }
                } else if (length > 65535) {
                    throw new IllegalArgumentException(String.format("%s encoding cannot support a %d-byte value.", new Object[]{this.f4842at, Integer.valueOf(length)}));
                }
            } else if (length > 255) {
                throw new IllegalArgumentException(String.format("%s encoding cannot support a %d-byte value.", new Object[]{this.f4842at, Integer.valueOf(length)}));
            }
            byte[] bArr2 = new byte[length];
            byte[] bArr3 = this.f4843au;
            System.arraycopy(bArr3, 0, bArr2, 0, bArr3.length);
            System.arraycopy(bArr, i, bArr2, this.f4843au.length, i2);
            this.f4843au = bArr2;
            return this;
        } else {
            throw new IllegalArgumentException(String.format("Number of bytes (%d) and offset (%d) not sufficient for declared length (%d).", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)}));
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        sb.append("Key=");
        if (this.f4839aq.mo4866a() <= 4) {
            sb.append(m11944m());
        } else {
            sb.append('[');
            for (byte b : m11945n()) {
                sb.append(Long.toHexString((long) (b & 255)));
                sb.append(' ');
            }
            sb.append(']');
        }
        sb.append(", Length=");
        sb.append(m11946o());
        sb.append(", Value=[");
        for (byte b2 : m11947p()) {
            sb.append(Long.toHexString((long) (b2 & 255)));
            sb.append(' ');
        }
        sb.append(']');
        sb.append(']');
        return sb.toString();
    }

    /* renamed from: atakplugin.UASTool.cpv$b */
    public enum C0331b {
        OneByte(1),
        TwoBytes(2),
        FourBytes(4),
        BER(5);
        

        /* renamed from: e */
        private final int f4856e;

        private C0331b(int i) {
            this.f4856e = i;
        }

        /* renamed from: a */
        public static C0331b m11977a(int i) {
            if (i == 0) {
                return BER;
            }
            if (i == 1) {
                return OneByte;
            }
            if (i == 2) {
                return TwoBytes;
            }
            if (i != 4) {
                return null;
            }
            return FourBytes;
        }

        /* renamed from: a */
        public int mo4867a() {
            return this.f4856e;
        }
    }

    /* renamed from: atakplugin.UASTool.cpv$a */
    public enum C0330a {
        OneByte(1),
        TwoBytes(2),
        FourBytes(4),
        SixteenBytes(16);
        
        /* access modifiers changed from: private */

        /* renamed from: e */
        public final int f4850e;

        private C0330a(int i) {
            this.f4850e = i;
        }

        /* renamed from: a */
        static C0330a m11975a(int i) {
            if (i == 1) {
                return OneByte;
            }
            if (i == 2) {
                return TwoBytes;
            }
            if (i == 4) {
                return FourBytes;
            }
            if (i != 16) {
                return null;
            }
            return SixteenBytes;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public int mo4866a() {
            return this.f4850e;
        }
    }
}

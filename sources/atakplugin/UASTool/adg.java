package atakplugin.UASTool;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@adm(mo342a = {5}, mo343b = 64)
public class adg extends adh {

    /* renamed from: a */
    public static Map<Integer, Integer> f461a = new HashMap();

    /* renamed from: b */
    public static Map<Integer, String> f462b = new HashMap();

    /* renamed from: A */
    public int f463A;

    /* renamed from: B */
    public int f464B;

    /* renamed from: C */
    public int f465C;

    /* renamed from: D */
    public boolean f466D;

    /* renamed from: E */
    public boolean f467E;

    /* renamed from: F */
    public boolean f468F;

    /* renamed from: G */
    public int f469G;

    /* renamed from: H */
    public boolean f470H;

    /* renamed from: I */
    public int f471I;

    /* renamed from: J */
    public int f472J;

    /* renamed from: K */
    public int f473K;

    /* renamed from: L */
    public int f474L;

    /* renamed from: M */
    public int f475M;

    /* renamed from: N */
    public int f476N;

    /* renamed from: O */
    public int f477O;

    /* renamed from: P */
    public int f478P;

    /* renamed from: Q */
    public int f479Q;

    /* renamed from: R */
    public int f480R;

    /* renamed from: S */
    public int f481S;

    /* renamed from: T */
    public int f482T;

    /* renamed from: U */
    public int f483U;

    /* renamed from: V */
    public int f484V;

    /* renamed from: W */
    public boolean f485W;

    /* renamed from: X */
    byte[] f486X;

    /* renamed from: Y */
    boolean f487Y = false;

    /* renamed from: c */
    public C0012a f488c;

    /* renamed from: d */
    public int f489d;

    /* renamed from: e */
    public int f490e;

    /* renamed from: f */
    public int f491f;

    /* renamed from: g */
    public int f492g;

    /* renamed from: h */
    public int f493h;

    /* renamed from: i */
    public int f494i;

    /* renamed from: j */
    public int f495j;

    /* renamed from: k */
    public boolean f496k;

    /* renamed from: l */
    public boolean f497l;

    /* renamed from: m */
    public int f498m = -1;

    /* renamed from: n */
    public int f499n;

    /* renamed from: o */
    public int f500o;

    /* renamed from: p */
    public int f501p;

    /* renamed from: q */
    public int f502q;

    /* renamed from: r */
    public int f503r;

    /* renamed from: s */
    public int f504s;

    /* renamed from: t */
    public int f505t = -1;

    /* renamed from: u */
    public int f506u = -1;

    /* renamed from: v */
    public int f507v = -1;

    /* renamed from: w */
    public int f508w;

    /* renamed from: x */
    public int f509x;

    /* renamed from: y */
    public int f510y;

    /* renamed from: z */
    public int f511z;

    static {
        f461a.put(0, 96000);
        f461a.put(1, 88200);
        f461a.put(2, 64000);
        f461a.put(3, 48000);
        f461a.put(4, 44100);
        f461a.put(5, 32000);
        f461a.put(6, 24000);
        f461a.put(7, 22050);
        f461a.put(8, 16000);
        f461a.put(9, 12000);
        f461a.put(10, 11025);
        f461a.put(11, 8000);
        f462b.put(1, "AAC main");
        f462b.put(2, "AAC LC");
        f462b.put(3, "AAC SSR");
        f462b.put(4, "AAC LTP");
        f462b.put(5, "SBR");
        f462b.put(6, "AAC Scalable");
        f462b.put(7, "TwinVQ");
        f462b.put(8, "CELP");
        f462b.put(9, "HVXC");
        f462b.put(10, "(reserved)");
        f462b.put(11, "(reserved)");
        f462b.put(12, "TTSI");
        f462b.put(13, "Main synthetic");
        f462b.put(14, "Wavetable synthesis");
        f462b.put(15, "General MIDI");
        f462b.put(16, "Algorithmic Synthesis and Audio FX");
        f462b.put(17, "ER AAC LC");
        f462b.put(18, "(reserved)");
        f462b.put(19, "ER AAC LTP");
        f462b.put(20, "ER AAC Scalable");
        f462b.put(21, "ER TwinVQ");
        f462b.put(22, "ER BSAC");
        f462b.put(23, "ER AAC LD");
        f462b.put(24, "ER CELP");
        f462b.put(25, "ER HVXC");
        f462b.put(26, "ER HILN");
        f462b.put(27, "ER Parametric");
        f462b.put(28, "SSC");
        f462b.put(29, "PS");
        f462b.put(30, "MPEG Surround");
        f462b.put(31, "(escape)");
        f462b.put(32, "Layer-1");
        f462b.put(33, "Layer-2");
        f462b.put(34, "Layer-3");
        f462b.put(35, "DST");
        f462b.put(36, "ALS");
        f462b.put(37, "SLS");
        f462b.put(38, "SLS non-core");
        f462b.put(39, "ER AAC ELD");
        f462b.put(40, "SMR Simple");
        f462b.put(41, "SMR Main");
    }

    public adg() {
        this.f537Z = 5;
    }

    /* renamed from: a */
    public void mo294a(ByteBuffer byteBuffer) {
        this.f487Y = true;
        ByteBuffer slice = byteBuffer.slice();
        slice.limit(this.f538aa);
        byteBuffer.position(byteBuffer.position() + this.f538aa);
        byte[] bArr = new byte[this.f538aa];
        this.f486X = bArr;
        slice.get(bArr);
        slice.rewind();
        adi adi = new adi(slice);
        int a = m471a(adi);
        this.f489d = a;
        this.f490e = a;
        int a2 = adi.mo315a(4);
        this.f491f = a2;
        if (a2 == 15) {
            this.f492g = adi.mo315a(24);
        }
        this.f493h = adi.mo315a(4);
        int i = this.f489d;
        if (i == 5 || i == 29) {
            this.f494i = 5;
            this.f496k = true;
            if (i == 29) {
                this.f497l = true;
            }
            int a3 = adi.mo315a(4);
            this.f498m = a3;
            if (a3 == 15) {
                this.f499n = adi.mo315a(24);
            }
            int a4 = m471a(adi);
            this.f489d = a4;
            if (a4 == 22) {
                this.f500o = adi.mo315a(4);
            }
        } else {
            this.f494i = 0;
        }
        int i2 = this.f489d;
        switch (i2) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 6:
            case 7:
            case 17:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                m472a(this.f491f, this.f493h, i2, adi);
                break;
            case 8:
                throw new UnsupportedOperationException("can't parse CelpSpecificConfig yet");
            case 9:
                throw new UnsupportedOperationException("can't parse HvxcSpecificConfig yet");
            case 12:
                throw new UnsupportedOperationException("can't parse TTSSpecificConfig yet");
            case 13:
            case 14:
            case 15:
            case 16:
                throw new UnsupportedOperationException("can't parse StructuredAudioSpecificConfig yet");
            case 24:
                throw new UnsupportedOperationException("can't parse ErrorResilientCelpSpecificConfig yet");
            case 25:
                throw new UnsupportedOperationException("can't parse ErrorResilientHvxcSpecificConfig yet");
            case 26:
            case 27:
                m475b(this.f491f, this.f493h, i2, adi);
                break;
            case 28:
                throw new UnsupportedOperationException("can't parse SSCSpecificConfig yet");
            case 30:
                this.f501p = adi.mo315a(1);
                throw new UnsupportedOperationException("can't parse SpatialSpecificConfig yet");
            case 32:
            case 33:
            case 34:
                throw new UnsupportedOperationException("can't parse MPEG_1_2_SpecificConfig yet");
            case 35:
                throw new UnsupportedOperationException("can't parse DSTSpecificConfig yet");
            case 36:
                this.f502q = adi.mo315a(5);
                throw new UnsupportedOperationException("can't parse ALSSpecificConfig yet");
            case 37:
            case 38:
                throw new UnsupportedOperationException("can't parse SLSSpecificConfig yet");
            case 39:
                this.f488c = new C0012a(this.f493h, adi);
                break;
            case 40:
            case 41:
                throw new UnsupportedOperationException("can't parse SymbolicMusicSpecificConfig yet");
        }
        int i3 = this.f489d;
        if (!(i3 == 17 || i3 == 39)) {
            switch (i3) {
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                    break;
            }
        }
        int a5 = adi.mo315a(2);
        this.f503r = a5;
        if (a5 == 2 || a5 == 3) {
            throw new UnsupportedOperationException("can't parse ErrorProtectionSpecificConfig yet");
        }
        if (a5 == 3) {
            int a6 = adi.mo315a(1);
            this.f504s = a6;
            if (a6 == 0) {
                throw new RuntimeException("not implemented");
            }
        }
        if (this.f494i != 5 && adi.mo319d() >= 16) {
            int a7 = adi.mo315a(11);
            this.f505t = a7;
            this.f507v = a7;
            if (a7 == 695) {
                int a8 = m471a(adi);
                this.f494i = a8;
                if (a8 == 5) {
                    boolean a9 = adi.mo316a();
                    this.f496k = a9;
                    if (a9) {
                        int a10 = adi.mo315a(4);
                        this.f498m = a10;
                        if (a10 == 15) {
                            this.f499n = adi.mo315a(24);
                        }
                        if (adi.mo319d() >= 12) {
                            int a11 = adi.mo315a(11);
                            this.f505t = a11;
                            this.f506u = a11;
                            if (a11 == 1352) {
                                this.f497l = adi.mo316a();
                            }
                        }
                    }
                }
                if (this.f494i == 22) {
                    boolean a12 = adi.mo316a();
                    this.f496k = a12;
                    if (a12) {
                        int a13 = adi.mo315a(4);
                        this.f498m = a13;
                        if (a13 == 15) {
                            this.f499n = adi.mo315a(24);
                        }
                    }
                    this.f500o = adi.mo315a(4);
                }
            }
        }
    }

    /* renamed from: l */
    private int m480l() {
        int i = (this.f509x == 1 ? 16 : 2) + 1;
        if (this.f493h != 0) {
            int i2 = this.f489d;
            if (i2 == 6 || i2 == 20) {
                i += 3;
            }
            if (this.f511z == 1) {
                if (i2 == 22) {
                    i = i + 5 + 11;
                }
                if (i2 == 17 || i2 == 19 || i2 == 20 || i2 == 23) {
                    i = i + 1 + 1 + 1;
                }
                i++;
                if (this.f469G == 1) {
                    throw new RuntimeException("Not implemented");
                }
            }
            return i;
        }
        throw new UnsupportedOperationException("can't parse program_config_element yet");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo292a() {
        int i;
        int i2 = (this.f490e > 30 ? 11 : 5) + 4;
        if (this.f491f == 15) {
            i2 += 24;
        }
        int i3 = i2 + 4;
        int i4 = this.f489d;
        if (i4 == 5 || i4 == 29) {
            i3 += 4;
            if (this.f498m == 15) {
                i3 += 24;
            }
        }
        if (i4 == 22) {
            i3 += 4;
        }
        if (this.f470H) {
            i3 += m480l();
        }
        int i5 = this.f507v;
        if (i5 >= 0) {
            i += 11;
            if (i5 == 695) {
                int i6 = i + 5;
                int i7 = this.f494i;
                if (i7 > 30) {
                    i6 += 6;
                }
                if (i7 == 5) {
                    i++;
                    if (this.f496k) {
                        i += 4;
                        if (this.f498m == 15) {
                            i += 24;
                        }
                        int i8 = this.f506u;
                        if (i8 >= 0) {
                            i += 11;
                            if (i8 == 1352) {
                                i++;
                            }
                        }
                    }
                }
                if (i7 == 22) {
                    int i9 = i + 1;
                    if (this.f496k) {
                        i9 += 4;
                        if (this.f498m == 15) {
                            i9 += 24;
                        }
                    }
                    i = i9 + 4;
                }
            }
        }
        return (int) Math.ceil(((double) i) / 8.0d);
    }

    /* renamed from: b */
    public ByteBuffer mo295b() {
        ByteBuffer allocate = ByteBuffer.allocate(mo314k());
        C0681nm.m12521d(allocate, this.f537Z);
        mo311a(allocate, mo292a());
        allocate.put(m481m());
        return (ByteBuffer) allocate.rewind();
    }

    /* renamed from: m */
    private ByteBuffer m481m() {
        ByteBuffer wrap = ByteBuffer.wrap(new byte[mo292a()]);
        adj adj = new adj(wrap);
        m473a(this.f490e, adj);
        adj.mo320a(this.f491f, 4);
        if (this.f491f == 15) {
            adj.mo320a(this.f492g, 24);
        }
        adj.mo320a(this.f493h, 4);
        int i = this.f489d;
        if (i == 5 || i == 29) {
            this.f494i = 5;
            this.f496k = true;
            if (i == 29) {
                this.f497l = true;
            }
            adj.mo320a(this.f498m, 4);
            if (this.f498m == 15) {
                adj.mo320a(this.f499n, 24);
            }
            m473a(this.f489d, adj);
            if (this.f489d == 22) {
                adj.mo320a(this.f500o, 4);
            }
        }
        switch (this.f489d) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 6:
            case 7:
            case 17:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                m474a(adj);
                break;
            case 8:
                throw new UnsupportedOperationException("can't write CelpSpecificConfig yet");
            case 9:
                throw new UnsupportedOperationException("can't write HvxcSpecificConfig yet");
            case 12:
                throw new UnsupportedOperationException("can't write TTSSpecificConfig yet");
            case 13:
            case 14:
            case 15:
            case 16:
                throw new UnsupportedOperationException("can't write StructuredAudioSpecificConfig yet");
            case 24:
                throw new UnsupportedOperationException("can't write ErrorResilientCelpSpecificConfig yet");
            case 25:
                throw new UnsupportedOperationException("can't write ErrorResilientHvxcSpecificConfig yet");
            case 26:
            case 27:
                throw new UnsupportedOperationException("can't write parseParametricSpecificConfig yet");
            case 28:
                throw new UnsupportedOperationException("can't write SSCSpecificConfig yet");
            case 30:
                adj.mo320a(this.f501p, 1);
                throw new UnsupportedOperationException("can't write SpatialSpecificConfig yet");
            case 32:
            case 33:
            case 34:
                throw new UnsupportedOperationException("can't write MPEG_1_2_SpecificConfig yet");
            case 35:
                throw new UnsupportedOperationException("can't write DSTSpecificConfig yet");
            case 36:
                adj.mo320a(this.f502q, 5);
                throw new UnsupportedOperationException("can't write ALSSpecificConfig yet");
            case 37:
            case 38:
                throw new UnsupportedOperationException("can't write SLSSpecificConfig yet");
            case 39:
                throw new UnsupportedOperationException("can't write ELDSpecificConfig yet");
            case 40:
            case 41:
                throw new UnsupportedOperationException("can't parse SymbolicMusicSpecificConfig yet");
        }
        int i2 = this.f489d;
        if (!(i2 == 17 || i2 == 39)) {
            switch (i2) {
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                    break;
            }
        }
        adj.mo320a(this.f503r, 2);
        int i3 = this.f503r;
        if (i3 == 2 || i3 == 3) {
            throw new UnsupportedOperationException("can't parse ErrorProtectionSpecificConfig yet");
        }
        if (i3 == 3) {
            adj.mo320a(this.f504s, 1);
            if (this.f504s == 0) {
                throw new RuntimeException("not implemented");
            }
        }
        int i4 = this.f507v;
        if (i4 >= 0) {
            adj.mo320a(i4, 11);
            if (this.f507v == 695) {
                m473a(this.f494i, adj);
                if (this.f494i == 5) {
                    adj.mo321a(this.f496k);
                    if (this.f496k) {
                        adj.mo320a(this.f498m, 4);
                        if (this.f498m == 15) {
                            adj.mo320a(this.f499n, 24);
                        }
                        int i5 = this.f506u;
                        if (i5 >= 0) {
                            adj.mo320a(i5, 11);
                            if (this.f505t == 1352) {
                                adj.mo321a(this.f497l);
                            }
                        }
                    }
                }
                if (this.f494i == 22) {
                    adj.mo321a(this.f496k);
                    if (this.f496k) {
                        adj.mo320a(this.f498m, 4);
                        if (this.f498m == 15) {
                            adj.mo320a(this.f499n, 24);
                        }
                    }
                    adj.mo320a(this.f500o, 4);
                }
            }
        }
        return (ByteBuffer) wrap.rewind();
    }

    /* renamed from: a */
    private void m473a(int i, adj adj) {
        if (i >= 32) {
            adj.mo320a(31, 5);
            adj.mo320a(i - 32, 6);
            return;
        }
        adj.mo320a(i, 5);
    }

    /* renamed from: a */
    private int m471a(adi adi) {
        int a = adi.mo315a(5);
        return a == 31 ? adi.mo315a(6) + 32 : a;
    }

    /* renamed from: a */
    private void m472a(int i, int i2, int i3, adi adi) {
        this.f508w = adi.mo315a(1);
        int a = adi.mo315a(1);
        this.f509x = a;
        if (a == 1) {
            this.f510y = adi.mo315a(14);
        }
        this.f511z = adi.mo315a(1);
        if (i2 != 0) {
            if (i3 == 6 || i3 == 20) {
                this.f463A = adi.mo315a(3);
            }
            if (this.f511z == 1) {
                if (i3 == 22) {
                    this.f464B = adi.mo315a(5);
                    this.f465C = adi.mo315a(11);
                }
                if (i3 == 17 || i3 == 19 || i3 == 20 || i3 == 23) {
                    this.f466D = adi.mo316a();
                    this.f467E = adi.mo316a();
                    this.f468F = adi.mo316a();
                }
                int a2 = adi.mo315a(1);
                this.f469G = a2;
                if (a2 == 1) {
                    throw new RuntimeException("not yet implemented");
                }
            }
            this.f470H = true;
            return;
        }
        throw new UnsupportedOperationException("can't parse program_config_element yet");
    }

    /* renamed from: a */
    private void m474a(adj adj) {
        adj.mo320a(this.f508w, 1);
        adj.mo320a(this.f509x, 1);
        if (this.f509x == 1) {
            adj.mo320a(this.f510y, 14);
        }
        adj.mo320a(this.f511z, 1);
        if (this.f493h != 0) {
            int i = this.f489d;
            if (i == 6 || i == 20) {
                adj.mo320a(this.f463A, 3);
            }
            if (this.f511z == 1) {
                if (this.f489d == 22) {
                    adj.mo320a(this.f464B, 5);
                    adj.mo320a(this.f465C, 11);
                }
                int i2 = this.f489d;
                if (i2 == 17 || i2 == 19 || i2 == 20 || i2 == 23) {
                    adj.mo321a(this.f466D);
                    adj.mo321a(this.f467E);
                    adj.mo321a(this.f468F);
                }
                adj.mo320a(this.f469G, 1);
                if (this.f469G == 1) {
                    throw new RuntimeException("not yet implemented");
                }
                return;
            }
            return;
        }
        throw new UnsupportedOperationException("can't parse program_config_element yet");
    }

    /* renamed from: b */
    private void m475b(int i, int i2, int i3, adi adi) {
        int a = adi.mo315a(1);
        this.f471I = a;
        if (a == 1) {
            m476c(i, i2, i3, adi);
        } else {
            m479f(i, i2, i3, adi);
        }
    }

    /* renamed from: c */
    private void m476c(int i, int i2, int i3, adi adi) {
        int a = adi.mo315a(2);
        this.f472J = a;
        if (a != 1) {
            m477d(i, i2, i3, adi);
        }
        if (this.f472J != 0) {
            m478e(i, i2, i3, adi);
        }
        this.f473K = adi.mo315a(1);
        this.f485W = true;
    }

    /* renamed from: d */
    private void m477d(int i, int i2, int i3, adi adi) {
        this.f474L = adi.mo315a(1);
        this.f475M = adi.mo315a(2);
        int a = adi.mo315a(1);
        this.f476N = a;
        if (a == 1) {
            this.f477O = adi.mo315a(1);
        }
    }

    /* renamed from: e */
    private void m478e(int i, int i2, int i3, adi adi) {
        this.f478P = adi.mo315a(1);
        this.f479Q = adi.mo315a(8);
        this.f480R = adi.mo315a(4);
        this.f481S = adi.mo315a(12);
        this.f482T = adi.mo315a(2);
    }

    /* renamed from: f */
    private void m479f(int i, int i2, int i3, adi adi) {
        int a = adi.mo315a(1);
        this.f483U = a;
        if (a == 1) {
            this.f484V = adi.mo315a(2);
        }
    }

    /* renamed from: c */
    public byte[] mo298c() {
        return m481m().array();
    }

    /* renamed from: d */
    public int mo299d() {
        return this.f489d;
    }

    /* renamed from: a */
    public void mo293a(int i) {
        this.f489d = i;
    }

    /* renamed from: b */
    public void mo296b(int i) {
        this.f490e = i;
    }

    /* renamed from: e */
    public int mo301e() {
        return this.f494i;
    }

    /* renamed from: c */
    public void mo297c(int i) {
        this.f491f = i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AudioSpecificConfig");
        sb.append("{configBytes=");
        sb.append(C0677ni.m12484a(this.f486X));
        sb.append(", audioObjectType=");
        sb.append(this.f489d);
        sb.append(" (");
        sb.append(f462b.get(Integer.valueOf(this.f489d)));
        sb.append(")");
        sb.append(", samplingFrequencyIndex=");
        sb.append(this.f491f);
        sb.append(" (");
        sb.append(f461a.get(Integer.valueOf(this.f491f)));
        sb.append(")");
        sb.append(", samplingFrequency=");
        sb.append(this.f492g);
        sb.append(", channelConfiguration=");
        sb.append(this.f493h);
        if (this.f494i > 0) {
            sb.append(", extensionAudioObjectType=");
            sb.append(this.f494i);
            sb.append(" (");
            sb.append(f462b.get(Integer.valueOf(this.f494i)));
            sb.append(")");
            sb.append(", sbrPresentFlag=");
            sb.append(this.f496k);
            sb.append(", psPresentFlag=");
            sb.append(this.f497l);
            sb.append(", extensionSamplingFrequencyIndex=");
            sb.append(this.f498m);
            sb.append(" (");
            sb.append(f461a.get(Integer.valueOf(this.f498m)));
            sb.append(")");
            sb.append(", extensionSamplingFrequency=");
            sb.append(this.f499n);
            sb.append(", extensionChannelConfiguration=");
            sb.append(this.f500o);
        }
        sb.append(", syncExtensionType=");
        sb.append(this.f505t);
        if (this.f470H) {
            sb.append(", frameLengthFlag=");
            sb.append(this.f508w);
            sb.append(", dependsOnCoreCoder=");
            sb.append(this.f509x);
            sb.append(", coreCoderDelay=");
            sb.append(this.f510y);
            sb.append(", extensionFlag=");
            sb.append(this.f511z);
            sb.append(", layerNr=");
            sb.append(this.f463A);
            sb.append(", numOfSubFrame=");
            sb.append(this.f464B);
            sb.append(", layer_length=");
            sb.append(this.f465C);
            sb.append(", aacSectionDataResilienceFlag=");
            sb.append(this.f466D);
            sb.append(", aacScalefactorDataResilienceFlag=");
            sb.append(this.f467E);
            sb.append(", aacSpectralDataResilienceFlag=");
            sb.append(this.f468F);
            sb.append(", extensionFlag3=");
            sb.append(this.f469G);
        }
        if (this.f485W) {
            sb.append(", isBaseLayer=");
            sb.append(this.f471I);
            sb.append(", paraMode=");
            sb.append(this.f472J);
            sb.append(", paraExtensionFlag=");
            sb.append(this.f473K);
            sb.append(", hvxcVarMode=");
            sb.append(this.f474L);
            sb.append(", hvxcRateMode=");
            sb.append(this.f475M);
            sb.append(", erHvxcExtensionFlag=");
            sb.append(this.f476N);
            sb.append(", var_ScalableFlag=");
            sb.append(this.f477O);
            sb.append(", hilnQuantMode=");
            sb.append(this.f478P);
            sb.append(", hilnMaxNumLine=");
            sb.append(this.f479Q);
            sb.append(", hilnSampleRateCode=");
            sb.append(this.f480R);
            sb.append(", hilnFrameLength=");
            sb.append(this.f481S);
            sb.append(", hilnContMode=");
            sb.append(this.f482T);
            sb.append(", hilnEnhaLayer=");
            sb.append(this.f483U);
            sb.append(", hilnEnhaQuantMode=");
            sb.append(this.f484V);
        }
        sb.append('}');
        return sb.toString();
    }

    /* renamed from: f */
    public int mo304f() {
        int i = this.f491f;
        return i == 15 ? this.f492g : f461a.get(Integer.valueOf(i)).intValue();
    }

    /* renamed from: g */
    public int mo305g() {
        int i = this.f498m;
        return i == 15 ? this.f499n : f461a.get(Integer.valueOf(i)).intValue();
    }

    /* renamed from: d */
    public void mo300d(int i) {
        this.f492g = i;
    }

    /* renamed from: h */
    public int mo306h() {
        return this.f493h;
    }

    /* renamed from: e */
    public void mo302e(int i) {
        this.f493h = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        adg adg = (adg) obj;
        return this.f467E == adg.f467E && this.f466D == adg.f466D && this.f468F == adg.f468F && this.f489d == adg.f489d && this.f493h == adg.f493h && this.f510y == adg.f510y && this.f509x == adg.f509x && this.f504s == adg.f504s && this.f503r == adg.f503r && this.f476N == adg.f476N && this.f494i == adg.f494i && this.f500o == adg.f500o && this.f511z == adg.f511z && this.f469G == adg.f469G && this.f499n == adg.f499n && this.f498m == adg.f498m && this.f502q == adg.f502q && this.f508w == adg.f508w && this.f470H == adg.f470H && this.f482T == adg.f482T && this.f483U == adg.f483U && this.f484V == adg.f484V && this.f481S == adg.f481S && this.f479Q == adg.f479Q && this.f478P == adg.f478P && this.f480R == adg.f480R && this.f475M == adg.f475M && this.f474L == adg.f474L && this.f471I == adg.f471I && this.f463A == adg.f463A && this.f465C == adg.f465C && this.f464B == adg.f464B && this.f473K == adg.f473K && this.f472J == adg.f472J && this.f485W == adg.f485W && this.f497l == adg.f497l && this.f501p == adg.f501p && this.f492g == adg.f492g && this.f491f == adg.f491f && this.f496k == adg.f496k && this.f505t == adg.f505t && this.f477O == adg.f477O && Arrays.equals(this.f486X, adg.f486X);
    }

    public int hashCode() {
        byte[] bArr = this.f486X;
        return ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((bArr != null ? Arrays.hashCode(bArr) : 0) * 31) + this.f489d) * 31) + this.f491f) * 31) + this.f492g) * 31) + this.f493h) * 31) + this.f494i) * 31) + (this.f496k ? 1 : 0)) * 31) + (this.f497l ? 1 : 0)) * 31) + this.f498m) * 31) + this.f499n) * 31) + this.f500o) * 31) + this.f501p) * 31) + this.f502q) * 31) + this.f503r) * 31) + this.f504s) * 31) + this.f505t) * 31) + this.f508w) * 31) + this.f509x) * 31) + this.f510y) * 31) + this.f511z) * 31) + this.f463A) * 31) + this.f464B) * 31) + this.f465C) * 31) + (this.f466D ? 1 : 0)) * 31) + (this.f467E ? 1 : 0)) * 31) + (this.f468F ? 1 : 0)) * 31) + this.f469G) * 31) + (this.f470H ? 1 : 0)) * 31) + this.f471I) * 31) + this.f472J) * 31) + this.f473K) * 31) + this.f474L) * 31) + this.f475M) * 31) + this.f476N) * 31) + this.f477O) * 31) + this.f478P) * 31) + this.f479Q) * 31) + this.f480R) * 31) + this.f481S) * 31) + this.f482T) * 31) + this.f483U) * 31) + this.f484V) * 31) + (this.f485W ? 1 : 0);
    }

    /* renamed from: atakplugin.UASTool.adg$a */
    public class C0012a {

        /* renamed from: i */
        private static final int f512i = 0;

        /* renamed from: a */
        public boolean f513a;

        /* renamed from: b */
        public boolean f514b;

        /* renamed from: c */
        public boolean f515c;

        /* renamed from: d */
        public boolean f516d;

        /* renamed from: e */
        public boolean f517e;

        /* renamed from: f */
        public boolean f518f;

        /* renamed from: g */
        public boolean f519g;

        public C0012a(int i, adi adi) {
            int i2;
            this.f513a = adi.mo316a();
            this.f514b = adi.mo316a();
            this.f515c = adi.mo316a();
            this.f516d = adi.mo316a();
            boolean a = adi.mo316a();
            this.f517e = a;
            if (a) {
                this.f518f = adi.mo316a();
                this.f519g = adi.mo316a();
                mo309a(i, adi);
            }
            while (adi.mo315a(4) != 0) {
                int a2 = adi.mo315a(4);
                if (a2 == 15) {
                    i2 = adi.mo315a(8);
                    a2 += i2;
                } else {
                    i2 = 0;
                }
                if (i2 == 255) {
                    a2 += adi.mo315a(16);
                }
                for (int i3 = 0; i3 < a2; i3++) {
                    adi.mo315a(8);
                }
            }
        }

        /* renamed from: a */
        public void mo309a(int i, adi adi) {
            int i2;
            switch (i) {
                case 1:
                case 2:
                    i2 = 1;
                    break;
                case 3:
                    i2 = 2;
                    break;
                case 4:
                case 5:
                case 6:
                    i2 = 3;
                    break;
                case 7:
                    i2 = 4;
                    break;
                default:
                    i2 = 0;
                    break;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                new C0013b(adi);
            }
        }
    }

    /* renamed from: atakplugin.UASTool.adg$b */
    public class C0013b {

        /* renamed from: a */
        public boolean f521a;

        /* renamed from: b */
        public int f522b;

        /* renamed from: c */
        public int f523c;

        /* renamed from: d */
        public int f524d;

        /* renamed from: e */
        public int f525e;

        /* renamed from: f */
        public boolean f526f;

        /* renamed from: g */
        public boolean f527g;

        /* renamed from: h */
        public int f528h;

        /* renamed from: i */
        public boolean f529i;

        /* renamed from: j */
        public int f530j;

        /* renamed from: k */
        public int f531k;

        /* renamed from: l */
        public int f532l;

        /* renamed from: m */
        public boolean f533m;

        /* renamed from: n */
        public boolean f534n;

        public C0013b(adi adi) {
            this.f521a = adi.mo316a();
            this.f522b = adi.mo315a(4);
            this.f523c = adi.mo315a(4);
            this.f524d = adi.mo315a(3);
            this.f525e = adi.mo315a(2);
            this.f526f = adi.mo316a();
            this.f527g = adi.mo316a();
            if (this.f526f) {
                this.f528h = adi.mo315a(2);
                this.f529i = adi.mo316a();
                this.f530j = adi.mo315a(2);
            }
            if (this.f527g) {
                this.f531k = adi.mo315a(2);
                this.f532l = adi.mo315a(2);
                this.f533m = adi.mo316a();
            }
            this.f534n = adi.mo316a();
        }
    }
}

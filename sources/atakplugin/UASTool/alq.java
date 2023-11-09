package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class alq extends C1004wp {

    /* renamed from: a */
    public static final String f2011a = "pssh";

    /* renamed from: b */
    public static byte[] f2012b = afw.m896a(UUID.fromString("A2B55680-6F43-11E0-9A3F-0002A5D5C51B"));

    /* renamed from: c */
    public static byte[] f2013c = afw.m896a(UUID.fromString("edef8ba9-79d6-4ace-a3c8-27dcd51d21ed"));

    /* renamed from: d */
    public static byte[] f2014d = afw.m896a(UUID.fromString("9A04F079-9840-4286-AB92-E65BE0885F95"));

    /* renamed from: p */
    static final /* synthetic */ boolean f2015p = true;

    /* renamed from: q */
    private static final /* synthetic */ can.C0296b f2016q = null;

    /* renamed from: r */
    private static final /* synthetic */ can.C0296b f2017r = null;

    /* renamed from: s */
    private static final /* synthetic */ can.C0296b f2018s = null;

    /* renamed from: t */
    private static final /* synthetic */ can.C0296b f2019t = null;

    /* renamed from: u */
    private static final /* synthetic */ can.C0296b f2020u = null;

    /* renamed from: v */
    private static final /* synthetic */ can.C0296b f2021v = null;

    /* renamed from: e */
    byte[] f2022e;

    /* renamed from: f */
    byte[] f2023f;

    /* renamed from: o */
    List<UUID> f2024o = new ArrayList();

    /* renamed from: k */
    private static /* synthetic */ void m2307k() {
        cdj cdj = new cdj("ProtectionSystemSpecificHeaderBox.java", alq.class);
        f2016q = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getKeyIds", "com.mp4parser.iso23001.part7.ProtectionSystemSpecificHeaderBox", "", "", "", "java.util.List"), 50);
        f2017r = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setKeyIds", "com.mp4parser.iso23001.part7.ProtectionSystemSpecificHeaderBox", "java.util.List", "keyIds", "", "void"), 54);
        f2018s = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getSystemId", "com.mp4parser.iso23001.part7.ProtectionSystemSpecificHeaderBox", "", "", "", "[B"), 61);
        f2019t = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setSystemId", "com.mp4parser.iso23001.part7.ProtectionSystemSpecificHeaderBox", "[B", "systemId", "", "void"), 65);
        f2020u = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getContent", "com.mp4parser.iso23001.part7.ProtectionSystemSpecificHeaderBox", "", "", "", "[B"), 70);
        f2021v = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setContent", "com.mp4parser.iso23001.part7.ProtectionSystemSpecificHeaderBox", "[B", "content", "", "void"), 74);
    }

    static {
        m2307k();
    }

    public alq(byte[] bArr, byte[] bArr2) {
        super(f2011a);
        this.f2022e = bArr2;
        this.f2023f = bArr;
    }

    /* renamed from: c */
    public List<UUID> mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f2016q, (Object) this, (Object) this));
        return this.f2024o;
    }

    /* renamed from: a */
    public void mo1410a(List<UUID> list) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f2017r, (Object) this, (Object) this, (Object) list));
        this.f2024o = list;
    }

    /* renamed from: i */
    public byte[] mo43i() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f2018s, (Object) this, (Object) this));
        return this.f2023f;
    }

    /* renamed from: a */
    public void mo1411a(byte[] bArr) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f2019t, (Object) this, (Object) this, (Object) bArr));
        if (f2015p || bArr.length == 16) {
            this.f2023f = bArr;
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: j */
    public byte[] mo1413j() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f2020u, (Object) this, (Object) this));
        return this.f2022e;
    }

    /* renamed from: b */
    public void mo1412b(byte[] bArr) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f2021v, (Object) this, (Object) this, (Object) bArr));
        this.f2022e = bArr;
    }

    public alq() {
        super(f2011a);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        long length = (long) (this.f2022e.length + 24);
        return mo5157a_() > 0 ? length + 4 + ((long) (this.f2024o.size() * 16)) : length;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        if (f2015p || this.f2023f.length == 16) {
            byteBuffer.put(this.f2023f, 0, 16);
            if (mo5157a_() > 0) {
                C0681nm.m12515b(byteBuffer, (long) this.f2024o.size());
                for (UUID a : this.f2024o) {
                    byteBuffer.put(afw.m896a(a));
                }
            }
            C0681nm.m12515b(byteBuffer, (long) this.f2022e.length);
            byteBuffer.put(this.f2022e);
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        byte[] bArr = new byte[16];
        this.f2023f = bArr;
        byteBuffer.get(bArr);
        if (mo5157a_() > 0) {
            int a = afi.m847a(C0679nk.m12495b(byteBuffer));
            while (true) {
                int i = a - 1;
                if (a <= 0) {
                    break;
                }
                byte[] bArr2 = new byte[16];
                byteBuffer.get(bArr2);
                this.f2024o.add(afw.m895a(bArr2));
                a = i;
            }
        }
        long b = C0679nk.m12495b(byteBuffer);
        byte[] bArr3 = new byte[byteBuffer.remaining()];
        this.f2022e = bArr3;
        byteBuffer.get(bArr3);
        if (!f2015p && b != ((long) this.f2022e.length)) {
            throw new AssertionError();
        }
    }
}

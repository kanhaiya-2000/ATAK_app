package atakplugin.UASTool;

public class akq extends akp {

    /* renamed from: a */
    private static final String f1717a = "hmac-md5-96";

    /* renamed from: b */
    private static final int f1718b = 12;

    /* renamed from: c */
    private final byte[] f1719c = new byte[16];

    /* renamed from: a */
    public String mo988a() {
        return f1717a;
    }

    /* renamed from: b */
    public int mo1185b() {
        return 12;
    }

    /* renamed from: a */
    public void mo1183a(byte[] bArr, int i) {
        super.mo1183a(this.f1719c, 0);
        System.arraycopy(this.f1719c, 0, bArr, i, 12);
    }
}

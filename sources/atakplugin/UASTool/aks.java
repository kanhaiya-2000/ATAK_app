package atakplugin.UASTool;

public class aks extends akr {

    /* renamed from: a */
    private static final String f1721a = "hmac-sha1-96";

    /* renamed from: b */
    private static final int f1722b = 12;

    /* renamed from: c */
    private final byte[] f1723c = new byte[20];

    /* renamed from: a */
    public String mo988a() {
        return f1721a;
    }

    /* renamed from: b */
    public int mo1185b() {
        return 12;
    }

    /* renamed from: a */
    public void mo1183a(byte[] bArr, int i) {
        super.mo1183a(this.f1723c, 0);
        System.arraycopy(this.f1723c, 0, bArr, i, 12);
    }
}

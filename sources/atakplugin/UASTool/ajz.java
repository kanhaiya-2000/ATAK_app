package atakplugin.UASTool;

public class ajz extends ajy {

    /* renamed from: d */
    private final byte[] f1675d = new byte[20];

    /* renamed from: b */
    public int mo993b() {
        return 12;
    }

    public ajz() {
        this.f1669a = "hmac-sha1-96";
    }

    /* renamed from: a */
    public void mo991a(byte[] bArr, int i) {
        super.mo991a(this.f1675d, 0);
        System.arraycopy(this.f1675d, 0, bArr, i, 12);
    }
}

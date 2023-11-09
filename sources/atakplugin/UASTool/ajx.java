package atakplugin.UASTool;

public class ajx extends ajw {

    /* renamed from: d */
    private final byte[] f1674d = new byte[16];

    /* renamed from: b */
    public int mo993b() {
        return 12;
    }

    public ajx() {
        this.f1669a = "hmac-md5-96";
    }

    /* renamed from: a */
    public void mo991a(byte[] bArr, int i) {
        super.mo991a(this.f1674d, 0);
        System.arraycopy(this.f1674d, 0, bArr, i, 12);
    }
}

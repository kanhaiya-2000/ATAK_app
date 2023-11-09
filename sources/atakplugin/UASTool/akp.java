package atakplugin.UASTool;

import java.security.MessageDigest;

public class akp extends ako implements ahv {

    /* renamed from: a */
    private static final String f1716a = "hmac-md5";

    /* renamed from: a */
    public String mo988a() {
        return f1716a;
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo1180a(int i) {
        super.mo1180a(i);
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo1182a(byte[] bArr) {
        super.mo1182a(bArr);
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo1183a(byte[] bArr, int i) {
        super.mo1183a(bArr, i);
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo1184a(byte[] bArr, int i, int i2) {
        super.mo1184a(bArr, i, i2);
    }

    /* renamed from: b */
    public /* bridge */ /* synthetic */ int mo1185b() {
        return super.mo1185b();
    }

    public akp() {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            System.err.println(e);
            messageDigest = null;
        }
        mo1181a(messageDigest);
    }
}

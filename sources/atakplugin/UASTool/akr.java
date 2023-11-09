package atakplugin.UASTool;

import java.security.MessageDigest;

public class akr extends ako implements ahv {

    /* renamed from: a */
    private static final String f1720a = "hmac-sha1";

    /* renamed from: a */
    public String mo988a() {
        return f1720a;
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

    public akr() {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("SHA-1");
        } catch (Exception e) {
            System.err.println(e);
            messageDigest = null;
        }
        mo1181a(messageDigest);
    }
}

package atakplugin.UASTool;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import javax.crypto.KeyAgreement;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPublicKeySpec;

public class aju implements ags {

    /* renamed from: a */
    BigInteger f1660a;

    /* renamed from: b */
    BigInteger f1661b;

    /* renamed from: c */
    BigInteger f1662c;

    /* renamed from: d */
    byte[] f1663d;

    /* renamed from: e */
    BigInteger f1664e;

    /* renamed from: f */
    BigInteger f1665f;

    /* renamed from: g */
    byte[] f1666g;

    /* renamed from: h */
    private KeyPairGenerator f1667h;

    /* renamed from: i */
    private KeyAgreement f1668i;

    /* renamed from: a */
    public void mo817a() {
        this.f1667h = KeyPairGenerator.getInstance("DH");
        this.f1668i = KeyAgreement.getInstance("DH");
    }

    /* renamed from: b */
    public byte[] mo820b() {
        if (this.f1662c == null) {
            this.f1667h.initialize(new DHParameterSpec(this.f1660a, this.f1661b));
            KeyPair generateKeyPair = this.f1667h.generateKeyPair();
            this.f1668i.init(generateKeyPair.getPrivate());
            generateKeyPair.getPublic().getEncoded();
            BigInteger y = ((DHPublicKey) generateKeyPair.getPublic()).getY();
            this.f1662c = y;
            this.f1663d = y.toByteArray();
        }
        return this.f1663d;
    }

    /* renamed from: c */
    public byte[] mo822c() {
        if (this.f1665f == null) {
            this.f1668i.doPhase(KeyFactory.getInstance("DH").generatePublic(new DHPublicKeySpec(this.f1664e, this.f1660a, this.f1661b)), true);
            byte[] generateSecret = this.f1668i.generateSecret();
            BigInteger bigInteger = new BigInteger(generateSecret);
            this.f1665f = bigInteger;
            this.f1666g = bigInteger.toByteArray();
            this.f1666g = generateSecret;
        }
        return this.f1666g;
    }

    /* renamed from: a */
    public void mo818a(byte[] bArr) {
        mo1176a(new BigInteger(bArr));
    }

    /* renamed from: b */
    public void mo819b(byte[] bArr) {
        mo1177b(new BigInteger(bArr));
    }

    /* renamed from: c */
    public void mo821c(byte[] bArr) {
        mo1178c(new BigInteger(bArr));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1176a(BigInteger bigInteger) {
        this.f1660a = bigInteger;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo1177b(BigInteger bigInteger) {
        this.f1661b = bigInteger;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo1178c(BigInteger bigInteger) {
        this.f1664e = bigInteger;
    }
}

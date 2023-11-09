package atakplugin.UASTool;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

public class akd implements ahp {

    /* renamed from: a */
    byte[] f1681a;

    /* renamed from: b */
    byte[] f1682b;

    /* renamed from: c */
    byte[] f1683c;

    /* renamed from: d */
    byte[] f1684d;

    /* renamed from: e */
    byte[] f1685e;

    /* renamed from: f */
    byte[] f1686f;

    /* renamed from: g */
    byte[] f1687g;

    /* renamed from: h */
    byte[] f1688h;

    /* renamed from: a */
    public void mo967a(int i) {
        KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA");
        instance.initialize(i, new SecureRandom());
        KeyPair generateKeyPair = instance.generateKeyPair();
        PublicKey publicKey = generateKeyPair.getPublic();
        PrivateKey privateKey = generateKeyPair.getPrivate();
        RSAPrivateKey rSAPrivateKey = (RSAPrivateKey) privateKey;
        this.f1681a = rSAPrivateKey.getPrivateExponent().toByteArray();
        this.f1682b = ((RSAPublicKey) publicKey).getPublicExponent().toByteArray();
        this.f1683c = rSAPrivateKey.getModulus().toByteArray();
        RSAPrivateCrtKey rSAPrivateCrtKey = (RSAPrivateCrtKey) privateKey;
        this.f1684d = rSAPrivateCrtKey.getCrtCoefficient().toByteArray();
        this.f1685e = rSAPrivateCrtKey.getPrimeExponentP().toByteArray();
        this.f1686f = rSAPrivateCrtKey.getPrimeExponentQ().toByteArray();
        this.f1687g = rSAPrivateCrtKey.getPrimeP().toByteArray();
        this.f1688h = rSAPrivateCrtKey.getPrimeQ().toByteArray();
    }

    /* renamed from: a */
    public byte[] mo968a() {
        return this.f1681a;
    }

    /* renamed from: b */
    public byte[] mo969b() {
        return this.f1682b;
    }

    /* renamed from: c */
    public byte[] mo970c() {
        return this.f1683c;
    }

    /* renamed from: d */
    public byte[] mo971d() {
        return this.f1684d;
    }

    /* renamed from: e */
    public byte[] mo972e() {
        return this.f1685e;
    }

    /* renamed from: f */
    public byte[] mo973f() {
        return this.f1686f;
    }

    /* renamed from: g */
    public byte[] mo974g() {
        return this.f1687g;
    }

    /* renamed from: h */
    public byte[] mo975h() {
        return this.f1688h;
    }
}

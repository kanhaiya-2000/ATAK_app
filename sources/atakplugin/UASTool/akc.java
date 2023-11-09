package atakplugin.UASTool;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.interfaces.DSAKey;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPrivateKey;
import java.security.interfaces.DSAPublicKey;

public class akc implements aho {

    /* renamed from: a */
    byte[] f1676a;

    /* renamed from: b */
    byte[] f1677b;

    /* renamed from: c */
    byte[] f1678c;

    /* renamed from: d */
    byte[] f1679d;

    /* renamed from: e */
    byte[] f1680e;

    /* renamed from: a */
    public void mo961a(int i) {
        KeyPairGenerator instance = KeyPairGenerator.getInstance("DSA");
        instance.initialize(i, new SecureRandom());
        KeyPair generateKeyPair = instance.generateKeyPair();
        PublicKey publicKey = generateKeyPair.getPublic();
        PrivateKey privateKey = generateKeyPair.getPrivate();
        this.f1676a = ((DSAPrivateKey) privateKey).getX().toByteArray();
        this.f1677b = ((DSAPublicKey) publicKey).getY().toByteArray();
        DSAParams params = ((DSAKey) privateKey).getParams();
        this.f1678c = params.getP().toByteArray();
        this.f1679d = params.getQ().toByteArray();
        this.f1680e = params.getG().toByteArray();
    }

    /* renamed from: a */
    public byte[] mo962a() {
        return this.f1676a;
    }

    /* renamed from: b */
    public byte[] mo963b() {
        return this.f1677b;
    }

    /* renamed from: c */
    public byte[] mo964c() {
        return this.f1678c;
    }

    /* renamed from: d */
    public byte[] mo965d() {
        return this.f1679d;
    }

    /* renamed from: e */
    public byte[] mo966e() {
        return this.f1680e;
    }
}

package atakplugin.UASTool;

import com.google.common.base.Ascii;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.Signature;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

public class akk implements aiy {

    /* renamed from: a */
    Signature f1696a;

    /* renamed from: b */
    KeyFactory f1697b;

    /* renamed from: a */
    public void mo1154a() {
        this.f1696a = Signature.getInstance("SHA1withRSA");
        this.f1697b = KeyFactory.getInstance("RSA");
    }

    /* renamed from: a */
    public void mo1160a(byte[] bArr, byte[] bArr2) {
        this.f1696a.initVerify(this.f1697b.generatePublic(new RSAPublicKeySpec(new BigInteger(bArr2), new BigInteger(bArr))));
    }

    /* renamed from: b */
    public void mo1161b(byte[] bArr, byte[] bArr2) {
        this.f1696a.initSign(this.f1697b.generatePrivate(new RSAPrivateKeySpec(new BigInteger(bArr2), new BigInteger(bArr))));
    }

    /* renamed from: b */
    public byte[] mo1157b() {
        return this.f1696a.sign();
    }

    /* renamed from: a */
    public void mo1155a(byte[] bArr) {
        this.f1696a.update(bArr);
    }

    /* renamed from: b */
    public boolean mo1156b(byte[] bArr) {
        if (bArr[0] == 0 && bArr[1] == 0 && bArr[2] == 0) {
            int i = 4 + (((bArr[1] << 16) & 16711680) | ((bArr[0] << Ascii.CAN) & -16777216) | ((bArr[2] << 8) & 65280) | (bArr[3] & 255));
            int i2 = i + 1;
            int i3 = i2 + 1;
            byte b = ((bArr[i2] << 16) & 16711680) | ((bArr[i] << Ascii.CAN) & -16777216);
            int i4 = i3 + 1;
            byte b2 = b | ((bArr[i3] << 8) & 65280);
            int i5 = i4 + 1;
            int i6 = b2 | (bArr[i4] & 255);
            byte[] bArr2 = new byte[i6];
            System.arraycopy(bArr, i5, bArr2, 0, i6);
            bArr = bArr2;
        }
        return this.f1696a.verify(bArr);
    }
}

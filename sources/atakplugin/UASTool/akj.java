package atakplugin.UASTool;

import com.google.common.base.Ascii;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.Signature;
import java.security.spec.DSAPrivateKeySpec;
import java.security.spec.DSAPublicKeySpec;

public class akj implements aix {

    /* renamed from: a */
    Signature f1694a;

    /* renamed from: b */
    KeyFactory f1695b;

    /* renamed from: a */
    public void mo1154a() {
        this.f1694a = Signature.getInstance("SHA1withDSA");
        this.f1695b = KeyFactory.getInstance("DSA");
    }

    /* renamed from: a */
    public void mo1158a(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        this.f1694a.initVerify(this.f1695b.generatePublic(new DSAPublicKeySpec(new BigInteger(bArr), new BigInteger(bArr2), new BigInteger(bArr3), new BigInteger(bArr4))));
    }

    /* renamed from: b */
    public void mo1159b(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        this.f1694a.initSign(this.f1695b.generatePrivate(new DSAPrivateKeySpec(new BigInteger(bArr), new BigInteger(bArr2), new BigInteger(bArr3), new BigInteger(bArr4))));
    }

    /* renamed from: b */
    public byte[] mo1157b() {
        byte[] sign = this.f1694a.sign();
        int i = sign[3] & 255;
        byte[] bArr = new byte[i];
        int i2 = 0;
        System.arraycopy(sign, 4, bArr, 0, i);
        int i3 = 4 + i + 1;
        int i4 = i3 + 1;
        int i5 = sign[i3] & 255;
        byte[] bArr2 = new byte[i5];
        System.arraycopy(sign, i4, bArr2, 0, i5);
        byte[] bArr3 = new byte[40];
        int i6 = i > 20 ? 1 : 0;
        int i7 = i > 20 ? 0 : 20 - i;
        if (i > 20) {
            i = 20;
        }
        System.arraycopy(bArr, i6, bArr3, i7, i);
        if (i5 > 20) {
            i2 = 1;
        }
        int i8 = i5 > 20 ? 20 : 40 - i5;
        if (i5 > 20) {
            i5 = 20;
        }
        System.arraycopy(bArr2, i2, bArr3, i8, i5);
        return bArr3;
    }

    /* renamed from: a */
    public void mo1155a(byte[] bArr) {
        this.f1694a.update(bArr);
    }

    /* renamed from: b */
    public boolean mo1156b(byte[] bArr) {
        if (bArr[0] == 0 && bArr[1] == 0 && bArr[2] == 0) {
            int i = (((bArr[0] << Ascii.CAN) & -16777216) | ((bArr[1] << 16) & 16711680) | ((bArr[2] << 8) & 65280) | (bArr[3] & 255)) + 4;
            int i2 = i + 1;
            int i3 = i2 + 1;
            byte b = ((bArr[i] << Ascii.CAN) & -16777216) | ((bArr[i2] << 16) & 16711680);
            int i4 = i3 + 1;
            byte b2 = b | ((bArr[i3] << 8) & 65280);
            int i5 = i4 + 1;
            int i6 = b2 | (bArr[i4] & 255);
            byte[] bArr2 = new byte[i6];
            System.arraycopy(bArr, i5, bArr2, 0, i6);
            bArr = bArr2;
        }
        byte b3 = (bArr[0] & 128) != 0 ? (byte) 1 : 0;
        byte b4 = (bArr[20] & 128) != 0 ? (byte) 1 : 0;
        byte[] bArr3 = new byte[(bArr.length + 6 + b3 + b4)];
        bArr3[0] = 48;
        bArr3[1] = 44;
        bArr3[1] = (byte) (bArr3[1] + b3);
        bArr3[1] = (byte) (bArr3[1] + b4);
        bArr3[2] = 2;
        bArr3[3] = Ascii.DC4;
        bArr3[3] = (byte) (bArr3[3] + b3);
        System.arraycopy(bArr, 0, bArr3, b3 + 4, 20);
        bArr3[bArr3[3] + 4] = 2;
        bArr3[bArr3[3] + 5] = Ascii.DC4;
        int i7 = bArr3[3] + 5;
        bArr3[i7] = (byte) (bArr3[i7] + b4);
        System.arraycopy(bArr, 20, bArr3, bArr3[3] + 6 + b4, 20);
        return this.f1694a.verify(bArr3);
    }
}

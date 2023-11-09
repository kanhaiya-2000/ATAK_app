package atakplugin.UASTool;

import atakplugin.UASTool.alo;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.AbstractList;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class acu extends AbstractList<C1024xh> {

    /* renamed from: a */
    List<alo> f357a;

    /* renamed from: b */
    afu<Integer, SecretKey> f358b;

    /* renamed from: c */
    List<C1024xh> f359c;

    /* renamed from: d */
    String f360d;

    public acu(SecretKey secretKey, List<C1024xh> list, List<alo> list2) {
        this(new afu(0, secretKey), list, list2, "cenc");
    }

    public acu(afu<Integer, SecretKey> afu, List<C1024xh> list, List<alo> list2, String str) {
        this.f358b = new afu<>();
        this.f357a = list2;
        this.f358b = afu;
        this.f359c = list;
        this.f360d = str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Cipher mo238a(SecretKey secretKey, byte[] bArr) {
        byte[] bArr2 = new byte[16];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        try {
            if ("cenc".equals(this.f360d)) {
                Cipher instance = Cipher.getInstance("AES/CTR/NoPadding");
                instance.init(2, secretKey, new IvParameterSpec(bArr2));
                return instance;
            } else if ("cbc1".equals(this.f360d)) {
                Cipher instance2 = Cipher.getInstance("AES/CBC/NoPadding");
                instance2.init(2, secretKey, new IvParameterSpec(bArr2));
                return instance2;
            } else {
                throw new RuntimeException("Only cenc & cbc1 is supported as encryptionAlgo");
            }
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (NoSuchPaddingException e2) {
            throw new RuntimeException(e2);
        } catch (InvalidAlgorithmParameterException e3) {
            throw new RuntimeException(e3);
        } catch (InvalidKeyException e4) {
            throw new RuntimeException(e4);
        }
    }

    /* renamed from: a */
    public C1024xh get(int i) {
        if (this.f358b.get(Integer.valueOf(i)) == null) {
            return this.f359c.get(i);
        }
        C1024xh xhVar = this.f359c.get(i);
        ByteBuffer b = xhVar.mo9b();
        b.rewind();
        ByteBuffer allocate = ByteBuffer.allocate(b.limit());
        alo alo = this.f357a.get(i);
        Cipher a = mo238a(this.f358b.get(Integer.valueOf(i)), alo.f1972a);
        try {
            if (alo.f1973b == null || alo.f1973b.length <= 0) {
                int limit = b.limit();
                byte[] bArr = new byte[limit];
                b.get(bArr);
                if ("cbc1".equals(this.f360d)) {
                    int i2 = (limit / 16) * 16;
                    allocate.put(a.doFinal(bArr, 0, i2));
                    allocate.put(bArr, i2, limit - i2);
                } else if ("cenc".equals(this.f360d)) {
                    allocate.put(a.doFinal(bArr));
                }
            } else {
                for (alo.C0065j jVar : alo.f1973b) {
                    int a2 = jVar.mo1408a();
                    int a3 = afi.m847a(jVar.mo1409b());
                    byte[] bArr2 = new byte[a2];
                    b.get(bArr2);
                    allocate.put(bArr2);
                    if (a3 > 0) {
                        byte[] bArr3 = new byte[a3];
                        b.get(bArr3);
                        allocate.put(a.update(bArr3));
                    }
                }
                if (b.remaining() > 0) {
                    System.err.println("Decrypted sample but still data remaining: " + xhVar.mo7a());
                }
                allocate.put(a.doFinal());
            }
            b.rewind();
            allocate.rewind();
            return new C1025xi(allocate);
        } catch (IllegalBlockSizeException e) {
            throw new RuntimeException(e);
        } catch (BadPaddingException e2) {
            throw new RuntimeException(e2);
        }
    }

    public int size() {
        return this.f359c.size();
    }
}

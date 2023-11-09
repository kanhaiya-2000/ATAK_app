package atakplugin.UASTool;

import atakplugin.UASTool.alo;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
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
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;

public class acv extends AbstractList<C1024xh> {

    /* renamed from: a */
    Cipher f361a;

    /* renamed from: b */
    List<alo> f362b;

    /* renamed from: c */
    afu<Integer, SecretKey> f363c;

    /* renamed from: d */
    List<C1024xh> f364d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final String f365e;

    public acv(SecretKey secretKey, List<C1024xh> list, List<alo> list2) {
        this(new afu(0, secretKey), list, list2, "cenc");
    }

    public acv(afu<Integer, SecretKey> afu, List<C1024xh> list, List<alo> list2, String str) {
        this.f363c = new afu<>();
        this.f362b = list2;
        this.f363c = afu;
        this.f365e = str;
        this.f364d = list;
        try {
            if ("cenc".equals(str)) {
                this.f361a = Cipher.getInstance("AES/CTR/NoPadding");
            } else if ("cbc1".equals(str)) {
                this.f361a = Cipher.getInstance("AES/CBC/NoPadding");
            } else {
                throw new RuntimeException("Only cenc & cbc1 is supported as encryptionAlgo");
            }
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (NoSuchPaddingException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* renamed from: a */
    public C1024xh get(int i) {
        C1024xh xhVar = this.f364d.get(i);
        if (this.f363c.get(Integer.valueOf(i)) == null) {
            return xhVar;
        }
        return new C0006a(this, xhVar, this.f362b.get(i), this.f361a, this.f363c.get(Integer.valueOf(i)), (C0006a) null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo242a(byte[] bArr, SecretKey secretKey) {
        try {
            byte[] bArr2 = new byte[16];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            this.f361a.init(1, secretKey, new IvParameterSpec(bArr2));
        } catch (InvalidAlgorithmParameterException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e2) {
            throw new RuntimeException(e2);
        }
    }

    public int size() {
        return this.f364d.size();
    }

    /* renamed from: atakplugin.UASTool.acv$a */
    private class C0006a implements C1024xh {

        /* renamed from: b */
        static final /* synthetic */ boolean f366b = true;

        /* renamed from: c */
        private final C1024xh f368c;

        /* renamed from: d */
        private final alo f369d;

        /* renamed from: e */
        private final Cipher f370e;

        /* renamed from: f */
        private final SecretKey f371f;

        static {
            Class<acv> cls = acv.class;
        }

        /* synthetic */ C0006a(acv acv, C1024xh xhVar, alo alo, Cipher cipher, SecretKey secretKey, C0006a aVar) {
            this(xhVar, alo, cipher, secretKey);
        }

        private C0006a(C1024xh xhVar, alo alo, Cipher cipher, SecretKey secretKey) {
            this.f368c = xhVar;
            this.f369d = alo;
            this.f370e = cipher;
            this.f371f = secretKey;
        }

        /* renamed from: a */
        public void mo8a(WritableByteChannel writableByteChannel) {
            ByteBuffer byteBuffer = (ByteBuffer) this.f368c.mo9b().rewind();
            acv.this.mo242a(this.f369d.f1972a, this.f371f);
            try {
                if (this.f369d.f1973b == null || this.f369d.f1973b.length <= 0) {
                    int limit = byteBuffer.limit();
                    byte[] bArr = new byte[limit];
                    byteBuffer.get(bArr);
                    if ("cbc1".equals(acv.this.f365e)) {
                        int i = (limit / 16) * 16;
                        writableByteChannel.write(ByteBuffer.wrap(this.f370e.doFinal(bArr, 0, i)));
                        writableByteChannel.write(ByteBuffer.wrap(bArr, i, limit - i));
                    } else if ("cenc".equals(acv.this.f365e)) {
                        writableByteChannel.write(ByteBuffer.wrap(this.f370e.doFinal(bArr)));
                    }
                } else {
                    byte[] bArr2 = new byte[byteBuffer.limit()];
                    byteBuffer.get(bArr2);
                    int i2 = 0;
                    for (alo.C0065j jVar : this.f369d.f1973b) {
                        int a = i2 + jVar.mo1408a();
                        if (jVar.mo1409b() > 0) {
                            this.f370e.update(bArr2, a, afi.m847a(jVar.mo1409b()), bArr2, a);
                            i2 = (int) (((long) a) + jVar.mo1409b());
                        } else {
                            i2 = a;
                        }
                    }
                    writableByteChannel.write(ByteBuffer.wrap(bArr2));
                }
                byteBuffer.rewind();
            } catch (IllegalBlockSizeException e) {
                throw new RuntimeException(e);
            } catch (BadPaddingException e2) {
                throw new RuntimeException(e2);
            } catch (ShortBufferException e3) {
                throw new RuntimeException(e3);
            }
        }

        /* renamed from: a */
        public long mo7a() {
            return this.f368c.mo7a();
        }

        /* renamed from: b */
        public ByteBuffer mo9b() {
            ByteBuffer byteBuffer = (ByteBuffer) this.f368c.mo9b().rewind();
            ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.limit());
            alo alo = this.f369d;
            acv.this.mo242a(alo.f1972a, this.f371f);
            try {
                if (alo.f1973b != null) {
                    for (alo.C0065j jVar : alo.f1973b) {
                        byte[] bArr = new byte[jVar.mo1408a()];
                        byteBuffer.get(bArr);
                        allocate.put(bArr);
                        if (jVar.mo1409b() > 0) {
                            int a = afi.m847a(jVar.mo1409b());
                            byte[] bArr2 = new byte[a];
                            byteBuffer.get(bArr2);
                            boolean z = f366b;
                            if (!z) {
                                if (a % 16 != 0) {
                                    throw new AssertionError();
                                }
                            }
                            byte[] update = this.f370e.update(bArr2);
                            if (!z) {
                                if (update.length != a) {
                                    throw new AssertionError();
                                }
                            }
                            allocate.put(update);
                        }
                    }
                } else {
                    int limit = byteBuffer.limit();
                    byte[] bArr3 = new byte[limit];
                    byteBuffer.get(bArr3);
                    if ("cbc1".equals(acv.this.f365e)) {
                        int i = (limit / 16) * 16;
                        allocate.put(this.f370e.doFinal(bArr3, 0, i));
                        allocate.put(bArr3, i, limit - i);
                    } else if ("cenc".equals(acv.this.f365e)) {
                        allocate.put(this.f370e.doFinal(bArr3));
                    }
                }
                byteBuffer.rewind();
                allocate.rewind();
                return allocate;
            } catch (IllegalBlockSizeException e) {
                throw new RuntimeException(e);
            } catch (BadPaddingException e2) {
                throw new RuntimeException(e2);
            }
        }
    }
}

package atakplugin.UASTool;

import indago.serialization.JsonKeyConstants;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

@aot(mo1534a = 1, mo1535b = {1, 1, 11}, mo1536c = {1, 0, 2}, mo1537d = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0017\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u001f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\r\u0010\n\u001a\u00020\bH\u0007¢\u0006\u0002\b\u0010J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0012H\u0016R\u0011\u0010\n\u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, mo1538e = {"Lokio/HashingSource;", "Lokio/ForwardingSource;", "source", "Lokio/Source;", "algorithm", "", "(Lokio/Source;Ljava/lang/String;)V", "key", "Lokio/ByteString;", "(Lokio/Source;Lokio/ByteString;Ljava/lang/String;)V", "hash", "()Lokio/ByteString;", "mac", "Ljavax/crypto/Mac;", "messageDigest", "Ljava/security/MessageDigest;", "-deprecated_hash", "read", "", "sink", "Lokio/Buffer;", "byteCount", "Companion", "jvm"})
public final class bwy extends bwt {

    /* renamed from: a */
    public static final C0279a f4157a = new C0279a((bfd) null);

    /* renamed from: b */
    private final MessageDigest f4158b;

    /* renamed from: c */
    private final Mac f4159c;

    @bcz
    /* renamed from: a */
    public static final bwy m10307a(bxr bxr) {
        return f4157a.mo4006a(bxr);
    }

    @bcz
    /* renamed from: a */
    public static final bwy m10308a(bxr bxr, bwq bwq) {
        return f4157a.mo4007a(bxr, bwq);
    }

    @bcz
    /* renamed from: b */
    public static final bwy m10309b(bxr bxr) {
        return f4157a.mo4008b(bxr);
    }

    @bcz
    /* renamed from: b */
    public static final bwy m10310b(bxr bxr, bwq bwq) {
        return f4157a.mo4009b(bxr, bwq);
    }

    @bcz
    /* renamed from: c */
    public static final bwy m10311c(bxr bxr) {
        return f4157a.mo4010c(bxr);
    }

    @bcz
    /* renamed from: c */
    public static final bwy m10312c(bxr bxr, bwq bwq) {
        return f4157a.mo4011c(bxr, bwq);
    }

    @bcz
    /* renamed from: d */
    public static final bwy m10313d(bxr bxr) {
        return f4157a.mo4012d(bxr);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public bwy(bxr bxr, String str) {
        super(bxr);
        bfq.m6567f(bxr, JsonKeyConstants.SOURCE);
        bfq.m6567f(str, "algorithm");
        this.f4158b = MessageDigest.getInstance(str);
        this.f4159c = null;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public bwy(bxr bxr, bwq bwq, String str) {
        super(bxr);
        bfq.m6567f(bxr, JsonKeyConstants.SOURCE);
        bfq.m6567f(bwq, "key");
        bfq.m6567f(str, "algorithm");
        try {
            Mac instance = Mac.getInstance(str);
            instance.init(new SecretKeySpec(bwq.mo3953p(), str));
            this.f4159c = instance;
            this.f4158b = null;
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /* renamed from: a */
    public long mo3425a(bwl bwl, long j) {
        bfq.m6567f(bwl, "sink");
        long a = super.mo3425a(bwl, j);
        if (a != -1) {
            long a2 = bwl.mo3783a() - a;
            long a3 = bwl.mo3783a();
            bxm bxm = bwl.f4122a;
            if (bxm == null) {
                bfq.m6538a();
            }
            while (a3 > a2) {
                bxm = bxm.f4205g;
                if (bxm == null) {
                    bfq.m6538a();
                }
                a3 -= (long) (bxm.f4201c - bxm.f4200b);
            }
            while (a3 < bwl.mo3783a()) {
                int i = (int) ((((long) bxm.f4200b) + a2) - a3);
                MessageDigest messageDigest = this.f4158b;
                if (messageDigest != null) {
                    messageDigest.update(bxm.f4199a, i, bxm.f4201c - i);
                } else {
                    Mac mac = this.f4159c;
                    if (mac == null) {
                        bfq.m6538a();
                    }
                    mac.update(bxm.f4199a, i, bxm.f4201c - i);
                }
                a3 += (long) (bxm.f4201c - bxm.f4200b);
                bxm = bxm.f4204f;
                if (bxm == null) {
                    bfq.m6538a();
                }
                a2 = a3;
            }
        }
        return a;
    }

    /* renamed from: c */
    public final bwq mo4004c() {
        byte[] bArr;
        MessageDigest messageDigest = this.f4158b;
        if (messageDigest != null) {
            bArr = messageDigest.digest();
        } else {
            Mac mac = this.f4159c;
            if (mac == null) {
                bfq.m6538a();
            }
            bArr = mac.doFinal();
        }
        bfq.m6554b(bArr, "result");
        return new bwq(bArr);
    }

    @anx(mo1516a = "moved to val", mo1517b = @C0081api(mo1552a = "hash", mo1553b = {}), mo1518c = any.ERROR)
    /* renamed from: d */
    public final bwq mo4005d() {
        return mo4004c();
    }

    @aot(mo1534a = 1, mo1535b = {1, 1, 11}, mo1536c = {1, 0, 2}, mo1537d = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u000f"}, mo1538e = {"Lokio/HashingSource$Companion;", "", "()V", "hmacSha1", "Lokio/HashingSource;", "source", "Lokio/Source;", "key", "Lokio/ByteString;", "hmacSha256", "hmacSha512", "md5", "sha1", "sha256", "sha512", "jvm"})
    /* renamed from: atakplugin.UASTool.bwy$a */
    public static final class C0279a {
        private C0279a() {
        }

        public /* synthetic */ C0279a(bfd bfd) {
            this();
        }

        @bcz
        /* renamed from: a */
        public final bwy mo4006a(bxr bxr) {
            bfq.m6567f(bxr, JsonKeyConstants.SOURCE);
            return new bwy(bxr, "MD5");
        }

        @bcz
        /* renamed from: b */
        public final bwy mo4008b(bxr bxr) {
            bfq.m6567f(bxr, JsonKeyConstants.SOURCE);
            return new bwy(bxr, "SHA-1");
        }

        @bcz
        /* renamed from: c */
        public final bwy mo4010c(bxr bxr) {
            bfq.m6567f(bxr, JsonKeyConstants.SOURCE);
            return new bwy(bxr, "SHA-256");
        }

        @bcz
        /* renamed from: d */
        public final bwy mo4012d(bxr bxr) {
            bfq.m6567f(bxr, JsonKeyConstants.SOURCE);
            return new bwy(bxr, "SHA-512");
        }

        @bcz
        /* renamed from: a */
        public final bwy mo4007a(bxr bxr, bwq bwq) {
            bfq.m6567f(bxr, JsonKeyConstants.SOURCE);
            bfq.m6567f(bwq, "key");
            return new bwy(bxr, bwq, "HmacSHA1");
        }

        @bcz
        /* renamed from: b */
        public final bwy mo4009b(bxr bxr, bwq bwq) {
            bfq.m6567f(bxr, JsonKeyConstants.SOURCE);
            bfq.m6567f(bwq, "key");
            return new bwy(bxr, bwq, "HmacSHA256");
        }

        @bcz
        /* renamed from: c */
        public final bwy mo4011c(bxr bxr, bwq bwq) {
            bfq.m6567f(bxr, JsonKeyConstants.SOURCE);
            bfq.m6567f(bwq, "key");
            return new bwy(bxr, bwq, "HmacSHA512");
        }
    }
}

package atakplugin.UASTool;

import indago.serialization.JsonKeyConstants;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

@aot(mo1534a = 1, mo1535b = {1, 1, 11}, mo1536c = {1, 0, 2}, mo1537d = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0017\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u001f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\r\u0010\n\u001a\u00020\bH\u0007¢\u0006\u0002\b\u0010J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\n\u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, mo1538e = {"Lokio/HashingSink;", "Lokio/ForwardingSink;", "sink", "Lokio/Sink;", "algorithm", "", "(Lokio/Sink;Ljava/lang/String;)V", "key", "Lokio/ByteString;", "(Lokio/Sink;Lokio/ByteString;Ljava/lang/String;)V", "hash", "()Lokio/ByteString;", "mac", "Ljavax/crypto/Mac;", "messageDigest", "Ljava/security/MessageDigest;", "-deprecated_hash", "write", "", "source", "Lokio/Buffer;", "byteCount", "", "Companion", "jvm"})
public final class bwx extends bws {

    /* renamed from: a */
    public static final C0278a f4154a = new C0278a((bfd) null);

    /* renamed from: b */
    private final MessageDigest f4155b;

    /* renamed from: c */
    private final Mac f4156c;

    @bcz
    /* renamed from: a */
    public static final bwx m10291a(bxp bxp) {
        return f4154a.mo3997a(bxp);
    }

    @bcz
    /* renamed from: a */
    public static final bwx m10292a(bxp bxp, bwq bwq) {
        return f4154a.mo3998a(bxp, bwq);
    }

    @bcz
    /* renamed from: b */
    public static final bwx m10293b(bxp bxp) {
        return f4154a.mo3999b(bxp);
    }

    @bcz
    /* renamed from: b */
    public static final bwx m10294b(bxp bxp, bwq bwq) {
        return f4154a.mo4000b(bxp, bwq);
    }

    @bcz
    /* renamed from: c */
    public static final bwx m10295c(bxp bxp) {
        return f4154a.mo4001c(bxp);
    }

    @bcz
    /* renamed from: c */
    public static final bwx m10296c(bxp bxp, bwq bwq) {
        return f4154a.mo4002c(bxp, bwq);
    }

    @bcz
    /* renamed from: d */
    public static final bwx m10297d(bxp bxp) {
        return f4154a.mo4003d(bxp);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public bwx(bxp bxp, String str) {
        super(bxp);
        bfq.m6567f(bxp, "sink");
        bfq.m6567f(str, "algorithm");
        this.f4155b = MessageDigest.getInstance(str);
        this.f4156c = null;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public bwx(bxp bxp, bwq bwq, String str) {
        super(bxp);
        bfq.m6567f(bxp, "sink");
        bfq.m6567f(bwq, "key");
        bfq.m6567f(str, "algorithm");
        try {
            Mac instance = Mac.getInstance(str);
            instance.init(new SecretKeySpec(bwq.mo3953p(), str));
            this.f4156c = instance;
            this.f4155b = null;
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public void write(bwl bwl, long j) {
        bfq.m6567f(bwl, JsonKeyConstants.SOURCE);
        bwg.m9952a(bwl.mo3783a(), 0, j);
        bxm bxm = bwl.f4122a;
        if (bxm == null) {
            bfq.m6538a();
        }
        long j2 = 0;
        while (j2 < j) {
            int min = (int) Math.min(j - j2, (long) (bxm.f4201c - bxm.f4200b));
            MessageDigest messageDigest = this.f4155b;
            if (messageDigest != null) {
                messageDigest.update(bxm.f4199a, bxm.f4200b, min);
            } else {
                Mac mac = this.f4156c;
                if (mac == null) {
                    bfq.m6538a();
                }
                mac.update(bxm.f4199a, bxm.f4200b, min);
            }
            j2 += (long) min;
            bxm = bxm.f4204f;
            if (bxm == null) {
                bfq.m6538a();
            }
        }
        super.write(bwl, j);
    }

    /* renamed from: a */
    public final bwq mo3995a() {
        byte[] bArr;
        MessageDigest messageDigest = this.f4155b;
        if (messageDigest != null) {
            bArr = messageDigest.digest();
        } else {
            Mac mac = this.f4156c;
            if (mac == null) {
                bfq.m6538a();
            }
            bArr = mac.doFinal();
        }
        bfq.m6554b(bArr, "result");
        return new bwq(bArr);
    }

    @anx(mo1516a = "moved to val", mo1517b = @C0081api(mo1552a = "hash", mo1553b = {}), mo1518c = any.ERROR)
    /* renamed from: b */
    public final bwq mo3996b() {
        return mo3995a();
    }

    @aot(mo1534a = 1, mo1535b = {1, 1, 11}, mo1536c = {1, 0, 2}, mo1537d = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u000f"}, mo1538e = {"Lokio/HashingSink$Companion;", "", "()V", "hmacSha1", "Lokio/HashingSink;", "sink", "Lokio/Sink;", "key", "Lokio/ByteString;", "hmacSha256", "hmacSha512", "md5", "sha1", "sha256", "sha512", "jvm"})
    /* renamed from: atakplugin.UASTool.bwx$a */
    public static final class C0278a {
        private C0278a() {
        }

        public /* synthetic */ C0278a(bfd bfd) {
            this();
        }

        @bcz
        /* renamed from: a */
        public final bwx mo3997a(bxp bxp) {
            bfq.m6567f(bxp, "sink");
            return new bwx(bxp, "MD5");
        }

        @bcz
        /* renamed from: b */
        public final bwx mo3999b(bxp bxp) {
            bfq.m6567f(bxp, "sink");
            return new bwx(bxp, "SHA-1");
        }

        @bcz
        /* renamed from: c */
        public final bwx mo4001c(bxp bxp) {
            bfq.m6567f(bxp, "sink");
            return new bwx(bxp, "SHA-256");
        }

        @bcz
        /* renamed from: d */
        public final bwx mo4003d(bxp bxp) {
            bfq.m6567f(bxp, "sink");
            return new bwx(bxp, "SHA-512");
        }

        @bcz
        /* renamed from: a */
        public final bwx mo3998a(bxp bxp, bwq bwq) {
            bfq.m6567f(bxp, "sink");
            bfq.m6567f(bwq, "key");
            return new bwx(bxp, bwq, "HmacSHA1");
        }

        @bcz
        /* renamed from: b */
        public final bwx mo4000b(bxp bxp, bwq bwq) {
            bfq.m6567f(bxp, "sink");
            bfq.m6567f(bwq, "key");
            return new bwx(bxp, bwq, "HmacSHA256");
        }

        @bcz
        /* renamed from: c */
        public final bwx mo4002c(bxp bxp, bwq bwq) {
            bfq.m6567f(bxp, "sink");
            bfq.m6567f(bwq, "key");
            return new bwx(bxp, bwq, "HmacSHA512");
        }
    }
}

package atakplugin.UASTool;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class bqy {

    /* renamed from: A */
    public static final bqy f3235A = m8669a("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40, 2712, 6, Integer.MAX_VALUE);

    /* renamed from: B */
    public static final bqy f3236B = m8669a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41, 2712, 6, Integer.MAX_VALUE);

    /* renamed from: C */
    public static final bqy f3237C = m8669a("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43, 2712, 6, Integer.MAX_VALUE);

    /* renamed from: D */
    public static final bqy f3238D = m8669a("TLS_RSA_WITH_AES_128_CBC_SHA", 47, 5246, 6, 10);

    /* renamed from: E */
    public static final bqy f3239E = m8669a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50, 5246, 6, 10);

    /* renamed from: F */
    public static final bqy f3240F = m8669a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51, 5246, 6, 10);

    /* renamed from: G */
    public static final bqy f3241G = m8669a("TLS_DH_anon_WITH_AES_128_CBC_SHA", 52, 5246, 6, 10);

    /* renamed from: H */
    public static final bqy f3242H = m8669a("TLS_RSA_WITH_AES_256_CBC_SHA", 53, 5246, 6, 10);

    /* renamed from: I */
    public static final bqy f3243I = m8669a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56, 5246, 6, 10);

    /* renamed from: J */
    public static final bqy f3244J = m8669a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57, 5246, 6, 10);

    /* renamed from: K */
    public static final bqy f3245K = m8669a("TLS_DH_anon_WITH_AES_256_CBC_SHA", 58, 5246, 6, 10);

    /* renamed from: L */
    public static final bqy f3246L = m8669a("TLS_RSA_WITH_NULL_SHA256", 59, 5246, 7, 21);

    /* renamed from: M */
    public static final bqy f3247M = m8669a("TLS_RSA_WITH_AES_128_CBC_SHA256", 60, 5246, 7, 21);

    /* renamed from: N */
    public static final bqy f3248N = m8669a("TLS_RSA_WITH_AES_256_CBC_SHA256", 61, 5246, 7, 21);

    /* renamed from: O */
    public static final bqy f3249O = m8669a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64, 5246, 7, 21);

    /* renamed from: P */
    public static final bqy f3250P = m8669a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103, 5246, 7, 21);

    /* renamed from: Q */
    public static final bqy f3251Q = m8669a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106, 5246, 7, 21);

    /* renamed from: R */
    public static final bqy f3252R = m8669a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107, 5246, 7, 21);

    /* renamed from: S */
    public static final bqy f3253S = m8669a("TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108, 5246, 7, 21);

    /* renamed from: T */
    public static final bqy f3254T = m8669a("TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109, 5246, 7, 21);

    /* renamed from: U */
    public static final bqy f3255U = m8669a("TLS_RSA_WITH_AES_128_GCM_SHA256", 156, 5288, 8, 21);

    /* renamed from: V */
    public static final bqy f3256V = m8669a("TLS_RSA_WITH_AES_256_GCM_SHA384", 157, 5288, 8, 21);

    /* renamed from: W */
    public static final bqy f3257W = m8669a("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 158, 5288, 8, 21);

    /* renamed from: X */
    public static final bqy f3258X = m8669a("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", 159, 5288, 8, 21);

    /* renamed from: Y */
    public static final bqy f3259Y = m8669a("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162, 5288, 8, 21);

    /* renamed from: Z */
    public static final bqy f3260Z = m8669a("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 163, 5288, 8, 21);

    /* renamed from: a */
    public static final bqy f3261a = m8669a("SSL_RSA_WITH_NULL_MD5", 1, 5246, 6, 10);

    /* renamed from: aA */
    public static final bqy f3262aA = m8669a("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176, 4492, 7, 14);

    /* renamed from: aB */
    public static final bqy f3263aB = m8669a("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177, 4492, 7, 14);

    /* renamed from: aC */
    public static final bqy f3264aC = m8669a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187, 5289, 7, 21);

    /* renamed from: aD */
    public static final bqy f3265aD = m8669a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188, 5289, 7, 21);

    /* renamed from: aE */
    public static final bqy f3266aE = m8669a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189, 5289, 7, 21);

    /* renamed from: aF */
    public static final bqy f3267aF = m8669a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190, 5289, 7, 21);

    /* renamed from: aG */
    public static final bqy f3268aG = m8669a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191, 5289, 7, 21);

    /* renamed from: aH */
    public static final bqy f3269aH = m8669a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192, 5289, 7, 21);

    /* renamed from: aI */
    public static final bqy f3270aI = m8669a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193, 5289, 7, 21);

    /* renamed from: aJ */
    public static final bqy f3271aJ = m8669a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194, 5289, 7, 21);

    /* renamed from: aK */
    public static final bqy f3272aK = m8669a("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195, 5289, 8, 21);

    /* renamed from: aL */
    public static final bqy f3273aL = m8669a("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196, 5289, 8, 21);

    /* renamed from: aM */
    public static final bqy f3274aM = m8669a("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197, 5289, 8, 21);

    /* renamed from: aN */
    public static final bqy f3275aN = m8669a("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198, 5289, 8, 21);

    /* renamed from: aO */
    public static final bqy f3276aO = m8669a("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199, 5289, 8, 21);

    /* renamed from: aP */
    public static final bqy f3277aP = m8669a("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200, 5289, 8, 21);

    /* renamed from: aQ */
    public static final bqy f3278aQ = m8669a("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201, 5289, 8, 21);

    /* renamed from: aR */
    public static final bqy f3279aR = m8669a("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202, 5289, 8, 21);

    /* renamed from: aT */
    private static final ConcurrentMap<String, bqy> f3280aT = new ConcurrentHashMap();

    /* renamed from: aa */
    public static final bqy f3281aa = m8669a("TLS_DH_anon_WITH_AES_128_GCM_SHA256", 166, 5288, 8, 21);

    /* renamed from: ab */
    public static final bqy f3282ab = m8669a("TLS_DH_anon_WITH_AES_256_GCM_SHA384", 167, 5288, 8, 21);

    /* renamed from: ac */
    public static final bqy f3283ac = m8669a("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255, 5746, 6, 14);

    /* renamed from: ad */
    public static final bqy f3284ad = m8669a("TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153, 4492, 7, 14);

    /* renamed from: ae */
    public static final bqy f3285ae = m8669a("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154, 4492, 7, 14);

    /* renamed from: af */
    public static final bqy f3286af = m8669a("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155, 4492, 7, 14);

    /* renamed from: ag */
    public static final bqy f3287ag = m8669a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156, 4492, 7, 14);

    /* renamed from: ah */
    public static final bqy f3288ah = m8669a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157, 4492, 7, 14);

    /* renamed from: ai */
    public static final bqy f3289ai = m8669a("TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158, 4492, 7, 14);

    /* renamed from: aj */
    public static final bqy f3290aj = m8669a("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159, 4492, 7, 14);

    /* renamed from: ak */
    public static final bqy f3291ak = m8669a("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160, 4492, 7, 14);

    /* renamed from: al */
    public static final bqy f3292al = m8669a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161, 4492, 7, 14);

    /* renamed from: am */
    public static final bqy f3293am = m8669a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162, 4492, 7, 14);

    /* renamed from: an */
    public static final bqy f3294an = m8669a("TLS_ECDH_RSA_WITH_NULL_SHA", 49163, 4492, 7, 14);

    /* renamed from: ao */
    public static final bqy f3295ao = m8669a("TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164, 4492, 7, 14);

    /* renamed from: ap */
    public static final bqy f3296ap = m8669a("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165, 4492, 7, 14);

    /* renamed from: aq */
    public static final bqy f3297aq = m8669a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166, 4492, 7, 14);

    /* renamed from: ar */
    public static final bqy f3298ar = m8669a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167, 4492, 7, 14);

    /* renamed from: as */
    public static final bqy f3299as = m8669a("TLS_ECDHE_RSA_WITH_NULL_SHA", 49168, 4492, 7, 14);

    /* renamed from: at */
    public static final bqy f3300at = m8669a("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169, 4492, 7, 14);

    /* renamed from: au */
    public static final bqy f3301au = m8669a("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170, 4492, 7, 14);

    /* renamed from: av */
    public static final bqy f3302av = m8669a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171, 4492, 7, 14);

    /* renamed from: aw */
    public static final bqy f3303aw = m8669a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172, 4492, 7, 14);

    /* renamed from: ax */
    public static final bqy f3304ax = m8669a("TLS_ECDH_anon_WITH_NULL_SHA", 49173, 4492, 7, 14);

    /* renamed from: ay */
    public static final bqy f3305ay = m8669a("TLS_ECDH_anon_WITH_RC4_128_SHA", 49174, 4492, 7, 14);

    /* renamed from: az */
    public static final bqy f3306az = m8669a("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175, 4492, 7, 14);

    /* renamed from: b */
    public static final bqy f3307b = m8669a("SSL_RSA_WITH_NULL_SHA", 2, 5246, 6, 10);

    /* renamed from: c */
    public static final bqy f3308c = m8669a("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3, 4346, 6, 10);

    /* renamed from: d */
    public static final bqy f3309d = m8669a("SSL_RSA_WITH_RC4_128_MD5", 4, 5246, 6, 10);

    /* renamed from: e */
    public static final bqy f3310e = m8669a("SSL_RSA_WITH_RC4_128_SHA", 5, 5246, 6, 10);

    /* renamed from: f */
    public static final bqy f3311f = m8669a("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8, 4346, 6, 10);

    /* renamed from: g */
    public static final bqy f3312g = m8669a("SSL_RSA_WITH_DES_CBC_SHA", 9, 5469, 6, 10);

    /* renamed from: h */
    public static final bqy f3313h = m8669a("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10, 5246, 6, 10);

    /* renamed from: i */
    public static final bqy f3314i = m8669a("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17, 4346, 6, 10);

    /* renamed from: j */
    public static final bqy f3315j = m8669a("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18, 5469, 6, 10);

    /* renamed from: k */
    public static final bqy f3316k = m8669a("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19, 5246, 6, 10);

    /* renamed from: l */
    public static final bqy f3317l = m8669a("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20, 4346, 6, 10);

    /* renamed from: m */
    public static final bqy f3318m = m8669a("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21, 5469, 6, 10);

    /* renamed from: n */
    public static final bqy f3319n = m8669a("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22, 5246, 6, 10);

    /* renamed from: o */
    public static final bqy f3320o = m8669a("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23, 4346, 6, 10);

    /* renamed from: p */
    public static final bqy f3321p = m8669a("SSL_DH_anon_WITH_RC4_128_MD5", 24, 5246, 6, 10);

    /* renamed from: q */
    public static final bqy f3322q = m8669a("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25, 4346, 6, 10);

    /* renamed from: r */
    public static final bqy f3323r = m8669a("SSL_DH_anon_WITH_DES_CBC_SHA", 26, 5469, 6, 10);

    /* renamed from: s */
    public static final bqy f3324s = m8669a("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27, 5246, 6, 10);

    /* renamed from: t */
    public static final bqy f3325t = m8669a("TLS_KRB5_WITH_DES_CBC_SHA", 30, 2712, 6, Integer.MAX_VALUE);

    /* renamed from: u */
    public static final bqy f3326u = m8669a("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31, 2712, 6, Integer.MAX_VALUE);

    /* renamed from: v */
    public static final bqy f3327v = m8669a("TLS_KRB5_WITH_RC4_128_SHA", 32, 2712, 6, Integer.MAX_VALUE);

    /* renamed from: w */
    public static final bqy f3328w = m8669a("TLS_KRB5_WITH_DES_CBC_MD5", 34, 2712, 6, Integer.MAX_VALUE);

    /* renamed from: x */
    public static final bqy f3329x = m8669a("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35, 2712, 6, Integer.MAX_VALUE);

    /* renamed from: y */
    public static final bqy f3330y = m8669a("TLS_KRB5_WITH_RC4_128_MD5", 36, 2712, 6, Integer.MAX_VALUE);

    /* renamed from: z */
    public static final bqy f3331z = m8669a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38, 2712, 6, Integer.MAX_VALUE);

    /* renamed from: aS */
    final String f3332aS;

    /* renamed from: a */
    public static bqy m8668a(String str) {
        ConcurrentMap<String, bqy> concurrentMap = f3280aT;
        bqy bqy = (bqy) concurrentMap.get(str);
        if (bqy != null) {
            return bqy;
        }
        bqy bqy2 = new bqy(str);
        bqy putIfAbsent = concurrentMap.putIfAbsent(str, bqy2);
        return putIfAbsent == null ? bqy2 : putIfAbsent;
    }

    private bqy(String str) {
        Objects.requireNonNull(str);
        this.f3332aS = str;
    }

    /* renamed from: a */
    private static bqy m8669a(String str, int i, int i2, int i3, int i4) {
        return m8668a(str);
    }

    /* renamed from: a */
    public String mo3078a() {
        return this.f3332aS;
    }

    public String toString() {
        return this.f3332aS;
    }
}

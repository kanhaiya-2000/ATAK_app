package atakplugin.UASTool;

import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class byt {

    /* renamed from: a */
    private static final int f4306a = 1024;

    /* renamed from: a */
    private static byte[] m10635a(MessageDigest messageDigest, InputStream inputStream) {
        byte[] bArr = new byte[1024];
        int read = inputStream.read(bArr, 0, 1024);
        while (read > -1) {
            messageDigest.update(bArr, 0, read);
            read = inputStream.read(bArr, 0, 1024);
        }
        return messageDigest.digest();
    }

    /* renamed from: l */
    private static byte[] m10669l(String str) {
        return bys.m10631f(str);
    }

    /* renamed from: a */
    static MessageDigest m10633a(String str) {
        try {
            return MessageDigest.getInstance(str);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /* renamed from: a */
    private static MessageDigest m10632a() {
        return m10633a("MD5");
    }

    /* renamed from: b */
    private static MessageDigest m10639b() {
        return m10633a("SHA-256");
    }

    /* renamed from: c */
    private static MessageDigest m10642c() {
        return m10633a("SHA-384");
    }

    /* renamed from: d */
    private static MessageDigest m10645d() {
        return m10633a("SHA-512");
    }

    /* renamed from: e */
    private static MessageDigest m10651e() {
        return m10633a("SHA");
    }

    /* renamed from: a */
    public static byte[] m10636a(byte[] bArr) {
        return m10632a().digest(bArr);
    }

    /* renamed from: a */
    public static byte[] m10634a(InputStream inputStream) {
        return m10635a(m10632a(), inputStream);
    }

    /* renamed from: b */
    public static byte[] m10640b(String str) {
        return m10636a(m10669l(str));
    }

    /* renamed from: b */
    public static String m10638b(byte[] bArr) {
        return byr.m10611d(m10636a(bArr));
    }

    /* renamed from: b */
    public static String m10637b(InputStream inputStream) {
        return byr.m10611d(m10634a(inputStream));
    }

    /* renamed from: c */
    public static String m10641c(String str) {
        return byr.m10611d(m10640b(str));
    }

    /* renamed from: c */
    public static byte[] m10644c(byte[] bArr) {
        return m10651e().digest(bArr);
    }

    /* renamed from: c */
    public static byte[] m10643c(InputStream inputStream) {
        return m10635a(m10651e(), inputStream);
    }

    /* renamed from: d */
    public static byte[] m10647d(String str) {
        return m10644c(m10669l(str));
    }

    /* renamed from: d */
    public static byte[] m10648d(byte[] bArr) {
        return m10639b().digest(bArr);
    }

    /* renamed from: d */
    public static byte[] m10646d(InputStream inputStream) {
        return m10635a(m10639b(), inputStream);
    }

    /* renamed from: e */
    public static byte[] m10652e(String str) {
        return m10648d(m10669l(str));
    }

    /* renamed from: e */
    public static String m10650e(byte[] bArr) {
        return byr.m10611d(m10648d(bArr));
    }

    /* renamed from: e */
    public static String m10649e(InputStream inputStream) {
        return byr.m10611d(m10646d(inputStream));
    }

    /* renamed from: f */
    public static String m10653f(String str) {
        return byr.m10611d(m10652e(str));
    }

    /* renamed from: f */
    public static byte[] m10655f(byte[] bArr) {
        return m10642c().digest(bArr);
    }

    /* renamed from: f */
    public static byte[] m10654f(InputStream inputStream) {
        return m10635a(m10642c(), inputStream);
    }

    /* renamed from: g */
    public static byte[] m10658g(String str) {
        return m10655f(m10669l(str));
    }

    /* renamed from: g */
    public static String m10657g(byte[] bArr) {
        return byr.m10611d(m10655f(bArr));
    }

    /* renamed from: g */
    public static String m10656g(InputStream inputStream) {
        return byr.m10611d(m10654f(inputStream));
    }

    /* renamed from: h */
    public static String m10659h(String str) {
        return byr.m10611d(m10658g(str));
    }

    /* renamed from: h */
    public static byte[] m10661h(byte[] bArr) {
        return m10645d().digest(bArr);
    }

    /* renamed from: h */
    public static byte[] m10660h(InputStream inputStream) {
        return m10635a(m10645d(), inputStream);
    }

    /* renamed from: i */
    public static byte[] m10664i(String str) {
        return m10661h(m10669l(str));
    }

    /* renamed from: i */
    public static String m10663i(byte[] bArr) {
        return byr.m10611d(m10661h(bArr));
    }

    /* renamed from: i */
    public static String m10662i(InputStream inputStream) {
        return byr.m10611d(m10660h(inputStream));
    }

    /* renamed from: j */
    public static String m10666j(String str) {
        return byr.m10611d(m10664i(str));
    }

    /* renamed from: j */
    public static String m10667j(byte[] bArr) {
        return byr.m10611d(m10644c(bArr));
    }

    /* renamed from: j */
    public static String m10665j(InputStream inputStream) {
        return byr.m10611d(m10643c(inputStream));
    }

    /* renamed from: k */
    public static String m10668k(String str) {
        return byr.m10611d(m10647d(str));
    }
}

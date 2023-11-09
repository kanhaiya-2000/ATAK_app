package atakplugin.UASTool;

import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

public class bvp {

    /* renamed from: a */
    private static final bvp f4065a = m9867a();

    /* renamed from: b */
    private static final Logger f4066b = Logger.getLogger(brw.class.getName());

    /* renamed from: c */
    public static final int f4067c = 4;

    /* renamed from: d */
    public static final int f4068d = 5;

    /* renamed from: a */
    public String mo3719a(SSLSocket sSLSocket) {
        return null;
    }

    /* renamed from: a */
    public void mo3723a(SSLSocket sSLSocket, String str, List<bry> list) {
    }

    /* renamed from: a */
    public boolean mo3724a(String str) {
        return true;
    }

    /* renamed from: b */
    public void mo3726b(SSLSocket sSLSocket) {
    }

    /* renamed from: c */
    public String mo3733c() {
        return "OkHttp";
    }

    /* renamed from: b */
    public static bvp m9870b() {
        return f4065a;
    }

    /* renamed from: a */
    public X509TrustManager mo3720a(SSLSocketFactory sSLSocketFactory) {
        try {
            Object a = m9868a((Object) sSLSocketFactory, Class.forName("sun.security.ssl.SSLContextImpl"), "context");
            if (a == null) {
                return null;
            }
            return (X509TrustManager) m9868a((Object) a, X509TrustManager.class, "trustManager");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    /* renamed from: a */
    public void mo3722a(Socket socket, InetSocketAddress inetSocketAddress, int i) {
        socket.connect(inetSocketAddress, i);
    }

    /* renamed from: a */
    public void mo3721a(int i, String str, Throwable th) {
        f4066b.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    /* renamed from: a */
    public static List<String> m9869a(List<bry> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            bry bry = list.get(i);
            if (bry != bry.HTTP_1_0) {
                arrayList.add(bry.toString());
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public bvr mo3718a(X509TrustManager x509TrustManager) {
        return new bvq(bvu.m9900a(x509TrustManager));
    }

    /* renamed from: a */
    private static bvp m9867a() {
        bvp a = bvl.m9841a();
        if (a != null) {
            return a;
        }
        bvm a2 = bvm.m9850a();
        if (a2 != null) {
            return a2;
        }
        bvp a3 = bvn.m9854a();
        if (a3 != null) {
            return a3;
        }
        return new bvp();
    }

    /* renamed from: b */
    static byte[] m9871b(List<bry> list) {
        bwl bwl = new bwl();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            bry bry = list.get(i);
            if (bry != bry.HTTP_1_0) {
                bwl.mo3833d(bry.toString().length());
                bwl.mo3817b(bry.toString());
            }
        }
        return bwl.mo3768A();
    }

    /* renamed from: a */
    static <T> T m9868a(Object obj, Class<T> cls, String str) {
        Object a;
        Class cls2 = obj.getClass();
        while (cls2 != Object.class) {
            try {
                Field declaredField = cls2.getDeclaredField(str);
                declaredField.setAccessible(true);
                Object obj2 = declaredField.get(obj);
                if (obj2 != null) {
                    if (cls.isInstance(obj2)) {
                        return cls.cast(obj2);
                    }
                }
                return null;
            } catch (NoSuchFieldException unused) {
                cls2 = cls2.getSuperclass();
            } catch (IllegalAccessException unused2) {
                throw new AssertionError();
            }
        }
        if (str.equals("delegate") || (a = m9868a(obj, Object.class, "delegate")) == null) {
            return null;
        }
        return m9868a(a, cls, str);
    }
}

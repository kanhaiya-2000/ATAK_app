package atakplugin.UASTool;

import android.util.Log;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

class bvl extends bvp {

    /* renamed from: a */
    private static final int f4044a = 4000;

    /* renamed from: b */
    private final Class<?> f4045b;

    /* renamed from: e */
    private final bvo<Socket> f4046e;

    /* renamed from: f */
    private final bvo<Socket> f4047f;

    /* renamed from: g */
    private final bvo<Socket> f4048g;

    /* renamed from: h */
    private final bvo<Socket> f4049h;

    public bvl(Class<?> cls, bvo<Socket> bvo, bvo<Socket> bvo2, bvo<Socket> bvo3, bvo<Socket> bvo4) {
        this.f4045b = cls;
        this.f4046e = bvo;
        this.f4047f = bvo2;
        this.f4048g = bvo3;
        this.f4049h = bvo4;
    }

    /* renamed from: a */
    public void mo3722a(Socket socket, InetSocketAddress inetSocketAddress, int i) {
        try {
            socket.connect(inetSocketAddress, i);
        } catch (AssertionError e) {
            if (bsp.m9163a(e)) {
                throw new IOException(e);
            }
            throw e;
        } catch (SecurityException e2) {
            IOException iOException = new IOException("Exception in connect");
            iOException.initCause(e2);
            throw iOException;
        }
    }

    /* renamed from: a */
    public X509TrustManager mo3720a(SSLSocketFactory sSLSocketFactory) {
        Object a = m9868a((Object) sSLSocketFactory, this.f4045b, "sslParameters");
        if (a == null) {
            try {
                a = m9868a((Object) sSLSocketFactory, Class.forName("com.google.android.gms.org.conscrypt.SSLParametersImpl", false, sSLSocketFactory.getClass().getClassLoader()), "sslParameters");
            } catch (ClassNotFoundException unused) {
                return super.mo3720a(sSLSocketFactory);
            }
        }
        X509TrustManager x509TrustManager = (X509TrustManager) m9868a((Object) a, X509TrustManager.class, "x509TrustManager");
        if (x509TrustManager != null) {
            return x509TrustManager;
        }
        return (X509TrustManager) m9868a((Object) a, X509TrustManager.class, "trustManager");
    }

    /* renamed from: a */
    public void mo3723a(SSLSocket sSLSocket, String str, List<bry> list) {
        if (str != null) {
            this.f4046e.mo3730b(sSLSocket, true);
            this.f4047f.mo3730b(sSLSocket, str);
        }
        bvo<Socket> bvo = this.f4049h;
        if (bvo != null && bvo.mo3729a(sSLSocket)) {
            this.f4049h.mo3732d(sSLSocket, m9871b(list));
        }
    }

    /* renamed from: a */
    public String mo3719a(SSLSocket sSLSocket) {
        byte[] bArr;
        bvo<Socket> bvo = this.f4048g;
        if (bvo == null || !bvo.mo3729a(sSLSocket) || (bArr = (byte[]) this.f4048g.mo3732d(sSLSocket, new Object[0])) == null) {
            return null;
        }
        return new String(bArr, bsp.f3584c);
    }

    /* renamed from: a */
    public void mo3721a(int i, String str, Throwable th) {
        int min;
        int i2 = 5;
        if (i != 5) {
            i2 = 3;
        }
        if (th != null) {
            str = str + 10 + Log.getStackTraceString(th);
        }
        int i3 = 0;
        int length = str.length();
        while (i3 < length) {
            int indexOf = str.indexOf(10, i3);
            if (indexOf == -1) {
                indexOf = length;
            }
            while (true) {
                min = Math.min(indexOf, i3 + 4000);
                Log.println(i2, "OkHttp", str.substring(i3, min));
                if (min >= indexOf) {
                    break;
                }
                i3 = min;
            }
            i3 = min + 1;
        }
    }

    /* renamed from: a */
    public boolean mo3724a(String str) {
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            Object invoke = cls.getMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[]{String.class}).invoke(invoke, new Object[]{str})).booleanValue();
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return super.mo3724a(str);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused2) {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    public bvr mo3718a(X509TrustManager x509TrustManager) {
        try {
            Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new C0266a(cls.getConstructor(new Class[]{X509TrustManager.class}).newInstance(new Object[]{x509TrustManager}), cls.getMethod("checkServerTrusted", new Class[]{X509Certificate[].class, String.class, String.class}));
        } catch (Exception unused) {
            return super.mo3718a(x509TrustManager);
        }
    }

    /* renamed from: a */
    public static bvp m9841a() {
        Class<?> cls;
        bvo bvo;
        bvo bvo2;
        Class<byte[]> cls2 = byte[].class;
        try {
            cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
        } catch (ClassNotFoundException unused) {
            try {
                cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            } catch (ClassNotFoundException unused2) {
                return null;
            }
        }
        Class<?> cls3 = cls;
        bvo bvo3 = new bvo((Class<?>) null, "setUseSessionTickets", Boolean.TYPE);
        bvo bvo4 = new bvo((Class<?>) null, "setHostname", String.class);
        try {
            Class.forName("android.net.Network");
            bvo2 = new bvo(cls2, "getAlpnSelectedProtocol", new Class[0]);
            try {
                bvo = new bvo((Class<?>) null, "setAlpnProtocols", cls2);
            } catch (ClassNotFoundException unused3) {
                bvo = null;
                return new bvl(cls3, bvo3, bvo4, bvo2, bvo);
            }
        } catch (ClassNotFoundException unused4) {
            bvo2 = null;
            bvo = null;
            return new bvl(cls3, bvo3, bvo4, bvo2, bvo);
        }
        return new bvl(cls3, bvo3, bvo4, bvo2, bvo);
    }

    /* renamed from: atakplugin.UASTool.bvl$a */
    static final class C0266a extends bvr {

        /* renamed from: a */
        private final Object f4050a;

        /* renamed from: b */
        private final Method f4051b;

        C0266a(Object obj, Method method) {
            this.f4050a = obj;
            this.f4051b = method;
        }

        /* renamed from: a */
        public List<Certificate> mo3725a(List<Certificate> list, String str) {
            try {
                return (List) this.f4051b.invoke(this.f4050a, new Object[]{(X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str});
            } catch (InvocationTargetException e) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e.getMessage());
                sSLPeerUnverifiedException.initCause(e);
                throw sSLPeerUnverifiedException;
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }
    }
}

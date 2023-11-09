package atakplugin.UASTool;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

final class bvm extends bvp {

    /* renamed from: a */
    final Method f4052a;

    /* renamed from: b */
    final Method f4053b;

    public bvm(Method method, Method method2) {
        this.f4052a = method;
        this.f4053b = method2;
    }

    /* renamed from: a */
    public void mo3723a(SSLSocket sSLSocket, String str, List<bry> list) {
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            List<String> a = m9869a(list);
            this.f4052a.invoke(sSLParameters, new Object[]{a.toArray(new String[a.size()])});
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    public String mo3719a(SSLSocket sSLSocket) {
        try {
            String str = (String) this.f4053b.invoke(sSLSocket, new Object[0]);
            if (str == null || str.equals("")) {
                return null;
            }
            return str;
        } catch (IllegalAccessException | InvocationTargetException unused) {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    public X509TrustManager mo3720a(SSLSocketFactory sSLSocketFactory) {
        throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on JDK 9+");
    }

    /* renamed from: a */
    public static bvm m9850a() {
        try {
            return new bvm(SSLParameters.class.getMethod("setApplicationProtocols", new Class[]{String[].class}), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }
}

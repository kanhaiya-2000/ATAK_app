package atakplugin.UASTool;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.net.ssl.SSLSocket;

class bvn extends bvp {

    /* renamed from: a */
    private final Method f4054a;

    /* renamed from: b */
    private final Method f4055b;

    /* renamed from: e */
    private final Method f4056e;

    /* renamed from: f */
    private final Class<?> f4057f;

    /* renamed from: g */
    private final Class<?> f4058g;

    public bvn(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.f4054a = method;
        this.f4055b = method2;
        this.f4056e = method3;
        this.f4057f = cls;
        this.f4058g = cls2;
    }

    /* renamed from: a */
    public void mo3723a(SSLSocket sSLSocket, String str, List<bry> list) {
        List<String> a = m9869a(list);
        try {
            Object newProxyInstance = Proxy.newProxyInstance(bvp.class.getClassLoader(), new Class[]{this.f4057f, this.f4058g}, new C0267a(a));
            this.f4054a.invoke((Object) null, new Object[]{sSLSocket, newProxyInstance});
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: b */
    public void mo3726b(SSLSocket sSLSocket) {
        try {
            this.f4056e.invoke((Object) null, new Object[]{sSLSocket});
        } catch (IllegalAccessException | InvocationTargetException unused) {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    public String mo3719a(SSLSocket sSLSocket) {
        try {
            C0267a aVar = (C0267a) Proxy.getInvocationHandler(this.f4055b.invoke((Object) null, new Object[]{sSLSocket}));
            if (!aVar.f4060b && aVar.f4061c == null) {
                bvp.m9870b().mo3721a(4, "ALPN callback dropped: SPDY and HTTP/2 are disabled. Is alpn-boot on the boot class path?", (Throwable) null);
                return null;
            } else if (aVar.f4060b) {
                return null;
            } else {
                return aVar.f4061c;
            }
        } catch (IllegalAccessException | InvocationTargetException unused) {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    public static bvp m9854a() {
        try {
            Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN");
            Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$Provider");
            Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$ClientProvider");
            Class<?> cls4 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$ServerProvider");
            Method method = cls.getMethod("put", new Class[]{SSLSocket.class, cls2});
            return new bvn(method, cls.getMethod("get", new Class[]{SSLSocket.class}), cls.getMethod("remove", new Class[]{SSLSocket.class}), cls3, cls4);
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        }
    }

    /* renamed from: atakplugin.UASTool.bvn$a */
    private static class C0267a implements InvocationHandler {

        /* renamed from: a */
        private final List<String> f4059a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public boolean f4060b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public String f4061c;

        public C0267a(List<String> list) {
            this.f4059a = list;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = bsp.f3583b;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return true;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f4060b = true;
                return null;
            } else if (name.equals("protocols") && objArr.length == 0) {
                return this.f4059a;
            } else {
                if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1 && (objArr[0] instanceof List)) {
                    List list = (List) objArr[0];
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        if (this.f4059a.contains(list.get(i))) {
                            String str = (String) list.get(i);
                            this.f4061c = str;
                            return str;
                        }
                    }
                    String str2 = this.f4059a.get(0);
                    this.f4061c = str2;
                    return str2;
                } else if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
                    return method.invoke(this, objArr);
                } else {
                    this.f4061c = (String) objArr[0];
                    return null;
                }
            }
        }
    }
}

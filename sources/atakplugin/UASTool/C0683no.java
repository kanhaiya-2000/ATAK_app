package atakplugin.UASTool;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: atakplugin.UASTool.no */
public class C0683no extends C0672nd {

    /* renamed from: g */
    static String[] f5337g = new String[0];

    /* renamed from: b */
    Properties f5338b;

    /* renamed from: c */
    Pattern f5339c = Pattern.compile("(.*)\\((.*?)\\)");

    /* renamed from: d */
    StringBuilder f5340d = new StringBuilder();

    /* renamed from: e */
    ThreadLocal<String> f5341e = new ThreadLocal<>();

    /* renamed from: f */
    ThreadLocal<String[]> f5342f = new ThreadLocal<>();

    public C0683no(String... strArr) {
        InputStream openStream;
        InputStream resourceAsStream = getClass().getResourceAsStream("/isoparser-default.properties");
        try {
            Properties properties = new Properties();
            this.f5338b = properties;
            try {
                properties.load(resourceAsStream);
                ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
                Enumeration<URL> resources = (contextClassLoader == null ? ClassLoader.getSystemClassLoader() : contextClassLoader).getResources("isoparser-custom.properties");
                while (resources.hasMoreElements()) {
                    openStream = resources.nextElement().openStream();
                    this.f5338b.load(openStream);
                    openStream.close();
                }
                for (String resourceAsStream2 : strArr) {
                    this.f5338b.load(getClass().getResourceAsStream(resourceAsStream2));
                }
                try {
                    resourceAsStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            } catch (Throwable th) {
                openStream.close();
                throw th;
            }
        } catch (Throwable th2) {
            try {
                resourceAsStream.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            throw th2;
        }
    }

    public C0683no(Properties properties) {
        this.f5338b = properties;
    }

    /* renamed from: a */
    public C0688nt mo5102a(String str, byte[] bArr, String str2) {
        mo5110b(str, bArr, str2);
        String[] strArr = this.f5342f.get();
        try {
            Class<?> cls = Class.forName(this.f5341e.get());
            if (strArr.length <= 0) {
                return (C0688nt) cls.newInstance();
            }
            Class[] clsArr = new Class[strArr.length];
            Object[] objArr = new Object[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                if ("userType".equals(strArr[i])) {
                    objArr[i] = bArr;
                    clsArr[i] = byte[].class;
                } else if ("type".equals(strArr[i])) {
                    objArr[i] = str;
                    clsArr[i] = String.class;
                } else if ("parent".equals(strArr[i])) {
                    objArr[i] = str2;
                    clsArr[i] = String.class;
                } else {
                    throw new InternalError("No such param: " + strArr[i]);
                }
            }
            return (C0688nt) cls.getConstructor(clsArr).newInstance(objArr);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e2) {
            throw new RuntimeException(e2);
        } catch (IllegalAccessException e3) {
            throw new RuntimeException(e3);
        } catch (InvocationTargetException e4) {
            throw new RuntimeException(e4);
        } catch (NoSuchMethodException e5) {
            throw new RuntimeException(e5);
        }
    }

    /* renamed from: b */
    public void mo5110b(String str, byte[] bArr, String str2) {
        String str3;
        if (bArr == null) {
            str3 = this.f5338b.getProperty(str);
            if (str3 == null) {
                StringBuilder sb = this.f5340d;
                sb.append(str2);
                sb.append('-');
                sb.append(str);
                String sb2 = sb.toString();
                this.f5340d.setLength(0);
                str3 = this.f5338b.getProperty(sb2);
            }
        } else if (C0758pz.f5795b.equals(str)) {
            Properties properties = this.f5338b;
            str3 = properties.getProperty("uuid[" + C0677ni.m12484a(bArr).toUpperCase() + "]");
            if (str3 == null) {
                Properties properties2 = this.f5338b;
                str3 = properties2.getProperty(String.valueOf(str2) + "-uuid[" + C0677ni.m12484a(bArr).toUpperCase() + "]");
            }
            if (str3 == null) {
                str3 = this.f5338b.getProperty(C0758pz.f5795b);
            }
        } else {
            throw new RuntimeException("we have a userType but no uuid box type. Something's wrong");
        }
        if (str3 == null) {
            str3 = this.f5338b.getProperty("default");
        }
        if (str3 == null) {
            throw new RuntimeException("No box object found for " + str);
        } else if (!str3.endsWith(")")) {
            this.f5342f.set(f5337g);
            this.f5341e.set(str3);
        } else {
            Matcher matcher = this.f5339c.matcher(str3);
            if (matcher.matches()) {
                this.f5341e.set(matcher.group(1));
                if (matcher.group(2).length() == 0) {
                    this.f5342f.set(f5337g);
                } else {
                    this.f5342f.set(matcher.group(2).length() > 0 ? matcher.group(2).split(",") : new String[0]);
                }
            } else {
                throw new RuntimeException("Cannot work with that constructor: " + str3);
            }
        }
    }
}

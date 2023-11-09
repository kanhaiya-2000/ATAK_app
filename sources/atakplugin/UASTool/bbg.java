package atakplugin.UASTool;

@aot(mo1534a = 2, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0001\u001a\"\u0010\b\u001a\u0002H\t\"\n\b\u0000\u0010\t\u0018\u0001*\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\b¢\u0006\u0002\u0010\f\u001a\b\u0010\r\u001a\u00020\u0005H\u0002\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo1538e = {"IMPLEMENTATIONS", "Lkotlin/internal/PlatformImplementations;", "apiVersionIsAtLeast", "", "major", "", "minor", "patch", "castToBaseType", "T", "", "instance", "(Ljava/lang/Object;)Ljava/lang/Object;", "getJavaVersion", "kotlin-stdlib"})
public final class bbg {

    /* renamed from: a */
    public static final bbf f2499a;

    static {
        bbf bbf;
        Object newInstance;
        Object newInstance2;
        int a = m6169a();
        if (a >= 65544) {
            try {
                newInstance2 = Class.forName("kotlin.internal.jdk8.JDK8PlatformImplementations").newInstance();
                bfq.m6554b(newInstance2, "Class.forName(\"kotlin.in…entations\").newInstance()");
                if (newInstance2 != null) {
                    bbf = (bbf) newInstance2;
                    f2499a = bbf;
                }
                throw new apx("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
            } catch (ClassCastException e) {
                ClassLoader classLoader = newInstance2.getClass().getClassLoader();
                ClassLoader classLoader2 = bbf.class.getClassLoader();
                Throwable initCause = new ClassCastException("Instance classloader: " + classLoader + ", base type classloader: " + classLoader2).initCause(e);
                bfq.m6554b(initCause, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                throw initCause;
            } catch (ClassNotFoundException unused) {
                try {
                    Object newInstance3 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
                    bfq.m6554b(newInstance3, "Class.forName(\"kotlin.in…entations\").newInstance()");
                    if (newInstance3 != null) {
                        try {
                            bbf = (bbf) newInstance3;
                        } catch (ClassCastException e2) {
                            ClassLoader classLoader3 = newInstance3.getClass().getClassLoader();
                            ClassLoader classLoader4 = bbf.class.getClassLoader();
                            Throwable initCause2 = new ClassCastException("Instance classloader: " + classLoader3 + ", base type classloader: " + classLoader4).initCause(e2);
                            bfq.m6554b(initCause2, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                            throw initCause2;
                        }
                    } else {
                        throw new apx("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                } catch (ClassNotFoundException unused2) {
                }
            }
        }
        if (a >= 65543) {
            try {
                newInstance = Class.forName("kotlin.internal.jdk7.JDK7PlatformImplementations").newInstance();
                bfq.m6554b(newInstance, "Class.forName(\"kotlin.in…entations\").newInstance()");
                if (newInstance != null) {
                    bbf = (bbf) newInstance;
                    f2499a = bbf;
                }
                throw new apx("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
            } catch (ClassCastException e3) {
                ClassLoader classLoader5 = newInstance.getClass().getClassLoader();
                ClassLoader classLoader6 = bbf.class.getClassLoader();
                Throwable initCause3 = new ClassCastException("Instance classloader: " + classLoader5 + ", base type classloader: " + classLoader6).initCause(e3);
                bfq.m6554b(initCause3, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                throw initCause3;
            } catch (ClassNotFoundException unused3) {
                try {
                    Object newInstance4 = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
                    bfq.m6554b(newInstance4, "Class.forName(\"kotlin.in…entations\").newInstance()");
                    if (newInstance4 != null) {
                        try {
                            bbf = (bbf) newInstance4;
                        } catch (ClassCastException e4) {
                            ClassLoader classLoader7 = newInstance4.getClass().getClassLoader();
                            ClassLoader classLoader8 = bbf.class.getClassLoader();
                            Throwable initCause4 = new ClassCastException("Instance classloader: " + classLoader7 + ", base type classloader: " + classLoader8).initCause(e4);
                            bfq.m6554b(initCause4, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                            throw initCause4;
                        }
                    } else {
                        throw new apx("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                } catch (ClassNotFoundException unused4) {
                }
            }
        }
        bbf = new bbf();
        f2499a = bbf;
    }

    /* renamed from: a */
    private static final /* synthetic */ <T> T m6170a(Object obj) {
        try {
            bfq.m6539a(1, "T");
            return obj;
        } catch (ClassCastException e) {
            ClassLoader classLoader = obj.getClass().getClassLoader();
            bfq.m6539a(4, "T");
            ClassLoader classLoader2 = Object.class.getClassLoader();
            Throwable initCause = new ClassCastException("Instance classloader: " + classLoader + ", base type classloader: " + classLoader2).initCause(e);
            bfq.m6554b(initCause, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
            throw initCause;
        }
    }

    /* renamed from: a */
    private static final int m6169a() {
        String property = System.getProperty("java.specification.version");
        if (property == null) {
            return 65542;
        }
        CharSequence charSequence = property;
        int a = boc.m8080a(charSequence, '.', 0, false, 6, (Object) null);
        if (a < 0) {
            try {
                return Integer.parseInt(property) * 65536;
            } catch (NumberFormatException unused) {
                return 65542;
            }
        } else {
            int i = a + 1;
            int a2 = boc.m8080a(charSequence, '.', i, false, 4, (Object) null);
            if (a2 < 0) {
                a2 = property.length();
            }
            if (property != null) {
                String substring = property.substring(0, a);
                bfq.m6554b(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                if (property != null) {
                    String substring2 = property.substring(i, a2);
                    bfq.m6554b(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    try {
                        return (Integer.parseInt(substring) * 65536) + Integer.parseInt(substring2);
                    } catch (NumberFormatException unused2) {
                        return 65542;
                    }
                } else {
                    throw new apx("null cannot be cast to non-null type java.lang.String");
                }
            } else {
                throw new apx("null cannot be cast to non-null type java.lang.String");
            }
        }
    }

    /* renamed from: a */
    public static final boolean m6171a(int i, int i2, int i3) {
        return aol.f2113b.mo1527a(i, i2, i3);
    }
}

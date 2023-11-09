package atakplugin.UASTool;

public final class ccw {
    /* renamed from: a */
    public static Object m11296a() {
        return null;
    }

    /* renamed from: i */
    public static Object m11312i(Object obj) {
        if (obj == null) {
        }
        return obj;
    }

    private ccw() {
    }

    /* renamed from: a */
    public static Object m11301a(int i) {
        return new Integer(i);
    }

    /* renamed from: a */
    public static Object m11303a(short s) {
        return new Short(s);
    }

    /* renamed from: a */
    public static Object m11297a(byte b) {
        return new Byte(b);
    }

    /* renamed from: a */
    public static Object m11298a(char c) {
        return new Character(c);
    }

    /* renamed from: a */
    public static Object m11302a(long j) {
        return new Long(j);
    }

    /* renamed from: a */
    public static Object m11300a(float f) {
        return new Float(f);
    }

    /* renamed from: a */
    public static Object m11299a(double d) {
        return new Double(d);
    }

    /* renamed from: a */
    public static Object m11304a(boolean z) {
        return new Boolean(z);
    }

    /* renamed from: a */
    public static int m11295a(Object obj) {
        if (obj == null) {
            return 0;
        }
        if (obj instanceof Number) {
            return ((Number) obj).intValue();
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(obj.getClass().getName());
        stringBuffer.append(" can not be converted to int");
        throw new ClassCastException(stringBuffer.toString());
    }

    /* renamed from: b */
    public static long m11305b(Object obj) {
        if (obj == null) {
            return 0;
        }
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(obj.getClass().getName());
        stringBuffer.append(" can not be converted to long");
        throw new ClassCastException(stringBuffer.toString());
    }

    /* renamed from: c */
    public static float m11306c(Object obj) {
        if (obj == null) {
            return 0.0f;
        }
        if (obj instanceof Number) {
            return ((Number) obj).floatValue();
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(obj.getClass().getName());
        stringBuffer.append(" can not be converted to float");
        throw new ClassCastException(stringBuffer.toString());
    }

    /* renamed from: d */
    public static double m11307d(Object obj) {
        if (obj == null) {
            return 0.0d;
        }
        if (obj instanceof Number) {
            return ((Number) obj).doubleValue();
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(obj.getClass().getName());
        stringBuffer.append(" can not be converted to double");
        throw new ClassCastException(stringBuffer.toString());
    }

    /* renamed from: e */
    public static byte m11308e(Object obj) {
        if (obj == null) {
            return 0;
        }
        if (obj instanceof Number) {
            return ((Number) obj).byteValue();
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(obj.getClass().getName());
        stringBuffer.append(" can not be converted to byte");
        throw new ClassCastException(stringBuffer.toString());
    }

    /* renamed from: f */
    public static short m11309f(Object obj) {
        if (obj == null) {
            return 0;
        }
        if (obj instanceof Number) {
            return ((Number) obj).shortValue();
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(obj.getClass().getName());
        stringBuffer.append(" can not be converted to short");
        throw new ClassCastException(stringBuffer.toString());
    }

    /* renamed from: g */
    public static char m11310g(Object obj) {
        if (obj == null) {
            return 0;
        }
        if (obj instanceof Character) {
            return ((Character) obj).charValue();
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(obj.getClass().getName());
        stringBuffer.append(" can not be converted to char");
        throw new ClassCastException(stringBuffer.toString());
    }

    /* renamed from: h */
    public static boolean m11311h(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(obj.getClass().getName());
        stringBuffer.append(" can not be converted to boolean");
        throw new ClassCastException(stringBuffer.toString());
    }
}

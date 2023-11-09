package atakplugin.UASTool;

public class amb {
    /* renamed from: a */
    static boolean m2395a(ama ama, Class<? extends alw> cls) {
        for (alw alw : ama.mo1469c()) {
            if (cls.isAssignableFrom(alw.getClass())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    static <B extends alw> B m2396b(ama ama, Class<B> cls) {
        for (B b : ama.mo1469c()) {
            if (cls.isAssignableFrom(b.getClass())) {
                return b;
            }
        }
        return null;
    }
}

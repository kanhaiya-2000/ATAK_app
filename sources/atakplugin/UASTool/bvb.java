package atakplugin.UASTool;

public final class bvb {
    /* renamed from: a */
    public static boolean m9788a(String str) {
        return str.equals("POST") || str.equals("PATCH") || str.equals("PUT") || str.equals("DELETE") || str.equals("MOVE");
    }

    /* renamed from: b */
    public static boolean m9789b(String str) {
        return str.equals("POST") || str.equals("PUT") || str.equals("PATCH") || str.equals("PROPPATCH") || str.equals("REPORT");
    }

    /* renamed from: c */
    public static boolean m9790c(String str) {
        return m9789b(str) || str.equals("OPTIONS") || str.equals("DELETE") || str.equals("PROPFIND") || str.equals("MKCOL") || str.equals("LOCK");
    }

    /* renamed from: d */
    public static boolean m9791d(String str) {
        return !str.equals("PROPFIND");
    }

    private bvb() {
    }
}

package atakplugin.UASTool;

public final class bqx {

    /* renamed from: a */
    private final String f3233a;

    /* renamed from: b */
    private final String f3234b;

    public bqx(String str, String str2) {
        this.f3233a = str;
        this.f3234b = str2;
    }

    /* renamed from: a */
    public String mo3073a() {
        return this.f3233a;
    }

    /* renamed from: b */
    public String mo3074b() {
        return this.f3234b;
    }

    public boolean equals(Object obj) {
        if (obj instanceof bqx) {
            bqx bqx = (bqx) obj;
            return bsp.m9164a((Object) this.f3233a, (Object) bqx.f3233a) && bsp.m9164a((Object) this.f3234b, (Object) bqx.f3234b);
        }
    }

    public int hashCode() {
        String str = this.f3234b;
        int i = 0;
        int hashCode = (899 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f3233a;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return this.f3233a + " realm=\"" + this.f3234b + "\"";
    }
}

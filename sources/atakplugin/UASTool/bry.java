package atakplugin.UASTool;

import java.io.IOException;

public enum bry {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2");
    

    /* renamed from: e */
    private final String f3515e;

    private bry(String str) {
        this.f3515e = str;
    }

    /* renamed from: a */
    public static bry m8990a(String str) {
        bry bry = HTTP_1_0;
        if (str.equals(bry.f3515e)) {
            return bry;
        }
        bry bry2 = HTTP_1_1;
        if (str.equals(bry2.f3515e)) {
            return bry2;
        }
        bry bry3 = HTTP_2;
        if (str.equals(bry3.f3515e)) {
            return bry3;
        }
        bry bry4 = SPDY_3;
        if (str.equals(bry4.f3515e)) {
            return bry4;
        }
        throw new IOException("Unexpected protocol: " + str);
    }

    public String toString() {
        return this.f3515e;
    }
}

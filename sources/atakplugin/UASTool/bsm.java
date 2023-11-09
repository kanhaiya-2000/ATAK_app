package atakplugin.UASTool;

public enum bsm {
    TLS_1_2("TLSv1.2"),
    TLS_1_1("TLSv1.1"),
    TLS_1_0("TLSv1"),
    SSL_3_0("SSLv3");
    

    /* renamed from: e */
    final String f3579e;

    private bsm(String str) {
        this.f3579e = str;
    }

    /* renamed from: a */
    public static bsm m9130a(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -503070503:
                if (str.equals("TLSv1.1")) {
                    c = 0;
                    break;
                }
                break;
            case -503070502:
                if (str.equals("TLSv1.2")) {
                    c = 1;
                    break;
                }
                break;
            case 79201641:
                if (str.equals("SSLv3")) {
                    c = 2;
                    break;
                }
                break;
            case 79923350:
                if (str.equals("TLSv1")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return TLS_1_1;
            case 1:
                return TLS_1_2;
            case 2:
                return SSL_3_0;
            case 3:
                return TLS_1_0;
            default:
                throw new IllegalArgumentException("Unexpected TLS version: " + str);
        }
    }

    /* renamed from: a */
    public String mo3422a() {
        return this.f3579e;
    }
}

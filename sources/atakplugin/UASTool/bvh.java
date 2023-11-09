package atakplugin.UASTool;

import java.net.ProtocolException;

public final class bvh {

    /* renamed from: a */
    public static final int f4037a = 307;

    /* renamed from: b */
    public static final int f4038b = 308;

    /* renamed from: c */
    public static final int f4039c = 100;

    /* renamed from: d */
    public final bry f4040d;

    /* renamed from: e */
    public final int f4041e;

    /* renamed from: f */
    public final String f4042f;

    public bvh(bry bry, int i, String str) {
        this.f4040d = bry;
        this.f4041e = i;
        this.f4042f = str;
    }

    /* renamed from: a */
    public static bvh m9823a(bsh bsh) {
        return new bvh(bsh.mo3376b(), bsh.mo3378c(), bsh.mo3381e());
    }

    /* renamed from: a */
    public static bvh m9824a(String str) {
        bry bry;
        String str2;
        int i = 9;
        if (str.startsWith("HTTP/1.")) {
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            int charAt = str.charAt(7) - '0';
            if (charAt == 0) {
                bry = bry.HTTP_1_0;
            } else if (charAt == 1) {
                bry = bry.HTTP_1_1;
            } else {
                throw new ProtocolException("Unexpected status line: " + str);
            }
        } else if (str.startsWith("ICY ")) {
            bry = bry.HTTP_1_0;
            i = 4;
        } else {
            throw new ProtocolException("Unexpected status line: " + str);
        }
        int i2 = i + 3;
        if (str.length() >= i2) {
            try {
                int parseInt = Integer.parseInt(str.substring(i, i2));
                if (str.length() <= i2) {
                    str2 = "";
                } else if (str.charAt(i2) == ' ') {
                    str2 = str.substring(i + 4);
                } else {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                return new bvh(bry, parseInt, str2);
            } catch (NumberFormatException unused) {
                throw new ProtocolException("Unexpected status line: " + str);
            }
        } else {
            throw new ProtocolException("Unexpected status line: " + str);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f4040d == bry.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        sb.append(' ');
        sb.append(this.f4041e);
        if (this.f4042f != null) {
            sb.append(' ');
            sb.append(this.f4042f);
        }
        return sb.toString();
    }
}

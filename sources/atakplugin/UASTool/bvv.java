package atakplugin.UASTool;

import atakplugin.UASTool.brt;
import com.google.common.net.HttpHeaders;
import java.io.EOFException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public final class bvv implements brt {

    /* renamed from: a */
    private static final Charset f4084a = Charset.forName("UTF-8");

    /* renamed from: b */
    private final C0271b f4085b;

    /* renamed from: c */
    private volatile C0270a f4086c;

    /* renamed from: atakplugin.UASTool.bvv$a */
    public enum C0270a {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    /* renamed from: atakplugin.UASTool.bvv$b */
    public interface C0271b {

        /* renamed from: a */
        public static final C0271b f4092a = new bvw();

        /* renamed from: a */
        void mo3740a(String str);
    }

    public bvv() {
        this(C0271b.f4092a);
    }

    public bvv(C0271b bVar) {
        this.f4086c = C0270a.NONE;
        this.f4085b = bVar;
    }

    /* renamed from: a */
    public bvv mo3739a(C0270a aVar) {
        Objects.requireNonNull(aVar, "level == null. Use Level.NONE instead.");
        this.f4086c = aVar;
        return this;
    }

    /* renamed from: a */
    public C0270a mo3738a() {
        return this.f4086c;
    }

    /* renamed from: a */
    public bsh mo3248a(brt.C0228a aVar) {
        boolean z;
        String str;
        String str2;
        boolean z2;
        brt.C0228a aVar2 = aVar;
        C0270a aVar3 = this.f4086c;
        bsb a = aVar.mo3249a();
        if (aVar3 == C0270a.NONE) {
            return aVar2.mo3250a(a);
        }
        boolean z3 = true;
        boolean z4 = aVar3 == C0270a.BODY;
        boolean z5 = z4 || aVar3 == C0270a.HEADERS;
        bsd d = a.mo3348d();
        if (d == null) {
            z3 = false;
        }
        bqz b = aVar.mo3251b();
        String str3 = "--> " + a.mo3345b() + ' ' + a.mo3343a() + ' ' + (b != null ? b.mo3083d() : bry.HTTP_1_1);
        if (!z5 && z3) {
            str3 = str3 + " (" + d.contentLength() + "-byte body)";
        }
        this.f4085b.mo3740a(str3);
        if (z5) {
            if (z3) {
                if (d.contentType() != null) {
                    this.f4085b.mo3740a("Content-Type: " + d.contentType());
                }
                if (d.contentLength() != -1) {
                    this.f4085b.mo3740a("Content-Length: " + d.contentLength());
                }
            }
            brp c = a.mo3347c();
            int a2 = c.mo3168a();
            int i = 0;
            while (i < a2) {
                String a3 = c.mo3169a(i);
                int i2 = a2;
                if ("Content-Type".equalsIgnoreCase(a3) || "Content-Length".equalsIgnoreCase(a3)) {
                    z2 = z5;
                } else {
                    z2 = z5;
                    this.f4085b.mo3740a(a3 + ": " + c.mo3171b(i));
                }
                i++;
                a2 = i2;
                z5 = z2;
            }
            z = z5;
            if (!z4 || !z3) {
                this.f4085b.mo3740a("--> END " + a.mo3345b());
            } else if (m9905a(a.mo3347c())) {
                this.f4085b.mo3740a("--> END " + a.mo3345b() + " (encoded body omitted)");
            } else {
                bwl bwl = new bwl();
                d.writeTo(bwl);
                Charset charset = f4084a;
                bru contentType = d.contentType();
                if (contentType != null) {
                    charset = contentType.mo3253a(charset);
                }
                this.f4085b.mo3740a("");
                if (m9906a(bwl)) {
                    this.f4085b.mo3740a(bwl.mo3805a(charset));
                    this.f4085b.mo3740a("--> END " + a.mo3345b() + " (" + d.contentLength() + "-byte body)");
                } else {
                    this.f4085b.mo3740a("--> END " + a.mo3345b() + " (binary " + d.contentLength() + "-byte body omitted)");
                }
            }
        } else {
            z = z5;
        }
        long nanoTime = System.nanoTime();
        try {
            bsh a4 = aVar2.mo3250a(a);
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime);
            bsj h = a4.mo3384h();
            long b2 = h.mo3017b();
            if (b2 != -1) {
                str = b2 + "-byte";
            } else {
                str = "unknown-length";
            }
            C0271b bVar = this.f4085b;
            StringBuilder sb = new StringBuilder();
            String str4 = "-byte body)";
            sb.append("<-- ");
            sb.append(a4.mo3378c());
            sb.append(' ');
            long j = b2;
            sb.append(a4.mo3381e());
            sb.append(' ');
            sb.append(a4.mo3372a().mo3343a());
            sb.append(" (");
            sb.append(millis);
            sb.append("ms");
            if (!z) {
                str2 = ", " + str + " body";
            } else {
                str2 = "";
            }
            sb.append(str2);
            sb.append(')');
            bVar.mo3740a(sb.toString());
            if (z) {
                brp g = a4.mo3383g();
                int a5 = g.mo3168a();
                for (int i3 = 0; i3 < a5; i3++) {
                    this.f4085b.mo3740a(g.mo3169a(i3) + ": " + g.mo3171b(i3));
                }
                if (!z4 || !bva.m9786d(a4)) {
                    this.f4085b.mo3740a("<-- END HTTP");
                } else if (m9905a(a4.mo3383g())) {
                    this.f4085b.mo3740a("<-- END HTTP (encoded body omitted)");
                } else {
                    bwp c2 = h.mo3018c();
                    c2.mo3829c((long) bfu.f2629b);
                    bwl b3 = c2.mo3811b();
                    Charset charset2 = f4084a;
                    bru a6 = h.mo3016a();
                    if (a6 != null) {
                        try {
                            charset2 = a6.mo3253a(charset2);
                        } catch (UnsupportedCharsetException unused) {
                            this.f4085b.mo3740a("");
                            this.f4085b.mo3740a("Couldn't decode the response body; charset is likely malformed.");
                            this.f4085b.mo3740a("<-- END HTTP");
                            return a4;
                        }
                    }
                    if (!m9906a(b3)) {
                        this.f4085b.mo3740a("");
                        this.f4085b.mo3740a("<-- END HTTP (binary " + b3.mo3783a() + "-byte body omitted)");
                        return a4;
                    }
                    if (j != 0) {
                        this.f4085b.mo3740a("");
                        this.f4085b.mo3740a(b3.clone().mo3805a(charset2));
                    }
                    this.f4085b.mo3740a("<-- END HTTP (" + b3.mo3783a() + str4);
                }
            }
            return a4;
        } catch (Exception e) {
            Exception exc = e;
            this.f4085b.mo3740a("<-- HTTP FAILED: " + exc);
            throw exc;
        }
    }

    /* renamed from: a */
    static boolean m9906a(bwl bwl) {
        try {
            bwl bwl2 = new bwl();
            bwl.mo3792a(bwl2, 0, bwl.mo3783a() < 64 ? bwl.mo3783a() : 64);
            for (int i = 0; i < 16; i++) {
                if (bwl2.mo3854i()) {
                    return true;
                }
                int z = bwl2.mo3891z();
                if (Character.isISOControl(z) && !Character.isWhitespace(z)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    /* renamed from: a */
    private boolean m9905a(brp brp) {
        String a = brp.mo3170a(HttpHeaders.CONTENT_ENCODING);
        return a != null && !a.equalsIgnoreCase("identity");
    }
}

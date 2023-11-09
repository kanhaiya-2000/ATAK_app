package atakplugin.UASTool;

import atakplugin.UASTool.C0998wk;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: atakplugin.UASTool.we */
class C0990we {

    /* renamed from: atakplugin.UASTool.we$a */
    static class C0991a {

        /* renamed from: a */
        final C0992a f7459a;

        /* renamed from: b */
        final String f7460b;

        /* renamed from: c */
        final int f7461c;

        /* renamed from: atakplugin.UASTool.we$a$a */
        enum C0992a implements C0998wk.C0999a<C0991a> {
            NUMERIC("0|[1-9][0-9]*"),
            DOT("\\."),
            HYPHEN("-"),
            EQUAL("="),
            NOT_EQUAL("!="),
            GREATER(">(?!=)"),
            GREATER_EQUAL(">="),
            LESS("<(?!=)"),
            LESS_EQUAL("<="),
            TILDE("~"),
            WILDCARD("[\\*xX]"),
            CARET("\\^"),
            AND("&"),
            OR("\\|"),
            NOT("!(?!=)"),
            LEFT_PAREN("\\("),
            RIGHT_PAREN("\\)"),
            WHITESPACE("\\s+"),
            EOI("?!");
            

            /* renamed from: t */
            final Pattern f7482t;

            private C0992a(String str) {
                this.f7482t = Pattern.compile("^(" + str + ")");
            }

            public String toString() {
                return name() + "(" + this.f7482t + ")";
            }

            /* renamed from: a */
            public boolean mo6080a(C0991a aVar) {
                return aVar != null && this == aVar.f7459a;
            }
        }

        C0991a(C0992a aVar, String str, int i) {
            this.f7459a = aVar;
            this.f7460b = str == null ? "" : str;
            this.f7461c = i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0991a)) {
                return false;
            }
            C0991a aVar = (C0991a) obj;
            if (!this.f7459a.equals(aVar.f7459a) || !this.f7460b.equals(aVar.f7460b) || this.f7461c != aVar.f7461c) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return ((((355 + this.f7459a.hashCode()) * 71) + this.f7460b.hashCode()) * 71) + this.f7461c;
        }

        public String toString() {
            return String.format("%s(%s) at position %d", new Object[]{this.f7459a.name(), this.f7460b, Integer.valueOf(this.f7461c)});
        }
    }

    C0990we() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0998wk<C0991a> mo6093a(String str) {
        boolean z;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (!str.isEmpty()) {
            C0991a.C0992a[] values = C0991a.C0992a.values();
            int length = values.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z = false;
                    continue;
                    break;
                }
                C0991a.C0992a aVar = values[i2];
                Matcher matcher = aVar.f7482t.matcher(str);
                if (matcher.find()) {
                    str = matcher.replaceFirst("");
                    if (aVar != C0991a.C0992a.WHITESPACE) {
                        arrayList.add(new C0991a(aVar, matcher.group(), i));
                    }
                    i += matcher.end();
                    z = true;
                    continue;
                } else {
                    i2++;
                }
            }
            if (!z) {
                throw new C0993wf(str);
            }
        }
        arrayList.add(new C0991a(C0991a.C0992a.EOI, (String) null, i));
        return new C0998wk<>(arrayList.toArray(new C0991a[arrayList.size()]));
    }
}

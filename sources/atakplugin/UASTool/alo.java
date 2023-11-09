package atakplugin.UASTool;

import java.math.BigInteger;
import java.util.Arrays;

public class alo {

    /* renamed from: a */
    public byte[] f1972a = new byte[0];

    /* renamed from: b */
    public C0065j[] f1973b = null;

    /* renamed from: atakplugin.UASTool.alo$j */
    public interface C0065j {
        /* renamed from: a */
        int mo1408a();

        /* renamed from: b */
        long mo1409b();
    }

    /* renamed from: a */
    public int mo1401a() {
        int length = this.f1972a.length;
        C0065j[] jVarArr = this.f1973b;
        return (jVarArr == null || jVarArr.length <= 0) ? length : length + 2 + (jVarArr.length * 6);
    }

    /* renamed from: a */
    public C0065j mo1402a(int i, long j) {
        if (i <= 127) {
            if (j <= 127) {
                return new C0057b(i, j);
            }
            if (j <= 32767) {
                return new C0060e(i, j);
            }
            if (j <= 2147483647L) {
                return new C0058c(i, j);
            }
            return new C0059d(i, j);
        } else if (i <= 32767) {
            if (j <= 127) {
                return new C0066k(i, j);
            }
            if (j <= 32767) {
                return new C0069n(i, j);
            }
            if (j <= 2147483647L) {
                return new C0067l(i, j);
            }
            return new C0068m(i, j);
        } else if (j <= 127) {
            return new C0061f(i, j);
        } else {
            if (j <= 32767) {
                return new C0064i(i, j);
            }
            if (j <= 2147483647L) {
                return new C0062g(i, j);
            }
            return new C0063h(i, j);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        alo alo = (alo) obj;
        if (!new BigInteger(this.f1972a).equals(new BigInteger(alo.f1972a))) {
            return false;
        }
        C0065j[] jVarArr = this.f1973b;
        C0065j[] jVarArr2 = alo.f1973b;
        return jVarArr == null ? jVarArr2 == null : Arrays.equals(jVarArr, jVarArr2);
    }

    public int hashCode() {
        byte[] bArr = this.f1972a;
        int i = 0;
        int hashCode = (bArr != null ? Arrays.hashCode(bArr) : 0) * 31;
        C0065j[] jVarArr = this.f1973b;
        if (jVarArr != null) {
            i = Arrays.hashCode(jVarArr);
        }
        return hashCode + i;
    }

    public String toString() {
        return "Entry{iv=" + C0677ni.m12484a(this.f1972a) + ", pairs=" + Arrays.toString(this.f1973b) + '}';
    }

    /* renamed from: atakplugin.UASTool.alo$b */
    private class C0057b extends C0056a {

        /* renamed from: c */
        private byte f1976c;

        /* renamed from: d */
        private byte f1977d;

        public C0057b(int i, long j) {
            super(alo.this, (C0056a) null);
            this.f1976c = (byte) i;
            this.f1977d = (byte) ((int) j);
        }

        /* renamed from: a */
        public int mo1408a() {
            return this.f1976c;
        }

        /* renamed from: b */
        public long mo1409b() {
            return (long) this.f1977d;
        }
    }

    /* renamed from: atakplugin.UASTool.alo$e */
    private class C0060e extends C0056a {

        /* renamed from: c */
        private byte f1985c;

        /* renamed from: d */
        private short f1986d;

        public C0060e(int i, long j) {
            super(alo.this, (C0056a) null);
            this.f1985c = (byte) i;
            this.f1986d = (short) ((int) j);
        }

        /* renamed from: a */
        public int mo1408a() {
            return this.f1985c;
        }

        /* renamed from: b */
        public long mo1409b() {
            return (long) this.f1986d;
        }
    }

    /* renamed from: atakplugin.UASTool.alo$c */
    private class C0058c extends C0056a {

        /* renamed from: c */
        private byte f1979c;

        /* renamed from: d */
        private int f1980d;

        public C0058c(int i, long j) {
            super(alo.this, (C0056a) null);
            this.f1979c = (byte) i;
            this.f1980d = (int) j;
        }

        /* renamed from: a */
        public int mo1408a() {
            return this.f1979c;
        }

        /* renamed from: b */
        public long mo1409b() {
            return (long) this.f1980d;
        }
    }

    /* renamed from: atakplugin.UASTool.alo$d */
    private class C0059d extends C0056a {

        /* renamed from: c */
        private byte f1982c;

        /* renamed from: d */
        private long f1983d;

        public C0059d(int i, long j) {
            super(alo.this, (C0056a) null);
            this.f1982c = (byte) i;
            this.f1983d = j;
        }

        /* renamed from: a */
        public int mo1408a() {
            return this.f1982c;
        }

        /* renamed from: b */
        public long mo1409b() {
            return this.f1983d;
        }
    }

    /* renamed from: atakplugin.UASTool.alo$k */
    private class C0066k extends C0056a {

        /* renamed from: c */
        private short f2000c;

        /* renamed from: d */
        private byte f2001d;

        public C0066k(int i, long j) {
            super(alo.this, (C0056a) null);
            this.f2000c = (short) i;
            this.f2001d = (byte) ((int) j);
        }

        /* renamed from: a */
        public int mo1408a() {
            return this.f2000c;
        }

        /* renamed from: b */
        public long mo1409b() {
            return (long) this.f2001d;
        }
    }

    /* renamed from: atakplugin.UASTool.alo$n */
    private class C0069n extends C0056a {

        /* renamed from: c */
        private short f2009c;

        /* renamed from: d */
        private short f2010d;

        public C0069n(int i, long j) {
            super(alo.this, (C0056a) null);
            this.f2009c = (short) i;
            this.f2010d = (short) ((int) j);
        }

        /* renamed from: a */
        public int mo1408a() {
            return this.f2009c;
        }

        /* renamed from: b */
        public long mo1409b() {
            return (long) this.f2010d;
        }
    }

    /* renamed from: atakplugin.UASTool.alo$l */
    private class C0067l extends C0056a {

        /* renamed from: c */
        private short f2003c;

        /* renamed from: d */
        private int f2004d;

        public C0067l(int i, long j) {
            super(alo.this, (C0056a) null);
            this.f2003c = (short) i;
            this.f2004d = (int) j;
        }

        /* renamed from: a */
        public int mo1408a() {
            return this.f2003c;
        }

        /* renamed from: b */
        public long mo1409b() {
            return (long) this.f2004d;
        }
    }

    /* renamed from: atakplugin.UASTool.alo$m */
    private class C0068m extends C0056a {

        /* renamed from: c */
        private short f2006c;

        /* renamed from: d */
        private long f2007d;

        public C0068m(int i, long j) {
            super(alo.this, (C0056a) null);
            this.f2006c = (short) i;
            this.f2007d = j;
        }

        /* renamed from: a */
        public int mo1408a() {
            return this.f2006c;
        }

        /* renamed from: b */
        public long mo1409b() {
            return this.f2007d;
        }
    }

    /* renamed from: atakplugin.UASTool.alo$f */
    private class C0061f extends C0056a {

        /* renamed from: c */
        private int f1988c;

        /* renamed from: d */
        private byte f1989d;

        public C0061f(int i, long j) {
            super(alo.this, (C0056a) null);
            this.f1988c = i;
            this.f1989d = (byte) ((int) j);
        }

        /* renamed from: a */
        public int mo1408a() {
            return this.f1988c;
        }

        /* renamed from: b */
        public long mo1409b() {
            return (long) this.f1989d;
        }
    }

    /* renamed from: atakplugin.UASTool.alo$i */
    private class C0064i extends C0056a {

        /* renamed from: c */
        private int f1997c;

        /* renamed from: d */
        private short f1998d;

        public C0064i(int i, long j) {
            super(alo.this, (C0056a) null);
            this.f1997c = i;
            this.f1998d = (short) ((int) j);
        }

        /* renamed from: a */
        public int mo1408a() {
            return this.f1997c;
        }

        /* renamed from: b */
        public long mo1409b() {
            return (long) this.f1998d;
        }
    }

    /* renamed from: atakplugin.UASTool.alo$g */
    private class C0062g extends C0056a {

        /* renamed from: c */
        private int f1991c;

        /* renamed from: d */
        private int f1992d;

        public C0062g(int i, long j) {
            super(alo.this, (C0056a) null);
            this.f1991c = i;
            this.f1992d = (int) j;
        }

        /* renamed from: a */
        public int mo1408a() {
            return this.f1991c;
        }

        /* renamed from: b */
        public long mo1409b() {
            return (long) this.f1992d;
        }
    }

    /* renamed from: atakplugin.UASTool.alo$h */
    private class C0063h extends C0056a {

        /* renamed from: c */
        private int f1994c;

        /* renamed from: d */
        private long f1995d;

        public C0063h(int i, long j) {
            super(alo.this, (C0056a) null);
            this.f1994c = i;
            this.f1995d = j;
        }

        /* renamed from: a */
        public int mo1408a() {
            return this.f1994c;
        }

        /* renamed from: b */
        public long mo1409b() {
            return this.f1995d;
        }
    }

    /* renamed from: atakplugin.UASTool.alo$a */
    private abstract class C0056a implements C0065j {
        private C0056a() {
        }

        /* synthetic */ C0056a(alo alo, C0056a aVar) {
            this();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C0065j jVar = (C0065j) obj;
            return mo1408a() == jVar.mo1408a() && mo1409b() == jVar.mo1409b();
        }

        public String toString() {
            return "P(" + mo1408a() + "|" + mo1409b() + ")";
        }
    }
}

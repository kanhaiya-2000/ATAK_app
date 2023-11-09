package atakplugin.UASTool;

import java.util.Arrays;

/* renamed from: atakplugin.UASTool.vh */
class C0958vh implements Comparable<C0958vh> {

    /* renamed from: a */
    static final C0958vh f7422a = new C0959a();

    /* renamed from: b */
    private final String[] f7423b;

    /* renamed from: atakplugin.UASTool.vh$a */
    private static class C0959a extends C0958vh {
        public int hashCode() {
            return 0;
        }

        public String toString() {
            return "";
        }

        public C0959a() {
            super((String[]) null);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C0958vh mo6024a() {
            throw new NullPointerException("Metadata version is NULL");
        }

        public boolean equals(Object obj) {
            return obj instanceof C0959a;
        }

        /* renamed from: a */
        public int compareTo(C0958vh vhVar) {
            return !equals(vhVar) ? 1 : 0;
        }
    }

    C0958vh(String[] strArr) {
        this.f7423b = strArr;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0958vh mo6024a() {
        String[] strArr = this.f7423b;
        String str = strArr[strArr.length - 1];
        if (m14228a(str)) {
            strArr[strArr.length - 1] = String.valueOf(Integer.parseInt(str) + 1);
        } else {
            strArr = (String[]) Arrays.copyOf(strArr, strArr.length + 1);
            strArr[strArr.length - 1] = String.valueOf(1);
        }
        return new C0958vh(strArr);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof C0958vh) && compareTo((C0958vh) obj) == 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f7423b);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String append : this.f7423b) {
            sb.append(append);
            sb.append(".");
        }
        return sb.deleteCharAt(sb.lastIndexOf(".")).toString();
    }

    /* renamed from: a */
    public int compareTo(C0958vh vhVar) {
        if (vhVar == f7422a) {
            return -1;
        }
        int a = m14226a(vhVar.f7423b);
        return a == 0 ? this.f7423b.length - vhVar.f7423b.length : a;
    }

    /* renamed from: a */
    private int m14226a(String[] strArr) {
        int a = m14227a(this.f7423b, strArr);
        int i = 0;
        for (int i2 = 0; i2 < a; i2++) {
            i = m14225a(this.f7423b[i2], strArr[i2]);
            if (i != 0) {
                break;
            }
        }
        return i;
    }

    /* renamed from: a */
    private int m14227a(String[] strArr, String[] strArr2) {
        return strArr.length <= strArr2.length ? strArr.length : strArr2.length;
    }

    /* renamed from: a */
    private int m14225a(String str, String str2) {
        if (!m14228a(str) || !m14228a(str2)) {
            return str.compareTo(str2);
        }
        return Integer.parseInt(str) - Integer.parseInt(str2);
    }

    /* renamed from: a */
    private boolean m14228a(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }
}

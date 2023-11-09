package atakplugin.UASTool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public final class brp {

    /* renamed from: a */
    private final String[] f3395a;

    private brp(C0225a aVar) {
        this.f3395a = (String[]) aVar.f3396a.toArray(new String[aVar.f3396a.size()]);
    }

    private brp(String[] strArr) {
        this.f3395a = strArr;
    }

    /* renamed from: a */
    public String mo3170a(String str) {
        return m8781a(this.f3395a, str);
    }

    /* renamed from: b */
    public Date mo3172b(String str) {
        String a = mo3170a(str);
        if (a != null) {
            return buy.m9769a(a);
        }
        return null;
    }

    /* renamed from: a */
    public int mo3168a() {
        return this.f3395a.length / 2;
    }

    /* renamed from: a */
    public String mo3169a(int i) {
        return this.f3395a[i * 2];
    }

    /* renamed from: b */
    public String mo3171b(int i) {
        return this.f3395a[(i * 2) + 1];
    }

    /* renamed from: b */
    public Set<String> mo3173b() {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        int a = mo3168a();
        for (int i = 0; i < a; i++) {
            treeSet.add(mo3169a(i));
        }
        return Collections.unmodifiableSet(treeSet);
    }

    /* renamed from: c */
    public List<String> mo3175c(String str) {
        int a = mo3168a();
        ArrayList arrayList = null;
        for (int i = 0; i < a; i++) {
            if (str.equalsIgnoreCase(mo3169a(i))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(mo3171b(i));
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    /* renamed from: c */
    public C0225a mo3174c() {
        C0225a aVar = new C0225a();
        Collections.addAll(aVar.f3396a, this.f3395a);
        return aVar;
    }

    public boolean equals(Object obj) {
        return (obj instanceof brp) && Arrays.equals(((brp) obj).f3395a, this.f3395a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f3395a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int a = mo3168a();
        for (int i = 0; i < a; i++) {
            sb.append(mo3169a(i));
            sb.append(": ");
            sb.append(mo3171b(i));
            sb.append("\n");
        }
        return sb.toString();
    }

    /* renamed from: d */
    public Map<String, List<String>> mo3176d() {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        int a = mo3168a();
        for (int i = 0; i < a; i++) {
            String lowerCase = mo3169a(i).toLowerCase(Locale.US);
            List list = (List) treeMap.get(lowerCase);
            if (list == null) {
                list = new ArrayList(2);
                treeMap.put(lowerCase, list);
            }
            list.add(mo3171b(i));
        }
        return treeMap;
    }

    /* renamed from: a */
    private static String m8781a(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    /* renamed from: a */
    public static brp m8780a(String... strArr) {
        Objects.requireNonNull(strArr, "namesAndValues == null");
        if (strArr.length % 2 == 0) {
            String[] strArr2 = (String[]) strArr.clone();
            int i = 0;
            while (i < strArr2.length) {
                if (strArr2[i] != null) {
                    strArr2[i] = strArr2[i].trim();
                    i++;
                } else {
                    throw new IllegalArgumentException("Headers cannot be null");
                }
            }
            int i2 = 0;
            while (i2 < strArr2.length) {
                String str = strArr2[i2];
                String str2 = strArr2[i2 + 1];
                if (str.length() != 0 && str.indexOf(0) == -1 && str2.indexOf(0) == -1) {
                    i2 += 2;
                } else {
                    throw new IllegalArgumentException("Unexpected header: " + str + ": " + str2);
                }
            }
            return new brp(strArr2);
        }
        throw new IllegalArgumentException("Expected alternating header names and values");
    }

    /* renamed from: a */
    public static brp m8779a(Map<String, String> map) {
        Objects.requireNonNull(map, "headers == null");
        String[] strArr = new String[(map.size() * 2)];
        int i = 0;
        for (Map.Entry next : map.entrySet()) {
            if (next.getKey() == null || next.getValue() == null) {
                throw new IllegalArgumentException("Headers cannot be null");
            }
            String trim = ((String) next.getKey()).trim();
            String trim2 = ((String) next.getValue()).trim();
            if (trim.length() != 0 && trim.indexOf(0) == -1 && trim2.indexOf(0) == -1) {
                strArr[i] = trim;
                strArr[i + 1] = trim2;
                i += 2;
            } else {
                throw new IllegalArgumentException("Unexpected header: " + trim + ": " + trim2);
            }
        }
        return new brp(strArr);
    }

    /* renamed from: atakplugin.UASTool.brp$a */
    public static final class C0225a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final List<String> f3396a = new ArrayList(20);

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C0225a mo3180a(String str) {
            int indexOf = str.indexOf(":", 1);
            if (indexOf != -1) {
                return mo3184b(str.substring(0, indexOf), str.substring(indexOf + 1));
            }
            if (str.startsWith(":")) {
                return mo3184b("", str.substring(1));
            }
            return mo3184b("", str);
        }

        /* renamed from: b */
        public C0225a mo3183b(String str) {
            int indexOf = str.indexOf(":");
            if (indexOf != -1) {
                return mo3181a(str.substring(0, indexOf).trim(), str.substring(indexOf + 1));
            }
            throw new IllegalArgumentException("Unexpected header: " + str);
        }

        /* renamed from: a */
        public C0225a mo3181a(String str, String str2) {
            m8792d(str, str2);
            return mo3184b(str, str2);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public C0225a mo3184b(String str, String str2) {
            this.f3396a.add(str);
            this.f3396a.add(str2.trim());
            return this;
        }

        /* renamed from: c */
        public C0225a mo3185c(String str) {
            int i = 0;
            while (i < this.f3396a.size()) {
                if (str.equalsIgnoreCase(this.f3396a.get(i))) {
                    this.f3396a.remove(i);
                    this.f3396a.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }

        /* renamed from: c */
        public C0225a mo3186c(String str, String str2) {
            m8792d(str, str2);
            mo3185c(str);
            mo3184b(str, str2);
            return this;
        }

        /* renamed from: d */
        private void m8792d(String str, String str2) {
            Objects.requireNonNull(str, "name == null");
            if (!str.isEmpty()) {
                int length = str.length();
                for (int i = 0; i < length; i++) {
                    char charAt = str.charAt(i);
                    if (charAt <= 31 || charAt >= 127) {
                        throw new IllegalArgumentException(bsp.m9152a("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i), str));
                    }
                }
                Objects.requireNonNull(str2, "value == null");
                int length2 = str2.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    char charAt2 = str2.charAt(i2);
                    if (charAt2 <= 31 || charAt2 >= 127) {
                        throw new IllegalArgumentException(bsp.m9152a("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt2), Integer.valueOf(i2), str, str2));
                    }
                }
                return;
            }
            throw new IllegalArgumentException("name is empty");
        }

        /* renamed from: d */
        public String mo3187d(String str) {
            for (int size = this.f3396a.size() - 2; size >= 0; size -= 2) {
                if (str.equalsIgnoreCase(this.f3396a.get(size))) {
                    return this.f3396a.get(size + 1);
                }
            }
            return null;
        }

        /* renamed from: a */
        public brp mo3182a() {
            return new brp(this);
        }
    }
}

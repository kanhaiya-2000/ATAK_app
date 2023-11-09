package atakplugin.UASTool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.IllegalFormatConversionException;
import java.util.MissingFormatArgumentException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class cep {

    /* renamed from: a */
    private static final String f4583a = "%(\\d+\\$)?([-#+ 0,(\\<]*)?(\\d+)?(\\.\\d+)?([tT])?([a-zA-Z%])";

    /* renamed from: b */
    private static Pattern f4584b = Pattern.compile(f4583a);

    /* renamed from: atakplugin.UASTool.cep$a */
    private static class C0311a {

        /* renamed from: a */
        private final int f4585a;

        /* renamed from: b */
        private final ceq f4586b;

        public C0311a(char c, int i) {
            this.f4585a = i;
            this.f4586b = ceq.m11526a(c);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public int mo4589a() {
            return this.f4585a;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public ceq mo4590b() {
            return this.f4586b;
        }
    }

    @cev
    /* renamed from: a */
    public static String m11515a(String str, ceq... ceqArr) {
        ceq[] b = m11518b(str);
        if (b.length == ceqArr.length) {
            int i = 0;
            while (i < ceqArr.length) {
                if (ceqArr[i] == b[i]) {
                    i++;
                } else {
                    throw new C0313c(ceqArr[i], b[i]);
                }
            }
            return str;
        }
        throw new C0312b(ceqArr.length, b.length);
    }

    /* renamed from: a */
    public static void m11516a(String str) {
        String.format(str, (Object[]) null);
    }

    /* renamed from: b */
    public static ceq[] m11518b(String str) {
        m11516a(str);
        C0311a[] c = m11519c(str);
        HashMap hashMap = new HashMap();
        int i = -1;
        int i2 = -1;
        int i3 = -1;
        for (C0311a aVar : c) {
            int a = aVar.mo4589a();
            if (a != -1) {
                if (a != 0) {
                    i3 = a - 1;
                } else {
                    i2++;
                    i3 = i2;
                }
            }
            i = Math.max(i, i3);
            hashMap.put(Integer.valueOf(i3), ceq.m11530b(hashMap.containsKey(Integer.valueOf(i3)) ? (ceq) hashMap.get(Integer.valueOf(i3)) : ceq.UNUSED, aVar.mo4590b()));
        }
        ceq[] ceqArr = new ceq[(i + 1)];
        for (int i4 = 0; i4 <= i; i4++) {
            ceqArr[i4] = hashMap.containsKey(Integer.valueOf(i4)) ? (ceq) hashMap.get(Integer.valueOf(i4)) : ceq.UNUSED;
        }
        return ceqArr;
    }

    /* renamed from: a */
    private static int m11514a(Matcher matcher) {
        String group = matcher.group(1);
        if (group != null) {
            return Integer.parseInt(group.substring(0, group.length() - 1));
        }
        if (matcher.group(2) == null || !matcher.group(2).contains(String.valueOf(bpg.f3096d))) {
            return 0;
        }
        return -1;
    }

    /* renamed from: b */
    private static char m11517b(Matcher matcher) {
        String group = matcher.group(5);
        if (group == null) {
            return matcher.group(6).charAt(0);
        }
        return group.charAt(0);
    }

    /* renamed from: c */
    private static C0311a[] m11519c(String str) {
        ArrayList arrayList = new ArrayList();
        Matcher matcher = f4584b.matcher(str);
        while (matcher.find()) {
            char b = m11517b(matcher);
            if (!(b == '%' || b == 'n')) {
                arrayList.add(new C0311a(b, m11514a(matcher)));
            }
        }
        return (C0311a[]) arrayList.toArray(new C0311a[arrayList.size()]);
    }

    /* renamed from: atakplugin.UASTool.cep$b */
    public static class C0312b extends MissingFormatArgumentException {

        /* renamed from: a */
        private static final long f4587a = 17000126;

        /* renamed from: b */
        private final int f4588b;

        /* renamed from: c */
        private final int f4589c;

        public C0312b(int i, int i2) {
            super("-");
            this.f4588b = i;
            this.f4589c = i2;
        }

        /* renamed from: a */
        public int mo4591a() {
            return this.f4588b;
        }

        /* renamed from: b */
        public int mo4592b() {
            return this.f4589c;
        }

        public String getMessage() {
            return String.format("Expected %d arguments but found %d.", new Object[]{Integer.valueOf(this.f4588b), Integer.valueOf(this.f4589c)});
        }
    }

    /* renamed from: atakplugin.UASTool.cep$c */
    public static class C0313c extends IllegalFormatConversionException {

        /* renamed from: a */
        private static final long f4590a = 17000126;

        /* renamed from: b */
        private final ceq f4591b;

        /* renamed from: c */
        private final ceq f4592c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0313c(ceq ceq, ceq ceq2) {
            super(ceq.f4604k.length() == 0 ? '-' : ceq.f4604k.charAt(0), ceq2.f4603j == null ? Object.class : ceq2.f4603j[0]);
            this.f4591b = ceq;
            this.f4592c = ceq2;
        }

        /* renamed from: a */
        public ceq mo4594a() {
            return this.f4591b;
        }

        /* renamed from: b */
        public ceq mo4595b() {
            return this.f4592c;
        }

        public String getMessage() {
            return String.format("Expected category %s but found %s.", new Object[]{this.f4591b, this.f4592c});
        }
    }
}

package atakplugin.UASTool;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@aot(mo1534a = 5, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000b\u001a!\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0002\b\u0004\u001a\u0011\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0002¢\u0006\u0002\b\u0007\u001a\u0014\u0010\b\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u001aJ\u0010\t\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001H\b¢\u0006\u0002\b\u000e\u001a\u0014\u0010\u000f\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u001a\u001e\u0010\u0011\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u001a\n\u0010\u0013\u001a\u00020\u0002*\u00020\u0002\u001a\u0014\u0010\u0014\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0002¨\u0006\u0015"}, mo1538e = {"getIndentFunction", "Lkotlin/Function1;", "", "indent", "getIndentFunction$StringsKt__IndentKt", "indentWidth", "", "indentWidth$StringsKt__IndentKt", "prependIndent", "reindent", "", "resultSizeEstimate", "indentAddFunction", "indentCutFunction", "reindent$StringsKt__IndentKt", "replaceIndent", "newIndent", "replaceIndentByMargin", "marginPrefix", "trimIndent", "trimMargin", "kotlin-stdlib"}, mo1539f = "kotlin/text/StringsKt", mo1541h = 1)
class bod {
    /* renamed from: a */
    public static /* synthetic */ String m7922a(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "|";
        }
        return boc.m7921a(str, str2);
    }

    /* renamed from: a */
    public static final String m7921a(String str, String str2) {
        bfq.m6567f(str, "$this$trimMargin");
        bfq.m6567f(str2, "marginPrefix");
        return boc.m7923a(str, "", str2);
    }

    /* renamed from: a */
    public static /* synthetic */ String m7924a(String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "";
        }
        if ((i & 2) != 0) {
            str3 = "|";
        }
        return boc.m7923a(str, str2, str3);
    }

    /* renamed from: a */
    public static final String m7923a(String str, String str2, String str3) {
        int i;
        String invoke;
        String str4 = str;
        String str5 = str3;
        bfq.m6567f(str4, "$this$replaceIndentByMargin");
        bfq.m6567f(str2, "newIndent");
        bfq.m6567f(str5, "marginPrefix");
        if (!boc.m8027a((CharSequence) str5)) {
            List<String> i2 = boc.m8226i(str4);
            int length = str.length() + (str2.length() * i2.size());
            bdl<String, String> c = m7929c(str2);
            int a = ato.m4592a(i2);
            Collection arrayList = new ArrayList();
            int i3 = 0;
            for (Object next : i2) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    ato.m4612b();
                }
                String str6 = (String) next;
                String str7 = null;
                if ((i3 == 0 || i3 == a) && boc.m8027a((CharSequence) str6)) {
                    str6 = null;
                } else {
                    CharSequence charSequence = str6;
                    int length2 = charSequence.length();
                    int i5 = 0;
                    while (true) {
                        if (i5 >= length2) {
                            i = -1;
                            break;
                        } else if (!bne.m7731a(charSequence.charAt(i5))) {
                            i = i5;
                            break;
                        } else {
                            i5++;
                        }
                    }
                    if (i != -1) {
                        int i6 = i;
                        if (boc.m8034a(str6, str3, i, false, 4, (Object) null)) {
                            int length3 = i6 + str3.length();
                            if (str6 != null) {
                                str7 = str6.substring(length3);
                                bfq.m6554b(str7, "(this as java.lang.String).substring(startIndex)");
                            } else {
                                throw new apx("null cannot be cast to non-null type java.lang.String");
                            }
                        }
                    }
                    if (!(str7 == null || (invoke = c.invoke(str7)) == null)) {
                        str6 = invoke;
                    }
                }
                if (str6 != null) {
                    arrayList.add(str6);
                }
                i3 = i4;
            }
            String sb = ((StringBuilder) ato.m4726a((List) arrayList, new StringBuilder(length), "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (bdl) null, 124, (Object) null)).toString();
            bfq.m6554b(sb, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
            return sb;
        }
        throw new IllegalArgumentException("marginPrefix must be non-blank string.".toString());
    }

    /* renamed from: a */
    public static final String m7920a(String str) {
        bfq.m6567f(str, "$this$trimIndent");
        return boc.m7927b(str, "");
    }

    /* renamed from: b */
    public static /* synthetic */ String m7928b(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "";
        }
        return boc.m7927b(str, str2);
    }

    /* renamed from: b */
    public static final String m7927b(String str, String str2) {
        String invoke;
        String str3 = str;
        bfq.m6567f(str3, "$this$replaceIndent");
        bfq.m6567f(str2, "newIndent");
        List<String> i = boc.m8226i(str3);
        Iterable iterable = i;
        Collection arrayList = new ArrayList();
        for (Object next : iterable) {
            if (!boc.m8027a((CharSequence) (String) next)) {
                arrayList.add(next);
            }
        }
        Iterable<String> iterable2 = (List) arrayList;
        Collection arrayList2 = new ArrayList(ato.m4625a(iterable2, 10));
        for (String b : iterable2) {
            arrayList2.add(Integer.valueOf(m7926b(b)));
        }
        Integer num = (Integer) ato.m4699F((List) arrayList2);
        int i2 = 0;
        int intValue = num != null ? num.intValue() : 0;
        int length = str.length() + (str2.length() * i.size());
        bdl<String, String> c = m7929c(str2);
        int a = ato.m4592a(i);
        Collection arrayList3 = new ArrayList();
        for (Object next2 : iterable) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                ato.m4612b();
            }
            String str4 = (String) next2;
            if ((i2 == 0 || i2 == a) && boc.m8027a((CharSequence) str4)) {
                str4 = null;
            } else {
                String f = boc.m8322f(str4, intValue);
                if (!(f == null || (invoke = c.invoke(f)) == null)) {
                    str4 = invoke;
                }
            }
            if (str4 != null) {
                arrayList3.add(str4);
            }
            i2 = i3;
        }
        String sb = ((StringBuilder) ato.m4726a((List) arrayList3, new StringBuilder(length), "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (bdl) null, 124, (Object) null)).toString();
        bfq.m6554b(sb, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return sb;
    }

    /* renamed from: c */
    public static /* synthetic */ String m7931c(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "    ";
        }
        return boc.m7930c(str, str2);
    }

    /* renamed from: c */
    public static final String m7930c(String str, String str2) {
        bfq.m6567f(str, "$this$prependIndent");
        bfq.m6567f(str2, "indent");
        return bkx.m7535a(bkx.m7614u(boc.m8225h(str), new bog(str2)), "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (bdl) null, 62, (Object) null);
    }

    /* renamed from: b */
    private static final int m7926b(String str) {
        CharSequence charSequence = str;
        int length = charSequence.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            } else if (!bne.m7731a(charSequence.charAt(i))) {
                break;
            } else {
                i++;
            }
        }
        return i == -1 ? str.length() : i;
    }

    /* renamed from: c */
    private static final bdl<String, String> m7929c(String str) {
        if (str.length() == 0) {
            return boe.f3055a;
        }
        return new bof(str);
    }

    /* renamed from: a */
    private static final String m7925a(List<String> list, int i, bdl<? super String, String> bdl, bdl<? super String, String> bdl2) {
        String invoke;
        int a = ato.m4592a(list);
        Collection arrayList = new ArrayList();
        int i2 = 0;
        for (Object next : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                if (bbg.m6171a(1, 3, 0)) {
                    ato.m4612b();
                } else {
                    throw new ArithmeticException("Index overflow has happened.");
                }
            }
            String str = (String) next;
            if ((i2 == 0 || i2 == a) && boc.m8027a((CharSequence) str)) {
                str = null;
            } else {
                String invoke2 = bdl2.invoke(str);
                if (!(invoke2 == null || (invoke = bdl.invoke(invoke2)) == null)) {
                    str = invoke;
                }
            }
            if (str != null) {
                arrayList.add(str);
            }
            i2 = i3;
        }
        String sb = ((StringBuilder) ato.m4726a((List) arrayList, new StringBuilder(i), "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (bdl) null, 124, (Object) null)).toString();
        bfq.m6554b(sb, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return sb;
    }
}

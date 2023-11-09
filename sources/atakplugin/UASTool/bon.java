package atakplugin.UASTool;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

@aot(mo1534a = 5, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000~\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\f\n\u0002\b\u0011\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u001a\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\b\u001a\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\b\u001a\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\b\u001a\u0019\u0010\u0007\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\b\u001a!\u0010\u0007\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\b\u001a)\u0010\u0007\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\b\u001a\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\b\u001a!\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\b\u001a!\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\b\u001a\n\u0010\u0017\u001a\u00020\u0002*\u00020\u0002\u001a\u0014\u0010\u0017\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0007\u001a\u0015\u0010\u001a\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0011H\b\u001a\u0015\u0010\u001c\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0011H\b\u001a\u001d\u0010\u001d\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u0011H\b\u001a\u001c\u0010 \u001a\u00020\u0011*\u00020\u00022\u0006\u0010!\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020#\u001a\f\u0010$\u001a\u00020\u0002*\u00020\u0014H\u0007\u001a \u0010$\u001a\u00020\u0002*\u00020\u00142\b\b\u0002\u0010%\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u0011H\u0007\u001a\u0015\u0010&\u001a\u00020#*\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\b\u001a\u0015\u0010&\u001a\u00020#*\u00020\u00022\u0006\u0010'\u001a\u00020(H\b\u001a\n\u0010)\u001a\u00020\u0002*\u00020\u0002\u001a\u0014\u0010)\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0007\u001a\f\u0010*\u001a\u00020\u0002*\u00020\rH\u0007\u001a*\u0010*\u001a\u00020\u0002*\u00020\r2\b\b\u0002\u0010%\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u00112\b\b\u0002\u0010+\u001a\u00020#H\u0007\u001a\f\u0010,\u001a\u00020\r*\u00020\u0002H\u0007\u001a*\u0010,\u001a\u00020\r*\u00020\u00022\b\b\u0002\u0010%\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u00112\b\b\u0002\u0010+\u001a\u00020#H\u0007\u001a\u001c\u0010-\u001a\u00020#*\u00020\u00022\u0006\u0010.\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020#\u001a \u0010/\u001a\u00020#*\u0004\u0018\u00010\u00022\b\u0010!\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\"\u001a\u00020#\u001a2\u00100\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0016\u00101\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\b¢\u0006\u0002\u00104\u001a*\u00100\u001a\u00020\u0002*\u00020\u00022\u0016\u00101\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\b¢\u0006\u0002\u00105\u001a:\u00100\u001a\u00020\u0002*\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u00100\u001a\u00020\u00022\u0016\u00101\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\b¢\u0006\u0002\u00106\u001a2\u00100\u001a\u00020\u0002*\u00020\u00042\u0006\u00100\u001a\u00020\u00022\u0016\u00101\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\b¢\u0006\u0002\u00107\u001a\r\u00108\u001a\u00020\u0002*\u00020\u0002H\b\u001a\n\u00109\u001a\u00020#*\u00020(\u001a\u001d\u0010:\u001a\u00020\u0011*\u00020\u00022\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u0011H\b\u001a\u001d\u0010:\u001a\u00020\u0011*\u00020\u00022\u0006\u0010>\u001a\u00020\u00022\u0006\u0010=\u001a\u00020\u0011H\b\u001a\u001d\u0010?\u001a\u00020\u0011*\u00020\u00022\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u0011H\b\u001a\u001d\u0010?\u001a\u00020\u0011*\u00020\u00022\u0006\u0010>\u001a\u00020\u00022\u0006\u0010=\u001a\u00020\u0011H\b\u001a\u001d\u0010@\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010A\u001a\u00020\u0011H\b\u001a4\u0010B\u001a\u00020#*\u00020(2\u0006\u0010C\u001a\u00020\u00112\u0006\u0010!\u001a\u00020(2\u0006\u0010D\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\"\u001a\u00020#\u001a4\u0010B\u001a\u00020#*\u00020\u00022\u0006\u0010C\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u00022\u0006\u0010D\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\"\u001a\u00020#\u001a\u0012\u0010E\u001a\u00020\u0002*\u00020(2\u0006\u0010F\u001a\u00020\u0011\u001a$\u0010G\u001a\u00020\u0002*\u00020\u00022\u0006\u0010H\u001a\u00020<2\u0006\u0010I\u001a\u00020<2\b\b\u0002\u0010\"\u001a\u00020#\u001a$\u0010G\u001a\u00020\u0002*\u00020\u00022\u0006\u0010J\u001a\u00020\u00022\u0006\u0010K\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020#\u001a$\u0010L\u001a\u00020\u0002*\u00020\u00022\u0006\u0010H\u001a\u00020<2\u0006\u0010I\u001a\u00020<2\b\b\u0002\u0010\"\u001a\u00020#\u001a$\u0010L\u001a\u00020\u0002*\u00020\u00022\u0006\u0010J\u001a\u00020\u00022\u0006\u0010K\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020#\u001a\"\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00020N*\u00020(2\u0006\u0010O\u001a\u00020P2\b\b\u0002\u0010Q\u001a\u00020\u0011\u001a\u001c\u0010R\u001a\u00020#*\u00020\u00022\u0006\u0010S\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020#\u001a$\u0010R\u001a\u00020#*\u00020\u00022\u0006\u0010S\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u00112\b\b\u0002\u0010\"\u001a\u00020#\u001a\u0015\u0010T\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0011H\b\u001a\u001d\u0010T\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u0011H\b\u001a\u0017\u0010U\u001a\u00020\r*\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\b\u001a\r\u0010V\u001a\u00020\u0014*\u00020\u0002H\b\u001a3\u0010V\u001a\u00020\u0014*\u00020\u00022\u0006\u0010W\u001a\u00020\u00142\b\b\u0002\u0010X\u001a\u00020\u00112\b\b\u0002\u0010%\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u0011H\b\u001a \u0010V\u001a\u00020\u0014*\u00020\u00022\b\b\u0002\u0010%\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u0011H\u0007\u001a\r\u0010Y\u001a\u00020\u0002*\u00020\u0002H\b\u001a\u0015\u0010Y\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\b\u001a\u0017\u0010Z\u001a\u00020P*\u00020\u00022\b\b\u0002\u0010[\u001a\u00020\u0011H\b\u001a\r\u0010\\\u001a\u00020\u0002*\u00020\u0002H\b\u001a\u0015\u0010\\\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\b\"%\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006]"}, mo1538e = {"CASE_INSENSITIVE_ORDER", "Ljava/util/Comparator;", "", "Lkotlin/Comparator;", "Lkotlin/String$Companion;", "getCASE_INSENSITIVE_ORDER", "(Lkotlin/jvm/internal/StringCompanionObject;)Ljava/util/Comparator;", "String", "stringBuffer", "Ljava/lang/StringBuffer;", "stringBuilder", "Ljava/lang/StringBuilder;", "bytes", "", "charset", "Ljava/nio/charset/Charset;", "offset", "", "length", "chars", "", "codePoints", "", "capitalize", "locale", "Ljava/util/Locale;", "codePointAt", "index", "codePointBefore", "codePointCount", "beginIndex", "endIndex", "compareTo", "other", "ignoreCase", "", "concatToString", "startIndex", "contentEquals", "charSequence", "", "decapitalize", "decodeToString", "throwOnInvalidSequence", "encodeToByteArray", "endsWith", "suffix", "equals", "format", "args", "", "", "(Ljava/lang/String;Ljava/util/Locale;[Ljava/lang/Object;)Ljava/lang/String;", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "(Lkotlin/jvm/internal/StringCompanionObject;Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "(Lkotlin/jvm/internal/StringCompanionObject;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "intern", "isBlank", "nativeIndexOf", "ch", "", "fromIndex", "str", "nativeLastIndexOf", "offsetByCodePoints", "codePointOffset", "regionMatches", "thisOffset", "otherOffset", "repeat", "n", "replace", "oldChar", "newChar", "oldValue", "newValue", "replaceFirst", "split", "", "regex", "Ljava/util/regex/Pattern;", "limit", "startsWith", "prefix", "substring", "toByteArray", "toCharArray", "destination", "destinationOffset", "toLowerCase", "toPattern", "flags", "toUpperCase", "kotlin-stdlib"}, mo1539f = "kotlin/text/StringsKt", mo1541h = 1)
class bon extends bom {
    /* renamed from: a */
    private static final int m8000a(String str, char c, int i) {
        if (str != null) {
            return str.indexOf(c, i);
        }
        throw new apx("null cannot be cast to non-null type java.lang.String");
    }

    /* renamed from: a */
    private static final int m8001a(String str, String str2, int i) {
        if (str != null) {
            return str.indexOf(str2, i);
        }
        throw new apx("null cannot be cast to non-null type java.lang.String");
    }

    /* renamed from: b */
    private static final int m8046b(String str, char c, int i) {
        if (str != null) {
            return str.lastIndexOf(c, i);
        }
        throw new apx("null cannot be cast to non-null type java.lang.String");
    }

    /* renamed from: b */
    private static final int m8047b(String str, String str2, int i) {
        if (str != null) {
            return str.lastIndexOf(str2, i);
        }
        throw new apx("null cannot be cast to non-null type java.lang.String");
    }

    /* renamed from: a */
    public static /* synthetic */ boolean m8036a(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return boc.m8035a(str, str2, z);
    }

    /* renamed from: a */
    public static final boolean m8035a(String str, String str2, boolean z) {
        if (str == null) {
            return str2 == null;
        }
        if (!z) {
            return str.equals(str2);
        }
        return str.equalsIgnoreCase(str2);
    }

    /* renamed from: a */
    public static /* synthetic */ String m8006a(String str, char c, char c2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return boc.m8005a(str, c, c2, z);
    }

    /* renamed from: a */
    public static final String m8005a(String str, char c, char c2, boolean z) {
        String str2 = str;
        bfq.m6567f(str2, "$this$replace");
        if (!z) {
            String replace = str.replace(c, c2);
            bfq.m6554b(replace, "(this as java.lang.Strin…replace(oldChar, newChar)");
            return replace;
        }
        return bkx.m7535a(boc.m8093a((CharSequence) str2, new char[]{c}, z, 0, 4, (Object) null), String.valueOf(c2), (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (bdl) null, 62, (Object) null);
    }

    /* renamed from: a */
    public static /* synthetic */ String m8008a(String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return boc.m8007a(str, str2, str3, z);
    }

    /* renamed from: a */
    public static final String m8007a(String str, String str2, String str3, boolean z) {
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        bfq.m6567f(str4, "$this$replace");
        bfq.m6567f(str5, "oldValue");
        bfq.m6567f(str6, "newValue");
        return bkx.m7535a(boc.m8097a((CharSequence) str4, new String[]{str5}, z, 0, 4, (Object) null), str6, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (bdl) null, 62, (Object) null);
    }

    /* renamed from: b */
    public static /* synthetic */ String m8049b(String str, char c, char c2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return boc.m8048b(str, c, c2, z);
    }

    /* renamed from: b */
    public static final String m8048b(String str, char c, char c2, boolean z) {
        bfq.m6567f(str, "$this$replaceFirst");
        CharSequence charSequence = str;
        int a = boc.m8080a(charSequence, c, 0, z, 2, (Object) null);
        return a < 0 ? str : boc.m8101a(charSequence, a, a + 1, (CharSequence) String.valueOf(c2)).toString();
    }

    /* renamed from: b */
    public static /* synthetic */ String m8052b(String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return boc.m8051b(str, str2, str3, z);
    }

    /* renamed from: b */
    public static final String m8051b(String str, String str2, String str3, boolean z) {
        bfq.m6567f(str, "$this$replaceFirst");
        bfq.m6567f(str2, "oldValue");
        bfq.m6567f(str3, "newValue");
        CharSequence charSequence = str;
        int a = boc.m8084a(charSequence, str2, 0, z, 2, (Object) null);
        return a < 0 ? str : boc.m8101a(charSequence, a, str2.length() + a, (CharSequence) str3).toString();
    }

    /* renamed from: n */
    private static final String m8075n(String str) {
        if (str != null) {
            String upperCase = str.toUpperCase();
            bfq.m6554b(upperCase, "(this as java.lang.String).toUpperCase()");
            return upperCase;
        }
        throw new apx("null cannot be cast to non-null type java.lang.String");
    }

    /* renamed from: o */
    private static final String m8076o(String str) {
        if (str != null) {
            String lowerCase = str.toLowerCase();
            bfq.m6554b(lowerCase, "(this as java.lang.String).toLowerCase()");
            return lowerCase;
        }
        throw new apx("null cannot be cast to non-null type java.lang.String");
    }

    /* renamed from: a */
    public static final String m8019a(char[] cArr) {
        bfq.m6567f(cArr, "$this$concatToString");
        return new String(cArr);
    }

    /* renamed from: a */
    public static /* synthetic */ String m8021a(char[] cArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = cArr.length;
        }
        return boc.m8020a(cArr, i, i2);
    }

    /* renamed from: a */
    public static final String m8020a(char[] cArr, int i, int i2) {
        bfq.m6567f(cArr, "$this$concatToString");
        ari.f2206a.mo1734b(i, i2, cArr.length);
        return new String(cArr, i, i2 - i);
    }

    /* renamed from: a */
    public static /* synthetic */ char[] m8043a(String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        return boc.m8042a(str, i, i2);
    }

    /* renamed from: a */
    public static final char[] m8042a(String str, int i, int i2) {
        bfq.m6567f(str, "$this$toCharArray");
        ari.f2206a.mo1734b(i, i2, str.length());
        char[] cArr = new char[(i2 - i)];
        str.getChars(i, i2, cArr, 0);
        return cArr;
    }

    /* renamed from: a */
    public static final String m8013a(byte[] bArr) {
        bfq.m6567f(bArr, "$this$decodeToString");
        return new String(bArr, bnh.f2996a);
    }

    /* renamed from: a */
    public static /* synthetic */ String m8017a(byte[] bArr, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = bArr.length;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return boc.m8016a(bArr, i, i2, z);
    }

    /* renamed from: a */
    public static final String m8016a(byte[] bArr, int i, int i2, boolean z) {
        bfq.m6567f(bArr, "$this$decodeToString");
        ari.f2206a.mo1734b(i, i2, bArr.length);
        if (!z) {
            return new String(bArr, i, i2 - i, bnh.f2996a);
        }
        String charBuffer = bnh.f2996a.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).decode(ByteBuffer.wrap(bArr, i, i2 - i)).toString();
        bfq.m6554b(charBuffer, "decoder.decode(ByteBuffe…- startIndex)).toString()");
        return charBuffer;
    }

    /* renamed from: k */
    public static final byte[] m8072k(String str) {
        bfq.m6567f(str, "$this$encodeToByteArray");
        byte[] bytes = str.getBytes(bnh.f2996a);
        bfq.m6554b(bytes, "(this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    /* renamed from: a */
    public static /* synthetic */ byte[] m8039a(String str, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return boc.m8038a(str, i, i2, z);
    }

    /* renamed from: a */
    public static final byte[] m8038a(String str, int i, int i2, boolean z) {
        bfq.m6567f(str, "$this$encodeToByteArray");
        ari.f2206a.mo1734b(i, i2, str.length());
        if (!z) {
            String substring = str.substring(i, i2);
            bfq.m6554b(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            Charset charset = bnh.f2996a;
            if (substring != null) {
                byte[] bytes = substring.getBytes(charset);
                bfq.m6554b(bytes, "(this as java.lang.String).getBytes(charset)");
                return bytes;
            }
            throw new apx("null cannot be cast to non-null type java.lang.String");
        }
        ByteBuffer encode = bnh.f2996a.newEncoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).encode(CharBuffer.wrap(str, i, i2));
        if (encode.hasArray() && encode.arrayOffset() == 0) {
            int remaining = encode.remaining();
            byte[] array = encode.array();
            if (array == null) {
                bfq.m6538a();
            }
            if (remaining == array.length) {
                byte[] array2 = encode.array();
                bfq.m6554b(array2, "byteBuffer.array()");
                return array2;
            }
        }
        byte[] bArr = new byte[encode.remaining()];
        encode.get(bArr);
        return bArr;
    }

    /* renamed from: p */
    private static final char[] m8077p(String str) {
        if (str != null) {
            char[] charArray = str.toCharArray();
            bfq.m6554b(charArray, "(this as java.lang.String).toCharArray()");
            return charArray;
        }
        throw new apx("null cannot be cast to non-null type java.lang.String");
    }

    /* renamed from: a */
    static /* synthetic */ char[] m8045a(String str, char[] cArr, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = str.length();
        }
        if (str != null) {
            str.getChars(i2, i3, cArr, i);
            return cArr;
        }
        throw new apx("null cannot be cast to non-null type java.lang.String");
    }

    /* renamed from: a */
    private static final char[] m8044a(String str, char[] cArr, int i, int i2, int i3) {
        if (str != null) {
            str.getChars(i2, i3, cArr, i);
            return cArr;
        }
        throw new apx("null cannot be cast to non-null type java.lang.String");
    }

    /* renamed from: a */
    private static final String m8011a(String str, Object... objArr) {
        String format = String.format(str, Arrays.copyOf(objArr, objArr.length));
        bfq.m6554b(format, "java.lang.String.format(this, *args)");
        return format;
    }

    /* renamed from: a */
    private static final String m8002a(bgu bgu, String str, Object... objArr) {
        String format = String.format(str, Arrays.copyOf(objArr, objArr.length));
        bfq.m6554b(format, "java.lang.String.format(format, *args)");
        return format;
    }

    /* renamed from: a */
    private static final String m8010a(String str, Locale locale, Object... objArr) {
        String format = String.format(locale, str, Arrays.copyOf(objArr, objArr.length));
        bfq.m6554b(format, "java.lang.String.format(locale, this, *args)");
        return format;
    }

    /* renamed from: a */
    private static final String m8003a(bgu bgu, Locale locale, String str, Object... objArr) {
        String format = String.format(locale, str, Arrays.copyOf(objArr, objArr.length));
        bfq.m6554b(format, "java.lang.String.format(locale, format, *args)");
        return format;
    }

    /* renamed from: a */
    public static /* synthetic */ List m8025a(CharSequence charSequence, Pattern pattern, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return boc.m8024a(charSequence, pattern, i);
    }

    /* renamed from: a */
    public static final List<String> m8024a(CharSequence charSequence, Pattern pattern, int i) {
        bfq.m6567f(charSequence, "$this$split");
        bfq.m6567f(pattern, "regex");
        if (i >= 0) {
            if (i == 0) {
                i = -1;
            }
            String[] split = pattern.split(charSequence, i);
            bfq.m6554b(split, "regex.split(this, if (limit == 0) -1 else limit)");
            return arv.m3276d((T[]) split);
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i + '.').toString());
    }

    /* renamed from: f */
    private static final String m8068f(String str, int i) {
        if (str != null) {
            String substring = str.substring(i);
            bfq.m6554b(substring, "(this as java.lang.String).substring(startIndex)");
            return substring;
        }
        throw new apx("null cannot be cast to non-null type java.lang.String");
    }

    /* renamed from: b */
    private static final String m8050b(String str, int i, int i2) {
        if (str != null) {
            String substring = str.substring(i, i2);
            bfq.m6554b(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }
        throw new apx("null cannot be cast to non-null type java.lang.String");
    }

    /* renamed from: b */
    public static /* synthetic */ boolean m8058b(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return boc.m8057b(str, str2, z);
    }

    /* renamed from: b */
    public static final boolean m8057b(String str, String str2, boolean z) {
        bfq.m6567f(str, "$this$startsWith");
        bfq.m6567f(str2, "prefix");
        if (!z) {
            return str.startsWith(str2);
        }
        return boc.m8030a(str, 0, str2, 0, str2.length(), z);
    }

    /* renamed from: a */
    public static /* synthetic */ boolean m8034a(String str, String str2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return boc.m8033a(str, str2, i, z);
    }

    /* renamed from: a */
    public static final boolean m8033a(String str, String str2, int i, boolean z) {
        bfq.m6567f(str, "$this$startsWith");
        bfq.m6567f(str2, "prefix");
        if (!z) {
            return str.startsWith(str2, i);
        }
        return boc.m8030a(str, i, str2, 0, str2.length(), z);
    }

    /* renamed from: c */
    public static /* synthetic */ boolean m8063c(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return boc.m8062c(str, str2, z);
    }

    /* renamed from: c */
    public static final boolean m8062c(String str, String str2, boolean z) {
        bfq.m6567f(str, "$this$endsWith");
        bfq.m6567f(str2, "suffix");
        if (!z) {
            return str.endsWith(str2);
        }
        return boc.m8030a(str, str.length() - str2.length(), str2, 0, str2.length(), true);
    }

    /* renamed from: a */
    private static final String m8015a(byte[] bArr, int i, int i2, Charset charset) {
        return new String(bArr, i, i2, charset);
    }

    /* renamed from: a */
    private static final String m8018a(byte[] bArr, Charset charset) {
        return new String(bArr, charset);
    }

    /* renamed from: a */
    private static final String m8014a(byte[] bArr, int i, int i2) {
        return new String(bArr, i, i2, bnh.f2996a);
    }

    /* renamed from: b */
    private static final String m8054b(byte[] bArr) {
        return new String(bArr, bnh.f2996a);
    }

    /* renamed from: b */
    private static final String m8055b(char[] cArr) {
        return new String(cArr);
    }

    /* renamed from: b */
    private static final String m8056b(char[] cArr, int i, int i2) {
        return new String(cArr, i, i2);
    }

    /* renamed from: a */
    private static final String m8022a(int[] iArr, int i, int i2) {
        return new String(iArr, i, i2);
    }

    /* renamed from: a */
    private static final String m8012a(StringBuffer stringBuffer) {
        return new String(stringBuffer);
    }

    /* renamed from: c */
    private static final String m8061c(StringBuilder sb) {
        return new String(sb);
    }

    /* renamed from: g */
    private static final int m8069g(String str, int i) {
        if (str != null) {
            return str.codePointAt(i);
        }
        throw new apx("null cannot be cast to non-null type java.lang.String");
    }

    /* renamed from: h */
    private static final int m8070h(String str, int i) {
        if (str != null) {
            return str.codePointBefore(i);
        }
        throw new apx("null cannot be cast to non-null type java.lang.String");
    }

    /* renamed from: c */
    private static final int m8059c(String str, int i, int i2) {
        if (str != null) {
            return str.codePointCount(i, i2);
        }
        throw new apx("null cannot be cast to non-null type java.lang.String");
    }

    /* renamed from: d */
    public static /* synthetic */ int m8066d(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return boc.m8065d(str, str2, z);
    }

    /* renamed from: d */
    public static final int m8065d(String str, String str2, boolean z) {
        bfq.m6567f(str, "$this$compareTo");
        bfq.m6567f(str2, "other");
        if (z) {
            return str.compareToIgnoreCase(str2);
        }
        return str.compareTo(str2);
    }

    /* renamed from: a */
    private static final boolean m8032a(String str, CharSequence charSequence) {
        if (str != null) {
            return str.contentEquals(charSequence);
        }
        throw new apx("null cannot be cast to non-null type java.lang.String");
    }

    /* renamed from: a */
    private static final boolean m8037a(String str, StringBuffer stringBuffer) {
        if (str != null) {
            return str.contentEquals(stringBuffer);
        }
        throw new apx("null cannot be cast to non-null type java.lang.String");
    }

    /* renamed from: q */
    private static final String m8078q(String str) {
        if (str != null) {
            String intern = str.intern();
            bfq.m6554b(intern, "(this as java.lang.String).intern()");
            return intern;
        }
        throw new apx("null cannot be cast to non-null type java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean m8027a(java.lang.CharSequence r4) {
        /*
            java.lang.String r0 = "$this$isBlank"
            atakplugin.UASTool.bfq.m6567f(r4, r0)
            int r0 = r4.length()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0040
            atakplugin.UASTool.biq r0 = atakplugin.UASTool.boc.m8223f(r4)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r3 = r0 instanceof java.util.Collection
            if (r3 == 0) goto L_0x0022
            r3 = r0
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x0022
        L_0x0020:
            r4 = 1
            goto L_0x003e
        L_0x0022:
            java.util.Iterator r0 = r0.iterator()
        L_0x0026:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0020
            r3 = r0
            atakplugin.UASTool.aut r3 = (atakplugin.UASTool.aut) r3
            int r3 = r3.mo2004b()
            char r3 = r4.charAt(r3)
            boolean r3 = atakplugin.UASTool.bne.m7731a((char) r3)
            if (r3 != 0) goto L_0x0026
            r4 = 0
        L_0x003e:
            if (r4 == 0) goto L_0x0041
        L_0x0040:
            r1 = 1
        L_0x0041:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.bon.m8027a(java.lang.CharSequence):boolean");
    }

    /* renamed from: d */
    private static final int m8064d(String str, int i, int i2) {
        if (str != null) {
            return str.offsetByCodePoints(i, i2);
        }
        throw new apx("null cannot be cast to non-null type java.lang.String");
    }

    /* renamed from: a */
    public static /* synthetic */ boolean m8029a(CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3, boolean z, int i4, Object obj) {
        return boc.m8028a(charSequence, i, charSequence2, i2, i3, (i4 & 16) != 0 ? false : z);
    }

    /* renamed from: a */
    public static final boolean m8028a(CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3, boolean z) {
        bfq.m6567f(charSequence, "$this$regionMatches");
        bfq.m6567f(charSequence2, "other");
        if (!(charSequence instanceof String) || !(charSequence2 instanceof String)) {
            return boc.m8178b(charSequence, i, charSequence2, i2, i3, z);
        }
        return boc.m8030a((String) charSequence, i, (String) charSequence2, i2, i3, z);
    }

    /* renamed from: a */
    public static /* synthetic */ boolean m8031a(String str, int i, String str2, int i2, int i3, boolean z, int i4, Object obj) {
        return boc.m8030a(str, i, str2, i2, i3, (i4 & 16) != 0 ? false : z);
    }

    /* renamed from: a */
    public static final boolean m8030a(String str, int i, String str2, int i2, int i3, boolean z) {
        bfq.m6567f(str, "$this$regionMatches");
        bfq.m6567f(str2, "other");
        if (!z) {
            return str.regionMatches(i, str2, i2, i3);
        }
        return str.regionMatches(z, i, str2, i2, i3);
    }

    /* renamed from: c */
    private static final String m8060c(String str, Locale locale) {
        if (str != null) {
            String lowerCase = str.toLowerCase(locale);
            bfq.m6554b(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            return lowerCase;
        }
        throw new apx("null cannot be cast to non-null type java.lang.String");
    }

    /* renamed from: d */
    private static final String m8067d(String str, Locale locale) {
        if (str != null) {
            String upperCase = str.toUpperCase(locale);
            bfq.m6554b(upperCase, "(this as java.lang.String).toUpperCase(locale)");
            return upperCase;
        }
        throw new apx("null cannot be cast to non-null type java.lang.String");
    }

    /* renamed from: a */
    private static final byte[] m8040a(String str, Charset charset) {
        if (str != null) {
            byte[] bytes = str.getBytes(charset);
            bfq.m6554b(bytes, "(this as java.lang.String).getBytes(charset)");
            return bytes;
        }
        throw new apx("null cannot be cast to non-null type java.lang.String");
    }

    /* renamed from: a */
    static /* synthetic */ byte[] m8041a(String str, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = bnh.f2996a;
        }
        if (str != null) {
            byte[] bytes = str.getBytes(charset);
            bfq.m6554b(bytes, "(this as java.lang.String).getBytes(charset)");
            return bytes;
        }
        throw new apx("null cannot be cast to non-null type java.lang.String");
    }

    /* renamed from: i */
    private static final Pattern m8071i(String str, int i) {
        Pattern compile = Pattern.compile(str, i);
        bfq.m6554b(compile, "java.util.regex.Pattern.compile(this, flags)");
        return compile;
    }

    /* renamed from: l */
    public static final String m8073l(String str) {
        bfq.m6567f(str, "$this$capitalize");
        if (!(str.length() > 0) || !Character.isLowerCase(str.charAt(0))) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        String substring = str.substring(0, 1);
        bfq.m6554b(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        if (substring != null) {
            String upperCase = substring.toUpperCase();
            bfq.m6554b(upperCase, "(this as java.lang.String).toUpperCase()");
            sb.append(upperCase);
            String substring2 = str.substring(1);
            bfq.m6554b(substring2, "(this as java.lang.String).substring(startIndex)");
            sb.append(substring2);
            return sb.toString();
        }
        throw new apx("null cannot be cast to non-null type java.lang.String");
    }

    /* renamed from: a */
    public static final String m8009a(String str, Locale locale) {
        bfq.m6567f(str, "$this$capitalize");
        bfq.m6567f(locale, "locale");
        if (str.length() > 0) {
            char charAt = str.charAt(0);
            if (Character.isLowerCase(charAt)) {
                StringBuilder sb = new StringBuilder();
                char titleCase = Character.toTitleCase(charAt);
                if (titleCase != Character.toUpperCase(charAt)) {
                    sb.append(titleCase);
                } else {
                    String substring = str.substring(0, 1);
                    bfq.m6554b(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    if (substring != null) {
                        String upperCase = substring.toUpperCase(locale);
                        bfq.m6554b(upperCase, "(this as java.lang.String).toUpperCase(locale)");
                        sb.append(upperCase);
                    } else {
                        throw new apx("null cannot be cast to non-null type java.lang.String");
                    }
                }
                String substring2 = str.substring(1);
                bfq.m6554b(substring2, "(this as java.lang.String).substring(startIndex)");
                sb.append(substring2);
                String sb2 = sb.toString();
                bfq.m6554b(sb2, "StringBuilder().apply(builderAction).toString()");
                return sb2;
            }
        }
        return str;
    }

    /* renamed from: m */
    public static final String m8074m(String str) {
        bfq.m6567f(str, "$this$decapitalize");
        if (!(str.length() > 0) || !Character.isUpperCase(str.charAt(0))) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        String substring = str.substring(0, 1);
        bfq.m6554b(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        if (substring != null) {
            String lowerCase = substring.toLowerCase();
            bfq.m6554b(lowerCase, "(this as java.lang.String).toLowerCase()");
            sb.append(lowerCase);
            String substring2 = str.substring(1);
            bfq.m6554b(substring2, "(this as java.lang.String).substring(startIndex)");
            sb.append(substring2);
            return sb.toString();
        }
        throw new apx("null cannot be cast to non-null type java.lang.String");
    }

    /* renamed from: b */
    public static final String m8053b(String str, Locale locale) {
        bfq.m6567f(str, "$this$decapitalize");
        bfq.m6567f(locale, "locale");
        if (!(str.length() > 0) || Character.isLowerCase(str.charAt(0))) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        String substring = str.substring(0, 1);
        bfq.m6554b(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        if (substring != null) {
            String lowerCase = substring.toLowerCase(locale);
            bfq.m6554b(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            sb.append(lowerCase);
            String substring2 = str.substring(1);
            bfq.m6554b(substring2, "(this as java.lang.String).substring(startIndex)");
            sb.append(substring2);
            return sb.toString();
        }
        throw new apx("null cannot be cast to non-null type java.lang.String");
    }

    /* renamed from: a */
    public static final String m8004a(CharSequence charSequence, int i) {
        bfq.m6567f(charSequence, "$this$repeat");
        int i2 = 1;
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i + '.').toString());
        } else if (i == 0) {
            return "";
        } else {
            if (i == 1) {
                return charSequence.toString();
            }
            int length = charSequence.length();
            if (length == 0) {
                return "";
            }
            if (length != 1) {
                StringBuilder sb = new StringBuilder(charSequence.length() * i);
                if (1 <= i) {
                    while (true) {
                        sb.append(charSequence);
                        if (i2 == i) {
                            break;
                        }
                        i2++;
                    }
                }
                String sb2 = sb.toString();
                bfq.m6554b(sb2, "sb.toString()");
                return sb2;
            }
            char charAt = charSequence.charAt(0);
            char[] cArr = new char[i];
            for (int i3 = 0; i3 < i; i3++) {
                cArr[i3] = charAt;
            }
            return new String(cArr);
        }
    }

    /* renamed from: a */
    public static final Comparator<String> m8023a(bgu bgu) {
        bfq.m6567f(bgu, "$this$CASE_INSENSITIVE_ORDER");
        Comparator<String> comparator = String.CASE_INSENSITIVE_ORDER;
        bfq.m6554b(comparator, "java.lang.String.CASE_INSENSITIVE_ORDER");
        return comparator;
    }

    /* renamed from: a */
    static /* synthetic */ Pattern m8026a(String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Pattern compile = Pattern.compile(str, i);
        bfq.m6554b(compile, "java.util.regex.Pattern.compile(this, flags)");
        return compile;
    }
}

package atakplugin.UASTool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@aot(mo1534a = 5, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000H\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a1\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0003H\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a!\u0010\u0007\u001a\u00020\b\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0003H\u0001¢\u0006\u0004\b\t\u0010\n\u001a?\u0010\u000b\u001a\u00020\f\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\n\u0010\r\u001a\u00060\u000ej\u0002`\u000f2\u0010\u0010\u0010\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013\u001a+\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0015\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00030\u0003¢\u0006\u0002\u0010\u0016\u001a8\u0010\u0017\u001a\u0002H\u0018\"\u0010\b\u0000\u0010\u0019*\u0006\u0012\u0002\b\u00030\u0003*\u0002H\u0018\"\u0004\b\u0001\u0010\u0018*\u0002H\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001bH\b¢\u0006\u0002\u0010\u001c\u001a)\u0010\u001d\u001a\u00020\u0001*\b\u0012\u0002\b\u0003\u0018\u00010\u0003H\b\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000¢\u0006\u0002\u0010\u001e\u001aG\u0010\u001f\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00180\u00150 \"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0018*\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00180 0\u0003¢\u0006\u0002\u0010!¨\u0006\""}, mo1538e = {"contentDeepEqualsImpl", "", "T", "", "other", "contentDeepEquals", "([Ljava/lang/Object;[Ljava/lang/Object;)Z", "contentDeepToStringImpl", "", "contentDeepToString", "([Ljava/lang/Object;)Ljava/lang/String;", "contentDeepToStringInternal", "", "result", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "processed", "", "contentDeepToStringInternal$ArraysKt__ArraysKt", "([Ljava/lang/Object;Ljava/lang/StringBuilder;Ljava/util/List;)V", "flatten", "", "([[Ljava/lang/Object;)Ljava/util/List;", "ifEmpty", "R", "C", "defaultValue", "Lkotlin/Function0;", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isNullOrEmpty", "([Ljava/lang/Object;)Z", "unzip", "Lkotlin/Pair;", "([Lkotlin/Pair;)Lkotlin/Pair;", "kotlin-stdlib"}, mo1539f = "kotlin/collections/ArraysKt", mo1541h = 1)
class arx extends arw {
    /* renamed from: a */
    public static final <T> List<T> m3095a(T[][] tArr) {
        bfq.m6567f(tArr, "$this$flatten");
        int i = 0;
        for (Object obj : (Object[]) tArr) {
            i += ((Object[]) obj).length;
        }
        ArrayList arrayList = new ArrayList(i);
        for (T[] a : tArr) {
            ato.m4655a(arrayList, a);
        }
        return arrayList;
    }

    /* renamed from: a */
    public static final <T, R> apc<List<T>, List<R>> m3093a(apc<? extends T, ? extends R>[] apcArr) {
        bfq.m6567f(apcArr, "$this$unzip");
        ArrayList arrayList = new ArrayList(apcArr.length);
        ArrayList arrayList2 = new ArrayList(apcArr.length);
        for (apc<? extends T, ? extends R> apc : apcArr) {
            arrayList.add(apc.mo1544a());
            arrayList2.add(apc.mo1545b());
        }
        return apv.m2659a(arrayList, arrayList2);
    }

    /* renamed from: d */
    private static final boolean m3099d(Object[] objArr) {
        if (objArr != null) {
            return objArr.length == 0;
        }
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [R, C] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final <C extends java.lang.Object & R, R> R m3094a(C r1, atakplugin.UASTool.bdk<? extends R> r2) {
        /*
            int r0 = r1.length
            if (r0 != 0) goto L_0x0005
            r0 = 1
            goto L_0x0006
        L_0x0005:
            r0 = 0
        L_0x0006:
            if (r0 == 0) goto L_0x000c
            java.lang.Object r1 = r2.invoke()
        L_0x000c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.arx.m3094a(java.lang.Object[], atakplugin.UASTool.bdk):java.lang.Object");
    }

    /* renamed from: a */
    public static final <T> boolean m3097a(T[] tArr, T[] tArr2) {
        bfq.m6567f(tArr, "$this$contentDeepEqualsImpl");
        bfq.m6567f(tArr2, "other");
        if (tArr == tArr2) {
            return true;
        }
        if (tArr.length != tArr2.length) {
            return false;
        }
        int length = tArr.length;
        for (int i = 0; i < length; i++) {
            T t = tArr[i];
            T t2 = tArr2[i];
            if (t != t2) {
                if (t == null || t2 == null) {
                    return false;
                }
                if (!(t instanceof Object[]) || !(t2 instanceof Object[])) {
                    if (!(t instanceof byte[]) || !(t2 instanceof byte[])) {
                        if (!(t instanceof short[]) || !(t2 instanceof short[])) {
                            if (!(t instanceof int[]) || !(t2 instanceof int[])) {
                                if (!(t instanceof long[]) || !(t2 instanceof long[])) {
                                    if (!(t instanceof float[]) || !(t2 instanceof float[])) {
                                        if (!(t instanceof double[]) || !(t2 instanceof double[])) {
                                            if (!(t instanceof char[]) || !(t2 instanceof char[])) {
                                                if (!(t instanceof boolean[]) || !(t2 instanceof boolean[])) {
                                                    if (!(t instanceof apz) || !(t2 instanceof apz)) {
                                                        if (!(t instanceof aqn) || !(t2 instanceof aqn)) {
                                                            if (!(t instanceof aqd) || !(t2 instanceof aqd)) {
                                                                if (!(t instanceof aqh) || !(t2 instanceof aqh)) {
                                                                    if (!bfq.m6552a((Object) t, (Object) t2)) {
                                                                        return false;
                                                                    }
                                                                } else if (!awc.m5385a(((aqh) t).mo1645d(), ((aqh) t2).mo1645d())) {
                                                                    return false;
                                                                }
                                                            } else if (!awc.m5384a(((aqd) t).mo1617d(), ((aqd) t2).mo1617d())) {
                                                                return false;
                                                            }
                                                        } else if (!awc.m5386a(((aqn) t).mo1673d(), ((aqn) t2).mo1673d())) {
                                                            return false;
                                                        }
                                                    } else if (!awc.m5383a(((apz) t).mo1589d(), ((apz) t2).mo1589d())) {
                                                        return false;
                                                    }
                                                } else if (!Arrays.equals((boolean[]) t, (boolean[]) t2)) {
                                                    return false;
                                                }
                                            } else if (!Arrays.equals((char[]) t, (char[]) t2)) {
                                                return false;
                                            }
                                        } else if (!Arrays.equals((double[]) t, (double[]) t2)) {
                                            return false;
                                        }
                                    } else if (!Arrays.equals((float[]) t, (float[]) t2)) {
                                        return false;
                                    }
                                } else if (!Arrays.equals((long[]) t, (long[]) t2)) {
                                    return false;
                                }
                            } else if (!Arrays.equals((int[]) t, (int[]) t2)) {
                                return false;
                            }
                        } else if (!Arrays.equals((short[]) t, (short[]) t2)) {
                            return false;
                        }
                    } else if (!Arrays.equals((byte[]) t, (byte[]) t2)) {
                        return false;
                    }
                } else if (!arv.m3097a((T[]) (Object[]) t, (T[]) (Object[]) t2)) {
                    return false;
                }
            }
        }
        return true;
    }

    /* renamed from: c */
    public static final <T> String m3098c(T[] tArr) {
        bfq.m6567f(tArr, "$this$contentDeepToStringImpl");
        StringBuilder sb = new StringBuilder((biu.m7191d(tArr.length, 429496729) * 5) + 2);
        m3096a(tArr, sb, new ArrayList());
        String sb2 = sb.toString();
        bfq.m6554b(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* renamed from: a */
    private static final <T> void m3096a(T[] tArr, StringBuilder sb, List<Object[]> list) {
        if (list.contains(tArr)) {
            sb.append("[...]");
            return;
        }
        list.add(tArr);
        sb.append('[');
        int length = tArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                sb.append(", ");
            }
            T t = tArr[i];
            if (t == null) {
                sb.append("null");
            } else if (t instanceof Object[]) {
                m3096a((Object[]) t, sb, list);
            } else if (t instanceof byte[]) {
                String arrays = Arrays.toString((byte[]) t);
                bfq.m6554b(arrays, "java.util.Arrays.toString(this)");
                sb.append(arrays);
            } else if (t instanceof short[]) {
                String arrays2 = Arrays.toString((short[]) t);
                bfq.m6554b(arrays2, "java.util.Arrays.toString(this)");
                sb.append(arrays2);
            } else if (t instanceof int[]) {
                String arrays3 = Arrays.toString((int[]) t);
                bfq.m6554b(arrays3, "java.util.Arrays.toString(this)");
                sb.append(arrays3);
            } else if (t instanceof long[]) {
                String arrays4 = Arrays.toString((long[]) t);
                bfq.m6554b(arrays4, "java.util.Arrays.toString(this)");
                sb.append(arrays4);
            } else if (t instanceof float[]) {
                String arrays5 = Arrays.toString((float[]) t);
                bfq.m6554b(arrays5, "java.util.Arrays.toString(this)");
                sb.append(arrays5);
            } else if (t instanceof double[]) {
                String arrays6 = Arrays.toString((double[]) t);
                bfq.m6554b(arrays6, "java.util.Arrays.toString(this)");
                sb.append(arrays6);
            } else if (t instanceof char[]) {
                String arrays7 = Arrays.toString((char[]) t);
                bfq.m6554b(arrays7, "java.util.Arrays.toString(this)");
                sb.append(arrays7);
            } else if (t instanceof boolean[]) {
                String arrays8 = Arrays.toString((boolean[]) t);
                bfq.m6554b(arrays8, "java.util.Arrays.toString(this)");
                sb.append(arrays8);
            } else if (t instanceof apz) {
                sb.append(awc.m5604l(((apz) t).mo1589d()));
            } else if (t instanceof aqn) {
                sb.append(awc.m5607l(((aqn) t).mo1673d()));
            } else if (t instanceof aqd) {
                sb.append(awc.m5605l(((aqd) t).mo1617d()));
            } else if (t instanceof aqh) {
                sb.append(awc.m5606l(((aqh) t).mo1645d()));
            } else {
                sb.append(t.toString());
            }
        }
        sb.append(']');
        list.remove(ato.m4592a(list));
    }
}

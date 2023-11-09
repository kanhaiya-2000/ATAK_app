package atakplugin.UASTool;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

@aot(mo1534a = 1, mo1535b = {1, 1, 11}, mo1536c = {1, 0, 2}, mo1537d = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0014B\u001f\b\u0002\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0011\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\rH\u0002R\u001e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0005X\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, mo1538e = {"Lokio/Options;", "Ljava/util/AbstractList;", "Lokio/ByteString;", "Ljava/util/RandomAccess;", "byteStrings", "", "trie", "", "([Lokio/ByteString;[I)V", "getByteStrings$jvm", "()[Lokio/ByteString;", "[Lokio/ByteString;", "size", "", "getSize", "()I", "getTrie$jvm", "()[I", "get", "index", "Companion", "jvm"})
public final class bxc extends AbstractList<bwq> implements RandomAccess {

    /* renamed from: a */
    public static final C0281a f4167a = new C0281a((bfd) null);

    /* renamed from: b */
    private final bwq[] f4168b;

    /* renamed from: c */
    private final int[] f4169c;

    @bcz
    /* renamed from: a */
    public static final bxc m10344a(bwq... bwqArr) {
        return f4167a.mo4031a(bwqArr);
    }

    public /* synthetic */ bxc(bwq[] bwqArr, int[] iArr, bfd bfd) {
        this(bwqArr, iArr);
    }

    /* renamed from: a */
    public boolean mo4017a(bwq bwq) {
        return super.contains(bwq);
    }

    /* renamed from: b */
    public int mo4018b(bwq bwq) {
        return super.indexOf(bwq);
    }

    /* renamed from: b */
    public bwq mo4019b(int i) {
        return (bwq) super.remove(i);
    }

    /* renamed from: c */
    public int mo4021c(bwq bwq) {
        return super.lastIndexOf(bwq);
    }

    /* renamed from: c */
    public final bwq mo4022c(int i) {
        return mo4019b(i);
    }

    public final boolean contains(Object obj) {
        if (obj != null ? obj instanceof bwq : true) {
            return mo4017a((bwq) obj);
        }
        return false;
    }

    /* renamed from: d */
    public boolean mo4025d(bwq bwq) {
        return super.remove(bwq);
    }

    public final int indexOf(Object obj) {
        if (obj != null ? obj instanceof bwq : true) {
            return mo4018b((bwq) obj);
        }
        return -1;
    }

    public final int lastIndexOf(Object obj) {
        if (obj != null ? obj instanceof bwq : true) {
            return mo4021c((bwq) obj);
        }
        return -1;
    }

    public final boolean remove(Object obj) {
        if (obj != null ? obj instanceof bwq : true) {
            return mo4025d((bwq) obj);
        }
        return false;
    }

    public final int size() {
        return mo4015a();
    }

    /* renamed from: b */
    public final bwq[] mo4020b() {
        return this.f4168b;
    }

    /* renamed from: c */
    public final int[] mo4023c() {
        return this.f4169c;
    }

    private bxc(bwq[] bwqArr, int[] iArr) {
        this.f4168b = bwqArr;
        this.f4169c = iArr;
    }

    /* renamed from: a */
    public int mo4015a() {
        return this.f4168b.length;
    }

    /* renamed from: a */
    public bwq get(int i) {
        return this.f4168b[i];
    }

    @aot(mo1534a = 1, mo1535b = {1, 1, 11}, mo1536c = {1, 0, 2}, mo1537d = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JT\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH\u0002J!\u0010\u0014\u001a\u00020\u00152\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u0016\"\u00020\u0010H\u0007¢\u0006\u0002\u0010\u0017R\u0018\u0010\u0003\u001a\u00020\u0004*\u00020\u00058BX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, mo1538e = {"Lokio/Options$Companion;", "", "()V", "intCount", "", "Lokio/Buffer;", "getIntCount", "(Lokio/Buffer;)J", "buildTrieRecursive", "", "nodeOffset", "node", "byteStringOffset", "", "byteStrings", "", "Lokio/ByteString;", "fromIndex", "toIndex", "indexes", "of", "Lokio/Options;", "", "([Lokio/ByteString;)Lokio/Options;", "jvm"})
    /* renamed from: atakplugin.UASTool.bxc$a */
    public static final class C0281a {
        private C0281a() {
        }

        public /* synthetic */ C0281a(bfd bfd) {
            this();
        }

        @bcz
        /* renamed from: a */
        public final bxc mo4031a(bwq... bwqArr) {
            bwq[] bwqArr2 = bwqArr;
            bfq.m6567f(bwqArr2, "byteStrings");
            int i = 0;
            if (bwqArr2.length == 0) {
                return new bxc(new bwq[0], new int[]{0, -1}, (bfd) null);
            }
            List u = arv.m4461u((T[]) bwqArr);
            ato.m4643c(u);
            Collection arrayList = new ArrayList(bwqArr2.length);
            for (bwq bwq : bwqArr2) {
                arrayList.add(-1);
            }
            Object[] array = ((List) arrayList).toArray(new Integer[0]);
            if (array != null) {
                Integer[] numArr = (Integer[]) array;
                List c = ato.m4615c((T[]) (Integer[]) Arrays.copyOf(numArr, numArr.length));
                int length = bwqArr2.length;
                int i2 = 0;
                int i3 = 0;
                while (i2 < length) {
                    c.set(ato.m4596a(u, (Comparable) bwqArr2[i2], 0, 0, 6, (Object) null), Integer.valueOf(i3));
                    i2++;
                    i3++;
                }
                if (((bwq) u.get(0)).mo3951n() > 0) {
                    int i4 = 0;
                    while (i4 < u.size()) {
                        bwq bwq2 = (bwq) u.get(i4);
                        int i5 = i4 + 1;
                        int i6 = i5;
                        while (i6 < u.size()) {
                            bwq bwq3 = (bwq) u.get(i6);
                            if (!bwq3.mo3934d(bwq2)) {
                                continue;
                                break;
                            }
                            if (!(bwq3.mo3951n() != bwq2.mo3951n())) {
                                throw new IllegalArgumentException(("duplicate option: " + bwq3).toString());
                            } else if (((Number) c.get(i6)).intValue() > ((Number) c.get(i4)).intValue()) {
                                u.remove(i6);
                                c.remove(i6);
                            } else {
                                i6++;
                            }
                        }
                        i4 = i5;
                    }
                    bwl bwl = new bwl();
                    C0281a aVar = this;
                    m10357a(aVar, 0, bwl, 0, u, 0, 0, c, 53, (Object) null);
                    int[] iArr = new int[((int) aVar.m10355a(bwl))];
                    while (!bwl.mo3854i()) {
                        iArr[i] = bwl.mo3872o();
                        i++;
                    }
                    return new bxc((bwq[]) bwqArr.clone(), iArr, (bfd) null);
                }
                throw new IllegalArgumentException("the empty byte string is not a supported option".toString());
            }
            throw new apx("null cannot be cast to non-null type kotlin.Array<T>");
        }

        /* renamed from: a */
        static /* synthetic */ void m10357a(C0281a aVar, long j, bwl bwl, int i, List list, int i2, int i3, List list2, int i4, Object obj) {
            aVar.m10356a((i4 & 1) != 0 ? 0 : j, bwl, (i4 & 4) != 0 ? 0 : i, list, (i4 & 16) != 0 ? 0 : i2, (i4 & 32) != 0 ? list.size() : i3, list2);
        }

        /* renamed from: a */
        private final void m10356a(long j, bwl bwl, int i, List<? extends bwq> list, int i2, int i3, List<Integer> list2) {
            int i4;
            int i5;
            int i6;
            bwl bwl2;
            int i7;
            bwl bwl3 = bwl;
            int i8 = i;
            List<? extends bwq> list3 = list;
            int i9 = i2;
            int i10 = i3;
            List<Integer> list4 = list2;
            if (i9 < i10) {
                int i11 = i9;
                while (i11 < i10) {
                    if (((bwq) list3.get(i11)).mo3951n() >= i8) {
                        i11++;
                    } else {
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                }
                bwq bwq = (bwq) list.get(i2);
                bwq bwq2 = (bwq) list3.get(i10 - 1);
                if (i8 == bwq.mo3951n()) {
                    int intValue = list4.get(i9).intValue();
                    int i12 = i9 + 1;
                    bwq bwq3 = (bwq) list3.get(i12);
                    i4 = i12;
                    i5 = intValue;
                    bwq = bwq3;
                } else {
                    i4 = i9;
                    i5 = -1;
                }
                if (bwq.mo3931d(i8) != bwq2.mo3931d(i8)) {
                    int i13 = 1;
                    for (int i14 = i4 + 1; i14 < i10; i14++) {
                        if (((bwq) list3.get(i14 - 1)).mo3931d(i8) != ((bwq) list3.get(i14)).mo3931d(i8)) {
                            i13++;
                        }
                    }
                    C0281a aVar = this;
                    long a = j + aVar.m10355a(bwl3) + ((long) 2) + ((long) (i13 * 2));
                    bwl3.mo3857j(i13);
                    bwl3.mo3857j(i5);
                    for (int i15 = i4; i15 < i10; i15++) {
                        byte d = ((bwq) list3.get(i15)).mo3931d(i8);
                        if (i15 == i4 || d != ((bwq) list3.get(i15 - 1)).mo3931d(i8)) {
                            bwl3.mo3857j((int) d & 255);
                        }
                    }
                    bwl bwl4 = new bwl();
                    int i16 = i4;
                    while (i16 < i10) {
                        byte d2 = ((bwq) list3.get(i16)).mo3931d(i8);
                        int i17 = i16 + 1;
                        int i18 = i17;
                        while (true) {
                            if (i18 >= i10) {
                                i6 = i10;
                                break;
                            } else if (d2 != ((bwq) list3.get(i18)).mo3931d(i8)) {
                                i6 = i18;
                                break;
                            } else {
                                i18++;
                            }
                        }
                        if (i17 == i6 && i8 + 1 == ((bwq) list3.get(i16)).mo3951n()) {
                            bwl3.mo3857j(list4.get(i16).intValue());
                            i7 = i6;
                            bwl2 = bwl4;
                        } else {
                            bwl3.mo3857j(((int) (a + aVar.m10355a(bwl4))) * -1);
                            i7 = i6;
                            bwl2 = bwl4;
                            aVar.m10356a(a, bwl4, i8 + 1, list, i16, i6, list2);
                        }
                        i16 = i7;
                        bwl4 = bwl2;
                    }
                    bwl3.mo3789a((bxr) bwl4);
                    return;
                }
                int min = Math.min(bwq.mo3951n(), bwq2.mo3951n());
                int i19 = i8;
                int i20 = 0;
                while (i19 < min && bwq.mo3931d(i19) == bwq2.mo3931d(i19)) {
                    i20++;
                    i19++;
                }
                C0281a aVar2 = this;
                C0281a aVar3 = aVar2;
                long a2 = 1 + j + aVar2.m10355a(bwl3) + ((long) 2) + ((long) i20);
                bwl3.mo3857j(-i20);
                bwl3.mo3857j(i5);
                int i21 = i8 + i20;
                while (i8 < i21) {
                    bwl3.mo3857j((int) bwq.mo3931d(i8) & 255);
                    i8++;
                }
                if (i4 + 1 == i10) {
                    if (i21 == ((bwq) list3.get(i4)).mo3951n()) {
                        bwl3.mo3857j(list4.get(i4).intValue());
                        return;
                    }
                    throw new IllegalStateException("Check failed.".toString());
                }
                bwl bwl5 = new bwl();
                C0281a aVar4 = aVar3;
                bwl3.mo3857j(((int) (aVar4.m10355a(bwl5) + a2)) * -1);
                aVar4.m10356a(a2, bwl5, i21, list, i4, i3, list2);
                bwl3.mo3789a((bxr) bwl5);
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        /* renamed from: a */
        private final long m10355a(bwl bwl) {
            return bwl.mo3783a() / ((long) 4);
        }
    }
}

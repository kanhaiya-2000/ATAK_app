package atakplugin.UASTool;

import java.util.Iterator;
import java.util.List;

@aot(mo1534a = 3, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u0003H@¢\u0006\u0004\b\u0005\u0010\u0006"}, mo1538e = {"<anonymous>", "", "T", "Lkotlin/sequences/SequenceScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
@baj(mo2223b = "SlidingWindow.kt", mo2224c = {34, 40, 49, 55, 58}, mo2225d = {"$this$iterator", "bufferInitialCapacity", "gap", "buffer", "skip", "e", "$this$iterator", "bufferInitialCapacity", "gap", "buffer", "skip", "$this$iterator", "bufferInitialCapacity", "gap", "buffer", "e", "$this$iterator", "bufferInitialCapacity", "gap", "buffer", "$this$iterator", "bufferInitialCapacity", "gap", "buffer"}, mo2226e = {"L$0", "I$0", "I$1", "L$1", "I$2", "L$2", "L$0", "I$0", "I$1", "L$1", "I$2", "L$0", "I$0", "I$1", "L$1", "L$2", "L$0", "I$0", "I$1", "L$1", "L$0", "I$0", "I$1", "L$1"}, mo2227f = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4}, mo2228g = "invokeSuspend", mo2229h = "kotlin.collections.SlidingWindowKt$windowedIterator$1")
final class avq extends bao implements bdw<bkw<? super List<? extends T>>, ayd<? super aqr>, Object> {

    /* renamed from: a */
    Object f2299a;

    /* renamed from: b */
    Object f2300b;

    /* renamed from: c */
    Object f2301c;

    /* renamed from: d */
    Object f2302d;

    /* renamed from: e */
    int f2303e;

    /* renamed from: f */
    int f2304f;

    /* renamed from: g */
    int f2305g;

    /* renamed from: h */
    int f2306h;

    /* renamed from: i */
    final /* synthetic */ int f2307i;

    /* renamed from: j */
    final /* synthetic */ int f2308j;

    /* renamed from: k */
    final /* synthetic */ Iterator f2309k;

    /* renamed from: l */
    final /* synthetic */ boolean f2310l;

    /* renamed from: m */
    final /* synthetic */ boolean f2311m;

    /* renamed from: n */
    private bkw f2312n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    avq(int i, int i2, Iterator it, boolean z, boolean z2, ayd ayd) {
        super(2, ayd);
        this.f2307i = i;
        this.f2308j = i2;
        this.f2309k = it;
        this.f2310l = z;
        this.f2311m = z2;
    }

    /* renamed from: a */
    public final ayd<aqr> mo2063a(Object obj, ayd<?> ayd) {
        bfq.m6567f(ayd, "completion");
        avq avq = new avq(this.f2307i, this.f2308j, this.f2309k, this.f2310l, this.f2311m, ayd);
        avq.f2312n = (bkw) obj;
        return avq;
    }

    /* renamed from: a */
    public final Object mo2065a(Object obj, Object obj2) {
        return ((avq) mo2063a(obj, (ayd<?>) (ayd) obj2)).mo2064a(aqr.f2177a);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00fc A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x015a  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0166  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00d4 A[SYNTHETIC] */
    /* renamed from: a */
    public final java.lang.Object mo2064a(java.lang.Object r15) {
        /*
            r14 = this;
            java.lang.Object r0 = atakplugin.UASTool.azv.m6108b()
            int r1 = r14.f2306h
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            if (r1 == 0) goto L_0x006e
            if (r1 == r6) goto L_0x0059
            if (r1 == r5) goto L_0x004c
            if (r1 == r4) goto L_0x0036
            if (r1 == r3) goto L_0x0024
            if (r1 != r2) goto L_0x001c
            java.lang.Object r0 = r14.f2300b
            atakplugin.UASTool.avi r0 = (atakplugin.UASTool.avi) r0
            goto L_0x0050
        L_0x001c:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L_0x0024:
            java.lang.Object r1 = r14.f2300b
            atakplugin.UASTool.avi r1 = (atakplugin.UASTool.avi) r1
            int r4 = r14.f2304f
            int r5 = r14.f2303e
            java.lang.Object r7 = r14.f2299a
            atakplugin.UASTool.bkw r7 = (atakplugin.UASTool.bkw) r7
            atakplugin.UASTool.apk.m2620a((java.lang.Object) r15)
            r15 = r14
            goto L_0x0189
        L_0x0036:
            java.lang.Object r1 = r14.f2302d
            java.util.Iterator r1 = (java.util.Iterator) r1
            java.lang.Object r5 = r14.f2300b
            atakplugin.UASTool.avi r5 = (atakplugin.UASTool.avi) r5
            int r7 = r14.f2304f
            int r8 = r14.f2303e
            java.lang.Object r9 = r14.f2299a
            atakplugin.UASTool.bkw r9 = (atakplugin.UASTool.bkw) r9
            atakplugin.UASTool.apk.m2620a((java.lang.Object) r15)
            r15 = r14
            goto L_0x0150
        L_0x004c:
            java.lang.Object r0 = r14.f2300b
            java.util.ArrayList r0 = (java.util.ArrayList) r0
        L_0x0050:
            java.lang.Object r0 = r14.f2299a
            atakplugin.UASTool.bkw r0 = (atakplugin.UASTool.bkw) r0
            atakplugin.UASTool.apk.m2620a((java.lang.Object) r15)
            goto L_0x01aa
        L_0x0059:
            java.lang.Object r1 = r14.f2302d
            java.util.Iterator r1 = (java.util.Iterator) r1
            java.lang.Object r2 = r14.f2300b
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            int r3 = r14.f2304f
            int r4 = r14.f2303e
            java.lang.Object r7 = r14.f2299a
            atakplugin.UASTool.bkw r7 = (atakplugin.UASTool.bkw) r7
            atakplugin.UASTool.apk.m2620a((java.lang.Object) r15)
            r8 = r14
            goto L_0x00c1
        L_0x006e:
            atakplugin.UASTool.apk.m2620a((java.lang.Object) r15)
            atakplugin.UASTool.bkw r15 = r14.f2312n
            int r1 = r14.f2307i
            r7 = 1024(0x400, float:1.435E-42)
            int r1 = atakplugin.UASTool.biu.m7191d((int) r1, (int) r7)
            int r7 = r14.f2308j
            int r8 = r14.f2307i
            int r7 = r7 - r8
            if (r7 < 0) goto L_0x00fd
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>(r1)
            r3 = 0
            java.util.Iterator r4 = r14.f2309k
            r8 = r14
            r13 = r4
            r4 = r1
            r1 = r13
        L_0x008e:
            boolean r9 = r1.hasNext()
            if (r9 == 0) goto L_0x00d4
            java.lang.Object r9 = r1.next()
            if (r3 <= 0) goto L_0x009d
            int r3 = r3 + -1
            goto L_0x008e
        L_0x009d:
            r2.add(r9)
            int r10 = r2.size()
            int r11 = r8.f2307i
            if (r10 != r11) goto L_0x008e
            r8.f2299a = r15
            r8.f2303e = r4
            r8.f2304f = r7
            r8.f2300b = r2
            r8.f2305g = r3
            r8.f2301c = r9
            r8.f2302d = r1
            r8.f2306h = r6
            java.lang.Object r3 = r15.mo2727a(r2, (atakplugin.UASTool.ayd<? super atakplugin.UASTool.aqr>) r8)
            if (r3 != r0) goto L_0x00bf
            return r0
        L_0x00bf:
            r3 = r7
            r7 = r15
        L_0x00c1:
            boolean r15 = r8.f2310l
            if (r15 == 0) goto L_0x00c9
            r2.clear()
            goto L_0x00d1
        L_0x00c9:
            java.util.ArrayList r15 = new java.util.ArrayList
            int r2 = r8.f2307i
            r15.<init>(r2)
            r2 = r15
        L_0x00d1:
            r15 = r7
            r7 = r3
            goto L_0x008e
        L_0x00d4:
            r1 = r2
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            r1 = r1 ^ r6
            if (r1 == 0) goto L_0x01aa
            boolean r1 = r8.f2311m
            if (r1 != 0) goto L_0x00ea
            int r1 = r2.size()
            int r6 = r8.f2307i
            if (r1 != r6) goto L_0x01aa
        L_0x00ea:
            r8.f2299a = r15
            r8.f2303e = r4
            r8.f2304f = r7
            r8.f2300b = r2
            r8.f2305g = r3
            r8.f2306h = r5
            java.lang.Object r15 = r15.mo2727a(r2, (atakplugin.UASTool.ayd<? super atakplugin.UASTool.aqr>) r8)
            if (r15 != r0) goto L_0x01aa
            return r0
        L_0x00fd:
            atakplugin.UASTool.avi r5 = new atakplugin.UASTool.avi
            r5.<init>(r1)
            java.util.Iterator r8 = r14.f2309k
            r9 = r15
            r15 = r14
            r13 = r8
            r8 = r1
            r1 = r13
        L_0x0109:
            boolean r10 = r1.hasNext()
            if (r10 == 0) goto L_0x0156
            java.lang.Object r10 = r1.next()
            r5.mo2056a(r10)
            boolean r11 = r5.mo2058b()
            if (r11 == 0) goto L_0x0109
            int r11 = r5.size()
            int r12 = r15.f2307i
            if (r11 >= r12) goto L_0x0129
            atakplugin.UASTool.avi r5 = r5.mo2055a((int) r12)
            goto L_0x0109
        L_0x0129:
            boolean r11 = r15.f2310l
            if (r11 == 0) goto L_0x0131
            r11 = r5
            java.util.List r11 = (java.util.List) r11
            goto L_0x013b
        L_0x0131:
            java.util.ArrayList r11 = new java.util.ArrayList
            r12 = r5
            java.util.Collection r12 = (java.util.Collection) r12
            r11.<init>(r12)
            java.util.List r11 = (java.util.List) r11
        L_0x013b:
            r15.f2299a = r9
            r15.f2303e = r8
            r15.f2304f = r7
            r15.f2300b = r5
            r15.f2301c = r10
            r15.f2302d = r1
            r15.f2306h = r4
            java.lang.Object r10 = r9.mo2727a(r11, (atakplugin.UASTool.ayd<? super atakplugin.UASTool.aqr>) r15)
            if (r10 != r0) goto L_0x0150
            return r0
        L_0x0150:
            int r10 = r15.f2308j
            r5.mo2057b((int) r10)
            goto L_0x0109
        L_0x0156:
            boolean r1 = r15.f2311m
            if (r1 == 0) goto L_0x01aa
            r1 = r5
            r4 = r7
            r5 = r8
            r7 = r9
        L_0x015e:
            int r8 = r1.size()
            int r9 = r15.f2308j
            if (r8 <= r9) goto L_0x018f
            boolean r8 = r15.f2310l
            if (r8 == 0) goto L_0x016e
            r8 = r1
            java.util.List r8 = (java.util.List) r8
            goto L_0x0178
        L_0x016e:
            java.util.ArrayList r8 = new java.util.ArrayList
            r9 = r1
            java.util.Collection r9 = (java.util.Collection) r9
            r8.<init>(r9)
            java.util.List r8 = (java.util.List) r8
        L_0x0178:
            r15.f2299a = r7
            r15.f2303e = r5
            r15.f2304f = r4
            r15.f2300b = r1
            r15.f2306h = r3
            java.lang.Object r8 = r7.mo2727a(r8, (atakplugin.UASTool.ayd<? super atakplugin.UASTool.aqr>) r15)
            if (r8 != r0) goto L_0x0189
            return r0
        L_0x0189:
            int r8 = r15.f2308j
            r1.mo2057b((int) r8)
            goto L_0x015e
        L_0x018f:
            r3 = r1
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            r3 = r3 ^ r6
            if (r3 == 0) goto L_0x01aa
            r15.f2299a = r7
            r15.f2303e = r5
            r15.f2304f = r4
            r15.f2300b = r1
            r15.f2306h = r2
            java.lang.Object r15 = r7.mo2727a(r1, (atakplugin.UASTool.ayd<? super atakplugin.UASTool.aqr>) r15)
            if (r15 != r0) goto L_0x01aa
            return r0
        L_0x01aa:
            atakplugin.UASTool.aqr r15 = atakplugin.UASTool.aqr.f2177a
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.avq.mo2064a(java.lang.Object):java.lang.Object");
    }
}

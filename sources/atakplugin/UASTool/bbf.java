package atakplugin.UASTool;

import com.atakmap.android.uastool.tasks.UASTask;
import java.lang.reflect.Method;
import java.util.regex.MatchResult;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0011"}, mo1538e = {"Lkotlin/internal/PlatformImplementations;", "", "()V", "addSuppressed", "", "cause", "", "exception", "defaultPlatformRandom", "Lkotlin/random/Random;", "getMatchResultNamedGroup", "Lkotlin/text/MatchGroup;", "matchResult", "Ljava/util/regex/MatchResult;", "name", "", "ReflectAddSuppressedMethod", "kotlin-stdlib"})
public class bbf {

    @aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo1538e = {"Lkotlin/internal/PlatformImplementations$ReflectAddSuppressedMethod;", "", "()V", "method", "Ljava/lang/reflect/Method;", "kotlin-stdlib"})
    /* renamed from: atakplugin.UASTool.bbf$a */
    private static final class C0137a {

        /* renamed from: a */
        public static final Method f2497a;

        /* renamed from: b */
        public static final C0137a f2498b = new C0137a();

        /* JADX WARNING: Removed duplicated region for block: B:13:0x0049 A[EDGE_INSN: B:13:0x0049->B:11:0x0049 ?: BREAK  , SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:9:0x0045 A[LOOP:0: B:1:0x0015->B:9:0x0045, LOOP_END] */
        static {
            /*
                atakplugin.UASTool.bbf$a r0 = new atakplugin.UASTool.bbf$a
                r0.<init>()
                f2498b = r0
                java.lang.Class<java.lang.Throwable> r0 = java.lang.Throwable.class
                java.lang.reflect.Method[] r1 = r0.getMethods()
                java.lang.String r2 = "throwableClass.methods"
                atakplugin.UASTool.bfq.m6554b(r1, r2)
                int r2 = r1.length
                r3 = 0
                r4 = 0
            L_0x0015:
                if (r4 >= r2) goto L_0x0048
                r5 = r1[r4]
                java.lang.String r6 = "it"
                atakplugin.UASTool.bfq.m6554b(r5, r6)
                java.lang.String r6 = r5.getName()
                java.lang.String r7 = "addSuppressed"
                boolean r6 = atakplugin.UASTool.bfq.m6552a((java.lang.Object) r6, (java.lang.Object) r7)
                if (r6 == 0) goto L_0x0041
                java.lang.Class[] r6 = r5.getParameterTypes()
                java.lang.String r7 = "it.parameterTypes"
                atakplugin.UASTool.bfq.m6554b(r6, r7)
                java.lang.Object r6 = atakplugin.UASTool.arv.m4268k((T[]) r6)
                java.lang.Class r6 = (java.lang.Class) r6
                boolean r6 = atakplugin.UASTool.bfq.m6552a((java.lang.Object) r6, (java.lang.Object) r0)
                if (r6 == 0) goto L_0x0041
                r6 = 1
                goto L_0x0042
            L_0x0041:
                r6 = 0
            L_0x0042:
                if (r6 == 0) goto L_0x0045
                goto L_0x0049
            L_0x0045:
                int r4 = r4 + 1
                goto L_0x0015
            L_0x0048:
                r5 = 0
            L_0x0049:
                f2497a = r5
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.bbf.C0137a.<clinit>():void");
        }

        private C0137a() {
        }
    }

    /* renamed from: a */
    public void mo2238a(Throwable th, Throwable th2) {
        bfq.m6567f(th, "cause");
        bfq.m6567f(th2, "exception");
        Method method = C0137a.f2497a;
        if (method != null) {
            method.invoke(th, new Object[]{th2});
        }
    }

    /* renamed from: a */
    public bnm mo2237a(MatchResult matchResult, String str) {
        bfq.m6567f(matchResult, "matchResult");
        bfq.m6567f(str, UASTask.COTDETAIL_NAME);
        throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
    }

    /* renamed from: a */
    public bic mo2236a() {
        return new bhx();
    }
}

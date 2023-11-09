package atakplugin.UASTool;

import java.io.PrintStream;
import java.io.PrintWriter;

@aot(mo1534a = 5, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000&\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\b\u001a\u00020\t*\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003\u001a\r\u0010\u000b\u001a\u00020\t*\u00020\u0003H\b\u001a\u0015\u0010\u000b\u001a\u00020\t*\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\b\u001a\u0015\u0010\u000b\u001a\u00020\t*\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\b\"!\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, mo1538e = {"stackTrace", "", "Ljava/lang/StackTraceElement;", "", "stackTrace$annotations", "(Ljava/lang/Throwable;)V", "getStackTrace", "(Ljava/lang/Throwable;)[Ljava/lang/StackTraceElement;", "addSuppressed", "", "exception", "printStackTrace", "stream", "Ljava/io/PrintStream;", "writer", "Ljava/io/PrintWriter;", "kotlin-stdlib"}, mo1539f = "kotlin/ExceptionsKt", mo1541h = 1)
class aob {
    /* renamed from: a */
    public static /* synthetic */ void m2470a(Throwable th) {
    }

    /* renamed from: c */
    private static final void m2475c(Throwable th) {
        if (th != null) {
            th.printStackTrace();
            return;
        }
        throw new apx("null cannot be cast to non-null type java.lang.Throwable");
    }

    /* renamed from: a */
    private static final void m2472a(Throwable th, PrintWriter printWriter) {
        if (th != null) {
            th.printStackTrace(printWriter);
            return;
        }
        throw new apx("null cannot be cast to non-null type java.lang.Throwable");
    }

    /* renamed from: a */
    private static final void m2471a(Throwable th, PrintStream printStream) {
        if (th != null) {
            th.printStackTrace(printStream);
            return;
        }
        throw new apx("null cannot be cast to non-null type java.lang.Throwable");
    }

    /* renamed from: b */
    public static final StackTraceElement[] m2474b(Throwable th) {
        bfq.m6567f(th, "$this$stackTrace");
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace == null) {
            bfq.m6538a();
        }
        return stackTrace;
    }

    /* renamed from: a */
    public static final void m2473a(Throwable th, Throwable th2) {
        bfq.m6567f(th, "$this$addSuppressed");
        bfq.m6567f(th2, "exception");
        bbg.f2499a.mo2238a(th, th2);
    }
}

package atakplugin.UASTool;

import java.io.PrintStream;
import java.io.PrintWriter;

public class car extends RuntimeException {

    /* renamed from: b */
    private static final boolean f4462b;

    /* renamed from: a */
    Throwable f4463a;

    static {
        boolean z;
        try {
            Class.forName("java.nio.Buffer");
            z = true;
        } catch (Throwable unused) {
            z = false;
        }
        f4462b = z;
    }

    public car(Throwable th) {
        this.f4463a = th;
    }

    /* renamed from: a */
    public Throwable mo4351a() {
        return this.f4463a;
    }

    public Throwable getCause() {
        return this.f4463a;
    }

    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        Throwable th = this.f4463a;
        if (!f4462b && th != null) {
            printStream.print("Caused by: ");
            th.printStackTrace(printStream);
        }
    }

    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        Throwable th = this.f4463a;
        if (!f4462b && th != null) {
            printWriter.print("Caused by: ");
            th.printStackTrace(printWriter);
        }
    }
}

package atakplugin.UASTool;

public class ait extends Exception {

    /* renamed from: a */
    public int f1573a;

    /* renamed from: b */
    private Throwable f1574b = null;

    public ait(int i, String str) {
        super(str);
        this.f1573a = i;
    }

    public ait(int i, String str, Throwable th) {
        super(str);
        this.f1573a = i;
        this.f1574b = th;
    }

    public String toString() {
        return this.f1573a + ": " + getMessage();
    }

    public Throwable getCause() {
        return this.f1574b;
    }
}

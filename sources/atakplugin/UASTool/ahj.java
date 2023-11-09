package atakplugin.UASTool;

public class ahj extends Exception {

    /* renamed from: a */
    private Throwable f1259a = null;

    public ahj() {
    }

    public ahj(String str) {
        super(str);
    }

    public ahj(String str, Throwable th) {
        super(str);
        this.f1259a = th;
    }

    public Throwable getCause() {
        return this.f1259a;
    }
}

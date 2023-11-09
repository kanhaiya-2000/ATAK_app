package atakplugin.UASTool;

/* renamed from: atakplugin.UASTool.vj */
public class C0961vj extends RuntimeException {
    public C0961vj() {
    }

    public C0961vj(String str) {
        super(str);
    }

    public C0961vj(String str, C0963vl vlVar) {
        super(str);
        initCause(vlVar);
    }

    public String toString() {
        Throwable cause = getCause();
        String message = getMessage();
        String str = "";
        if (message == null) {
            return cause != null ? cause.toString() : str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(message);
        if (cause != null) {
            str = " (" + cause.toString() + ")";
        }
        sb.append(str);
        return sb.toString();
    }
}

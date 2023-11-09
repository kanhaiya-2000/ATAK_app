package atakplugin.UASTool;

public class afi {
    /* renamed from: a */
    public static int m847a(long j) {
        if (j <= 2147483647L && j >= -2147483648L) {
            return (int) j;
        }
        throw new RuntimeException("A cast to int has gone wrong. Please contact the mp4parser discussion group (" + j + ")");
    }
}

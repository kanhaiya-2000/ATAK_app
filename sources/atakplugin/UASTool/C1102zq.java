package atakplugin.UASTool;

import java.io.PrintStream;

/* renamed from: atakplugin.UASTool.zq */
public class C1102zq {
    public C1102zq(adi adi) {
        int i = 0;
        while (((long) adi.mo315a(8)) == 255) {
            i += 255;
        }
        int a = adi.mo315a(8) + i;
        do {
        } while (((long) adi.mo315a(8)) == 255);
        adi.mo315a(8);
        PrintStream printStream = System.err;
        printStream.println("payloadType " + a);
    }
}

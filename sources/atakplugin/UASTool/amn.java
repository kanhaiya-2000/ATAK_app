package atakplugin.UASTool;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class amn extends alt {

    /* renamed from: e */
    C1088zi f2093e;

    public amn(C1088zi ziVar) {
        this.f2093e = ziVar;
        this.f2048a = new ArrayBlockingQueue(100, true);
        new amo(this).start();
        this.f2050c = ziVar.mo13n();
    }

    /* renamed from: h */
    public void mo1495h() {
        List<C1024xh> l = this.f2093e.mo11l();
        for (int i = 0; i < l.size(); i++) {
            PrintStream printStream = System.err;
            printStream.println("Jo! " + i + " of " + l.size());
            this.f2048a.put(new amp(this, l.get(i), this.f2093e.mo12m()[i]));
        }
        System.err.println("Jo!");
    }

    /* renamed from: e */
    public long mo1470e() {
        return this.f2093e.mo14o().mo6178b();
    }

    /* renamed from: f */
    public String mo1471f() {
        return this.f2093e.mo15p();
    }

    /* renamed from: g */
    public String mo1472g() {
        return this.f2093e.mo14o().mo6170a();
    }

    /* renamed from: a */
    public static void m2433a(String[] strArr) {
        new alu(new amc[]{new amn(new C1088zi(new C1009wu("c:\\content\\big_buck_bunny_1080p_h264-2min.h264")))}, new FileOutputStream("output.mp4")).mo1448f();
    }
}

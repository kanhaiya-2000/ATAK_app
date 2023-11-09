package atakplugin.UASTool;

import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;
import javax.imageio.ImageIO;

/* renamed from: atakplugin.UASTool.zt */
public class C1105zt extends C1018xc {

    /* renamed from: d */
    File[] f8095d;

    /* renamed from: e */
    C1027xk f8096e = new C1027xk();

    /* renamed from: f */
    long[] f8097f;

    /* renamed from: g */
    C0737pi f8098g;

    /* renamed from: h */
    long[] f8099h;

    public void close() {
    }

    /* renamed from: p */
    public String mo15p() {
        return "vide";
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1105zt(String str, File[] fileArr, C1026xj xjVar) {
        super(str);
        File[] fileArr2 = fileArr;
        this.f8095d = fileArr2;
        if (xjVar.mo6140b().length == fileArr2.length) {
            BufferedImage read = ImageIO.read(fileArr2[0]);
            this.f8096e.mo6171a((double) read.getWidth());
            this.f8096e.mo6179b((double) read.getHeight());
            this.f8096e.mo6174a(xjVar.mo14o().mo6178b());
            long[] m = xjVar.mo12m();
            long[] b = xjVar.mo6140b();
            this.f8097f = new long[b.length];
            long j = 0;
            boolean z = true;
            long j2 = 0;
            int i = 1;
            for (int i2 = 1; i2 < m.length; i2++) {
                if (i < b.length && ((long) i2) == b[i]) {
                    this.f8097f[i - 1] = j2;
                    i++;
                    j2 = 0;
                }
                j2 += m[i2];
            }
            long[] jArr = this.f8097f;
            jArr[jArr.length - 1] = j2;
            this.f8098g = new C0737pi();
            C0801rj rjVar = new C0801rj(C0801rj.f6082b);
            this.f8098g.mo170a((C0688nt) rjVar);
            ade ade = new ade();
            ade.mo112c(ByteBuffer.wrap(C0677ni.m12486a("038080801B000100048080800D6C11000000000A1CB4000A1CB4068080800102")));
            ade.mo288a((adn) ads.m574a(-1, ByteBuffer.wrap(C0677ni.m12486a("038080801B000100048080800D6C11000000000A1CB4000A1CB4068080800102"))));
            rjVar.mo170a((C0688nt) ade);
            this.f8099h = new long[fileArr2.length];
            int i3 = 0;
            while (true) {
                long[] jArr2 = this.f8099h;
                if (i3 >= jArr2.length) {
                    break;
                }
                int i4 = i3 + 1;
                jArr2[i3] = (long) i4;
                i3 = i4;
            }
            double d = 0.0d;
            boolean z2 = true;
            for (C1021xe next : xjVar.mo6145g()) {
                if (next.mo6156c() == -1 && !z) {
                    throw new RuntimeException("Cannot accept edit list for processing (1)");
                } else if (next.mo6156c() >= 0 && !z2) {
                    throw new RuntimeException("Cannot accept edit list for processing (2)");
                } else if (next.mo6156c() == -1) {
                    d += next.mo6155b();
                } else {
                    d -= ((double) next.mo6156c()) / ((double) next.mo6154a());
                    z2 = false;
                    z = false;
                }
            }
            if (xjVar.mo6139a() != null && xjVar.mo6139a().size() > 0) {
                int[] b2 = C0693ny.m12590b(xjVar.mo6139a());
                int i5 = 0;
                while (i5 < b2.length && i5 < 50) {
                    b2[i5] = (int) (((long) b2[i5]) + j);
                    j += xjVar.mo12m()[i5];
                    i5++;
                }
                Arrays.sort(b2);
                d += ((double) b2[0]) / ((double) xjVar.mo14o().mo6178b());
            }
            if (d < 0.0d) {
                mo6145g().add(new C1021xe((long) ((-d) * ((double) mo14o().mo6178b())), mo14o().mo6178b(), 1.0d, ((double) mo6143e()) / ((double) mo14o().mo6178b())));
            } else if (d > 0.0d) {
                mo6145g().add(new C1021xe(-1, mo14o().mo6178b(), 1.0d, d));
                mo6145g().add(new C1021xe(0, mo14o().mo6178b(), 1.0d, ((double) mo6143e()) / ((double) mo14o().mo6178b())));
            }
        } else {
            throw new RuntimeException("Number of sync samples doesn't match the number of stills (" + xjVar.mo6140b().length + " vs. " + fileArr2.length + ")");
        }
    }

    /* renamed from: n */
    public C0737pi mo13n() {
        return this.f8098g;
    }

    /* renamed from: m */
    public long[] mo12m() {
        return this.f8097f;
    }

    /* renamed from: o */
    public C1027xk mo14o() {
        return this.f8096e;
    }

    /* renamed from: b */
    public long[] mo6140b() {
        return this.f8099h;
    }

    /* renamed from: l */
    public List<C1024xh> mo11l() {
        return new C1106zu(this);
    }
}

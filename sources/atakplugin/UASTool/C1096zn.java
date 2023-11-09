package atakplugin.UASTool;

import atakplugin.UASTool.C1053yh;
import atakplugin.UASTool.alc;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* renamed from: atakplugin.UASTool.zn */
public class C1096zn extends C1053yh implements C1095zm {

    /* renamed from: aa */
    ArrayList<ByteBuffer> f8035aa = new ArrayList<>();

    /* renamed from: ab */
    ArrayList<ByteBuffer> f8036ab = new ArrayList<>();

    /* renamed from: ac */
    ArrayList<ByteBuffer> f8037ac = new ArrayList<>();

    /* renamed from: ad */
    ArrayList<C1024xh> f8038ad = new ArrayList<>();

    /* renamed from: ae */
    C0737pi f8039ae;

    /* renamed from: n */
    public C0737pi mo13n() {
        return null;
    }

    /* renamed from: p */
    public String mo15p() {
        return "vide";
    }

    public C1096zn(C1007ws wsVar) {
        super(wsVar);
        ArrayList arrayList = new ArrayList();
        C1053yh.C1054a aVar = new C1053yh.C1054a(wsVar);
        boolean[] zArr = new boolean[1];
        boolean[] zArr2 = {true};
        while (true) {
            ByteBuffer a = mo6273a(aVar);
            if (a == null) {
                this.f8039ae = m14967i();
                this.f7688a_ = new long[this.f8038ad.size()];
                mo14o().mo6174a(25);
                Arrays.fill(this.f7688a_, 1);
                return;
            }
            C1094zl b = m14966b(a);
            if (zArr[0]) {
                if (!mo6327a(b)) {
                    switch (b.f7980b) {
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                        case 39:
                        case 41:
                        case 42:
                        case 43:
                        case 44:
                        case 48:
                        case 49:
                        case 50:
                        case 51:
                        case 52:
                        case 53:
                        case 54:
                        case 55:
                            mo6326a(arrayList, zArr, zArr2);
                            break;
                    }
                } else if ((a.get(2) & Byte.MIN_VALUE) != 0) {
                    mo6326a(arrayList, zArr, zArr2);
                }
            }
            int i = b.f7980b;
            if (i != 39) {
                switch (i) {
                    case 32:
                        a.position(2);
                        this.f8037ac.add(a.slice());
                        System.err.println("Stored VPS");
                        break;
                    case 33:
                        a.position(2);
                        this.f8035aa.add(a.slice());
                        a.position(1);
                        new C1103zr(Channels.newInputStream(new afh(a.slice())));
                        System.err.println("Stored SPS");
                        break;
                    case 34:
                        a.position(2);
                        this.f8036ab.add(a.slice());
                        System.err.println("Stored PPS");
                        break;
                }
            } else {
                new C1102zq(new adi(a.slice()));
            }
            switch (b.f7980b) {
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                    break;
                default:
                    PrintStream printStream = System.err;
                    printStream.println("Adding " + b.f7980b);
                    arrayList.add(a);
                    break;
            }
            if (mo6327a(b)) {
                int i2 = b.f7980b;
                if (i2 == 19 || i2 == 20) {
                    zArr2[0] = zArr2[0] & true;
                } else {
                    zArr2[0] = false;
                }
            }
            zArr[0] = zArr[0] | mo6327a(b);
        }
    }

    /* renamed from: i */
    private C0737pi m14967i() {
        this.f8039ae = new C0737pi();
        C0801rj rjVar = new C0801rj(C0801rj.f6087g);
        rjVar.mo204a(1);
        rjVar.mo5644e(24);
        rjVar.mo5643d(1);
        rjVar.mo5635a(72.0d);
        rjVar.mo5638b(72.0d);
        rjVar.mo5639b(640);
        rjVar.mo5641c(480);
        rjVar.mo5640b("HEVC Coding");
        alb alb = new alb();
        alc.C0055a aVar = new alc.C0055a();
        aVar.f1871a = true;
        aVar.f1873c = 33;
        aVar.f1874d = new ArrayList();
        Iterator<ByteBuffer> it = this.f8035aa.iterator();
        while (it.hasNext()) {
            aVar.f1874d.add(m14714a(it.next()));
        }
        alc.C0055a aVar2 = new alc.C0055a();
        aVar2.f1871a = true;
        aVar2.f1873c = 34;
        aVar2.f1874d = new ArrayList();
        Iterator<ByteBuffer> it2 = this.f8036ab.iterator();
        while (it2.hasNext()) {
            aVar2.f1874d.add(m14714a(it2.next()));
        }
        alc.C0055a aVar3 = new alc.C0055a();
        aVar3.f1871a = true;
        aVar3.f1873c = 34;
        aVar3.f1874d = new ArrayList();
        Iterator<ByteBuffer> it3 = this.f8037ac.iterator();
        while (it3.hasNext()) {
            aVar3.f1874d.add(m14714a(it3.next()));
        }
        alb.mo1245B().addAll(Arrays.asList(new alc.C0055a[]{aVar, aVar3, aVar2}));
        rjVar.mo170a((C0688nt) alb);
        this.f8039ae.mo170a((C0688nt) rjVar);
        return this.f8039ae;
    }

    /* renamed from: a */
    public void mo6326a(List<ByteBuffer> list, boolean[] zArr, boolean[] zArr2) {
        this.f8038ad.add(mo6272a((List<? extends ByteBuffer>) list));
        PrintStream printStream = System.err;
        printStream.print("Create AU from " + list.size() + " NALs");
        if (zArr2[0]) {
            System.err.println("  IDR");
        } else {
            System.err.println();
        }
        zArr[0] = false;
        zArr2[0] = true;
        list.clear();
    }

    /* renamed from: l */
    public List<C1024xh> mo11l() {
        return this.f8038ad;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo6327a(C1094zl zlVar) {
        return zlVar.f7980b >= 0 && zlVar.f7980b <= 31;
    }

    /* renamed from: b */
    public static C1094zl m14966b(ByteBuffer byteBuffer) {
        byteBuffer.position(0);
        int d = C0679nk.m12497d(byteBuffer);
        C1094zl zlVar = new C1094zl();
        zlVar.f7979a = (32768 & d) >> 15;
        zlVar.f7980b = (d & 32256) >> 9;
        zlVar.f7981c = (d & 504) >> 3;
        zlVar.f7982d = d & 7;
        return zlVar;
    }

    /* renamed from: a */
    public static void m14965a(String[] strArr) {
        C1096zn znVar = new C1096zn(new C1009wu("c:\\content\\test-UHD-HEVC_01_FMV_Med_track1.hvc"));
        C1022xf xfVar = new C1022xf();
        xfVar.mo6161a((C1026xj) znVar);
        new C1030xn().mo6195a(xfVar).mo209b(new FileOutputStream("output.mp4").getChannel());
    }
}

package atakplugin.UASTool;

import java.util.Date;

/* renamed from: atakplugin.UASTool.xk */
public class C1027xk implements Cloneable {

    /* renamed from: a */
    int f7575a;

    /* renamed from: b */
    private String f7576b = "eng";

    /* renamed from: c */
    private long f7577c;

    /* renamed from: d */
    private Date f7578d = new Date();

    /* renamed from: e */
    private Date f7579e = new Date();

    /* renamed from: f */
    private afr f7580f = afr.f870j;

    /* renamed from: g */
    private double f7581g;

    /* renamed from: h */
    private double f7582h;

    /* renamed from: i */
    private float f7583i;

    /* renamed from: j */
    private long f7584j = 1;

    /* renamed from: k */
    private int f7585k = 0;

    /* renamed from: a */
    public String mo6170a() {
        return this.f7576b;
    }

    /* renamed from: a */
    public void mo6176a(String str) {
        this.f7576b = str;
    }

    /* renamed from: b */
    public long mo6178b() {
        return this.f7577c;
    }

    /* renamed from: a */
    public void mo6174a(long j) {
        this.f7577c = j;
    }

    /* renamed from: c */
    public Date mo6183c() {
        return this.f7578d;
    }

    /* renamed from: a */
    public void mo6177a(Date date) {
        this.f7578d = date;
    }

    /* renamed from: d */
    public Date mo6185d() {
        return this.f7579e;
    }

    /* renamed from: b */
    public void mo6182b(Date date) {
        this.f7579e = date;
    }

    /* renamed from: e */
    public double mo6186e() {
        return this.f7581g;
    }

    /* renamed from: a */
    public void mo6171a(double d) {
        this.f7581g = d;
    }

    /* renamed from: f */
    public double mo6187f() {
        return this.f7582h;
    }

    /* renamed from: b */
    public void mo6179b(double d) {
        this.f7582h = d;
    }

    /* renamed from: g */
    public long mo6188g() {
        return this.f7584j;
    }

    /* renamed from: b */
    public void mo6181b(long j) {
        this.f7584j = j;
    }

    /* renamed from: h */
    public int mo6189h() {
        return this.f7575a;
    }

    /* renamed from: a */
    public void mo6173a(int i) {
        this.f7575a = i;
    }

    /* renamed from: i */
    public float mo6190i() {
        return this.f7583i;
    }

    /* renamed from: a */
    public void mo6172a(float f) {
        this.f7583i = f;
    }

    /* renamed from: j */
    public int mo6191j() {
        return this.f7585k;
    }

    /* renamed from: b */
    public void mo6180b(int i) {
        this.f7585k = i;
    }

    /* renamed from: k */
    public afr mo6192k() {
        return this.f7580f;
    }

    /* renamed from: a */
    public void mo6175a(afr afr) {
        this.f7580f = afr;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }
}

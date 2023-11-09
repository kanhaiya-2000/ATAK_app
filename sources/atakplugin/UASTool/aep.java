package atakplugin.UASTool;

public class aep {

    /* renamed from: a */
    private aep f712a;

    /* renamed from: b */
    private aep f713b;

    /* renamed from: c */
    private Object f714c;

    /* renamed from: a */
    public void mo512a(String str, Object obj) {
        aep aep;
        if (str.length() == 0) {
            this.f714c = obj;
            return;
        }
        if (str.charAt(0) == '0') {
            if (this.f712a == null) {
                this.f712a = new aep();
            }
            aep = this.f712a;
        } else {
            if (this.f713b == null) {
                this.f713b = new aep();
            }
            aep = this.f713b;
        }
        aep.mo512a(str.substring(1), obj);
    }

    /* renamed from: a */
    public aep mo510a(int i) {
        if (i == 0) {
            return this.f712a;
        }
        return this.f713b;
    }

    /* renamed from: a */
    public Object mo511a() {
        return this.f714c;
    }
}

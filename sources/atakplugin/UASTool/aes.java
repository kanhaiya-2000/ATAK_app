package atakplugin.UASTool;

public class aes {

    /* renamed from: a */
    public static final aes f718a = new aes(255);

    /* renamed from: b */
    private int f719b;

    private aes(int i) {
        this.f719b = i;
    }

    /* renamed from: a */
    public static aes m779a(int i) {
        aes aes = f718a;
        if (i == aes.f719b) {
            return aes;
        }
        return new aes(i);
    }

    /* renamed from: a */
    public int mo518a() {
        return this.f719b;
    }

    public String toString() {
        return "AspectRatio{" + "value=" + this.f719b + '}';
    }
}

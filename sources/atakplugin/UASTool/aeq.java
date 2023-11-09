package atakplugin.UASTool;

public class aeq {

    /* renamed from: a */
    private char[] f715a;

    /* renamed from: b */
    private int f716b;

    public aeq(int i) {
        this.f715a = new char[i];
    }

    /* renamed from: a */
    public void mo515a(String str) {
        char[] charArray = str.toCharArray();
        char[] cArr = this.f715a;
        int length = cArr.length;
        int i = this.f716b;
        int i2 = length - i;
        if (charArray.length < i2) {
            i2 = charArray.length;
        }
        System.arraycopy(charArray, 0, cArr, i, i2);
        this.f716b += i2;
    }

    public String toString() {
        return new String(this.f715a, 0, this.f716b);
    }

    /* renamed from: a */
    public void mo513a() {
        this.f716b = 0;
    }

    /* renamed from: a */
    public void mo514a(char c) {
        int i = this.f716b;
        char[] cArr = this.f715a;
        if (i < cArr.length - 1) {
            cArr[i] = c;
            this.f716b = i + 1;
        }
    }

    /* renamed from: b */
    public int mo516b() {
        return this.f716b;
    }
}

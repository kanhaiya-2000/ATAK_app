package atakplugin.UASTool;

public class aex {

    /* renamed from: a */
    public int[] f764a;

    /* renamed from: b */
    public boolean f765b;

    /* renamed from: a */
    public void mo530a(afe afe) {
        int i = 0;
        if (this.f765b) {
            afe.mo570b(0, "SPS: ");
            return;
        }
        int i2 = 8;
        while (true) {
            int[] iArr = this.f764a;
            if (i < iArr.length) {
                afe.mo570b((iArr[i] - i2) - 256, "SPS: ");
                i2 = this.f764a[i];
                i++;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public static aex m789a(afc afc, int i) {
        aex aex = new aex();
        aex.f764a = new int[i];
        int i2 = 8;
        int i3 = 8;
        int i4 = 0;
        while (i4 < i) {
            if (i2 != 0) {
                i2 = ((afc.mo551b("deltaScale") + i3) + 256) % 256;
                aex.f765b = i4 == 0 && i2 == 0;
            }
            int[] iArr = aex.f764a;
            if (i2 != 0) {
                i3 = i2;
            }
            iArr[i4] = i3;
            i3 = iArr[i4];
            i4++;
        }
        return aex;
    }

    public String toString() {
        return "ScalingList{scalingList=" + this.f764a + ", useDefaultScalingMatrixFlag=" + this.f765b + '}';
    }
}

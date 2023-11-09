package atakplugin.UASTool;

/* renamed from: atakplugin.UASTool.o */
final class C0696o implements C0391ei<double[], Double> {
    C0696o() {
    }

    /* renamed from: a */
    public Double apply(double[] dArr) {
        if (dArr[0] == 0.0d) {
            return Double.valueOf(0.0d);
        }
        return Double.valueOf(dArr[1] / dArr[0]);
    }
}

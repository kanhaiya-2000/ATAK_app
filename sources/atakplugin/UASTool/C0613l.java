package atakplugin.UASTool;

/* renamed from: atakplugin.UASTool.l */
final class C0613l implements C0391ei<long[], Double> {
    C0613l() {
    }

    /* renamed from: a */
    public Double apply(long[] jArr) {
        if (jArr[0] == 0) {
            return Double.valueOf(0.0d);
        }
        return Double.valueOf(((double) jArr[1]) / ((double) jArr[0]));
    }
}

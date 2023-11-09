package atakplugin.UASTool;

public final class afs {
    private afs() {
    }

    /* renamed from: a */
    public static long[] m880a(long[] jArr, long... jArr2) {
        if (jArr == null) {
            jArr = new long[0];
        }
        if (jArr2 == null) {
            jArr2 = new long[0];
        }
        long[] jArr3 = new long[(jArr.length + jArr2.length)];
        System.arraycopy(jArr, 0, jArr3, 0, jArr.length);
        System.arraycopy(jArr2, 0, jArr3, jArr.length, jArr2.length);
        return jArr3;
    }

    /* renamed from: a */
    public static int[] m879a(int[] iArr, int... iArr2) {
        if (iArr == null) {
            iArr = new int[0];
        }
        if (iArr2 == null) {
            iArr2 = new int[0];
        }
        int[] iArr3 = new int[(iArr.length + iArr2.length)];
        System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
        System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
        return iArr3;
    }
}

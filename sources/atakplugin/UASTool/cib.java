package atakplugin.UASTool;

public final class cib {

    /* renamed from: a */
    static final /* synthetic */ boolean f4641a = true;

    private cib() {
        throw new AssertionError("shouldn't be instantiated");
    }

    @ciq(mo4682a = {"#1"})
    /* renamed from: a */
    public static <T> T m11620a(T t) {
        if (f4641a || t != null) {
            return t;
        }
        throw new AssertionError("Misuse of castNonNull: called with a null argument");
    }

    @ciq(mo4682a = {"#1"})
    /* renamed from: a */
    public static <T> T[] m11621a(T[] tArr) {
        return m11627b(tArr);
    }

    @ciq(mo4682a = {"#1"})
    /* renamed from: a */
    public static <T> T[][] m11622a(T[][] tArr) {
        return (Object[][]) m11627b((T[]) tArr);
    }

    @ciq(mo4682a = {"#1"})
    /* renamed from: a */
    public static <T> T[][][] m11623a(T[][][] tArr) {
        return (Object[][][]) m11627b((T[]) tArr);
    }

    @ciq(mo4682a = {"#1"})
    /* renamed from: a */
    public static <T> T[][][][] m11624a(T[][][][] tArr) {
        return (Object[][][][]) m11627b((T[]) tArr);
    }

    @ciq(mo4682a = {"#1"})
    /* renamed from: a */
    public static <T> T[][][][][] m11625a(T[][][][][] tArr) {
        return (Object[][][][][]) m11627b((T[]) tArr);
    }

    /* renamed from: b */
    private static <T> T[] m11627b(T[] tArr) {
        if (f4641a || tArr != null) {
            int i = 0;
            while (i < tArr.length) {
                if (f4641a || tArr[i] != null) {
                    m11626b((Object) tArr[i]);
                    i++;
                } else {
                    throw new AssertionError("Misuse of castNonNull: called with a null array element");
                }
            }
            return (Object[]) tArr;
        }
        throw new AssertionError("Misuse of castNonNullArray: called with a null array argument");
    }

    /* renamed from: b */
    private static void m11626b(Object obj) {
        if (f4641a || obj != null) {
            Class<?> componentType = obj.getClass().getComponentType();
            if (componentType != null && !componentType.isPrimitive()) {
                m11627b((T[]) (Object[]) obj);
                return;
            }
            return;
        }
        throw new AssertionError("Misuse of checkIfArray: called with a null argument");
    }
}

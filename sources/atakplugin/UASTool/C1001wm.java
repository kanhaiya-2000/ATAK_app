package atakplugin.UASTool;

import atakplugin.UASTool.C0998wk;
import java.util.Arrays;

/* renamed from: atakplugin.UASTool.wm */
public class C1001wm extends RuntimeException {

    /* renamed from: a */
    private final Object f7494a;

    /* renamed from: b */
    private final int f7495b;

    /* renamed from: c */
    private final C0998wk.C0999a<?>[] f7496c;

    C1001wm(Object obj, int i, C0998wk.C0999a<?>... aVarArr) {
        this.f7494a = obj;
        this.f7495b = i;
        this.f7496c = aVarArr;
    }

    /* renamed from: a */
    public Object mo6115a() {
        return this.f7494a;
    }

    /* renamed from: b */
    public int mo6116b() {
        return this.f7495b;
    }

    /* renamed from: c */
    public C0998wk.C0999a<?>[] mo6117c() {
        return this.f7496c;
    }

    public String toString() {
        String format = String.format("Unexpected element '%s' at position '%d'", new Object[]{this.f7494a, Integer.valueOf(this.f7495b)});
        if (this.f7496c.length <= 0) {
            return format;
        }
        return format + String.format(", expecting '%s'", new Object[]{Arrays.toString(this.f7496c)});
    }
}

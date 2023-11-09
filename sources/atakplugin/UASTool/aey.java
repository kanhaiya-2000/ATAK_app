package atakplugin.UASTool;

import java.util.Arrays;
import java.util.List;

public class aey {

    /* renamed from: a */
    public aex[] f766a;

    /* renamed from: b */
    public aex[] f767b;

    public String toString() {
        StringBuilder sb = new StringBuilder("ScalingMatrix{ScalingList4x4=");
        aex[] aexArr = this.f766a;
        List list = null;
        sb.append(aexArr == null ? null : Arrays.asList(aexArr));
        sb.append("\n");
        sb.append(", ScalingList8x8=");
        aex[] aexArr2 = this.f767b;
        if (aexArr2 != null) {
            list = Arrays.asList(aexArr2);
        }
        sb.append(list);
        sb.append("\n");
        sb.append('}');
        return sb.toString();
    }
}

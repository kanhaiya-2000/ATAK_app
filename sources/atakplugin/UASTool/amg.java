package atakplugin.UASTool;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class amg implements alw {

    /* renamed from: a */
    public static Map<Integer, amg> f2081a = Collections.synchronizedMap(new HashMap());

    /* renamed from: b */
    private int f2082b;

    /* renamed from: a */
    public static amg m2412a(int i) {
        amg amg = f2081a.get(Integer.valueOf(i));
        if (amg != null) {
            return amg;
        }
        amg amg2 = new amg();
        amg2.f2082b = i;
        f2081a.put(Integer.valueOf(i), amg2);
        return amg2;
    }

    /* renamed from: a */
    public int mo1477a() {
        return this.f2082b;
    }
}

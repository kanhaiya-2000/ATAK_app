package atakplugin.UASTool;

import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

public class cbn {

    /* renamed from: a */
    private static Map<Class, WeakReference<cbm>> f4473a = Collections.synchronizedMap(new WeakHashMap());

    /* renamed from: a */
    public static <T> cbm<T> m11175a(Class<T> cls) {
        WeakReference weakReference = f4473a.get(cls);
        if (weakReference != null) {
            cbm<T> cbm = (cbm) weakReference.get();
            if (cbm != null) {
                return cbm;
            }
            bzs bzs = new bzs(cls);
            f4473a.put(cls, new WeakReference(bzs));
            return bzs;
        }
        bzs bzs2 = new bzs(cls);
        f4473a.put(cls, new WeakReference(bzs2));
        return bzs2;
    }
}

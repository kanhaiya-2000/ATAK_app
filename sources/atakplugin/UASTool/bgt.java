package atakplugin.UASTool;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class bgt {

    /* renamed from: a */
    private final ArrayList<Object> f2680a;

    public bgt(int i) {
        this.f2680a = new ArrayList<>(i);
    }

    /* renamed from: a */
    public void mo2505a(Object obj) {
        if (obj != null) {
            if (obj instanceof Object[]) {
                Object[] objArr = (Object[]) obj;
                if (objArr.length > 0) {
                    ArrayList<Object> arrayList = this.f2680a;
                    arrayList.ensureCapacity(arrayList.size() + objArr.length);
                    Collections.addAll(this.f2680a, objArr);
                }
            } else if (obj instanceof Collection) {
                this.f2680a.addAll((Collection) obj);
            } else if (obj instanceof Iterable) {
                for (Object add : (Iterable) obj) {
                    this.f2680a.add(add);
                }
            } else if (obj instanceof Iterator) {
                Iterator it = (Iterator) obj;
                while (it.hasNext()) {
                    this.f2680a.add(it.next());
                }
            } else {
                throw new UnsupportedOperationException("Don't know how to spread " + obj.getClass());
            }
        }
    }

    /* renamed from: a */
    public int mo2504a() {
        return this.f2680a.size();
    }

    /* renamed from: b */
    public void mo2507b(Object obj) {
        this.f2680a.add(obj);
    }

    /* renamed from: a */
    public Object[] mo2506a(Object[] objArr) {
        return this.f2680a.toArray(objArr);
    }
}

package atakplugin.UASTool;

import java.util.Arrays;
import java.util.Iterator;

/* renamed from: atakplugin.UASTool.wk */
public class C0998wk<E> implements Iterable<E> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final E[] f7490a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f7491b = 0;

    /* renamed from: atakplugin.UASTool.wk$a */
    public interface C0999a<E> {
        /* renamed from: a */
        boolean mo6080a(E e);
    }

    public C0998wk(E[] eArr) {
        this.f7490a = (Object[]) eArr.clone();
    }

    /* renamed from: a */
    public E mo6101a() {
        int i = this.f7491b;
        E[] eArr = this.f7490a;
        if (i >= eArr.length) {
            return null;
        }
        this.f7491b = i + 1;
        return eArr[i];
    }

    /* renamed from: a */
    public <T extends C0999a<E>> E mo6103a(T... tArr) {
        Object a = mo6102a(1);
        for (T a2 : tArr) {
            if (a2.mo6080a(a)) {
                return mo6101a();
            }
        }
        throw new C1001wm(a, this.f7491b, tArr);
    }

    /* renamed from: b */
    public void mo6106b() {
        int i = this.f7491b;
        if (i > 0) {
            this.f7491b = i - 1;
        }
    }

    /* renamed from: c */
    public E mo6108c() {
        return mo6102a(1);
    }

    /* renamed from: a */
    public E mo6102a(int i) {
        int i2 = (this.f7491b + i) - 1;
        E[] eArr = this.f7490a;
        if (i2 < eArr.length) {
            return eArr[i2];
        }
        return null;
    }

    /* renamed from: d */
    public int mo6109d() {
        return this.f7491b;
    }

    /* renamed from: b */
    public <T extends C0999a<E>> boolean mo6107b(T... tArr) {
        for (T a : tArr) {
            if (a.mo6080a(mo6102a(1))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public <T extends C0999a<E>> boolean mo6105a(C0999a<E> aVar, T... tArr) {
        int i = 1;
        while (true) {
            if (i > this.f7490a.length) {
                break;
            }
            Object a = mo6102a(i);
            if (aVar.mo6080a(a)) {
                break;
            }
            for (T a2 : tArr) {
                if (a2.mo6080a(a)) {
                    return true;
                }
            }
            i++;
        }
        return false;
    }

    /* renamed from: a */
    public <T extends C0999a<E>> boolean mo6104a(int i, T... tArr) {
        int i2 = 1;
        while (true) {
            if (i2 > i) {
                return false;
            }
            for (T a : tArr) {
                if (a.mo6080a(mo6102a(i2))) {
                    return true;
                }
            }
            i2++;
        }
    }

    public Iterator<E> iterator() {
        return new C1000wl(this);
    }

    /* renamed from: e */
    public E[] mo6110e() {
        E[] eArr = this.f7490a;
        return Arrays.copyOfRange(eArr, this.f7491b, eArr.length);
    }
}

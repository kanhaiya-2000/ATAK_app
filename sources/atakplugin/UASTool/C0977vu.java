package atakplugin.UASTool;

import atakplugin.UASTool.C0968vn;
import java.util.EnumSet;
import java.util.Iterator;

/* 'enum' modifier removed */
/* renamed from: atakplugin.UASTool.vu */
final class C0977vu extends C0968vn.C0970a {
    C0977vu(String str, int i) {
        super(str, i);
    }

    /* renamed from: b */
    public boolean mo6080a(Character ch) {
        Iterator it = EnumSet.complementOf(EnumSet.of(ILLEGAL)).iterator();
        while (it.hasNext()) {
            if (((C0968vn.C0970a) it.next()).mo6080a(ch)) {
                return false;
            }
        }
        return true;
    }
}

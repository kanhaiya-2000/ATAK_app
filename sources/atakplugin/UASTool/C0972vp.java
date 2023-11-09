package atakplugin.UASTool;

import atakplugin.UASTool.C0968vn;

/* 'enum' modifier removed */
/* renamed from: atakplugin.UASTool.vp */
final class C0972vp extends C0968vn.C0970a {
    C0972vp(String str, int i) {
        super(str, i);
    }

    /* renamed from: b */
    public boolean mo6080a(Character ch) {
        if (ch == null) {
            return false;
        }
        if ((ch.charValue() < 'a' || ch.charValue() > 'z') && (ch.charValue() < 'A' || ch.charValue() > 'Z')) {
            return false;
        }
        return true;
    }
}

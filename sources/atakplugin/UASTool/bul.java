package atakplugin.UASTool;

import java.util.zip.Inflater;

class bul extends Inflater {

    /* renamed from: a */
    final /* synthetic */ buj f3918a;

    bul(buj buj) {
        this.f3918a = buj;
    }

    public int inflate(byte[] bArr, int i, int i2) {
        int inflate = super.inflate(bArr, i, i2);
        if (inflate != 0 || !needsDictionary()) {
            return inflate;
        }
        setDictionary(buq.f3958m);
        return super.inflate(bArr, i, i2);
    }
}

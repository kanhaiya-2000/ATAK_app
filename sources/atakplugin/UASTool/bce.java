package atakplugin.UASTool;

import java.util.ArrayList;

@aot(mo1534a = 3, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo1538e = {"<anonymous>", "", "it", "", "invoke"})
final class bce extends bfr implements bdl<String, aqr> {

    /* renamed from: a */
    final /* synthetic */ ArrayList f2546a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    bce(ArrayList arrayList) {
        super(1);
        this.f2546a = arrayList;
    }

    public /* synthetic */ Object invoke(Object obj) {
        mo2275a((String) obj);
        return aqr.f2177a;
    }

    /* renamed from: a */
    public final void mo2275a(String str) {
        bfq.m6567f(str, "it");
        this.f2546a.add(str);
    }
}

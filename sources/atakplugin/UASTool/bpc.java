package atakplugin.UASTool;

@aot(mo1534a = 3, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, mo1538e = {"<anonymous>", "R", "index", "", "invoke", "(I)Ljava/lang/Object;"})
final class bpc extends bfr implements bdl<Integer, R> {

    /* renamed from: a */
    final /* synthetic */ CharSequence f3073a;

    /* renamed from: b */
    final /* synthetic */ int f3074b;

    /* renamed from: c */
    final /* synthetic */ bdl f3075c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    bpc(CharSequence charSequence, int i, bdl bdl) {
        super(1);
        this.f3073a = charSequence;
        this.f3074b = i;
        this.f3075c = bdl;
    }

    public /* synthetic */ Object invoke(Object obj) {
        return mo2944a(((Number) obj).intValue());
    }

    /* renamed from: a */
    public final R mo2944a(int i) {
        int i2 = this.f3074b + i;
        if (i2 < 0 || i2 > this.f3073a.length()) {
            i2 = this.f3073a.length();
        }
        return this.f3075c.invoke(this.f3073a.subSequence(i, i2));
    }
}

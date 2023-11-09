package atakplugin.UASTool;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\t\u0010\u0004\u001a\u00020\u0005H\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, mo1538e = {"kotlin/text/StringsKt__StringsKt$iterator$1", "Lkotlin/collections/CharIterator;", "index", "", "hasNext", "", "nextChar", "", "kotlin-stdlib"})
public final class bop extends atn {

    /* renamed from: a */
    final /* synthetic */ CharSequence f3058a;

    /* renamed from: b */
    private int f3059b;

    bop(CharSequence charSequence) {
        this.f3058a = charSequence;
    }

    /* renamed from: b */
    public char mo1882b() {
        CharSequence charSequence = this.f3058a;
        int i = this.f3059b;
        this.f3059b = i + 1;
        return charSequence.charAt(i);
    }

    public boolean hasNext() {
        return this.f3059b < this.f3058a.length();
    }
}

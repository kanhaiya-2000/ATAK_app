package atakplugin.UASTool;

/* renamed from: atakplugin.UASTool.h */
final class C0488h implements C0391ei<StringBuilder, String> {

    /* renamed from: a */
    final /* synthetic */ String f4986a;

    /* renamed from: b */
    final /* synthetic */ CharSequence f4987b;

    C0488h(String str, CharSequence charSequence) {
        this.f4986a = str;
        this.f4987b = charSequence;
    }

    /* renamed from: a */
    public String apply(StringBuilder sb) {
        if (sb.length() == 0) {
            return this.f4986a;
        }
        sb.append(this.f4987b);
        return sb.toString();
    }
}

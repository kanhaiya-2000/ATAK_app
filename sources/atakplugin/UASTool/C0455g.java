package atakplugin.UASTool;

/* renamed from: atakplugin.UASTool.g */
final class C0455g implements C0339cv<StringBuilder, CharSequence> {

    /* renamed from: a */
    final /* synthetic */ CharSequence f4956a;

    /* renamed from: b */
    final /* synthetic */ CharSequence f4957b;

    C0455g(CharSequence charSequence, CharSequence charSequence2) {
        this.f4956a = charSequence;
        this.f4957b = charSequence2;
    }

    /* renamed from: a */
    public void mo128a(StringBuilder sb, CharSequence charSequence) {
        if (sb.length() > 0) {
            sb.append(this.f4956a);
        } else {
            sb.append(this.f4957b);
        }
        sb.append(charSequence);
    }
}

package atakplugin.UASTool;

import java.util.Objects;

/* renamed from: atakplugin.UASTool.zz-$$ExternalSynthetic0  reason: invalid class name */
public /* synthetic */ class zz$$ExternalSynthetic0 {
    /* renamed from: m0 */
    public static /* synthetic */ String m15036m0(CharSequence charSequence, CharSequence[] charSequenceArr) {
        Objects.requireNonNull(charSequence, "delimiter");
        StringBuilder sb = new StringBuilder();
        if (charSequenceArr.length > 0) {
            sb.append(charSequenceArr[0]);
            for (int i = 1; i < charSequenceArr.length; i++) {
                sb.append(charSequence);
                sb.append(charSequenceArr[i]);
            }
        }
        return sb.toString();
    }
}

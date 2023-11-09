package atakplugin.UASTool;

import atakplugin.UASTool.C0560jd;
import java.util.NoSuchElementException;

/* renamed from: atakplugin.UASTool.kb */
public class C0588kb extends C0560jd.C0562b {

    /* renamed from: a */
    private final CharSequence f5115a;

    /* renamed from: b */
    private final boolean f5116b;

    /* renamed from: c */
    private int f5117c = 0;

    /* renamed from: d */
    private int f5118d = -1;

    public C0588kb(CharSequence charSequence) {
        this.f5115a = charSequence;
        this.f5116b = charSequence instanceof String;
    }

    public boolean hasNext() {
        return this.f5117c < m12383b();
    }

    /* renamed from: a */
    public int mo2940a() {
        int i;
        int b = m12383b();
        int i2 = this.f5117c;
        if (i2 < b) {
            CharSequence charSequence = this.f5115a;
            this.f5117c = i2 + 1;
            char charAt = charSequence.charAt(i2);
            if (Character.isHighSurrogate(charAt) && (i = this.f5117c) < b) {
                char charAt2 = this.f5115a.charAt(i);
                if (Character.isLowSurrogate(charAt2)) {
                    this.f5117c++;
                    return Character.toCodePoint(charAt, charAt2);
                }
            }
            return charAt;
        }
        throw new NoSuchElementException();
    }

    /* renamed from: b */
    private int m12383b() {
        if (!this.f5116b) {
            return this.f5115a.length();
        }
        if (this.f5118d == -1) {
            this.f5118d = this.f5115a.length();
        }
        return this.f5118d;
    }
}

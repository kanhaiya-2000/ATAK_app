package atakplugin.UASTool;

import java.util.StringTokenizer;

public class bzw implements cbu {

    /* renamed from: a */
    private cbm<?> f4397a;

    /* renamed from: b */
    private cco[] f4398b;

    /* renamed from: c */
    private String f4399c;

    public bzw(String str, cbm cbm) {
        this.f4397a = cbm;
        this.f4399c = str;
        StringTokenizer stringTokenizer = new StringTokenizer(str.startsWith("(") ? str.substring(1, str.length() - 1) : str, ",");
        this.f4398b = new cco[stringTokenizer.countTokens()];
        int i = 0;
        while (true) {
            cco[] ccoArr = this.f4398b;
            if (i < ccoArr.length) {
                ccoArr[i] = new cak(stringTokenizer.nextToken().trim());
                i++;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public cbm mo4276a() {
        return this.f4397a;
    }

    /* renamed from: b */
    public cco[] mo4277b() {
        return this.f4398b;
    }

    public String toString() {
        return "declare precedence : " + this.f4399c;
    }
}

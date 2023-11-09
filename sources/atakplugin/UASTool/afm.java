package atakplugin.UASTool;

import java.util.logging.Level;
import java.util.logging.Logger;

public class afm extends afp {

    /* renamed from: a */
    Logger f864a;

    public afm(String str) {
        this.f864a = Logger.getLogger(str);
    }

    /* renamed from: a */
    public void mo574a(String str) {
        this.f864a.log(Level.FINE, str);
    }

    /* renamed from: b */
    public void mo575b(String str) {
        this.f864a.log(Level.WARNING, str);
    }

    /* renamed from: c */
    public void mo576c(String str) {
        this.f864a.log(Level.SEVERE, str);
    }
}

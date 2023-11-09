package atakplugin.UASTool;

import com.o3dr.services.android.lib.drone.companion.solo.controller.SoloControllerUnits;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.logging.Logger;

/* renamed from: atakplugin.UASTool.wz */
public class C1014wz {

    /* renamed from: a */
    public static final String f7540a;

    /* renamed from: b */
    private static final Logger f7541b;

    static {
        String str;
        Class<C1014wz> cls = C1014wz.class;
        f7541b = Logger.getLogger(cls.getName());
        try {
            str = new LineNumberReader(new InputStreamReader(cls.getResourceAsStream("/version.txt"))).readLine();
        } catch (IOException e) {
            f7541b.warning(e.getMessage());
            str = SoloControllerUnits.UNKNOWN;
        }
        f7540a = str;
    }
}

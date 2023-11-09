package indago.time;

import atakplugin.UASTool.aot;
import atakplugin.UASTool.bdk;
import atakplugin.UASTool.bfr;
import java.text.SimpleDateFormat;

@aot(mo1534a = 3, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo1538e = {"<anonymous>", "Ljava/text/SimpleDateFormat;", "invoke"})
final class CoordinatedTime$Companion$takFormatter$2 extends bfr implements bdk<SimpleDateFormat> {
    public static final CoordinatedTime$Companion$takFormatter$2 INSTANCE = new CoordinatedTime$Companion$takFormatter$2();

    CoordinatedTime$Companion$takFormatter$2() {
        super(0);
    }

    public final SimpleDateFormat invoke() {
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    }
}

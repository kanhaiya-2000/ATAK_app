package indago.connection;

import atakplugin.UASTool.aot;
import atakplugin.UASTool.bdk;
import atakplugin.UASTool.bfr;
import atakplugin.UASTool.bra;
import atakplugin.UASTool.brw;
import java.util.concurrent.TimeUnit;

@aot(mo1534a = 3, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, mo1538e = {"<anonymous>", "Lokhttp3/OkHttpClient;", "kotlin.jvm.PlatformType", "invoke"})
final class VehicleConnection$client$2 extends bfr implements bdk<brw> {
    final /* synthetic */ long $connectionTimeoutMillis;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VehicleConnection$client$2(long j) {
        super(0);
        this.$connectionTimeoutMillis = j;
    }

    public final brw invoke() {
        return new brw.C0231a().mo3296a(this.$connectionTimeoutMillis, TimeUnit.MILLISECONDS).mo3321c(20, TimeUnit.SECONDS).mo3315b(20, TimeUnit.SECONDS).mo3300a(new bra(0, 1, TimeUnit.MILLISECONDS)).mo3322c(true).pingInterval(20, TimeUnit.SECONDS).mo3323c();
    }
}

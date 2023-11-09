package indago.connection;

import atakplugin.UASTool.aot;
import atakplugin.UASTool.aqr;
import atakplugin.UASTool.bdl;
import atakplugin.UASTool.bfl;
import atakplugin.UASTool.bgp;
import atakplugin.UASTool.bjk;

@aot(mo1534a = 3, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0018\u00010\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\b\u0007"}, mo1538e = {"<anonymous>", "", "p1", "", "Lkotlin/ParameterName;", "name", "error", "invoke"})
final /* synthetic */ class VehicleConnection$connect$1$listener$2 extends bfl implements bdl<Throwable, aqr> {
    VehicleConnection$connect$1$listener$2(VehicleConnection vehicleConnection) {
        super(1, vehicleConnection);
    }

    public final String getName() {
        return "onClosed";
    }

    public final bjk getOwner() {
        return bgp.m6715b(VehicleConnection.class);
    }

    public final String getSignature() {
        return "onClosed(Ljava/lang/Throwable;)V";
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return aqr.f2177a;
    }

    public final void invoke(Throwable th) {
        ((VehicleConnection) this.receiver).onClosed(th);
    }
}

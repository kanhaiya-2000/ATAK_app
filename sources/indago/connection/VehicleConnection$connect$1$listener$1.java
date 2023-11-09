package indago.connection;

import atakplugin.UASTool.aot;
import atakplugin.UASTool.aqr;
import atakplugin.UASTool.bdk;
import atakplugin.UASTool.bfl;
import atakplugin.UASTool.bgp;
import atakplugin.UASTool.bjk;

@aot(mo1534a = 3, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, mo1538e = {"<anonymous>", "", "invoke"})
final /* synthetic */ class VehicleConnection$connect$1$listener$1 extends bfl implements bdk<aqr> {
    VehicleConnection$connect$1$listener$1(VehicleConnection vehicleConnection) {
        super(0, vehicleConnection);
    }

    public final String getName() {
        return "onOpened";
    }

    public final bjk getOwner() {
        return bgp.m6715b(VehicleConnection.class);
    }

    public final String getSignature() {
        return "onOpened()V";
    }

    public final void invoke() {
        ((VehicleConnection) this.receiver).onOpened();
    }
}

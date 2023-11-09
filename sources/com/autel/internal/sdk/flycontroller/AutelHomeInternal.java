package com.autel.internal.sdk.flycontroller;

import com.autel.common.flycontroller.FlyHome;
import com.autel.common.mission.AutelCoordinate3D;

public class AutelHomeInternal implements FlyHome {
    private AutelCoordinate3D autelCoord3D = new AutelCoordinate3D(0.0d);

    public AutelCoordinate3D getAutelCoord3D() {
        return this.autelCoord3D;
    }

    public boolean isHomeChanged(AutelCoordinate3D autelCoordinate3D) {
        return this.autelCoord3D.getLatitude() == autelCoordinate3D.getLatitude() && this.autelCoord3D.getLongitude() == autelCoordinate3D.getLongitude() && this.autelCoord3D.getAltitude() == autelCoordinate3D.getAltitude();
    }

    public boolean isValid() {
        return (getAutelCoord3D().getLatitude() == 0.0d || getAutelCoord3D().getLongitude() == 0.0d) ? false : true;
    }

    public String toString() {
        return "latitude : " + this.autelCoord3D.getLatitude() + ",　longitude : " + this.autelCoord3D.getLongitude() + ",　altitude : " + this.autelCoord3D.getAltitude();
    }
}

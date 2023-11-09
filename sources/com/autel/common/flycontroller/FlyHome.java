package com.autel.common.flycontroller;

import com.autel.common.mission.AutelCoordinate3D;

public interface FlyHome {
    AutelCoordinate3D getAutelCoord3D();

    boolean isHomeChanged(AutelCoordinate3D autelCoordinate3D);

    boolean isValid();
}

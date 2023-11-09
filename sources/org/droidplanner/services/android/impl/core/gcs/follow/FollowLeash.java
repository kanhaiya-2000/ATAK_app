package org.droidplanner.services.android.impl.core.gcs.follow;

import android.os.Handler;
import com.o3dr.services.android.lib.coordinate.LatLong;
import com.o3dr.services.android.lib.coordinate.LatLongAlt;
import com.o3dr.services.android.lib.drone.attribute.AttributeType;
import com.o3dr.services.android.lib.drone.property.Gps;
import org.droidplanner.services.android.impl.core.drone.manager.MavLinkDroneManager;
import org.droidplanner.services.android.impl.core.gcs.follow.FollowAlgorithm;
import org.droidplanner.services.android.impl.core.gcs.location.Location;
import org.droidplanner.services.android.impl.core.helpers.geoTools.GeoTools;

public class FollowLeash extends FollowWithRadiusAlgorithm {
    public FollowLeash(MavLinkDroneManager mavLinkDroneManager, Handler handler, double d) {
        super(mavLinkDroneManager, handler, d);
    }

    public FollowAlgorithm.FollowModes getType() {
        return FollowAlgorithm.FollowModes.LEASH;
    }

    /* access modifiers changed from: protected */
    public void processNewLocation(Location location) {
        LatLongAlt coord = location.getCoord();
        LatLong position = ((Gps) this.drone.getAttribute(AttributeType.GPS)).getPosition();
        if (coord != null && position != null && GeoTools.getDistance(coord, position) > this.radius) {
            this.drone.getGuidedPoint().newGuidedCoord(GeoTools.newCoordFromBearingAndDistance(coord, GeoTools.getHeadingFromCoordinates(coord, position), this.radius));
        }
    }
}

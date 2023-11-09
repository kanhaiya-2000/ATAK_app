package org.droidplanner.services.android.impl.core.drone.variables;

import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_camera_feedback;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_mount_status;
import com.o3dr.services.android.lib.coordinate.LatLong;
import com.o3dr.services.android.lib.drone.attribute.AttributeType;
import com.o3dr.services.android.lib.drone.property.Altitude;
import com.o3dr.services.android.lib.drone.property.Attitude;
import com.o3dr.services.android.lib.drone.property.Gps;
import java.util.ArrayList;
import java.util.List;
import org.droidplanner.services.android.impl.core.drone.DroneInterfaces;
import org.droidplanner.services.android.impl.core.drone.DroneVariable;
import org.droidplanner.services.android.impl.core.drone.autopilot.MavLinkDrone;
import org.droidplanner.services.android.impl.core.survey.CameraInfo;
import org.droidplanner.services.android.impl.core.survey.Footprint;

public class Camera extends DroneVariable {
    private CameraInfo camera = new CameraInfo();
    private List<Footprint> footprints = new ArrayList();
    private double gimbal_pitch;

    public Camera(MavLinkDrone mavLinkDrone) {
        super(mavLinkDrone);
    }

    public void newImageLocation(msg_camera_feedback msg_camera_feedback) {
        this.footprints.add(new Footprint(this.camera, msg_camera_feedback));
        this.myDrone.notifyDroneEvent(DroneInterfaces.DroneEventsType.FOOTPRINT);
    }

    public List<Footprint> getFootprints() {
        return this.footprints;
    }

    public Footprint getLastFootprint() {
        List<Footprint> list = this.footprints;
        return list.get(list.size() - 1);
    }

    public CameraInfo getCamera() {
        return this.camera;
    }

    public Footprint getCurrentFieldOfView() {
        double altitude = ((Altitude) this.myDrone.getAttribute(AttributeType.ALTITUDE)).getAltitude();
        LatLong position = ((Gps) this.myDrone.getAttribute(AttributeType.GPS)).getPosition();
        Attitude attitude = (Attitude) this.myDrone.getAttribute(AttributeType.ATTITUDE);
        return new Footprint(this.camera, position, altitude, attitude.getPitch(), attitude.getRoll(), attitude.getYaw());
    }

    public void updateMountOrientation(msg_mount_status msg_mount_status) {
        this.gimbal_pitch = (double) (90 - (msg_mount_status.pointing_a / 100));
    }
}

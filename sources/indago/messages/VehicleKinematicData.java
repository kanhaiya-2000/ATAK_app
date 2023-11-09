package indago.messages;

import atakplugin.UASTool.aot;
import atakplugin.UASTool.bfq;
import indago.datastructures.Vector3;
import indago.location.GeoLocation;
import indago.pose.CameraFieldOfView;
import indago.serialization.JsonKeyConstants;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\fHÆ\u0003JK\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006&"}, mo1538e = {"Lindago/messages/VehicleKinematicData;", "", "messageData", "Lindago/messages/MessageData;", "time", "", "position", "Lindago/location/GeoLocation;", "groundSpeed", "Lindago/datastructures/Vector3;", "rollPitchYaw", "cameraFieldOfView", "Lindago/pose/CameraFieldOfView;", "(Lindago/messages/MessageData;Ljava/lang/String;Lindago/location/GeoLocation;Lindago/datastructures/Vector3;Lindago/datastructures/Vector3;Lindago/pose/CameraFieldOfView;)V", "getCameraFieldOfView", "()Lindago/pose/CameraFieldOfView;", "getGroundSpeed", "()Lindago/datastructures/Vector3;", "getMessageData", "()Lindago/messages/MessageData;", "getPosition", "()Lindago/location/GeoLocation;", "getRollPitchYaw", "getTime", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "indago"})
public final class VehicleKinematicData {
    private final CameraFieldOfView cameraFieldOfView;
    private final Vector3 groundSpeed;
    private final MessageData messageData;
    private final GeoLocation position;
    private final Vector3 rollPitchYaw;
    private final String time;

    public static /* synthetic */ VehicleKinematicData copy$default(VehicleKinematicData vehicleKinematicData, MessageData messageData2, String str, GeoLocation geoLocation, Vector3 vector3, Vector3 vector32, CameraFieldOfView cameraFieldOfView2, int i, Object obj) {
        if ((i & 1) != 0) {
            messageData2 = vehicleKinematicData.messageData;
        }
        if ((i & 2) != 0) {
            str = vehicleKinematicData.time;
        }
        String str2 = str;
        if ((i & 4) != 0) {
            geoLocation = vehicleKinematicData.position;
        }
        GeoLocation geoLocation2 = geoLocation;
        if ((i & 8) != 0) {
            vector3 = vehicleKinematicData.groundSpeed;
        }
        Vector3 vector33 = vector3;
        if ((i & 16) != 0) {
            vector32 = vehicleKinematicData.rollPitchYaw;
        }
        Vector3 vector34 = vector32;
        if ((i & 32) != 0) {
            cameraFieldOfView2 = vehicleKinematicData.cameraFieldOfView;
        }
        return vehicleKinematicData.copy(messageData2, str2, geoLocation2, vector33, vector34, cameraFieldOfView2);
    }

    public final MessageData component1() {
        return this.messageData;
    }

    public final String component2() {
        return this.time;
    }

    public final GeoLocation component3() {
        return this.position;
    }

    public final Vector3 component4() {
        return this.groundSpeed;
    }

    public final Vector3 component5() {
        return this.rollPitchYaw;
    }

    public final CameraFieldOfView component6() {
        return this.cameraFieldOfView;
    }

    public final VehicleKinematicData copy(MessageData messageData2, String str, GeoLocation geoLocation, Vector3 vector3, Vector3 vector32, CameraFieldOfView cameraFieldOfView2) {
        bfq.m6567f(messageData2, "messageData");
        bfq.m6567f(vector3, JsonKeyConstants.GROUND_SPEED);
        bfq.m6567f(vector32, JsonKeyConstants.ROLL_PITCH_YAW);
        return new VehicleKinematicData(messageData2, str, geoLocation, vector3, vector32, cameraFieldOfView2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VehicleKinematicData)) {
            return false;
        }
        VehicleKinematicData vehicleKinematicData = (VehicleKinematicData) obj;
        return bfq.m6552a((Object) this.messageData, (Object) vehicleKinematicData.messageData) && bfq.m6552a((Object) this.time, (Object) vehicleKinematicData.time) && bfq.m6552a((Object) this.position, (Object) vehicleKinematicData.position) && bfq.m6552a((Object) this.groundSpeed, (Object) vehicleKinematicData.groundSpeed) && bfq.m6552a((Object) this.rollPitchYaw, (Object) vehicleKinematicData.rollPitchYaw) && bfq.m6552a((Object) this.cameraFieldOfView, (Object) vehicleKinematicData.cameraFieldOfView);
    }

    public int hashCode() {
        MessageData messageData2 = this.messageData;
        int i = 0;
        int hashCode = (messageData2 != null ? messageData2.hashCode() : 0) * 31;
        String str = this.time;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        GeoLocation geoLocation = this.position;
        int hashCode3 = (hashCode2 + (geoLocation != null ? geoLocation.hashCode() : 0)) * 31;
        Vector3 vector3 = this.groundSpeed;
        int hashCode4 = (hashCode3 + (vector3 != null ? vector3.hashCode() : 0)) * 31;
        Vector3 vector32 = this.rollPitchYaw;
        int hashCode5 = (hashCode4 + (vector32 != null ? vector32.hashCode() : 0)) * 31;
        CameraFieldOfView cameraFieldOfView2 = this.cameraFieldOfView;
        if (cameraFieldOfView2 != null) {
            i = cameraFieldOfView2.hashCode();
        }
        return hashCode5 + i;
    }

    public String toString() {
        return "VehicleKinematicData(messageData=" + this.messageData + ", time=" + this.time + ", position=" + this.position + ", groundSpeed=" + this.groundSpeed + ", rollPitchYaw=" + this.rollPitchYaw + ", cameraFieldOfView=" + this.cameraFieldOfView + ")";
    }

    public VehicleKinematicData(MessageData messageData2, String str, GeoLocation geoLocation, Vector3 vector3, Vector3 vector32, CameraFieldOfView cameraFieldOfView2) {
        bfq.m6567f(messageData2, "messageData");
        bfq.m6567f(vector3, JsonKeyConstants.GROUND_SPEED);
        bfq.m6567f(vector32, JsonKeyConstants.ROLL_PITCH_YAW);
        this.messageData = messageData2;
        this.time = str;
        this.position = geoLocation;
        this.groundSpeed = vector3;
        this.rollPitchYaw = vector32;
        this.cameraFieldOfView = cameraFieldOfView2;
    }

    public final MessageData getMessageData() {
        return this.messageData;
    }

    public final String getTime() {
        return this.time;
    }

    public final GeoLocation getPosition() {
        return this.position;
    }

    public final Vector3 getGroundSpeed() {
        return this.groundSpeed;
    }

    public final Vector3 getRollPitchYaw() {
        return this.rollPitchYaw;
    }

    public final CameraFieldOfView getCameraFieldOfView() {
        return this.cameraFieldOfView;
    }
}

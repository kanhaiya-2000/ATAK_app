package indago.connection;

import atakplugin.UASTool.aot;
import indago.messages.EventMessage;
import indago.messages.HomeGeolocation;
import indago.messages.SavedFlightPlans;
import indago.messages.VehicleKinematicData;
import indago.messages.VehicleStatus;
import indago.messages.VideoGeolocation;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H&¨\u0006\u0015"}, mo1538e = {"Lindago/connection/MessageReceivedCallback;", "", "onEventMessageReceived", "", "eventMessage", "Lindago/messages/EventMessage;", "onHomeGeolocationMessageReceived", "homeGeoloaction", "Lindago/messages/HomeGeolocation;", "onSavedFlightPlansMessageReceived", "savedFlightPlans", "Lindago/messages/SavedFlightPlans;", "onVehicleKinematicMessageReceived", "vehicleKinematicData", "Lindago/messages/VehicleKinematicData;", "onVehicleStatusMessageReceived", "vehicleStatus", "Lindago/messages/VehicleStatus;", "onVideoGeolocationMessageReceived", "videoGeolocation", "Lindago/messages/VideoGeolocation;", "indago"})
public interface MessageReceivedCallback {
    void onEventMessageReceived(EventMessage eventMessage);

    void onHomeGeolocationMessageReceived(HomeGeolocation homeGeolocation);

    void onSavedFlightPlansMessageReceived(SavedFlightPlans savedFlightPlans);

    void onVehicleKinematicMessageReceived(VehicleKinematicData vehicleKinematicData);

    void onVehicleStatusMessageReceived(VehicleStatus vehicleStatus);

    void onVideoGeolocationMessageReceived(VideoGeolocation videoGeolocation);
}

package indago.connection;

import atakplugin.UASTool.aot;
import atakplugin.UASTool.bfq;
import indago.messages.EventMessage;
import indago.messages.HomeGeolocation;
import indago.messages.SavedFlightPlans;
import indago.messages.VehicleKinematicData;
import indago.messages.VehicleStatus;
import indago.messages.VideoGeolocation;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0015H\u0016¨\u0006\u0016"}, mo1538e = {"Lindago/connection/SimpleMessageReceivedCallback;", "Lindago/connection/MessageReceivedCallback;", "()V", "onEventMessageReceived", "", "eventMessage", "Lindago/messages/EventMessage;", "onHomeGeolocationMessageReceived", "homeGeoloaction", "Lindago/messages/HomeGeolocation;", "onSavedFlightPlansMessageReceived", "savedFlightPlans", "Lindago/messages/SavedFlightPlans;", "onVehicleKinematicMessageReceived", "vehicleKinematicData", "Lindago/messages/VehicleKinematicData;", "onVehicleStatusMessageReceived", "vehicleStatus", "Lindago/messages/VehicleStatus;", "onVideoGeolocationMessageReceived", "videoGeolocation", "Lindago/messages/VideoGeolocation;", "indago"})
public class SimpleMessageReceivedCallback implements MessageReceivedCallback {
    public void onEventMessageReceived(EventMessage eventMessage) {
        bfq.m6567f(eventMessage, "eventMessage");
    }

    public void onHomeGeolocationMessageReceived(HomeGeolocation homeGeolocation) {
        bfq.m6567f(homeGeolocation, "homeGeoloaction");
    }

    public void onSavedFlightPlansMessageReceived(SavedFlightPlans savedFlightPlans) {
        bfq.m6567f(savedFlightPlans, "savedFlightPlans");
    }

    public void onVehicleKinematicMessageReceived(VehicleKinematicData vehicleKinematicData) {
        bfq.m6567f(vehicleKinematicData, "vehicleKinematicData");
    }

    public void onVehicleStatusMessageReceived(VehicleStatus vehicleStatus) {
        bfq.m6567f(vehicleStatus, "vehicleStatus");
    }

    public void onVideoGeolocationMessageReceived(VideoGeolocation videoGeolocation) {
        bfq.m6567f(videoGeolocation, "videoGeolocation");
    }
}

package indago.serialization;

import atakplugin.UASTool.aot;
import indago.messages.ChangeFlightMode;
import indago.messages.CheckFlightReadiness;
import indago.messages.DesiredSearchArea;
import indago.messages.EventMessage;
import indago.messages.HomeGeolocation;
import indago.messages.LoadFlightPlan;
import indago.messages.SavedFlightPlans;
import indago.messages.UnsupportedMessageAdvisory;
import indago.messages.VehicleKinematicData;
import indago.messages.VehicleStatus;
import indago.messages.VideoGeolocation;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H&J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001aH&J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001dH&J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020 H&J\u0010\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020#H&¨\u0006$"}, mo1538e = {"Lindago/serialization/MessageDeserializationCallback;", "", "onChangeFlightModeDeserialized", "", "flightMode", "Lindago/messages/ChangeFlightMode;", "onCheckFlightReadinessDeserialized", "checkFlightReadiness", "Lindago/messages/CheckFlightReadiness;", "onDesiredSearchAreaDeserialized", "desiredSearchArea", "Lindago/messages/DesiredSearchArea;", "onEventMessageDeserialized", "eventMessage", "Lindago/messages/EventMessage;", "onHomeGeolocationDeserialized", "homeGeolocation", "Lindago/messages/HomeGeolocation;", "onLoadFlightPlanDeserialized", "loadFlightPlan", "Lindago/messages/LoadFlightPlan;", "onSavedFlightPlansDeserialized", "savedFlightPlans", "Lindago/messages/SavedFlightPlans;", "onUnsupportedMessageAdvisoryDeserialized", "unsupportedMessageAdvisory", "Lindago/messages/UnsupportedMessageAdvisory;", "onVehicleKinematicDataDeserialized", "vehicleKinematicData", "Lindago/messages/VehicleKinematicData;", "onVehicleStatusDeserialized", "vehicleStatus", "Lindago/messages/VehicleStatus;", "onVideoGeolocationDeserialized", "videoGeolocation", "Lindago/messages/VideoGeolocation;", "indago"})
public interface MessageDeserializationCallback {
    void onChangeFlightModeDeserialized(ChangeFlightMode changeFlightMode);

    void onCheckFlightReadinessDeserialized(CheckFlightReadiness checkFlightReadiness);

    void onDesiredSearchAreaDeserialized(DesiredSearchArea desiredSearchArea);

    void onEventMessageDeserialized(EventMessage eventMessage);

    void onHomeGeolocationDeserialized(HomeGeolocation homeGeolocation);

    void onLoadFlightPlanDeserialized(LoadFlightPlan loadFlightPlan);

    void onSavedFlightPlansDeserialized(SavedFlightPlans savedFlightPlans);

    void onUnsupportedMessageAdvisoryDeserialized(UnsupportedMessageAdvisory unsupportedMessageAdvisory);

    void onVehicleKinematicDataDeserialized(VehicleKinematicData vehicleKinematicData);

    void onVehicleStatusDeserialized(VehicleStatus vehicleStatus);

    void onVideoGeolocationDeserialized(VideoGeolocation videoGeolocation);
}

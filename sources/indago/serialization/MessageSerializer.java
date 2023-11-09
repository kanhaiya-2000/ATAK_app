package indago.serialization;

import atakplugin.UASTool.aot;
import indago.messages.ChangeFlightMode;
import indago.messages.CheckFlightReadiness;
import indago.messages.DesiredSearchArea;
import indago.messages.EventMessage;
import indago.messages.HomeGeolocation;
import indago.messages.LoadFlightPlan;
import indago.messages.LookAtPosition;
import indago.messages.PayloadControl;
import indago.messages.SavedFlightPlans;
import indago.messages.UnsupportedMessageAdvisory;
import indago.messages.VehicleKinematicData;
import indago.messages.VehicleStatus;
import indago.messages.VideoGeolocation;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0017H&J\u0010\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001aH&J\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001dH&J\u0010\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020 H&J\u0010\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020#H&J\u0010\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020&H&J\u0010\u0010'\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020)H&J\u0010\u0010*\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020,H&J\u0010\u0010-\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020/H&J\u0010\u00100\u001a\u00020\u000b2\u0006\u00101\u001a\u000202H&R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u00063"}, mo1538e = {"Lindago/serialization/MessageSerializer;", "", "deserializationCallback", "Lindago/serialization/MessageDeserializationCallback;", "getDeserializationCallback", "()Lindago/serialization/MessageDeserializationCallback;", "setDeserializationCallback", "(Lindago/serialization/MessageDeserializationCallback;)V", "deserializeData", "", "data", "", "serializeChangeFlightMode", "changeFlightMode", "Lindago/messages/ChangeFlightMode;", "serializeCheckFlightReadiness", "checkFlightReadiness", "Lindago/messages/CheckFlightReadiness;", "serializeDesiredSearchArea", "desiredSearchArea", "Lindago/messages/DesiredSearchArea;", "serializeEventMessage", "eventMessage", "Lindago/messages/EventMessage;", "serializeHomeGeolocation", "homeGeolocation", "Lindago/messages/HomeGeolocation;", "serializeLoadFlightPlan", "loadFlightPlan", "Lindago/messages/LoadFlightPlan;", "serializeLookAtPosition", "lookAtPosition", "Lindago/messages/LookAtPosition;", "serializePayloadControl", "payloadControl", "Lindago/messages/PayloadControl;", "serializeSavedFlightPlans", "savedFlightPlans", "Lindago/messages/SavedFlightPlans;", "serializeUnsupportedMessageAdvisory", "unsupportedMessageAdvisory", "Lindago/messages/UnsupportedMessageAdvisory;", "serializeVehicleKinematicData", "kinematicData", "Lindago/messages/VehicleKinematicData;", "serializeVehicleStatus", "vehicleStatus", "Lindago/messages/VehicleStatus;", "serializeVideoGeolocation", "videoGeolocation", "Lindago/messages/VideoGeolocation;", "indago"})
public interface MessageSerializer {
    void deserializeData(String str);

    MessageDeserializationCallback getDeserializationCallback();

    String serializeChangeFlightMode(ChangeFlightMode changeFlightMode);

    String serializeCheckFlightReadiness(CheckFlightReadiness checkFlightReadiness);

    String serializeDesiredSearchArea(DesiredSearchArea desiredSearchArea);

    String serializeEventMessage(EventMessage eventMessage);

    String serializeHomeGeolocation(HomeGeolocation homeGeolocation);

    String serializeLoadFlightPlan(LoadFlightPlan loadFlightPlan);

    String serializeLookAtPosition(LookAtPosition lookAtPosition);

    String serializePayloadControl(PayloadControl payloadControl);

    String serializeSavedFlightPlans(SavedFlightPlans savedFlightPlans);

    String serializeUnsupportedMessageAdvisory(UnsupportedMessageAdvisory unsupportedMessageAdvisory);

    String serializeVehicleKinematicData(VehicleKinematicData vehicleKinematicData);

    String serializeVehicleStatus(VehicleStatus vehicleStatus);

    String serializeVideoGeolocation(VideoGeolocation videoGeolocation);

    void setDeserializationCallback(MessageDeserializationCallback messageDeserializationCallback);
}

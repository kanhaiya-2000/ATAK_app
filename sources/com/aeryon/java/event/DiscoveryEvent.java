package com.aeryon.java.event;

import com.aeryon.java.event.BaseEvent;
import com.aeryon.java.types.DeviceInfo;

public class DiscoveryEvent extends BaseEvent {
    private DeviceInfo deviceInfo;
    private DISCOVERY_EVENT_TYPE type;

    public enum DISCOVERY_EVENT_TYPE {
        NEW,
        UPDATE,
        LOST,
        UNKNOWN
    }

    public DiscoveryEvent(long j, DeviceInfo deviceInfo2, int i) {
        super(j, BaseEvent.EVENT_BASE_TYPE.ADK_EV_Discovery);
        this.deviceInfo = deviceInfo2;
        if (i == 0) {
            this.type = DISCOVERY_EVENT_TYPE.NEW;
        } else if (i == 1) {
            this.type = DISCOVERY_EVENT_TYPE.UPDATE;
        } else if (i != 2) {
            this.type = DISCOVERY_EVENT_TYPE.UNKNOWN;
        } else {
            this.type = DISCOVERY_EVENT_TYPE.LOST;
        }
    }

    public DISCOVERY_EVENT_TYPE getType() {
        return this.type;
    }

    public DeviceInfo getDeviceInfo() {
        return this.deviceInfo;
    }

    public String toString() {
        return "Discovery Event " + this.type.name() + ":\n" + this.deviceInfo.toJson();
    }
}

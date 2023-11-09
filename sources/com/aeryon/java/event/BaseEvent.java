package com.aeryon.java.event;

public class BaseEvent {
    private final EVENT_BASE_TYPE baseType;
    private final long eventUid;

    public enum EVENT_BASE_TYPE {
        ADK_EV_Discovery,
        ADK_EV_Auth,
        ADK_EV_Navigation,
        ADK_EV_Camera,
        ADK_EV_Gimbal,
        ADK_EV_Fault,
        ADK_EV_ObjectModel,
        ADK_EV_Vision,
        ADK_EV_Live,
        ADK_EV_Last
    }

    public BaseEvent(long j, EVENT_BASE_TYPE event_base_type) {
        this.eventUid = j;
        this.baseType = event_base_type;
    }
}

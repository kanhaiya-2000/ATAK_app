package com.atakmap.android.uastool.p000av;

/* renamed from: com.atakmap.android.uastool.av.MissionSetFrames */
class MissionSetFrames extends GCSUplinkMessageSet {
    public void addMissionWaypoint(MissionWaypointFrame missionWaypointFrame) {
        addMessage(missionWaypointFrame);
    }

    public void addMissionParameter(MissionParameterFrame missionParameterFrame) {
        addMessage(missionParameterFrame);
    }
}

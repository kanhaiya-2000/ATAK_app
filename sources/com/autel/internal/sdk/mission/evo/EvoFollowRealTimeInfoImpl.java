package com.autel.internal.sdk.mission.evo;

import com.autel.common.camera.visual.TrackingArea;
import com.autel.common.mission.evo.EvoTrackingRealTimeInfo;

public class EvoFollowRealTimeInfoImpl implements EvoTrackingRealTimeInfo {
    public TrackingArea mTrackingArea;

    public TrackingArea getTrackingArea() {
        return this.mTrackingArea;
    }
}

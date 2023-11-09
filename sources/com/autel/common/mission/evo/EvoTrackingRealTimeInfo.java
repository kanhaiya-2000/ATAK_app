package com.autel.common.mission.evo;

import com.autel.common.camera.visual.TrackingArea;
import com.autel.common.mission.RealTimeInfo;

public interface EvoTrackingRealTimeInfo extends RealTimeInfo {
    TrackingArea getTrackingArea();
}

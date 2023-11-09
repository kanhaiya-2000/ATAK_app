package com.autel.sdk10.AutelNet.AutelMission.interfaces;

import com.autel.common.mission.xstar.Waypoint;
import com.autel.internal.sdk.mission.AutelOrbitRealTimeInfoInternal;
import com.autel.internal.sdk.mission.AutelWaypointRealTimeInfoInternal;
import java.util.ArrayList;

public class AutelMissionInterface {

    public interface ICurrentWaypointMissionRequestListener {
        void onDownloadWaypointInfo(int i, int i2);

        void onEndRequest(ArrayList<Waypoint> arrayList);

        void onRecWaypointCount(int i);

        void onStartRequest(boolean z);

        void onTimeOut();
    }

    public interface IOrbitRealtimeInfoListener {
        void onOrbitRealtimeInfo(AutelOrbitRealTimeInfoInternal autelOrbitRealTimeInfoInternal);
    }

    public interface IWaypointMissionDownloadListener {
        void onProgress(float f);

        void onResult(ArrayList<Waypoint> arrayList);
    }

    public interface IWaypointMissionUploadListener {
        void onProgress(float f);

        void onResult(boolean z);
    }

    public interface IWaypointRealtimeInfoListener {
        void onWaypointRealtimeInfo(AutelWaypointRealTimeInfoInternal autelWaypointRealTimeInfoInternal);
    }

    public interface IWaypointUploadStatusListener {
        void onEndUpload(boolean z);

        void onStartUpload(boolean z);

        void onTimeOut();

        void onUploadWaypoint(int i);
    }
}

package com.autel.AutelNet2.aircraft.mission.interfaces;

import com.autel.common.mission.xstar.Waypoint;
import java.util.ArrayList;

public interface IWaypointRequestListener {
    void onDownloading(int i, int i2);

    void onEnd(ArrayList<Waypoint> arrayList);

    void onRecWaypointCount(int i);

    void onStart();

    void onTimeOut();
}

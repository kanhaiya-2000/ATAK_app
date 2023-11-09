package com.autel.internal.sdk.mission.evo;

import android.location.Location;
import com.autel.common.mission.evo.EvoFollowMission;

public class EvoFollowMissionWithUpdate extends EvoFollowMission {
    private UpdateListener updateListener;

    public interface UpdateListener {
        void update(Location location);
    }

    public void setUpdateListener(UpdateListener updateListener2) {
        this.updateListener = updateListener2;
    }

    public void update(Location location) {
        UpdateListener updateListener2 = this.updateListener;
        if (updateListener2 != null) {
            updateListener2.update(location);
        }
    }
}

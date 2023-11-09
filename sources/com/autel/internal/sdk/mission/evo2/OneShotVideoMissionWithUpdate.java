package com.autel.internal.sdk.mission.evo2;

import android.location.Location;
import com.autel.common.mission.evo.OneShotVideoMission;
import com.autel.internal.sdk.mission.FollowMissionWithUpdate;

public class OneShotVideoMissionWithUpdate extends OneShotVideoMission {
    private FollowMissionWithUpdate.UpdateListener updateListener;

    public interface UpdateListener {
        void update(Location location);
    }

    public void setUpdateListener(FollowMissionWithUpdate.UpdateListener updateListener2) {
        this.updateListener = updateListener2;
    }

    public void update(Location location) {
        FollowMissionWithUpdate.UpdateListener updateListener2 = this.updateListener;
        if (updateListener2 != null) {
            updateListener2.update(location);
        }
    }
}

package com.o3dr.android.client.apis;

import android.location.Location;
import android.os.Bundle;
import com.o3dr.android.client.Drone;
import com.o3dr.android.client.apis.Api;
import com.o3dr.services.android.lib.gcs.action.FollowMeActions;
import com.o3dr.services.android.lib.gcs.follow.FollowLocationSource;
import com.o3dr.services.android.lib.gcs.follow.FollowType;
import com.o3dr.services.android.lib.model.action.Action;
import java.util.concurrent.ConcurrentHashMap;

public class FollowApi extends Api {
    private static final Api.Builder<FollowApi> apiBuilder = new Api.Builder<FollowApi>() {
        public FollowApi build(Drone drone) {
            return new FollowApi(drone);
        }
    };
    private static final ConcurrentHashMap<Drone, FollowApi> followApiCache = new ConcurrentHashMap<>();
    private final Drone drone;

    public static FollowApi getApi(Drone drone2) {
        return (FollowApi) getApi(drone2, followApiCache, apiBuilder);
    }

    private FollowApi(Drone drone2) {
        this.drone = drone2;
    }

    public void enableFollowMe(FollowType followType, FollowLocationSource followLocationSource) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(FollowMeActions.EXTRA_FOLLOW_TYPE, followType);
        bundle.putParcelable(FollowMeActions.EXTRA_LOCATION_SOURCE, followLocationSource);
        this.drone.performAsyncAction(new Action(FollowMeActions.ACTION_ENABLE_FOLLOW_ME, bundle));
    }

    public void enableFollowMe(FollowType followType) {
        enableFollowMe(followType, FollowLocationSource.INTERNAL);
    }

    public void updateFollowParams(Bundle bundle) {
        this.drone.performAsyncAction(new Action(FollowMeActions.ACTION_UPDATE_FOLLOW_PARAMS, bundle));
    }

    public void disableFollowMe() {
        this.drone.performAsyncAction(new Action(FollowMeActions.ACTION_DISABLE_FOLLOW_ME));
    }

    public void updateLocation(Location location) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(FollowMeActions.EXTRA_LOCATION, location);
        this.drone.performAsyncAction(new Action(FollowMeActions.ACTION_NEW_EXTERNAL_LOCATION, bundle));
    }
}

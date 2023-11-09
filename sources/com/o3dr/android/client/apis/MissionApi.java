package com.o3dr.android.client.apis;

import android.net.Uri;
import android.os.Bundle;
import com.o3dr.android.client.Drone;
import com.o3dr.android.client.apis.Api;
import com.o3dr.services.android.lib.drone.mission.Mission;
import com.o3dr.services.android.lib.drone.mission.MissionItemType;
import com.o3dr.services.android.lib.drone.mission.action.MissionActions;
import com.o3dr.services.android.lib.drone.mission.item.MissionItem;
import com.o3dr.services.android.lib.model.AbstractCommandListener;
import com.o3dr.services.android.lib.model.action.Action;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class MissionApi extends Api {
    private static final Api.Builder<MissionApi> apiBuilder = new Api.Builder<MissionApi>() {
        public MissionApi build(Drone drone) {
            return new MissionApi(drone);
        }
    };
    private static final ConcurrentHashMap<Drone, MissionApi> missionApiCache = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */
    public final Drone drone;

    public interface LoadingCallback<T> {
        void onLoadingComplete(T t);

        void onLoadingFailed();

        void onLoadingStart();
    }

    public static MissionApi getApi(Drone drone2) {
        return (MissionApi) getApi(drone2, missionApiCache, apiBuilder);
    }

    private MissionApi(Drone drone2) {
        this.drone = drone2;
    }

    public void generateDronie() {
        this.drone.performAsyncAction(new Action(MissionActions.ACTION_GENERATE_DRONIE));
    }

    public void setMission(Mission mission, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(MissionActions.EXTRA_MISSION, mission);
        bundle.putBoolean(MissionActions.EXTRA_PUSH_TO_DRONE, z);
        this.drone.performAsyncAction(new Action(MissionActions.ACTION_SET_MISSION, bundle));
    }

    public void startMission(boolean z, boolean z2, AbstractCommandListener abstractCommandListener) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(MissionActions.EXTRA_FORCE_MODE_CHANGE, z);
        bundle.putBoolean(MissionActions.EXTRA_FORCE_ARM, z2);
        this.drone.performAsyncActionOnDroneThread(new Action(MissionActions.ACTION_START_MISSION, bundle), abstractCommandListener);
    }

    public void gotoWaypoint(int i, AbstractCommandListener abstractCommandListener) {
        Bundle bundle = new Bundle();
        bundle.putInt(MissionActions.EXTRA_MISSION_ITEM_INDEX, i);
        this.drone.performAsyncActionOnDroneThread(new Action(MissionActions.ACTION_GOTO_WAYPOINT, bundle), abstractCommandListener);
    }

    public void loadWaypoints() {
        this.drone.performAsyncAction(new Action(MissionActions.ACTION_LOAD_WAYPOINTS));
    }

    public void loadMission(Uri uri, LoadingCallback<Mission> loadingCallback) {
        loadAndSetMission(uri, false, loadingCallback);
    }

    public void loadAndSetMission(Uri uri, LoadingCallback<Mission> loadingCallback) {
        loadAndSetMission(uri, true, loadingCallback);
    }

    private void loadAndSetMission(final Uri uri, final boolean z, final LoadingCallback<Mission> loadingCallback) {
        Objects.requireNonNull(uri, "Mission source uri must be non null.");
        if (z || loadingCallback != null) {
            this.drone.getAsyncScheduler().execute(new Runnable() {
                public void run() {
                    MissionApi.this.postLoadingStart(loadingCallback);
                    Bundle bundle = new Bundle();
                    bundle.putParcelable(MissionActions.EXTRA_LOAD_MISSION_URI, uri);
                    bundle.putBoolean(MissionActions.EXTRA_SET_LOADED_MISSION, z);
                    Action action = new Action(MissionActions.ACTION_LOAD_MISSION, bundle);
                    boolean performAction = MissionApi.this.drone.performAction(action);
                    LoadingCallback loadingCallback = loadingCallback;
                    if (loadingCallback == null) {
                        return;
                    }
                    if (performAction) {
                        Mission mission = (Mission) action.getData().getParcelable(MissionActions.EXTRA_MISSION);
                        if (mission == null) {
                            MissionApi.this.postLoadingFailed(loadingCallback);
                        } else {
                            MissionApi.this.postLoadingComplete(mission, loadingCallback);
                        }
                    } else {
                        MissionApi.this.postLoadingFailed(loadingCallback);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void postLoadingStart(final LoadingCallback<?> loadingCallback) {
        if (loadingCallback != null) {
            this.drone.getHandler().post(new Runnable() {
                public void run() {
                    loadingCallback.onLoadingStart();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void postLoadingFailed(final LoadingCallback<?> loadingCallback) {
        if (loadingCallback != null) {
            this.drone.getHandler().post(new Runnable() {
                public void run() {
                    loadingCallback.onLoadingFailed();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public <T> void postLoadingComplete(final T t, final LoadingCallback<T> loadingCallback) {
        if (loadingCallback != null) {
            this.drone.getHandler().post(new Runnable() {
                public void run() {
                    loadingCallback.onLoadingComplete(t);
                }
            });
        }
    }

    public void saveMission(Mission mission, Uri uri, AbstractCommandListener abstractCommandListener) {
        Objects.requireNonNull(mission, "Mission must be non null.");
        Objects.requireNonNull(uri, "Mission destination uri must be non null.");
        Bundle bundle = new Bundle();
        bundle.putParcelable(MissionActions.EXTRA_MISSION, mission);
        bundle.putParcelable(MissionActions.EXTRA_SAVE_MISSION_URI, uri);
        this.drone.performAsyncActionOnDroneThread(new Action(MissionActions.ACTION_SAVE_MISSION, bundle), abstractCommandListener);
    }

    private Action buildComplexMissionItem(Bundle bundle) {
        Action action = new Action(MissionActions.ACTION_BUILD_COMPLEX_MISSION_ITEM, bundle);
        if (this.drone.performAction(action)) {
            return action;
        }
        return null;
    }

    public <T extends MissionItem> T buildMissionItem(MissionItem.ComplexItem<T> complexItem) {
        Action buildComplexMissionItem;
        T t = (MissionItem) complexItem;
        Bundle storeMissionItem = t.getType().storeMissionItem(t);
        if (storeMissionItem == null || (buildComplexMissionItem = buildComplexMissionItem(storeMissionItem)) == null) {
            return null;
        }
        complexItem.copy(MissionItemType.restoreMissionItemFromBundle(buildComplexMissionItem.getData()));
        return t;
    }

    public void pauseMission(AbstractCommandListener abstractCommandListener) {
        Bundle bundle = new Bundle();
        bundle.putFloat(MissionActions.EXTRA_MISSION_SPEED, 0.0f);
        this.drone.performAsyncActionOnDroneThread(new Action(MissionActions.ACTION_CHANGE_MISSION_SPEED, bundle), abstractCommandListener);
    }

    public void setMissionSpeed(float f, AbstractCommandListener abstractCommandListener) {
        Bundle bundle = new Bundle();
        bundle.putFloat(MissionActions.EXTRA_MISSION_SPEED, f);
        this.drone.performAsyncActionOnDroneThread(new Action(MissionActions.ACTION_CHANGE_MISSION_SPEED, bundle), abstractCommandListener);
    }
}

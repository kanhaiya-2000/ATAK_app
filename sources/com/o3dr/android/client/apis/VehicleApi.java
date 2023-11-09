package com.o3dr.android.client.apis;

import android.os.Bundle;
import com.o3dr.android.client.Drone;
import com.o3dr.android.client.apis.Api;
import com.o3dr.services.android.lib.coordinate.LatLongAlt;
import com.o3dr.services.android.lib.drone.action.ConnectionActions;
import com.o3dr.services.android.lib.drone.action.ParameterActions;
import com.o3dr.services.android.lib.drone.action.StateActions;
import com.o3dr.services.android.lib.drone.connection.ConnectionParameter;
import com.o3dr.services.android.lib.drone.property.Parameters;
import com.o3dr.services.android.lib.drone.property.VehicleMode;
import com.o3dr.services.android.lib.model.AbstractCommandListener;
import com.o3dr.services.android.lib.model.action.Action;
import java.util.concurrent.ConcurrentHashMap;

public class VehicleApi extends Api {
    private static final Api.Builder<VehicleApi> apiBuilder = new Api.Builder<VehicleApi>() {
        public VehicleApi build(Drone drone) {
            return new VehicleApi(drone);
        }
    };
    private static final ConcurrentHashMap<Drone, VehicleApi> vehicleApiCache = new ConcurrentHashMap<>();
    private final Drone drone;

    public static VehicleApi getApi(Drone drone2) {
        return (VehicleApi) getApi(drone2, vehicleApiCache, apiBuilder);
    }

    private VehicleApi(Drone drone2) {
        this.drone = drone2;
    }

    public void connect(ConnectionParameter connectionParameter) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(ConnectionActions.EXTRA_CONNECT_PARAMETER, connectionParameter);
        this.drone.performAsyncAction(new Action(ConnectionActions.ACTION_CONNECT, bundle));
    }

    public void disconnect() {
        this.drone.performAsyncAction(new Action(ConnectionActions.ACTION_DISCONNECT));
    }

    public void arm(boolean z) {
        arm(z, (AbstractCommandListener) null);
    }

    public void arm(boolean z, AbstractCommandListener abstractCommandListener) {
        arm(z, false, abstractCommandListener);
    }

    public void arm(boolean z, boolean z2, AbstractCommandListener abstractCommandListener) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(StateActions.EXTRA_ARM, z);
        bundle.putBoolean(StateActions.EXTRA_EMERGENCY_DISARM, z2);
        this.drone.performAsyncActionOnDroneThread(new Action(StateActions.ACTION_ARM, bundle), abstractCommandListener);
    }

    public void setVehicleMode(VehicleMode vehicleMode) {
        setVehicleMode(vehicleMode, (AbstractCommandListener) null);
    }

    public void setVehicleMode(VehicleMode vehicleMode, AbstractCommandListener abstractCommandListener) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(StateActions.EXTRA_VEHICLE_MODE, vehicleMode);
        this.drone.performAsyncActionOnDroneThread(new Action(StateActions.ACTION_SET_VEHICLE_MODE, bundle), abstractCommandListener);
    }

    public void refreshParameters() {
        this.drone.performAsyncAction(new Action(ParameterActions.ACTION_REFRESH_PARAMETERS));
    }

    public void writeParameters(Parameters parameters) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(ParameterActions.EXTRA_PARAMETERS, parameters);
        this.drone.performAsyncAction(new Action(ParameterActions.ACTION_WRITE_PARAMETERS, bundle));
    }

    public void setVehicleHome(LatLongAlt latLongAlt, AbstractCommandListener abstractCommandListener) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(StateActions.EXTRA_VEHICLE_HOME_LOCATION, latLongAlt);
        this.drone.performAsyncActionOnDroneThread(new Action(StateActions.ACTION_SET_VEHICLE_HOME, bundle), abstractCommandListener);
    }

    public void enableReturnToMe(boolean z, AbstractCommandListener abstractCommandListener) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(StateActions.EXTRA_IS_RETURN_TO_ME_ENABLED, z);
        this.drone.performAsyncActionOnDroneThread(new Action(StateActions.ACTION_ENABLE_RETURN_TO_ME, bundle), abstractCommandListener);
    }

    public void updateVehicleDataStreamRate(int i, AbstractCommandListener abstractCommandListener) {
        Bundle bundle = new Bundle();
        bundle.putInt(StateActions.EXTRA_VEHICLE_DATA_STREAM_RATE, i);
        this.drone.performAsyncActionOnDroneThread(new Action(StateActions.ACTION_UPDATE_VEHICLE_DATA_STREAM_RATE, bundle), abstractCommandListener);
    }
}

package com.o3dr.android.client.apis;

import android.os.Bundle;
import com.o3dr.android.client.Drone;
import com.o3dr.android.client.apis.Api;
import com.o3dr.services.android.lib.gcs.action.CalibrationActions;
import com.o3dr.services.android.lib.model.AbstractCommandListener;
import com.o3dr.services.android.lib.model.action.Action;
import java.util.concurrent.ConcurrentHashMap;

public class CalibrationApi extends Api {
    private static final Api.Builder<CalibrationApi> apiBuilder = new Api.Builder<CalibrationApi>() {
        public CalibrationApi build(Drone drone) {
            return new CalibrationApi(drone);
        }
    };
    private static final ConcurrentHashMap<Drone, CalibrationApi> calibrationApiCache = new ConcurrentHashMap<>();
    private final Drone drone;

    public static CalibrationApi getApi(Drone drone2) {
        return (CalibrationApi) getApi(drone2, calibrationApiCache, apiBuilder);
    }

    private CalibrationApi(Drone drone2) {
        this.drone = drone2;
    }

    public void startIMUCalibration() {
        startIMUCalibration((AbstractCommandListener) null);
    }

    public void startIMUCalibration(AbstractCommandListener abstractCommandListener) {
        this.drone.performAsyncActionOnDroneThread(new Action(CalibrationActions.ACTION_START_IMU_CALIBRATION), abstractCommandListener);
    }

    public void sendIMUAck(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt(CalibrationActions.EXTRA_IMU_STEP, i);
        this.drone.performAsyncAction(new Action(CalibrationActions.ACTION_SEND_IMU_CALIBRATION_ACK, bundle));
    }

    public void startMagnetometerCalibration() {
        startMagnetometerCalibration(false, true, 0);
    }

    public void startMagnetometerCalibration(boolean z, boolean z2, int i) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(CalibrationActions.EXTRA_RETRY_ON_FAILURE, z);
        bundle.putBoolean(CalibrationActions.EXTRA_SAVE_AUTOMATICALLY, z2);
        bundle.putInt(CalibrationActions.EXTRA_START_DELAY, i);
        this.drone.performAsyncAction(new Action(CalibrationActions.ACTION_START_MAGNETOMETER_CALIBRATION, bundle));
    }

    public void acceptMagnetometerCalibration() {
        this.drone.performAsyncAction(new Action(CalibrationActions.ACTION_ACCEPT_MAGNETOMETER_CALIBRATION));
    }

    public void cancelMagnetometerCalibration() {
        this.drone.performAsyncAction(new Action(CalibrationActions.ACTION_CANCEL_MAGNETOMETER_CALIBRATION));
    }
}

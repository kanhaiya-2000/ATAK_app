package com.aeryon.java.types;

import android.util.Log;
import com.aeryon.java.command.CommandStateCallback;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Aircraft {
    public static int ADK_CARGO_LATCH_STATE_Closed = 0;
    public static int ADK_CARGO_LATCH_STATE_Error = 2;
    public static int ADK_CARGO_LATCH_STATE_MovingToClosed = 4;
    public static int ADK_CARGO_LATCH_STATE_MovingToOpened = 3;
    public static int ADK_CARGO_LATCH_STATE_Open = 1;
    private static final String TAG = "ACTS.Aircraft";
    private static final ExecutorService executor = Executors.newCachedThreadPool();
    private String host;
    private String name;
    /* access modifiers changed from: private */
    public Long pointer = null;
    private Long routePointer = null;
    private int routePtCt;
    private String serial;

    public interface CameraStreamsCallback {
        void handleCameraStreams(CameraStream[] cameraStreamArr);
    }

    private native void cargoActuateLatch(long j, int i);

    private native int cargoLatchState(long j);

    private native void destroyAircraft(long j);

    private native long flyRoute(long j, Vec3dLLA[] vec3dLLAArr, int i, boolean z, CommandStateCallback commandStateCallback);

    private native int flyToLLA(long j, Vec3dLLA vec3dLLA, CommandStateCallback commandStateCallback);

    private native int flyToRads(long j, double d, double d2, double d3, CommandStateCallback commandStateCallback);

    private static native long getAircraftPtr(long j);

    private native int getBatteryMargin(long j);

    private native BatteryStatus[] getBatteryStatus(long j);

    /* access modifiers changed from: private */
    public native CameraStream[] getCameraStreams(long j);

    private native int getCommsLossAction(long j);

    private native float getCruiseSpeed(long j);

    private native Position getEstimatedPosition(long j);

    private native Vec3dNED getEstimatedVelocity(long j);

    private native Orientation getGimbalOrientation(long j, int i);

    private native int getGpsSatelliteCount(long j);

    private native String getHardwareVariant(long j);

    private native Vec3dLLA getHomePosition(long j);

    private native int getInFlightFaultAction(long j);

    private native int getLightFaultMode(long j);

    private native int getLightMode(long j);

    private native int getLwirPalette(long j, int i, int i2);

    private native float getMaxAltitude(long j);

    private native int getMaxZoom(long j, int i, int i2);

    private native float getMaximumRange(long j);

    private native MediaFile[] getMedia(long j);

    private native float getMinimumSafeAltitude(long j);

    private native Orientation getOrientation(long j);

    private native float getPayloadFov(long j, int i, int i2, int i3);

    private native PowerStatus getPowerStatus(long j);

    private native int getRSSI(long j);

    private native boolean getRecording(long j, int i, int i2);

    private native float getRecoverySpeed(long j);

    private native int getSensorType(long j, int i, int i2);

    private native int getShootMode(long j, int i, int i2);

    private native int getZoom(long j, int i, int i2);

    private native void halt(long j);

    private native boolean isCompatible(long j);

    private native boolean isFlying(long j);

    private native boolean isLiveConnected(long j);

    private native boolean isNavAuthorized(long j);

    private native boolean isPayloadAuthorized(long j);

    private native void landInPlace(long j);

    private native boolean lookat(long j, double d, double d2, double d3, int i);

    private native void releaseCameraControl(long j, CommandStateCallback commandStateCallback);

    private native void releaseNavigationControl(long j, CommandStateCallback commandStateCallback);

    private native void requestCameraControl(long j, CommandStateCallback commandStateCallback);

    private native void requestMediaUpdate(long j);

    private native void requestNavigationControl(long j, CommandStateCallback commandStateCallback);

    private native void returnToLanding(long j);

    private native void routeContinue(long j);

    private native void routePause(long j);

    private native void setBatteryMargin(long j, int i, CommandStateCallback commandStateCallback);

    private native void setCommsLossAction(long j, int i, CommandStateCallback commandStateCallback);

    private native void setCruiseSpeed(long j, float f, CommandStateCallback commandStateCallback);

    private native void setHomePositionLLA(long j, Vec3dLLA vec3dLLA, CommandStateCallback commandStateCallback);

    private native void setInFlightFaultAction(long j, int i, CommandStateCallback commandStateCallback);

    private native void setLightFaultMode(long j, int i, CommandStateCallback commandStateCallback);

    private native void setLightMode(long j, int i, CommandStateCallback commandStateCallback);

    private native void setLwirPalette(long j, int i, int i2, int i3, CommandStateCallback commandStateCallback);

    private native void setMaxAltitude(long j, float f, CommandStateCallback commandStateCallback);

    private native void setMaximumRange(long j, float f, CommandStateCallback commandStateCallback);

    private native void setMinimumSafeAltitude(long j, float f, CommandStateCallback commandStateCallback);

    private native boolean setPose(long j, double d, double d2, int i);

    private native void setRecording(long j, int i, int i2, boolean z, CommandStateCallback commandStateCallback);

    private native void setRecoverySpeed(long j, float f, CommandStateCallback commandStateCallback);

    private native void setSensorType(long j, int i, int i2, int i3);

    private native void setShootMode(long j, int i, int i2, int i3, CommandStateCallback commandStateCallback);

    private native void setZoom(long j, int i, int i2, int i3, CommandStateCallback commandStateCallback);

    private native boolean snapGimbal(long j);

    private native void takeSnapshot(long j, int i, int i2, CommandStateCallback commandStateCallback);

    private native void takeoff(long j, double d, boolean z, CommandStateCallback commandStateCallback);

    public native boolean hasOfsprey();

    private Aircraft(long j, String str, String str2, String str3) {
        this.pointer = Long.valueOf(j);
        this.serial = str;
        this.name = str2;
        this.host = str3;
    }

    public static Aircraft getAircraft(DeviceInfo deviceInfo) {
        return new Aircraft(getAircraftPtr(deviceInfo.getPointer().longValue()), deviceInfo.getSerial(), deviceInfo.getName(), deviceInfo.getHost());
    }

    public String getHost() {
        return this.host;
    }

    public String getSerial() {
        return this.serial;
    }

    public String getHardwareVariant() {
        return getHardwareVariant(this.pointer.longValue());
    }

    public Position getPosition() {
        return getEstimatedPosition(this.pointer.longValue());
    }

    public Vec3dNED getVelocity() {
        return getEstimatedVelocity(this.pointer.longValue());
    }

    public Orientation getOrientation() {
        return getOrientation(this.pointer.longValue());
    }

    public PowerStatus getPowerStatus() {
        return getPowerStatus(this.pointer.longValue());
    }

    public BatteryStatus[] getBatteryStatuses() {
        return getBatteryStatus(this.pointer.longValue());
    }

    public Future<CameraStream[]> getCameraStreams() {
        return executor.submit(new Callable<CameraStream[]>() {
            public CameraStream[] call() {
                Aircraft aircraft = Aircraft.this;
                return aircraft.getCameraStreams(aircraft.pointer.longValue());
            }
        });
    }

    public void snapGimbal() {
        snapGimbal(this.pointer.longValue());
    }

    public void setPose(double d, double d2, CameraStream cameraStream) {
        setPose(this.pointer.longValue(), Double.isNaN(d) ? Double.NaN : Math.toRadians(d), Double.isNaN(d2) ? Double.NaN : Math.toRadians(d2), cameraStream.getPayloadSlot());
    }

    public void lookAt(double d, double d2, double d3, CameraStream cameraStream) {
        lookat(this.pointer.longValue(), Math.toRadians(d), Math.toRadians(d2), d3, cameraStream.getPayloadSlot());
    }

    public void getCameraStreamsWithCallback(final CameraStreamsCallback cameraStreamsCallback) {
        executor.submit(new Runnable() {
            public void run() {
                Aircraft aircraft = Aircraft.this;
                cameraStreamsCallback.handleCameraStreams(aircraft.getCameraStreams(aircraft.pointer.longValue()));
            }
        });
    }

    public void cargoActuateLatch(int i) {
        cargoActuateLatch(this.pointer.longValue(), i);
    }

    public int cargoLatchState() {
        return cargoLatchState(this.pointer.longValue());
    }

    public void returnToLanding() {
        returnToLanding(this.pointer.longValue());
    }

    public void fetchMedia() {
        getMedia(this.pointer.longValue());
    }

    public void requestCameraControl(CommandStateCallback commandStateCallback) {
        requestCameraControl(this.pointer.longValue(), commandStateCallback);
    }

    public void releaseCameraControl(CommandStateCallback commandStateCallback) {
        releaseCameraControl(this.pointer.longValue(), commandStateCallback);
    }

    public void requestNavigationControl(CommandStateCallback commandStateCallback) {
        requestNavigationControl(this.pointer.longValue(), commandStateCallback);
    }

    public void releaseNavigationControl(CommandStateCallback commandStateCallback) {
        releaseNavigationControl(this.pointer.longValue(), commandStateCallback);
    }

    public void takeoff(double d, boolean z, CommandStateCallback commandStateCallback) {
        Log.d("Aircraft", "Takeoff java method called.");
        takeoff(this.pointer.longValue(), d, z, commandStateCallback);
    }

    public void requestMediaListingUpdate() {
        requestMediaUpdate(this.pointer.longValue());
    }

    public COMMAND_STATE flyTo(double d, double d2, double d3, CommandStateCallback commandStateCallback) {
        double radians = Math.toRadians(d);
        double radians2 = Math.toRadians(d2);
        return COMMAND_STATE.lookup(flyToRads(this.pointer.longValue(), radians, radians2, d3, commandStateCallback));
    }

    public Vec3dLLA getHomePosition() {
        return getHomePosition(this.pointer.longValue());
    }

    public void setHomePositionLLA(Vec3dLLA vec3dLLA, CommandStateCallback commandStateCallback) {
        setHomePositionLLA(this.pointer.longValue(), vec3dLLA, commandStateCallback);
    }

    public void halt() {
        halt(this.pointer.longValue());
        this.routePtCt = 0;
        this.routePointer = null;
    }

    public String getName() {
        return this.name;
    }

    public void finalize() {
        destroy();
    }

    public void destroy() {
        synchronized (this.pointer) {
            Long l = this.pointer;
            if (l != null) {
                destroyAircraft(l.longValue());
                this.pointer = null;
            }
        }
    }

    public boolean isValid() {
        return this.pointer != null;
    }

    public Orientation getGimbalOrientation(CameraStream cameraStream) {
        return getGimbalOrientation(this.pointer.longValue(), cameraStream.getPayloadSlot());
    }

    public double getPayloadVerticalFov(CameraStream cameraStream) {
        return Math.toDegrees((double) getPayloadFov(this.pointer.longValue(), cameraStream.getPayloadSlot(), cameraStream.getStreamIndex(), 1));
    }

    public double getPayloadHorizontalFov(CameraStream cameraStream) {
        return Math.toDegrees((double) getPayloadFov(this.pointer.longValue(), cameraStream.getPayloadSlot(), cameraStream.getStreamIndex(), 0));
    }

    public void landInPlace() {
        landInPlace(this.pointer.longValue());
    }

    public boolean isFlying() {
        return isFlying(this.pointer.longValue());
    }

    public float getCruiseSpeed() {
        return getCruiseSpeed(this.pointer.longValue());
    }

    public void setCruiseSpeed(float f, CommandStateCallback commandStateCallback) {
        setCruiseSpeed(this.pointer.longValue(), f, commandStateCallback);
    }

    public float getMaxAltitude() {
        return getMaxAltitude(this.pointer.longValue());
    }

    public void setMaxAltitude(float f, CommandStateCallback commandStateCallback) {
        setMaxAltitude(this.pointer.longValue(), f, commandStateCallback);
    }

    public float getMinimumSafeAltitude() {
        return getMinimumSafeAltitude(this.pointer.longValue());
    }

    public void setMinimumSafeAltitude(float f, CommandStateCallback commandStateCallback) {
        setMinimumSafeAltitude(this.pointer.longValue(), f, commandStateCallback);
    }

    public float getMaximumRange() {
        return getMaximumRange(this.pointer.longValue());
    }

    public void setMaximumRange(float f, CommandStateCallback commandStateCallback) {
        setMaximumRange(this.pointer.longValue(), f, commandStateCallback);
    }

    public float getRecoverySpeed() {
        return getRecoverySpeed(this.pointer.longValue());
    }

    public void setRecoverySpeed(float f, CommandStateCallback commandStateCallback) {
        setRecoverySpeed(this.pointer.longValue(), f, commandStateCallback);
    }

    public LIGHT_MODE getLightMode() {
        return LIGHT_MODE.fromInt(getLightMode(this.pointer.longValue()));
    }

    public void setLightMode(LIGHT_MODE light_mode, CommandStateCallback commandStateCallback) {
        setLightMode(this.pointer.longValue(), light_mode.toInt(), commandStateCallback);
    }

    public LIGHT_FAULT_MODE getLightFaultMode() {
        return LIGHT_FAULT_MODE.fromInt(getLightFaultMode(this.pointer.longValue()));
    }

    public void setLightFaultMode(LIGHT_FAULT_MODE light_fault_mode, CommandStateCallback commandStateCallback) {
        setLightFaultMode(this.pointer.longValue(), light_fault_mode.toInt(), commandStateCallback);
    }

    public FAULT_ACTION getCommsLossAction() {
        return FAULT_ACTION.fromInt(getCommsLossAction(this.pointer.longValue()));
    }

    public void setCommsLossAction(FAULT_ACTION fault_action, CommandStateCallback commandStateCallback) {
        setCommsLossAction(this.pointer.longValue(), fault_action.toInt(), commandStateCallback);
    }

    public FAULT_ACTION getInFlightFaultAction() {
        return FAULT_ACTION.fromInt(getInFlightFaultAction(this.pointer.longValue()));
    }

    public void setInFlightFaultAction(FAULT_ACTION fault_action, CommandStateCallback commandStateCallback) {
        setInFlightFaultAction(this.pointer.longValue(), fault_action.toInt(), commandStateCallback);
    }

    public int getBatteryMargin() {
        return getBatteryMargin(this.pointer.longValue());
    }

    public void setBatteryMargin(int i, CommandStateCallback commandStateCallback) {
        setBatteryMargin(this.pointer.longValue(), i, commandStateCallback);
    }

    public int getRSSI() {
        return getRSSI(this.pointer.longValue());
    }

    public int getGpsSatelliteCount() {
        return getGpsSatelliteCount(this.pointer.longValue());
    }

    public void takeSnapshot(CameraStream cameraStream, CommandStateCallback commandStateCallback) {
        takeSnapshot(this.pointer.longValue(), cameraStream.getPayloadSlot(), cameraStream.getStreamIndex(), commandStateCallback);
    }

    public void setRecording(CameraStream cameraStream, boolean z, CommandStateCallback commandStateCallback) {
        setRecording(this.pointer.longValue(), cameraStream.getPayloadSlot(), cameraStream.getStreamIndex(), z, commandStateCallback);
    }

    public boolean getIsRecording(CameraStream cameraStream) {
        return getRecording(this.pointer.longValue(), cameraStream.getPayloadSlot(), cameraStream.getStreamIndex());
    }

    public void setShootMode(CameraStream cameraStream, CAMERA_SHOOT_MODE camera_shoot_mode, CommandStateCallback commandStateCallback) {
        setShootMode(this.pointer.longValue(), cameraStream.getPayloadSlot(), cameraStream.getStreamIndex(), camera_shoot_mode.toInt(), commandStateCallback);
    }

    public CAMERA_SHOOT_MODE getShootMode(CameraStream cameraStream) {
        return CAMERA_SHOOT_MODE.fromInt(getShootMode(this.pointer.longValue(), cameraStream.getPayloadSlot(), cameraStream.getStreamIndex()));
    }

    public void setZoom(CameraStream cameraStream, int i, CommandStateCallback commandStateCallback) {
        setZoom(this.pointer.longValue(), cameraStream.getPayloadSlot(), cameraStream.getStreamIndex(), i, commandStateCallback);
    }

    public int getZoom(CameraStream cameraStream) {
        return getZoom(this.pointer.longValue(), cameraStream.getPayloadSlot(), cameraStream.getStreamIndex());
    }

    public int getMaxZoom(CameraStream cameraStream) {
        return getMaxZoom(this.pointer.longValue(), cameraStream.getPayloadSlot(), cameraStream.getStreamIndex());
    }

    public COMMAND_STATE flyToLLA(Vec3dLLA vec3dLLA, CommandStateCallback commandStateCallback) {
        return COMMAND_STATE.lookup(flyToLLA(this.pointer.longValue(), vec3dLLA, commandStateCallback));
    }

    public COMMAND_STATE flyRoute(Vec3dLLA[] vec3dLLAArr, WAYPOINT_PLAY_MODE waypoint_play_mode, CommandStateCallback commandStateCallback) {
        this.routePointer = Long.valueOf(flyRoute(this.pointer.longValue(), vec3dLLAArr, waypoint_play_mode.getValue(), true, commandStateCallback));
        this.routePtCt = vec3dLLAArr.length;
        return COMMAND_STATE.Active;
    }

    public boolean routePause() {
        Long l;
        if (this.routePtCt <= 1 || (l = this.routePointer) == null || l.longValue() == 0) {
            halt();
            return false;
        }
        routePause(this.routePointer.longValue());
        return true;
    }

    public boolean routeContinue() {
        Long l = this.routePointer;
        if (l == null || l.longValue() == 0) {
            return false;
        }
        routeContinue(this.routePointer.longValue());
        return true;
    }

    public void setLwirPalette(CameraStream cameraStream, LwirPalette lwirPalette, CommandStateCallback commandStateCallback) {
        setLwirPalette(this.pointer.longValue(), cameraStream.getPayloadSlot(), cameraStream.getStreamIndex(), lwirPalette.value, commandStateCallback);
    }

    public LwirPalette getLwirPalette(CameraStream cameraStream) {
        return LwirPalette.fromInt(getLwirPalette(this.pointer.longValue(), cameraStream.getPayloadSlot(), cameraStream.getStreamIndex()));
    }

    public boolean isCompatible() {
        return isCompatible(this.pointer.longValue());
    }

    public boolean isLiveConnected() {
        return isLiveConnected(this.pointer.longValue());
    }

    public SensorType getSensorType(CameraStream cameraStream) {
        return SensorType.fromInt(getSensorType(this.pointer.longValue(), cameraStream.getPayloadSlot(), cameraStream.getStreamIndex()));
    }

    public void setSensorType(CameraStream cameraStream, SensorType sensorType) {
        setSensorType(this.pointer.longValue(), cameraStream.getPayloadSlot(), cameraStream.getStreamIndex(), sensorType.value);
    }

    public boolean isPayloadAuthorized() {
        return isPayloadAuthorized(this.pointer.longValue());
    }

    public boolean isNavAuthorized() {
        return isNavAuthorized(this.pointer.longValue());
    }
}

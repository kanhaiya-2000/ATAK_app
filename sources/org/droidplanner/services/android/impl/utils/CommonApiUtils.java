package org.droidplanner.services.android.impl.utils;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.Surface;
import atakplugin.UASTool.cqb;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_ekf_status_report;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_mag_cal_progress;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_mag_cal_report;
import com.o3dr.services.android.lib.coordinate.LatLong;
import com.o3dr.services.android.lib.coordinate.LatLongAlt;
import com.o3dr.services.android.lib.drone.attribute.AttributeType;
import com.o3dr.services.android.lib.drone.calibration.magnetometer.MagnetometerCalibrationProgress;
import com.o3dr.services.android.lib.drone.calibration.magnetometer.MagnetometerCalibrationResult;
import com.o3dr.services.android.lib.drone.calibration.magnetometer.MagnetometerCalibrationStatus;
import com.o3dr.services.android.lib.drone.mission.Mission;
import com.o3dr.services.android.lib.drone.mission.MissionItemType;
import com.o3dr.services.android.lib.drone.mission.item.MissionItem;
import com.o3dr.services.android.lib.drone.mission.item.complex.CameraDetail;
import com.o3dr.services.android.lib.drone.mission.item.complex.StructureScanner;
import com.o3dr.services.android.lib.drone.mission.item.complex.Survey;
import com.o3dr.services.android.lib.drone.property.CameraProxy;
import com.o3dr.services.android.lib.drone.property.EkfStatus;
import com.o3dr.services.android.lib.drone.property.FootPrint;
import com.o3dr.services.android.lib.drone.property.Gps;
import com.o3dr.services.android.lib.drone.property.GuidedState;
import com.o3dr.services.android.lib.drone.property.Parameter;
import com.o3dr.services.android.lib.drone.property.Parameters;
import com.o3dr.services.android.lib.drone.property.State;
import com.o3dr.services.android.lib.drone.property.Type;
import com.o3dr.services.android.lib.drone.property.VehicleMode;
import com.o3dr.services.android.lib.drone.property.Vibration;
import com.o3dr.services.android.lib.gcs.follow.FollowState;
import com.o3dr.services.android.lib.gcs.follow.FollowType;
import com.o3dr.services.android.lib.mavlink.MavlinkMessageWrapper;
import com.o3dr.services.android.lib.model.AbstractCommandListener;
import com.o3dr.services.android.lib.model.ICommandListener;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.droidplanner.services.android.impl.core.MAVLink.MavLinkCommands;
import org.droidplanner.services.android.impl.core.MAVLink.command.doCmd.MavLinkDoCmds;
import org.droidplanner.services.android.impl.core.drone.autopilot.Drone;
import org.droidplanner.services.android.impl.core.drone.autopilot.MavLinkDrone;
import org.droidplanner.services.android.impl.core.drone.autopilot.apm.ArduPilot;
import org.droidplanner.services.android.impl.core.drone.autopilot.generic.GenericMavLinkDrone;
import org.droidplanner.services.android.impl.core.drone.profiles.ParameterManager;
import org.droidplanner.services.android.impl.core.drone.variables.ApmModes;
import org.droidplanner.services.android.impl.core.drone.variables.Camera;
import org.droidplanner.services.android.impl.core.drone.variables.GuidedPoint;
import org.droidplanner.services.android.impl.core.drone.variables.calibration.AccelCalibration;
import org.droidplanner.services.android.impl.core.drone.variables.calibration.MagnetometerCalibrationImpl;
import org.droidplanner.services.android.impl.core.firmware.FirmwareType;
import org.droidplanner.services.android.impl.core.gcs.follow.Follow;
import org.droidplanner.services.android.impl.core.gcs.follow.FollowAlgorithm;
import org.droidplanner.services.android.impl.core.mission.MissionImpl;
import org.droidplanner.services.android.impl.core.mission.MissionItemImpl;
import org.droidplanner.services.android.impl.core.mission.survey.SplineSurveyImpl;
import org.droidplanner.services.android.impl.core.mission.survey.SurveyImpl;
import org.droidplanner.services.android.impl.core.mission.waypoints.StructureScannerImpl;
import org.droidplanner.services.android.impl.core.survey.Footprint;

public class CommonApiUtils {
    public static int getDroneProxyType(int i) {
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (!(i == 2 || i == 4)) {
                if (i == 10 || i == 11) {
                    return 10;
                }
                switch (i) {
                    case 13:
                    case 14:
                    case 15:
                        break;
                    default:
                        return -1;
                }
            }
        }
        return i2;
    }

    private CommonApiUtils() {
    }

    public static void postSuccessEvent(ICommandListener iCommandListener) {
        if (iCommandListener != null) {
            try {
                iCommandListener.onSuccess();
            } catch (RemoteException e) {
                cqb.m12015e(e, e.getMessage(), new Object[0]);
            }
        }
    }

    public static void postErrorEvent(int i, ICommandListener iCommandListener) {
        if (iCommandListener != null) {
            try {
                iCommandListener.onError(i);
            } catch (RemoteException e) {
                cqb.m12015e(e, e.getMessage(), new Object[0]);
            }
        }
    }

    public static void postTimeoutEvent(ICommandListener iCommandListener) {
        if (iCommandListener != null) {
            try {
                iCommandListener.onTimeout();
            } catch (RemoteException e) {
                cqb.m12015e(e, e.getMessage(), new Object[0]);
            }
        }
    }

    public static VehicleMode getVehicleMode(ApmModes apmModes) {
        switch (C60116.f8650x3b160879[apmModes.ordinal()]) {
            case 1:
                return VehicleMode.PLANE_MANUAL;
            case 2:
                return VehicleMode.PLANE_CIRCLE;
            case 3:
                return VehicleMode.PLANE_STABILIZE;
            case 4:
                return VehicleMode.PLANE_TRAINING;
            case 5:
                return VehicleMode.PLANE_ACRO;
            case 6:
                return VehicleMode.PLANE_FLY_BY_WIRE_A;
            case 7:
                return VehicleMode.PLANE_FLY_BY_WIRE_B;
            case 8:
                return VehicleMode.PLANE_CRUISE;
            case 9:
                return VehicleMode.PLANE_AUTOTUNE;
            case 10:
                return VehicleMode.PLANE_AUTO;
            case 11:
                return VehicleMode.PLANE_RTL;
            case 12:
                return VehicleMode.PLANE_LOITER;
            case 13:
                return VehicleMode.PLANE_GUIDED;
            case 14:
                return VehicleMode.COPTER_STABILIZE;
            case 15:
                return VehicleMode.COPTER_ACRO;
            case 16:
                return VehicleMode.COPTER_ALT_HOLD;
            case 17:
                return VehicleMode.COPTER_AUTO;
            case 18:
                return VehicleMode.COPTER_GUIDED;
            case 19:
                return VehicleMode.COPTER_LOITER;
            case 20:
                return VehicleMode.COPTER_RTL;
            case 21:
                return VehicleMode.COPTER_CIRCLE;
            case 22:
                return VehicleMode.COPTER_LAND;
            case 23:
                return VehicleMode.COPTER_DRIFT;
            case 24:
                return VehicleMode.COPTER_SPORT;
            case 25:
                return VehicleMode.COPTER_AUTOTUNE;
            case 26:
                return VehicleMode.COPTER_POSHOLD;
            case 27:
                return VehicleMode.COPTER_BRAKE;
            case 28:
                return VehicleMode.ROVER_MANUAL;
            case 29:
                return VehicleMode.ROVER_LEARNING;
            case 30:
                return VehicleMode.ROVER_STEERING;
            case 31:
                return VehicleMode.ROVER_HOLD;
            case 32:
                return VehicleMode.ROVER_AUTO;
            case 33:
                return VehicleMode.ROVER_RTL;
            case 34:
                return VehicleMode.ROVER_GUIDED;
            case 35:
                return VehicleMode.ROVER_INITIALIZING;
            default:
                return null;
        }
    }

    public static FootPrint getProxyCameraFootPrint(Footprint footprint) {
        if (footprint == null) {
            return null;
        }
        return new FootPrint(footprint.getGSD(), footprint.getVertexInGlobalFrame());
    }

    public static FollowAlgorithm.FollowModes followTypeToMode(MavLinkDrone mavLinkDrone, FollowType followType) {
        switch (C60116.$SwitchMap$com$o3dr$services$android$lib$gcs$follow$FollowType[followType.ordinal()]) {
            case 1:
                return mavLinkDrone.getFirmwareType() == FirmwareType.ARDU_SOLO ? FollowAlgorithm.FollowModes.SPLINE_ABOVE : FollowAlgorithm.FollowModes.ABOVE;
            case 2:
                return FollowAlgorithm.FollowModes.LEAD;
            case 4:
                return FollowAlgorithm.FollowModes.CIRCLE;
            case 5:
                return FollowAlgorithm.FollowModes.LEFT;
            case 6:
                return FollowAlgorithm.FollowModes.RIGHT;
            case 7:
                return FollowAlgorithm.FollowModes.GUIDED_SCAN;
            case 8:
                return FollowAlgorithm.FollowModes.LOOK_AT_ME;
            case 9:
                return FollowAlgorithm.FollowModes.SOLO_SHOT;
            default:
                if (mavLinkDrone.getFirmwareType() == FirmwareType.ARDU_SOLO) {
                    return FollowAlgorithm.FollowModes.SPLINE_LEASH;
                }
                return FollowAlgorithm.FollowModes.LEASH;
        }
    }

    public static FollowType followModeToType(FollowAlgorithm.FollowModes followModes) {
        switch (followModes) {
            case LEAD:
                return FollowType.LEAD;
            case RIGHT:
                return FollowType.RIGHT;
            case LEFT:
                return FollowType.LEFT;
            case CIRCLE:
                return FollowType.CIRCLE;
            case ABOVE:
            case SPLINE_ABOVE:
                return FollowType.ABOVE;
            case GUIDED_SCAN:
                return FollowType.GUIDED_SCAN;
            case LOOK_AT_ME:
                return FollowType.LOOK_AT_ME;
            case SOLO_SHOT:
                return FollowType.SOLO_SHOT;
            default:
                return FollowType.LEASH;
        }
    }

    public static CameraProxy getCameraProxy(Drone drone, List<CameraDetail> list) {
        CameraDetail cameraDetail;
        FootPrint footPrint;
        ArrayList arrayList = new ArrayList();
        if (!(drone instanceof MavLinkDrone)) {
            cameraDetail = new CameraDetail();
            footPrint = new FootPrint();
        } else {
            Camera camera = ((MavLinkDrone) drone).getCamera();
            CameraDetail cameraDetail2 = ProxyUtils.getCameraDetail(camera.getCamera());
            for (Footprint proxyCameraFootPrint : camera.getFootprints()) {
                arrayList.add(getProxyCameraFootPrint(proxyCameraFootPrint));
            }
            Gps gps = (Gps) drone.getAttribute(AttributeType.GPS);
            footPrint = (gps == null || !gps.isValid()) ? new FootPrint() : getProxyCameraFootPrint(camera.getCurrentFieldOfView());
            cameraDetail = cameraDetail2;
        }
        return new CameraProxy(cameraDetail, footPrint, arrayList, list);
    }

    public static State getState(MavLinkDrone mavLinkDrone, boolean z, Vibration vibration) {
        if (mavLinkDrone == null) {
            return new State();
        }
        org.droidplanner.services.android.impl.core.drone.variables.State state = mavLinkDrone.getState();
        ApmModes mode = state.getMode();
        AccelCalibration calibrationSetup = mavLinkDrone.getCalibrationSetup();
        return new State(z, getVehicleMode(mode), state.isArmed(), state.isFlying(), state.getErrorId(), mavLinkDrone.getMavlinkVersion(), (calibrationSetup == null || !calibrationSetup.isCalibrating()) ? null : calibrationSetup.getMessage(), state.getFlightStartTime(), generateEkfStatus(state.getEkfStatus()), z && mavLinkDrone.isConnectionAlive(), vibration);
    }

    public static EkfStatus generateEkfStatus(msg_ekf_status_report msg_ekf_status_report) {
        if (msg_ekf_status_report == null) {
            return null;
        }
        return new EkfStatus(msg_ekf_status_report.flags, msg_ekf_status_report.compass_variance, msg_ekf_status_report.pos_horiz_variance, msg_ekf_status_report.terrain_alt_variance, msg_ekf_status_report.velocity_variance, msg_ekf_status_report.pos_vert_variance);
    }

    public static Mission getMission(MavLinkDrone mavLinkDrone) {
        Mission mission = new Mission();
        if (mavLinkDrone == null) {
            return mission;
        }
        List<MissionItemImpl> componentItems = mavLinkDrone.getMission().getComponentItems();
        mission.setCurrentMissionItem((short) mavLinkDrone.getMissionStats().getCurrentWP());
        if (!componentItems.isEmpty()) {
            for (MissionItemImpl proxyMissionItem : componentItems) {
                mission.addMissionItem(ProxyUtils.getProxyMissionItem(proxyMissionItem));
            }
        }
        return mission;
    }

    public static Type getType(MavLinkDrone mavLinkDrone) {
        if (mavLinkDrone == null) {
            return new Type();
        }
        return new Type(getDroneProxyType(mavLinkDrone.getType()), mavLinkDrone.getFirmwareVersion());
    }

    public static GuidedState getGuidedState(MavLinkDrone mavLinkDrone) {
        if (mavLinkDrone == null) {
            return new GuidedState();
        }
        GuidedPoint guidedPoint = mavLinkDrone.getGuidedPoint();
        int i = C60116.f8651x3bace18d[guidedPoint.getState().ordinal()];
        int i2 = 2;
        if (i != 2) {
            i2 = i != 3 ? 0 : 1;
        }
        LatLong coord = guidedPoint.getCoord();
        if (coord == null) {
            coord = new LatLong(0.0d, 0.0d);
        }
        return new GuidedState(i2, new LatLongAlt(coord, guidedPoint.getAltitude()));
    }

    public static void changeVehicleMode(MavLinkDrone mavLinkDrone, VehicleMode vehicleMode, ICommandListener iCommandListener) {
        if (mavLinkDrone != null) {
            int droneType = vehicleMode.getDroneType();
            int i = 10;
            if (droneType == 1) {
                i = 1;
            } else if (droneType != 10) {
                i = 2;
            }
            mavLinkDrone.getState().changeFlightMode(ApmModes.getMode((long) vehicleMode.getMode(), i), iCommandListener);
        }
    }

    public static FollowState getFollowState(Follow follow) {
        Double d;
        if (follow == null) {
            return new FollowState();
        }
        int i = C60116.f8652xe4d0c3ee[follow.getState().ordinal()];
        int i2 = 5;
        if (i == 2) {
            i2 = 1;
        } else if (i == 3) {
            i2 = 2;
        } else if (i == 4) {
            i2 = 3;
        } else if (i == 5) {
            i2 = 4;
        } else if (i != 6) {
            i2 = 0;
        }
        FollowAlgorithm followAlgorithm = follow.getFollowAlgorithm();
        Map<String, Object> params = followAlgorithm.getParams();
        Bundle bundle = new Bundle();
        for (Map.Entry next : params.entrySet()) {
            String str = (String) next.getKey();
            str.hashCode();
            if (str.equals("extra_follow_roi_target")) {
                LatLongAlt latLongAlt = (LatLongAlt) next.getValue();
                if (latLongAlt != null) {
                    bundle.putParcelable((String) next.getKey(), latLongAlt);
                }
            } else if (str.equals("extra_follow_radius") && (d = (Double) next.getValue()) != null) {
                bundle.putDouble((String) next.getKey(), d.doubleValue());
            }
        }
        return new FollowState(i2, followModeToType(followAlgorithm.getType()), bundle);
    }

    public static void disableFollowMe(Follow follow) {
        if (follow != null) {
            follow.disableFollowMe();
        }
    }

    public static void triggerCamera(MavLinkDrone mavLinkDrone) {
        if (mavLinkDrone != null) {
            MavLinkDoCmds.triggerCamera(mavLinkDrone);
        }
    }

    public static void epmCommand(MavLinkDrone mavLinkDrone, boolean z, ICommandListener iCommandListener) {
        if (mavLinkDrone != null) {
            MavLinkDoCmds.empCommand(mavLinkDrone, z, iCommandListener);
        }
    }

    public static void loadWaypoints(MavLinkDrone mavLinkDrone) {
        if (mavLinkDrone != null) {
            mavLinkDrone.getWaypointManager().getWaypoints();
        }
    }

    public static void refreshParameters(MavLinkDrone mavLinkDrone) {
        if (mavLinkDrone != null) {
            mavLinkDrone.getParameterManager().refreshParameters();
        }
    }

    public static void writeParameters(MavLinkDrone mavLinkDrone, Parameters parameters) {
        if (mavLinkDrone != null && parameters != null) {
            List<Parameter> parameters2 = parameters.getParameters();
            if (!parameters2.isEmpty()) {
                ParameterManager parameterManager = mavLinkDrone.getParameterManager();
                for (Parameter sendParameter : parameters2) {
                    parameterManager.sendParameter(sendParameter);
                }
            }
        }
    }

    public static void setMission(MavLinkDrone mavLinkDrone, Mission mission, boolean z) {
        if (mavLinkDrone != null) {
            MissionImpl mission2 = mavLinkDrone.getMission();
            mission2.clearMissionItems();
            for (MissionItem missionItemImpl : mission.getMissionItems()) {
                mission2.addMissionItem(ProxyUtils.getMissionItemImpl(mission2, missionItemImpl));
            }
            if (z) {
                mission2.sendMissionToAPM();
            }
        }
    }

    public static void startMission(final ArduPilot arduPilot, final boolean z, boolean z2, final ICommandListener iCommandListener) {
        if (arduPilot != null) {
            final C60051 r0 = new Runnable() {
                public void run() {
                    MavLinkCommands.startMission(ArduPilot.this, iCommandListener);
                }
            };
            final C60062 r1 = new Runnable() {
                public void run() {
                    if (ArduPilot.this.getState().getMode() == ApmModes.ROTOR_AUTO) {
                        r0.run();
                    } else if (z) {
                        CommonApiUtils.changeVehicleMode(ArduPilot.this, VehicleMode.COPTER_AUTO, new AbstractCommandListener() {
                            public void onSuccess() {
                                r0.run();
                            }

                            public void onError(int i) {
                                CommonApiUtils.postErrorEvent(i, iCommandListener);
                            }

                            public void onTimeout() {
                                CommonApiUtils.postTimeoutEvent(iCommandListener);
                            }
                        });
                    } else {
                        CommonApiUtils.postErrorEvent(4, iCommandListener);
                    }
                }
            };
            if (arduPilot.getState().isArmed()) {
                r1.run();
            } else if (z2) {
                arm(arduPilot, true, new AbstractCommandListener() {
                    public void onSuccess() {
                        r1.run();
                    }

                    public void onError(int i) {
                        CommonApiUtils.postErrorEvent(i, iCommandListener);
                    }

                    public void onTimeout() {
                        CommonApiUtils.postTimeoutEvent(iCommandListener);
                    }
                });
            } else {
                postErrorEvent(4, iCommandListener);
            }
        }
    }

    public static float generateDronie(MavLinkDrone mavLinkDrone) {
        if (mavLinkDrone == null) {
            return -1.0f;
        }
        return (float) mavLinkDrone.getMission().makeAndUploadDronie();
    }

    public static void arm(ArduPilot arduPilot, boolean z, ICommandListener iCommandListener) {
        arm(arduPilot, z, false, iCommandListener);
    }

    public static void arm(final ArduPilot arduPilot, final boolean z, final boolean z2, final ICommandListener iCommandListener) {
        if (arduPilot != null) {
            if (z || !z2 || !org.droidplanner.services.android.impl.core.drone.variables.Type.isCopter(arduPilot.getType()) || isKillSwitchSupported(arduPilot)) {
                MavLinkCommands.sendArmMessage(arduPilot, z, z2, iCommandListener);
            } else {
                changeVehicleMode(arduPilot, VehicleMode.COPTER_STABILIZE, new AbstractCommandListener() {
                    public void onSuccess() {
                        MavLinkCommands.sendArmMessage(ArduPilot.this, z, z2, iCommandListener);
                    }

                    public void onError(int i) {
                        ICommandListener iCommandListener = iCommandListener;
                        if (iCommandListener != null) {
                            try {
                                iCommandListener.onError(i);
                            } catch (RemoteException e) {
                                cqb.m12015e(e, e.getMessage(), new Object[0]);
                            }
                        }
                    }

                    public void onTimeout() {
                        ICommandListener iCommandListener = iCommandListener;
                        if (iCommandListener != null) {
                            try {
                                iCommandListener.onTimeout();
                            } catch (RemoteException e) {
                                cqb.m12015e(e, e.getMessage(), new Object[0]);
                            }
                        }
                    }
                });
            }
        }
    }

    public static boolean isKillSwitchSupported(MavLinkDrone mavLinkDrone) {
        if (mavLinkDrone == null || !org.droidplanner.services.android.impl.core.drone.variables.Type.isCopter(mavLinkDrone.getType())) {
            return false;
        }
        String firmwareVersion = mavLinkDrone.getFirmwareVersion();
        if (TextUtils.isEmpty(firmwareVersion)) {
            return false;
        }
        if (firmwareVersion.startsWith("APM:Copter V3.3") || firmwareVersion.startsWith("APM:Copter V3.4") || firmwareVersion.startsWith("Solo")) {
            return true;
        }
        return false;
    }

    public static void startMagnetometerCalibration(MavLinkDrone mavLinkDrone, boolean z, boolean z2, int i) {
        if (mavLinkDrone != null) {
            mavLinkDrone.getMagnetometerCalibration().startCalibration(z, z2, i);
        }
    }

    public static void cancelMagnetometerCalibration(MavLinkDrone mavLinkDrone) {
        if (mavLinkDrone != null) {
            mavLinkDrone.getMagnetometerCalibration().cancelCalibration();
        }
    }

    public static void acceptMagnetometerCalibration(MavLinkDrone mavLinkDrone) {
        if (mavLinkDrone != null) {
            mavLinkDrone.getMagnetometerCalibration().acceptCalibration();
        }
    }

    public static void startIMUCalibration(MavLinkDrone mavLinkDrone, ICommandListener iCommandListener) {
        if (mavLinkDrone != null) {
            mavLinkDrone.getCalibrationSetup().startCalibration(iCommandListener);
        }
    }

    public static void sendIMUCalibrationAck(MavLinkDrone mavLinkDrone, int i) {
        if (mavLinkDrone != null) {
            mavLinkDrone.getCalibrationSetup().sendAck(i);
        }
    }

    public static void doGuidedTakeoff(MavLinkDrone mavLinkDrone, double d, ICommandListener iCommandListener) {
        if (mavLinkDrone != null) {
            mavLinkDrone.getGuidedPoint().doGuidedTakeoff(d, iCommandListener);
        }
    }

    public static void sendMavlinkMessage(MavLinkDrone mavLinkDrone, MavlinkMessageWrapper mavlinkMessageWrapper) {
        MAVLinkMessage mavLinkMessage;
        if (mavLinkDrone != null && mavlinkMessageWrapper != null && (mavLinkMessage = mavlinkMessageWrapper.getMavLinkMessage()) != null) {
            mavLinkMessage.compid = mavLinkDrone.getCompid();
            mavLinkMessage.sysid = mavLinkDrone.getSysid();
            try {
                Class<?> cls = mavLinkMessage.getClass();
                Field declaredField = cls.getDeclaredField("target_system");
                Field declaredField2 = cls.getDeclaredField("target_component");
                declaredField.setByte(mavLinkMessage, (byte) mavLinkMessage.sysid);
                declaredField2.setByte(mavLinkMessage, (byte) mavLinkMessage.compid);
            } catch (ExceptionInInitializerError | IllegalAccessException | IllegalArgumentException | NoSuchFieldException | SecurityException e) {
                cqb.m12015e(e, e.getMessage(), new Object[0]);
            }
            mavLinkDrone.getMavClient().sendMessage(mavLinkMessage, (ICommandListener) null);
        }
    }

    public static void sendGuidedPoint(MavLinkDrone mavLinkDrone, LatLong latLong, boolean z, ICommandListener iCommandListener) {
        if (mavLinkDrone != null) {
            GuidedPoint guidedPoint = mavLinkDrone.getGuidedPoint();
            if (guidedPoint.isInitialized()) {
                guidedPoint.newGuidedCoord(latLong);
            } else if (z) {
                try {
                    guidedPoint.forcedGuidedCoordinate(latLong, iCommandListener);
                } catch (Exception e) {
                    cqb.m12015e(e, e.getMessage(), new Object[0]);
                }
            }
        }
    }

    public static void sendLookAtTarget(final MavLinkDrone mavLinkDrone, final LatLongAlt latLongAlt, boolean z, final ICommandListener iCommandListener) {
        if (mavLinkDrone != null) {
            if (mavLinkDrone.getGuidedPoint().isInitialized()) {
                MavLinkDoCmds.setROI(mavLinkDrone, latLongAlt, iCommandListener);
            } else if (z) {
                GuidedPoint.changeToGuidedMode(mavLinkDrone, new AbstractCommandListener() {
                    public void onSuccess() {
                        MavLinkDoCmds.setROI(MavLinkDrone.this, latLongAlt, iCommandListener);
                    }

                    public void onError(int i) {
                        CommonApiUtils.postErrorEvent(i, iCommandListener);
                    }

                    public void onTimeout() {
                        CommonApiUtils.postTimeoutEvent(iCommandListener);
                    }
                });
            }
        }
    }

    public static void setGuidedAltitude(MavLinkDrone mavLinkDrone, double d) {
        if (mavLinkDrone != null) {
            mavLinkDrone.getGuidedPoint().changeGuidedAltitude(d);
        }
    }

    public static void gotoWaypoint(MavLinkDrone mavLinkDrone, int i, ICommandListener iCommandListener) {
        if (mavLinkDrone != null) {
            if (i < 0) {
                postErrorEvent(4, iCommandListener);
            } else {
                MavLinkDoCmds.gotoWaypoint(mavLinkDrone, i, iCommandListener);
            }
        }
    }

    public static void buildComplexMissionItem(MavLinkDrone mavLinkDrone, Bundle bundle) {
        MissionItem restoreMissionItemFromBundle = MissionItemType.restoreMissionItemFromBundle(bundle);
        if (restoreMissionItemFromBundle != null && (restoreMissionItemFromBundle instanceof MissionItem.ComplexItem)) {
            MissionItemType type = restoreMissionItemFromBundle.getType();
            int i = C60116.f8649x5ec7fdea[type.ordinal()];
            if (i == 1) {
                Survey buildSurvey = buildSurvey(mavLinkDrone, (Survey) restoreMissionItemFromBundle);
                if (buildSurvey != null) {
                    type.storeMissionItem(buildSurvey, bundle);
                }
            } else if (i == 2) {
                Survey buildSplineSurvey = buildSplineSurvey(mavLinkDrone, (Survey) restoreMissionItemFromBundle);
                if (buildSplineSurvey != null) {
                    type.storeMissionItem(buildSplineSurvey, bundle);
                }
            } else if (i != 3) {
                cqb.m12012d("Unrecognized complex mission item.", new Object[0]);
            } else {
                StructureScanner buildStructureScanner = buildStructureScanner(mavLinkDrone, (StructureScanner) restoreMissionItemFromBundle);
                if (buildStructureScanner != null) {
                    type.storeMissionItem(buildStructureScanner, bundle);
                }
            }
        }
    }

    /* renamed from: org.droidplanner.services.android.impl.utils.CommonApiUtils$6 */
    /* synthetic */ class C60116 {

        /* renamed from: $SwitchMap$com$o3dr$services$android$lib$drone$mission$MissionItemType */
        static final /* synthetic */ int[] f8649x5ec7fdea;
        static final /* synthetic */ int[] $SwitchMap$com$o3dr$services$android$lib$gcs$follow$FollowType;

        /* renamed from: $SwitchMap$org$droidplanner$services$android$impl$core$drone$variables$ApmModes */
        static final /* synthetic */ int[] f8650x3b160879;

        /* renamed from: $SwitchMap$org$droidplanner$services$android$impl$core$drone$variables$GuidedPoint$GuidedStates */
        static final /* synthetic */ int[] f8651x3bace18d;

        /* renamed from: $SwitchMap$org$droidplanner$services$android$impl$core$gcs$follow$Follow$FollowStates */
        static final /* synthetic */ int[] f8652xe4d0c3ee;

        /* JADX WARNING: Can't wrap try/catch for region: R(136:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|(2:17|18)|19|(2:21|22)|23|(2:25|26)|27|(2:29|30)|31|33|34|35|36|(2:37|38)|39|41|42|43|44|45|46|47|48|49|50|(2:51|52)|53|(2:55|56)|57|(2:59|60)|61|(2:63|64)|65|(2:67|68)|69|(2:71|72)|73|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|(2:91|92)|93|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|(3:165|166|168)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(137:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|(2:17|18)|19|(2:21|22)|23|(2:25|26)|27|(2:29|30)|31|33|34|35|36|(2:37|38)|39|41|42|43|44|45|46|47|48|49|50|(2:51|52)|53|(2:55|56)|57|(2:59|60)|61|(2:63|64)|65|67|68|69|(2:71|72)|73|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|(2:91|92)|93|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|(3:165|166|168)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(138:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|(2:17|18)|19|(2:21|22)|23|(2:25|26)|27|(2:29|30)|31|33|34|35|36|(2:37|38)|39|41|42|43|44|45|46|47|48|49|50|(2:51|52)|53|(2:55|56)|57|(2:59|60)|61|63|64|65|67|68|69|(2:71|72)|73|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|(2:91|92)|93|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|(3:165|166|168)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(139:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|(2:17|18)|19|(2:21|22)|23|(2:25|26)|27|(2:29|30)|31|33|34|35|36|(2:37|38)|39|41|42|43|44|45|46|47|48|49|50|(2:51|52)|53|(2:55|56)|57|(2:59|60)|61|63|64|65|67|68|69|(2:71|72)|73|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|(3:165|166|168)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(141:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|(2:17|18)|19|(2:21|22)|23|(2:25|26)|27|29|30|31|33|34|35|36|(2:37|38)|39|41|42|43|44|45|46|47|48|49|50|(2:51|52)|53|(2:55|56)|57|59|60|61|63|64|65|67|68|69|(2:71|72)|73|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|(3:165|166|168)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(143:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|(2:17|18)|19|(2:21|22)|23|25|26|27|29|30|31|33|34|35|36|(2:37|38)|39|41|42|43|44|45|46|47|48|49|50|(2:51|52)|53|55|56|57|59|60|61|63|64|65|67|68|69|(2:71|72)|73|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|(3:165|166|168)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(145:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|(2:17|18)|19|21|22|23|25|26|27|29|30|31|33|34|35|36|(2:37|38)|39|41|42|43|44|45|46|47|48|49|50|51|52|53|55|56|57|59|60|61|63|64|65|67|68|69|(2:71|72)|73|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|(3:165|166|168)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(146:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|17|18|19|21|22|23|25|26|27|29|30|31|33|34|35|36|(2:37|38)|39|41|42|43|44|45|46|47|48|49|50|51|52|53|55|56|57|59|60|61|63|64|65|67|68|69|(2:71|72)|73|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|(3:165|166|168)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(147:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|21|22|23|25|26|27|29|30|31|33|34|35|36|(2:37|38)|39|41|42|43|44|45|46|47|48|49|50|51|52|53|55|56|57|59|60|61|63|64|65|67|68|69|(2:71|72)|73|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|(3:165|166|168)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(148:0|(2:1|2)|3|5|6|7|9|10|11|13|14|15|16|17|18|19|21|22|23|25|26|27|29|30|31|33|34|35|36|(2:37|38)|39|41|42|43|44|45|46|47|48|49|50|51|52|53|55|56|57|59|60|61|63|64|65|67|68|69|(2:71|72)|73|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|(3:165|166|168)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(153:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|19|21|22|23|25|26|27|29|30|31|33|34|35|36|37|38|39|41|42|43|44|45|46|47|48|49|50|51|52|53|55|56|57|59|60|61|63|64|65|67|68|69|71|72|73|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|165|166|168) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:101:0x0197 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:103:0x01a1 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:105:0x01ab */
        /* JADX WARNING: Missing exception handler attribute for start block: B:107:0x01b5 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:109:0x01bf */
        /* JADX WARNING: Missing exception handler attribute for start block: B:111:0x01c9 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:113:0x01d3 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:115:0x01dd */
        /* JADX WARNING: Missing exception handler attribute for start block: B:117:0x01e7 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:119:0x01f3 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:121:0x01ff */
        /* JADX WARNING: Missing exception handler attribute for start block: B:123:0x020b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:125:0x0217 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:127:0x0223 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:129:0x022f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:131:0x023b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:133:0x0247 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:135:0x0253 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:137:0x025f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:139:0x026b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:141:0x0277 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:143:0x0283 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:145:0x028f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:147:0x029b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:149:0x02a7 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:151:0x02b3 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:153:0x02bf */
        /* JADX WARNING: Missing exception handler attribute for start block: B:155:0x02cb */
        /* JADX WARNING: Missing exception handler attribute for start block: B:157:0x02d7 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:159:0x02e3 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:161:0x02ef */
        /* JADX WARNING: Missing exception handler attribute for start block: B:163:0x02fb */
        /* JADX WARNING: Missing exception handler attribute for start block: B:165:0x0307 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x007f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0089 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00a4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00ae */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00b8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00c2 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00cc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:77:0x0122 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:79:0x012c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:81:0x0136 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:83:0x0140 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:85:0x014a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:87:0x0154 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:89:0x015e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:91:0x0168 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:97:0x0183 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:99:0x018d */
        static {
            /*
                com.o3dr.services.android.lib.drone.mission.MissionItemType[] r0 = com.o3dr.services.android.lib.drone.mission.MissionItemType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8649x5ec7fdea = r0
                r1 = 1
                com.o3dr.services.android.lib.drone.mission.MissionItemType r2 = com.o3dr.services.android.lib.drone.mission.MissionItemType.SURVEY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f8649x5ec7fdea     // Catch:{ NoSuchFieldError -> 0x001d }
                com.o3dr.services.android.lib.drone.mission.MissionItemType r3 = com.o3dr.services.android.lib.drone.mission.MissionItemType.SPLINE_SURVEY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f8649x5ec7fdea     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.o3dr.services.android.lib.drone.mission.MissionItemType r4 = com.o3dr.services.android.lib.drone.mission.MissionItemType.STRUCTURE_SCANNER     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                org.droidplanner.services.android.impl.core.gcs.follow.Follow$FollowStates[] r3 = org.droidplanner.services.android.impl.core.gcs.follow.Follow.FollowStates.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f8652xe4d0c3ee = r3
                org.droidplanner.services.android.impl.core.gcs.follow.Follow$FollowStates r4 = org.droidplanner.services.android.impl.core.gcs.follow.Follow.FollowStates.FOLLOW_INVALID_STATE     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r3 = f8652xe4d0c3ee     // Catch:{ NoSuchFieldError -> 0x0043 }
                org.droidplanner.services.android.impl.core.gcs.follow.Follow$FollowStates r4 = org.droidplanner.services.android.impl.core.gcs.follow.Follow.FollowStates.FOLLOW_DRONE_NOT_ARMED     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r3 = f8652xe4d0c3ee     // Catch:{ NoSuchFieldError -> 0x004d }
                org.droidplanner.services.android.impl.core.gcs.follow.Follow$FollowStates r4 = org.droidplanner.services.android.impl.core.gcs.follow.Follow.FollowStates.FOLLOW_DRONE_DISCONNECTED     // Catch:{ NoSuchFieldError -> 0x004d }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                r3 = 4
                int[] r4 = f8652xe4d0c3ee     // Catch:{ NoSuchFieldError -> 0x0058 }
                org.droidplanner.services.android.impl.core.gcs.follow.Follow$FollowStates r5 = org.droidplanner.services.android.impl.core.gcs.follow.Follow.FollowStates.FOLLOW_START     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                r4 = 5
                int[] r5 = f8652xe4d0c3ee     // Catch:{ NoSuchFieldError -> 0x0063 }
                org.droidplanner.services.android.impl.core.gcs.follow.Follow$FollowStates r6 = org.droidplanner.services.android.impl.core.gcs.follow.Follow.FollowStates.FOLLOW_RUNNING     // Catch:{ NoSuchFieldError -> 0x0063 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0063 }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x0063 }
            L_0x0063:
                r5 = 6
                int[] r6 = f8652xe4d0c3ee     // Catch:{ NoSuchFieldError -> 0x006e }
                org.droidplanner.services.android.impl.core.gcs.follow.Follow$FollowStates r7 = org.droidplanner.services.android.impl.core.gcs.follow.Follow.FollowStates.FOLLOW_END     // Catch:{ NoSuchFieldError -> 0x006e }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r6[r7] = r5     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                org.droidplanner.services.android.impl.core.drone.variables.GuidedPoint$GuidedStates[] r6 = org.droidplanner.services.android.impl.core.drone.variables.GuidedPoint.GuidedStates.values()
                int r6 = r6.length
                int[] r6 = new int[r6]
                f8651x3bace18d = r6
                org.droidplanner.services.android.impl.core.drone.variables.GuidedPoint$GuidedStates r7 = org.droidplanner.services.android.impl.core.drone.variables.GuidedPoint.GuidedStates.UNINITIALIZED     // Catch:{ NoSuchFieldError -> 0x007f }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x007f }
                r6[r7] = r1     // Catch:{ NoSuchFieldError -> 0x007f }
            L_0x007f:
                int[] r6 = f8651x3bace18d     // Catch:{ NoSuchFieldError -> 0x0089 }
                org.droidplanner.services.android.impl.core.drone.variables.GuidedPoint$GuidedStates r7 = org.droidplanner.services.android.impl.core.drone.variables.GuidedPoint.GuidedStates.ACTIVE     // Catch:{ NoSuchFieldError -> 0x0089 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0089 }
                r6[r7] = r0     // Catch:{ NoSuchFieldError -> 0x0089 }
            L_0x0089:
                int[] r6 = f8651x3bace18d     // Catch:{ NoSuchFieldError -> 0x0093 }
                org.droidplanner.services.android.impl.core.drone.variables.GuidedPoint$GuidedStates r7 = org.droidplanner.services.android.impl.core.drone.variables.GuidedPoint.GuidedStates.IDLE     // Catch:{ NoSuchFieldError -> 0x0093 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0093 }
                r6[r7] = r2     // Catch:{ NoSuchFieldError -> 0x0093 }
            L_0x0093:
                org.droidplanner.services.android.impl.core.gcs.follow.FollowAlgorithm$FollowModes[] r6 = org.droidplanner.services.android.impl.core.gcs.follow.FollowAlgorithm.FollowModes.values()
                int r6 = r6.length
                int[] r6 = new int[r6]
                f8653xc43a86a1 = r6
                org.droidplanner.services.android.impl.core.gcs.follow.FollowAlgorithm$FollowModes r7 = org.droidplanner.services.android.impl.core.gcs.follow.FollowAlgorithm.FollowModes.LEASH     // Catch:{ NoSuchFieldError -> 0x00a4 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a4 }
                r6[r7] = r1     // Catch:{ NoSuchFieldError -> 0x00a4 }
            L_0x00a4:
                int[] r6 = f8653xc43a86a1     // Catch:{ NoSuchFieldError -> 0x00ae }
                org.droidplanner.services.android.impl.core.gcs.follow.FollowAlgorithm$FollowModes r7 = org.droidplanner.services.android.impl.core.gcs.follow.FollowAlgorithm.FollowModes.SPLINE_LEASH     // Catch:{ NoSuchFieldError -> 0x00ae }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ae }
                r6[r7] = r0     // Catch:{ NoSuchFieldError -> 0x00ae }
            L_0x00ae:
                int[] r6 = f8653xc43a86a1     // Catch:{ NoSuchFieldError -> 0x00b8 }
                org.droidplanner.services.android.impl.core.gcs.follow.FollowAlgorithm$FollowModes r7 = org.droidplanner.services.android.impl.core.gcs.follow.FollowAlgorithm.FollowModes.LEAD     // Catch:{ NoSuchFieldError -> 0x00b8 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b8 }
                r6[r7] = r2     // Catch:{ NoSuchFieldError -> 0x00b8 }
            L_0x00b8:
                int[] r6 = f8653xc43a86a1     // Catch:{ NoSuchFieldError -> 0x00c2 }
                org.droidplanner.services.android.impl.core.gcs.follow.FollowAlgorithm$FollowModes r7 = org.droidplanner.services.android.impl.core.gcs.follow.FollowAlgorithm.FollowModes.RIGHT     // Catch:{ NoSuchFieldError -> 0x00c2 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c2 }
                r6[r7] = r3     // Catch:{ NoSuchFieldError -> 0x00c2 }
            L_0x00c2:
                int[] r6 = f8653xc43a86a1     // Catch:{ NoSuchFieldError -> 0x00cc }
                org.droidplanner.services.android.impl.core.gcs.follow.FollowAlgorithm$FollowModes r7 = org.droidplanner.services.android.impl.core.gcs.follow.FollowAlgorithm.FollowModes.LEFT     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r6[r7] = r4     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                int[] r6 = f8653xc43a86a1     // Catch:{ NoSuchFieldError -> 0x00d6 }
                org.droidplanner.services.android.impl.core.gcs.follow.FollowAlgorithm$FollowModes r7 = org.droidplanner.services.android.impl.core.gcs.follow.FollowAlgorithm.FollowModes.CIRCLE     // Catch:{ NoSuchFieldError -> 0x00d6 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d6 }
                r6[r7] = r5     // Catch:{ NoSuchFieldError -> 0x00d6 }
            L_0x00d6:
                r6 = 7
                int[] r7 = f8653xc43a86a1     // Catch:{ NoSuchFieldError -> 0x00e1 }
                org.droidplanner.services.android.impl.core.gcs.follow.FollowAlgorithm$FollowModes r8 = org.droidplanner.services.android.impl.core.gcs.follow.FollowAlgorithm.FollowModes.ABOVE     // Catch:{ NoSuchFieldError -> 0x00e1 }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e1 }
                r7[r8] = r6     // Catch:{ NoSuchFieldError -> 0x00e1 }
            L_0x00e1:
                r7 = 8
                int[] r8 = f8653xc43a86a1     // Catch:{ NoSuchFieldError -> 0x00ed }
                org.droidplanner.services.android.impl.core.gcs.follow.FollowAlgorithm$FollowModes r9 = org.droidplanner.services.android.impl.core.gcs.follow.FollowAlgorithm.FollowModes.SPLINE_ABOVE     // Catch:{ NoSuchFieldError -> 0x00ed }
                int r9 = r9.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ed }
                r8[r9] = r7     // Catch:{ NoSuchFieldError -> 0x00ed }
            L_0x00ed:
                r8 = 9
                int[] r9 = f8653xc43a86a1     // Catch:{ NoSuchFieldError -> 0x00f9 }
                org.droidplanner.services.android.impl.core.gcs.follow.FollowAlgorithm$FollowModes r10 = org.droidplanner.services.android.impl.core.gcs.follow.FollowAlgorithm.FollowModes.GUIDED_SCAN     // Catch:{ NoSuchFieldError -> 0x00f9 }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f9 }
                r9[r10] = r8     // Catch:{ NoSuchFieldError -> 0x00f9 }
            L_0x00f9:
                r9 = 10
                int[] r10 = f8653xc43a86a1     // Catch:{ NoSuchFieldError -> 0x0105 }
                org.droidplanner.services.android.impl.core.gcs.follow.FollowAlgorithm$FollowModes r11 = org.droidplanner.services.android.impl.core.gcs.follow.FollowAlgorithm.FollowModes.LOOK_AT_ME     // Catch:{ NoSuchFieldError -> 0x0105 }
                int r11 = r11.ordinal()     // Catch:{ NoSuchFieldError -> 0x0105 }
                r10[r11] = r9     // Catch:{ NoSuchFieldError -> 0x0105 }
            L_0x0105:
                r10 = 11
                int[] r11 = f8653xc43a86a1     // Catch:{ NoSuchFieldError -> 0x0111 }
                org.droidplanner.services.android.impl.core.gcs.follow.FollowAlgorithm$FollowModes r12 = org.droidplanner.services.android.impl.core.gcs.follow.FollowAlgorithm.FollowModes.SOLO_SHOT     // Catch:{ NoSuchFieldError -> 0x0111 }
                int r12 = r12.ordinal()     // Catch:{ NoSuchFieldError -> 0x0111 }
                r11[r12] = r10     // Catch:{ NoSuchFieldError -> 0x0111 }
            L_0x0111:
                com.o3dr.services.android.lib.gcs.follow.FollowType[] r11 = com.o3dr.services.android.lib.gcs.follow.FollowType.values()
                int r11 = r11.length
                int[] r11 = new int[r11]
                $SwitchMap$com$o3dr$services$android$lib$gcs$follow$FollowType = r11
                com.o3dr.services.android.lib.gcs.follow.FollowType r12 = com.o3dr.services.android.lib.gcs.follow.FollowType.ABOVE     // Catch:{ NoSuchFieldError -> 0x0122 }
                int r12 = r12.ordinal()     // Catch:{ NoSuchFieldError -> 0x0122 }
                r11[r12] = r1     // Catch:{ NoSuchFieldError -> 0x0122 }
            L_0x0122:
                int[] r11 = $SwitchMap$com$o3dr$services$android$lib$gcs$follow$FollowType     // Catch:{ NoSuchFieldError -> 0x012c }
                com.o3dr.services.android.lib.gcs.follow.FollowType r12 = com.o3dr.services.android.lib.gcs.follow.FollowType.LEAD     // Catch:{ NoSuchFieldError -> 0x012c }
                int r12 = r12.ordinal()     // Catch:{ NoSuchFieldError -> 0x012c }
                r11[r12] = r0     // Catch:{ NoSuchFieldError -> 0x012c }
            L_0x012c:
                int[] r11 = $SwitchMap$com$o3dr$services$android$lib$gcs$follow$FollowType     // Catch:{ NoSuchFieldError -> 0x0136 }
                com.o3dr.services.android.lib.gcs.follow.FollowType r12 = com.o3dr.services.android.lib.gcs.follow.FollowType.LEASH     // Catch:{ NoSuchFieldError -> 0x0136 }
                int r12 = r12.ordinal()     // Catch:{ NoSuchFieldError -> 0x0136 }
                r11[r12] = r2     // Catch:{ NoSuchFieldError -> 0x0136 }
            L_0x0136:
                int[] r11 = $SwitchMap$com$o3dr$services$android$lib$gcs$follow$FollowType     // Catch:{ NoSuchFieldError -> 0x0140 }
                com.o3dr.services.android.lib.gcs.follow.FollowType r12 = com.o3dr.services.android.lib.gcs.follow.FollowType.CIRCLE     // Catch:{ NoSuchFieldError -> 0x0140 }
                int r12 = r12.ordinal()     // Catch:{ NoSuchFieldError -> 0x0140 }
                r11[r12] = r3     // Catch:{ NoSuchFieldError -> 0x0140 }
            L_0x0140:
                int[] r11 = $SwitchMap$com$o3dr$services$android$lib$gcs$follow$FollowType     // Catch:{ NoSuchFieldError -> 0x014a }
                com.o3dr.services.android.lib.gcs.follow.FollowType r12 = com.o3dr.services.android.lib.gcs.follow.FollowType.LEFT     // Catch:{ NoSuchFieldError -> 0x014a }
                int r12 = r12.ordinal()     // Catch:{ NoSuchFieldError -> 0x014a }
                r11[r12] = r4     // Catch:{ NoSuchFieldError -> 0x014a }
            L_0x014a:
                int[] r11 = $SwitchMap$com$o3dr$services$android$lib$gcs$follow$FollowType     // Catch:{ NoSuchFieldError -> 0x0154 }
                com.o3dr.services.android.lib.gcs.follow.FollowType r12 = com.o3dr.services.android.lib.gcs.follow.FollowType.RIGHT     // Catch:{ NoSuchFieldError -> 0x0154 }
                int r12 = r12.ordinal()     // Catch:{ NoSuchFieldError -> 0x0154 }
                r11[r12] = r5     // Catch:{ NoSuchFieldError -> 0x0154 }
            L_0x0154:
                int[] r11 = $SwitchMap$com$o3dr$services$android$lib$gcs$follow$FollowType     // Catch:{ NoSuchFieldError -> 0x015e }
                com.o3dr.services.android.lib.gcs.follow.FollowType r12 = com.o3dr.services.android.lib.gcs.follow.FollowType.GUIDED_SCAN     // Catch:{ NoSuchFieldError -> 0x015e }
                int r12 = r12.ordinal()     // Catch:{ NoSuchFieldError -> 0x015e }
                r11[r12] = r6     // Catch:{ NoSuchFieldError -> 0x015e }
            L_0x015e:
                int[] r11 = $SwitchMap$com$o3dr$services$android$lib$gcs$follow$FollowType     // Catch:{ NoSuchFieldError -> 0x0168 }
                com.o3dr.services.android.lib.gcs.follow.FollowType r12 = com.o3dr.services.android.lib.gcs.follow.FollowType.LOOK_AT_ME     // Catch:{ NoSuchFieldError -> 0x0168 }
                int r12 = r12.ordinal()     // Catch:{ NoSuchFieldError -> 0x0168 }
                r11[r12] = r7     // Catch:{ NoSuchFieldError -> 0x0168 }
            L_0x0168:
                int[] r11 = $SwitchMap$com$o3dr$services$android$lib$gcs$follow$FollowType     // Catch:{ NoSuchFieldError -> 0x0172 }
                com.o3dr.services.android.lib.gcs.follow.FollowType r12 = com.o3dr.services.android.lib.gcs.follow.FollowType.SOLO_SHOT     // Catch:{ NoSuchFieldError -> 0x0172 }
                int r12 = r12.ordinal()     // Catch:{ NoSuchFieldError -> 0x0172 }
                r11[r12] = r8     // Catch:{ NoSuchFieldError -> 0x0172 }
            L_0x0172:
                org.droidplanner.services.android.impl.core.drone.variables.ApmModes[] r11 = org.droidplanner.services.android.impl.core.drone.variables.ApmModes.values()
                int r11 = r11.length
                int[] r11 = new int[r11]
                f8650x3b160879 = r11
                org.droidplanner.services.android.impl.core.drone.variables.ApmModes r12 = org.droidplanner.services.android.impl.core.drone.variables.ApmModes.FIXED_WING_MANUAL     // Catch:{ NoSuchFieldError -> 0x0183 }
                int r12 = r12.ordinal()     // Catch:{ NoSuchFieldError -> 0x0183 }
                r11[r12] = r1     // Catch:{ NoSuchFieldError -> 0x0183 }
            L_0x0183:
                int[] r1 = f8650x3b160879     // Catch:{ NoSuchFieldError -> 0x018d }
                org.droidplanner.services.android.impl.core.drone.variables.ApmModes r11 = org.droidplanner.services.android.impl.core.drone.variables.ApmModes.FIXED_WING_CIRCLE     // Catch:{ NoSuchFieldError -> 0x018d }
                int r11 = r11.ordinal()     // Catch:{ NoSuchFieldError -> 0x018d }
                r1[r11] = r0     // Catch:{ NoSuchFieldError -> 0x018d }
            L_0x018d:
                int[] r0 = f8650x3b160879     // Catch:{ NoSuchFieldError -> 0x0197 }
                org.droidplanner.services.android.impl.core.drone.variables.ApmModes r1 = org.droidplanner.services.android.impl.core.drone.variables.ApmModes.FIXED_WING_STABILIZE     // Catch:{ NoSuchFieldError -> 0x0197 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0197 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0197 }
            L_0x0197:
                int[] r0 = f8650x3b160879     // Catch:{ NoSuchFieldError -> 0x01a1 }
                org.droidplanner.services.android.impl.core.drone.variables.ApmModes r1 = org.droidplanner.services.android.impl.core.drone.variables.ApmModes.FIXED_WING_TRAINING     // Catch:{ NoSuchFieldError -> 0x01a1 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x01a1 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x01a1 }
            L_0x01a1:
                int[] r0 = f8650x3b160879     // Catch:{ NoSuchFieldError -> 0x01ab }
                org.droidplanner.services.android.impl.core.drone.variables.ApmModes r1 = org.droidplanner.services.android.impl.core.drone.variables.ApmModes.FIXED_WING_ACRO     // Catch:{ NoSuchFieldError -> 0x01ab }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x01ab }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x01ab }
            L_0x01ab:
                int[] r0 = f8650x3b160879     // Catch:{ NoSuchFieldError -> 0x01b5 }
                org.droidplanner.services.android.impl.core.drone.variables.ApmModes r1 = org.droidplanner.services.android.impl.core.drone.variables.ApmModes.FIXED_WING_FLY_BY_WIRE_A     // Catch:{ NoSuchFieldError -> 0x01b5 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x01b5 }
                r0[r1] = r5     // Catch:{ NoSuchFieldError -> 0x01b5 }
            L_0x01b5:
                int[] r0 = f8650x3b160879     // Catch:{ NoSuchFieldError -> 0x01bf }
                org.droidplanner.services.android.impl.core.drone.variables.ApmModes r1 = org.droidplanner.services.android.impl.core.drone.variables.ApmModes.FIXED_WING_FLY_BY_WIRE_B     // Catch:{ NoSuchFieldError -> 0x01bf }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x01bf }
                r0[r1] = r6     // Catch:{ NoSuchFieldError -> 0x01bf }
            L_0x01bf:
                int[] r0 = f8650x3b160879     // Catch:{ NoSuchFieldError -> 0x01c9 }
                org.droidplanner.services.android.impl.core.drone.variables.ApmModes r1 = org.droidplanner.services.android.impl.core.drone.variables.ApmModes.FIXED_WING_CRUISE     // Catch:{ NoSuchFieldError -> 0x01c9 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x01c9 }
                r0[r1] = r7     // Catch:{ NoSuchFieldError -> 0x01c9 }
            L_0x01c9:
                int[] r0 = f8650x3b160879     // Catch:{ NoSuchFieldError -> 0x01d3 }
                org.droidplanner.services.android.impl.core.drone.variables.ApmModes r1 = org.droidplanner.services.android.impl.core.drone.variables.ApmModes.FIXED_WING_AUTOTUNE     // Catch:{ NoSuchFieldError -> 0x01d3 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x01d3 }
                r0[r1] = r8     // Catch:{ NoSuchFieldError -> 0x01d3 }
            L_0x01d3:
                int[] r0 = f8650x3b160879     // Catch:{ NoSuchFieldError -> 0x01dd }
                org.droidplanner.services.android.impl.core.drone.variables.ApmModes r1 = org.droidplanner.services.android.impl.core.drone.variables.ApmModes.FIXED_WING_AUTO     // Catch:{ NoSuchFieldError -> 0x01dd }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x01dd }
                r0[r1] = r9     // Catch:{ NoSuchFieldError -> 0x01dd }
            L_0x01dd:
                int[] r0 = f8650x3b160879     // Catch:{ NoSuchFieldError -> 0x01e7 }
                org.droidplanner.services.android.impl.core.drone.variables.ApmModes r1 = org.droidplanner.services.android.impl.core.drone.variables.ApmModes.FIXED_WING_RTL     // Catch:{ NoSuchFieldError -> 0x01e7 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x01e7 }
                r0[r1] = r10     // Catch:{ NoSuchFieldError -> 0x01e7 }
            L_0x01e7:
                int[] r0 = f8650x3b160879     // Catch:{ NoSuchFieldError -> 0x01f3 }
                org.droidplanner.services.android.impl.core.drone.variables.ApmModes r1 = org.droidplanner.services.android.impl.core.drone.variables.ApmModes.FIXED_WING_LOITER     // Catch:{ NoSuchFieldError -> 0x01f3 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x01f3 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x01f3 }
            L_0x01f3:
                int[] r0 = f8650x3b160879     // Catch:{ NoSuchFieldError -> 0x01ff }
                org.droidplanner.services.android.impl.core.drone.variables.ApmModes r1 = org.droidplanner.services.android.impl.core.drone.variables.ApmModes.FIXED_WING_GUIDED     // Catch:{ NoSuchFieldError -> 0x01ff }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x01ff }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x01ff }
            L_0x01ff:
                int[] r0 = f8650x3b160879     // Catch:{ NoSuchFieldError -> 0x020b }
                org.droidplanner.services.android.impl.core.drone.variables.ApmModes r1 = org.droidplanner.services.android.impl.core.drone.variables.ApmModes.ROTOR_STABILIZE     // Catch:{ NoSuchFieldError -> 0x020b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x020b }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x020b }
            L_0x020b:
                int[] r0 = f8650x3b160879     // Catch:{ NoSuchFieldError -> 0x0217 }
                org.droidplanner.services.android.impl.core.drone.variables.ApmModes r1 = org.droidplanner.services.android.impl.core.drone.variables.ApmModes.ROTOR_ACRO     // Catch:{ NoSuchFieldError -> 0x0217 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0217 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0217 }
            L_0x0217:
                int[] r0 = f8650x3b160879     // Catch:{ NoSuchFieldError -> 0x0223 }
                org.droidplanner.services.android.impl.core.drone.variables.ApmModes r1 = org.droidplanner.services.android.impl.core.drone.variables.ApmModes.ROTOR_ALT_HOLD     // Catch:{ NoSuchFieldError -> 0x0223 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0223 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0223 }
            L_0x0223:
                int[] r0 = f8650x3b160879     // Catch:{ NoSuchFieldError -> 0x022f }
                org.droidplanner.services.android.impl.core.drone.variables.ApmModes r1 = org.droidplanner.services.android.impl.core.drone.variables.ApmModes.ROTOR_AUTO     // Catch:{ NoSuchFieldError -> 0x022f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x022f }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x022f }
            L_0x022f:
                int[] r0 = f8650x3b160879     // Catch:{ NoSuchFieldError -> 0x023b }
                org.droidplanner.services.android.impl.core.drone.variables.ApmModes r1 = org.droidplanner.services.android.impl.core.drone.variables.ApmModes.ROTOR_GUIDED     // Catch:{ NoSuchFieldError -> 0x023b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x023b }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x023b }
            L_0x023b:
                int[] r0 = f8650x3b160879     // Catch:{ NoSuchFieldError -> 0x0247 }
                org.droidplanner.services.android.impl.core.drone.variables.ApmModes r1 = org.droidplanner.services.android.impl.core.drone.variables.ApmModes.ROTOR_LOITER     // Catch:{ NoSuchFieldError -> 0x0247 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0247 }
                r2 = 19
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0247 }
            L_0x0247:
                int[] r0 = f8650x3b160879     // Catch:{ NoSuchFieldError -> 0x0253 }
                org.droidplanner.services.android.impl.core.drone.variables.ApmModes r1 = org.droidplanner.services.android.impl.core.drone.variables.ApmModes.ROTOR_RTL     // Catch:{ NoSuchFieldError -> 0x0253 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0253 }
                r2 = 20
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0253 }
            L_0x0253:
                int[] r0 = f8650x3b160879     // Catch:{ NoSuchFieldError -> 0x025f }
                org.droidplanner.services.android.impl.core.drone.variables.ApmModes r1 = org.droidplanner.services.android.impl.core.drone.variables.ApmModes.ROTOR_CIRCLE     // Catch:{ NoSuchFieldError -> 0x025f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x025f }
                r2 = 21
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x025f }
            L_0x025f:
                int[] r0 = f8650x3b160879     // Catch:{ NoSuchFieldError -> 0x026b }
                org.droidplanner.services.android.impl.core.drone.variables.ApmModes r1 = org.droidplanner.services.android.impl.core.drone.variables.ApmModes.ROTOR_LAND     // Catch:{ NoSuchFieldError -> 0x026b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x026b }
                r2 = 22
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x026b }
            L_0x026b:
                int[] r0 = f8650x3b160879     // Catch:{ NoSuchFieldError -> 0x0277 }
                org.droidplanner.services.android.impl.core.drone.variables.ApmModes r1 = org.droidplanner.services.android.impl.core.drone.variables.ApmModes.ROTOR_TOY     // Catch:{ NoSuchFieldError -> 0x0277 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0277 }
                r2 = 23
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0277 }
            L_0x0277:
                int[] r0 = f8650x3b160879     // Catch:{ NoSuchFieldError -> 0x0283 }
                org.droidplanner.services.android.impl.core.drone.variables.ApmModes r1 = org.droidplanner.services.android.impl.core.drone.variables.ApmModes.ROTOR_SPORT     // Catch:{ NoSuchFieldError -> 0x0283 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0283 }
                r2 = 24
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0283 }
            L_0x0283:
                int[] r0 = f8650x3b160879     // Catch:{ NoSuchFieldError -> 0x028f }
                org.droidplanner.services.android.impl.core.drone.variables.ApmModes r1 = org.droidplanner.services.android.impl.core.drone.variables.ApmModes.ROTOR_AUTOTUNE     // Catch:{ NoSuchFieldError -> 0x028f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x028f }
                r2 = 25
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x028f }
            L_0x028f:
                int[] r0 = f8650x3b160879     // Catch:{ NoSuchFieldError -> 0x029b }
                org.droidplanner.services.android.impl.core.drone.variables.ApmModes r1 = org.droidplanner.services.android.impl.core.drone.variables.ApmModes.ROTOR_POSHOLD     // Catch:{ NoSuchFieldError -> 0x029b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x029b }
                r2 = 26
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x029b }
            L_0x029b:
                int[] r0 = f8650x3b160879     // Catch:{ NoSuchFieldError -> 0x02a7 }
                org.droidplanner.services.android.impl.core.drone.variables.ApmModes r1 = org.droidplanner.services.android.impl.core.drone.variables.ApmModes.ROTOR_BRAKE     // Catch:{ NoSuchFieldError -> 0x02a7 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x02a7 }
                r2 = 27
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x02a7 }
            L_0x02a7:
                int[] r0 = f8650x3b160879     // Catch:{ NoSuchFieldError -> 0x02b3 }
                org.droidplanner.services.android.impl.core.drone.variables.ApmModes r1 = org.droidplanner.services.android.impl.core.drone.variables.ApmModes.ROVER_MANUAL     // Catch:{ NoSuchFieldError -> 0x02b3 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x02b3 }
                r2 = 28
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x02b3 }
            L_0x02b3:
                int[] r0 = f8650x3b160879     // Catch:{ NoSuchFieldError -> 0x02bf }
                org.droidplanner.services.android.impl.core.drone.variables.ApmModes r1 = org.droidplanner.services.android.impl.core.drone.variables.ApmModes.ROVER_LEARNING     // Catch:{ NoSuchFieldError -> 0x02bf }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x02bf }
                r2 = 29
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x02bf }
            L_0x02bf:
                int[] r0 = f8650x3b160879     // Catch:{ NoSuchFieldError -> 0x02cb }
                org.droidplanner.services.android.impl.core.drone.variables.ApmModes r1 = org.droidplanner.services.android.impl.core.drone.variables.ApmModes.ROVER_STEERING     // Catch:{ NoSuchFieldError -> 0x02cb }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x02cb }
                r2 = 30
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x02cb }
            L_0x02cb:
                int[] r0 = f8650x3b160879     // Catch:{ NoSuchFieldError -> 0x02d7 }
                org.droidplanner.services.android.impl.core.drone.variables.ApmModes r1 = org.droidplanner.services.android.impl.core.drone.variables.ApmModes.ROVER_HOLD     // Catch:{ NoSuchFieldError -> 0x02d7 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x02d7 }
                r2 = 31
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x02d7 }
            L_0x02d7:
                int[] r0 = f8650x3b160879     // Catch:{ NoSuchFieldError -> 0x02e3 }
                org.droidplanner.services.android.impl.core.drone.variables.ApmModes r1 = org.droidplanner.services.android.impl.core.drone.variables.ApmModes.ROVER_AUTO     // Catch:{ NoSuchFieldError -> 0x02e3 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x02e3 }
                r2 = 32
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x02e3 }
            L_0x02e3:
                int[] r0 = f8650x3b160879     // Catch:{ NoSuchFieldError -> 0x02ef }
                org.droidplanner.services.android.impl.core.drone.variables.ApmModes r1 = org.droidplanner.services.android.impl.core.drone.variables.ApmModes.ROVER_RTL     // Catch:{ NoSuchFieldError -> 0x02ef }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x02ef }
                r2 = 33
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x02ef }
            L_0x02ef:
                int[] r0 = f8650x3b160879     // Catch:{ NoSuchFieldError -> 0x02fb }
                org.droidplanner.services.android.impl.core.drone.variables.ApmModes r1 = org.droidplanner.services.android.impl.core.drone.variables.ApmModes.ROVER_GUIDED     // Catch:{ NoSuchFieldError -> 0x02fb }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x02fb }
                r2 = 34
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x02fb }
            L_0x02fb:
                int[] r0 = f8650x3b160879     // Catch:{ NoSuchFieldError -> 0x0307 }
                org.droidplanner.services.android.impl.core.drone.variables.ApmModes r1 = org.droidplanner.services.android.impl.core.drone.variables.ApmModes.ROVER_INITIALIZING     // Catch:{ NoSuchFieldError -> 0x0307 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0307 }
                r2 = 35
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0307 }
            L_0x0307:
                int[] r0 = f8650x3b160879     // Catch:{ NoSuchFieldError -> 0x0313 }
                org.droidplanner.services.android.impl.core.drone.variables.ApmModes r1 = org.droidplanner.services.android.impl.core.drone.variables.ApmModes.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0313 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0313 }
                r2 = 36
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0313 }
            L_0x0313:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.droidplanner.services.android.impl.utils.CommonApiUtils.C60116.<clinit>():void");
        }
    }

    public static Survey buildSurvey(MavLinkDrone mavLinkDrone, Survey survey) {
        return (Survey) ProxyUtils.getProxyMissionItem((SurveyImpl) ProxyUtils.getMissionItemImpl(mavLinkDrone == null ? null : mavLinkDrone.getMission(), survey));
    }

    public static Survey buildSplineSurvey(MavLinkDrone mavLinkDrone, Survey survey) {
        return (Survey) ProxyUtils.getProxyMissionItem((SplineSurveyImpl) ProxyUtils.getMissionItemImpl(mavLinkDrone == null ? null : mavLinkDrone.getMission(), survey));
    }

    public static StructureScanner buildStructureScanner(MavLinkDrone mavLinkDrone, StructureScanner structureScanner) {
        return (StructureScanner) ProxyUtils.getProxyMissionItem((StructureScannerImpl) ProxyUtils.getMissionItemImpl(mavLinkDrone == null ? null : mavLinkDrone.getMission(), structureScanner));
    }

    public static MagnetometerCalibrationStatus getMagnetometerCalibrationStatus(MavLinkDrone mavLinkDrone) {
        MagnetometerCalibrationStatus magnetometerCalibrationStatus = new MagnetometerCalibrationStatus();
        if (mavLinkDrone != null) {
            MagnetometerCalibrationImpl magnetometerCalibration = mavLinkDrone.getMagnetometerCalibration();
            magnetometerCalibrationStatus.setCalibrationCancelled(magnetometerCalibration.isCancelled());
            for (MagnetometerCalibrationImpl.Info next : magnetometerCalibration.getMagCalibrationTracker().values()) {
                magnetometerCalibrationStatus.addCalibrationProgress(getMagnetometerCalibrationProgress(next.getCalProgress()));
                magnetometerCalibrationStatus.addCalibrationResult(getMagnetometerCalibrationResult(next.getCalReport()));
            }
        }
        return magnetometerCalibrationStatus;
    }

    public static MagnetometerCalibrationProgress getMagnetometerCalibrationProgress(msg_mag_cal_progress msg_mag_cal_progress) {
        if (msg_mag_cal_progress == null) {
            return null;
        }
        return new MagnetometerCalibrationProgress(msg_mag_cal_progress.compass_id, msg_mag_cal_progress.completion_pct, msg_mag_cal_progress.direction_x, msg_mag_cal_progress.direction_y, msg_mag_cal_progress.direction_z);
    }

    public static MagnetometerCalibrationResult getMagnetometerCalibrationResult(msg_mag_cal_report msg_mag_cal_report) {
        if (msg_mag_cal_report == null) {
            return null;
        }
        short s = msg_mag_cal_report.compass_id;
        boolean z = false;
        boolean z2 = msg_mag_cal_report.cal_status == 4;
        if (msg_mag_cal_report.autosaved == 1) {
            z = true;
        }
        return new MagnetometerCalibrationResult(s, z2, z, msg_mag_cal_report.fitness, msg_mag_cal_report.ofs_x, msg_mag_cal_report.ofs_y, msg_mag_cal_report.ofs_z, msg_mag_cal_report.diag_x, msg_mag_cal_report.diag_y, msg_mag_cal_report.diag_z, msg_mag_cal_report.offdiag_x, msg_mag_cal_report.offdiag_y, msg_mag_cal_report.offdiag_z);
    }

    public static void startVideoStream(Drone drone, Bundle bundle, String str, String str2, Surface surface, ICommandListener iCommandListener) {
        if (!(drone instanceof GenericMavLinkDrone)) {
            postErrorEvent(3, iCommandListener);
        } else {
            ((GenericMavLinkDrone) drone).startVideoStream(bundle, str, str2, surface, iCommandListener);
        }
    }

    public static void stopVideoStream(Drone drone, String str, String str2, ICommandListener iCommandListener) {
        if (!(drone instanceof GenericMavLinkDrone)) {
            postErrorEvent(3, iCommandListener);
        } else {
            ((GenericMavLinkDrone) drone).stopVideoStream(str, str2, iCommandListener);
        }
    }

    public static void startVideoStreamForObserver(Drone drone, String str, String str2, ICommandListener iCommandListener) {
        if (!(drone instanceof GenericMavLinkDrone)) {
            postErrorEvent(3, iCommandListener);
        } else {
            ((GenericMavLinkDrone) drone).startVideoStreamForObserver(str, str2, iCommandListener);
        }
    }

    public static void stopVideoStreamForObserver(Drone drone, String str, String str2, ICommandListener iCommandListener) {
        if (!(drone instanceof GenericMavLinkDrone)) {
            postErrorEvent(3, iCommandListener);
        } else {
            ((GenericMavLinkDrone) drone).stopVideoStreamForObserver(str, str2, iCommandListener);
        }
    }
}

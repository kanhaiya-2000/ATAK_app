package com.autel.internal.flycontroller.evo2;

import com.autel.AutelNet2.aircraft.flycontroller.AircraftHeatBeatManager2;
import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.CallbackWithOneParamProgress;
import com.autel.common.CallbackWithTwoParams;
import com.autel.common.camera.visual.TrackTargetArea;
import com.autel.common.camera.visual.TrackingAction;
import com.autel.common.camera.visual.TrackingGoalArea;
import com.autel.common.camera.visual.ViewPointTargetArea;
import com.autel.common.camera.visual.ViewpointAction;
import com.autel.common.camera.visual.VisualWarningInfo;
import com.autel.common.flycontroller.ARMWarning;
import com.autel.common.flycontroller.AuthInfo;
import com.autel.common.flycontroller.BoatMode;
import com.autel.common.flycontroller.CalibrateIMUStatus;
import com.autel.common.flycontroller.CalibrateIMUStep;
import com.autel.common.flycontroller.FlyControllerStatus;
import com.autel.common.flycontroller.FlyLimitAreaWarning;
import com.autel.common.flycontroller.FlyMode;
import com.autel.common.flycontroller.FmuParameterEvent;
import com.autel.common.flycontroller.GPSInfo;
import com.autel.common.flycontroller.MainFlyState;
import com.autel.common.flycontroller.RTKSignalType;
import com.autel.common.flycontroller.RtkCoordinateSystem;
import com.autel.common.flycontroller.evo.EvoFlyControllerInfo;
import com.autel.common.flycontroller.evo.EvoFlyControllerParameterRangeManager;
import com.autel.common.flycontroller.evo2.MotionDelayParams;
import com.autel.common.flycontroller.evo2.RTKInternal;
import com.autel.common.flycontroller.evo2.TripodParams;
import com.autel.common.flycontroller.visual.AvoidanceRadarInfo;
import com.autel.common.flycontroller.visual.DynamicTrackMode;
import com.autel.common.flycontroller.visual.VisualSettingInfo;
import com.autel.common.flycontroller.visual.VisualSettingSwitchblade;
import com.autel.common.mission.AutelCoordinate3D;
import com.autel.common.mission.RealTimeInfo;
import com.autel.internal.AutelListenerManager;
import com.autel.internal.AutelModuleService;
import com.autel.internal.AutelServiceVersion;
import com.autel.internal.flycontroller.AutelFlyControllerInitializeProxy;
import com.autel.internal.flycontroller.FlyControllerFactory;
import com.autel.internal.flycontroller.evo.bean.G2FlyControllerInfoImpl;
import com.autel.internal.sdk.flycontroller.FileDataType;
import com.autel.sdk.flycontroller.p007rx.RxEvo2FlyController;
import java.util.List;

public class Evo2FlyControllerInitializeProxy extends AutelFlyControllerInitializeProxy implements Evo2FlyControllerService4Initialize {
    protected Evo2FlyControllerService g2FlyControllerService;
    private RxEvo2FlyController mRxG2FlyController;

    public Evo2FlyControllerInitializeProxy() {
        super(createFlyControllerStatus(), new GPSInfo() {
            public int getSatelliteStrength() {
                return 0;
            }

            public int getGpsCount() {
                return G2FlyControllerInfoImpl.instance().mG2GpsInfo.getSatellitesVisible();
            }

            public AutelCoordinate3D getCoordinate() {
                return new AutelCoordinate3D(G2FlyControllerInfoImpl.instance().mG2GpsInfo.getLatitude(), G2FlyControllerInfoImpl.instance().mG2GpsInfo.getLongitude());
            }
        });
    }

    /* access modifiers changed from: protected */
    public AutelModuleService buildConnection(AutelServiceVersion autelServiceVersion) {
        Evo2FlyControllerService createEvo2FlyController = FlyControllerFactory.createEvo2FlyController(autelServiceVersion);
        this.g2FlyControllerService = createEvo2FlyController;
        this.flyControllerService = createEvo2FlyController;
        return this.g2FlyControllerService;
    }

    /* access modifiers changed from: protected */
    public void initListener() {
        super.initListener();
        if (this.g2FlyControllerService != null) {
            Object obj = this.listenerManager.get(AutelListenerManager.FlyControllerInfoListener);
            if (obj instanceof CallbackWithTwoParams) {
                this.g2FlyControllerService.setFlyControllerInfoListener((CallbackWithOneParam) obj);
            }
            Object obj2 = this.listenerManager.get(AutelListenerManager.VisualWarnListener);
            if (obj2 instanceof CallbackWithOneParam) {
                this.g2FlyControllerService.setVisualWarnListener((CallbackWithOneParam) obj2);
            }
            Object obj3 = this.listenerManager.get(AutelListenerManager.RadarInfoListener);
            if (obj3 instanceof CallbackWithOneParam) {
                this.g2FlyControllerService.setAvoidanceRadarInfoListener((CallbackWithOneParam) obj3);
            }
            Object obj4 = this.listenerManager.get(AutelListenerManager.VisualSettingInfoListener);
            if (obj4 instanceof CallbackWithOneParam) {
                this.g2FlyControllerService.setVisualSettingInfoListener((CallbackWithOneParam) obj4);
            }
            Object obj5 = this.listenerManager.get(AutelListenerManager.VisualViewpoingListener);
            if (obj5 instanceof CallbackWithOneParam) {
                this.g2FlyControllerService.setViewpointInfoListener((CallbackWithOneParam) obj5);
            }
            Object obj6 = this.listenerManager.get(AutelListenerManager.FlyControllerParameterChangedListener);
            if (obj6 instanceof CallbackWithOneParam) {
                this.g2FlyControllerService.setFlyControllerParameterChangedListener((CallbackWithTwoParams) obj6);
            }
            Object obj7 = this.listenerManager.get(AutelListenerManager.BreakPointMissionListener);
            if (obj7 instanceof CallbackWithOneParam) {
                this.g2FlyControllerService.setBreakPointMissionListener((CallbackWithOneParam) obj7);
            }
            Object obj8 = this.listenerManager.get(AutelListenerManager.RtkInfoListener);
            if (obj8 instanceof CallbackWithOneParam) {
                this.g2FlyControllerService.setRtkInfoListener((CallbackWithOneParam) obj8);
            }
            Object obj9 = this.listenerManager.get(AutelListenerManager.RtkGGAListener);
            if (obj9 instanceof CallbackWithOneParam) {
                this.g2FlyControllerService.setRtkGGAListener((CallbackWithOneParam) obj9);
            }
        }
    }

    public void sendRtkData(byte[] bArr) {
        Evo2FlyControllerService evo2FlyControllerService = this.g2FlyControllerService;
        if (evo2FlyControllerService != null) {
            evo2FlyControllerService.sendRtkData(bArr);
        }
    }

    public void setRtkGGAListener(CallbackWithOneParam<byte[]> callbackWithOneParam) {
        this.listenerManager.put(AutelListenerManager.RtkGGAListener, callbackWithOneParam);
        Evo2FlyControllerService evo2FlyControllerService = this.g2FlyControllerService;
        if (evo2FlyControllerService != null) {
            evo2FlyControllerService.setRtkGGAListener(callbackWithOneParam);
        }
    }

    public void setRtkInfoListener(CallbackWithOneParam<RTKInternal> callbackWithOneParam) {
        this.listenerManager.put(AutelListenerManager.RtkInfoListener, callbackWithOneParam);
        Evo2FlyControllerService evo2FlyControllerService = this.g2FlyControllerService;
        if (evo2FlyControllerService != null) {
            evo2FlyControllerService.setRtkInfoListener(callbackWithOneParam);
        }
    }

    public void setBreakPointMissionListener(CallbackWithOneParam<RealTimeInfo> callbackWithOneParam) {
        this.listenerManager.put(AutelListenerManager.BreakPointMissionListener, callbackWithOneParam);
        Evo2FlyControllerService evo2FlyControllerService = this.g2FlyControllerService;
        if (evo2FlyControllerService != null) {
            evo2FlyControllerService.setBreakPointMissionListener(callbackWithOneParam);
        }
    }

    public void setFlyControllerInfoListener(CallbackWithOneParam<EvoFlyControllerInfo> callbackWithOneParam) {
        this.listenerManager.put(AutelListenerManager.FlyControllerInfoListener, callbackWithOneParam);
        Evo2FlyControllerService evo2FlyControllerService = this.g2FlyControllerService;
        if (evo2FlyControllerService != null) {
            evo2FlyControllerService.setFlyControllerInfoListener(callbackWithOneParam);
        }
    }

    public void setFlyControllerParameterChangedListener(CallbackWithTwoParams<FmuParameterEvent, Float> callbackWithTwoParams) {
        this.listenerManager.put(AutelListenerManager.FlyControllerParameterChangedListener, callbackWithTwoParams);
        Evo2FlyControllerService evo2FlyControllerService = this.g2FlyControllerService;
        if (evo2FlyControllerService != null) {
            evo2FlyControllerService.setFlyControllerParameterChangedListener(callbackWithTwoParams);
        }
    }

    public void setVisualWarnListener(CallbackWithOneParam<VisualWarningInfo> callbackWithOneParam) {
        this.listenerManager.put(AutelListenerManager.VisualWarnListener, callbackWithOneParam);
        Evo2FlyControllerService evo2FlyControllerService = this.g2FlyControllerService;
        if (evo2FlyControllerService != null) {
            evo2FlyControllerService.setVisualWarnListener(callbackWithOneParam);
        }
    }

    public void setAvoidanceRadarInfoListener(CallbackWithOneParam<AvoidanceRadarInfo> callbackWithOneParam) {
        this.listenerManager.put(AutelListenerManager.RadarInfoListener, callbackWithOneParam);
        Evo2FlyControllerService evo2FlyControllerService = this.g2FlyControllerService;
        if (evo2FlyControllerService != null) {
            evo2FlyControllerService.setAvoidanceRadarInfoListener(callbackWithOneParam);
        }
    }

    public void setVisualSettingInfoListener(CallbackWithOneParam<VisualSettingInfo> callbackWithOneParam) {
        this.listenerManager.put(AutelListenerManager.VisualSettingInfoListener, callbackWithOneParam);
        Evo2FlyControllerService evo2FlyControllerService = this.g2FlyControllerService;
        if (evo2FlyControllerService != null) {
            evo2FlyControllerService.setVisualSettingInfoListener(callbackWithOneParam);
        }
    }

    public void setViewpointInfoListener(CallbackWithOneParam<ViewPointTargetArea> callbackWithOneParam) {
        this.listenerManager.put(AutelListenerManager.VisualViewpoingListener, callbackWithOneParam);
        Evo2FlyControllerService evo2FlyControllerService = this.g2FlyControllerService;
        if (evo2FlyControllerService != null) {
            evo2FlyControllerService.setViewpointInfoListener(callbackWithOneParam);
        }
    }

    public void droneArmed(CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.g2FlyControllerService.droneArmed(callbackWithNoParam);
        }
    }

    public void droneDisarmed(CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.g2FlyControllerService.droneDisarmed(callbackWithNoParam);
        }
    }

    public EvoFlyControllerParameterRangeManager getParameterRangeManager() {
        return this.g2FlyControllerService.getParameterRangeManager();
    }

    public void setAircraftHeadingDirection(int i, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.g2FlyControllerService.setAircraftHeadingDirection(i, callbackWithNoParam);
        }
    }

    public void setBoatMode(BoatMode boatMode, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.g2FlyControllerService.setBoatMode(boatMode, callbackWithNoParam);
        }
    }

    public void getBoatMode(CallbackWithOneParam<BoatMode> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.g2FlyControllerService.getBoatMode(callbackWithOneParam);
        }
    }

    public boolean isSupportBoatMode() {
        return AircraftHeatBeatManager2.getInstance().getHeartBeatInfo().getVersionId() > 1;
    }

    public void setTripodParams(TripodParams tripodParams, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.g2FlyControllerService.setTripodParams(tripodParams, callbackWithNoParam);
        }
    }

    public void setMotionDelayParams(MotionDelayParams motionDelayParams, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.g2FlyControllerService.setMotionDelayParams(motionDelayParams, callbackWithNoParam);
        }
    }

    public void cancelMission(int i, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.g2FlyControllerService.cancelMission(i, callbackWithNoParam);
        }
    }

    public void checkNFZ(String str, String str2, CallbackWithOneParam<Boolean> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.g2FlyControllerService.checkNFZ(str, str2, callbackWithOneParam);
        }
    }

    public void uploadFileData(String str, FileDataType fileDataType, CallbackWithOneParamProgress<Float> callbackWithOneParamProgress) {
        if (checkStateEnable(callbackWithOneParamProgress)) {
            this.g2FlyControllerService.uploadFileData(str, fileDataType, callbackWithOneParamProgress);
        }
    }

    public void setGasPedalSensitivity(float f, CallbackWithOneParam<Boolean> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.g2FlyControllerService.setGasPedalSensitivity(f, callbackWithOneParam);
        }
    }

    public void getGasPedalSensitivity(CallbackWithOneParam<Float> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.g2FlyControllerService.getGasPedalSensitivity(callbackWithOneParam);
        }
    }

    public void setATTISensitivity(float f, CallbackWithOneParam<Boolean> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.g2FlyControllerService.setATTISensitivity(f, callbackWithOneParam);
        }
    }

    public void getATTISensitivity(CallbackWithOneParam<Float> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.g2FlyControllerService.getATTISensitivity(callbackWithOneParam);
        }
    }

    public void setBrakeSensitivity(float f, CallbackWithOneParam<Boolean> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.g2FlyControllerService.setBrakeSensitivity(f, callbackWithOneParam);
        }
    }

    public void getBrakeSensitivity(CallbackWithOneParam<Float> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.g2FlyControllerService.getBrakeSensitivity(callbackWithOneParam);
        }
    }

    public void setYawStrokeSensitivity(float f, CallbackWithOneParam<Boolean> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.g2FlyControllerService.setYawStrokeSensitivity(f, callbackWithOneParam);
        }
    }

    public void getYawStrokeSensitivity(CallbackWithOneParam<Float> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.g2FlyControllerService.getYawStrokeSensitivity(callbackWithOneParam);
        }
    }

    public void setPitchAndRollSenCoefficient(float f, CallbackWithOneParam<Boolean> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.g2FlyControllerService.setPitchAndRollSenCoefficient(f, callbackWithOneParam);
        }
    }

    public void getPitchAndRollSenCoefficient(CallbackWithOneParam<Float> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.g2FlyControllerService.getPitchAndRollSenCoefficient(callbackWithOneParam);
        }
    }

    public void startCalibrationIMU(CallbackWithTwoParams<CalibrateIMUStep, CalibrateIMUStatus> callbackWithTwoParams) {
        if (checkStateEnable(callbackWithTwoParams)) {
            this.g2FlyControllerService.startCalibrationIMU(callbackWithTwoParams);
        }
    }

    public RxEvo2FlyController toRx() {
        if (this.mRxG2FlyController == null) {
            this.mRxG2FlyController = new RxEvo2FlyControllerImpl(this);
        }
        return this.mRxG2FlyController;
    }

    public void getRtkAuthInfo(CallbackWithOneParam<AuthInfo> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.g2FlyControllerService.getRtkAuthInfo(callbackWithOneParam);
        }
    }

    public void setUseRTK(boolean z, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.g2FlyControllerService.setUseRTK(z, callbackWithNoParam);
        }
    }

    public void getUseRTK(CallbackWithOneParam<Boolean> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.g2FlyControllerService.getUseRTK(callbackWithOneParam);
        }
    }

    public void setRtkCoordinateSys(RtkCoordinateSystem rtkCoordinateSystem, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.g2FlyControllerService.setRtkCoordinateSys(rtkCoordinateSystem, callbackWithNoParam);
        }
    }

    public void setRtkRecvType(int i, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.g2FlyControllerService.setRtkRecvType(i, callbackWithNoParam);
        }
    }

    public void getRtkCoordinateSys(CallbackWithOneParam<RtkCoordinateSystem> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.g2FlyControllerService.getRtkCoordinateSys(callbackWithOneParam);
        }
    }

    public void getRtkRecvType(CallbackWithOneParam<RTKSignalType> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.g2FlyControllerService.getRtkRecvType(callbackWithOneParam);
        }
    }

    private static FlyControllerStatus createFlyControllerStatus() {
        return new FlyControllerStatus() {
            public MainFlyState getMainFlyState() {
                return G2FlyControllerInfoImpl.instance().mFlyControllerStatus.getMainFlyState();
            }

            public ARMWarning getArmErrorCode() {
                return G2FlyControllerInfoImpl.instance().mFlyControllerStatus.getArmErrorCode();
            }

            public FlyMode getFlyMode() {
                return G2FlyControllerInfoImpl.instance().mFlyControllerStatus.getFlyMode();
            }

            public boolean isReachMaxHeight() {
                return G2FlyControllerInfoImpl.instance().mFlyControllerStatus.isReachMaxHeight();
            }

            public boolean isReachMaxRange() {
                return G2FlyControllerInfoImpl.instance().mFlyControllerStatus.isReachMaxRange();
            }

            public boolean isGpsValid() {
                return G2FlyControllerInfoImpl.instance().mFlyControllerStatus.isGpsValid();
            }

            public boolean isHomePointValid() {
                return G2FlyControllerInfoImpl.instance().mFlyControllerStatus.isHomePointValid();
            }

            public boolean isCompassValid() {
                return G2FlyControllerInfoImpl.instance().mFlyControllerStatus.isCompassValid();
            }

            public boolean isFlightControllerLostRemoteControllerSignal() {
                return G2FlyControllerInfoImpl.instance().mFlyControllerStatus.isFlightControllerLostRemoteControllerSignal();
            }

            public boolean isFlightControllerOverHeated() {
                return G2FlyControllerInfoImpl.instance().mFlyControllerStatus.isFlightControllerOverHeated();
            }

            public boolean isOneClickTakeOffValid() {
                return G2FlyControllerInfoImpl.instance().mFlyControllerStatus.isOneClickTakeOffValid();
            }

            public boolean isTakeOffValid() {
                return G2FlyControllerInfoImpl.instance().mFlyControllerStatus.isTakeOffValid();
            }

            public boolean isWarmingUp() {
                return G2FlyControllerInfoImpl.instance().mFlyControllerStatus.isWarmingUp();
            }

            public boolean isHomePointLocationAccurate() {
                return G2FlyControllerInfoImpl.instance().mFlyControllerStatus.isHomePointLocationAccurate();
            }

            public boolean isGoHomePending() {
                return G2FlyControllerInfoImpl.instance().mFlyControllerStatus.isGoHomePending();
            }

            public FlyLimitAreaWarning getFlyLimitAreaWarning() {
                return G2FlyControllerInfoImpl.instance().mFlyControllerStatus.getFlyLimitAreaWarning();
            }

            public boolean isStickLimited() {
                return G2FlyControllerInfoImpl.instance().mFlyControllerStatus.isStickLimited();
            }

            public boolean isNearRangeLimit() {
                return G2FlyControllerInfoImpl.instance().mFlyControllerStatus.isNearRangeLimit();
            }

            public boolean isWindTooHigh() {
                return G2FlyControllerInfoImpl.instance().mFlyControllerStatus.isWindTooHigh();
            }

            public boolean isSupportRtk() {
                return G2FlyControllerInfoImpl.instance().mFlyControllerStatus.isSupportRtk();
            }
        };
    }

    public void setVisualSettingEnable(VisualSettingSwitchblade visualSettingSwitchblade, boolean z, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.g2FlyControllerService.setVisualSettingEnable(visualSettingSwitchblade, z, callbackWithNoParam);
        }
    }

    public void setVisualSettingParams(VisualSettingSwitchblade visualSettingSwitchblade, int i, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.g2FlyControllerService.setVisualSettingParams(visualSettingSwitchblade, i, callbackWithNoParam);
        }
    }

    public void getVisualSettingInfo(CallbackWithOneParam<VisualSettingInfo> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.g2FlyControllerService.getVisualSettingInfo(callbackWithOneParam);
        }
    }

    public void setVisualFollowMode(DynamicTrackMode dynamicTrackMode, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.g2FlyControllerService.setVisualFollowMode(dynamicTrackMode, callbackWithNoParam);
        }
    }

    public void setVisualViewPointCoordinate(float f, float f2, float f3, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.g2FlyControllerService.setVisualViewPointCoordinate(f, f2, f3, callbackWithNoParam);
        }
    }

    public void setVisualViewPointSpeed(float f, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.g2FlyControllerService.setVisualViewPointSpeed(f, callbackWithNoParam);
        }
    }

    public void setVisualDigitalZoom(int i, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.g2FlyControllerService.setVisualDigitalZoom(i, callbackWithNoParam);
        }
    }

    public void updateVisualResolutionAngle(CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.g2FlyControllerService.updateVisualResolutionAngle(callbackWithNoParam);
        }
    }

    public void setTrackingMode(TrackingAction trackingAction, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.g2FlyControllerService.setTrackingMode(trackingAction, callbackWithNoParam);
        }
    }

    public void setTrackingTargetListener(CallbackWithTwoParams<List<TrackingGoalArea>, Boolean> callbackWithTwoParams) {
        if (checkStateEnable(callbackWithTwoParams)) {
            this.g2FlyControllerService.setTrackingTargetListener(callbackWithTwoParams);
        }
    }

    public void setOrbitTargetListener(CallbackWithOneParam<TrackTargetArea> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.g2FlyControllerService.setOrbitTargetListener(callbackWithOneParam);
        }
    }

    public void setViewpointAction(ViewpointAction viewpointAction, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.g2FlyControllerService.setViewpointAction(viewpointAction, callbackWithNoParam);
        }
    }

    public void setVisualViewPointCoordinate(float f, float f2, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.g2FlyControllerService.setVisualViewPointCoordinate(f, f2, callbackWithNoParam);
        }
    }

    public void setVisualResolution() {
        this.g2FlyControllerService.setVisualResolution();
    }
}

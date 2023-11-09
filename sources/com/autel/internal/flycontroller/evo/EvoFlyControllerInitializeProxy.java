package com.autel.internal.flycontroller.evo;

import com.autel.AutelNet2.aircraft.flycontroller.AircraftHeatBeatManager2;
import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.CallbackWithTwoParams;
import com.autel.common.camera.visual.ViewPointTargetArea;
import com.autel.common.camera.visual.VisualWarningInfo;
import com.autel.common.flycontroller.ARMWarning;
import com.autel.common.flycontroller.BoatMode;
import com.autel.common.flycontroller.FlyControllerStatus;
import com.autel.common.flycontroller.FlyLimitAreaWarning;
import com.autel.common.flycontroller.FlyMode;
import com.autel.common.flycontroller.GPSInfo;
import com.autel.common.flycontroller.MainFlyState;
import com.autel.common.flycontroller.evo.EvoFlyControllerInfo;
import com.autel.common.flycontroller.evo.EvoFlyControllerParameterRangeManager;
import com.autel.common.flycontroller.visual.AvoidanceRadarInfo;
import com.autel.common.flycontroller.visual.DynamicTrackMode;
import com.autel.common.flycontroller.visual.VisualSettingInfo;
import com.autel.common.flycontroller.visual.VisualSettingSwitchblade;
import com.autel.common.mission.AutelCoordinate3D;
import com.autel.internal.AutelListenerManager;
import com.autel.internal.AutelModuleService;
import com.autel.internal.AutelServiceVersion;
import com.autel.internal.flycontroller.AutelFlyControllerInitializeProxy;
import com.autel.internal.flycontroller.FlyControllerFactory;
import com.autel.internal.flycontroller.evo.bean.G2FlyControllerInfoImpl;
import com.autel.sdk.flycontroller.p007rx.RxEvoFlyController;

public class EvoFlyControllerInitializeProxy extends AutelFlyControllerInitializeProxy implements EvoFlyControllerService4Initialize {
    protected EvoFlyControllerService g2FlyControllerService;
    private RxEvoFlyController mRxG2FlyController;

    public EvoFlyControllerInitializeProxy() {
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
        EvoFlyControllerService createG2FlyController = FlyControllerFactory.createG2FlyController(autelServiceVersion);
        this.g2FlyControllerService = createG2FlyController;
        this.flyControllerService = createG2FlyController;
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
        }
    }

    public void setFlyControllerInfoListener(CallbackWithOneParam<EvoFlyControllerInfo> callbackWithOneParam) {
        this.listenerManager.put(AutelListenerManager.FlyControllerInfoListener, callbackWithOneParam);
        EvoFlyControllerService evoFlyControllerService = this.g2FlyControllerService;
        if (evoFlyControllerService != null) {
            evoFlyControllerService.setFlyControllerInfoListener(callbackWithOneParam);
        }
    }

    public void setVisualWarnListener(CallbackWithOneParam<VisualWarningInfo> callbackWithOneParam) {
        this.listenerManager.put(AutelListenerManager.VisualWarnListener, callbackWithOneParam);
        EvoFlyControllerService evoFlyControllerService = this.g2FlyControllerService;
        if (evoFlyControllerService != null) {
            evoFlyControllerService.setVisualWarnListener(callbackWithOneParam);
        }
    }

    public void setAvoidanceRadarInfoListener(CallbackWithOneParam<AvoidanceRadarInfo> callbackWithOneParam) {
        this.listenerManager.put(AutelListenerManager.RadarInfoListener, callbackWithOneParam);
        EvoFlyControllerService evoFlyControllerService = this.g2FlyControllerService;
        if (evoFlyControllerService != null) {
            evoFlyControllerService.setAvoidanceRadarInfoListener(callbackWithOneParam);
        }
    }

    public void setVisualSettingInfoListener(CallbackWithOneParam<VisualSettingInfo> callbackWithOneParam) {
        this.listenerManager.put(AutelListenerManager.VisualSettingInfoListener, callbackWithOneParam);
        EvoFlyControllerService evoFlyControllerService = this.g2FlyControllerService;
        if (evoFlyControllerService != null) {
            evoFlyControllerService.setVisualSettingInfoListener(callbackWithOneParam);
        }
    }

    public void setViewpointInfoListener(CallbackWithOneParam<ViewPointTargetArea> callbackWithOneParam) {
        this.listenerManager.put(AutelListenerManager.VisualViewpoingListener, callbackWithOneParam);
        EvoFlyControllerService evoFlyControllerService = this.g2FlyControllerService;
        if (evoFlyControllerService != null) {
            evoFlyControllerService.setViewpointInfoListener(callbackWithOneParam);
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

    public void cancelMission(int i, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.g2FlyControllerService.cancelMission(i, callbackWithNoParam);
        }
    }

    public RxEvoFlyController toRx() {
        if (this.mRxG2FlyController == null) {
            this.mRxG2FlyController = new RxEvoFlyControllerImpl(this);
        }
        return this.mRxG2FlyController;
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
}

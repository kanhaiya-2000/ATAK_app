package com.autel.internal.mission.evo.protocol;

import com.autel.common.flycontroller.ARMWarning;
import com.autel.common.flycontroller.FlyControllerStatus;
import com.autel.common.flycontroller.FlyLimitAreaWarning;
import com.autel.common.flycontroller.FlyMode;
import com.autel.common.flycontroller.GPSInfo;
import com.autel.common.flycontroller.MainFlyState;
import com.autel.common.mission.AutelCoordinate3D;
import com.autel.internal.flycontroller.evo.bean.G2FlyControllerInfoImpl;

public class MissionUtil {
    public static FlyControllerStatus createFlyControllerStatus() {
        return new FlyControllerStatus() {
            public MainFlyState getMainFlyState() {
                return G2FlyControllerInfoImpl.instance().getFlyControllerStatus().getMainFlyState();
            }

            public ARMWarning getArmErrorCode() {
                return G2FlyControllerInfoImpl.instance().getFlyControllerStatus().getArmErrorCode();
            }

            public FlyMode getFlyMode() {
                return G2FlyControllerInfoImpl.instance().getFlyControllerStatus().getFlyMode();
            }

            public boolean isReachMaxHeight() {
                return G2FlyControllerInfoImpl.instance().getFlyControllerStatus().isReachMaxHeight();
            }

            public boolean isReachMaxRange() {
                return G2FlyControllerInfoImpl.instance().getFlyControllerStatus().isReachMaxRange();
            }

            public boolean isGpsValid() {
                return G2FlyControllerInfoImpl.instance().getFlyControllerStatus().isGpsValid();
            }

            public boolean isHomePointValid() {
                return G2FlyControllerInfoImpl.instance().getFlyControllerStatus().isHomePointValid();
            }

            public boolean isCompassValid() {
                return G2FlyControllerInfoImpl.instance().getFlyControllerStatus().isCompassValid();
            }

            public boolean isFlightControllerLostRemoteControllerSignal() {
                return G2FlyControllerInfoImpl.instance().getFlyControllerStatus().isFlightControllerLostRemoteControllerSignal();
            }

            public boolean isFlightControllerOverHeated() {
                return G2FlyControllerInfoImpl.instance().getFlyControllerStatus().isFlightControllerOverHeated();
            }

            public boolean isOneClickTakeOffValid() {
                return G2FlyControllerInfoImpl.instance().getFlyControllerStatus().isOneClickTakeOffValid();
            }

            public boolean isTakeOffValid() {
                return G2FlyControllerInfoImpl.instance().getFlyControllerStatus().isTakeOffValid();
            }

            public boolean isWarmingUp() {
                return G2FlyControllerInfoImpl.instance().getFlyControllerStatus().isWarmingUp();
            }

            public boolean isHomePointLocationAccurate() {
                return G2FlyControllerInfoImpl.instance().mFlyControllerStatus.isHomePointLocationAccurate();
            }

            public boolean isGoHomePending() {
                return G2FlyControllerInfoImpl.instance().mFlyControllerStatus.isGoHomePending();
            }

            public FlyLimitAreaWarning getFlyLimitAreaWarning() {
                return G2FlyControllerInfoImpl.instance().getFlyControllerStatus().getFlyLimitAreaWarning();
            }

            public boolean isStickLimited() {
                return G2FlyControllerInfoImpl.instance().getFlyControllerStatus().isStickLimited();
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

    public static GPSInfo createGPSInfo() {
        return new GPSInfo() {
            public int getSatelliteStrength() {
                return 0;
            }

            public int getGpsCount() {
                return G2FlyControllerInfoImpl.instance().getGpsInfo().getSatellitesVisible();
            }

            public AutelCoordinate3D getCoordinate() {
                return new AutelCoordinate3D(G2FlyControllerInfoImpl.instance().getGpsInfo().getLatitude(), G2FlyControllerInfoImpl.instance().getGpsInfo().getLongitude(), G2FlyControllerInfoImpl.instance().getGpsInfo().getAltitude());
            }
        };
    }
}

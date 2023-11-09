package com.autel.internal.flycontroller;

import android.location.Location;
import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.CallbackWithTwoParams;
import com.autel.common.FailedCallback;
import com.autel.common.RangePair;
import com.autel.common.error.AutelError;
import com.autel.common.flycontroller.ARMWarning;
import com.autel.common.flycontroller.CalibrateCompassStatus;
import com.autel.common.flycontroller.FlyControllerParameterRangeManager;
import com.autel.common.flycontroller.FlyControllerStatus;
import com.autel.common.flycontroller.FlyControllerVersionInfo;
import com.autel.common.flycontroller.FlyMode;
import com.autel.common.flycontroller.GPSInfo;
import com.autel.common.flycontroller.LedPilotLamp;
import com.autel.common.flycontroller.MagnetometerState;
import com.autel.internal.AutelInitializeProxy;
import com.autel.internal.AutelListenerManager;
import com.autel.internal.autel.authorization.network.AuthorityState;

public abstract class AutelFlyControllerInitializeProxy extends AutelInitializeProxy implements AutelFlyControllerService4Initialize {
    protected AutelFlyControllerService flyControllerService;
    private FlyControllerStatus flyControllerStatus;
    private GPSInfo mGpsInfo;

    public abstract FlyControllerParameterRangeManager getParameterRangeManager();

    public AutelFlyControllerInitializeProxy(FlyControllerStatus flyControllerStatus2, GPSInfo gPSInfo) {
        this.flyControllerStatus = flyControllerStatus2;
        this.mGpsInfo = gPSInfo;
    }

    public void setWarningListener(CallbackWithTwoParams<ARMWarning, MagnetometerState> callbackWithTwoParams) {
        this.listenerManager.put(AutelListenerManager.FlyControllerWarningListener, callbackWithTwoParams);
        AutelFlyControllerService autelFlyControllerService = this.flyControllerService;
        if (autelFlyControllerService != null) {
            autelFlyControllerService.setWarningListener(callbackWithTwoParams);
        }
    }

    public void setCalibrateCompassListener(CallbackWithOneParam<CalibrateCompassStatus> callbackWithOneParam) {
        this.listenerManager.put(AutelListenerManager.CalibrateCompassListener, callbackWithOneParam);
        AutelFlyControllerService autelFlyControllerService = this.flyControllerService;
        if (autelFlyControllerService != null) {
            autelFlyControllerService.setCalibrateCompassListener(callbackWithOneParam);
        }
    }

    public void setBeginnerModeEnable(boolean z, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.flyControllerService.setBeginnerModeEnable(z, callbackWithNoParam);
        }
    }

    public void isBeginnerModeEnable(CallbackWithOneParam<Boolean> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.flyControllerService.isBeginnerModeEnable(callbackWithOneParam);
        }
    }

    public void setMaxHeight(double d, CallbackWithNoParam callbackWithNoParam) {
        FlyControllerParameterRangeManager parameterRangeManager;
        if (checkStateEnable(callbackWithNoParam, AuthorityState.NORMAL) && (parameterRangeManager = getParameterRangeManager()) != null) {
            RangePair<Float> heightRange = parameterRangeManager.getHeightRange();
            if (d >= ((double) heightRange.getValueFrom().floatValue()) && d <= ((double) heightRange.getValueTo().floatValue())) {
                this.flyControllerService.setMaxHeight(d, callbackWithNoParam);
            } else if (callbackWithNoParam != null) {
                callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_OUT_OF_RANGE);
            }
        }
    }

    public void getMaxHeight(CallbackWithOneParam<Float> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.flyControllerService.getMaxHeight(callbackWithOneParam);
        }
    }

    public void setMaxRange(double d, CallbackWithNoParam callbackWithNoParam) {
        FlyControllerParameterRangeManager parameterRangeManager;
        if (checkStateEnable(callbackWithNoParam, AuthorityState.NORMAL) && (parameterRangeManager = getParameterRangeManager()) != null) {
            RangePair<Float> rangeOfMaxRange = parameterRangeManager.getRangeOfMaxRange();
            if ((d >= ((double) rangeOfMaxRange.getValueFrom().floatValue()) && d <= ((double) rangeOfMaxRange.getValueTo().floatValue())) || d == 10000.0d) {
                this.flyControllerService.setMaxRange(d, callbackWithNoParam);
            } else if (callbackWithNoParam != null) {
                callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_OUT_OF_RANGE);
            }
        }
    }

    public void getMaxRange(CallbackWithOneParam<Float> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.flyControllerService.getMaxRange(callbackWithOneParam);
        }
    }

    public void setReturnHeight(double d, CallbackWithNoParam callbackWithNoParam) {
        FlyControllerParameterRangeManager parameterRangeManager;
        if (checkStateEnable(callbackWithNoParam, AuthorityState.NORMAL) && (parameterRangeManager = getParameterRangeManager()) != null) {
            RangePair<Float> returnHeightRange = parameterRangeManager.getReturnHeightRange();
            if (d >= ((double) returnHeightRange.getValueFrom().floatValue()) && d <= ((double) returnHeightRange.getValueTo().floatValue())) {
                this.flyControllerService.setReturnHeight(d, callbackWithNoParam);
            } else if (callbackWithNoParam != null) {
                callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_OUT_OF_RANGE);
            }
        }
    }

    public void getReturnHeight(CallbackWithOneParam<Float> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.flyControllerService.getReturnHeight(callbackWithOneParam);
        }
    }

    public void setMaxHorizontalSpeed(double d, CallbackWithNoParam callbackWithNoParam) {
        FlyControllerParameterRangeManager parameterRangeManager;
        if (checkStateEnable(callbackWithNoParam, AuthorityState.NORMAL) && (parameterRangeManager = getParameterRangeManager()) != null) {
            RangePair<Float> horizontalSpeedRange = parameterRangeManager.getHorizontalSpeedRange();
            if (d >= ((double) horizontalSpeedRange.getValueFrom().floatValue()) && d <= ((double) horizontalSpeedRange.getValueTo().floatValue())) {
                this.flyControllerService.setMaxHorizontalSpeed(d, callbackWithNoParam);
            } else if (callbackWithNoParam != null) {
                callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_OUT_OF_RANGE);
            }
        }
    }

    public void getMaxHorizontalSpeed(CallbackWithOneParam<Float> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.flyControllerService.getMaxHorizontalSpeed(callbackWithOneParam);
        }
    }

    public void setAttitudeModeEnable(boolean z, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam, AuthorityState.NORMAL)) {
            this.flyControllerService.setAttitudeModeEnable(z, callbackWithNoParam);
        }
    }

    public void isAttitudeModeEnable(CallbackWithOneParam<Boolean> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.flyControllerService.isAttitudeModeEnable(callbackWithOneParam);
        }
    }

    public void setLedPilotLamp(LedPilotLamp ledPilotLamp, CallbackWithNoParam callbackWithNoParam) {
        if (!checkStateEnable(callbackWithNoParam)) {
            return;
        }
        if (LedPilotLamp.UNKNOWN != ledPilotLamp) {
            this.flyControllerService.setLedPilotLamp(ledPilotLamp, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_INVALID);
        }
    }

    public void getLedPilotLamp(CallbackWithOneParam<LedPilotLamp> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.flyControllerService.getLedPilotLamp(callbackWithOneParam);
        }
    }

    public void startCalibrateCompass(CallbackWithOneParam<CalibrateCompassStatus> callbackWithOneParam) {
        if (checkStateEnable((FailedCallback) null)) {
            FlyControllerStatus flyControllerStatus2 = this.flyControllerStatus;
            if (flyControllerStatus2 == null || flyControllerStatus2.getFlyMode() == null) {
                if (callbackWithOneParam != null) {
                    callbackWithOneParam.onFailure(AutelError.COMMAND_FAILED);
                }
            } else if (this.flyControllerStatus.getFlyMode() != FlyMode.DISARM) {
                if (callbackWithOneParam != null) {
                    callbackWithOneParam.onFailure(AutelError.FLY_CALIBRATE_COMPASS_FAILED_AS_NOT_IN_DISARM_MODE);
                }
            } else if (this.flyControllerStatus.isGpsValid()) {
                this.flyControllerService.startCalibrateCompass(callbackWithOneParam);
            } else if (callbackWithOneParam != null) {
                callbackWithOneParam.onFailure(AutelError.FLY_CALIBRATE_COMPASS_FAILED_AS_GPS_UNAVAILABLE);
            }
        }
    }

    public void takeOff(CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam, AuthorityState.NORMAL)) {
            this.flyControllerService.takeOff(callbackWithNoParam);
        }
    }

    public void goHome(CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam, AuthorityState.NORMAL)) {
            FlyMode flyMode = this.flyControllerStatus.getFlyMode();
            if (FlyMode.LANDING == flyMode || FlyMode.DISARM == flyMode || FlyMode.MOTOR_SPINNING == flyMode) {
                if (callbackWithNoParam != null) {
                    callbackWithNoParam.onFailure(AutelError.MISSION_GO_HOME_FAILED_WITH_BAD_MODE);
                }
            } else if (this.flyControllerStatus.isCompassValid() && this.flyControllerStatus.isGpsValid() && this.flyControllerStatus.isHomePointValid()) {
                this.flyControllerService.goHome(callbackWithNoParam);
            } else if (callbackWithNoParam != null) {
                callbackWithNoParam.onFailure(AutelError.MISSION_GO_HOME_FAILED_WITH_INVALID_STATE);
            }
        }
    }

    public void land(CallbackWithNoParam callbackWithNoParam) {
        FlyMode flyMode;
        if (checkStateEnable(callbackWithNoParam, AuthorityState.NORMAL) && (flyMode = this.flyControllerStatus.getFlyMode()) != null) {
            if (flyMode.getValue() > FlyMode.TAKEOFF.getValue()) {
                this.flyControllerService.land(callbackWithNoParam);
            } else if (callbackWithNoParam != null) {
                callbackWithNoParam.onFailure(AutelError.MISSION_LAND_FAILED);
            }
        }
    }

    public void cancelLand(CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam, AuthorityState.NORMAL)) {
            if (FlyMode.LANDING == this.flyControllerStatus.getFlyMode()) {
                this.flyControllerService.cancelLand(callbackWithNoParam);
            } else if (callbackWithNoParam != null) {
                callbackWithNoParam.onFailure(AutelError.MISSION_CANCEL_LAND_FAILED);
            }
        }
    }

    public void cancelReturn(CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam, AuthorityState.NORMAL)) {
            this.flyControllerService.cancelReturn(callbackWithNoParam);
        }
    }

    public void setAircraftLocationAsHomePoint(CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam, AuthorityState.NORMAL)) {
            FlyMode flyMode = this.flyControllerStatus.getFlyMode();
            if (FlyMode.DISARM == flyMode || FlyMode.LANDING == flyMode) {
                if (callbackWithNoParam != null) {
                    callbackWithNoParam.onFailure(AutelError.MISSION_LOCATION_AS_HOME_FAILED_WITH_DISARM_OR_LANDING);
                }
            } else if (FlyMode.ORBIT_HOLD == flyMode || FlyMode.ORBIT_ORBIT == flyMode || FlyMode.WAYPOINT_MODE == flyMode || FlyMode.WAYPOINT_MODE_HOLD == flyMode || FlyMode.RECTANGLE == flyMode || FlyMode.RECTANGLE_HOLD == flyMode || FlyMode.POLYGON == flyMode || FlyMode.POLYGON_HOLD == flyMode) {
                if (callbackWithNoParam != null) {
                    callbackWithNoParam.onFailure(AutelError.MISSION_LOCATION_AS_HOME_FAILED_SHOULD_NOT_ON_MISSION_MODE);
                }
            } else if (FlyMode.EXCEED_RANGE_GO_HOME == flyMode || FlyMode.LOW_BATTERY_GO_HOME == flyMode || FlyMode.MISSION_GO_HOME == flyMode || FlyMode.NORMAL_GO_HOME == flyMode || FlyMode.RC_LOST_GO_HOME == flyMode) {
                if (callbackWithNoParam != null) {
                    callbackWithNoParam.onFailure(AutelError.MISSION_LOCATION_AS_HOME_FAILED_SHOULD_NOT_ON_GO_HOME_STATE);
                }
            } else if (this.flyControllerStatus.isGpsValid()) {
                this.flyControllerService.setAircraftLocationAsHomePoint(callbackWithNoParam);
            } else if (callbackWithNoParam != null) {
                callbackWithNoParam.onFailure(AutelError.MISSION_LOCATION_AS_HOME_FAILED_WITH_GPS);
            }
        }
    }

    public void setLocationAsHomePoint(double d, double d2, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam, AuthorityState.NORMAL)) {
            FlyMode flyMode = this.flyControllerStatus.getFlyMode();
            if (FlyMode.DISARM == flyMode || FlyMode.LANDING == flyMode) {
                if (callbackWithNoParam != null) {
                    callbackWithNoParam.onFailure(AutelError.MISSION_LOCATION_AS_HOME_FAILED_WITH_DISARM_OR_LANDING);
                }
            } else if (FlyMode.ORBIT_HOLD == flyMode || FlyMode.ORBIT_ORBIT == flyMode || FlyMode.WAYPOINT_MODE == flyMode || FlyMode.WAYPOINT_MODE_HOLD == flyMode || FlyMode.RECTANGLE == flyMode || FlyMode.RECTANGLE_HOLD == flyMode || FlyMode.POLYGON == flyMode || FlyMode.POLYGON_HOLD == flyMode) {
                if (callbackWithNoParam != null) {
                    callbackWithNoParam.onFailure(AutelError.MISSION_LOCATION_AS_HOME_FAILED_SHOULD_NOT_ON_MISSION_MODE);
                }
            } else if (FlyMode.EXCEED_RANGE_GO_HOME == flyMode || FlyMode.LOW_BATTERY_GO_HOME == flyMode || FlyMode.MISSION_GO_HOME == flyMode || FlyMode.NORMAL_GO_HOME == flyMode || FlyMode.RC_LOST_GO_HOME == flyMode) {
                if (callbackWithNoParam != null) {
                    callbackWithNoParam.onFailure(AutelError.MISSION_LOCATION_AS_HOME_FAILED_SHOULD_NOT_ON_GO_HOME_STATE);
                }
            } else if (this.flyControllerStatus.isGpsValid()) {
                if (distanceBetweenPoints(this.mGpsInfo.getCoordinate().getLatitude(), this.mGpsInfo.getCoordinate().getLongitude(), d, d2) <= 5000) {
                    this.flyControllerService.setLocationAsHomePoint(d, d2, callbackWithNoParam);
                } else if (callbackWithNoParam != null) {
                    callbackWithNoParam.onFailure(AutelError.MISSION_PHONE_LOCATION_AS_HOME_FAILED_WITH_DISTANCE);
                }
            } else if (callbackWithNoParam != null) {
                callbackWithNoParam.onFailure(AutelError.MISSION_LOCATION_AS_HOME_FAILED_WITH_GPS);
            }
        }
    }

    public void getSerialNumber(CallbackWithOneParam<String> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam) && callbackWithOneParam != null) {
            this.flyControllerService.getSerialNumber(callbackWithOneParam);
        }
    }

    public void getVersionInfo(CallbackWithOneParam<FlyControllerVersionInfo> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam) && callbackWithOneParam != null) {
            this.flyControllerService.getVersionInfo(callbackWithOneParam);
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkStateEnable(FailedCallback failedCallback) {
        AutelError autelError;
        if (!this.hasInit || this.stateManager == null) {
            autelError = AutelError.SDK_MODULE_SERVICE_HAS_NOT_BEEN_INITIALIZED;
        } else if (!this.stateManager.isSdkValidate()) {
            autelError = AutelError.SDK_AUTHOR_NEED_MORE_THAN_DISABLE;
        } else {
            autelError = !this.stateManager.isProductConnected() ? AutelError.SDK_HAS_NOT_CONNECT_TO_AIRCRAFT : null;
        }
        if (!(autelError == null || failedCallback == null)) {
            failedCallback.onFailure(autelError);
        }
        return autelError == null;
    }

    /* access modifiers changed from: protected */
    public boolean checkStateEnable(FailedCallback failedCallback, AuthorityState authorityState) {
        AutelError autelError;
        if (!this.hasInit || this.stateManager == null) {
            autelError = AutelError.SDK_MODULE_SERVICE_HAS_NOT_BEEN_INITIALIZED;
        } else if (this.stateManager.getAuthorityState().levelLessThan(authorityState)) {
            autelError = AutelError.SDK_AUTHOR_NEED_NORMAL_LEVEL;
        } else {
            autelError = !this.stateManager.isProductConnected() ? AutelError.SDK_HAS_NOT_CONNECT_TO_AIRCRAFT : null;
        }
        if (!(autelError == null || failedCallback == null)) {
            failedCallback.onFailure(autelError);
        }
        return autelError == null;
    }

    /* access modifiers changed from: protected */
    public void initListener() {
        Object obj = this.listenerManager.get(AutelListenerManager.CalibrateCompassListener);
        if (obj instanceof CallbackWithOneParam) {
            this.flyControllerService.setCalibrateCompassListener((CallbackWithOneParam) obj);
        }
        Object obj2 = this.listenerManager.get(AutelListenerManager.FlyControllerWarningListener);
        if (obj2 instanceof CallbackWithTwoParams) {
            this.flyControllerService.setWarningListener((CallbackWithTwoParams) obj2);
        }
    }

    /* access modifiers changed from: protected */
    public int distanceBetweenPoints(double d, double d2, double d3, double d4) {
        float[] fArr = new float[3];
        Location.distanceBetween(d, d2, d3, d4, fArr);
        return (int) fArr[0];
    }
}

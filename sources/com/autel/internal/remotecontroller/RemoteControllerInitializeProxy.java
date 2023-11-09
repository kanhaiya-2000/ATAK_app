package com.autel.internal.remotecontroller;

import android.util.Pair;
import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.FailedCallback;
import com.autel.common.RangePair;
import com.autel.common.error.AutelError;
import com.autel.common.remotecontroller.CustomFunction;
import com.autel.common.remotecontroller.CustomKey;
import com.autel.common.remotecontroller.RFPower;
import com.autel.common.remotecontroller.RemoteControllerCommandStickMode;
import com.autel.common.remotecontroller.RemoteControllerConnectState;
import com.autel.common.remotecontroller.RemoteControllerInfo;
import com.autel.common.remotecontroller.RemoteControllerLanguage;
import com.autel.common.remotecontroller.RemoteControllerNavigateButtonEvent;
import com.autel.common.remotecontroller.RemoteControllerParameterRangeManager;
import com.autel.common.remotecontroller.RemoteControllerParameterUnit;
import com.autel.common.remotecontroller.RemoteControllerStickCalibration;
import com.autel.common.remotecontroller.RemoteControllerVersionInfo;
import com.autel.common.remotecontroller.TeachingMode;
import com.autel.internal.AutelInitializeProxy;
import com.autel.internal.AutelListenerManager;
import com.autel.internal.AutelModuleService;
import com.autel.internal.AutelServiceVersion;
import com.autel.internal.autel.authorization.network.AuthorityState;
import com.autel.sdk.remotecontroller.p010rx.RxAutelRemoteController;

public class RemoteControllerInitializeProxy extends AutelInitializeProxy implements RemoteControllerService4Initialize {
    private AutelListenerManager listenerManager = new AutelListenerManager();
    private RxAutelRemoteController mRxAutelRemoteController;
    private RemoteControllerService remoteControllerService;

    public void setConnectStateListener(CallbackWithOneParam<RemoteControllerConnectState> callbackWithOneParam) {
        this.listenerManager.put(AutelListenerManager.RemoteControllerConnectStateListener, callbackWithOneParam);
        RemoteControllerService remoteControllerService2 = this.remoteControllerService;
        if (remoteControllerService2 != null) {
            remoteControllerService2.setConnectStateListener(callbackWithOneParam);
        }
    }

    public void setRemoteButtonControllerListener(CallbackWithOneParam<RemoteControllerNavigateButtonEvent> callbackWithOneParam) {
        this.listenerManager.put(AutelListenerManager.RemoteButtonControllerListener, callbackWithOneParam);
        RemoteControllerService remoteControllerService2 = this.remoteControllerService;
        if (remoteControllerService2 != null) {
            remoteControllerService2.setRemoteButtonControllerListener(callbackWithOneParam);
        }
    }

    public void setInfoDataListener(CallbackWithOneParam<RemoteControllerInfo> callbackWithOneParam) {
        this.listenerManager.put(AutelListenerManager.RCInfoDataListener, callbackWithOneParam);
        RemoteControllerService remoteControllerService2 = this.remoteControllerService;
        if (remoteControllerService2 != null) {
            remoteControllerService2.setInfoDataListener(callbackWithOneParam);
        }
    }

    public void setControlMenuListener(CallbackWithOneParam<int[]> callbackWithOneParam) {
        this.listenerManager.put(AutelListenerManager.RCControlMenuListener, callbackWithOneParam);
        RemoteControllerService remoteControllerService2 = this.remoteControllerService;
        if (remoteControllerService2 != null) {
            remoteControllerService2.setControlMenuListener(callbackWithOneParam);
        }
    }

    public void setLanguage(RemoteControllerLanguage remoteControllerLanguage, CallbackWithNoParam callbackWithNoParam) {
        if (!checkStateEnable(callbackWithNoParam)) {
            return;
        }
        if (RemoteControllerLanguage.UNKNOWN != remoteControllerLanguage) {
            this.remoteControllerService.setLanguage(remoteControllerLanguage, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_INVALID);
        }
    }

    public void getLanguage(CallbackWithOneParam<RemoteControllerLanguage> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam) && callbackWithOneParam != null) {
            this.remoteControllerService.getLanguage(callbackWithOneParam);
        }
    }

    public void exitPairing() {
        RemoteControllerService remoteControllerService2 = this.remoteControllerService;
        if (remoteControllerService2 != null) {
            remoteControllerService2.exitPairing();
        }
    }

    public void enterPairing(CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.remoteControllerService.enterPairing(callbackWithNoParam);
        }
    }

    public void setRFPower(RFPower rFPower, CallbackWithNoParam callbackWithNoParam) {
        if (!checkStateEnable(callbackWithNoParam)) {
            return;
        }
        if (RFPower.UNKNOWN != rFPower) {
            this.remoteControllerService.setRFPower(rFPower, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_INVALID);
        }
    }

    public void getRFPower(CallbackWithOneParam<RFPower> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam) && callbackWithOneParam != null) {
            this.remoteControllerService.getRFPower(callbackWithOneParam);
        }
    }

    public void setTeachingMode(TeachingMode teachingMode, CallbackWithNoParam callbackWithNoParam) {
        if (!checkStateEnable(callbackWithNoParam)) {
            return;
        }
        if (TeachingMode.UNKNOWN != teachingMode) {
            this.remoteControllerService.setTeachingMode(teachingMode, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_INVALID);
        }
    }

    public void getTeachingMode(CallbackWithOneParam<TeachingMode> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam) && callbackWithOneParam != null) {
            this.remoteControllerService.getTeachingMode(callbackWithOneParam);
        }
    }

    public void setStickCalibration(RemoteControllerStickCalibration remoteControllerStickCalibration, CallbackWithNoParam callbackWithNoParam) {
        if (!checkStateEnable(callbackWithNoParam)) {
            return;
        }
        if (RemoteControllerStickCalibration.UNKNOWN != remoteControllerStickCalibration) {
            this.remoteControllerService.setStickCalibration(remoteControllerStickCalibration, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_INVALID);
        }
    }

    public void setParameterUnit(RemoteControllerParameterUnit remoteControllerParameterUnit, CallbackWithNoParam callbackWithNoParam) {
        if (!checkStateEnable(callbackWithNoParam)) {
            return;
        }
        if (RemoteControllerParameterUnit.UNKNOWN != remoteControllerParameterUnit) {
            this.remoteControllerService.setParameterUnit(remoteControllerParameterUnit, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_INVALID);
        }
    }

    public void getLengthUnit(CallbackWithOneParam<RemoteControllerParameterUnit> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam) && callbackWithOneParam != null) {
            this.remoteControllerService.getLengthUnit(callbackWithOneParam);
        }
    }

    public void setCommandStickMode(RemoteControllerCommandStickMode remoteControllerCommandStickMode, CallbackWithNoParam callbackWithNoParam) {
        if (!checkStateEnable(callbackWithNoParam)) {
            return;
        }
        if (RemoteControllerCommandStickMode.UNKNOWN != remoteControllerCommandStickMode) {
            this.remoteControllerService.setCommandStickMode(remoteControllerCommandStickMode, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_INVALID);
        }
    }

    public void getCommandStickMode(CallbackWithOneParam<RemoteControllerCommandStickMode> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam) && callbackWithOneParam != null) {
            this.remoteControllerService.getCommandStickMode(callbackWithOneParam);
        }
    }

    public void setYawCoefficient(float f, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            RangePair<Float> yawCoefficient = getParameterRangeManager().getYawCoefficient();
            if (f >= yawCoefficient.getValueFrom().floatValue() && f <= yawCoefficient.getValueTo().floatValue()) {
                this.remoteControllerService.setYawCoefficient(f, callbackWithNoParam);
            } else if (callbackWithNoParam != null) {
                callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_OUT_OF_RANGE);
            }
        }
    }

    public void getYawCoefficient(CallbackWithOneParam<Float> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam) && callbackWithOneParam != null) {
            this.remoteControllerService.getYawCoefficient(callbackWithOneParam);
        }
    }

    public void getVersionInfo(CallbackWithOneParam<RemoteControllerVersionInfo> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam) && callbackWithOneParam != null) {
            this.remoteControllerService.getVersionInfo(callbackWithOneParam);
        }
    }

    public void getSerialNumber(CallbackWithOneParam<String> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam) && callbackWithOneParam != null) {
            this.remoteControllerService.getSerialNumber(callbackWithOneParam);
        }
    }

    public RemoteControllerParameterRangeManager getParameterRangeManager() {
        return this.remoteControllerService.getParameterRangeManager();
    }

    public void setGimbalDialAdjustSpeed(int i, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            RangePair<Integer> dialAdjustSpeed = getParameterRangeManager().getDialAdjustSpeed();
            if (i >= dialAdjustSpeed.getValueFrom().intValue() && i <= dialAdjustSpeed.getValueTo().intValue()) {
                this.remoteControllerService.setGimbalDialAdjustSpeed(i, callbackWithNoParam);
            } else if (callbackWithNoParam != null) {
                callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_OUT_OF_RANGE);
            }
        }
    }

    public void getGimbalDialAdjustSpeed(CallbackWithOneParam<Integer> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam) && callbackWithOneParam != null) {
            this.remoteControllerService.getGimbalDialAdjustSpeed(callbackWithOneParam);
        }
    }

    public void setRcCustomKey(CustomKey customKey, CustomFunction customFunction, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam) && callbackWithNoParam != null) {
            this.remoteControllerService.setRcCustomKey(customKey, customFunction, callbackWithNoParam);
        }
    }

    public void getRcCustomKey(CallbackWithOneParam<Pair<CustomFunction, CustomFunction>> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam) && callbackWithOneParam != null) {
            this.remoteControllerService.getRcCustomKey(callbackWithOneParam);
        }
    }

    public RxAutelRemoteController toRx() {
        if (this.mRxAutelRemoteController == null) {
            this.mRxAutelRemoteController = new RxRemoteControllerImpl(this);
        }
        return this.mRxAutelRemoteController;
    }

    /* access modifiers changed from: protected */
    public boolean checkStateEnable(FailedCallback failedCallback) {
        AutelError autelError;
        if (!this.hasInit || this.stateManager == null) {
            autelError = AutelError.SDK_MODULE_SERVICE_HAS_NOT_BEEN_INITIALIZED;
        } else if (!this.stateManager.isSdkValidate()) {
            autelError = AutelError.SDK_AUTHOR_NEED_MORE_THAN_DISABLE;
        } else {
            autelError = !this.stateManager.isRemoteControllerConnected() ? AutelError.SDK_HAS_NOT_CONNECT_TO_REMOTE_CONTROLLER : null;
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
            autelError = !this.stateManager.isRemoteControllerConnected() ? AutelError.SDK_HAS_NOT_CONNECT_TO_REMOTE_CONTROLLER : null;
        }
        if (!(autelError == null || failedCallback == null)) {
            failedCallback.onFailure(autelError);
        }
        return autelError == null;
    }

    public AutelModuleService buildConnection(AutelServiceVersion autelServiceVersion) {
        RemoteControllerService createRemoteController = RemoteControllerFactory.createRemoteController(autelServiceVersion);
        this.remoteControllerService = createRemoteController;
        return createRemoteController;
    }

    /* access modifiers changed from: protected */
    public void initListener() {
        if (this.remoteControllerService != null) {
            Object obj = this.listenerManager.get(AutelListenerManager.RemoteControllerConnectStateListener);
            if (obj instanceof CallbackWithOneParam) {
                this.remoteControllerService.setConnectStateListener((CallbackWithOneParam) obj);
            }
            Object obj2 = this.listenerManager.get(AutelListenerManager.RemoteButtonControllerListener);
            if (obj2 instanceof CallbackWithOneParam) {
                this.remoteControllerService.setRemoteButtonControllerListener((CallbackWithOneParam) obj2);
            }
            Object obj3 = this.listenerManager.get(AutelListenerManager.RCInfoDataListener);
            if (obj3 instanceof CallbackWithOneParam) {
                this.remoteControllerService.setInfoDataListener((CallbackWithOneParam) obj3);
            }
            Object obj4 = this.listenerManager.get(AutelListenerManager.RCControlMenuListener);
            if (obj4 instanceof CallbackWithOneParam) {
                this.remoteControllerService.setControlMenuListener((CallbackWithOneParam) obj4);
            }
        }
    }
}

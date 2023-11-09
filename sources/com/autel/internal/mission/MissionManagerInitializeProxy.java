package com.autel.internal.mission;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.CallbackWithOneParamProgress;
import com.autel.common.FailedCallback;
import com.autel.common.error.AutelError;
import com.autel.common.mission.C2700AutelMission;
import com.autel.common.mission.MissionExecuteState;
import com.autel.common.mission.RealTimeInfo;
import com.autel.internal.AutelInitializeProxy;
import com.autel.internal.AutelListenerManager;
import com.autel.internal.AutelModuleService;
import com.autel.internal.AutelServiceVersion;
import com.autel.internal.autel.authorization.network.AuthorityState;
import com.autel.sdk.flycontroller.C4930AutelFlyController;
import com.autel.sdk.mission.p009rx.RxMissionManager;

public class MissionManagerInitializeProxy extends AutelInitializeProxy implements MissionManagerService4Initialize {
    private C4930AutelFlyController autelFlyController;
    private RxMissionManager mRxMissionManager;
    private MissionManagerService missionManagerService;

    public MissionManagerInitializeProxy(C4930AutelFlyController autelFlyController2) {
        this.autelFlyController = autelFlyController2;
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
    public AutelModuleService buildConnection(AutelServiceVersion autelServiceVersion) {
        MissionManagerService createMissionManager = MissionFactory.createMissionManager(autelServiceVersion, this.autelFlyController);
        this.missionManagerService = createMissionManager;
        return createMissionManager;
    }

    /* access modifiers changed from: protected */
    public void initListener() {
        if (this.missionManagerService != null) {
            Object obj = this.listenerManager.get(AutelListenerManager.MissionStateRealTimeInfoListener);
            if (obj instanceof CallbackWithOneParam) {
                this.missionManagerService.setRealTimeInfoListener((CallbackWithOneParam) obj);
            }
        }
    }

    public void setRealTimeInfoListener(CallbackWithOneParam<RealTimeInfo> callbackWithOneParam) {
        this.listenerManager.put(AutelListenerManager.MissionStateRealTimeInfoListener, callbackWithOneParam);
        MissionManagerService missionManagerService2 = this.missionManagerService;
        if (missionManagerService2 != null) {
            missionManagerService2.setRealTimeInfoListener(callbackWithOneParam);
        }
    }

    public void prepareMission(C2700AutelMission autelMission, CallbackWithOneParamProgress<Boolean> callbackWithOneParamProgress) {
        if (checkStateEnable(callbackWithOneParamProgress, AuthorityState.NORMAL)) {
            this.missionManagerService.prepareMission(autelMission, callbackWithOneParamProgress);
        }
    }

    public void startMission(CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam, AuthorityState.NORMAL)) {
            this.missionManagerService.startMission(callbackWithNoParam);
        }
    }

    public void pauseMission(CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam, AuthorityState.NORMAL)) {
            this.missionManagerService.pauseMission(callbackWithNoParam);
        }
    }

    public void resumeMission(CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam, AuthorityState.NORMAL)) {
            this.missionManagerService.resumeMission(callbackWithNoParam);
        }
    }

    public void cancelMission(CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam, AuthorityState.NORMAL)) {
            this.missionManagerService.cancelMission(callbackWithNoParam);
        }
    }

    public void cancelMission(int i, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam, AuthorityState.NORMAL)) {
            this.missionManagerService.cancelMission(i, callbackWithNoParam);
        }
    }

    public void downloadMission(CallbackWithOneParamProgress<C2700AutelMission> callbackWithOneParamProgress) {
        if (checkStateEnable(callbackWithOneParamProgress)) {
            this.missionManagerService.downloadMission(callbackWithOneParamProgress);
        }
    }

    public void downloadMissionForEvo(CallbackWithOneParamProgress<C2700AutelMission> callbackWithOneParamProgress) {
        if (checkStateEnable(callbackWithOneParamProgress)) {
            this.missionManagerService.downloadMissionForEvo(callbackWithOneParamProgress);
        }
    }

    public void yawRestore(CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam, AuthorityState.NORMAL)) {
            this.missionManagerService.yawRestore(callbackWithNoParam);
        }
    }

    public C2700AutelMission getCurrentMission() {
        if (checkStateEnable((FailedCallback) null)) {
            return this.missionManagerService.getCurrentMission();
        }
        return null;
    }

    public MissionExecuteState getMissionExecuteState() {
        if (checkStateEnable((FailedCallback) null)) {
            return this.missionManagerService.getMissionExecuteState();
        }
        return null;
    }

    public RxMissionManager toRx() {
        if (this.mRxMissionManager == null) {
            this.mRxMissionManager = new RxMissionManagerImpl(this);
        }
        return this.mRxMissionManager;
    }
}

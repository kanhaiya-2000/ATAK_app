package com.autel.internal;

import com.autel.common.FailedCallback;
import com.autel.internal.autel.IAutelStateManager;

public abstract class AutelInitializeProxy implements AutelVersionService {
    protected boolean hasInit = false;
    protected AutelListenerManager listenerManager = new AutelListenerManager();
    private AutelModuleService moduleService;
    protected IAutelStateManager stateManager;

    /* access modifiers changed from: protected */
    public abstract AutelModuleService buildConnection(AutelServiceVersion autelServiceVersion);

    /* access modifiers changed from: protected */
    public abstract boolean checkStateEnable(FailedCallback failedCallback);

    /* access modifiers changed from: protected */
    public abstract void initListener();

    public void init(IAutelStateManager iAutelStateManager) {
        this.hasInit = true;
        this.stateManager = iAutelStateManager;
    }

    public void connect(AutelServiceVersion autelServiceVersion) {
        AutelModuleService autelModuleService = this.moduleService;
        if (autelModuleService != null) {
            autelModuleService.destroy();
        }
        this.moduleService = buildConnection(autelServiceVersion);
        initListener();
        AutelModuleService autelModuleService2 = this.moduleService;
        if (autelModuleService2 != null) {
            autelModuleService2.init(this.stateManager);
            this.moduleService.connect();
        }
    }

    public void disconnect() {
        AutelModuleService autelModuleService = this.moduleService;
        if (autelModuleService != null) {
            autelModuleService.disconnect();
        }
    }

    public void destroy() {
        AutelModuleService autelModuleService = this.moduleService;
        if (autelModuleService != null) {
            this.hasInit = false;
            autelModuleService.destroy();
            this.listenerManager.clear();
        }
    }

    /* access modifiers changed from: protected */
    public boolean isSdkValidate() {
        IAutelStateManager iAutelStateManager = this.stateManager;
        return iAutelStateManager != null && iAutelStateManager.isSdkValidate();
    }
}

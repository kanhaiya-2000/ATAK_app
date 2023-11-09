package com.autel.internal.product;

import com.autel.common.product.AutelProductType;
import com.autel.internal.AutelServiceVersion;
import com.autel.internal.autel.IAutelStateManager;
import com.autel.internal.battery.BatteryFactory;
import com.autel.internal.battery.evo.EvoBatteryService4Initialize;
import com.autel.internal.dsp.DspFactory;
import com.autel.internal.dsp.evo.EvoDspService4Initialize;
import com.autel.internal.flycontroller.FlyControllerFactory;
import com.autel.internal.flycontroller.evo2.Evo2FlyControllerService4Initialize;
import com.autel.internal.gimbal.GimbalFactory;
import com.autel.internal.gimbal.evo.EvoGimbalService4Initialize;
import com.autel.internal.mission.MissionFactory;
import com.autel.internal.mission.MissionManagerService4Initialize;
import com.autel.internal.remotecontroller.RemoteControllerFactory;
import com.autel.internal.remotecontroller.RemoteControllerService4Initialize;
import com.autel.sdk.battery.EvoBattery;
import com.autel.sdk.dsp.EvoDsp;
import com.autel.sdk.flycontroller.Evo2FlyController;
import com.autel.sdk.gimbal.EvoGimbal;
import com.autel.sdk.mission.MissionManager;
import com.autel.sdk.product.Evo2Aircraft;
import com.autel.sdk.remotecontroller.C4932AutelRemoteController;

public class Evo2AircraftImpl extends BaseProductImpl implements Evo2Aircraft {
    protected EvoBatteryService4Initialize productBattery = BatteryFactory.createG2Battery();
    private EvoDspService4Initialize productDsp = DspFactory.createG2Dsp();
    private Evo2FlyControllerService4Initialize productFlyController = FlyControllerFactory.createEvo2FlyController();
    private EvoGimbalService4Initialize productGimbal = GimbalFactory.createG2Gimbal();
    protected MissionManagerService4Initialize productMissionManager = MissionFactory.createMissionManager(this.productFlyController);
    private RemoteControllerService4Initialize productRemoteController = RemoteControllerFactory.createRemoteController();

    public Evo2AircraftImpl(IAutelStateManager iAutelStateManager, AutelServiceVersion autelServiceVersion) {
        super(iAutelStateManager);
        this.serviceVersion = autelServiceVersion;
    }

    public Evo2FlyController getFlyController() {
        return this.productFlyController;
    }

    public C4932AutelRemoteController getRemoteController() {
        return this.productRemoteController;
    }

    public EvoGimbal getGimbal() {
        return this.productGimbal;
    }

    public MissionManager getMissionManager() {
        return this.productMissionManager;
    }

    public EvoDsp getDsp() {
        return this.productDsp;
    }

    public AutelProductType getType() {
        return AutelProductType.EVO_2;
    }

    public EvoBattery getBattery() {
        return this.productBattery;
    }

    public void productConnected() {
        super.productConnected();
        this.productFlyController.connect(this.serviceVersion);
        this.productRemoteController.connect(this.serviceVersion);
        this.productGimbal.connect(this.serviceVersion);
        this.productMissionManager.connect(this.serviceVersion);
        this.productDsp.connect(this.serviceVersion);
        this.productBattery.connect(this.serviceVersion);
    }

    public void productDisconnect() {
        super.productDisconnect();
        this.productFlyController.disconnect();
        this.productRemoteController.disconnect();
        this.productGimbal.disconnect();
        this.productMissionManager.disconnect();
        this.productDsp.disconnect();
        this.productBattery.disconnect();
    }

    public void productInit() {
        super.productInit();
        this.productFlyController.init(this.stateManager);
        this.productRemoteController.init(this.stateManager);
        this.productGimbal.init(this.stateManager);
        this.productMissionManager.init(this.stateManager);
        this.productDsp.init(this.stateManager);
        this.productBattery.init(this.stateManager);
    }

    public void productDestroy() {
        super.productDestroy();
        this.productFlyController.destroy();
        this.productRemoteController.destroy();
        this.productGimbal.destroy();
        this.productMissionManager.destroy();
        this.productDsp.destroy();
        this.productBattery.destroy();
    }
}

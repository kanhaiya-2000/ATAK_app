package com.autel.internal.product;

import com.autel.common.product.AutelProductType;
import com.autel.internal.AutelServiceVersion;
import com.autel.internal.autel.IAutelStateManager;
import com.autel.internal.battery.BatteryFactory;
import com.autel.internal.battery.xstar.XStarBatteryService4Initialize;
import com.autel.internal.dsp.DspFactory;
import com.autel.internal.dsp.xstar.XStarDspService4Initialize;
import com.autel.internal.flycontroller.FlyControllerFactory;
import com.autel.internal.flycontroller.xstar.XStarFlyControllerService4Initialize;
import com.autel.internal.gimbal.GimbalFactory;
import com.autel.internal.gimbal.xstar.XStarGimbalService4Initialize;
import com.autel.internal.mission.MissionFactory;
import com.autel.internal.mission.MissionManagerService4Initialize;
import com.autel.internal.remotecontroller.RemoteControllerFactory;
import com.autel.internal.remotecontroller.RemoteControllerService4Initialize;
import com.autel.sdk.battery.XStarBattery;
import com.autel.sdk.dsp.XStarDsp;
import com.autel.sdk.flycontroller.XStarFlyController;
import com.autel.sdk.gimbal.XStarGimbal;
import com.autel.sdk.mission.MissionManager;
import com.autel.sdk.product.XStarAircraft;
import com.autel.sdk.remotecontroller.C4932AutelRemoteController;

public class XStarAircraftImpl extends BaseProductImpl implements XStarAircraft {
    private XStarBatteryService4Initialize productBattery = BatteryFactory.createXStarBattery();
    private XStarDspService4Initialize productDsp = DspFactory.createXStarDsp();
    private XStarFlyControllerService4Initialize productFlyController = FlyControllerFactory.createXStarFlyController();
    private XStarGimbalService4Initialize productGimbal = GimbalFactory.createXStarGimbal();
    private MissionManagerService4Initialize productMissionManager = MissionFactory.createMissionManager(this.productFlyController);
    private RemoteControllerService4Initialize productRemoteController = RemoteControllerFactory.createRemoteController();

    public XStarAircraftImpl(IAutelStateManager iAutelStateManager, AutelServiceVersion autelServiceVersion) {
        super(iAutelStateManager);
        this.serviceVersion = autelServiceVersion;
    }

    public XStarFlyController getFlyController() {
        return this.productFlyController;
    }

    public C4932AutelRemoteController getRemoteController() {
        return this.productRemoteController;
    }

    public XStarGimbal getGimbal() {
        return this.productGimbal;
    }

    public MissionManager getMissionManager() {
        return this.productMissionManager;
    }

    public XStarDsp getDsp() {
        return this.productDsp;
    }

    public XStarBattery getBattery() {
        return this.productBattery;
    }

    public AutelProductType getType() {
        return AutelProductType.X_STAR;
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

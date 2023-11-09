package com.autel.internal.mission;

import com.autel.AutelNet2.aircraft.battery.engine.BatteryInfoInternal;
import com.autel.common.flycontroller.FlyControllerStatus;
import com.autel.internal.AutelServiceVersion;
import com.autel.internal.mission.evo.EvoMissionManager;
import com.autel.internal.mission.evo.protocol.MissionUtil;
import com.autel.internal.mission.xstar.MissionManager10;
import com.autel.sdk.flycontroller.C4930AutelFlyController;
import com.autel.sdk10.AutelNet.AutelBattery.parser.BatteryInfoParser;
import com.autel.sdk10.AutelNet.AutelFlyController.parser.FlyControllerStatusInternalParser;
import com.autel.sdk10.AutelNet.AutelFlyController.parser.GPSInfoInternalParser;

public class MissionFactory {
    public static MissionManagerInitializeProxy createMissionManager(C4930AutelFlyController autelFlyController) {
        return new MissionManagerInitializeProxy(autelFlyController);
    }

    /* renamed from: com.autel.internal.mission.MissionFactory$1 */
    /* synthetic */ class C46311 {
        static final /* synthetic */ int[] $SwitchMap$com$autel$internal$AutelServiceVersion;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.autel.internal.AutelServiceVersion[] r0 = com.autel.internal.AutelServiceVersion.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$autel$internal$AutelServiceVersion = r0
                com.autel.internal.AutelServiceVersion r1 = com.autel.internal.AutelServiceVersion.SERVICE_10     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$autel$internal$AutelServiceVersion     // Catch:{ NoSuchFieldError -> 0x001d }
                com.autel.internal.AutelServiceVersion r1 = com.autel.internal.AutelServiceVersion.SERVICE_20     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.autel.internal.mission.MissionFactory.C46311.<clinit>():void");
        }
    }

    public static MissionManagerService createMissionManager(AutelServiceVersion autelServiceVersion, C4930AutelFlyController autelFlyController) {
        int i = C46311.$SwitchMap$com$autel$internal$AutelServiceVersion[autelServiceVersion.ordinal()];
        if (i == 1) {
            return new MissionManagerPreconditionProxy(new MissionManager10(FlyControllerStatusInternalParser.getInstance_(), autelFlyController), FlyControllerStatusInternalParser.getInstance_(), GPSInfoInternalParser.getInstance_(), BatteryInfoParser.getInstance_());
        }
        if (i != 2) {
            FlyControllerStatus createFlyControllerStatus = MissionUtil.createFlyControllerStatus();
            return new MissionManagerPreconditionProxy(new EvoMissionManager(createFlyControllerStatus, autelFlyController), createFlyControllerStatus, MissionUtil.createGPSInfo(), BatteryInfoInternal.instance());
        }
        FlyControllerStatus createFlyControllerStatus2 = MissionUtil.createFlyControllerStatus();
        return new MissionManagerPreconditionProxy(new EvoMissionManager(createFlyControllerStatus2, autelFlyController), createFlyControllerStatus2, MissionUtil.createGPSInfo(), BatteryInfoInternal.instance());
    }
}

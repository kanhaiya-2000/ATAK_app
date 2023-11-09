package org.droidplanner.services.android.impl.utils;

import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import atakplugin.UASTool.cqb;
import com.o3dr.services.android.lib.drone.companion.solo.SoloState;
import com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloButtonSettingSetter;
import com.o3dr.services.android.lib.drone.companion.solo.tlv.TLVPacket;
import com.o3dr.services.android.lib.model.ICommandListener;
import org.droidplanner.services.android.impl.core.drone.autopilot.Drone;
import org.droidplanner.services.android.impl.core.drone.autopilot.apm.solo.ArduSolo;
import org.droidplanner.services.android.impl.core.drone.autopilot.apm.solo.SoloComp;

public class SoloApiUtils {
    private SoloApiUtils() {
    }

    public static SoloState getSoloLinkState(ArduSolo arduSolo) {
        if (arduSolo == null) {
            return null;
        }
        SoloComp soloComp = arduSolo.getSoloComp();
        Pair<String, String> wifiSettings = soloComp.getWifiSettings();
        return new SoloState(soloComp.getAutopilotVersion(), soloComp.getControllerFirmwareVersion(), soloComp.getControllerVersion(), soloComp.getVehicleVersion(), (String) wifiSettings.second, (String) wifiSettings.first, soloComp.getTxPowerCompliantCountry(), soloComp.getButtonSettings(), soloComp.getGimbalVersion(), soloComp.getControllerMode(), soloComp.getControllerUnit());
    }

    public static boolean isSoloLinkFeatureAvailable(Drone drone, ICommandListener iCommandListener) {
        if (drone == null) {
            return false;
        }
        if (drone instanceof ArduSolo) {
            return true;
        }
        if (iCommandListener != null) {
            try {
                iCommandListener.onError(3);
            } catch (RemoteException e) {
                cqb.m12015e(e, e.getMessage(), new Object[0]);
            }
        }
        return false;
    }

    public static void sendSoloLinkMessage(ArduSolo arduSolo, TLVPacket tLVPacket, ICommandListener iCommandListener) {
        if (isSoloLinkFeatureAvailable(arduSolo, iCommandListener) && tLVPacket != null) {
            arduSolo.getSoloComp().sendSoloLinkMessage(tLVPacket, iCommandListener);
        }
    }

    public static void updateSoloLinkWifiSettings(ArduSolo arduSolo, String str, String str2, ICommandListener iCommandListener) {
        if (isSoloLinkFeatureAvailable(arduSolo, iCommandListener)) {
            if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
                arduSolo.getSoloComp().updateWifiSettings(str, str2, iCommandListener);
            }
        }
    }

    public static void updateSoloLinkButtonSettings(ArduSolo arduSolo, SoloButtonSettingSetter soloButtonSettingSetter, ICommandListener iCommandListener) {
        if (isSoloLinkFeatureAvailable(arduSolo, iCommandListener) && soloButtonSettingSetter != null) {
            arduSolo.getSoloComp().pushButtonSettings(soloButtonSettingSetter, iCommandListener);
        }
    }

    public static void updateSoloLinkControllerMode(ArduSolo arduSolo, int i, ICommandListener iCommandListener) {
        if (isSoloLinkFeatureAvailable(arduSolo, iCommandListener)) {
            arduSolo.getSoloComp().updateControllerMode(i, iCommandListener);
        }
    }

    public static void updateSoloControllerUnit(ArduSolo arduSolo, String str, ICommandListener iCommandListener) {
        if (isSoloLinkFeatureAvailable(arduSolo, iCommandListener)) {
            arduSolo.getSoloComp().updateControllerUnit(str, iCommandListener);
        }
    }

    public static void updateSoloLinkTxPowerComplianceCountry(ArduSolo arduSolo, String str, ICommandListener iCommandListener) {
        if (isSoloLinkFeatureAvailable(arduSolo, iCommandListener)) {
            arduSolo.getSoloComp().updateTxPowerComplianceCountry(str, iCommandListener);
        }
    }
}

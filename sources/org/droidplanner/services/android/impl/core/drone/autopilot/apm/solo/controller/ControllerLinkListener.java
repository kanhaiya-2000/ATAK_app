package org.droidplanner.services.android.impl.core.drone.autopilot.apm.solo.controller;

import com.o3dr.services.android.lib.drone.companion.solo.button.ButtonPacket;
import com.o3dr.services.android.lib.drone.companion.solo.tlv.TLVPacket;
import org.droidplanner.services.android.impl.core.drone.autopilot.apm.solo.AbstractLinkManager;

public interface ControllerLinkListener extends AbstractLinkManager.LinkListener {
    void onButtonPacketReceived(ButtonPacket buttonPacket);

    void onControllerModeUpdated();

    void onControllerUnitUpdated(String str);

    void onTlvPacketReceived(TLVPacket tLVPacket);

    void onTxPowerComplianceCountryUpdated(String str);

    void onWifiInfoUpdated(String str, String str2);
}

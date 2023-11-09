package org.droidplanner.services.android.impl.core.drone.autopilot.apm.solo.sololink;

import com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloButtonSetting;
import com.o3dr.services.android.lib.drone.companion.solo.tlv.TLVPacket;
import org.droidplanner.services.android.impl.core.drone.autopilot.apm.solo.AbstractLinkManager;

public interface SoloLinkListener extends AbstractLinkManager.LinkListener {
    void onPresetButtonLoaded(int i, SoloButtonSetting soloButtonSetting);

    void onTlvPacketReceived(TLVPacket tLVPacket);
}

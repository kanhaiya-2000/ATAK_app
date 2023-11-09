package org.droidplanner.services.android.impl.core.MAVLink.connection;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.o3dr.services.android.lib.gcs.link.LinkConnectionStatus;

public interface MavLinkConnectionListener {
    void onConnectionStatus(LinkConnectionStatus linkConnectionStatus);

    void onReceivePacket(MAVLinkPacket mAVLinkPacket);
}

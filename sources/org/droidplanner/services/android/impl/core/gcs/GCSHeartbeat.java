package org.droidplanner.services.android.impl.core.gcs;

import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.common.msg_heartbeat;
import com.o3dr.services.android.lib.model.ICommandListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.droidplanner.services.android.impl.communication.model.DataLink;

public class GCSHeartbeat {
    /* access modifiers changed from: private */
    public static final msg_heartbeat sMsg;
    /* access modifiers changed from: private */
    public final DataLink.DataLinkProvider<MAVLinkMessage> dataLink;
    private ScheduledExecutorService heartbeatExecutor;
    private final Runnable heartbeatRunnable = new Runnable() {
        public void run() {
            GCSHeartbeat.this.dataLink.sendMessage(GCSHeartbeat.sMsg, (ICommandListener) null);
        }
    };
    private final int period;

    static {
        msg_heartbeat msg_heartbeat = new msg_heartbeat();
        sMsg = msg_heartbeat;
        msg_heartbeat.type = 6;
        msg_heartbeat.autopilot = 0;
    }

    public GCSHeartbeat(DataLink.DataLinkProvider<MAVLinkMessage> dataLinkProvider, int i) {
        this.dataLink = dataLinkProvider;
        this.period = i;
    }

    public synchronized void setActive(boolean z) {
        if (z) {
            ScheduledExecutorService scheduledExecutorService = this.heartbeatExecutor;
            if (scheduledExecutorService == null || scheduledExecutorService.isShutdown()) {
                ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
                this.heartbeatExecutor = newSingleThreadScheduledExecutor;
                newSingleThreadScheduledExecutor.scheduleWithFixedDelay(this.heartbeatRunnable, 0, (long) this.period, TimeUnit.SECONDS);
            }
        } else {
            ScheduledExecutorService scheduledExecutorService2 = this.heartbeatExecutor;
            if (scheduledExecutorService2 != null && !scheduledExecutorService2.isShutdown()) {
                this.heartbeatExecutor.shutdownNow();
                this.heartbeatExecutor = null;
            }
        }
    }
}

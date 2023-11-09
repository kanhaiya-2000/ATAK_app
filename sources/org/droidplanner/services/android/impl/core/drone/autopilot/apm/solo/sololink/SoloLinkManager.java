package org.droidplanner.services.android.impl.core.drone.autopilot.apm.solo.sololink;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import atakplugin.UASTool.cqb;
import com.o3dr.android.client.utils.connection.TcpConnection;
import com.o3dr.android.client.utils.connection.UdpConnection;
import com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloButtonSetting;
import com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloButtonSettingGetter;
import com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloButtonSettingSetter;
import com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloGoproRequestState;
import com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloMessageShotManagerError;
import com.o3dr.services.android.lib.drone.companion.solo.tlv.TLVMessageParser;
import com.o3dr.services.android.lib.drone.companion.solo.tlv.TLVPacket;
import com.o3dr.services.android.lib.model.ICommandListener;
import com.o3dr.services.android.lib.model.SimpleCommandListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicReference;
import org.droidplanner.services.android.impl.communication.model.DataLink;
import org.droidplanner.services.android.impl.core.drone.autopilot.apm.solo.AbstractLinkManager;
import org.droidplanner.services.android.impl.core.drone.autopilot.apm.solo.SoloComp;
import org.droidplanner.services.android.impl.utils.connection.SshConnection;

public class SoloLinkManager extends AbstractLinkManager<SoloLinkListener> {
    private static final String GIMBAL_VERSION_FILENAME = "/AXON_VERSION";
    private static final String PIXHAWK_VERSION_FILENAME = "/PIX_VERSION";
    private static final int SHOT_FOLLOW_UDP_PORT = 14558;
    public static final String SOLO_LINK_IP = "10.1.1.10";
    public static final int SOLO_LINK_TCP_PORT = 5507;
    private static final String SOLO_VERSION_FILENAME = "/VERSION";
    private final UdpConnection followDataConn;
    /* access modifiers changed from: private */
    public final AtomicReference<String> gimbalVersion = new AtomicReference<>("");
    private final Runnable gimbalVersionRetriever = new Runnable() {
        public void run() {
            String access$000 = SoloLinkManager.this.retrieveVersion(SoloLinkManager.GIMBAL_VERSION_FILENAME);
            if (access$000 != null) {
                SoloLinkManager.this.gimbalVersion.set(access$000);
            }
            if (SoloLinkManager.this.linkListener != null && SoloLinkManager.this.areVersionsSet()) {
                SoloLinkManager.this.linkListener.onVersionsUpdated();
            }
        }
    };
    private final SoloGoproRequestState goproStateGetter = new SoloGoproRequestState();
    /* access modifiers changed from: private */
    public SoloLinkListener linkListener;
    private final AtomicReference<SoloButtonSetting> loadedPresetButtonA = new AtomicReference<>();
    private final AtomicReference<SoloButtonSetting> loadedPresetButtonB = new AtomicReference<>();
    /* access modifiers changed from: private */
    public final AtomicReference<String> pixhawkVersion = new AtomicReference<>("");
    private final Runnable pixhawkVersionRetriever = new Runnable() {
        public void run() {
            String access$000 = SoloLinkManager.this.retrieveVersion(SoloLinkManager.PIXHAWK_VERSION_FILENAME);
            if (access$000 != null) {
                SoloLinkManager.this.pixhawkVersion.set(access$000);
            }
            if (SoloLinkManager.this.linkListener != null && SoloLinkManager.this.areVersionsSet()) {
                SoloLinkManager.this.linkListener.onVersionsUpdated();
            }
        }
    };
    private final SoloButtonSettingGetter presetButtonAGetter = new SoloButtonSettingGetter(4, 0);
    /* access modifiers changed from: private */
    public final SoloButtonSettingGetter presetButtonBGetter = new SoloButtonSettingGetter(5, 0);
    private final Runnable soloLinkVersionRetriever = new Runnable() {
        public void run() {
            String access$000 = SoloLinkManager.this.retrieveVersion(SoloLinkManager.SOLO_VERSION_FILENAME);
            if (access$000 != null) {
                SoloLinkManager.this.vehicleVersion.set(access$000);
            }
            if (SoloLinkManager.this.linkListener != null && SoloLinkManager.this.areVersionsSet()) {
                SoloLinkManager.this.linkListener.onVersionsUpdated();
            }
        }
    };
    private final SshConnection sshLink;
    /* access modifiers changed from: private */
    public final AtomicReference<String> vehicleVersion = new AtomicReference<>("");

    public static String getSoloLinkIp() {
        return "10.1.1.10";
    }

    public SoloLinkManager(Context context, Handler handler, ExecutorService executorService, DataLink.DataLinkProvider dataLinkProvider) {
        super(context, new TcpConnection(handler, getSoloLinkIp(), SOLO_LINK_TCP_PORT), handler, executorService, dataLinkProvider);
        UdpConnection udpConnection;
        this.sshLink = new SshConnection(getSoloLinkIp(), SoloComp.SSH_USERNAME, SoloComp.SSH_PASSWORD, dataLinkProvider);
        try {
            udpConnection = new UdpConnection(handler, getSoloLinkIp(), 14558, 14557);
        } catch (UnknownHostException e) {
            cqb.m12015e(e, "Error while creating follow udp connection.", new Object[0]);
            udpConnection = null;
        }
        this.followDataConn = udpConnection;
    }

    public String getVehicleVersion() {
        return this.vehicleVersion.get();
    }

    public String getPixhawkVersion() {
        return this.pixhawkVersion.get();
    }

    public String getGimbalVersion() {
        return this.gimbalVersion.get();
    }

    public boolean areVersionsSet() {
        return !TextUtils.isEmpty(this.vehicleVersion.get()) && !TextUtils.isEmpty(this.pixhawkVersion.get());
    }

    public void start(SoloLinkListener soloLinkListener) {
        if (!isStarted()) {
            cqb.m12010c("Starting solo link manager", new Object[0]);
        }
        super.start(soloLinkListener);
        this.linkListener = soloLinkListener;
    }

    public void stop() {
        if (isStarted()) {
            cqb.m12010c("Stopping solo link manager", new Object[0]);
        }
        super.stop();
    }

    public void refreshState() {
        cqb.m12007b("Connected to sololink.", new Object[0]);
        loadMacAddress();
        loadPresetButtonSettings();
        loadGoproState();
        refreshSoloLinkVersions();
    }

    /* access modifiers changed from: protected */
    public SshConnection getSshLink() {
        return this.sshLink;
    }

    public void onIpDisconnected() {
        cqb.m12007b("Disconnected from sololink.", new Object[0]);
        super.onIpDisconnected();
    }

    public void onPacketReceived(ByteBuffer byteBuffer) {
        List<TLVPacket> parseTLVPacket = TLVMessageParser.parseTLVPacket(byteBuffer);
        if (!parseTLVPacket.isEmpty()) {
            for (TLVPacket next : parseTLVPacket) {
                int messageType = next.getMessageType();
                cqb.m12007b("Received tlv message: " + messageType, new Object[0]);
                if (messageType == 5) {
                    handleReceivedPresetButton((SoloButtonSettingGetter) next);
                } else if (messageType == 1000) {
                    cqb.m12012d(((SoloMessageShotManagerError) next).getExceptionInfo(), new Object[0]);
                }
                SoloLinkListener soloLinkListener = this.linkListener;
                if (soloLinkListener != null) {
                    soloLinkListener.onTlvPacketReceived(next);
                }
            }
        }
    }

    private void sendPacket(byte[] bArr, int i, ICommandListener iCommandListener) {
        this.linkConn.sendPacket(bArr, i, iCommandListener);
    }

    private void sendFollowPacket(byte[] bArr, int i, ICommandListener iCommandListener) {
        UdpConnection udpConnection = this.followDataConn;
        if (udpConnection != null) {
            udpConnection.sendPacket(bArr, i, iCommandListener);
            return;
        }
        throw new IllegalStateException("Unable to send follow data.");
    }

    public void sendTLVPacket(TLVPacket tLVPacket, ICommandListener iCommandListener) {
        sendTLVPacket(tLVPacket, false, iCommandListener);
    }

    public void sendTLVPacket(TLVPacket tLVPacket, boolean z, ICommandListener iCommandListener) {
        if (tLVPacket != null) {
            byte[] bytes = tLVPacket.toBytes();
            if (z) {
                sendFollowPacket(bytes, bytes.length, iCommandListener);
            } else {
                sendPacket(bytes, bytes.length, iCommandListener);
            }
        }
    }

    public void loadPresetButtonSettings() {
        sendTLVPacket(this.presetButtonAGetter, new SimpleCommandListener() {
            public void onSuccess() {
                SoloLinkManager soloLinkManager = SoloLinkManager.this;
                soloLinkManager.sendTLVPacket(soloLinkManager.presetButtonBGetter, (ICommandListener) null);
            }
        });
    }

    private void loadGoproState() {
        sendTLVPacket(this.goproStateGetter, (ICommandListener) null);
    }

    /* access modifiers changed from: private */
    public void handleReceivedPresetButton(SoloButtonSetting soloButtonSetting) {
        int button = soloButtonSetting.getButton();
        if (button == 4) {
            this.loadedPresetButtonA.set(soloButtonSetting);
            SoloLinkListener soloLinkListener = this.linkListener;
            if (soloLinkListener != null) {
                soloLinkListener.onPresetButtonLoaded(button, soloButtonSetting);
            }
        } else if (button == 5) {
            this.loadedPresetButtonB.set(soloButtonSetting);
            SoloLinkListener soloLinkListener2 = this.linkListener;
            if (soloLinkListener2 != null) {
                soloLinkListener2.onPresetButtonLoaded(button, soloButtonSetting);
            }
        }
    }

    public SoloButtonSetting getLoadedPresetButton(int i) {
        if (i == 4) {
            return this.loadedPresetButtonA.get();
        }
        if (i != 5) {
            return null;
        }
        return this.loadedPresetButtonB.get();
    }

    public void pushPresetButtonSettings(final SoloButtonSettingSetter soloButtonSettingSetter, final ICommandListener iCommandListener) {
        if (isLinkConnected() && soloButtonSettingSetter != null) {
            sendTLVPacket(soloButtonSettingSetter, new SimpleCommandListener() {
                public void onSuccess() {
                    SoloLinkManager.this.postSuccessEvent(iCommandListener);
                    SoloLinkManager.this.handleReceivedPresetButton(soloButtonSettingSetter);
                }

                public void onTimeout() {
                    SoloLinkManager.this.postTimeoutEvent(iCommandListener);
                }
            });
        }
    }

    public void disableFollowDataConnection() {
        UdpConnection udpConnection = this.followDataConn;
        if (udpConnection != null) {
            udpConnection.disconnect();
        }
    }

    public void enableFollowDataConnection() {
        UdpConnection udpConnection = this.followDataConn;
        if (udpConnection != null) {
            udpConnection.connect(this.linkProvider.getConnectionExtras());
        }
    }

    public boolean updateSololinkWifi(CharSequence charSequence, CharSequence charSequence2) {
        cqb.m12007b(String.format(Locale.US, "Updating solo wifi ssid to %s with password %s", new Object[]{charSequence, charSequence2}), new Object[0]);
        try {
            SshConnection sshConnection = this.sshLink;
            sshConnection.execute("/usr/bin/sololink_config --set-wifi-ssid " + charSequence);
            SshConnection sshConnection2 = this.sshLink;
            sshConnection2.execute("/usr/bin/sololink_config --set-wifi-password " + charSequence2);
            this.sshLink.execute("/usr/bin/sololink_config --reboot");
            return true;
        } catch (IOException e) {
            cqb.m12015e(e, "Error occurred while updating the sololink wifi ssid.", new Object[0]);
            return false;
        }
    }

    private void updateSoloLinkVersion() {
        postAsyncTask(this.soloLinkVersionRetriever);
    }

    private void updatePixhawkVersion() {
        postAsyncTask(this.pixhawkVersionRetriever);
    }

    private void updateGimbalVersion() {
        postAsyncTask(this.gimbalVersionRetriever);
    }

    /* access modifiers changed from: private */
    public String retrieveVersion(String str) {
        try {
            SshConnection sshConnection = this.sshLink;
            String execute = sshConnection.execute("cat " + str);
            if (!TextUtils.isEmpty(execute)) {
                return execute.split("\n")[0];
            }
            cqb.m12007b("No version file was found", new Object[0]);
            return "";
        } catch (IOException e) {
            cqb.m12014e("Unable to retrieve the current version.", e);
            return null;
        }
    }

    public void refreshSoloLinkVersions() {
        updateSoloLinkVersion();
        updatePixhawkVersion();
        updateGimbalVersion();
    }
}

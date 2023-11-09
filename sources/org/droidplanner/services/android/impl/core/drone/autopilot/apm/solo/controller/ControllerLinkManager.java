package org.droidplanner.services.android.impl.core.drone.autopilot.apm.solo.controller;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Pair;
import atakplugin.UASTool.C0964vm;
import atakplugin.UASTool.cqb;
import com.o3dr.android.client.utils.TxPowerComplianceCountries;
import com.o3dr.android.client.utils.connection.IpConnectionListener;
import com.o3dr.android.client.utils.connection.TcpConnection;
import com.o3dr.services.android.lib.drone.companion.solo.button.ButtonPacket;
import com.o3dr.services.android.lib.drone.companion.solo.controller.SoloControllerUnits;
import com.o3dr.services.android.lib.drone.companion.solo.tlv.TLVMessageParser;
import com.o3dr.services.android.lib.drone.companion.solo.tlv.TLVPacket;
import com.o3dr.services.android.lib.model.ICommandListener;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.droidplanner.services.android.impl.communication.model.DataLink;
import org.droidplanner.services.android.impl.core.drone.autopilot.apm.solo.AbstractLinkManager;
import org.droidplanner.services.android.impl.core.drone.autopilot.apm.solo.SoloComp;
import org.droidplanner.services.android.impl.utils.NetworkUtils;
import org.droidplanner.services.android.impl.utils.connection.SshConnection;

public class ControllerLinkManager extends AbstractLinkManager<ControllerLinkListener> {
    private static final int ARTOO_BATTERY_PORT = 5021;
    private static final int ARTOO_BUTTON_PORT = 5016;
    public static final String ARTOO_IP = "10.1.1.1";
    public static final int ARTOO_UDP_PORT = 5600;
    private static final String ARTOO_VERSION_FILENAME = "/VERSION";
    private static final int ARTOO_VIDEO_HANDSHAKE_PORT = 5502;
    private static final C0964vm CONTROLLER_MODE_MIN_VERSION = C0964vm.m14246a(1, 1, 13);
    public static final String SOLOLINK_SSID_CONFIG_PATH = "/usr/bin/sololink_config";
    private static final String STM32_VERSION_FILENAME = "/STM_VERSION";
    private final Runnable artooModeRetriever = new Runnable() {
        public void run() {
            cqb.m12010c("Retrieving controller mode", new Object[0]);
            try {
                String execute = ControllerLinkManager.this.sshLink.execute("/usr/bin/sololink_config --get-ui-mode");
                String trim = TextUtils.isEmpty(execute) ? "" : execute.trim();
                char c = 65535;
                int hashCode = trim.hashCode();
                if (hashCode != 49) {
                    if (hashCode == 50) {
                        if (trim.equals("2")) {
                            c = 1;
                        }
                    }
                } else if (trim.equals("1")) {
                    c = 0;
                }
                if (c == 0) {
                    ControllerLinkManager.this.setControllerMode(1);
                } else if (c != 1) {
                    cqb.m12012d("Unable to parse received controller mode.", new Object[0]);
                    ControllerLinkManager.this.setControllerMode(0);
                } else {
                    ControllerLinkManager.this.setControllerMode(2);
                }
            } catch (IOException e) {
                cqb.m12015e(e, "Error occurred while getting controller mode.", new Object[0]);
            }
        }
    };
    private final Runnable artooVersionRetriever = new Runnable() {
        public void run() {
            String access$600 = ControllerLinkManager.this.retrieveVersion(ControllerLinkManager.ARTOO_VERSION_FILENAME);
            if (access$600 != null) {
                ControllerLinkManager.this.controllerVersion.set(access$600);
            }
            ControllerLinkManager.this.updateControllerModeIfPossible();
            ControllerLinkManager.this.updateControllerUnitIfPossible();
            ControllerLinkManager.this.onVersionsUpdated();
        }
    };
    /* access modifiers changed from: private */
    public final TcpConnection batteryConnection;
    private final Runnable checkEUTxPowerCompliance = new Runnable() {
        public void run() {
            String str;
            try {
                str = ControllerLinkManager.this.sshLink.execute("/usr/bin/sololink_config --get-wifi-country").trim();
                if (ControllerLinkManager.this.linkListener != null) {
                    ControllerLinkManager.this.linkListener.onTxPowerComplianceCountryUpdated(str);
                }
            } catch (IOException e) {
                cqb.m12015e(e, "Error occurred while querying wifi country.", new Object[0]);
                str = TxPowerComplianceCountries.getDefaultCountry().name();
            }
            ControllerLinkManager.this.txPowerCompliantCountry.set(str);
        }
    };
    private final AtomicInteger controllerMode = new AtomicInteger(0);
    private final AtomicReference<String> controllerUnits = new AtomicReference<>("");
    /* access modifiers changed from: private */
    public final AtomicReference<String> controllerVersion = new AtomicReference<>("");
    /* access modifiers changed from: private */
    public final AtomicBoolean isBatteryStarted = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public final AtomicBoolean isVideoHandshakeStarted = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public ControllerLinkListener linkListener;
    private final Runnable loadWifiInfo = new Runnable() {
        public void run() {
            try {
                String execute = ControllerLinkManager.this.sshLink.execute("/usr/bin/sololink_config --get-wifi-ssid");
                String execute2 = ControllerLinkManager.this.sshLink.execute("/usr/bin/sololink_config --get-wifi-password");
                if (!TextUtils.isEmpty(execute) && !TextUtils.isEmpty(execute2)) {
                    Pair create = Pair.create(execute.trim(), execute2.trim());
                    ControllerLinkManager.this.sololinkWifiInfo.set(create);
                    if (ControllerLinkManager.this.linkListener != null) {
                        ControllerLinkManager.this.linkListener.onWifiInfoUpdated((String) create.first, (String) create.second);
                    }
                }
            } catch (IOException e) {
                cqb.m12015e(e, "Unable to retrieve sololink wifi info.", new Object[0]);
            }
        }
    };
    /* access modifiers changed from: private */
    public final Runnable reconnectBatteryTask = new Runnable() {
        public void run() {
            ControllerLinkManager.this.handler.removeCallbacks(this);
            ControllerLinkManager.this.batteryConnection.connect(ControllerLinkManager.this.linkProvider.getConnectionExtras());
        }
    };
    /* access modifiers changed from: private */
    public final Runnable reconnectVideoHandshake = new Runnable() {
        public void run() {
            ControllerLinkManager.this.handler.removeCallbacks(this);
            ControllerLinkManager.this.videoHandshake.connect(ControllerLinkManager.this.linkProvider.getConnectionExtras());
        }
    };
    /* access modifiers changed from: private */
    public final AtomicReference<Pair<String, String>> sololinkWifiInfo = new AtomicReference<>(Pair.create("", ""));
    protected final SshConnection sshLink;
    /* access modifiers changed from: private */
    public final AtomicReference<String> stm32Version = new AtomicReference<>("");
    private final Runnable stm32VersionRetriever = new Runnable() {
        public void run() {
            String access$600 = ControllerLinkManager.this.retrieveVersion(ControllerLinkManager.STM32_VERSION_FILENAME);
            if (access$600 != null) {
                ControllerLinkManager.this.stm32Version.set(access$600);
            }
            ControllerLinkManager.this.onVersionsUpdated();
        }
    };
    /* access modifiers changed from: private */
    public final AtomicBoolean streamingPermission = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public final AtomicReference<String> txPowerCompliantCountry = new AtomicReference<>(TxPowerComplianceCountries.getDefaultCountry().name());
    private final Runnable unitsRetriever = new Runnable() {
        public void run() {
            cqb.m12007b("Retrieving controller units.", new Object[0]);
            try {
                String execute = ControllerLinkManager.this.sshLink.execute("/usr/bin/sololink_config --get-ui-units");
                String trim = TextUtils.isEmpty(execute) ? SoloControllerUnits.UNKNOWN : execute.trim();
                char c = 65535;
                int hashCode = trim.hashCode();
                if (hashCode != -1077545552) {
                    if (hashCode != -431614405) {
                        if (hashCode == -284840886) {
                            if (trim.equals(SoloControllerUnits.UNKNOWN)) {
                                c = 2;
                            }
                        }
                    } else if (trim.equals(SoloControllerUnits.IMPERIAL)) {
                        c = 1;
                    }
                } else if (trim.equals(SoloControllerUnits.METRIC)) {
                    c = 0;
                }
                if (c == 0 || c == 1 || c == 2) {
                    ControllerLinkManager.this.setControllerUnit(trim);
                } else {
                    cqb.m12012d("Received unknown value for controller unit: %s", trim);
                }
            } catch (IOException e) {
                cqb.m12015e(e, "Error occurred while retrieving the controller units.", new Object[0]);
            }
        }
    };
    /* access modifiers changed from: private */
    public final TcpConnection videoHandshake;

    public ControllerLinkManager(Context context, final Handler handler, ExecutorService executorService, DataLink.DataLinkProvider dataLinkProvider) {
        super(context, new TcpConnection(handler, ARTOO_IP, ARTOO_BUTTON_PORT), handler, executorService, dataLinkProvider);
        this.sshLink = new SshConnection(ARTOO_IP, SoloComp.SSH_USERNAME, SoloComp.SSH_PASSWORD, dataLinkProvider);
        TcpConnection tcpConnection = new TcpConnection(handler, ARTOO_IP, ARTOO_VIDEO_HANDSHAKE_PORT);
        this.videoHandshake = tcpConnection;
        tcpConnection.setIpConnectionListener(new IpConnectionListener() {
            public void onPacketReceived(ByteBuffer byteBuffer) {
            }

            public void onIpConnected() {
                handler.removeCallbacks(ControllerLinkManager.this.reconnectVideoHandshake);
                cqb.m12007b("Artoo link connected. Starting video stream...", new Object[0]);
                ControllerLinkManager.this.streamingPermission.set(true);
            }

            public void onIpDisconnected() {
                ControllerLinkManager.this.streamingPermission.set(false);
                if (ControllerLinkManager.this.isVideoHandshakeStarted.get()) {
                    handler.postDelayed(ControllerLinkManager.this.reconnectVideoHandshake, 1000);
                }
            }
        });
        TcpConnection tcpConnection2 = new TcpConnection(handler, ARTOO_IP, ARTOO_BATTERY_PORT);
        this.batteryConnection = tcpConnection2;
        tcpConnection2.setIpConnectionListener(new IpConnectionListener() {
            public void onIpConnected() {
                handler.removeCallbacks(ControllerLinkManager.this.reconnectBatteryTask);
            }

            public void onIpDisconnected() {
                if (ControllerLinkManager.this.isBatteryStarted.get()) {
                    handler.postDelayed(ControllerLinkManager.this.reconnectBatteryTask, 1000);
                }
            }

            public void onPacketReceived(ByteBuffer byteBuffer) {
                List<TLVPacket> parseTLVPacket = TLVMessageParser.parseTLVPacket(byteBuffer);
                if (!parseTLVPacket.isEmpty()) {
                    for (TLVPacket next : parseTLVPacket) {
                        int messageType = next.getMessageType();
                        cqb.m12007b("Received tlv message: " + messageType, new Object[0]);
                        if (ControllerLinkManager.this.linkListener != null) {
                            ControllerLinkManager.this.linkListener.onTlvPacketReceived(next);
                        }
                    }
                }
            }
        });
    }

    public boolean hasStreamingPermission() {
        return this.streamingPermission.get();
    }

    public boolean areVersionsSet() {
        return !TextUtils.isEmpty(this.controllerVersion.get()) && !TextUtils.isEmpty(this.stm32Version.get());
    }

    public String getArtooVersion() {
        return this.controllerVersion.get();
    }

    public String getStm32Version() {
        return this.stm32Version.get();
    }

    public String getTxPowerCompliantCountry() {
        return this.txPowerCompliantCountry.get();
    }

    public int getControllerMode() {
        return this.controllerMode.get();
    }

    public String getControllerUnit() {
        return this.controllerUnits.get();
    }

    private void startVideoManager() {
        this.handler.removeCallbacks(this.reconnectVideoHandshake);
        this.isVideoHandshakeStarted.set(true);
        this.videoHandshake.connect(this.linkProvider.getConnectionExtras());
    }

    private void stopVideoManager() {
        this.handler.removeCallbacks(this.reconnectVideoHandshake);
        this.isVideoHandshakeStarted.set(false);
        this.videoHandshake.disconnect();
    }

    private void loadSololinkWifiInfo() {
        postAsyncTask(this.loadWifiInfo);
    }

    public boolean updateSololinkWifi(CharSequence charSequence, CharSequence charSequence2) {
        cqb.m12007b(String.format(Locale.US, "Updating artoo wifi ssid to %s with password %s", new Object[]{charSequence, charSequence2}), new Object[0]);
        try {
            SshConnection sshConnection = this.sshLink;
            sshConnection.execute("/usr/bin/sololink_config --set-wifi-ssid " + charSequence);
            SshConnection sshConnection2 = this.sshLink;
            sshConnection2.execute("/usr/bin/sololink_config --set-wifi-password " + charSequence2);
            restartController();
            return true;
        } catch (IOException e) {
            cqb.m12015e(e, "Error occurred while updating the sololink wifi ssid.", new Object[0]);
            return false;
        }
    }

    public Pair<String, String> getSoloLinkWifiInfo() {
        return this.sololinkWifiInfo.get();
    }

    public void start(ControllerLinkListener controllerLinkListener) {
        this.linkListener = controllerLinkListener;
        if (!isStarted()) {
            cqb.m12010c("Starting artoo link manager", new Object[0]);
        }
        super.start(controllerLinkListener);
    }

    public void stop() {
        if (isStarted()) {
            cqb.m12010c("Stopping artoo link manager", new Object[0]);
        }
        super.stop();
    }

    public boolean isLinkConnected() {
        return NetworkUtils.isOnSololinkNetwork(this.context);
    }

    public void refreshState() {
        cqb.m12007b("Artoo link connected.", new Object[0]);
        loadMacAddress();
        startVideoManager();
        loadSololinkWifiInfo();
        refreshControllerVersions();
        loadCurrentEUTxPowerComplianceMode();
    }

    /* access modifiers changed from: protected */
    public SshConnection getSshLink() {
        return this.sshLink;
    }

    /* access modifiers changed from: private */
    public void onVersionsUpdated() {
        if (this.linkListener != null && areVersionsSet()) {
            this.linkListener.onVersionsUpdated();
        }
    }

    /* access modifiers changed from: private */
    public void updateControllerUnitIfPossible() {
        if (doesSupportControllerMode()) {
            cqb.m12007b("Updating current controller unit.", new Object[0]);
            loadControllerUnit();
            return;
        }
        cqb.m12012d("This controller version doesn't support controller unit retrieval.", new Object[0]);
    }

    /* access modifiers changed from: private */
    public void updateControllerModeIfPossible() {
        if (doesSupportControllerMode()) {
            cqb.m12007b("Updating current controller mode.", new Object[0]);
            loadCurrentControllerMode();
            return;
        }
        cqb.m12012d("This controller version doesn't support controller mode retrieval.", new Object[0]);
    }

    /* access modifiers changed from: private */
    public boolean doesSupportControllerMode() {
        String str = this.controllerVersion.get();
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return CONTROLLER_MODE_MIN_VERSION.mo6057d(C0964vm.m14247a(str));
        } catch (Exception e) {
            cqb.m12015e(e, "Unable to parse controller version.", new Object[0]);
            return false;
        }
    }

    public void onIpDisconnected() {
        cqb.m12007b("Artoo link disconnected.", new Object[0]);
        stopVideoManager();
        super.onIpDisconnected();
    }

    public void onPacketReceived(ByteBuffer byteBuffer) {
        ButtonPacket parseButtonPacket = ButtonPacket.parseButtonPacket(byteBuffer);
        if (parseButtonPacket != null) {
            byte buttonId = parseButtonPacket.getButtonId();
            cqb.m12007b("Button pressed: " + buttonId, new Object[0]);
            ControllerLinkListener controllerLinkListener = this.linkListener;
            if (controllerLinkListener != null) {
                controllerLinkListener.onButtonPacketReceived(parseButtonPacket);
            }
        }
    }

    private void updateArtooVersion() {
        postAsyncTask(this.artooVersionRetriever);
    }

    private void updateStm32Version() {
        postAsyncTask(this.stm32VersionRetriever);
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

    public void updateControllerUnit(final String str, final ICommandListener iCommandListener) {
        postAsyncTask(new Runnable() {
            public void run() {
                if (!ControllerLinkManager.this.doesSupportControllerMode()) {
                    ControllerLinkManager.this.postErrorEvent(3, iCommandListener);
                    return;
                }
                cqb.m12007b("Switching controller unit to %s", str);
                try {
                    cqb.m12007b("Response from unit change was: %s", ControllerLinkManager.this.sshLink.execute(String.format(Locale.US, "/usr/bin/sololink_config --set-ui-units %s", new Object[]{str})));
                    ControllerLinkManager.this.postSuccessEvent(iCommandListener);
                    ControllerLinkManager.this.setControllerUnit(str);
                } catch (IOException e) {
                    cqb.m12015e(e, "Error occurred while changing controller unit.", new Object[0]);
                    ControllerLinkManager.this.postTimeoutEvent(iCommandListener);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void setControllerUnit(String str) {
        this.controllerUnits.set(str);
        ControllerLinkListener controllerLinkListener = this.linkListener;
        if (controllerLinkListener != null) {
            controllerLinkListener.onControllerUnitUpdated(str);
        }
    }

    public void updateControllerMode(final int i, final ICommandListener iCommandListener) {
        postAsyncTask(new Runnable() {
            public void run() {
                String str;
                cqb.m12007b("Switching controller to mode %d", Integer.valueOf(i));
                try {
                    boolean access$2200 = ControllerLinkManager.this.doesSupportControllerMode();
                    String str2 = access$2200 ? "/usr/bin/sololink_config --set-ui-mode %d" : "runStickMapperMode%d.sh";
                    int i = i;
                    if (i == 1) {
                        str = ControllerLinkManager.this.sshLink.execute(String.format(Locale.US, str2, new Object[]{Integer.valueOf(i)}));
                        ControllerLinkManager.this.postSuccessEvent(iCommandListener);
                    } else if (i != 2) {
                        str = "No response.";
                        ControllerLinkManager.this.postErrorEvent(3, iCommandListener);
                    } else {
                        str = ControllerLinkManager.this.sshLink.execute(String.format(Locale.US, str2, new Object[]{Integer.valueOf(i)}));
                        ControllerLinkManager.this.postSuccessEvent(iCommandListener);
                    }
                    cqb.m12007b("Response from switch mode command was: %s", str);
                    if (access$2200) {
                        ControllerLinkManager.this.setControllerMode(i);
                    }
                } catch (IOException e) {
                    cqb.m12015e(e, "Error occurred while changing controller modes.", new Object[0]);
                    ControllerLinkManager.this.postTimeoutEvent(iCommandListener);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void setControllerMode(int i) {
        this.controllerMode.set(i);
        ControllerLinkListener controllerLinkListener = this.linkListener;
        if (controllerLinkListener != null) {
            controllerLinkListener.onControllerModeUpdated();
        }
    }

    public void setTxPowerComplianceCountry(final String str, final ICommandListener iCommandListener) {
        postAsyncTask(new Runnable() {
            public void run() {
                cqb.m12007b("Enabling %s Tx power compliance mode", str);
                try {
                    if (!ControllerLinkManager.this.sshLink.execute("/usr/bin/sololink_config --get-wifi-country").trim().equals(str)) {
                        SshConnection sshConnection = ControllerLinkManager.this.sshLink;
                        String execute = sshConnection.execute("/usr/bin/sololink_config --set-wifi-country " + str + "; echo $?");
                        if (execute.trim().equals("0")) {
                            ControllerLinkManager.this.restartController();
                            cqb.m12007b("wifi country successfully set, rebooting artoo", new Object[0]);
                            ControllerLinkManager.this.txPowerCompliantCountry.set(str);
                            ControllerLinkManager.this.postSuccessEvent(iCommandListener);
                            return;
                        }
                        cqb.m12007b("wifi country set failed: %s", execute);
                        ControllerLinkManager.this.postErrorEvent(4, iCommandListener);
                    }
                } catch (IOException e) {
                    cqb.m12015e(e, "Error occurred while changing wifi country.", new Object[0]);
                    ControllerLinkManager.this.postTimeoutEvent(iCommandListener);
                }
            }
        });
    }

    private void loadCurrentEUTxPowerComplianceMode() {
        postAsyncTask(this.checkEUTxPowerCompliance);
    }

    private void loadCurrentControllerMode() {
        postAsyncTask(this.artooModeRetriever);
    }

    private void loadControllerUnit() {
        postAsyncTask(this.unitsRetriever);
    }

    /* access modifiers changed from: private */
    public void restartController() {
        try {
            this.sshLink.execute("/usr/bin/sololink_config --reboot");
        } catch (IOException e) {
            cqb.m12015e(e, "Error occurred while restarting hostpad service on Artoo.", new Object[0]);
        }
    }

    public void refreshControllerVersions() {
        updateArtooVersion();
        updateStm32Version();
    }
}

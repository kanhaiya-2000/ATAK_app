package org.droidplanner.services.android.impl.core.drone.autopilot.apm.solo;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import atakplugin.UASTool.cqb;
import com.o3dr.services.android.lib.drone.attribute.AttributeEvent;
import com.o3dr.services.android.lib.drone.companion.solo.SoloEventExtras;
import com.o3dr.services.android.lib.drone.companion.solo.SoloEvents;
import com.o3dr.services.android.lib.drone.companion.solo.button.ButtonPacket;
import com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloButtonSetting;
import com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloButtonSettingSetter;
import com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloGoproState;
import com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloGoproStateV2;
import com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloMessageLocation;
import com.o3dr.services.android.lib.drone.companion.solo.tlv.TLVPacket;
import com.o3dr.services.android.lib.model.ICommandListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.droidplanner.services.android.impl.communication.model.DataLink;
import org.droidplanner.services.android.impl.core.drone.autopilot.apm.solo.controller.ControllerLinkListener;
import org.droidplanner.services.android.impl.core.drone.autopilot.apm.solo.controller.ControllerLinkManager;
import org.droidplanner.services.android.impl.core.drone.autopilot.apm.solo.sololink.SoloLinkListener;
import org.droidplanner.services.android.impl.core.drone.autopilot.apm.solo.sololink.SoloLinkManager;
import org.droidplanner.services.android.impl.utils.NetworkUtils;

public class SoloComp implements ControllerLinkListener, SoloLinkListener {
    public static final String SOLO_LINK_WIFI_PREFIX = "SoloLink_";
    public static final String SSH_PASSWORD = "TjSDBkAu";
    public static final String SSH_USERNAME = "root";
    private final ExecutorService asyncExecutor;
    private SoloCompListener compListener;
    private final Context context;
    /* access modifiers changed from: private */
    public final ControllerLinkManager controllerLinkManager;
    private SoloGoproState goproState;
    private SoloGoproStateV2 goproStateV2;
    private final Handler handler;
    /* access modifiers changed from: private */
    public final SoloLinkManager soloLinkMgr;

    public interface SoloCompListener {
        void onButtonPacketReceived(ButtonPacket buttonPacket);

        void onConnected();

        void onControllerEvent(String str, Bundle bundle);

        void onDisconnected();

        void onPresetButtonLoaded(int i, SoloButtonSetting soloButtonSetting);

        void onTlvPacketReceived(TLVPacket tLVPacket);

        void onTxPowerComplianceCountryUpdated(String str);

        void onVersionsUpdated();

        void onWifiInfoUpdated(String str, String str2);
    }

    public SoloComp(Context context2, Handler handler2, DataLink.DataLinkProvider dataLinkProvider) {
        this.context = context2;
        this.handler = handler2;
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        this.asyncExecutor = newCachedThreadPool;
        this.controllerLinkManager = new ControllerLinkManager(context2, handler2, newCachedThreadPool, dataLinkProvider);
        this.soloLinkMgr = new SoloLinkManager(context2, handler2, newCachedThreadPool, dataLinkProvider);
    }

    public SoloGoproState getGoproState() {
        return this.goproState;
    }

    public SoloGoproStateV2 getGoproStateV2() {
        return this.goproStateV2;
    }

    public boolean hasStreamingPermission() {
        return this.controllerLinkManager.hasStreamingPermission();
    }

    public void setListener(SoloCompListener soloCompListener) {
        this.compListener = soloCompListener;
    }

    public static boolean isAvailable(Context context2) {
        return NetworkUtils.isOnSololinkNetwork(context2);
    }

    public void start() {
        if (isAvailable(this.context)) {
            this.controllerLinkManager.start((ControllerLinkListener) this);
            this.soloLinkMgr.start((SoloLinkListener) this);
        }
    }

    public void stop() {
        this.soloLinkMgr.stop();
        this.controllerLinkManager.stop();
    }

    public void refreshState() {
        this.soloLinkMgr.refreshState();
        this.controllerLinkManager.refreshState();
    }

    public void destroy() {
        stop();
        this.asyncExecutor.shutdownNow();
    }

    public void onTlvPacketReceived(TLVPacket tLVPacket) {
        if (tLVPacket != null) {
            int messageType = tLVPacket.getMessageType();
            if (messageType == 5005) {
                this.goproState = (SoloGoproState) tLVPacket;
                cqb.m12007b("Updated gopro state.", new Object[0]);
            } else if (messageType == 5006) {
                this.goproStateV2 = (SoloGoproStateV2) tLVPacket;
                cqb.m12010c("Updated gopro state.", new Object[0]);
            }
            SoloCompListener soloCompListener = this.compListener;
            if (soloCompListener != null) {
                soloCompListener.onTlvPacketReceived(tLVPacket);
            }
        }
    }

    public void onWifiInfoUpdated(String str, String str2) {
        SoloCompListener soloCompListener = this.compListener;
        if (soloCompListener != null) {
            soloCompListener.onWifiInfoUpdated(str, str2);
        }
    }

    public void onButtonPacketReceived(ButtonPacket buttonPacket) {
        SoloCompListener soloCompListener = this.compListener;
        if (soloCompListener != null) {
            soloCompListener.onButtonPacketReceived(buttonPacket);
        }
    }

    public void onTxPowerComplianceCountryUpdated(String str) {
        SoloCompListener soloCompListener = this.compListener;
        if (soloCompListener != null) {
            soloCompListener.onTxPowerComplianceCountryUpdated(str);
        }
    }

    public void onControllerModeUpdated() {
        if (this.compListener != null) {
            Bundle bundle = new Bundle();
            bundle.putInt(SoloEventExtras.EXTRA_SOLO_CONTROLLER_MODE, getControllerMode());
            this.compListener.onControllerEvent(SoloEvents.SOLO_CONTROLLER_MODE_UPDATED, bundle);
        }
    }

    public void onControllerUnitUpdated(String str) {
        if (this.compListener != null) {
            Bundle bundle = new Bundle();
            bundle.putString(SoloEventExtras.EXTRA_SOLO_CONTROLLER_UNIT, str);
            this.compListener.onControllerEvent(SoloEvents.SOLO_CONTROLLER_UNIT_UPDATED, bundle);
        }
    }

    public void onPresetButtonLoaded(int i, SoloButtonSetting soloButtonSetting) {
        SoloCompListener soloCompListener = this.compListener;
        if (soloCompListener != null) {
            soloCompListener.onPresetButtonLoaded(i, soloButtonSetting);
        }
    }

    public void onLinkConnected() {
        if (isConnected()) {
            SoloCompListener soloCompListener = this.compListener;
            if (soloCompListener != null) {
                soloCompListener.onConnected();
                return;
            }
            return;
        }
        if (!this.controllerLinkManager.isLinkConnected()) {
            this.controllerLinkManager.start((ControllerLinkListener) this);
        }
        if (!this.soloLinkMgr.isLinkConnected()) {
            this.soloLinkMgr.start((SoloLinkListener) this);
        }
    }

    public void onLinkDisconnected() {
        SoloCompListener soloCompListener = this.compListener;
        if (soloCompListener != null) {
            soloCompListener.onDisconnected();
        }
        this.soloLinkMgr.stop();
        this.controllerLinkManager.stop();
    }

    public void onVersionsUpdated() {
        SoloCompListener soloCompListener = this.compListener;
        if (soloCompListener != null) {
            soloCompListener.onVersionsUpdated();
        }
    }

    public void onMacAddressUpdated() {
        SoloCompListener soloCompListener;
        String macAddress = this.soloLinkMgr.getMacAddress();
        String macAddress2 = this.controllerLinkManager.getMacAddress();
        if (!TextUtils.isEmpty(macAddress) && !TextUtils.isEmpty(macAddress2) && (soloCompListener = this.compListener) != null) {
            soloCompListener.onControllerEvent(AttributeEvent.STATE_VEHICLE_UID, (Bundle) null);
        }
    }

    public boolean isConnected() {
        return this.controllerLinkManager.isLinkConnected() && this.soloLinkMgr.isLinkConnected();
    }

    public Pair<String, String> getWifiSettings() {
        return this.controllerLinkManager.getSoloLinkWifiInfo();
    }

    public String getTxPowerCompliantCountry() {
        return this.controllerLinkManager.getTxPowerCompliantCountry();
    }

    public void refreshSoloVersions() {
        this.soloLinkMgr.refreshSoloLinkVersions();
        this.controllerLinkManager.refreshControllerVersions();
    }

    public String getControllerVersion() {
        return this.controllerLinkManager.getArtooVersion();
    }

    public String getControllerFirmwareVersion() {
        return this.controllerLinkManager.getStm32Version();
    }

    public String getVehicleVersion() {
        return this.soloLinkMgr.getVehicleVersion();
    }

    public int getControllerMode() {
        return this.controllerLinkManager.getControllerMode();
    }

    public String getControllerUnit() {
        return this.controllerLinkManager.getControllerUnit();
    }

    public String getSoloMacAddress() {
        return this.soloLinkMgr.getMacAddress();
    }

    public String getControllerMacAddress() {
        return this.controllerLinkManager.getMacAddress();
    }

    public String getAutopilotVersion() {
        return this.soloLinkMgr.getPixhawkVersion();
    }

    public String getGimbalVersion() {
        return this.soloLinkMgr.getGimbalVersion();
    }

    public SoloButtonSetting getButtonSetting(int i) {
        return this.soloLinkMgr.getLoadedPresetButton(i);
    }

    public SparseArray<SoloButtonSetting> getButtonSettings() {
        SparseArray<SoloButtonSetting> sparseArray = new SparseArray<>(2);
        sparseArray.append(4, this.soloLinkMgr.getLoadedPresetButton(4));
        sparseArray.append(5, this.soloLinkMgr.getLoadedPresetButton(5));
        return sparseArray;
    }

    public void sendSoloLinkMessage(TLVPacket tLVPacket, ICommandListener iCommandListener) {
        this.soloLinkMgr.sendTLVPacket(tLVPacket, iCommandListener);
    }

    public void updateWifiSettings(final String str, final String str2, final ICommandListener iCommandListener) {
        postAsyncTask(new Runnable() {
            public void run() {
                if (!SoloComp.this.soloLinkMgr.updateSololinkWifi(str, str2) || !SoloComp.this.controllerLinkManager.updateSololinkWifi(str, str2)) {
                    cqb.m12007b("Sololink wifi update failed.", new Object[0]);
                    ICommandListener iCommandListener = iCommandListener;
                    if (iCommandListener != null) {
                        SoloComp.this.postErrorEvent(4, iCommandListener);
                        return;
                    }
                    return;
                }
                cqb.m12007b("Sololink wifi update successful.", new Object[0]);
                ICommandListener iCommandListener2 = iCommandListener;
                if (iCommandListener2 != null) {
                    SoloComp.this.postSuccessEvent(iCommandListener2);
                }
            }
        });
    }

    public void pushButtonSettings(SoloButtonSettingSetter soloButtonSettingSetter, ICommandListener iCommandListener) {
        this.soloLinkMgr.pushPresetButtonSettings(soloButtonSettingSetter, iCommandListener);
    }

    public void updateControllerMode(int i, ICommandListener iCommandListener) {
        this.controllerLinkManager.updateControllerMode(i, iCommandListener);
    }

    public void updateControllerUnit(String str, ICommandListener iCommandListener) {
        this.controllerLinkManager.updateControllerUnit(str, iCommandListener);
    }

    public void updateTxPowerComplianceCountry(String str, ICommandListener iCommandListener) {
        this.controllerLinkManager.setTxPowerComplianceCountry(str, iCommandListener);
    }

    /* access modifiers changed from: protected */
    public void postAsyncTask(Runnable runnable) {
        ExecutorService executorService = this.asyncExecutor;
        if (executorService != null && !executorService.isShutdown()) {
            this.asyncExecutor.execute(runnable);
        }
    }

    /* access modifiers changed from: protected */
    public void postSuccessEvent(final ICommandListener iCommandListener) {
        Handler handler2 = this.handler;
        if (handler2 != null && iCommandListener != null) {
            handler2.post(new Runnable() {
                public void run() {
                    try {
                        iCommandListener.onSuccess();
                    } catch (RemoteException e) {
                        cqb.m12015e(e, e.getMessage(), new Object[0]);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void postTimeoutEvent(final ICommandListener iCommandListener) {
        Handler handler2 = this.handler;
        if (handler2 != null && iCommandListener != null) {
            handler2.post(new Runnable() {
                public void run() {
                    try {
                        iCommandListener.onTimeout();
                    } catch (RemoteException e) {
                        cqb.m12015e(e, e.getMessage(), new Object[0]);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void postErrorEvent(final int i, final ICommandListener iCommandListener) {
        Handler handler2 = this.handler;
        if (handler2 != null && iCommandListener != null) {
            handler2.post(new Runnable() {
                public void run() {
                    try {
                        iCommandListener.onError(i);
                    } catch (RemoteException e) {
                        cqb.m12015e(e, e.getMessage(), new Object[0]);
                    }
                }
            });
        }
    }

    public void enableFollowDataConnection() {
        this.soloLinkMgr.enableFollowDataConnection();
    }

    public void disableFollowDataConnection() {
        this.soloLinkMgr.disableFollowDataConnection();
    }

    public void updateFollowCenter(SoloMessageLocation soloMessageLocation) {
        this.soloLinkMgr.sendTLVPacket(soloMessageLocation, true, (ICommandListener) null);
    }
}

package org.droidplanner.services.android.impl.core.drone.autopilot.apm.solo;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.Surface;
import atakplugin.UASTool.cqb;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.common.msg_statustext;
import com.o3dr.android.client.apis.CapabilityApi;
import com.o3dr.services.android.lib.drone.attribute.AttributeEvent;
import com.o3dr.services.android.lib.drone.attribute.AttributeType;
import com.o3dr.services.android.lib.drone.companion.solo.SoloAttributes;
import com.o3dr.services.android.lib.drone.companion.solo.SoloEventExtras;
import com.o3dr.services.android.lib.drone.companion.solo.SoloEvents;
import com.o3dr.services.android.lib.drone.companion.solo.action.SoloActions;
import com.o3dr.services.android.lib.drone.companion.solo.action.SoloConfigActions;
import com.o3dr.services.android.lib.drone.companion.solo.button.ButtonPacket;
import com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloButtonSetting;
import com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloButtonSettingSetter;
import com.o3dr.services.android.lib.drone.companion.solo.tlv.TLVPacket;
import com.o3dr.services.android.lib.drone.property.DroneAttribute;
import com.o3dr.services.android.lib.drone.property.State;
import com.o3dr.services.android.lib.model.ICommandListener;
import com.o3dr.services.android.lib.model.action.Action;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.droidplanner.services.android.impl.communication.model.DataLink;
import org.droidplanner.services.android.impl.core.drone.DroneInterfaces;
import org.droidplanner.services.android.impl.core.drone.LogMessageListener;
import org.droidplanner.services.android.impl.core.drone.autopilot.apm.ArduCopter;
import org.droidplanner.services.android.impl.core.drone.autopilot.apm.solo.SoloComp;
import org.droidplanner.services.android.impl.core.drone.variables.ApmModes;
import org.droidplanner.services.android.impl.core.drone.variables.HeartBeat;
import org.droidplanner.services.android.impl.core.drone.variables.StreamRates;
import org.droidplanner.services.android.impl.core.firmware.FirmwareType;
import org.droidplanner.services.android.impl.core.model.AutopilotWarningParser;
import org.droidplanner.services.android.impl.utils.SoloApiUtils;

public class ArduSolo extends ArduCopter {
    private static final Pattern PIXHAWK_SERIAL_NUMBER_PATTERN = Pattern.compile(PIXHAWK_SERIAL_NUMBER_REGEX);
    private static final String PIXHAWK_SERIAL_NUMBER_REGEX = ".*PX4v2 (([0-9A-F]{8}) ([0-9A-F]{8}) ([0-9A-F]{8}))";
    private static final String SERIAL_NUMBER_LABEL = "serial_number";
    /* access modifiers changed from: private */
    public final Runnable disconnectSoloCompTask = new Runnable() {
        public void run() {
            if (ArduSolo.this.soloComp.isConnected()) {
                ArduSolo.this.soloComp.stop();
            }
            ArduSolo.this.handler.removeCallbacks(ArduSolo.this.disconnectSoloCompTask);
        }
    };
    private String pixhawkSerialNumber;
    /* access modifiers changed from: private */
    public final SoloComp soloComp;

    public StreamRates getStreamRates() {
        return null;
    }

    public int getType() {
        return 2;
    }

    public void setType(int i) {
    }

    public ArduSolo(String str, Context context, DataLink.DataLinkProvider<MAVLinkMessage> dataLinkProvider, Handler handler, AutopilotWarningParser autopilotWarningParser, LogMessageListener logMessageListener) {
        super(str, context, dataLinkProvider, handler, autopilotWarningParser, logMessageListener);
        SoloComp soloComp2 = new SoloComp(context, handler, dataLinkProvider);
        this.soloComp = soloComp2;
        soloComp2.setListener(new SoloComp.SoloCompListener() {
            public void onConnected() {
                if (ArduSolo.this.isConnected()) {
                    ArduSolo.this.notifyDroneEvent(DroneInterfaces.DroneEventsType.CONNECTED);
                }
            }

            public void onDisconnected() {
                ArduSolo.this.notifyDroneEvent(DroneInterfaces.DroneEventsType.DISCONNECTED);
            }

            public void onTlvPacketReceived(TLVPacket tLVPacket) {
                int messageType = tLVPacket.getMessageType();
                if (messageType != 5 && messageType != 6 && messageType != 2003) {
                    if (messageType == 5005) {
                        ArduSolo.this.notifyAttributeListener(SoloEvents.SOLO_GOPRO_STATE_UPDATED);
                    } else if (messageType != 5006) {
                        Bundle bundle = new Bundle();
                        bundle.putParcelable(SoloEventExtras.EXTRA_SOLO_MESSAGE_DATA, tLVPacket);
                        ArduSolo.this.notifyAttributeListener(SoloEvents.SOLO_MESSAGE_RECEIVED, bundle);
                    } else {
                        ArduSolo.this.notifyAttributeListener(SoloEvents.SOLO_GOPRO_STATE_V2_UPDATED);
                    }
                }
            }

            public void onPresetButtonLoaded(int i, SoloButtonSetting soloButtonSetting) {
                ArduSolo.this.notifyAttributeListener(SoloEvents.SOLO_BUTTON_SETTINGS_UPDATED, (Bundle) null);
            }

            public void onWifiInfoUpdated(String str, String str2) {
                ArduSolo.this.notifyAttributeListener(SoloEvents.SOLO_WIFI_SETTINGS_UPDATED, (Bundle) null);
            }

            public void onButtonPacketReceived(ButtonPacket buttonPacket) {
                Bundle bundle = new Bundle();
                bundle.putParcelable(SoloEventExtras.EXTRA_SOLO_BUTTON_EVENT, buttonPacket);
                ArduSolo.this.notifyAttributeListener(SoloEvents.SOLO_BUTTON_EVENT_RECEIVED, bundle);
            }

            public void onTxPowerComplianceCountryUpdated(String str) {
                Bundle bundle = new Bundle(1);
                bundle.putString(SoloEventExtras.EXTRA_SOLO_TX_POWER_COMPLIANT_COUNTRY, str);
                ArduSolo.this.notifyAttributeListener(SoloEvents.SOLO_TX_POWER_COMPLIANCE_COUNTRY_UPDATED, bundle);
            }

            public void onVersionsUpdated() {
                Bundle bundle = new Bundle();
                bundle.putString(SoloEventExtras.EXTRA_SOLO_VEHICLE_VERSION, ArduSolo.this.soloComp.getVehicleVersion());
                bundle.putString(SoloEventExtras.EXTRA_SOLO_AUTOPILOT_VERSION, ArduSolo.this.soloComp.getAutopilotVersion());
                bundle.putString(SoloEventExtras.EXTRA_SOLO_GIMBAL_VERSION, ArduSolo.this.soloComp.getGimbalVersion());
                bundle.putString(SoloEventExtras.EXTRA_SOLO_CONTROLLER_VERSION, ArduSolo.this.soloComp.getControllerVersion());
                bundle.putString(SoloEventExtras.EXTRA_SOLO_CONTROLLER_FIRMWARE_VERSION, ArduSolo.this.soloComp.getControllerFirmwareVersion());
                ArduSolo.this.notifyAttributeListener(SoloEvents.SOLO_VERSIONS_UPDATED, bundle);
            }

            public void onControllerEvent(String str, Bundle bundle) {
                ArduSolo.this.notifyAttributeListener(str, bundle);
            }
        });
    }

    public void destroy() {
        super.destroy();
        this.soloComp.destroy();
    }

    public SoloComp getSoloComp() {
        return this.soloComp;
    }

    public FirmwareType getFirmwareType() {
        return FirmwareType.ARDU_SOLO;
    }

    public boolean isConnected() {
        return this.soloComp.isConnected() && super.isConnected();
    }

    public DroneAttribute getAttribute(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1702436682:
                if (str.equals(AttributeType.STATE)) {
                    c = 0;
                    break;
                }
                break;
            case -1614425999:
                if (str.equals(SoloAttributes.SOLO_STATE)) {
                    c = 1;
                    break;
                }
                break;
            case -430574716:
                if (str.equals(SoloAttributes.SOLO_GOPRO_STATE_V2)) {
                    c = 2;
                    break;
                }
                break;
            case 968230999:
                if (str.equals(SoloAttributes.SOLO_GOPRO_STATE)) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                State state = (State) super.getAttribute(str);
                state.addToVehicleUid(SERIAL_NUMBER_LABEL, this.pixhawkSerialNumber);
                state.addToVehicleUid("solo_mac_address", this.soloComp.getSoloMacAddress());
                state.addToVehicleUid("controller_mac_address", this.soloComp.getControllerMacAddress());
                return state;
            case 1:
                return SoloApiUtils.getSoloLinkState(this);
            case 2:
                return this.soloComp.getGoproStateV2();
            case 3:
                return this.soloComp.getGoproState();
            default:
                return super.getAttribute(str);
        }
    }

    /* access modifiers changed from: protected */
    public void resetVideoManager() {
        this.videoMgr.reset();
    }

    public void startVideoStream(Bundle bundle, String str, String str2, Surface surface, ICommandListener iCommandListener) {
        if (!this.soloComp.hasStreamingPermission()) {
            postErrorEvent(2, iCommandListener);
        } else {
            super.startVideoStream(bundle, str, str2, surface, iCommandListener);
        }
    }

    /* access modifiers changed from: protected */
    public void postErrorEvent(final int i, final ICommandListener iCommandListener) {
        if (this.handler != null && iCommandListener != null) {
            this.handler.post(new Runnable() {
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

    /* renamed from: org.droidplanner.services.android.impl.core.drone.autopilot.apm.solo.ArduSolo$4 */
    /* synthetic */ class C59454 {

        /* renamed from: $SwitchMap$org$droidplanner$services$android$impl$core$drone$DroneInterfaces$DroneEventsType */
        static final /* synthetic */ int[] f8623x7e1461ff;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType[] r0 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8623x7e1461ff = r0
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r1 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.HEARTBEAT_FIRST     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8623x7e1461ff     // Catch:{ NoSuchFieldError -> 0x001d }
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r1 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.CONNECTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f8623x7e1461ff     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r1 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.DISCONNECTED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f8623x7e1461ff     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r1 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.HEARTBEAT_TIMEOUT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f8623x7e1461ff     // Catch:{ NoSuchFieldError -> 0x003e }
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r1 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.HEARTBEAT_RESTORED     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.droidplanner.services.android.impl.core.drone.autopilot.apm.solo.ArduSolo.C59454.<clinit>():void");
        }
    }

    public void notifyDroneEvent(DroneInterfaces.DroneEventsType droneEventsType) {
        int i = C59454.f8623x7e1461ff[droneEventsType.ordinal()];
        if (i == 1 || i == 2) {
            cqb.m12010c("Vehicle " + droneEventsType.name().toLowerCase(), new Object[0]);
            if (!this.soloComp.isConnected()) {
                resetVideoManager();
                this.soloComp.start();
                return;
            }
        } else if (i == 3) {
            cqb.m12010c("Vehicle disconnected.", new Object[0]);
            if (this.soloComp.isConnected()) {
                this.soloComp.stop();
                resetVideoManager();
                return;
            }
        } else if (i == 4) {
            cqb.m12010c("Vehicle heartbeat timed out.", new Object[0]);
            if (this.soloComp.isConnected()) {
                this.handler.postDelayed(this.disconnectSoloCompTask, HeartBeat.HEARTBEAT_NORMAL_TIMEOUT);
            }
        } else if (i == 5) {
            cqb.m12010c("Vehicle heartbeat restored.", new Object[0]);
            this.handler.removeCallbacks(this.disconnectSoloCompTask);
            if (!this.soloComp.isConnected()) {
                this.soloComp.start();
            } else {
                this.soloComp.refreshState();
            }
        }
        super.notifyDroneEvent(droneEventsType);
    }

    public boolean executeAsyncAction(Action action, ICommandListener iCommandListener) {
        String type = action.getType();
        Bundle data = action.getData();
        type.hashCode();
        char c = 65535;
        switch (type.hashCode()) {
            case -313014253:
                if (type.equals(SoloConfigActions.ACTION_UPDATE_TX_POWER_COMPLIANCE_COUNTRY)) {
                    c = 0;
                    break;
                }
                break;
            case 322656860:
                if (type.equals(SoloConfigActions.ACTION_UPDATE_BUTTON_SETTINGS)) {
                    c = 1;
                    break;
                }
                break;
            case 1603505141:
                if (type.equals(SoloConfigActions.ACTION_REFRESH_SOLO_VERSIONS)) {
                    c = 2;
                    break;
                }
                break;
            case 1656757298:
                if (type.equals(SoloConfigActions.ACTION_UPDATE_CONTROLLER_MODE)) {
                    c = 3;
                    break;
                }
                break;
            case 1656994835:
                if (type.equals(SoloConfigActions.ACTION_UPDATE_CONTROLLER_UNIT)) {
                    c = 4;
                    break;
                }
                break;
            case 2092562522:
                if (type.equals(SoloActions.ACTION_SEND_MESSAGE)) {
                    c = 5;
                    break;
                }
                break;
            case 2136015065:
                if (type.equals(SoloConfigActions.ACTION_UPDATE_WIFI_SETTINGS)) {
                    c = 6;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                SoloApiUtils.updateSoloLinkTxPowerComplianceCountry(this, data.getString(SoloConfigActions.EXTRA_TX_POWER_COMPLIANT_COUNTRY_CODE), iCommandListener);
                return true;
            case 1:
                SoloButtonSettingSetter soloButtonSettingSetter = (SoloButtonSettingSetter) data.getParcelable(SoloConfigActions.EXTRA_BUTTON_SETTINGS);
                if (soloButtonSettingSetter != null) {
                    SoloApiUtils.updateSoloLinkButtonSettings(this, soloButtonSettingSetter, iCommandListener);
                }
                return true;
            case 2:
                this.soloComp.refreshSoloVersions();
                return true;
            case 3:
                SoloApiUtils.updateSoloLinkControllerMode(this, data.getInt(SoloConfigActions.EXTRA_CONTROLLER_MODE), iCommandListener);
                return true;
            case 4:
                SoloApiUtils.updateSoloControllerUnit(this, data.getString(SoloConfigActions.EXTRA_CONTROLLER_UNIT), iCommandListener);
                return true;
            case 5:
                TLVPacket tLVPacket = (TLVPacket) data.getParcelable(SoloActions.EXTRA_MESSAGE_DATA);
                if (tLVPacket != null) {
                    SoloApiUtils.sendSoloLinkMessage(this, tLVPacket, iCommandListener);
                }
                return true;
            case 6:
                SoloApiUtils.updateSoloLinkWifiSettings(this, data.getString(SoloConfigActions.EXTRA_WIFI_SSID), data.getString(SoloConfigActions.EXTRA_WIFI_PASSWORD), iCommandListener);
                return true;
            default:
                return super.executeAsyncAction(action, iCommandListener);
        }
    }

    /* access modifiers changed from: protected */
    public boolean isFeatureSupported(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case 445623148:
                if (str.equals(CapabilityApi.FeatureIds.KILL_SWITCH)) {
                    c = 0;
                    break;
                }
                break;
            case 960109428:
                if (str.equals(CapabilityApi.FeatureIds.COMPASS_CALIBRATION)) {
                    c = 1;
                    break;
                }
                break;
            case 1572072423:
                if (str.equals(CapabilityApi.FeatureIds.SOLO_VIDEO_STREAMING)) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
                return true;
            default:
                return super.isFeatureSupported(str);
        }
    }

    /* access modifiers changed from: protected */
    public void processSignalUpdate(int i, int i2, short s, short s2, short s3, short s4, short s5) {
        double d = (double) (s2 & 255);
        this.signal.setValid(true);
        this.signal.setRxerrors(i & 65535);
        this.signal.setFixed(i2 & 65535);
        this.signal.setRssi((double) (s & 255));
        this.signal.setRemrssi(d);
        this.signal.setNoise((double) (s4 & 255));
        this.signal.setRemnoise((double) (s5 & 255));
        this.signal.setTxbuf(s3 & 255);
        if (d > 127.0d) {
            d -= 256.0d;
        }
        this.signal.setSignalStrength(d);
        notifyDroneEvent(DroneInterfaces.DroneEventsType.RADIO);
    }

    /* access modifiers changed from: protected */
    public void processStatusText(msg_statustext msg_statustext) {
        super.processStatusText(msg_statustext);
        String text = msg_statustext.getText();
        if (!TextUtils.isEmpty(text)) {
            Matcher matcher = PIXHAWK_SERIAL_NUMBER_PATTERN.matcher(text);
            if (matcher.matches()) {
                cqb.m12010c("Received serial number: %s", text);
                String str = matcher.group(2) + matcher.group(3) + matcher.group(4);
                if (!str.equalsIgnoreCase(this.pixhawkSerialNumber)) {
                    this.pixhawkSerialNumber = str;
                    notifyAttributeListener(AttributeEvent.STATE_VEHICLE_UID);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean brakeVehicle(ICommandListener iCommandListener) {
        getState().changeFlightMode(ApmModes.ROTOR_BRAKE, iCommandListener);
        return true;
    }
}

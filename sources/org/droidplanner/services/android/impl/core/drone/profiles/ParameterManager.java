package org.droidplanner.services.android.impl.core.drone.profiles;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseBooleanArray;
import atakplugin.UASTool.cqb;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.common.msg_param_value;
import com.o3dr.services.android.lib.drone.property.Parameter;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.droidplanner.services.android.impl.core.MAVLink.MavLinkParameters;
import org.droidplanner.services.android.impl.core.drone.DroneInterfaces;
import org.droidplanner.services.android.impl.core.drone.DroneVariable;
import org.droidplanner.services.android.impl.core.drone.autopilot.MavLinkDrone;
import org.droidplanner.services.android.impl.utils.file.p013IO.ParameterMetadataLoader;

public class ParameterManager extends DroneVariable<MavLinkDrone> implements DroneInterfaces.OnDroneListener<MavLinkDrone> {
    private static final long TIMEOUT = 1000;
    private final Context context;
    private int expectedParams;
    private final AtomicBoolean isRefreshing = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public DroneInterfaces.OnParameterManagerListener parameterListener;
    private final ConcurrentHashMap<String, Parameter> parameters = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, ParameterMetadata> parametersMetadata = new ConcurrentHashMap<>();
    private final Runnable parametersReceiptEndNotification = new Runnable() {
        public void run() {
            if (ParameterManager.this.parameterListener != null) {
                ParameterManager.this.parameterListener.onEndReceivingParameters();
            }
        }
    };
    private final Runnable parametersReceiptStartNotification = new Runnable() {
        public void run() {
            if (ParameterManager.this.parameterListener != null) {
                ParameterManager.this.parameterListener.onBeginReceivingParameters();
            }
        }
    };
    private final SparseBooleanArray paramsRollCall = new SparseBooleanArray();
    private final ConcurrentLinkedQueue<String> paramsToReadFromVehicle = new ConcurrentLinkedQueue<>();
    private final Handler watchdog;
    public final Runnable watchdogCallback = new Runnable() {
        public void run() {
            ParameterManager.this.onParameterStreamStopped();
        }
    };

    public ParameterManager(MavLinkDrone mavLinkDrone, Context context2, Handler handler) {
        super(mavLinkDrone);
        this.context = context2;
        this.watchdog = handler;
        mavLinkDrone.addDroneListener(this);
        refreshParametersMetadata();
    }

    public void refreshParameters() {
        if (this.isRefreshing.compareAndSet(false, true)) {
            this.paramsToReadFromVehicle.clear();
            this.expectedParams = 0;
            this.parameters.clear();
            this.paramsRollCall.clear();
            notifyParametersReceiptStart();
            MavLinkParameters.requestParametersList(this.myDrone);
            resetWatchdog();
        }
    }

    public Map<String, Parameter> getParameters() {
        if (this.parameters.isEmpty()) {
            refreshParameters();
        }
        return this.parameters;
    }

    public boolean processMessage(MAVLinkMessage mAVLinkMessage) {
        if (mAVLinkMessage.msgid != 22) {
            return false;
        }
        processReceivedParam((msg_param_value) mAVLinkMessage);
        return true;
    }

    /* access modifiers changed from: protected */
    public void processReceivedParam(msg_param_value msg_param_value) {
        String param_Id = msg_param_value.getParam_Id();
        if (this.paramsToReadFromVehicle.remove(param_Id) || this.isRefreshing.get()) {
            Parameter parameter = new Parameter(param_Id, (double) msg_param_value.param_value, msg_param_value.param_type);
            loadParameterMetadata(parameter);
            int i = msg_param_value.param_index;
            this.parameters.put(parameter.getName().toLowerCase(Locale.US), parameter);
            if (i == -1) {
                notifyParameterReceipt(parameter, 0, 1);
                notifyParametersReceiptEnd();
                return;
            }
            this.paramsRollCall.append(i, true);
            this.expectedParams = msg_param_value.param_count;
            notifyParameterReceipt(parameter, i, msg_param_value.param_count);
            if (this.parameters.size() >= msg_param_value.param_count) {
                if (this.isRefreshing.compareAndSet(true, false)) {
                    killWatchdog();
                }
                notifyParametersReceiptEnd();
                return;
            }
            resetWatchdog();
        }
    }

    private void reRequestMissingParams(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (!this.paramsRollCall.get(i2)) {
                MavLinkParameters.readParameter(this.myDrone, i2);
            }
        }
    }

    public void sendParameter(Parameter parameter) {
        this.paramsToReadFromVehicle.add(parameter.getName());
        MavLinkParameters.sendParameter(this.myDrone, parameter);
    }

    public void readParameter(String str) {
        this.paramsToReadFromVehicle.add(str);
        MavLinkParameters.readParameter(this.myDrone, str);
    }

    public Parameter getParameter(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.parameters.get(str.toLowerCase(Locale.US));
    }

    /* access modifiers changed from: private */
    public void onParameterStreamStopped() {
        int i = this.expectedParams;
        if (i > 0) {
            reRequestMissingParams(i);
            resetWatchdog();
            return;
        }
        this.isRefreshing.set(false);
    }

    private void resetWatchdog() {
        this.watchdog.removeCallbacks(this.watchdogCallback);
        this.watchdog.postDelayed(this.watchdogCallback, TIMEOUT);
    }

    private void killWatchdog() {
        this.watchdog.removeCallbacks(this.watchdogCallback);
        this.isRefreshing.set(false);
    }

    /* renamed from: org.droidplanner.services.android.impl.core.drone.profiles.ParameterManager$5 */
    /* synthetic */ class C59775 {

        /* renamed from: $SwitchMap$org$droidplanner$services$android$impl$core$drone$DroneInterfaces$DroneEventsType */
        static final /* synthetic */ int[] f8628x7e1461ff;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType[] r0 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8628x7e1461ff = r0
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r1 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.HEARTBEAT_FIRST     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8628x7e1461ff     // Catch:{ NoSuchFieldError -> 0x001d }
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r1 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.DISCONNECTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f8628x7e1461ff     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r1 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.HEARTBEAT_TIMEOUT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f8628x7e1461ff     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r1 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.TYPE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.droidplanner.services.android.impl.core.drone.profiles.ParameterManager.C59775.<clinit>():void");
        }
    }

    public void onDroneEvent(DroneInterfaces.DroneEventsType droneEventsType, MavLinkDrone mavLinkDrone) {
        int i = C59775.f8628x7e1461ff[droneEventsType.ordinal()];
        if (i == 1) {
            refreshParameters();
        } else if (i == 2 || i == 3) {
            killWatchdog();
        } else if (i == 4) {
            refreshParametersMetadata();
        }
    }

    private void refreshParametersMetadata() {
        String parameterMetadataGroup = this.myDrone.getFirmwareType().getParameterMetadataGroup();
        if (!TextUtils.isEmpty(parameterMetadataGroup)) {
            try {
                ParameterMetadataLoader.load(this.context, parameterMetadataGroup, this.parametersMetadata);
            } catch (Exception e) {
                cqb.m12015e(e, e.getMessage(), new Object[0]);
            }
        }
        if (!this.parametersMetadata.isEmpty() && !this.parameters.isEmpty()) {
            for (Parameter loadParameterMetadata : this.parameters.values()) {
                loadParameterMetadata(loadParameterMetadata);
            }
        }
    }

    private void loadParameterMetadata(Parameter parameter) {
        ParameterMetadata parameterMetadata = this.parametersMetadata.get(parameter.getName());
        if (parameterMetadata != null) {
            parameter.setDisplayName(parameterMetadata.getDisplayName());
            parameter.setDescription(parameterMetadata.getDescription());
            parameter.setUnits(parameterMetadata.getUnits());
            parameter.setRange(parameterMetadata.getRange());
            parameter.setValues(parameterMetadata.getValues());
        }
    }

    public void setParameterListener(DroneInterfaces.OnParameterManagerListener onParameterManagerListener) {
        this.parameterListener = onParameterManagerListener;
    }

    private void notifyParametersReceiptStart() {
        if (this.parameterListener != null) {
            this.watchdog.post(this.parametersReceiptStartNotification);
        }
    }

    private void notifyParametersReceiptEnd() {
        if (this.parameterListener != null) {
            this.watchdog.post(this.parametersReceiptEndNotification);
        }
    }

    private void notifyParameterReceipt(final Parameter parameter, final int i, final int i2) {
        if (this.parameterListener != null) {
            this.watchdog.post(new Runnable() {
                public void run() {
                    if (ParameterManager.this.parameterListener != null) {
                        ParameterManager.this.parameterListener.onParameterReceived(parameter, i, i2);
                    }
                }
            });
        }
    }
}

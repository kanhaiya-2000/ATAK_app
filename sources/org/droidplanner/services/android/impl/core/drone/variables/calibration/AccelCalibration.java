package org.droidplanner.services.android.impl.core.drone.variables.calibration;

import android.os.Handler;
import android.os.RemoteException;
import atakplugin.UASTool.cqb;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.common.msg_statustext;
import com.o3dr.services.android.lib.model.ICommandListener;
import com.o3dr.services.android.lib.model.SimpleCommandListener;
import java.util.concurrent.atomic.AtomicReference;
import org.droidplanner.services.android.impl.core.MAVLink.MavLinkCalibration;
import org.droidplanner.services.android.impl.core.drone.DroneInterfaces;
import org.droidplanner.services.android.impl.core.drone.DroneVariable;
import org.droidplanner.services.android.impl.core.drone.autopilot.MavLinkDrone;

public class AccelCalibration extends DroneVariable implements DroneInterfaces.OnDroneListener<MavLinkDrone> {
    private boolean calibrating;
    private final Handler handler;
    /* access modifiers changed from: private */
    public final AtomicReference<ICommandListener> listenerRef = new AtomicReference<>((Object) null);
    private String mavMsg;
    private final Runnable onCalibrationStart = new Runnable() {
        public void run() {
            ICommandListener iCommandListener = (ICommandListener) AccelCalibration.this.listenerRef.getAndSet((Object) null);
            if (iCommandListener != null) {
                try {
                    iCommandListener.onSuccess();
                } catch (RemoteException e) {
                    cqb.m12015e(e, e.getMessage(), new Object[0]);
                }
            }
        }
    };

    public AccelCalibration(MavLinkDrone mavLinkDrone, Handler handler2) {
        super(mavLinkDrone);
        this.handler = handler2;
        mavLinkDrone.addDroneListener(this);
    }

    public void startCalibration(ICommandListener iCommandListener) {
        if (this.calibrating) {
            if (iCommandListener != null) {
                try {
                    iCommandListener.onSuccess();
                } catch (RemoteException e) {
                    cqb.m12015e(e, e.getMessage(), new Object[0]);
                }
            }
        } else if (this.myDrone.getState().isFlying()) {
            this.calibrating = false;
        } else {
            this.calibrating = true;
            this.mavMsg = "";
            this.listenerRef.set(iCommandListener);
            MavLinkCalibration.startAccelerometerCalibration(this.myDrone, new SimpleCommandListener() {
                public void onSuccess() {
                    ICommandListener iCommandListener = (ICommandListener) AccelCalibration.this.listenerRef.getAndSet((Object) null);
                    if (iCommandListener != null) {
                        try {
                            iCommandListener.onSuccess();
                        } catch (RemoteException e) {
                            cqb.m12015e(e, e.getMessage(), new Object[0]);
                        }
                    }
                }

                public void onError(int i) {
                    ICommandListener iCommandListener = (ICommandListener) AccelCalibration.this.listenerRef.getAndSet((Object) null);
                    if (iCommandListener != null) {
                        try {
                            iCommandListener.onError(i);
                        } catch (RemoteException e) {
                            cqb.m12015e(e, e.getMessage(), new Object[0]);
                        }
                    }
                }

                public void onTimeout() {
                    ICommandListener iCommandListener = (ICommandListener) AccelCalibration.this.listenerRef.getAndSet((Object) null);
                    if (iCommandListener != null) {
                        try {
                            iCommandListener.onTimeout();
                        } catch (RemoteException e) {
                            cqb.m12015e(e, e.getMessage(), new Object[0]);
                        }
                    }
                }
            });
        }
    }

    public void sendAck(int i) {
        if (this.calibrating) {
            MavLinkCalibration.sendCalibrationAckMessage(this.myDrone, i);
        }
    }

    public void processMessage(MAVLinkMessage mAVLinkMessage) {
        String text;
        if (this.calibrating && mAVLinkMessage.msgid == 253 && (text = ((msg_statustext) mAVLinkMessage).getText()) != null) {
            if (text.startsWith("Place vehicle") || text.startsWith("Calibration")) {
                this.handler.post(this.onCalibrationStart);
                this.mavMsg = text;
                if (text.startsWith("Calibration")) {
                    this.calibrating = false;
                }
                this.myDrone.notifyDroneEvent(DroneInterfaces.DroneEventsType.CALIBRATION_IMU);
            }
        }
    }

    public String getMessage() {
        return this.mavMsg;
    }

    public boolean isCalibrating() {
        return this.calibrating;
    }

    /* renamed from: org.droidplanner.services.android.impl.core.drone.variables.calibration.AccelCalibration$3 */
    /* synthetic */ class C59933 {

        /* renamed from: $SwitchMap$org$droidplanner$services$android$impl$core$drone$DroneInterfaces$DroneEventsType */
        static final /* synthetic */ int[] f8638x7e1461ff;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType[] r0 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8638x7e1461ff = r0
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r1 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.HEARTBEAT_TIMEOUT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8638x7e1461ff     // Catch:{ NoSuchFieldError -> 0x001d }
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r1 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.DISCONNECTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.droidplanner.services.android.impl.core.drone.variables.calibration.AccelCalibration.C59933.<clinit>():void");
        }
    }

    public void onDroneEvent(DroneInterfaces.DroneEventsType droneEventsType, MavLinkDrone mavLinkDrone) {
        int i = C59933.f8638x7e1461ff[droneEventsType.ordinal()];
        if ((i == 1 || i == 2) && this.calibrating) {
            cancelCalibration();
        }
    }

    public void cancelCalibration() {
        this.mavMsg = "";
        this.calibrating = false;
    }
}

package org.droidplanner.services.android.impl.core.drone.variables.calibration;

import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_mag_cal_progress;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_mag_cal_report;
import com.o3dr.services.android.lib.model.ICommandListener;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.droidplanner.services.android.impl.core.MAVLink.MavLinkCalibration;
import org.droidplanner.services.android.impl.core.drone.DroneInterfaces;
import org.droidplanner.services.android.impl.core.drone.DroneVariable;
import org.droidplanner.services.android.impl.core.drone.autopilot.MavLinkDrone;

public class MagnetometerCalibrationImpl extends DroneVariable implements DroneInterfaces.OnDroneListener<MavLinkDrone> {
    private AtomicBoolean cancelled = new AtomicBoolean(false);
    private OnMagnetometerCalibrationListener listener;
    private final HashMap<Short, Info> magCalibrationTracker = new HashMap<>();

    public interface OnMagnetometerCalibrationListener {
        void onCalibrationCancelled();

        void onCalibrationCompleted(msg_mag_cal_report msg_mag_cal_report);

        void onCalibrationProgress(msg_mag_cal_progress msg_mag_cal_progress);
    }

    public MagnetometerCalibrationImpl(MavLinkDrone mavLinkDrone) {
        super(mavLinkDrone);
        mavLinkDrone.addDroneListener(this);
    }

    public void setListener(OnMagnetometerCalibrationListener onMagnetometerCalibrationListener) {
        this.listener = onMagnetometerCalibrationListener;
    }

    public void startCalibration(boolean z, boolean z2, int i) {
        this.magCalibrationTracker.clear();
        this.cancelled.set(false);
        MavLinkCalibration.startMagnetometerCalibration(this.myDrone, z, z2, i, (ICommandListener) null);
    }

    public void cancelCalibration() {
        MavLinkCalibration.cancelMagnetometerCalibration(this.myDrone, (ICommandListener) null);
        this.cancelled.set(true);
        OnMagnetometerCalibrationListener onMagnetometerCalibrationListener = this.listener;
        if (onMagnetometerCalibrationListener != null) {
            onMagnetometerCalibrationListener.onCalibrationCancelled();
        }
    }

    public void acceptCalibration() {
        MavLinkCalibration.acceptMagnetometerCalibration(this.myDrone, (ICommandListener) null);
    }

    public void processCalibrationMessage(MAVLinkMessage mAVLinkMessage) {
        int i = mAVLinkMessage.msgid;
        if (i == 191) {
            msg_mag_cal_progress msg_mag_cal_progress = (msg_mag_cal_progress) mAVLinkMessage;
            Info info = this.magCalibrationTracker.get(Short.valueOf(msg_mag_cal_progress.compass_id));
            if (info == null) {
                info = new Info();
                this.magCalibrationTracker.put(Short.valueOf(msg_mag_cal_progress.compass_id), info);
            }
            info.calProgress = msg_mag_cal_progress;
            OnMagnetometerCalibrationListener onMagnetometerCalibrationListener = this.listener;
            if (onMagnetometerCalibrationListener != null) {
                onMagnetometerCalibrationListener.onCalibrationProgress(msg_mag_cal_progress);
            }
        } else if (i == 192) {
            msg_mag_cal_report msg_mag_cal_report = (msg_mag_cal_report) mAVLinkMessage;
            Info info2 = this.magCalibrationTracker.get(Short.valueOf(msg_mag_cal_report.compass_id));
            if (info2 == null) {
                info2 = new Info();
                this.magCalibrationTracker.put(Short.valueOf(msg_mag_cal_report.compass_id), info2);
            }
            info2.calReport = msg_mag_cal_report;
            OnMagnetometerCalibrationListener onMagnetometerCalibrationListener2 = this.listener;
            if (onMagnetometerCalibrationListener2 != null) {
                onMagnetometerCalibrationListener2.onCalibrationCompleted(msg_mag_cal_report);
            }
        }
    }

    public HashMap<Short, Info> getMagCalibrationTracker() {
        return this.magCalibrationTracker;
    }

    public boolean isCancelled() {
        return this.cancelled.get();
    }

    public static class Info {
        msg_mag_cal_progress calProgress;
        msg_mag_cal_report calReport;

        public msg_mag_cal_progress getCalProgress() {
            return this.calProgress;
        }

        public msg_mag_cal_report getCalReport() {
            return this.calReport;
        }
    }

    /* renamed from: org.droidplanner.services.android.impl.core.drone.variables.calibration.MagnetometerCalibrationImpl$1 */
    /* synthetic */ class C59941 {

        /* renamed from: $SwitchMap$org$droidplanner$services$android$impl$core$drone$DroneInterfaces$DroneEventsType */
        static final /* synthetic */ int[] f8639x7e1461ff;

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
                f8639x7e1461ff = r0
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r1 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.HEARTBEAT_TIMEOUT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8639x7e1461ff     // Catch:{ NoSuchFieldError -> 0x001d }
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r1 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.DISCONNECTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.droidplanner.services.android.impl.core.drone.variables.calibration.MagnetometerCalibrationImpl.C59941.<clinit>():void");
        }
    }

    public void onDroneEvent(DroneInterfaces.DroneEventsType droneEventsType, MavLinkDrone mavLinkDrone) {
        int i = C59941.f8639x7e1461ff[droneEventsType.ordinal()];
        if (i == 1 || i == 2) {
            cancelCalibration();
        }
    }
}

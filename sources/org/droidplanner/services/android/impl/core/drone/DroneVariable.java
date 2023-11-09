package org.droidplanner.services.android.impl.core.drone;

import android.os.Handler;
import android.os.RemoteException;
import atakplugin.UASTool.cqb;
import com.o3dr.services.android.lib.model.ICommandListener;
import org.droidplanner.services.android.impl.core.drone.autopilot.MavLinkDrone;

public class DroneVariable<T extends MavLinkDrone> {
    static int UNSIGNED_BYTE_MAX_VALUE = 255;
    static int UNSIGNED_BYTE_MIN_VALUE;
    protected T myDrone;

    public DroneVariable(T t) {
        this.myDrone = t;
    }

    /* access modifiers changed from: protected */
    public void postSuccessEvent(Handler handler, final ICommandListener iCommandListener) {
        if (handler != null && iCommandListener != null) {
            handler.post(new Runnable() {
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
    public void postErrorEvent(Handler handler, final ICommandListener iCommandListener, final int i) {
        if (handler != null && iCommandListener != null) {
            handler.post(new Runnable() {
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

    /* access modifiers changed from: protected */
    public void postTimeoutEvent(Handler handler, final ICommandListener iCommandListener) {
        if (handler != null && iCommandListener != null) {
            handler.post(new Runnable() {
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

    public static short validateToUnsignedByteRange(int i) {
        if (i >= UNSIGNED_BYTE_MIN_VALUE && i <= UNSIGNED_BYTE_MAX_VALUE) {
            return (short) i;
        }
        throw new IllegalArgumentException("Value is outside of the range of an sysid/compid byte: " + i);
    }
}

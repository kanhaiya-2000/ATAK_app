package org.droidplanner.services.android.impl.core.drone.manager;

import android.os.Handler;
import android.os.RemoteException;
import atakplugin.UASTool.cqb;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.common.msg_command_ack;
import com.atakmap.android.uastool.MAVLink.common.msg_command_long;
import com.atakmap.android.uastool.MAVLink.common.msg_set_mode;
import com.o3dr.services.android.lib.model.ICommandListener;
import java.util.concurrent.ConcurrentHashMap;

public class DroneCommandTracker {
    private static final long COMMAND_TIMEOUT_PERIOD = 2000;
    /* access modifiers changed from: private */
    public final ConcurrentHashMap<CallbackKey, AckCallback> callbackStore = new ConcurrentHashMap<>();
    private final Handler handler;
    /* access modifiers changed from: private */
    public final ConcurrentHashMap<Integer, CallbackKey> keyStore = new ConcurrentHashMap<>();

    DroneCommandTracker(Handler handler2) {
        this.handler = handler2;
    }

    public void onCommandSubmitted(MAVLinkMessage mAVLinkMessage, ICommandListener iCommandListener) {
        if (mAVLinkMessage != null && iCommandListener != null) {
            if (mAVLinkMessage instanceof msg_command_long) {
                onCommandSubmittedImpl((msg_command_long) mAVLinkMessage, iCommandListener);
            } else if (mAVLinkMessage instanceof msg_set_mode) {
                onCommandSubmittedImpl((msg_set_mode) mAVLinkMessage, iCommandListener);
            }
        }
    }

    private void onCommandSubmittedImpl(msg_command_long msg_command_long, ICommandListener iCommandListener) {
        int i = msg_command_long.command;
        C59701 r0 = new CallbackKey<msg_command_ack>(i) {
            public int checkAckResult(msg_command_ack msg_command_ack) {
                return msg_command_ack.result;
            }
        };
        AckCallback ackCallback = new AckCallback(iCommandListener, i);
        this.keyStore.put(Integer.valueOf(i), r0);
        this.callbackStore.put(r0, ackCallback);
        this.handler.postDelayed(ackCallback, COMMAND_TIMEOUT_PERIOD);
    }

    private void onCommandSubmittedImpl(msg_set_mode msg_set_mode, ICommandListener iCommandListener) {
        int i = msg_set_mode.msgid;
        C59712 r0 = new CallbackKey<msg_command_ack>(i) {
            public int checkAckResult(msg_command_ack msg_command_ack) {
                return msg_command_ack.result;
            }
        };
        AckCallback ackCallback = new AckCallback(iCommandListener, i);
        this.keyStore.put(Integer.valueOf(i), r0);
        this.callbackStore.put(r0, ackCallback);
        this.handler.postDelayed(ackCallback, COMMAND_TIMEOUT_PERIOD);
    }

    public void onCommandAck(int i, Object obj) {
        if (i == 77) {
            onCommandAckImpl((msg_command_ack) obj);
        }
    }

    private void onCommandAckImpl(msg_command_ack msg_command_ack) {
        AckCallback remove;
        CallbackKey callbackKey = this.keyStore.get(Integer.valueOf(msg_command_ack.command));
        if (callbackKey != null && (remove = this.callbackStore.remove(callbackKey)) != null) {
            this.handler.removeCallbacks(remove);
            remove.setAckResult(callbackKey.checkAckResult(msg_command_ack));
            this.handler.post(remove);
        }
    }

    private static abstract class CallbackKey<T> {
        private final int commandId;

        public abstract int checkAckResult(T t);

        CallbackKey(int i) {
            this.commandId = i;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if ((obj instanceof CallbackKey) && this.commandId == ((CallbackKey) obj).commandId) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.commandId;
        }
    }

    private class AckCallback implements Runnable {
        private static final int COMMAND_SUCCEED = 0;
        private static final int COMMAND_TIMED_OUT = -1;
        private final int ackId;
        private int ackResult = -1;
        private final ICommandListener listener;

        AckCallback(ICommandListener iCommandListener, int i) {
            this.listener = iCommandListener;
            this.ackId = i;
        }

        /* access modifiers changed from: package-private */
        public void setAckResult(int i) {
            this.ackResult = i;
        }

        public void run() {
            if (this.listener != null) {
                CallbackKey callbackKey = (CallbackKey) DroneCommandTracker.this.keyStore.remove(Integer.valueOf(this.ackId));
                if (callbackKey != null) {
                    DroneCommandTracker.this.callbackStore.remove(callbackKey);
                }
                cqb.m12007b("Callback with ack result %d", Integer.valueOf(this.ackResult));
                try {
                    int i = this.ackResult;
                    if (i == -1) {
                        this.listener.onTimeout();
                    } else if (i != 0) {
                        this.listener.onError(i);
                    } else {
                        this.listener.onSuccess();
                    }
                } catch (RemoteException e) {
                    cqb.m12015e(e, e.getMessage(), new Object[0]);
                }
            }
        }
    }
}

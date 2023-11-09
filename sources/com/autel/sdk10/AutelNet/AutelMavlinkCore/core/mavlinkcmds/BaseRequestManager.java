package com.autel.sdk10.AutelNet.AutelMavlinkCore.core.mavlinkcmds;

import com.autel.common.error.AutelError;
import com.autel.internal.sdk.product.datapost.MsgPostManager;
import com.autel.internal.sdk.product.datapost.PostRunnable;
import com.autel.sdk10.AutelNet.AutelMavlinkCore.controller.StarLinkClientManager;
import com.autel.sdk10.AutelNet.AutelMavlinkCore.core.mavlinkcmds.mavlinkpacket.ParametersMavLinkPacketFactory;
import com.autel.sdk10.AutelNet.AutelMavlinkCore.core.mavlinkcmds.mavlinkparameter.Parameter;
import com.autel.sdk10.interfaces.AutelCompletionCallback;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.droidplanner.services.android.impl.core.drone.variables.HeartBeat;

public abstract class BaseRequestManager {
    protected static final int MAV_PARAM_TYPE_INT32 = 6;
    protected static final int MAV_PARAM_TYPE_REAL32 = 9;
    protected final int REQUEST_TIMEOUT = 5000;
    protected ConcurrentHashMap<Integer, AutelCompletionCallback.ICompletionCallbackWith> callbacks = new ConcurrentHashMap<>();
    private ScheduledExecutorService checkTimeOutThreadPool = Executors.newScheduledThreadPool(10);

    /* access modifiers changed from: protected */
    public abstract boolean isReportResponseSucc(int i, long j, AutelCompletionCallback.ICompletionCallbackWith iCompletionCallbackWith);

    protected static void sendParameter(Parameter... parameterArr) {
        for (Parameter parameter : parameterArr) {
            if (!(parameter == null || parameter.getName() == null || parameter.getName().equals("N/A"))) {
                sendParameter(parameter);
            }
        }
        confirmation();
    }

    private static void sendParameter(Parameter parameter) {
        StarLinkClientManager.getInstance_().sendMavPacket(ParametersMavLinkPacketFactory.createSendParameterPacket(parameter));
    }

    private static void confirmation() {
        StarLinkClientManager.getInstance_().sendMavPacket(ParametersMavLinkPacketFactory.createConfirmationPacket());
    }

    protected static void readParameterName(String str) {
        StarLinkClientManager.getInstance_().sendMavPacket(ParametersMavLinkPacketFactory.createReadParameterNamePacket(str));
    }

    /* access modifiers changed from: protected */
    public synchronized void waitForResponse(int i, AutelCompletionCallback.ICompletionCallbackWith iCompletionCallbackWith) {
        if (checkValueValid(iCompletionCallbackWith)) {
            this.checkTimeOutThreadPool.execute(new CheckTimeoutRunnable(i, iCompletionCallbackWith));
        }
    }

    /* access modifiers changed from: protected */
    public synchronized void waitForResponseWithDelay(int i, long j, AutelCompletionCallback.ICompletionCallbackWith iCompletionCallbackWith) {
        checkValueValid(iCompletionCallbackWith);
        if (this.callbacks.get(Integer.valueOf(iCompletionCallbackWith.hashCode())) != null) {
            this.checkTimeOutThreadPool.schedule(new CheckTimeoutRunnable(i, iCompletionCallbackWith), j, TimeUnit.MILLISECONDS);
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkValueValid(AutelCompletionCallback.ICompletionCallbackWith iCompletionCallbackWith) {
        if (iCompletionCallbackWith != null) {
            this.callbacks.put(Integer.valueOf(iCompletionCallbackWith.hashCode()), iCompletionCallbackWith);
        }
        return iCompletionCallbackWith != null;
    }

    private class CheckTimeoutRunnable implements Runnable {
        /* access modifiers changed from: private */
        public AutelCompletionCallback.ICompletionCallbackWith iCompletionCallbackWith;
        private int requestId;

        public CheckTimeoutRunnable(int i, AutelCompletionCallback.ICompletionCallbackWith iCompletionCallbackWith2) {
            this.requestId = i;
            this.iCompletionCallbackWith = iCompletionCallbackWith2;
        }

        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            boolean z = true;
            while (z && BaseRequestManager.this.getCallback(this.iCompletionCallbackWith) != null) {
                try {
                    Thread.sleep(50);
                    if (System.currentTimeMillis() - currentTimeMillis > HeartBeat.HEARTBEAT_NORMAL_TIMEOUT) {
                        MsgPostManager.instance().post(new PostRunnable() {
                            /* access modifiers changed from: protected */
                            public void task() {
                                if (BaseRequestManager.this.getCallback(CheckTimeoutRunnable.this.iCompletionCallbackWith) != null) {
                                    BaseRequestManager.this.getCallback(CheckTimeoutRunnable.this.iCompletionCallbackWith).onFailure(AutelError.COMMON_TIMEOUT);
                                }
                                BaseRequestManager.this.removeCallback(CheckTimeoutRunnable.this.iCompletionCallbackWith);
                            }
                        });
                        if (BaseRequestManager.this.getCallback(this.iCompletionCallbackWith) == null) {
                            return;
                        }
                        z = false;
                    } else if (BaseRequestManager.this.getCallback(this.iCompletionCallbackWith) != null) {
                        BaseRequestManager baseRequestManager = BaseRequestManager.this;
                        z = !baseRequestManager.isReportResponseSucc(this.requestId, currentTimeMillis, baseRequestManager.getCallback(this.iCompletionCallbackWith));
                        if (!z) {
                            BaseRequestManager.this.removeCallback(this.iCompletionCallbackWith);
                        }
                    } else {
                        return;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void removeCallback(int i) {
        this.callbacks.remove(Integer.valueOf(i));
    }

    /* access modifiers changed from: protected */
    public void removeCallback(AutelCompletionCallback.ICompletionCallbackWith iCompletionCallbackWith) {
        if (iCompletionCallbackWith != null) {
            removeCallback(iCompletionCallbackWith.hashCode());
        }
    }

    /* access modifiers changed from: protected */
    public AutelCompletionCallback.ICompletionCallbackWith getCallback(AutelCompletionCallback.ICompletionCallbackWith iCompletionCallbackWith) {
        if (iCompletionCallbackWith != null) {
            return this.callbacks.get(Integer.valueOf(iCompletionCallbackWith.hashCode()));
        }
        return null;
    }

    public synchronized void remove1TimeCallbacksFromClass(Object obj) {
        String str;
        if (obj instanceof String) {
            str = (String) obj;
        } else {
            str = obj.getClass().getName();
        }
        for (Map.Entry<Integer, AutelCompletionCallback.ICompletionCallbackWith> key : this.callbacks.entrySet()) {
            Integer num = (Integer) key.getKey();
            AutelCompletionCallback.ICompletionCallbackWith iCompletionCallbackWith = this.callbacks.get(num);
            if (!(iCompletionCallbackWith == null || iCompletionCallbackWith.getClass() == null)) {
                String name = iCompletionCallbackWith.getClass().getName();
                if (name.startsWith(str + "$")) {
                    removeCallback(num.intValue());
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void callbackResult(AutelCompletionCallback.ICompletionCallbackWith iCompletionCallbackWith, Object obj) {
        if (iCompletionCallbackWith != null && getCallback(iCompletionCallbackWith) != null) {
            getCallback(iCompletionCallbackWith).onResult(obj);
            removeCallback(iCompletionCallbackWith);
        }
    }

    /* access modifiers changed from: protected */
    public void callbackFailure(AutelCompletionCallback.ICompletionCallbackWith iCompletionCallbackWith, AutelError autelError) {
        if (iCompletionCallbackWith != null && getCallback(iCompletionCallbackWith) != null) {
            getCallback(iCompletionCallbackWith).onFailure(autelError);
            removeCallback(iCompletionCallbackWith);
        }
    }
}

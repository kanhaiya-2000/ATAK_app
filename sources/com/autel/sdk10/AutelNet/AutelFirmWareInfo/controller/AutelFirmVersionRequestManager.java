package com.autel.sdk10.AutelNet.AutelFirmWareInfo.controller;

import com.autel.common.error.AutelError;
import com.autel.internal.sdk.firmware.AircraftComponentSerialNumberVersionInfo;
import com.autel.internal.sdk.firmware.AircraftComponentVersionInfo;
import com.autel.internal.sdk.firmware.AutelVersionInfo;
import com.autel.internal.sdk.firmware.RemoteControllerSerialNumberVersionInfo;
import com.autel.internal.sdk.product.datapost.MsgPostManager;
import com.autel.internal.sdk.product.datapost.PostRunnable;
import com.autel.internal.sdk.remotecontroller.RemoteControllerVersionPartInfo;
import com.autel.sdk10.AutelNet.AutelFirmWareInfo.engine.version.AircraftComponentSNVersion;
import com.autel.sdk10.AutelNet.AutelFirmWareInfo.engine.version.AircraftComponentVersion;
import com.autel.sdk10.AutelNet.AutelFirmWareInfo.engine.version.RCSNVersion;
import com.autel.sdk10.AutelNet.AutelFirmWareInfo.engine.version.RCVersion;
import com.autel.sdk10.AutelNet.AutelFirmWareInfo.interfaces.IAutelFirmVersionCallback;
import com.autel.sdk10.AutelNet.AutelFirmWareInfo.socket.FirmVersionSocket;
import com.autel.sdk10.products.aircraft.AutelAircraftInfoManager;

public class AutelFirmVersionRequestManager {
    private static AutelFirmVersionRequestManager instance_;
    /* access modifiers changed from: private */
    public IAutelFirmVersionCallback<AircraftComponentSerialNumberVersionInfo> iAircraftComponentSNVersionInfoCallback;
    /* access modifiers changed from: private */
    public IAutelFirmVersionCallback<AircraftComponentVersionInfo> iAircraftComponentVersionInfoCallback;
    /* access modifiers changed from: private */
    public IAutelFirmVersionCallback<RemoteControllerSerialNumberVersionInfo> iAutelRCSNVersionInfoCallback;
    /* access modifiers changed from: private */
    public IAutelFirmVersionCallback<RemoteControllerVersionPartInfo> iAutelRCVersionInfoCallback;

    public static AutelFirmVersionRequestManager getInstance() {
        if (instance_ == null) {
            instance_ = new AutelFirmVersionRequestManager();
        }
        return instance_;
    }

    private AutelFirmVersionRequestManager() {
    }

    /* access modifiers changed from: private */
    public void callbackReceiveVersion(final IAutelFirmVersionCallback iAutelFirmVersionCallback, final AutelVersionInfo autelVersionInfo) {
        MsgPostManager.instance().post(new PostRunnable() {
            /* access modifiers changed from: protected */
            public void task() {
                IAutelFirmVersionCallback iAutelFirmVersionCallback = iAutelFirmVersionCallback;
                if (iAutelFirmVersionCallback != null) {
                    iAutelFirmVersionCallback.onReceiveVersion(autelVersionInfo);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void callbackFailure(final IAutelFirmVersionCallback iAutelFirmVersionCallback, final AutelError autelError) {
        MsgPostManager.instance().post(new PostRunnable() {
            /* access modifiers changed from: protected */
            public void task() {
                IAutelFirmVersionCallback iAutelFirmVersionCallback = iAutelFirmVersionCallback;
                if (iAutelFirmVersionCallback != null) {
                    iAutelFirmVersionCallback.onFailure(autelError);
                }
            }
        });
    }

    public void requestAutelAircraftComponentVersion(IAutelFirmVersionCallback<AircraftComponentVersionInfo> iAutelFirmVersionCallback) {
        this.iAircraftComponentVersionInfoCallback = iAutelFirmVersionCallback;
        new FirmVersionSocket(AircraftComponentVersion.getInstance_(), new IAutelFirmVersionCallback<String>() {
            public void onReceiveVersion(String str) {
                AircraftComponentVersion.getInstance_().jsonParser(str);
                AutelFirmVersionRequestManager autelFirmVersionRequestManager = AutelFirmVersionRequestManager.this;
                autelFirmVersionRequestManager.callbackReceiveVersion(autelFirmVersionRequestManager.iAircraftComponentVersionInfoCallback, AutelAircraftInfoManager.getAircraftComponentVersionInfo());
            }

            public void onFailure(AutelError autelError) {
                AutelFirmVersionRequestManager autelFirmVersionRequestManager = AutelFirmVersionRequestManager.this;
                autelFirmVersionRequestManager.callbackFailure(autelFirmVersionRequestManager.iAircraftComponentVersionInfoCallback, autelError);
            }
        });
    }

    public void cancelRequestAutelAircraftComponentVersion() {
        this.iAircraftComponentVersionInfoCallback = null;
    }

    public void requestAutelAircraftComponentSNVersion(IAutelFirmVersionCallback<AircraftComponentSerialNumberVersionInfo> iAutelFirmVersionCallback) {
        this.iAircraftComponentSNVersionInfoCallback = iAutelFirmVersionCallback;
        new FirmVersionSocket(AircraftComponentSNVersion.getInstance_(), new IAutelFirmVersionCallback<String>() {
            public void onReceiveVersion(String str) {
                AircraftComponentSNVersion.getInstance_().jsonParser(str);
                AutelFirmVersionRequestManager autelFirmVersionRequestManager = AutelFirmVersionRequestManager.this;
                autelFirmVersionRequestManager.callbackReceiveVersion(autelFirmVersionRequestManager.iAircraftComponentSNVersionInfoCallback, AutelAircraftInfoManager.getAircraftComponentSNVersionInfo());
            }

            public void onFailure(AutelError autelError) {
                AutelFirmVersionRequestManager autelFirmVersionRequestManager = AutelFirmVersionRequestManager.this;
                autelFirmVersionRequestManager.callbackFailure(autelFirmVersionRequestManager.iAircraftComponentSNVersionInfoCallback, autelError);
            }
        });
    }

    public void cancelRequestAutelAircraftComponentSNVersion() {
        this.iAircraftComponentSNVersionInfoCallback = null;
    }

    public void requestAutelRCVersion(IAutelFirmVersionCallback<RemoteControllerVersionPartInfo> iAutelFirmVersionCallback) {
        this.iAutelRCVersionInfoCallback = iAutelFirmVersionCallback;
        new FirmVersionSocket(RCVersion.getInstance_(), new IAutelFirmVersionCallback<String>() {
            public void onReceiveVersion(String str) {
                RCVersion.getInstance_().jsonParser(str);
                AutelFirmVersionRequestManager autelFirmVersionRequestManager = AutelFirmVersionRequestManager.this;
                autelFirmVersionRequestManager.callbackReceiveVersion(autelFirmVersionRequestManager.iAutelRCVersionInfoCallback, AutelAircraftInfoManager.getRCVersionInfo());
            }

            public void onFailure(AutelError autelError) {
                AutelFirmVersionRequestManager autelFirmVersionRequestManager = AutelFirmVersionRequestManager.this;
                autelFirmVersionRequestManager.callbackFailure(autelFirmVersionRequestManager.iAutelRCVersionInfoCallback, autelError);
            }
        });
    }

    public void cancelRequestAutelRCVersion() {
        this.iAutelRCVersionInfoCallback = null;
    }

    public void requestAutelRCSNVersion(IAutelFirmVersionCallback<RemoteControllerSerialNumberVersionInfo> iAutelFirmVersionCallback) {
        this.iAutelRCSNVersionInfoCallback = iAutelFirmVersionCallback;
        new FirmVersionSocket(RCSNVersion.getInstance_(), new IAutelFirmVersionCallback<String>() {
            public void onReceiveVersion(String str) {
                RCSNVersion.getInstance_().jsonParser(str);
                AutelFirmVersionRequestManager autelFirmVersionRequestManager = AutelFirmVersionRequestManager.this;
                autelFirmVersionRequestManager.callbackReceiveVersion(autelFirmVersionRequestManager.iAutelRCSNVersionInfoCallback, AutelAircraftInfoManager.getRCSNVersionInfo());
            }

            public void onFailure(AutelError autelError) {
                AutelFirmVersionRequestManager autelFirmVersionRequestManager = AutelFirmVersionRequestManager.this;
                autelFirmVersionRequestManager.callbackFailure(autelFirmVersionRequestManager.iAutelRCSNVersionInfoCallback, autelError);
            }
        });
    }

    public void cancelRequestAutelRCSNVersion() {
        this.iAutelRCSNVersionInfoCallback = null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0078, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x007d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void remove1TimeCallbacksFromClass(java.lang.Object r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            if (r2 == 0) goto L_0x007c
            java.lang.Class r0 = r2.getClass()     // Catch:{ all -> 0x0079 }
            if (r0 != 0) goto L_0x000a
            goto L_0x007c
        L_0x000a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0079 }
            r0.<init>()     // Catch:{ all -> 0x0079 }
            java.lang.Class r2 = r2.getClass()     // Catch:{ all -> 0x0079 }
            java.lang.String r2 = r2.getName()     // Catch:{ all -> 0x0079 }
            r0.append(r2)     // Catch:{ all -> 0x0079 }
            java.lang.String r2 = "$"
            r0.append(r2)     // Catch:{ all -> 0x0079 }
            java.lang.String r2 = r0.toString()     // Catch:{ all -> 0x0079 }
            com.autel.sdk10.AutelNet.AutelFirmWareInfo.interfaces.IAutelFirmVersionCallback<com.autel.internal.sdk.firmware.AircraftComponentVersionInfo> r0 = r1.iAircraftComponentVersionInfoCallback     // Catch:{ all -> 0x0079 }
            if (r0 == 0) goto L_0x0038
            java.lang.Class r0 = r0.getClass()     // Catch:{ all -> 0x0079 }
            java.lang.String r0 = r0.getName()     // Catch:{ all -> 0x0079 }
            boolean r0 = r0.startsWith(r2)     // Catch:{ all -> 0x0079 }
            if (r0 == 0) goto L_0x0038
            r1.cancelRequestAutelAircraftComponentVersion()     // Catch:{ all -> 0x0079 }
        L_0x0038:
            com.autel.sdk10.AutelNet.AutelFirmWareInfo.interfaces.IAutelFirmVersionCallback<com.autel.internal.sdk.firmware.AircraftComponentSerialNumberVersionInfo> r0 = r1.iAircraftComponentSNVersionInfoCallback     // Catch:{ all -> 0x0079 }
            if (r0 == 0) goto L_0x004d
            java.lang.Class r0 = r0.getClass()     // Catch:{ all -> 0x0079 }
            java.lang.String r0 = r0.getName()     // Catch:{ all -> 0x0079 }
            boolean r0 = r0.startsWith(r2)     // Catch:{ all -> 0x0079 }
            if (r0 == 0) goto L_0x004d
            r1.cancelRequestAutelAircraftComponentSNVersion()     // Catch:{ all -> 0x0079 }
        L_0x004d:
            com.autel.sdk10.AutelNet.AutelFirmWareInfo.interfaces.IAutelFirmVersionCallback<com.autel.internal.sdk.remotecontroller.RemoteControllerVersionPartInfo> r0 = r1.iAutelRCVersionInfoCallback     // Catch:{ all -> 0x0079 }
            if (r0 == 0) goto L_0x0062
            java.lang.Class r0 = r0.getClass()     // Catch:{ all -> 0x0079 }
            java.lang.String r0 = r0.getName()     // Catch:{ all -> 0x0079 }
            boolean r0 = r0.startsWith(r2)     // Catch:{ all -> 0x0079 }
            if (r0 == 0) goto L_0x0062
            r1.cancelRequestAutelRCVersion()     // Catch:{ all -> 0x0079 }
        L_0x0062:
            com.autel.sdk10.AutelNet.AutelFirmWareInfo.interfaces.IAutelFirmVersionCallback<com.autel.internal.sdk.firmware.RemoteControllerSerialNumberVersionInfo> r0 = r1.iAutelRCSNVersionInfoCallback     // Catch:{ all -> 0x0079 }
            if (r0 == 0) goto L_0x0077
            java.lang.Class r0 = r0.getClass()     // Catch:{ all -> 0x0079 }
            java.lang.String r0 = r0.getName()     // Catch:{ all -> 0x0079 }
            boolean r2 = r0.startsWith(r2)     // Catch:{ all -> 0x0079 }
            if (r2 == 0) goto L_0x0077
            r1.cancelRequestAutelRCSNVersion()     // Catch:{ all -> 0x0079 }
        L_0x0077:
            monitor-exit(r1)
            return
        L_0x0079:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        L_0x007c:
            monitor-exit(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autel.sdk10.AutelNet.AutelFirmWareInfo.controller.AutelFirmVersionRequestManager.remove1TimeCallbacksFromClass(java.lang.Object):void");
    }
}

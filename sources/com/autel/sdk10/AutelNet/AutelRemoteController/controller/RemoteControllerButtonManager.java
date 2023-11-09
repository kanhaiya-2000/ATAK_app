package com.autel.sdk10.AutelNet.AutelRemoteController.controller;

import com.autel.common.remotecontroller.RemoteControllerNavigateButtonEvent;
import com.autel.sdk10.AutelNet.AutelRemoteController.interfaces.IUdpRcvCallback;
import com.autel.sdk10.AutelNet.AutelRemoteController.udp.RemoteButtonControllerUdp;
import com.autel.sdk10.interfaces.AutelCompletionCallback;
import java.util.concurrent.ConcurrentHashMap;

public class RemoteControllerButtonManager implements IUdpRcvCallback {
    private static RemoteControllerButtonManager s_instance;
    private RemoteButtonControllerUdp autelRemoteControllerUdp;
    private ConcurrentHashMap<String, AutelCompletionCallback.ICompletionCallbackWith<RemoteControllerNavigateButtonEvent>> callbackMaps = new ConcurrentHashMap<>();

    private RemoteControllerButtonManager() {
    }

    public static RemoteControllerButtonManager getInstance() {
        if (s_instance == null) {
            s_instance = new RemoteControllerButtonManager();
        }
        return s_instance;
    }

    private synchronized RemoteButtonControllerUdp getAutelRemoteButtonUdp() {
        if (this.autelRemoteControllerUdp == null) {
            this.autelRemoteControllerUdp = new RemoteButtonControllerUdp(this);
        }
        return this.autelRemoteControllerUdp;
    }

    public synchronized void openConnection() {
        getAutelRemoteButtonUdp().connect();
    }

    public synchronized void closeConnection() {
        RemoteButtonControllerUdp remoteButtonControllerUdp = this.autelRemoteControllerUdp;
        if (remoteButtonControllerUdp != null) {
            remoteButtonControllerUdp.closeUdpConnect();
            this.autelRemoteControllerUdp = null;
        }
    }

    public void addRemoteButtonControllerListener(String str, AutelCompletionCallback.ICompletionCallbackWith<RemoteControllerNavigateButtonEvent> iCompletionCallbackWith) {
        this.callbackMaps.put(str, iCompletionCallbackWith);
    }

    public void removeRemoteButtonControllerListener(String str) {
        this.callbackMaps.remove(str);
    }

    public void receiverData(RemoteControllerNavigateButtonEvent remoteControllerNavigateButtonEvent) {
        if (!this.callbackMaps.isEmpty() && remoteControllerNavigateButtonEvent != null) {
            for (AutelCompletionCallback.ICompletionCallbackWith<RemoteControllerNavigateButtonEvent> onResult : this.callbackMaps.values()) {
                onResult.onResult(remoteControllerNavigateButtonEvent);
            }
        }
    }
}

package com.autel.camera.communication.tcp.connection;

import android.os.Handler;
import com.autel.camera.communication.tcp.CameraController;
import com.autel.camera.communication.tcp.CameraHeartBeat;
import com.autel.camera.communication.tcp.connection.base.AbsTcpConnection;
import com.autel.camera.communication.tcp.connection.events.CameraControllerDispatcher;
import com.autel.camera.protocol.protocol10.engine.CameraCommandMessage;
import com.autel.camera.protocol.protocol10.engine.CameraCommandMsgFactory;
import com.autel.camera.utils.IpConstantUtils;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.error.AutelError;
import com.autel.internal.sdk.camera.BaseCameraMsgParser;
import com.autel.util.log.AutelLog;
import com.autel.util.log.AutelLogTags;
import java.lang.ref.WeakReference;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.droidplanner.services.android.impl.core.drone.variables.HeartBeat;

public class CameraControllerTcpImpl extends AbsTcpConnection {
    private static final String TAG = "AbsTcpConnection";
    private WeakReference<Socket> mSocket;
    protected ConcurrentHashMap<CameraCommandMessage, Long> mTimeOutMaps = new ConcurrentHashMap<>();
    private ConcurrentHashMap<CameraCommandMessage, CallbackWithOneParam<BaseCameraMsgParser>> messageList = new ConcurrentHashMap<>();
    private SendPacketTask sendThread;

    /* access modifiers changed from: protected */
    public int getPort() {
        return 7878;
    }

    /* access modifiers changed from: protected */
    public boolean reConnect() {
        return true;
    }

    /* access modifiers changed from: protected */
    public String loadUrl() {
        return IpConstantUtils.getCameraControlAddress();
    }

    /* access modifiers changed from: protected */
    public Socket getSocket() {
        WeakReference<Socket> weakReference = this.mSocket;
        if (weakReference == null) {
            return null;
        }
        return (Socket) weakReference.get();
    }

    /* access modifiers changed from: protected */
    public void openConnection(String str) {
        AutelLog.m15082d(TAG, "controller openConnection ====>>> " + getPort());
        Socket socket = new Socket();
        try {
            socket.connect(new InetSocketAddress(loadUrl(), getPort()), 5000);
            socket.setKeepAlive(true);
            if (socket.isConnected()) {
                Handler handler = this.mHandler;
                SendPacketTask sendPacketTask = new SendPacketTask();
                this.sendThread = sendPacketTask;
                handler.postDelayed(sendPacketTask, 200);
            }
        } catch (Exception e) {
            AutelLog.m15084e(AutelLogTags.CAMERA_STATUS, "controller openConnection Exception ====>>> " + str + " e " + e.getMessage());
            e.printStackTrace();
        }
        this.mSocket = new WeakReference<>(socket);
    }

    public void checkTimeOutMain() {
        Long l;
        for (Map.Entry<CameraCommandMessage, Long> key : this.mTimeOutMaps.entrySet()) {
            CameraCommandMessage cameraCommandMessage = (CameraCommandMessage) key.getKey();
            if (!(cameraCommandMessage == null || (l = this.mTimeOutMaps.get(cameraCommandMessage)) == null || System.currentTimeMillis() - l.longValue() <= HeartBeat.HEARTBEAT_NORMAL_TIMEOUT)) {
                this.mTimeOutMaps.remove(cameraCommandMessage);
                if (this.messageList.get(cameraCommandMessage) != null) {
                    CallbackWithOneParam callbackWithOneParam = this.messageList.get(cameraCommandMessage);
                    if (callbackWithOneParam != null) {
                        callbackWithOneParam.onFailure(AutelError.COMMON_TIMEOUT);
                    }
                    this.messageList.remove(cameraCommandMessage);
                }
            }
        }
    }

    private class SendPacketTask implements Runnable {
        private SendPacketTask() {
        }

        public void run() {
            if (CameraController.instance().getTcpCameraToken() < 0) {
                CameraControllerTcpImpl.this.sendMessage(CameraCommandMsgFactory.createCameraToken());
                CameraControllerTcpImpl.this.mHandler.postDelayed(this, 1000);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void parserData(Object obj) {
        AutelLog.m15082d(AutelLogTags.CAMERA_STATUS, "parserData ====>>> " + obj.toString());
        CameraControllerDispatcher.instance().onDisPatchPacket(obj.toString());
    }

    /* access modifiers changed from: protected */
    public void closeTcpConnection() {
        CameraHeartBeat.instance().disconnect();
        CameraController.instance().setTcpCameraToken(-1);
        AutelLog.m15082d(TAG, "closeTcpConnection controller ");
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.sendThread);
            this.sendThread = null;
        }
        WeakReference<Socket> weakReference = this.mSocket;
        if (weakReference != null) {
            Socket socket = (Socket) weakReference.get();
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
            this.mSocket.clear();
        }
        this.messageList.clear();
        this.mTimeOutMaps.clear();
    }

    public boolean isConnected() {
        WeakReference<Socket> weakReference = this.mSocket;
        if (weakReference == null || weakReference.get() == null) {
            return false;
        }
        return ((Socket) this.mSocket.get()).isConnected();
    }

    public <T> boolean sendMessage(T t) {
        if (!isConnected()) {
            return false;
        }
        CameraCommandMessage cameraCommandMessage = (CameraCommandMessage) t;
        this.mTimeOutMaps.put(cameraCommandMessage, Long.valueOf(System.currentTimeMillis()));
        return this.mMsgList.offer(cameraCommandMessage.getData());
    }

    public void setMessageList(ConcurrentHashMap<CameraCommandMessage, CallbackWithOneParam<BaseCameraMsgParser>> concurrentHashMap) {
        this.messageList = concurrentHashMap;
    }
}

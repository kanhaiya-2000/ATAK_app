package com.atakmap.android.uastool.paladin;

import android.os.AsyncTask;
import com.atakmap.coremap.filesystem.FileSystemUtils;
import com.atakmap.coremap.log.Log;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Timer;
import java.util.TimerTask;

public class PaladinCommands {
    private static final int CONNECTION_CHECK_INTERVAL = 3000;
    private static Timer connectionTimer;
    private static TimerTask connectionTimerTask;
    private static StatusListenTask listen;

    public static void listenForAcks(PaladinPayloadManager paladinPayloadManager, String str, int i) {
        if (listen == null) {
            StatusListenTask statusListenTask = new StatusListenTask(paladinPayloadManager);
            listen = statusListenTask;
            statusListenTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{str, String.valueOf(i)});
        }
    }

    public static void stopListenForAcks() {
        StatusListenTask statusListenTask = listen;
        if (statusListenTask != null) {
            statusListenTask.cancel(true);
            listen = null;
        }
    }

    public static void scheduleHeartbeatSend(String str, String str2, int i) {
        if (str2.length() == 0 || i == -1) {
            Timer timer = connectionTimer;
            if (timer != null) {
                timer.cancel();
            }
            TimerTask timerTask = connectionTimerTask;
            if (timerTask != null) {
                timerTask.cancel();
            }
            connectionTimer = null;
            return;
        }
        Timer timer2 = connectionTimer;
        if (timer2 != null) {
            timer2.cancel();
        }
        TimerTask timerTask2 = connectionTimerTask;
        if (timerTask2 != null) {
            timerTask2.cancel();
        }
        connectionTimerTask = new checkConnectionTimerTask(str, str2, i);
        Timer timer3 = new Timer(true);
        connectionTimer = timer3;
        timer3.scheduleAtFixedRate(connectionTimerTask, 500, 3000);
    }

    public static void stopHeartbeatSend() {
        Timer timer = connectionTimer;
        if (timer != null) {
            timer.cancel();
            connectionTimer = null;
        }
        TimerTask timerTask = connectionTimerTask;
        if (timerTask != null) {
            timerTask.cancel();
            connectionTimerTask = null;
        }
    }

    static class checkConnectionTimerTask extends TimerTask {

        /* renamed from: ip */
        String f8407ip;
        int port;
        String statusCommand;

        public checkConnectionTimerTask(String str, String str2, int i) {
            this.statusCommand = str;
            this.f8407ip = str2;
            this.port = i;
        }

        public void run() {
            Log.d("Paladin", "Sending command to " + this.f8407ip + ":" + this.port);
            PaladinCommands.sendCommand(this.statusCommand, this.f8407ip, this.port);
        }
    }

    public static void sendCommand(String str, String str2, int i) {
        new ConnectTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{str2, String.valueOf(i), str});
    }

    private static class ConnectTask extends AsyncTask<String, Void, String> {
        private String commandString;
        private String host;
        private int port;

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
        }

        /* access modifiers changed from: protected */
        public String doInBackground(String... strArr) {
            try {
                this.host = strArr[0];
                this.port = Integer.parseInt(strArr[1]);
                this.commandString = strArr[2];
                DatagramSocket datagramSocket = new DatagramSocket();
                byte[] bytes = this.commandString.getBytes(FileSystemUtils.UTF8_CHARSET);
                datagramSocket.send(new DatagramPacket(bytes, bytes.length, InetAddress.getByName(this.host), this.port));
                datagramSocket.close();
            } catch (IOException unused) {
            }
            return "";
        }
    }

    private static class StatusListenTask extends AsyncTask<String, Void, String> {
        private static final String TAG = "StatusListenTask";
        private String ackIP;
        private int ackPort;
        private final PaladinPayloadManager callback;

        public StatusListenTask(PaladinPayloadManager paladinPayloadManager) {
            this.callback = paladinPayloadManager;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
        }

        /* access modifiers changed from: protected */
        public String doInBackground(String... strArr) {
            this.ackIP = strArr[0];
            this.ackPort = Integer.parseInt(strArr[1]);
            try {
                DatagramSocket datagramSocket = new DatagramSocket(this.ackPort);
                byte[] bArr = new byte[1024];
                while (true) {
                    Log.d(TAG, "Waiting for multicast message...");
                    DatagramPacket datagramPacket = new DatagramPacket(bArr, 1024);
                    datagramSocket.receive(datagramPacket);
                    String str = new String(datagramPacket.getData(), datagramPacket.getOffset(), datagramPacket.getLength());
                    Log.d("Paladin", "Received Ack: " + str);
                    this.callback.updateFeatureStatus(str);
                }
            } catch (IOException unused) {
                return "";
            }
        }
    }
}

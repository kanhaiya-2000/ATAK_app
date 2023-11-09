package com.atakmap.android.uastool.PD100;

import com.atakmap.coremap.log.Log;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.concurrent.LinkedBlockingQueue;

public class UdpUplinkComm extends Thread implements AutoCloseable {
    private static final String TAG = "UdpUplinkComm";
    private final LinkedBlockingQueue<DatagramPacket> _packets;
    volatile boolean cancelled = false;

    /* renamed from: ds */
    private DatagramSocket f8371ds;

    UdpUplinkComm(LinkedBlockingQueue<DatagramPacket> linkedBlockingQueue) {
        this._packets = linkedBlockingQueue;
    }

    public void close() {
        this.cancelled = true;
        interrupt();
    }

    public void run() {
        Log.d(TAG, "Starting UDP uplink...");
        this.cancelled = false;
        while (!this.cancelled) {
            if (this.f8371ds == null) {
                try {
                    Log.d(TAG, "Establishing UDP send socket");
                    DatagramSocket datagramSocket = new DatagramSocket();
                    this.f8371ds = datagramSocket;
                    try {
                        datagramSocket.setReuseAddress(true);
                    } catch (Exception e) {
                        Log.d(TAG, "Exception: " + e.getMessage());
                    }
                } catch (SocketException e2) {
                    Log.e(TAG, "Exception in UdpUplinkComm.run()", e2);
                }
            }
            try {
                DatagramPacket take = this._packets.take();
                if (take != null) {
                    Log.d(TAG, "Send Command to: " + take.getAddress() + ":" + take.getPort());
                    send(take);
                }
            } catch (InterruptedException unused) {
            } catch (Exception e3) {
                if (!this.cancelled) {
                    Log.e(TAG, "Exception in UdpUplinkComm.run()", e3);
                }
            }
        }
        Log.d(TAG, "Stopping UDP uplink...");
        DatagramSocket datagramSocket2 = this.f8371ds;
        if (datagramSocket2 != null) {
            datagramSocket2.close();
        }
        this.f8371ds = null;
        this._packets.clear();
        Log.d(TAG, "UDP uplink Stopped");
    }

    private void send(DatagramPacket datagramPacket) {
        try {
            this.f8371ds.send(datagramPacket);
        } catch (Exception e) {
            Log.e(TAG, "Error during command request", e);
        }
    }
}

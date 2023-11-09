package com.o3dr.android.client.utils.connection;

import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.os.RemoteException;
import android.util.Log;
import com.o3dr.services.android.lib.model.ICommandListener;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.nio.ByteBuffer;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public abstract class AbstractIpConnection {
    public static final int CONNECTION_TIMEOUT = 15000;
    private static final int DEFAULT_READ_BUFFER_SIZE = 4096;
    public static final int STATE_CONNECTED = 2;
    public static final int STATE_CONNECTING = 1;
    public static final int STATE_DISCONNECTED = 0;
    /* access modifiers changed from: private */
    public static final String TAG = "AbstractIpConnection";
    /* access modifiers changed from: private */
    public final AtomicInteger connectionStatus;
    /* access modifiers changed from: private */
    public final AtomicReference<Bundle> extrasHolder;
    /* access modifiers changed from: private */
    public final Handler handler;
    /* access modifiers changed from: private */
    public IpConnectionListener ipConnectionListener;
    /* access modifiers changed from: private */
    public final boolean isPolling;
    /* access modifiers changed from: private */
    public final boolean isReadingDisabled;
    /* access modifiers changed from: private */
    public final boolean isSendingDisabled;
    private final Runnable managerTask;
    private Thread managerThread;
    /* access modifiers changed from: private */
    public final LinkedBlockingQueue<PacketData> packetsToSend;
    /* access modifiers changed from: private */
    public final ByteBuffer readBuffer;
    /* access modifiers changed from: private */
    public final Runnable sendingTask;

    /* access modifiers changed from: protected */
    public abstract void close();

    /* access modifiers changed from: protected */
    public abstract void open(Bundle bundle);

    /* access modifiers changed from: protected */
    public abstract int read(ByteBuffer byteBuffer);

    /* access modifiers changed from: protected */
    public abstract void send(PacketData packetData);

    public AbstractIpConnection(Handler handler2) {
        this(handler2, false, false);
    }

    public AbstractIpConnection(Handler handler2, int i, boolean z) {
        this(handler2, i, false, false, z);
    }

    public AbstractIpConnection(Handler handler2, boolean z, boolean z2) {
        this(handler2, 4096, z, z2, false);
    }

    public AbstractIpConnection(Handler handler2, int i, boolean z, boolean z2, boolean z3) {
        this.packetsToSend = new LinkedBlockingQueue<>();
        this.connectionStatus = new AtomicInteger(0);
        this.extrasHolder = new AtomicReference<>();
        this.managerTask = new Runnable() {
            public void run() {
                Process.setThreadPriority(-4);
                Thread thread = null;
                try {
                    AbstractIpConnection abstractIpConnection = AbstractIpConnection.this;
                    abstractIpConnection.open((Bundle) abstractIpConnection.extrasHolder.get());
                    AbstractIpConnection.this.connectionStatus.set(2);
                    if (AbstractIpConnection.this.ipConnectionListener != null) {
                        AbstractIpConnection.this.ipConnectionListener.onIpConnected();
                    }
                    try {
                        if (!AbstractIpConnection.this.isSendingDisabled) {
                            Thread thread2 = new Thread(AbstractIpConnection.this.sendingTask, "IP Connection-Sending Thread");
                            try {
                                thread2.start();
                                thread = thread2;
                            } catch (Throwable th) {
                                Thread thread3 = thread2;
                                th = th;
                                thread = thread3;
                                if (thread != null && thread.isAlive()) {
                                    thread.interrupt();
                                }
                                AbstractIpConnection.this.disconnect();
                                Log.i(AbstractIpConnection.TAG, "Exiting connection manager thread.");
                                throw th;
                            }
                        }
                        if (!AbstractIpConnection.this.isReadingDisabled) {
                            while (AbstractIpConnection.this.connectionStatus.get() == 2) {
                                try {
                                    AbstractIpConnection.this.readBuffer.clear();
                                    AbstractIpConnection abstractIpConnection2 = AbstractIpConnection.this;
                                    int read = abstractIpConnection2.read(abstractIpConnection2.readBuffer);
                                    if (read > 0) {
                                        AbstractIpConnection.this.readBuffer.limit(read);
                                        if (AbstractIpConnection.this.ipConnectionListener != null) {
                                            AbstractIpConnection.this.readBuffer.rewind();
                                            AbstractIpConnection.this.ipConnectionListener.onPacketReceived(AbstractIpConnection.this.readBuffer);
                                        }
                                    }
                                } catch (InterruptedIOException e) {
                                    if (!AbstractIpConnection.this.isPolling) {
                                        throw e;
                                    }
                                } catch (IOException e2) {
                                    Log.e(AbstractIpConnection.TAG, "Error occurred while reading from the connection.", e2);
                                }
                            }
                        } else if (thread != null) {
                            thread.join();
                        }
                    } catch (InterruptedException e3) {
                        Log.e(AbstractIpConnection.TAG, "Error while waiting for sending thread to complete.", e3);
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    if (thread != null && thread.isAlive()) {
                        thread.interrupt();
                    }
                    AbstractIpConnection.this.disconnect();
                    Log.i(AbstractIpConnection.TAG, "Exiting connection manager thread.");
                } catch (IOException e4) {
                    Log.e(AbstractIpConnection.TAG, "Unable to open ip connection.", e4);
                    AbstractIpConnection.this.disconnect();
                    Log.i(AbstractIpConnection.TAG, "Exiting connection manager thread.");
                }
            }
        };
        this.sendingTask = new Runnable() {
            public void run() {
                while (AbstractIpConnection.this.connectionStatus.get() == 2) {
                    try {
                        PacketData packetData = (PacketData) AbstractIpConnection.this.packetsToSend.take();
                        ICommandListener iCommandListener = packetData.listener;
                        try {
                            AbstractIpConnection.this.send(packetData);
                            postSendSuccess(iCommandListener);
                        } catch (IOException e) {
                            Log.e(AbstractIpConnection.TAG, "Error occurred while sending packet.", e);
                            postSendTimeout(iCommandListener);
                        }
                    } catch (InterruptedException e2) {
                        Log.e(AbstractIpConnection.TAG, "Dispatching thread was interrupted.", e2);
                    } catch (Throwable th) {
                        AbstractIpConnection.this.disconnect();
                        Log.i(AbstractIpConnection.TAG, "Exiting packet dispatcher thread.");
                        throw th;
                    }
                }
                AbstractIpConnection.this.disconnect();
                Log.i(AbstractIpConnection.TAG, "Exiting packet dispatcher thread.");
            }

            private void postSendSuccess(final ICommandListener iCommandListener) {
                if (AbstractIpConnection.this.handler != null && iCommandListener != null) {
                    AbstractIpConnection.this.handler.post(new Runnable() {
                        public void run() {
                            try {
                                iCommandListener.onSuccess();
                            } catch (RemoteException e) {
                                Log.e(AbstractIpConnection.TAG, e.getMessage(), e);
                            }
                        }
                    });
                }
            }

            private void postSendTimeout(final ICommandListener iCommandListener) {
                if (AbstractIpConnection.this.handler != null && iCommandListener != null) {
                    AbstractIpConnection.this.handler.post(new Runnable() {
                        public void run() {
                            try {
                                iCommandListener.onTimeout();
                            } catch (RemoteException e) {
                                Log.e(AbstractIpConnection.TAG, e.getMessage(), e);
                            }
                        }
                    });
                }
            }
        };
        this.handler = handler2;
        this.readBuffer = ByteBuffer.allocate(i);
        this.isReadingDisabled = z2;
        this.isSendingDisabled = z;
        this.isPolling = z3;
    }

    public void connect(Bundle bundle) {
        if (this.connectionStatus.compareAndSet(0, 1)) {
            Log.i(TAG, "Starting manager thread.");
            this.extrasHolder.set(bundle);
            Thread thread = new Thread(this.managerTask, "IP Connection-Manager Thread");
            this.managerThread = thread;
            thread.setPriority(10);
            this.managerThread.start();
        }
    }

    public Bundle getConnectionExtras() {
        return this.extrasHolder.get();
    }

    public void disconnect() {
        if (this.connectionStatus.get() != 0 && this.managerThread != null) {
            this.connectionStatus.set(0);
            Thread thread = this.managerThread;
            if (thread != null && thread.isAlive() && !this.managerThread.isInterrupted()) {
                this.managerThread.interrupt();
            }
            try {
                close();
            } catch (IOException e) {
                Log.e(TAG, "Error occurred while closing ip connection.", e);
            }
            IpConnectionListener ipConnectionListener2 = this.ipConnectionListener;
            if (ipConnectionListener2 != null) {
                ipConnectionListener2.onIpDisconnected();
            }
        }
    }

    public void setIpConnectionListener(IpConnectionListener ipConnectionListener2) {
        this.ipConnectionListener = ipConnectionListener2;
    }

    public void sendPacket(byte[] bArr, int i, ICommandListener iCommandListener) {
        if (bArr != null && i > 0) {
            this.packetsToSend.offer(new PacketData(i, bArr, iCommandListener));
        }
    }

    public int getConnectionStatus() {
        return this.connectionStatus.get();
    }

    protected static final class PacketData {
        public final byte[] data;
        public final int dataLength;
        public final ICommandListener listener;

        public PacketData(int i, byte[] bArr, ICommandListener iCommandListener) {
            this.dataLength = i;
            this.data = bArr;
            this.listener = iCommandListener;
        }
    }
}

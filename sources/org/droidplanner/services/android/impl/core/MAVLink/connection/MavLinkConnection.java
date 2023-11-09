package org.droidplanner.services.android.impl.core.MAVLink.connection;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.core.util.Pair;
import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Parser;
import com.o3dr.services.android.lib.gcs.link.LinkConnectionStatus;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.BindException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.droidplanner.services.android.impl.core.model.Logger;

public abstract class MavLinkConnection {
    public static final String EXTRA_NETWORK = "extra_network";
    public static final int MAVLINK_CONNECTED = 2;
    public static final int MAVLINK_CONNECTING = 1;
    public static final int MAVLINK_DISCONNECTED = 0;
    private static final int READ_BUFFER_SIZE = 4096;
    /* access modifiers changed from: private */
    public static final String TAG = "MavLinkConnection";
    protected final Context context;
    /* access modifiers changed from: private */
    public final AtomicReference<Bundle> extrasHolder = new AtomicReference<>();
    /* access modifiers changed from: private */
    public final ConcurrentHashMap<String, Pair<Uri, BufferedOutputStream>> loggingOutStreams = new ConcurrentHashMap<>();
    private Thread mConnectThread;
    private final Runnable mConnectingTask = new Runnable() {
        public void run() {
            MavLinkConnection.this.loadPreferences();
            try {
                MavLinkConnection mavLinkConnection = MavLinkConnection.this;
                mavLinkConnection.openConnection((Bundle) mavLinkConnection.extrasHolder.get());
            } catch (IOException e) {
                if (MavLinkConnection.this.mConnectionStatus.get() != 0) {
                    MavLinkConnection.this.reportIOException(e);
                    MavLinkConnection.this.mLogger.logErr(MavLinkConnection.TAG, (Exception) e);
                }
                MavLinkConnection.this.disconnect();
            }
            MavLinkConnection.this.mLogger.logInfo(MavLinkConnection.TAG, "Exiting connecting thread.");
        }
    };
    /* access modifiers changed from: private */
    public final AtomicInteger mConnectionStatus = new AtomicInteger(0);
    /* access modifiers changed from: private */
    public final AtomicLong mConnectionTime = new AtomicLong(-1);
    private final ConcurrentHashMap<String, MavLinkConnectionListener> mListeners = new ConcurrentHashMap<>();
    protected final Logger mLogger = initLogger();
    /* access modifiers changed from: private */
    public final Runnable mLoggingTask = new Runnable() {
        /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public void run() {
            /*
                r10 = this;
                java.lang.String r0 = "IO Exception while closing "
                r1 = 8
                java.nio.ByteBuffer r1 = java.nio.ByteBuffer.allocate(r1)
                java.nio.ByteOrder r2 = java.nio.ByteOrder.BIG_ENDIAN
                r1.order(r2)
            L_0x000d:
                org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection r2 = org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection.this     // Catch:{ InterruptedException -> 0x00ed }
                java.util.concurrent.atomic.AtomicInteger r2 = r2.mConnectionStatus     // Catch:{ InterruptedException -> 0x00ed }
                int r2 = r2.get()     // Catch:{ InterruptedException -> 0x00ed }
                r3 = 2
                if (r2 != r3) goto L_0x00a5
                org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection r2 = org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection.this     // Catch:{ InterruptedException -> 0x00ed }
                java.util.concurrent.LinkedBlockingQueue r2 = r2.mPacketsToLog     // Catch:{ InterruptedException -> 0x00ed }
                java.lang.Object r2 = r2.take()     // Catch:{ InterruptedException -> 0x00ed }
                byte[] r2 = (byte[]) r2     // Catch:{ InterruptedException -> 0x00ed }
                r1.clear()     // Catch:{ InterruptedException -> 0x00ed }
                long r3 = java.lang.System.currentTimeMillis()     // Catch:{ InterruptedException -> 0x00ed }
                r5 = 1000(0x3e8, double:4.94E-321)
                long r3 = r3 * r5
                r1.putLong(r3)     // Catch:{ InterruptedException -> 0x00ed }
                org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection r3 = org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection.this     // Catch:{ InterruptedException -> 0x00ed }
                java.util.concurrent.ConcurrentHashMap r3 = r3.loggingOutStreams     // Catch:{ InterruptedException -> 0x00ed }
                java.util.Set r3 = r3.entrySet()     // Catch:{ InterruptedException -> 0x00ed }
                java.util.Iterator r3 = r3.iterator()     // Catch:{ InterruptedException -> 0x00ed }
            L_0x0042:
                boolean r4 = r3.hasNext()     // Catch:{ InterruptedException -> 0x00ed }
                if (r4 == 0) goto L_0x000d
                java.lang.Object r4 = r3.next()     // Catch:{ InterruptedException -> 0x00ed }
                java.util.Map$Entry r4 = (java.util.Map.Entry) r4     // Catch:{ InterruptedException -> 0x00ed }
                java.lang.Object r5 = r4.getValue()     // Catch:{ InterruptedException -> 0x00ed }
                androidx.core.util.Pair r5 = (androidx.core.util.Pair) r5     // Catch:{ InterruptedException -> 0x00ed }
                java.lang.Object r6 = r5.first     // Catch:{ InterruptedException -> 0x00ed }
                android.net.Uri r6 = (android.net.Uri) r6     // Catch:{ InterruptedException -> 0x00ed }
                java.lang.Object r5 = r5.second     // Catch:{ IOException -> 0x0087 }
                java.io.BufferedOutputStream r5 = (java.io.BufferedOutputStream) r5     // Catch:{ IOException -> 0x0087 }
                if (r5 != 0) goto L_0x007c
                java.io.BufferedOutputStream r5 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x0087 }
                org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection r7 = org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection.this     // Catch:{ IOException -> 0x0087 }
                android.content.Context r7 = r7.context     // Catch:{ IOException -> 0x0087 }
                java.io.OutputStream r7 = com.o3dr.services.android.lib.util.UriUtils.getOutputStream(r7, r6)     // Catch:{ IOException -> 0x0087 }
                r5.<init>(r7)     // Catch:{ IOException -> 0x0087 }
                org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection r7 = org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection.this     // Catch:{ IOException -> 0x0087 }
                java.util.concurrent.ConcurrentHashMap r7 = r7.loggingOutStreams     // Catch:{ IOException -> 0x0087 }
                java.lang.Object r4 = r4.getKey()     // Catch:{ IOException -> 0x0087 }
                androidx.core.util.Pair r8 = androidx.core.util.Pair.create(r6, r5)     // Catch:{ IOException -> 0x0087 }
                r7.put(r4, r8)     // Catch:{ IOException -> 0x0087 }
            L_0x007c:
                byte[] r4 = r1.array()     // Catch:{ IOException -> 0x0087 }
                r5.write(r4)     // Catch:{ IOException -> 0x0087 }
                r5.write(r2)     // Catch:{ IOException -> 0x0087 }
                goto L_0x0042
            L_0x0087:
                r4 = move-exception
                org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection r5 = org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection.this     // Catch:{ InterruptedException -> 0x00ed }
                org.droidplanner.services.android.impl.core.model.Logger r5 = r5.mLogger     // Catch:{ InterruptedException -> 0x00ed }
                java.lang.String r7 = org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection.TAG     // Catch:{ InterruptedException -> 0x00ed }
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ InterruptedException -> 0x00ed }
                r8.<init>()     // Catch:{ InterruptedException -> 0x00ed }
                java.lang.String r9 = "IO Exception while writing to "
                r8.append(r9)     // Catch:{ InterruptedException -> 0x00ed }
                r8.append(r6)     // Catch:{ InterruptedException -> 0x00ed }
                java.lang.String r6 = r8.toString()     // Catch:{ InterruptedException -> 0x00ed }
                r5.logErr(r7, r6, r4)     // Catch:{ InterruptedException -> 0x00ed }
                goto L_0x0042
            L_0x00a5:
                org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection r1 = org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection.this
                java.util.concurrent.ConcurrentHashMap r1 = r1.loggingOutStreams
                java.util.Collection r1 = r1.values()
                java.util.Iterator r1 = r1.iterator()
            L_0x00b3:
                boolean r2 = r1.hasNext()
                if (r2 == 0) goto L_0x0145
                java.lang.Object r2 = r1.next()
                androidx.core.util.Pair r2 = (androidx.core.util.Pair) r2
                java.lang.Object r3 = r2.first
                android.net.Uri r3 = (android.net.Uri) r3
                java.lang.Object r4 = r2.second     // Catch:{ IOException -> 0x00cf }
                if (r4 == 0) goto L_0x00b3
                java.lang.Object r2 = r2.second     // Catch:{ IOException -> 0x00cf }
                java.io.BufferedOutputStream r2 = (java.io.BufferedOutputStream) r2     // Catch:{ IOException -> 0x00cf }
                r2.close()     // Catch:{ IOException -> 0x00cf }
                goto L_0x00b3
            L_0x00cf:
                r2 = move-exception
                org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection r4 = org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection.this
                org.droidplanner.services.android.impl.core.model.Logger r4 = r4.mLogger
                java.lang.String r5 = org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection.TAG
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                r6.append(r0)
                r6.append(r3)
                java.lang.String r3 = r6.toString()
                r4.logErr(r5, r3, r2)
                goto L_0x00b3
            L_0x00eb:
                r1 = move-exception
                goto L_0x014f
            L_0x00ed:
                r1 = move-exception
                java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x00eb }
                if (r1 == 0) goto L_0x00ff
                org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection r2 = org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection.this     // Catch:{ all -> 0x00eb }
                org.droidplanner.services.android.impl.core.model.Logger r2 = r2.mLogger     // Catch:{ all -> 0x00eb }
                java.lang.String r3 = org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection.TAG     // Catch:{ all -> 0x00eb }
                r2.logVerbose(r3, r1)     // Catch:{ all -> 0x00eb }
            L_0x00ff:
                org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection r1 = org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection.this
                java.util.concurrent.ConcurrentHashMap r1 = r1.loggingOutStreams
                java.util.Collection r1 = r1.values()
                java.util.Iterator r1 = r1.iterator()
            L_0x010d:
                boolean r2 = r1.hasNext()
                if (r2 == 0) goto L_0x0145
                java.lang.Object r2 = r1.next()
                androidx.core.util.Pair r2 = (androidx.core.util.Pair) r2
                java.lang.Object r3 = r2.first
                android.net.Uri r3 = (android.net.Uri) r3
                java.lang.Object r4 = r2.second     // Catch:{ IOException -> 0x0129 }
                if (r4 == 0) goto L_0x010d
                java.lang.Object r2 = r2.second     // Catch:{ IOException -> 0x0129 }
                java.io.BufferedOutputStream r2 = (java.io.BufferedOutputStream) r2     // Catch:{ IOException -> 0x0129 }
                r2.close()     // Catch:{ IOException -> 0x0129 }
                goto L_0x010d
            L_0x0129:
                r2 = move-exception
                org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection r4 = org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection.this
                org.droidplanner.services.android.impl.core.model.Logger r4 = r4.mLogger
                java.lang.String r5 = org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection.TAG
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                r6.append(r0)
                r6.append(r3)
                java.lang.String r3 = r6.toString()
                r4.logErr(r5, r3, r2)
                goto L_0x010d
            L_0x0145:
                org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection r0 = org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection.this
                java.util.concurrent.ConcurrentHashMap r0 = r0.loggingOutStreams
                r0.clear()
                return
            L_0x014f:
                org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection r2 = org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection.this
                java.util.concurrent.ConcurrentHashMap r2 = r2.loggingOutStreams
                java.util.Collection r2 = r2.values()
                java.util.Iterator r2 = r2.iterator()
            L_0x015d:
                boolean r3 = r2.hasNext()
                if (r3 == 0) goto L_0x0195
                java.lang.Object r3 = r2.next()
                androidx.core.util.Pair r3 = (androidx.core.util.Pair) r3
                java.lang.Object r4 = r3.first
                android.net.Uri r4 = (android.net.Uri) r4
                java.lang.Object r5 = r3.second     // Catch:{ IOException -> 0x0179 }
                if (r5 == 0) goto L_0x015d
                java.lang.Object r3 = r3.second     // Catch:{ IOException -> 0x0179 }
                java.io.BufferedOutputStream r3 = (java.io.BufferedOutputStream) r3     // Catch:{ IOException -> 0x0179 }
                r3.close()     // Catch:{ IOException -> 0x0179 }
                goto L_0x015d
            L_0x0179:
                r3 = move-exception
                org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection r5 = org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection.this
                org.droidplanner.services.android.impl.core.model.Logger r5 = r5.mLogger
                java.lang.String r6 = org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection.TAG
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>()
                r7.append(r0)
                r7.append(r4)
                java.lang.String r4 = r7.toString()
                r5.logErr(r6, r4, r3)
                goto L_0x015d
            L_0x0195:
                org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection r0 = org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection.this
                java.util.concurrent.ConcurrentHashMap r0 = r0.loggingOutStreams
                r0.clear()
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection.C59304.run():void");
        }
    };
    private final Runnable mManagerTask = new Runnable() {
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0081, code lost:
            if (r3.isAlive() != false) goto L_0x00c8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c6, code lost:
            if (r3.isAlive() != false) goto L_0x00c8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x00c8, code lost:
            r3.interrupt();
         */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x00a5 A[Catch:{ all -> 0x00dc }] */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x00c2  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r8 = this;
                java.lang.String r0 = "Exiting manager thread."
                r1 = 0
                long r2 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x0095, all -> 0x0090 }
                org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection r4 = org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection.this     // Catch:{ IOException -> 0x0095, all -> 0x0090 }
                java.util.concurrent.atomic.AtomicLong r4 = r4.mConnectionTime     // Catch:{ IOException -> 0x0095, all -> 0x0090 }
                r4.set(r2)     // Catch:{ IOException -> 0x0095, all -> 0x0090 }
                org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection r4 = org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection.this     // Catch:{ IOException -> 0x0095, all -> 0x0090 }
                r4.reportConnect(r2)     // Catch:{ IOException -> 0x0095, all -> 0x0090 }
                org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection r2 = org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection.this     // Catch:{ IOException -> 0x0095, all -> 0x0090 }
                org.droidplanner.services.android.impl.core.model.Logger r2 = r2.mLogger     // Catch:{ IOException -> 0x0095, all -> 0x0090 }
                java.lang.String r3 = org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection.TAG     // Catch:{ IOException -> 0x0095, all -> 0x0090 }
                java.lang.String r4 = "Starting sender thread."
                r2.logInfo(r3, r4)     // Catch:{ IOException -> 0x0095, all -> 0x0090 }
                java.lang.Thread r2 = new java.lang.Thread     // Catch:{ IOException -> 0x0095, all -> 0x0090 }
                org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection r3 = org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection.this     // Catch:{ IOException -> 0x0095, all -> 0x0090 }
                java.lang.Runnable r3 = r3.mSendingTask     // Catch:{ IOException -> 0x0095, all -> 0x0090 }
                java.lang.String r4 = "MavLinkConnection-Sending Thread"
                r2.<init>(r3, r4)     // Catch:{ IOException -> 0x0095, all -> 0x0090 }
                r2.start()     // Catch:{ IOException -> 0x008b, all -> 0x0086 }
                org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection r3 = org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection.this     // Catch:{ IOException -> 0x008b, all -> 0x0086 }
                org.droidplanner.services.android.impl.core.model.Logger r3 = r3.mLogger     // Catch:{ IOException -> 0x008b, all -> 0x0086 }
                java.lang.String r4 = org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection.TAG     // Catch:{ IOException -> 0x008b, all -> 0x0086 }
                java.lang.String r5 = "Starting logging thread."
                r3.logInfo(r4, r5)     // Catch:{ IOException -> 0x008b, all -> 0x0086 }
                java.lang.Thread r3 = new java.lang.Thread     // Catch:{ IOException -> 0x008b, all -> 0x0086 }
                org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection r4 = org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection.this     // Catch:{ IOException -> 0x008b, all -> 0x0086 }
                java.lang.Runnable r4 = r4.mLoggingTask     // Catch:{ IOException -> 0x008b, all -> 0x0086 }
                java.lang.String r5 = "MavLinkConnection-Logging Thread"
                r3.<init>(r4, r5)     // Catch:{ IOException -> 0x008b, all -> 0x0086 }
                r3.start()     // Catch:{ IOException -> 0x0084 }
                com.atakmap.android.uastool.MAVLink.Parser r1 = new com.atakmap.android.uastool.MAVLink.Parser     // Catch:{ IOException -> 0x0084 }
                r1.<init>()     // Catch:{ IOException -> 0x0084 }
                com.atakmap.android.uastool.MAVLink.Messages.MAVLinkStats r4 = r1.stats     // Catch:{ IOException -> 0x0084 }
                r4.resetStats()     // Catch:{ IOException -> 0x0084 }
                r4 = 4096(0x1000, float:5.74E-42)
                byte[] r4 = new byte[r4]     // Catch:{ IOException -> 0x0084 }
            L_0x005d:
                org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection r5 = org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection.this     // Catch:{ IOException -> 0x0084 }
                java.util.concurrent.atomic.AtomicInteger r5 = r5.mConnectionStatus     // Catch:{ IOException -> 0x0084 }
                int r5 = r5.get()     // Catch:{ IOException -> 0x0084 }
                r6 = 2
                if (r5 != r6) goto L_0x0074
                org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection r5 = org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection.this     // Catch:{ IOException -> 0x0084 }
                int r5 = r5.readDataBlock(r4)     // Catch:{ IOException -> 0x0084 }
                r8.handleData(r1, r5, r4)     // Catch:{ IOException -> 0x0084 }
                goto L_0x005d
            L_0x0074:
                boolean r1 = r2.isAlive()
                if (r1 == 0) goto L_0x007d
                r2.interrupt()
            L_0x007d:
                boolean r1 = r3.isAlive()
                if (r1 == 0) goto L_0x00cb
                goto L_0x00c8
            L_0x0084:
                r1 = move-exception
                goto L_0x0099
            L_0x0086:
                r3 = move-exception
                r7 = r3
                r3 = r1
                r1 = r7
                goto L_0x00dd
            L_0x008b:
                r3 = move-exception
                r7 = r3
                r3 = r1
                r1 = r7
                goto L_0x0099
            L_0x0090:
                r2 = move-exception
                r3 = r1
                r1 = r2
                r2 = r3
                goto L_0x00dd
            L_0x0095:
                r2 = move-exception
                r3 = r1
                r1 = r2
                r2 = r3
            L_0x0099:
                org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection r4 = org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection.this     // Catch:{ all -> 0x00dc }
                java.util.concurrent.atomic.AtomicInteger r4 = r4.mConnectionStatus     // Catch:{ all -> 0x00dc }
                int r4 = r4.get()     // Catch:{ all -> 0x00dc }
                if (r4 == 0) goto L_0x00b5
                org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection r4 = org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection.this     // Catch:{ all -> 0x00dc }
                r4.reportIOException(r1)     // Catch:{ all -> 0x00dc }
                org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection r4 = org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection.this     // Catch:{ all -> 0x00dc }
                org.droidplanner.services.android.impl.core.model.Logger r4 = r4.mLogger     // Catch:{ all -> 0x00dc }
                java.lang.String r5 = org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection.TAG     // Catch:{ all -> 0x00dc }
                r4.logErr((java.lang.String) r5, (java.lang.Exception) r1)     // Catch:{ all -> 0x00dc }
            L_0x00b5:
                if (r2 == 0) goto L_0x00c0
                boolean r1 = r2.isAlive()
                if (r1 == 0) goto L_0x00c0
                r2.interrupt()
            L_0x00c0:
                if (r3 == 0) goto L_0x00cb
                boolean r1 = r3.isAlive()
                if (r1 == 0) goto L_0x00cb
            L_0x00c8:
                r3.interrupt()
            L_0x00cb:
                org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection r1 = org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection.this
                r1.disconnect()
                org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection r1 = org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection.this
                org.droidplanner.services.android.impl.core.model.Logger r1 = r1.mLogger
                java.lang.String r2 = org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection.TAG
                r1.logInfo(r2, r0)
                return
            L_0x00dc:
                r1 = move-exception
            L_0x00dd:
                if (r2 == 0) goto L_0x00e8
                boolean r4 = r2.isAlive()
                if (r4 == 0) goto L_0x00e8
                r2.interrupt()
            L_0x00e8:
                if (r3 == 0) goto L_0x00f3
                boolean r2 = r3.isAlive()
                if (r2 == 0) goto L_0x00f3
                r3.interrupt()
            L_0x00f3:
                org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection r2 = org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection.this
                r2.disconnect()
                org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection r2 = org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection.this
                org.droidplanner.services.android.impl.core.model.Logger r2 = r2.mLogger
                java.lang.String r3 = org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection.TAG
                r2.logInfo(r3, r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection.C59282.run():void");
        }

        private void handleData(Parser parser, int i, byte[] bArr) {
            if (i >= 1) {
                for (int i2 = 0; i2 < i; i2++) {
                    MAVLinkPacket mavlink_parse_char = parser.mavlink_parse_char(bArr[i2] & 255);
                    if (mavlink_parse_char != null) {
                        MavLinkConnection.this.queueToLog(mavlink_parse_char);
                        MavLinkConnection.this.reportReceivedPacket(mavlink_parse_char);
                    }
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public final LinkedBlockingQueue<byte[]> mPacketsToLog = new LinkedBlockingQueue<>();
    /* access modifiers changed from: private */
    public final LinkedBlockingQueue<byte[]> mPacketsToSend = new LinkedBlockingQueue<>();
    /* access modifiers changed from: private */
    public final Runnable mSendingTask = new Runnable() {
        public void run() {
            while (MavLinkConnection.this.mConnectionStatus.get() == 2) {
                try {
                    byte[] bArr = (byte[]) MavLinkConnection.this.mPacketsToSend.take();
                    try {
                        MavLinkConnection.this.sendBuffer(bArr);
                        MavLinkConnection.this.queueToLog(bArr);
                    } catch (IOException e) {
                        MavLinkConnection.this.reportIOException(e);
                        MavLinkConnection.this.mLogger.logErr(MavLinkConnection.TAG, (Exception) e);
                    }
                } catch (InterruptedException e2) {
                    MavLinkConnection.this.mLogger.logVerbose(MavLinkConnection.TAG, e2.getMessage());
                } catch (Throwable th) {
                    MavLinkConnection.this.disconnect();
                    throw th;
                }
            }
            MavLinkConnection.this.disconnect();
        }
    };
    private Thread mTaskThread;

    /* access modifiers changed from: protected */
    public abstract void closeConnection();

    public abstract int getConnectionType();

    /* access modifiers changed from: protected */
    public abstract Logger initLogger();

    /* access modifiers changed from: protected */
    public abstract void loadPreferences();

    /* access modifiers changed from: protected */
    public abstract void openConnection(Bundle bundle);

    /* access modifiers changed from: protected */
    public abstract int readDataBlock(byte[] bArr);

    /* access modifiers changed from: protected */
    public abstract void sendBuffer(byte[] bArr);

    private int getErrorCode(IOException iOException) {
        return iOException instanceof BindException ? -6 : -7;
    }

    protected MavLinkConnection(Context context2) {
        this.context = context2;
    }

    public void connect(Bundle bundle) {
        if (this.mConnectionStatus.compareAndSet(0, 1)) {
            this.extrasHolder.set(bundle);
            this.mLogger.logInfo(TAG, "Starting connection thread.");
            Thread thread = new Thread(this.mConnectingTask, "MavLinkConnection-Connecting Thread");
            this.mConnectThread = thread;
            thread.start();
            reportConnecting();
        }
    }

    /* access modifiers changed from: protected */
    public void onConnectionOpened(Bundle bundle) {
        if (this.mConnectionStatus.compareAndSet(1, 2)) {
            this.extrasHolder.set(bundle);
            this.mLogger.logInfo(TAG, "Starting manager thread.");
            Thread thread = new Thread(this.mManagerTask, "MavLinkConnection-Manager Thread");
            this.mTaskThread = thread;
            thread.start();
        }
    }

    /* access modifiers changed from: protected */
    public void onConnectionStatus(LinkConnectionStatus linkConnectionStatus) {
        reportConnectionStatus(linkConnectionStatus);
        String statusCode = linkConnectionStatus.getStatusCode();
        statusCode.hashCode();
        if (statusCode.equals(LinkConnectionStatus.FAILED)) {
            Logger logger = this.mLogger;
            String str = TAG;
            logger.logInfo(str, "Unable to establish connection: " + linkConnectionStatus.getStatusCode());
            disconnect();
        }
    }

    public void disconnect() {
        if (this.mConnectionStatus.get() == 0) {
            return;
        }
        if (this.mConnectThread != null || this.mTaskThread != null) {
            try {
                this.mConnectionStatus.set(0);
                this.mConnectionTime.set(-1);
                this.extrasHolder.set((Object) null);
                Thread thread = this.mConnectThread;
                if (thread != null && thread.isAlive() && !this.mConnectThread.isInterrupted()) {
                    this.mConnectThread.interrupt();
                }
                Thread thread2 = this.mTaskThread;
                if (thread2 != null && thread2.isAlive() && !this.mTaskThread.isInterrupted()) {
                    this.mTaskThread.interrupt();
                }
                closeConnection();
                reportDisconnect();
            } catch (IOException e) {
                this.mLogger.logErr(TAG, (Exception) e);
                reportIOException(e);
            }
        }
    }

    public int getConnectionStatus() {
        return this.mConnectionStatus.get();
    }

    public void sendMavPacket(MAVLinkPacket mAVLinkPacket) {
        if (!this.mPacketsToSend.offer(mAVLinkPacket.encodePacket())) {
            this.mLogger.logErr(TAG, "Unable to send mavlink packet. Packet queue is full!");
        }
    }

    /* access modifiers changed from: private */
    public void queueToLog(MAVLinkPacket mAVLinkPacket) {
        if (mAVLinkPacket != null) {
            queueToLog(mAVLinkPacket.encodePacket());
        }
    }

    /* access modifiers changed from: private */
    public void queueToLog(byte[] bArr) {
        if (bArr != null && !this.mPacketsToLog.offer(bArr)) {
            this.mLogger.logErr(TAG, "Unable to log mavlink packet. Queue is full!");
        }
    }

    public void addLoggingPath(String str, Uri uri) {
        if (str != null && str.length() != 0 && uri != null && !this.loggingOutStreams.contains(str)) {
            this.loggingOutStreams.put(str, Pair.create(uri, (Object) null));
        }
    }

    public void removeLoggingPath(String str) {
        Pair pair;
        BufferedOutputStream bufferedOutputStream;
        if (str != null && str.length() != 0 && (pair = (Pair) this.loggingOutStreams.remove(str)) != null && (bufferedOutputStream = (BufferedOutputStream) pair.second) != null) {
            try {
                bufferedOutputStream.close();
            } catch (IOException e) {
                Logger logger = this.mLogger;
                String str2 = TAG;
                logger.logErr(str2, "IO Exception while closing " + pair.first, e);
            }
        }
    }

    public void addMavLinkConnectionListener(String str, MavLinkConnectionListener mavLinkConnectionListener) {
        this.mListeners.put(str, mavLinkConnectionListener);
        if (getConnectionStatus() == 2) {
            Bundle bundle = new Bundle();
            bundle.putLong(LinkConnectionStatus.EXTRA_CONNECTION_TIME, this.mConnectionTime.get());
            mavLinkConnectionListener.onConnectionStatus(new LinkConnectionStatus(LinkConnectionStatus.CONNECTED, bundle));
        }
    }

    public int getMavLinkConnectionListenersCount() {
        return this.mListeners.size();
    }

    public Bundle getConnectionExtras() {
        return this.extrasHolder.get();
    }

    public boolean hasMavLinkConnectionListener(String str) {
        return this.mListeners.containsKey(str);
    }

    public void removeMavLinkConnectionListener(String str) {
        this.mListeners.remove(str);
    }

    public void removeAllMavLinkConnectionListeners() {
        this.mListeners.clear();
    }

    /* access modifiers changed from: protected */
    public Logger getLogger() {
        return this.mLogger;
    }

    /* access modifiers changed from: protected */
    public void reportConnectionStatus(LinkConnectionStatus linkConnectionStatus) {
        if (!this.mListeners.isEmpty()) {
            for (MavLinkConnectionListener onConnectionStatus : this.mListeners.values()) {
                onConnectionStatus.onConnectionStatus(linkConnectionStatus);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void reportConnecting() {
        reportConnectionStatus(new LinkConnectionStatus(LinkConnectionStatus.CONNECTING, (Bundle) null));
    }

    /* access modifiers changed from: protected */
    public void reportConnect(long j) {
        Bundle bundle = new Bundle();
        bundle.putLong(LinkConnectionStatus.EXTRA_CONNECTION_TIME, j);
        reportConnectionStatus(new LinkConnectionStatus(LinkConnectionStatus.CONNECTED, bundle));
    }

    /* access modifiers changed from: protected */
    public void reportDisconnect() {
        reportConnectionStatus(new LinkConnectionStatus(LinkConnectionStatus.DISCONNECTED, (Bundle) null));
    }

    /* access modifiers changed from: private */
    public void reportReceivedPacket(MAVLinkPacket mAVLinkPacket) {
        if (!this.mListeners.isEmpty()) {
            for (MavLinkConnectionListener onReceivePacket : this.mListeners.values()) {
                onReceivePacket.onReceivePacket(mAVLinkPacket);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void reportIOException(IOException iOException) {
        reportConnectionStatus(LinkConnectionStatus.newFailedConnectionStatus(getErrorCode(iOException), iOException.getMessage()));
    }
}

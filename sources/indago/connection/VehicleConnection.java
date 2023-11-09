package indago.connection;

import atakplugin.UASTool.aon;
import atakplugin.UASTool.aoo;
import atakplugin.UASTool.aot;
import atakplugin.UASTool.apc;
import atakplugin.UASTool.apv;
import atakplugin.UASTool.aqr;
import atakplugin.UASTool.bfq;
import atakplugin.UASTool.bgk;
import atakplugin.UASTool.bgl;
import atakplugin.UASTool.bgp;
import atakplugin.UASTool.bjr;
import atakplugin.UASTool.brw;
import atakplugin.UASTool.bsb;
import com.atakmap.android.uastool.tasks.UASTask;
import indago.datastructures.Buffer;
import indago.location.GeoLocation;
import indago.location.GeoPolygon;
import indago.messages.ChangeFlightMode;
import indago.messages.CheckFlightReadiness;
import indago.messages.DesiredSearchArea;
import indago.messages.EventMessage;
import indago.messages.FlightAction;
import indago.messages.HomeGeolocation;
import indago.messages.LoadFlightPlan;
import indago.messages.LookAtPosition;
import indago.messages.MessageData;
import indago.messages.PayloadControl;
import indago.messages.SavedFlightPlans;
import indago.messages.VehicleKinematicData;
import indago.messages.VehicleStatus;
import indago.messages.VideoGeolocation;
import indago.serialization.JsonKeyConstants;
import indago.serialization.JsonSerializer;
import indago.serialization.MessageDeserializationCallback;
import indago.serialization.MessageSerializer;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002TUBO\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u000e\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u001cJ\u000e\u0010/\u001a\u00020-2\u0006\u0010.\u001a\u00020!J\u0006\u00100\u001a\u00020-J\u0006\u00101\u001a\u00020-J\u001e\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002052\u0006\u00107\u001a\u000205J\u0012\u00108\u001a\u00020-2\b\u00109\u001a\u0004\u0018\u00010:H\u0002J\b\u0010;\u001a\u00020-H\u0002J\u001e\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u0002052\u0006\u0010?\u001a\u0002052\u0006\u0010@\u001a\u000205J\u000e\u0010A\u001a\u00020-2\u0006\u0010.\u001a\u00020\u001cJ\u000e\u0010B\u001a\u00020-2\u0006\u0010.\u001a\u00020!J\u000e\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020FJ\u000e\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020\u0003J\u000e\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u000205J\u000e\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020PJ\u0018\u0010Q\u001a\u00020-2\u0006\u0010R\u001a\u00020\f2\u0006\u0010S\u001a\u00020\u0003H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u001bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0013R\"\u0010#\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00030%\u0018\u00010$X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006V"}, mo1538e = {"Lindago/connection/VehicleConnection;", "", "address", "", "name", "connectionTimeoutMillis", "", "ignoreMalformedData", "", "ignoreUnknownMessageTypes", "ignoreErrorsInOutgoingMessages", "messageBufferSize", "", "serializer", "Lindago/serialization/MessageSerializer;", "executorService", "Ljava/util/concurrent/ExecutorService;", "(Ljava/lang/String;Ljava/lang/String;JZZZILindago/serialization/MessageSerializer;Ljava/util/concurrent/ExecutorService;)V", "getAddress", "()Ljava/lang/String;", "client", "Lokhttp3/OkHttpClient;", "getClient", "()Lokhttp3/OkHttpClient;", "client$delegate", "Lkotlin/Lazy;", "connectionStateListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lindago/connection/ConnectionStateCallback;", "<set-?>", "isOpen", "()Z", "messageListeners", "Lindago/connection/MessageReceivedCallback;", "getName", "outgoingMessageBuffer", "Lindago/datastructures/Buffer;", "Lkotlin/Pair;", "outgoingMessageNumber", "socket", "Lokhttp3/WebSocket;", "socketListener", "Lindago/connection/SocketListener;", "syncRoot", "addConnectionStateListener", "", "listener", "addMessageListener", "connect", "disconnect", "lookAtPosition", "Lindago/messages/LookAtPosition;", "lat", "", "lon", "alt_msl", "onClosed", "error", "", "onOpened", "payloadConrol", "Lindago/messages/PayloadControl;", "azimuthRate_percent", "elevationRate_percent", "zoomRate_percent", "removeConnectionStateListener", "removeMessageListener", "requestFlightActionChange", "Lindago/messages/ChangeFlightMode;", "desiredFlightAction", "Lindago/messages/FlightAction;", "requestFlightPlanBeLoaded", "Lindago/messages/LoadFlightPlan;", "flightPlanName", "requestFlightReadinessCheck", "Lindago/messages/CheckFlightReadiness;", "observedTrueHeading", "requestSearchArea", "Lindago/messages/DesiredSearchArea;", "polygon", "Lindago/location/GeoPolygon;", "sendAndBufferMessageData", "messageNumber", "data", "Builder", "IncomingMessageProxy", "indago"})
public final class VehicleConnection {
    static final /* synthetic */ bjr[] $$delegatedProperties = {bgp.m6707a((bgk) new bgl(bgp.m6715b(VehicleConnection.class), "client", "getClient()Lokhttp3/OkHttpClient;"))};
    private final String address;
    private final aon client$delegate;
    private final CopyOnWriteArrayList<ConnectionStateCallback> connectionStateListeners;
    private final ExecutorService executorService;
    /* access modifiers changed from: private */
    public final boolean ignoreErrorsInOutgoingMessages;
    private final boolean ignoreMalformedData;
    private final boolean ignoreUnknownMessageTypes;
    private volatile boolean isOpen;
    /* access modifiers changed from: private */
    public final CopyOnWriteArrayList<MessageReceivedCallback> messageListeners;
    private final String name;
    /* access modifiers changed from: private */
    public final Buffer<apc<Integer, String>> outgoingMessageBuffer;
    private int outgoingMessageNumber;
    private final MessageSerializer serializer;
    private volatile WebSocket socket;
    private SocketListener socketListener;
    /* access modifiers changed from: private */
    public final Object syncRoot;

    private final brw getClient() {
        aon aon = this.client$delegate;
        bjr bjr = $$delegatedProperties[0];
        return (brw) aon.mo1522b();
    }

    private VehicleConnection(String str, String str2, long j, boolean z, boolean z2, boolean z3, int i, MessageSerializer messageSerializer, ExecutorService executorService2) {
        this.address = str;
        this.name = str2;
        this.ignoreMalformedData = z;
        this.ignoreUnknownMessageTypes = z2;
        this.ignoreErrorsInOutgoingMessages = z3;
        this.serializer = messageSerializer;
        this.executorService = executorService2;
        this.client$delegate = aoo.m2492a(new VehicleConnection$client$2(j));
        this.syncRoot = new Object();
        this.outgoingMessageBuffer = (z3 || i <= 2) ? null : new Buffer<>(i);
        this.connectionStateListeners = new CopyOnWriteArrayList<>();
        this.messageListeners = new CopyOnWriteArrayList<>();
    }

    public /* synthetic */ VehicleConnection(String str, String str2, long j, boolean z, boolean z2, boolean z3, int i, MessageSerializer messageSerializer, ExecutorService executorService2, bfd bfd) {
        this(str, str2, j, z, z2, z3, i, messageSerializer, executorService2);
    }

    public final String getAddress() {
        return this.address;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean isOpen() {
        return this.isOpen;
    }

    public final void addConnectionStateListener(ConnectionStateCallback connectionStateCallback) {
        bfq.m6567f(connectionStateCallback, "listener");
        this.connectionStateListeners.addIfAbsent(connectionStateCallback);
    }

    public final void removeConnectionStateListener(ConnectionStateCallback connectionStateCallback) {
        bfq.m6567f(connectionStateCallback, "listener");
        this.connectionStateListeners.remove(connectionStateCallback);
    }

    public final void addMessageListener(MessageReceivedCallback messageReceivedCallback) {
        bfq.m6567f(messageReceivedCallback, "listener");
        this.messageListeners.addIfAbsent(messageReceivedCallback);
    }

    public final void removeMessageListener(MessageReceivedCallback messageReceivedCallback) {
        bfq.m6567f(messageReceivedCallback, "listener");
        this.messageListeners.remove(messageReceivedCallback);
    }

    public final void connect() {
        synchronized (this.syncRoot) {
            if (!this.isOpen) {
                bsb d = new bsb.C0234a().mo3360a(this.address).mo3371d();
                WebSocketListener socketListener2 = new SocketListener(this.serializer, this.ignoreMalformedData, this.ignoreUnknownMessageTypes, this.executorService, new VehicleConnection$connect$1$listener$1(this), new VehicleConnection$connect$1$listener$2(this));
                this.serializer.setDeserializationCallback(new IncomingMessageProxy());
                this.socketListener = socketListener2;
                this.socket = getClient().newWebSocket(d, socketListener2);
            }
            aqr aqr = aqr.f2177a;
        }
    }

    /* access modifiers changed from: private */
    public final void onOpened() {
        this.isOpen = true;
        for (ConnectionStateCallback onConnected : this.connectionStateListeners) {
            onConnected.onConnected(this);
        }
    }

    /* access modifiers changed from: private */
    public final void onClosed(Throwable th) {
        this.isOpen = false;
        for (ConnectionStateCallback onDisconnected : this.connectionStateListeners) {
            onDisconnected.onDisconnected(this, th);
        }
    }

    public final void disconnect() {
        synchronized (this.syncRoot) {
            SocketListener socketListener2 = this.socketListener;
            if (socketListener2 != null) {
                socketListener2.dispose();
            }
            this.socketListener = null;
            WebSocket webSocket = this.socket;
            if (webSocket != null) {
                Boolean.valueOf(webSocket.close(1000, (String) null));
            }
        }
    }

    public final ChangeFlightMode requestFlightActionChange(FlightAction flightAction) {
        ChangeFlightMode changeFlightMode;
        bfq.m6567f(flightAction, "desiredFlightAction");
        synchronized (this.syncRoot) {
            int i = this.outgoingMessageNumber;
            this.outgoingMessageNumber = i + 1;
            changeFlightMode = new ChangeFlightMode(MessageData.Companion.createDefaultDataToServer$indago(this.name, i), flightAction);
            sendAndBufferMessageData(i, this.serializer.serializeChangeFlightMode(changeFlightMode));
        }
        return changeFlightMode;
    }

    public final CheckFlightReadiness requestFlightReadinessCheck(double d) {
        CheckFlightReadiness checkFlightReadiness;
        synchronized (this.syncRoot) {
            int i = this.outgoingMessageNumber;
            this.outgoingMessageNumber = i + 1;
            checkFlightReadiness = new CheckFlightReadiness(MessageData.Companion.createDefaultDataToServer$indago(this.name, i), d);
            sendAndBufferMessageData(i, this.serializer.serializeCheckFlightReadiness(checkFlightReadiness));
        }
        return checkFlightReadiness;
    }

    public final DesiredSearchArea requestSearchArea(GeoPolygon geoPolygon) {
        DesiredSearchArea desiredSearchArea;
        bfq.m6567f(geoPolygon, JsonKeyConstants.POLYGON);
        synchronized (this.syncRoot) {
            int i = this.outgoingMessageNumber;
            this.outgoingMessageNumber = i + 1;
            desiredSearchArea = new DesiredSearchArea(MessageData.Companion.createDefaultDataToServer$indago(this.name, i), geoPolygon);
            sendAndBufferMessageData(i, this.serializer.serializeDesiredSearchArea(desiredSearchArea));
        }
        return desiredSearchArea;
    }

    public final LoadFlightPlan requestFlightPlanBeLoaded(String str) {
        LoadFlightPlan loadFlightPlan;
        bfq.m6567f(str, "flightPlanName");
        synchronized (this.syncRoot) {
            int i = this.outgoingMessageNumber;
            this.outgoingMessageNumber = i + 1;
            loadFlightPlan = new LoadFlightPlan(MessageData.Companion.createDefaultDataToServer$indago(this.name, i), str);
            sendAndBufferMessageData(i, this.serializer.serializeLoadFlightPlan(loadFlightPlan));
        }
        return loadFlightPlan;
    }

    public final PayloadControl payloadConrol(double d, double d2, double d3) {
        PayloadControl payloadControl;
        synchronized (this.syncRoot) {
            int i = this.outgoingMessageNumber;
            this.outgoingMessageNumber = i + 1;
            payloadControl = new PayloadControl(MessageData.Companion.createDefaultDataToServer$indago(this.name, i), Double.valueOf(d), Double.valueOf(d2), Double.valueOf(d3));
            sendAndBufferMessageData(i, this.serializer.serializePayloadControl(payloadControl));
        }
        return payloadControl;
    }

    public final LookAtPosition lookAtPosition(double d, double d2, double d3) {
        LookAtPosition lookAtPosition;
        synchronized (this.syncRoot) {
            int i = this.outgoingMessageNumber;
            this.outgoingMessageNumber = i + 1;
            lookAtPosition = new LookAtPosition(MessageData.Companion.createDefaultDataToServer$indago(this.name, i), new GeoLocation(d, d2, Double.valueOf(d3)));
            sendAndBufferMessageData(i, this.serializer.serializeLookAtPosition(lookAtPosition));
        }
        return lookAtPosition;
    }

    private final void sendAndBufferMessageData(int i, String str) {
        WebSocket webSocket = this.socket;
        if (webSocket != null) {
            Buffer<apc<Integer, String>> buffer = this.outgoingMessageBuffer;
            if (buffer != null) {
                buffer.add(apv.m2659a(Integer.valueOf(i), str));
            }
            webSocket.send(str);
            return;
        }
        throw new IllegalStateException("Socket must be connected prior to sending data");
    }

    @aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\rJ\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\rJ\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\rJ\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, mo1538e = {"Lindago/connection/VehicleConnection$Builder;", "", "address", "", "(Ljava/lang/String;)V", "connectionTimeoutMillis", "", "executorService", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "messageBufferSize", "name", "shouldIgnoreErrorsInOutgoingMessages", "", "shouldIgnoreIncomingMalformedData", "shouldIgnoreUnknownIncomingMessages", "build", "Lindago/connection/VehicleConnection;", "timeout", "ignoreErrorsInOutgoingMessages", "ignore", "ignoreIncomingMalformedData", "ignoreUnknownIncomingMessages", "indago"})
    public static final class Builder {
        private final String address;
        private int connectionTimeoutMillis = 20000;
        private ExecutorService executorService = Executors.newFixedThreadPool(5);
        private int messageBufferSize = 50;
        private String name = "Client";
        private boolean shouldIgnoreErrorsInOutgoingMessages;
        private boolean shouldIgnoreIncomingMalformedData = true;
        private boolean shouldIgnoreUnknownIncomingMessages = true;

        public Builder(String str) {
            bfq.m6567f(str, "address");
            this.address = str;
        }

        public final Builder name(String str) {
            bfq.m6567f(str, UASTask.COTDETAIL_NAME);
            this.name = str;
            return this;
        }

        public final Builder connectionTimeoutMillis(int i) {
            this.connectionTimeoutMillis = i;
            return this;
        }

        public final Builder ignoreIncomingMalformedData(boolean z) {
            this.shouldIgnoreIncomingMalformedData = z;
            return this;
        }

        public final Builder ignoreUnknownIncomingMessages(boolean z) {
            this.shouldIgnoreUnknownIncomingMessages = z;
            return this;
        }

        public final Builder ignoreErrorsInOutgoingMessages(boolean z) {
            this.shouldIgnoreErrorsInOutgoingMessages = z;
            return this;
        }

        public final Builder executorService(ExecutorService executorService2) {
            bfq.m6567f(executorService2, "executorService");
            this.executorService = executorService2;
            return this;
        }

        public final VehicleConnection build() {
            ExecutorService executorService2 = this.executorService;
            bfq.m6554b(executorService2, "executorService");
            return new VehicleConnection(this.address, this.name, (long) this.connectionTimeoutMillis, this.shouldIgnoreIncomingMalformedData, this.shouldIgnoreUnknownIncomingMessages, this.shouldIgnoreErrorsInOutgoingMessages, this.messageBufferSize, new JsonSerializer(), executorService2, (bfd) null);
        }
    }

    @aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020$H\u0016¨\u0006%"}, mo1538e = {"Lindago/connection/VehicleConnection$IncomingMessageProxy;", "Lindago/serialization/MessageDeserializationCallback;", "(Lindago/connection/VehicleConnection;)V", "onChangeFlightModeDeserialized", "", "flightMode", "Lindago/messages/ChangeFlightMode;", "onCheckFlightReadinessDeserialized", "checkFlightReadiness", "Lindago/messages/CheckFlightReadiness;", "onDesiredSearchAreaDeserialized", "desiredSearchArea", "Lindago/messages/DesiredSearchArea;", "onEventMessageDeserialized", "eventMessage", "Lindago/messages/EventMessage;", "onHomeGeolocationDeserialized", "homeGeolocation", "Lindago/messages/HomeGeolocation;", "onLoadFlightPlanDeserialized", "loadFlightPlan", "Lindago/messages/LoadFlightPlan;", "onSavedFlightPlansDeserialized", "savedFlightPlans", "Lindago/messages/SavedFlightPlans;", "onUnsupportedMessageAdvisoryDeserialized", "unsupportedMessageAdvisory", "Lindago/messages/UnsupportedMessageAdvisory;", "onVehicleKinematicDataDeserialized", "vehicleKinematicData", "Lindago/messages/VehicleKinematicData;", "onVehicleStatusDeserialized", "vehicleStatus", "Lindago/messages/VehicleStatus;", "onVideoGeolocationDeserialized", "videoGeolocation", "Lindago/messages/VideoGeolocation;", "indago"})
    private final class IncomingMessageProxy implements MessageDeserializationCallback {
        public void onChangeFlightModeDeserialized(ChangeFlightMode changeFlightMode) {
            bfq.m6567f(changeFlightMode, JsonKeyConstants.FLIGHT_MODE);
        }

        public void onCheckFlightReadinessDeserialized(CheckFlightReadiness checkFlightReadiness) {
            bfq.m6567f(checkFlightReadiness, "checkFlightReadiness");
        }

        public void onDesiredSearchAreaDeserialized(DesiredSearchArea desiredSearchArea) {
            bfq.m6567f(desiredSearchArea, "desiredSearchArea");
        }

        public void onLoadFlightPlanDeserialized(LoadFlightPlan loadFlightPlan) {
            bfq.m6567f(loadFlightPlan, "loadFlightPlan");
        }

        public IncomingMessageProxy() {
        }

        public void onEventMessageDeserialized(EventMessage eventMessage) {
            bfq.m6567f(eventMessage, "eventMessage");
            for (MessageReceivedCallback onEventMessageReceived : VehicleConnection.this.messageListeners) {
                onEventMessageReceived.onEventMessageReceived(eventMessage);
            }
        }

        public void onHomeGeolocationDeserialized(HomeGeolocation homeGeolocation) {
            bfq.m6567f(homeGeolocation, "homeGeolocation");
            for (MessageReceivedCallback onHomeGeolocationMessageReceived : VehicleConnection.this.messageListeners) {
                onHomeGeolocationMessageReceived.onHomeGeolocationMessageReceived(homeGeolocation);
            }
        }

        public void onSavedFlightPlansDeserialized(SavedFlightPlans savedFlightPlans) {
            bfq.m6567f(savedFlightPlans, "savedFlightPlans");
            for (MessageReceivedCallback onSavedFlightPlansMessageReceived : VehicleConnection.this.messageListeners) {
                onSavedFlightPlansMessageReceived.onSavedFlightPlansMessageReceived(savedFlightPlans);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.String} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onUnsupportedMessageAdvisoryDeserialized(indago.messages.UnsupportedMessageAdvisory r6) {
            /*
                r5 = this;
                java.lang.String r0 = "unsupportedMessageAdvisory"
                atakplugin.UASTool.bfq.m6567f(r6, r0)
                indago.messages.MessageData r6 = r6.getMessageData()
                java.lang.Integer r6 = r6.getInReplyToMessageNumber()
                if (r6 == 0) goto L_0x0014
                int r6 = r6.intValue()
                goto L_0x0015
            L_0x0014:
                r6 = -1
            L_0x0015:
                indago.connection.VehicleConnection r0 = indago.connection.VehicleConnection.this
                boolean r0 = r0.ignoreErrorsInOutgoingMessages
                if (r0 != 0) goto L_0x009c
                indago.connection.VehicleConnection r0 = indago.connection.VehicleConnection.this
                java.lang.Object r0 = r0.syncRoot
                monitor-enter(r0)
                indago.connection.VehicleConnection r1 = indago.connection.VehicleConnection.this     // Catch:{ all -> 0x0099 }
                indago.datastructures.Buffer r1 = r1.outgoingMessageBuffer     // Catch:{ all -> 0x0099 }
                r2 = 0
                if (r1 == 0) goto L_0x005e
                java.lang.Iterable r1 = (java.lang.Iterable) r1     // Catch:{ all -> 0x0099 }
                java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0099 }
            L_0x0033:
                boolean r3 = r1.hasNext()     // Catch:{ all -> 0x0099 }
                if (r3 == 0) goto L_0x0052
                java.lang.Object r3 = r1.next()     // Catch:{ all -> 0x0099 }
                r4 = r3
                atakplugin.UASTool.apc r4 = (atakplugin.UASTool.apc) r4     // Catch:{ all -> 0x0099 }
                java.lang.Object r4 = r4.mo1546c()     // Catch:{ all -> 0x0099 }
                java.lang.Number r4 = (java.lang.Number) r4     // Catch:{ all -> 0x0099 }
                int r4 = r4.intValue()     // Catch:{ all -> 0x0099 }
                if (r4 != r6) goto L_0x004e
                r4 = 1
                goto L_0x004f
            L_0x004e:
                r4 = 0
            L_0x004f:
                if (r4 == 0) goto L_0x0033
                goto L_0x0053
            L_0x0052:
                r3 = r2
            L_0x0053:
                atakplugin.UASTool.apc r3 = (atakplugin.UASTool.apc) r3     // Catch:{ all -> 0x0099 }
                if (r3 == 0) goto L_0x005e
                java.lang.Object r1 = r3.mo1545b()     // Catch:{ all -> 0x0099 }
                r2 = r1
                java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0099 }
            L_0x005e:
                monitor-exit(r0)
                if (r2 == 0) goto L_0x007b
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Unsupported message ("
                r0.append(r1)
                r0.append(r6)
                java.lang.String r6 = ") was sent to the server. Sent data was: "
                r0.append(r6)
                r0.append(r2)
                java.lang.String r6 = r0.toString()
                goto L_0x0091
            L_0x007b:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Unsupported message ("
                r0.append(r1)
                r0.append(r6)
                java.lang.String r6 = ") was sent to the server. Sent data unavailable"
                r0.append(r6)
                java.lang.String r6 = r0.toString()
            L_0x0091:
                indago.errors.InvalidDataException r0 = new indago.errors.InvalidDataException
                r0.<init>(r6)
                java.lang.Throwable r0 = (java.lang.Throwable) r0
                throw r0
            L_0x0099:
                r6 = move-exception
                monitor-exit(r0)
                throw r6
            L_0x009c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: indago.connection.VehicleConnection.IncomingMessageProxy.onUnsupportedMessageAdvisoryDeserialized(indago.messages.UnsupportedMessageAdvisory):void");
        }

        public void onVehicleKinematicDataDeserialized(VehicleKinematicData vehicleKinematicData) {
            bfq.m6567f(vehicleKinematicData, "vehicleKinematicData");
            for (MessageReceivedCallback onVehicleKinematicMessageReceived : VehicleConnection.this.messageListeners) {
                onVehicleKinematicMessageReceived.onVehicleKinematicMessageReceived(vehicleKinematicData);
            }
        }

        public void onVehicleStatusDeserialized(VehicleStatus vehicleStatus) {
            bfq.m6567f(vehicleStatus, "vehicleStatus");
            for (MessageReceivedCallback onVehicleStatusMessageReceived : VehicleConnection.this.messageListeners) {
                onVehicleStatusMessageReceived.onVehicleStatusMessageReceived(vehicleStatus);
            }
        }

        public void onVideoGeolocationDeserialized(VideoGeolocation videoGeolocation) {
            bfq.m6567f(videoGeolocation, "videoGeolocation");
            for (MessageReceivedCallback onVideoGeolocationMessageReceived : VehicleConnection.this.messageListeners) {
                onVideoGeolocationMessageReceived.onVideoGeolocationMessageReceived(videoGeolocation);
            }
        }
    }
}

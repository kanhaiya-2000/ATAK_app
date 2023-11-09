package indago.connection;

import atakplugin.UASTool.aot;
import atakplugin.UASTool.aqr;
import atakplugin.UASTool.bdk;
import atakplugin.UASTool.bdl;
import atakplugin.UASTool.bfq;
import atakplugin.UASTool.bsh;
import indago.errors.InvalidDataException;
import indago.errors.InvalidPayloadException;
import indago.errors.MissingElementException;
import indago.serialization.MessageSerializer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0014\u0010\f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\u0010\u000fJ\u0006\u0010\u0012\u001a\u00020\u000bJ \u0010\f\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\"\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u000e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u0018H\u0016J\u0018\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001cH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u000b0\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, mo1538e = {"Lindago/connection/SocketListener;", "Lokhttp3/WebSocketListener;", "serializer", "Lindago/serialization/MessageSerializer;", "ignoreMalformedData", "", "ignoreUnknownMessageTypes", "executorService", "Ljava/util/concurrent/ExecutorService;", "onOpened", "Lkotlin/Function0;", "", "onClosed", "Lkotlin/Function1;", "", "(Lindago/serialization/MessageSerializer;ZZLjava/util/concurrent/ExecutorService;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "isDisposed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "dispose", "webSocket", "Lokhttp3/WebSocket;", "code", "", "reason", "", "onFailure", "t", "response", "Lokhttp3/Response;", "onMessage", "text", "onOpen", "indago"})
public final class SocketListener extends WebSocketListener {
    private final ExecutorService executorService;
    private final boolean ignoreMalformedData;
    private final boolean ignoreUnknownMessageTypes;
    private final AtomicBoolean isDisposed = new AtomicBoolean(false);
    private final bdl<Throwable, aqr> onClosed;
    private final bdk<aqr> onOpened;
    private final MessageSerializer serializer;

    public SocketListener(MessageSerializer messageSerializer, boolean z, boolean z2, ExecutorService executorService2, bdk<aqr> bdk, bdl<? super Throwable, aqr> bdl) {
        bfq.m6567f(messageSerializer, "serializer");
        bfq.m6567f(executorService2, "executorService");
        bfq.m6567f(bdk, "onOpened");
        bfq.m6567f(bdl, "onClosed");
        this.serializer = messageSerializer;
        this.ignoreMalformedData = z;
        this.ignoreUnknownMessageTypes = z2;
        this.executorService = executorService2;
        this.onOpened = bdk;
        this.onClosed = bdl;
    }

    public final void dispose() {
        this.isDisposed.set(true);
    }

    public void onOpen(WebSocket webSocket, bsh bsh) {
        bfq.m6567f(webSocket, "webSocket");
        bfq.m6567f(bsh, "response");
        if (!this.isDisposed.get()) {
            this.onOpened.invoke();
        }
    }

    public void onFailure(WebSocket webSocket, Throwable th, bsh bsh) {
        bfq.m6567f(webSocket, "webSocket");
        bfq.m6567f(th, "t");
        if (!this.isDisposed.get()) {
            this.onClosed.invoke(th);
        }
    }

    public void onMessage(WebSocket webSocket, String str) {
        bfq.m6567f(webSocket, "webSocket");
        bfq.m6567f(str, "text");
        if (!this.isDisposed.get()) {
            try {
                this.serializer.deserializeData(str);
            } catch (Exception e) {
                if (!(e instanceof InvalidDataException) && !(e instanceof MissingElementException)) {
                    if (!(e instanceof InvalidPayloadException)) {
                        throw e;
                    } else if (!this.ignoreUnknownMessageTypes) {
                        throw e;
                    }
                } else if (!this.ignoreMalformedData) {
                    throw e;
                }
            }
        }
    }

    public void onClosed(WebSocket webSocket, int i, String str) {
        bfq.m6567f(webSocket, "webSocket");
        bfq.m6567f(str, "reason");
        if (!this.isDisposed.get()) {
            this.onClosed.invoke(null);
        }
    }
}

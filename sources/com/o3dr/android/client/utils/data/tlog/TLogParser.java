package com.o3dr.android.client.utils.data.tlog;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Parser;
import com.o3dr.services.android.lib.util.UriUtils;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TLogParser {
    private static final TLogParserFilter DEFAULT_FILTER = new TLogParserFilter() {
        public boolean includeEvent(Event event) {
            return true;
        }

        public boolean shouldIterate() {
            return true;
        }
    };
    private static final String LOG_TAG = "TLogParser";
    private static final Parser parser = new Parser();

    private TLogParser() {
    }

    public static class TLogIterator {
        private static final TLogIteratorFilter DEFAULT_FILTER = new TLogIteratorFilter() {
            public boolean acceptEvent(Event event) {
                return true;
            }
        };
        private final Context context;
        private final Handler handler;

        /* renamed from: in */
        private DataInputStream f8604in;
        private final Uri uri;

        public TLogIterator(Context context2, Uri uri2) {
            this(context2, uri2, new Handler());
        }

        public TLogIterator(Context context2, Uri uri2, Handler handler2) {
            this.f8604in = null;
            this.context = context2;
            this.handler = handler2;
            this.uri = uri2;
        }

        public void start() {
            this.f8604in = new DataInputStream(new BufferedInputStream(UriUtils.getInputStream(this.context, this.uri)));
        }

        public void finish() {
            this.f8604in.close();
        }

        public void nextAsync(TLogIteratorCallback tLogIteratorCallback) {
            nextAsync(DEFAULT_FILTER, tLogIteratorCallback);
        }

        public void nextAsync(final TLogIteratorFilter tLogIteratorFilter, final TLogIteratorCallback tLogIteratorCallback) {
            TLogParser.getInstance().execute(new Runnable() {
                public void run() {
                    try {
                        Event blockingNext = TLogIterator.this.blockingNext(tLogIteratorFilter);
                        if (blockingNext != null) {
                            TLogIterator.this.sendResult(tLogIteratorCallback, blockingNext);
                        } else {
                            TLogIterator.this.sendFailed(tLogIteratorCallback, new NoSuchElementException());
                        }
                    } catch (IOException e) {
                        TLogIterator.this.sendFailed(tLogIteratorCallback, e);
                    }
                }
            });
        }

        public Event blockingNext() {
            return blockingNext(DEFAULT_FILTER);
        }

        public Event blockingNext(TLogIteratorFilter tLogIteratorFilter) {
            Event access$300 = TLogParser.next(this.f8604in);
            while (access$300 != null) {
                if (tLogIteratorFilter.acceptEvent(access$300)) {
                    return access$300;
                }
                access$300 = TLogParser.next(this.f8604in);
            }
            return null;
        }

        /* access modifiers changed from: private */
        public void sendResult(final TLogIteratorCallback tLogIteratorCallback, final Event event) {
            if (tLogIteratorCallback != null) {
                this.handler.post(new Runnable() {
                    public void run() {
                        tLogIteratorCallback.onResult(event);
                    }
                });
            }
        }

        /* access modifiers changed from: private */
        public void sendFailed(final TLogIteratorCallback tLogIteratorCallback, final Exception exc) {
            if (tLogIteratorCallback != null) {
                this.handler.post(new Runnable() {
                    public void run() {
                        tLogIteratorCallback.onFailed(exc);
                    }
                });
            }
        }
    }

    public static List<Event> getAllEvents(Context context, Uri uri) {
        return getAllEvents(context, uri, DEFAULT_FILTER);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0050 A[SYNTHETIC, Splitter:B:21:0x0050] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<com.o3dr.android.client.utils.data.tlog.TLogParser.Event> getAllEvents(android.content.Context r4, android.net.Uri r5, com.o3dr.android.client.utils.data.tlog.TLogParserFilter r6) {
        /*
            java.lang.String r0 = "Failed to close file "
            java.io.InputStream r4 = com.o3dr.services.android.lib.util.UriUtils.getInputStream(r4, r5)
            r1 = 0
            java.io.DataInputStream r2 = new java.io.DataInputStream     // Catch:{ all -> 0x004d }
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch:{ all -> 0x004d }
            r3.<init>(r4)     // Catch:{ all -> 0x004d }
            r2.<init>(r3)     // Catch:{ all -> 0x004d }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x004a }
            r4.<init>()     // Catch:{ all -> 0x004a }
            com.o3dr.android.client.utils.data.tlog.TLogParser$Event r1 = next(r2)     // Catch:{ all -> 0x004a }
        L_0x001a:
            if (r1 == 0) goto L_0x0030
            boolean r3 = r6.shouldIterate()     // Catch:{ all -> 0x004a }
            if (r3 == 0) goto L_0x0030
            boolean r3 = r6.includeEvent(r1)     // Catch:{ all -> 0x004a }
            if (r3 == 0) goto L_0x002b
            r4.add(r1)     // Catch:{ all -> 0x004a }
        L_0x002b:
            com.o3dr.android.client.utils.data.tlog.TLogParser$Event r1 = next(r2)     // Catch:{ all -> 0x004a }
            goto L_0x001a
        L_0x0030:
            r2.close()     // Catch:{ IOException -> 0x0034 }
            goto L_0x0049
        L_0x0034:
            r6 = move-exception
            java.lang.String r1 = LOG_TAG
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r5)
            java.lang.String r5 = r2.toString()
            android.util.Log.e(r1, r5, r6)
        L_0x0049:
            return r4
        L_0x004a:
            r4 = move-exception
            r1 = r2
            goto L_0x004e
        L_0x004d:
            r4 = move-exception
        L_0x004e:
            if (r1 == 0) goto L_0x0069
            r1.close()     // Catch:{ IOException -> 0x0054 }
            goto L_0x0069
        L_0x0054:
            r6 = move-exception
            java.lang.String r1 = LOG_TAG
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r5)
            java.lang.String r5 = r2.toString()
            android.util.Log.e(r1, r5, r6)
        L_0x0069:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.o3dr.android.client.utils.data.tlog.TLogParser.getAllEvents(android.content.Context, android.net.Uri, com.o3dr.android.client.utils.data.tlog.TLogParserFilter):java.util.List");
    }

    public static void getAllEventsAsync(Context context, Handler handler, Uri uri, TLogParserCallback tLogParserCallback) {
        getAllEventsAsync(context, handler, uri, DEFAULT_FILTER, tLogParserCallback);
    }

    public static void getAllEventsAsync(Context context, Handler handler, Uri uri, TLogParserFilter tLogParserFilter, TLogParserCallback tLogParserCallback) {
        final Context context2 = context;
        final Uri uri2 = uri;
        final TLogParserFilter tLogParserFilter2 = tLogParserFilter;
        final Handler handler2 = handler;
        final TLogParserCallback tLogParserCallback2 = tLogParserCallback;
        getInstance().execute(new Runnable() {
            public void run() {
                try {
                    List<Event> allEvents = TLogParser.getAllEvents(context2, uri2, tLogParserFilter2);
                    if (allEvents.isEmpty()) {
                        TLogParser.sendFailed(handler2, tLogParserCallback2, new NoSuchElementException());
                    } else {
                        TLogParser.sendResult(handler2, tLogParserCallback2, allEvents);
                    }
                } catch (Exception e) {
                    TLogParser.sendFailed(handler2, tLogParserCallback2, e);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public static void sendResult(Handler handler, final TLogParserCallback tLogParserCallback, final List<Event> list) {
        if (tLogParserCallback != null) {
            handler.post(new Runnable() {
                public void run() {
                    TLogParserCallback.this.onResult(list);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static void sendFailed(Handler handler, final TLogParserCallback tLogParserCallback, final Exception exc) {
        if (tLogParserCallback != null) {
            handler.post(new Runnable() {
                public void run() {
                    TLogParserCallback.this.onFailed(exc);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static Event next(DataInputStream dataInputStream) {
        MAVLinkPacket mavlink_parse_char;
        try {
            long readLong = dataInputStream.readLong() / 1000;
            while (true) {
                mavlink_parse_char = parser.mavlink_parse_char(dataInputStream.readUnsignedByte());
                if (mavlink_parse_char != null) {
                    break;
                }
            }
            MAVLinkMessage unpack = mavlink_parse_char.unpack();
            if (unpack == null) {
                return null;
            }
            return new Event(readLong, unpack);
        } catch (EOFException unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static ExecutorService getInstance() {
        return InitializeExecutorService.executorService;
    }

    private static class InitializeExecutorService {
        /* access modifiers changed from: private */
        public static final ExecutorService executorService = Executors.newSingleThreadExecutor();

        private InitializeExecutorService() {
        }
    }

    public static class Event implements Serializable {
        private static final long serialVersionUID = -3035618718582382608L;
        private MAVLinkMessage mavLinkMessage;
        private long timestamp;

        private Event(long j, MAVLinkMessage mAVLinkMessage) {
            this.timestamp = j;
            this.mavLinkMessage = mAVLinkMessage;
        }

        public long getTimestamp() {
            return this.timestamp;
        }

        public MAVLinkMessage getMavLinkMessage() {
            return this.mavLinkMessage;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Event)) {
                return false;
            }
            Event event = (Event) obj;
            if (this.timestamp != event.timestamp) {
                return false;
            }
            MAVLinkMessage mAVLinkMessage = this.mavLinkMessage;
            MAVLinkMessage mAVLinkMessage2 = event.mavLinkMessage;
            if (mAVLinkMessage != null) {
                return mAVLinkMessage.equals(mAVLinkMessage2);
            }
            if (mAVLinkMessage2 == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            long j = this.timestamp;
            int i = ((int) (j ^ (j >>> 32))) * 31;
            MAVLinkMessage mAVLinkMessage = this.mavLinkMessage;
            return i + (mAVLinkMessage != null ? mAVLinkMessage.hashCode() : 0);
        }
    }
}

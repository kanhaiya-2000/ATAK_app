package atakplugin.UASTool;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

@aot(mo1534a = 2, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001aJ\u0010\u0000\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\b\u001aL\u0010\u0000\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\b\u001a\u001a\u0010\u0010\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0001\u001aJ\u0010\u0010\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\b\u001aL\u0010\u0010\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\b\u001a$\u0010\u0011\u001a\u00020\f2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\b\u001a0\u0010\u0012\u001a\u00020\f*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00072\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\b\u001a8\u0010\u0012\u001a\u00020\f*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\b\u001a0\u0010\u0012\u001a\u00020\f*\u00020\u00012\u0006\u0010\u0014\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\b\u001a8\u0010\u0012\u001a\u00020\f*\u00020\u00012\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\b\u001a8\u0010\u0015\u001a\u00020\f*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\b\u001a8\u0010\u0015\u001a\u00020\f*\u00020\u00012\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\b¨\u0006\u0016"}, mo1538e = {"fixedRateTimer", "Ljava/util/Timer;", "name", "", "daemon", "", "startAt", "Ljava/util/Date;", "period", "", "action", "Lkotlin/Function1;", "Ljava/util/TimerTask;", "", "Lkotlin/ExtensionFunctionType;", "initialDelay", "timer", "timerTask", "schedule", "time", "delay", "scheduleAtFixedRate", "kotlin-stdlib"})
public final class axn {
    /* renamed from: a */
    private static final TimerTask m5818a(Timer timer, long j, bdl<? super TimerTask, aqr> bdl) {
        TimerTask axo = new axo(bdl);
        timer.schedule(axo, j);
        return axo;
    }

    /* renamed from: a */
    private static final TimerTask m5820a(Timer timer, Date date, bdl<? super TimerTask, aqr> bdl) {
        TimerTask axo = new axo(bdl);
        timer.schedule(axo, date);
        return axo;
    }

    /* renamed from: a */
    private static final TimerTask m5817a(Timer timer, long j, long j2, bdl<? super TimerTask, aqr> bdl) {
        TimerTask axo = new axo(bdl);
        timer.schedule(axo, j, j2);
        return axo;
    }

    /* renamed from: a */
    private static final TimerTask m5819a(Timer timer, Date date, long j, bdl<? super TimerTask, aqr> bdl) {
        TimerTask axo = new axo(bdl);
        timer.schedule(axo, date, j);
        return axo;
    }

    /* renamed from: b */
    private static final TimerTask m5825b(Timer timer, long j, long j2, bdl<? super TimerTask, aqr> bdl) {
        TimerTask axo = new axo(bdl);
        timer.scheduleAtFixedRate(axo, j, j2);
        return axo;
    }

    /* renamed from: b */
    private static final TimerTask m5826b(Timer timer, Date date, long j, bdl<? super TimerTask, aqr> bdl) {
        TimerTask axo = new axo(bdl);
        timer.scheduleAtFixedRate(axo, date, j);
        return axo;
    }

    /* renamed from: a */
    public static final Timer m5811a(String str, boolean z) {
        return str == null ? new Timer(z) : new Timer(str, z);
    }

    /* renamed from: a */
    static /* synthetic */ Timer m5813a(String str, boolean z, long j, long j2, bdl bdl, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            j = 0;
        }
        Timer a = m5811a(str, z);
        a.schedule(new axo(bdl), j, j2);
        return a;
    }

    /* renamed from: a */
    private static final Timer m5812a(String str, boolean z, long j, long j2, bdl<? super TimerTask, aqr> bdl) {
        Timer a = m5811a(str, z);
        a.schedule(new axo(bdl), j, j2);
        return a;
    }

    /* renamed from: a */
    static /* synthetic */ Timer m5815a(String str, boolean z, Date date, long j, bdl bdl, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        Timer a = m5811a(str, z);
        a.schedule(new axo(bdl), date, j);
        return a;
    }

    /* renamed from: a */
    private static final Timer m5814a(String str, boolean z, Date date, long j, bdl<? super TimerTask, aqr> bdl) {
        Timer a = m5811a(str, z);
        a.schedule(new axo(bdl), date, j);
        return a;
    }

    /* renamed from: b */
    static /* synthetic */ Timer m5822b(String str, boolean z, long j, long j2, bdl bdl, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            j = 0;
        }
        Timer a = m5811a(str, z);
        a.scheduleAtFixedRate(new axo(bdl), j, j2);
        return a;
    }

    /* renamed from: b */
    private static final Timer m5821b(String str, boolean z, long j, long j2, bdl<? super TimerTask, aqr> bdl) {
        Timer a = m5811a(str, z);
        a.scheduleAtFixedRate(new axo(bdl), j, j2);
        return a;
    }

    /* renamed from: b */
    static /* synthetic */ Timer m5824b(String str, boolean z, Date date, long j, bdl bdl, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        Timer a = m5811a(str, z);
        a.scheduleAtFixedRate(new axo(bdl), date, j);
        return a;
    }

    /* renamed from: b */
    private static final Timer m5823b(String str, boolean z, Date date, long j, bdl<? super TimerTask, aqr> bdl) {
        Timer a = m5811a(str, z);
        a.scheduleAtFixedRate(new axo(bdl), date, j);
        return a;
    }

    /* renamed from: a */
    private static final TimerTask m5816a(bdl<? super TimerTask, aqr> bdl) {
        return new axo(bdl);
    }
}

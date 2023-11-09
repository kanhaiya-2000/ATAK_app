package indago.time;

import atakplugin.UASTool.aon;
import atakplugin.UASTool.aoo;
import atakplugin.UASTool.aot;
import atakplugin.UASTool.apc;
import atakplugin.UASTool.apv;
import atakplugin.UASTool.apx;
import atakplugin.UASTool.ato;
import atakplugin.UASTool.bfq;
import atakplugin.UASTool.bgk;
import atakplugin.UASTool.bgl;
import atakplugin.UASTool.bgp;
import atakplugin.UASTool.bjr;
import atakplugin.UASTool.boc;
import com.atakmap.android.uastool.flightlog.FlightLogger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0017B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0000H\u0002J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000b\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\nH\u0016J\b\u0010\u0012\u001a\u00020\u0010H\u0016J\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\rJ\u001c\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u00152\u0006\u0010\u0016\u001a\u00020\nH\u0002R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0018"}, mo1538e = {"Lindago/time/CoordinatedTime;", "", "()V", "date", "Ljava/util/Date;", "(Ljava/util/Date;)V", "timeStamp", "getTimeStamp", "()Ljava/util/Date;", "compareTo", "", "other", "equals", "", "", "getUtcOffsetString", "", "hashCode", "toString", "useTakUtcFormat", "totalHoursAndMinutesFromMillis", "Lkotlin/Pair;", "millis", "Companion", "indago"})
public final class CoordinatedTime implements Comparable<CoordinatedTime> {
    public static final Companion Companion = new Companion((bfd) null);
    /* access modifiers changed from: private */
    public static final aon offsetFormatter$delegate = aoo.m2492a(CoordinatedTime$Companion$offsetFormatter$2.INSTANCE);
    /* access modifiers changed from: private */
    public static final aon takFormatter$delegate = aoo.m2492a(CoordinatedTime$Companion$takFormatter$2.INSTANCE);
    private final Date timeStamp;

    public final Date getTimeStamp() {
        return this.timeStamp;
    }

    public CoordinatedTime() {
        Calendar instance = Calendar.getInstance();
        bfq.m6554b(instance, "cal");
        this.timeStamp = new Date(instance.getTimeInMillis() - ((long) instance.getTimeZone().getOffset(instance.getTimeInMillis())));
    }

    public CoordinatedTime(Date date) {
        bfq.m6567f(date, FlightLogger.LOCS_DATE);
        this.timeStamp = date;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof CoordinatedTime)) {
            return false;
        }
        return bfq.m6552a((Object) this.timeStamp, (Object) ((CoordinatedTime) obj).timeStamp);
    }

    public int hashCode() {
        return this.timeStamp.hashCode();
    }

    public String toString() {
        return toString(false);
    }

    public final String toString(boolean z) {
        if (z) {
            String format = Companion.getTakFormatter().format(this.timeStamp);
            bfq.m6554b(format, "takFormatter.format(this.timeStamp)");
            return format;
        }
        Calendar instance = Calendar.getInstance();
        bfq.m6554b(instance, "cal");
        Date date = new Date(this.timeStamp.getTime() + ((long) instance.getTimeZone().getOffset(instance.getTimeInMillis())));
        return Companion.getOffsetFormatter().format(date) + getUtcOffsetString();
    }

    private final String getUtcOffsetString() {
        StringBuilder sb = new StringBuilder();
        Calendar instance = Calendar.getInstance();
        bfq.m6554b(instance, "cal");
        int offset = instance.getTimeZone().getOffset(instance.getTimeInMillis());
        apc<Integer, Integer> apc = totalHoursAndMinutesFromMillis(offset);
        int intValue = apc.mo1546c().intValue();
        int intValue2 = apc.mo1547d().intValue();
        sb.append(offset > 0 ? "-" : "+");
        sb.append(boc.m8116a(String.valueOf(intValue), 2, '0'));
        sb.append(":");
        sb.append(boc.m8116a(String.valueOf(intValue2), 2, '0'));
        String sb2 = sb.toString();
        bfq.m6554b(sb2, "StringBuilder().apply {\n…0'))\n        }.toString()");
        return sb2;
    }

    private final apc<Integer, Integer> totalHoursAndMinutesFromMillis(int i) {
        int abs = Math.abs(i);
        int floor = (int) Math.floor(((double) abs) / ((double) 3600000));
        return apv.m2659a(Integer.valueOf(floor), Integer.valueOf((abs - (3600000 * floor)) / 60000));
    }

    public int compareTo(CoordinatedTime coordinatedTime) {
        bfq.m6567f(coordinatedTime, "other");
        return this.timeStamp.compareTo(coordinatedTime.timeStamp);
    }

    @aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\n\u0010\u0006¨\u0006\u0013"}, mo1538e = {"Lindago/time/CoordinatedTime$Companion;", "", "()V", "offsetFormatter", "Ljava/text/SimpleDateFormat;", "getOffsetFormatter", "()Ljava/text/SimpleDateFormat;", "offsetFormatter$delegate", "Lkotlin/Lazy;", "takFormatter", "getTakFormatter", "takFormatter$delegate", "parse", "Lindago/time/CoordinatedTime;", "date", "", "tryParse", "tryParseTakFormat", "tryParseTimeWithOffset", "indago"})
    public static final class Companion {
        static final /* synthetic */ bjr[] $$delegatedProperties;

        static {
            Class<Companion> cls = Companion.class;
            $$delegatedProperties = new bjr[]{bgp.m6707a((bgk) new bgl(bgp.m6715b(cls), "takFormatter", "getTakFormatter()Ljava/text/SimpleDateFormat;")), bgp.m6707a((bgk) new bgl(bgp.m6715b(cls), "offsetFormatter", "getOffsetFormatter()Ljava/text/SimpleDateFormat;"))};
        }

        /* access modifiers changed from: private */
        public final SimpleDateFormat getOffsetFormatter() {
            aon access$getOffsetFormatter$cp = CoordinatedTime.offsetFormatter$delegate;
            Companion companion = CoordinatedTime.Companion;
            bjr bjr = $$delegatedProperties[1];
            return (SimpleDateFormat) access$getOffsetFormatter$cp.mo1522b();
        }

        /* access modifiers changed from: private */
        public final SimpleDateFormat getTakFormatter() {
            aon access$getTakFormatter$cp = CoordinatedTime.takFormatter$delegate;
            Companion companion = CoordinatedTime.Companion;
            bjr bjr = $$delegatedProperties[0];
            return (SimpleDateFormat) access$getTakFormatter$cp.mo1522b();
        }

        private Companion() {
        }

        public /* synthetic */ Companion(bfd bfd) {
            this();
        }

        public final CoordinatedTime parse(String str) {
            bfq.m6567f(str, FlightLogger.LOCS_DATE);
            CoordinatedTime tryParse = tryParse(str);
            if (tryParse != null) {
                return tryParse;
            }
            throw new IllegalArgumentException("Date (" + str + ") is not in a valid format. Expecting yyyy-MM-dd'T'HH:mm:ss.SSS'Z' or yyyy-MM-dd'T'HH:mm:ss.SSS");
        }

        public final CoordinatedTime tryParse(String str) {
            bfq.m6567f(str, FlightLogger.LOCS_DATE);
            return boc.m8063c(str, "Z", false, 2, (Object) null) ? tryParseTakFormat(str) : tryParseTimeWithOffset(str);
        }

        private final CoordinatedTime tryParseTimeWithOffset(String str) {
            CharSequence charSequence = str;
            int b = boc.m8140b(charSequence, "+", 0, false, 6, (Object) null);
            if (b < 0) {
                b = boc.m8140b(charSequence, "-", 0, false, 6, (Object) null);
            }
            if (str != null) {
                String substring = str.substring(b);
                bfq.m6554b(substring, "(this as java.lang.String).substring(startIndex)");
                int i = boc.m8058b(substring, "+", false, 2, (Object) null) ? 1 : -1;
                List b2 = boc.m8174b((CharSequence) boc.m8170b(substring, '+', '-'), new String[]{":"}, false, 0, 6, (Object) null);
                String str2 = (String) ato.m4781c(b2, 0);
                Integer h = str2 != null ? boc.m7997h(str2) : null;
                String str3 = (String) ato.m4781c(b2, 1);
                Integer h2 = str3 != null ? boc.m7997h(str3) : null;
                if (h == null || h2 == null) {
                    return null;
                }
                int intValue = (h.intValue() * 3600000) + (h2.intValue() * 60000 * i);
                try {
                    Date parse = getOffsetFormatter().parse(str);
                    bfq.m6554b(parse, "parsedDate");
                    return new CoordinatedTime(new Date(parse.getTime() + ((long) intValue)));
                } catch (ParseException unused) {
                    return null;
                }
            } else {
                throw new apx("null cannot be cast to non-null type java.lang.String");
            }
        }

        private final CoordinatedTime tryParseTakFormat(String str) {
            try {
                Date parse = getTakFormatter().parse(str);
                bfq.m6554b(parse, "takFormatter.parse(date)");
                return new CoordinatedTime(parse);
            } catch (ParseException unused) {
                return null;
            }
        }
    }
}

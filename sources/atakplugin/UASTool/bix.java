package atakplugin.UASTool;

import atakplugin.UASTool.big;
import atakplugin.UASTool.bio;
import atakplugin.UASTool.bir;
import java.util.NoSuchElementException;

@aot(mo1534a = 5, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000n\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0010\n\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\u001a'\u0010\u0000\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002*\u0002H\u00012\u0006\u0010\u0003\u001a\u0002H\u0001¢\u0006\u0002\u0010\u0004\u001a\u0012\u0010\u0000\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0005\u001a\u0012\u0010\u0000\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0006\u001a\u0012\u0010\u0000\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0007\u001a\u0012\u0010\u0000\u001a\u00020\b*\u00020\b2\u0006\u0010\u0003\u001a\u00020\b\u001a\u0012\u0010\u0000\u001a\u00020\t*\u00020\t2\u0006\u0010\u0003\u001a\u00020\t\u001a\u0012\u0010\u0000\u001a\u00020\n*\u00020\n2\u0006\u0010\u0003\u001a\u00020\n\u001a'\u0010\u000b\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002*\u0002H\u00012\u0006\u0010\f\u001a\u0002H\u0001¢\u0006\u0002\u0010\u0004\u001a\u0012\u0010\u000b\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005\u001a\u0012\u0010\u000b\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006\u001a\u0012\u0010\u000b\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007\u001a\u0012\u0010\u000b\u001a\u00020\b*\u00020\b2\u0006\u0010\f\u001a\u00020\b\u001a\u0012\u0010\u000b\u001a\u00020\t*\u00020\t2\u0006\u0010\f\u001a\u00020\t\u001a\u0012\u0010\u000b\u001a\u00020\n*\u00020\n2\u0006\u0010\f\u001a\u00020\n\u001a3\u0010\r\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002*\u0002H\u00012\b\u0010\u0003\u001a\u0004\u0018\u0001H\u00012\b\u0010\f\u001a\u0004\u0018\u0001H\u0001¢\u0006\u0002\u0010\u000e\u001a/\u0010\r\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002*\u0002H\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0010H\u0007¢\u0006\u0002\u0010\u0011\u001a-\u0010\r\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002*\u0002H\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0012¢\u0006\u0002\u0010\u0013\u001a\u001a\u0010\r\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005\u001a\u001a\u0010\r\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006\u001a\u001a\u0010\r\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007\u001a\u001a\u0010\r\u001a\u00020\b*\u00020\b2\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b\u001a\u0018\u0010\r\u001a\u00020\b*\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u0012\u001a\u001a\u0010\r\u001a\u00020\t*\u00020\t2\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t\u001a\u0018\u0010\r\u001a\u00020\t*\u00020\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u0012\u001a\u001a\u0010\r\u001a\u00020\n*\u00020\n2\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n\u001a\u001c\u0010\u0014\u001a\u00020\u0015*\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\n¢\u0006\u0002\u0010\u0019\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00050\u00122\u0006\u0010\u001a\u001a\u00020\u0006H\u0002¢\u0006\u0002\b\u001b\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00050\u00122\u0006\u0010\u001a\u001a\u00020\u0007H\u0002¢\u0006\u0002\b\u001b\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00050\u00122\u0006\u0010\u001a\u001a\u00020\bH\u0002¢\u0006\u0002\b\u001b\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00050\u00122\u0006\u0010\u001a\u001a\u00020\tH\u0002¢\u0006\u0002\b\u001b\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00050\u00122\u0006\u0010\u001a\u001a\u00020\nH\u0002¢\u0006\u0002\b\u001b\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u001a\u001a\u00020\u0005H\u0002¢\u0006\u0002\b\u001c\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u001a\u001a\u00020\u0007H\u0002¢\u0006\u0002\b\u001c\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u001a\u001a\u00020\bH\u0002¢\u0006\u0002\b\u001c\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u001a\u001a\u00020\tH\u0002¢\u0006\u0002\b\u001c\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u001a\u001a\u00020\nH\u0002¢\u0006\u0002\b\u001c\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\u001a\u001a\u00020\u0005H\u0002¢\u0006\u0002\b\u001d\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\u001a\u001a\u00020\u0006H\u0002¢\u0006\u0002\b\u001d\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\u001a\u001a\u00020\bH\u0002¢\u0006\u0002\b\u001d\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\u001a\u001a\u00020\tH\u0002¢\u0006\u0002\b\u001d\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\u001a\u001a\u00020\nH\u0002¢\u0006\u0002\b\u001d\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\u001a\u001a\u00020\u0005H\u0002¢\u0006\u0002\b\u001e\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\u001a\u001a\u00020\u0006H\u0002¢\u0006\u0002\b\u001e\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\u001a\u001a\u00020\u0007H\u0002¢\u0006\u0002\b\u001e\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\u001a\u001a\u00020\tH\u0002¢\u0006\u0002\b\u001e\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\u001a\u001a\u00020\nH\u0002¢\u0006\u0002\b\u001e\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010\u001a\u001a\u00020\u0005H\u0002¢\u0006\u0002\b\u001f\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010\u001a\u001a\u00020\u0006H\u0002¢\u0006\u0002\b\u001f\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010\u001a\u001a\u00020\u0007H\u0002¢\u0006\u0002\b\u001f\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010\u001a\u001a\u00020\bH\u0002¢\u0006\u0002\b\u001f\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010\u001a\u001a\u00020\nH\u0002¢\u0006\u0002\b\u001f\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u001a\u001a\u00020\u0005H\u0002¢\u0006\u0002\b \u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u001a\u001a\u00020\u0006H\u0002¢\u0006\u0002\b \u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u001a\u001a\u00020\u0007H\u0002¢\u0006\u0002\b \u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u001a\u001a\u00020\bH\u0002¢\u0006\u0002\b \u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u001a\u001a\u00020\tH\u0002¢\u0006\u0002\b \u001a\u001c\u0010\u0014\u001a\u00020\u0015*\u00020!2\b\u0010\u0017\u001a\u0004\u0018\u00010\bH\n¢\u0006\u0002\u0010\"\u001a\u001c\u0010\u0014\u001a\u00020\u0015*\u00020#2\b\u0010\u0017\u001a\u0004\u0018\u00010\tH\n¢\u0006\u0002\u0010$\u001a\u0015\u0010%\u001a\u00020&*\u00020\u00052\u0006\u0010'\u001a\u00020\u0005H\u0004\u001a\u0015\u0010%\u001a\u00020&*\u00020\u00052\u0006\u0010'\u001a\u00020\bH\u0004\u001a\u0015\u0010%\u001a\u00020(*\u00020\u00052\u0006\u0010'\u001a\u00020\tH\u0004\u001a\u0015\u0010%\u001a\u00020&*\u00020\u00052\u0006\u0010'\u001a\u00020\nH\u0004\u001a\u0015\u0010%\u001a\u00020)*\u00020\u00182\u0006\u0010'\u001a\u00020\u0018H\u0004\u001a\u0015\u0010%\u001a\u00020&*\u00020\b2\u0006\u0010'\u001a\u00020\u0005H\u0004\u001a\u0015\u0010%\u001a\u00020&*\u00020\b2\u0006\u0010'\u001a\u00020\bH\u0004\u001a\u0015\u0010%\u001a\u00020(*\u00020\b2\u0006\u0010'\u001a\u00020\tH\u0004\u001a\u0015\u0010%\u001a\u00020&*\u00020\b2\u0006\u0010'\u001a\u00020\nH\u0004\u001a\u0015\u0010%\u001a\u00020(*\u00020\t2\u0006\u0010'\u001a\u00020\u0005H\u0004\u001a\u0015\u0010%\u001a\u00020(*\u00020\t2\u0006\u0010'\u001a\u00020\bH\u0004\u001a\u0015\u0010%\u001a\u00020(*\u00020\t2\u0006\u0010'\u001a\u00020\tH\u0004\u001a\u0015\u0010%\u001a\u00020(*\u00020\t2\u0006\u0010'\u001a\u00020\nH\u0004\u001a\u0015\u0010%\u001a\u00020&*\u00020\n2\u0006\u0010'\u001a\u00020\u0005H\u0004\u001a\u0015\u0010%\u001a\u00020&*\u00020\n2\u0006\u0010'\u001a\u00020\bH\u0004\u001a\u0015\u0010%\u001a\u00020(*\u00020\n2\u0006\u0010'\u001a\u00020\tH\u0004\u001a\u0015\u0010%\u001a\u00020&*\u00020\n2\u0006\u0010'\u001a\u00020\nH\u0004\u001a\r\u0010*\u001a\u00020\u0018*\u00020\u0016H\b\u001a\u0014\u0010*\u001a\u00020\u0018*\u00020\u00162\u0006\u0010*\u001a\u00020+H\u0007\u001a\r\u0010*\u001a\u00020\b*\u00020!H\b\u001a\u0014\u0010*\u001a\u00020\b*\u00020!2\u0006\u0010*\u001a\u00020+H\u0007\u001a\r\u0010*\u001a\u00020\t*\u00020#H\b\u001a\u0014\u0010*\u001a\u00020\t*\u00020#2\u0006\u0010*\u001a\u00020+H\u0007\u001a\n\u0010,\u001a\u00020)*\u00020)\u001a\n\u0010,\u001a\u00020&*\u00020&\u001a\n\u0010,\u001a\u00020(*\u00020(\u001a\u0015\u0010-\u001a\u00020)*\u00020)2\u0006\u0010-\u001a\u00020\bH\u0004\u001a\u0015\u0010-\u001a\u00020&*\u00020&2\u0006\u0010-\u001a\u00020\bH\u0004\u001a\u0015\u0010-\u001a\u00020(*\u00020(2\u0006\u0010-\u001a\u00020\tH\u0004\u001a\u0013\u0010.\u001a\u0004\u0018\u00010\u0005*\u00020\u0006H\u0000¢\u0006\u0002\u0010/\u001a\u0013\u0010.\u001a\u0004\u0018\u00010\u0005*\u00020\u0007H\u0000¢\u0006\u0002\u00100\u001a\u0013\u0010.\u001a\u0004\u0018\u00010\u0005*\u00020\bH\u0000¢\u0006\u0002\u00101\u001a\u0013\u0010.\u001a\u0004\u0018\u00010\u0005*\u00020\tH\u0000¢\u0006\u0002\u00102\u001a\u0013\u0010.\u001a\u0004\u0018\u00010\u0005*\u00020\nH\u0000¢\u0006\u0002\u00103\u001a\u0013\u00104\u001a\u0004\u0018\u00010\b*\u00020\u0006H\u0000¢\u0006\u0002\u00105\u001a\u0013\u00104\u001a\u0004\u0018\u00010\b*\u00020\u0007H\u0000¢\u0006\u0002\u00106\u001a\u0013\u00104\u001a\u0004\u0018\u00010\b*\u00020\tH\u0000¢\u0006\u0002\u00107\u001a\u0013\u00108\u001a\u0004\u0018\u00010\t*\u00020\u0006H\u0000¢\u0006\u0002\u00109\u001a\u0013\u00108\u001a\u0004\u0018\u00010\t*\u00020\u0007H\u0000¢\u0006\u0002\u0010:\u001a\u0013\u0010;\u001a\u0004\u0018\u00010\n*\u00020\u0006H\u0000¢\u0006\u0002\u0010<\u001a\u0013\u0010;\u001a\u0004\u0018\u00010\n*\u00020\u0007H\u0000¢\u0006\u0002\u0010=\u001a\u0013\u0010;\u001a\u0004\u0018\u00010\n*\u00020\bH\u0000¢\u0006\u0002\u0010>\u001a\u0013\u0010;\u001a\u0004\u0018\u00010\n*\u00020\tH\u0000¢\u0006\u0002\u0010?\u001a\u0015\u0010@\u001a\u00020!*\u00020\u00052\u0006\u0010'\u001a\u00020\u0005H\u0004\u001a\u0015\u0010@\u001a\u00020!*\u00020\u00052\u0006\u0010'\u001a\u00020\bH\u0004\u001a\u0015\u0010@\u001a\u00020#*\u00020\u00052\u0006\u0010'\u001a\u00020\tH\u0004\u001a\u0015\u0010@\u001a\u00020!*\u00020\u00052\u0006\u0010'\u001a\u00020\nH\u0004\u001a\u0015\u0010@\u001a\u00020\u0016*\u00020\u00182\u0006\u0010'\u001a\u00020\u0018H\u0004\u001a\u0015\u0010@\u001a\u00020!*\u00020\b2\u0006\u0010'\u001a\u00020\u0005H\u0004\u001a\u0015\u0010@\u001a\u00020!*\u00020\b2\u0006\u0010'\u001a\u00020\bH\u0004\u001a\u0015\u0010@\u001a\u00020#*\u00020\b2\u0006\u0010'\u001a\u00020\tH\u0004\u001a\u0015\u0010@\u001a\u00020!*\u00020\b2\u0006\u0010'\u001a\u00020\nH\u0004\u001a\u0015\u0010@\u001a\u00020#*\u00020\t2\u0006\u0010'\u001a\u00020\u0005H\u0004\u001a\u0015\u0010@\u001a\u00020#*\u00020\t2\u0006\u0010'\u001a\u00020\bH\u0004\u001a\u0015\u0010@\u001a\u00020#*\u00020\t2\u0006\u0010'\u001a\u00020\tH\u0004\u001a\u0015\u0010@\u001a\u00020#*\u00020\t2\u0006\u0010'\u001a\u00020\nH\u0004\u001a\u0015\u0010@\u001a\u00020!*\u00020\n2\u0006\u0010'\u001a\u00020\u0005H\u0004\u001a\u0015\u0010@\u001a\u00020!*\u00020\n2\u0006\u0010'\u001a\u00020\bH\u0004\u001a\u0015\u0010@\u001a\u00020#*\u00020\n2\u0006\u0010'\u001a\u00020\tH\u0004\u001a\u0015\u0010@\u001a\u00020!*\u00020\n2\u0006\u0010'\u001a\u00020\nH\u0004¨\u0006A"}, mo1538e = {"coerceAtLeast", "T", "", "minimumValue", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "", "", "", "", "", "", "coerceAtMost", "maximumValue", "coerceIn", "(Ljava/lang/Comparable;Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "range", "Lkotlin/ranges/ClosedFloatingPointRange;", "(Ljava/lang/Comparable;Lkotlin/ranges/ClosedFloatingPointRange;)Ljava/lang/Comparable;", "Lkotlin/ranges/ClosedRange;", "(Ljava/lang/Comparable;Lkotlin/ranges/ClosedRange;)Ljava/lang/Comparable;", "contains", "", "Lkotlin/ranges/CharRange;", "element", "", "(Lkotlin/ranges/CharRange;Ljava/lang/Character;)Z", "value", "byteRangeContains", "doubleRangeContains", "floatRangeContains", "intRangeContains", "longRangeContains", "shortRangeContains", "Lkotlin/ranges/IntRange;", "(Lkotlin/ranges/IntRange;Ljava/lang/Integer;)Z", "Lkotlin/ranges/LongRange;", "(Lkotlin/ranges/LongRange;Ljava/lang/Long;)Z", "downTo", "Lkotlin/ranges/IntProgression;", "to", "Lkotlin/ranges/LongProgression;", "Lkotlin/ranges/CharProgression;", "random", "Lkotlin/random/Random;", "reversed", "step", "toByteExactOrNull", "(D)Ljava/lang/Byte;", "(F)Ljava/lang/Byte;", "(I)Ljava/lang/Byte;", "(J)Ljava/lang/Byte;", "(S)Ljava/lang/Byte;", "toIntExactOrNull", "(D)Ljava/lang/Integer;", "(F)Ljava/lang/Integer;", "(J)Ljava/lang/Integer;", "toLongExactOrNull", "(D)Ljava/lang/Long;", "(F)Ljava/lang/Long;", "toShortExactOrNull", "(D)Ljava/lang/Short;", "(F)Ljava/lang/Short;", "(I)Ljava/lang/Short;", "(J)Ljava/lang/Short;", "until", "kotlin-stdlib"}, mo1539f = "kotlin/ranges/RangesKt", mo1541h = 1)
class bix extends biw {
    /* renamed from: b */
    public static final double m7144b(double d, double d2) {
        return d < d2 ? d2 : d;
    }

    /* renamed from: b */
    public static final float m7145b(float f, float f2) {
        return f < f2 ? f2 : f;
    }

    /* renamed from: c */
    public static final byte m7174c(byte b, byte b2) {
        return b < b2 ? b2 : b;
    }

    /* renamed from: c */
    public static final double m7175c(double d, double d2) {
        return d > d2 ? d2 : d;
    }

    /* renamed from: c */
    public static final float m7176c(float f, float f2) {
        return f > f2 ? f2 : f;
    }

    /* renamed from: c */
    public static final int m7177c(int i, int i2) {
        return i < i2 ? i2 : i;
    }

    /* renamed from: c */
    public static final long m7178c(long j, long j2) {
        return j < j2 ? j2 : j;
    }

    /* renamed from: c */
    public static final short m7183c(short s, short s2) {
        return s < s2 ? s2 : s;
    }

    /* renamed from: d */
    public static final byte m7190d(byte b, byte b2) {
        return b > b2 ? b2 : b;
    }

    /* renamed from: d */
    public static final int m7191d(int i, int i2) {
        return i > i2 ? i2 : i;
    }

    /* renamed from: d */
    public static final long m7192d(long j, long j2) {
        return j > j2 ? j2 : j;
    }

    /* renamed from: d */
    public static final short m7195d(short s, short s2) {
        return s > s2 ? s2 : s;
    }

    /* renamed from: a */
    private static final int m7097a(biq biq) {
        return biu.m7098a(biq, (bic) bic.f2709b);
    }

    /* renamed from: a */
    private static final long m7101a(bit bit) {
        return biu.m7102a(bit, (bic) bic.f2709b);
    }

    /* renamed from: a */
    private static final char m7091a(bii bii) {
        return biu.m7092a(bii, (bic) bic.f2709b);
    }

    /* renamed from: a */
    public static final int m7098a(biq biq, bic bic) {
        bfq.m6567f(biq, "$this$random");
        bfq.m6567f(bic, "random");
        try {
            return bid.m6976a(bic, biq);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    /* renamed from: a */
    public static final long m7102a(bit bit, bic bic) {
        bfq.m6567f(bit, "$this$random");
        bfq.m6567f(bic, "random");
        try {
            return bid.m6977a(bic, bit);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    /* renamed from: a */
    public static final char m7092a(bii bii, bic bic) {
        bfq.m6567f(bii, "$this$random");
        bfq.m6567f(bic, "random");
        try {
            return (char) bic.mo2549a((int) bii.mo2554a(), bii.mo2555b() + 1);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    /* renamed from: a */
    private static final boolean m7142a(biq biq, Integer num) {
        bfq.m6567f(biq, "$this$contains");
        return num != null && biq.mo2603a(num.intValue());
    }

    /* renamed from: a */
    private static final boolean m7143a(bit bit, Long l) {
        bfq.m6567f(bit, "$this$contains");
        return l != null && bit.mo2619a(l.longValue());
    }

    /* renamed from: a */
    private static final boolean m7135a(bii bii, Character ch) {
        bfq.m6567f(bii, "$this$contains");
        return ch != null && bii.mo2566a(ch.charValue());
    }

    /* renamed from: a */
    public static final boolean m7136a(bim<Integer> bim, byte b) {
        bfq.m6567f(bim, "$this$contains");
        return bim.mo2567a(Integer.valueOf(b));
    }

    /* renamed from: b */
    public static final boolean m7168b(bim<Long> bim, byte b) {
        bfq.m6567f(bim, "$this$contains");
        return bim.mo2567a(Long.valueOf((long) b));
    }

    /* renamed from: c */
    public static final boolean m7184c(bim<Short> bim, byte b) {
        bfq.m6567f(bim, "$this$contains");
        return bim.mo2567a(Short.valueOf((short) b));
    }

    @anx(mo1516a = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    /* renamed from: d */
    public static final boolean m7196d(bim<Double> bim, byte b) {
        bfq.m6567f(bim, "$this$contains");
        return bim.mo2567a(Double.valueOf((double) b));
    }

    @anx(mo1516a = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    /* renamed from: e */
    public static final boolean m7202e(bim<Float> bim, byte b) {
        bfq.m6567f(bim, "$this$contains");
        return bim.mo2567a(Float.valueOf((float) b));
    }

    @anx(mo1516a = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    /* renamed from: a */
    public static final boolean m7137a(bim<Integer> bim, double d) {
        bfq.m6567f(bim, "$this$contains");
        Integer b = biu.m7164b(d);
        if (b != null) {
            return bim.mo2567a(b);
        }
        return false;
    }

    @anx(mo1516a = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    /* renamed from: b */
    public static final boolean m7169b(bim<Long> bim, double d) {
        bfq.m6567f(bim, "$this$contains");
        Long c = biu.m7180c(d);
        if (c != null) {
            return bim.mo2567a(c);
        }
        return false;
    }

    @anx(mo1516a = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    /* renamed from: c */
    public static final boolean m7185c(bim<Byte> bim, double d) {
        bfq.m6567f(bim, "$this$contains");
        Byte a = biu.m7126a(d);
        if (a != null) {
            return bim.mo2567a(a);
        }
        return false;
    }

    @anx(mo1516a = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    /* renamed from: d */
    public static final boolean m7197d(bim<Short> bim, double d) {
        bfq.m6567f(bim, "$this$contains");
        Short d2 = biu.m7193d(d);
        if (d2 != null) {
            return bim.mo2567a(d2);
        }
        return false;
    }

    /* renamed from: e */
    public static final boolean m7203e(bim<Float> bim, double d) {
        bfq.m6567f(bim, "$this$contains");
        return bim.mo2567a(Float.valueOf((float) d));
    }

    @anx(mo1516a = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    /* renamed from: a */
    public static final boolean m7138a(bim<Integer> bim, float f) {
        bfq.m6567f(bim, "$this$contains");
        Integer b = biu.m7165b(f);
        if (b != null) {
            return bim.mo2567a(b);
        }
        return false;
    }

    @anx(mo1516a = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    /* renamed from: b */
    public static final boolean m7170b(bim<Long> bim, float f) {
        bfq.m6567f(bim, "$this$contains");
        Long c = biu.m7181c(f);
        if (c != null) {
            return bim.mo2567a(c);
        }
        return false;
    }

    @anx(mo1516a = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    /* renamed from: c */
    public static final boolean m7186c(bim<Byte> bim, float f) {
        bfq.m6567f(bim, "$this$contains");
        Byte a = biu.m7127a(f);
        if (a != null) {
            return bim.mo2567a(a);
        }
        return false;
    }

    @anx(mo1516a = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    /* renamed from: d */
    public static final boolean m7198d(bim<Short> bim, float f) {
        bfq.m6567f(bim, "$this$contains");
        Short d = biu.m7194d(f);
        if (d != null) {
            return bim.mo2567a(d);
        }
        return false;
    }

    /* renamed from: e */
    public static final boolean m7204e(bim<Double> bim, float f) {
        bfq.m6567f(bim, "$this$contains");
        return bim.mo2567a(Double.valueOf((double) f));
    }

    /* renamed from: a */
    public static final boolean m7139a(bim<Long> bim, int i) {
        bfq.m6567f(bim, "$this$contains");
        return bim.mo2567a(Long.valueOf((long) i));
    }

    /* renamed from: b */
    public static final boolean m7171b(bim<Byte> bim, int i) {
        bfq.m6567f(bim, "$this$contains");
        Byte a = biu.m7128a(i);
        if (a != null) {
            return bim.mo2567a(a);
        }
        return false;
    }

    /* renamed from: c */
    public static final boolean m7187c(bim<Short> bim, int i) {
        bfq.m6567f(bim, "$this$contains");
        Short b = biu.m7167b(i);
        if (b != null) {
            return bim.mo2567a(b);
        }
        return false;
    }

    @anx(mo1516a = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    /* renamed from: d */
    public static final boolean m7199d(bim<Double> bim, int i) {
        bfq.m6567f(bim, "$this$contains");
        return bim.mo2567a(Double.valueOf((double) i));
    }

    @anx(mo1516a = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    /* renamed from: e */
    public static final boolean m7205e(bim<Float> bim, int i) {
        bfq.m6567f(bim, "$this$contains");
        return bim.mo2567a(Float.valueOf((float) i));
    }

    /* renamed from: a */
    public static final boolean m7140a(bim<Integer> bim, long j) {
        bfq.m6567f(bim, "$this$contains");
        Integer b = biu.m7166b(j);
        if (b != null) {
            return bim.mo2567a(b);
        }
        return false;
    }

    /* renamed from: b */
    public static final boolean m7172b(bim<Byte> bim, long j) {
        bfq.m6567f(bim, "$this$contains");
        Byte a = biu.m7129a(j);
        if (a != null) {
            return bim.mo2567a(a);
        }
        return false;
    }

    /* renamed from: c */
    public static final boolean m7188c(bim<Short> bim, long j) {
        bfq.m6567f(bim, "$this$contains");
        Short c = biu.m7182c(j);
        if (c != null) {
            return bim.mo2567a(c);
        }
        return false;
    }

    @anx(mo1516a = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    /* renamed from: d */
    public static final boolean m7200d(bim<Double> bim, long j) {
        bfq.m6567f(bim, "$this$contains");
        return bim.mo2567a(Double.valueOf((double) j));
    }

    @anx(mo1516a = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    /* renamed from: e */
    public static final boolean m7206e(bim<Float> bim, long j) {
        bfq.m6567f(bim, "$this$contains");
        return bim.mo2567a(Float.valueOf((float) j));
    }

    /* renamed from: a */
    public static final boolean m7141a(bim<Integer> bim, short s) {
        bfq.m6567f(bim, "$this$contains");
        return bim.mo2567a(Integer.valueOf(s));
    }

    /* renamed from: b */
    public static final boolean m7173b(bim<Long> bim, short s) {
        bfq.m6567f(bim, "$this$contains");
        return bim.mo2567a(Long.valueOf((long) s));
    }

    /* renamed from: c */
    public static final boolean m7189c(bim<Byte> bim, short s) {
        bfq.m6567f(bim, "$this$contains");
        Byte a = biu.m7130a(s);
        if (a != null) {
            return bim.mo2567a(a);
        }
        return false;
    }

    @anx(mo1516a = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    /* renamed from: d */
    public static final boolean m7201d(bim<Double> bim, short s) {
        bfq.m6567f(bim, "$this$contains");
        return bim.mo2567a(Double.valueOf((double) s));
    }

    @anx(mo1516a = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    /* renamed from: e */
    public static final boolean m7207e(bim<Float> bim, short s) {
        bfq.m6567f(bim, "$this$contains");
        return bim.mo2567a(Float.valueOf((float) s));
    }

    /* renamed from: a */
    public static final bio m7109a(int i, byte b) {
        return bio.f2734a.mo2600a(i, b, -1);
    }

    /* renamed from: a */
    public static final bir m7119a(long j, byte b) {
        return bir.f2744a.mo2616a(j, (long) b, -1);
    }

    /* renamed from: a */
    public static final bio m7106a(byte b, byte b2) {
        return bio.f2734a.mo2600a(b, b2, -1);
    }

    /* renamed from: a */
    public static final bio m7114a(short s, byte b) {
        return bio.f2734a.mo2600a(s, b, -1);
    }

    /* renamed from: a */
    public static final big m7103a(char c, char c2) {
        return big.f2718a.mo2563a(c, c2, -1);
    }

    /* renamed from: a */
    public static final bio m7110a(int i, int i2) {
        return bio.f2734a.mo2600a(i, i2, -1);
    }

    /* renamed from: a */
    public static final bir m7120a(long j, int i) {
        return bir.f2744a.mo2616a(j, (long) i, -1);
    }

    /* renamed from: a */
    public static final bio m7107a(byte b, int i) {
        return bio.f2734a.mo2600a(b, i, -1);
    }

    /* renamed from: a */
    public static final bio m7115a(short s, int i) {
        return bio.f2734a.mo2600a(s, i, -1);
    }

    /* renamed from: a */
    public static final bir m7118a(int i, long j) {
        return bir.f2744a.mo2616a((long) i, j, -1);
    }

    /* renamed from: a */
    public static final bir m7121a(long j, long j2) {
        return bir.f2744a.mo2616a(j, j2, -1);
    }

    /* renamed from: a */
    public static final bir m7117a(byte b, long j) {
        return bir.f2744a.mo2616a((long) b, j, -1);
    }

    /* renamed from: a */
    public static final bir m7125a(short s, long j) {
        return bir.f2744a.mo2616a((long) s, j, -1);
    }

    /* renamed from: a */
    public static final bio m7111a(int i, short s) {
        return bio.f2734a.mo2600a(i, s, -1);
    }

    /* renamed from: a */
    public static final bir m7122a(long j, short s) {
        return bir.f2744a.mo2616a(j, (long) s, -1);
    }

    /* renamed from: a */
    public static final bio m7108a(byte b, short s) {
        return bio.f2734a.mo2600a(b, s, -1);
    }

    /* renamed from: a */
    public static final bio m7116a(short s, short s2) {
        return bio.f2734a.mo2600a(s, s2, -1);
    }

    /* renamed from: a */
    public static final bio m7112a(bio bio) {
        bfq.m6567f(bio, "$this$reversed");
        return bio.f2734a.mo2600a(bio.mo2592b(), bio.mo2591a(), -bio.mo2593c());
    }

    /* renamed from: a */
    public static final bir m7123a(bir bir) {
        bfq.m6567f(bir, "$this$reversed");
        return bir.f2744a.mo2616a(bir.mo2608b(), bir.mo2607a(), -bir.mo2609c());
    }

    /* renamed from: a */
    public static final big m7104a(big big) {
        bfq.m6567f(big, "$this$reversed");
        return big.f2718a.mo2563a(big.mo2555b(), big.mo2554a(), -big.mo2556c());
    }

    /* renamed from: a */
    public static final bio m7113a(bio bio, int i) {
        bfq.m6567f(bio, "$this$step");
        biu.m7088a(i > 0, (Number) Integer.valueOf(i));
        bio.C0169a aVar = bio.f2734a;
        int a = bio.mo2591a();
        int b = bio.mo2592b();
        if (bio.mo2593c() <= 0) {
            i = -i;
        }
        return aVar.mo2600a(a, b, i);
    }

    /* renamed from: a */
    public static final bir m7124a(bir bir, long j) {
        bfq.m6567f(bir, "$this$step");
        biu.m7088a(j > 0, (Number) Long.valueOf(j));
        bir.C0171a aVar = bir.f2744a;
        long a = bir.mo2607a();
        long b = bir.mo2608b();
        if (bir.mo2609c() <= 0) {
            j = -j;
        }
        return aVar.mo2616a(a, b, j);
    }

    /* renamed from: a */
    public static final big m7105a(big big, int i) {
        bfq.m6567f(big, "$this$step");
        biu.m7088a(i > 0, (Number) Integer.valueOf(i));
        big.C0165a aVar = big.f2718a;
        char a = big.mo2554a();
        char b = big.mo2555b();
        if (big.mo2556c() <= 0) {
            i = -i;
        }
        return aVar.mo2563a(a, b, i);
    }

    /* renamed from: a */
    public static final Byte m7128a(int i) {
        if (-128 <= i && 127 >= i) {
            return Byte.valueOf((byte) i);
        }
        return null;
    }

    /* renamed from: a */
    public static final Byte m7129a(long j) {
        long j2 = (long) 127;
        if (((long) -128) <= j && j2 >= j) {
            return Byte.valueOf((byte) ((int) j));
        }
        return null;
    }

    /* renamed from: a */
    public static final Byte m7130a(short s) {
        short s2 = (short) 127;
        if (((short) -128) <= s && s2 >= s) {
            return Byte.valueOf((byte) s);
        }
        return null;
    }

    /* renamed from: a */
    public static final Byte m7126a(double d) {
        double d2 = (double) 127;
        if (d < ((double) -128) || d > d2) {
            return null;
        }
        return Byte.valueOf((byte) ((int) d));
    }

    /* renamed from: a */
    public static final Byte m7127a(float f) {
        float f2 = (float) 127;
        if (f < ((float) -128) || f > f2) {
            return null;
        }
        return Byte.valueOf((byte) ((int) f));
    }

    /* renamed from: b */
    public static final Integer m7166b(long j) {
        long j2 = (long) Integer.MAX_VALUE;
        if (((long) Integer.MIN_VALUE) <= j && j2 >= j) {
            return Integer.valueOf((int) j);
        }
        return null;
    }

    /* renamed from: b */
    public static final Integer m7164b(double d) {
        double d2 = (double) Integer.MAX_VALUE;
        if (d < ((double) Integer.MIN_VALUE) || d > d2) {
            return null;
        }
        return Integer.valueOf((int) d);
    }

    /* renamed from: b */
    public static final Integer m7165b(float f) {
        float f2 = (float) Integer.MAX_VALUE;
        if (f < ((float) Integer.MIN_VALUE) || f > f2) {
            return null;
        }
        return Integer.valueOf((int) f);
    }

    /* renamed from: c */
    public static final Long m7180c(double d) {
        double d2 = (double) bfu.f2629b;
        if (d < ((double) Long.MIN_VALUE) || d > d2) {
            return null;
        }
        return Long.valueOf((long) d);
    }

    /* renamed from: c */
    public static final Long m7181c(float f) {
        float f2 = (float) bfu.f2629b;
        if (f < ((float) Long.MIN_VALUE) || f > f2) {
            return null;
        }
        return Long.valueOf((long) f);
    }

    /* renamed from: b */
    public static final Short m7167b(int i) {
        if (-32768 <= i && 32767 >= i) {
            return Short.valueOf((short) i);
        }
        return null;
    }

    /* renamed from: c */
    public static final Short m7182c(long j) {
        long j2 = (long) 32767;
        if (((long) -32768) <= j && j2 >= j) {
            return Short.valueOf((short) ((int) j));
        }
        return null;
    }

    /* renamed from: d */
    public static final Short m7193d(double d) {
        double d2 = (double) 32767;
        if (d < ((double) -32768) || d > d2) {
            return null;
        }
        return Short.valueOf((short) ((int) d));
    }

    /* renamed from: d */
    public static final Short m7194d(float f) {
        float f2 = (float) 32767;
        if (f < ((float) -32768) || f > f2) {
            return null;
        }
        return Short.valueOf((short) ((int) f));
    }

    /* renamed from: b */
    public static final biq m7150b(int i, byte b) {
        return new biq(i, b - 1);
    }

    /* renamed from: b */
    public static final bit m7158b(long j, byte b) {
        return new bit(j, ((long) b) - 1);
    }

    /* renamed from: b */
    public static final biq m7147b(byte b, byte b2) {
        return new biq(b, b2 - 1);
    }

    /* renamed from: b */
    public static final biq m7153b(short s, byte b) {
        return new biq(s, b - 1);
    }

    /* renamed from: b */
    public static final bii m7146b(char c, char c2) {
        if (c2 <= 0) {
            return bii.f2726b.mo2572a();
        }
        return new bii(c, (char) (c2 - 1));
    }

    /* renamed from: b */
    public static final biq m7151b(int i, int i2) {
        if (i2 <= Integer.MIN_VALUE) {
            return biq.f2742b.mo2606a();
        }
        return new biq(i, i2 - 1);
    }

    /* renamed from: b */
    public static final bit m7159b(long j, int i) {
        return new bit(j, ((long) i) - 1);
    }

    /* renamed from: b */
    public static final biq m7148b(byte b, int i) {
        if (i <= Integer.MIN_VALUE) {
            return biq.f2742b.mo2606a();
        }
        return new biq(b, i - 1);
    }

    /* renamed from: b */
    public static final biq m7154b(short s, int i) {
        if (i <= Integer.MIN_VALUE) {
            return biq.f2742b.mo2606a();
        }
        return new biq(s, i - 1);
    }

    /* renamed from: b */
    public static final bit m7157b(int i, long j) {
        if (j <= Long.MIN_VALUE) {
            return bit.f2752b.mo2622a();
        }
        return new bit((long) i, j - 1);
    }

    /* renamed from: b */
    public static final bit m7160b(long j, long j2) {
        if (j2 <= Long.MIN_VALUE) {
            return bit.f2752b.mo2622a();
        }
        return new bit(j, j2 - 1);
    }

    /* renamed from: b */
    public static final bit m7156b(byte b, long j) {
        if (j <= Long.MIN_VALUE) {
            return bit.f2752b.mo2622a();
        }
        return new bit((long) b, j - 1);
    }

    /* renamed from: b */
    public static final bit m7162b(short s, long j) {
        if (j <= Long.MIN_VALUE) {
            return bit.f2752b.mo2622a();
        }
        return new bit((long) s, j - 1);
    }

    /* renamed from: b */
    public static final biq m7152b(int i, short s) {
        return new biq(i, s - 1);
    }

    /* renamed from: b */
    public static final bit m7161b(long j, short s) {
        return new bit(j, ((long) s) - 1);
    }

    /* renamed from: b */
    public static final biq m7149b(byte b, short s) {
        return new biq(b, s - 1);
    }

    /* renamed from: b */
    public static final biq m7155b(short s, short s2) {
        return new biq(s, s2 - 1);
    }

    /* renamed from: b */
    public static final <T extends Comparable<? super T>> T m7163b(T t, T t2) {
        bfq.m6567f(t, "$this$coerceAtLeast");
        bfq.m6567f(t2, "minimumValue");
        return t.compareTo(t2) < 0 ? t2 : t;
    }

    /* renamed from: c */
    public static final <T extends Comparable<? super T>> T m7179c(T t, T t2) {
        bfq.m6567f(t, "$this$coerceAtMost");
        bfq.m6567f(t2, "maximumValue");
        return t.compareTo(t2) > 0 ? t2 : t;
    }

    /* renamed from: a */
    public static final <T extends Comparable<? super T>> T m7133a(T t, T t2, T t3) {
        bfq.m6567f(t, "$this$coerceIn");
        if (t2 == null || t3 == null) {
            if (t2 == null || t.compareTo(t2) >= 0) {
                return (t3 == null || t.compareTo(t3) <= 0) ? t : t3;
            }
            return t2;
        } else if (t2.compareTo(t3) > 0) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + t3 + " is less than minimum " + t2 + '.');
        } else if (t.compareTo(t2) < 0) {
            return t2;
        } else {
            if (t.compareTo(t3) > 0) {
                return t3;
            }
        }
    }

    /* renamed from: a */
    public static final byte m7090a(byte b, byte b2, byte b3) {
        if (b2 > b3) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + b3 + " is less than minimum " + b2 + '.');
        } else if (b < b2) {
            return b2;
        } else {
            return b > b3 ? b3 : b;
        }
    }

    /* renamed from: a */
    public static final short m7134a(short s, short s2, short s3) {
        if (s2 > s3) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + s3 + " is less than minimum " + s2 + '.');
        } else if (s < s2) {
            return s2;
        } else {
            return s > s3 ? s3 : s;
        }
    }

    /* renamed from: a */
    public static final int m7095a(int i, int i2, int i3) {
        if (i2 > i3) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i3 + " is less than minimum " + i2 + '.');
        } else if (i < i2) {
            return i2;
        } else {
            return i > i3 ? i3 : i;
        }
    }

    /* renamed from: a */
    public static final long m7099a(long j, long j2, long j3) {
        if (j2 > j3) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + j3 + " is less than minimum " + j2 + '.');
        } else if (j < j2) {
            return j2;
        } else {
            return j > j3 ? j3 : j;
        }
    }

    /* renamed from: a */
    public static final float m7094a(float f, float f2, float f3) {
        if (f2 > f3) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + f3 + " is less than minimum " + f2 + '.');
        } else if (f < f2) {
            return f2;
        } else {
            return f > f3 ? f3 : f;
        }
    }

    /* renamed from: a */
    public static final double m7093a(double d, double d2, double d3) {
        if (d2 > d3) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + d3 + " is less than minimum " + d2 + '.');
        } else if (d < d2) {
            return d2;
        } else {
            return d > d3 ? d3 : d;
        }
    }

    /* renamed from: a */
    public static final <T extends Comparable<? super T>> T m7131a(T t, bil<T> bil) {
        bfq.m6567f(t, "$this$coerceIn");
        bfq.m6567f(bil, "range");
        if (bil.mo2558e()) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: " + bil + '.');
        } else if (!bil.mo2576a(t, bil.mo2569g()) || bil.mo2576a(bil.mo2569g(), t)) {
            return (!bil.mo2576a(bil.mo2571i(), t) || bil.mo2576a(t, bil.mo2571i())) ? t : bil.mo2571i();
        } else {
            return bil.mo2569g();
        }
    }

    /* renamed from: a */
    public static final <T extends Comparable<? super T>> T m7132a(T t, bim<T> bim) {
        bfq.m6567f(t, "$this$coerceIn");
        bfq.m6567f(bim, "range");
        if (bim instanceof bil) {
            return biu.m7131a(t, (bil) bim);
        }
        if (bim.mo2558e()) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: " + bim + '.');
        } else if (t.compareTo(bim.mo2569g()) < 0) {
            return bim.mo2569g();
        } else {
            return t.compareTo(bim.mo2571i()) > 0 ? bim.mo2571i() : t;
        }
    }

    /* renamed from: a */
    public static final int m7096a(int i, bim<Integer> bim) {
        bfq.m6567f(bim, "range");
        if (bim instanceof bil) {
            return ((Number) biu.m7131a(Integer.valueOf(i), (bil) bim)).intValue();
        }
        if (bim.mo2558e()) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: " + bim + '.');
        } else if (i < bim.mo2569g().intValue()) {
            return bim.mo2569g().intValue();
        } else {
            return i > bim.mo2571i().intValue() ? bim.mo2571i().intValue() : i;
        }
    }

    /* renamed from: a */
    public static final long m7100a(long j, bim<Long> bim) {
        bfq.m6567f(bim, "range");
        if (bim instanceof bil) {
            return ((Number) biu.m7131a(Long.valueOf(j), (bil) bim)).longValue();
        }
        if (bim.mo2558e()) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: " + bim + '.');
        } else if (j < bim.mo2569g().longValue()) {
            return bim.mo2569g().longValue();
        } else {
            return j > bim.mo2571i().longValue() ? bim.mo2571i().longValue() : j;
        }
    }
}

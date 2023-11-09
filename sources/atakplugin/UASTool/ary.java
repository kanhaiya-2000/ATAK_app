package atakplugin.UASTool;

import indago.serialization.JsonKeyConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

@aot(mo1534a = 5, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0001\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0018\n\u0002\u0010\u0005\n\u0002\u0010\u0012\n\u0002\u0010\f\n\u0002\u0010\u0019\n\u0002\u0010\u0006\n\u0002\u0010\u0013\n\u0002\u0010\u0007\n\u0002\u0010\u0014\n\u0002\u0010\b\n\u0002\u0010\u0015\n\u0002\u0010\t\n\u0002\u0010\u0016\n\u0002\u0010\n\n\u0002\u0010\u0017\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010\u000f\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\u001a#\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0003¢\u0006\u0002\u0010\u0004\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00050\u0001*\u00020\u0006\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001*\u00020\b\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\t0\u0001*\u00020\n\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001*\u00020\f\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\r0\u0001*\u00020\u000e\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0001*\u00020\u0010\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00110\u0001*\u00020\u0012\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00130\u0001*\u00020\u0014\u001aU\u0010\u0015\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\u0006\u0010\u0016\u001a\u0002H\u00022\u001a\u0010\u0017\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0018j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f¢\u0006\u0002\u0010\u001c\u001a9\u0010\u0015\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\u0006\u0010\u0016\u001a\u0002H\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f¢\u0006\u0002\u0010\u001d\u001a&\u0010\u0015\u001a\u00020\u000f*\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a&\u0010\u0015\u001a\u00020\u000f*\u00020\n2\u0006\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a&\u0010\u0015\u001a\u00020\u000f*\u00020\f2\u0006\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a&\u0010\u0015\u001a\u00020\u000f*\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a&\u0010\u0015\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u000f2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a&\u0010\u0015\u001a\u00020\u000f*\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a&\u0010\u0015\u001a\u00020\u000f*\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00132\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a2\u0010\u001e\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\u000e\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0003H\f¢\u0006\u0004\b \u0010!\u001a\"\u0010\"\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0003H\b¢\u0006\u0004\b#\u0010$\u001a\"\u0010%\u001a\u00020&\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0003H\b¢\u0006\u0004\b'\u0010(\u001a0\u0010)\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\u000e\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0003H\f¢\u0006\u0002\u0010!\u001a\u0015\u0010)\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\f\u001a\u0015\u0010)\u001a\u00020\u0005*\u00020\b2\u0006\u0010\u001f\u001a\u00020\bH\f\u001a\u0015\u0010)\u001a\u00020\u0005*\u00020\n2\u0006\u0010\u001f\u001a\u00020\nH\f\u001a\u0015\u0010)\u001a\u00020\u0005*\u00020\f2\u0006\u0010\u001f\u001a\u00020\fH\f\u001a\u0015\u0010)\u001a\u00020\u0005*\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000eH\f\u001a\u0015\u0010)\u001a\u00020\u0005*\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u0010H\f\u001a\u0015\u0010)\u001a\u00020\u0005*\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u0012H\f\u001a\u0015\u0010)\u001a\u00020\u0005*\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u0014H\f\u001a \u0010*\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0003H\b¢\u0006\u0002\u0010$\u001a\r\u0010*\u001a\u00020\u000f*\u00020\u0006H\b\u001a\r\u0010*\u001a\u00020\u000f*\u00020\bH\b\u001a\r\u0010*\u001a\u00020\u000f*\u00020\nH\b\u001a\r\u0010*\u001a\u00020\u000f*\u00020\fH\b\u001a\r\u0010*\u001a\u00020\u000f*\u00020\u000eH\b\u001a\r\u0010*\u001a\u00020\u000f*\u00020\u0010H\b\u001a\r\u0010*\u001a\u00020\u000f*\u00020\u0012H\b\u001a\r\u0010*\u001a\u00020\u000f*\u00020\u0014H\b\u001a \u0010+\u001a\u00020&\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0003H\b¢\u0006\u0002\u0010(\u001a\r\u0010+\u001a\u00020&*\u00020\u0006H\b\u001a\r\u0010+\u001a\u00020&*\u00020\bH\b\u001a\r\u0010+\u001a\u00020&*\u00020\nH\b\u001a\r\u0010+\u001a\u00020&*\u00020\fH\b\u001a\r\u0010+\u001a\u00020&*\u00020\u000eH\b\u001a\r\u0010+\u001a\u00020&*\u00020\u0010H\b\u001a\r\u0010+\u001a\u00020&*\u00020\u0012H\b\u001a\r\u0010+\u001a\u00020&*\u00020\u0014H\b\u001aQ\u0010,\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\f\u0010-\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00032\b\b\u0002\u0010.\u001a\u00020\u000f2\b\b\u0002\u0010/\u001a\u00020\u000f2\b\b\u0002\u00100\u001a\u00020\u000fH\u0007¢\u0006\u0002\u00101\u001a2\u0010,\u001a\u00020\u0006*\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\b\b\u0002\u0010.\u001a\u00020\u000f2\b\b\u0002\u0010/\u001a\u00020\u000f2\b\b\u0002\u00100\u001a\u00020\u000fH\u0007\u001a2\u0010,\u001a\u00020\b*\u00020\b2\u0006\u0010-\u001a\u00020\b2\b\b\u0002\u0010.\u001a\u00020\u000f2\b\b\u0002\u0010/\u001a\u00020\u000f2\b\b\u0002\u00100\u001a\u00020\u000fH\u0007\u001a2\u0010,\u001a\u00020\n*\u00020\n2\u0006\u0010-\u001a\u00020\n2\b\b\u0002\u0010.\u001a\u00020\u000f2\b\b\u0002\u0010/\u001a\u00020\u000f2\b\b\u0002\u00100\u001a\u00020\u000fH\u0007\u001a2\u0010,\u001a\u00020\f*\u00020\f2\u0006\u0010-\u001a\u00020\f2\b\b\u0002\u0010.\u001a\u00020\u000f2\b\b\u0002\u0010/\u001a\u00020\u000f2\b\b\u0002\u00100\u001a\u00020\u000fH\u0007\u001a2\u0010,\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010-\u001a\u00020\u000e2\b\b\u0002\u0010.\u001a\u00020\u000f2\b\b\u0002\u0010/\u001a\u00020\u000f2\b\b\u0002\u00100\u001a\u00020\u000fH\u0007\u001a2\u0010,\u001a\u00020\u0010*\u00020\u00102\u0006\u0010-\u001a\u00020\u00102\b\b\u0002\u0010.\u001a\u00020\u000f2\b\b\u0002\u0010/\u001a\u00020\u000f2\b\b\u0002\u00100\u001a\u00020\u000fH\u0007\u001a2\u0010,\u001a\u00020\u0012*\u00020\u00122\u0006\u0010-\u001a\u00020\u00122\b\b\u0002\u0010.\u001a\u00020\u000f2\b\b\u0002\u0010/\u001a\u00020\u000f2\b\b\u0002\u00100\u001a\u00020\u000fH\u0007\u001a2\u0010,\u001a\u00020\u0014*\u00020\u00142\u0006\u0010-\u001a\u00020\u00142\b\b\u0002\u0010.\u001a\u00020\u000f2\b\b\u0002\u0010/\u001a\u00020\u000f2\b\b\u0002\u00100\u001a\u00020\u000fH\u0007\u001a$\u00102\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\b¢\u0006\u0002\u00103\u001a.\u00102\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u00104\u001a\u00020\u000fH\b¢\u0006\u0002\u00105\u001a\r\u00102\u001a\u00020\u0006*\u00020\u0006H\b\u001a\u0015\u00102\u001a\u00020\u0006*\u00020\u00062\u0006\u00104\u001a\u00020\u000fH\b\u001a\r\u00102\u001a\u00020\b*\u00020\bH\b\u001a\u0015\u00102\u001a\u00020\b*\u00020\b2\u0006\u00104\u001a\u00020\u000fH\b\u001a\r\u00102\u001a\u00020\n*\u00020\nH\b\u001a\u0015\u00102\u001a\u00020\n*\u00020\n2\u0006\u00104\u001a\u00020\u000fH\b\u001a\r\u00102\u001a\u00020\f*\u00020\fH\b\u001a\u0015\u00102\u001a\u00020\f*\u00020\f2\u0006\u00104\u001a\u00020\u000fH\b\u001a\r\u00102\u001a\u00020\u000e*\u00020\u000eH\b\u001a\u0015\u00102\u001a\u00020\u000e*\u00020\u000e2\u0006\u00104\u001a\u00020\u000fH\b\u001a\r\u00102\u001a\u00020\u0010*\u00020\u0010H\b\u001a\u0015\u00102\u001a\u00020\u0010*\u00020\u00102\u0006\u00104\u001a\u00020\u000fH\b\u001a\r\u00102\u001a\u00020\u0012*\u00020\u0012H\b\u001a\u0015\u00102\u001a\u00020\u0012*\u00020\u00122\u0006\u00104\u001a\u00020\u000fH\b\u001a\r\u00102\u001a\u00020\u0014*\u00020\u0014H\b\u001a\u0015\u00102\u001a\u00020\u0014*\u00020\u00142\u0006\u00104\u001a\u00020\u000fH\b\u001a6\u00106\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\b¢\u0006\u0004\b7\u00108\u001a\"\u00106\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\b¢\u0006\u0002\b7\u001a\"\u00106\u001a\u00020\b*\u00020\b2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\b¢\u0006\u0002\b7\u001a\"\u00106\u001a\u00020\n*\u00020\n2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\b¢\u0006\u0002\b7\u001a\"\u00106\u001a\u00020\f*\u00020\f2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\b¢\u0006\u0002\b7\u001a\"\u00106\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\b¢\u0006\u0002\b7\u001a\"\u00106\u001a\u00020\u0010*\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\b¢\u0006\u0002\b7\u001a\"\u00106\u001a\u00020\u0012*\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\b¢\u0006\u0002\b7\u001a\"\u00106\u001a\u00020\u0014*\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\b¢\u0006\u0002\b7\u001a5\u00109\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0001¢\u0006\u0004\b6\u00108\u001a!\u00109\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0001¢\u0006\u0002\b6\u001a!\u00109\u001a\u00020\b*\u00020\b2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0001¢\u0006\u0002\b6\u001a!\u00109\u001a\u00020\n*\u00020\n2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0001¢\u0006\u0002\b6\u001a!\u00109\u001a\u00020\f*\u00020\f2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0001¢\u0006\u0002\b6\u001a!\u00109\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0001¢\u0006\u0002\b6\u001a!\u00109\u001a\u00020\u0010*\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0001¢\u0006\u0002\b6\u001a!\u00109\u001a\u00020\u0012*\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0001¢\u0006\u0002\b6\u001a!\u00109\u001a\u00020\u0014*\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0001¢\u0006\u0002\b6\u001a(\u0010:\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\u0006\u0010;\u001a\u00020\u000fH\b¢\u0006\u0002\u0010<\u001a\u0015\u0010:\u001a\u00020\u0005*\u00020\u00062\u0006\u0010;\u001a\u00020\u000fH\b\u001a\u0015\u0010:\u001a\u00020\u0007*\u00020\b2\u0006\u0010;\u001a\u00020\u000fH\b\u001a\u0015\u0010:\u001a\u00020\t*\u00020\n2\u0006\u0010;\u001a\u00020\u000fH\b\u001a\u0015\u0010:\u001a\u00020\u000b*\u00020\f2\u0006\u0010;\u001a\u00020\u000fH\b\u001a\u0015\u0010:\u001a\u00020\r*\u00020\u000e2\u0006\u0010;\u001a\u00020\u000fH\b\u001a\u0015\u0010:\u001a\u00020\u000f*\u00020\u00102\u0006\u0010;\u001a\u00020\u000fH\b\u001a\u0015\u0010:\u001a\u00020\u0011*\u00020\u00122\u0006\u0010;\u001a\u00020\u000fH\b\u001a\u0015\u0010:\u001a\u00020\u0013*\u00020\u00142\u0006\u0010;\u001a\u00020\u000fH\b\u001a7\u0010=\u001a\u00020>\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0016\u001a\u0002H\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f¢\u0006\u0002\u0010?\u001a&\u0010=\u001a\u00020>*\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a&\u0010=\u001a\u00020>*\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a&\u0010=\u001a\u00020>*\u00020\n2\u0006\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a&\u0010=\u001a\u00020>*\u00020\f2\u0006\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a&\u0010=\u001a\u00020>*\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a&\u0010=\u001a\u00020>*\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u000f2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a&\u0010=\u001a\u00020>*\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a&\u0010=\u001a\u00020>*\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00132\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a-\u0010@\u001a\b\u0012\u0004\u0012\u0002HA0\u0001\"\u0004\b\u0000\u0010A*\u0006\u0012\u0002\b\u00030\u00032\f\u0010B\u001a\b\u0012\u0004\u0012\u0002HA0C¢\u0006\u0002\u0010D\u001aA\u0010E\u001a\u0002HF\"\u0010\b\u0000\u0010F*\n\u0012\u0006\b\u0000\u0012\u0002HA0G\"\u0004\b\u0001\u0010A*\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010-\u001a\u0002HF2\f\u0010B\u001a\b\u0012\u0004\u0012\u0002HA0C¢\u0006\u0002\u0010H\u001a,\u0010I\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0016\u001a\u0002H\u0002H\u0002¢\u0006\u0002\u0010J\u001a4\u0010I\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u000e\u0010K\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0003H\u0002¢\u0006\u0002\u0010L\u001a2\u0010I\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u0010K\u001a\b\u0012\u0004\u0012\u0002H\u00020MH\u0002¢\u0006\u0002\u0010N\u001a\u0015\u0010I\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0005H\u0002\u001a\u0015\u0010I\u001a\u00020\u0006*\u00020\u00062\u0006\u0010K\u001a\u00020\u0006H\u0002\u001a\u001b\u0010I\u001a\u00020\u0006*\u00020\u00062\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00050MH\u0002\u001a\u0015\u0010I\u001a\u00020\b*\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0007H\u0002\u001a\u0015\u0010I\u001a\u00020\b*\u00020\b2\u0006\u0010K\u001a\u00020\bH\u0002\u001a\u001b\u0010I\u001a\u00020\b*\u00020\b2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00070MH\u0002\u001a\u0015\u0010I\u001a\u00020\n*\u00020\n2\u0006\u0010\u0016\u001a\u00020\tH\u0002\u001a\u0015\u0010I\u001a\u00020\n*\u00020\n2\u0006\u0010K\u001a\u00020\nH\u0002\u001a\u001b\u0010I\u001a\u00020\n*\u00020\n2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\t0MH\u0002\u001a\u0015\u0010I\u001a\u00020\f*\u00020\f2\u0006\u0010\u0016\u001a\u00020\u000bH\u0002\u001a\u0015\u0010I\u001a\u00020\f*\u00020\f2\u0006\u0010K\u001a\u00020\fH\u0002\u001a\u001b\u0010I\u001a\u00020\f*\u00020\f2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u000b0MH\u0002\u001a\u0015\u0010I\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\rH\u0002\u001a\u0015\u0010I\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010K\u001a\u00020\u000eH\u0002\u001a\u001b\u0010I\u001a\u00020\u000e*\u00020\u000e2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\r0MH\u0002\u001a\u0015\u0010I\u001a\u00020\u0010*\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u000fH\u0002\u001a\u0015\u0010I\u001a\u00020\u0010*\u00020\u00102\u0006\u0010K\u001a\u00020\u0010H\u0002\u001a\u001b\u0010I\u001a\u00020\u0010*\u00020\u00102\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u000f0MH\u0002\u001a\u0015\u0010I\u001a\u00020\u0012*\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0011H\u0002\u001a\u0015\u0010I\u001a\u00020\u0012*\u00020\u00122\u0006\u0010K\u001a\u00020\u0012H\u0002\u001a\u001b\u0010I\u001a\u00020\u0012*\u00020\u00122\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00110MH\u0002\u001a\u0015\u0010I\u001a\u00020\u0014*\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0013H\u0002\u001a\u0015\u0010I\u001a\u00020\u0014*\u00020\u00142\u0006\u0010K\u001a\u00020\u0014H\u0002\u001a\u001b\u0010I\u001a\u00020\u0014*\u00020\u00142\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00130MH\u0002\u001a,\u0010O\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0016\u001a\u0002H\u0002H\b¢\u0006\u0002\u0010J\u001a\u001d\u0010P\u001a\u00020>\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0003¢\u0006\u0002\u0010Q\u001a*\u0010P\u001a\u00020>\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020R*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0003H\b¢\u0006\u0002\u0010S\u001a1\u0010P\u001a\u00020>\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f¢\u0006\u0002\u0010T\u001a\n\u0010P\u001a\u00020>*\u00020\b\u001a\u001e\u0010P\u001a\u00020>*\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a\n\u0010P\u001a\u00020>*\u00020\n\u001a\u001e\u0010P\u001a\u00020>*\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a\n\u0010P\u001a\u00020>*\u00020\f\u001a\u001e\u0010P\u001a\u00020>*\u00020\f2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a\n\u0010P\u001a\u00020>*\u00020\u000e\u001a\u001e\u0010P\u001a\u00020>*\u00020\u000e2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a\n\u0010P\u001a\u00020>*\u00020\u0010\u001a\u001e\u0010P\u001a\u00020>*\u00020\u00102\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a\n\u0010P\u001a\u00020>*\u00020\u0012\u001a\u001e\u0010P\u001a\u00020>*\u00020\u00122\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a\n\u0010P\u001a\u00020>*\u00020\u0014\u001a\u001e\u0010P\u001a\u00020>*\u00020\u00142\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a9\u0010U\u001a\u00020>\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\u001a\u0010\u0017\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0018j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0019¢\u0006\u0002\u0010V\u001aM\u0010U\u001a\u00020>\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\u001a\u0010\u0017\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0018j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f¢\u0006\u0002\u0010W\u001a-\u0010X\u001a\b\u0012\u0004\u0012\u0002H\u00020Y\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020R*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0003¢\u0006\u0002\u0010Z\u001a?\u0010X\u001a\b\u0012\u0004\u0012\u0002H\u00020Y\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\u001a\u0010\u0017\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0018j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0019¢\u0006\u0002\u0010[\u001a\u0010\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00050Y*\u00020\u0006\u001a\u0010\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00070Y*\u00020\b\u001a\u0010\u0010X\u001a\b\u0012\u0004\u0012\u00020\t0Y*\u00020\n\u001a\u0010\u0010X\u001a\b\u0012\u0004\u0012\u00020\u000b0Y*\u00020\f\u001a\u0010\u0010X\u001a\b\u0012\u0004\u0012\u00020\r0Y*\u00020\u000e\u001a\u0010\u0010X\u001a\b\u0012\u0004\u0012\u00020\u000f0Y*\u00020\u0010\u001a\u0010\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00110Y*\u00020\u0012\u001a\u0010\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00130Y*\u00020\u0014\u001a\u0015\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00050\u0003*\u00020\u0006¢\u0006\u0002\u0010]\u001a\u0015\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003*\u00020\b¢\u0006\u0002\u0010^\u001a\u0015\u0010\\\u001a\b\u0012\u0004\u0012\u00020\t0\u0003*\u00020\n¢\u0006\u0002\u0010_\u001a\u0015\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003*\u00020\f¢\u0006\u0002\u0010`\u001a\u0015\u0010\\\u001a\b\u0012\u0004\u0012\u00020\r0\u0003*\u00020\u000e¢\u0006\u0002\u0010a\u001a\u0015\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0003*\u00020\u0010¢\u0006\u0002\u0010b\u001a\u0015\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00110\u0003*\u00020\u0012¢\u0006\u0002\u0010c\u001a\u0015\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00130\u0003*\u00020\u0014¢\u0006\u0002\u0010d¨\u0006e"}, mo1538e = {"asList", "", "T", "", "([Ljava/lang/Object;)Ljava/util/List;", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "binarySearch", "element", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "fromIndex", "toIndex", "([Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Comparator;II)I", "([Ljava/lang/Object;Ljava/lang/Object;II)I", "contentDeepEquals", "other", "contentDeepEqualsInline", "([Ljava/lang/Object;[Ljava/lang/Object;)Z", "contentDeepHashCode", "contentDeepHashCodeInline", "([Ljava/lang/Object;)I", "contentDeepToString", "", "contentDeepToStringInline", "([Ljava/lang/Object;)Ljava/lang/String;", "contentEquals", "contentHashCode", "contentToString", "copyInto", "destination", "destinationOffset", "startIndex", "endIndex", "([Ljava/lang/Object;[Ljava/lang/Object;III)[Ljava/lang/Object;", "copyOf", "([Ljava/lang/Object;)[Ljava/lang/Object;", "newSize", "([Ljava/lang/Object;I)[Ljava/lang/Object;", "copyOfRange", "copyOfRangeInline", "([Ljava/lang/Object;II)[Ljava/lang/Object;", "copyOfRangeImpl", "elementAt", "index", "([Ljava/lang/Object;I)Ljava/lang/Object;", "fill", "", "([Ljava/lang/Object;Ljava/lang/Object;II)V", "filterIsInstance", "R", "klass", "Ljava/lang/Class;", "([Ljava/lang/Object;Ljava/lang/Class;)Ljava/util/List;", "filterIsInstanceTo", "C", "", "([Ljava/lang/Object;Ljava/util/Collection;Ljava/lang/Class;)Ljava/util/Collection;", "plus", "([Ljava/lang/Object;Ljava/lang/Object;)[Ljava/lang/Object;", "elements", "([Ljava/lang/Object;[Ljava/lang/Object;)[Ljava/lang/Object;", "", "([Ljava/lang/Object;Ljava/util/Collection;)[Ljava/lang/Object;", "plusElement", "sort", "([Ljava/lang/Object;)V", "", "([Ljava/lang/Comparable;)V", "([Ljava/lang/Object;II)V", "sortWith", "([Ljava/lang/Object;Ljava/util/Comparator;)V", "([Ljava/lang/Object;Ljava/util/Comparator;II)V", "toSortedSet", "Ljava/util/SortedSet;", "([Ljava/lang/Comparable;)Ljava/util/SortedSet;", "([Ljava/lang/Object;Ljava/util/Comparator;)Ljava/util/SortedSet;", "toTypedArray", "([Z)[Ljava/lang/Boolean;", "([B)[Ljava/lang/Byte;", "([C)[Ljava/lang/Character;", "([D)[Ljava/lang/Double;", "([F)[Ljava/lang/Float;", "([I)[Ljava/lang/Integer;", "([J)[Ljava/lang/Long;", "([S)[Ljava/lang/Short;", "kotlin-stdlib"}, mo1539f = "kotlin/collections/ArraysKt", mo1541h = 1)
class ary extends arx {
    /* renamed from: b */
    private static final <T> T m3203b(T[] tArr, int i) {
        return tArr[i];
    }

    /* renamed from: a */
    private static final byte m3100a(byte[] bArr, int i) {
        return bArr[i];
    }

    /* renamed from: a */
    private static final short m3134a(short[] sArr, int i) {
        return sArr[i];
    }

    /* renamed from: b */
    private static final int m3202b(int[] iArr, int i) {
        return iArr[i];
    }

    /* renamed from: a */
    private static final long m3122a(long[] jArr, int i) {
        return jArr[i];
    }

    /* renamed from: a */
    private static final float m3103a(float[] fArr, int i) {
        return fArr[i];
    }

    /* renamed from: a */
    private static final double m3102a(double[] dArr, int i) {
        return dArr[i];
    }

    /* renamed from: a */
    private static final boolean m3148a(boolean[] zArr, int i) {
        return zArr[i];
    }

    /* renamed from: a */
    private static final char m3101a(char[] cArr, int i) {
        return cArr[i];
    }

    /* renamed from: a */
    public static final <R> List<R> m3130a(Object[] objArr, Class<R> cls) {
        bfq.m6567f(objArr, "$this$filterIsInstance");
        bfq.m6567f(cls, "klass");
        return (List) arv.m3123a(objArr, new ArrayList(), cls);
    }

    /* renamed from: a */
    public static final <C extends Collection<? super R>, R> C m3123a(Object[] objArr, C c, Class<R> cls) {
        bfq.m6567f(objArr, "$this$filterIsInstanceTo");
        bfq.m6567f(c, JsonKeyConstants.DESTINATION);
        bfq.m6567f(cls, "klass");
        for (Object obj : objArr) {
            if (cls.isInstance(obj)) {
                c.add(obj);
            }
        }
        return c;
    }

    /* renamed from: d */
    public static final <T> List<T> m3276d(T[] tArr) {
        bfq.m6567f(tArr, "$this$asList");
        List<T> a = atk.m4578a(tArr);
        bfq.m6554b(a, "ArraysUtilJVM.asList(this)");
        return a;
    }

    /* renamed from: a */
    public static final List<Byte> m3124a(byte[] bArr) {
        bfq.m6567f(bArr, "$this$asList");
        return new arz(bArr);
    }

    /* renamed from: a */
    public static final List<Short> m3131a(short[] sArr) {
        bfq.m6567f(sArr, "$this$asList");
        return new asa(sArr);
    }

    /* renamed from: a */
    public static final List<Integer> m3128a(int[] iArr) {
        bfq.m6567f(iArr, "$this$asList");
        return new asb(iArr);
    }

    /* renamed from: a */
    public static final List<Long> m3129a(long[] jArr) {
        bfq.m6567f(jArr, "$this$asList");
        return new asc(jArr);
    }

    /* renamed from: a */
    public static final List<Float> m3127a(float[] fArr) {
        bfq.m6567f(fArr, "$this$asList");
        return new asd(fArr);
    }

    /* renamed from: a */
    public static final List<Double> m3126a(double[] dArr) {
        bfq.m6567f(dArr, "$this$asList");
        return new ase(dArr);
    }

    /* renamed from: a */
    public static final List<Boolean> m3132a(boolean[] zArr) {
        bfq.m6567f(zArr, "$this$asList");
        return new asf(zArr);
    }

    /* renamed from: a */
    public static final List<Character> m3125a(char[] cArr) {
        bfq.m6567f(cArr, "$this$asList");
        return new asg(cArr);
    }

    /* renamed from: a */
    public static /* synthetic */ int m3119a(Object[] objArr, Object obj, Comparator comparator, int i, int i2, int i3, Object obj2) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        if ((i3 & 8) != 0) {
            i2 = objArr.length;
        }
        return arv.m3118a((T[]) objArr, obj, comparator, i, i2);
    }

    /* renamed from: a */
    public static final <T> int m3118a(T[] tArr, T t, Comparator<? super T> comparator, int i, int i2) {
        bfq.m6567f(tArr, "$this$binarySearch");
        bfq.m6567f(comparator, "comparator");
        return Arrays.binarySearch(tArr, i, i2, t, comparator);
    }

    /* renamed from: a */
    public static /* synthetic */ int m3117a(Object[] objArr, Object obj, int i, int i2, int i3, Object obj2) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = objArr.length;
        }
        return arv.m3116a((T[]) objArr, obj, i, i2);
    }

    /* renamed from: a */
    public static final <T> int m3116a(T[] tArr, T t, int i, int i2) {
        bfq.m6567f(tArr, "$this$binarySearch");
        return Arrays.binarySearch(tArr, i, i2, t);
    }

    /* renamed from: a */
    public static /* synthetic */ int m3105a(byte[] bArr, byte b, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length;
        }
        return arv.m3104a(bArr, b, i, i2);
    }

    /* renamed from: a */
    public static final int m3104a(byte[] bArr, byte b, int i, int i2) {
        bfq.m6567f(bArr, "$this$binarySearch");
        return Arrays.binarySearch(bArr, i, i2, b);
    }

    /* renamed from: a */
    public static /* synthetic */ int m3121a(short[] sArr, short s, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = sArr.length;
        }
        return arv.m3120a(sArr, s, i, i2);
    }

    /* renamed from: a */
    public static final int m3120a(short[] sArr, short s, int i, int i2) {
        bfq.m6567f(sArr, "$this$binarySearch");
        return Arrays.binarySearch(sArr, i, i2, s);
    }

    /* renamed from: a */
    public static /* synthetic */ int m3113a(int[] iArr, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = iArr.length;
        }
        return arv.m3112a(iArr, i, i2, i3);
    }

    /* renamed from: a */
    public static final int m3112a(int[] iArr, int i, int i2, int i3) {
        bfq.m6567f(iArr, "$this$binarySearch");
        return Arrays.binarySearch(iArr, i2, i3, i);
    }

    /* renamed from: a */
    public static /* synthetic */ int m3115a(long[] jArr, long j, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = jArr.length;
        }
        return arv.m3114a(jArr, j, i, i2);
    }

    /* renamed from: a */
    public static final int m3114a(long[] jArr, long j, int i, int i2) {
        bfq.m6567f(jArr, "$this$binarySearch");
        return Arrays.binarySearch(jArr, i, i2, j);
    }

    /* renamed from: a */
    public static /* synthetic */ int m3111a(float[] fArr, float f, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = fArr.length;
        }
        return arv.m3110a(fArr, f, i, i2);
    }

    /* renamed from: a */
    public static final int m3110a(float[] fArr, float f, int i, int i2) {
        bfq.m6567f(fArr, "$this$binarySearch");
        return Arrays.binarySearch(fArr, i, i2, f);
    }

    /* renamed from: a */
    public static /* synthetic */ int m3109a(double[] dArr, double d, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = dArr.length;
        }
        return arv.m3108a(dArr, d, i, i2);
    }

    /* renamed from: a */
    public static final int m3108a(double[] dArr, double d, int i, int i2) {
        bfq.m6567f(dArr, "$this$binarySearch");
        return Arrays.binarySearch(dArr, i, i2, d);
    }

    /* renamed from: a */
    public static /* synthetic */ int m3107a(char[] cArr, char c, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = cArr.length;
        }
        return arv.m3106a(cArr, c, i, i2);
    }

    /* renamed from: a */
    public static final int m3106a(char[] cArr, char c, int i, int i2) {
        bfq.m6567f(cArr, "$this$binarySearch");
        return Arrays.binarySearch(cArr, i, i2, c);
    }

    /* renamed from: c */
    private static final <T> boolean m3257c(T[] tArr, T[] tArr2) {
        if (bbg.m6171a(1, 3, 0)) {
            return arv.m3097a(tArr, tArr2);
        }
        return Arrays.deepEquals(tArr, tArr2);
    }

    /* renamed from: f */
    private static final <T> int m3294f(T[] tArr) {
        if (bbg.m6171a(1, 3, 0)) {
            return arv.m3092b(tArr);
        }
        return Arrays.deepHashCode(tArr);
    }

    /* renamed from: g */
    private static final <T> String m3303g(T[] tArr) {
        if (bbg.m6171a(1, 3, 0)) {
            return arv.m3098c(tArr);
        }
        String deepToString = Arrays.deepToString(tArr);
        bfq.m6554b(deepToString, "java.util.Arrays.deepToString(this)");
        return deepToString;
    }

    /* renamed from: d */
    private static final <T> boolean m3284d(T[] tArr, T[] tArr2) {
        return Arrays.equals(tArr, tArr2);
    }

    /* renamed from: b */
    private static final boolean m3237b(byte[] bArr, byte[] bArr2) {
        return Arrays.equals(bArr, bArr2);
    }

    /* renamed from: b */
    private static final boolean m3243b(short[] sArr, short[] sArr2) {
        return Arrays.equals(sArr, sArr2);
    }

    /* renamed from: b */
    private static final boolean m3241b(int[] iArr, int[] iArr2) {
        return Arrays.equals(iArr, iArr2);
    }

    /* renamed from: b */
    private static final boolean m3242b(long[] jArr, long[] jArr2) {
        return Arrays.equals(jArr, jArr2);
    }

    /* renamed from: b */
    private static final boolean m3240b(float[] fArr, float[] fArr2) {
        return Arrays.equals(fArr, fArr2);
    }

    /* renamed from: b */
    private static final boolean m3239b(double[] dArr, double[] dArr2) {
        return Arrays.equals(dArr, dArr2);
    }

    /* renamed from: b */
    private static final boolean m3244b(boolean[] zArr, boolean[] zArr2) {
        return Arrays.equals(zArr, zArr2);
    }

    /* renamed from: b */
    private static final boolean m3238b(char[] cArr, char[] cArr2) {
        return Arrays.equals(cArr, cArr2);
    }

    /* renamed from: h */
    private static final <T> int m3311h(T[] tArr) {
        return Arrays.hashCode(tArr);
    }

    /* renamed from: e */
    private static final int m3285e(byte[] bArr) {
        return Arrays.hashCode(bArr);
    }

    /* renamed from: e */
    private static final int m3291e(short[] sArr) {
        return Arrays.hashCode(sArr);
    }

    /* renamed from: e */
    private static final int m3289e(int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    /* renamed from: e */
    private static final int m3290e(long[] jArr) {
        return Arrays.hashCode(jArr);
    }

    /* renamed from: e */
    private static final int m3288e(float[] fArr) {
        return Arrays.hashCode(fArr);
    }

    /* renamed from: e */
    private static final int m3287e(double[] dArr) {
        return Arrays.hashCode(dArr);
    }

    /* renamed from: d */
    private static final int m3275d(boolean[] zArr) {
        return Arrays.hashCode(zArr);
    }

    /* renamed from: e */
    private static final int m3286e(char[] cArr) {
        return Arrays.hashCode(cArr);
    }

    /* renamed from: i */
    private static final <T> String m3312i(T[] tArr) {
        String arrays = Arrays.toString(tArr);
        bfq.m6554b(arrays, "java.util.Arrays.toString(this)");
        return arrays;
    }

    /* renamed from: f */
    private static final String m3295f(byte[] bArr) {
        String arrays = Arrays.toString(bArr);
        bfq.m6554b(arrays, "java.util.Arrays.toString(this)");
        return arrays;
    }

    /* renamed from: f */
    private static final String m3301f(short[] sArr) {
        String arrays = Arrays.toString(sArr);
        bfq.m6554b(arrays, "java.util.Arrays.toString(this)");
        return arrays;
    }

    /* renamed from: f */
    private static final String m3299f(int[] iArr) {
        String arrays = Arrays.toString(iArr);
        bfq.m6554b(arrays, "java.util.Arrays.toString(this)");
        return arrays;
    }

    /* renamed from: f */
    private static final String m3300f(long[] jArr) {
        String arrays = Arrays.toString(jArr);
        bfq.m6554b(arrays, "java.util.Arrays.toString(this)");
        return arrays;
    }

    /* renamed from: f */
    private static final String m3298f(float[] fArr) {
        String arrays = Arrays.toString(fArr);
        bfq.m6554b(arrays, "java.util.Arrays.toString(this)");
        return arrays;
    }

    /* renamed from: f */
    private static final String m3297f(double[] dArr) {
        String arrays = Arrays.toString(dArr);
        bfq.m6554b(arrays, "java.util.Arrays.toString(this)");
        return arrays;
    }

    /* renamed from: e */
    private static final String m3292e(boolean[] zArr) {
        String arrays = Arrays.toString(zArr);
        bfq.m6554b(arrays, "java.util.Arrays.toString(this)");
        return arrays;
    }

    /* renamed from: f */
    private static final String m3296f(char[] cArr) {
        String arrays = Arrays.toString(cArr);
        bfq.m6554b(arrays, "java.util.Arrays.toString(this)");
        return arrays;
    }

    /* renamed from: a */
    public static /* synthetic */ Object[] m3189a(Object[] objArr, Object[] objArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = objArr.length;
        }
        return arv.m3188a((T[]) objArr, (T[]) objArr2, i, i2, i3);
    }

    /* renamed from: a */
    public static final <T> T[] m3188a(T[] tArr, T[] tArr2, int i, int i2, int i3) {
        bfq.m6567f(tArr, "$this$copyInto");
        bfq.m6567f(tArr2, JsonKeyConstants.DESTINATION);
        System.arraycopy(tArr, i2, tArr2, i, i3 - i2);
        return tArr2;
    }

    /* renamed from: a */
    public static /* synthetic */ byte[] m3154a(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = bArr.length;
        }
        return arv.m3153a(bArr, bArr2, i, i2, i3);
    }

    /* renamed from: a */
    public static final byte[] m3153a(byte[] bArr, byte[] bArr2, int i, int i2, int i3) {
        bfq.m6567f(bArr, "$this$copyInto");
        bfq.m6567f(bArr2, JsonKeyConstants.DESTINATION);
        System.arraycopy(bArr, i2, bArr2, i, i3 - i2);
        return bArr2;
    }

    /* renamed from: a */
    public static /* synthetic */ short[] m3195a(short[] sArr, short[] sArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = sArr.length;
        }
        return arv.m3194a(sArr, sArr2, i, i2, i3);
    }

    /* renamed from: a */
    public static final short[] m3194a(short[] sArr, short[] sArr2, int i, int i2, int i3) {
        bfq.m6567f(sArr, "$this$copyInto");
        bfq.m6567f(sArr2, JsonKeyConstants.DESTINATION);
        System.arraycopy(sArr, i2, sArr2, i, i3 - i2);
        return sArr2;
    }

    /* renamed from: a */
    public static /* synthetic */ int[] m3178a(int[] iArr, int[] iArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = iArr.length;
        }
        return arv.m3177a(iArr, iArr2, i, i2, i3);
    }

    /* renamed from: a */
    public static final int[] m3177a(int[] iArr, int[] iArr2, int i, int i2, int i3) {
        bfq.m6567f(iArr, "$this$copyInto");
        bfq.m6567f(iArr2, JsonKeyConstants.DESTINATION);
        System.arraycopy(iArr, i2, iArr2, i, i3 - i2);
        return iArr2;
    }

    /* renamed from: a */
    public static /* synthetic */ long[] m3184a(long[] jArr, long[] jArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = jArr.length;
        }
        return arv.m3183a(jArr, jArr2, i, i2, i3);
    }

    /* renamed from: a */
    public static final long[] m3183a(long[] jArr, long[] jArr2, int i, int i2, int i3) {
        bfq.m6567f(jArr, "$this$copyInto");
        bfq.m6567f(jArr2, JsonKeyConstants.DESTINATION);
        System.arraycopy(jArr, i2, jArr2, i, i3 - i2);
        return jArr2;
    }

    /* renamed from: a */
    public static /* synthetic */ float[] m3172a(float[] fArr, float[] fArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = fArr.length;
        }
        return arv.m3171a(fArr, fArr2, i, i2, i3);
    }

    /* renamed from: a */
    public static final float[] m3171a(float[] fArr, float[] fArr2, int i, int i2, int i3) {
        bfq.m6567f(fArr, "$this$copyInto");
        bfq.m6567f(fArr2, JsonKeyConstants.DESTINATION);
        System.arraycopy(fArr, i2, fArr2, i, i3 - i2);
        return fArr2;
    }

    /* renamed from: a */
    public static /* synthetic */ double[] m3166a(double[] dArr, double[] dArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = dArr.length;
        }
        return arv.m3165a(dArr, dArr2, i, i2, i3);
    }

    /* renamed from: a */
    public static final double[] m3165a(double[] dArr, double[] dArr2, int i, int i2, int i3) {
        bfq.m6567f(dArr, "$this$copyInto");
        bfq.m6567f(dArr2, JsonKeyConstants.DESTINATION);
        System.arraycopy(dArr, i2, dArr2, i, i3 - i2);
        return dArr2;
    }

    /* renamed from: a */
    public static /* synthetic */ boolean[] m3201a(boolean[] zArr, boolean[] zArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = zArr.length;
        }
        return arv.m3200a(zArr, zArr2, i, i2, i3);
    }

    /* renamed from: a */
    public static final boolean[] m3200a(boolean[] zArr, boolean[] zArr2, int i, int i2, int i3) {
        bfq.m6567f(zArr, "$this$copyInto");
        bfq.m6567f(zArr2, JsonKeyConstants.DESTINATION);
        System.arraycopy(zArr, i2, zArr2, i, i3 - i2);
        return zArr2;
    }

    /* renamed from: a */
    public static /* synthetic */ char[] m3160a(char[] cArr, char[] cArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = cArr.length;
        }
        return arv.m3159a(cArr, cArr2, i, i2, i3);
    }

    /* renamed from: a */
    public static final char[] m3159a(char[] cArr, char[] cArr2, int i, int i2, int i3) {
        bfq.m6567f(cArr, "$this$copyInto");
        bfq.m6567f(cArr2, JsonKeyConstants.DESTINATION);
        System.arraycopy(cArr, i2, cArr2, i, i3 - i2);
        return cArr2;
    }

    /* renamed from: j */
    private static final <T> T[] m3313j(T[] tArr) {
        T[] copyOf = Arrays.copyOf(tArr, tArr.length);
        bfq.m6554b(copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    /* renamed from: g */
    private static final byte[] m3304g(byte[] bArr) {
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        bfq.m6554b(copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    /* renamed from: g */
    private static final short[] m3310g(short[] sArr) {
        short[] copyOf = Arrays.copyOf(sArr, sArr.length);
        bfq.m6554b(copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    /* renamed from: g */
    private static final int[] m3308g(int[] iArr) {
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        bfq.m6554b(copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    /* renamed from: g */
    private static final long[] m3309g(long[] jArr) {
        long[] copyOf = Arrays.copyOf(jArr, jArr.length);
        bfq.m6554b(copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    /* renamed from: g */
    private static final float[] m3307g(float[] fArr) {
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        bfq.m6554b(copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    /* renamed from: g */
    private static final double[] m3306g(double[] dArr) {
        double[] copyOf = Arrays.copyOf(dArr, dArr.length);
        bfq.m6554b(copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    /* renamed from: f */
    private static final boolean[] m3302f(boolean[] zArr) {
        boolean[] copyOf = Arrays.copyOf(zArr, zArr.length);
        bfq.m6554b(copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    /* renamed from: g */
    private static final char[] m3305g(char[] cArr) {
        char[] copyOf = Arrays.copyOf(cArr, cArr.length);
        bfq.m6554b(copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    /* renamed from: b */
    private static final byte[] m3245b(byte[] bArr, int i) {
        byte[] copyOf = Arrays.copyOf(bArr, i);
        bfq.m6554b(copyOf, "java.util.Arrays.copyOf(this, newSize)");
        return copyOf;
    }

    /* renamed from: b */
    private static final short[] m3253b(short[] sArr, int i) {
        short[] copyOf = Arrays.copyOf(sArr, i);
        bfq.m6554b(copyOf, "java.util.Arrays.copyOf(this, newSize)");
        return copyOf;
    }

    /* renamed from: c */
    private static final int[] m3262c(int[] iArr, int i) {
        int[] copyOf = Arrays.copyOf(iArr, i);
        bfq.m6554b(copyOf, "java.util.Arrays.copyOf(this, newSize)");
        return copyOf;
    }

    /* renamed from: b */
    private static final long[] m3249b(long[] jArr, int i) {
        long[] copyOf = Arrays.copyOf(jArr, i);
        bfq.m6554b(copyOf, "java.util.Arrays.copyOf(this, newSize)");
        return copyOf;
    }

    /* renamed from: b */
    private static final float[] m3248b(float[] fArr, int i) {
        float[] copyOf = Arrays.copyOf(fArr, i);
        bfq.m6554b(copyOf, "java.util.Arrays.copyOf(this, newSize)");
        return copyOf;
    }

    /* renamed from: b */
    private static final double[] m3247b(double[] dArr, int i) {
        double[] copyOf = Arrays.copyOf(dArr, i);
        bfq.m6554b(copyOf, "java.util.Arrays.copyOf(this, newSize)");
        return copyOf;
    }

    /* renamed from: b */
    private static final boolean[] m3254b(boolean[] zArr, int i) {
        boolean[] copyOf = Arrays.copyOf(zArr, i);
        bfq.m6554b(copyOf, "java.util.Arrays.copyOf(this, newSize)");
        return copyOf;
    }

    /* renamed from: b */
    private static final char[] m3246b(char[] cArr, int i) {
        char[] copyOf = Arrays.copyOf(cArr, i);
        bfq.m6554b(copyOf, "java.util.Arrays.copyOf(this, newSize)");
        return copyOf;
    }

    /* renamed from: c */
    private static final <T> T[] m3271c(T[] tArr, int i) {
        T[] copyOf = Arrays.copyOf(tArr, i);
        bfq.m6554b(copyOf, "java.util.Arrays.copyOf(this, newSize)");
        return copyOf;
    }

    /* renamed from: c */
    private static final <T> T[] m3272c(T[] tArr, int i, int i2) {
        if (bbg.m6171a(1, 3, 0)) {
            return arv.m3185a(tArr, i, i2);
        }
        if (i2 <= tArr.length) {
            T[] copyOfRange = Arrays.copyOfRange(tArr, i, i2);
            bfq.m6554b(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
            return copyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i2 + ", size: " + tArr.length);
    }

    /* renamed from: c */
    private static final byte[] m3258c(byte[] bArr, int i, int i2) {
        if (bbg.m6171a(1, 3, 0)) {
            return arv.m3150a(bArr, i, i2);
        }
        if (i2 <= bArr.length) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, i, i2);
            bfq.m6554b(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
            return copyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i2 + ", size: " + bArr.length);
    }

    /* renamed from: c */
    private static final short[] m3274c(short[] sArr, int i, int i2) {
        if (bbg.m6171a(1, 3, 0)) {
            return arv.m3190a(sArr, i, i2);
        }
        if (i2 <= sArr.length) {
            short[] copyOfRange = Arrays.copyOfRange(sArr, i, i2);
            bfq.m6554b(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
            return copyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i2 + ", size: " + sArr.length);
    }

    /* renamed from: c */
    private static final int[] m3263c(int[] iArr, int i, int i2) {
        if (bbg.m6171a(1, 3, 0)) {
            return arv.m3174a(iArr, i, i2);
        }
        if (i2 <= iArr.length) {
            int[] copyOfRange = Arrays.copyOfRange(iArr, i, i2);
            bfq.m6554b(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
            return copyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i2 + ", size: " + iArr.length);
    }

    /* renamed from: c */
    private static final long[] m3264c(long[] jArr, int i, int i2) {
        if (bbg.m6171a(1, 3, 0)) {
            return arv.m3179a(jArr, i, i2);
        }
        if (i2 <= jArr.length) {
            long[] copyOfRange = Arrays.copyOfRange(jArr, i, i2);
            bfq.m6554b(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
            return copyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i2 + ", size: " + jArr.length);
    }

    /* renamed from: c */
    private static final float[] m3261c(float[] fArr, int i, int i2) {
        if (bbg.m6171a(1, 3, 0)) {
            return arv.m3168a(fArr, i, i2);
        }
        if (i2 <= fArr.length) {
            float[] copyOfRange = Arrays.copyOfRange(fArr, i, i2);
            bfq.m6554b(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
            return copyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i2 + ", size: " + fArr.length);
    }

    /* renamed from: c */
    private static final double[] m3260c(double[] dArr, int i, int i2) {
        if (bbg.m6171a(1, 3, 0)) {
            return arv.m3162a(dArr, i, i2);
        }
        if (i2 <= dArr.length) {
            double[] copyOfRange = Arrays.copyOfRange(dArr, i, i2);
            bfq.m6554b(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
            return copyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i2 + ", size: " + dArr.length);
    }

    /* renamed from: b */
    private static final boolean[] m3255b(boolean[] zArr, int i, int i2) {
        if (bbg.m6171a(1, 3, 0)) {
            return arv.m3196a(zArr, i, i2);
        }
        if (i2 <= zArr.length) {
            boolean[] copyOfRange = Arrays.copyOfRange(zArr, i, i2);
            bfq.m6554b(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
            return copyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i2 + ", size: " + zArr.length);
    }

    /* renamed from: c */
    private static final char[] m3259c(char[] cArr, int i, int i2) {
        if (bbg.m6171a(1, 3, 0)) {
            return arv.m3156a(cArr, i, i2);
        }
        if (i2 <= cArr.length) {
            char[] copyOfRange = Arrays.copyOfRange(cArr, i, i2);
            bfq.m6554b(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
            return copyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i2 + ", size: " + cArr.length);
    }

    /* renamed from: a */
    public static final <T> T[] m3185a(T[] tArr, int i, int i2) {
        bfq.m6567f(tArr, "$this$copyOfRangeImpl");
        arv.m3088a(i2, tArr.length);
        T[] copyOfRange = Arrays.copyOfRange(tArr, i, i2);
        bfq.m6554b(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return copyOfRange;
    }

    /* renamed from: a */
    public static final byte[] m3150a(byte[] bArr, int i, int i2) {
        bfq.m6567f(bArr, "$this$copyOfRangeImpl");
        arv.m3088a(i2, bArr.length);
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i, i2);
        bfq.m6554b(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return copyOfRange;
    }

    /* renamed from: a */
    public static final short[] m3190a(short[] sArr, int i, int i2) {
        bfq.m6567f(sArr, "$this$copyOfRangeImpl");
        arv.m3088a(i2, sArr.length);
        short[] copyOfRange = Arrays.copyOfRange(sArr, i, i2);
        bfq.m6554b(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return copyOfRange;
    }

    /* renamed from: a */
    public static final int[] m3174a(int[] iArr, int i, int i2) {
        bfq.m6567f(iArr, "$this$copyOfRangeImpl");
        arv.m3088a(i2, iArr.length);
        int[] copyOfRange = Arrays.copyOfRange(iArr, i, i2);
        bfq.m6554b(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return copyOfRange;
    }

    /* renamed from: a */
    public static final long[] m3179a(long[] jArr, int i, int i2) {
        bfq.m6567f(jArr, "$this$copyOfRangeImpl");
        arv.m3088a(i2, jArr.length);
        long[] copyOfRange = Arrays.copyOfRange(jArr, i, i2);
        bfq.m6554b(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return copyOfRange;
    }

    /* renamed from: a */
    public static final float[] m3168a(float[] fArr, int i, int i2) {
        bfq.m6567f(fArr, "$this$copyOfRangeImpl");
        arv.m3088a(i2, fArr.length);
        float[] copyOfRange = Arrays.copyOfRange(fArr, i, i2);
        bfq.m6554b(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return copyOfRange;
    }

    /* renamed from: a */
    public static final double[] m3162a(double[] dArr, int i, int i2) {
        bfq.m6567f(dArr, "$this$copyOfRangeImpl");
        arv.m3088a(i2, dArr.length);
        double[] copyOfRange = Arrays.copyOfRange(dArr, i, i2);
        bfq.m6554b(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return copyOfRange;
    }

    /* renamed from: a */
    public static final boolean[] m3196a(boolean[] zArr, int i, int i2) {
        bfq.m6567f(zArr, "$this$copyOfRangeImpl");
        arv.m3088a(i2, zArr.length);
        boolean[] copyOfRange = Arrays.copyOfRange(zArr, i, i2);
        bfq.m6554b(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return copyOfRange;
    }

    /* renamed from: a */
    public static final char[] m3156a(char[] cArr, int i, int i2) {
        bfq.m6567f(cArr, "$this$copyOfRangeImpl");
        arv.m3088a(i2, cArr.length);
        char[] copyOfRange = Arrays.copyOfRange(cArr, i, i2);
        bfq.m6554b(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return copyOfRange;
    }

    /* renamed from: b */
    public static /* synthetic */ void m3232b(Object[] objArr, Object obj, int i, int i2, int i3, Object obj2) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = objArr.length;
        }
        arv.m3231b((T[]) objArr, obj, i, i2);
    }

    /* renamed from: b */
    public static final <T> void m3231b(T[] tArr, T t, int i, int i2) {
        bfq.m6567f(tArr, "$this$fill");
        Arrays.fill(tArr, i, i2, t);
    }

    /* renamed from: b */
    public static /* synthetic */ void m3207b(byte[] bArr, byte b, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length;
        }
        arv.m3206b(bArr, b, i, i2);
    }

    /* renamed from: b */
    public static final void m3206b(byte[] bArr, byte b, int i, int i2) {
        bfq.m6567f(bArr, "$this$fill");
        Arrays.fill(bArr, i, i2, b);
    }

    /* renamed from: b */
    public static /* synthetic */ void m3236b(short[] sArr, short s, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = sArr.length;
        }
        arv.m3235b(sArr, s, i, i2);
    }

    /* renamed from: b */
    public static final void m3235b(short[] sArr, short s, int i, int i2) {
        bfq.m6567f(sArr, "$this$fill");
        Arrays.fill(sArr, i, i2, s);
    }

    /* renamed from: b */
    public static /* synthetic */ void m3224b(int[] iArr, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = iArr.length;
        }
        arv.m3223b(iArr, i, i2, i3);
    }

    /* renamed from: b */
    public static final void m3223b(int[] iArr, int i, int i2, int i3) {
        bfq.m6567f(iArr, "$this$fill");
        Arrays.fill(iArr, i2, i3, i);
    }

    /* renamed from: b */
    public static /* synthetic */ void m3228b(long[] jArr, long j, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = jArr.length;
        }
        arv.m3227b(jArr, j, i, i2);
    }

    /* renamed from: b */
    public static final void m3227b(long[] jArr, long j, int i, int i2) {
        bfq.m6567f(jArr, "$this$fill");
        Arrays.fill(jArr, i, i2, j);
    }

    /* renamed from: b */
    public static /* synthetic */ void m3219b(float[] fArr, float f, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = fArr.length;
        }
        arv.m3218b(fArr, f, i, i2);
    }

    /* renamed from: b */
    public static final void m3218b(float[] fArr, float f, int i, int i2) {
        bfq.m6567f(fArr, "$this$fill");
        Arrays.fill(fArr, i, i2, f);
    }

    /* renamed from: b */
    public static /* synthetic */ void m3215b(double[] dArr, double d, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = dArr.length;
        }
        arv.m3214b(dArr, d, i, i2);
    }

    /* renamed from: b */
    public static final void m3214b(double[] dArr, double d, int i, int i2) {
        bfq.m6567f(dArr, "$this$fill");
        Arrays.fill(dArr, i, i2, d);
    }

    /* renamed from: a */
    public static /* synthetic */ void m3147a(boolean[] zArr, boolean z, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = zArr.length;
        }
        arv.m3146a(zArr, z, i, i2);
    }

    /* renamed from: a */
    public static final void m3146a(boolean[] zArr, boolean z, int i, int i2) {
        bfq.m6567f(zArr, "$this$fill");
        Arrays.fill(zArr, i, i2, z);
    }

    /* renamed from: b */
    public static /* synthetic */ void m3211b(char[] cArr, char c, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = cArr.length;
        }
        arv.m3210b(cArr, c, i, i2);
    }

    /* renamed from: b */
    public static final void m3210b(char[] cArr, char c, int i, int i2) {
        bfq.m6567f(cArr, "$this$fill");
        Arrays.fill(cArr, i, i2, c);
    }

    /* renamed from: a */
    public static final <T> T[] m3186a(T[] tArr, T t) {
        bfq.m6567f(tArr, "$this$plus");
        int length = tArr.length;
        T[] copyOf = Arrays.copyOf(tArr, length + 1);
        copyOf[length] = t;
        bfq.m6554b(copyOf, "result");
        return copyOf;
    }

    /* renamed from: a */
    public static final byte[] m3149a(byte[] bArr, byte b) {
        bfq.m6567f(bArr, "$this$plus");
        int length = bArr.length;
        byte[] copyOf = Arrays.copyOf(bArr, length + 1);
        copyOf[length] = b;
        bfq.m6554b(copyOf, "result");
        return copyOf;
    }

    /* renamed from: a */
    public static final short[] m3192a(short[] sArr, short s) {
        bfq.m6567f(sArr, "$this$plus");
        int length = sArr.length;
        short[] copyOf = Arrays.copyOf(sArr, length + 1);
        copyOf[length] = s;
        bfq.m6554b(copyOf, "result");
        return copyOf;
    }

    /* renamed from: a */
    public static final int[] m3173a(int[] iArr, int i) {
        bfq.m6567f(iArr, "$this$plus");
        int length = iArr.length;
        int[] copyOf = Arrays.copyOf(iArr, length + 1);
        copyOf[length] = i;
        bfq.m6554b(copyOf, "result");
        return copyOf;
    }

    /* renamed from: a */
    public static final long[] m3180a(long[] jArr, long j) {
        bfq.m6567f(jArr, "$this$plus");
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, length + 1);
        copyOf[length] = j;
        bfq.m6554b(copyOf, "result");
        return copyOf;
    }

    /* renamed from: a */
    public static final float[] m3167a(float[] fArr, float f) {
        bfq.m6567f(fArr, "$this$plus");
        int length = fArr.length;
        float[] copyOf = Arrays.copyOf(fArr, length + 1);
        copyOf[length] = f;
        bfq.m6554b(copyOf, "result");
        return copyOf;
    }

    /* renamed from: a */
    public static final double[] m3161a(double[] dArr, double d) {
        bfq.m6567f(dArr, "$this$plus");
        int length = dArr.length;
        double[] copyOf = Arrays.copyOf(dArr, length + 1);
        copyOf[length] = d;
        bfq.m6554b(copyOf, "result");
        return copyOf;
    }

    /* renamed from: a */
    public static final boolean[] m3198a(boolean[] zArr, boolean z) {
        bfq.m6567f(zArr, "$this$plus");
        int length = zArr.length;
        boolean[] copyOf = Arrays.copyOf(zArr, length + 1);
        copyOf[length] = z;
        bfq.m6554b(copyOf, "result");
        return copyOf;
    }

    /* renamed from: a */
    public static final char[] m3155a(char[] cArr, char c) {
        bfq.m6567f(cArr, "$this$plus");
        int length = cArr.length;
        char[] copyOf = Arrays.copyOf(cArr, length + 1);
        copyOf[length] = c;
        bfq.m6554b(copyOf, "result");
        return copyOf;
    }

    /* renamed from: a */
    public static final <T> T[] m3187a(T[] tArr, Collection<? extends T> collection) {
        bfq.m6567f(tArr, "$this$plus");
        bfq.m6567f(collection, "elements");
        int length = tArr.length;
        T[] copyOf = Arrays.copyOf(tArr, collection.size() + length);
        for (T t : collection) {
            copyOf[length] = t;
            length++;
        }
        bfq.m6554b(copyOf, "result");
        return copyOf;
    }

    /* renamed from: a */
    public static final byte[] m3151a(byte[] bArr, Collection<Byte> collection) {
        bfq.m6567f(bArr, "$this$plus");
        bfq.m6567f(collection, "elements");
        int length = bArr.length;
        byte[] copyOf = Arrays.copyOf(bArr, collection.size() + length);
        for (Byte byteValue : collection) {
            copyOf[length] = byteValue.byteValue();
            length++;
        }
        bfq.m6554b(copyOf, "result");
        return copyOf;
    }

    /* renamed from: a */
    public static final short[] m3191a(short[] sArr, Collection<Short> collection) {
        bfq.m6567f(sArr, "$this$plus");
        bfq.m6567f(collection, "elements");
        int length = sArr.length;
        short[] copyOf = Arrays.copyOf(sArr, collection.size() + length);
        for (Short shortValue : collection) {
            copyOf[length] = shortValue.shortValue();
            length++;
        }
        bfq.m6554b(copyOf, "result");
        return copyOf;
    }

    /* renamed from: a */
    public static final int[] m3175a(int[] iArr, Collection<Integer> collection) {
        bfq.m6567f(iArr, "$this$plus");
        bfq.m6567f(collection, "elements");
        int length = iArr.length;
        int[] copyOf = Arrays.copyOf(iArr, collection.size() + length);
        for (Integer intValue : collection) {
            copyOf[length] = intValue.intValue();
            length++;
        }
        bfq.m6554b(copyOf, "result");
        return copyOf;
    }

    /* renamed from: a */
    public static final long[] m3181a(long[] jArr, Collection<Long> collection) {
        bfq.m6567f(jArr, "$this$plus");
        bfq.m6567f(collection, "elements");
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, collection.size() + length);
        for (Long longValue : collection) {
            copyOf[length] = longValue.longValue();
            length++;
        }
        bfq.m6554b(copyOf, "result");
        return copyOf;
    }

    /* renamed from: a */
    public static final float[] m3169a(float[] fArr, Collection<Float> collection) {
        bfq.m6567f(fArr, "$this$plus");
        bfq.m6567f(collection, "elements");
        int length = fArr.length;
        float[] copyOf = Arrays.copyOf(fArr, collection.size() + length);
        for (Float floatValue : collection) {
            copyOf[length] = floatValue.floatValue();
            length++;
        }
        bfq.m6554b(copyOf, "result");
        return copyOf;
    }

    /* renamed from: a */
    public static final double[] m3163a(double[] dArr, Collection<Double> collection) {
        bfq.m6567f(dArr, "$this$plus");
        bfq.m6567f(collection, "elements");
        int length = dArr.length;
        double[] copyOf = Arrays.copyOf(dArr, collection.size() + length);
        for (Double doubleValue : collection) {
            copyOf[length] = doubleValue.doubleValue();
            length++;
        }
        bfq.m6554b(copyOf, "result");
        return copyOf;
    }

    /* renamed from: a */
    public static final boolean[] m3197a(boolean[] zArr, Collection<Boolean> collection) {
        bfq.m6567f(zArr, "$this$plus");
        bfq.m6567f(collection, "elements");
        int length = zArr.length;
        boolean[] copyOf = Arrays.copyOf(zArr, collection.size() + length);
        for (Boolean booleanValue : collection) {
            copyOf[length] = booleanValue.booleanValue();
            length++;
        }
        bfq.m6554b(copyOf, "result");
        return copyOf;
    }

    /* renamed from: a */
    public static final char[] m3157a(char[] cArr, Collection<Character> collection) {
        bfq.m6567f(cArr, "$this$plus");
        bfq.m6567f(collection, "elements");
        int length = cArr.length;
        char[] copyOf = Arrays.copyOf(cArr, collection.size() + length);
        for (Character charValue : collection) {
            copyOf[length] = charValue.charValue();
            length++;
        }
        bfq.m6554b(copyOf, "result");
        return copyOf;
    }

    /* renamed from: b */
    public static final <T> T[] m3252b(T[] tArr, T[] tArr2) {
        bfq.m6567f(tArr, "$this$plus");
        bfq.m6567f(tArr2, "elements");
        int length = tArr.length;
        int length2 = tArr2.length;
        T[] copyOf = Arrays.copyOf(tArr, length + length2);
        System.arraycopy(tArr2, 0, copyOf, length, length2);
        bfq.m6554b(copyOf, "result");
        return copyOf;
    }

    /* renamed from: a */
    public static final byte[] m3152a(byte[] bArr, byte[] bArr2) {
        bfq.m6567f(bArr, "$this$plus");
        bfq.m6567f(bArr2, "elements");
        int length = bArr.length;
        int length2 = bArr2.length;
        byte[] copyOf = Arrays.copyOf(bArr, length + length2);
        System.arraycopy(bArr2, 0, copyOf, length, length2);
        bfq.m6554b(copyOf, "result");
        return copyOf;
    }

    /* renamed from: a */
    public static final short[] m3193a(short[] sArr, short[] sArr2) {
        bfq.m6567f(sArr, "$this$plus");
        bfq.m6567f(sArr2, "elements");
        int length = sArr.length;
        int length2 = sArr2.length;
        short[] copyOf = Arrays.copyOf(sArr, length + length2);
        System.arraycopy(sArr2, 0, copyOf, length, length2);
        bfq.m6554b(copyOf, "result");
        return copyOf;
    }

    /* renamed from: a */
    public static final int[] m3176a(int[] iArr, int[] iArr2) {
        bfq.m6567f(iArr, "$this$plus");
        bfq.m6567f(iArr2, "elements");
        int length = iArr.length;
        int length2 = iArr2.length;
        int[] copyOf = Arrays.copyOf(iArr, length + length2);
        System.arraycopy(iArr2, 0, copyOf, length, length2);
        bfq.m6554b(copyOf, "result");
        return copyOf;
    }

    /* renamed from: a */
    public static final long[] m3182a(long[] jArr, long[] jArr2) {
        bfq.m6567f(jArr, "$this$plus");
        bfq.m6567f(jArr2, "elements");
        int length = jArr.length;
        int length2 = jArr2.length;
        long[] copyOf = Arrays.copyOf(jArr, length + length2);
        System.arraycopy(jArr2, 0, copyOf, length, length2);
        bfq.m6554b(copyOf, "result");
        return copyOf;
    }

    /* renamed from: a */
    public static final float[] m3170a(float[] fArr, float[] fArr2) {
        bfq.m6567f(fArr, "$this$plus");
        bfq.m6567f(fArr2, "elements");
        int length = fArr.length;
        int length2 = fArr2.length;
        float[] copyOf = Arrays.copyOf(fArr, length + length2);
        System.arraycopy(fArr2, 0, copyOf, length, length2);
        bfq.m6554b(copyOf, "result");
        return copyOf;
    }

    /* renamed from: a */
    public static final double[] m3164a(double[] dArr, double[] dArr2) {
        bfq.m6567f(dArr, "$this$plus");
        bfq.m6567f(dArr2, "elements");
        int length = dArr.length;
        int length2 = dArr2.length;
        double[] copyOf = Arrays.copyOf(dArr, length + length2);
        System.arraycopy(dArr2, 0, copyOf, length, length2);
        bfq.m6554b(copyOf, "result");
        return copyOf;
    }

    /* renamed from: a */
    public static final boolean[] m3199a(boolean[] zArr, boolean[] zArr2) {
        bfq.m6567f(zArr, "$this$plus");
        bfq.m6567f(zArr2, "elements");
        int length = zArr.length;
        int length2 = zArr2.length;
        boolean[] copyOf = Arrays.copyOf(zArr, length + length2);
        System.arraycopy(zArr2, 0, copyOf, length, length2);
        bfq.m6554b(copyOf, "result");
        return copyOf;
    }

    /* renamed from: a */
    public static final char[] m3158a(char[] cArr, char[] cArr2) {
        bfq.m6567f(cArr, "$this$plus");
        bfq.m6567f(cArr2, "elements");
        int length = cArr.length;
        int length2 = cArr2.length;
        char[] copyOf = Arrays.copyOf(cArr, length + length2);
        System.arraycopy(cArr2, 0, copyOf, length, length2);
        bfq.m6554b(copyOf, "result");
        return copyOf;
    }

    /* renamed from: b */
    private static final <T> T[] m3251b(T[] tArr, T t) {
        return arv.m3186a(tArr, t);
    }

    /* renamed from: b */
    public static final void m3221b(int[] iArr) {
        bfq.m6567f(iArr, "$this$sort");
        if (iArr.length > 1) {
            Arrays.sort(iArr);
        }
    }

    /* renamed from: b */
    public static final void m3225b(long[] jArr) {
        bfq.m6567f(jArr, "$this$sort");
        if (jArr.length > 1) {
            Arrays.sort(jArr);
        }
    }

    /* renamed from: b */
    public static final void m3205b(byte[] bArr) {
        bfq.m6567f(bArr, "$this$sort");
        if (bArr.length > 1) {
            Arrays.sort(bArr);
        }
    }

    /* renamed from: b */
    public static final void m3233b(short[] sArr) {
        bfq.m6567f(sArr, "$this$sort");
        if (sArr.length > 1) {
            Arrays.sort(sArr);
        }
    }

    /* renamed from: b */
    public static final void m3213b(double[] dArr) {
        bfq.m6567f(dArr, "$this$sort");
        if (dArr.length > 1) {
            Arrays.sort(dArr);
        }
    }

    /* renamed from: b */
    public static final void m3217b(float[] fArr) {
        bfq.m6567f(fArr, "$this$sort");
        if (fArr.length > 1) {
            Arrays.sort(fArr);
        }
    }

    /* renamed from: b */
    public static final void m3209b(char[] cArr) {
        bfq.m6567f(cArr, "$this$sort");
        if (cArr.length > 1) {
            Arrays.sort(cArr);
        }
    }

    /* renamed from: b */
    private static final <T extends Comparable<? super T>> void m3229b(T[] tArr) {
        if (tArr != null) {
            arv.m3293e((T[]) (Object[]) tArr);
            return;
        }
        throw new apx("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
    }

    /* renamed from: e */
    public static final <T> void m3293e(T[] tArr) {
        bfq.m6567f(tArr, "$this$sort");
        if (tArr.length > 1) {
            Arrays.sort(tArr);
        }
    }

    /* renamed from: a */
    public static /* synthetic */ void m3141a(Object[] objArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = objArr.length;
        }
        arv.m3230b((T[]) objArr, i, i2);
    }

    /* renamed from: b */
    public static final <T> void m3230b(T[] tArr, int i, int i2) {
        bfq.m6567f(tArr, "$this$sort");
        Arrays.sort(tArr, i, i2);
    }

    /* renamed from: a */
    public static /* synthetic */ void m3135a(byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = bArr.length;
        }
        arv.m3208b(bArr, i, i2);
    }

    /* renamed from: b */
    public static final void m3208b(byte[] bArr, int i, int i2) {
        bfq.m6567f(bArr, "$this$sort");
        Arrays.sort(bArr, i, i2);
    }

    /* renamed from: a */
    public static /* synthetic */ void m3145a(short[] sArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = sArr.length;
        }
        arv.m3234b(sArr, i, i2);
    }

    /* renamed from: b */
    public static final void m3234b(short[] sArr, int i, int i2) {
        bfq.m6567f(sArr, "$this$sort");
        Arrays.sort(sArr, i, i2);
    }

    /* renamed from: a */
    public static /* synthetic */ void m3139a(int[] iArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = iArr.length;
        }
        arv.m3222b(iArr, i, i2);
    }

    /* renamed from: b */
    public static final void m3222b(int[] iArr, int i, int i2) {
        bfq.m6567f(iArr, "$this$sort");
        Arrays.sort(iArr, i, i2);
    }

    /* renamed from: a */
    public static /* synthetic */ void m3140a(long[] jArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = jArr.length;
        }
        arv.m3226b(jArr, i, i2);
    }

    /* renamed from: b */
    public static final void m3226b(long[] jArr, int i, int i2) {
        bfq.m6567f(jArr, "$this$sort");
        Arrays.sort(jArr, i, i2);
    }

    /* renamed from: a */
    public static /* synthetic */ void m3138a(float[] fArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = fArr.length;
        }
        arv.m3220b(fArr, i, i2);
    }

    /* renamed from: b */
    public static final void m3220b(float[] fArr, int i, int i2) {
        bfq.m6567f(fArr, "$this$sort");
        Arrays.sort(fArr, i, i2);
    }

    /* renamed from: a */
    public static /* synthetic */ void m3137a(double[] dArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = dArr.length;
        }
        arv.m3216b(dArr, i, i2);
    }

    /* renamed from: b */
    public static final void m3216b(double[] dArr, int i, int i2) {
        bfq.m6567f(dArr, "$this$sort");
        Arrays.sort(dArr, i, i2);
    }

    /* renamed from: a */
    public static /* synthetic */ void m3136a(char[] cArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = cArr.length;
        }
        arv.m3212b(cArr, i, i2);
    }

    /* renamed from: b */
    public static final void m3212b(char[] cArr, int i, int i2) {
        bfq.m6567f(cArr, "$this$sort");
        Arrays.sort(cArr, i, i2);
    }

    /* renamed from: a */
    public static final <T> void m3142a(T[] tArr, Comparator<? super T> comparator) {
        bfq.m6567f(tArr, "$this$sortWith");
        bfq.m6567f(comparator, "comparator");
        if (tArr.length > 1) {
            Arrays.sort(tArr, comparator);
        }
    }

    /* renamed from: a */
    public static /* synthetic */ void m3144a(Object[] objArr, Comparator comparator, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = objArr.length;
        }
        arv.m3143a((T[]) objArr, comparator, i, i2);
    }

    /* renamed from: a */
    public static final <T> void m3143a(T[] tArr, Comparator<? super T> comparator, int i, int i2) {
        bfq.m6567f(tArr, "$this$sortWith");
        bfq.m6567f(comparator, "comparator");
        Arrays.sort(tArr, i, i2, comparator);
    }

    /* renamed from: c */
    public static final Byte[] m3265c(byte[] bArr) {
        bfq.m6567f(bArr, "$this$toTypedArray");
        Byte[] bArr2 = new Byte[bArr.length];
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            bArr2[i] = Byte.valueOf(bArr[i]);
        }
        return bArr2;
    }

    /* renamed from: c */
    public static final Short[] m3273c(short[] sArr) {
        bfq.m6567f(sArr, "$this$toTypedArray");
        Short[] shArr = new Short[sArr.length];
        int length = sArr.length;
        for (int i = 0; i < length; i++) {
            shArr[i] = Short.valueOf(sArr[i]);
        }
        return shArr;
    }

    /* renamed from: c */
    public static final Integer[] m3269c(int[] iArr) {
        bfq.m6567f(iArr, "$this$toTypedArray");
        Integer[] numArr = new Integer[iArr.length];
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            numArr[i] = Integer.valueOf(iArr[i]);
        }
        return numArr;
    }

    /* renamed from: c */
    public static final Long[] m3270c(long[] jArr) {
        bfq.m6567f(jArr, "$this$toTypedArray");
        Long[] lArr = new Long[jArr.length];
        int length = jArr.length;
        for (int i = 0; i < length; i++) {
            lArr[i] = Long.valueOf(jArr[i]);
        }
        return lArr;
    }

    /* renamed from: c */
    public static final Float[] m3268c(float[] fArr) {
        bfq.m6567f(fArr, "$this$toTypedArray");
        Float[] fArr2 = new Float[fArr.length];
        int length = fArr.length;
        for (int i = 0; i < length; i++) {
            fArr2[i] = Float.valueOf(fArr[i]);
        }
        return fArr2;
    }

    /* renamed from: c */
    public static final Double[] m3267c(double[] dArr) {
        bfq.m6567f(dArr, "$this$toTypedArray");
        Double[] dArr2 = new Double[dArr.length];
        int length = dArr.length;
        for (int i = 0; i < length; i++) {
            dArr2[i] = Double.valueOf(dArr[i]);
        }
        return dArr2;
    }

    /* renamed from: b */
    public static final Boolean[] m3250b(boolean[] zArr) {
        bfq.m6567f(zArr, "$this$toTypedArray");
        Boolean[] boolArr = new Boolean[zArr.length];
        int length = zArr.length;
        for (int i = 0; i < length; i++) {
            boolArr[i] = Boolean.valueOf(zArr[i]);
        }
        return boolArr;
    }

    /* renamed from: c */
    public static final Character[] m3266c(char[] cArr) {
        bfq.m6567f(cArr, "$this$toTypedArray");
        Character[] chArr = new Character[cArr.length];
        int length = cArr.length;
        for (int i = 0; i < length; i++) {
            chArr[i] = Character.valueOf(cArr[i]);
        }
        return chArr;
    }

    /* renamed from: a */
    public static final <T extends Comparable<? super T>> SortedSet<T> m3133a(T[] tArr) {
        bfq.m6567f(tArr, "$this$toSortedSet");
        return (SortedSet) arv.m4134e(tArr, new TreeSet());
    }

    /* renamed from: d */
    public static final SortedSet<Byte> m3277d(byte[] bArr) {
        bfq.m6567f(bArr, "$this$toSortedSet");
        return (SortedSet) arv.m3993c(bArr, new TreeSet());
    }

    /* renamed from: d */
    public static final SortedSet<Short> m3283d(short[] sArr) {
        bfq.m6567f(sArr, "$this$toSortedSet");
        return (SortedSet) arv.m4008c(sArr, new TreeSet());
    }

    /* renamed from: d */
    public static final SortedSet<Integer> m3281d(int[] iArr) {
        bfq.m6567f(iArr, "$this$toSortedSet");
        return (SortedSet) arv.m4001c(iArr, new TreeSet());
    }

    /* renamed from: d */
    public static final SortedSet<Long> m3282d(long[] jArr) {
        bfq.m6567f(jArr, "$this$toSortedSet");
        return (SortedSet) arv.m4003c(jArr, new TreeSet());
    }

    /* renamed from: d */
    public static final SortedSet<Float> m3280d(float[] fArr) {
        bfq.m6567f(fArr, "$this$toSortedSet");
        return (SortedSet) arv.m3999c(fArr, new TreeSet());
    }

    /* renamed from: d */
    public static final SortedSet<Double> m3279d(double[] dArr) {
        bfq.m6567f(dArr, "$this$toSortedSet");
        return (SortedSet) arv.m3997c(dArr, new TreeSet());
    }

    /* renamed from: c */
    public static final SortedSet<Boolean> m3256c(boolean[] zArr) {
        bfq.m6567f(zArr, "$this$toSortedSet");
        return (SortedSet) arv.m4010c(zArr, new TreeSet());
    }

    /* renamed from: d */
    public static final SortedSet<Character> m3278d(char[] cArr) {
        bfq.m6567f(cArr, "$this$toSortedSet");
        return (SortedSet) arv.m3995c(cArr, new TreeSet());
    }

    /* renamed from: b */
    public static final <T> SortedSet<T> m3204b(T[] tArr, Comparator<? super T> comparator) {
        bfq.m6567f(tArr, "$this$toSortedSet");
        bfq.m6567f(comparator, "comparator");
        return (SortedSet) arv.m4134e(tArr, new TreeSet(comparator));
    }
}

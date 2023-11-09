package atakplugin.UASTool;

import indago.serialization.JsonKeyConstants;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@aot(mo1534a = 5, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000~\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0000\n\u0002\u0010&\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010(\n\u0002\u0010)\n\u0002\u0010'\n\u0002\b\n\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0016\u001a\u001e\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005\u001a1\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0007j\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0005`\b\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005H\b\u001a_\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0007j\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0005`\b\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u00052*\u0010\t\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u000b0\n\"\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u000b¢\u0006\u0002\u0010\f\u001a1\u0010\r\u001a\u001e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u000ej\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0005`\u000f\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005H\b\u001a_\u0010\r\u001a\u001e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u000ej\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0005`\u000f\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u00052*\u0010\t\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u000b0\n\"\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u000b¢\u0006\u0002\u0010\u0010\u001a\u0010\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0001H\u0001\u001a!\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005H\b\u001aO\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u00052*\u0010\t\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u000b0\n\"\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u000b¢\u0006\u0002\u0010\u0014\u001a!\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0016\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005H\b\u001aO\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0016\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u00052*\u0010\t\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u000b0\n\"\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u000b¢\u0006\u0002\u0010\u0014\u001a*\u0010\u0017\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0018H\n¢\u0006\u0002\u0010\u0019\u001a*\u0010\u001a\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0018H\n¢\u0006\u0002\u0010\u0019\u001a9\u0010\u001b\u001a\u00020\u001c\"\t\b\u0000\u0010\u0004¢\u0006\u0002\b\u001d\"\u0004\b\u0001\u0010\u0005*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00032\u0006\u0010\u001e\u001a\u0002H\u0004H\n¢\u0006\u0002\u0010\u001f\u001a1\u0010 \u001a\u00020\u001c\"\t\b\u0000\u0010\u0004¢\u0006\u0002\b\u001d*\u000e\u0012\u0006\b\u0001\u0012\u0002H\u0004\u0012\u0002\b\u00030\u00032\u0006\u0010\u001e\u001a\u0002H\u0004H\b¢\u0006\u0002\u0010\u001f\u001a7\u0010!\u001a\u00020\u001c\"\u0004\b\u0000\u0010\u0004\"\t\b\u0001\u0010\u0005¢\u0006\u0002\b\u001d*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00032\u0006\u0010\"\u001a\u0002H\u0005H\b¢\u0006\u0002\u0010\u001f\u001aS\u0010#\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00032\u001e\u0010$\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0018\u0012\u0004\u0012\u00020\u001c0%H\b\u001aG\u0010&\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00032\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u00020\u001c0%H\b\u001aS\u0010'\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00032\u001e\u0010$\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0018\u0012\u0004\u0012\u00020\u001c0%H\b\u001an\u0010(\u001a\u0002H)\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005\"\u0018\b\u0002\u0010)*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0004\u0012\u0006\b\u0000\u0012\u0002H\u00050\u0016*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00032\u0006\u0010*\u001a\u0002H)2\u001e\u0010$\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0018\u0012\u0004\u0012\u00020\u001c0%H\b¢\u0006\u0002\u0010+\u001an\u0010,\u001a\u0002H)\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005\"\u0018\b\u0002\u0010)*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0004\u0012\u0006\b\u0000\u0012\u0002H\u00050\u0016*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00032\u0006\u0010*\u001a\u0002H)2\u001e\u0010$\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0018\u0012\u0004\u0012\u00020\u001c0%H\b¢\u0006\u0002\u0010+\u001aG\u0010-\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00032\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u00020\u001c0%H\b\u001a;\u0010.\u001a\u0004\u0018\u0001H\u0005\"\t\b\u0000\u0010\u0004¢\u0006\u0002\b\u001d\"\u0004\b\u0001\u0010\u0005*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00032\u0006\u0010\u001e\u001a\u0002H\u0004H\n¢\u0006\u0002\u0010/\u001a@\u00100\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00032\u0006\u0010\u001e\u001a\u0002H\u00042\f\u00101\u001a\b\u0012\u0004\u0012\u0002H\u000502H\b¢\u0006\u0002\u00103\u001a@\u00104\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00032\u0006\u0010\u001e\u001a\u0002H\u00042\f\u00101\u001a\b\u0012\u0004\u0012\u0002H\u000502H\b¢\u0006\u0002\u00103\u001a@\u00105\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00162\u0006\u0010\u001e\u001a\u0002H\u00042\f\u00101\u001a\b\u0012\u0004\u0012\u0002H\u000502H\b¢\u0006\u0002\u00103\u001a1\u00106\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00032\u0006\u0010\u001e\u001a\u0002H\u0004H\u0007¢\u0006\u0002\u0010/\u001a<\u00107\u001a\u0002H8\"\u0014\b\u0000\u0010)*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003*\u0002H8\"\u0004\b\u0001\u00108*\u0002H)2\f\u00101\u001a\b\u0012\u0004\u0012\u0002H802H\b¢\u0006\u0002\u00109\u001a'\u0010:\u001a\u00020\u001c\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003H\b\u001a:\u0010;\u001a\u00020\u001c\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u0012\u0012\u0006\b\u0001\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0005\u0018\u00010\u0003H\b\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a9\u0010<\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00180=\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003H\n\u001a<\u0010<\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050?0>\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0016H\n¢\u0006\u0002\b@\u001aY\u0010A\u001a\u000e\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005\"\u0004\b\u0002\u00108*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00032\u001e\u0010B\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0018\u0012\u0004\u0012\u0002H80%H\b\u001at\u0010C\u001a\u0002H)\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005\"\u0004\b\u0002\u00108\"\u0018\b\u0003\u0010)*\u0012\u0012\u0006\b\u0000\u0012\u0002H8\u0012\u0006\b\u0000\u0012\u0002H\u00050\u0016*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00032\u0006\u0010*\u001a\u0002H)2\u001e\u0010B\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0018\u0012\u0004\u0012\u0002H80%H\b¢\u0006\u0002\u0010+\u001aY\u0010D\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H80\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005\"\u0004\b\u0002\u00108*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00032\u001e\u0010B\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0018\u0012\u0004\u0012\u0002H80%H\b\u001at\u0010E\u001a\u0002H)\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005\"\u0004\b\u0002\u00108\"\u0018\b\u0003\u0010)*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0004\u0012\u0006\b\u0000\u0012\u0002H80\u0016*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00032\u0006\u0010*\u001a\u0002H)2\u001e\u0010B\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0018\u0012\u0004\u0012\u0002H80%H\b¢\u0006\u0002\u0010+\u001a@\u0010F\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00032\u0006\u0010\u001e\u001a\u0002H\u0004H\u0002¢\u0006\u0002\u0010G\u001aH\u0010F\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00032\u000e\u0010H\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00040\nH\u0002¢\u0006\u0002\u0010I\u001aA\u0010F\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00032\f\u0010H\u001a\b\u0012\u0004\u0012\u0002H\u00040JH\u0002\u001aA\u0010F\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00032\f\u0010H\u001a\b\u0012\u0004\u0012\u0002H\u00040KH\u0002\u001a2\u0010L\u001a\u00020M\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00162\u0006\u0010\u001e\u001a\u0002H\u0004H\n¢\u0006\u0002\u0010N\u001a:\u0010L\u001a\u00020M\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00162\u000e\u0010H\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00040\nH\n¢\u0006\u0002\u0010O\u001a3\u0010L\u001a\u00020M\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00162\f\u0010H\u001a\b\u0012\u0004\u0012\u0002H\u00040JH\n\u001a3\u0010L\u001a\u00020M\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00162\f\u0010H\u001a\b\u0012\u0004\u0012\u0002H\u00040KH\n\u001a0\u0010P\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003H\u0000\u001a3\u0010Q\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u0010\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0005\u0018\u00010\u0003H\b\u001aT\u0010R\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00032\u001a\u0010\t\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u000b0\nH\u0002¢\u0006\u0002\u0010S\u001aG\u0010R\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00032\u0012\u0010T\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u000bH\u0002\u001aM\u0010R\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00032\u0018\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u000b0JH\u0002\u001aI\u0010R\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00032\u0014\u0010U\u001a\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003H\u0002\u001aM\u0010R\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00032\u0018\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u000b0KH\u0002\u001aJ\u0010V\u001a\u00020M\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0004\u0012\u0006\b\u0000\u0012\u0002H\u00050\u00162\u001a\u0010\t\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u000b0\nH\n¢\u0006\u0002\u0010W\u001a=\u0010V\u001a\u00020M\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0004\u0012\u0006\b\u0000\u0012\u0002H\u00050\u00162\u0012\u0010T\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u000bH\n\u001aC\u0010V\u001a\u00020M\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0004\u0012\u0006\b\u0000\u0012\u0002H\u00050\u00162\u0018\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u000b0JH\n\u001a=\u0010V\u001a\u00020M\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0004\u0012\u0006\b\u0000\u0012\u0002H\u00050\u00162\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003H\n\u001aC\u0010V\u001a\u00020M\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0004\u0012\u0006\b\u0000\u0012\u0002H\u00050\u00162\u0018\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u000b0KH\n\u001aG\u0010X\u001a\u00020M\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0004\u0012\u0006\b\u0000\u0012\u0002H\u00050\u00162\u001a\u0010\t\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u000b0\n¢\u0006\u0002\u0010W\u001a@\u0010X\u001a\u00020M\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0004\u0012\u0006\b\u0000\u0012\u0002H\u00050\u00162\u0018\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u000b0J\u001a@\u0010X\u001a\u00020M\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0004\u0012\u0006\b\u0000\u0012\u0002H\u00050\u00162\u0018\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u000b0K\u001a;\u0010Y\u001a\u0004\u0018\u0001H\u0005\"\t\b\u0000\u0010\u0004¢\u0006\u0002\b\u001d\"\u0004\b\u0001\u0010\u0005*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00162\u0006\u0010\u001e\u001a\u0002H\u0004H\b¢\u0006\u0002\u0010/\u001a:\u0010Z\u001a\u00020M\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00162\u0006\u0010\u001e\u001a\u0002H\u00042\u0006\u0010\"\u001a\u0002H\u0005H\n¢\u0006\u0002\u0010[\u001a;\u0010\\\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u000b0\n¢\u0006\u0002\u0010\u0014\u001aQ\u0010\\\u001a\u0002H)\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005\"\u0018\b\u0002\u0010)*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0004\u0012\u0006\b\u0000\u0012\u0002H\u00050\u0016*\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u000b0\n2\u0006\u0010*\u001a\u0002H)¢\u0006\u0002\u0010]\u001a4\u0010\\\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u000b0J\u001aO\u0010\\\u001a\u0002H)\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005\"\u0018\b\u0002\u0010)*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0004\u0012\u0006\b\u0000\u0012\u0002H\u00050\u0016*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u000b0J2\u0006\u0010*\u001a\u0002H)¢\u0006\u0002\u0010^\u001a2\u0010\\\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003H\u0007\u001aM\u0010\\\u001a\u0002H)\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005\"\u0018\b\u0002\u0010)*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0004\u0012\u0006\b\u0000\u0012\u0002H\u00050\u0016*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00032\u0006\u0010*\u001a\u0002H)H\u0007¢\u0006\u0002\u0010_\u001a4\u0010\\\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u000b0K\u001aO\u0010\\\u001a\u0002H)\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005\"\u0018\b\u0002\u0010)*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0004\u0012\u0006\b\u0000\u0012\u0002H\u00050\u0016*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u000b0K2\u0006\u0010*\u001a\u0002H)¢\u0006\u0002\u0010`\u001a2\u0010a\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0016\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003H\u0007\u001a1\u0010b\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u000b\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0018H\b\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006c"}, mo1538e = {"INT_MAX_POWER_OF_TWO", "", "emptyMap", "", "K", "V", "hashMapOf", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "pairs", "", "Lkotlin/Pair;", "([Lkotlin/Pair;)Ljava/util/HashMap;", "linkedMapOf", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "([Lkotlin/Pair;)Ljava/util/LinkedHashMap;", "mapCapacity", "expectedSize", "mapOf", "([Lkotlin/Pair;)Ljava/util/Map;", "mutableMapOf", "", "component1", "", "(Ljava/util/Map$Entry;)Ljava/lang/Object;", "component2", "contains", "", "Lkotlin/internal/OnlyInputTypes;", "key", "(Ljava/util/Map;Ljava/lang/Object;)Z", "containsKey", "containsValue", "value", "filter", "predicate", "Lkotlin/Function1;", "filterKeys", "filterNot", "filterNotTo", "M", "destination", "(Ljava/util/Map;Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "filterTo", "filterValues", "get", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/lang/Object;", "getOrElse", "defaultValue", "Lkotlin/Function0;", "(Ljava/util/Map;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "getOrElseNullable", "getOrPut", "getValue", "ifEmpty", "R", "(Ljava/util/Map;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isNotEmpty", "isNullOrEmpty", "iterator", "", "", "", "mutableIterator", "mapKeys", "transform", "mapKeysTo", "mapValues", "mapValuesTo", "minus", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/util/Map;", "keys", "(Ljava/util/Map;[Ljava/lang/Object;)Ljava/util/Map;", "", "Lkotlin/sequences/Sequence;", "minusAssign", "", "(Ljava/util/Map;Ljava/lang/Object;)V", "(Ljava/util/Map;[Ljava/lang/Object;)V", "optimizeReadOnlyMap", "orEmpty", "plus", "(Ljava/util/Map;[Lkotlin/Pair;)Ljava/util/Map;", "pair", "map", "plusAssign", "(Ljava/util/Map;[Lkotlin/Pair;)V", "putAll", "remove", "set", "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;)V", "toMap", "([Lkotlin/Pair;Ljava/util/Map;)Ljava/util/Map;", "(Ljava/lang/Iterable;Ljava/util/Map;)Ljava/util/Map;", "(Ljava/util/Map;Ljava/util/Map;)Ljava/util/Map;", "(Lkotlin/sequences/Sequence;Ljava/util/Map;)Ljava/util/Map;", "toMutableMap", "toPair", "kotlin-stdlib"}, mo1539f = "kotlin/collections/MapsKt", mo1541h = 1)
class avb extends ava {

    /* renamed from: a */
    private static final int f2284a = 1073741824;

    /* renamed from: a */
    public static final <K, V> Map<K, V> m4975a() {
        auj auj = auj.f2273a;
        if (auj != null) {
            return auj;
        }
        throw new apx("null cannot be cast to non-null type kotlin.collections.Map<K, V>");
    }

    /* renamed from: b */
    public static final <K, V> Map<K, V> m4998b(apc<? extends K, ? extends V>... apcArr) {
        bfq.m6567f(apcArr, "pairs");
        return apcArr.length > 0 ? auy.m4984a(apcArr, new LinkedHashMap(auy.m4971a(apcArr.length))) : auy.m4975a();
    }

    /* renamed from: b */
    private static final <K, V> Map<K, V> m4992b() {
        return auy.m4975a();
    }

    /* renamed from: c */
    private static final <K, V> Map<K, V> m5003c() {
        return new LinkedHashMap<>();
    }

    /* renamed from: c */
    public static final <K, V> Map<K, V> m5010c(apc<? extends K, ? extends V>... apcArr) {
        bfq.m6567f(apcArr, "pairs");
        Map<K, V> linkedHashMap = new LinkedHashMap<>(auy.m4971a(apcArr.length));
        auy.m4988a(linkedHashMap, apcArr);
        return linkedHashMap;
    }

    /* renamed from: d */
    private static final <K, V> HashMap<K, V> m5013d() {
        return new HashMap<>();
    }

    /* renamed from: d */
    public static final <K, V> HashMap<K, V> m5014d(apc<? extends K, ? extends V>... apcArr) {
        bfq.m6567f(apcArr, "pairs");
        HashMap<K, V> hashMap = new HashMap<>(auy.m4971a(apcArr.length));
        auy.m4988a(hashMap, apcArr);
        return hashMap;
    }

    /* renamed from: e */
    private static final <K, V> LinkedHashMap<K, V> m5022e() {
        return new LinkedHashMap<>();
    }

    /* renamed from: e */
    public static final <K, V> LinkedHashMap<K, V> m5023e(apc<? extends K, ? extends V>... apcArr) {
        bfq.m6567f(apcArr, "pairs");
        return (LinkedHashMap) auy.m4984a(apcArr, new LinkedHashMap(auy.m4971a(apcArr.length)));
    }

    /* renamed from: a */
    public static final int m4971a(int i) {
        if (i < 3) {
            return i + 1;
        }
        if (i < 1073741824) {
            return i + (i / 3);
        }
        return Integer.MAX_VALUE;
    }

    /* renamed from: f */
    private static final <K, V> boolean m5030f(Map<? extends K, ? extends V> map) {
        return !map.isEmpty();
    }

    /* renamed from: g */
    private static final <K, V> boolean m5033g(Map<? extends K, ? extends V> map) {
        return map == null || map.isEmpty();
    }

    /* renamed from: h */
    private static final <K, V> Map<K, V> m5036h(Map<K, ? extends V> map) {
        return map != null ? map : auy.m4975a();
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [R, java.util.Map, M] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final <M extends java.util.Map<?, ?> & R, R> R m4973a(M r1, atakplugin.UASTool.bdk<? extends R> r2) {
        /*
            boolean r0 = r1.isEmpty()
            if (r0 == 0) goto L_0x000a
            java.lang.Object r1 = r2.invoke()
        L_0x000a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.avb.m4973a(java.util.Map, atakplugin.UASTool.bdk):java.lang.Object");
    }

    /* renamed from: d */
    private static final <K, V> boolean m5020d(Map<? extends K, ? extends V> map, K k) {
        bfq.m6567f(map, "$this$contains");
        return map.containsKey(k);
    }

    /* renamed from: e */
    private static final <K, V> V m5021e(Map<? extends K, ? extends V> map, K k) {
        bfq.m6567f(map, "$this$get");
        return map.get(k);
    }

    /* renamed from: a */
    private static final <K, V> void m4987a(Map<K, V> map, K k, V v) {
        bfq.m6567f(map, "$this$set");
        map.put(k, v);
    }

    /* renamed from: f */
    private static final <K> boolean m5031f(Map<? extends K, ?> map, K k) {
        if (map != null) {
            return map.containsKey(k);
        }
        throw new apx("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
    }

    /* renamed from: g */
    private static final <K, V> boolean m5034g(Map<K, ? extends V> map, V v) {
        return map.containsValue(v);
    }

    /* renamed from: h */
    private static final <K, V> V m5035h(Map<? extends K, V> map, K k) {
        if (map != null) {
            return bgv.m6780t(map).remove(k);
        }
        throw new apx("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
    }

    /* renamed from: a */
    private static final <K, V> K m4972a(Map.Entry<? extends K, ? extends V> entry) {
        bfq.m6567f(entry, "$this$component1");
        return entry.getKey();
    }

    /* renamed from: b */
    private static final <K, V> V m4989b(Map.Entry<? extends K, ? extends V> entry) {
        bfq.m6567f(entry, "$this$component2");
        return entry.getValue();
    }

    /* renamed from: c */
    private static final <K, V> apc<K, V> m5001c(Map.Entry<? extends K, ? extends V> entry) {
        return new apc<>(entry.getKey(), entry.getValue());
    }

    /* renamed from: c */
    private static final <K, V> V m5002c(Map<K, ? extends V> map, K k, bdk<? extends V> bdk) {
        V v = map.get(k);
        return v != null ? v : bdk.invoke();
    }

    /* renamed from: a */
    public static final <K, V> V m4974a(Map<K, ? extends V> map, K k, bdk<? extends V> bdk) {
        bfq.m6567f(map, "$this$getOrElseNullable");
        bfq.m6567f(bdk, "defaultValue");
        V v = map.get(k);
        return (v != null || map.containsKey(k)) ? v : bdk.invoke();
    }

    /* renamed from: b */
    public static final <K, V> V m4990b(Map<K, ? extends V> map, K k) {
        bfq.m6567f(map, "$this$getValue");
        return auy.m4959a(map, k);
    }

    /* renamed from: b */
    public static final <K, V> V m4991b(Map<K, V> map, K k, bdk<? extends V> bdk) {
        bfq.m6567f(map, "$this$getOrPut");
        bfq.m6567f(bdk, "defaultValue");
        V v = map.get(k);
        if (v != null) {
            return v;
        }
        V invoke = bdk.invoke();
        map.put(k, invoke);
        return invoke;
    }

    /* renamed from: i */
    private static final <K, V> Iterator<Map.Entry<K, V>> m5038i(Map<? extends K, ? extends V> map) {
        bfq.m6567f(map, "$this$iterator");
        return map.entrySet().iterator();
    }

    /* renamed from: j */
    private static final <K, V> Iterator<Map.Entry<K, V>> m5040j(Map<K, V> map) {
        bfq.m6567f(map, "$this$iterator");
        return map.entrySet().iterator();
    }

    /* renamed from: a */
    public static final <K, V, R, M extends Map<? super K, ? super R>> M m4982a(Map<? extends K, ? extends V> map, M m, bdl<? super Map.Entry<? extends K, ? extends V>, ? extends R> bdl) {
        bfq.m6567f(map, "$this$mapValuesTo");
        bfq.m6567f(m, JsonKeyConstants.DESTINATION);
        bfq.m6567f(bdl, "transform");
        for (Object next : map.entrySet()) {
            m.put(((Map.Entry) next).getKey(), bdl.invoke(next));
        }
        return m;
    }

    /* renamed from: b */
    public static final <K, V, R, M extends Map<? super R, ? super V>> M m4996b(Map<? extends K, ? extends V> map, M m, bdl<? super Map.Entry<? extends K, ? extends V>, ? extends R> bdl) {
        bfq.m6567f(map, "$this$mapKeysTo");
        bfq.m6567f(m, JsonKeyConstants.DESTINATION);
        bfq.m6567f(bdl, "transform");
        for (Object next : map.entrySet()) {
            m.put(bdl.invoke(next), ((Map.Entry) next).getValue());
        }
        return m;
    }

    /* renamed from: a */
    public static final <K, V> void m4988a(Map<? super K, ? super V> map, apc<? extends K, ? extends V>[] apcArr) {
        bfq.m6567f(map, "$this$putAll");
        bfq.m6567f(apcArr, "pairs");
        for (apc<? extends K, ? extends V> apc : apcArr) {
            map.put(apc.mo1546c(), apc.mo1547d());
        }
    }

    /* renamed from: a */
    public static final <K, V> void m4986a(Map<? super K, ? super V> map, Iterable<? extends apc<? extends K, ? extends V>> iterable) {
        bfq.m6567f(map, "$this$putAll");
        bfq.m6567f(iterable, "pairs");
        for (apc apc : iterable) {
            map.put(apc.mo1546c(), apc.mo1547d());
        }
    }

    /* renamed from: a */
    public static final <K, V> void m4985a(Map<? super K, ? super V> map, bku<? extends apc<? extends K, ? extends V>> bku) {
        bfq.m6567f(map, "$this$putAll");
        bfq.m6567f(bku, "pairs");
        Iterator<? extends apc<? extends K, ? extends V>> a = bku.mo1859a();
        while (a.hasNext()) {
            apc apc = (apc) a.next();
            map.put(apc.mo1546c(), apc.mo1547d());
        }
    }

    /* renamed from: c */
    public static final <K, V, R> Map<K, R> m5005c(Map<? extends K, ? extends V> map, bdl<? super Map.Entry<? extends K, ? extends V>, ? extends R> bdl) {
        bfq.m6567f(map, "$this$mapValues");
        bfq.m6567f(bdl, "transform");
        Map<K, R> linkedHashMap = new LinkedHashMap<>(auy.m4971a(map.size()));
        for (Object next : map.entrySet()) {
            linkedHashMap.put(((Map.Entry) next).getKey(), bdl.invoke(next));
        }
        return linkedHashMap;
    }

    /* renamed from: d */
    public static final <K, V, R> Map<R, V> m5016d(Map<? extends K, ? extends V> map, bdl<? super Map.Entry<? extends K, ? extends V>, ? extends R> bdl) {
        bfq.m6567f(map, "$this$mapKeys");
        bfq.m6567f(bdl, "transform");
        Map<R, V> linkedHashMap = new LinkedHashMap<>(auy.m4971a(map.size()));
        for (Object next : map.entrySet()) {
            linkedHashMap.put(bdl.invoke(next), ((Map.Entry) next).getValue());
        }
        return linkedHashMap;
    }

    /* renamed from: e */
    public static final <K, V> Map<K, V> m5025e(Map<? extends K, ? extends V> map, bdl<? super K, Boolean> bdl) {
        bfq.m6567f(map, "$this$filterKeys");
        bfq.m6567f(bdl, "predicate");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry next : map.entrySet()) {
            if (bdl.invoke(next.getKey()).booleanValue()) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        return linkedHashMap;
    }

    /* renamed from: f */
    public static final <K, V> Map<K, V> m5028f(Map<? extends K, ? extends V> map, bdl<? super V, Boolean> bdl) {
        bfq.m6567f(map, "$this$filterValues");
        bfq.m6567f(bdl, "predicate");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry next : map.entrySet()) {
            if (bdl.invoke(next.getValue()).booleanValue()) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        return linkedHashMap;
    }

    /* renamed from: c */
    public static final <K, V, M extends Map<? super K, ? super V>> M m5009c(Map<? extends K, ? extends V> map, M m, bdl<? super Map.Entry<? extends K, ? extends V>, Boolean> bdl) {
        bfq.m6567f(map, "$this$filterTo");
        bfq.m6567f(m, JsonKeyConstants.DESTINATION);
        bfq.m6567f(bdl, "predicate");
        for (Map.Entry next : map.entrySet()) {
            if (bdl.invoke(next).booleanValue()) {
                m.put(next.getKey(), next.getValue());
            }
        }
        return m;
    }

    /* renamed from: g */
    public static final <K, V> Map<K, V> m5032g(Map<? extends K, ? extends V> map, bdl<? super Map.Entry<? extends K, ? extends V>, Boolean> bdl) {
        bfq.m6567f(map, "$this$filter");
        bfq.m6567f(bdl, "predicate");
        Map<K, V> linkedHashMap = new LinkedHashMap<>();
        for (Map.Entry next : map.entrySet()) {
            if (bdl.invoke(next).booleanValue()) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        return linkedHashMap;
    }

    /* renamed from: d */
    public static final <K, V, M extends Map<? super K, ? super V>> M m5017d(Map<? extends K, ? extends V> map, M m, bdl<? super Map.Entry<? extends K, ? extends V>, Boolean> bdl) {
        bfq.m6567f(map, "$this$filterNotTo");
        bfq.m6567f(m, JsonKeyConstants.DESTINATION);
        bfq.m6567f(bdl, "predicate");
        for (Map.Entry next : map.entrySet()) {
            if (!bdl.invoke(next).booleanValue()) {
                m.put(next.getKey(), next.getValue());
            }
        }
        return m;
    }

    /* renamed from: h */
    public static final <K, V> Map<K, V> m5037h(Map<? extends K, ? extends V> map, bdl<? super Map.Entry<? extends K, ? extends V>, Boolean> bdl) {
        bfq.m6567f(map, "$this$filterNot");
        bfq.m6567f(bdl, "predicate");
        Map<K, V> linkedHashMap = new LinkedHashMap<>();
        for (Map.Entry next : map.entrySet()) {
            if (!bdl.invoke(next).booleanValue()) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        return linkedHashMap;
    }

    /* renamed from: a */
    public static final <K, V> Map<K, V> m4978a(Iterable<? extends apc<? extends K, ? extends V>> iterable) {
        bfq.m6567f(iterable, "$this$toMap");
        if (!(iterable instanceof Collection)) {
            return auy.m5024e(auy.m4979a(iterable, new LinkedHashMap()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return auy.m4975a();
        }
        if (size != 1) {
            return auy.m4979a(iterable, new LinkedHashMap(auy.m4971a(collection.size())));
        }
        return auy.m4964a((apc) (iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next()));
    }

    /* renamed from: a */
    public static final <K, V, M extends Map<? super K, ? super V>> M m4979a(Iterable<? extends apc<? extends K, ? extends V>> iterable, M m) {
        bfq.m6567f(iterable, "$this$toMap");
        bfq.m6567f(m, JsonKeyConstants.DESTINATION);
        auy.m4986a(m, iterable);
        return m;
    }

    /* renamed from: f */
    public static final <K, V> Map<K, V> m5029f(apc<? extends K, ? extends V>[] apcArr) {
        bfq.m6567f(apcArr, "$this$toMap");
        int length = apcArr.length;
        if (length == 0) {
            return auy.m4975a();
        }
        if (length != 1) {
            return auy.m4984a(apcArr, new LinkedHashMap(auy.m4971a(apcArr.length)));
        }
        return auy.m4964a(apcArr[0]);
    }

    /* renamed from: a */
    public static final <K, V, M extends Map<? super K, ? super V>> M m4984a(apc<? extends K, ? extends V>[] apcArr, M m) {
        bfq.m6567f(apcArr, "$this$toMap");
        bfq.m6567f(m, JsonKeyConstants.DESTINATION);
        auy.m4988a(m, apcArr);
        return m;
    }

    /* renamed from: a */
    public static final <K, V> Map<K, V> m4976a(bku<? extends apc<? extends K, ? extends V>> bku) {
        bfq.m6567f(bku, "$this$toMap");
        return auy.m5024e(auy.m4977a(bku, new LinkedHashMap()));
    }

    /* renamed from: a */
    public static final <K, V, M extends Map<? super K, ? super V>> M m4977a(bku<? extends apc<? extends K, ? extends V>> bku, M m) {
        bfq.m6567f(bku, "$this$toMap");
        bfq.m6567f(m, JsonKeyConstants.DESTINATION);
        auy.m4985a(m, bku);
        return m;
    }

    /* renamed from: c */
    public static final <K, V> Map<K, V> m5004c(Map<? extends K, ? extends V> map) {
        bfq.m6567f(map, "$this$toMap");
        int size = map.size();
        if (size == 0) {
            return auy.m4975a();
        }
        if (size != 1) {
            return auy.m5015d(map);
        }
        return auy.m4968b(map);
    }

    /* renamed from: d */
    public static final <K, V> Map<K, V> m5015d(Map<? extends K, ? extends V> map) {
        bfq.m6567f(map, "$this$toMutableMap");
        return new LinkedHashMap<>(map);
    }

    /* renamed from: a */
    public static final <K, V, M extends Map<? super K, ? super V>> M m4981a(Map<? extends K, ? extends V> map, M m) {
        bfq.m6567f(map, "$this$toMap");
        bfq.m6567f(m, JsonKeyConstants.DESTINATION);
        m.putAll(map);
        return m;
    }

    /* renamed from: a */
    public static final <K, V> Map<K, V> m4980a(Map<? extends K, ? extends V> map, apc<? extends K, ? extends V> apc) {
        bfq.m6567f(map, "$this$plus");
        bfq.m6567f(apc, "pair");
        if (map.isEmpty()) {
            return auy.m4964a(apc);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.put(apc.mo1544a(), apc.mo1545b());
        return linkedHashMap;
    }

    /* renamed from: b */
    public static final <K, V> Map<K, V> m4994b(Map<? extends K, ? extends V> map, Iterable<? extends apc<? extends K, ? extends V>> iterable) {
        bfq.m6567f(map, "$this$plus");
        bfq.m6567f(iterable, "pairs");
        if (map.isEmpty()) {
            return auy.m4978a(iterable);
        }
        Map<K, V> linkedHashMap = new LinkedHashMap<>(map);
        auy.m4986a(linkedHashMap, iterable);
        return linkedHashMap;
    }

    /* renamed from: b */
    public static final <K, V> Map<K, V> m4997b(Map<? extends K, ? extends V> map, apc<? extends K, ? extends V>[] apcArr) {
        bfq.m6567f(map, "$this$plus");
        bfq.m6567f(apcArr, "pairs");
        if (map.isEmpty()) {
            return auy.m5029f(apcArr);
        }
        Map<K, V> linkedHashMap = new LinkedHashMap<>(map);
        auy.m4988a(linkedHashMap, apcArr);
        return linkedHashMap;
    }

    /* renamed from: b */
    public static final <K, V> Map<K, V> m4993b(Map<? extends K, ? extends V> map, bku<? extends apc<? extends K, ? extends V>> bku) {
        bfq.m6567f(map, "$this$plus");
        bfq.m6567f(bku, "pairs");
        Map linkedHashMap = new LinkedHashMap(map);
        auy.m4985a(linkedHashMap, bku);
        return auy.m5024e(linkedHashMap);
    }

    /* renamed from: b */
    public static final <K, V> Map<K, V> m4995b(Map<? extends K, ? extends V> map, Map<? extends K, ? extends V> map2) {
        bfq.m6567f(map, "$this$plus");
        bfq.m6567f(map2, "map");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.putAll(map2);
        return linkedHashMap;
    }

    /* renamed from: b */
    private static final <K, V> void m4999b(Map<? super K, ? super V> map, apc<? extends K, ? extends V> apc) {
        bfq.m6567f(map, "$this$plusAssign");
        map.put(apc.mo1544a(), apc.mo1545b());
    }

    /* renamed from: d */
    private static final <K, V> void m5019d(Map<? super K, ? super V> map, Iterable<? extends apc<? extends K, ? extends V>> iterable) {
        bfq.m6567f(map, "$this$plusAssign");
        auy.m4986a(map, iterable);
    }

    /* renamed from: c */
    private static final <K, V> void m5012c(Map<? super K, ? super V> map, apc<? extends K, ? extends V>[] apcArr) {
        bfq.m6567f(map, "$this$plusAssign");
        auy.m4988a(map, apcArr);
    }

    /* renamed from: d */
    private static final <K, V> void m5018d(Map<? super K, ? super V> map, bku<? extends apc<? extends K, ? extends V>> bku) {
        bfq.m6567f(map, "$this$plusAssign");
        auy.m4985a(map, bku);
    }

    /* renamed from: c */
    private static final <K, V> void m5011c(Map<? super K, ? super V> map, Map<K, ? extends V> map2) {
        bfq.m6567f(map, "$this$plusAssign");
        map.putAll(map2);
    }

    /* renamed from: c */
    public static final <K, V> Map<K, V> m5008c(Map<? extends K, ? extends V> map, K k) {
        bfq.m6567f(map, "$this$minus");
        Map<? extends K, ? extends V> d = auy.m5015d(map);
        d.remove(k);
        return auy.m5024e(d);
    }

    /* renamed from: c */
    public static final <K, V> Map<K, V> m5007c(Map<? extends K, ? extends V> map, Iterable<? extends K> iterable) {
        bfq.m6567f(map, "$this$minus");
        bfq.m6567f(iterable, "keys");
        Map<? extends K, ? extends V> d = auy.m5015d(map);
        ato.m4662b(d.keySet(), iterable);
        return auy.m5024e(d);
    }

    /* renamed from: a */
    public static final <K, V> Map<K, V> m4983a(Map<? extends K, ? extends V> map, K[] kArr) {
        bfq.m6567f(map, "$this$minus");
        bfq.m6567f(kArr, "keys");
        Map<? extends K, ? extends V> d = auy.m5015d(map);
        ato.m4664b(d.keySet(), (T[]) kArr);
        return auy.m5024e(d);
    }

    /* renamed from: c */
    public static final <K, V> Map<K, V> m5006c(Map<? extends K, ? extends V> map, bku<? extends K> bku) {
        bfq.m6567f(map, "$this$minus");
        bfq.m6567f(bku, "keys");
        Map<? extends K, ? extends V> d = auy.m5015d(map);
        ato.m4661b(d.keySet(), bku);
        return auy.m5024e(d);
    }

    /* renamed from: i */
    private static final <K, V> void m5039i(Map<K, V> map, K k) {
        bfq.m6567f(map, "$this$minusAssign");
        map.remove(k);
    }

    /* renamed from: e */
    private static final <K, V> void m5027e(Map<K, V> map, Iterable<? extends K> iterable) {
        bfq.m6567f(map, "$this$minusAssign");
        ato.m4662b(map.keySet(), iterable);
    }

    /* renamed from: b */
    private static final <K, V> void m5000b(Map<K, V> map, K[] kArr) {
        bfq.m6567f(map, "$this$minusAssign");
        ato.m4664b(map.keySet(), (T[]) kArr);
    }

    /* renamed from: e */
    private static final <K, V> void m5026e(Map<K, V> map, bku<? extends K> bku) {
        bfq.m6567f(map, "$this$minusAssign");
        ato.m4661b(map.keySet(), bku);
    }

    /* renamed from: e */
    public static final <K, V> Map<K, V> m5024e(Map<K, ? extends V> map) {
        bfq.m6567f(map, "$this$optimizeReadOnlyMap");
        int size = map.size();
        if (size == 0) {
            return auy.m4975a();
        }
        if (size != 1) {
            return map;
        }
        return auy.m4968b(map);
    }
}

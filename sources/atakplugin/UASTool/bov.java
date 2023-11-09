package atakplugin.UASTool;

import indago.serialization.JsonKeyConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

@aot(mo1534a = 5, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000Ü\u0001\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u001f\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\u000f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a!\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\b\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0002\u001a!\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\b\u001a\u0010\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b*\u00020\u0002\u001a\u0010\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n*\u00020\u0002\u001aE\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000e0\f\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u000e*\u00020\u00022\u001e\u0010\u000f\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000e0\u00100\u0004H\b\u001a3\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u00020\u00050\f\"\u0004\b\u0000\u0010\r*\u00020\u00022\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\r0\u0004H\b\u001aM\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000e0\f\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u000e*\u00020\u00022\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\r0\u00042\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u000e0\u0004H\b\u001aN\u0010\u0014\u001a\u0002H\u0015\"\u0004\b\u0000\u0010\r\"\u0018\b\u0001\u0010\u0015*\u0012\u0012\u0006\b\u0000\u0012\u0002H\r\u0012\u0006\b\u0000\u0012\u00020\u00050\u0016*\u00020\u00022\u0006\u0010\u0017\u001a\u0002H\u00152\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\r0\u0004H\b¢\u0006\u0002\u0010\u0018\u001ah\u0010\u0014\u001a\u0002H\u0015\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u000e\"\u0018\b\u0002\u0010\u0015*\u0012\u0012\u0006\b\u0000\u0012\u0002H\r\u0012\u0006\b\u0000\u0012\u0002H\u000e0\u0016*\u00020\u00022\u0006\u0010\u0017\u001a\u0002H\u00152\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\r0\u00042\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u000e0\u0004H\b¢\u0006\u0002\u0010\u0019\u001a`\u0010\u001a\u001a\u0002H\u0015\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u000e\"\u0018\b\u0002\u0010\u0015*\u0012\u0012\u0006\b\u0000\u0012\u0002H\r\u0012\u0006\b\u0000\u0012\u0002H\u000e0\u0016*\u00020\u00022\u0006\u0010\u0017\u001a\u0002H\u00152\u001e\u0010\u000f\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000e0\u00100\u0004H\b¢\u0006\u0002\u0010\u0018\u001a3\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u000e0\f\"\u0004\b\u0000\u0010\u000e*\u00020\u00022\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u000e0\u0004H\b\u001aN\u0010\u001d\u001a\u0002H\u0015\"\u0004\b\u0000\u0010\u000e\"\u0018\b\u0001\u0010\u0015*\u0012\u0012\u0006\b\u0000\u0012\u00020\u0005\u0012\u0006\b\u0000\u0012\u0002H\u000e0\u0016*\u00020\u00022\u0006\u0010\u0017\u001a\u0002H\u00152\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u000e0\u0004H\b¢\u0006\u0002\u0010\u0018\u001a\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f*\u00020\u00022\u0006\u0010!\u001a\u00020\"H\u0007\u001a4\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H#0\u001f\"\u0004\b\u0000\u0010#*\u00020\u00022\u0006\u0010!\u001a\u00020\"2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H#0\u0004H\u0007\u001a\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020 0\n*\u00020\u00022\u0006\u0010!\u001a\u00020\"H\u0007\u001a4\u0010$\u001a\b\u0012\u0004\u0012\u0002H#0\n\"\u0004\b\u0000\u0010#*\u00020\u00022\u0006\u0010!\u001a\u00020\"2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H#0\u0004H\u0007\u001a\r\u0010%\u001a\u00020\"*\u00020\u0002H\b\u001a!\u0010%\u001a\u00020\"*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\b\u001a\u0012\u0010&\u001a\u00020\u0002*\u00020\u00022\u0006\u0010'\u001a\u00020\"\u001a\u0012\u0010&\u001a\u00020 *\u00020 2\u0006\u0010'\u001a\u00020\"\u001a\u0012\u0010(\u001a\u00020\u0002*\u00020\u00022\u0006\u0010'\u001a\u00020\"\u001a\u0012\u0010(\u001a\u00020 *\u00020 2\u0006\u0010'\u001a\u00020\"\u001a!\u0010)\u001a\u00020\u0002*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\b\u001a!\u0010)\u001a\u00020 *\u00020 2\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\b\u001a!\u0010*\u001a\u00020\u0002*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\b\u001a!\u0010*\u001a\u00020 *\u00020 2\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\b\u001a)\u0010+\u001a\u00020\u0005*\u00020\u00022\u0006\u0010,\u001a\u00020\"2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00050\u0004H\b\u001a\u001c\u0010.\u001a\u0004\u0018\u00010\u0005*\u00020\u00022\u0006\u0010,\u001a\u00020\"H\b¢\u0006\u0002\u0010/\u001a!\u00100\u001a\u00020\u0002*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\b\u001a!\u00100\u001a\u00020 *\u00020 2\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\b\u001a6\u00101\u001a\u00020\u0002*\u00020\u00022'\u0010\u0003\u001a#\u0012\u0013\u0012\u00110\"¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000102H\b\u001a6\u00101\u001a\u00020 *\u00020 2'\u0010\u0003\u001a#\u0012\u0013\u0012\u00110\"¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000102H\b\u001aQ\u00105\u001a\u0002H6\"\f\b\u0000\u00106*\u000607j\u0002`8*\u00020\u00022\u0006\u0010\u0017\u001a\u0002H62'\u0010\u0003\u001a#\u0012\u0013\u0012\u00110\"¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000102H\b¢\u0006\u0002\u00109\u001a!\u0010:\u001a\u00020\u0002*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\b\u001a!\u0010:\u001a\u00020 *\u00020 2\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\b\u001a<\u0010;\u001a\u0002H6\"\f\b\u0000\u00106*\u000607j\u0002`8*\u00020\u00022\u0006\u0010\u0017\u001a\u0002H62\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\b¢\u0006\u0002\u0010<\u001a<\u0010=\u001a\u0002H6\"\f\b\u0000\u00106*\u000607j\u0002`8*\u00020\u00022\u0006\u0010\u0017\u001a\u0002H62\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\b¢\u0006\u0002\u0010<\u001a(\u0010>\u001a\u0004\u0018\u00010\u0005*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\b¢\u0006\u0002\u0010?\u001a(\u0010@\u001a\u0004\u0018\u00010\u0005*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\b¢\u0006\u0002\u0010?\u001a\n\u0010A\u001a\u00020\u0005*\u00020\u0002\u001a!\u0010A\u001a\u00020\u0005*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\b\u001a\u0011\u0010B\u001a\u0004\u0018\u00010\u0005*\u00020\u0002¢\u0006\u0002\u0010C\u001a(\u0010B\u001a\u0004\u0018\u00010\u0005*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\b¢\u0006\u0002\u0010?\u001a3\u0010D\u001a\b\u0012\u0004\u0012\u0002H#0\u001f\"\u0004\b\u0000\u0010#*\u00020\u00022\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u0002H#0\b0\u0004H\b\u001aL\u0010E\u001a\u0002H6\"\u0004\b\u0000\u0010#\"\u0010\b\u0001\u00106*\n\u0012\u0006\b\u0000\u0012\u0002H#0F*\u00020\u00022\u0006\u0010\u0017\u001a\u0002H62\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u0002H#0\b0\u0004H\b¢\u0006\u0002\u0010G\u001aI\u0010H\u001a\u0002H#\"\u0004\b\u0000\u0010#*\u00020\u00022\u0006\u0010I\u001a\u0002H#2'\u0010J\u001a#\u0012\u0013\u0012\u0011H#¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(K\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H#02H\b¢\u0006\u0002\u0010L\u001a^\u0010M\u001a\u0002H#\"\u0004\b\u0000\u0010#*\u00020\u00022\u0006\u0010I\u001a\u0002H#2<\u0010J\u001a8\u0012\u0013\u0012\u00110\"¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(,\u0012\u0013\u0012\u0011H#¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(K\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H#0NH\b¢\u0006\u0002\u0010O\u001aI\u0010P\u001a\u0002H#\"\u0004\b\u0000\u0010#*\u00020\u00022\u0006\u0010I\u001a\u0002H#2'\u0010J\u001a#\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u0011H#¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(K\u0012\u0004\u0012\u0002H#02H\b¢\u0006\u0002\u0010L\u001a^\u0010Q\u001a\u0002H#\"\u0004\b\u0000\u0010#*\u00020\u00022\u0006\u0010I\u001a\u0002H#2<\u0010J\u001a8\u0012\u0013\u0012\u00110\"¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u0011H#¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(K\u0012\u0004\u0012\u0002H#0NH\b¢\u0006\u0002\u0010O\u001a!\u0010R\u001a\u00020S*\u00020\u00022\u0012\u0010T\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020S0\u0004H\b\u001a6\u0010U\u001a\u00020S*\u00020\u00022'\u0010T\u001a#\u0012\u0013\u0012\u00110\"¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020S02H\b\u001a)\u0010V\u001a\u00020\u0005*\u00020\u00022\u0006\u0010,\u001a\u00020\"2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00050\u0004H\b\u001a\u0019\u0010W\u001a\u0004\u0018\u00010\u0005*\u00020\u00022\u0006\u0010,\u001a\u00020\"¢\u0006\u0002\u0010/\u001a9\u0010X\u001a\u0014\u0012\u0004\u0012\u0002H\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u001f0\f\"\u0004\b\u0000\u0010\r*\u00020\u00022\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\r0\u0004H\b\u001aS\u0010X\u001a\u0014\u0012\u0004\u0012\u0002H\r\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000e0\u001f0\f\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u000e*\u00020\u00022\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\r0\u00042\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u000e0\u0004H\b\u001aR\u0010Y\u001a\u0002H\u0015\"\u0004\b\u0000\u0010\r\"\u001c\b\u0001\u0010\u0015*\u0016\u0012\u0006\b\u0000\u0012\u0002H\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050Z0\u0016*\u00020\u00022\u0006\u0010\u0017\u001a\u0002H\u00152\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\r0\u0004H\b¢\u0006\u0002\u0010\u0018\u001al\u0010Y\u001a\u0002H\u0015\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u000e\"\u001c\b\u0002\u0010\u0015*\u0016\u0012\u0006\b\u0000\u0012\u0002H\r\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000e0Z0\u0016*\u00020\u00022\u0006\u0010\u0017\u001a\u0002H\u00152\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\r0\u00042\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u000e0\u0004H\b¢\u0006\u0002\u0010\u0019\u001a5\u0010[\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\r0\\\"\u0004\b\u0000\u0010\r*\u00020\u00022\u0014\b\u0004\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\r0\u0004H\b\u001a!\u0010]\u001a\u00020\"*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\b\u001a!\u0010^\u001a\u00020\"*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\b\u001a\n\u0010_\u001a\u00020\u0005*\u00020\u0002\u001a!\u0010_\u001a\u00020\u0005*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\b\u001a\u0011\u0010`\u001a\u0004\u0018\u00010\u0005*\u00020\u0002¢\u0006\u0002\u0010C\u001a(\u0010`\u001a\u0004\u0018\u00010\u0005*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\b¢\u0006\u0002\u0010?\u001a-\u0010a\u001a\b\u0012\u0004\u0012\u0002H#0\u001f\"\u0004\b\u0000\u0010#*\u00020\u00022\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H#0\u0004H\b\u001aB\u0010b\u001a\b\u0012\u0004\u0012\u0002H#0\u001f\"\u0004\b\u0000\u0010#*\u00020\u00022'\u0010\u000f\u001a#\u0012\u0013\u0012\u00110\"¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H#02H\b\u001aH\u0010c\u001a\b\u0012\u0004\u0012\u0002H#0\u001f\"\b\b\u0000\u0010#*\u00020d*\u00020\u00022)\u0010\u000f\u001a%\u0012\u0013\u0012\u00110\"¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u0001H#02H\b\u001aa\u0010e\u001a\u0002H6\"\b\b\u0000\u0010#*\u00020d\"\u0010\b\u0001\u00106*\n\u0012\u0006\b\u0000\u0012\u0002H#0F*\u00020\u00022\u0006\u0010\u0017\u001a\u0002H62)\u0010\u000f\u001a%\u0012\u0013\u0012\u00110\"¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u0001H#02H\b¢\u0006\u0002\u0010f\u001a[\u0010g\u001a\u0002H6\"\u0004\b\u0000\u0010#\"\u0010\b\u0001\u00106*\n\u0012\u0006\b\u0000\u0012\u0002H#0F*\u00020\u00022\u0006\u0010\u0017\u001a\u0002H62'\u0010\u000f\u001a#\u0012\u0013\u0012\u00110\"¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H#02H\b¢\u0006\u0002\u0010f\u001a3\u0010h\u001a\b\u0012\u0004\u0012\u0002H#0\u001f\"\b\b\u0000\u0010#*\u00020d*\u00020\u00022\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u0001H#0\u0004H\b\u001aL\u0010i\u001a\u0002H6\"\b\b\u0000\u0010#*\u00020d\"\u0010\b\u0001\u00106*\n\u0012\u0006\b\u0000\u0012\u0002H#0F*\u00020\u00022\u0006\u0010\u0017\u001a\u0002H62\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u0001H#0\u0004H\b¢\u0006\u0002\u0010G\u001aF\u0010j\u001a\u0002H6\"\u0004\b\u0000\u0010#\"\u0010\b\u0001\u00106*\n\u0012\u0006\b\u0000\u0012\u0002H#0F*\u00020\u00022\u0006\u0010\u0017\u001a\u0002H62\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H#0\u0004H\b¢\u0006\u0002\u0010G\u001a\u0011\u0010k\u001a\u0004\u0018\u00010\u0005*\u00020\u0002¢\u0006\u0002\u0010C\u001a8\u0010l\u001a\u0004\u0018\u00010\u0005\"\u000e\b\u0000\u0010#*\b\u0012\u0004\u0012\u0002H#0m*\u00020\u00022\u0012\u0010n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H#0\u0004H\b¢\u0006\u0002\u0010?\u001a-\u0010o\u001a\u0004\u0018\u00010\u0005*\u00020\u00022\u001a\u0010p\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00050qj\n\u0012\u0006\b\u0000\u0012\u00020\u0005`r¢\u0006\u0002\u0010s\u001a\u0011\u0010t\u001a\u0004\u0018\u00010\u0005*\u00020\u0002¢\u0006\u0002\u0010C\u001a8\u0010u\u001a\u0004\u0018\u00010\u0005\"\u000e\b\u0000\u0010#*\b\u0012\u0004\u0012\u0002H#0m*\u00020\u00022\u0012\u0010n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H#0\u0004H\b¢\u0006\u0002\u0010?\u001a-\u0010v\u001a\u0004\u0018\u00010\u0005*\u00020\u00022\u001a\u0010p\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00050qj\n\u0012\u0006\b\u0000\u0012\u00020\u0005`r¢\u0006\u0002\u0010s\u001a\n\u0010w\u001a\u00020\u0001*\u00020\u0002\u001a!\u0010w\u001a\u00020\u0001*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\b\u001a0\u0010x\u001a\u0002Hy\"\b\b\u0000\u0010y*\u00020\u0002*\u0002Hy2\u0012\u0010T\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020S0\u0004H\b¢\u0006\u0002\u0010z\u001a-\u0010{\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0010*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\b\u001a-\u0010{\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 0\u0010*\u00020 2\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\b\u001a\r\u0010|\u001a\u00020\u0005*\u00020\u0002H\b\u001a\u0014\u0010|\u001a\u00020\u0005*\u00020\u00022\u0006\u0010|\u001a\u00020}H\u0007\u001a6\u0010~\u001a\u00020\u0005*\u00020\u00022'\u0010J\u001a#\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(K\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000502H\b\u001aK\u0010\u001a\u00020\u0005*\u00020\u00022<\u0010J\u001a8\u0012\u0013\u0012\u00110\"¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(,\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(K\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050NH\b\u001a7\u0010\u0001\u001a\u00020\u0005*\u00020\u00022'\u0010J\u001a#\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(K\u0012\u0004\u0012\u00020\u000502H\b\u001aL\u0010\u0001\u001a\u00020\u0005*\u00020\u00022<\u0010J\u001a8\u0012\u0013\u0012\u00110\"¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(K\u0012\u0004\u0012\u00020\u00050NH\b\u001a\u000b\u0010\u0001\u001a\u00020\u0002*\u00020\u0002\u001a\u000e\u0010\u0001\u001a\u00020 *\u00020 H\b\u001a\u000b\u0010\u0001\u001a\u00020\u0005*\u00020\u0002\u001a\"\u0010\u0001\u001a\u00020\u0005*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\b\u001a\u0012\u0010\u0001\u001a\u0004\u0018\u00010\u0005*\u00020\u0002¢\u0006\u0002\u0010C\u001a)\u0010\u0001\u001a\u0004\u0018\u00010\u0005*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\b¢\u0006\u0002\u0010?\u001a\u001a\u0010\u0001\u001a\u00020\u0002*\u00020\u00022\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\"0\b\u001a\u0015\u0010\u0001\u001a\u00020\u0002*\u00020\u00022\b\u0010\u0001\u001a\u00030\u0001\u001a\u001d\u0010\u0001\u001a\u00020 *\u00020 2\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\"0\bH\b\u001a\u0015\u0010\u0001\u001a\u00020 *\u00020 2\b\u0010\u0001\u001a\u00030\u0001\u001a\"\u0010\u0001\u001a\u00020\"*\u00020\u00022\u0012\u0010n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\"0\u0004H\b\u001a$\u0010\u0001\u001a\u00030\u0001*\u00020\u00022\u0013\u0010n\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0012\u0005\u0012\u00030\u00010\u0004H\b\u001a\u0013\u0010\u0001\u001a\u00020\u0002*\u00020\u00022\u0006\u0010'\u001a\u00020\"\u001a\u0013\u0010\u0001\u001a\u00020 *\u00020 2\u0006\u0010'\u001a\u00020\"\u001a\u0013\u0010\u0001\u001a\u00020\u0002*\u00020\u00022\u0006\u0010'\u001a\u00020\"\u001a\u0013\u0010\u0001\u001a\u00020 *\u00020 2\u0006\u0010'\u001a\u00020\"\u001a\"\u0010\u0001\u001a\u00020\u0002*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\b\u001a\"\u0010\u0001\u001a\u00020 *\u00020 2\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\b\u001a\"\u0010\u0001\u001a\u00020\u0002*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\b\u001a\"\u0010\u0001\u001a\u00020 *\u00020 2\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\b\u001a+\u0010\u0001\u001a\u0002H6\"\u0010\b\u0000\u00106*\n\u0012\u0006\b\u0000\u0012\u00020\u00050F*\u00020\u00022\u0006\u0010\u0017\u001a\u0002H6¢\u0006\u0003\u0010\u0001\u001a\u001d\u0010\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u00050\u0001j\t\u0012\u0004\u0012\u00020\u0005`\u0001*\u00020\u0002\u001a\u0011\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050\u001f*\u00020\u0002\u001a\u0011\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050Z*\u00020\u0002\u001a\u0012\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020\u00050\u0001*\u00020\u0002\u001a1\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020 0\u001f*\u00020\u00022\u0006\u0010!\u001a\u00020\"2\t\b\u0002\u0010\u0001\u001a\u00020\"2\t\b\u0002\u0010\u0001\u001a\u00020\u0001H\u0007\u001aK\u0010\u0001\u001a\b\u0012\u0004\u0012\u0002H#0\u001f\"\u0004\b\u0000\u0010#*\u00020\u00022\u0006\u0010!\u001a\u00020\"2\t\b\u0002\u0010\u0001\u001a\u00020\"2\t\b\u0002\u0010\u0001\u001a\u00020\u00012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H#0\u0004H\u0007\u001a1\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020 0\n*\u00020\u00022\u0006\u0010!\u001a\u00020\"2\t\b\u0002\u0010\u0001\u001a\u00020\"2\t\b\u0002\u0010\u0001\u001a\u00020\u0001H\u0007\u001aK\u0010\u0001\u001a\b\u0012\u0004\u0012\u0002H#0\n\"\u0004\b\u0000\u0010#*\u00020\u00022\u0006\u0010!\u001a\u00020\"2\t\b\u0002\u0010\u0001\u001a\u00020\"2\t\b\u0002\u0010\u0001\u001a\u00020\u00012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H#0\u0004H\u0007\u001a\u0018\u0010\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\u00050\u00010\b*\u00020\u0002\u001a)\u0010\u0001\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00100\u001f*\u00020\u00022\u0007\u0010\u0001\u001a\u00020\u0002H\u0004\u001a]\u0010\u0001\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u001f\"\u0004\b\u0000\u0010\u000e*\u00020\u00022\u0007\u0010\u0001\u001a\u00020\u000228\u0010\u000f\u001a4\u0012\u0014\u0012\u00120\u0005¢\u0006\r\b3\u0012\t\b4\u0012\u0005\b\b( \u0001\u0012\u0014\u0012\u00120\u0005¢\u0006\r\b3\u0012\t\b4\u0012\u0005\b\b(¡\u0001\u0012\u0004\u0012\u0002H\u000e02H\b\u001a\u001f\u0010¢\u0001\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00100\u001f*\u00020\u0002H\u0007\u001aT\u0010¢\u0001\u001a\b\u0012\u0004\u0012\u0002H#0\u001f\"\u0004\b\u0000\u0010#*\u00020\u000228\u0010\u000f\u001a4\u0012\u0014\u0012\u00120\u0005¢\u0006\r\b3\u0012\t\b4\u0012\u0005\b\b( \u0001\u0012\u0014\u0012\u00120\u0005¢\u0006\r\b3\u0012\t\b4\u0012\u0005\b\b(¡\u0001\u0012\u0004\u0012\u0002H#02H\b¨\u0006£\u0001"}, mo1538e = {"all", "", "", "predicate", "Lkotlin/Function1;", "", "any", "asIterable", "", "asSequence", "Lkotlin/sequences/Sequence;", "associate", "", "K", "V", "transform", "Lkotlin/Pair;", "associateBy", "keySelector", "valueTransform", "associateByTo", "M", "", "destination", "(Ljava/lang/CharSequence;Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "(Ljava/lang/CharSequence;Ljava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "associateTo", "associateWith", "valueSelector", "associateWithTo", "chunked", "", "", "size", "", "R", "chunkedSequence", "count", "drop", "n", "dropLast", "dropLastWhile", "dropWhile", "elementAtOrElse", "index", "defaultValue", "elementAtOrNull", "(Ljava/lang/CharSequence;I)Ljava/lang/Character;", "filter", "filterIndexed", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "filterIndexedTo", "C", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "(Ljava/lang/CharSequence;Ljava/lang/Appendable;Lkotlin/jvm/functions/Function2;)Ljava/lang/Appendable;", "filterNot", "filterNotTo", "(Ljava/lang/CharSequence;Ljava/lang/Appendable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "filterTo", "find", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Character;", "findLast", "first", "firstOrNull", "(Ljava/lang/CharSequence;)Ljava/lang/Character;", "flatMap", "flatMapTo", "", "(Ljava/lang/CharSequence;Ljava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "fold", "initial", "operation", "acc", "(Ljava/lang/CharSequence;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldIndexed", "Lkotlin/Function3;", "(Ljava/lang/CharSequence;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "foldRight", "foldRightIndexed", "forEach", "", "action", "forEachIndexed", "getOrElse", "getOrNull", "groupBy", "groupByTo", "", "groupingBy", "Lkotlin/collections/Grouping;", "indexOfFirst", "indexOfLast", "last", "lastOrNull", "map", "mapIndexed", "mapIndexedNotNull", "", "mapIndexedNotNullTo", "(Ljava/lang/CharSequence;Ljava/util/Collection;Lkotlin/jvm/functions/Function2;)Ljava/util/Collection;", "mapIndexedTo", "mapNotNull", "mapNotNullTo", "mapTo", "max", "maxBy", "", "selector", "maxWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/lang/CharSequence;Ljava/util/Comparator;)Ljava/lang/Character;", "min", "minBy", "minWith", "none", "onEach", "S", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/CharSequence;", "partition", "random", "Lkotlin/random/Random;", "reduce", "reduceIndexed", "reduceRight", "reduceRightIndexed", "reversed", "single", "singleOrNull", "slice", "indices", "Lkotlin/ranges/IntRange;", "sumBy", "sumByDouble", "", "take", "takeLast", "takeLastWhile", "takeWhile", "toCollection", "(Ljava/lang/CharSequence;Ljava/util/Collection;)Ljava/util/Collection;", "toHashSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "toList", "toMutableList", "toSet", "", "windowed", "step", "partialWindows", "windowedSequence", "withIndex", "Lkotlin/collections/IndexedValue;", "zip", "other", "a", "b", "zipWithNext", "kotlin-stdlib"}, mo1539f = "kotlin/text/StringsKt", mo1541h = 1)
class bov extends bou {
    /* renamed from: c */
    private static final char m8302c(CharSequence charSequence, int i, bdl<? super Integer, Character> bdl) {
        return (i < 0 || i > boc.m8224g(charSequence)) ? bdl.invoke(Integer.valueOf(i)).charValue() : charSequence.charAt(i);
    }

    /* renamed from: j */
    private static final Character m8339j(CharSequence charSequence, int i) {
        return boc.m8303c(charSequence, i);
    }

    /* renamed from: k */
    public static final char m8340k(CharSequence charSequence) {
        bfq.m6567f(charSequence, "$this$first");
        if (!(charSequence.length() == 0)) {
            return charSequence.charAt(0);
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    /* renamed from: d */
    public static final char m8308d(CharSequence charSequence, bdl<? super Character, Boolean> bdl) {
        bfq.m6567f(charSequence, "$this$first");
        bfq.m6567f(bdl, "predicate");
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            if (bdl.invoke(Character.valueOf(charAt)).booleanValue()) {
                return charAt;
            }
        }
        throw new NoSuchElementException("Char sequence contains no character matching the predicate.");
    }

    /* renamed from: l */
    public static final Character m8343l(CharSequence charSequence) {
        bfq.m6567f(charSequence, "$this$firstOrNull");
        if (charSequence.length() == 0) {
            return null;
        }
        return Character.valueOf(charSequence.charAt(0));
    }

    /* renamed from: e */
    public static final Character m8317e(CharSequence charSequence, bdl<? super Character, Boolean> bdl) {
        bfq.m6567f(charSequence, "$this$firstOrNull");
        bfq.m6567f(bdl, "predicate");
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            if (bdl.invoke(Character.valueOf(charAt)).booleanValue()) {
                return Character.valueOf(charAt);
            }
        }
        return null;
    }

    /* renamed from: d */
    private static final char m8307d(CharSequence charSequence, int i, bdl<? super Integer, Character> bdl) {
        return (i < 0 || i > boc.m8224g(charSequence)) ? bdl.invoke(Integer.valueOf(i)).charValue() : charSequence.charAt(i);
    }

    /* renamed from: c */
    public static final Character m8303c(CharSequence charSequence, int i) {
        bfq.m6567f(charSequence, "$this$getOrNull");
        if (i < 0 || i > boc.m8224g(charSequence)) {
            return null;
        }
        return Character.valueOf(charSequence.charAt(i));
    }

    /* renamed from: f */
    public static final int m8320f(CharSequence charSequence, bdl<? super Character, Boolean> bdl) {
        bfq.m6567f(charSequence, "$this$indexOfFirst");
        bfq.m6567f(bdl, "predicate");
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (bdl.invoke(Character.valueOf(charSequence.charAt(i))).booleanValue()) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: g */
    public static final int m8324g(CharSequence charSequence, bdl<? super Character, Boolean> bdl) {
        bfq.m6567f(charSequence, "$this$indexOfLast");
        bfq.m6567f(bdl, "predicate");
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (bdl.invoke(Character.valueOf(charSequence.charAt(length))).booleanValue()) {
                return length;
            }
        }
        return -1;
    }

    /* renamed from: m */
    public static final char m8344m(CharSequence charSequence) {
        bfq.m6567f(charSequence, "$this$last");
        if (!(charSequence.length() == 0)) {
            return charSequence.charAt(boc.m8224g(charSequence));
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    /* renamed from: h */
    public static final char m8329h(CharSequence charSequence, bdl<? super Character, Boolean> bdl) {
        char charAt;
        bfq.m6567f(charSequence, "$this$last");
        bfq.m6567f(bdl, "predicate");
        int length = charSequence.length();
        do {
            length--;
            if (length >= 0) {
                charAt = charSequence.charAt(length);
            } else {
                throw new NoSuchElementException("Char sequence contains no character matching the predicate.");
            }
        } while (!bdl.invoke(Character.valueOf(charAt)).booleanValue());
        return charAt;
    }

    /* renamed from: n */
    public static final Character m8347n(CharSequence charSequence) {
        bfq.m6567f(charSequence, "$this$lastOrNull");
        if (charSequence.length() == 0) {
            return null;
        }
        return Character.valueOf(charSequence.charAt(charSequence.length() - 1));
    }

    /* renamed from: i */
    public static final Character m8334i(CharSequence charSequence, bdl<? super Character, Boolean> bdl) {
        char charAt;
        bfq.m6567f(charSequence, "$this$lastOrNull");
        bfq.m6567f(bdl, "predicate");
        int length = charSequence.length();
        do {
            length--;
            if (length < 0) {
                return null;
            }
            charAt = charSequence.charAt(length);
        } while (!bdl.invoke(Character.valueOf(charAt)).booleanValue());
        return Character.valueOf(charAt);
    }

    /* renamed from: D */
    private static final char m8251D(CharSequence charSequence) {
        return boc.m8263a(charSequence, (bic) bic.f2709b);
    }

    /* renamed from: a */
    public static final char m8263a(CharSequence charSequence, bic bic) {
        bfq.m6567f(charSequence, "$this$random");
        bfq.m6567f(bic, "random");
        if (!(charSequence.length() == 0)) {
            return charSequence.charAt(bic.mo2529b(charSequence.length()));
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    /* renamed from: o */
    public static final char m8349o(CharSequence charSequence) {
        bfq.m6567f(charSequence, "$this$single");
        int length = charSequence.length();
        if (length == 0) {
            throw new NoSuchElementException("Char sequence is empty.");
        } else if (length == 1) {
            return charSequence.charAt(0);
        } else {
            throw new IllegalArgumentException("Char sequence has more than one element.");
        }
    }

    /* renamed from: j */
    public static final char m8337j(CharSequence charSequence, bdl<? super Character, Boolean> bdl) {
        bfq.m6567f(charSequence, "$this$single");
        bfq.m6567f(bdl, "predicate");
        Character ch = null;
        boolean z = false;
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            if (bdl.invoke(Character.valueOf(charAt)).booleanValue()) {
                if (!z) {
                    ch = Character.valueOf(charAt);
                    z = true;
                } else {
                    throw new IllegalArgumentException("Char sequence contains more than one matching element.");
                }
            }
        }
        if (!z) {
            throw new NoSuchElementException("Char sequence contains no character matching the predicate.");
        } else if (ch != null) {
            return ch.charValue();
        } else {
            throw new apx("null cannot be cast to non-null type kotlin.Char");
        }
    }

    /* renamed from: p */
    public static final Character m8352p(CharSequence charSequence) {
        bfq.m6567f(charSequence, "$this$singleOrNull");
        if (charSequence.length() == 1) {
            return Character.valueOf(charSequence.charAt(0));
        }
        return null;
    }

    /* renamed from: k */
    public static final Character m8341k(CharSequence charSequence, bdl<? super Character, Boolean> bdl) {
        bfq.m6567f(charSequence, "$this$singleOrNull");
        bfq.m6567f(bdl, "predicate");
        Character ch = null;
        boolean z = false;
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            if (bdl.invoke(Character.valueOf(charAt)).booleanValue()) {
                if (z) {
                    return null;
                }
                ch = Character.valueOf(charAt);
                z = true;
            }
        }
        if (!z) {
            return null;
        }
        return ch;
    }

    /* renamed from: d */
    public static final CharSequence m8309d(CharSequence charSequence, int i) {
        bfq.m6567f(charSequence, "$this$drop");
        if (i >= 0) {
            return charSequence.subSequence(biu.m7191d(i, charSequence.length()), charSequence.length());
        }
        throw new IllegalArgumentException(("Requested character count " + i + " is less than zero.").toString());
    }

    /* renamed from: f */
    public static final String m8322f(String str, int i) {
        bfq.m6567f(str, "$this$drop");
        if (i >= 0) {
            String substring = str.substring(biu.m7191d(i, str.length()));
            bfq.m6554b(substring, "(this as java.lang.String).substring(startIndex)");
            return substring;
        }
        throw new IllegalArgumentException(("Requested character count " + i + " is less than zero.").toString());
    }

    /* renamed from: e */
    public static final CharSequence m8316e(CharSequence charSequence, int i) {
        bfq.m6567f(charSequence, "$this$dropLast");
        if (i >= 0) {
            return boc.m8321f(charSequence, biu.m7177c(charSequence.length() - i, 0));
        }
        throw new IllegalArgumentException(("Requested character count " + i + " is less than zero.").toString());
    }

    /* renamed from: g */
    public static final String m8326g(String str, int i) {
        bfq.m6567f(str, "$this$dropLast");
        if (i >= 0) {
            return boc.m8330h(str, biu.m7177c(str.length() - i, 0));
        }
        throw new IllegalArgumentException(("Requested character count " + i + " is less than zero.").toString());
    }

    /* renamed from: l */
    public static final CharSequence m8342l(CharSequence charSequence, bdl<? super Character, Boolean> bdl) {
        bfq.m6567f(charSequence, "$this$dropLastWhile");
        bfq.m6567f(bdl, "predicate");
        for (int g = boc.m8224g(charSequence); g >= 0; g--) {
            if (!bdl.invoke(Character.valueOf(charSequence.charAt(g))).booleanValue()) {
                return charSequence.subSequence(0, g + 1);
            }
        }
        return "";
    }

    /* renamed from: d */
    public static final String m8311d(String str, bdl<? super Character, Boolean> bdl) {
        bfq.m6567f(str, "$this$dropLastWhile");
        bfq.m6567f(bdl, "predicate");
        for (int g = boc.m8224g(str); g >= 0; g--) {
            if (!bdl.invoke(Character.valueOf(str.charAt(g))).booleanValue()) {
                String substring = str.substring(0, g + 1);
                bfq.m6554b(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                return substring;
            }
        }
        return "";
    }

    /* renamed from: m */
    public static final CharSequence m8345m(CharSequence charSequence, bdl<? super Character, Boolean> bdl) {
        bfq.m6567f(charSequence, "$this$dropWhile");
        bfq.m6567f(bdl, "predicate");
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!bdl.invoke(Character.valueOf(charSequence.charAt(i))).booleanValue()) {
                return charSequence.subSequence(i, charSequence.length());
            }
        }
        return "";
    }

    /* renamed from: e */
    public static final String m8318e(String str, bdl<? super Character, Boolean> bdl) {
        bfq.m6567f(str, "$this$dropWhile");
        bfq.m6567f(bdl, "predicate");
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!bdl.invoke(Character.valueOf(str.charAt(i))).booleanValue()) {
                String substring = str.substring(i);
                bfq.m6554b(substring, "(this as java.lang.String).substring(startIndex)");
                return substring;
            }
        }
        return "";
    }

    /* renamed from: n */
    public static final CharSequence m8346n(CharSequence charSequence, bdl<? super Character, Boolean> bdl) {
        bfq.m6567f(charSequence, "$this$filter");
        bfq.m6567f(bdl, "predicate");
        Appendable sb = new StringBuilder();
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            char charAt = charSequence.charAt(i);
            if (bdl.invoke(Character.valueOf(charAt)).booleanValue()) {
                sb.append(charAt);
            }
        }
        return (CharSequence) sb;
    }

    /* renamed from: f */
    public static final String m8323f(String str, bdl<? super Character, Boolean> bdl) {
        bfq.m6567f(str, "$this$filter");
        bfq.m6567f(bdl, "predicate");
        CharSequence charSequence = str;
        Appendable sb = new StringBuilder();
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            char charAt = charSequence.charAt(i);
            if (bdl.invoke(Character.valueOf(charAt)).booleanValue()) {
                sb.append(charAt);
            }
        }
        String sb2 = ((StringBuilder) sb).toString();
        bfq.m6554b(sb2, "filterTo(StringBuilder(), predicate).toString()");
        return sb2;
    }

    /* renamed from: a */
    public static final CharSequence m8266a(CharSequence charSequence, bdw<? super Integer, ? super Character, Boolean> bdw) {
        bfq.m6567f(charSequence, "$this$filterIndexed");
        bfq.m6567f(bdw, "predicate");
        Appendable sb = new StringBuilder();
        int i = 0;
        int i2 = 0;
        while (i < charSequence.length()) {
            char charAt = charSequence.charAt(i);
            int i3 = i2 + 1;
            if (bdw.mo2065a(Integer.valueOf(i2), Character.valueOf(charAt)).booleanValue()) {
                sb.append(charAt);
            }
            i++;
            i2 = i3;
        }
        return (CharSequence) sb;
    }

    /* renamed from: a */
    public static final String m8271a(String str, bdw<? super Integer, ? super Character, Boolean> bdw) {
        bfq.m6567f(str, "$this$filterIndexed");
        bfq.m6567f(bdw, "predicate");
        CharSequence charSequence = str;
        Appendable sb = new StringBuilder();
        int i = 0;
        int i2 = 0;
        while (i < charSequence.length()) {
            char charAt = charSequence.charAt(i);
            int i3 = i2 + 1;
            if (bdw.mo2065a(Integer.valueOf(i2), Character.valueOf(charAt)).booleanValue()) {
                sb.append(charAt);
            }
            i++;
            i2 = i3;
        }
        String sb2 = ((StringBuilder) sb).toString();
        bfq.m6554b(sb2, "filterIndexedTo(StringBu…(), predicate).toString()");
        return sb2;
    }

    /* renamed from: o */
    public static final CharSequence m8350o(CharSequence charSequence, bdl<? super Character, Boolean> bdl) {
        bfq.m6567f(charSequence, "$this$filterNot");
        bfq.m6567f(bdl, "predicate");
        Appendable sb = new StringBuilder();
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            if (!bdl.invoke(Character.valueOf(charAt)).booleanValue()) {
                sb.append(charAt);
            }
        }
        return (CharSequence) sb;
    }

    /* renamed from: g */
    public static final String m8327g(String str, bdl<? super Character, Boolean> bdl) {
        bfq.m6567f(str, "$this$filterNot");
        bfq.m6567f(bdl, "predicate");
        CharSequence charSequence = str;
        Appendable sb = new StringBuilder();
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            if (!bdl.invoke(Character.valueOf(charAt)).booleanValue()) {
                sb.append(charAt);
            }
        }
        String sb2 = ((StringBuilder) sb).toString();
        bfq.m6554b(sb2, "filterNotTo(StringBuilder(), predicate).toString()");
        return sb2;
    }

    /* renamed from: a */
    public static final <C extends Appendable> C m8264a(CharSequence charSequence, C c, bdl<? super Character, Boolean> bdl) {
        bfq.m6567f(charSequence, "$this$filterNotTo");
        bfq.m6567f(c, JsonKeyConstants.DESTINATION);
        bfq.m6567f(bdl, "predicate");
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            if (!bdl.invoke(Character.valueOf(charAt)).booleanValue()) {
                c.append(charAt);
            }
        }
        return c;
    }

    /* renamed from: b */
    public static final <C extends Appendable> C m8291b(CharSequence charSequence, C c, bdl<? super Character, Boolean> bdl) {
        bfq.m6567f(charSequence, "$this$filterTo");
        bfq.m6567f(c, JsonKeyConstants.DESTINATION);
        bfq.m6567f(bdl, "predicate");
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            char charAt = charSequence.charAt(i);
            if (bdl.invoke(Character.valueOf(charAt)).booleanValue()) {
                c.append(charAt);
            }
        }
        return c;
    }

    /* renamed from: d */
    public static final CharSequence m8310d(CharSequence charSequence, biq biq) {
        bfq.m6567f(charSequence, "$this$slice");
        bfq.m6567f(biq, "indices");
        if (biq.mo2595e()) {
            return "";
        }
        return boc.m8103a(charSequence, biq);
    }

    /* renamed from: b */
    public static final String m8295b(String str, biq biq) {
        bfq.m6567f(str, "$this$slice");
        bfq.m6567f(biq, "indices");
        if (biq.mo2595e()) {
            return "";
        }
        return boc.m8120a(str, biq);
    }

    /* renamed from: a */
    public static final CharSequence m8267a(CharSequence charSequence, Iterable<Integer> iterable) {
        bfq.m6567f(charSequence, "$this$slice");
        bfq.m6567f(iterable, "indices");
        int a = ato.m4625a(iterable, 10);
        if (a == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(a);
        for (Integer intValue : iterable) {
            sb.append(charSequence.charAt(intValue.intValue()));
        }
        return sb;
    }

    /* renamed from: a */
    private static final String m8272a(String str, Iterable<Integer> iterable) {
        if (str != null) {
            return boc.m8267a((CharSequence) str, iterable).toString();
        }
        throw new apx("null cannot be cast to non-null type kotlin.CharSequence");
    }

    /* renamed from: f */
    public static final CharSequence m8321f(CharSequence charSequence, int i) {
        bfq.m6567f(charSequence, "$this$take");
        if (i >= 0) {
            return charSequence.subSequence(0, biu.m7191d(i, charSequence.length()));
        }
        throw new IllegalArgumentException(("Requested character count " + i + " is less than zero.").toString());
    }

    /* renamed from: h */
    public static final String m8330h(String str, int i) {
        bfq.m6567f(str, "$this$take");
        if (i >= 0) {
            String substring = str.substring(0, biu.m7191d(i, str.length()));
            bfq.m6554b(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }
        throw new IllegalArgumentException(("Requested character count " + i + " is less than zero.").toString());
    }

    /* renamed from: g */
    public static final CharSequence m8325g(CharSequence charSequence, int i) {
        bfq.m6567f(charSequence, "$this$takeLast");
        if (i >= 0) {
            int length = charSequence.length();
            return charSequence.subSequence(length - biu.m7191d(i, length), length);
        }
        throw new IllegalArgumentException(("Requested character count " + i + " is less than zero.").toString());
    }

    /* renamed from: i */
    public static final String m8335i(String str, int i) {
        bfq.m6567f(str, "$this$takeLast");
        if (i >= 0) {
            int length = str.length();
            String substring = str.substring(length - biu.m7191d(i, length));
            bfq.m6554b(substring, "(this as java.lang.String).substring(startIndex)");
            return substring;
        }
        throw new IllegalArgumentException(("Requested character count " + i + " is less than zero.").toString());
    }

    /* renamed from: p */
    public static final CharSequence m8351p(CharSequence charSequence, bdl<? super Character, Boolean> bdl) {
        bfq.m6567f(charSequence, "$this$takeLastWhile");
        bfq.m6567f(bdl, "predicate");
        for (int g = boc.m8224g(charSequence); g >= 0; g--) {
            if (!bdl.invoke(Character.valueOf(charSequence.charAt(g))).booleanValue()) {
                return charSequence.subSequence(g + 1, charSequence.length());
            }
        }
        return charSequence.subSequence(0, charSequence.length());
    }

    /* renamed from: h */
    public static final String m8331h(String str, bdl<? super Character, Boolean> bdl) {
        bfq.m6567f(str, "$this$takeLastWhile");
        bfq.m6567f(bdl, "predicate");
        for (int g = boc.m8224g(str); g >= 0; g--) {
            if (!bdl.invoke(Character.valueOf(str.charAt(g))).booleanValue()) {
                String substring = str.substring(g + 1);
                bfq.m6554b(substring, "(this as java.lang.String).substring(startIndex)");
                return substring;
            }
        }
        return str;
    }

    /* renamed from: q */
    public static final CharSequence m8354q(CharSequence charSequence, bdl<? super Character, Boolean> bdl) {
        bfq.m6567f(charSequence, "$this$takeWhile");
        bfq.m6567f(bdl, "predicate");
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!bdl.invoke(Character.valueOf(charSequence.charAt(i))).booleanValue()) {
                return charSequence.subSequence(0, i);
            }
        }
        return charSequence.subSequence(0, charSequence.length());
    }

    /* renamed from: i */
    public static final String m8336i(String str, bdl<? super Character, Boolean> bdl) {
        bfq.m6567f(str, "$this$takeWhile");
        bfq.m6567f(bdl, "predicate");
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!bdl.invoke(Character.valueOf(str.charAt(i))).booleanValue()) {
                String substring = str.substring(0, i);
                bfq.m6554b(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                return substring;
            }
        }
        return str;
    }

    /* renamed from: q */
    public static final CharSequence m8353q(CharSequence charSequence) {
        bfq.m6567f(charSequence, "$this$reversed");
        StringBuilder reverse = new StringBuilder(charSequence).reverse();
        bfq.m6554b(reverse, "StringBuilder(this).reverse()");
        return reverse;
    }

    /* renamed from: n */
    private static final String m8348n(String str) {
        if (str != null) {
            return boc.m8353q(str).toString();
        }
        throw new apx("null cannot be cast to non-null type kotlin.CharSequence");
    }

    /* renamed from: r */
    public static final <K, V> Map<K, V> m8356r(CharSequence charSequence, bdl<? super Character, ? extends apc<? extends K, ? extends V>> bdl) {
        bfq.m6567f(charSequence, "$this$associate");
        bfq.m6567f(bdl, "transform");
        Map<K, V> linkedHashMap = new LinkedHashMap<>(biu.m7177c(auy.m4971a(charSequence.length()), 16));
        for (int i = 0; i < charSequence.length(); i++) {
            apc apc = (apc) bdl.invoke(Character.valueOf(charSequence.charAt(i)));
            linkedHashMap.put(apc.mo1544a(), apc.mo1545b());
        }
        return linkedHashMap;
    }

    /* renamed from: s */
    public static final <K> Map<K, Character> m8358s(CharSequence charSequence, bdl<? super Character, ? extends K> bdl) {
        bfq.m6567f(charSequence, "$this$associateBy");
        bfq.m6567f(bdl, "keySelector");
        Map<K, Character> linkedHashMap = new LinkedHashMap<>(biu.m7177c(auy.m4971a(charSequence.length()), 16));
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            linkedHashMap.put(bdl.invoke(Character.valueOf(charAt)), Character.valueOf(charAt));
        }
        return linkedHashMap;
    }

    /* renamed from: a */
    public static final <K, V> Map<K, V> m8282a(CharSequence charSequence, bdl<? super Character, ? extends K> bdl, bdl<? super Character, ? extends V> bdl2) {
        bfq.m6567f(charSequence, "$this$associateBy");
        bfq.m6567f(bdl, "keySelector");
        bfq.m6567f(bdl2, "valueTransform");
        Map<K, V> linkedHashMap = new LinkedHashMap<>(biu.m7177c(auy.m4971a(charSequence.length()), 16));
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            linkedHashMap.put(bdl.invoke(Character.valueOf(charAt)), bdl2.invoke(Character.valueOf(charAt)));
        }
        return linkedHashMap;
    }

    /* renamed from: a */
    public static final <K, M extends Map<? super K, ? super Character>> M m8283a(CharSequence charSequence, M m, bdl<? super Character, ? extends K> bdl) {
        bfq.m6567f(charSequence, "$this$associateByTo");
        bfq.m6567f(m, JsonKeyConstants.DESTINATION);
        bfq.m6567f(bdl, "keySelector");
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            m.put(bdl.invoke(Character.valueOf(charAt)), Character.valueOf(charAt));
        }
        return m;
    }

    /* renamed from: a */
    public static final <K, V, M extends Map<? super K, ? super V>> M m8284a(CharSequence charSequence, M m, bdl<? super Character, ? extends K> bdl, bdl<? super Character, ? extends V> bdl2) {
        bfq.m6567f(charSequence, "$this$associateByTo");
        bfq.m6567f(m, JsonKeyConstants.DESTINATION);
        bfq.m6567f(bdl, "keySelector");
        bfq.m6567f(bdl2, "valueTransform");
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            m.put(bdl.invoke(Character.valueOf(charAt)), bdl2.invoke(Character.valueOf(charAt)));
        }
        return m;
    }

    /* renamed from: b */
    public static final <K, V, M extends Map<? super K, ? super V>> M m8300b(CharSequence charSequence, M m, bdl<? super Character, ? extends apc<? extends K, ? extends V>> bdl) {
        bfq.m6567f(charSequence, "$this$associateTo");
        bfq.m6567f(m, JsonKeyConstants.DESTINATION);
        bfq.m6567f(bdl, "transform");
        for (int i = 0; i < charSequence.length(); i++) {
            apc apc = (apc) bdl.invoke(Character.valueOf(charSequence.charAt(i)));
            m.put(apc.mo1544a(), apc.mo1545b());
        }
        return m;
    }

    /* renamed from: t */
    public static final <V> Map<Character, V> m8360t(CharSequence charSequence, bdl<? super Character, ? extends V> bdl) {
        bfq.m6567f(charSequence, "$this$associateWith");
        bfq.m6567f(bdl, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(biu.m7177c(auy.m4971a(charSequence.length()), 16));
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            linkedHashMap.put(Character.valueOf(charAt), bdl.invoke(Character.valueOf(charAt)));
        }
        return linkedHashMap;
    }

    /* renamed from: c */
    public static final <V, M extends Map<? super Character, ? super V>> M m8306c(CharSequence charSequence, M m, bdl<? super Character, ? extends V> bdl) {
        bfq.m6567f(charSequence, "$this$associateWithTo");
        bfq.m6567f(m, JsonKeyConstants.DESTINATION);
        bfq.m6567f(bdl, "valueSelector");
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            m.put(Character.valueOf(charAt), bdl.invoke(Character.valueOf(charAt)));
        }
        return m;
    }

    /* renamed from: a */
    public static final <C extends Collection<? super Character>> C m8273a(CharSequence charSequence, C c) {
        bfq.m6567f(charSequence, "$this$toCollection");
        bfq.m6567f(c, JsonKeyConstants.DESTINATION);
        for (int i = 0; i < charSequence.length(); i++) {
            c.add(Character.valueOf(charSequence.charAt(i)));
        }
        return c;
    }

    /* renamed from: r */
    public static final HashSet<Character> m8355r(CharSequence charSequence) {
        bfq.m6567f(charSequence, "$this$toHashSet");
        return (HashSet) boc.m8273a(charSequence, new HashSet(auy.m4971a(charSequence.length())));
    }

    /* renamed from: s */
    public static final List<Character> m8357s(CharSequence charSequence) {
        bfq.m6567f(charSequence, "$this$toList");
        int length = charSequence.length();
        if (length == 0) {
            return ato.m4604a();
        }
        if (length != 1) {
            return boc.m8359t(charSequence);
        }
        return ato.m4586a(Character.valueOf(charSequence.charAt(0)));
    }

    /* renamed from: t */
    public static final List<Character> m8359t(CharSequence charSequence) {
        bfq.m6567f(charSequence, "$this$toMutableList");
        return (List) boc.m8273a(charSequence, new ArrayList(charSequence.length()));
    }

    /* renamed from: u */
    public static final Set<Character> m8362u(CharSequence charSequence) {
        bfq.m6567f(charSequence, "$this$toSet");
        int length = charSequence.length();
        if (length == 0) {
            return avk.m5092a();
        }
        if (length != 1) {
            return (Set) boc.m8273a(charSequence, new LinkedHashSet(auy.m4971a(charSequence.length())));
        }
        return avk.m5089a(Character.valueOf(charSequence.charAt(0)));
    }

    /* renamed from: u */
    public static final <R> List<R> m8361u(CharSequence charSequence, bdl<? super Character, ? extends Iterable<? extends R>> bdl) {
        bfq.m6567f(charSequence, "$this$flatMap");
        bfq.m6567f(bdl, "transform");
        Collection arrayList = new ArrayList();
        for (int i = 0; i < charSequence.length(); i++) {
            ato.m4652a(arrayList, (Iterable) bdl.invoke(Character.valueOf(charSequence.charAt(i))));
        }
        return (List) arrayList;
    }

    /* renamed from: a */
    public static final <R, C extends Collection<? super R>> C m8274a(CharSequence charSequence, C c, bdl<? super Character, ? extends Iterable<? extends R>> bdl) {
        bfq.m6567f(charSequence, "$this$flatMapTo");
        bfq.m6567f(c, JsonKeyConstants.DESTINATION);
        bfq.m6567f(bdl, "transform");
        for (int i = 0; i < charSequence.length(); i++) {
            ato.m4652a(c, (Iterable) bdl.invoke(Character.valueOf(charSequence.charAt(i))));
        }
        return c;
    }

    /* renamed from: v */
    public static final <K> Map<K, List<Character>> m8364v(CharSequence charSequence, bdl<? super Character, ? extends K> bdl) {
        bfq.m6567f(charSequence, "$this$groupBy");
        bfq.m6567f(bdl, "keySelector");
        Map<K, List<Character>> linkedHashMap = new LinkedHashMap<>();
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            Object invoke = bdl.invoke(Character.valueOf(charAt));
            List<Character> list = linkedHashMap.get(invoke);
            if (list == null) {
                list = new ArrayList<>();
                linkedHashMap.put(invoke, list);
            }
            list.add(Character.valueOf(charAt));
        }
        return linkedHashMap;
    }

    /* renamed from: b */
    public static final <K, V> Map<K, List<V>> m8299b(CharSequence charSequence, bdl<? super Character, ? extends K> bdl, bdl<? super Character, ? extends V> bdl2) {
        bfq.m6567f(charSequence, "$this$groupBy");
        bfq.m6567f(bdl, "keySelector");
        bfq.m6567f(bdl2, "valueTransform");
        Map<K, List<V>> linkedHashMap = new LinkedHashMap<>();
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            Object invoke = bdl.invoke(Character.valueOf(charAt));
            List<V> list = linkedHashMap.get(invoke);
            if (list == null) {
                list = new ArrayList<>();
                linkedHashMap.put(invoke, list);
            }
            list.add(bdl2.invoke(Character.valueOf(charAt)));
        }
        return linkedHashMap;
    }

    /* renamed from: d */
    public static final <K, M extends Map<? super K, List<Character>>> M m8313d(CharSequence charSequence, M m, bdl<? super Character, ? extends K> bdl) {
        bfq.m6567f(charSequence, "$this$groupByTo");
        bfq.m6567f(m, JsonKeyConstants.DESTINATION);
        bfq.m6567f(bdl, "keySelector");
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            Object invoke = bdl.invoke(Character.valueOf(charAt));
            Object obj = m.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                m.put(invoke, obj);
            }
            ((List) obj).add(Character.valueOf(charAt));
        }
        return m;
    }

    /* renamed from: b */
    public static final <K, V, M extends Map<? super K, List<V>>> M m8301b(CharSequence charSequence, M m, bdl<? super Character, ? extends K> bdl, bdl<? super Character, ? extends V> bdl2) {
        bfq.m6567f(charSequence, "$this$groupByTo");
        bfq.m6567f(m, JsonKeyConstants.DESTINATION);
        bfq.m6567f(bdl, "keySelector");
        bfq.m6567f(bdl2, "valueTransform");
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            Object invoke = bdl.invoke(Character.valueOf(charAt));
            Object obj = m.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                m.put(invoke, obj);
            }
            ((List) obj).add(bdl2.invoke(Character.valueOf(charAt)));
        }
        return m;
    }

    /* renamed from: w */
    public static final <K> aum<Character, K> m8365w(CharSequence charSequence, bdl<? super Character, ? extends K> bdl) {
        bfq.m6567f(charSequence, "$this$groupingBy");
        bfq.m6567f(bdl, "keySelector");
        return new boz(charSequence, bdl);
    }

    /* renamed from: x */
    public static final <R> List<R> m8368x(CharSequence charSequence, bdl<? super Character, ? extends R> bdl) {
        bfq.m6567f(charSequence, "$this$map");
        bfq.m6567f(bdl, "transform");
        Collection arrayList = new ArrayList(charSequence.length());
        for (int i = 0; i < charSequence.length(); i++) {
            arrayList.add(bdl.invoke(Character.valueOf(charSequence.charAt(i))));
        }
        return (List) arrayList;
    }

    /* renamed from: b */
    public static final <R> List<R> m8298b(CharSequence charSequence, bdw<? super Integer, ? super Character, ? extends R> bdw) {
        bfq.m6567f(charSequence, "$this$mapIndexed");
        bfq.m6567f(bdw, "transform");
        Collection arrayList = new ArrayList(charSequence.length());
        int i = 0;
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            char charAt = charSequence.charAt(i2);
            Integer valueOf = Integer.valueOf(i);
            i++;
            arrayList.add(bdw.mo2065a(valueOf, Character.valueOf(charAt)));
        }
        return (List) arrayList;
    }

    /* renamed from: c */
    public static final <R> List<R> m8305c(CharSequence charSequence, bdw<? super Integer, ? super Character, ? extends R> bdw) {
        bfq.m6567f(charSequence, "$this$mapIndexedNotNull");
        bfq.m6567f(bdw, "transform");
        Collection arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        while (i < charSequence.length()) {
            int i3 = i2 + 1;
            Object a = bdw.mo2065a(Integer.valueOf(i2), Character.valueOf(charSequence.charAt(i)));
            if (a != null) {
                arrayList.add(a);
            }
            i++;
            i2 = i3;
        }
        return (List) arrayList;
    }

    /* renamed from: b */
    public static final <R, C extends Collection<? super R>> C m8297b(CharSequence charSequence, C c, bdw<? super Integer, ? super Character, ? extends R> bdw) {
        bfq.m6567f(charSequence, "$this$mapIndexedTo");
        bfq.m6567f(c, JsonKeyConstants.DESTINATION);
        bfq.m6567f(bdw, "transform");
        int i = 0;
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            char charAt = charSequence.charAt(i2);
            Integer valueOf = Integer.valueOf(i);
            i++;
            c.add(bdw.mo2065a(valueOf, Character.valueOf(charAt)));
        }
        return c;
    }

    /* renamed from: y */
    public static final <R> List<R> m8370y(CharSequence charSequence, bdl<? super Character, ? extends R> bdl) {
        bfq.m6567f(charSequence, "$this$mapNotNull");
        bfq.m6567f(bdl, "transform");
        Collection arrayList = new ArrayList();
        for (int i = 0; i < charSequence.length(); i++) {
            Object invoke = bdl.invoke(Character.valueOf(charSequence.charAt(i)));
            if (invoke != null) {
                arrayList.add(invoke);
            }
        }
        return (List) arrayList;
    }

    /* renamed from: c */
    public static final <R, C extends Collection<? super R>> C m8304c(CharSequence charSequence, C c, bdl<? super Character, ? extends R> bdl) {
        bfq.m6567f(charSequence, "$this$mapTo");
        bfq.m6567f(c, JsonKeyConstants.DESTINATION);
        bfq.m6567f(bdl, "transform");
        for (int i = 0; i < charSequence.length(); i++) {
            c.add(bdl.invoke(Character.valueOf(charSequence.charAt(i))));
        }
        return c;
    }

    /* renamed from: v */
    public static final Iterable<auq<Character>> m8363v(CharSequence charSequence) {
        bfq.m6567f(charSequence, "$this$withIndex");
        return new aur<>(new bpd(charSequence));
    }

    /* renamed from: z */
    public static final boolean m8372z(CharSequence charSequence, bdl<? super Character, Boolean> bdl) {
        bfq.m6567f(charSequence, "$this$all");
        bfq.m6567f(bdl, "predicate");
        for (int i = 0; i < charSequence.length(); i++) {
            if (!bdl.invoke(Character.valueOf(charSequence.charAt(i))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: w */
    public static final boolean m8366w(CharSequence charSequence) {
        bfq.m6567f(charSequence, "$this$any");
        return !(charSequence.length() == 0);
    }

    /* renamed from: A */
    public static final boolean m8246A(CharSequence charSequence, bdl<? super Character, Boolean> bdl) {
        bfq.m6567f(charSequence, "$this$any");
        bfq.m6567f(bdl, "predicate");
        for (int i = 0; i < charSequence.length(); i++) {
            if (bdl.invoke(Character.valueOf(charSequence.charAt(i))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: E */
    private static final int m8253E(CharSequence charSequence) {
        return charSequence.length();
    }

    /* renamed from: B */
    public static final int m8247B(CharSequence charSequence, bdl<? super Character, Boolean> bdl) {
        bfq.m6567f(charSequence, "$this$count");
        bfq.m6567f(bdl, "predicate");
        int i = 0;
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            if (bdl.invoke(Character.valueOf(charSequence.charAt(i2))).booleanValue()) {
                i++;
            }
        }
        return i;
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [atakplugin.UASTool.bdw<? super R, ? super java.lang.Character, ? extends R>, atakplugin.UASTool.bdw, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <R> R m8269a(java.lang.CharSequence r2, R r3, atakplugin.UASTool.bdw<? super R, ? super java.lang.Character, ? extends R> r4) {
        /*
            java.lang.String r0 = "$this$fold"
            atakplugin.UASTool.bfq.m6567f(r2, r0)
            java.lang.String r0 = "operation"
            atakplugin.UASTool.bfq.m6567f(r4, r0)
            r0 = 0
        L_0x000b:
            int r1 = r2.length()
            if (r0 >= r1) goto L_0x0020
            char r1 = r2.charAt(r0)
            java.lang.Character r1 = java.lang.Character.valueOf(r1)
            java.lang.Object r3 = r4.mo2065a(r3, r1)
            int r0 = r0 + 1
            goto L_0x000b
        L_0x0020:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.bov.m8269a(java.lang.CharSequence, java.lang.Object, atakplugin.UASTool.bdw):java.lang.Object");
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [atakplugin.UASTool.bea, atakplugin.UASTool.bea<? super java.lang.Integer, ? super R, ? super java.lang.Character, ? extends R>, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <R> R m8270a(java.lang.CharSequence r4, R r5, atakplugin.UASTool.bea<? super java.lang.Integer, ? super R, ? super java.lang.Character, ? extends R> r6) {
        /*
            java.lang.String r0 = "$this$foldIndexed"
            atakplugin.UASTool.bfq.m6567f(r4, r0)
            java.lang.String r0 = "operation"
            atakplugin.UASTool.bfq.m6567f(r6, r0)
            r0 = 0
            r1 = 0
        L_0x000c:
            int r2 = r4.length()
            if (r0 >= r2) goto L_0x0027
            char r2 = r4.charAt(r0)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r1)
            int r1 = r1 + 1
            java.lang.Character r2 = java.lang.Character.valueOf(r2)
            java.lang.Object r5 = r6.mo2214a(r3, r5, r2)
            int r0 = r0 + 1
            goto L_0x000c
        L_0x0027:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.bov.m8270a(java.lang.CharSequence, java.lang.Object, atakplugin.UASTool.bea):java.lang.Object");
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [atakplugin.UASTool.bdw<? super java.lang.Character, ? super R, ? extends R>, atakplugin.UASTool.bdw, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <R> R m8293b(java.lang.CharSequence r2, R r3, atakplugin.UASTool.bdw<? super java.lang.Character, ? super R, ? extends R> r4) {
        /*
            java.lang.String r0 = "$this$foldRight"
            atakplugin.UASTool.bfq.m6567f(r2, r0)
            java.lang.String r0 = "operation"
            atakplugin.UASTool.bfq.m6567f(r4, r0)
            int r0 = atakplugin.UASTool.boc.m8224g(r2)
        L_0x000e:
            if (r0 < 0) goto L_0x0020
            int r1 = r0 + -1
            char r0 = r2.charAt(r0)
            java.lang.Character r0 = java.lang.Character.valueOf(r0)
            java.lang.Object r3 = r4.mo2065a(r0, r3)
            r0 = r1
            goto L_0x000e
        L_0x0020:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.bov.m8293b(java.lang.CharSequence, java.lang.Object, atakplugin.UASTool.bdw):java.lang.Object");
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [atakplugin.UASTool.bea, atakplugin.UASTool.bea<? super java.lang.Integer, ? super java.lang.Character, ? super R, ? extends R>, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <R> R m8294b(java.lang.CharSequence r3, R r4, atakplugin.UASTool.bea<? super java.lang.Integer, ? super java.lang.Character, ? super R, ? extends R> r5) {
        /*
            java.lang.String r0 = "$this$foldRightIndexed"
            atakplugin.UASTool.bfq.m6567f(r3, r0)
            java.lang.String r0 = "operation"
            atakplugin.UASTool.bfq.m6567f(r5, r0)
            int r0 = atakplugin.UASTool.boc.m8224g(r3)
        L_0x000e:
            if (r0 < 0) goto L_0x0023
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
            char r2 = r3.charAt(r0)
            java.lang.Character r2 = java.lang.Character.valueOf(r2)
            java.lang.Object r4 = r5.mo2214a(r1, r2, r4)
            int r0 = r0 + -1
            goto L_0x000e
        L_0x0023:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.bov.m8294b(java.lang.CharSequence, java.lang.Object, atakplugin.UASTool.bea):java.lang.Object");
    }

    /* renamed from: C */
    public static final void m8250C(CharSequence charSequence, bdl<? super Character, aqr> bdl) {
        bfq.m6567f(charSequence, "$this$forEach");
        bfq.m6567f(bdl, "action");
        for (int i = 0; i < charSequence.length(); i++) {
            bdl.invoke(Character.valueOf(charSequence.charAt(i)));
        }
    }

    /* renamed from: d */
    public static final void m8314d(CharSequence charSequence, bdw<? super Integer, ? super Character, aqr> bdw) {
        bfq.m6567f(charSequence, "$this$forEachIndexed");
        bfq.m6567f(bdw, "action");
        int i = 0;
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            char charAt = charSequence.charAt(i2);
            Integer valueOf = Integer.valueOf(i);
            i++;
            bdw.mo2065a(valueOf, Character.valueOf(charAt));
        }
    }

    /* renamed from: x */
    public static final Character m8367x(CharSequence charSequence) {
        bfq.m6567f(charSequence, "$this$max");
        int i = 1;
        if (charSequence.length() == 0) {
            return null;
        }
        char charAt = charSequence.charAt(0);
        int g = boc.m8224g(charSequence);
        if (1 <= g) {
            while (true) {
                char charAt2 = charSequence.charAt(i);
                if (charAt < charAt2) {
                    charAt = charAt2;
                }
                if (i == g) {
                    break;
                }
                i++;
            }
        }
        return Character.valueOf(charAt);
    }

    /* renamed from: D */
    public static final <R extends Comparable<? super R>> Character m8252D(CharSequence charSequence, bdl<? super Character, ? extends R> bdl) {
        bfq.m6567f(charSequence, "$this$maxBy");
        bfq.m6567f(bdl, "selector");
        int i = 1;
        if (charSequence.length() == 0) {
            return null;
        }
        char charAt = charSequence.charAt(0);
        int g = boc.m8224g(charSequence);
        if (g == 0) {
            return Character.valueOf(charAt);
        }
        Comparable comparable = (Comparable) bdl.invoke(Character.valueOf(charAt));
        if (1 <= g) {
            while (true) {
                char charAt2 = charSequence.charAt(i);
                Comparable comparable2 = (Comparable) bdl.invoke(Character.valueOf(charAt2));
                if (comparable.compareTo(comparable2) < 0) {
                    charAt = charAt2;
                    comparable = comparable2;
                }
                if (i == g) {
                    break;
                }
                i++;
            }
        }
        return Character.valueOf(charAt);
    }

    /* renamed from: a */
    public static final Character m8268a(CharSequence charSequence, Comparator<? super Character> comparator) {
        bfq.m6567f(charSequence, "$this$maxWith");
        bfq.m6567f(comparator, "comparator");
        int i = 1;
        if (charSequence.length() == 0) {
            return null;
        }
        char charAt = charSequence.charAt(0);
        int g = boc.m8224g(charSequence);
        if (1 <= g) {
            while (true) {
                char charAt2 = charSequence.charAt(i);
                if (comparator.compare(Character.valueOf(charAt), Character.valueOf(charAt2)) < 0) {
                    charAt = charAt2;
                }
                if (i == g) {
                    break;
                }
                i++;
            }
        }
        return Character.valueOf(charAt);
    }

    /* renamed from: y */
    public static final Character m8369y(CharSequence charSequence) {
        bfq.m6567f(charSequence, "$this$min");
        int i = 1;
        if (charSequence.length() == 0) {
            return null;
        }
        char charAt = charSequence.charAt(0);
        int g = boc.m8224g(charSequence);
        if (1 <= g) {
            while (true) {
                char charAt2 = charSequence.charAt(i);
                if (charAt > charAt2) {
                    charAt = charAt2;
                }
                if (i == g) {
                    break;
                }
                i++;
            }
        }
        return Character.valueOf(charAt);
    }

    /* renamed from: E */
    public static final <R extends Comparable<? super R>> Character m8254E(CharSequence charSequence, bdl<? super Character, ? extends R> bdl) {
        bfq.m6567f(charSequence, "$this$minBy");
        bfq.m6567f(bdl, "selector");
        int i = 1;
        if (charSequence.length() == 0) {
            return null;
        }
        char charAt = charSequence.charAt(0);
        int g = boc.m8224g(charSequence);
        if (g == 0) {
            return Character.valueOf(charAt);
        }
        Comparable comparable = (Comparable) bdl.invoke(Character.valueOf(charAt));
        if (1 <= g) {
            while (true) {
                char charAt2 = charSequence.charAt(i);
                Comparable comparable2 = (Comparable) bdl.invoke(Character.valueOf(charAt2));
                if (comparable.compareTo(comparable2) > 0) {
                    charAt = charAt2;
                    comparable = comparable2;
                }
                if (i == g) {
                    break;
                }
                i++;
            }
        }
        return Character.valueOf(charAt);
    }

    /* renamed from: b */
    public static final Character m8292b(CharSequence charSequence, Comparator<? super Character> comparator) {
        bfq.m6567f(charSequence, "$this$minWith");
        bfq.m6567f(comparator, "comparator");
        int i = 1;
        if (charSequence.length() == 0) {
            return null;
        }
        char charAt = charSequence.charAt(0);
        int g = boc.m8224g(charSequence);
        if (1 <= g) {
            while (true) {
                char charAt2 = charSequence.charAt(i);
                if (comparator.compare(Character.valueOf(charAt), Character.valueOf(charAt2)) > 0) {
                    charAt = charAt2;
                }
                if (i == g) {
                    break;
                }
                i++;
            }
        }
        return Character.valueOf(charAt);
    }

    /* renamed from: z */
    public static final boolean m8371z(CharSequence charSequence) {
        bfq.m6567f(charSequence, "$this$none");
        return charSequence.length() == 0;
    }

    /* renamed from: F */
    public static final boolean m8255F(CharSequence charSequence, bdl<? super Character, Boolean> bdl) {
        bfq.m6567f(charSequence, "$this$none");
        bfq.m6567f(bdl, "predicate");
        for (int i = 0; i < charSequence.length(); i++) {
            if (bdl.invoke(Character.valueOf(charSequence.charAt(i))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: G */
    public static final <S extends CharSequence> S m8256G(S s, bdl<? super Character, aqr> bdl) {
        bfq.m6567f(s, "$this$onEach");
        bfq.m6567f(bdl, "action");
        for (int i = 0; i < s.length(); i++) {
            bdl.invoke(Character.valueOf(s.charAt(i)));
        }
        return s;
    }

    /* renamed from: e */
    public static final char m8315e(CharSequence charSequence, bdw<? super Character, ? super Character, Character> bdw) {
        bfq.m6567f(charSequence, "$this$reduce");
        bfq.m6567f(bdw, "operation");
        int i = 1;
        if (!(charSequence.length() == 0)) {
            char charAt = charSequence.charAt(0);
            int g = boc.m8224g(charSequence);
            if (1 <= g) {
                while (true) {
                    charAt = bdw.mo2065a(Character.valueOf(charAt), Character.valueOf(charSequence.charAt(i))).charValue();
                    if (i == g) {
                        break;
                    }
                    i++;
                }
            }
            return charAt;
        }
        throw new UnsupportedOperationException("Empty char sequence can't be reduced.");
    }

    /* renamed from: a */
    public static final char m8262a(CharSequence charSequence, bea<? super Integer, ? super Character, ? super Character, Character> bea) {
        bfq.m6567f(charSequence, "$this$reduceIndexed");
        bfq.m6567f(bea, "operation");
        int i = 1;
        if (!(charSequence.length() == 0)) {
            char charAt = charSequence.charAt(0);
            int g = boc.m8224g(charSequence);
            if (1 <= g) {
                while (true) {
                    charAt = bea.mo2214a(Integer.valueOf(i), Character.valueOf(charAt), Character.valueOf(charSequence.charAt(i))).charValue();
                    if (i == g) {
                        break;
                    }
                    i++;
                }
            }
            return charAt;
        }
        throw new UnsupportedOperationException("Empty char sequence can't be reduced.");
    }

    /* renamed from: f */
    public static final char m8319f(CharSequence charSequence, bdw<? super Character, ? super Character, Character> bdw) {
        bfq.m6567f(charSequence, "$this$reduceRight");
        bfq.m6567f(bdw, "operation");
        int g = boc.m8224g(charSequence);
        if (g >= 0) {
            char charAt = charSequence.charAt(g);
            for (int i = g - 1; i >= 0; i--) {
                charAt = bdw.mo2065a(Character.valueOf(charSequence.charAt(i)), Character.valueOf(charAt)).charValue();
            }
            return charAt;
        }
        throw new UnsupportedOperationException("Empty char sequence can't be reduced.");
    }

    /* renamed from: b */
    public static final char m8285b(CharSequence charSequence, bea<? super Integer, ? super Character, ? super Character, Character> bea) {
        bfq.m6567f(charSequence, "$this$reduceRightIndexed");
        bfq.m6567f(bea, "operation");
        int g = boc.m8224g(charSequence);
        if (g >= 0) {
            char charAt = charSequence.charAt(g);
            for (int i = g - 1; i >= 0; i--) {
                charAt = bea.mo2214a(Integer.valueOf(i), Character.valueOf(charSequence.charAt(i)), Character.valueOf(charAt)).charValue();
            }
            return charAt;
        }
        throw new UnsupportedOperationException("Empty char sequence can't be reduced.");
    }

    /* renamed from: H */
    public static final int m8257H(CharSequence charSequence, bdl<? super Character, Integer> bdl) {
        bfq.m6567f(charSequence, "$this$sumBy");
        bfq.m6567f(bdl, "selector");
        int i = 0;
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            i += bdl.invoke(Character.valueOf(charSequence.charAt(i2))).intValue();
        }
        return i;
    }

    /* renamed from: I */
    public static final double m8258I(CharSequence charSequence, bdl<? super Character, Double> bdl) {
        bfq.m6567f(charSequence, "$this$sumByDouble");
        bfq.m6567f(bdl, "selector");
        double d = 0.0d;
        for (int i = 0; i < charSequence.length(); i++) {
            d += bdl.invoke(Character.valueOf(charSequence.charAt(i))).doubleValue();
        }
        return d;
    }

    /* renamed from: h */
    public static final List<String> m8332h(CharSequence charSequence, int i) {
        bfq.m6567f(charSequence, "$this$chunked");
        return boc.m8276a(charSequence, i, i, true);
    }

    /* renamed from: a */
    public static final <R> List<R> m8280a(CharSequence charSequence, int i, bdl<? super CharSequence, ? extends R> bdl) {
        bfq.m6567f(charSequence, "$this$chunked");
        bfq.m6567f(bdl, "transform");
        return boc.m8278a(charSequence, i, i, true, bdl);
    }

    /* renamed from: i */
    public static final bku<String> m8333i(CharSequence charSequence, int i) {
        bfq.m6567f(charSequence, "$this$chunkedSequence");
        return boc.m8290b(charSequence, i, boy.f3068a);
    }

    /* renamed from: b */
    public static final <R> bku<R> m8290b(CharSequence charSequence, int i, bdl<? super CharSequence, ? extends R> bdl) {
        bfq.m6567f(charSequence, "$this$chunkedSequence");
        bfq.m6567f(bdl, "transform");
        return boc.m8288b(charSequence, i, i, true, bdl);
    }

    /* renamed from: J */
    public static final apc<CharSequence, CharSequence> m8259J(CharSequence charSequence, bdl<? super Character, Boolean> bdl) {
        bfq.m6567f(charSequence, "$this$partition");
        bfq.m6567f(bdl, "predicate");
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            if (bdl.invoke(Character.valueOf(charAt)).booleanValue()) {
                sb.append(charAt);
            } else {
                sb2.append(charAt);
            }
        }
        return new apc<>(sb, sb2);
    }

    /* renamed from: j */
    public static final apc<String, String> m8338j(String str, bdl<? super Character, Boolean> bdl) {
        bfq.m6567f(str, "$this$partition");
        bfq.m6567f(bdl, "predicate");
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (bdl.invoke(Character.valueOf(charAt)).booleanValue()) {
                sb.append(charAt);
            } else {
                sb2.append(charAt);
            }
        }
        return new apc<>(sb.toString(), sb2.toString());
    }

    /* renamed from: a */
    public static /* synthetic */ List m8277a(CharSequence charSequence, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 1;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return boc.m8276a(charSequence, i, i2, z);
    }

    /* renamed from: a */
    public static final List<String> m8276a(CharSequence charSequence, int i, int i2, boolean z) {
        bfq.m6567f(charSequence, "$this$windowed");
        return boc.m8278a(charSequence, i, i2, z, bpa.f3071a);
    }

    /* renamed from: a */
    public static /* synthetic */ List m8279a(CharSequence charSequence, int i, int i2, boolean z, bdl bdl, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 1;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return boc.m8278a(charSequence, i, i2, z, bdl);
    }

    /* renamed from: a */
    public static final <R> List<R> m8278a(CharSequence charSequence, int i, int i2, boolean z, bdl<? super CharSequence, ? extends R> bdl) {
        bfq.m6567f(charSequence, "$this$windowed");
        bfq.m6567f(bdl, "transform");
        avp.m5117a(i, i2);
        int length = charSequence.length();
        int i3 = 0;
        ArrayList arrayList = new ArrayList((length / i2) + (length % i2 == 0 ? 0 : 1));
        while (i3 >= 0 && length > i3) {
            int i4 = i3 + i;
            if (i4 < 0 || i4 > length) {
                if (!z) {
                    break;
                }
                i4 = length;
            }
            arrayList.add(bdl.invoke(charSequence.subSequence(i3, i4)));
            i3 += i2;
        }
        return arrayList;
    }

    /* renamed from: b */
    public static /* synthetic */ bku m8287b(CharSequence charSequence, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 1;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return boc.m8286b(charSequence, i, i2, z);
    }

    /* renamed from: b */
    public static final bku<String> m8286b(CharSequence charSequence, int i, int i2, boolean z) {
        bfq.m6567f(charSequence, "$this$windowedSequence");
        return boc.m8288b(charSequence, i, i2, z, bpb.f3072a);
    }

    /* renamed from: b */
    public static /* synthetic */ bku m8289b(CharSequence charSequence, int i, int i2, boolean z, bdl bdl, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 1;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return boc.m8288b(charSequence, i, i2, z, bdl);
    }

    /* renamed from: b */
    public static final <R> bku<R> m8288b(CharSequence charSequence, int i, int i2, boolean z, bdl<? super CharSequence, ? extends R> bdl) {
        bfq.m6567f(charSequence, "$this$windowedSequence");
        bfq.m6567f(bdl, "transform");
        avp.m5117a(i, i2);
        return bkx.m7614u(ato.m4708J(biu.m7113a((bio) z ? boc.m8223f(charSequence) : biu.m7151b(0, (charSequence.length() - i) + 1), i2)), new bpc(charSequence, i, bdl));
    }

    /* renamed from: a */
    public static final <V> List<V> m8281a(CharSequence charSequence, CharSequence charSequence2, bdw<? super Character, ? super Character, ? extends V> bdw) {
        bfq.m6567f(charSequence, "$this$zip");
        bfq.m6567f(charSequence2, "other");
        bfq.m6567f(bdw, "transform");
        int min = Math.min(charSequence.length(), charSequence2.length());
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(bdw.mo2065a(Character.valueOf(charSequence.charAt(i)), Character.valueOf(charSequence2.charAt(i))));
        }
        return arrayList;
    }

    /* renamed from: g */
    public static final <R> List<R> m8328g(CharSequence charSequence, bdw<? super Character, ? super Character, ? extends R> bdw) {
        bfq.m6567f(charSequence, "$this$zipWithNext");
        bfq.m6567f(bdw, "transform");
        int length = charSequence.length() - 1;
        if (length < 1) {
            return ato.m4604a();
        }
        ArrayList arrayList = new ArrayList(length);
        int i = 0;
        while (i < length) {
            i++;
            arrayList.add(bdw.mo2065a(Character.valueOf(charSequence.charAt(i)), Character.valueOf(charSequence.charAt(i))));
        }
        return arrayList;
    }

    /* renamed from: B */
    public static final Iterable<Character> m8248B(CharSequence charSequence) {
        bfq.m6567f(charSequence, "$this$asIterable");
        if (charSequence instanceof String) {
            if (charSequence.length() == 0) {
                return ato.m4604a();
            }
        }
        return new bow(charSequence);
    }

    /* renamed from: C */
    public static final bku<Character> m8249C(CharSequence charSequence) {
        bfq.m6567f(charSequence, "$this$asSequence");
        if (charSequence instanceof String) {
            if (charSequence.length() == 0) {
                return bkx.m7468b();
            }
        }
        return new box(charSequence);
    }

    /* renamed from: K */
    private static final Character m8260K(CharSequence charSequence, bdl<? super Character, Boolean> bdl) {
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            if (bdl.invoke(Character.valueOf(charAt)).booleanValue()) {
                return Character.valueOf(charAt);
            }
        }
        return null;
    }

    /* renamed from: L */
    private static final Character m8261L(CharSequence charSequence, bdl<? super Character, Boolean> bdl) {
        char charAt;
        int length = charSequence.length();
        do {
            length--;
            if (length < 0) {
                return null;
            }
            charAt = charSequence.charAt(length);
        } while (!bdl.invoke(Character.valueOf(charAt)).booleanValue());
        return Character.valueOf(charAt);
    }

    /* renamed from: a */
    public static final <C extends Appendable> C m8265a(CharSequence charSequence, C c, bdw<? super Integer, ? super Character, Boolean> bdw) {
        bfq.m6567f(charSequence, "$this$filterIndexedTo");
        bfq.m6567f(c, JsonKeyConstants.DESTINATION);
        bfq.m6567f(bdw, "predicate");
        int i = 0;
        int i2 = 0;
        while (i < charSequence.length()) {
            char charAt = charSequence.charAt(i);
            int i3 = i2 + 1;
            if (bdw.mo2065a(Integer.valueOf(i2), Character.valueOf(charAt)).booleanValue()) {
                c.append(charAt);
            }
            i++;
            i2 = i3;
        }
        return c;
    }

    /* renamed from: a */
    public static final <R, C extends Collection<? super R>> C m8275a(CharSequence charSequence, C c, bdw<? super Integer, ? super Character, ? extends R> bdw) {
        bfq.m6567f(charSequence, "$this$mapIndexedNotNullTo");
        bfq.m6567f(c, JsonKeyConstants.DESTINATION);
        bfq.m6567f(bdw, "transform");
        int i = 0;
        int i2 = 0;
        while (i < charSequence.length()) {
            int i3 = i2 + 1;
            Object a = bdw.mo2065a(Integer.valueOf(i2), Character.valueOf(charSequence.charAt(i)));
            if (a != null) {
                c.add(a);
            }
            i++;
            i2 = i3;
        }
        return c;
    }

    /* renamed from: b */
    public static final <R, C extends Collection<? super R>> C m8296b(CharSequence charSequence, C c, bdl<? super Character, ? extends R> bdl) {
        bfq.m6567f(charSequence, "$this$mapNotNullTo");
        bfq.m6567f(c, JsonKeyConstants.DESTINATION);
        bfq.m6567f(bdl, "transform");
        for (int i = 0; i < charSequence.length(); i++) {
            Object invoke = bdl.invoke(Character.valueOf(charSequence.charAt(i)));
            if (invoke != null) {
                c.add(invoke);
            }
        }
        return c;
    }

    /* renamed from: d */
    public static final List<apc<Character, Character>> m8312d(CharSequence charSequence, CharSequence charSequence2) {
        bfq.m6567f(charSequence, "$this$zip");
        bfq.m6567f(charSequence2, "other");
        int min = Math.min(charSequence.length(), charSequence2.length());
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(apv.m2659a(Character.valueOf(charSequence.charAt(i)), Character.valueOf(charSequence2.charAt(i))));
        }
        return arrayList;
    }

    /* renamed from: A */
    public static final List<apc<Character, Character>> m8245A(CharSequence charSequence) {
        bfq.m6567f(charSequence, "$this$zipWithNext");
        int length = charSequence.length() - 1;
        if (length < 1) {
            return ato.m4604a();
        }
        ArrayList arrayList = new ArrayList(length);
        int i = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            i++;
            arrayList.add(apv.m2659a(Character.valueOf(charAt), Character.valueOf(charSequence.charAt(i))));
        }
        return arrayList;
    }
}

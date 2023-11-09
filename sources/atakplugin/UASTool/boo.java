package atakplugin.UASTool;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@aot(mo1534a = 5, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000|\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0019\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\u001a\u001c\u0010\t\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u001c\u0010\u000e\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u001f\u0010\u000f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\rH\u0002\u001a\u001f\u0010\u000f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\rH\u0002\u001a\u0015\u0010\u000f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\n\u001a\u001c\u0010\u0014\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u001c\u0010\u0014\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\r\u001a:\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017*\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001aE\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017*\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\rH\u0002¢\u0006\u0002\b\u001c\u001a:\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017*\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u0012\u0010\u001e\u001a\u00020\r*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0006\u001a4\u0010 \u001a\u0002H!\"\f\b\u0000\u0010\"*\u00020\u0002*\u0002H!\"\u0004\b\u0001\u0010!*\u0002H\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H!0$H\b¢\u0006\u0002\u0010%\u001a4\u0010&\u001a\u0002H!\"\f\b\u0000\u0010\"*\u00020\u0002*\u0002H!\"\u0004\b\u0001\u0010!*\u0002H\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H!0$H\b¢\u0006\u0002\u0010%\u001a&\u0010'\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a;\u0010'\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u001b\u001a\u00020\rH\u0002¢\u0006\u0002\b)\u001a&\u0010'\u001a\u00020\u0006*\u00020\u00022\u0006\u0010*\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a&\u0010+\u001a\u00020\u0006*\u00020\u00022\u0006\u0010,\u001a\u00020-2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a,\u0010+\u001a\u00020\u0006*\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a\r\u0010.\u001a\u00020\r*\u00020\u0002H\b\u001a\r\u0010/\u001a\u00020\r*\u00020\u0002H\b\u001a\r\u00100\u001a\u00020\r*\u00020\u0002H\b\u001a \u00101\u001a\u00020\r*\u0004\u0018\u00010\u0002H\b\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a \u00102\u001a\u00020\r*\u0004\u0018\u00010\u0002H\b\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a\r\u00103\u001a\u000204*\u00020\u0002H\u0002\u001a&\u00105\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a&\u00105\u001a\u00020\u0006*\u00020\u00022\u0006\u0010*\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a&\u00106\u001a\u00020\u0006*\u00020\u00022\u0006\u0010,\u001a\u00020-2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a,\u00106\u001a\u00020\u0006*\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u0010\u00107\u001a\b\u0012\u0004\u0012\u00020\n08*\u00020\u0002\u001a\u0010\u00109\u001a\b\u0012\u0004\u0012\u00020\n0:*\u00020\u0002\u001a\u0015\u0010;\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\f\u001a\u000f\u0010<\u001a\u00020\n*\u0004\u0018\u00010\nH\b\u001a\u001c\u0010=\u001a\u00020\u0002*\u00020\u00022\u0006\u0010>\u001a\u00020\u00062\b\b\u0002\u0010?\u001a\u00020\u0011\u001a\u001c\u0010=\u001a\u00020\n*\u00020\n2\u0006\u0010>\u001a\u00020\u00062\b\b\u0002\u0010?\u001a\u00020\u0011\u001a\u001c\u0010@\u001a\u00020\u0002*\u00020\u00022\u0006\u0010>\u001a\u00020\u00062\b\b\u0002\u0010?\u001a\u00020\u0011\u001a\u001c\u0010@\u001a\u00020\n*\u00020\n2\u0006\u0010>\u001a\u00020\u00062\b\b\u0002\u0010?\u001a\u00020\u0011\u001aG\u0010A\u001a\b\u0012\u0004\u0012\u00020\u000108*\u00020\u00022\u000e\u0010B\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0C2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010D\u001a\u00020\u0006H\u0002¢\u0006\u0004\bE\u0010F\u001a=\u0010A\u001a\b\u0012\u0004\u0012\u00020\u000108*\u00020\u00022\u0006\u0010B\u001a\u00020-2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010D\u001a\u00020\u0006H\u0002¢\u0006\u0002\bE\u001a4\u0010G\u001a\u00020\r*\u00020\u00022\u0006\u0010H\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010I\u001a\u00020\u00062\u0006\u0010>\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0000\u001a\u0012\u0010J\u001a\u00020\u0002*\u00020\u00022\u0006\u0010K\u001a\u00020\u0002\u001a\u0012\u0010J\u001a\u00020\n*\u00020\n2\u0006\u0010K\u001a\u00020\u0002\u001a\u001a\u0010L\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0006\u001a\u0012\u0010L\u001a\u00020\u0002*\u00020\u00022\u0006\u0010M\u001a\u00020\u0001\u001a\u001d\u0010L\u001a\u00020\n*\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0006H\b\u001a\u0015\u0010L\u001a\u00020\n*\u00020\n2\u0006\u0010M\u001a\u00020\u0001H\b\u001a\u0012\u0010N\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0012\u0010N\u001a\u00020\n*\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0012\u0010O\u001a\u00020\u0002*\u00020\u00022\u0006\u0010P\u001a\u00020\u0002\u001a\u001a\u0010O\u001a\u00020\u0002*\u00020\u00022\u0006\u0010K\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0012\u0010O\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u0002\u001a\u001a\u0010O\u001a\u00020\n*\u00020\n2\u0006\u0010K\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002\u001a+\u0010Q\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0014\b\b\u0010R\u001a\u000e\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020\u00020SH\b\u001a\u001d\u0010Q\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010U\u001a\u00020\nH\b\u001a$\u0010V\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a$\u0010V\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a$\u0010X\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a$\u0010X\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a$\u0010Y\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a$\u0010Y\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a$\u0010Z\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a$\u0010Z\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001d\u0010[\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010U\u001a\u00020\nH\b\u001a\"\u0010\\\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\u0006\u0010U\u001a\u00020\u0002\u001a\u001a\u0010\\\u001a\u00020\u0002*\u00020\u00022\u0006\u0010M\u001a\u00020\u00012\u0006\u0010U\u001a\u00020\u0002\u001a%\u0010\\\u001a\u00020\n*\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\u0006\u0010U\u001a\u00020\u0002H\b\u001a\u001d\u0010\\\u001a\u00020\n*\u00020\n2\u0006\u0010M\u001a\u00020\u00012\u0006\u0010U\u001a\u00020\u0002H\b\u001a=\u0010]\u001a\b\u0012\u0004\u0012\u00020\n0:*\u00020\u00022\u0012\u0010B\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0C\"\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010D\u001a\u00020\u0006¢\u0006\u0002\u0010^\u001a0\u0010]\u001a\b\u0012\u0004\u0012\u00020\n0:*\u00020\u00022\n\u0010B\u001a\u00020-\"\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010D\u001a\u00020\u0006\u001a/\u0010]\u001a\b\u0012\u0004\u0012\u00020\n0:*\u00020\u00022\u0006\u0010P\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010D\u001a\u00020\u0006H\u0002¢\u0006\u0002\b_\u001a%\u0010]\u001a\b\u0012\u0004\u0012\u00020\n0:*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010D\u001a\u00020\u0006H\b\u001a=\u0010`\u001a\b\u0012\u0004\u0012\u00020\n08*\u00020\u00022\u0012\u0010B\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0C\"\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010D\u001a\u00020\u0006¢\u0006\u0002\u0010a\u001a0\u0010`\u001a\b\u0012\u0004\u0012\u00020\n08*\u00020\u00022\n\u0010B\u001a\u00020-\"\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010D\u001a\u00020\u0006\u001a\u001c\u0010b\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u001c\u0010b\u001a\u00020\r*\u00020\u00022\u0006\u0010K\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\r\u001a$\u0010b\u001a\u00020\r*\u00020\u00022\u0006\u0010K\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u0012\u0010c\u001a\u00020\u0002*\u00020\u00022\u0006\u0010M\u001a\u00020\u0001\u001a\u001d\u0010c\u001a\u00020\u0002*\u00020\n2\u0006\u0010d\u001a\u00020\u00062\u0006\u0010e\u001a\u00020\u0006H\b\u001a\u001f\u0010f\u001a\u00020\n*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010(\u001a\u00020\u0006H\b\u001a\u0012\u0010f\u001a\u00020\n*\u00020\u00022\u0006\u0010M\u001a\u00020\u0001\u001a\u0012\u0010f\u001a\u00020\n*\u00020\n2\u0006\u0010M\u001a\u00020\u0001\u001a\u001c\u0010g\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001c\u0010g\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001c\u0010h\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001c\u0010h\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001c\u0010i\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001c\u0010i\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001c\u0010j\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001c\u0010j\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a\n\u0010k\u001a\u00020\u0002*\u00020\u0002\u001a!\u0010k\u001a\u00020\u0002*\u00020\u00022\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0SH\b\u001a\u0016\u0010k\u001a\u00020\u0002*\u00020\u00022\n\u0010,\u001a\u00020-\"\u00020\u0011\u001a\r\u0010k\u001a\u00020\n*\u00020\nH\b\u001a!\u0010k\u001a\u00020\n*\u00020\n2\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0SH\b\u001a\u0016\u0010k\u001a\u00020\n*\u00020\n2\n\u0010,\u001a\u00020-\"\u00020\u0011\u001a\n\u0010m\u001a\u00020\u0002*\u00020\u0002\u001a!\u0010m\u001a\u00020\u0002*\u00020\u00022\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0SH\b\u001a\u0016\u0010m\u001a\u00020\u0002*\u00020\u00022\n\u0010,\u001a\u00020-\"\u00020\u0011\u001a\r\u0010m\u001a\u00020\n*\u00020\nH\b\u001a!\u0010m\u001a\u00020\n*\u00020\n2\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0SH\b\u001a\u0016\u0010m\u001a\u00020\n*\u00020\n2\n\u0010,\u001a\u00020-\"\u00020\u0011\u001a\n\u0010n\u001a\u00020\u0002*\u00020\u0002\u001a!\u0010n\u001a\u00020\u0002*\u00020\u00022\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0SH\b\u001a\u0016\u0010n\u001a\u00020\u0002*\u00020\u00022\n\u0010,\u001a\u00020-\"\u00020\u0011\u001a\r\u0010n\u001a\u00020\n*\u00020\nH\b\u001a!\u0010n\u001a\u00020\n*\u00020\n2\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0SH\b\u001a\u0016\u0010n\u001a\u00020\n*\u00020\n2\n\u0010,\u001a\u00020-\"\u00020\u0011\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006o"}, mo1538e = {"indices", "Lkotlin/ranges/IntRange;", "", "getIndices", "(Ljava/lang/CharSequence;)Lkotlin/ranges/IntRange;", "lastIndex", "", "getLastIndex", "(Ljava/lang/CharSequence;)I", "commonPrefixWith", "", "other", "ignoreCase", "", "commonSuffixWith", "contains", "char", "", "regex", "Lkotlin/text/Regex;", "endsWith", "suffix", "findAnyOf", "Lkotlin/Pair;", "strings", "", "startIndex", "last", "findAnyOf$StringsKt__StringsKt", "findLastAnyOf", "hasSurrogatePairAt", "index", "ifBlank", "R", "C", "defaultValue", "Lkotlin/Function0;", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ifEmpty", "indexOf", "endIndex", "indexOf$StringsKt__StringsKt", "string", "indexOfAny", "chars", "", "isEmpty", "isNotBlank", "isNotEmpty", "isNullOrBlank", "isNullOrEmpty", "iterator", "Lkotlin/collections/CharIterator;", "lastIndexOf", "lastIndexOfAny", "lineSequence", "Lkotlin/sequences/Sequence;", "lines", "", "matches", "orEmpty", "padEnd", "length", "padChar", "padStart", "rangesDelimitedBy", "delimiters", "", "limit", "rangesDelimitedBy$StringsKt__StringsKt", "(Ljava/lang/CharSequence;[Ljava/lang/String;IZI)Lkotlin/sequences/Sequence;", "regionMatchesImpl", "thisOffset", "otherOffset", "removePrefix", "prefix", "removeRange", "range", "removeSuffix", "removeSurrounding", "delimiter", "replace", "transform", "Lkotlin/Function1;", "Lkotlin/text/MatchResult;", "replacement", "replaceAfter", "missingDelimiterValue", "replaceAfterLast", "replaceBefore", "replaceBeforeLast", "replaceFirst", "replaceRange", "split", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Ljava/util/List;", "split$StringsKt__StringsKt", "splitToSequence", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Lkotlin/sequences/Sequence;", "startsWith", "subSequence", "start", "end", "substring", "substringAfter", "substringAfterLast", "substringBefore", "substringBeforeLast", "trim", "predicate", "trimEnd", "trimStart", "kotlin-stdlib"}, mo1539f = "kotlin/text/StringsKt", mo1541h = 1)
class boo extends bon {
    /* renamed from: q */
    private static final String m8235q(String str) {
        return str != null ? str : "";
    }

    /* renamed from: a */
    public static final CharSequence m8102a(CharSequence charSequence, bdl<? super Character, Boolean> bdl) {
        bfq.m6567f(charSequence, "$this$trim");
        bfq.m6567f(bdl, "predicate");
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean booleanValue = bdl.invoke(Character.valueOf(charSequence.charAt(!z ? i : length))).booleanValue();
            if (!z) {
                if (!booleanValue) {
                    z = true;
                } else {
                    i++;
                }
            } else if (!booleanValue) {
                break;
            } else {
                length--;
            }
        }
        return charSequence.subSequence(i, length + 1);
    }

    /* renamed from: a */
    public static final String m8119a(String str, bdl<? super Character, Boolean> bdl) {
        bfq.m6567f(str, "$this$trim");
        bfq.m6567f(bdl, "predicate");
        CharSequence charSequence = str;
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean booleanValue = bdl.invoke(Character.valueOf(charSequence.charAt(!z ? i : length))).booleanValue();
            if (!z) {
                if (!booleanValue) {
                    z = true;
                } else {
                    i++;
                }
            } else if (!booleanValue) {
                break;
            } else {
                length--;
            }
        }
        return charSequence.subSequence(i, length + 1).toString();
    }

    /* renamed from: b */
    public static final CharSequence m8149b(CharSequence charSequence, bdl<? super Character, Boolean> bdl) {
        bfq.m6567f(charSequence, "$this$trimStart");
        bfq.m6567f(bdl, "predicate");
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!bdl.invoke(Character.valueOf(charSequence.charAt(i))).booleanValue()) {
                return charSequence.subSequence(i, charSequence.length());
            }
        }
        return "";
    }

    /* renamed from: b */
    public static final String m8163b(String str, bdl<? super Character, Boolean> bdl) {
        CharSequence charSequence;
        bfq.m6567f(str, "$this$trimStart");
        bfq.m6567f(bdl, "predicate");
        CharSequence charSequence2 = str;
        int length = charSequence2.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            } else if (!bdl.invoke(Character.valueOf(charSequence2.charAt(i))).booleanValue()) {
                charSequence = charSequence2.subSequence(i, charSequence2.length());
                break;
            } else {
                i++;
            }
        }
        return charSequence.toString();
    }

    /* renamed from: c */
    public static final CharSequence m8185c(CharSequence charSequence, bdl<? super Character, Boolean> bdl) {
        bfq.m6567f(charSequence, "$this$trimEnd");
        bfq.m6567f(bdl, "predicate");
        int length = charSequence.length();
        do {
            length--;
            if (length < 0) {
                return "";
            }
        } while (bdl.invoke(Character.valueOf(charSequence.charAt(length))).booleanValue());
        return charSequence.subSequence(0, length + 1);
    }

    /* renamed from: c */
    public static final String m8196c(String str, bdl<? super Character, Boolean> bdl) {
        CharSequence charSequence;
        bfq.m6567f(str, "$this$trimEnd");
        bfq.m6567f(bdl, "predicate");
        CharSequence charSequence2 = str;
        int length = charSequence2.length();
        while (true) {
            length--;
            if (length >= 0) {
                if (!bdl.invoke(Character.valueOf(charSequence2.charAt(length))).booleanValue()) {
                    charSequence = charSequence2.subSequence(0, length + 1);
                    break;
                }
            } else {
                break;
            }
        }
        return charSequence.toString();
    }

    /* renamed from: n */
    private static final String m8231n(String str) {
        if (str != null) {
            return boc.m8146b(str).toString();
        }
        throw new apx("null cannot be cast to non-null type kotlin.CharSequence");
    }

    /* renamed from: o */
    private static final String m8233o(String str) {
        if (str != null) {
            return boc.m8184c(str).toString();
        }
        throw new apx("null cannot be cast to non-null type kotlin.CharSequence");
    }

    /* renamed from: p */
    private static final String m8234p(String str) {
        if (str != null) {
            return boc.m8207d(str).toString();
        }
        throw new apx("null cannot be cast to non-null type kotlin.CharSequence");
    }

    /* renamed from: a */
    public static /* synthetic */ CharSequence m8099a(CharSequence charSequence, int i, char c, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            c = ' ';
        }
        return boc.m8098a(charSequence, i, c);
    }

    /* renamed from: a */
    public static final CharSequence m8098a(CharSequence charSequence, int i, char c) {
        bfq.m6567f(charSequence, "$this$padStart");
        if (i < 0) {
            throw new IllegalArgumentException("Desired length " + i + " is less than zero.");
        } else if (i <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        } else {
            StringBuilder sb = new StringBuilder(i);
            int length = i - charSequence.length();
            int i2 = 1;
            if (1 <= length) {
                while (true) {
                    sb.append(c);
                    if (i2 == length) {
                        break;
                    }
                    i2++;
                }
            }
            sb.append(charSequence);
            return sb;
        }
    }

    /* renamed from: a */
    public static /* synthetic */ String m8117a(String str, int i, char c, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            c = ' ';
        }
        return boc.m8116a(str, i, c);
    }

    /* renamed from: a */
    public static final String m8116a(String str, int i, char c) {
        bfq.m6567f(str, "$this$padStart");
        return boc.m8098a((CharSequence) str, i, c).toString();
    }

    /* renamed from: b */
    public static /* synthetic */ CharSequence m8148b(CharSequence charSequence, int i, char c, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            c = ' ';
        }
        return boc.m8147b(charSequence, i, c);
    }

    /* renamed from: b */
    public static final CharSequence m8147b(CharSequence charSequence, int i, char c) {
        bfq.m6567f(charSequence, "$this$padEnd");
        if (i < 0) {
            throw new IllegalArgumentException("Desired length " + i + " is less than zero.");
        } else if (i <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        } else {
            StringBuilder sb = new StringBuilder(i);
            sb.append(charSequence);
            int length = i - charSequence.length();
            int i2 = 1;
            if (1 <= length) {
                while (true) {
                    sb.append(c);
                    if (i2 == length) {
                        break;
                    }
                    i2++;
                }
            }
            return sb;
        }
    }

    /* renamed from: b */
    public static /* synthetic */ String m8162b(String str, int i, char c, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            c = ' ';
        }
        return boc.m8161b(str, i, c);
    }

    /* renamed from: b */
    public static final String m8161b(String str, int i, char c) {
        bfq.m6567f(str, "$this$padEnd");
        return boc.m8147b((CharSequence) str, i, c).toString();
    }

    /* renamed from: j */
    private static final boolean m8227j(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    /* renamed from: k */
    private static final boolean m8228k(CharSequence charSequence) {
        return charSequence.length() == 0;
    }

    /* renamed from: l */
    private static final boolean m8229l(CharSequence charSequence) {
        return charSequence.length() > 0;
    }

    /* renamed from: m */
    private static final boolean m8230m(CharSequence charSequence) {
        return !boc.m8027a(charSequence);
    }

    /* renamed from: n */
    private static final boolean m8232n(CharSequence charSequence) {
        return charSequence == null || boc.m8027a(charSequence);
    }

    /* renamed from: e */
    public static final atn m8218e(CharSequence charSequence) {
        bfq.m6567f(charSequence, "$this$iterator");
        return new bop(charSequence);
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [R, C, java.lang.CharSequence] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final <C extends java.lang.CharSequence & R, R> R m8108a(C r1, atakplugin.UASTool.bdk<? extends R> r2) {
        /*
            int r0 = r1.length()
            if (r0 != 0) goto L_0x0008
            r0 = 1
            goto L_0x0009
        L_0x0008:
            r0 = 0
        L_0x0009:
            if (r0 == 0) goto L_0x000f
            java.lang.Object r1 = r2.invoke()
        L_0x000f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.boo.m8108a(java.lang.CharSequence, atakplugin.UASTool.bdk):java.lang.Object");
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [R, C, java.lang.CharSequence] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final <C extends java.lang.CharSequence & R, R> R m8153b(C r1, atakplugin.UASTool.bdk<? extends R> r2) {
        /*
            boolean r0 = atakplugin.UASTool.boc.m8027a((java.lang.CharSequence) r1)
            if (r0 == 0) goto L_0x000a
            java.lang.Object r1 = r2.invoke()
        L_0x000a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.boo.m8153b(java.lang.CharSequence, atakplugin.UASTool.bdk):java.lang.Object");
    }

    /* renamed from: f */
    public static final biq m8223f(CharSequence charSequence) {
        bfq.m6567f(charSequence, "$this$indices");
        return new biq(0, charSequence.length() - 1);
    }

    /* renamed from: g */
    public static final int m8224g(CharSequence charSequence) {
        bfq.m6567f(charSequence, "$this$lastIndex");
        return charSequence.length() - 1;
    }

    /* renamed from: b */
    public static final boolean m8177b(CharSequence charSequence, int i) {
        bfq.m6567f(charSequence, "$this$hasSurrogatePairAt");
        int length = charSequence.length() - 2;
        if (i >= 0 && length >= i && Character.isHighSurrogate(charSequence.charAt(i)) && Character.isLowSurrogate(charSequence.charAt(i + 1))) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public static final String m8120a(String str, biq biq) {
        bfq.m6567f(str, "$this$substring");
        bfq.m6567f(biq, "range");
        String substring = str.substring(biq.mo2569g().intValue(), biq.mo2571i().intValue() + 1);
        bfq.m6554b(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    /* renamed from: a */
    public static final CharSequence m8103a(CharSequence charSequence, biq biq) {
        bfq.m6567f(charSequence, "$this$subSequence");
        bfq.m6567f(biq, "range");
        return charSequence.subSequence(biq.mo2569g().intValue(), biq.mo2571i().intValue() + 1);
    }

    @anx(mo1516a = "Use parameters named startIndex and endIndex.", mo1517b = @C0081api(mo1552a = "subSequence(startIndex = start, endIndex = end)", mo1553b = {}))
    /* renamed from: b */
    private static final CharSequence m8152b(String str, int i, int i2) {
        return str.subSequence(i, i2);
    }

    /* renamed from: a */
    static /* synthetic */ String m8109a(CharSequence charSequence, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = charSequence.length();
        }
        return charSequence.subSequence(i, i2).toString();
    }

    /* renamed from: b */
    private static final String m8154b(CharSequence charSequence, int i, int i2) {
        return charSequence.subSequence(i, i2).toString();
    }

    /* renamed from: b */
    public static final String m8155b(CharSequence charSequence, biq biq) {
        bfq.m6567f(charSequence, "$this$substring");
        bfq.m6567f(biq, "range");
        return charSequence.subSequence(biq.mo2569g().intValue(), biq.mo2571i().intValue() + 1).toString();
    }

    /* renamed from: a */
    public static /* synthetic */ String m8113a(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return boc.m8112a(str, c, str2);
    }

    /* renamed from: a */
    public static final String m8112a(String str, char c, String str2) {
        bfq.m6567f(str, "$this$substringBefore");
        bfq.m6567f(str2, "missingDelimiterValue");
        int a = boc.m8080a((CharSequence) str, c, 0, false, 6, (Object) null);
        if (a == -1) {
            return str2;
        }
        String substring = str.substring(0, a);
        bfq.m6554b(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    /* renamed from: b */
    public static /* synthetic */ String m8167b(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return boc.m8166b(str, str2, str3);
    }

    /* renamed from: b */
    public static final String m8166b(String str, String str2, String str3) {
        bfq.m6567f(str, "$this$substringBefore");
        bfq.m6567f(str2, "delimiter");
        bfq.m6567f(str3, "missingDelimiterValue");
        int a = boc.m8084a((CharSequence) str, str2, 0, false, 6, (Object) null);
        if (a == -1) {
            return str3;
        }
        String substring = str.substring(0, a);
        bfq.m6554b(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    /* renamed from: b */
    public static /* synthetic */ String m8158b(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return boc.m8157b(str, c, str2);
    }

    /* renamed from: b */
    public static final String m8157b(String str, char c, String str2) {
        bfq.m6567f(str, "$this$substringAfter");
        bfq.m6567f(str2, "missingDelimiterValue");
        int a = boc.m8080a((CharSequence) str, c, 0, false, 6, (Object) null);
        if (a == -1) {
            return str2;
        }
        String substring = str.substring(a + 1, str.length());
        bfq.m6554b(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    /* renamed from: c */
    public static /* synthetic */ String m8199c(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return boc.m8198c(str, str2, str3);
    }

    /* renamed from: c */
    public static final String m8198c(String str, String str2, String str3) {
        bfq.m6567f(str, "$this$substringAfter");
        bfq.m6567f(str2, "delimiter");
        bfq.m6567f(str3, "missingDelimiterValue");
        int a = boc.m8084a((CharSequence) str, str2, 0, false, 6, (Object) null);
        if (a == -1) {
            return str3;
        }
        String substring = str.substring(a + str2.length(), str.length());
        bfq.m6554b(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    /* renamed from: c */
    public static /* synthetic */ String m8192c(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return boc.m8191c(str, c, str2);
    }

    /* renamed from: c */
    public static final String m8191c(String str, char c, String str2) {
        bfq.m6567f(str, "$this$substringBeforeLast");
        bfq.m6567f(str2, "missingDelimiterValue");
        int b = boc.m8138b((CharSequence) str, c, 0, false, 6, (Object) null);
        if (b == -1) {
            return str2;
        }
        String substring = str.substring(0, b);
        bfq.m6554b(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    /* renamed from: d */
    public static /* synthetic */ String m8215d(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return boc.m8214d(str, str2, str3);
    }

    /* renamed from: d */
    public static final String m8214d(String str, String str2, String str3) {
        bfq.m6567f(str, "$this$substringBeforeLast");
        bfq.m6567f(str2, "delimiter");
        bfq.m6567f(str3, "missingDelimiterValue");
        int b = boc.m8140b((CharSequence) str, str2, 0, false, 6, (Object) null);
        if (b == -1) {
            return str3;
        }
        String substring = str.substring(0, b);
        bfq.m6554b(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    /* renamed from: d */
    public static /* synthetic */ String m8211d(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return boc.m8210d(str, c, str2);
    }

    /* renamed from: d */
    public static final String m8210d(String str, char c, String str2) {
        bfq.m6567f(str, "$this$substringAfterLast");
        bfq.m6567f(str2, "missingDelimiterValue");
        int b = boc.m8138b((CharSequence) str, c, 0, false, 6, (Object) null);
        if (b == -1) {
            return str2;
        }
        String substring = str.substring(b + 1, str.length());
        bfq.m6554b(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    /* renamed from: e */
    public static /* synthetic */ String m8220e(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return boc.m8219e(str, str2, str3);
    }

    /* renamed from: e */
    public static final String m8219e(String str, String str2, String str3) {
        bfq.m6567f(str, "$this$substringAfterLast");
        bfq.m6567f(str2, "delimiter");
        bfq.m6567f(str3, "missingDelimiterValue");
        int b = boc.m8140b((CharSequence) str, str2, 0, false, 6, (Object) null);
        if (b == -1) {
            return str3;
        }
        String substring = str.substring(b + str2.length(), str.length());
        bfq.m6554b(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    /* renamed from: a */
    public static final CharSequence m8101a(CharSequence charSequence, int i, int i2, CharSequence charSequence2) {
        bfq.m6567f(charSequence, "$this$replaceRange");
        bfq.m6567f(charSequence2, "replacement");
        if (i2 >= i) {
            StringBuilder sb = new StringBuilder();
            sb.append(charSequence, 0, i);
            sb.append(charSequence2);
            sb.append(charSequence, i2, charSequence.length());
            return sb;
        }
        throw new IndexOutOfBoundsException("End index (" + i2 + ") is less than start index (" + i + ").");
    }

    /* renamed from: a */
    private static final String m8118a(String str, int i, int i2, CharSequence charSequence) {
        if (str != null) {
            return boc.m8101a((CharSequence) str, i, i2, charSequence).toString();
        }
        throw new apx("null cannot be cast to non-null type kotlin.CharSequence");
    }

    /* renamed from: a */
    public static final CharSequence m8104a(CharSequence charSequence, biq biq, CharSequence charSequence2) {
        bfq.m6567f(charSequence, "$this$replaceRange");
        bfq.m6567f(biq, "range");
        bfq.m6567f(charSequence2, "replacement");
        return boc.m8101a(charSequence, biq.mo2569g().intValue(), biq.mo2571i().intValue() + 1, charSequence2);
    }

    /* renamed from: a */
    private static final String m8121a(String str, biq biq, CharSequence charSequence) {
        if (str != null) {
            return boc.m8104a((CharSequence) str, biq, charSequence).toString();
        }
        throw new apx("null cannot be cast to non-null type kotlin.CharSequence");
    }

    /* renamed from: a */
    public static final CharSequence m8100a(CharSequence charSequence, int i, int i2) {
        bfq.m6567f(charSequence, "$this$removeRange");
        if (i2 < i) {
            throw new IndexOutOfBoundsException("End index (" + i2 + ") is less than start index (" + i + ").");
        } else if (i2 == i) {
            return charSequence.subSequence(0, charSequence.length());
        } else {
            StringBuilder sb = new StringBuilder(charSequence.length() - (i2 - i));
            sb.append(charSequence, 0, i);
            sb.append(charSequence, i2, charSequence.length());
            return sb;
        }
    }

    /* renamed from: c */
    private static final String m8195c(String str, int i, int i2) {
        if (str != null) {
            return boc.m8100a((CharSequence) str, i, i2).toString();
        }
        throw new apx("null cannot be cast to non-null type kotlin.CharSequence");
    }

    /* renamed from: c */
    public static final CharSequence m8186c(CharSequence charSequence, biq biq) {
        bfq.m6567f(charSequence, "$this$removeRange");
        bfq.m6567f(biq, "range");
        return boc.m8100a(charSequence, biq.mo2569g().intValue(), biq.mo2571i().intValue() + 1);
    }

    /* renamed from: b */
    private static final String m8164b(String str, biq biq) {
        if (str != null) {
            return boc.m8186c((CharSequence) str, biq).toString();
        }
        throw new apx("null cannot be cast to non-null type kotlin.CharSequence");
    }

    /* renamed from: a */
    public static final CharSequence m8105a(CharSequence charSequence, CharSequence charSequence2) {
        bfq.m6567f(charSequence, "$this$removePrefix");
        bfq.m6567f(charSequence2, "prefix");
        if (boc.m8136a(charSequence, charSequence2, false, 2, (Object) null)) {
            return charSequence.subSequence(charSequence2.length(), charSequence.length());
        }
        return charSequence.subSequence(0, charSequence.length());
    }

    /* renamed from: a */
    public static final String m8122a(String str, CharSequence charSequence) {
        bfq.m6567f(str, "$this$removePrefix");
        bfq.m6567f(charSequence, "prefix");
        if (!boc.m8136a((CharSequence) str, charSequence, false, 2, (Object) null)) {
            return str;
        }
        String substring = str.substring(charSequence.length());
        bfq.m6554b(substring, "(this as java.lang.String).substring(startIndex)");
        return substring;
    }

    /* renamed from: b */
    public static final CharSequence m8150b(CharSequence charSequence, CharSequence charSequence2) {
        bfq.m6567f(charSequence, "$this$removeSuffix");
        bfq.m6567f(charSequence2, "suffix");
        if (boc.m8181b(charSequence, charSequence2, false, 2, (Object) null)) {
            return charSequence.subSequence(0, charSequence.length() - charSequence2.length());
        }
        return charSequence.subSequence(0, charSequence.length());
    }

    /* renamed from: b */
    public static final String m8165b(String str, CharSequence charSequence) {
        bfq.m6567f(str, "$this$removeSuffix");
        bfq.m6567f(charSequence, "suffix");
        if (!boc.m8181b((CharSequence) str, charSequence, false, 2, (Object) null)) {
            return str;
        }
        String substring = str.substring(0, str.length() - charSequence.length());
        bfq.m6554b(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    /* renamed from: a */
    public static final CharSequence m8106a(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        bfq.m6567f(charSequence, "$this$removeSurrounding");
        bfq.m6567f(charSequence2, "prefix");
        bfq.m6567f(charSequence3, "suffix");
        if (charSequence.length() < charSequence2.length() + charSequence3.length() || !boc.m8136a(charSequence, charSequence2, false, 2, (Object) null) || !boc.m8181b(charSequence, charSequence3, false, 2, (Object) null)) {
            return charSequence.subSequence(0, charSequence.length());
        }
        return charSequence.subSequence(charSequence2.length(), charSequence.length() - charSequence3.length());
    }

    /* renamed from: a */
    public static final String m8123a(String str, CharSequence charSequence, CharSequence charSequence2) {
        bfq.m6567f(str, "$this$removeSurrounding");
        bfq.m6567f(charSequence, "prefix");
        bfq.m6567f(charSequence2, "suffix");
        if (str.length() < charSequence.length() + charSequence2.length()) {
            return str;
        }
        CharSequence charSequence3 = str;
        if (!boc.m8136a(charSequence3, charSequence, false, 2, (Object) null) || !boc.m8181b(charSequence3, charSequence2, false, 2, (Object) null)) {
            return str;
        }
        String substring = str.substring(charSequence.length(), str.length() - charSequence2.length());
        bfq.m6554b(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    /* renamed from: c */
    public static final CharSequence m8187c(CharSequence charSequence, CharSequence charSequence2) {
        bfq.m6567f(charSequence, "$this$removeSurrounding");
        bfq.m6567f(charSequence2, "delimiter");
        return boc.m8106a(charSequence, charSequence2, charSequence2);
    }

    /* renamed from: c */
    public static final String m8197c(String str, CharSequence charSequence) {
        bfq.m6567f(str, "$this$removeSurrounding");
        bfq.m6567f(charSequence, "delimiter");
        return boc.m8123a(str, charSequence, charSequence);
    }

    /* renamed from: a */
    public static /* synthetic */ String m8115a(String str, char c, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = str;
        }
        return boc.m8114a(str, c, str2, str3);
    }

    /* renamed from: a */
    public static final String m8114a(String str, char c, String str2, String str3) {
        bfq.m6567f(str, "$this$replaceBefore");
        bfq.m6567f(str2, "replacement");
        bfq.m6567f(str3, "missingDelimiterValue");
        CharSequence charSequence = str;
        int a = boc.m8080a(charSequence, c, 0, false, 6, (Object) null);
        return a == -1 ? str3 : boc.m8101a(charSequence, 0, a, (CharSequence) str2).toString();
    }

    /* renamed from: a */
    public static /* synthetic */ String m8125a(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str4 = str;
        }
        return boc.m8124a(str, str2, str3, str4);
    }

    /* renamed from: a */
    public static final String m8124a(String str, String str2, String str3, String str4) {
        bfq.m6567f(str, "$this$replaceBefore");
        bfq.m6567f(str2, "delimiter");
        bfq.m6567f(str3, "replacement");
        bfq.m6567f(str4, "missingDelimiterValue");
        CharSequence charSequence = str;
        int a = boc.m8084a(charSequence, str2, 0, false, 6, (Object) null);
        return a == -1 ? str4 : boc.m8101a(charSequence, 0, a, (CharSequence) str3).toString();
    }

    /* renamed from: b */
    public static /* synthetic */ String m8160b(String str, char c, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = str;
        }
        return boc.m8159b(str, c, str2, str3);
    }

    /* renamed from: b */
    public static final String m8159b(String str, char c, String str2, String str3) {
        bfq.m6567f(str, "$this$replaceAfter");
        bfq.m6567f(str2, "replacement");
        bfq.m6567f(str3, "missingDelimiterValue");
        CharSequence charSequence = str;
        int a = boc.m8080a(charSequence, c, 0, false, 6, (Object) null);
        return a == -1 ? str3 : boc.m8101a(charSequence, a + 1, str.length(), (CharSequence) str2).toString();
    }

    /* renamed from: b */
    public static /* synthetic */ String m8169b(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str4 = str;
        }
        return boc.m8168b(str, str2, str3, str4);
    }

    /* renamed from: b */
    public static final String m8168b(String str, String str2, String str3, String str4) {
        bfq.m6567f(str, "$this$replaceAfter");
        bfq.m6567f(str2, "delimiter");
        bfq.m6567f(str3, "replacement");
        bfq.m6567f(str4, "missingDelimiterValue");
        CharSequence charSequence = str;
        int a = boc.m8084a(charSequence, str2, 0, false, 6, (Object) null);
        return a == -1 ? str4 : boc.m8101a(charSequence, a + str2.length(), str.length(), (CharSequence) str3).toString();
    }

    /* renamed from: c */
    public static /* synthetic */ String m8201c(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str4 = str;
        }
        return boc.m8200c(str, str2, str3, str4);
    }

    /* renamed from: c */
    public static final String m8200c(String str, String str2, String str3, String str4) {
        bfq.m6567f(str, "$this$replaceAfterLast");
        bfq.m6567f(str2, "delimiter");
        bfq.m6567f(str3, "replacement");
        bfq.m6567f(str4, "missingDelimiterValue");
        CharSequence charSequence = str;
        int b = boc.m8140b(charSequence, str2, 0, false, 6, (Object) null);
        return b == -1 ? str4 : boc.m8101a(charSequence, b + str2.length(), str.length(), (CharSequence) str3).toString();
    }

    /* renamed from: c */
    public static /* synthetic */ String m8194c(String str, char c, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = str;
        }
        return boc.m8193c(str, c, str2, str3);
    }

    /* renamed from: c */
    public static final String m8193c(String str, char c, String str2, String str3) {
        bfq.m6567f(str, "$this$replaceAfterLast");
        bfq.m6567f(str2, "replacement");
        bfq.m6567f(str3, "missingDelimiterValue");
        CharSequence charSequence = str;
        int b = boc.m8138b(charSequence, c, 0, false, 6, (Object) null);
        return b == -1 ? str3 : boc.m8101a(charSequence, b + 1, str.length(), (CharSequence) str2).toString();
    }

    /* renamed from: d */
    public static /* synthetic */ String m8213d(String str, char c, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = str;
        }
        return boc.m8212d(str, c, str2, str3);
    }

    /* renamed from: d */
    public static final String m8212d(String str, char c, String str2, String str3) {
        bfq.m6567f(str, "$this$replaceBeforeLast");
        bfq.m6567f(str2, "replacement");
        bfq.m6567f(str3, "missingDelimiterValue");
        CharSequence charSequence = str;
        int b = boc.m8138b(charSequence, c, 0, false, 6, (Object) null);
        return b == -1 ? str3 : boc.m8101a(charSequence, 0, b, (CharSequence) str2).toString();
    }

    /* renamed from: d */
    public static /* synthetic */ String m8217d(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str4 = str;
        }
        return boc.m8216d(str, str2, str3, str4);
    }

    /* renamed from: d */
    public static final String m8216d(String str, String str2, String str3, String str4) {
        bfq.m6567f(str, "$this$replaceBeforeLast");
        bfq.m6567f(str2, "delimiter");
        bfq.m6567f(str3, "replacement");
        bfq.m6567f(str4, "missingDelimiterValue");
        CharSequence charSequence = str;
        int b = boc.m8140b(charSequence, str2, 0, false, 6, (Object) null);
        return b == -1 ? str4 : boc.m8101a(charSequence, 0, b, (CharSequence) str3).toString();
    }

    /* renamed from: a */
    private static final String m8111a(CharSequence charSequence, bnu bnu, String str) {
        return bnu.mo2864a(charSequence, str);
    }

    /* renamed from: a */
    private static final String m8110a(CharSequence charSequence, bnu bnu, bdl<? super bnp, ? extends CharSequence> bdl) {
        return bnu.mo2863a(charSequence, bdl);
    }

    /* renamed from: b */
    private static final String m8156b(CharSequence charSequence, bnu bnu, String str) {
        return bnu.mo2867b(charSequence, str);
    }

    /* renamed from: a */
    private static final boolean m8132a(CharSequence charSequence, bnu bnu) {
        return bnu.mo2865a(charSequence);
    }

    /* renamed from: b */
    public static final boolean m8178b(CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3, boolean z) {
        bfq.m6567f(charSequence, "$this$regionMatchesImpl");
        bfq.m6567f(charSequence2, "other");
        if (i2 < 0 || i < 0 || i > charSequence.length() - i3 || i2 > charSequence2.length() - i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!bne.m7751a(charSequence.charAt(i + i4), charSequence2.charAt(i2 + i4), z)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static /* synthetic */ boolean m8131a(CharSequence charSequence, char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return boc.m8130a(charSequence, c, z);
    }

    /* renamed from: a */
    public static final boolean m8130a(CharSequence charSequence, char c, boolean z) {
        bfq.m6567f(charSequence, "$this$startsWith");
        return charSequence.length() > 0 && bne.m7751a(charSequence.charAt(0), c, z);
    }

    /* renamed from: b */
    public static /* synthetic */ boolean m8176b(CharSequence charSequence, char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return boc.m8175b(charSequence, c, z);
    }

    /* renamed from: b */
    public static final boolean m8175b(CharSequence charSequence, char c, boolean z) {
        bfq.m6567f(charSequence, "$this$endsWith");
        return charSequence.length() > 0 && bne.m7751a(charSequence.charAt(boc.m8224g(charSequence)), c, z);
    }

    /* renamed from: a */
    public static /* synthetic */ boolean m8136a(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return boc.m8135a(charSequence, charSequence2, z);
    }

    /* renamed from: a */
    public static final boolean m8135a(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        bfq.m6567f(charSequence, "$this$startsWith");
        bfq.m6567f(charSequence2, "prefix");
        if (!z && (charSequence instanceof String) && (charSequence2 instanceof String)) {
            return boc.m8058b((String) charSequence, (String) charSequence2, false, 2, (Object) null);
        }
        return boc.m8178b(charSequence, 0, charSequence2, 0, charSequence2.length(), z);
    }

    /* renamed from: a */
    public static /* synthetic */ boolean m8134a(CharSequence charSequence, CharSequence charSequence2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return boc.m8133a(charSequence, charSequence2, i, z);
    }

    /* renamed from: a */
    public static final boolean m8133a(CharSequence charSequence, CharSequence charSequence2, int i, boolean z) {
        bfq.m6567f(charSequence, "$this$startsWith");
        bfq.m6567f(charSequence2, "prefix");
        if (!z && (charSequence instanceof String) && (charSequence2 instanceof String)) {
            return boc.m8034a((String) charSequence, (String) charSequence2, i, false, 4, (Object) null);
        }
        return boc.m8178b(charSequence, i, charSequence2, 0, charSequence2.length(), z);
    }

    /* renamed from: b */
    public static /* synthetic */ boolean m8181b(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return boc.m8180b(charSequence, charSequence2, z);
    }

    /* renamed from: b */
    public static final boolean m8180b(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        bfq.m6567f(charSequence, "$this$endsWith");
        bfq.m6567f(charSequence2, "suffix");
        if (!z && (charSequence instanceof String) && (charSequence2 instanceof String)) {
            return boc.m8063c((String) charSequence, (String) charSequence2, false, 2, (Object) null);
        }
        return boc.m8178b(charSequence, charSequence.length() - charSequence2.length(), charSequence2, 0, charSequence2.length(), z);
    }

    /* renamed from: c */
    public static /* synthetic */ String m8190c(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return boc.m8189c(charSequence, charSequence2, z);
    }

    /* renamed from: c */
    public static final String m8189c(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        bfq.m6567f(charSequence, "$this$commonPrefixWith");
        bfq.m6567f(charSequence2, "other");
        int min = Math.min(charSequence.length(), charSequence2.length());
        int i = 0;
        while (i < min && bne.m7751a(charSequence.charAt(i), charSequence2.charAt(i), z)) {
            i++;
        }
        int i2 = i - 1;
        if (boc.m8177b(charSequence, i2) || boc.m8177b(charSequence2, i2)) {
            i--;
        }
        return charSequence.subSequence(0, i).toString();
    }

    /* renamed from: d */
    public static /* synthetic */ String m8209d(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return boc.m8208d(charSequence, charSequence2, z);
    }

    /* renamed from: d */
    public static final String m8208d(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        bfq.m6567f(charSequence, "$this$commonSuffixWith");
        bfq.m6567f(charSequence2, "other");
        int length = charSequence.length();
        int length2 = charSequence2.length();
        int min = Math.min(length, length2);
        int i = 0;
        while (i < min && bne.m7751a(charSequence.charAt((length - i) - 1), charSequence2.charAt((length2 - i) - 1), z)) {
            i++;
        }
        if (boc.m8177b(charSequence, (length - i) - 1) || boc.m8177b(charSequence2, (length2 - i) - 1)) {
            i--;
        }
        return charSequence.subSequence(length - i, length).toString();
    }

    /* renamed from: a */
    public static /* synthetic */ int m8086a(CharSequence charSequence, char[] cArr, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return boc.m8085a(charSequence, cArr, i, z);
    }

    /* renamed from: a */
    public static final int m8085a(CharSequence charSequence, char[] cArr, int i, boolean z) {
        boolean z2;
        bfq.m6567f(charSequence, "$this$indexOfAny");
        bfq.m6567f(cArr, "chars");
        if (z || cArr.length != 1 || !(charSequence instanceof String)) {
            int c = biu.m7177c(i, 0);
            int g = boc.m8224g(charSequence);
            if (c > g) {
                return -1;
            }
            while (true) {
                char charAt = charSequence.charAt(c);
                int length = cArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        z2 = false;
                        break;
                    } else if (bne.m7751a(cArr[i2], charAt, z)) {
                        z2 = true;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (z2) {
                    return c;
                }
                if (c == g) {
                    return -1;
                }
                c++;
            }
        } else {
            return ((String) charSequence).indexOf(arv.m4231i(cArr), i);
        }
    }

    /* renamed from: b */
    public static /* synthetic */ int m8142b(CharSequence charSequence, char[] cArr, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = boc.m8224g(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return boc.m8141b(charSequence, cArr, i, z);
    }

    /* renamed from: b */
    public static final int m8141b(CharSequence charSequence, char[] cArr, int i, boolean z) {
        bfq.m6567f(charSequence, "$this$lastIndexOfAny");
        bfq.m6567f(cArr, "chars");
        if (z || cArr.length != 1 || !(charSequence instanceof String)) {
            for (int d = biu.m7191d(i, boc.m8224g(charSequence)); d >= 0; d--) {
                char charAt = charSequence.charAt(d);
                int length = cArr.length;
                boolean z2 = false;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (bne.m7751a(cArr[i2], charAt, z)) {
                        z2 = true;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (z2) {
                    return d;
                }
            }
            return -1;
        }
        return ((String) charSequence).lastIndexOf(arv.m4231i(cArr), i);
    }

    /* renamed from: a */
    static /* synthetic */ int m8082a(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2, int i3, Object obj) {
        return m8081a(charSequence, charSequence2, i, i2, z, (i3 & 16) != 0 ? false : z2);
    }

    /* renamed from: a */
    private static final int m8081a(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2) {
        bio bio;
        if (!z2) {
            bio = new biq(biu.m7177c(i, 0), biu.m7191d(i2, charSequence.length()));
        } else {
            bio = biu.m7110a(biu.m7191d(i, boc.m8224g(charSequence)), biu.m7177c(i2, 0));
        }
        if (!(charSequence instanceof String) || !(charSequence2 instanceof String)) {
            int a = bio.mo2591a();
            int b = bio.mo2592b();
            int c = bio.mo2593c();
            if (c >= 0) {
                if (a > b) {
                    return -1;
                }
            } else if (a < b) {
                return -1;
            }
            while (true) {
                if (boc.m8178b(charSequence2, 0, charSequence, a, charSequence2.length(), z)) {
                    return a;
                }
                if (a == b) {
                    return -1;
                }
                a += c;
            }
        } else {
            int a2 = bio.mo2591a();
            int b2 = bio.mo2592b();
            int c2 = bio.mo2593c();
            if (c2 >= 0) {
                if (a2 > b2) {
                    return -1;
                }
            } else if (a2 < b2) {
                return -1;
            }
            while (true) {
                if (boc.m8030a((String) charSequence2, 0, (String) charSequence, a2, charSequence2.length(), z)) {
                    return a2;
                }
                if (a2 == b2) {
                    return -1;
                }
                a2 += c2;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final apc<Integer, String> m8145b(CharSequence charSequence, Collection<String> collection, int i, boolean z, boolean z2) {
        Object obj;
        Object obj2;
        if (z || collection.size() != 1) {
            bio biq = !z2 ? new biq(biu.m7177c(i, 0), charSequence.length()) : biu.m7110a(biu.m7191d(i, boc.m8224g(charSequence)), 0);
            if (charSequence instanceof String) {
                int a = biq.mo2591a();
                int b = biq.mo2592b();
                int c = biq.mo2593c();
                if (c < 0 ? a >= b : a <= b) {
                    while (true) {
                        Iterator it = collection.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                obj2 = null;
                                break;
                            }
                            obj2 = it.next();
                            String str = (String) obj2;
                            if (boc.m8030a(str, 0, (String) charSequence, a, str.length(), z)) {
                                break;
                            }
                        }
                        String str2 = (String) obj2;
                        if (str2 == null) {
                            if (a == b) {
                                break;
                            }
                            a += c;
                        } else {
                            return apv.m2659a(Integer.valueOf(a), str2);
                        }
                    }
                }
            } else {
                int a2 = biq.mo2591a();
                int b2 = biq.mo2592b();
                int c2 = biq.mo2593c();
                if (c2 < 0 ? a2 >= b2 : a2 <= b2) {
                    while (true) {
                        Iterator it2 = collection.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                obj = null;
                                break;
                            }
                            obj = it2.next();
                            String str3 = (String) obj;
                            if (boc.m8178b((CharSequence) str3, 0, charSequence, a2, str3.length(), z)) {
                                break;
                            }
                        }
                        String str4 = (String) obj;
                        if (str4 == null) {
                            if (a2 == b2) {
                                break;
                            }
                            a2 += c2;
                        } else {
                            return apv.m2659a(Integer.valueOf(a2), str4);
                        }
                    }
                }
            }
            return null;
        }
        String str5 = (String) ato.m4844k(collection);
        CharSequence charSequence2 = charSequence;
        String str6 = str5;
        int i2 = i;
        int a3 = !z2 ? boc.m8084a(charSequence2, str6, i2, false, 4, (Object) null) : boc.m8140b(charSequence2, str6, i2, false, 4, (Object) null);
        if (a3 < 0) {
            return null;
        }
        return apv.m2659a(Integer.valueOf(a3), str5);
    }

    /* renamed from: a */
    public static /* synthetic */ apc m8088a(CharSequence charSequence, Collection collection, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return boc.m8087a(charSequence, (Collection<String>) collection, i, z);
    }

    /* renamed from: a */
    public static final apc<Integer, String> m8087a(CharSequence charSequence, Collection<String> collection, int i, boolean z) {
        bfq.m6567f(charSequence, "$this$findAnyOf");
        bfq.m6567f(collection, "strings");
        return m8145b(charSequence, collection, i, z, false);
    }

    /* renamed from: b */
    public static /* synthetic */ apc m8144b(CharSequence charSequence, Collection collection, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = boc.m8224g(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return boc.m8143b(charSequence, (Collection<String>) collection, i, z);
    }

    /* renamed from: b */
    public static final apc<Integer, String> m8143b(CharSequence charSequence, Collection<String> collection, int i, boolean z) {
        bfq.m6567f(charSequence, "$this$findLastAnyOf");
        bfq.m6567f(collection, "strings");
        return m8145b(charSequence, collection, i, z, true);
    }

    /* renamed from: c */
    public static /* synthetic */ int m8183c(CharSequence charSequence, Collection collection, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return boc.m8182c(charSequence, (Collection<String>) collection, i, z);
    }

    /* renamed from: c */
    public static final int m8182c(CharSequence charSequence, Collection<String> collection, int i, boolean z) {
        Integer a;
        bfq.m6567f(charSequence, "$this$indexOfAny");
        bfq.m6567f(collection, "strings");
        apc<Integer, String> b = m8145b(charSequence, collection, i, z, false);
        if (b == null || (a = b.mo1544a()) == null) {
            return -1;
        }
        return a.intValue();
    }

    /* renamed from: d */
    public static /* synthetic */ int m8206d(CharSequence charSequence, Collection collection, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = boc.m8224g(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return boc.m8205d(charSequence, (Collection<String>) collection, i, z);
    }

    /* renamed from: d */
    public static final int m8205d(CharSequence charSequence, Collection<String> collection, int i, boolean z) {
        Integer a;
        bfq.m6567f(charSequence, "$this$lastIndexOfAny");
        bfq.m6567f(collection, "strings");
        apc<Integer, String> b = m8145b(charSequence, collection, i, z, true);
        if (b == null || (a = b.mo1544a()) == null) {
            return -1;
        }
        return a.intValue();
    }

    /* renamed from: a */
    public static /* synthetic */ int m8080a(CharSequence charSequence, char c, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return boc.m8079a(charSequence, c, i, z);
    }

    /* renamed from: a */
    public static final int m8079a(CharSequence charSequence, char c, int i, boolean z) {
        bfq.m6567f(charSequence, "$this$indexOf");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(c, i);
        }
        return boc.m8085a(charSequence, new char[]{c}, i, z);
    }

    /* renamed from: a */
    public static /* synthetic */ int m8084a(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return boc.m8083a(charSequence, str, i, z);
    }

    /* renamed from: a */
    public static final int m8083a(CharSequence charSequence, String str, int i, boolean z) {
        bfq.m6567f(charSequence, "$this$indexOf");
        bfq.m6567f(str, "string");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(str, i);
        }
        return m8082a(charSequence, str, i, charSequence.length(), z, false, 16, (Object) null);
    }

    /* renamed from: b */
    public static /* synthetic */ int m8138b(CharSequence charSequence, char c, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = boc.m8224g(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return boc.m8137b(charSequence, c, i, z);
    }

    /* renamed from: b */
    public static final int m8137b(CharSequence charSequence, char c, int i, boolean z) {
        bfq.m6567f(charSequence, "$this$lastIndexOf");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(c, i);
        }
        return boc.m8141b(charSequence, new char[]{c}, i, z);
    }

    /* renamed from: b */
    public static /* synthetic */ int m8140b(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = boc.m8224g(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return boc.m8139b(charSequence, str, i, z);
    }

    /* renamed from: b */
    public static final int m8139b(CharSequence charSequence, String str, int i, boolean z) {
        bfq.m6567f(charSequence, "$this$lastIndexOf");
        bfq.m6567f(str, "string");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(str, i);
        }
        return m8081a(charSequence, (CharSequence) str, i, 0, z, true);
    }

    /* renamed from: e */
    public static /* synthetic */ boolean m8222e(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return boc.m8221e(charSequence, charSequence2, z);
    }

    /* renamed from: e */
    public static final boolean m8221e(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        bfq.m6567f(charSequence, "$this$contains");
        bfq.m6567f(charSequence2, "other");
        if (charSequence2 instanceof String) {
            if (boc.m8084a(charSequence, (String) charSequence2, 0, z, 2, (Object) null) >= 0) {
                return true;
            }
        } else {
            if (m8082a(charSequence, charSequence2, 0, charSequence.length(), z, false, 16, (Object) null) >= 0) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    public static /* synthetic */ boolean m8204c(CharSequence charSequence, char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return boc.m8203c(charSequence, c, z);
    }

    /* renamed from: c */
    public static final boolean m8203c(CharSequence charSequence, char c, boolean z) {
        bfq.m6567f(charSequence, "$this$contains");
        return boc.m8080a(charSequence, c, 0, z, 2, (Object) null) >= 0;
    }

    /* renamed from: b */
    private static final boolean m8179b(CharSequence charSequence, bnu bnu) {
        bfq.m6567f(charSequence, "$this$contains");
        return bnu.mo2869b(charSequence);
    }

    /* renamed from: a */
    static /* synthetic */ bku m8091a(CharSequence charSequence, char[] cArr, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return m8090a(charSequence, cArr, i, z, i2);
    }

    /* renamed from: a */
    private static final bku<biq> m8090a(CharSequence charSequence, char[] cArr, int i, boolean z, int i2) {
        if (i2 >= 0) {
            return new bnj(charSequence, i, i2, new boq(cArr, z));
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i2 + '.').toString());
    }

    /* renamed from: a */
    static /* synthetic */ bku m8095a(CharSequence charSequence, String[] strArr, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return m8094a(charSequence, strArr, i, z, i2);
    }

    /* renamed from: a */
    private static final bku<biq> m8094a(CharSequence charSequence, String[] strArr, int i, boolean z, int i2) {
        if (i2 >= 0) {
            return new bnj(charSequence, i, i2, new bor(arv.m3276d((T[]) strArr), z));
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i2 + '.').toString());
    }

    /* renamed from: a */
    public static /* synthetic */ bku m8097a(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return boc.m8096a(charSequence, strArr, z, i);
    }

    /* renamed from: a */
    public static final bku<String> m8096a(CharSequence charSequence, String[] strArr, boolean z, int i) {
        bfq.m6567f(charSequence, "$this$splitToSequence");
        bfq.m6567f(strArr, "delimiters");
        return bkx.m7614u(m8095a(charSequence, strArr, 0, z, i, 2, (Object) null), new bos(charSequence));
    }

    /* renamed from: b */
    public static /* synthetic */ List m8174b(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return boc.m8173b(charSequence, strArr, z, i);
    }

    /* renamed from: b */
    public static final List<String> m8173b(CharSequence charSequence, String[] strArr, boolean z, int i) {
        bfq.m6567f(charSequence, "$this$split");
        bfq.m6567f(strArr, "delimiters");
        boolean z2 = true;
        if (strArr.length == 1) {
            String str = strArr[0];
            if (str.length() != 0) {
                z2 = false;
            }
            if (!z2) {
                return m8129a(charSequence, str, z, i);
            }
        }
        Iterable<biq> H = bkx.m7501H(m8095a(charSequence, strArr, 0, z, i, 2, (Object) null));
        Collection arrayList = new ArrayList(ato.m4625a(H, 10));
        for (biq b : H) {
            arrayList.add(boc.m8155b(charSequence, b));
        }
        return (List) arrayList;
    }

    /* renamed from: a */
    public static /* synthetic */ bku m8093a(CharSequence charSequence, char[] cArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return boc.m8092a(charSequence, cArr, z, i);
    }

    /* renamed from: a */
    public static final bku<String> m8092a(CharSequence charSequence, char[] cArr, boolean z, int i) {
        bfq.m6567f(charSequence, "$this$splitToSequence");
        bfq.m6567f(cArr, "delimiters");
        return bkx.m7614u(m8091a(charSequence, cArr, 0, z, i, 2, (Object) null), new bot(charSequence));
    }

    /* renamed from: b */
    public static /* synthetic */ List m8172b(CharSequence charSequence, char[] cArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return boc.m8171b(charSequence, cArr, z, i);
    }

    /* renamed from: b */
    public static final List<String> m8171b(CharSequence charSequence, char[] cArr, boolean z, int i) {
        bfq.m6567f(charSequence, "$this$split");
        bfq.m6567f(cArr, "delimiters");
        if (cArr.length == 1) {
            return m8129a(charSequence, String.valueOf(cArr[0]), z, i);
        }
        Iterable<biq> H = bkx.m7501H(m8091a(charSequence, cArr, 0, z, i, 2, (Object) null));
        Collection arrayList = new ArrayList(ato.m4625a(H, 10));
        for (biq b : H) {
            arrayList.add(boc.m8155b(charSequence, b));
        }
        return (List) arrayList;
    }

    /* renamed from: a */
    private static final List<String> m8129a(CharSequence charSequence, String str, boolean z, int i) {
        int i2 = 0;
        if (i >= 0) {
            int a = boc.m8083a(charSequence, str, 0, z);
            if (a == -1 || i == 1) {
                return ato.m4586a(charSequence.toString());
            }
            boolean z2 = i > 0;
            int i3 = 10;
            if (z2) {
                i3 = biu.m7191d(i, 10);
            }
            ArrayList arrayList = new ArrayList(i3);
            do {
                arrayList.add(charSequence.subSequence(i2, a).toString());
                i2 = str.length() + a;
                if ((z2 && arrayList.size() == i - 1) || (a = boc.m8083a(charSequence, str, i2, z)) == -1) {
                    arrayList.add(charSequence.subSequence(i2, charSequence.length()).toString());
                }
                arrayList.add(charSequence.subSequence(i2, a).toString());
                i2 = str.length() + a;
                break;
            } while ((a = boc.m8083a(charSequence, str, i2, z)) == -1);
            arrayList.add(charSequence.subSequence(i2, charSequence.length()).toString());
            return arrayList;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i + '.').toString());
    }

    /* renamed from: a */
    private static final List<String> m8127a(CharSequence charSequence, bnu bnu, int i) {
        return bnu.mo2871c(charSequence, i);
    }

    /* renamed from: h */
    public static final bku<String> m8225h(CharSequence charSequence) {
        bfq.m6567f(charSequence, "$this$lineSequence");
        return boc.m8097a(charSequence, new String[]{"\r\n", "\n", "\r"}, false, 0, 6, (Object) null);
    }

    /* renamed from: i */
    public static final List<String> m8226i(CharSequence charSequence) {
        bfq.m6567f(charSequence, "$this$lines");
        return bkx.m7605q(boc.m8225h(charSequence));
    }

    /* renamed from: a */
    public static final CharSequence m8107a(CharSequence charSequence, char... cArr) {
        bfq.m6567f(charSequence, "$this$trim");
        bfq.m6567f(cArr, "chars");
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean b = arv.m3934b(cArr, charSequence.charAt(!z ? i : length));
            if (!z) {
                if (!b) {
                    z = true;
                } else {
                    i++;
                }
            } else if (!b) {
                break;
            } else {
                length--;
            }
        }
        return charSequence.subSequence(i, length + 1);
    }

    /* renamed from: a */
    public static final String m8126a(String str, char... cArr) {
        bfq.m6567f(str, "$this$trim");
        bfq.m6567f(cArr, "chars");
        CharSequence charSequence = str;
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean b = arv.m3934b(cArr, charSequence.charAt(!z ? i : length));
            if (!z) {
                if (!b) {
                    z = true;
                } else {
                    i++;
                }
            } else if (!b) {
                break;
            } else {
                length--;
            }
        }
        return charSequence.subSequence(i, length + 1).toString();
    }

    /* renamed from: b */
    public static final CharSequence m8151b(CharSequence charSequence, char... cArr) {
        bfq.m6567f(charSequence, "$this$trimStart");
        bfq.m6567f(cArr, "chars");
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!arv.m3934b(cArr, charSequence.charAt(i))) {
                return charSequence.subSequence(i, charSequence.length());
            }
        }
        return "";
    }

    /* renamed from: b */
    public static final String m8170b(String str, char... cArr) {
        CharSequence charSequence;
        bfq.m6567f(str, "$this$trimStart");
        bfq.m6567f(cArr, "chars");
        CharSequence charSequence2 = str;
        int length = charSequence2.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            } else if (!arv.m3934b(cArr, charSequence2.charAt(i))) {
                charSequence = charSequence2.subSequence(i, charSequence2.length());
                break;
            } else {
                i++;
            }
        }
        return charSequence.toString();
    }

    /* renamed from: c */
    public static final CharSequence m8188c(CharSequence charSequence, char... cArr) {
        bfq.m6567f(charSequence, "$this$trimEnd");
        bfq.m6567f(cArr, "chars");
        int length = charSequence.length();
        do {
            length--;
            if (length < 0) {
                return "";
            }
        } while (arv.m3934b(cArr, charSequence.charAt(length)));
        return charSequence.subSequence(0, length + 1);
    }

    /* renamed from: c */
    public static final String m8202c(String str, char... cArr) {
        CharSequence charSequence;
        bfq.m6567f(str, "$this$trimEnd");
        bfq.m6567f(cArr, "chars");
        CharSequence charSequence2 = str;
        int length = charSequence2.length();
        while (true) {
            length--;
            if (length >= 0) {
                if (!arv.m3934b(cArr, charSequence2.charAt(length))) {
                    charSequence = charSequence2.subSequence(0, length + 1);
                    break;
                }
            } else {
                break;
            }
        }
        return charSequence.toString();
    }

    /* renamed from: b */
    public static final CharSequence m8146b(CharSequence charSequence) {
        bfq.m6567f(charSequence, "$this$trim");
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean a = bne.m7731a(charSequence.charAt(!z ? i : length));
            if (!z) {
                if (!a) {
                    z = true;
                } else {
                    i++;
                }
            } else if (!a) {
                break;
            } else {
                length--;
            }
        }
        return charSequence.subSequence(i, length + 1);
    }

    /* renamed from: c */
    public static final CharSequence m8184c(CharSequence charSequence) {
        bfq.m6567f(charSequence, "$this$trimStart");
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!bne.m7731a(charSequence.charAt(i))) {
                return charSequence.subSequence(i, charSequence.length());
            }
        }
        return "";
    }

    /* renamed from: d */
    public static final CharSequence m8207d(CharSequence charSequence) {
        bfq.m6567f(charSequence, "$this$trimEnd");
        int length = charSequence.length();
        do {
            length--;
            if (length < 0) {
                return "";
            }
        } while (bne.m7731a(charSequence.charAt(length)));
        return charSequence.subSequence(0, length + 1);
    }

    /* renamed from: a */
    static /* synthetic */ List m8128a(CharSequence charSequence, bnu bnu, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return bnu.mo2871c(charSequence, i);
    }
}

package atakplugin.UASTool;

import atakplugin.UASTool.can;
import com.atakmap.android.uastool.MAVLink.common.msg_mount_orientation;
import com.atakmap.android.uastool.tasks.UASTask;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;

public class adb extends C1002wn {

    /* renamed from: A */
    private static final /* synthetic */ can.C0296b f418A = null;

    /* renamed from: B */
    private static final /* synthetic */ can.C0296b f419B = null;

    /* renamed from: C */
    private static final /* synthetic */ can.C0296b f420C = null;

    /* renamed from: a */
    public static final String f421a = "Xtra";

    /* renamed from: b */
    public static final int f422b = 8;

    /* renamed from: c */
    public static final int f423c = 19;

    /* renamed from: d */
    public static final int f424d = 21;

    /* renamed from: e */
    public static final int f425e = 72;

    /* renamed from: q */
    private static final long f426q = 11644473600000L;

    /* renamed from: r */
    private static final long f427r = 10000;

    /* renamed from: s */
    private static final /* synthetic */ can.C0296b f428s = null;

    /* renamed from: t */
    private static final /* synthetic */ can.C0296b f429t = null;

    /* renamed from: u */
    private static final /* synthetic */ can.C0296b f430u = null;

    /* renamed from: v */
    private static final /* synthetic */ can.C0296b f431v = null;

    /* renamed from: w */
    private static final /* synthetic */ can.C0296b f432w = null;

    /* renamed from: x */
    private static final /* synthetic */ can.C0296b f433x = null;

    /* renamed from: y */
    private static final /* synthetic */ can.C0296b f434y = null;

    /* renamed from: z */
    private static final /* synthetic */ can.C0296b f435z = null;

    /* renamed from: f */
    Vector<C0010a> f436f = new Vector<>();

    /* renamed from: o */
    ByteBuffer f437o;

    /* renamed from: p */
    private boolean f438p = false;

    static {
        m422c();
    }

    /* renamed from: c */
    private static /* synthetic */ void m422c() {
        cdj cdj = new cdj("XtraBox.java", adb.class);
        f428s = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "toString", "com.googlecode.mp4parser.boxes.microsoft.XtraBox", "", "", "", "java.lang.String"), 88);
        f429t = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getAllTagNames", "com.googlecode.mp4parser.boxes.microsoft.XtraBox", "", "", "", "[Ljava.lang.String;"), 151);
        f420C = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setTagValue", "com.googlecode.mp4parser.boxes.microsoft.XtraBox", "java.lang.String:long", "name:value", "", "void"), 289);
        f430u = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getFirstStringValue", "com.googlecode.mp4parser.boxes.microsoft.XtraBox", "java.lang.String", UASTask.COTDETAIL_NAME, "", "java.lang.String"), 166);
        f431v = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getFirstDateValue", "com.googlecode.mp4parser.boxes.microsoft.XtraBox", "java.lang.String", UASTask.COTDETAIL_NAME, "", "java.util.Date"), 183);
        f432w = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getFirstLongValue", "com.googlecode.mp4parser.boxes.microsoft.XtraBox", "java.lang.String", UASTask.COTDETAIL_NAME, "", "java.lang.Long"), 200);
        f433x = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getValues", "com.googlecode.mp4parser.boxes.microsoft.XtraBox", "java.lang.String", UASTask.COTDETAIL_NAME, "", "[Ljava.lang.Object;"), 216);
        f434y = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "removeTag", "com.googlecode.mp4parser.boxes.microsoft.XtraBox", "java.lang.String", UASTask.COTDETAIL_NAME, "", "void"), 236);
        f435z = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setTagValues", "com.googlecode.mp4parser.boxes.microsoft.XtraBox", "java.lang.String:[Ljava.lang.String;", "name:values", "", "void"), 249);
        f418A = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setTagValue", "com.googlecode.mp4parser.boxes.microsoft.XtraBox", "java.lang.String:java.lang.String", "name:value", "", "void"), (int) msg_mount_orientation.MAVLINK_MSG_ID_MOUNT_ORIENTATION);
        f419B = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setTagValue", "com.googlecode.mp4parser.boxes.microsoft.XtraBox", "java.lang.String:java.util.Date", "name:date", "", "void"), 276);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static long m424d(long j) {
        return (j + f426q) * 10000;
    }

    public adb() {
        super(f421a);
    }

    public adb(String str) {
        super(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        int limit;
        if (this.f438p) {
            limit = m416b();
        } else {
            limit = this.f437o.limit();
        }
        return (long) limit;
    }

    /* renamed from: b */
    private int m416b() {
        int i = 0;
        for (int i2 = 0; i2 < this.f436f.size(); i2++) {
            i += this.f436f.elementAt(i2).m441a();
        }
        return i;
    }

    public String toString() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f428s, (Object) this, (Object) this));
        if (!mo6121x()) {
            mo6120v();
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("XtraBox[");
        Iterator<C0010a> it = this.f436f.iterator();
        while (it.hasNext()) {
            C0010a next = it.next();
            Iterator it2 = next.f441c.iterator();
            while (it2.hasNext()) {
                stringBuffer.append(next.f440b);
                stringBuffer.append("=");
                stringBuffer.append(((C0011b) it2.next()).toString());
                stringBuffer.append(";");
            }
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        this.f437o = byteBuffer.slice();
        this.f438p = false;
        try {
            this.f436f.clear();
            while (byteBuffer.remaining() > 0) {
                C0010a aVar = new C0010a((C0010a) null);
                aVar.m444a(byteBuffer);
                this.f436f.addElement(aVar);
            }
            int b = m416b();
            if (remaining == b) {
                this.f438p = true;
                byteBuffer.order(ByteOrder.BIG_ENDIAN);
                return;
            }
            throw new RuntimeException("Improperly handled Xtra tag: Calculated sizes don't match ( " + remaining + "/" + b + ")");
        } catch (Exception e) {
            this.f438p = false;
            PrintStream printStream = System.err;
            printStream.println("Malformed Xtra Tag detected: " + e.toString());
            e.printStackTrace();
            byteBuffer.position(byteBuffer.position() + byteBuffer.remaining());
        } catch (Throwable th) {
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        if (this.f438p) {
            for (int i = 0; i < this.f436f.size(); i++) {
                this.f436f.elementAt(i).m447b(byteBuffer);
            }
            return;
        }
        this.f437o.rewind();
        byteBuffer.put(this.f437o);
    }

    /* renamed from: a */
    public String[] mo278a() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f429t, (Object) this, (Object) this));
        String[] strArr = new String[this.f436f.size()];
        for (int i = 0; i < this.f436f.size(); i++) {
            strArr[i] = this.f436f.elementAt(i).f440b;
        }
        return strArr;
    }

    /* renamed from: a */
    public String mo273a(String str) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f430u, (Object) this, (Object) this, (Object) str));
        for (Object obj : mo281d(str)) {
            if (obj instanceof String) {
                return (String) obj;
            }
        }
        return null;
    }

    /* renamed from: b */
    public Date mo279b(String str) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f431v, (Object) this, (Object) this, (Object) str));
        for (Object obj : mo281d(str)) {
            if (obj instanceof Date) {
                return (Date) obj;
            }
        }
        return null;
    }

    /* renamed from: c */
    public Long mo280c(String str) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f432w, (Object) this, (Object) this, (Object) str));
        for (Object obj : mo281d(str)) {
            if (obj instanceof Long) {
                return (Long) obj;
            }
        }
        return null;
    }

    /* renamed from: d */
    public Object[] mo281d(String str) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f433x, (Object) this, (Object) this, (Object) str));
        C0010a f = m427f(str);
        if (f == null) {
            return new Object[0];
        }
        Object[] objArr = new Object[f.f441c.size()];
        for (int i = 0; i < f.f441c.size(); i++) {
            objArr[i] = ((C0011b) f.f441c.elementAt(i)).m450a();
        }
        return objArr;
    }

    /* renamed from: e */
    public void mo282e(String str) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f434y, (Object) this, (Object) this, (Object) str));
        C0010a f = m427f(str);
        if (f != null) {
            this.f436f.remove(f);
        }
    }

    /* renamed from: a */
    public void mo277a(String str, String[] strArr) {
        C1013wy.m14474a().mo6137a(cdj.m11378a(f435z, (Object) this, (Object) this, (Object) str, (Object) strArr));
        mo282e(str);
        C0010a aVar = new C0010a(str, (C0010a) null);
        for (String bVar : strArr) {
            aVar.f441c.addElement(new C0011b(bVar, (C0011b) null));
        }
        this.f436f.addElement(aVar);
    }

    /* renamed from: a */
    public void mo275a(String str, String str2) {
        C1013wy.m14474a().mo6137a(cdj.m11378a(f418A, (Object) this, (Object) this, (Object) str, (Object) str2));
        mo277a(str, new String[]{str2});
    }

    /* renamed from: a */
    public void mo276a(String str, Date date) {
        C1013wy.m14474a().mo6137a(cdj.m11378a(f419B, (Object) this, (Object) this, (Object) str, (Object) date));
        mo282e(str);
        C0010a aVar = new C0010a(str, (C0010a) null);
        aVar.f441c.addElement(new C0011b(date, (C0011b) null));
        this.f436f.addElement(aVar);
    }

    /* renamed from: a */
    public void mo274a(String str, long j) {
        C1013wy.m14474a().mo6137a(cdj.m11378a(f420C, (Object) this, (Object) this, (Object) str, ccw.m11302a(j)));
        mo282e(str);
        C0010a aVar = new C0010a(str, (C0010a) null);
        aVar.f441c.addElement(new C0011b(j, (C0011b) null));
        this.f436f.addElement(aVar);
    }

    /* renamed from: f */
    private C0010a m427f(String str) {
        Iterator<C0010a> it = this.f436f.iterator();
        while (it.hasNext()) {
            C0010a next = it.next();
            if (next.f440b.equals(str)) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: atakplugin.UASTool.adb$a */
    private static class C0010a {

        /* renamed from: a */
        private int f439a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public String f440b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public Vector<C0011b> f441c;

        private C0010a() {
            this.f441c = new Vector<>();
        }

        /* synthetic */ C0010a(C0010a aVar) {
            this();
        }

        /* synthetic */ C0010a(String str, C0010a aVar) {
            this(str);
        }

        private C0010a(String str) {
            this();
            this.f440b = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m444a(ByteBuffer byteBuffer) {
            this.f439a = byteBuffer.getInt();
            this.f440b = adb.m421c(byteBuffer, byteBuffer.getInt());
            int i = byteBuffer.getInt();
            for (int i2 = 0; i2 < i; i2++) {
                C0011b bVar = new C0011b((C0011b) null);
                bVar.m452a(byteBuffer);
                this.f441c.addElement(bVar);
            }
            if (this.f439a != m441a()) {
                throw new RuntimeException("Improperly handled Xtra tag: Sizes don't match ( " + this.f439a + "/" + m441a() + ") on " + this.f440b);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public void m447b(ByteBuffer byteBuffer) {
            byteBuffer.putInt(m441a());
            byteBuffer.putInt(this.f440b.length());
            adb.m423c(byteBuffer, this.f440b);
            byteBuffer.putInt(this.f441c.size());
            for (int i = 0; i < this.f441c.size(); i++) {
                this.f441c.elementAt(i).m456b(byteBuffer);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public int m441a() {
            int length = this.f440b.length() + 12;
            for (int i = 0; i < this.f441c.size(); i++) {
                length += this.f441c.elementAt(i).m453b();
            }
            return length;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(this.f440b);
            stringBuffer.append(" [");
            stringBuffer.append(this.f439a);
            stringBuffer.append("/");
            stringBuffer.append(this.f441c.size());
            stringBuffer.append("]:\n");
            for (int i = 0; i < this.f441c.size(); i++) {
                stringBuffer.append("  ");
                stringBuffer.append(this.f441c.elementAt(i).toString());
                stringBuffer.append("\n");
            }
            return stringBuffer.toString();
        }
    }

    /* renamed from: atakplugin.UASTool.adb$b */
    private static class C0011b {

        /* renamed from: a */
        public int f442a;

        /* renamed from: b */
        public String f443b;

        /* renamed from: c */
        public long f444c;

        /* renamed from: d */
        public byte[] f445d;

        /* renamed from: e */
        public Date f446e;

        private C0011b() {
        }

        /* synthetic */ C0011b(C0011b bVar) {
            this();
        }

        private C0011b(String str) {
            this.f442a = 8;
            this.f443b = str;
        }

        /* synthetic */ C0011b(String str, C0011b bVar) {
            this(str);
        }

        private C0011b(long j) {
            this.f442a = 19;
            this.f444c = j;
        }

        /* synthetic */ C0011b(long j, C0011b bVar) {
            this(j);
        }

        private C0011b(Date date) {
            this.f442a = 21;
            this.f446e = date;
        }

        /* synthetic */ C0011b(Date date, C0011b bVar) {
            this(date);
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public Object m450a() {
            int i = this.f442a;
            if (i == 8) {
                return this.f443b;
            }
            if (i == 19) {
                return new Long(this.f444c);
            }
            if (i != 21) {
                return this.f445d;
            }
            return this.f446e;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m452a(ByteBuffer byteBuffer) {
            int i = byteBuffer.getInt() - 6;
            this.f442a = byteBuffer.getShort();
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            int i2 = this.f442a;
            if (i2 == 8) {
                this.f443b = adb.m425d(byteBuffer, i);
            } else if (i2 == 19) {
                this.f444c = byteBuffer.getLong();
            } else if (i2 != 21) {
                byte[] bArr = new byte[i];
                this.f445d = bArr;
                byteBuffer.get(bArr);
            } else {
                this.f446e = new Date(adb.m420c(byteBuffer.getLong()));
            }
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public void m456b(ByteBuffer byteBuffer) {
            try {
                byteBuffer.putInt(m453b());
                byteBuffer.putShort((short) this.f442a);
                byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
                int i = this.f442a;
                if (i == 8) {
                    adb.m426d(byteBuffer, this.f443b);
                } else if (i == 19) {
                    byteBuffer.putLong(this.f444c);
                } else if (i != 21) {
                    byteBuffer.put(this.f445d);
                } else {
                    byteBuffer.putLong(adb.m424d(this.f446e.getTime()));
                }
            } finally {
                byteBuffer.order(ByteOrder.BIG_ENDIAN);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public int m453b() {
            int i;
            int i2 = this.f442a;
            if (i2 == 8) {
                i = (this.f443b.length() * 2) + 2;
            } else if (i2 == 19 || i2 == 21) {
                return 14;
            } else {
                i = this.f445d.length;
            }
            return i + 6;
        }

        public String toString() {
            int i = this.f442a;
            if (i == 8) {
                return "[string]" + this.f443b;
            } else if (i == 19) {
                return "[long]" + String.valueOf(this.f444c);
            } else if (i != 21) {
                return "[GUID](nonParsed)";
            } else {
                return "[filetime]" + this.f446e.toString();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static long m420c(long j) {
        return (j / 10000) - f426q;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static void m423c(ByteBuffer byteBuffer, String str) {
        try {
            byteBuffer.put(str.getBytes(bxz.f4230b));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Shouldn't happen", e);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static String m421c(ByteBuffer byteBuffer, int i) {
        byte[] bArr = new byte[i];
        byteBuffer.get(bArr);
        try {
            return new String(bArr, bxz.f4230b);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Shouldn't happen", e);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static String m425d(ByteBuffer byteBuffer, int i) {
        int i2 = (i / 2) - 1;
        char[] cArr = new char[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            cArr[i3] = byteBuffer.getChar();
        }
        byteBuffer.getChar();
        return new String(cArr);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static void m426d(ByteBuffer byteBuffer, String str) {
        char[] charArray = str.toCharArray();
        for (char putChar : charArray) {
            byteBuffer.putChar(putChar);
        }
        byteBuffer.putChar(0);
    }
}

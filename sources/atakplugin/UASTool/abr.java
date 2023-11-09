package atakplugin.UASTool;

import atakplugin.UASTool.can;
import com.atakmap.android.uastool.flightlog.FlightLogger;
import java.nio.ByteBuffer;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class abr extends abc {

    /* renamed from: f */
    private static final /* synthetic */ can.C0296b f186f = null;

    /* renamed from: o */
    private static final /* synthetic */ can.C0296b f187o = null;

    /* renamed from: d */
    DateFormat f188d;

    /* renamed from: e */
    Date f189e = new Date();

    static {
        m183m();
    }

    /* renamed from: m */
    private static /* synthetic */ void m183m() {
        cdj cdj = new cdj("AppleRecordingYearBox.java", abr.class);
        f186f = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getDate", "com.googlecode.mp4parser.boxes.apple.AppleRecordingYearBox", "", "", "", "java.util.Date"), 27);
        f187o = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setDate", "com.googlecode.mp4parser.boxes.apple.AppleRecordingYearBox", "java.util.Date", FlightLogger.LOCS_DATE, "", "void"), 31);
    }

    public abr() {
        super("©day", 1);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'kk:mm:ssZ");
        this.f188d = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    /* renamed from: a */
    public Date mo109a() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f186f, (Object) this, (Object) this));
        return this.f189e;
    }

    /* renamed from: a */
    public void mo126a(Date date) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f187o, (Object) this, (Object) this, (Object) date));
        this.f189e = date;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public byte[] mo111b() {
        return C0684np.m12528a(m182b(this.f188d.format(this.f189e)));
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo112c(ByteBuffer byteBuffer) {
        try {
            this.f189e = this.f188d.parse(m181a(C0679nk.m12494a(byteBuffer, byteBuffer.remaining())));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    protected static String m181a(String str) {
        return str.replaceAll("Z$", "+0000").replaceAll("([0-9][0-9]):([0-9][0-9])$", "$1$2");
    }

    /* renamed from: b */
    protected static String m182b(String str) {
        return str.replaceAll("\\+0000$", "Z");
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public int mo36c() {
        return C0684np.m12528a(m182b(this.f188d.format(this.f189e))).length;
    }
}

package atakplugin.UASTool;

import com.atakmap.android.uastool.MAVLink.enums.MAV_CMD;

public final class bue {

    /* renamed from: a */
    public static final bwq f3827a = bwq.m10196b(":status");

    /* renamed from: b */
    public static final bwq f3828b = bwq.m10196b(":method");

    /* renamed from: c */
    public static final bwq f3829c = bwq.m10196b(":path");

    /* renamed from: d */
    public static final bwq f3830d = bwq.m10196b(":scheme");

    /* renamed from: e */
    public static final bwq f3831e = bwq.m10196b(":authority");

    /* renamed from: f */
    public static final bwq f3832f = bwq.m10196b(":host");

    /* renamed from: g */
    public static final bwq f3833g = bwq.m10196b(":version");

    /* renamed from: h */
    public final bwq f3834h;

    /* renamed from: i */
    public final bwq f3835i;

    /* renamed from: j */
    final int f3836j;

    public bue(String str, String str2) {
        this(bwq.m10196b(str), bwq.m10196b(str2));
    }

    public bue(bwq bwq, String str) {
        this(bwq, bwq.m10196b(str));
    }

    public bue(bwq bwq, bwq bwq2) {
        this.f3834h = bwq;
        this.f3835i = bwq2;
        this.f3836j = bwq.mo3951n() + 32 + bwq2.mo3951n();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof bue)) {
            return false;
        }
        bue bue = (bue) obj;
        if (!this.f3834h.equals(bue.f3834h) || !this.f3835i.equals(bue.f3835i)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((MAV_CMD.MAV_CMD_REQUEST_CAMERA_CAPTURE_STATUS + this.f3834h.hashCode()) * 31) + this.f3835i.hashCode();
    }

    public String toString() {
        return bsp.m9152a("%s: %s", this.f3834h.mo3929c(), this.f3835i.mo3929c());
    }
}

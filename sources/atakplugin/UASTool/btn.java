package atakplugin.UASTool;

public enum btn {
    NO_ERROR(0, -1, 0),
    PROTOCOL_ERROR(1, 1, 1),
    INVALID_STREAM(1, 2, -1),
    UNSUPPORTED_VERSION(1, 4, -1),
    STREAM_IN_USE(1, 8, -1),
    STREAM_ALREADY_CLOSED(1, 9, -1),
    INTERNAL_ERROR(2, 6, 2),
    FLOW_CONTROL_ERROR(3, 7, -1),
    STREAM_CLOSED(5, -1, -1),
    FRAME_TOO_LARGE(6, 11, -1),
    REFUSED_STREAM(7, 3, -1),
    CANCEL(8, 5, -1),
    COMPRESSION_ERROR(9, -1, -1),
    CONNECT_ERROR(10, -1, -1),
    ENHANCE_YOUR_CALM(11, -1, -1),
    INADEQUATE_SECURITY(12, -1, -1),
    HTTP_1_1_REQUIRED(13, -1, -1),
    INVALID_CREDENTIALS(-1, 10, -1);
    

    /* renamed from: s */
    public final int f3727s;

    /* renamed from: t */
    public final int f3728t;

    /* renamed from: u */
    public final int f3729u;

    private btn(int i, int i2, int i3) {
        this.f3727s = i;
        this.f3728t = i2;
        this.f3729u = i3;
    }

    /* renamed from: a */
    public static btn m9334a(int i) {
        for (btn btn : values()) {
            if (btn.f3728t == i) {
                return btn;
            }
        }
        return null;
    }

    /* renamed from: b */
    public static btn m9335b(int i) {
        for (btn btn : values()) {
            if (btn.f3727s == i) {
                return btn;
            }
        }
        return null;
    }

    /* renamed from: c */
    public static btn m9336c(int i) {
        for (btn btn : values()) {
            if (btn.f3729u == i) {
                return btn;
            }
        }
        return null;
    }
}

package atakplugin.UASTool;

public enum buf {
    SPDY_SYN_STREAM,
    SPDY_REPLY,
    SPDY_HEADERS,
    HTTP_20_HEADERS;

    /* renamed from: a */
    public boolean mo3619a() {
        return this == SPDY_REPLY || this == SPDY_HEADERS;
    }

    /* renamed from: b */
    public boolean mo3620b() {
        return this == SPDY_SYN_STREAM;
    }

    /* renamed from: c */
    public boolean mo3621c() {
        return this == SPDY_HEADERS;
    }

    /* renamed from: d */
    public boolean mo3622d() {
        return this == SPDY_REPLY;
    }
}

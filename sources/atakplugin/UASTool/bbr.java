package atakplugin.UASTool;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

@aot(mo1534a = 3, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, mo1538e = {"<anonymous>", "Ljava/nio/charset/CharsetDecoder;", "kotlin.jvm.PlatformType", "invoke"})
final class bbr extends bfr implements bdk<CharsetDecoder> {

    /* renamed from: a */
    public static final bbr f2512a = new bbr();

    bbr() {
        super(0);
    }

    /* renamed from: a */
    public final CharsetDecoder invoke() {
        return Charset.defaultCharset().newDecoder();
    }
}

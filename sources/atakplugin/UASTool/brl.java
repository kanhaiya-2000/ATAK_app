package atakplugin.UASTool;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

final class brl implements brk {
    brl() {
    }

    /* renamed from: a */
    public List<InetAddress> mo3148a(String str) {
        if (str != null) {
            return Arrays.asList(InetAddress.getAllByName(str));
        }
        throw new UnknownHostException("hostname == null");
    }
}

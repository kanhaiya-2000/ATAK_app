package atakplugin.UASTool;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;

public final class bth {

    /* renamed from: a */
    private final List<brc> f3670a;

    /* renamed from: b */
    private int f3671b = 0;

    /* renamed from: c */
    private boolean f3672c;

    /* renamed from: d */
    private boolean f3673d;

    public bth(List<brc> list) {
        this.f3670a = list;
    }

    /* renamed from: a */
    public brc mo3466a(SSLSocket sSLSocket) {
        brc brc;
        int i = this.f3671b;
        int size = this.f3670a.size();
        while (true) {
            if (i >= size) {
                brc = null;
                break;
            }
            brc = this.f3670a.get(i);
            if (brc.mo3094a(sSLSocket)) {
                this.f3671b = i + 1;
                break;
            }
            i++;
        }
        if (brc != null) {
            this.f3672c = m9281b(sSLSocket);
            bsn.f3580a.mo3328a(brc, sSLSocket, this.f3673d);
            return brc;
        }
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.f3673d + ", modes=" + this.f3670a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
    }

    /* renamed from: a */
    public boolean mo3467a(IOException iOException) {
        this.f3673d = true;
        if (!this.f3672c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        boolean z = iOException instanceof SSLHandshakeException;
        if ((z && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        if (z || (iOException instanceof SSLProtocolException)) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    private boolean m9281b(SSLSocket sSLSocket) {
        for (int i = this.f3671b; i < this.f3670a.size(); i++) {
            if (this.f3670a.get(i).mo3094a(sSLSocket)) {
                return true;
            }
        }
        return false;
    }
}

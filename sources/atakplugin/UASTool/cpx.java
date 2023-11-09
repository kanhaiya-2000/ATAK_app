package atakplugin.UASTool;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Handler;
import android.os.HandlerThread;
import atakplugin.UASTool.cpv;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.coremap.filesystem.FileSystemUtils;
import com.atakmap.coremap.log.Log;
import com.atakmap.coremap.maps.coords.GeoPoint;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;

public class cpx {
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final String f4859c = "atakplugin.UASTool.cpx";

    /* renamed from: d */
    private static final char[] f4860d = "0123456789ABCDEF".toCharArray();

    /* renamed from: a */
    private DatagramSocket f4861a;

    /* renamed from: b */
    private final cpv f4862b;

    /* renamed from: e */
    private LocationManager f4863e;

    /* renamed from: f */
    private LocationListener f4864f;

    /* renamed from: g */
    private final UASItem f4865g;

    /* renamed from: h */
    private Location f4866h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Handler f4867i;

    /* renamed from: j */
    private HandlerThread f4868j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final Runnable f4869k = new cpy(this);

    /* renamed from: a */
    private static int m11979a(short s) {
        return s & 65535;
    }

    public cpx(UASItem uASItem) {
        try {
            this.f4861a = new DatagramSocket();
        } catch (SocketException e) {
            Log.e(f4859c, "error", e);
        }
        this.f4865g = uASItem;
        cpv cpv = new cpv();
        this.f4862b = cpv;
        cpv.mo4853b(cpv.f4821i);
        cpv.mo4847a(cpv.C0331b.BER);
        cpv.mo4856c(new byte[]{Ascii.f8514CR});
    }

    /* renamed from: a */
    public static String m11981a(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i] & 255;
            int i2 = i * 2;
            char[] cArr2 = f4860d;
            cArr[i2] = cArr2[b >>> 4];
            cArr[i2 + 1] = cArr2[b & Ascii.f8523SI];
        }
        return new String(cArr);
    }

    /* renamed from: a */
    public void mo4868a() {
        HandlerThread handlerThread = new HandlerThread("KLV Thread");
        this.f4868j = handlerThread;
        handlerThread.start();
        Handler handler = new Handler(this.f4868j.getLooper());
        this.f4867i = handler;
        handler.post(this.f4869k);
    }

    /* renamed from: b */
    public void mo4869b() {
        HandlerThread handlerThread = this.f4868j;
        if (handlerThread != null) {
            handlerThread.quit();
        }
        Handler handler = this.f4867i;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        this.f4867i = null;
        this.f4868j = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11983a(cpu cpu) {
        if (this.f4865g != null) {
            cpv cpv = new cpv();
            cpv.mo4853b(cpv.f4797a);
            GeoPoint geoPoint = this.f4865g.getGeoPoint();
            cpv d = m11994d(geoPoint.getLongitude());
            cpv c = m11991c(geoPoint.getLatitude());
            cpv e = m11995e(geoPoint.getAltitude());
            cpv.mo4848a(m11993d());
            cpv.mo4848a(c);
            cpv.mo4848a(d);
            cpv.mo4848a(e);
            for (cpv a : cpu.mo4840a()) {
                cpv.mo4848a(a);
            }
            cpv.mo4848a(this.f4862b);
            cpv cpv2 = new cpv();
            cpv2.mo4853b(cpv.f4815c);
            cpv2.mo4847a(cpv.C0331b.BER);
            cpv2.mo4841a(2);
            cpv.mo4848a(cpv2);
            byte[] bArr = new byte[2];
            ByteBuffer.wrap(bArr).putShort(m11982a(cpv));
            cpv.mo4856c(bArr);
            try {
                byte[] a2 = cpv.mo4851a();
                this.f4861a.send(new DatagramPacket(a2, a2.length, InetAddress.getByName("127.0.0.1"), 46695));
                Log.d(f4859c, "Sent klv.");
            } catch (IOException e2) {
                Log.d(f4859c, "Failed to send klv: ", e2);
            }
        }
    }

    /* renamed from: c */
    private cpv m11991c(double d) {
        byte[] a = m11985a(d);
        cpv cpv = new cpv();
        cpv.mo4853b(cpv.f4824l);
        cpv.mo4847a(cpv.C0331b.BER);
        cpv.mo4850a(a, 0, a.length);
        return cpv;
    }

    /* renamed from: d */
    private cpv m11994d(double d) {
        byte[] b = m11990b(d);
        cpv cpv = new cpv();
        cpv.mo4853b(cpv.f4827o);
        cpv.mo4847a(cpv.C0331b.BER);
        cpv.mo4850a(b, 0, b.length);
        return cpv;
    }

    /* renamed from: e */
    private cpv m11995e(double d) {
        byte[] bArr;
        Location location = this.f4866h;
        if (location != null) {
            bArr = m11986a((float) (location.getAltitude() + d));
        } else {
            bArr = m11986a(9999999.0f);
        }
        cpv cpv = new cpv();
        cpv.mo4853b(cpv.f4829q);
        cpv.mo4847a(cpv.C0331b.BER);
        cpv.mo4850a(bArr, 0, bArr.length);
        return cpv;
    }

    /* renamed from: d */
    private cpv m11993d() {
        cpv cpv = new cpv();
        cpv.mo4853b(cpv.f4818f);
        cpv.mo4847a(cpv.C0331b.BER);
        cpv.mo4856c(m11987a(System.nanoTime() / 1000));
        return cpv;
    }

    /* renamed from: a */
    private short m11982a(cpv cpv) {
        byte[] a = cpv.mo4851a();
        short s = 0;
        short s2 = 0;
        while (s < a.length) {
            byte b = a[s];
            int i = s + 1;
            s2 = (short) (s2 + (b << ((i % 2) * 8)));
            s = (short) i;
        }
        return s2;
    }

    /* renamed from: a */
    private byte[] m11988a(String str) {
        return str.getBytes(FileSystemUtils.UTF8_CHARSET);
    }

    /* renamed from: a */
    private byte[] m11987a(long j) {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.putLong(j);
        return allocate.array();
    }

    /* renamed from: a */
    public static byte[] m11985a(double d) {
        int intValue = Double.valueOf(d * 2.38609294111E7d).intValue();
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(intValue);
        return allocate.array();
    }

    /* renamed from: b */
    public static byte[] m11990b(double d) {
        int intValue = Double.valueOf(d * 1.19304647056E7d).intValue();
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(intValue);
        return allocate.array();
    }

    /* renamed from: a */
    private byte[] m11986a(float f) {
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.putShort((short) ((int) (((double) (f + 900.0f)) * 3.2932160804d)));
        return allocate.array();
    }
}

package atakplugin.UASTool;

import com.o3dr.services.android.lib.drone.companion.solo.controller.SoloControllerUnits;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

/* renamed from: atakplugin.UASTool.wu */
public class C1009wu implements C1007ws {

    /* renamed from: a */
    FileChannel f7530a;

    /* renamed from: b */
    String f7531b;

    public C1009wu(File file) {
        this.f7530a = new FileInputStream(file).getChannel();
        this.f7531b = file.getName();
    }

    public C1009wu(String str) {
        File file = new File(str);
        this.f7530a = new FileInputStream(file).getChannel();
        this.f7531b = file.getName();
    }

    public C1009wu(FileChannel fileChannel) {
        this.f7530a = fileChannel;
        this.f7531b = SoloControllerUnits.UNKNOWN;
    }

    public C1009wu(FileChannel fileChannel, String str) {
        this.f7530a = fileChannel;
        this.f7531b = str;
    }

    /* renamed from: a */
    public synchronized int mo5650a(ByteBuffer byteBuffer) {
        return this.f7530a.read(byteBuffer);
    }

    /* renamed from: a */
    public synchronized long mo5651a() {
        return this.f7530a.size();
    }

    /* renamed from: b */
    public synchronized long mo5655b() {
        return this.f7530a.position();
    }

    /* renamed from: a */
    public synchronized void mo5654a(long j) {
        this.f7530a.position(j);
    }

    /* renamed from: a */
    public synchronized long mo5652a(long j, long j2, WritableByteChannel writableByteChannel) {
        return this.f7530a.transferTo(j, j2, writableByteChannel);
    }

    /* renamed from: a */
    public synchronized ByteBuffer mo5653a(long j, long j2) {
        return this.f7530a.map(FileChannel.MapMode.READ_ONLY, j, j2);
    }

    public void close() {
        this.f7530a.close();
    }

    public String toString() {
        return this.f7531b;
    }
}

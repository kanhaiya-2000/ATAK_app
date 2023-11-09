package atakplugin.UASTool;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

/* renamed from: atakplugin.UASTool.wx */
public class C1012wx implements C1007ws {

    /* renamed from: a */
    FileChannel[] f7536a;

    /* renamed from: b */
    int f7537b = 0;

    public C1012wx(File... fileArr) {
        this.f7536a = new FileChannel[fileArr.length];
        for (int i = 0; i < fileArr.length; i++) {
            this.f7536a[i] = new FileInputStream(fileArr[i]).getChannel();
        }
    }

    /* renamed from: a */
    public int mo5650a(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        int read = this.f7536a[this.f7537b].read(byteBuffer);
        if (read == remaining) {
            return read;
        }
        this.f7537b++;
        return read + mo5650a(byteBuffer);
    }

    /* renamed from: a */
    public long mo5651a() {
        long j = 0;
        for (FileChannel size : this.f7536a) {
            j += size.size();
        }
        return j;
    }

    /* renamed from: b */
    public long mo5655b() {
        long j = 0;
        int i = 0;
        while (true) {
            int i2 = this.f7537b;
            if (i >= i2) {
                return j + this.f7536a[i2].position();
            }
            j += this.f7536a[i].size();
            i++;
        }
    }

    /* renamed from: a */
    public void mo5654a(long j) {
        int i = 0;
        while (true) {
            FileChannel[] fileChannelArr = this.f7536a;
            if (i < fileChannelArr.length) {
                if (j - fileChannelArr[i].size() < 0) {
                    this.f7536a[i].position(j);
                    this.f7537b = i;
                    return;
                }
                j -= this.f7536a[i].size();
                i++;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public long mo5652a(long j, long j2, WritableByteChannel writableByteChannel) {
        long j3 = j2;
        if (j3 == 0) {
            return 0;
        }
        FileChannel[] fileChannelArr = this.f7536a;
        int length = fileChannelArr.length;
        int i = 0;
        long j4 = 0;
        while (i < length) {
            FileChannel fileChannel = fileChannelArr[i];
            long size = fileChannel.size();
            if (j < j4 || j >= j4 + size || j + j3 <= j4) {
                j4 += size;
                i++;
            } else {
                long j5 = j - j4;
                long min = Math.min(j3, size - j5);
                fileChannel.transferTo(j5, min, writableByteChannel);
                return min + mo5652a(j + min, j3 - min, writableByteChannel);
            }
        }
        return 0;
    }

    /* renamed from: a */
    public ByteBuffer mo5653a(long j, long j2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(afi.m847a(j2));
        mo5652a(j, j2, Channels.newChannel(byteArrayOutputStream));
        return ByteBuffer.wrap(byteArrayOutputStream.toByteArray());
    }

    public void close() {
        for (FileChannel close : this.f7536a) {
            close.close();
        }
    }
}

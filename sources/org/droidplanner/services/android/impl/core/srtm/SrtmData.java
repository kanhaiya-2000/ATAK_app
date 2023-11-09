package org.droidplanner.services.android.impl.core.srtm;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.droidplanner.services.android.impl.core.srtm.Srtm;

public class SrtmData {
    private String path;

    /* renamed from: s */
    private BufferedInputStream f8648s;
    private File srtmFile;

    public SrtmData(String str) {
        this.path = str;
    }

    public int load(double d, double d2, Srtm.OnProgressListner onProgressListner) {
        String name = getName(d, d2);
        setupFilePaths(name);
        downloadSrtmFileIfNeeded(name, onProgressListner);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(this.srtmFile));
        this.f8648s = bufferedInputStream;
        int readHtgFile = readHtgFile(bufferedInputStream, d, d2);
        this.f8648s.close();
        return readHtgFile;
    }

    private void downloadSrtmFileIfNeeded(String str, Srtm.OnProgressListner onProgressListner) {
        if (!this.srtmFile.exists()) {
            new SrtmDownloader(onProgressListner).downloadSrtmFile(str, this.path);
        }
    }

    private void setupFilePaths(String str) {
        this.srtmFile = new File(this.path + "/" + str);
    }

    private int readHtgFile(BufferedInputStream bufferedInputStream, double d, double d2) {
        byte[] bArr = new byte[2];
        skipToDataPositionInFile(calculateFileIndex(d, d2));
        bufferedInputStream.read(bArr);
        return ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).getShort();
    }

    private void skipToDataPositionInFile(int i) {
        long j = (long) i;
        if (this.f8648s.skip(j) != j) {
            throw new Exception("error when skipping");
        }
    }

    private int calculateFileIndex(double d, double d2) {
        return (((int) Math.round((d - Math.floor(d)) * 1200.0d)) + ((1200 - ((int) Math.round((d2 - Math.floor(d2)) * 1200.0d))) * 1201)) * 2;
    }

    static String getName(double d, double d2) {
        int floor = (int) Math.floor(d);
        int floor2 = (int) Math.floor(d2);
        String str = floor2 < 0 ? "S" : "N";
        String str2 = floor < 0 ? "W" : "E";
        String valueOf = String.valueOf(Math.abs(floor2));
        while (valueOf.length() < 2) {
            valueOf = "0" + valueOf;
        }
        String str3 = str + valueOf;
        String valueOf2 = String.valueOf(Math.abs(floor));
        while (valueOf2.length() < 3) {
            valueOf2 = "0" + valueOf2;
        }
        return str3 + str2 + valueOf2 + ".hgt";
    }
}

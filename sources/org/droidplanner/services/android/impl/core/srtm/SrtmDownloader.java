package org.droidplanner.services.android.impl.core.srtm;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import org.droidplanner.services.android.impl.core.srtm.Srtm;

public class SrtmDownloader {
    static final String url = "http://dds.cr.usgs.gov/srtm/version2_1/SRTM3/";
    private Srtm.OnProgressListner listner;

    public SrtmDownloader(Srtm.OnProgressListner onProgressListner) {
        this.listner = onProgressListner;
    }

    public void downloadRegionIndex(int i, String str) {
        downloadFile(url + SrtmRegions.REGIONS[i] + "/", new File(getIndexPath(str) + (SrtmRegions.REGIONS[i] + ".index.html")));
    }

    public void downloadSrtmFile(String str, String str2) {
        String findRegion = new SrtmRegions(str2).findRegion(str, this.listner);
        File file = new File(str2 + "/" + str + ".zip");
        downloadSrtmFile(str, file, findRegion);
        UnZip.unZipIt(str, file);
        file.delete();
    }

    private void downloadSrtmFile(String str, File file, String str2) {
        try {
            downloadFile(url + str2 + "/" + str + ".zip", file);
        } catch (IOException e) {
            downloadAlternativeSrtmFile(str, file, str2, e);
        }
    }

    private void downloadAlternativeSrtmFile(String str, File file, String str2, IOException iOException) {
        if (!str.startsWith("N5") || !str2.equalsIgnoreCase("North_America")) {
            throw iOException;
        }
        downloadFile(url + str2 + "/" + str.replace(".hgt", "hgt") + ".zip", file);
    }

    private void downloadFile(String str, File file) {
        URL url2 = new URL(str);
        URLConnection openConnection = url2.openConnection();
        openConnection.connect();
        long contentLength = (long) openConnection.getContentLength();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(url2.openStream());
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        byte[] bArr = new byte[2048];
        long j = 0;
        while (true) {
            int read = bufferedInputStream.read(bArr);
            if (read != -1) {
                j += (long) read;
                bufferedOutputStream.write(bArr, 0, read);
                callListner(file.getName(), (int) ((100 * j) / contentLength));
            } else {
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
                bufferedInputStream.close();
                return;
            }
        }
    }

    private void callListner(String str, int i) {
        Srtm.OnProgressListner onProgressListner = this.listner;
        if (onProgressListner == null) {
            return;
        }
        if (i >= 0) {
            onProgressListner.onProgress(str, i);
        } else {
            onProgressListner.onProgress(str, -1);
        }
    }

    public static String getIndexPath(String str) {
        return str + "/Index/";
    }
}

package org.droidplanner.services.android.impl.core.srtm;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.ZipFile;

public class UnZip {
    public static void unZipIt(String str, File file) {
        byte[] bArr = new byte[1024];
        ZipFile zipFile = new ZipFile(file);
        InputStream inputStream = zipFile.getInputStream(zipFile.getEntry(str));
        FileOutputStream fileOutputStream = new FileOutputStream(new File(file.getParent() + "/" + str));
        while (true) {
            int read = inputStream.read(bArr);
            if (read > 0) {
                fileOutputStream.write(bArr, 0, read);
            } else {
                fileOutputStream.close();
                inputStream.close();
                zipFile.close();
                return;
            }
        }
    }
}

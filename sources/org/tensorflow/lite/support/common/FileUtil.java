package org.tensorflow.lite.support.common;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import atakplugin.UASTool.civ;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    private FileUtil() {
    }

    @civ
    public static List<String> loadLabels(@civ Context context, @civ String str) {
        return loadLabels(context, str, Charset.defaultCharset());
    }

    @civ
    public static List<String> loadLabels(@civ Context context, @civ String str, Charset charset) {
        SupportPreconditions.checkNotNull(context, "Context cannot be null.");
        SupportPreconditions.checkNotNull(str, "File path cannot be null.");
        InputStream open = context.getAssets().open(str);
        try {
            List<String> loadLabels = loadLabels(open, charset);
            if (open != null) {
                open.close();
            }
            return loadLabels;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    @civ
    public static List<String> loadLabels(@civ InputStream inputStream) {
        return loadLabels(inputStream, Charset.defaultCharset());
    }

    @civ
    public static List<String> loadLabels(@civ InputStream inputStream, Charset charset) {
        ArrayList arrayList = new ArrayList();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, charset));
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedReader.close();
                    return arrayList;
                } else if (readLine.trim().length() > 0) {
                    arrayList.add(readLine);
                }
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        }
        throw th;
    }

    @civ
    public static List<String> loadSingleColumnTextFile(@civ Context context, @civ String str, Charset charset) {
        return loadLabels(context, str, charset);
    }

    @civ
    public static List<String> loadSingleColumnTextFile(@civ InputStream inputStream, Charset charset) {
        return loadLabels(inputStream, charset);
    }

    @civ
    public static MappedByteBuffer loadMappedFile(@civ Context context, @civ String str) {
        FileInputStream fileInputStream;
        SupportPreconditions.checkNotNull(context, "Context should not be null.");
        SupportPreconditions.checkNotNull(str, "File path cannot be null.");
        AssetFileDescriptor openFd = context.getAssets().openFd(str);
        try {
            fileInputStream = new FileInputStream(openFd.getFileDescriptor());
            MappedByteBuffer map = fileInputStream.getChannel().map(FileChannel.MapMode.READ_ONLY, openFd.getStartOffset(), openFd.getDeclaredLength());
            fileInputStream.close();
            if (openFd != null) {
                openFd.close();
            }
            return map;
        } catch (Throwable th) {
            if (openFd != null) {
                try {
                    openFd.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
        throw th;
    }

    @civ
    public static byte[] loadByteFromFile(@civ Context context, @civ String str) {
        MappedByteBuffer loadMappedFile = loadMappedFile(context, str);
        byte[] bArr = new byte[loadMappedFile.remaining()];
        loadMappedFile.get(bArr);
        return bArr;
    }
}

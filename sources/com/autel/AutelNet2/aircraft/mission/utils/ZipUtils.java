package com.autel.AutelNet2.aircraft.mission.utils;

import android.util.Log;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Enumeration;
import java.util.zip.DataFormatException;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class ZipUtils {
    private static final int BUFF_SIZE = 1048576;
    public static String zipName;

    public static void zipFiles(Collection<File> collection, File file) {
        if (file.exists()) {
            file.delete();
        }
        ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file), 1048576));
        for (File zipFile : collection) {
            zipFile(zipFile, zipOutputStream, "");
        }
        zipOutputStream.close();
    }

    public static void zipFile(File file, File file2) {
        if (file2.exists()) {
            file2.delete();
        }
        ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file2), 1048576));
        zipFile(file, zipOutputStream, "");
        zipOutputStream.close();
    }

    public static void zipFiles(Collection<File> collection, File file, String str) {
        ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file), 1048576));
        for (File zipFile : collection) {
            zipFile(zipFile, zipOutputStream, "");
        }
        zipOutputStream.setComment(str);
        zipOutputStream.close();
    }

    public static void zipFile(File file, ZipOutputStream zipOutputStream, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str.trim().length() == 0 ? "" : File.separator);
        sb.append(file.getName());
        String str2 = new String(sb.toString().getBytes(), StandardCharsets.UTF_8);
        if (file.isDirectory()) {
            for (File zipFile : file.listFiles()) {
                zipFile(zipFile, zipOutputStream, str2);
            }
            return;
        }
        byte[] bArr = new byte[1048576];
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file), 1048576);
        zipOutputStream.putNextEntry(new ZipEntry(str2));
        while (true) {
            int read = bufferedInputStream.read(bArr);
            if (read != -1) {
                zipOutputStream.write(bArr, 0, read);
            } else {
                bufferedInputStream.close();
                zipOutputStream.flush();
                zipOutputStream.closeEntry();
                return;
            }
        }
    }

    public static void upZipFile(File file, String str) {
        ZipFile zipFile = new ZipFile(file);
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        byte[] bArr = new byte[1024];
        while (entries.hasMoreElements()) {
            ZipEntry zipEntry = (ZipEntry) entries.nextElement();
            if (zipEntry.isDirectory()) {
                new File(new String((str + zipEntry.getName()).getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8)).mkdir();
            } else {
                Log.d("upZipFile", "ze.getName() = " + zipEntry.getName());
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(getRealFileName(str, zipEntry.getName())));
                zipName = zipEntry.getName();
                BufferedInputStream bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(zipEntry));
                while (true) {
                    int read = bufferedInputStream.read(bArr, 0, 1024);
                    if (read == -1) {
                        break;
                    }
                    bufferedOutputStream.write(bArr, 0, read);
                }
                bufferedInputStream.close();
                bufferedOutputStream.close();
            }
        }
        zipFile.close();
    }

    private static File getRealFileName(String str, String str2) {
        String[] split = str2.split("/");
        File file = new File(str);
        file.mkdirs();
        if (split.length <= 0) {
            return file;
        }
        int i = 0;
        while (i < split.length - 1) {
            i++;
            file = new File(file, split[i]);
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, split[split.length - 1]);
    }

    public static byte[] compress(String str) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream);
            deflaterOutputStream.write(str.getBytes());
            deflaterOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String deCompress(byte[] bArr) {
        int i;
        Inflater inflater = new Inflater();
        inflater.setInput(bArr, 0, bArr.length);
        byte[] bArr2 = new byte[4194304];
        try {
            i = inflater.inflate(bArr2);
        } catch (DataFormatException e) {
            e.printStackTrace();
            i = 0;
        }
        inflater.end();
        return new String(bArr2).substring(0, i);
    }
}

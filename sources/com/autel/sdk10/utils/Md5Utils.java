package com.autel.sdk10.utils;

import com.google.common.base.Ascii;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Utils {
    protected static char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    protected static MessageDigest messagedigest;

    static {
        messagedigest = null;
        try {
            messagedigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            PrintStream printStream = System.err;
            printStream.println(Md5Utils.class.getName() + "初始化失败，MessageDigest不支持MD5Util。");
            e.printStackTrace();
        }
    }

    public static String getFileMD5String(File file) {
        String str;
        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel channel = fileInputStream.getChannel();
        MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
        try {
            MessageDigest messageDigest = (MessageDigest) messagedigest.clone();
            messageDigest.update(map);
            str = bufferToHex(messageDigest.digest());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            str = null;
        }
        channel.close();
        fileInputStream.close();
        return str;
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:32:0x0053=Splitter:B:32:0x0053, B:26:0x0047=Splitter:B:26:0x0047, B:38:0x005f=Splitter:B:38:0x005f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getFileMD5(java.io.File r4) {
        /*
            r0 = 10240(0x2800, float:1.4349E-41)
            byte[] r0 = new byte[r0]
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x000b }
            r2.<init>(r4)     // Catch:{ FileNotFoundException -> 0x000b }
            goto L_0x0010
        L_0x000b:
            r4 = move-exception
            r4.printStackTrace()
            r2 = r1
        L_0x0010:
            if (r2 != 0) goto L_0x0013
            return r1
        L_0x0013:
            java.lang.String r4 = "MD5"
            java.security.MessageDigest r4 = java.security.MessageDigest.getInstance(r4)     // Catch:{ NoSuchAlgorithmException -> 0x005d, FileNotFoundException -> 0x0051, IOException -> 0x0045, all -> 0x0043 }
            java.security.DigestInputStream r3 = new java.security.DigestInputStream     // Catch:{ NoSuchAlgorithmException -> 0x005d, FileNotFoundException -> 0x0051, IOException -> 0x0045, all -> 0x0043 }
            r3.<init>(r2, r4)     // Catch:{ NoSuchAlgorithmException -> 0x005d, FileNotFoundException -> 0x0051, IOException -> 0x0045, all -> 0x0043 }
        L_0x001e:
            int r4 = r3.read(r0)     // Catch:{ NoSuchAlgorithmException -> 0x0041, FileNotFoundException -> 0x003f, IOException -> 0x003d }
            if (r4 <= 0) goto L_0x0025
            goto L_0x001e
        L_0x0025:
            java.security.MessageDigest r4 = r3.getMessageDigest()     // Catch:{ NoSuchAlgorithmException -> 0x0041, FileNotFoundException -> 0x003f, IOException -> 0x003d }
            byte[] r4 = r4.digest()     // Catch:{ NoSuchAlgorithmException -> 0x0041, FileNotFoundException -> 0x003f, IOException -> 0x003d }
            java.lang.String r4 = byteArrayToHex(r4)     // Catch:{ NoSuchAlgorithmException -> 0x0041, FileNotFoundException -> 0x003f, IOException -> 0x003d }
            r3.close()     // Catch:{ Exception -> 0x0038 }
            r2.close()     // Catch:{ Exception -> 0x0038 }
            goto L_0x003c
        L_0x0038:
            r0 = move-exception
            r0.printStackTrace()
        L_0x003c:
            return r4
        L_0x003d:
            r4 = move-exception
            goto L_0x0047
        L_0x003f:
            r4 = move-exception
            goto L_0x0053
        L_0x0041:
            r4 = move-exception
            goto L_0x005f
        L_0x0043:
            r4 = move-exception
            goto L_0x0070
        L_0x0045:
            r4 = move-exception
            r3 = r1
        L_0x0047:
            r4.printStackTrace()     // Catch:{ all -> 0x006e }
            r3.close()     // Catch:{ Exception -> 0x0069 }
            r2.close()     // Catch:{ Exception -> 0x0069 }
            goto L_0x006d
        L_0x0051:
            r4 = move-exception
            r3 = r1
        L_0x0053:
            r4.printStackTrace()     // Catch:{ all -> 0x006e }
            r3.close()     // Catch:{ Exception -> 0x0069 }
            r2.close()     // Catch:{ Exception -> 0x0069 }
            goto L_0x006d
        L_0x005d:
            r4 = move-exception
            r3 = r1
        L_0x005f:
            r4.printStackTrace()     // Catch:{ all -> 0x006e }
            r3.close()     // Catch:{ Exception -> 0x0069 }
            r2.close()     // Catch:{ Exception -> 0x0069 }
            goto L_0x006d
        L_0x0069:
            r4 = move-exception
            r4.printStackTrace()
        L_0x006d:
            return r1
        L_0x006e:
            r4 = move-exception
            r1 = r3
        L_0x0070:
            r1.close()     // Catch:{ Exception -> 0x0077 }
            r2.close()     // Catch:{ Exception -> 0x0077 }
            goto L_0x007b
        L_0x0077:
            r0 = move-exception
            r0.printStackTrace()
        L_0x007b:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autel.sdk10.utils.Md5Utils.getFileMD5(java.io.File):java.lang.String");
    }

    public static String byteArrayToHex(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = hexDigits;
            cArr[i] = cArr2[(b >>> 4) & 15];
            i = i2 + 1;
            cArr[i2] = cArr2[b & Ascii.f8523SI];
        }
        return new String(cArr);
    }

    public static String getMD5String(String str) {
        return getMD5String(str.getBytes());
    }

    public static String getMD5String(byte[] bArr) {
        messagedigest.update(bArr);
        return bufferToHex(messagedigest.digest());
    }

    private static String bufferToHex(byte[] bArr) {
        return bufferToHex(bArr, 0, bArr.length);
    }

    private static String bufferToHex(byte[] bArr, int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer(i2 * 2);
        int i3 = i2 + i;
        while (i < i3) {
            appendHexPair(bArr[i], stringBuffer);
            i++;
        }
        return stringBuffer.toString();
    }

    private static void appendHexPair(byte b, StringBuffer stringBuffer) {
        char[] cArr = hexDigits;
        char c = cArr[(b & 240) >> 4];
        char c2 = cArr[b & Ascii.f8523SI];
        stringBuffer.append(c);
        stringBuffer.append(c2);
    }

    public static boolean checkPassword(String str, String str2) {
        return getMD5String(str).equals(str2);
    }

    public static void main(String[] strArr) {
        long currentTimeMillis = System.currentTimeMillis();
        String fileMD5String = getFileMD5String(new File("e:/新建文件夹.rar"));
        long currentTimeMillis2 = System.currentTimeMillis();
        PrintStream printStream = System.out;
        printStream.println("md5:" + fileMD5String + " leftTime:" + ((currentTimeMillis2 - currentTimeMillis) / 1000) + "s");
    }
}

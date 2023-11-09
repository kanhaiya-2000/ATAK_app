package com.autel.sdk10.AutelCommunity.utils;

import com.autel.util.okhttp.model.HttpMediaType;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;

public class MultipartEntity implements HttpEntity {
    private static final char[] MULTIPART_CHARS = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private String boundary = null;
    boolean isSetFirst;
    boolean isSetLast;
    ByteArrayOutputStream out = new ByteArrayOutputStream();

    public Header getContentEncoding() {
        return null;
    }

    public boolean isChunked() {
        return false;
    }

    public boolean isRepeatable() {
        return false;
    }

    public boolean isStreaming() {
        return false;
    }

    public MultipartEntity() {
        this.isSetLast = false;
        this.isSetFirst = false;
        StringBuffer stringBuffer = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            char[] cArr = MULTIPART_CHARS;
            stringBuffer.append(cArr[random.nextInt(cArr.length)]);
        }
        this.boundary = stringBuffer.toString();
    }

    public void writeFirstBoundaryIfNeeds() {
        if (!this.isSetFirst) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = this.out;
                byteArrayOutputStream.write(("--" + this.boundary + "\r\n").getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.isSetFirst = true;
    }

    public void writeLastBoundaryIfNeeds() {
        if (!this.isSetLast) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = this.out;
                byteArrayOutputStream.write(("\r\n--" + this.boundary + "--\r\n").getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.isSetLast = true;
        }
    }

    public void addPart(String str, String str2) {
        writeFirstBoundaryIfNeeds();
        try {
            ByteArrayOutputStream byteArrayOutputStream = this.out;
            byteArrayOutputStream.write(("Content-Disposition: form-data; name=\"" + str + "\"\r\n\r\n").getBytes());
            this.out.write(str2.getBytes());
            ByteArrayOutputStream byteArrayOutputStream2 = this.out;
            byteArrayOutputStream2.write(("\r\n--" + this.boundary + "\r\n").getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addPart(String str, String str2, InputStream inputStream, boolean z) {
        addPart(str, str2, inputStream, HttpMediaType.MEDIA_TYPE_STREAM, z);
    }

    public void addPart(String str, String str2, InputStream inputStream, String str3, boolean z) {
        writeFirstBoundaryIfNeeds();
        try {
            this.out.write(("Content-Disposition: form-data; name=\"" + str + "\"; filename=\"" + str2 + "\"\r\n").getBytes());
            this.out.write(("Content-Type: " + str3 + "\r\n").getBytes());
            this.out.write("Content-Transfer-VideoEncodeFormat: binary\r\n\r\n".getBytes());
            byte[] bArr = new byte[4096];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                this.out.write(bArr, 0, read);
            }
            if (!z) {
                this.out.write(("\r\n--" + this.boundary + "\r\n").getBytes());
            }
            this.out.flush();
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            inputStream.close();
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            throw th;
        }
    }

    public void addPart(String str, File file, boolean z) {
        try {
            addPart(str, file.getName(), new FileInputStream(file), z);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public long getContentLength() {
        writeLastBoundaryIfNeeds();
        return (long) this.out.toByteArray().length;
    }

    public Header getContentType() {
        return new BasicHeader("Content-Type", "multipart/form-data; boundary=" + this.boundary);
    }

    public void writeTo(OutputStream outputStream) {
        outputStream.write(this.out.toByteArray());
    }

    public void consumeContent() {
        if (isStreaming()) {
            throw new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
        }
    }

    public InputStream getContent() {
        return new ByteArrayInputStream(this.out.toByteArray());
    }
}

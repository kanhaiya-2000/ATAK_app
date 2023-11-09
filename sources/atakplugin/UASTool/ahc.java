package atakplugin.UASTool;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ahc {

    /* renamed from: a */
    InputStream f1234a;

    /* renamed from: b */
    OutputStream f1235b;

    /* renamed from: c */
    OutputStream f1236c;

    /* renamed from: d */
    private boolean f1237d = false;

    /* renamed from: e */
    private boolean f1238e = false;

    /* renamed from: f */
    private boolean f1239f = false;

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo857a(OutputStream outputStream) {
        this.f1235b = outputStream;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo858a(OutputStream outputStream, boolean z) {
        this.f1238e = z;
        mo857a(outputStream);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo862b(OutputStream outputStream) {
        this.f1236c = outputStream;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo863b(OutputStream outputStream, boolean z) {
        this.f1239f = z;
        mo862b(outputStream);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo855a(InputStream inputStream) {
        this.f1234a = inputStream;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo856a(InputStream inputStream, boolean z) {
        this.f1237d = z;
        mo855a(inputStream);
    }

    /* renamed from: a */
    public void mo854a(ahy ahy) {
        this.f1235b.write(ahy.f1376a.f888b, 0, ahy.f1376a.f889c);
        this.f1235b.flush();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo860a(byte[] bArr, int i, int i2) {
        this.f1235b.write(bArr, i, i2);
        this.f1235b.flush();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo864b(byte[] bArr, int i, int i2) {
        this.f1236c.write(bArr, i, i2);
        this.f1236c.flush();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo853a() {
        return this.f1234a.read();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo859a(byte[] bArr) {
        mo866c(bArr, 0, bArr.length);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo866c(byte[] bArr, int i, int i2) {
        do {
            int read = this.f1234a.read(bArr, i, i2);
            if (read >= 0) {
                i += read;
                i2 -= read;
            } else {
                throw new IOException("End of IO Stream Read");
            }
        } while (i2 > 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo861b() {
        try {
            OutputStream outputStream = this.f1235b;
            if (outputStream != null && !this.f1238e) {
                outputStream.close();
            }
            this.f1235b = null;
        } catch (Exception unused) {
        }
    }

    /* renamed from: c */
    public void mo865c() {
        try {
            InputStream inputStream = this.f1234a;
            if (inputStream != null && !this.f1237d) {
                inputStream.close();
            }
            this.f1234a = null;
        } catch (Exception unused) {
        }
        mo861b();
        try {
            OutputStream outputStream = this.f1236c;
            if (outputStream != null && !this.f1239f) {
                outputStream.close();
            }
            this.f1236c = null;
        } catch (Exception unused2) {
        }
    }
}

package atakplugin.UASTool;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

final class bvk implements bvj {
    bvk() {
    }

    /* renamed from: a */
    public bxr mo3710a(File file) {
        return bxb.m10343c(file);
    }

    /* renamed from: b */
    public bxp mo3712b(File file) {
        try {
            return bxb.m10332a(file);
        } catch (FileNotFoundException unused) {
            file.getParentFile().mkdirs();
            return bxb.m10332a(file);
        }
    }

    /* renamed from: c */
    public bxp mo3713c(File file) {
        try {
            return bxb.m10340b(file);
        } catch (FileNotFoundException unused) {
            file.getParentFile().mkdirs();
            return bxb.m10340b(file);
        }
    }

    /* renamed from: d */
    public void mo3714d(File file) {
        if (!file.delete() && file.exists()) {
            throw new IOException("failed to delete " + file);
        }
    }

    /* renamed from: e */
    public boolean mo3715e(File file) {
        return file.exists();
    }

    /* renamed from: f */
    public long mo3716f(File file) {
        return file.length();
    }

    /* renamed from: a */
    public void mo3711a(File file, File file2) {
        mo3714d(file2);
        if (!file.renameTo(file2)) {
            throw new IOException("failed to rename " + file + " to " + file2);
        }
    }

    /* renamed from: g */
    public void mo3717g(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            int length = listFiles.length;
            int i = 0;
            while (i < length) {
                File file2 = listFiles[i];
                if (file2.isDirectory()) {
                    mo3717g(file2);
                }
                if (file2.delete()) {
                    i++;
                } else {
                    throw new IOException("failed to delete " + file2);
                }
            }
            return;
        }
        throw new IOException("not a readable directory: " + file);
    }
}

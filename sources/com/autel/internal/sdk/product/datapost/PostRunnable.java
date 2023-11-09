package com.autel.internal.sdk.product.datapost;

import android.media.MediaScannerConnection;
import com.autel.internal.sdk.AutelBaseApplication;
import com.autel.util.log.AutelConfig;
import com.autel.util.log.AutelLog;
import com.autel.util.log.LocalLogUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;

public abstract class PostRunnable implements Runnable {
    private boolean uiThread = true;

    /* access modifiers changed from: protected */
    public abstract void task();

    public PostRunnable() {
    }

    public PostRunnable(boolean z) {
        this.uiThread = z;
    }

    public boolean isRunOnUiThread() {
        return this.uiThread;
    }

    public void run() {
        if (AutelConfig.AUTEL_DEBUG_LOG) {
            task();
            return;
        }
        try {
            task();
        } catch (Exception e) {
            AutelLog.m15084e("PostRunnable", "PostRunnable error " + e.getMessage());
            try {
                File file = new File(LocalLogUtil.getLogPath("local_log_temp"));
                if (!file.exists()) {
                    file.createNewFile();
                }
                PrintStream printStream = new PrintStream(new FileOutputStream(file, true));
                printStream.print(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(System.currentTimeMillis())));
                printStream.println();
                e.printStackTrace(printStream);
                printStream.close();
                MediaScannerConnection.scanFile(AutelBaseApplication.getAppContext(), new String[]{LocalLogUtil.getLogPath("local_log_temp")}, (String[]) null, (MediaScannerConnection.OnScanCompletedListener) null);
            } catch (IOException e2) {
                e2.printStackTrace();
                AutelLog.debug_i(AutelLog.TMP_CONNECT_ATG, "PostRunnable write error log failed " + e2.getMessage());
            }
            AutelLog.debug_i(AutelLog.TMP_CONNECT_ATG, "PostRunnable error " + e.getMessage() + "  id  " + this);
        }
    }
}

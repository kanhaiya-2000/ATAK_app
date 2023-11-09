package com.o3dr.android.client.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import atakplugin.UASTool.cqb;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class LogToFileTree extends cqb.C0333a {
    /* access modifiers changed from: private */
    public static final SimpleDateFormat FILE_DATE_FORMAT = new SimpleDateFormat("yyyy_MM_dd_HH_mm", Locale.US);
    private static final SimpleDateFormat LOG_DATE_FORMAT = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.US);
    private final Date date = new Date();
    private Thread dequeueThread;
    /* access modifiers changed from: private */
    public final AtomicBoolean isRunning = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public PrintStream logOutputFile;
    /* access modifiers changed from: private */
    public final LinkedBlockingQueue<String> logQueue = new LinkedBlockingQueue<>();

    private String getPriorityString(int i) {
        switch (i) {
            case 2:
                return "V";
            case 3:
                return "D";
            case 4:
                return "I";
            case 5:
                return "W";
            case 6:
                return "E";
            case 7:
                return "ASSERT";
            default:
                return "";
        }
    }

    private boolean isLoggableToFile(int i) {
        return i >= 3;
    }

    /* access modifiers changed from: protected */
    public void log(int i, String str, String str2, Throwable th) {
        super.log(i, str, str2, th);
        if (isLoggableToFile(i)) {
            this.logQueue.add(getLogMessage(i, str, str2));
        }
    }

    private String getLogMessage(int i, String str, String str2) {
        String priorityString = getPriorityString(i);
        this.date.setTime(System.currentTimeMillis());
        return String.format("%s %s/%s : %s", new Object[]{LOG_DATE_FORMAT.format(this.date), priorityString, str, str2});
    }

    public void createFileStartLogging(final Context context) {
        Thread thread = this.dequeueThread;
        if (thread != null && thread.isAlive()) {
            stopLoggingThread();
        }
        this.dequeueThread = new Thread(new Runnable() {
            public void run() {
                String str;
                try {
                    str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
                } catch (PackageManager.NameNotFoundException unused) {
                    cqb.m12012d("Failed to get package info", new Object[0]);
                    str = "";
                }
                File file = new File(context.getExternalFilesDir((String) null), "/log_cat/");
                file.mkdirs();
                try {
                    PrintStream unused2 = LogToFileTree.this.logOutputFile = new PrintStream(new FileOutputStream(new File(file, String.format("%s_%s.log", new Object[]{str, LogToFileTree.FILE_DATE_FORMAT.format(new Date())})), true));
                    while (LogToFileTree.this.isRunning.get()) {
                        try {
                            LogToFileTree.this.logOutputFile.println((String) LogToFileTree.this.logQueue.take());
                        } catch (InterruptedException unused3) {
                            cqb.m12012d("Failed to receive message from logQueue", new Object[0]);
                        }
                    }
                    LogToFileTree.this.isRunning.set(false);
                    if (LogToFileTree.this.logOutputFile == null) {
                        return;
                    }
                } catch (IOException unused4) {
                    cqb.m12012d("Failed to open file", new Object[0]);
                    LogToFileTree.this.isRunning.set(false);
                    if (LogToFileTree.this.logOutputFile == null) {
                        return;
                    }
                } catch (Throwable th) {
                    LogToFileTree.this.isRunning.set(false);
                    if (LogToFileTree.this.logOutputFile != null) {
                        LogToFileTree.this.logOutputFile.close();
                    }
                    throw th;
                }
                LogToFileTree.this.logOutputFile.close();
            }
        });
        this.isRunning.set(true);
        this.dequeueThread.start();
    }

    public void stopLoggingThread() {
        if (this.dequeueThread != null) {
            this.isRunning.set(false);
            this.dequeueThread.interrupt();
            this.dequeueThread = null;
        }
    }
}

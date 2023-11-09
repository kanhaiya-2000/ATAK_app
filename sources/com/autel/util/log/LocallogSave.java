package com.autel.util.log;

import android.content.Intent;
import com.autel.internal.sdk.AutelBaseApplication;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class LocallogSave {
    private static final long FILE_MAX_SIZE = 10485760;
    private static final String LOCAL_LOG_FILENAME_1 = "local_log_filename_1";
    private static final String LOCAL_LOG_FILENAME_2 = "local_log_filename_2";
    private static final String LOCAL_LOG_FILENAME_3 = "local_log_filename_3";
    private static final String NECESSARY_LOGKEY = "NECESSARY_LOGKEY";
    private static final String NECESSARY_LOG_FILENAME = "local_log_0";
    private static final String NECESSARY_LOG_FILENAME_01 = "local_log_1";
    /* access modifiers changed from: private */
    public static final Object lockOfWork = new Object();
    /* access modifiers changed from: private */
    public static boolean mIsLoop = true;
    /* access modifiers changed from: private */
    public static List<LogTask> taskList;
    /* access modifiers changed from: private */
    public static LogWriteThread workThread;

    public static void writeLog(String str, String str2) {
    }

    /* access modifiers changed from: private */
    public static void saveLocalLog(String str) {
        long fileSize = LocalLogUtil.getFileSize(LocalLogUtil.getLogPath(LOCAL_LOG_FILENAME_1));
        long logSize = getLogSize(str);
        if (fileSize + logSize < FILE_MAX_SIZE) {
            LocalLogUtil.writeLog(LOCAL_LOG_FILENAME_1, str);
        } else if (LocalLogUtil.getFileSize(LocalLogUtil.getLogPath(LOCAL_LOG_FILENAME_2)) + logSize < FILE_MAX_SIZE) {
            LocalLogUtil.writeLog(LOCAL_LOG_FILENAME_2, str);
        } else if (LocalLogUtil.getFileSize(LocalLogUtil.getLogPath(LOCAL_LOG_FILENAME_3)) + logSize < FILE_MAX_SIZE) {
            LocalLogUtil.writeLog(LOCAL_LOG_FILENAME_3, str);
        } else {
            reNameFile();
            saveLocalLog(str);
        }
    }

    /* access modifiers changed from: private */
    public static void saveNecessaryLog(String str) {
        long fileSize = LocalLogUtil.getFileSize(LocalLogUtil.getLogPath(NECESSARY_LOG_FILENAME));
        long logSize = getLogSize(str);
        if (fileSize + logSize < FILE_MAX_SIZE) {
            LocalLogUtil.writeLog(NECESSARY_LOG_FILENAME, str);
        } else if (LocalLogUtil.getFileSize(LocalLogUtil.getLogPath(NECESSARY_LOG_FILENAME_01)) + logSize < FILE_MAX_SIZE) {
            LocalLogUtil.writeLog(NECESSARY_LOG_FILENAME_01, str);
        } else {
            if (new File(LocalLogUtil.getLogPath(NECESSARY_LOG_FILENAME)).exists()) {
                delLocalLogFile(NECESSARY_LOG_FILENAME);
            }
            File file = new File(LocalLogUtil.getLogPath(NECESSARY_LOG_FILENAME_01));
            if (file.exists()) {
                file.renameTo(getFile(LocalLogUtil.getLogPath(NECESSARY_LOG_FILENAME)));
            }
            saveNecessaryLog(str);
        }
    }

    private static void reNameFile() {
        try {
            if (new File(LocalLogUtil.getLogPath(LOCAL_LOG_FILENAME_1)).exists()) {
                delLocalLogFile(LOCAL_LOG_FILENAME_1);
            }
            File file = new File(LocalLogUtil.getLogPath(LOCAL_LOG_FILENAME_2));
            if (file.exists()) {
                file.renameTo(getFile(LocalLogUtil.getLogPath(LOCAL_LOG_FILENAME_1)));
            }
            File file2 = new File(LocalLogUtil.getLogPath(LOCAL_LOG_FILENAME_3));
            if (file2.exists()) {
                file2.renameTo(getFile(LocalLogUtil.getLogPath(LOCAL_LOG_FILENAME_2)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static File getFile(String str) {
        try {
            return new File(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static long getLogSize(String str) {
        if (str == null) {
            return 0;
        }
        try {
            return (long) str.length();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    private static void delLocalLogFile(String str) {
        try {
            new File(LocalLogUtil.getLogPath(str)).delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void debug_writeNecessaryLog(String str) {
        LocalLogUtil.writeExpection(str);
        LogTask logTask = new LogTask(NECESSARY_LOGKEY, str);
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace != null && stackTrace.length >= 5) {
            StackTraceElement stackTraceElement = stackTrace[4];
            logTask.location = stackTraceElement.getClassName() + ":" + stackTraceElement.getMethodName();
        }
        addTask(logTask);
    }

    private static void addTask(LogTask logTask) {
        if (taskList == null) {
            taskList = new ArrayList();
        }
        taskList.add(logTask);
        startWriteLog();
    }

    private static void startWriteLog() {
        synchronized (lockOfWork) {
            LogWriteThread logWriteThread = workThread;
            if (logWriteThread == null || !logWriteThread.isAlive()) {
                LogWriteThread logWriteThread2 = new LogWriteThread();
                workThread = logWriteThread2;
                logWriteThread2.start();
            }
        }
    }

    private static class LogWriteThread extends Thread {
        private LogWriteThread() {
        }

        public void run() {
            super.run();
            while (LocallogSave.mIsLoop) {
                try {
                    boolean z = false;
                    if (LocallogSave.taskList == null || LocallogSave.taskList.size() <= 0) {
                        synchronized (LocallogSave.lockOfWork) {
                            if (LocallogSave.taskList == null || LocallogSave.taskList.size() == 0) {
                                LogWriteThread unused = LocallogSave.workThread = null;
                                z = true;
                            }
                        }
                        if (z) {
                            return;
                        }
                    } else {
                        LogTask logTask = (LogTask) LocallogSave.taskList.remove(0);
                        if (AutelConfig.AUTEL_USB_LOG) {
                            Intent intent = new Intent(LogClient.ACTION_MSG);
                            intent.putExtra("strMsg", "log_type:" + logTask.type + " " + logTask.writeTime + " log: " + logTask.log);
                            AutelBaseApplication.getAppContext().sendBroadcast(intent);
                        }
                        if (!logTask.type.startsWith(LocallogSave.NECESSARY_LOGKEY)) {
                            LocallogSave.saveLocalLog(logTask.writeTime + "    log_type:" + logTask.type + "    location:" + logTask.location + "\n" + logTask.log);
                        } else {
                            if (logTask.isStartLog) {
                                LocallogSave.saveNecessaryLog("\n*********************************************************************************************");
                            }
                            LocallogSave.saveNecessaryLog(logTask.writeTime + "  " + logTask.type.substring(16) + ":  " + logTask.log);
                            if (logTask.isEndLog) {
                                LocallogSave.saveNecessaryLog("*********************************************************************************************\n");
                            }
                        }
                    }
                } catch (Exception unused2) {
                    synchronized (LocallogSave.lockOfWork) {
                        LogWriteThread unused3 = LocallogSave.workThread = null;
                        return;
                    }
                }
            }
        }
    }

    public static void writeNecessaryLog(String str, String str2, boolean z, boolean z2) {
        LocalLogUtil.writeExpection(str2);
        LogTask logTask = new LogTask(NECESSARY_LOGKEY + str, str2);
        logTask.isStartLog = z;
        logTask.isEndLog = z2;
        addTask(logTask);
    }

    public static void writeNecessaryLog(String str, String str2) {
        writeNecessaryLog(str, str2, false, false);
    }
}

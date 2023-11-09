package com.atakmap.android.uastool.toastlog;

import com.atakmap.coremap.locale.LocaleUtil;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ToastLogItem {
    private static final SimpleDateFormat dateformat = new SimpleDateFormat("MMM dd, yyyy HH:mm:ss", LocaleUtil.US);
    private final String message;
    private final long timestampMillis;

    public ToastLogItem(long j, String str) {
        this.timestampMillis = j;
        this.message = str;
    }

    private long getTimestamp() {
        return this.timestampMillis;
    }

    public String getDateString() {
        return dateformat.format(new Date(getTimestamp()));
    }

    public String getMessage() {
        return this.message;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ToastLogItem) {
            ToastLogItem toastLogItem = (ToastLogItem) obj;
            return toastLogItem.getTimestamp() == this.timestampMillis && toastLogItem.getMessage().equals(this.message);
        }
    }
}

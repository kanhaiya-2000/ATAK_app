package com.o3dr.android.client.utils.data.tlog;

import com.o3dr.android.client.utils.data.tlog.TLogParser;

public interface TLogIteratorCallback {
    void onFailed(Exception exc);

    void onResult(TLogParser.Event event);
}

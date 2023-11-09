package com.o3dr.android.client.utils.data.tlog;

import com.o3dr.android.client.utils.data.tlog.TLogParser;

public interface TLogIteratorFilter {
    boolean acceptEvent(TLogParser.Event event);
}

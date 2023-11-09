package com.o3dr.android.client.utils.data.tlog;

import com.o3dr.android.client.utils.data.tlog.TLogParser;

public interface TLogParserFilter {
    boolean includeEvent(TLogParser.Event event);

    boolean shouldIterate();
}

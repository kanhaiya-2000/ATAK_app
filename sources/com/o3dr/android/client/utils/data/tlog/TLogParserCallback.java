package com.o3dr.android.client.utils.data.tlog;

import com.o3dr.android.client.utils.data.tlog.TLogParser;
import java.util.List;

public interface TLogParserCallback {
    void onFailed(Exception exc);

    void onResult(List<TLogParser.Event> list);
}

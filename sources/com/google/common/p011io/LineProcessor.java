package com.google.common.p011io;

/* renamed from: com.google.common.io.LineProcessor */
public interface LineProcessor<T> {
    T getResult();

    boolean processLine(String str);
}

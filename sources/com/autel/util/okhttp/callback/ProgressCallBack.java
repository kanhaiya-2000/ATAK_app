package com.autel.util.okhttp.callback;

public abstract class ProgressCallBack<T> extends ResponseCallBack<T> {
    public abstract void Progress(long j, long j2);
}

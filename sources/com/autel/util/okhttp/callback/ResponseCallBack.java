package com.autel.util.okhttp.callback;

public abstract class ResponseCallBack<T> {
    public abstract void onFailure(Throwable th);

    public boolean onInterrupt(ResponseInterface responseInterface) {
        return false;
    }

    public void onStart() {
    }

    public abstract void onSuccess(T t);

    public T convert(ResponseInterface responseInterface) {
        return responseInterface.getString();
    }
}

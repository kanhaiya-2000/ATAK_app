package com.autel.util.okhttp.callback;

import com.autel.internal.sdk.camera.BaseCameraMsgParser;

public abstract class CameraMsgResponseCallback<T> extends ResponseCallBack<T> {
    private static final String TAG = "RequestManager";

    /* access modifiers changed from: protected */
    public abstract T convertFromParser(BaseCameraMsgParser baseCameraMsgParser);

    public abstract void onFailure(Throwable th);

    public boolean onInterrupt(ResponseInterface responseInterface) {
        return false;
    }

    public void onStart() {
    }

    public abstract void onSuccess(T t);

    public final T convert(ResponseInterface responseInterface) {
        BaseCameraMsgParser baseCameraMsgParser = new BaseCameraMsgParser();
        baseCameraMsgParser.parserData(responseInterface.getString());
        return convertFromParser(baseCameraMsgParser);
    }
}

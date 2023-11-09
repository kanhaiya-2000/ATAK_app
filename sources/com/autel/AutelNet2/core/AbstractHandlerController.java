package com.autel.AutelNet2.core;

import com.autel.common.CallbackWithOneParam;
import com.autel.common.CallbackWithTwoParams;
import com.autel.common.error.AutelError;
import com.autel.internal.sdk.product.datapost.MsgPostManager;
import com.autel.internal.sdk.product.datapost.PostRunnable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractHandlerController {
    /* access modifiers changed from: protected */
    public void callbackSucc(final CallbackWithOneParam callbackWithOneParam, final Object obj) {
        if (callbackWithOneParam != null) {
            MsgPostManager.instance().post(new PostRunnable() {
                /* access modifiers changed from: protected */
                public void task() {
                    callbackWithOneParam.onSuccess(obj);
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public <T, D> void callbackSucc(final CallbackWithTwoParams<T, D> callbackWithTwoParams, final T t, final D d) {
        if (callbackWithTwoParams != null) {
            MsgPostManager.instance().post(new PostRunnable() {
                /* access modifiers changed from: protected */
                public void task() {
                    callbackWithTwoParams.onSuccess(t, d);
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void callbackFail(final CallbackWithOneParam callbackWithOneParam, final AutelError autelError) {
        if (callbackWithOneParam != null) {
            MsgPostManager.instance().post(new PostRunnable() {
                /* access modifiers changed from: protected */
                public void task() {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public <T> void iteratorCallback(ConcurrentHashMap<String, CallbackWithOneParam<T>> concurrentHashMap, Object obj) {
        for (Map.Entry<String, CallbackWithOneParam<T>> key : concurrentHashMap.entrySet()) {
            CallbackWithOneParam callbackWithOneParam = concurrentHashMap.get((String) key.getKey());
            if (!(callbackWithOneParam == null || callbackWithOneParam.getClass() == null)) {
                callbackSucc(callbackWithOneParam, obj);
            }
        }
    }

    /* access modifiers changed from: protected */
    public <T, D> void iteratorCallback(ConcurrentHashMap<String, CallbackWithTwoParams<T, D>> concurrentHashMap, T t, D d) {
        for (Map.Entry<String, CallbackWithTwoParams<T, D>> key : concurrentHashMap.entrySet()) {
            CallbackWithTwoParams callbackWithTwoParams = concurrentHashMap.get((String) key.getKey());
            if (!(callbackWithTwoParams == null || callbackWithTwoParams.getClass() == null)) {
                callbackSucc(callbackWithTwoParams, t, d);
            }
        }
    }
}

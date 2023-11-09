package com.autel.sdk10.interfaces;

import com.autel.common.error.AutelError;

public class AutelCompletionCallback {

    public interface ICompletionCallback {
        void onResult(AutelError autelError);
    }

    public interface ICompletionCallbackWith<T> {
        void onFailure(AutelError autelError);

        void onResult(T t);
    }
}

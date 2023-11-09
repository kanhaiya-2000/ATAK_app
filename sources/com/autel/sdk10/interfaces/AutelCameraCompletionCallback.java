package com.autel.sdk10.interfaces;

import com.autel.common.error.AutelError;

public class AutelCameraCompletionCallback {

    public interface ICompletionCameraSettingCallbackWith<T> {
        void onFailure(AutelError autelError);

        void onResult(T t);
    }

    public interface ICompletionCameraStatusCallbackWith<T> {
        void onFailure(AutelError autelError);

        void onResult(T t);
    }
}

package com.autel.sdk10.interfaces;

public class IAutelCameraLongTimeCallback {

    public interface IAutelCameraLongTimeCallbackWith<T> {
        void onReceiveMsg(T t);
    }
}

package com.autel.sdk10.AutelNet.AutelRemoteController.interfaces;

public class IAutelRCLongTimeCallback {

    public interface IAutelRCLongTimeCallbackWith<T> {
        void onReceiveMsg(T t);
    }
}

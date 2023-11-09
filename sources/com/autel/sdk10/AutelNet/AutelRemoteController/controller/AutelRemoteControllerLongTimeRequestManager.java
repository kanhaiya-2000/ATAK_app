package com.autel.sdk10.AutelNet.AutelRemoteController.controller;

import com.autel.common.remotecontroller.RemoteControllerNavigateButtonEvent;
import com.autel.internal.sdk.product.datapost.MsgPostManager;
import com.autel.internal.sdk.product.datapost.PostRunnable;
import com.autel.sdk10.AutelNet.AutelRemoteController.engine.RCCommandMessage;
import com.autel.sdk10.AutelNet.AutelRemoteController.enums.AutelRCUploadDataSwitch;
import com.autel.sdk10.AutelNet.AutelRemoteController.interfaces.IAutelRCLongTimeCallback;
import com.autel.sdk10.AutelNet.AutelRemoteController.parser.RCRespondMsgParser;
import com.autel.sdk10.interfaces.AutelCompletionCallback;

public abstract class AutelRemoteControllerLongTimeRequestManager {
    /* access modifiers changed from: protected */
    public abstract void addIAutelRCLongTimeCallbackWith(String str, RCCommandMessage rCCommandMessage, IAutelRCLongTimeCallback.IAutelRCLongTimeCallbackWith iAutelRCLongTimeCallbackWith);

    /* access modifiers changed from: protected */
    public abstract void removeIAutelRCLongTimeCallbackWith(String str);

    /* access modifiers changed from: private */
    public void callbackReceiveMsg(final IAutelRCLongTimeCallback.IAutelRCLongTimeCallbackWith iAutelRCLongTimeCallbackWith, final Object obj) {
        MsgPostManager.instance().post(new PostRunnable() {
            /* access modifiers changed from: protected */
            public void task() {
                IAutelRCLongTimeCallback.IAutelRCLongTimeCallbackWith iAutelRCLongTimeCallbackWith = iAutelRCLongTimeCallbackWith;
                if (iAutelRCLongTimeCallbackWith != null) {
                    iAutelRCLongTimeCallbackWith.onReceiveMsg(obj);
                }
            }
        });
    }

    /* renamed from: a */
    public void mo19487a(String str, final IAutelRCLongTimeCallback.IAutelRCLongTimeCallbackWith<Integer> iAutelRCLongTimeCallbackWith) {
        RCCommandMessage rCCommandMessage = new RCCommandMessage();
        rCCommandMessage.createQueryGimbalAngleParams();
        addIAutelRCLongTimeCallbackWith(str, rCCommandMessage, new IAutelRCLongTimeCallback.IAutelRCLongTimeCallbackWith<RCRespondMsgParser>() {
            public void onReceiveMsg(RCRespondMsgParser rCRespondMsgParser) {
                AutelRemoteControllerLongTimeRequestManager.this.callbackReceiveMsg(iAutelRCLongTimeCallbackWith, Integer.valueOf(rCRespondMsgParser.getGimbalAngle()));
            }
        });
    }

    /* renamed from: b */
    public void mo19492b(String str) {
        removeIAutelRCLongTimeCallbackWith(str);
    }

    public void addQueryRCUploadDataCallback(String str, final IAutelRCLongTimeCallback.IAutelRCLongTimeCallbackWith<int[]> iAutelRCLongTimeCallbackWith) {
        RCCommandMessage rCCommandMessage = new RCCommandMessage();
        rCCommandMessage.createQueryRCUploadDataParams(AutelRCUploadDataSwitch.OPEN.getValue());
        addIAutelRCLongTimeCallbackWith(str, rCCommandMessage, new IAutelRCLongTimeCallback.IAutelRCLongTimeCallbackWith<RCRespondMsgParser>() {
            public void onReceiveMsg(RCRespondMsgParser rCRespondMsgParser) {
                AutelRemoteControllerLongTimeRequestManager.this.callbackReceiveMsg(iAutelRCLongTimeCallbackWith, rCRespondMsgParser.getRCUploadData());
            }
        });
    }

    public void removeQueryRCUploadDataCallback(String str) {
        removeIAutelRCLongTimeCallbackWith(str);
    }

    public void addQueryRCInfoDataCallback(String str, final IAutelRCLongTimeCallback.IAutelRCLongTimeCallbackWith<int[]> iAutelRCLongTimeCallbackWith) {
        RCCommandMessage rCCommandMessage = new RCCommandMessage();
        rCCommandMessage.createQueryRCInfoDataParams();
        addIAutelRCLongTimeCallbackWith(str, rCCommandMessage, new IAutelRCLongTimeCallback.IAutelRCLongTimeCallbackWith<RCRespondMsgParser>() {
            public void onReceiveMsg(RCRespondMsgParser rCRespondMsgParser) {
                AutelRemoteControllerLongTimeRequestManager.this.callbackReceiveMsg(iAutelRCLongTimeCallbackWith, rCRespondMsgParser.getRCInfoData());
            }
        });
    }

    public void removeQueryRCInfoDataCallback(String str) {
        removeIAutelRCLongTimeCallbackWith(str);
    }

    public void addRemoteControllerButtonListener(String str, AutelCompletionCallback.ICompletionCallbackWith<RemoteControllerNavigateButtonEvent> iCompletionCallbackWith) {
        RemoteControllerButtonManager.getInstance().addRemoteButtonControllerListener(str, iCompletionCallbackWith);
    }

    public void removeRemoteControllerButtonListener(String str) {
        RemoteControllerButtonManager.getInstance().removeRemoteButtonControllerListener(str);
    }
}

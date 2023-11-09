package com.autel.AutelNet2.remotecontroller.message;

import com.autel.AutelNet2.constant.MsgType;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.core.message.MsgHead;
import com.autel.camera.protocol.protocol20.entity.CameraParamsConfig;
import com.autel.common.remotecontroller.RemoteControllerNavigateButtonEvent;
import org.json.JSONObject;

public class RCButtonPacket extends BaseMsgPacket {
    private static final int ACTION_01 = 1;
    private static final int ACTION_02 = 2;
    private static final int ACTION_03 = 3;
    private static final int ACTION_04 = 4;
    private static final int ACTION_05 = 5;
    private static final int ACTION_07 = 7;
    private static final int ACTION_08 = 8;
    private static final int LONG_PRESS = 1;
    private static final int SHORT_PRESS = 0;
    private static final int WHEEL_LEFT = 1;
    private static final int WHEEL_RIGHT = 2;
    private RemoteControllerNavigateButtonEvent mAutelRCControlBtnEvent;

    /* access modifiers changed from: protected */
    public String loadBody() {
        return null;
    }

    public RCButtonPacket(MsgHead msgHead, byte[] bArr) {
        setHead(msgHead);
        setBody(bArr);
    }

    public void setAutelRCControlBtnEvent(RemoteControllerNavigateButtonEvent remoteControllerNavigateButtonEvent) {
        this.mAutelRCControlBtnEvent = remoteControllerNavigateButtonEvent;
    }

    public RemoteControllerNavigateButtonEvent getAutelRCControlBtnEvent() {
        return this.mAutelRCControlBtnEvent;
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
        this.msg_head.msg_type = MsgType.AU_BUTTON_PHOTO_RECORD_RESP;
    }

    public BaseMsgPacket parseBody() {
        JSONObject jSONObject = getBodyJson().getJSONObject("params");
        int i = jSONObject.getInt("KeyId");
        int i2 = jSONObject.getInt("KeyTime");
        int i3 = jSONObject.getInt("KeyValue");
        jSONObject.getInt(CameraParamsConfig.param_Status);
        switch (i) {
            case 1:
                if (i3 != 1) {
                    if (i3 != 2) {
                        this.mAutelRCControlBtnEvent = RemoteControllerNavigateButtonEvent.UNKNOWN;
                        break;
                    } else {
                        this.mAutelRCControlBtnEvent = RemoteControllerNavigateButtonEvent.CUSTOM_WHEEL_RIGHT_SLIDE;
                        break;
                    }
                } else {
                    this.mAutelRCControlBtnEvent = RemoteControllerNavigateButtonEvent.CUSTOM_WHEEL_LEFT_SLIDE;
                    break;
                }
            case 2:
                this.mAutelRCControlBtnEvent = RemoteControllerNavigateButtonEvent.CUSTOM_BUTTON_CLICK;
                break;
            case 3:
                this.mAutelRCControlBtnEvent = RemoteControllerNavigateButtonEvent.CUSTOM_WHEEL_CLICK;
                break;
            case 4:
                if (i2 != 1) {
                    if (i2 != 0) {
                        this.mAutelRCControlBtnEvent = RemoteControllerNavigateButtonEvent.UNKNOWN;
                        break;
                    } else {
                        this.mAutelRCControlBtnEvent = RemoteControllerNavigateButtonEvent.TAKEN_PHOTO;
                        break;
                    }
                } else {
                    this.mAutelRCControlBtnEvent = RemoteControllerNavigateButtonEvent.TAKEN_PHOTO_WITH_FOCUS;
                    break;
                }
            case 5:
                if (i2 != 1) {
                    if (i2 != 0) {
                        this.mAutelRCControlBtnEvent = RemoteControllerNavigateButtonEvent.UNKNOWN;
                        break;
                    } else {
                        this.mAutelRCControlBtnEvent = RemoteControllerNavigateButtonEvent.START_VIDEO;
                        break;
                    }
                } else {
                    this.mAutelRCControlBtnEvent = RemoteControllerNavigateButtonEvent.START_VIDEO_WITH_FOCUS;
                    break;
                }
            case 7:
                if (i2 != 1) {
                    if (i2 != 0) {
                        this.mAutelRCControlBtnEvent = RemoteControllerNavigateButtonEvent.UNKNOWN;
                        break;
                    } else {
                        this.mAutelRCControlBtnEvent = RemoteControllerNavigateButtonEvent.CUSTOM_BUTTON_SHORT_B;
                        break;
                    }
                } else {
                    this.mAutelRCControlBtnEvent = RemoteControllerNavigateButtonEvent.CUSTOM_BUTTON_LONG_B;
                    break;
                }
            case 8:
                if (i2 != 1) {
                    if (i2 != 0) {
                        this.mAutelRCControlBtnEvent = RemoteControllerNavigateButtonEvent.UNKNOWN;
                        break;
                    } else {
                        this.mAutelRCControlBtnEvent = RemoteControllerNavigateButtonEvent.CUSTOM_BUTTON_SHORT_A;
                        break;
                    }
                } else {
                    this.mAutelRCControlBtnEvent = RemoteControllerNavigateButtonEvent.CUSTOM_BUTTON_LONG_A;
                    break;
                }
            default:
                this.mAutelRCControlBtnEvent = RemoteControllerNavigateButtonEvent.UNKNOWN;
                break;
        }
        return this;
    }
}

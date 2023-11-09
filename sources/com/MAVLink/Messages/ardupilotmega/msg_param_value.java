package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_param_value extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_PARAM_VALUE = 22;
    public static final int MAVLINK_MSG_LENGTH = 25;
    private static final long serialVersionUID = 22;
    public short param_count;
    public byte[] param_id = new byte[16];
    public short param_index;
    public byte param_type;
    public float param_value;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 25;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 22;
        byte b = this.param_type;
        if (b == 5 || b == 6) {
            mAVLinkPacket.payload.putInt((int) this.param_value);
        } else {
            mAVLinkPacket.payload.putFloat(this.param_value);
        }
        mAVLinkPacket.payload.putShort(this.param_count);
        mAVLinkPacket.payload.putShort(this.param_index);
        for (byte putByte : this.param_id) {
            mAVLinkPacket.payload.putByte(putByte);
        }
        mAVLinkPacket.payload.putByte(this.param_type);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.param_value = mAVLinkPayload.getFloat();
        this.param_count = mAVLinkPayload.getShort();
        this.param_index = mAVLinkPayload.getShort();
        int i = 0;
        while (true) {
            byte[] bArr = this.param_id;
            if (i >= bArr.length) {
                break;
            }
            bArr[i] = mAVLinkPayload.getByte();
            i++;
        }
        byte b = mAVLinkPayload.getByte();
        this.param_type = b;
        switch (b) {
            case 1:
            case 2:
            case 3:
            case 4:
                this.param_value = (float) mAVLinkPayload.getParamTypeShort();
                return;
            case 5:
            case 6:
                this.param_value = (float) mAVLinkPayload.getParamTypeInt();
                return;
            default:
                return;
        }
    }

    public msg_param_value() {
        this.msgid = 22;
    }

    public msg_param_value(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 22;
        unpack(mAVLinkPacket.payload);
    }

    public void setParam_Id(String str) {
        int min = Math.min(str.length(), 16);
        for (int i = 0; i < min; i++) {
            this.param_id[i] = (byte) str.charAt(i);
        }
        while (min < 16) {
            this.param_id[min] = 0;
            min++;
        }
    }

    public String getParam_Id() {
        String str = "";
        int i = 0;
        while (i < 16 && this.param_id[i] != 0) {
            str = str + ((char) this.param_id[i]);
            i++;
        }
        return str;
    }

    public String toString() {
        return "MAVLINK_MSG_ID_PARAM_VALUE - param_value:" + this.param_value + " param_count:" + this.param_count + " param_index:" + this.param_index + " param_id:" + this.param_id + " param_type:" + this.param_type + "";
    }
}

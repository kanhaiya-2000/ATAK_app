package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_param_set extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_PARAM_SET = 23;
    public static final int MAVLINK_MSG_LENGTH = 23;
    private static final long serialVersionUID = 23;
    public byte[] param_id = new byte[16];
    public byte param_type;
    public float param_value;
    public byte target_component;
    public byte target_system;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 23;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 23;
        byte b = this.param_type;
        if (b == 5 || b == 6) {
            mAVLinkPacket.payload.putInt((int) this.param_value);
        } else {
            mAVLinkPacket.payload.putFloat(this.param_value);
        }
        mAVLinkPacket.payload.putByte(this.target_system);
        mAVLinkPacket.payload.putByte(this.target_component);
        for (byte putByte : this.param_id) {
            mAVLinkPacket.payload.putByte(putByte);
        }
        mAVLinkPacket.payload.putByte(this.param_type);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.param_value = mAVLinkPayload.getFloat();
        this.target_system = mAVLinkPayload.getByte();
        this.target_component = mAVLinkPayload.getByte();
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
        if (b == 5 || b == 6) {
            this.param_value = (float) mAVLinkPayload.getParamTypeInt();
        }
    }

    public msg_param_set() {
        this.msgid = 23;
    }

    public msg_param_set(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 23;
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
        return "MAVLINK_MSG_ID_PARAM_SET - param_value:" + this.param_value + " target_system:" + this.target_system + " target_component:" + this.target_component + " param_id:" + this.param_id + " param_type:" + this.param_type + "";
    }
}

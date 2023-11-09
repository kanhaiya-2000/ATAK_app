package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_param_set extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_PARAM_SET = 23;
    public static final int MAVLINK_MSG_ID_PARAM_SET_CRC = 168;
    public static final int MAVLINK_MSG_LENGTH = 23;
    private static final long serialVersionUID = 23;
    public byte[] param_id = new byte[16];
    public short param_type;
    public float param_value;
    public short target_component;
    public short target_system;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(23);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 23;
        mAVLinkPacket.crc_extra = 168;
        mAVLinkPacket.payload.putFloat(this.param_value);
        mAVLinkPacket.payload.putUnsignedByte(this.target_system);
        mAVLinkPacket.payload.putUnsignedByte(this.target_component);
        for (byte putByte : this.param_id) {
            mAVLinkPacket.payload.putByte(putByte);
        }
        mAVLinkPacket.payload.putUnsignedByte(this.param_type);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.param_value = mAVLinkPayload.getFloat();
        this.target_system = mAVLinkPayload.getUnsignedByte();
        this.target_component = mAVLinkPayload.getUnsignedByte();
        int i = 0;
        while (true) {
            byte[] bArr = this.param_id;
            if (i < bArr.length) {
                bArr[i] = mAVLinkPayload.getByte();
                i++;
            } else {
                this.param_type = mAVLinkPayload.getUnsignedByte();
                return;
            }
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
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 16; i++) {
            byte[] bArr = this.param_id;
            if (bArr[i] == 0) {
                break;
            }
            stringBuffer.append((char) bArr[i]);
        }
        return stringBuffer.toString();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_PARAM_SET - sysid:" + this.sysid + " compid:" + this.compid + " param_value:" + this.param_value + " target_system:" + this.target_system + " target_component:" + this.target_component + " param_id:" + this.param_id + " param_type:" + this.param_type + "";
    }
}

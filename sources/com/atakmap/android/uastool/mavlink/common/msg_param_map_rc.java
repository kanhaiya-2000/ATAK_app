package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_param_map_rc extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_PARAM_MAP_RC = 50;
    public static final int MAVLINK_MSG_ID_PARAM_MAP_RC_CRC = 78;
    public static final int MAVLINK_MSG_LENGTH = 37;
    private static final long serialVersionUID = 50;
    public byte[] param_id = new byte[16];
    public short param_index;
    public float param_value0;
    public float param_value_max;
    public float param_value_min;
    public short parameter_rc_channel_index;
    public float scale;
    public short target_component;
    public short target_system;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(37);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 50;
        mAVLinkPacket.crc_extra = 78;
        mAVLinkPacket.payload.putFloat(this.param_value0);
        mAVLinkPacket.payload.putFloat(this.scale);
        mAVLinkPacket.payload.putFloat(this.param_value_min);
        mAVLinkPacket.payload.putFloat(this.param_value_max);
        mAVLinkPacket.payload.putShort(this.param_index);
        mAVLinkPacket.payload.putUnsignedByte(this.target_system);
        mAVLinkPacket.payload.putUnsignedByte(this.target_component);
        for (byte putByte : this.param_id) {
            mAVLinkPacket.payload.putByte(putByte);
        }
        mAVLinkPacket.payload.putUnsignedByte(this.parameter_rc_channel_index);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.param_value0 = mAVLinkPayload.getFloat();
        this.scale = mAVLinkPayload.getFloat();
        this.param_value_min = mAVLinkPayload.getFloat();
        this.param_value_max = mAVLinkPayload.getFloat();
        this.param_index = mAVLinkPayload.getShort();
        this.target_system = mAVLinkPayload.getUnsignedByte();
        this.target_component = mAVLinkPayload.getUnsignedByte();
        int i = 0;
        while (true) {
            byte[] bArr = this.param_id;
            if (i < bArr.length) {
                bArr[i] = mAVLinkPayload.getByte();
                i++;
            } else {
                this.parameter_rc_channel_index = mAVLinkPayload.getUnsignedByte();
                return;
            }
        }
    }

    public msg_param_map_rc() {
        this.msgid = 50;
    }

    public msg_param_map_rc(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 50;
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
        return "MAVLINK_MSG_ID_PARAM_MAP_RC - sysid:" + this.sysid + " compid:" + this.compid + " param_value0:" + this.param_value0 + " scale:" + this.scale + " param_value_min:" + this.param_value_min + " param_value_max:" + this.param_value_max + " param_index:" + this.param_index + " target_system:" + this.target_system + " target_component:" + this.target_component + " param_id:" + this.param_id + " parameter_rc_channel_index:" + this.parameter_rc_channel_index + "";
    }
}

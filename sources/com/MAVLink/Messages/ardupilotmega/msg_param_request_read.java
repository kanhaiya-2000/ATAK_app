package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_param_request_read extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_PARAM_REQUEST_READ = 20;
    public static final int MAVLINK_MSG_LENGTH = 20;
    private static final long serialVersionUID = 20;
    public byte[] param_id = new byte[16];
    public short param_index;
    public byte target_component;
    public byte target_system;
    private String testTag;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 20;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 20;
        mAVLinkPacket.payload.putShort(this.param_index);
        mAVLinkPacket.payload.putByte(this.target_system);
        mAVLinkPacket.payload.putByte(this.target_component);
        for (byte putByte : this.param_id) {
            mAVLinkPacket.payload.putByte(putByte);
        }
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.param_index = mAVLinkPayload.getShort();
        this.target_system = mAVLinkPayload.getByte();
        this.target_component = mAVLinkPayload.getByte();
        int i = 0;
        while (true) {
            byte[] bArr = this.param_id;
            if (i < bArr.length) {
                bArr[i] = mAVLinkPayload.getByte();
                i++;
            } else {
                return;
            }
        }
    }

    public msg_param_request_read() {
        this.msgid = 20;
    }

    public msg_param_request_read(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 20;
        unpack(mAVLinkPacket.payload);
    }

    public void setParam_Id(String str) {
        this.testTag = str;
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
        return "MAVLINK_MSG_ID_PARAM_REQUEST_READ - param_index:" + this.param_index + " target_system:" + this.target_system + " target_component:" + this.target_component + " param_id:" + this.param_id + "";
    }
}

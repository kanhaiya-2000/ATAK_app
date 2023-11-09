package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_resource_request extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_RESOURCE_REQUEST = 142;
    public static final int MAVLINK_MSG_ID_RESOURCE_REQUEST_CRC = 72;
    public static final int MAVLINK_MSG_LENGTH = 243;
    private static final long serialVersionUID = 142;
    public short request_id;
    public short[] storage = new short[120];
    public short transfer_type;
    public short[] uri = new short[120];
    public short uri_type;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(243);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 142;
        mAVLinkPacket.crc_extra = 72;
        mAVLinkPacket.payload.putUnsignedByte(this.request_id);
        mAVLinkPacket.payload.putUnsignedByte(this.uri_type);
        for (short putUnsignedByte : this.uri) {
            mAVLinkPacket.payload.putUnsignedByte(putUnsignedByte);
        }
        mAVLinkPacket.payload.putUnsignedByte(this.transfer_type);
        for (short putUnsignedByte2 : this.storage) {
            mAVLinkPacket.payload.putUnsignedByte(putUnsignedByte2);
        }
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.request_id = mAVLinkPayload.getUnsignedByte();
        this.uri_type = mAVLinkPayload.getUnsignedByte();
        int i = 0;
        int i2 = 0;
        while (true) {
            short[] sArr = this.uri;
            if (i2 >= sArr.length) {
                break;
            }
            sArr[i2] = mAVLinkPayload.getUnsignedByte();
            i2++;
        }
        this.transfer_type = mAVLinkPayload.getUnsignedByte();
        while (true) {
            short[] sArr2 = this.storage;
            if (i < sArr2.length) {
                sArr2[i] = mAVLinkPayload.getUnsignedByte();
                i++;
            } else {
                return;
            }
        }
    }

    public msg_resource_request() {
        this.msgid = 142;
    }

    public msg_resource_request(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 142;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_RESOURCE_REQUEST - sysid:" + this.sysid + " compid:" + this.compid + " request_id:" + this.request_id + " uri_type:" + this.uri_type + " uri:" + this.uri + " transfer_type:" + this.transfer_type + " storage:" + this.storage + "";
    }
}

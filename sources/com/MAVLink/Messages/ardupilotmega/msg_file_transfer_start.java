package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_file_transfer_start extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_FILE_TRANSFER_START = 110;
    public static final int MAVLINK_MSG_LENGTH = 254;
    private static final long serialVersionUID = 110;
    public byte[] dest_path = new byte[240];
    public byte direction;
    public int file_size;
    public byte flags;
    public long transfer_uid;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 254;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 110;
        mAVLinkPacket.payload.putLong(this.transfer_uid);
        mAVLinkPacket.payload.putInt(this.file_size);
        for (byte putByte : this.dest_path) {
            mAVLinkPacket.payload.putByte(putByte);
        }
        mAVLinkPacket.payload.putByte(this.direction);
        mAVLinkPacket.payload.putByte(this.flags);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.transfer_uid = mAVLinkPayload.getLong();
        this.file_size = mAVLinkPayload.getInt();
        int i = 0;
        while (true) {
            byte[] bArr = this.dest_path;
            if (i < bArr.length) {
                bArr[i] = mAVLinkPayload.getByte();
                i++;
            } else {
                this.direction = mAVLinkPayload.getByte();
                this.flags = mAVLinkPayload.getByte();
                return;
            }
        }
    }

    public msg_file_transfer_start() {
        this.msgid = 110;
    }

    public msg_file_transfer_start(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 110;
        unpack(mAVLinkPacket.payload);
    }

    public void setDest_Path(String str) {
        int min = Math.min(str.length(), 240);
        for (int i = 0; i < min; i++) {
            this.dest_path[i] = (byte) str.charAt(i);
        }
        while (min < 240) {
            this.dest_path[min] = 0;
            min++;
        }
    }

    public String getDest_Path() {
        String str = "";
        int i = 0;
        while (i < 240 && this.dest_path[i] != 0) {
            str = str + ((char) this.dest_path[i]);
            i++;
        }
        return str;
    }

    public String toString() {
        return "MAVLINK_MSG_ID_FILE_TRANSFER_START - transfer_uid:" + this.transfer_uid + " file_size:" + this.file_size + " dest_path:" + this.dest_path + " direction:" + this.direction + " flags:" + this.flags + "";
    }
}

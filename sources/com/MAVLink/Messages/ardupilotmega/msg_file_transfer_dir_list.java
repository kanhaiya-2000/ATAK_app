package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_file_transfer_dir_list extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_FILE_TRANSFER_DIR_LIST = 111;
    public static final int MAVLINK_MSG_LENGTH = 249;
    private static final long serialVersionUID = 111;
    public byte[] dir_path = new byte[240];
    public byte flags;
    public long transfer_uid;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 249;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 111;
        mAVLinkPacket.payload.putLong(this.transfer_uid);
        for (byte putByte : this.dir_path) {
            mAVLinkPacket.payload.putByte(putByte);
        }
        mAVLinkPacket.payload.putByte(this.flags);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.transfer_uid = mAVLinkPayload.getLong();
        int i = 0;
        while (true) {
            byte[] bArr = this.dir_path;
            if (i < bArr.length) {
                bArr[i] = mAVLinkPayload.getByte();
                i++;
            } else {
                this.flags = mAVLinkPayload.getByte();
                return;
            }
        }
    }

    public msg_file_transfer_dir_list() {
        this.msgid = 111;
    }

    public msg_file_transfer_dir_list(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 111;
        unpack(mAVLinkPacket.payload);
    }

    public void setDir_Path(String str) {
        int min = Math.min(str.length(), 240);
        for (int i = 0; i < min; i++) {
            this.dir_path[i] = (byte) str.charAt(i);
        }
        while (min < 240) {
            this.dir_path[min] = 0;
            min++;
        }
    }

    public String getDir_Path() {
        String str = "";
        int i = 0;
        while (i < 240 && this.dir_path[i] != 0) {
            str = str + ((char) this.dir_path[i]);
            i++;
        }
        return str;
    }

    public String toString() {
        return "MAVLINK_MSG_ID_FILE_TRANSFER_DIR_LIST - transfer_uid:" + this.transfer_uid + " dir_path:" + this.dir_path + " flags:" + this.flags + "";
    }
}

package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_sys_status extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_SYS_STATUS = 1;
    public static final int MAVLINK_MSG_LENGTH = 19;
    private static final long serialVersionUID = 1;
    public int exflags;
    public byte flight_status;
    public int flight_warning;
    public short load;
    public byte[] version = new byte[8];

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 19;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 1;
        mAVLinkPacket.payload.putInt(this.flight_warning);
        mAVLinkPacket.payload.putInt(this.exflags);
        mAVLinkPacket.payload.putShort(this.load);
        mAVLinkPacket.payload.putByte(this.flight_status);
        for (byte putByte : this.version) {
            mAVLinkPacket.payload.putByte(putByte);
        }
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.flight_warning = mAVLinkPayload.getInt();
        this.exflags = mAVLinkPayload.getInt();
        this.load = mAVLinkPayload.getShort();
        this.flight_status = mAVLinkPayload.getByte();
        int i = 0;
        while (true) {
            byte[] bArr = this.version;
            if (i < bArr.length) {
                bArr[i] = mAVLinkPayload.getByte();
                i++;
            } else {
                getVersion();
                return;
            }
        }
    }

    public msg_sys_status() {
        this.msgid = 1;
    }

    public msg_sys_status(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 1;
        unpack(mAVLinkPacket.payload);
    }

    public String getVersion() {
        String str = "";
        int i = 0;
        while (i < 8 && this.version[i] != 0) {
            str = str + ((char) this.version[i]);
            i++;
        }
        return str;
    }

    public String toString() {
        return "MAVLINK_MSG_ID_SYS_STATUS :flight_warning:" + this.flight_warning + " /nload:" + this.load + " /nflight_status:" + this.flight_status + "exflags: " + this.exflags + " /n";
    }
}

package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_set_quad_swarm_roll_pitch_yaw_thrust extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_SET_QUAD_SWARM_ROLL_PITCH_YAW_THRUST = 61;
    public static final int MAVLINK_MSG_LENGTH = 34;
    private static final long serialVersionUID = 61;
    public byte group;
    public byte mode;
    public short[] pitch = new short[4];
    public short[] roll = new short[4];
    public short[] thrust = new short[4];
    public short[] yaw = new short[4];

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 34;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 61;
        for (short putShort : this.roll) {
            mAVLinkPacket.payload.putShort(putShort);
        }
        for (short putShort2 : this.pitch) {
            mAVLinkPacket.payload.putShort(putShort2);
        }
        for (short putShort3 : this.yaw) {
            mAVLinkPacket.payload.putShort(putShort3);
        }
        for (short putShort4 : this.thrust) {
            mAVLinkPacket.payload.putShort(putShort4);
        }
        mAVLinkPacket.payload.putByte(this.group);
        mAVLinkPacket.payload.putByte(this.mode);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        int i = 0;
        int i2 = 0;
        while (true) {
            short[] sArr = this.roll;
            if (i2 >= sArr.length) {
                break;
            }
            sArr[i2] = mAVLinkPayload.getShort();
            i2++;
        }
        int i3 = 0;
        while (true) {
            short[] sArr2 = this.pitch;
            if (i3 >= sArr2.length) {
                break;
            }
            sArr2[i3] = mAVLinkPayload.getShort();
            i3++;
        }
        int i4 = 0;
        while (true) {
            short[] sArr3 = this.yaw;
            if (i4 >= sArr3.length) {
                break;
            }
            sArr3[i4] = mAVLinkPayload.getShort();
            i4++;
        }
        while (true) {
            short[] sArr4 = this.thrust;
            if (i < sArr4.length) {
                sArr4[i] = mAVLinkPayload.getShort();
                i++;
            } else {
                this.group = mAVLinkPayload.getByte();
                this.mode = mAVLinkPayload.getByte();
                return;
            }
        }
    }

    public msg_set_quad_swarm_roll_pitch_yaw_thrust() {
        this.msgid = 61;
    }

    public msg_set_quad_swarm_roll_pitch_yaw_thrust(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 61;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_SET_QUAD_SWARM_ROLL_PITCH_YAW_THRUST - roll:" + this.roll + " pitch:" + this.pitch + " yaw:" + this.yaw + " thrust:" + this.thrust + " group:" + this.group + " mode:" + this.mode + "";
    }
}

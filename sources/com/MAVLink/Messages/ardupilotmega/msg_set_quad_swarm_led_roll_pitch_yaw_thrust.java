package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_set_quad_swarm_led_roll_pitch_yaw_thrust extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_SET_QUAD_SWARM_LED_ROLL_PITCH_YAW_THRUST = 63;
    public static final int MAVLINK_MSG_LENGTH = 46;
    private static final long serialVersionUID = 63;
    public byte group;
    public byte[] led_blue = new byte[4];
    public byte[] led_green = new byte[4];
    public byte[] led_red = new byte[4];
    public byte mode;
    public short[] pitch = new short[4];
    public short[] roll = new short[4];
    public short[] thrust = new short[4];
    public short[] yaw = new short[4];

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 46;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 63;
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
        for (byte putByte : this.led_red) {
            mAVLinkPacket.payload.putByte(putByte);
        }
        for (byte putByte2 : this.led_blue) {
            mAVLinkPacket.payload.putByte(putByte2);
        }
        for (byte putByte3 : this.led_green) {
            mAVLinkPacket.payload.putByte(putByte3);
        }
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
        int i5 = 0;
        while (true) {
            short[] sArr4 = this.thrust;
            if (i5 >= sArr4.length) {
                break;
            }
            sArr4[i5] = mAVLinkPayload.getShort();
            i5++;
        }
        this.group = mAVLinkPayload.getByte();
        this.mode = mAVLinkPayload.getByte();
        int i6 = 0;
        while (true) {
            byte[] bArr = this.led_red;
            if (i6 >= bArr.length) {
                break;
            }
            bArr[i6] = mAVLinkPayload.getByte();
            i6++;
        }
        int i7 = 0;
        while (true) {
            byte[] bArr2 = this.led_blue;
            if (i7 >= bArr2.length) {
                break;
            }
            bArr2[i7] = mAVLinkPayload.getByte();
            i7++;
        }
        while (true) {
            byte[] bArr3 = this.led_green;
            if (i < bArr3.length) {
                bArr3[i] = mAVLinkPayload.getByte();
                i++;
            } else {
                return;
            }
        }
    }

    public msg_set_quad_swarm_led_roll_pitch_yaw_thrust() {
        this.msgid = 63;
    }

    public msg_set_quad_swarm_led_roll_pitch_yaw_thrust(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 63;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_SET_QUAD_SWARM_LED_ROLL_PITCH_YAW_THRUST - roll:" + this.roll + " pitch:" + this.pitch + " yaw:" + this.yaw + " thrust:" + this.thrust + " group:" + this.group + " mode:" + this.mode + " led_red:" + this.led_red + " led_blue:" + this.led_blue + " led_green:" + this.led_green + "";
    }
}

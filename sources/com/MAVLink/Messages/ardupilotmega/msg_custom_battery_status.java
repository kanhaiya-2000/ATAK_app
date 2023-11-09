package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_custom_battery_status extends MAVLinkMessage {
    public static final int MAVLINK_MSG_CUSTOM_BATTERY_STATUS = 214;
    private static final int MAVLINK_MSG_LENGTH = 82;
    private static final long serialVersionUID = 214;
    public float CycleCount;
    public int DesignCap;
    public int FullChgCap;
    public short RSOC;

    /* renamed from: SN */
    public byte[] f8134SN = new byte[32];

    /* renamed from: VN */
    public byte[] f8135VN = new byte[8];
    public float capacity_mah;
    public float current_ma;
    public float temperature;
    public short voltage_cell_1;
    public short voltage_cell_2;
    public short voltage_cell_3;
    public short voltage_cell_4;
    public short voltage_cell_5;
    public short voltage_cell_6;
    public float voltage_mv;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 82;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 214;
        mAVLinkPacket.payload.putFloat(this.voltage_mv);
        mAVLinkPacket.payload.putFloat(this.capacity_mah);
        mAVLinkPacket.payload.putFloat(this.current_ma);
        mAVLinkPacket.payload.putFloat(this.temperature);
        mAVLinkPacket.payload.putFloat(this.CycleCount);
        mAVLinkPacket.payload.putInt(this.DesignCap);
        mAVLinkPacket.payload.putInt(this.FullChgCap);
        mAVLinkPacket.payload.putShort(this.RSOC);
        mAVLinkPacket.payload.putShort(this.voltage_cell_1);
        mAVLinkPacket.payload.putShort(this.voltage_cell_2);
        mAVLinkPacket.payload.putShort(this.voltage_cell_3);
        mAVLinkPacket.payload.putShort(this.voltage_cell_4);
        mAVLinkPacket.payload.putShort(this.voltage_cell_5);
        mAVLinkPacket.payload.putShort(this.voltage_cell_6);
        for (byte putByte : this.f8134SN) {
            mAVLinkPacket.payload.putByte(putByte);
        }
        for (byte putByte2 : this.f8135VN) {
            mAVLinkPacket.payload.putByte(putByte2);
        }
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.voltage_mv = mAVLinkPayload.getFloat();
        this.capacity_mah = mAVLinkPayload.getFloat();
        this.current_ma = mAVLinkPayload.getFloat();
        this.temperature = mAVLinkPayload.getFloat();
        this.CycleCount = mAVLinkPayload.getFloat();
        this.DesignCap = mAVLinkPayload.getInt();
        this.FullChgCap = mAVLinkPayload.getInt();
        this.RSOC = mAVLinkPayload.getShort();
        this.voltage_cell_1 = mAVLinkPayload.getShort();
        this.voltage_cell_2 = mAVLinkPayload.getShort();
        this.voltage_cell_3 = mAVLinkPayload.getShort();
        this.voltage_cell_4 = mAVLinkPayload.getShort();
        this.voltage_cell_5 = mAVLinkPayload.getShort();
        this.voltage_cell_6 = mAVLinkPayload.getShort();
        int i = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr = this.f8134SN;
            if (i2 >= bArr.length) {
                break;
            }
            bArr[i2] = mAVLinkPayload.getByte();
            i2++;
        }
        while (true) {
            byte[] bArr2 = this.f8135VN;
            if (i < bArr2.length) {
                bArr2[i] = mAVLinkPayload.getByte();
                i++;
            } else {
                return;
            }
        }
    }

    public String getSNId() {
        return new String(this.f8134SN);
    }

    public String getVersionId() {
        String str = "";
        int i = 0;
        while (true) {
            byte[] bArr = this.f8135VN;
            if (i >= bArr.length || bArr[i] == 0) {
                return str;
            }
            str = str + ((char) this.f8135VN[i]);
            i++;
        }
        return str;
    }

    public msg_custom_battery_status() {
        this.msgid = 214;
    }

    public msg_custom_battery_status(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 214;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "msg_custom_battery_status:\n voltage_cell_1 :" + this.voltage_cell_1 + "\n voltage_cell_2 :" + this.voltage_cell_2 + "\n voltage_cell_3 :" + this.voltage_cell_3 + "\n voltage_cell_4 :" + this.voltage_cell_4 + "\n voltage_cell_5 :" + this.voltage_cell_5 + "\n voltage_cell_6 :" + this.voltage_cell_6 + "\n voltage_mv:" + this.voltage_mv + "\n capacity_mah:" + this.capacity_mah + "\n current_ma:" + this.current_ma + "\n temperature:" + this.temperature + "\n CycleCount:" + this.CycleCount + "\n DesignCap:" + this.DesignCap + "\n FullChgCap:" + this.FullChgCap + "\n RSOC:" + this.RSOC + "\n SN[i]:" + getSNId();
    }
}

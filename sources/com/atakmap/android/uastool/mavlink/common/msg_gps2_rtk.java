package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_gps2_rtk extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_GPS2_RTK = 128;
    public static final int MAVLINK_MSG_ID_GPS2_RTK_CRC = 226;
    public static final int MAVLINK_MSG_LENGTH = 35;
    private static final long serialVersionUID = 128;
    public long accuracy;
    public int baseline_a_mm;
    public int baseline_b_mm;
    public int baseline_c_mm;
    public short baseline_coords_type;
    public int iar_num_hypotheses;
    public short nsats;
    public short rtk_health;
    public short rtk_rate;
    public short rtk_receiver_id;
    public long time_last_baseline_ms;
    public long tow;

    /* renamed from: wn */
    public int f8276wn;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(35);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 128;
        mAVLinkPacket.crc_extra = 226;
        mAVLinkPacket.payload.putUnsignedInt(this.time_last_baseline_ms);
        mAVLinkPacket.payload.putUnsignedInt(this.tow);
        mAVLinkPacket.payload.putInt(this.baseline_a_mm);
        mAVLinkPacket.payload.putInt(this.baseline_b_mm);
        mAVLinkPacket.payload.putInt(this.baseline_c_mm);
        mAVLinkPacket.payload.putUnsignedInt(this.accuracy);
        mAVLinkPacket.payload.putInt(this.iar_num_hypotheses);
        mAVLinkPacket.payload.putUnsignedShort(this.f8276wn);
        mAVLinkPacket.payload.putUnsignedByte(this.rtk_receiver_id);
        mAVLinkPacket.payload.putUnsignedByte(this.rtk_health);
        mAVLinkPacket.payload.putUnsignedByte(this.rtk_rate);
        mAVLinkPacket.payload.putUnsignedByte(this.nsats);
        mAVLinkPacket.payload.putUnsignedByte(this.baseline_coords_type);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.time_last_baseline_ms = mAVLinkPayload.getUnsignedInt();
        this.tow = mAVLinkPayload.getUnsignedInt();
        this.baseline_a_mm = mAVLinkPayload.getInt();
        this.baseline_b_mm = mAVLinkPayload.getInt();
        this.baseline_c_mm = mAVLinkPayload.getInt();
        this.accuracy = mAVLinkPayload.getUnsignedInt();
        this.iar_num_hypotheses = mAVLinkPayload.getInt();
        this.f8276wn = mAVLinkPayload.getUnsignedShort();
        this.rtk_receiver_id = mAVLinkPayload.getUnsignedByte();
        this.rtk_health = mAVLinkPayload.getUnsignedByte();
        this.rtk_rate = mAVLinkPayload.getUnsignedByte();
        this.nsats = mAVLinkPayload.getUnsignedByte();
        this.baseline_coords_type = mAVLinkPayload.getUnsignedByte();
    }

    public msg_gps2_rtk() {
        this.msgid = 128;
    }

    public msg_gps2_rtk(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 128;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_GPS2_RTK - sysid:" + this.sysid + " compid:" + this.compid + " time_last_baseline_ms:" + this.time_last_baseline_ms + " tow:" + this.tow + " baseline_a_mm:" + this.baseline_a_mm + " baseline_b_mm:" + this.baseline_b_mm + " baseline_c_mm:" + this.baseline_c_mm + " accuracy:" + this.accuracy + " iar_num_hypotheses:" + this.iar_num_hypotheses + " wn:" + this.f8276wn + " rtk_receiver_id:" + this.rtk_receiver_id + " rtk_health:" + this.rtk_health + " rtk_rate:" + this.rtk_rate + " nsats:" + this.nsats + " baseline_coords_type:" + this.baseline_coords_type + "";
    }
}

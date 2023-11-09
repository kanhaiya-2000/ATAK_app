package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_gps2_rtk extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_GPS2_RTK = 128;
    public static final int MAVLINK_MSG_LENGTH = 35;
    private static final long serialVersionUID = 128;
    public int accuracy;
    public int baseline_a_mm;
    public int baseline_b_mm;
    public int baseline_c_mm;
    public byte baseline_coords_type;
    public int iar_num_hypotheses;
    public byte nsats;
    public byte rtk_health;
    public byte rtk_rate;
    public byte rtk_receiver_id;
    public int time_last_baseline_ms;
    public int tow;

    /* renamed from: wn */
    public short f8149wn;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 35;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 128;
        mAVLinkPacket.payload.putInt(this.time_last_baseline_ms);
        mAVLinkPacket.payload.putInt(this.tow);
        mAVLinkPacket.payload.putInt(this.baseline_a_mm);
        mAVLinkPacket.payload.putInt(this.baseline_b_mm);
        mAVLinkPacket.payload.putInt(this.baseline_c_mm);
        mAVLinkPacket.payload.putInt(this.accuracy);
        mAVLinkPacket.payload.putInt(this.iar_num_hypotheses);
        mAVLinkPacket.payload.putShort(this.f8149wn);
        mAVLinkPacket.payload.putByte(this.rtk_receiver_id);
        mAVLinkPacket.payload.putByte(this.rtk_health);
        mAVLinkPacket.payload.putByte(this.rtk_rate);
        mAVLinkPacket.payload.putByte(this.nsats);
        mAVLinkPacket.payload.putByte(this.baseline_coords_type);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.time_last_baseline_ms = mAVLinkPayload.getInt();
        this.tow = mAVLinkPayload.getInt();
        this.baseline_a_mm = mAVLinkPayload.getInt();
        this.baseline_b_mm = mAVLinkPayload.getInt();
        this.baseline_c_mm = mAVLinkPayload.getInt();
        this.accuracy = mAVLinkPayload.getInt();
        this.iar_num_hypotheses = mAVLinkPayload.getInt();
        this.f8149wn = mAVLinkPayload.getShort();
        this.rtk_receiver_id = mAVLinkPayload.getByte();
        this.rtk_health = mAVLinkPayload.getByte();
        this.rtk_rate = mAVLinkPayload.getByte();
        this.nsats = mAVLinkPayload.getByte();
        this.baseline_coords_type = mAVLinkPayload.getByte();
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
        return "MAVLINK_MSG_ID_GPS2_RTK - time_last_baseline_ms:" + this.time_last_baseline_ms + " tow:" + this.tow + " baseline_a_mm:" + this.baseline_a_mm + " baseline_b_mm:" + this.baseline_b_mm + " baseline_c_mm:" + this.baseline_c_mm + " accuracy:" + this.accuracy + " iar_num_hypotheses:" + this.iar_num_hypotheses + " wn:" + this.f8149wn + " rtk_receiver_id:" + this.rtk_receiver_id + " rtk_health:" + this.rtk_health + " rtk_rate:" + this.rtk_rate + " nsats:" + this.nsats + " baseline_coords_type:" + this.baseline_coords_type + "";
    }
}

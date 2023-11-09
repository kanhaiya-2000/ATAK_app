package com.atakmap.android.uastool.MAVLink.ardupilotmega;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_mag_cal_report extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_MAG_CAL_REPORT = 192;
    public static final int MAVLINK_MSG_ID_MAG_CAL_REPORT_CRC = 36;
    public static final int MAVLINK_MSG_LENGTH = 44;
    private static final long serialVersionUID = 192;
    public short autosaved;
    public short cal_mask;
    public short cal_status;
    public short compass_id;
    public float diag_x;
    public float diag_y;
    public float diag_z;
    public float fitness;
    public float offdiag_x;
    public float offdiag_y;
    public float offdiag_z;
    public float ofs_x;
    public float ofs_y;
    public float ofs_z;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(44);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 192;
        mAVLinkPacket.crc_extra = 36;
        mAVLinkPacket.payload.putFloat(this.fitness);
        mAVLinkPacket.payload.putFloat(this.ofs_x);
        mAVLinkPacket.payload.putFloat(this.ofs_y);
        mAVLinkPacket.payload.putFloat(this.ofs_z);
        mAVLinkPacket.payload.putFloat(this.diag_x);
        mAVLinkPacket.payload.putFloat(this.diag_y);
        mAVLinkPacket.payload.putFloat(this.diag_z);
        mAVLinkPacket.payload.putFloat(this.offdiag_x);
        mAVLinkPacket.payload.putFloat(this.offdiag_y);
        mAVLinkPacket.payload.putFloat(this.offdiag_z);
        mAVLinkPacket.payload.putUnsignedByte(this.compass_id);
        mAVLinkPacket.payload.putUnsignedByte(this.cal_mask);
        mAVLinkPacket.payload.putUnsignedByte(this.cal_status);
        mAVLinkPacket.payload.putUnsignedByte(this.autosaved);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.fitness = mAVLinkPayload.getFloat();
        this.ofs_x = mAVLinkPayload.getFloat();
        this.ofs_y = mAVLinkPayload.getFloat();
        this.ofs_z = mAVLinkPayload.getFloat();
        this.diag_x = mAVLinkPayload.getFloat();
        this.diag_y = mAVLinkPayload.getFloat();
        this.diag_z = mAVLinkPayload.getFloat();
        this.offdiag_x = mAVLinkPayload.getFloat();
        this.offdiag_y = mAVLinkPayload.getFloat();
        this.offdiag_z = mAVLinkPayload.getFloat();
        this.compass_id = mAVLinkPayload.getUnsignedByte();
        this.cal_mask = mAVLinkPayload.getUnsignedByte();
        this.cal_status = mAVLinkPayload.getUnsignedByte();
        this.autosaved = mAVLinkPayload.getUnsignedByte();
    }

    public msg_mag_cal_report() {
        this.msgid = 192;
    }

    public msg_mag_cal_report(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 192;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_MAG_CAL_REPORT - sysid:" + this.sysid + " compid:" + this.compid + " fitness:" + this.fitness + " ofs_x:" + this.ofs_x + " ofs_y:" + this.ofs_y + " ofs_z:" + this.ofs_z + " diag_x:" + this.diag_x + " diag_y:" + this.diag_y + " diag_z:" + this.diag_z + " offdiag_x:" + this.offdiag_x + " offdiag_y:" + this.offdiag_y + " offdiag_z:" + this.offdiag_z + " compass_id:" + this.compass_id + " cal_mask:" + this.cal_mask + " cal_status:" + this.cal_status + " autosaved:" + this.autosaved + "";
    }
}

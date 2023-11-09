package com.MAVLink.Messages;

public class MAVLinkStats {
    public int crcErrorCount;
    private int lastPacketSeq;
    public int lostPacketCount;
    public int receivedPacketCount;

    public void newPacket(MAVLinkPacket mAVLinkPacket) {
        advanceLastPacketSequence();
        if (hasLostPackets(mAVLinkPacket)) {
            updateLostPacketCount(mAVLinkPacket);
        }
        this.lastPacketSeq = mAVLinkPacket.seq;
        this.receivedPacketCount++;
    }

    private void updateLostPacketCount(MAVLinkPacket mAVLinkPacket) {
        int i;
        if (mAVLinkPacket.seq - this.lastPacketSeq < 0) {
            i = (mAVLinkPacket.seq - this.lastPacketSeq) + 255;
        } else {
            i = mAVLinkPacket.seq - this.lastPacketSeq;
        }
        this.lostPacketCount += i;
    }

    private boolean hasLostPackets(MAVLinkPacket mAVLinkPacket) {
        return this.lastPacketSeq > 0 && mAVLinkPacket.seq != this.lastPacketSeq;
    }

    private void advanceLastPacketSequence() {
        this.lastPacketSeq = (this.lastPacketSeq + 1) & 255;
    }

    public void crcError() {
        this.crcErrorCount++;
    }

    public void mavlinkResetStats() {
        this.lastPacketSeq = -1;
        this.lostPacketCount = 0;
        this.crcErrorCount = 0;
        this.receivedPacketCount = 0;
    }
}

package com.autel.AutelNet2.core.message;

import com.autel.AutelNet2.core.utils.UdpConfig;

public class MsgHead {
    private byte[] buffer;
    public byte flag = -64;
    private int index;
    public short length;
    public byte magic0 = UdpConfig.MAGIC0;
    public byte magic1 = UdpConfig.MAGIC1;
    public short msg_dst;
    public short msg_src;
    public short msg_type;
    public short package_id;
    public short sequence;
    public byte version = UdpConfig.VERSION;

    private void add(byte b) {
        try {
            byte[] bArr = this.buffer;
            int i = this.index;
            this.index = i + 1;
            bArr[i] = b;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void putByte(byte b) {
        add(b);
    }

    private void putShort(short s) {
        add((byte) (s >> 8));
        add((byte) (s >> 0));
    }

    private void putInt(int i) {
        add((byte) (i >> 24));
        add((byte) (i >> 16));
        add((byte) (i >> 8));
        add((byte) (i >> 0));
    }

    public byte[] getData() {
        packHead();
        return this.buffer;
    }

    private void packHead() {
        this.index = 0;
        this.buffer = new byte[UdpConfig.HEAD_LENGTH];
        putByte(this.magic0);
        putByte(this.magic1);
        putByte(this.version);
        putByte(this.flag);
        putShort(this.length);
        putShort(this.msg_src);
        putShort(this.msg_dst);
        putShort(this.msg_type);
        putShort(this.sequence);
        putShort(this.package_id);
    }

    public String toString() {
        return "magic0: 0X" + Integer.toHexString(this.magic0) + ",magic1: 0X" + Integer.toHexString(this.magic1) + ",version: 0X" + Integer.toHexString(this.version) + ",flag: 0X" + Integer.toHexString(this.flag) + ",length: 0X" + Integer.toHexString(this.length) + ",msg_src: 0X" + Integer.toHexString(this.msg_src) + ",msg_dst: 0X" + Integer.toHexString(this.msg_dst) + ",msg_type: 0X" + Integer.toHexString(this.msg_type) + ",sequence: 0X" + Integer.toHexString(this.sequence) + ",package_id: 0X" + Integer.toHexString(this.package_id) + "\n";
    }
}

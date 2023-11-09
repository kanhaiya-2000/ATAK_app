package com.autel.sdk10.AutelNet.AutelRemoteController.engine;

import com.autel.sdk10.utils.BytesUtils;
import com.google.common.base.Ascii;
import java.io.Serializable;

public class RCCommandMessage implements Serializable {
    private byte[] data;
    private int msgId;

    public RCCommandMessage() {
    }

    public RCCommandMessage(byte[] bArr) {
        setData(bArr);
    }

    public void setData(byte[] bArr) {
        this.data = bArr;
        this.msgId = BytesUtils.getInt(bArr[4]);
    }

    public int getMsgId() {
        return this.msgId;
    }

    public byte[] getData() {
        return this.data;
    }

    public boolean isLongTimeUploadMsg() {
        return getMsgId() == 14 || getMsgId() == 15 || getMsgId() == 12;
    }

    private void creatHead(short s) {
        byte[] bArr = new byte[(s + 4)];
        this.data = bArr;
        bArr[0] = 65;
        bArr[1] = 84;
        bArr[2] = BytesUtils.getBytes_(s)[0];
        this.data[3] = BytesUtils.getBytes_(s)[1];
    }

    public void createSetGimbalAdjustSpeedParams(int i) {
        this.msgId = 1;
        byte[] bytes = BytesUtils.getBytes(i);
        creatHead(6);
        byte[] bArr = this.data;
        bArr[4] = 1;
        bArr[5] = 4;
        bArr[6] = bytes[0];
        bArr[7] = bytes[1];
        bArr[8] = bytes[2];
        bArr[9] = bytes[3];
    }

    public void createQueryGimbalAdjustSpeedParams() {
        this.msgId = 2;
        creatHead(2);
        byte[] bArr = this.data;
        bArr[4] = 2;
        bArr[5] = 0;
    }

    public void createSetRCLanguageParams(int i) {
        this.msgId = 3;
        creatHead(3);
        byte[] bArr = this.data;
        bArr[4] = 3;
        bArr[5] = 1;
        bArr[6] = (byte) i;
    }

    public void createQueryRCLanguageParams() {
        this.msgId = 4;
        creatHead(2);
        byte[] bArr = this.data;
        bArr[4] = 4;
        bArr[5] = 0;
    }

    public void createSetRCPairModeParams() {
        this.msgId = 5;
        creatHead(2);
        byte[] bArr = this.data;
        bArr[4] = 5;
        bArr[5] = 0;
    }

    public void createQueryRCPairModeParams() {
        this.msgId = 6;
        creatHead(2);
        byte[] bArr = this.data;
        bArr[4] = 6;
        bArr[5] = 0;
    }

    public void createSetRFPowerParams(int i) {
        this.msgId = 7;
        creatHead(3);
        byte[] bArr = this.data;
        bArr[4] = 7;
        bArr[5] = 1;
        bArr[6] = (byte) i;
    }

    public void createQueryRFPowerParams() {
        this.msgId = 8;
        creatHead(2);
        byte[] bArr = this.data;
        bArr[4] = 8;
        bArr[5] = 0;
    }

    public void createSetTeacherStudentModeParams(int i) {
        this.msgId = 9;
        creatHead(3);
        byte[] bArr = this.data;
        bArr[4] = 9;
        bArr[5] = 1;
        bArr[6] = (byte) i;
    }

    public void createQueryTeacherStudentModeParams() {
        this.msgId = 10;
        creatHead(2);
        byte[] bArr = this.data;
        bArr[4] = 10;
        bArr[5] = 0;
    }

    public void createSetGimbalAngleParams(float f) {
        this.msgId = 11;
        byte[] bytes = BytesUtils.getBytes(f);
        creatHead(6);
        byte[] bArr = this.data;
        bArr[4] = Ascii.f8527VT;
        bArr[5] = 4;
        bArr[6] = bytes[0];
        bArr[7] = bytes[1];
        bArr[8] = bytes[2];
        bArr[9] = bytes[3];
    }

    public void createQueryGimbalAngleParams() {
        this.msgId = 12;
        creatHead(2);
        byte[] bArr = this.data;
        bArr[4] = Ascii.f8516FF;
        bArr[5] = 0;
    }

    public void createSetRCAdjustStepParams(int i) {
        this.msgId = 13;
        creatHead(3);
        byte[] bArr = this.data;
        bArr[4] = Ascii.f8514CR;
        bArr[5] = 1;
        bArr[6] = (byte) i;
    }

    public void createQueryRCUploadDataParams(int i) {
        this.msgId = 14;
        creatHead(3);
        byte[] bArr = this.data;
        bArr[4] = Ascii.f8524SO;
        bArr[5] = 1;
        bArr[6] = (byte) i;
    }

    public void createQueryRCInfoDataParams() {
        this.msgId = 15;
        creatHead(2);
        byte[] bArr = this.data;
        bArr[4] = Ascii.f8523SI;
        bArr[5] = 0;
    }

    public void createQueryRCVersionDataParams() {
        this.msgId = 16;
        creatHead(2);
        byte[] bArr = this.data;
        bArr[4] = 16;
        bArr[5] = 0;
    }

    public void createSetRCLengthUnitParams(int i) {
        this.msgId = 17;
        creatHead(3);
        byte[] bArr = this.data;
        bArr[4] = 17;
        bArr[5] = 1;
        bArr[6] = (byte) i;
    }

    public void createQueryRCLengthUnitParams() {
        this.msgId = 20;
        creatHead(2);
        byte[] bArr = this.data;
        bArr[4] = Ascii.DC4;
        bArr[5] = 0;
    }

    public void createSetRCControlModelParams(int i) {
        this.msgId = 18;
        creatHead(3);
        byte[] bArr = this.data;
        bArr[4] = Ascii.DC2;
        bArr[5] = 1;
        bArr[6] = (byte) i;
    }

    public void createQueryRCControlModelParams() {
        this.msgId = 19;
        creatHead(2);
        byte[] bArr = this.data;
        bArr[4] = 19;
        bArr[5] = 0;
    }

    public void createRCResetWifi() {
        this.msgId = 21;
        creatHead(3);
        byte[] bArr = this.data;
        bArr[4] = Ascii.NAK;
        bArr[5] = 1;
        bArr[6] = 0;
    }

    public void uploadPhoneCompassAngle(int i) {
        this.msgId = 22;
        byte[] unsignedBytes = BytesUtils.getUnsignedBytes(i);
        creatHead(4);
        byte[] bArr = this.data;
        bArr[4] = Ascii.SYN;
        bArr[5] = 2;
        bArr[6] = unsignedBytes[0];
        bArr[7] = unsignedBytes[1];
    }
}

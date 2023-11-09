package com.o3dr.services.android.lib.drone.companion.solo.tlv;

import android.os.Parcel;
import android.os.Parcelable;
import com.o3dr.services.android.lib.drone.property.DroneAttribute;
import java.nio.ByteBuffer;

public class SoloGoproState extends TLVPacket implements DroneAttribute {
    public static final Parcelable.Creator<SoloGoproState> CREATOR = new Parcelable.Creator<SoloGoproState>() {
        public SoloGoproState createFromParcel(Parcel parcel) {
            return new SoloGoproState(parcel);
        }

        public SoloGoproState[] newArray(int i) {
            return new SoloGoproState[i];
        }
    };
    public static final int MESSAGE_LENGTH = 36;
    private byte batteryRemaining;
    private byte burstShutterRate;
    private byte captureMode;
    private byte color;
    private byte continuousShutterSpeed;
    private short extra1;
    private short extra2;
    private short extra3;
    private short extra4;
    private short extra5;
    private byte fov;
    private byte fps;
    private byte lowLight;
    private byte model;
    private byte ntsc_pal;
    private byte photoExposure;
    private byte photoRemaining;
    private byte photoResolution;
    private byte photoTaken;
    private byte proTune;
    private byte recording;
    private byte sharpness;
    private byte spotMeter;
    private byte status;
    private byte timeLapseInterval;
    private byte version;
    private byte videoExposure;
    private byte videoRemaining;
    private byte videoResolution;
    private byte videoTaken;
    private byte whiteBalance;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SoloGoproState(byte b, byte b2, byte b3, byte b4, byte b5, short s, short s2, short s3, short s4, short s5, byte b6, byte b7, byte b8, byte b9, byte b10, byte b11, byte b12, byte b13, byte b14, byte b15, byte b16, byte b17, byte b18, byte b19, byte b20, byte b21, byte b22, byte b23, byte b24, byte b25, byte b26) {
        super(TLVMessageTypes.TYPE_SOLO_GOPRO_STATE, 36);
        this.batteryRemaining = b;
        this.burstShutterRate = b2;
        this.captureMode = b3;
        this.color = b4;
        this.continuousShutterSpeed = b5;
        this.extra1 = s;
        this.extra2 = s2;
        this.extra3 = s3;
        this.extra4 = s4;
        this.extra5 = s5;
        this.fov = b6;
        this.fps = b7;
        this.lowLight = b8;
        this.model = b9;
        this.ntsc_pal = b10;
        this.photoExposure = b11;
        this.photoRemaining = b12;
        this.photoResolution = b13;
        this.photoTaken = b14;
        this.proTune = b15;
        this.recording = b16;
        this.sharpness = b17;
        this.spotMeter = b18;
        this.status = b19;
        this.timeLapseInterval = b20;
        this.version = b21;
        this.videoExposure = b22;
        this.videoRemaining = b23;
        this.videoResolution = b24;
        this.videoTaken = b25;
        this.whiteBalance = b26;
    }

    public SoloGoproState(ByteBuffer byteBuffer) {
        super(TLVMessageTypes.TYPE_SOLO_GOPRO_STATE, 36);
        this.version = byteBuffer.get();
        this.model = byteBuffer.get();
        this.status = byteBuffer.get();
        this.recording = byteBuffer.get();
        this.captureMode = byteBuffer.get();
        this.fov = byteBuffer.get();
        this.videoResolution = byteBuffer.get();
        this.fps = byteBuffer.get();
        this.whiteBalance = byteBuffer.get();
        this.proTune = byteBuffer.get();
        this.videoExposure = byteBuffer.get();
        this.photoResolution = byteBuffer.get();
        this.photoExposure = byteBuffer.get();
        this.ntsc_pal = byteBuffer.get();
        this.lowLight = byteBuffer.get();
        this.spotMeter = byteBuffer.get();
        this.batteryRemaining = byteBuffer.get();
        this.photoRemaining = byteBuffer.get();
        this.photoTaken = byteBuffer.get();
        this.videoRemaining = byteBuffer.get();
        this.videoTaken = byteBuffer.get();
        this.color = byteBuffer.get();
        this.sharpness = byteBuffer.get();
        this.burstShutterRate = byteBuffer.get();
        this.continuousShutterSpeed = byteBuffer.get();
        this.timeLapseInterval = byteBuffer.get();
        this.extra1 = byteBuffer.getShort();
        this.extra2 = byteBuffer.getShort();
        this.extra3 = byteBuffer.getShort();
        this.extra4 = byteBuffer.getShort();
        this.extra5 = byteBuffer.getShort();
    }

    /* access modifiers changed from: protected */
    public void getMessageValue(ByteBuffer byteBuffer) {
        byteBuffer.put(this.version);
        byteBuffer.put(this.model);
        byteBuffer.put(this.status);
        byteBuffer.put(this.recording);
        byteBuffer.put(this.captureMode);
        byteBuffer.put(this.fov);
        byteBuffer.put(this.videoResolution);
        byteBuffer.put(this.fps);
        byteBuffer.put(this.whiteBalance);
        byteBuffer.put(this.proTune);
        byteBuffer.put(this.videoExposure);
        byteBuffer.put(this.photoResolution);
        byteBuffer.put(this.photoExposure);
        byteBuffer.put(this.ntsc_pal);
        byteBuffer.put(this.lowLight);
        byteBuffer.put(this.spotMeter);
        byteBuffer.put(this.batteryRemaining);
        byteBuffer.put(this.photoRemaining);
        byteBuffer.put(this.photoTaken);
        byteBuffer.put(this.videoRemaining);
        byteBuffer.put(this.videoTaken);
        byteBuffer.put(this.color);
        byteBuffer.put(this.sharpness);
        byteBuffer.put(this.burstShutterRate);
        byteBuffer.put(this.continuousShutterSpeed);
        byteBuffer.put(this.timeLapseInterval);
        byteBuffer.putShort(this.extra1);
        byteBuffer.putShort(this.extra2);
        byteBuffer.putShort(this.extra3);
        byteBuffer.putShort(this.extra4);
        byteBuffer.putShort(this.extra5);
    }

    public byte getBatteryRemaining() {
        return this.batteryRemaining;
    }

    public byte getBurstShutterRate() {
        return this.burstShutterRate;
    }

    public byte getCaptureMode() {
        return this.captureMode;
    }

    public byte getColor() {
        return this.color;
    }

    public byte getContinuousShutterSpeed() {
        return this.continuousShutterSpeed;
    }

    public short getExtra1() {
        return this.extra1;
    }

    public short getExtra2() {
        return this.extra2;
    }

    public short getExtra3() {
        return this.extra3;
    }

    public short getExtra4() {
        return this.extra4;
    }

    public short getExtra5() {
        return this.extra5;
    }

    public byte getFov() {
        return this.fov;
    }

    public byte getFps() {
        return this.fps;
    }

    public byte getLowLight() {
        return this.lowLight;
    }

    public byte getModel() {
        return this.model;
    }

    public byte getNtsc_pal() {
        return this.ntsc_pal;
    }

    public byte getPhotoExposure() {
        return this.photoExposure;
    }

    public byte getPhotoRemaining() {
        return this.photoRemaining;
    }

    public byte getPhotoResolution() {
        return this.photoResolution;
    }

    public byte getPhotoTaken() {
        return this.photoTaken;
    }

    public byte getProTune() {
        return this.proTune;
    }

    public byte getRecording() {
        return this.recording;
    }

    public byte getSharpness() {
        return this.sharpness;
    }

    public byte getSpotMeter() {
        return this.spotMeter;
    }

    public byte getStatus() {
        return this.status;
    }

    public byte getTimeLapseInterval() {
        return this.timeLapseInterval;
    }

    public byte getVersion() {
        return this.version;
    }

    public byte getVideoExposure() {
        return this.videoExposure;
    }

    public byte getVideoRemaining() {
        return this.videoRemaining;
    }

    public byte getVideoResolution() {
        return this.videoResolution;
    }

    public byte getVideoTaken() {
        return this.videoTaken;
    }

    public byte getWhiteBalance() {
        return this.whiteBalance;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeByte(this.version);
        parcel.writeByte(this.model);
        parcel.writeByte(this.status);
        parcel.writeByte(this.recording);
        parcel.writeByte(this.captureMode);
        parcel.writeByte(this.fov);
        parcel.writeByte(this.videoResolution);
        parcel.writeByte(this.fps);
        parcel.writeByte(this.whiteBalance);
        parcel.writeByte(this.proTune);
        parcel.writeByte(this.videoExposure);
        parcel.writeByte(this.photoResolution);
        parcel.writeByte(this.photoExposure);
        parcel.writeByte(this.ntsc_pal);
        parcel.writeByte(this.lowLight);
        parcel.writeByte(this.spotMeter);
        parcel.writeByte(this.batteryRemaining);
        parcel.writeByte(this.photoRemaining);
        parcel.writeByte(this.photoTaken);
        parcel.writeByte(this.videoRemaining);
        parcel.writeByte(this.videoTaken);
        parcel.writeByte(this.color);
        parcel.writeByte(this.sharpness);
        parcel.writeByte(this.burstShutterRate);
        parcel.writeByte(this.continuousShutterSpeed);
        parcel.writeByte(this.timeLapseInterval);
        parcel.writeInt(this.extra1);
        parcel.writeInt(this.extra2);
        parcel.writeInt(this.extra3);
        parcel.writeInt(this.extra4);
        parcel.writeInt(this.extra5);
    }

    protected SoloGoproState(Parcel parcel) {
        super(parcel);
        this.version = parcel.readByte();
        this.model = parcel.readByte();
        this.status = parcel.readByte();
        this.recording = parcel.readByte();
        this.captureMode = parcel.readByte();
        this.fov = parcel.readByte();
        this.videoResolution = parcel.readByte();
        this.fps = parcel.readByte();
        this.whiteBalance = parcel.readByte();
        this.proTune = parcel.readByte();
        this.videoExposure = parcel.readByte();
        this.photoResolution = parcel.readByte();
        this.photoExposure = parcel.readByte();
        this.ntsc_pal = parcel.readByte();
        this.lowLight = parcel.readByte();
        this.spotMeter = parcel.readByte();
        this.batteryRemaining = parcel.readByte();
        this.photoRemaining = parcel.readByte();
        this.photoTaken = parcel.readByte();
        this.videoRemaining = parcel.readByte();
        this.videoTaken = parcel.readByte();
        this.color = parcel.readByte();
        this.sharpness = parcel.readByte();
        this.burstShutterRate = parcel.readByte();
        this.continuousShutterSpeed = parcel.readByte();
        this.timeLapseInterval = parcel.readByte();
        this.extra1 = (short) parcel.readInt();
        this.extra2 = (short) parcel.readInt();
        this.extra3 = (short) parcel.readInt();
        this.extra4 = (short) parcel.readInt();
        this.extra5 = (short) parcel.readInt();
    }

    public String toString() {
        return "SoloGoproState{batteryRemaining=" + this.batteryRemaining + ", version=" + this.version + ", model=" + this.model + ", status=" + this.status + ", recording=" + this.recording + ", captureMode=" + this.captureMode + ", fov=" + this.fov + ", videoResolution=" + this.videoResolution + ", fps=" + this.fps + ", whiteBalance=" + this.whiteBalance + ", proTune=" + this.proTune + ", videoExposure=" + this.videoExposure + ", photoResolution=" + this.photoResolution + ", photoExposure=" + this.photoExposure + ", ntsc_pal=" + this.ntsc_pal + ", lowLight=" + this.lowLight + ", spotMeter=" + this.spotMeter + ", photoRemaining=" + this.photoRemaining + ", photoTaken=" + this.photoTaken + ", videoRemaining=" + this.videoRemaining + ", videoTaken=" + this.videoTaken + ", color=" + this.color + ", sharpness=" + this.sharpness + ", burstShutterRate=" + this.burstShutterRate + ", continuousShutterSpeed=" + this.continuousShutterSpeed + ", timeLapseInterval=" + this.timeLapseInterval + ", extra1=" + this.extra1 + ", extra2=" + this.extra2 + ", extra3=" + this.extra3 + ", extra4=" + this.extra4 + ", extra5=" + this.extra5 + '}';
    }
}

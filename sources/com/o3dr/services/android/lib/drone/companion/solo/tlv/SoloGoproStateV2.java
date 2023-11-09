package com.o3dr.services.android.lib.drone.companion.solo.tlv;

import android.os.Parcel;
import android.os.Parcelable;
import com.o3dr.services.android.lib.drone.property.DroneAttribute;
import java.nio.ByteBuffer;

public class SoloGoproStateV2 extends TLVPacket implements DroneAttribute {
    public static final Parcelable.Creator<SoloGoproStateV2> CREATOR = new Parcelable.Creator<SoloGoproStateV2>() {
        public SoloGoproStateV2 createFromParcel(Parcel parcel) {
            return new SoloGoproStateV2(parcel);
        }

        public SoloGoproStateV2[] newArray(int i) {
            return new SoloGoproStateV2[i];
        }
    };
    public static final int MESSAGE_LENGTH = 36;
    private byte captureMode;
    private byte extra1;
    private short extra10;
    private short extra11;
    private short extra12;
    private byte extra2;
    private byte extra3;
    private byte extra4;
    private byte extra5;
    private byte extra6;
    private byte extra7;
    private short extra8;
    private short extra9;
    private byte fov;
    private byte fps;
    private byte gimbalEnabled;
    private byte lowLight;
    private byte model;
    private byte ntsc_pal;
    private byte photoBurstRate;
    private byte photoResolution;
    private byte recording;
    private byte status;
    private byte version;
    private byte videoColor;
    private byte videoExposure;
    private byte videoGain;
    private byte videoProtune;
    private byte videoResolution;
    private byte videoSharpness;
    private byte videoWhiteBalance;

    public SoloGoproStateV2(ByteBuffer byteBuffer) {
        super(TLVMessageTypes.TYPE_SOLO_GOPRO_STATE_V2, 36);
        this.version = byteBuffer.get();
        this.model = byteBuffer.get();
        this.status = byteBuffer.get();
        this.recording = byteBuffer.get();
        this.captureMode = byteBuffer.get();
        this.ntsc_pal = byteBuffer.get();
        this.videoResolution = byteBuffer.get();
        this.fps = byteBuffer.get();
        this.fov = byteBuffer.get();
        this.lowLight = byteBuffer.get();
        this.photoResolution = byteBuffer.get();
        this.photoBurstRate = byteBuffer.get();
        this.videoProtune = byteBuffer.get();
        this.videoWhiteBalance = byteBuffer.get();
        this.videoColor = byteBuffer.get();
        this.videoGain = byteBuffer.get();
        this.videoSharpness = byteBuffer.get();
        this.videoExposure = byteBuffer.get();
        this.gimbalEnabled = byteBuffer.get();
        this.extra1 = byteBuffer.get();
        this.extra2 = byteBuffer.get();
        this.extra3 = byteBuffer.get();
        this.extra4 = byteBuffer.get();
        this.extra5 = byteBuffer.get();
        this.extra6 = byteBuffer.get();
        this.extra7 = byteBuffer.get();
        this.extra8 = byteBuffer.getShort();
        this.extra9 = byteBuffer.getShort();
        this.extra10 = byteBuffer.getShort();
        this.extra11 = byteBuffer.getShort();
        this.extra12 = byteBuffer.getShort();
    }

    /* access modifiers changed from: protected */
    public void getMessageValue(ByteBuffer byteBuffer) {
        byteBuffer.put(this.version);
        byteBuffer.put(this.model);
        byteBuffer.put(this.status);
        byteBuffer.put(this.recording);
        byteBuffer.put(this.captureMode);
        byteBuffer.put(this.ntsc_pal);
        byteBuffer.put(this.videoResolution);
        byteBuffer.put(this.fps);
        byteBuffer.put(this.fov);
        byteBuffer.put(this.lowLight);
        byteBuffer.put(this.photoResolution);
        byteBuffer.put(this.photoBurstRate);
        byteBuffer.put(this.videoProtune);
        byteBuffer.put(this.videoWhiteBalance);
        byteBuffer.put(this.videoColor);
        byteBuffer.put(this.videoGain);
        byteBuffer.put(this.videoSharpness);
        byteBuffer.put(this.videoExposure);
        byteBuffer.put(this.gimbalEnabled);
        byteBuffer.put(this.extra1);
        byteBuffer.put(this.extra2);
        byteBuffer.put(this.extra3);
        byteBuffer.put(this.extra4);
        byteBuffer.put(this.extra5);
        byteBuffer.put(this.extra6);
        byteBuffer.put(this.extra7);
        byteBuffer.putShort(this.extra8);
        byteBuffer.putShort(this.extra9);
        byteBuffer.putShort(this.extra10);
        byteBuffer.putShort(this.extra11);
        byteBuffer.putShort(this.extra12);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeByte(this.version);
        parcel.writeByte(this.model);
        parcel.writeByte(this.status);
        parcel.writeByte(this.recording);
        parcel.writeByte(this.captureMode);
        parcel.writeByte(this.ntsc_pal);
        parcel.writeByte(this.fov);
        parcel.writeByte(this.videoResolution);
        parcel.writeByte(this.fps);
        parcel.writeByte(this.lowLight);
        parcel.writeByte(this.photoResolution);
        parcel.writeByte(this.photoBurstRate);
        parcel.writeByte(this.videoProtune);
        parcel.writeByte(this.videoWhiteBalance);
        parcel.writeByte(this.videoColor);
        parcel.writeByte(this.videoGain);
        parcel.writeByte(this.videoSharpness);
        parcel.writeByte(this.videoExposure);
        parcel.writeByte(this.gimbalEnabled);
        parcel.writeByte(this.extra1);
        parcel.writeByte(this.extra2);
        parcel.writeByte(this.extra3);
        parcel.writeByte(this.extra4);
        parcel.writeByte(this.extra5);
        parcel.writeByte(this.extra6);
        parcel.writeByte(this.extra7);
        parcel.writeInt(this.extra8);
        parcel.writeInt(this.extra9);
        parcel.writeInt(this.extra10);
        parcel.writeInt(this.extra11);
        parcel.writeInt(this.extra12);
    }

    protected SoloGoproStateV2(Parcel parcel) {
        super(parcel);
        this.version = parcel.readByte();
        this.model = parcel.readByte();
        this.status = parcel.readByte();
        this.recording = parcel.readByte();
        this.captureMode = parcel.readByte();
        this.ntsc_pal = parcel.readByte();
        this.fov = parcel.readByte();
        this.videoResolution = parcel.readByte();
        this.fps = parcel.readByte();
        this.lowLight = parcel.readByte();
        this.photoResolution = parcel.readByte();
        this.photoBurstRate = parcel.readByte();
        this.videoProtune = parcel.readByte();
        this.videoWhiteBalance = parcel.readByte();
        this.videoColor = parcel.readByte();
        this.videoGain = parcel.readByte();
        this.videoSharpness = parcel.readByte();
        this.videoExposure = parcel.readByte();
        this.gimbalEnabled = parcel.readByte();
        this.extra1 = parcel.readByte();
        this.extra2 = parcel.readByte();
        this.extra3 = parcel.readByte();
        this.extra4 = parcel.readByte();
        this.extra5 = parcel.readByte();
        this.extra6 = parcel.readByte();
        this.extra7 = parcel.readByte();
        this.extra8 = (short) parcel.readInt();
        this.extra9 = (short) parcel.readInt();
        this.extra10 = (short) parcel.readInt();
        this.extra11 = (short) parcel.readInt();
        this.extra12 = (short) parcel.readInt();
    }

    public String toString() {
        return "SoloGoproStateV2{captureMode=" + this.captureMode + ", version=" + this.version + ", model=" + this.model + ", status=" + this.status + ", recording=" + this.recording + ", ntsc_pal=" + this.ntsc_pal + ", fov=" + this.fov + ", videoResolution=" + this.videoResolution + ", fps=" + this.fps + ", lowLight=" + this.lowLight + ", photoResolution=" + this.photoResolution + ", photoBurstRate=" + this.photoBurstRate + ", videoProtune=" + this.videoProtune + ", videoWhiteBalance=" + this.videoWhiteBalance + ", videoColor=" + this.videoColor + ", videoGain=" + this.videoGain + ", videoSharpness=" + this.videoSharpness + ", videoExposure=" + this.videoExposure + ", gimbalEnabled=" + this.gimbalEnabled + ", extra1=" + this.extra1 + ", extra2=" + this.extra2 + ", extra3=" + this.extra3 + ", extra4=" + this.extra4 + ", extra5=" + this.extra5 + ", extra6=" + this.extra6 + ", extra7=" + this.extra7 + ", extra8=" + this.extra8 + ", extra9=" + this.extra9 + ", extra10=" + this.extra10 + ", extra11=" + this.extra11 + ", extra12=" + this.extra12 + '}';
    }

    public byte getFov() {
        return this.fov;
    }

    public byte getFps() {
        return this.fps;
    }

    public byte getGimbalEnabled() {
        return this.gimbalEnabled;
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

    public byte getPhotoBurstRate() {
        return this.photoBurstRate;
    }

    public byte getPhotoResolution() {
        return this.photoResolution;
    }

    public byte getRecording() {
        return this.recording;
    }

    public byte getStatus() {
        return this.status;
    }

    public byte getVersion() {
        return this.version;
    }

    public byte getVideoColor() {
        return this.videoColor;
    }

    public byte getVideoExposure() {
        return this.videoExposure;
    }

    public byte getVideoGain() {
        return this.videoGain;
    }

    public byte getVideoProtune() {
        return this.videoProtune;
    }

    public byte getVideoResolution() {
        return this.videoResolution;
    }

    public byte getVideoSharpness() {
        return this.videoSharpness;
    }

    public byte getVideoWhiteBalance() {
        return this.videoWhiteBalance;
    }

    public byte getCaptureMode() {
        return this.captureMode;
    }
}

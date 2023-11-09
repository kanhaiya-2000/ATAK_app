package com.aeryon.java.types;

public class CameraStream {
    private double hfov;
    private boolean isRecording;
    private String name;
    private int payloadSlot;
    private int streamIndex;
    private String url;
    private double vfov;

    public CameraStream(String str, String str2, float f, float f2, int i, int i2, boolean z) {
        this.name = str;
        this.url = str2;
        this.vfov = Math.toDegrees((double) f2);
        this.hfov = Math.toDegrees((double) f);
        this.payloadSlot = i;
        this.streamIndex = i2;
        this.isRecording = z;
    }

    public boolean getIsRecording() {
        return this.isRecording;
    }

    public String getName() {
        return this.name;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "Camera Stream:\nName: " + this.name + "\nURL: " + this.url + "\nPayloadSlot: " + this.payloadSlot + "\nStreamIndex: " + this.streamIndex + "\n";
    }

    public int getPayloadSlot() {
        return this.payloadSlot;
    }

    public double getVerticalFieldOfView() {
        return this.vfov;
    }

    public double getHorizontalFieldOfView() {
        return this.hfov;
    }

    public int getStreamIndex() {
        return this.streamIndex;
    }

    public String getNamePretty() {
        String name2 = getName();
        int indexOf = name2.indexOf("/");
        return indexOf > 0 ? name2.substring(indexOf + 1) : name2;
    }
}

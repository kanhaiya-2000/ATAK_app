package com.autel.common.camera.media;

public class PhotoStyle {
    public int brightness;
    public int contrast = -4;
    public int hue;
    public int saturation = -4;
    public int sharpness = -4;
    public PhotoStyleType type;

    public String toString() {
        return "type " + this.type + "   contrast   " + this.contrast + "  saturation  " + this.saturation + "   sharpness " + this.sharpness + "  brightness  " + this.brightness + "  hue  " + this.hue;
    }
}

package com.autel.internal.camera.xbbasic;

import com.autel.common.camera.media.SkylinePositionData;

public class SkylinePositionDataImpl implements SkylinePositionData {
    public int heightDistanceBetweenSkylineAndValidBoundary;
    public int skylineYPosition;

    public int getSkylineYPosition() {
        return this.skylineYPosition;
    }

    public int getHeightDistanceBetweenSkylineAndValidBoundary() {
        return this.heightDistanceBetweenSkylineAndValidBoundary;
    }

    public String toString() {
        return "skylineYPosition : " + this.skylineYPosition + ", heightDistanceBetweenSkylineAndValidBoundary : " + this.heightDistanceBetweenSkylineAndValidBoundary;
    }
}

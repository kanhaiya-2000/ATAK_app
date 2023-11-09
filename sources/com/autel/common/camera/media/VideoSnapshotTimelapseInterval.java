package com.autel.common.camera.media;

public enum VideoSnapshotTimelapseInterval {
    SECOND_5(5),
    SECOND_10(10),
    SECOND_30(30),
    SECOND_60(60),
    UNKNOWN(-1);
    
    private final int value;

    private VideoSnapshotTimelapseInterval(int i) {
        this.value = i;
    }

    public int value() {
        return this.value;
    }

    public static VideoSnapshotTimelapseInterval find(int i) {
        VideoSnapshotTimelapseInterval videoSnapshotTimelapseInterval = SECOND_5;
        if (videoSnapshotTimelapseInterval.value() == i) {
            return videoSnapshotTimelapseInterval;
        }
        VideoSnapshotTimelapseInterval videoSnapshotTimelapseInterval2 = SECOND_10;
        if (videoSnapshotTimelapseInterval2.value() == i) {
            return videoSnapshotTimelapseInterval2;
        }
        VideoSnapshotTimelapseInterval videoSnapshotTimelapseInterval3 = SECOND_30;
        if (videoSnapshotTimelapseInterval3.value() == i) {
            return videoSnapshotTimelapseInterval3;
        }
        VideoSnapshotTimelapseInterval videoSnapshotTimelapseInterval4 = SECOND_60;
        if (videoSnapshotTimelapseInterval4.value() == i) {
            return videoSnapshotTimelapseInterval4;
        }
        return UNKNOWN;
    }
}

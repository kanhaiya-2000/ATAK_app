package com.autel.common.camera.media;

public enum SaveLocation {
    SD_CARD(0),
    FLASH_CARD(1),
    UNKNOWN(-1);
    
    private final int value;

    private SaveLocation(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static SaveLocation find(int i) {
        SaveLocation saveLocation = SD_CARD;
        if (saveLocation.getValue() == i) {
            return saveLocation;
        }
        SaveLocation saveLocation2 = FLASH_CARD;
        if (saveLocation2.getValue() == i) {
            return saveLocation2;
        }
        return UNKNOWN;
    }
}

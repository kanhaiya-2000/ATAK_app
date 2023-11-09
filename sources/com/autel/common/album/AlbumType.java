package com.autel.common.album;

public enum AlbumType {
    ALL(0),
    VIDEO(1),
    PHOTO(2);
    
    private final int value;

    private AlbumType(int i) {
        this.value = i;
    }

    public int value() {
        return this.value;
    }
}

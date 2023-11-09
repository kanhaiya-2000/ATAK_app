package com.autel.internal.sdk.camera.xb008;

public enum FileNamingMode {
    CONTINUE("Continue"),
    RESET("Reset"),
    UNKNOWN("UnKnown");
    
    private String value;

    private FileNamingMode(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }

    public FileNamingMode find(String str) {
        FileNamingMode fileNamingMode = CONTINUE;
        if (fileNamingMode.getValue().equals(str)) {
            return fileNamingMode;
        }
        FileNamingMode fileNamingMode2 = RESET;
        if (fileNamingMode2.getValue().equals(str)) {
            return fileNamingMode2;
        }
        return UNKNOWN;
    }
}

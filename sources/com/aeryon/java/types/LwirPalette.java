package com.aeryon.java.types;

public enum LwirPalette {
    Unknown(0),
    WhiteHot(1),
    BlackHot(2),
    Rainbow(3),
    Ironbow(4);
    
    private static LwirPalette[] items;
    private static String[] names;
    public int value;

    static {
        int i;
        LwirPalette[] values = values();
        items = values;
        names = new String[(values.length - 1)];
        while (true) {
            String[] strArr = names;
            if (i < strArr.length) {
                int i2 = i + 1;
                strArr[i] = items[i2].name();
                i = i2;
            } else {
                return;
            }
        }
    }

    public static LwirPalette[] getItems() {
        return items;
    }

    public static String[] getNames() {
        return names;
    }

    private LwirPalette(int i) {
        this.value = i;
    }

    public static LwirPalette fromInt(int i) {
        if (i > 0) {
            LwirPalette[] lwirPaletteArr = items;
            if (i < lwirPaletteArr.length) {
                return lwirPaletteArr[i];
            }
        }
        return Unknown;
    }

    public static LwirPalette fromString(String str) {
        for (LwirPalette lwirPalette : items) {
            if (lwirPalette.name().equals(str)) {
                return lwirPalette;
            }
        }
        return Unknown;
    }
}

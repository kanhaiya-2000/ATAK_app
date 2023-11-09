package com.aeryon.java.types;

public enum SensorType {
    VisibleLight(0),
    LongWaveInfrared(1),
    MultiplePip(2),
    MultipleFusion(3),
    Unknown(-1);
    
    private static SensorType[] items;
    private static String[] names;
    public int value;

    static {
        int i;
        SensorType[] values = values();
        items = values;
        names = new String[(values.length - 1)];
        while (true) {
            String[] strArr = names;
            if (i < strArr.length) {
                strArr[i] = items[i].name();
                i++;
            } else {
                return;
            }
        }
    }

    public static SensorType[] getItems() {
        return items;
    }

    public static String[] getNames() {
        return names;
    }

    private SensorType(int i) {
        this.value = i;
    }

    public static SensorType fromInt(int i) {
        if (i > 0) {
            SensorType[] sensorTypeArr = items;
            if (i < sensorTypeArr.length) {
                return sensorTypeArr[i];
            }
        }
        return Unknown;
    }

    public static SensorType fromString(String str) {
        for (SensorType sensorType : items) {
            if (sensorType.name().equals(str)) {
                return sensorType;
            }
        }
        return Unknown;
    }
}

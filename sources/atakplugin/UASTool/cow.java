package atakplugin.UASTool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum cow {
    NULL,
    INT,
    LONG,
    FLOAT,
    DOUBLE,
    BOOLEAN,
    CHAR,
    STRING,
    ALL,
    PRIMITIVE;

    /* renamed from: a */
    public static List<cow> m11907a() {
        ArrayList arrayList = new ArrayList(Arrays.asList(values()));
        arrayList.remove(ALL);
        arrayList.remove(PRIMITIVE);
        return arrayList;
    }

    /* renamed from: b */
    public static List<cow> m11908b() {
        return new ArrayList(Arrays.asList(new cow[]{INT, LONG, FLOAT, DOUBLE, BOOLEAN, CHAR}));
    }
}

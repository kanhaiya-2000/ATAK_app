package com.autel.internal.sdk.util;

import com.autel.util.jni.Utils;
import java.util.ArrayList;
import java.util.Map;

public class SignUtil {
    static final String pKey = "b7022c97a7d8c9fc47b2c14b8b375a9e";

    public static String getSign(Map<String, Object> map) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : map.entrySet()) {
            if (next.getValue() != null && !next.getValue().equals("")) {
                arrayList.add(((String) next.getKey()) + "=" + next.getValue() + "&");
            }
        }
        String[] strArr = new String[arrayList.size()];
        arrayList.toArray(strArr);
        return change(strArr);
    }

    private static String change(String[] strArr) {
        return Utils.stringFromSign(strArr);
    }
}

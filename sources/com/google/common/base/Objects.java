package com.google.common.base;

import atakplugin.UASTool.cij;
import java.util.Arrays;

public final class Objects extends ExtraObjectsMethodsForWeb {
    private Objects() {
    }

    public static boolean equal(@cij Object obj, @cij Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int hashCode(@cij Object... objArr) {
        return Arrays.hashCode(objArr);
    }
}

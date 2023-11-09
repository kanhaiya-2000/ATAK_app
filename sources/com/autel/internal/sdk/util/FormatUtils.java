package com.autel.internal.sdk.util;

import java.math.BigDecimal;

public final class FormatUtils {
    private FormatUtils() {
    }

    public static double doubleFormat(double d) {
        return new BigDecimal(d).setScale(1, 5).doubleValue();
    }
}

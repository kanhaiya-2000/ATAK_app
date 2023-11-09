package com.autel.sdk10.AutelNet.AutelMavlinkCore.core.mavlinkcmds.mavlinkparameter;

import com.autel.util.log.AutelLog;
import com.autel.util.log.AutelLogTags;
import java.text.DecimalFormat;
import java.text.ParseException;

public final class ParamsUtils {
    private static final DecimalFormat formatter = Parameter.getFormat();

    private ParamsUtils() {
    }

    public static Parameter getParameter(String str, String str2, int i) {
        try {
            return new Parameter(str, formatter.parse(str2).doubleValue(), i);
        } catch (ParseException e) {
            AutelLog.m15084e(AutelLogTags.TAG_MAVLINK, e.toString());
            return null;
        }
    }

    public static void commit(Parameter parameter, String str) {
        try {
            parameter.setValue(formatter.parse(str).doubleValue());
        } catch (ParseException e) {
            AutelLog.m15084e(AutelLogTags.TAG_MAVLINK, e.toString());
        }
    }
}

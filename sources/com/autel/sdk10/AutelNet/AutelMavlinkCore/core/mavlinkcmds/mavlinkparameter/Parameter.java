package com.autel.sdk10.AutelNet.AutelMavlinkCore.core.mavlinkcmds.mavlinkparameter;

import com.MAVLink.Messages.ardupilotmega.msg_param_value;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class Parameter {
    private static final DecimalFormat format;
    private String name;
    private int type;
    private double value;

    static {
        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(Locale.ENGLISH);
        format = decimalFormat;
        decimalFormat.applyPattern("0.###");
    }

    public Parameter(String str, double d, int i) {
        this.name = str;
        this.value = d;
        this.type = i;
    }

    public Parameter(msg_param_value msg_param_value) {
        this(msg_param_value.getParam_Id(), (double) msg_param_value.param_value, msg_param_value.param_type);
    }

    public String getValueStr() {
        return format.format(this.value);
    }

    public void setValue(double d) {
        this.value = d;
    }

    public double getValue() {
        return this.value;
    }

    public String getName() {
        return this.name;
    }

    public int getType() {
        return this.type;
    }

    public static DecimalFormat getFormat() {
        return format;
    }

    public String toString() {
        return "Parameter [name=" + this.name + ", type=" + this.type + ", value=" + this.value + "]";
    }
}

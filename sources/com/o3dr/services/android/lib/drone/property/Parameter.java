package com.o3dr.services.android.lib.drone.property;

import android.os.Parcel;
import android.os.Parcelable;
import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;

public class Parameter implements DroneAttribute, Comparable<Parameter> {
    public static final Parcelable.Creator<Parameter> CREATOR = new Parcelable.Creator<Parameter>() {
        public Parameter createFromParcel(Parcel parcel) {
            return new Parameter(parcel);
        }

        public Parameter[] newArray(int i) {
            return new Parameter[i];
        }
    };
    public static final int RANGE_HIGH = 1;
    public static final int RANGE_LOW = 0;
    private static final DecimalFormat formatter;
    private String description;
    private String displayName;
    private String name;
    private String range;
    private int type;
    private String units;
    private double value;
    private String values;

    public int describeContents() {
        return 0;
    }

    static {
        DecimalFormat decimalFormat = (DecimalFormat) DecimalFormat.getInstance();
        formatter = decimalFormat;
        decimalFormat.applyPattern("0.###");
    }

    public Parameter(String str, double d, int i) {
        this.name = str;
        this.value = d;
        this.type = i;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public double getValue() {
        return this.value;
    }

    public String getDisplayValue() {
        return formatter.format(this.value);
    }

    public void setValue(double d) {
        this.value = d;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public String getUnits() {
        return this.units;
    }

    public void setUnits(String str) {
        this.units = str;
    }

    public String getRange() {
        return this.range;
    }

    public void setRange(String str) {
        this.range = str;
    }

    public String getValues() {
        return this.values;
    }

    public void setValues(String str) {
        this.values = str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = r1.values;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean hasInfo() {
        /*
            r1 = this;
            java.lang.String r0 = r1.description
            if (r0 == 0) goto L_0x000a
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0014
        L_0x000a:
            java.lang.String r0 = r1.values
            if (r0 == 0) goto L_0x0016
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0016
        L_0x0014:
            r0 = 1
            goto L_0x0017
        L_0x0016:
            r0 = 0
        L_0x0017:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.o3dr.services.android.lib.drone.property.Parameter.hasInfo():boolean");
    }

    public double[] parseRange() {
        DecimalFormat decimalFormat = formatter;
        String[] split = this.range.split("( to |\\s+|-)");
        if (split.length >= 2) {
            return new double[]{decimalFormat.parse(split[0]).doubleValue(), decimalFormat.parse(split[1]).doubleValue()};
        }
        throw new IllegalArgumentException();
    }

    public Map<Double, String> parseValues() {
        DecimalFormat decimalFormat = formatter;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String str = this.values;
        if (str != null) {
            String[] split = str.split(",");
            int length = split.length;
            int i = 0;
            while (i < length) {
                String[] split2 = split[i].split(":");
                if (split2.length == 2) {
                    linkedHashMap.put(Double.valueOf(decimalFormat.parse(split2[0].trim()).doubleValue()), split2[1].trim());
                    i++;
                } else {
                    throw new IllegalArgumentException();
                }
            }
        }
        return linkedHashMap;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Parameter)) {
            return false;
        }
        String str = this.name;
        String str2 = ((Parameter) obj).name;
        if (str != null) {
            if (!str.equals(str2)) {
                return false;
            }
            return true;
        } else if (str2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.name;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeDouble(this.value);
        parcel.writeInt(this.type);
        parcel.writeString(this.displayName);
        parcel.writeString(this.description);
        parcel.writeString(this.units);
        parcel.writeString(this.range);
        parcel.writeString(this.values);
    }

    private Parameter(Parcel parcel) {
        this.name = parcel.readString();
        this.value = parcel.readDouble();
        this.type = parcel.readInt();
        this.displayName = parcel.readString();
        this.description = parcel.readString();
        this.units = parcel.readString();
        this.range = parcel.readString();
        this.values = parcel.readString();
    }

    public int compareTo(Parameter parameter) {
        return this.name.compareTo(parameter.name);
    }
}

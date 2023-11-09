package org.droidplanner.services.android.impl.core.drone.profiles;

import java.io.Serializable;

public class ParameterMetadata implements Serializable {
    private String description;
    private String displayName;
    private String name;
    private String range;
    private String units;
    private String values;

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
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
}

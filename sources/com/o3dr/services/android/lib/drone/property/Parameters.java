package com.o3dr.services.android.lib.drone.property;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class Parameters implements DroneAttribute {
    public static final Parcelable.Creator<Parameters> CREATOR = new Parcelable.Creator<Parameters>() {
        public Parameters createFromParcel(Parcel parcel) {
            return new Parameters(parcel);
        }

        public Parameters[] newArray(int i) {
            return new Parameters[i];
        }
    };
    private final List<Parameter> parametersList;

    public int describeContents() {
        return 0;
    }

    public Parameters() {
        this.parametersList = new ArrayList();
    }

    public Parameters(Collection<Parameter> collection) {
        this.parametersList = new ArrayList();
        setParametersList(collection);
    }

    public List<Parameter> getParameters() {
        return this.parametersList;
    }

    public Parameter getParameter(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (Parameter next : this.parametersList) {
            if (next.getName().equalsIgnoreCase(str)) {
                return next;
            }
        }
        return null;
    }

    public void setParametersList(Collection<Parameter> collection) {
        this.parametersList.clear();
        if (collection != null && !collection.isEmpty()) {
            this.parametersList.addAll(collection);
        }
    }

    public void addParameter(Parameter parameter) {
        Objects.requireNonNull(parameter, "Invalid parameter argument.");
        this.parametersList.add(parameter);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.parametersList);
    }

    private Parameters(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        this.parametersList = arrayList;
        parcel.readTypedList(arrayList, Parameter.CREATOR);
    }
}

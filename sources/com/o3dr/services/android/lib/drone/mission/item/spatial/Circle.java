package com.o3dr.services.android.lib.drone.mission.item.spatial;

import android.os.Parcel;
import android.os.Parcelable;
import com.o3dr.services.android.lib.drone.mission.MissionItemType;
import com.o3dr.services.android.lib.drone.mission.item.MissionItem;

public class Circle extends BaseSpatialItem implements Parcelable {
    public static final Parcelable.Creator<Circle> CREATOR = new Parcelable.Creator<Circle>() {
        public Circle createFromParcel(Parcel parcel) {
            return new Circle(parcel);
        }

        public Circle[] newArray(int i) {
            return new Circle[i];
        }
    };
    private double radius;
    private int turns;

    public Circle() {
        super(MissionItemType.CIRCLE);
        this.radius = 10.0d;
        this.turns = 1;
    }

    public Circle(Circle circle) {
        super((BaseSpatialItem) circle);
        this.radius = 10.0d;
        this.turns = 1;
        this.radius = circle.radius;
        this.turns = circle.turns;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double d) {
        this.radius = d;
    }

    public int getTurns() {
        return this.turns;
    }

    public void setTurns(int i) {
        this.turns = i;
    }

    public String toString() {
        return "Circle{radius=" + this.radius + ", turns=" + this.turns + ", " + super.toString() + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Circle) || !super.equals(obj)) {
            return false;
        }
        Circle circle = (Circle) obj;
        if (Double.compare(circle.radius, this.radius) == 0 && this.turns == circle.turns) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = super.hashCode();
        long doubleToLongBits = Double.doubleToLongBits(this.radius);
        return (((hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + this.turns;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeDouble(this.radius);
        parcel.writeInt(this.turns);
    }

    private Circle(Parcel parcel) {
        super(parcel);
        this.radius = 10.0d;
        this.turns = 1;
        this.radius = parcel.readDouble();
        this.turns = parcel.readInt();
    }

    public MissionItem clone() {
        return new Circle(this);
    }
}

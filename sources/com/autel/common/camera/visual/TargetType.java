package com.autel.common.camera.visual;

public enum TargetType {
    Background(0),
    Animal(1),
    Boat(2),
    Car(3),
    Person(4),
    Rider(5),
    Vehicle(6),
    DetectAndSelectPerson(7),
    Take_Photo(8),
    StartOrStopRecording(9),
    VehicleLP(10),
    LicensePlate(11),
    UNKNOWN(-1);
    
    private int value;

    private TargetType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static TargetType find(int i) {
        TargetType targetType = Background;
        if (targetType.getValue() == i) {
            return targetType;
        }
        TargetType targetType2 = Animal;
        if (targetType2.getValue() == i) {
            return targetType2;
        }
        TargetType targetType3 = Boat;
        if (targetType3.getValue() == i) {
            return targetType3;
        }
        TargetType targetType4 = Car;
        if (targetType4.getValue() == i) {
            return targetType4;
        }
        TargetType targetType5 = Person;
        if (targetType5.getValue() == i) {
            return targetType5;
        }
        TargetType targetType6 = Rider;
        if (targetType6.getValue() == i) {
            return targetType6;
        }
        TargetType targetType7 = Vehicle;
        if (targetType7.getValue() == i) {
            return targetType7;
        }
        TargetType targetType8 = DetectAndSelectPerson;
        if (targetType8.getValue() == i) {
            return targetType8;
        }
        TargetType targetType9 = Take_Photo;
        if (targetType9.getValue() == i) {
            return targetType9;
        }
        TargetType targetType10 = StartOrStopRecording;
        if (targetType10.getValue() == i) {
            return targetType10;
        }
        TargetType targetType11 = VehicleLP;
        if (targetType11.getValue() == i) {
            return targetType11;
        }
        TargetType targetType12 = LicensePlate;
        if (targetType12.getValue() == i) {
            return targetType12;
        }
        return UNKNOWN;
    }
}

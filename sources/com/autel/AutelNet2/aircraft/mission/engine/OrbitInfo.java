package com.autel.AutelNet2.aircraft.mission.engine;

import com.autel.common.mission.evo.OrbitEntryDirection;
import com.autel.common.mission.evo.OrbitHeadingDirection;
import com.autel.common.mission.evo.OrbitRotateDirection;

public class OrbitInfo {
    private int CenterAltitude;
    private int CenterLatitude;
    private int CenterLongitude;
    private int Cycles;
    private int EntryDirection;
    private int HeadingDirection;
    private int Radius;
    private int RemainDegree;
    private int RotateDirection;
    private int Speed;
    private int oRadius = -1000;
    private float oSpeed = -1.0f;

    public void setoSpeed(float f) {
        this.oSpeed = f;
    }

    public float getoSpeed() {
        return this.oSpeed;
    }

    public int getSpeed() {
        return this.Speed;
    }

    public void setSpeed(int i) {
        this.Speed = i;
    }

    public int getRadius() {
        return this.Radius;
    }

    public void setRadius(int i) {
        this.Radius = i;
    }

    public float getoRadius() {
        return (float) (this.oRadius / 1000);
    }

    public void setoRadius(int i) {
        this.oRadius = i;
    }

    public int getCycles() {
        return this.Cycles;
    }

    public void setCycles(int i) {
        this.Cycles = i;
    }

    public int getRemainDegree() {
        return this.RemainDegree;
    }

    public void setRemainDegree(int i) {
        this.RemainDegree = i;
    }

    public int getRotateDirection() {
        return this.RotateDirection;
    }

    public int getHeadingDirection() {
        return this.HeadingDirection;
    }

    public int getCenterLongitude() {
        return this.CenterLongitude;
    }

    public void setCenterLongitude(int i) {
        this.CenterLongitude = i;
    }

    public int getCenterAltitude() {
        return this.CenterAltitude;
    }

    public void setCenterAltitude(int i) {
        this.CenterAltitude = i;
    }

    public int getEntryDirection() {
        return this.EntryDirection;
    }

    public void setEntryDirection(OrbitEntryDirection orbitEntryDirection) {
        this.EntryDirection = orbitEntryDirection.getValue();
    }

    public void setHeadingDirection(OrbitHeadingDirection orbitHeadingDirection) {
        this.HeadingDirection = orbitHeadingDirection.getValue();
    }

    /* renamed from: com.autel.AutelNet2.aircraft.mission.engine.OrbitInfo$1 */
    /* synthetic */ class C22481 {
        static final /* synthetic */ int[] $SwitchMap$com$autel$common$mission$evo$OrbitRotateDirection;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.autel.common.mission.evo.OrbitRotateDirection[] r0 = com.autel.common.mission.evo.OrbitRotateDirection.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$autel$common$mission$evo$OrbitRotateDirection = r0
                com.autel.common.mission.evo.OrbitRotateDirection r1 = com.autel.common.mission.evo.OrbitRotateDirection.Clockwise     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$autel$common$mission$evo$OrbitRotateDirection     // Catch:{ NoSuchFieldError -> 0x001d }
                com.autel.common.mission.evo.OrbitRotateDirection r1 = com.autel.common.mission.evo.OrbitRotateDirection.Counterclockwise     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$autel$common$mission$evo$OrbitRotateDirection     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.autel.common.mission.evo.OrbitRotateDirection r1 = com.autel.common.mission.evo.OrbitRotateDirection.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.autel.AutelNet2.aircraft.mission.engine.OrbitInfo.C22481.<clinit>():void");
        }
    }

    public void setRotateDirection(OrbitRotateDirection orbitRotateDirection) {
        int i = C22481.$SwitchMap$com$autel$common$mission$evo$OrbitRotateDirection[orbitRotateDirection.ordinal()];
        if (i == 1) {
            this.RotateDirection = 0;
        } else if (i == 2) {
            this.RotateDirection = 1;
        } else if (i == 3) {
            this.RotateDirection = 0;
        }
    }

    public int getCenterLatitude() {
        return this.CenterLatitude;
    }

    public void setCenterLatitude(int i) {
        this.CenterLatitude = i;
    }
}

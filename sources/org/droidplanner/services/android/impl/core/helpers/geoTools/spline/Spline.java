package org.droidplanner.services.android.impl.core.helpers.geoTools.spline;

import com.o3dr.services.android.lib.coordinate.LatLong;
import java.util.ArrayList;
import java.util.List;

public class Spline {
    private static final double SPLINE_TENSION = 1.6d;

    /* renamed from: a */
    private LatLong f8644a;

    /* renamed from: b */
    private LatLong f8645b;

    /* renamed from: p0 */
    private LatLong f8646p0;
    private LatLong p0_prime;

    public Spline(LatLong latLong, LatLong latLong2, LatLong latLong3, LatLong latLong4) {
        this.f8646p0 = latLong2;
        this.p0_prime = latLong3.subtract(latLong).dot(0.625d);
        LatLong dot = latLong4.subtract(this.f8646p0).dot(0.625d);
        this.f8644a = LatLong.sum(this.f8646p0.dot(2.0d), latLong3.dot(-2.0d), this.p0_prime, dot);
        this.f8645b = LatLong.sum(this.f8646p0.dot(-3.0d), latLong3.dot(3.0d), this.p0_prime.dot(-2.0d), dot.negate());
    }

    public List<LatLong> generateCoordinates(int i) {
        ArrayList arrayList = new ArrayList();
        float f = 1.0f / ((float) i);
        for (float f2 = 0.0f; f2 < 1.0f; f2 += f) {
            arrayList.add(evaluate((double) f2));
        }
        return arrayList;
    }

    private LatLong evaluate(double d) {
        double d2 = d * d;
        return LatLong.sum(this.f8644a.dot(d2 * d), this.f8645b.dot(d2), this.p0_prime.dot(d), this.f8646p0);
    }
}

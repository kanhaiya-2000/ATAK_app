package com.atakmap.android.uastool.utils;

import com.atakmap.math.Matrix;

public class Matrix3D {
    public Matrix matrix = Matrix.getIdentity();

    public static Matrix3D getRotateZMatrix(double d) {
        double radians = Math.toRadians(d);
        Matrix3D matrix3D = new Matrix3D();
        matrix3D.set(0, 0, Math.cos(radians));
        matrix3D.set(0, 1, -Math.sin(radians));
        matrix3D.set(0, 2, 0.0d);
        matrix3D.set(1, 0, Math.sin(radians));
        matrix3D.set(1, 1, Math.cos(radians));
        matrix3D.set(1, 2, 0.0d);
        matrix3D.set(2, 0, 0.0d);
        matrix3D.set(2, 1, 0.0d);
        matrix3D.set(2, 2, 1.0d);
        return matrix3D;
    }

    public static Matrix3D getRotateYMatrix(double d) {
        double radians = Math.toRadians(d);
        Matrix3D matrix3D = new Matrix3D();
        matrix3D.set(0, 0, Math.cos(radians));
        matrix3D.set(0, 1, 0.0d);
        matrix3D.set(0, 2, Math.sin(radians));
        matrix3D.set(1, 0, 0.0d);
        matrix3D.set(1, 1, 1.0d);
        matrix3D.set(1, 2, 0.0d);
        matrix3D.set(2, 0, -Math.sin(radians));
        matrix3D.set(2, 1, 0.0d);
        matrix3D.set(2, 2, Math.cos(radians));
        return matrix3D;
    }

    public static Matrix3D getPitchMatrix(double d) {
        Matrix3D matrix3D = new Matrix3D();
        double radians = Math.toRadians(d);
        matrix3D.set(0, 0, 1.0d);
        matrix3D.set(0, 1, 0.0d);
        matrix3D.set(0, 2, 0.0d);
        matrix3D.set(1, 0, 0.0d);
        matrix3D.set(1, 1, Math.sin(radians));
        matrix3D.set(1, 2, -Math.cos(radians));
        matrix3D.set(2, 0, 0.0d);
        matrix3D.set(2, 1, Math.cos(radians));
        matrix3D.set(2, 2, Math.sin(radians));
        return matrix3D;
    }

    public static Matrix3D getRotateXMatrix(double d) {
        Matrix3D matrix3D = new Matrix3D();
        double radians = Math.toRadians(d);
        matrix3D.set(0, 0, 1.0d);
        matrix3D.set(0, 1, 0.0d);
        matrix3D.set(0, 2, 0.0d);
        matrix3D.set(1, 0, 0.0d);
        matrix3D.set(1, 1, Math.cos(radians));
        matrix3D.set(1, 2, -Math.sin(radians));
        matrix3D.set(2, 0, 0.0d);
        matrix3D.set(2, 1, Math.sin(radians));
        matrix3D.set(2, 2, Math.cos(radians));
        return matrix3D;
    }

    public void set(int i, int i2, double d) {
        this.matrix.set(i, i2, d);
    }

    public double get(int i, int i2) {
        return this.matrix.get(i, i2);
    }

    public Matrix3D transpose() {
        Matrix3D matrix3D = new Matrix3D();
        for (int i = 0; i < 3; i++) {
            for (int i2 = 0; i2 < 3; i2++) {
                matrix3D.set(i, i2, get(i2, i));
            }
        }
        return matrix3D;
    }

    public Point3D transform(Point3D point3D) {
        Point3D point3D2 = new Point3D(0.0d, 0.0d, 0.0d);
        this.matrix.transform(point3D, point3D2);
        return point3D2;
    }

    public Matrix3D dot(Matrix3D matrix3D) {
        Matrix3D matrix3D2 = new Matrix3D();
        Matrix matrix2 = this.matrix;
        Matrix matrix3 = matrix3D.matrix;
        matrix3D2.set(0, 0, (matrix2.get(0, 0) * matrix3.get(0, 0)) + (matrix2.get(0, 1) * matrix3.get(1, 0)) + (matrix2.get(0, 2) * matrix3.get(2, 0)));
        matrix3D2.set(0, 1, (matrix2.get(0, 0) * matrix3.get(0, 1)) + (matrix2.get(0, 1) * matrix3.get(1, 1)) + (matrix2.get(0, 2) * matrix3.get(2, 1)));
        matrix3D2.set(0, 2, (matrix2.get(0, 0) * matrix3.get(0, 2)) + (matrix2.get(0, 1) * matrix3.get(1, 2)) + (matrix2.get(0, 2) * matrix3.get(2, 2)));
        matrix3D2.set(1, 0, (matrix2.get(1, 0) * matrix3.get(0, 0)) + (matrix2.get(1, 1) * matrix3.get(1, 0)) + (matrix2.get(1, 2) * matrix3.get(2, 0)));
        matrix3D2.set(1, 1, (matrix2.get(1, 0) * matrix3.get(0, 1)) + (matrix2.get(1, 1) * matrix3.get(1, 1)) + (matrix2.get(1, 2) * matrix3.get(2, 1)));
        matrix3D2.set(1, 2, (matrix2.get(1, 0) * matrix3.get(0, 2)) + (matrix2.get(1, 1) * matrix3.get(1, 2)) + (matrix2.get(1, 2) * matrix3.get(2, 2)));
        matrix3D2.set(2, 0, (get(2, 0) * matrix3D.get(0, 0)) + (get(2, 1) * matrix3D.get(1, 0)) + (get(2, 2) * matrix3D.get(2, 0)));
        matrix3D2.set(2, 1, (get(2, 0) * matrix3D.get(0, 1)) + (get(2, 1) * matrix3D.get(1, 1)) + (get(2, 2) * matrix3D.get(2, 1)));
        matrix3D2.set(2, 2, (get(2, 0) * matrix3D.get(0, 2)) + (get(2, 1) * matrix3D.get(1, 2)) + (get(2, 2) * matrix3D.get(2, 2)));
        return matrix3D2;
    }

    public String toString() {
        return String.format("[%.3f,%.3f,%.3f]\n", new Object[]{Double.valueOf(get(0, 0)), Double.valueOf(get(0, 1)), Double.valueOf(get(0, 2))}) + String.format("[%.3f,%.3f,%.3f]\n", new Object[]{Double.valueOf(get(1, 0)), Double.valueOf(get(1, 1)), Double.valueOf(get(1, 2))}) + String.format("[%.3f,%.3f,%.3f]", new Object[]{Double.valueOf(get(2, 0)), Double.valueOf(get(2, 1)), Double.valueOf(get(2, 2))});
    }
}

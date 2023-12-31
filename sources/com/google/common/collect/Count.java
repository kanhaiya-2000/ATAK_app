package com.google.common.collect;

import atakplugin.UASTool.cij;
import java.io.Serializable;

final class Count implements Serializable {
    private int value;

    Count(int i) {
        this.value = i;
    }

    public int get() {
        return this.value;
    }

    public void add(int i) {
        this.value += i;
    }

    public int addAndGet(int i) {
        int i2 = this.value + i;
        this.value = i2;
        return i2;
    }

    public void set(int i) {
        this.value = i;
    }

    public int getAndSet(int i) {
        int i2 = this.value;
        this.value = i;
        return i2;
    }

    public int hashCode() {
        return this.value;
    }

    public boolean equals(@cij Object obj) {
        return (obj instanceof Count) && ((Count) obj).value == this.value;
    }

    public String toString() {
        return Integer.toString(this.value);
    }
}

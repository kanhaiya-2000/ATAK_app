package com.google.common.base;

import atakplugin.UASTool.cij;
import java.util.Collections;
import java.util.Set;

final class Present<T> extends Optional<T> {
    private static final long serialVersionUID = 0;
    private final T reference;

    public boolean isPresent() {
        return true;
    }

    Present(T t) {
        this.reference = t;
    }

    public T get() {
        return this.reference;
    }

    /* renamed from: or */
    public T mo19988or(T t) {
        Preconditions.checkNotNull(t, "use Optional.orNull() instead of Optional.or(null)");
        return this.reference;
    }

    /* renamed from: or */
    public Optional<T> mo19986or(Optional<? extends T> optional) {
        Preconditions.checkNotNull(optional);
        return this;
    }

    /* renamed from: or */
    public T mo19987or(Supplier<? extends T> supplier) {
        Preconditions.checkNotNull(supplier);
        return this.reference;
    }

    public T orNull() {
        return this.reference;
    }

    public Set<T> asSet() {
        return Collections.singleton(this.reference);
    }

    public <V> Optional<V> transform(Function<? super T, V> function) {
        return new Present(Preconditions.checkNotNull(function.apply(this.reference), "the Function passed to Optional.transform() must not return null."));
    }

    public boolean equals(@cij Object obj) {
        if (obj instanceof Present) {
            return this.reference.equals(((Present) obj).reference);
        }
        return false;
    }

    public int hashCode() {
        return this.reference.hashCode() + 1502476572;
    }

    public String toString() {
        return "Optional.of(" + this.reference + ")";
    }
}

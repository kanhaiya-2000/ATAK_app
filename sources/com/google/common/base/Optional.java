package com.google.common.base;

import atakplugin.UASTool.cij;
import com.google.errorprone.annotations.DoNotMock;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;

@DoNotMock("Use Optional.of(value) or Optional.absent()")
public abstract class Optional<T> implements Serializable {
    private static final long serialVersionUID = 0;

    public abstract Set<T> asSet();

    public abstract boolean equals(@cij Object obj);

    public abstract T get();

    public abstract int hashCode();

    public abstract boolean isPresent();

    /* renamed from: or */
    public abstract Optional<T> mo19986or(Optional<? extends T> optional);

    /* renamed from: or */
    public abstract T mo19987or(Supplier<? extends T> supplier);

    /* renamed from: or */
    public abstract T mo19988or(T t);

    @cij
    public abstract T orNull();

    public abstract String toString();

    public abstract <V> Optional<V> transform(Function<? super T, V> function);

    public static <T> Optional<T> absent() {
        return Absent.withType();
    }

    /* renamed from: of */
    public static <T> Optional<T> m15104of(T t) {
        return new Present(Preconditions.checkNotNull(t));
    }

    public static <T> Optional<T> fromNullable(@cij T t) {
        return t == null ? absent() : new Present(t);
    }

    Optional() {
    }

    public static <T> Iterable<T> presentInstances(final Iterable<? extends Optional<? extends T>> iterable) {
        Preconditions.checkNotNull(iterable);
        return new Iterable<T>() {
            public Iterator<T> iterator() {
                return new AbstractIterator<T>() {
                    private final Iterator<? extends Optional<? extends T>> iterator;

                    {
                        this.iterator = (Iterator) Preconditions.checkNotNull(iterable.iterator());
                    }

                    /* access modifiers changed from: protected */
                    public T computeNext() {
                        while (this.iterator.hasNext()) {
                            Optional optional = (Optional) this.iterator.next();
                            if (optional.isPresent()) {
                                return optional.get();
                            }
                        }
                        return endOfData();
                    }
                };
            }
        };
    }
}

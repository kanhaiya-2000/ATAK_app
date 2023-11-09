package com.google.common.reflect;

import atakplugin.UASTool.cij;
import com.google.errorprone.annotations.DoNotMock;
import java.util.Map;

@DoNotMock("Use ImmutableTypeToInstanceMap or MutableTypeToInstanceMap")
public interface TypeToInstanceMap<B> extends Map<TypeToken<? extends B>, B> {
    @cij
    <T extends B> T getInstance(TypeToken<T> typeToken);

    @cij
    <T extends B> T getInstance(Class<T> cls);

    @cij
    <T extends B> T putInstance(TypeToken<T> typeToken, @cij T t);

    @cij
    <T extends B> T putInstance(Class<T> cls, @cij T t);
}

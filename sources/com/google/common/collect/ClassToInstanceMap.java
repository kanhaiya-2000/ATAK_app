package com.google.common.collect;

import atakplugin.UASTool.cij;
import com.google.errorprone.annotations.DoNotMock;
import java.util.Map;

@DoNotMock("Use ImmutableClassToInstanceMap or MutableClassToInstanceMap")
public interface ClassToInstanceMap<B> extends Map<Class<? extends B>, B> {
    <T extends B> T getInstance(Class<T> cls);

    <T extends B> T putInstance(Class<T> cls, @cij T t);
}

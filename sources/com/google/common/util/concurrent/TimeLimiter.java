package com.google.common.util.concurrent;

import com.google.errorprone.annotations.DoNotMock;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

@DoNotMock("Use FakeTimeLimiter")
public interface TimeLimiter {
    <T> T callUninterruptiblyWithTimeout(Callable<T> callable, long j, TimeUnit timeUnit);

    <T> T callWithTimeout(Callable<T> callable, long j, TimeUnit timeUnit);

    <T> T newProxy(T t, Class<T> cls, long j, TimeUnit timeUnit);

    void runUninterruptiblyWithTimeout(Runnable runnable, long j, TimeUnit timeUnit);

    void runWithTimeout(Runnable runnable, long j, TimeUnit timeUnit);
}

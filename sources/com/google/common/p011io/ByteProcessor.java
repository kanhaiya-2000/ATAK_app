package com.google.common.p011io;

import com.google.errorprone.annotations.DoNotMock;

@DoNotMock("Implement it normally")
/* renamed from: com.google.common.io.ByteProcessor */
public interface ByteProcessor<T> {
    T getResult();

    boolean processBytes(byte[] bArr, int i, int i2);
}

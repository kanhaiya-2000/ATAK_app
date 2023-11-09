package com.autel.internal.sdk.warning;

import com.autel.common.error.AutelError;

public interface AutelWarningListener {
    void failed(AutelError autelError);
}

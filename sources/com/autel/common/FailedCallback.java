package com.autel.common;

import com.autel.common.error.AutelError;

public interface FailedCallback {
    void onFailure(AutelError autelError);
}

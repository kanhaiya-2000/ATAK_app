package com.autel.common.error;

public class RxException extends Throwable {
    private AutelError autelError;

    public RxException() {
    }

    public RxException(AutelError autelError2) {
        this.autelError = autelError2;
    }

    public AutelError getError() {
        return this.autelError;
    }

    public void setError(AutelError autelError2) {
        this.autelError = autelError2;
    }

    public String getMessage() {
        AutelError autelError2 = this.autelError;
        if (autelError2 == null) {
            return "error is null";
        }
        return autelError2.getDescription();
    }

    public String getLocalizedMessage() {
        AutelError autelError2 = this.autelError;
        if (autelError2 == null) {
            return "error is null";
        }
        return autelError2.getDescription();
    }
}

package com.autel.sdk10.AutelCommunity.enums;

public enum AutelErrorReson {
    EXIST_REGISTER(1),
    REQUEST_FAIL(2),
    REQUEST_DATA_ERROR(3),
    REQUEST_NETWORK_FAILED(4),
    REQUEST_ERROR_PARAM(5),
    REQUEST_LOSS_PARAM(6),
    REQUEST_NOT_FIND_DEVICE(7),
    EMAIL_NO_REGISTER(8),
    PASSWORD_ERROR(9),
    SYSTEM_ERROR(10);
    
    private final int value;

    private AutelErrorReson(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static AutelErrorReson find(int i) {
        AutelErrorReson autelErrorReson = EXIST_REGISTER;
        if (autelErrorReson.getValue() == i) {
            return autelErrorReson;
        }
        AutelErrorReson autelErrorReson2 = REQUEST_FAIL;
        if (autelErrorReson2.getValue() == i) {
            return autelErrorReson2;
        }
        AutelErrorReson autelErrorReson3 = REQUEST_DATA_ERROR;
        if (autelErrorReson3.getValue() == i) {
            return autelErrorReson3;
        }
        AutelErrorReson autelErrorReson4 = REQUEST_NETWORK_FAILED;
        if (autelErrorReson4.getValue() == i) {
            return autelErrorReson4;
        }
        return null;
    }
}

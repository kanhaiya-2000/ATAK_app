package com.autel.libupdrage.upgrade.entity;

import com.autel.common.error.AutelError;
import com.autel.common.error.AutelErrorCode;

public class FirmwareUpgradeError extends AutelError {
    public static final FirmwareUpgradeError FIRMWARE_UPGRADE_FAILED = new FirmwareUpgradeError(AutelErrorCode.FIRMWARE_UPGRADE_FAILED, "Failed to upgrade the firmware");
    public static final FirmwareUpgradeError FIRMWARE_UPGRADE_FAILED_DISCONNECT = new FirmwareUpgradeError(AutelErrorCode.FIRMWARE_UPGRADE_FAILED_DISCONNECT, "disconnect");
    public static final FirmwareUpgradeError FIRMWARE_UPGRADE_FAILED_DRONE_BATTERY_LOW = new FirmwareUpgradeError(AutelErrorCode.FIRMWARE_UPGRADE_FAILED_DRONE_BATTERY_LOW, "drone battery low");
    public static final FirmwareUpgradeError FIRMWARE_UPGRADE_FAILED_MOTOR_NO_CLOSE = new FirmwareUpgradeError(AutelErrorCode.FIRMWARE_UPGRADE_FAILED_MOTOR_IS_ARMED, "motor not close");
    public static final FirmwareUpgradeError FIRMWARE_UPGRADE_FAILED_NO_SDCARD = new FirmwareUpgradeError(AutelErrorCode.FIRMWARE_UPGRADE_FAILED_NO_SDCARD, "no sdcard");
    public static final FirmwareUpgradeError FIRMWARE_UPGRADE_FAILED_REMOTE_BATTERY_LOW = new FirmwareUpgradeError(AutelErrorCode.FIRMWARE_UPGRADE_FAILED_RC_BATTERY_LOW, "remote battery low");
    public static final FirmwareUpgradeError FIRMWARE_UPGRADE_FAILED_SDCARD_ERROR = new FirmwareUpgradeError(AutelErrorCode.FIRMWARE_UPGRADE_FAILED_SDCARD_ERROR, "sdcard error");
    public static final FirmwareUpgradeError FIRMWARE_UPGRADE_FAILED_SDCARD_FULL = new FirmwareUpgradeError(AutelErrorCode.FIRMWARE_UPGRADE_FAILED_SDCARD_FULL, "sdcard full");
    public static final FirmwareUpgradeError FIRMWARE_UPGRADE_FAILED_SEND_FILE_FAIL = new FirmwareUpgradeError(AutelErrorCode.FIRMWARE_UPGRADE_FAILED_SEND_FILE, "send firmware file failed");
    public static final FirmwareUpgradeError FIRMWARE_UPGRADE_FAILED_UNKNOW_ERROR = new FirmwareUpgradeError(AutelErrorCode.FIRMWARE_UPGRADE_FAILED_UNKNOWN_ERROR, "unknown error");

    private FirmwareUpgradeError(AutelErrorCode autelErrorCode, String str) {
        super(autelErrorCode, str);
    }

    public String getDescription() {
        return super.getDescription();
    }

    public void setDescription(String str) {
        super.setDescription(str);
    }

    public AutelErrorCode getErrCode() {
        return super.getErrCode();
    }
}

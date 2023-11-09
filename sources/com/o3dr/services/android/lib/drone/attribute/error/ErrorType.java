package com.o3dr.services.android.lib.drone.attribute.error;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.o3dr.android.client.C5729R;

public enum ErrorType implements Parcelable {
    NO_ERROR(C5729R.string.error_no_error),
    ARM_THROTTLE_BELOW_FAILSAFE(C5729R.string.error_throttle_below_failsafe),
    ARM_GYRO_CALIBRATION_FAILED(C5729R.string.error_gyro_calibration_failed),
    ARM_MODE_NOT_ARMABLE(C5729R.string.error_mode_not_armable),
    ARM_ROTOR_NOT_SPINNING(C5729R.string.error_rotor_not_spinning),
    ARM_LEANING(C5729R.string.error_vehicle_leaning),
    ARM_THROTTLE_TOO_HIGH(C5729R.string.error_throttle_too_high),
    ARM_SAFETY_SWITCH(C5729R.string.error_safety_switch),
    ARM_COMPASS_CALIBRATION_RUNNING(C5729R.string.error_compass_calibration_running),
    PRE_ARM_RC_NOT_CALIBRATED(C5729R.string.error_rc_not_calibrated),
    PRE_ARM_BAROMETER_NOT_HEALTHY(C5729R.string.error_barometer_not_healthy),
    PRE_ARM_COMPASS_NOT_HEALTHY(C5729R.string.error_compass_not_healthy),
    PRE_ARM_COMPASS_NOT_CALIBRATED(C5729R.string.error_compass_not_calibrated),
    PRE_ARM_COMPASS_OFFSETS_TOO_HIGH(C5729R.string.error_compass_offsets_too_high),
    PRE_ARM_CHECK_MAGNETIC_FIELD(C5729R.string.error_check_magnetic_field),
    PRE_ARM_INCONSISTENT_COMPASSES(C5729R.string.error_inconsistent_compass),
    PRE_ARM_CHECK_FENCE(C5729R.string.error_check_geo_fence),
    PRE_ARM_INS_NOT_CALIBRATED(C5729R.string.error_ins_not_calibrated),
    PRE_ARM_ACCELEROMETERS_NOT_HEALTHY(C5729R.string.error_accelerometers_not_healthy),
    PRE_ARM_INCONSISTENT_ACCELEROMETERS(C5729R.string.error_inconsistent_accelerometers),
    PRE_ARM_GYROS_NOT_HEALTHY(C5729R.string.error_gyros_not_healthy),
    PRE_ARM_INCONSISTENT_GYROS(C5729R.string.error_inconsistent_gyros),
    PRE_ARM_CHECK_BOARD_VOLTAGE(C5729R.string.error_check_board_voltage),
    PRE_ARM_DUPLICATE_AUX_SWITCH_OPTIONS(C5729R.string.error_duplicate_aux_switch_options),
    PRE_ARM_CHECK_FAILSAFE_THRESHOLD_VALUE(C5729R.string.error_check_failsafe_threshold),
    PRE_ARM_CHECK_ANGLE_MAX(C5729R.string.error_check_angle_max),
    PRE_ARM_ACRO_BAL_ROLL_PITCH(C5729R.string.error_acro_bal_roll_pitch),
    PRE_ARM_NEED_GPS_LOCK(C5729R.string.error_need_gps_lock),
    PRE_ARM_EKF_HOME_VARIANCE(C5729R.string.error_ekf_home_variance),
    PRE_ARM_HIGH_GPS_HDOP(C5729R.string.error_high_gps_hdop),
    PRE_ARM_GPS_GLITCH(C5729R.string.error_gps_glitch),
    WAITING_FOR_NAVIGATION_ALIGNMENT(C5729R.string.error_waiting_for_navigation_alignment),
    ALTITUDE_DISPARITY(C5729R.string.error_altitude_disparity),
    LOW_BATTERY(C5729R.string.error_low_battery),
    AUTO_TUNE_FAILED(C5729R.string.error_auto_tune_failed),
    CRASH_DISARMING(C5729R.string.error_crash),
    PARACHUTE_TOO_LOW(C5729R.string.error_parachute_too_low),
    EKF_VARIANCE(C5729R.string.error_ekf_variance),
    NO_DATAFLASH_INSERTED(C5729R.string.error_no_dataflash),
    RC_FAILSAFE(C5729R.string.error_rc_failsafe);
    
    public static final Parcelable.Creator<ErrorType> CREATOR = null;
    private final int labelResId;

    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new Parcelable.Creator<ErrorType>() {
            public ErrorType createFromParcel(Parcel parcel) {
                return ErrorType.valueOf(parcel.readString());
            }

            public ErrorType[] newArray(int i) {
                return new ErrorType[i];
            }
        };
    }

    private ErrorType(int i) {
        this.labelResId = i;
    }

    public CharSequence getLabel(Context context) {
        if (context == null) {
            return null;
        }
        return context.getText(this.labelResId);
    }

    public static ErrorType getErrorById(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return valueOf(str);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name());
    }
}

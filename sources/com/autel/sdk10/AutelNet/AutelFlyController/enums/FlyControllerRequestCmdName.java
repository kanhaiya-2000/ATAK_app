package com.autel.sdk10.AutelNet.AutelFlyController.enums;

public final class FlyControllerRequestCmdName {
    public static final String AscendSpeed = "SM_Max_v_z";
    public static final String AttiModeSwitch = "SM_EN_ATT_MODE";
    public static final String DescendSpeed = "SM_Min_v_z";
    public static final String FreshManMode = "SM_Beginner_Mode";
    public static final String HorizontalSpeed = "SM_Max_v_xy";
    public static final String MaxHeight = "SM_Max_Height";
    public static final String MaxRange = "SM_Max_Range";
    public static final String RC_YAW_SEN = "RC_YAW_SEN";
    public static final String ReturnHeight = "SM_RTH_Height";
    public static final String SDLogFrequency = "SM_SDLOG_SEN";
    public static final String SN_DISABLE = "SN_DISABLE";
    public static final String SN_SAVED = "SN_SAVED";

    private FlyControllerRequestCmdName() {
    }

    public static boolean isFlyControllerRequestCmdName(String str) {
        return str.equals("SM_Max_Height") || str.equals("SM_Max_Range") || str.equals("SM_RTH_Height") || str.equals("SM_Max_v_xy") || str.equals("SM_Max_v_z") || str.equals("SM_Min_v_z") || str.equals("SM_Beginner_Mode") || str.equals("SM_SDLOG_SEN") || str.equals("SM_EN_ATT_MODE") || str.equals(SN_DISABLE) || str.equals(SN_SAVED) || RC_YAW_SEN.equals(str);
    }
}

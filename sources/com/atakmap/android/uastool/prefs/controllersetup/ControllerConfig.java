package com.atakmap.android.uastool.prefs.controllersetup;

public class ControllerConfig {
    public static final ControllerConfig defaultConfig = new ControllerConfig("DEFAULT");
    public String deviceName;
    public float leftStickXLeft;
    public float leftStickXRight;
    public float leftStickYDown;
    public float leftStickYUp;
    public int leftTriggerAxis;
    public boolean leftTriggerInverted;
    public float leftTriggerMax;
    public float leftTriggerMin;
    public int leftXAxis;
    public boolean leftXInverted;
    public int leftYAxis;
    public boolean leftYInverted;
    private transient float maxLeftTrigger = Float.NaN;
    private transient float maxLeftXValue = Float.NaN;
    private transient float maxLeftYValue = Float.NaN;
    private transient float maxRightTrigger = Float.NaN;
    private transient float maxRightXValue = Float.NaN;
    private transient float maxRightYValue = Float.NaN;
    public float rightStickXLeft;
    public float rightStickXRight;
    public float rightStickYDown;
    public float rightStickYUp;
    public int rightTriggerAxis;
    public boolean rightTriggerInverted;
    public float rightTriggerMax;
    public float rightTriggerMin;
    public int rightXAxis;
    public boolean rightXInverted;
    public int rightYAxis;
    public boolean rightYInverted;

    public ControllerConfig() {
        reset();
        this.deviceName = "";
    }

    public ControllerConfig(String str) {
        reset();
        this.deviceName = str;
    }

    public void reset() {
        this.deviceName = "";
        this.rightYAxis = 14;
        this.rightXAxis = 11;
        this.leftYAxis = 1;
        this.leftXAxis = 0;
        this.leftStickYDown = 1.0f;
        this.leftStickYUp = -1.0f;
        this.leftStickXLeft = -1.0f;
        this.leftStickXRight = 1.0f;
        this.rightStickXLeft = -1.0f;
        this.rightStickXRight = 1.0f;
        this.rightStickYDown = 1.0f;
        this.rightStickYUp = -1.0f;
        this.leftTriggerMax = 1.0f;
        this.leftTriggerMin = 0.0f;
        this.rightTriggerMax = 1.0f;
        this.rightTriggerMin = 0.0f;
        this.leftXInverted = false;
        this.rightXInverted = false;
        this.leftYInverted = false;
        this.rightYInverted = false;
        this.leftTriggerAxis = 23;
        this.rightTriggerAxis = 22;
        this.leftTriggerInverted = false;
        this.rightTriggerInverted = false;
    }

    public ControllerConfig makeDeepCopy() {
        ControllerConfig controllerConfig = new ControllerConfig();
        controllerConfig.rightYAxis = this.rightYAxis;
        controllerConfig.rightXAxis = this.rightXAxis;
        controllerConfig.leftXAxis = this.leftXAxis;
        controllerConfig.leftYAxis = this.leftYAxis;
        controllerConfig.rightTriggerAxis = this.rightTriggerAxis;
        controllerConfig.leftTriggerAxis = this.leftTriggerAxis;
        controllerConfig.rightTriggerMax = this.rightTriggerMax;
        controllerConfig.rightTriggerMin = this.rightTriggerMin;
        controllerConfig.leftTriggerMax = this.leftTriggerMax;
        controllerConfig.leftTriggerMin = this.leftTriggerMin;
        controllerConfig.leftTriggerInverted = this.leftTriggerInverted;
        controllerConfig.rightTriggerInverted = this.rightTriggerInverted;
        controllerConfig.rightYInverted = this.rightYInverted;
        controllerConfig.rightXInverted = this.rightXInverted;
        controllerConfig.rightStickYUp = this.rightStickYUp;
        controllerConfig.rightStickYDown = this.rightStickYDown;
        controllerConfig.rightStickXRight = this.rightStickXRight;
        controllerConfig.rightStickXLeft = this.rightStickXLeft;
        controllerConfig.leftYInverted = this.leftYInverted;
        controllerConfig.leftXInverted = this.leftXInverted;
        controllerConfig.leftStickXRight = this.leftStickXRight;
        controllerConfig.leftStickXLeft = this.leftStickXLeft;
        controllerConfig.leftStickYDown = this.leftStickYDown;
        controllerConfig.leftStickYUp = this.leftStickYUp;
        controllerConfig.deviceName = this.deviceName;
        return controllerConfig;
    }

    public boolean isValid() {
        return !Float.isInfinite(this.leftStickXLeft) && !Float.isNaN(this.leftStickXLeft) && !Float.isInfinite(this.leftStickXRight) && !Float.isNaN(this.leftStickXRight) && !Float.isInfinite(this.leftStickYDown) && !Float.isNaN(this.leftStickYDown) && !Float.isInfinite(this.leftStickYUp) && !Float.isNaN(this.leftStickYUp) && !Float.isInfinite(this.rightStickXLeft) && !Float.isNaN(this.rightStickXLeft) && !Float.isInfinite(this.rightStickXRight) && !Float.isNaN(this.rightStickXRight) && !Float.isInfinite(this.rightStickYDown) && !Float.isNaN(this.rightStickYDown) && !Float.isInfinite(this.rightStickYUp) && !Float.isNaN(this.rightStickYUp) && !Float.isInfinite(this.leftTriggerMax) && !Float.isNaN(this.leftTriggerMax) && !Float.isInfinite(this.leftTriggerMin) && !Float.isNaN(this.leftTriggerMin) && !Float.isInfinite(this.rightTriggerMax) && !Float.isNaN(this.rightTriggerMin);
    }

    public float maxLeftXValue() {
        if (Float.isNaN(this.maxLeftXValue)) {
            this.maxLeftXValue = ((Math.abs(this.leftStickXLeft) + Math.abs(this.leftStickXRight)) / 2.0f) * ((float) (this.leftXInverted ? -1 : 1));
        }
        return this.maxLeftXValue;
    }

    public float maxLeftTriggerValue() {
        if (Float.isNaN(this.maxLeftTrigger)) {
            this.maxLeftTrigger = Math.max(Math.abs(this.leftTriggerMin), Math.abs(this.leftTriggerMax)) * ((float) (this.leftTriggerInverted ? -1 : 1));
        }
        return this.maxLeftTrigger;
    }

    public float maxRightTriggerValue() {
        if (Float.isNaN(this.maxRightTrigger)) {
            this.maxRightTrigger = Math.max(Math.abs(this.rightTriggerMin), Math.abs(this.rightTriggerMax)) * ((float) (this.rightTriggerInverted ? -1 : 1));
        }
        return this.maxRightTrigger;
    }

    public float maxLeftYValue() {
        if (Float.isNaN(this.maxLeftYValue)) {
            this.maxLeftYValue = ((Math.abs(this.leftStickYUp) + Math.abs(this.leftStickYDown)) / 2.0f) * ((float) (this.leftYInverted ? -1 : 1));
        }
        return this.maxLeftYValue;
    }

    public float maxRightXValue() {
        if (Float.isNaN(this.maxRightXValue)) {
            this.maxRightXValue = ((Math.abs(this.rightStickXLeft) + Math.abs(this.rightStickXRight)) / 2.0f) * ((float) (this.rightXInverted ? -1 : 1));
        }
        return this.maxRightXValue;
    }

    public float maxRightYValue() {
        if (Float.isNaN(this.maxRightYValue)) {
            this.maxRightYValue = ((Math.abs(this.rightStickYDown) + Math.abs(this.rightStickYUp)) / 2.0f) * ((float) (this.rightYInverted ? -1 : 1));
        }
        return this.maxRightYValue;
    }
}

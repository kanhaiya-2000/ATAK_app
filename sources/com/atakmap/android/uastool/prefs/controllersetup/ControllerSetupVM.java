package com.atakmap.android.uastool.prefs.controllersetup;

import android.view.MotionEvent;

public class ControllerSetupVM {
    public static final int CALIB_FINISHED = 13;
    public static final int CALIB_STEP_CENTER = 0;
    public static final int CALIB_STEP_LEFT_TRIGGER_DOWN = 9;
    public static final int CALIB_STEP_LEFT_TRIGGER_UP = 10;
    public static final int CALIB_STEP_LEFT_X_LEFT = 4;
    public static final int CALIB_STEP_LEFT_X_RIGHT = 3;
    public static final int CALIB_STEP_LEFT_Y_DOWN = 2;
    public static final int CALIB_STEP_LEFT_Y_UP = 1;
    public static final int CALIB_STEP_RIGHT_TRIGGER_DOWN = 11;
    public static final int CALIB_STEP_RIGHT_TRIGGER_UP = 12;
    public static final int CALIB_STEP_RIGHT_X_LEFT = 6;
    public static final int CALIB_STEP_RIGHT_X_RIGHT = 5;
    public static final int CALIB_STEP_RIGHT_Y_DOWN = 8;
    public static final int CALIB_STEP_RIGHT_Y_UP = 7;
    public static final float INPUT_THRESHOLD = 0.6f;
    public static final int MAX_CALIBRATION_STEPS = 13;
    private static final ControllerSetupVM controllerSetupVM = new ControllerSetupVM();
    private int calibrationStep = 0;
    private final ControllerConfig controller = new ControllerConfig();
    private MotionEvent lastEvent = null;

    private ControllerSetupVM() {
    }

    public static ControllerSetupVM getInstance() {
        return controllerSetupVM;
    }

    public MotionEvent getLastEvent() {
        return this.lastEvent;
    }

    private void processControllerMotion(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 16777232) == 16777232 && motionEvent.getAction() == 2) {
            this.controller.deviceName = motionEvent.getDevice().getName();
            if (this.controller.deviceName == null || this.controller.deviceName.isEmpty()) {
                this.controller.deviceName = "PARROT_ANAFI_MPP3";
            }
            int axis = getAxis(motionEvent);
            switch (this.calibrationStep) {
                case 1:
                    this.controller.leftStickYUp = motionEvent.getAxisValue(axis);
                    this.controller.leftYAxis = axis;
                    if (this.controller.leftStickYUp > 0.0f) {
                        this.controller.leftYInverted = true;
                        return;
                    }
                    return;
                case 2:
                    this.controller.leftStickYDown = motionEvent.getAxisValue(axis);
                    return;
                case 3:
                    this.controller.leftXAxis = axis;
                    this.controller.leftStickXRight = motionEvent.getAxisValue(axis);
                    if (this.controller.leftStickXRight < 0.0f) {
                        this.controller.leftXInverted = true;
                        return;
                    }
                    return;
                case 4:
                    this.controller.leftStickXLeft = motionEvent.getAxisValue(axis);
                    return;
                case 5:
                    this.controller.rightXAxis = axis;
                    this.controller.rightStickXRight = motionEvent.getAxisValue(axis);
                    if (this.controller.rightStickXRight < 0.0f) {
                        this.controller.rightXInverted = true;
                        return;
                    }
                    return;
                case 6:
                    this.controller.rightStickXLeft = motionEvent.getAxisValue(axis);
                    return;
                case 7:
                    this.controller.rightYAxis = axis;
                    this.controller.rightStickYUp = motionEvent.getAxisValue(axis);
                    if (this.controller.rightStickYUp > 0.0f) {
                        this.controller.rightYInverted = true;
                        return;
                    }
                    return;
                case 8:
                    this.controller.rightStickYDown = motionEvent.getAxisValue(axis);
                    return;
                case 9:
                    this.controller.leftTriggerAxis = axis;
                    this.controller.leftTriggerMax = motionEvent.getAxisValue(axis);
                    if (this.controller.leftTriggerMax < 0.0f) {
                        this.controller.leftTriggerInverted = true;
                        return;
                    }
                    return;
                case 10:
                    this.controller.leftTriggerAxis = axis;
                    this.controller.leftTriggerMin = motionEvent.getAxisValue(axis);
                    return;
                case 11:
                    this.controller.rightTriggerAxis = axis;
                    this.controller.rightTriggerMax = motionEvent.getAxisValue(axis);
                    if (this.controller.rightTriggerMax < 0.0f) {
                        this.controller.rightTriggerInverted = true;
                        return;
                    }
                    return;
                case 12:
                    this.controller.rightTriggerAxis = axis;
                    this.controller.rightTriggerMin = motionEvent.getAxisValue(axis);
                    return;
                default:
                    return;
            }
        }
    }

    public void startCalibration() {
        this.calibrationStep = 0;
    }

    public int getAxis(MotionEvent motionEvent) {
        float f = 0.0f;
        int i = -1;
        for (int i2 = 0; i2 <= 47; i2++) {
            float axisValue = motionEvent.getAxisValue(i2);
            if (Math.abs(axisValue) >= Math.abs(f)) {
                i = i2;
                f = axisValue;
            }
        }
        return i;
    }

    public void processControllerMotion() {
        MotionEvent motionEvent = this.lastEvent;
        if (motionEvent != null) {
            processControllerMotion(motionEvent);
        }
    }

    public void nextStep() {
        int i = this.calibrationStep;
        if (i < 13) {
            this.calibrationStep = i + 1;
        }
    }

    public boolean writeConfiguration() {
        boolean writeControllerConfig;
        synchronized (this.controller) {
            if (this.controller.deviceName == null || this.controller.deviceName.isEmpty()) {
                this.controller.deviceName = "default";
            }
            ControllerConfigStore instance = ControllerConfigStore.getInstance();
            ControllerConfig controllerConfig = this.controller;
            writeControllerConfig = instance.writeControllerConfig(controllerConfig, controllerConfig.deviceName);
        }
        return writeControllerConfig;
    }

    public void updateMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 16777232) == 16777232 && motionEvent.getAction() == 2) {
            this.lastEvent = motionEvent;
        }
    }

    public String getControllerDeviceName() {
        return this.controller.deviceName;
    }

    public void reset() {
        this.calibrationStep = 0;
        this.lastEvent = null;
    }

    public void resetControllerData() {
        this.controller.reset();
    }

    public int getCalibrationStep() {
        return this.calibrationStep;
    }

    public boolean finishedCalibrating() {
        return this.calibrationStep >= 13;
    }
}

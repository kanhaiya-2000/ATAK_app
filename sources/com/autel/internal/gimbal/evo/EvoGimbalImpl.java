package com.autel.internal.gimbal.evo;

import com.autel.AutelNet2.aircraft.gimbal.controller.GimbalManager2;
import com.autel.AutelNet2.aircraft.gimbal.engine.GimbalAngle;
import com.autel.AutelNet2.aircraft.gimbal.engine.GimbalAngleRangeImpl;
import com.autel.AutelNet2.aircraft.gimbal.engine.GimbalCmdInfo;
import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.RangePair;
import com.autel.common.error.AutelError;
import com.autel.common.gimbal.GimbalAdjustmentAngle;
import com.autel.common.gimbal.GimbalAxisType;
import com.autel.common.gimbal.GimbalRollAngleAdjust;
import com.autel.common.gimbal.GimbalWorkMode;
import com.autel.common.gimbal.evo.EvoAngleInfo;
import com.autel.common.gimbal.evo.EvoGimbalParameterRangeManager;
import com.autel.common.gimbal.evo.GimbalAngleData;
import com.autel.common.gimbal.evo.GimbalAngleRange;
import com.autel.common.gimbal.evo.GimbalAngleSpeed;
import com.autel.internal.gimbal.Gimbal20;
import com.autel.sdk.gimbal.p008rx.RxEvoGimbal;

public class EvoGimbalImpl extends Gimbal20 implements EvoGimbalService {
    private static final String GimbalAngleListenerTag = "GimbalAngleListenerTag";
    private EvoGimbalParameterRangeManager rangeManager;

    public RxEvoGimbal toRx() {
        return null;
    }

    public void setAngleListener(final CallbackWithOneParam<EvoAngleInfo> callbackWithOneParam) {
        if (callbackWithOneParam == null) {
            GimbalManager2.getInstance().removeGimbalAngleListener(GimbalAngleListenerTag);
        } else {
            GimbalManager2.getInstance().addGimbalAngleListener(GimbalAngleListenerTag, new CallbackWithOneParam<GimbalAngle>() {
                public void onSuccess(GimbalAngle gimbalAngle) {
                    callbackWithOneParam.onSuccess(gimbalAngle);
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        }
    }

    public void setGimbalAngleWithSpeed(float f) {
        GimbalAngleSpeed gimbalAngleSpeed = new GimbalAngleSpeed();
        gimbalAngleSpeed.setPitchSpeed(f);
        GimbalManager2.getInstance().setGimbalAngleSpeed(gimbalAngleSpeed);
    }

    public void setGimbalAngle(float f, float f2, float f3) {
        GimbalAngleData gimbalAngleData = new GimbalAngleData();
        gimbalAngleData.setPitch(f);
        gimbalAngleData.setRoll(f3);
        gimbalAngleData.setYaw(f2);
        GimbalManager2.getInstance().setGimbalAngle(gimbalAngleData);
    }

    public EvoGimbalParameterRangeManager getParameterRangeManager() {
        if (this.rangeManager == null) {
            this.rangeManager = new EvoGimbalParameterRangeManager() {
                public void getAngleRange(final CallbackWithOneParam<GimbalAngleRange> callbackWithOneParam) {
                    if (callbackWithOneParam != null) {
                        GimbalManager2.getInstance().queryGimbalAngleRange(new CallbackWithOneParam<GimbalAngleRangeImpl>() {
                            public void onSuccess(GimbalAngleRangeImpl gimbalAngleRangeImpl) {
                                callbackWithOneParam.onSuccess(gimbalAngleRangeImpl);
                            }

                            public void onFailure(AutelError autelError) {
                                callbackWithOneParam.onFailure(autelError);
                            }
                        });
                    }
                }

                public RangePair<Integer> getAngleSpeedRange() {
                    return new RangePair<Integer>() {
                        public Integer getValueFrom() {
                            return 0;
                        }

                        public Integer getValueTo() {
                            return 90;
                        }
                    };
                }

                public GimbalWorkMode[] getWorkMode() {
                    return new GimbalWorkMode[]{GimbalWorkMode.FPV, GimbalWorkMode.STABILIZED};
                }

                public GimbalRollAngleAdjust[] getRollAngleAdjust() {
                    return new GimbalRollAngleAdjust[]{GimbalRollAngleAdjust.MINUS, GimbalRollAngleAdjust.PLUS};
                }
            };
        }
        return this.rangeManager;
    }

    public void resetGimbalAngle(GimbalAxisType gimbalAxisType, final CallbackWithNoParam callbackWithNoParam) {
        GimbalManager2.getInstance().resetGimbalAngle(gimbalAxisType, new CallbackWithOneParam<GimbalCmdInfo>() {
            public void onSuccess(GimbalCmdInfo gimbalCmdInfo) {
                CallbackWithNoParam callbackWithNoParam;
                if (gimbalCmdInfo.getData()[0] == 0 && (callbackWithNoParam = callbackWithNoParam) != null) {
                    callbackWithNoParam.onSuccess();
                }
            }

            public void onFailure(AutelError autelError) {
                CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                if (callbackWithNoParam != null) {
                    callbackWithNoParam.onFailure(autelError);
                }
            }
        });
    }

    public void setRollAdjustData(float f, final CallbackWithNoParam callbackWithNoParam) {
        GimbalManager2.getInstance().setRollAdjustData((int) (f * 100.0f), new CallbackWithOneParam<GimbalCmdInfo>() {
            public void onSuccess(GimbalCmdInfo gimbalCmdInfo) {
                if (callbackWithNoParam == null) {
                    return;
                }
                if (gimbalCmdInfo.getData()[0] == 0) {
                    callbackWithNoParam.onSuccess();
                } else {
                    callbackWithNoParam.onFailure(AutelError.COMMAND_FAILED);
                }
            }

            public void onFailure(AutelError autelError) {
                CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                if (callbackWithNoParam != null) {
                    callbackWithNoParam.onFailure(autelError);
                }
            }
        });
    }

    public void getRollAdjustData(final CallbackWithOneParam<Double> callbackWithOneParam) {
        GimbalManager2.getInstance().getRollAdjustData(new CallbackWithOneParam<GimbalCmdInfo>() {
            public void onSuccess(GimbalCmdInfo gimbalCmdInfo) {
                CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                if (callbackWithOneParam != null) {
                    callbackWithOneParam.onSuccess(Double.valueOf((double) (((float) gimbalCmdInfo.getData()[0]) / 100.0f)));
                }
            }

            public void onFailure(AutelError autelError) {
                CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                if (callbackWithOneParam != null) {
                    callbackWithOneParam.onFailure(autelError);
                }
            }
        });
    }

    public void getAdjustGimbalAngelData(final CallbackWithOneParam<GimbalAdjustmentAngle> callbackWithOneParam) {
        GimbalManager2.getInstance().getRollAdjustData(new CallbackWithOneParam<GimbalCmdInfo>() {
            public void onSuccess(final GimbalCmdInfo gimbalCmdInfo) {
                CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                if (callbackWithOneParam != null) {
                    callbackWithOneParam.onSuccess(new GimbalAdjustmentAngle() {
                        public float getPitch() {
                            return ((float) gimbalCmdInfo.getData()[1]) / 100.0f;
                        }

                        public float getRoll() {
                            return ((float) gimbalCmdInfo.getData()[0]) / 100.0f;
                        }

                        public float getYaw() {
                            return ((float) gimbalCmdInfo.getData()[2]) / 100.0f;
                        }
                    });
                }
            }

            public void onFailure(AutelError autelError) {
                CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                if (callbackWithOneParam != null) {
                    callbackWithOneParam.onFailure(autelError);
                }
            }
        });
    }

    public void setYawAdjustData(float f, final CallbackWithNoParam callbackWithNoParam) {
        GimbalManager2.getInstance().setYawAdjustData((int) (f * 100.0f), new CallbackWithOneParam<GimbalCmdInfo>() {
            public void onSuccess(GimbalCmdInfo gimbalCmdInfo) {
                if (callbackWithNoParam == null) {
                    return;
                }
                if (gimbalCmdInfo.getData()[0] == 0) {
                    callbackWithNoParam.onSuccess();
                } else {
                    callbackWithNoParam.onFailure(AutelError.COMMAND_FAILED);
                }
            }

            public void onFailure(AutelError autelError) {
                CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                if (callbackWithNoParam != null) {
                    callbackWithNoParam.onFailure(autelError);
                }
            }
        });
    }

    public void getYawAdjustData(final CallbackWithOneParam<Double> callbackWithOneParam) {
        GimbalManager2.getInstance().getYawAdjustData(new CallbackWithOneParam<GimbalCmdInfo>() {
            public void onSuccess(GimbalCmdInfo gimbalCmdInfo) {
                CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                if (callbackWithOneParam != null) {
                    callbackWithOneParam.onSuccess(Double.valueOf((double) (((float) gimbalCmdInfo.getData()[2]) / 100.0f)));
                }
            }

            public void onFailure(AutelError autelError) {
                CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                if (callbackWithOneParam != null) {
                    callbackWithOneParam.onFailure(autelError);
                }
            }
        });
    }

    public void setPitchAdjustData(float f, final CallbackWithNoParam callbackWithNoParam) {
        GimbalManager2.getInstance().setPitchAdjustData((int) (f * 100.0f), new CallbackWithOneParam<GimbalCmdInfo>() {
            public void onSuccess(GimbalCmdInfo gimbalCmdInfo) {
                if (callbackWithNoParam == null) {
                    return;
                }
                if (gimbalCmdInfo.getData()[0] == 0) {
                    callbackWithNoParam.onSuccess();
                } else {
                    callbackWithNoParam.onFailure(AutelError.COMMAND_FAILED);
                }
            }

            public void onFailure(AutelError autelError) {
                CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                if (callbackWithNoParam != null) {
                    callbackWithNoParam.onFailure(autelError);
                }
            }
        });
    }

    public void getPitchAdjustData(final CallbackWithOneParam<Double> callbackWithOneParam) {
        GimbalManager2.getInstance().getPitchAdjustData(new CallbackWithOneParam<GimbalCmdInfo>() {
            public void onSuccess(GimbalCmdInfo gimbalCmdInfo) {
                CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                if (callbackWithOneParam != null) {
                    callbackWithOneParam.onSuccess(Double.valueOf((double) (((float) gimbalCmdInfo.getData()[1]) / 100.0f)));
                }
            }

            public void onFailure(AutelError autelError) {
                CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                if (callbackWithOneParam != null) {
                    callbackWithOneParam.onFailure(autelError);
                }
            }
        });
    }

    public void setSaveParams(final CallbackWithNoParam callbackWithNoParam) {
        GimbalManager2.getInstance().setSaveParams(new CallbackWithOneParam<GimbalCmdInfo>() {
            public void onSuccess(GimbalCmdInfo gimbalCmdInfo) {
                if (callbackWithNoParam == null) {
                    return;
                }
                if (gimbalCmdInfo.getData()[0] == 0) {
                    callbackWithNoParam.onSuccess();
                } else {
                    callbackWithNoParam.onFailure(AutelError.COMMAND_FAILED);
                }
            }

            public void onFailure(AutelError autelError) {
                CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                if (callbackWithNoParam != null) {
                    callbackWithNoParam.onFailure(autelError);
                }
            }
        });
    }

    public void setGimbalCalibration(final CallbackWithNoParam callbackWithNoParam) {
        GimbalManager2.getInstance().setGimbalCalibration(new CallbackWithOneParam<GimbalCmdInfo>() {
            public void onSuccess(GimbalCmdInfo gimbalCmdInfo) {
                if (callbackWithNoParam == null) {
                    return;
                }
                if (gimbalCmdInfo.getData()[0] == 0) {
                    callbackWithNoParam.onSuccess();
                } else {
                    callbackWithNoParam.onFailure(AutelError.COMMAND_FAILED);
                }
            }

            public void onFailure(AutelError autelError) {
                CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                if (callbackWithNoParam != null) {
                    callbackWithNoParam.onFailure(autelError);
                }
            }
        });
    }
}

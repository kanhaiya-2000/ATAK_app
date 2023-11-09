package com.autel.internal.gimbal.xstar;

import com.autel.common.CallbackWithOneParam;
import com.autel.common.RangePair;
import com.autel.common.error.AutelError;
import com.autel.common.gimbal.GimbalRollAngleAdjust;
import com.autel.common.gimbal.GimbalState;
import com.autel.common.gimbal.GimbalWorkMode;
import com.autel.common.gimbal.xstar.XStarGimbalParameterRangeManager;
import com.autel.internal.gimbal.Gimbal10;
import com.autel.internal.sdk.flycontroller.AutelWarningInternal;
import com.autel.sdk.gimbal.p008rx.RxXStarGimbal;
import com.autel.sdk10.AutelNet.AutelFlyController.interfaces.IAutelFlyControllerInterfaces;
import com.autel.sdk10.AutelNet.AutelFlyController.parser.ErrorWarningInternalParser;
import com.autel.sdk10.AutelNet.AutelGimbal.GimbalManager;
import com.autel.sdk10.AutelNet.AutelRemoteController.interfaces.IAutelRCLongTimeCallback;
import com.autel.sdk10.interfaces.AutelCompletionCallback;

public class XStarGimbalImpl extends Gimbal10 implements XStarGimbalService {
    private XStarGimbalParameterRangeManager rangeManager;

    public RxXStarGimbal toRx() {
        return null;
    }

    public void setAngleListener(final CallbackWithOneParam<Integer> callbackWithOneParam) {
        if (callbackWithOneParam == null) {
            GimbalManager.getAutelGimbalRequestManager().removeQueryGimbalAngleCallback("gimbalAngleListener");
        } else {
            GimbalManager.getAutelGimbalRequestManager().addQueryGimbalAngleCallback("gimbalAngleListener", new IAutelRCLongTimeCallback.IAutelRCLongTimeCallbackWith<Integer>() {
                public void onReceiveMsg(Integer num) {
                    CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                    if (callbackWithOneParam != null) {
                        callbackWithOneParam.onSuccess(num);
                    }
                }
            });
        }
    }

    public void setGimbalStateListener(final CallbackWithOneParam<GimbalState> callbackWithOneParam) {
        if (callbackWithOneParam == null) {
            ErrorWarningInternalParser.getInstance().removeIFlyControllerErrorWarningListener("gimbalStateListener");
            return;
        }
        this.currentGimbalState = GimbalState.UNKNOWN;
        ErrorWarningInternalParser.getInstance().addIFlyControllerErrorWarningListener("gimbalStateListener", new IAutelFlyControllerInterfaces.IFlyControllerErrorWarningListener() {
            public void onErrorWarning(AutelWarningInternal autelWarningInternal) {
                if (XStarGimbalImpl.this.currentGimbalState != autelWarningInternal.getGimbalErrorCode()) {
                    GimbalState unused = XStarGimbalImpl.this.currentGimbalState = autelWarningInternal.getGimbalErrorCode();
                    callbackWithOneParam.onSuccess(autelWarningInternal.getGimbalErrorCode());
                }
            }
        });
    }

    public void setGimbalAngleWithSpeed(int i) {
        RangePair<Integer> angleWithSpeed = getParameterRangeManager().getAngleWithSpeed();
        if (i >= angleWithSpeed.getValueFrom().intValue() && i <= angleWithSpeed.getValueTo().intValue()) {
            GimbalManager.getAutelGimbalRequestManager().setGimbalAngle((float) (-i));
        }
    }

    public XStarGimbalParameterRangeManager getParameterRangeManager() {
        if (this.rangeManager == null) {
            this.rangeManager = new XStarGimbalParameterRangeManager() {
                public RangePair<Integer> getAngleWithSpeed() {
                    return new RangePair<Integer>() {
                        public Integer getValueFrom() {
                            return -100;
                        }

                        public Integer getValueTo() {
                            return 100;
                        }
                    };
                }

                public RangePair<Integer> getAngle() {
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
                    return new GimbalWorkMode[]{GimbalWorkMode.STABILIZED, GimbalWorkMode.FPV};
                }

                public GimbalRollAngleAdjust[] getRollAngleAdjust() {
                    return new GimbalRollAngleAdjust[]{GimbalRollAngleAdjust.PLUS, GimbalRollAngleAdjust.MINUS, GimbalRollAngleAdjust.QUERY, GimbalRollAngleAdjust.RESET};
                }
            };
        }
        return this.rangeManager;
    }

    public void setGimbalAngle(float f) {
        RangePair<Integer> angle = getParameterRangeManager().getAngle();
        if (f >= ((float) angle.getValueFrom().intValue()) && f <= ((float) angle.getValueTo().intValue())) {
            GimbalManager.getAutelGimbalRequestManager().setGimbalAngle(f + 110.0f);
        }
    }

    public void setRollAdjustData(GimbalRollAngleAdjust gimbalRollAngleAdjust, final CallbackWithOneParam<Double> callbackWithOneParam) {
        GimbalManager.getAutelGimbalRequestManager().setRollAdjustData(gimbalRollAngleAdjust, (AutelCompletionCallback.ICompletionCallbackWith<Double>) null);
        GimbalManager.getAutelGimbalRequestManager().setRollAdjustData(GimbalRollAngleAdjust.QUERY, new AutelCompletionCallback.ICompletionCallbackWith<Double>() {
            public void onResult(Double d) {
                CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                if (callbackWithOneParam != null) {
                    callbackWithOneParam.onSuccess(d);
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
}

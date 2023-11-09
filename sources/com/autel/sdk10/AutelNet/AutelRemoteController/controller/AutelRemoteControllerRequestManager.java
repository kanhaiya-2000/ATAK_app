package com.autel.sdk10.AutelNet.AutelRemoteController.controller;

import com.autel.common.error.AutelError;
import com.autel.common.remotecontroller.RFPower;
import com.autel.common.remotecontroller.RemoteControllerCommandStickMode;
import com.autel.common.remotecontroller.RemoteControllerLanguage;
import com.autel.common.remotecontroller.RemoteControllerParameterUnit;
import com.autel.common.remotecontroller.RemoteControllerStickCalibration;
import com.autel.common.remotecontroller.TeachingMode;
import com.autel.internal.sdk.product.datapost.MsgPostManager;
import com.autel.internal.sdk.product.datapost.PostRunnable;
import com.autel.sdk10.AutelNet.AutelRemoteController.engine.RCCommandMessage;
import com.autel.sdk10.AutelNet.AutelRemoteController.parser.RCRespondMsgParser;
import com.autel.sdk10.interfaces.AutelCompletionCallback;
import com.autel.sdk10.products.aircraft.AutelAircraftInfoManager;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AutelRemoteControllerRequestManager extends AutelRemoteControllerLongTimeRequestManager {
    protected ConcurrentHashMap<Integer, AutelCompletionCallback.ICompletionCallbackWith> callbacks = new ConcurrentHashMap<>();

    /* access modifiers changed from: protected */
    public abstract void setICompletionCallbackWith(RCCommandMessage rCCommandMessage, AutelCompletionCallback.ICompletionCallbackWith iCompletionCallbackWith);

    private void checkValueValid(AutelCompletionCallback.ICompletionCallbackWith iCompletionCallbackWith) {
        if (iCompletionCallbackWith != null) {
            this.callbacks.put(Integer.valueOf(iCompletionCallbackWith.hashCode()), iCompletionCallbackWith);
        }
    }

    public void removeCallback(AutelCompletionCallback.ICompletionCallbackWith iCompletionCallbackWith) {
        if (iCompletionCallbackWith != null) {
            removeCallback(iCompletionCallbackWith.hashCode());
        }
    }

    private void removeCallback(int i) {
        this.callbacks.remove(Integer.valueOf(i));
    }

    private AutelCompletionCallback.ICompletionCallbackWith getCallback(AutelCompletionCallback.ICompletionCallbackWith iCompletionCallbackWith) {
        if (iCompletionCallbackWith == null) {
            return null;
        }
        return this.callbacks.get(Integer.valueOf(iCompletionCallbackWith.hashCode()));
    }

    public synchronized void remove1TimeCallbacksFromClass(Object obj) {
        String str;
        if (obj instanceof String) {
            str = (String) obj;
        } else {
            str = obj.getClass().getName();
        }
        for (Map.Entry<Integer, AutelCompletionCallback.ICompletionCallbackWith> key : this.callbacks.entrySet()) {
            Integer num = (Integer) key.getKey();
            AutelCompletionCallback.ICompletionCallbackWith iCompletionCallbackWith = this.callbacks.get(num);
            if (!(iCompletionCallbackWith == null || iCompletionCallbackWith.getClass() == null)) {
                String name = iCompletionCallbackWith.getClass().getName();
                if (name.startsWith(str + "$")) {
                    removeCallback(num.intValue());
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void callbackResult(final AutelCompletionCallback.ICompletionCallbackWith iCompletionCallbackWith, final Object obj) {
        MsgPostManager.instance().post(new PostRunnable() {
            /* access modifiers changed from: protected */
            public void task() {
                if (iCompletionCallbackWith != null && AutelRemoteControllerRequestManager.this.callbacks.get(Integer.valueOf(iCompletionCallbackWith.hashCode())) != null) {
                    AutelRemoteControllerRequestManager.this.callbacks.get(Integer.valueOf(iCompletionCallbackWith.hashCode())).onResult(obj);
                    AutelRemoteControllerRequestManager.this.removeCallback(iCompletionCallbackWith);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void callbackFailure(final AutelCompletionCallback.ICompletionCallbackWith iCompletionCallbackWith, final AutelError autelError) {
        MsgPostManager.instance().post(new PostRunnable() {
            /* access modifiers changed from: protected */
            public void task() {
                if (iCompletionCallbackWith != null && AutelRemoteControllerRequestManager.this.callbacks.get(Integer.valueOf(iCompletionCallbackWith.hashCode())) != null) {
                    AutelRemoteControllerRequestManager.this.callbacks.get(Integer.valueOf(iCompletionCallbackWith.hashCode())).onFailure(autelError);
                    AutelRemoteControllerRequestManager.this.removeCallback(iCompletionCallbackWith);
                }
            }
        });
    }

    /* renamed from: a */
    public void mo19500a(float f) {
        RCCommandMessage rCCommandMessage = new RCCommandMessage();
        rCCommandMessage.createSetGimbalAngleParams(f);
        setICompletionCallbackWith(rCCommandMessage, (AutelCompletionCallback.ICompletionCallbackWith) null);
    }

    public void setGimbalWheelAdjustSpeed(final int i, final AutelCompletionCallback.ICompletionCallbackWith<Boolean> iCompletionCallbackWith) {
        RCCommandMessage rCCommandMessage = new RCCommandMessage();
        rCCommandMessage.createSetGimbalAdjustSpeedParams(i);
        checkValueValid(iCompletionCallbackWith);
        setICompletionCallbackWith(rCCommandMessage, new AutelCompletionCallback.ICompletionCallbackWith<RCRespondMsgParser>() {
            public void onResult(RCRespondMsgParser rCRespondMsgParser) {
                boolean isGimbalAdjustSpeedSetSucc = rCRespondMsgParser.isGimbalAdjustSpeedSetSucc();
                if (isGimbalAdjustSpeedSetSucc) {
                    AutelAircraftInfoManager.getRemoteControllerInfo().setGimbalAdjustSpeed(i);
                }
                AutelRemoteControllerRequestManager.this.callbackResult(iCompletionCallbackWith, Boolean.valueOf(isGimbalAdjustSpeedSetSucc));
            }

            public void onFailure(AutelError autelError) {
                AutelRemoteControllerRequestManager.this.callbackFailure(iCompletionCallbackWith, autelError);
            }
        });
    }

    public void queryGimbalWheelAdjustSpeed(final AutelCompletionCallback.ICompletionCallbackWith<Integer> iCompletionCallbackWith) {
        RCCommandMessage rCCommandMessage = new RCCommandMessage();
        rCCommandMessage.createQueryGimbalAdjustSpeedParams();
        checkValueValid(iCompletionCallbackWith);
        setICompletionCallbackWith(rCCommandMessage, new AutelCompletionCallback.ICompletionCallbackWith<RCRespondMsgParser>() {
            public void onResult(RCRespondMsgParser rCRespondMsgParser) {
                int gimbalAdjustSpeed = rCRespondMsgParser.getGimbalAdjustSpeed();
                AutelAircraftInfoManager.getRemoteControllerInfo().setGimbalAdjustSpeed(gimbalAdjustSpeed);
                AutelRemoteControllerRequestManager.this.callbackResult(iCompletionCallbackWith, Integer.valueOf(gimbalAdjustSpeed));
            }

            public void onFailure(AutelError autelError) {
                AutelRemoteControllerRequestManager.this.callbackFailure(iCompletionCallbackWith, autelError);
            }
        });
    }

    public void setRCLanguage(final RemoteControllerLanguage remoteControllerLanguage, final AutelCompletionCallback.ICompletionCallbackWith<Boolean> iCompletionCallbackWith) {
        RCCommandMessage rCCommandMessage = new RCCommandMessage();
        rCCommandMessage.createSetRCLanguageParams(remoteControllerLanguage.getValue());
        checkValueValid(iCompletionCallbackWith);
        setICompletionCallbackWith(rCCommandMessage, new AutelCompletionCallback.ICompletionCallbackWith<RCRespondMsgParser>() {
            public void onResult(RCRespondMsgParser rCRespondMsgParser) {
                boolean isRCLanguageSetSucc = rCRespondMsgParser.isRCLanguageSetSucc();
                if (isRCLanguageSetSucc) {
                    AutelAircraftInfoManager.getRemoteControllerInfo().setRCLanguage(remoteControllerLanguage);
                }
                AutelRemoteControllerRequestManager.this.callbackResult(iCompletionCallbackWith, Boolean.valueOf(isRCLanguageSetSucc));
            }

            public void onFailure(AutelError autelError) {
                AutelRemoteControllerRequestManager.this.callbackFailure(iCompletionCallbackWith, autelError);
            }
        });
    }

    public void queryRCLanguage(final AutelCompletionCallback.ICompletionCallbackWith<RemoteControllerLanguage> iCompletionCallbackWith) {
        RCCommandMessage rCCommandMessage = new RCCommandMessage();
        rCCommandMessage.createQueryRCLanguageParams();
        checkValueValid(iCompletionCallbackWith);
        setICompletionCallbackWith(rCCommandMessage, new AutelCompletionCallback.ICompletionCallbackWith<RCRespondMsgParser>() {
            public void onResult(RCRespondMsgParser rCRespondMsgParser) {
                RemoteControllerLanguage rCLanguage = rCRespondMsgParser.getRCLanguage();
                AutelAircraftInfoManager.getRemoteControllerInfo().setRCLanguage(rCLanguage);
                AutelRemoteControllerRequestManager.this.callbackResult(iCompletionCallbackWith, rCLanguage);
            }

            public void onFailure(AutelError autelError) {
                AutelRemoteControllerRequestManager.this.callbackFailure(iCompletionCallbackWith, autelError);
            }
        });
    }

    public void startRCBinding(final AutelCompletionCallback.ICompletionCallbackWith<Boolean> iCompletionCallbackWith) {
        RCCommandMessage rCCommandMessage = new RCCommandMessage();
        rCCommandMessage.createSetRCPairModeParams();
        checkValueValid(iCompletionCallbackWith);
        setICompletionCallbackWith(rCCommandMessage, new AutelCompletionCallback.ICompletionCallbackWith<RCRespondMsgParser>() {
            public void onResult(RCRespondMsgParser rCRespondMsgParser) {
                AutelRemoteControllerRequestManager.this.callbackResult(iCompletionCallbackWith, Boolean.valueOf(rCRespondMsgParser.isRCBindSucc()));
            }

            public void onFailure(AutelError autelError) {
                AutelRemoteControllerRequestManager.this.callbackFailure(iCompletionCallbackWith, autelError);
            }
        });
    }

    public void queryRCBindMode(final AutelCompletionCallback.ICompletionCallbackWith<Integer> iCompletionCallbackWith) {
        RCCommandMessage rCCommandMessage = new RCCommandMessage();
        rCCommandMessage.createQueryRCPairModeParams();
        checkValueValid(iCompletionCallbackWith);
        setICompletionCallbackWith(rCCommandMessage, new AutelCompletionCallback.ICompletionCallbackWith<RCRespondMsgParser>() {
            public void onResult(RCRespondMsgParser rCRespondMsgParser) {
                AutelRemoteControllerRequestManager.this.callbackResult(iCompletionCallbackWith, Integer.valueOf(rCRespondMsgParser.getRCBindMode()));
            }

            public void onFailure(AutelError autelError) {
                AutelRemoteControllerRequestManager.this.callbackFailure(iCompletionCallbackWith, autelError);
            }
        });
    }

    public void setRFPower(final RFPower rFPower, final AutelCompletionCallback.ICompletionCallbackWith<Boolean> iCompletionCallbackWith) {
        RCCommandMessage rCCommandMessage = new RCCommandMessage();
        rCCommandMessage.createSetRFPowerParams(rFPower.getValue());
        checkValueValid(iCompletionCallbackWith);
        setICompletionCallbackWith(rCCommandMessage, new AutelCompletionCallback.ICompletionCallbackWith<RCRespondMsgParser>() {
            public void onResult(RCRespondMsgParser rCRespondMsgParser) {
                boolean isRFPowerSetSucc = rCRespondMsgParser.isRFPowerSetSucc();
                if (isRFPowerSetSucc) {
                    AutelAircraftInfoManager.getRemoteControllerInfo().setAutelRFPower(rFPower);
                }
                AutelRemoteControllerRequestManager.this.callbackResult(iCompletionCallbackWith, Boolean.valueOf(isRFPowerSetSucc));
            }

            public void onFailure(AutelError autelError) {
                AutelRemoteControllerRequestManager.this.callbackFailure(iCompletionCallbackWith, autelError);
            }
        });
    }

    public void queryRFPower(final AutelCompletionCallback.ICompletionCallbackWith<RFPower> iCompletionCallbackWith) {
        RCCommandMessage rCCommandMessage = new RCCommandMessage();
        rCCommandMessage.createQueryRFPowerParams();
        checkValueValid(iCompletionCallbackWith);
        setICompletionCallbackWith(rCCommandMessage, new AutelCompletionCallback.ICompletionCallbackWith<RCRespondMsgParser>() {
            public void onResult(RCRespondMsgParser rCRespondMsgParser) {
                RFPower rFPower = rCRespondMsgParser.getRFPower();
                AutelAircraftInfoManager.getRemoteControllerInfo().setAutelRFPower(rFPower);
                AutelRemoteControllerRequestManager.this.callbackResult(iCompletionCallbackWith, rFPower);
            }

            public void onFailure(AutelError autelError) {
                AutelRemoteControllerRequestManager.this.callbackFailure(iCompletionCallbackWith, autelError);
            }
        });
    }

    public void setTeacherStudentMode(final TeachingMode teachingMode, final AutelCompletionCallback.ICompletionCallbackWith<Boolean> iCompletionCallbackWith) {
        RCCommandMessage rCCommandMessage = new RCCommandMessage();
        rCCommandMessage.createSetTeacherStudentModeParams(teachingMode.getValue());
        checkValueValid(iCompletionCallbackWith);
        setICompletionCallbackWith(rCCommandMessage, new AutelCompletionCallback.ICompletionCallbackWith<RCRespondMsgParser>() {
            public void onResult(RCRespondMsgParser rCRespondMsgParser) {
                boolean isTeacherStudentModeSetSucc = rCRespondMsgParser.isTeacherStudentModeSetSucc();
                if (isTeacherStudentModeSetSucc) {
                    AutelAircraftInfoManager.getRemoteControllerInfo().setTeacherStudentMode(teachingMode);
                }
                AutelRemoteControllerRequestManager.this.callbackResult(iCompletionCallbackWith, Boolean.valueOf(isTeacherStudentModeSetSucc));
            }

            public void onFailure(AutelError autelError) {
                AutelRemoteControllerRequestManager.this.callbackFailure(iCompletionCallbackWith, autelError);
            }
        });
    }

    public void queryTeacherStudentMode(final AutelCompletionCallback.ICompletionCallbackWith<TeachingMode> iCompletionCallbackWith) {
        RCCommandMessage rCCommandMessage = new RCCommandMessage();
        rCCommandMessage.createQueryTeacherStudentModeParams();
        checkValueValid(iCompletionCallbackWith);
        setICompletionCallbackWith(rCCommandMessage, new AutelCompletionCallback.ICompletionCallbackWith<RCRespondMsgParser>() {
            public void onResult(RCRespondMsgParser rCRespondMsgParser) {
                TeachingMode teacherStudentMode = rCRespondMsgParser.getTeacherStudentMode();
                AutelAircraftInfoManager.getRemoteControllerInfo().setTeacherStudentMode(teacherStudentMode);
                AutelRemoteControllerRequestManager.this.callbackResult(iCompletionCallbackWith, teacherStudentMode);
            }

            public void onFailure(AutelError autelError) {
                AutelRemoteControllerRequestManager.this.callbackFailure(iCompletionCallbackWith, autelError);
            }
        });
    }

    public void setRCCalibrationStep(RemoteControllerStickCalibration remoteControllerStickCalibration, final AutelCompletionCallback.ICompletionCallbackWith<int[]> iCompletionCallbackWith) {
        RCCommandMessage rCCommandMessage = new RCCommandMessage();
        rCCommandMessage.createSetRCAdjustStepParams(remoteControllerStickCalibration.getValue());
        checkValueValid(iCompletionCallbackWith);
        setICompletionCallbackWith(rCCommandMessage, new AutelCompletionCallback.ICompletionCallbackWith<RCRespondMsgParser>() {
            public void onResult(RCRespondMsgParser rCRespondMsgParser) {
                AutelRemoteControllerRequestManager.this.callbackResult(iCompletionCallbackWith, rCRespondMsgParser.getRCAdjustStep());
            }

            public void onFailure(AutelError autelError) {
                AutelRemoteControllerRequestManager.this.callbackFailure(iCompletionCallbackWith, autelError);
            }
        });
    }

    public void queryRCVersionData(final AutelCompletionCallback.ICompletionCallbackWith<int[]> iCompletionCallbackWith) {
        RCCommandMessage rCCommandMessage = new RCCommandMessage();
        rCCommandMessage.createQueryRCVersionDataParams();
        checkValueValid(iCompletionCallbackWith);
        setICompletionCallbackWith(rCCommandMessage, new AutelCompletionCallback.ICompletionCallbackWith<RCRespondMsgParser>() {
            public void onResult(RCRespondMsgParser rCRespondMsgParser) {
                AutelRemoteControllerRequestManager.this.callbackResult(iCompletionCallbackWith, rCRespondMsgParser.getRCVersionData());
            }

            public void onFailure(AutelError autelError) {
                AutelRemoteControllerRequestManager.this.callbackFailure(iCompletionCallbackWith, autelError);
            }
        });
    }

    public void setRCLengthUnit(final RemoteControllerParameterUnit remoteControllerParameterUnit, final AutelCompletionCallback.ICompletionCallbackWith<Boolean> iCompletionCallbackWith) {
        RCCommandMessage rCCommandMessage = new RCCommandMessage();
        rCCommandMessage.createSetRCLengthUnitParams(remoteControllerParameterUnit.getValue());
        checkValueValid(iCompletionCallbackWith);
        setICompletionCallbackWith(rCCommandMessage, new AutelCompletionCallback.ICompletionCallbackWith<RCRespondMsgParser>() {
            public void onResult(RCRespondMsgParser rCRespondMsgParser) {
                boolean isRCLengthUnitSetSucc = rCRespondMsgParser.isRCLengthUnitSetSucc();
                if (isRCLengthUnitSetSucc) {
                    AutelAircraftInfoManager.getRemoteControllerInfo().setRCLengthUnit(remoteControllerParameterUnit);
                }
                AutelRemoteControllerRequestManager.this.callbackResult(iCompletionCallbackWith, Boolean.valueOf(isRCLengthUnitSetSucc));
            }

            public void onFailure(AutelError autelError) {
                AutelRemoteControllerRequestManager.this.callbackFailure(iCompletionCallbackWith, autelError);
            }
        });
    }

    public void queryRCLengthUnit(final AutelCompletionCallback.ICompletionCallbackWith<RemoteControllerParameterUnit> iCompletionCallbackWith) {
        checkValueValid(iCompletionCallbackWith);
        RCCommandMessage rCCommandMessage = new RCCommandMessage();
        rCCommandMessage.createQueryRCLengthUnitParams();
        setICompletionCallbackWith(rCCommandMessage, new AutelCompletionCallback.ICompletionCallbackWith<RCRespondMsgParser>() {
            public void onResult(RCRespondMsgParser rCRespondMsgParser) {
                RemoteControllerParameterUnit rCLengthUnit = rCRespondMsgParser.getRCLengthUnit();
                AutelAircraftInfoManager.getRemoteControllerInfo().setRCLengthUnit(rCLengthUnit);
                AutelRemoteControllerRequestManager.this.callbackResult(iCompletionCallbackWith, rCLengthUnit);
            }

            public void onFailure(AutelError autelError) {
                AutelRemoteControllerRequestManager.this.callbackFailure(iCompletionCallbackWith, autelError);
            }
        });
    }

    public void setRCCommandStickMode(final RemoteControllerCommandStickMode remoteControllerCommandStickMode, final AutelCompletionCallback.ICompletionCallbackWith<Boolean> iCompletionCallbackWith) {
        checkValueValid(iCompletionCallbackWith);
        RCCommandMessage rCCommandMessage = new RCCommandMessage();
        rCCommandMessage.createSetRCControlModelParams(remoteControllerCommandStickMode.getValue());
        setICompletionCallbackWith(rCCommandMessage, new AutelCompletionCallback.ICompletionCallbackWith<RCRespondMsgParser>() {
            public void onResult(RCRespondMsgParser rCRespondMsgParser) {
                boolean isRCControlModelSetSucc = rCRespondMsgParser.isRCControlModelSetSucc();
                if (isRCControlModelSetSucc) {
                    AutelAircraftInfoManager.getRemoteControllerInfo().setRCCommandStickMode(remoteControllerCommandStickMode);
                }
                AutelRemoteControllerRequestManager.this.callbackResult(iCompletionCallbackWith, Boolean.valueOf(isRCControlModelSetSucc));
            }

            public void onFailure(AutelError autelError) {
                AutelRemoteControllerRequestManager.this.callbackFailure(iCompletionCallbackWith, autelError);
            }
        });
    }

    public void queryRCCommandStickMode(final AutelCompletionCallback.ICompletionCallbackWith<RemoteControllerCommandStickMode> iCompletionCallbackWith) {
        RCCommandMessage rCCommandMessage = new RCCommandMessage();
        rCCommandMessage.createQueryRCControlModelParams();
        checkValueValid(iCompletionCallbackWith);
        setICompletionCallbackWith(rCCommandMessage, new AutelCompletionCallback.ICompletionCallbackWith<RCRespondMsgParser>() {
            public void onResult(RCRespondMsgParser rCRespondMsgParser) {
                RemoteControllerCommandStickMode rCControlModel = rCRespondMsgParser.getRCControlModel();
                AutelAircraftInfoManager.getRemoteControllerInfo().setRCCommandStickMode(rCControlModel);
                AutelRemoteControllerRequestManager.this.callbackResult(iCompletionCallbackWith, rCControlModel);
            }

            public void onFailure(AutelError autelError) {
                AutelRemoteControllerRequestManager.this.callbackFailure(iCompletionCallbackWith, autelError);
            }
        });
    }

    public void resetWifi() {
        RCCommandMessage rCCommandMessage = new RCCommandMessage();
        rCCommandMessage.createRCResetWifi();
        setICompletionCallbackWith(rCCommandMessage, (AutelCompletionCallback.ICompletionCallbackWith) null);
    }

    public void uploadPhoneCompassAngle(int i) {
        RCCommandMessage rCCommandMessage = new RCCommandMessage();
        rCCommandMessage.uploadPhoneCompassAngle(i);
        setICompletionCallbackWith(rCCommandMessage, (AutelCompletionCallback.ICompletionCallbackWith) null);
    }
}

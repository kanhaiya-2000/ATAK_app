package com.autel.internal.battery.evo;

import com.autel.AutelNet2.aircraft.battery.controller.BatteryRequestManager2;
import com.autel.AutelNet2.aircraft.battery.engine.BatteryInfoInternal;
import com.autel.AutelNet2.aircraft.engine.BatteryInfoCmdParams;
import com.autel.AutelNet2.aircraft.firmware.FirmwareManager;
import com.autel.AutelNet2.aircraft.firmware.bean.FirmwareDeviceInfo;
import com.autel.AutelNet2.aircraft.flycontroller.engine.CommandInfoInternal;
import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.battery.BatteryParameterRangeManager;
import com.autel.common.battery.evo.EvoBatteryInfo;
import com.autel.common.error.AutelError;
import com.autel.internal.autel.IAutelStateManager;
import com.autel.sdk.battery.p004rx.RxEvoBattery;

public class EvoBatteryImpl implements EvoBatteryService {
    private static final String addBatteryRealTimeDataListenerTag = "addBatteryRealTimeDataListener";
    private static final String getFullChargeTag = "getFullCharge";
    private BatteryParameterRangeManager batteryParameterRangeManager;

    public void connect() {
    }

    public void disconnect() {
    }

    public RxEvoBattery toRx() {
        return null;
    }

    public void setBatteryStateListener(final CallbackWithOneParam<EvoBatteryInfo> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            BatteryRequestManager2.getInstance().addBatteryRealTimeDataListener(addBatteryRealTimeDataListenerTag, new CallbackWithOneParam<BatteryInfoInternal>() {
                public void onFailure(AutelError autelError) {
                }

                public void onSuccess(BatteryInfoInternal batteryInfoInternal) {
                    callbackWithOneParam.onSuccess(batteryInfoInternal);
                }
            });
        } else {
            BatteryRequestManager2.getInstance().removeBatteryRealTimeDataListener(addBatteryRealTimeDataListenerTag);
        }
    }

    public void setLowBatteryNotifyThreshold(float f, final CallbackWithNoParam callbackWithNoParam) {
        BatteryRequestManager2.getInstance().setLowBatteryWarning(f, new CallbackWithOneParam<Float>() {
            public void onSuccess(Float f) {
                CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                if (callbackWithNoParam != null) {
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

    public void getLowBatteryNotifyThreshold(CallbackWithOneParam<Float> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            BatteryRequestManager2.getInstance().queryLowBatteryWarning(callbackWithOneParam);
        }
    }

    public void setCriticalBatteryNotifyThreshold(float f, final CallbackWithNoParam callbackWithNoParam) {
        BatteryRequestManager2.getInstance().setCriticalBatteryWarning(f, new CallbackWithOneParam<Float>() {
            public void onSuccess(Float f) {
                CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                if (callbackWithNoParam != null) {
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

    public void getCriticalBatteryNotifyThreshold(CallbackWithOneParam<Float> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            BatteryRequestManager2.getInstance().queryCriticalBatteryWarning(callbackWithOneParam);
        }
    }

    public void setDischargeDay(int i, final CallbackWithNoParam callbackWithNoParam) {
        BatteryRequestManager2.getInstance().setBatteryDisCharge(i, new CallbackWithOneParam<CommandInfoInternal>() {
            public void onSuccess(CommandInfoInternal commandInfoInternal) {
                if (callbackWithNoParam == null) {
                    return;
                }
                if (commandInfoInternal.isSuccess()) {
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

    public void getDischargeDay(final CallbackWithOneParam<Integer> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            BatteryRequestManager2.getInstance().queryBatteryInfo(new CallbackWithOneParam<BatteryInfoCmdParams>() {
                public void onSuccess(BatteryInfoCmdParams batteryInfoCmdParams) {
                    callbackWithOneParam.onSuccess(Integer.valueOf(batteryInfoCmdParams.getDischargeDays()));
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        }
    }

    public void getDischargeCount(final CallbackWithOneParam<Integer> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            BatteryRequestManager2.getInstance().queryBatteryInfo(new CallbackWithOneParam<BatteryInfoCmdParams>() {
                public void onSuccess(BatteryInfoCmdParams batteryInfoCmdParams) {
                    callbackWithOneParam.onSuccess(Integer.valueOf(batteryInfoCmdParams.getLoopTimes()));
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        }
    }

    public void getSerialNumber(final CallbackWithOneParam<String> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            FirmwareManager.instance().getComponentInfo(FirmwareManager.DEV_BATTERY, new CallbackWithOneParam<FirmwareDeviceInfo.VersionBean>() {
                public void onSuccess(FirmwareDeviceInfo.VersionBean versionBean) {
                    callbackWithOneParam.onSuccess(versionBean.getSerialNumber());
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        }
    }

    public void getVersion(final CallbackWithOneParam<String> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            BatteryRequestManager2.getInstance().queryBatteryInfo(new CallbackWithOneParam<BatteryInfoCmdParams>() {
                public void onSuccess(BatteryInfoCmdParams batteryInfoCmdParams) {
                    callbackWithOneParam.onSuccess(batteryInfoCmdParams.getVersion());
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        }
    }

    public BatteryParameterRangeManager getParameterSupportManager() {
        if (this.batteryParameterRangeManager == null) {
            this.batteryParameterRangeManager = new EvoBatteryParameterRangeManagerImpl();
        }
        return this.batteryParameterRangeManager;
    }

    public void getFullChargeCapacity(final CallbackWithOneParam<Integer> callbackWithOneParam) {
        BatteryRequestManager2.getInstance().addBatteryRealTimeDataListener(getFullChargeTag, new CallbackWithOneParam<BatteryInfoInternal>() {
            public void onSuccess(BatteryInfoInternal batteryInfoInternal) {
                BatteryRequestManager2.getInstance().removeBatteryRealTimeDataListener(EvoBatteryImpl.getFullChargeTag);
                callbackWithOneParam.onSuccess(Integer.valueOf((int) batteryInfoInternal.getFullCapacity()));
            }

            public void onFailure(AutelError autelError) {
                BatteryRequestManager2.getInstance().removeBatteryRealTimeDataListener(EvoBatteryImpl.getFullChargeTag);
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void init(IAutelStateManager iAutelStateManager) {
        BatteryRequestManager2.getInstance().init();
    }

    public void destroy() {
        BatteryRequestManager2.getInstance().destroy();
    }
}

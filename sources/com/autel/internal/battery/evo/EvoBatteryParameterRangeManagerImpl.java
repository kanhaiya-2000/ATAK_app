package com.autel.internal.battery.evo;

import com.autel.AutelNet2.aircraft.battery.controller.BatteryRequestManager2;
import com.autel.AutelNet2.aircraft.engine.BatteryInfoCmdParams;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.RangePair;
import com.autel.common.battery.BatteryParameterRangeManager;
import com.autel.common.error.AutelError;

public class EvoBatteryParameterRangeManagerImpl implements BatteryParameterRangeManager {
    public RangePair<Float> getLowBattery() {
        return new RangePair<Float>() {
            public Float getValueFrom() {
                return Float.valueOf(0.15f);
            }

            public Float getValueTo() {
                return Float.valueOf(0.5f);
            }
        };
    }

    public RangePair<Float> getCriticalBattery() {
        return new RangePair<Float>() {
            public Float getValueFrom() {
                return Float.valueOf(0.08f);
            }

            public Float getValueTo() {
                return Float.valueOf(0.45f);
            }
        };
    }

    public RangePair<Integer> getDischargeDay() {
        return new RangePair<Integer>() {
            public Integer getValueFrom() {
                return 1;
            }

            public Integer getValueTo() {
                return 10;
            }
        };
    }

    public void getBatteryCellVoltageRange(final CallbackWithOneParam<RangePair<Integer>> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            BatteryRequestManager2.getInstance().queryBatteryInfo(new CallbackWithOneParam<BatteryInfoCmdParams>() {
                public void onSuccess(final BatteryInfoCmdParams batteryInfoCmdParams) {
                    callbackWithOneParam.onSuccess(new RangePair<Integer>() {
                        public Integer getValueFrom() {
                            return Integer.valueOf(batteryInfoCmdParams.getMinVoltage());
                        }

                        public Integer getValueTo() {
                            return Integer.valueOf(batteryInfoCmdParams.getMaxVoltage());
                        }
                    });
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        }
    }
}

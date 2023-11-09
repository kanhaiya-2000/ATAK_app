package com.autel.internal.battery;

import com.atakmap.android.uastool.MAVLink.enums.MAV_CMD;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.RangePair;
import com.autel.common.battery.BatteryParameterRangeManager;

public class BatteryParameterRangeManagerImpl implements BatteryParameterRangeManager {
    public RangePair<Float> getLowBattery() {
        return new RangePair<Float>() {
            public Float getValueFrom() {
                return Float.valueOf(0.25f);
            }

            public Float getValueTo() {
                return Float.valueOf(0.5f);
            }
        };
    }

    public RangePair<Float> getCriticalBattery() {
        return new RangePair<Float>() {
            public Float getValueFrom() {
                return Float.valueOf(0.1f);
            }

            public Float getValueTo() {
                return Float.valueOf(0.25f);
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

    public void getBatteryCellVoltageRange(CallbackWithOneParam<RangePair<Integer>> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            callbackWithOneParam.onSuccess(new RangePair<Integer>() {
                public Integer getValueFrom() {
                    return Integer.valueOf(MAV_CMD.MAV_CMD_DO_VTOL_TRANSITION);
                }

                public Integer getValueTo() {
                    return 4200;
                }
            });
        }
    }
}

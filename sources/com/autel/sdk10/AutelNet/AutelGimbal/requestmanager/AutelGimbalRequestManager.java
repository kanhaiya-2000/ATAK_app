package com.autel.sdk10.AutelNet.AutelGimbal.requestmanager;

import com.autel.common.error.AutelError;
import com.autel.common.gimbal.GimbalRollAngleAdjust;
import com.autel.common.gimbal.GimbalWorkMode;
import com.autel.internal.sdk.product.datapost.MsgPostManager;
import com.autel.internal.sdk.product.datapost.PostRunnable;
import com.autel.sdk10.AutelNet.AutelGimbal.GimbalManager;
import com.autel.sdk10.AutelNet.AutelGimbal.enums.GimbalRequestCmdName;
import com.autel.sdk10.AutelNet.AutelMavlinkCore.controller.StarLinkClientManager;
import com.autel.sdk10.AutelNet.AutelMavlinkCore.core.mavlinkcmds.BaseRequestManager;
import com.autel.sdk10.AutelNet.AutelMavlinkCore.core.mavlinkcmds.mavlinkpacket.GimbalMAVLinkPacketFactory;
import com.autel.sdk10.AutelNet.AutelMavlinkCore.core.mavlinkcmds.mavlinkparameter.ParamsUtils;
import com.autel.sdk10.AutelNet.AutelRemoteController.interfaces.IAutelRCLongTimeCallback;
import com.autel.sdk10.interfaces.AutelCompletionCallback;
import com.autel.sdk10.products.aircraft.AutelAircraftInfoManager;
import com.autel.sdk10.products.aircraft.AutelAircraftRequestManager;

public class AutelGimbalRequestManager extends BaseRequestManager {
    public void addQueryGimbalAngleCallback(String str, IAutelRCLongTimeCallback.IAutelRCLongTimeCallbackWith<Integer> iAutelRCLongTimeCallbackWith) {
        AutelAircraftRequestManager.getRCRequestManager().mo19487a(str, iAutelRCLongTimeCallbackWith);
    }

    public void removeQueryGimbalAngleCallback(String str) {
        AutelAircraftRequestManager.getRCRequestManager().mo19492b(str);
    }

    public void setGimbalAngle(float f) {
        AutelAircraftRequestManager.getRCRequestManager().mo19500a(f);
    }

    public void setGimbalWorkMode(final GimbalWorkMode gimbalWorkMode, final AutelCompletionCallback.ICompletionCallbackWith<GimbalWorkMode> iCompletionCallbackWith) {
        checkValueValid(iCompletionCallbackWith);
        sendParameter(ParamsUtils.getParameter(GimbalRequestCmdName.GIMBAL_WORK_MODE, gimbalWorkMode.getValue10() + "", 6));
        waitForResponse(0, new AutelCompletionCallback.ICompletionCallbackWith<GimbalWorkMode>() {
            public void onResult(GimbalWorkMode gimbalWorkMode) {
                StarLinkClientManager.getInstance_().sendMavPacket(GimbalMAVLinkPacketFactory.createSendPztWorkModePacket(gimbalWorkMode));
                StarLinkClientManager.getInstance_().sendMavPacket(GimbalMAVLinkPacketFactory.createSendPztWorkModePacket(gimbalWorkMode));
                StarLinkClientManager.getInstance_().sendMavPacket(GimbalMAVLinkPacketFactory.createSendPztWorkModePacket(gimbalWorkMode));
                AutelGimbalRequestManager.this.callbackResult(iCompletionCallbackWith, gimbalWorkMode);
            }

            public void onFailure(AutelError autelError) {
                AutelGimbalRequestManager.this.callbackFailure(iCompletionCallbackWith, autelError);
            }
        });
    }

    public void queryGimbalWorkMode(AutelCompletionCallback.ICompletionCallbackWith<GimbalWorkMode> iCompletionCallbackWith) {
        readParameterName(GimbalRequestCmdName.GIMBAL_WORK_MODE);
        waitForResponse(0, iCompletionCallbackWith);
    }

    public void setRollAdjustData(GimbalRollAngleAdjust gimbalRollAngleAdjust, AutelCompletionCallback.ICompletionCallbackWith<Double> iCompletionCallbackWith) {
        StarLinkClientManager.getInstance_().sendMavPacket(GimbalMAVLinkPacketFactory.createSetRollAdjustDataPacket(gimbalRollAngleAdjust.getValue(), 0));
        waitForResponse(1, iCompletionCallbackWith);
    }

    /* access modifiers changed from: protected */
    public boolean isReportResponseSucc(final int i, long j, final AutelCompletionCallback.ICompletionCallbackWith iCompletionCallbackWith) {
        if (iCompletionCallbackWith == null) {
            return true;
        }
        if (!GimbalManager.getAutelGimbalInfoParser().isNewInfo(i, j)) {
            return false;
        }
        MsgPostManager.instance().post(new PostRunnable() {
            /* access modifiers changed from: protected */
            public void task() {
                int i = i;
                if (i == 0) {
                    iCompletionCallbackWith.onResult(AutelAircraftInfoManager.getAutelGimbalInfo().getGimbalWorkMode());
                } else if (i == 1) {
                    iCompletionCallbackWith.onResult(Double.valueOf(AutelAircraftInfoManager.getAutelGimbalInfo().getRollAdjust()));
                }
            }
        });
        return true;
    }
}

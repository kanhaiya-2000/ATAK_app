package com.autel.sdk10.products.requestmanager;

import com.autel.internal.sdk.product.datapost.MsgPostManager;
import com.autel.internal.sdk.product.datapost.PostRunnable;
import com.autel.sdk10.AutelNet.AutelFlyController.FlyControllerManager;
import com.autel.sdk10.AutelNet.AutelFlyController.enums.FlyControllerRequestCmdName;
import com.autel.sdk10.AutelNet.AutelMavlinkCore.core.mavlinkcmds.BaseRequestManager;
import com.autel.sdk10.AutelNet.AutelMavlinkCore.core.mavlinkcmds.mavlinkparameter.ParamsUtils;
import com.autel.sdk10.interfaces.AutelCompletionCallback;
import com.autel.sdk10.products.aircraft.AutelAircraftInfoManager;

public class ProductAircraftRequestManager extends BaseRequestManager {
    private static ProductAircraftRequestManager instance;

    private ProductAircraftRequestManager() {
    }

    public static ProductAircraftRequestManager getInstance() {
        if (instance == null) {
            instance = new ProductAircraftRequestManager();
        }
        return instance;
    }

    public void queryAircraftHasSNCode(AutelCompletionCallback.ICompletionCallbackWith<Integer> iCompletionCallbackWith) {
        readParameterName(FlyControllerRequestCmdName.SN_SAVED);
        waitForResponse(11, iCompletionCallbackWith);
    }

    public void queryAircraftActivateState(AutelCompletionCallback.ICompletionCallbackWith<Integer> iCompletionCallbackWith) {
        readParameterName(FlyControllerRequestCmdName.SN_DISABLE);
        waitForResponse(10, iCompletionCallbackWith);
    }

    public void setAircraftActivateState(int i, AutelCompletionCallback.ICompletionCallbackWith<Integer> iCompletionCallbackWith) {
        sendParameter(ParamsUtils.getParameter(FlyControllerRequestCmdName.SN_DISABLE, String.valueOf(i), 6));
        waitForResponse(10, iCompletionCallbackWith);
    }

    /* access modifiers changed from: protected */
    public synchronized boolean isReportResponseSucc(final int i, long j, final AutelCompletionCallback.ICompletionCallbackWith iCompletionCallbackWith) {
        if (iCompletionCallbackWith == null) {
            return true;
        }
        if (!FlyControllerManager.getAutelFlyControllerInfoParser().isNewInfo(i, j)) {
            return false;
        }
        MsgPostManager.instance().post(new PostRunnable() {
            /* access modifiers changed from: protected */
            public void task() {
                int i = i;
                if (i == 10) {
                    iCompletionCallbackWith.onResult(Integer.valueOf(AutelAircraftInfoManager.getAutelFlyControllerInfo().getSNDisableCode()));
                } else if (i == 11) {
                    iCompletionCallbackWith.onResult(Integer.valueOf(AutelAircraftInfoManager.getAutelFlyControllerInfo().getSNCode()));
                }
            }
        });
        return true;
    }
}

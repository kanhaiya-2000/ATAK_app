package com.autel.sdk10.products.info;

import com.MAVLink.Messages.ardupilotmega.msg_heartbeat;
import com.autel.common.product.AutelProductInfo;
import com.autel.common.product.AutelProductType;
import com.autel.internal.network.usb.proxy.AutelUSBHelper;
import com.autel.internal.sdk.product.ActivateState;

public class AutelProductInfoInternal implements AutelProductInfo {
    private static AutelProductInfoInternal instance_;
    private msg_heartbeat msg;

    public static AutelProductInfoInternal getInstance_() {
        if (instance_ == null) {
            instance_ = new AutelProductInfoInternal();
        }
        return instance_;
    }

    private AutelProductInfoInternal() {
    }

    public void setData(msg_heartbeat msg_heartbeat) {
        this.msg = msg_heartbeat;
    }

    public ActivateState getActivateState() {
        msg_heartbeat msg_heartbeat = this.msg;
        if (msg_heartbeat == null) {
            return ActivateState.UNKNOWN;
        }
        if (msg_heartbeat.custom_mode == 128) {
            return ActivateState.INACTIVATE;
        }
        if (this.msg.custom_mode == 129) {
            return ActivateState.ACTIVATE;
        }
        return ActivateState.UNKNOWN;
    }

    public AutelProductType getProduct() {
        msg_heartbeat msg_heartbeat = this.msg;
        if (msg_heartbeat == null) {
            return AutelProductType.UNKNOWN;
        }
        if (msg_heartbeat.autopilot != 13) {
            return AutelProductType.UNKNOWN;
        }
        return AutelUSBHelper.instance().isUsbOpened() ? AutelProductType.PREMIUM : AutelProductType.X_STAR;
    }

    public String toString() {
        msg_heartbeat msg_heartbeat = this.msg;
        return msg_heartbeat == null ? "Null" : msg_heartbeat.toString();
    }
}

package com.autel.AutelNet2.aircraft.visual.tracking.entity;

import com.autel.common.camera.visual.VisualWarningInfo;
import com.autel.common.flycontroller.VisualWarnState;

public class VisualWarningInfoImpl implements VisualWarningInfo {
    private int reasoncode;
    private int status;

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public int getReasoncode() {
        return this.reasoncode;
    }

    public void setReasoncode(int i) {
        this.reasoncode = i;
    }

    public VisualWarnState getWarnState() {
        return VisualWarnState.find(this.reasoncode);
    }

    public boolean isValid() {
        return this.status == 1;
    }
}

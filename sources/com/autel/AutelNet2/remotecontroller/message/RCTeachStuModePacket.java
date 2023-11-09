package com.autel.AutelNet2.remotecontroller.message;

import com.autel.common.remotecontroller.TeachingMode;
import org.json.JSONArray;

public class RCTeachStuModePacket extends RCMsgPacket {
    private boolean isSucc = false;
    private TeachingMode mAutelTeachingMode;

    public RCTeachStuModePacket() {
        setType(10);
    }

    public void setTeachStuMode(TeachingMode teachingMode) {
        setType(9);
        this.mAutelTeachingMode = teachingMode;
        addData(teachingMode.getValue());
    }

    public TeachingMode getMode() {
        return this.mAutelTeachingMode;
    }

    public boolean isSetTeachStuModeSucc() {
        return this.isSucc;
    }

    public void parseData(int i, JSONArray jSONArray) {
        if (i == 9) {
            this.isSucc = isResultSucc(jSONArray);
        } else if (i == 10) {
            int i2 = jSONArray.getInt(0);
            if (i2 == TeachingMode.TEACHER.getValue()) {
                this.mAutelTeachingMode = TeachingMode.TEACHER;
            } else if (i2 == TeachingMode.STUDENT.getValue()) {
                this.mAutelTeachingMode = TeachingMode.STUDENT;
            } else {
                this.mAutelTeachingMode = TeachingMode.DISABLED;
            }
        }
    }
}

package com.autel.AutelNet2.aircraft.gimbal.message;

import com.autel.AutelNet2.aircraft.gimbal.engine.GimbalCmdType;
import com.autel.AutelNet2.constant.FmuCmdConstant;
import com.autel.AutelNet2.constant.MsgType;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.common.gimbal.GimbalAxisType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GimbalCmdPacket extends BaseMsgPacket {
    private int command;
    private int[] data = new int[4];

    public BaseMsgPacket parseBody() {
        return null;
    }

    public void setCommand(GimbalCmdType gimbalCmdType) {
        this.command = gimbalCmdType.getValue();
    }

    public void setData(int i) {
        this.data[0] = i;
    }

    public void setRollData(int i) {
        int[] iArr = this.data;
        iArr[0] = i;
        iArr[3] = 0;
    }

    public void setPitchData(int i) {
        int[] iArr = this.data;
        iArr[1] = i;
        iArr[3] = 1;
    }

    public void setYawData(int i) {
        int[] iArr = this.data;
        iArr[2] = i;
        iArr[3] = 2;
    }

    public void saveParams() {
        this.data[3] = 3;
    }

    /* renamed from: com.autel.AutelNet2.aircraft.gimbal.message.GimbalCmdPacket$1 */
    /* synthetic */ class C22461 {
        static final /* synthetic */ int[] $SwitchMap$com$autel$common$gimbal$GimbalAxisType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.autel.common.gimbal.GimbalAxisType[] r0 = com.autel.common.gimbal.GimbalAxisType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$autel$common$gimbal$GimbalAxisType = r0
                com.autel.common.gimbal.GimbalAxisType r1 = com.autel.common.gimbal.GimbalAxisType.PITCH     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$autel$common$gimbal$GimbalAxisType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.autel.common.gimbal.GimbalAxisType r1 = com.autel.common.gimbal.GimbalAxisType.ROLL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$autel$common$gimbal$GimbalAxisType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.autel.common.gimbal.GimbalAxisType r1 = com.autel.common.gimbal.GimbalAxisType.YAW     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.autel.AutelNet2.aircraft.gimbal.message.GimbalCmdPacket.C22461.<clinit>():void");
        }
    }

    public void setGimbalAngleCmdData(GimbalAxisType gimbalAxisType) {
        int i = C22461.$SwitchMap$com$autel$common$gimbal$GimbalAxisType[gimbalAxisType.ordinal()];
        if (i == 1) {
            this.data[1] = 1;
        } else if (i == 2) {
            this.data[0] = 1;
        } else if (i == 3) {
            this.data[2] = 1;
        }
    }

    public int getType() {
        return this.command;
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
        this.msg_head.msg_type = MsgType.AU_MAV_GIMBAL_CMD;
        this.msg_head.msg_dst = 4;
    }

    /* access modifiers changed from: protected */
    public String loadBody() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("method", FmuCmdConstant.GIMBAL_CMD);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("Cmd", this.command);
            JSONArray jSONArray = new JSONArray();
            int i = 0;
            while (true) {
                int[] iArr = this.data;
                if (i >= iArr.length) {
                    break;
                }
                jSONArray.put(i, iArr[i]);
                i++;
            }
            jSONObject2.put("Data", jSONArray);
            jSONObject.put("params", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}

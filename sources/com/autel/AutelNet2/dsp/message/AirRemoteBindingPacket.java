package com.autel.AutelNet2.dsp.message;

import android.text.TextUtils;
import com.atakmap.android.uastool.tasks.UASTask;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.dsp.data.UserInfo;
import com.autel.common.remotecontroller.TeachingMode;
import org.json.JSONException;
import org.json.JSONObject;

public class AirRemoteBindingPacket extends BaseMsgPacket {
    private UserInfo userInfo;

    public BaseMsgPacket parseBody() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
        this.msg_head.msg_type = 10;
        this.msg_head.msg_dst = 2048;
    }

    /* access modifiers changed from: protected */
    public String loadBody() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.userInfo != null) {
                jSONObject.put("method", "AirRemoteBinding");
                JSONObject jSONObject2 = new JSONObject();
                if (this.userInfo.getRole() == TeachingMode.TEACHER.getValue() || this.userInfo.getRole() == TeachingMode.STUDENT.getValue()) {
                    if (!TextUtils.isEmpty(this.userInfo.getUser())) {
                        jSONObject2.put(UASTask.COTDETAIL_USER, this.userInfo.getUser());
                    }
                    if (!TextUtils.isEmpty(this.userInfo.getPassword())) {
                        jSONObject2.put("password", this.userInfo.getPassword());
                    }
                }
                jSONObject2.put("role", this.userInfo.getRole());
                jSONObject.put("params", jSONObject2);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public void setUserInfo(UserInfo userInfo2) {
        this.userInfo = userInfo2;
    }
}

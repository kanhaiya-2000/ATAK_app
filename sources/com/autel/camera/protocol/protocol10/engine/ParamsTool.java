package com.autel.camera.protocol.protocol10.engine;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ParamsTool implements Serializable {
    private static final long serialVersionUID = 1;
    private JSONObject jsonObj;
    private HashMap<String, String> m_data;

    public ParamsTool() {
        this.m_data = null;
        this.jsonObj = new JSONObject();
        this.m_data = new HashMap<>();
    }

    public void setParams(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            this.m_data.put(str, str2);
        }
    }

    public void setParams(String str, int i) {
        if (i < 0) {
            i = 0;
        }
        this.m_data.put(str, String.valueOf(i));
    }

    public String toString() {
        try {
            for (Map.Entry next : this.m_data.entrySet()) {
                if (!TextUtils.isEmpty((CharSequence) next.getValue())) {
                    if (!"msg_id".equals(next.getKey())) {
                        if (!"token".equals(next.getKey())) {
                            this.jsonObj.put((String) next.getKey(), next.getValue());
                        }
                    }
                    if (Integer.valueOf((String) next.getValue()).intValue() == 1793) {
                        this.jsonObj.put("rval", 0);
                    }
                    this.jsonObj.put((String) next.getKey(), Integer.valueOf((String) next.getValue()));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this.jsonObj.toString();
    }
}

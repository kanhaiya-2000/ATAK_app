package com.autel.sdk10.AutelNet.AutelDsp.usb.engine;

import com.autel.common.dsp.RFData;
import com.autel.util.log.AutelLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AutelDspJsonCommand {
    public static String createGetCurRF() {
        return "{\"msg_name\":\"get_current_signal_strength\"}";
    }

    public static String createScanAllRF() {
        return "{\"msg_name\": \"get_all_signal_strength\"}";
    }

    public static String createSetRF(String str) {
        return "{\"msg_name\":\"set_current_signal_strength\",\"set_frequency\":" + str + "}";
    }

    public static ArrayList<RFData> resolveScanAllRFJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            ArrayList<RFData> arrayList = new ArrayList<>();
            jSONObject.getString("msg_name");
            JSONArray jSONArray = jSONObject.getJSONArray("params");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                arrayList.add(new RFData((float) Integer.valueOf(jSONObject2.getInt("freq")).intValue(), Integer.valueOf(jSONObject2.getInt("signal_strength")).intValue()));
            }
            if ("true".equals(jSONObject.getString("rval"))) {
                return arrayList;
            }
            return null;
        } catch (JSONException e) {
            e.printStackTrace();
            AutelLog.m15084e("DSP_RF", "JSONException  " + e.toString());
            return null;
        }
    }

    public static ArrayList<RFData> resolveGetCurRFJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.getString("msg_name");
            int i = jSONObject.getInt("current_frequency");
            int i2 = jSONObject.getInt("current_signal_strength");
            if (!"true".equals(jSONObject.getString("rval"))) {
                return null;
            }
            ArrayList<RFData> arrayList = new ArrayList<>();
            arrayList.add(new RFData((float) i, i2));
            return arrayList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean resolveSetRFJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.getString("msg_name");
            return "true".equals(jSONObject.getString("rval"));
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }
}

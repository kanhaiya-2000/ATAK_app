package com.autel.util.okhttp.utils;

import android.text.TextUtils;
import com.autel.common.error.AutelError;
import com.autel.util.log.AutelLog;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MessageParser {
    public Gson gsonParser = new Gson();
    private HashMap<String, String> m_data;

    public <T> T getObject(String str, Class<T> cls) {
        try {
            return this.gsonParser.fromJson(str, cls);
        } catch (Exception e) {
            AutelLog.m15084e("MessageParser", "Message Parser Exception------->> " + e.getMessage());
            e.printStackTrace();
            throw new Exception(AutelError.COMMON_PARSER_PARAMETER_FAILED.getDescription());
        }
    }

    public static <T> ArrayList<T> getObjectList(String str, Class<T> cls) {
        Type type = new TypeToken<ArrayList<JsonObject>>() {
        }.getType();
        ArrayList<T> arrayList = new ArrayList<>();
        Iterator it = ((ArrayList) new Gson().fromJson(str, type)).iterator();
        while (it.hasNext()) {
            arrayList.add(new Gson().fromJson((JsonElement) (JsonObject) it.next(), cls));
        }
        return arrayList;
    }

    public HashMap<String, String> parserJson(String str) {
        this.m_data = new HashMap<>();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                for (int i = 0; i < jSONObject.names().length(); i++) {
                    if (jSONObject.keys().hasNext()) {
                        String str2 = (String) jSONObject.names().get(i);
                        this.m_data.put(str2, jSONObject.getString(str2));
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return this.m_data;
    }

    public Map<String, String> parserParams(String str) {
        HashMap hashMap = new HashMap();
        try {
            if (!TextUtils.isEmpty(str) && str.contains("[{")) {
                hashMap.clear();
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                    for (int i2 = 0; i2 < jSONObject.names().length(); i2++) {
                        String str2 = (String) jSONObject.names().get(i2);
                        hashMap.put(str2, jSONObject.getString(str2));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hashMap;
    }
}

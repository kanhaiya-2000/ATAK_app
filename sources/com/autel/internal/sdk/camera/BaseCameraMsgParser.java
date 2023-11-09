package com.autel.internal.sdk.camera;

import android.text.TextUtils;
import com.autel.util.okhttp.utils.MessageParser;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BaseCameraMsgParser {
    public static String PARAM_MSG_ID = "msg_id";
    public static String PARAM_RVAL = "rval";
    protected ConcurrentHashMap<String, String> m_data = new ConcurrentHashMap<>();
    protected MessageParser messageParser = new MessageParser();

    public void parserData(String str) {
        this.m_data.putAll(this.messageParser.parserJson(str));
    }

    public Map<String, String> parserParam(String str) {
        return this.messageParser.parserParams(str);
    }

    public int getRval() {
        if (this.m_data.get(PARAM_RVAL) != null) {
            return Integer.valueOf(this.m_data.get(PARAM_RVAL)).intValue();
        }
        return -1;
    }

    public int getMsg_Id() {
        if (this.m_data.get(PARAM_MSG_ID) != null) {
            return Integer.valueOf(this.m_data.get(PARAM_MSG_ID)).intValue();
        }
        return -1;
    }

    public int getIntParam(String str) {
        return Integer.valueOf(!TextUtils.isEmpty(this.m_data.get(str)) ? this.m_data.get(str) : "0").intValue();
    }

    public float getFloatParam(String str) {
        return Float.valueOf(!TextUtils.isEmpty(this.m_data.get(str)) ? this.m_data.get(str) : "0f").floatValue();
    }

    public String getParam(String str) {
        return !TextUtils.isEmpty(this.m_data.get(str)) ? this.m_data.get(str) : "";
    }

    public String toString() {
        return this.m_data.toString();
    }
}

package com.autel.util.okhttp.model;

import com.autel.util.okhttp.utils.UrlUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FormParams {
    private static String ENCODING = "UTF-8";
    private ConcurrentHashMap<String, String> ParamsMap = new ConcurrentHashMap<>();

    public void addForm(String str, String str2) {
        this.ParamsMap.put(str, str2);
    }

    public Map<String, String> Forms() {
        return this.ParamsMap;
    }

    public String Form(String str) {
        return this.ParamsMap.get(str);
    }

    public String getParamString() {
        return UrlUtils.format(this, ENCODING);
    }
}

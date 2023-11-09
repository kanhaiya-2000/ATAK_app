package com.autel.util.okhttp.utils;

import com.autel.util.okhttp.model.FormParams;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class UrlUtils {
    public static String format(FormParams formParams, String str) {
        if (formParams == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (formParams.Forms() != null) {
            for (String next : formParams.Forms().keySet()) {
                String encodeFormFields = encodeFormFields(next, str);
                String encodeFormFields2 = encodeFormFields(formParams.Form(next), str);
                if (sb.length() > 0) {
                    sb.append("&");
                }
                sb.append(encodeFormFields);
                if (encodeFormFields2 != null) {
                    sb.append("=");
                    sb.append(encodeFormFields2);
                }
            }
        }
        return sb.toString();
    }

    private static String encodeFormFields(String str, String str2) {
        if (str == null) {
            return null;
        }
        if (str2 == null) {
            str2 = "UTF-8";
        }
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        }
    }
}

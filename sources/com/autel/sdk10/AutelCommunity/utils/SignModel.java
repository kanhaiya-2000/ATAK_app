package com.autel.sdk10.AutelCommunity.utils;

import android.text.TextUtils;
import atakplugin.UASTool.byr;
import atakplugin.UASTool.byt;
import com.autel.util.log.AutelBuildConfig;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SignModel {
    public static String ACTION_UPLOADAVATAR = "uploadAvatar";
    private static final String Host_IP = (!AutelBuildConfig.DEBUG ? "http://app.autelrobotics.com:8080" : "http://192.168.1.101");
    private static String pkey = "b7022c97a7d8c9fc47b2c14b8b375a9e";
    public static String url;

    public static String getCheckIsExixtUrl(String str) {
        url = Host_IP + "/personal_center/";
        if (!TextUtils.isEmpty(str)) {
            String sign = getSign(str);
            url += "?" + ("a=IsUserExist&" + str) + "&_sign=" + sign;
        }
        String replaceAll = url.replaceAll(" ", "%20");
        url = replaceAll;
        return replaceAll;
    }

    public static String getRegisterUrl(String str) {
        url = Host_IP + "/personal_center/";
        if (!TextUtils.isEmpty(str)) {
            String sign = getSign(str);
            url += "?" + ("a=RegUser&" + str) + "&_sign=" + sign;
        }
        String replaceAll = url.replaceAll(" ", "%20");
        url = replaceAll;
        return replaceAll;
    }

    public static String getUserInfo(Map<String, Object> map) {
        url = Host_IP + "/personal_center/?a=fetchLoginInfo";
        map.put("_sign", getSign(map));
        for (Map.Entry next : map.entrySet()) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(url);
                sb.append("&");
                sb.append((String) next.getKey());
                sb.append("=");
                sb.append(URLEncoder.encode(next.getValue() == null ? "" : next.getValue().toString(), "UTF-8"));
                url = sb.toString();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        String replaceAll = url.replaceAll(" ", "%20");
        url = replaceAll;
        return replaceAll;
    }

    public static String getUserRecordInfo(Map<String, Object> map) {
        url = Host_IP + "/personal_center/?a=fetchUserRecordsInfo";
        map.put("_sign", getSign(map));
        for (Map.Entry next : map.entrySet()) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(url);
                sb.append("&");
                sb.append((String) next.getKey());
                sb.append("=");
                sb.append(URLEncoder.encode(next.getValue() == null ? "" : next.getValue().toString(), "UTF-8"));
                url = sb.toString();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        String replaceAll = url.replaceAll(" ", "%20");
        url = replaceAll;
        return replaceAll;
    }

    public static String getLoginUrl(Map<String, Object> map) {
        url = Host_IP + "/personal_center/?a=login";
        map.put("_sign", getSign(map));
        for (Map.Entry next : map.entrySet()) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(url);
                sb.append("&");
                sb.append((String) next.getKey());
                sb.append("=");
                sb.append(URLEncoder.encode(next.getValue() == null ? "" : next.getValue().toString(), "UTF-8"));
                url = sb.toString();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        String replaceAll = url.replaceAll(" ", "%20");
        url = replaceAll;
        return replaceAll;
    }

    public static String getFindPwdUrl(Map<String, Object> map) {
        url = Host_IP + "/personal_center/?a=forgotPwd";
        map.put("_sign", getSign(map));
        for (Map.Entry next : map.entrySet()) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(url);
                sb.append("&");
                sb.append((String) next.getKey());
                sb.append("=");
                sb.append(URLEncoder.encode(next.getValue() == null ? "" : next.getValue().toString(), "UTF-8"));
                url = sb.toString();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        String replaceAll = url.replaceAll(" ", "%20");
        url = replaceAll;
        return replaceAll;
    }

    public static String getEditUserUrl(Map<String, Object> map) {
        url = Host_IP + "/personal_center/?a=updateCustomer";
        map.put("_sign", getSign(map));
        for (Map.Entry next : map.entrySet()) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(url);
                sb.append("&");
                sb.append((String) next.getKey());
                sb.append("=");
                sb.append(URLEncoder.encode(next.getValue() == null ? "" : next.getValue().toString(), "UTF-8"));
                url = sb.toString();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        String replaceAll = url.replaceAll(" ", "%20");
        url = replaceAll;
        return replaceAll;
    }

    public static String getAutelForumUrl(Map<String, Object> map) {
        url = Host_IP + "/personal_center/?a=checkSingleLoginByAutelIDAndURL";
        map.put("_sign", getSign(map));
        for (Map.Entry next : map.entrySet()) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(url);
                sb.append("&");
                sb.append((String) next.getKey());
                sb.append("=");
                sb.append(URLEncoder.encode(next.getValue() == null ? "" : next.getValue().toString(), "UTF-8"));
                url = sb.toString();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        String replaceAll = url.replaceAll(" ", "%20");
        url = replaceAll;
        return replaceAll;
    }

    public static String getRegProductUrl(String str, String str2) {
        url = Host_IP + "/personal_center/?a=regProductUAV";
        HashMap hashMap = new HashMap();
        hashMap.put("customerCode", str);
        hashMap.put("aircraftSerialNumber", str2);
        hashMap.put("_sign", getSign((Map<String, Object>) hashMap));
        for (Map.Entry entry : hashMap.entrySet()) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(url);
                sb.append("&");
                sb.append((String) entry.getKey());
                sb.append("=");
                sb.append(URLEncoder.encode(entry.getValue() == null ? "" : entry.getValue().toString(), "UTF-8"));
                url = sb.toString();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        String replaceAll = url.replaceAll(" ", "%20");
        url = replaceAll;
        return replaceAll;
    }

    public static String queryPersonalRegProducts(String str) {
        url = Host_IP + "/personal_center/?a=queryProducts";
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", str);
        hashMap.put("_sign", getSign((Map<String, Object>) hashMap));
        for (Map.Entry entry : hashMap.entrySet()) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(url);
                sb.append("&");
                sb.append((String) entry.getKey());
                sb.append("=");
                sb.append(URLEncoder.encode(entry.getValue() == null ? "" : entry.getValue().toString(), "UTF-8"));
                url = sb.toString();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        String replaceAll = url.replaceAll(" ", "%20");
        url = replaceAll;
        return replaceAll;
    }

    public static String queryProductBindStatus(String str) {
        url = Host_IP + "/personal_center/?a=getUavRegstatus";
        HashMap hashMap = new HashMap();
        hashMap.put("aircraftSerialNumber", str);
        hashMap.put("_sign", getSign((Map<String, Object>) hashMap));
        for (Map.Entry entry : hashMap.entrySet()) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(url);
                sb.append("&");
                sb.append((String) entry.getKey());
                sb.append("=");
                sb.append(URLEncoder.encode(entry.getValue() == null ? "" : entry.getValue().toString(), "UTF-8"));
                url = sb.toString();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        String replaceAll = url.replaceAll(" ", "%20");
        url = replaceAll;
        return replaceAll;
    }

    public static String createChangeCustomerDeviceName(String str, String str2, String str3) {
        url = Host_IP + "/personal_center/?a=updateDeviceAlias";
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", str);
        hashMap.put("proCode", str2);
        hashMap.put("alias", str3);
        hashMap.put("_sign", getSign((Map<String, Object>) hashMap));
        for (Map.Entry entry : hashMap.entrySet()) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(url);
                sb.append("&");
                sb.append((String) entry.getKey());
                sb.append("=");
                sb.append(URLEncoder.encode(entry.getValue() == null ? "" : entry.getValue().toString(), "UTF-8"));
                url = sb.toString();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        String replaceAll = url.replaceAll(" ", "%20");
        url = replaceAll;
        return replaceAll;
    }

    public static String getHttpUrlByActionName(String str) {
        String str2 = Host_IP + "/personal_center/?a=" + str;
        url = str2;
        return str2;
    }

    public static String getPersonalCenterUrl() {
        return Host_IP + "/personal_center/";
    }

    public static String getSignString(String str) {
        return getSign(str);
    }

    public static String changeCustomerAutelRoboticsID(String str, String str2, String str3) {
        String str4;
        url = Host_IP + "/personal_center/?a=changeCustomerAutelRoboticsID";
        HashMap hashMap = new HashMap();
        hashMap.put("aircraftSerialNumber", str);
        hashMap.put("newAutelROboticsId", str2);
        if (str3 == null) {
            str3 = "";
        }
        hashMap.put("operatorReason", str3);
        hashMap.put("_sign", getSign((Map<String, Object>) hashMap));
        for (Map.Entry entry : hashMap.entrySet()) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(url);
                sb.append("&");
                sb.append((String) entry.getKey());
                sb.append("=");
                if (entry.getValue() == null) {
                    str4 = "";
                } else {
                    str4 = entry.getValue().toString();
                }
                sb.append(URLEncoder.encode(str4, "UTF-8"));
                url = sb.toString();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return url;
    }

    private static String getSign(String str) {
        HashMap hashMap = new HashMap();
        for (String split : str.split("&")) {
            try {
                String[] split2 = split.split("=");
                hashMap.put(split2[0], split2[1]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return getSign((Map<String, Object>) hashMap);
    }

    private static String getSign(Map<String, Object> map) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : map.entrySet()) {
            if (next.getValue() != null && !next.getValue().equals("")) {
                arrayList.add(((String) next.getKey()) + "=" + next.getValue() + "&");
            }
        }
        int size = arrayList.size();
        String[] strArr = (String[]) arrayList.toArray(new String[size]);
        Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER);
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < size; i++) {
            stringBuffer.append(strArr[i]);
        }
        String stringBuffer2 = stringBuffer.toString();
        return new String(byr.m10610c(byt.m10636a((stringBuffer2 + pkey).getBytes(StandardCharsets.UTF_8))));
    }

    public static String getNoFlyZoneUrl(long j) {
        url = Host_IP + "/personal_center/index.php/Utils/fetchNoflyzoneinfo";
        if (j != 0) {
            url += "?synctime=" + j;
        }
        return url;
    }
}

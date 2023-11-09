package com.autel.sdk10.AutelCommunity.engine;

public class CommunityFactory {
    public static String buildAutelCommunityUrl(String str) {
        return str.substring(0, str.indexOf("&"));
    }

    public static String buildAutelCommunityBody(String str) {
        return str.substring(str.indexOf("&") + 1);
    }
}

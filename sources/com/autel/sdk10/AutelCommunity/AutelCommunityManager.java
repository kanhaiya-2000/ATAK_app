package com.autel.sdk10.AutelCommunity;

import com.autel.common.CallbackWithOneParam;
import com.autel.sdk10.AutelCommunity.engine.AutelCommunityInfo;
import com.autel.sdk10.AutelCommunity.engine.AutelCommunityRequest;
import com.autel.sdk10.AutelCommunity.engine.UserRecordInfo;
import java.io.InputStream;

public class AutelCommunityManager {
    private static AutelCommunityManager s_instance;

    private AutelCommunityManager() {
    }

    public static AutelCommunityManager instance() {
        if (s_instance == null) {
            s_instance = new AutelCommunityManager();
        }
        return s_instance;
    }

    public void doRegister(String str, String str2, AutelCommunityRequest.IAutelCommunityListener iAutelCommunityListener) {
        AutelCommunityRequest.instance().requestAutelRegister(str, str2, iAutelCommunityListener);
    }

    public void doLogin(String str, String str2, AutelCommunityRequest.IAutelCommunityLoginListener iAutelCommunityLoginListener) {
        AutelCommunityRequest.instance().requestAutelLogin(str, str2, iAutelCommunityLoginListener);
    }

    public void doAutelCommunityInfoModify(AutelCommunityInfo autelCommunityInfo, AutelCommunityRequest.IAutelCommunityListener iAutelCommunityListener) {
        AutelCommunityRequest.instance().requestAutelCommunityInfoModify(autelCommunityInfo, iAutelCommunityListener);
    }

    public void doFindPwd(String str, AutelCommunityRequest.IAutelCommunityListener iAutelCommunityListener) {
        AutelCommunityRequest.instance().requestAutelCommunityFindPwd(str, iAutelCommunityListener);
    }

    public String getAutelCommunityForumUrl(String str) {
        return AutelCommunityRequest.instance().requestAutelCommunityForumUrl(str);
    }

    public void doRequestRegisterProduct(String str, String str2, AutelCommunityRequest.IAutelCommunityRegProductListener iAutelCommunityRegProductListener) {
        AutelCommunityRequest.instance().requestRegisterProduct(str, str2, iAutelCommunityRegProductListener);
    }

    public void getPersonalRegProducts(String str, AutelCommunityRequest.IAutelQueryPersonalRegProductsListener iAutelQueryPersonalRegProductsListener) {
        AutelCommunityRequest.instance().queryPersonalRegProducts(str, iAutelQueryPersonalRegProductsListener);
    }

    public void queryProductBindStatusByProductSn(String str, AutelCommunityRequest.IAutelCommunityQuerySNStatusListener iAutelCommunityQuerySNStatusListener) {
        AutelCommunityRequest.instance().queryProductBindStatusByProductSn(str, iAutelCommunityQuerySNStatusListener);
    }

    public void doChangeCustomerAutelRoboticsID(String str, String str2, String str3, AutelCommunityRequest.IAutelChangeCustomerAutelRoboticsIDListener iAutelChangeCustomerAutelRoboticsIDListener) {
        AutelCommunityRequest.instance().changeCustomerAutelRoboticsID(str, str2, str3, iAutelChangeCustomerAutelRoboticsIDListener);
    }

    public void doRequestUploadUserPhoto(AutelCommunityInfo autelCommunityInfo, InputStream inputStream, AutelCommunityRequest.IAutelCommunityListener iAutelCommunityListener) {
        AutelCommunityRequest.instance().requestUploadUserPhoto(autelCommunityInfo, inputStream, iAutelCommunityListener);
    }

    public void doFetchUserInfo(AutelCommunityInfo autelCommunityInfo, AutelCommunityRequest.IAutelCommunityLoginListener iAutelCommunityLoginListener) {
        AutelCommunityRequest.instance().queryUserInfo(autelCommunityInfo, iAutelCommunityLoginListener);
    }

    public void doFetchFlightRecordInfo(AutelCommunityInfo autelCommunityInfo, CallbackWithOneParam<UserRecordInfo> callbackWithOneParam) {
        AutelCommunityRequest.instance().queryFlightRecordInfo(autelCommunityInfo, callbackWithOneParam);
    }

    public void doFetchNoFlyZone(long j, AutelCommunityRequest.IAutelCommunityNoFlyZoneListener iAutelCommunityNoFlyZoneListener) {
        AutelCommunityRequest.instance().doFetchNoFlyZone(j, iAutelCommunityNoFlyZoneListener);
    }
}

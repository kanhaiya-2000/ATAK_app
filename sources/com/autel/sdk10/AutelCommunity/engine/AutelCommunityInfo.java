package com.autel.sdk10.AutelCommunity.engine;

public class AutelCommunityInfo {
    private static AutelCommunityInfo s_instance;
    private String actCode;
    private String address;
    private String autelId;
    private String city;
    private String code;
    private String country;
    private String imageName;
    private String imageUrl;
    private String province;
    private String sex;
    private String userFirstName;
    private String userName;

    private AutelCommunityInfo() {
    }

    public static AutelCommunityInfo instance() {
        if (s_instance == null) {
            s_instance = new AutelCommunityInfo();
        }
        return s_instance;
    }

    public String getAutelId() {
        return this.autelId;
    }

    public void setAutelId(String str) {
        this.autelId = str;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public String getUserFirstName() {
        return this.userFirstName;
    }

    public void setUserFirstName(String str) {
        this.userFirstName = str;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public String getProvince() {
        return this.province;
    }

    public void setProvince(String str) {
        this.province = str;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String str) {
        this.sex = str;
    }

    public String getActCode() {
        return this.actCode;
    }

    public void setActCode(String str) {
        this.actCode = str;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public String getImageName() {
        return this.imageName;
    }

    public void setImageName(String str) {
        this.imageName = str;
    }
}

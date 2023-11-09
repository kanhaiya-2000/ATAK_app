package com.autel.AutelNet2.dsp.data;

public class UserInfo {
    private String password;
    private int role;
    private String user;

    public String getUser() {
        return this.user;
    }

    public void setUser(String str) {
        this.user = str;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public int getRole() {
        return this.role;
    }

    public void setRole(int i) {
        this.role = i;
    }
}

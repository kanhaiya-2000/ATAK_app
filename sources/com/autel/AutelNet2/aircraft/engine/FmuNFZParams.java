package com.autel.AutelNet2.aircraft.engine;

public class FmuNFZParams {
    private String country;
    private String digest;

    public FmuNFZParams(String str, String str2) {
        setCountry(str);
        setDigest(str2);
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public String getDigest() {
        return this.digest;
    }

    public void setDigest(String str) {
        this.digest = str;
    }
}

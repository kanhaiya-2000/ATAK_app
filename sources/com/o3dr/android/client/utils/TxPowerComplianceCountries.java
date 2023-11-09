package com.o3dr.android.client.utils;

public enum TxPowerComplianceCountries {
    AU("Australia"),
    FR("European Union"),
    JP("Japan"),
    US("United States");
    
    private String prettyName;

    private TxPowerComplianceCountries(String str) {
        this.prettyName = str;
    }

    public String getPrettyName() {
        return this.prettyName;
    }

    public static TxPowerComplianceCountries getDefaultCountry() {
        return US;
    }

    public static TxPowerComplianceCountries getDefaultEUCountry() {
        return FR;
    }
}

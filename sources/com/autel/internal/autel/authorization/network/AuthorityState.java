package com.autel.internal.autel.authorization.network;

public enum AuthorityState {
    DISABLE("disabled", -1),
    RESTRICTED("restricted", 0),
    NORMAL("normal", 1);
    
    int level;
    String value;

    private AuthorityState(String str, int i) {
        this.value = str;
        this.level = i;
    }

    public String value() {
        return this.value;
    }

    public static AuthorityState find(String str) {
        AuthorityState authorityState = DISABLE;
        if (authorityState.value.equals(str)) {
            return authorityState;
        }
        AuthorityState authorityState2 = RESTRICTED;
        if (authorityState2.value.equals(str)) {
            return authorityState2;
        }
        AuthorityState authorityState3 = NORMAL;
        return authorityState3.value.equals(str) ? authorityState3 : authorityState2;
    }

    public boolean levelLessThan(AuthorityState authorityState) {
        return authorityState == null || this.level < authorityState.level;
    }
}

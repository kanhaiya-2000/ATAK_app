package com.atakmap.android.uastool.generic;

import android.view.KeyEvent;
import com.google.gson.annotations.SerializedName;

public class KeyBind {
    @SerializedName("Function")
    private String function;
    @SerializedName("KeyCode")
    private int key;
    @SerializedName("Button")
    private String keyName;

    public KeyBind(int i, String str) {
        this.key = i;
        this.function = str;
        this.keyName = KeyEvent.keyCodeToString(i);
    }

    public KeyBind(String str, String str2) {
        this.keyName = str;
        this.function = str2;
        this.key = KeyEvent.keyCodeFromString(str);
    }

    public int getKey() {
        return this.key;
    }

    public void setKey(int i) {
        this.key = i;
    }

    public String getFunction() {
        return this.function;
    }

    public void setFunction(String str) {
        this.function = str;
    }

    public String getKeyName() {
        return this.keyName;
    }

    public void setKeyName(String str) {
        this.keyName = str;
    }

    public String toString() {
        return "KeyCode " + this.key + " KeyName " + this.keyName + " Function " + this.function;
    }
}

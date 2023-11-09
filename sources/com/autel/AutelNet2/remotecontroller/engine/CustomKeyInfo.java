package com.autel.AutelNet2.remotecontroller.engine;

import java.util.List;

public class CustomKeyInfo {
    private String method;
    private List<CusKey> result;
    private int status;

    public String getMethod() {
        return this.method;
    }

    public void setMethod(String str) {
        this.method = str;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public List<CusKey> getResult() {
        return this.result;
    }

    public void setResult(List<CusKey> list) {
        this.result = list;
    }

    public class CusKey {
        private int func;
        private String key;

        public CusKey() {
        }

        public String getKey() {
            return this.key;
        }

        public void setKey(String str) {
            this.key = str;
        }

        public int getFunc() {
            return this.func;
        }

        public void setFunc(int i) {
            this.func = i;
        }
    }
}

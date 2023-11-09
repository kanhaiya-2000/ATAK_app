package com.autel.sdk10.AutelCommunity.engine;

public class RecordResult {
    private int code;
    private DataBean data;

    public int getCode() {
        return this.code;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public DataBean getData() {
        return this.data;
    }

    public void setData(DataBean dataBean) {
        this.data = dataBean;
    }

    public static class DataBean {
        private UserRecordInfo UserRecordsInfo;
        private String action;
        private String msg;
        private String status;

        public String getAction() {
            return this.action;
        }

        public void setAction(String str) {
            this.action = str;
        }

        public String getStatus() {
            return this.status;
        }

        public void setStatus(String str) {
            this.status = str;
        }

        public String getMsg() {
            return this.msg;
        }

        public void setMsg(String str) {
            this.msg = str;
        }

        public UserRecordInfo getUserRecordsInfo() {
            return this.UserRecordsInfo;
        }

        public void setUserRecordsInfo(UserRecordInfo userRecordInfo) {
            this.UserRecordsInfo = userRecordInfo;
        }
    }
}

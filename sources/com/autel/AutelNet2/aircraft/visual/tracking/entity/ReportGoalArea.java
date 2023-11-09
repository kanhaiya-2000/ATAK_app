package com.autel.AutelNet2.aircraft.visual.tracking.entity;

import java.util.List;

public class ReportGoalArea {

    /* renamed from: id */
    private int f8435id;
    private String method;
    private ParamsBean params;

    public String getMethod() {
        return this.method;
    }

    public void setMethod(String str) {
        this.method = str;
    }

    public ParamsBean getParams() {
        return this.params;
    }

    public void setParams(ParamsBean paramsBean) {
        this.params = paramsBean;
    }

    public int getId() {
        return this.f8435id;
    }

    public void setId(int i) {
        this.f8435id = i;
    }

    public static class ParamsBean {
        private List<DetectionTargetArea> arealist;
        private int count;
        private int objId;
        private int resolution_height;
        private int resolution_width;
        private long timestamp;
        private int total;

        public int getObjId() {
            return this.objId;
        }

        public void setObjId(int i) {
            this.objId = i;
        }

        public int getResolution_width() {
            return this.resolution_width;
        }

        public void setResolution_width(int i) {
            this.resolution_width = i;
        }

        public int getResolution_height() {
            return this.resolution_height;
        }

        public void setResolution_height(int i) {
            this.resolution_height = i;
        }

        public int getCount() {
            return this.count;
        }

        public void setCount(int i) {
            this.count = i;
        }

        public int getTotal() {
            return this.total;
        }

        public void setTotal(int i) {
            this.total = i;
        }

        public long getTimestamp() {
            return this.timestamp;
        }

        public void setTimestamp(long j) {
            this.timestamp = j;
        }

        public List<DetectionTargetArea> getArealist() {
            return this.arealist;
        }

        public void setArealist(List<DetectionTargetArea> list) {
            this.arealist = list;
        }
    }
}

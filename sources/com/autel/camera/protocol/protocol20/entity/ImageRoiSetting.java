package com.autel.camera.protocol.protocol20.entity;

import java.util.List;

public class ImageRoiSetting {
    private List<RoiRegion> RoiRegion;
    private String Status;

    public class RoiRegion {
        private int Priority;
        private int RectHeight;
        private int RectWidth;
        private int RectX;
        private int RectY;
        private String Status;
        private int Strength;

        public RoiRegion() {
        }

        public String getStatus() {
            return this.Status;
        }

        public void setStatus(String str) {
            this.Status = str;
        }

        public int getPriority() {
            return this.Priority;
        }

        public void setPriority(int i) {
            this.Priority = i;
        }

        public int getStrength() {
            return this.Strength;
        }

        public void setStrength(int i) {
            this.Strength = i;
        }

        public int getRectX() {
            return this.RectX;
        }

        public void setRectX(int i) {
            this.RectX = i;
        }

        public int getRectY() {
            return this.RectY;
        }

        public void setRectY(int i) {
            this.RectY = i;
        }

        public int getRectWidth() {
            return this.RectWidth;
        }

        public void setRectWidth(int i) {
            this.RectWidth = i;
        }

        public int getRectHeight() {
            return this.RectHeight;
        }

        public void setRectHeight(int i) {
            this.RectHeight = i;
        }
    }

    public String getStatus() {
        return this.Status;
    }

    public void setStatus(String str) {
        this.Status = str;
    }

    public List<RoiRegion> getRoiRegion() {
        return this.RoiRegion;
    }

    public void setRoiRegion(List<RoiRegion> list) {
        this.RoiRegion = list;
    }
}

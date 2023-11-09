package com.autel.AutelNet2.aircraft.flycontroller.engine;

public class RtkIntenal {
    private int BeidouSta;
    private int CoordinateSys;
    private int FixSat;
    private int GalileoSta;
    private int GlonassSta;
    private int GpsSta;
    private double Hgt;
    private double HgtSigma;
    private int InPos;
    private double Lat;
    private double LatSigma;
    private int LocationType;
    private double Lon;
    private double LonSigma;
    private int PosType;
    private int RTKUsed;
    private int RecvDiffType;
    private int SVs;
    private int SolSta;
    private int SolnSVs;

    public int getSolSta() {
        return this.SolSta;
    }

    public void setSolSta(int i) {
        this.SolSta = i;
    }

    public int getPosType() {
        return this.PosType;
    }

    public void setPosType(int i) {
        this.PosType = i;
    }

    public double getLat() {
        return this.Lat;
    }

    public void setLat(double d) {
        this.Lat = d;
    }

    public double getLon() {
        return this.Lon;
    }

    public void setLon(double d) {
        this.Lon = d;
    }

    public double getHgt() {
        return this.Hgt;
    }

    public void setHgt(double d) {
        this.Hgt = d;
    }

    public double getLatSigma() {
        return this.LatSigma;
    }

    public void setLatSigma(double d) {
        this.LatSigma = d;
    }

    public double getLonSigma() {
        return this.LonSigma;
    }

    public void setLonSigma(double d) {
        this.LonSigma = d;
    }

    public double getHgtSigma() {
        return this.HgtSigma;
    }

    public void setHgtSigma(double d) {
        this.HgtSigma = d;
    }

    public int getSVs() {
        return this.SVs;
    }

    public void setSVs(int i) {
        this.SVs = i;
    }

    public int getSolnSVs() {
        return this.SolnSVs;
    }

    public void setSolnSVs(int i) {
        this.SolnSVs = i;
    }

    public int getGpsSta() {
        return this.GpsSta;
    }

    public void setGpsSta(int i) {
        this.GpsSta = i;
    }

    public int getBeidouSta() {
        return this.BeidouSta;
    }

    public void setBeidouSta(int i) {
        this.BeidouSta = i;
    }

    public int getGlonassSta() {
        return this.GlonassSta;
    }

    public void setGlonassSta(int i) {
        this.GlonassSta = i;
    }

    public int getGalileoSta() {
        return this.GalileoSta;
    }

    public void setGalileoSta(int i) {
        this.GalileoSta = i;
    }

    public int getInPos() {
        return this.InPos;
    }

    public void setInPos(int i) {
        this.InPos = i;
    }

    public int getRTKUsed() {
        return this.RTKUsed;
    }

    public void setRTKUsed(int i) {
        this.RTKUsed = i;
    }

    public int getFixSat() {
        return this.FixSat;
    }

    public void setFixSat(int i) {
        this.FixSat = i;
    }

    public int getLocationType() {
        return this.LocationType;
    }

    public void setLocationType(int i) {
        this.LocationType = i;
    }

    public int getRecvDiffType() {
        return this.RecvDiffType;
    }

    public void setRecvDiffType(int i) {
        this.RecvDiffType = i;
    }

    public int getCoordinateSys() {
        return this.CoordinateSys;
    }

    public void setCoordinateSys(int i) {
        this.CoordinateSys = i;
    }
}

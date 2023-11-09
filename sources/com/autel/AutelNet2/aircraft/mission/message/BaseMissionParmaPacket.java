package com.autel.AutelNet2.aircraft.mission.message;

import com.autel.AutelNet2.core.message.BaseMsgPacket;
import org.json.JSONException;
import org.json.JSONObject;

public class BaseMissionParmaPacket extends BaseMsgPacket {
    private static final String METHOD = "SetMission";
    public float alt;
    public int angler;
    public int eph;
    public int epv;
    public float lat;
    public float lon;
    public int vel;

    /* access modifiers changed from: protected */
    public void loadHead() {
    }

    public BaseMsgPacket parseBody() {
        return this;
    }

    /* access modifiers changed from: protected */
    public void parseData() {
    }

    /* access modifiers changed from: protected */
    public String loadBody() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("method", METHOD);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("Lat", (double) this.lat);
            jSONObject2.put("Lon", (double) this.lon);
            jSONObject2.put("Alt", (double) this.alt);
            jSONObject2.put("Eph", this.eph);
            jSONObject2.put("Epv", this.epv);
            jSONObject2.put("Angler", this.angler);
            jSONObject2.put("Vel", this.vel);
            jSONObject.put("params", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    /* access modifiers changed from: protected */
    public void setLat(float f) {
        this.lat = f;
    }

    /* access modifiers changed from: protected */
    public void setLon(float f) {
        this.lon = f;
    }

    /* access modifiers changed from: protected */
    public void setAlt(float f) {
        this.alt = f;
    }

    /* access modifiers changed from: protected */
    public void setEph(int i) {
        this.eph = i;
    }

    /* access modifiers changed from: protected */
    public void setEpv(int i) {
        this.epv = i;
    }

    /* access modifiers changed from: protected */
    public void setAngler(int i) {
        this.angler = i;
    }

    /* access modifiers changed from: protected */
    public void setVel(int i) {
        this.vel = i;
    }
}

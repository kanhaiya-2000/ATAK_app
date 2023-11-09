package com.atakmap.android.uastool.pagers.status;

import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.plugin.C1877R;

public class StatusMetaItem {
    private int color;
    private boolean isSelected;
    private final String label;
    private String meta;
    private final META_TYPE type;

    public enum META_TYPE {
        OPERATOR(C1877R.string.status_meta_operator),
        MODEL(C1877R.string.status_meta_model),
        LOCATION(C1877R.string.status_meta_location),
        ALTITUDE(C1877R.string.status_meta_altitude),
        HEADING(C1877R.string.status_meta_heading),
        SPEED(C1877R.string.status_meta_speed),
        BATTERY(C1877R.string.status_meta_battery),
        SIGNAL(C1877R.string.status_meta_signal),
        TGT_SRB(C1877R.string.status_meta_tgt_srb),
        UAS_RB(C1877R.string.status_meta_uas_rb),
        WIND(C1877R.string.status_meta_wind),
        TEMPERATURE(C1877R.string.status_meta_temperature),
        ERROR(C1877R.string.status_meta_error),
        UID(C1877R.string.status_meta_uid),
        PITCH(C1877R.string.status_meta_pitch);
        
        private final int stringId;

        private META_TYPE(int i) {
            this.stringId = i;
        }

        public String getLabel() {
            try {
                return UASToolDropDownReceiver.getInstance().getPluginContext().getResources().getString(this.stringId);
            } catch (Exception unused) {
                return "--";
            }
        }
    }

    public StatusMetaItem(META_TYPE meta_type, String str, String str2) {
        this.type = meta_type;
        this.label = str;
        this.meta = str2;
        this.color = -1;
        this.isSelected = false;
    }

    public StatusMetaItem(META_TYPE meta_type, String str) {
        this(meta_type, meta_type.getLabel(), str);
    }

    public META_TYPE getType() {
        return this.type;
    }

    public String getLabel() {
        return this.label;
    }

    public String getMeta() {
        return this.meta;
    }

    public void setMeta(String str) {
        this.meta = str;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public int getColor() {
        return this.color;
    }

    public void setColor(int i) {
        this.color = i;
    }

    public boolean isError() {
        return this.type.equals(META_TYPE.ERROR);
    }

    public String getSummary() {
        if (this.type.equals(META_TYPE.LOCATION) || this.type.equals(META_TYPE.MODEL)) {
            return this.meta;
        }
        return this.label + ": " + this.meta;
    }
}

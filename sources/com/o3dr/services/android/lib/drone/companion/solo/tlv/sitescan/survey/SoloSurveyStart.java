package com.o3dr.services.android.lib.drone.companion.solo.tlv.sitescan.survey;

import android.os.Parcel;
import android.os.Parcelable;
import com.o3dr.services.android.lib.drone.companion.solo.tlv.TLVMessageTypes;
import com.o3dr.services.android.lib.drone.companion.solo.tlv.TLVPacket;
import java.nio.ByteBuffer;

public class SoloSurveyStart extends TLVPacket {
    public static final Parcelable.Creator<SoloSurveyStart> CREATOR = new Parcelable.Creator<SoloSurveyStart>() {
        public SoloSurveyStart createFromParcel(Parcel parcel) {
            return new SoloSurveyStart(parcel);
        }

        public SoloSurveyStart[] newArray(int i) {
            return new SoloSurveyStart[i];
        }
    };

    /* access modifiers changed from: protected */
    public void getMessageValue(ByteBuffer byteBuffer) {
    }

    public SoloSurveyStart() {
        super(TLVMessageTypes.TYPE_SOLO_SURVEY_START, 0);
    }

    protected SoloSurveyStart(Parcel parcel) {
        super(parcel);
    }
}

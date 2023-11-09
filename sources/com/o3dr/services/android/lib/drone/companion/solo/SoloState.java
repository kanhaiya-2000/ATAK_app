package com.o3dr.services.android.lib.drone.companion.solo;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import com.o3dr.android.client.utils.TxPowerComplianceCountries;
import com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloButtonSetting;
import com.o3dr.services.android.lib.drone.companion.solo.tlv.TLVMessageParser;
import com.o3dr.services.android.lib.drone.companion.solo.tlv.TLVPacket;
import com.o3dr.services.android.lib.drone.property.DroneAttribute;
import java.nio.ByteBuffer;
import java.util.List;

public class SoloState implements DroneAttribute {
    public static final Parcelable.Creator<SoloState> CREATOR = new Parcelable.Creator<SoloState>() {
        public SoloState createFromParcel(Parcel parcel) {
            return new SoloState(parcel);
        }

        public SoloState[] newArray(int i) {
            return new SoloState[i];
        }
    };
    private String autopilotVersion;
    private SparseArray<SoloButtonSetting> buttonSettings;
    private String controllerFirmwareVersion;
    private int controllerMode;
    private String controllerUnit;
    private String controllerVersion;
    private String gimbalVersion;
    private String txPowerCompliantCountry;
    private String vehicleVersion;
    private String wifiPassword;
    private String wifiSsid;

    public int describeContents() {
        return 0;
    }

    public SoloState() {
    }

    public SoloState(String str, String str2, String str3, String str4, String str5, String str6, String str7, SparseArray<SoloButtonSetting> sparseArray, String str8, int i, String str9) {
        this.autopilotVersion = str;
        this.controllerFirmwareVersion = str2;
        this.controllerVersion = str3;
        this.vehicleVersion = str4;
        this.wifiPassword = str5;
        this.wifiSsid = str6;
        this.txPowerCompliantCountry = str7;
        this.buttonSettings = sparseArray;
        this.gimbalVersion = str8;
        this.controllerMode = i;
        this.controllerUnit = str9;
    }

    public String getAutopilotVersion() {
        return this.autopilotVersion;
    }

    public String getControllerFirmwareVersion() {
        return this.controllerFirmwareVersion;
    }

    public String getControllerVersion() {
        return this.controllerVersion;
    }

    public int getControllerMode() {
        return this.controllerMode;
    }

    public String getVehicleVersion() {
        return this.vehicleVersion;
    }

    public String getWifiPassword() {
        return this.wifiPassword;
    }

    public String getWifiSsid() {
        return this.wifiSsid;
    }

    private boolean isEUTxPowerCompliant() {
        return !TxPowerComplianceCountries.getDefaultCountry().name().equals(this.txPowerCompliantCountry);
    }

    public String getTxPowerCompliantCountry() {
        return this.txPowerCompliantCountry;
    }

    public SoloButtonSetting getButtonSetting(int i) {
        return this.buttonSettings.get(i);
    }

    public String getGimbalVersion() {
        return this.gimbalVersion;
    }

    public String getControllerUnit() {
        return this.controllerUnit;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.wifiSsid);
        parcel.writeString(this.wifiPassword);
        parcel.writeString(this.controllerVersion);
        parcel.writeString(this.controllerFirmwareVersion);
        parcel.writeString(this.vehicleVersion);
        parcel.writeString(this.autopilotVersion);
        parcel.writeByte(isEUTxPowerCompliant() ? (byte) 1 : 0);
        int size = this.buttonSettings.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            SoloButtonSetting valueAt = this.buttonSettings.valueAt(i2);
            if (valueAt == null) {
                parcel.writeInt(0);
            } else {
                byte[] bytes = valueAt.toBytes();
                parcel.writeInt(bytes.length);
                parcel.writeByteArray(bytes);
            }
        }
        parcel.writeString(this.gimbalVersion);
        parcel.writeInt(this.controllerMode);
        parcel.writeString(this.controllerUnit);
        parcel.writeString(this.txPowerCompliantCountry);
    }

    protected SoloState(Parcel parcel) {
        this.wifiSsid = parcel.readString();
        this.wifiPassword = parcel.readString();
        this.controllerVersion = parcel.readString();
        this.controllerFirmwareVersion = parcel.readString();
        this.vehicleVersion = parcel.readString();
        this.autopilotVersion = parcel.readString();
        parcel.readByte();
        int readInt = parcel.readInt();
        this.buttonSettings = new SparseArray<>(readInt);
        for (int i = 0; i < readInt; i++) {
            int readInt2 = parcel.readInt();
            if (readInt2 != 0) {
                ByteBuffer allocate = ByteBuffer.allocate(readInt2);
                parcel.readByteArray(allocate.array());
                List<TLVPacket> parseTLVPacket = TLVMessageParser.parseTLVPacket(allocate);
                if (!parseTLVPacket.isEmpty()) {
                    for (TLVPacket next : parseTLVPacket) {
                        if (next instanceof SoloButtonSetting) {
                            SoloButtonSetting soloButtonSetting = (SoloButtonSetting) next;
                            this.buttonSettings.put(soloButtonSetting.getButton(), soloButtonSetting);
                        }
                    }
                }
            }
        }
        this.gimbalVersion = parcel.readString();
        this.controllerMode = parcel.readInt();
        this.controllerUnit = parcel.readString();
        this.txPowerCompliantCountry = parcel.readString();
    }
}

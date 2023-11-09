package com.o3dr.android.client.apis.solo;

import android.os.Bundle;
import com.o3dr.android.client.Drone;
import com.o3dr.android.client.apis.Api;
import com.o3dr.android.client.utils.TxPowerComplianceCountries;
import com.o3dr.services.android.lib.drone.companion.solo.action.SoloConfigActions;
import com.o3dr.services.android.lib.drone.companion.solo.controller.SoloControllerUnits;
import com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloButtonSettingSetter;
import com.o3dr.services.android.lib.model.AbstractCommandListener;
import com.o3dr.services.android.lib.model.action.Action;
import java.util.concurrent.ConcurrentHashMap;

public class SoloConfigApi extends SoloApi {
    private static final Api.Builder<SoloConfigApi> apiBuilder = new Api.Builder<SoloConfigApi>() {
        public SoloConfigApi build(Drone drone) {
            return new SoloConfigApi(drone);
        }
    };
    private static final ConcurrentHashMap<Drone, SoloConfigApi> soloConfigApiCache = new ConcurrentHashMap<>();

    public static SoloConfigApi getApi(Drone drone) {
        return (SoloConfigApi) getApi(drone, soloConfigApiCache, apiBuilder);
    }

    protected SoloConfigApi(Drone drone) {
        super(drone);
    }

    public void updateWifiSettings(String str, String str2, AbstractCommandListener abstractCommandListener) {
        Bundle bundle = new Bundle();
        bundle.putString(SoloConfigActions.EXTRA_WIFI_SSID, str);
        bundle.putString(SoloConfigActions.EXTRA_WIFI_PASSWORD, str2);
        this.drone.performAsyncActionOnDroneThread(new Action(SoloConfigActions.ACTION_UPDATE_WIFI_SETTINGS, bundle), abstractCommandListener);
    }

    public void updateButtonSettings(SoloButtonSettingSetter soloButtonSettingSetter, AbstractCommandListener abstractCommandListener) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(SoloConfigActions.EXTRA_BUTTON_SETTINGS, soloButtonSettingSetter);
        this.drone.performAsyncActionOnDroneThread(new Action(SoloConfigActions.ACTION_UPDATE_BUTTON_SETTINGS, bundle), abstractCommandListener);
    }

    public void updateControllerMode(int i, AbstractCommandListener abstractCommandListener) {
        Bundle bundle = new Bundle();
        bundle.putInt(SoloConfigActions.EXTRA_CONTROLLER_MODE, i);
        this.drone.performAsyncActionOnDroneThread(new Action(SoloConfigActions.ACTION_UPDATE_CONTROLLER_MODE, bundle), abstractCommandListener);
    }

    public void updateTxPowerComplianceCountry(TxPowerComplianceCountries txPowerComplianceCountries, AbstractCommandListener abstractCommandListener) {
        Bundle bundle = new Bundle();
        bundle.putString(SoloConfigActions.EXTRA_TX_POWER_COMPLIANT_COUNTRY_CODE, txPowerComplianceCountries.name());
        this.drone.performAsyncActionOnDroneThread(new Action(SoloConfigActions.ACTION_UPDATE_TX_POWER_COMPLIANCE_COUNTRY, bundle), abstractCommandListener);
    }

    public void refreshSoloVersions() {
        this.drone.performAsyncActionOnDroneThread(new Action(SoloConfigActions.ACTION_REFRESH_SOLO_VERSIONS), (AbstractCommandListener) null);
    }

    public void updateControllerUnit(String str, final AbstractCommandListener abstractCommandListener) {
        if (!SoloControllerUnits.UNKNOWN.equals(str)) {
            Bundle bundle = new Bundle();
            bundle.putString(SoloConfigActions.EXTRA_CONTROLLER_UNIT, str);
            this.drone.performAsyncActionOnDroneThread(new Action(SoloConfigActions.ACTION_UPDATE_CONTROLLER_UNIT, bundle), abstractCommandListener);
        } else if (abstractCommandListener != null) {
            this.drone.post(new Runnable() {
                public void run() {
                    abstractCommandListener.onError(2);
                }
            });
        }
    }
}

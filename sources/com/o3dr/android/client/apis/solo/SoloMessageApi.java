package com.o3dr.android.client.apis.solo;

import com.o3dr.android.client.Drone;
import com.o3dr.android.client.apis.Api;
import com.o3dr.services.android.lib.drone.companion.solo.tlv.TLVPacket;
import com.o3dr.services.android.lib.model.AbstractCommandListener;
import java.util.concurrent.ConcurrentHashMap;

public class SoloMessageApi extends SoloApi {
    private static final Api.Builder<SoloMessageApi> apiBuilder = new Api.Builder<SoloMessageApi>() {
        public SoloMessageApi build(Drone drone) {
            return new SoloMessageApi(drone);
        }
    };
    private static final ConcurrentHashMap<Drone, SoloMessageApi> apiCache = new ConcurrentHashMap<>();

    public static SoloMessageApi getApi(Drone drone) {
        return (SoloMessageApi) getApi(drone, apiCache, apiBuilder);
    }

    protected SoloMessageApi(Drone drone) {
        super(drone);
    }

    public void sendMessage(TLVPacket tLVPacket, AbstractCommandListener abstractCommandListener) {
        super.sendMessage(tLVPacket, abstractCommandListener);
    }
}

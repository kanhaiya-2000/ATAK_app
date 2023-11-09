package com.atakmap.android.uastool.utils;

import atakplugin.UASTool.cpv;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.pagers.video_ui.ArOverlayView;
import com.atakmap.coremap.log.Log;
import com.atakmap.coremap.maps.conversion.EGM96;
import com.atakmap.coremap.maps.coords.GeoPoint;
import com.partech.mobilevid.f;
import com.partech.mobilevid.g;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;

public class AROverlayMuxCallback implements g {
    private static final String TAG = "AROverlayMuxCallback";
    private static final long nanoclock0 = (System.nanoTime() / 1000);
    private static final long posix0 = (System.currentTimeMillis() * 1000);
    private final ByteArrayOutputStream baos = new ByteArrayOutputStream();
    protected final UASItem defaultUASItem;
    private byte[] klvBuff = null;
    private int klvBuffLength = 0;
    private long lastTime = 0;

    public AROverlayMuxCallback(UASItem uASItem) {
        this.defaultUASItem = uASItem;
    }

    /* renamed from: a */
    public long mo10830a(long j, f fVar) {
        long j2;
        long j3 = j;
        f fVar2 = fVar;
        if (j3 - this.lastTime <= 400) {
            return -1;
        }
        try {
            ArOverlayView operatorArOverlay = UASToolDropDownReceiver.getInstance().getOperatorArOverlay();
            UASItem uASItem = this.defaultUASItem;
            if (uASItem != null) {
                if (operatorArOverlay != null) {
                    GeoPoint geoPoint = uASItem.getGeoPoint();
                    GeoPoint centerPoint = operatorArOverlay.getCenterPoint();
                    List<GeoPoint> fieldOfViewList = operatorArOverlay.getFieldOfViewList();
                    long nanoTime = ((System.nanoTime() / 1000) - nanoclock0) + posix0;
                    this.baos.reset();
                    DataOutputStream dataOutputStream = new DataOutputStream(this.baos);
                    int i = geoPoint != null ? 29 : 13;
                    if (this.defaultUASItem.getHFOV() != 0.0d) {
                        try {
                            if (this.defaultUASItem.getVFOV() != 0.0d) {
                                i = i + 4 + 4 + 4 + 4 + 6 + 6;
                            }
                        } catch (IOException e) {
                            e = e;
                            j2 = -1;
                            Log.e(TAG, "error", e);
                            return j2;
                        }
                    }
                    if (centerPoint != null) {
                        i = i + 6 + 6 + 4;
                    }
                    if (fieldOfViewList != null && fieldOfViewList.size() >= 4) {
                        i = i + 6 + 6 + 6 + 6 + 6 + 6 + 6 + 6;
                    }
                    dataOutputStream.write(cpv.f4797a, 0, cpv.f4797a.length);
                    dataOutputStream.write(i + 4);
                    dataOutputStream.write(cpv.f4818f);
                    dataOutputStream.write(8);
                    dataOutputStream.writeLong(nanoTime);
                    dataOutputStream.write(cpv.f4821i);
                    dataOutputStream.write(1);
                    dataOutputStream.write(13);
                    if (geoPoint != null) {
                        dataOutputStream.write(cpv.f4824l);
                        dataOutputStream.write(4);
                        dataOutputStream.writeInt(KLVUtils.convertLatitude(geoPoint.getLatitude()));
                        dataOutputStream.write(cpv.f4827o);
                        dataOutputStream.write(4);
                        dataOutputStream.writeInt(KLVUtils.convertLongitude(geoPoint.getLongitude()));
                        dataOutputStream.write(cpv.f4829q);
                        dataOutputStream.write(2);
                        dataOutputStream.writeShort(KLVUtils.convertAltitude(EGM96.getMSL(geoPoint)));
                    }
                    if (!(this.defaultUASItem.getHFOV() == 0.0d || this.defaultUASItem.getVFOV() == 0.0d)) {
                        dataOutputStream.write(cpv.f4835w);
                        dataOutputStream.write(2);
                        dataOutputStream.writeShort((short) KLVUtils.convertSensorAngle(this.defaultUASItem.getHFOV()));
                        dataOutputStream.write(cpv.f4837y);
                        dataOutputStream.write(2);
                        dataOutputStream.writeShort((short) KLVUtils.convertSensorAngle(this.defaultUASItem.getVFOV()));
                        dataOutputStream.write(cpv.f4831s);
                        dataOutputStream.write(2);
                        dataOutputStream.writeShort((short) KLVUtils.convertPlatformAzimuthAngle(this.defaultUASItem.getHeading()));
                        dataOutputStream.write(cpv.f4833u);
                        dataOutputStream.write(2);
                        dataOutputStream.writeShort(KLVUtils.convertPlatformElevationAngle(this.defaultUASItem.getPitch()));
                        dataOutputStream.write(cpv.f4771A);
                        dataOutputStream.write(4);
                        dataOutputStream.writeInt((int) KLVUtils.convertSensorRelativeAzimuth(this.defaultUASItem.getGimbalAngle() - this.defaultUASItem.getHeading()));
                        dataOutputStream.write(cpv.f4773C);
                        dataOutputStream.write(4);
                        dataOutputStream.writeInt(KLVUtils.convertSensorRelativeElevation(this.defaultUASItem.getGimbalPitch() - this.defaultUASItem.getPitch()));
                    }
                    if (centerPoint != null) {
                        dataOutputStream.write(cpv.f4777G);
                        dataOutputStream.write(4);
                        dataOutputStream.writeInt(KLVUtils.convertLatitude(centerPoint.getLatitude()));
                        dataOutputStream.write(cpv.f4780J);
                        dataOutputStream.write(4);
                        dataOutputStream.writeInt(KLVUtils.convertLongitude(centerPoint.getLongitude()));
                        dataOutputStream.write(cpv.f4784N);
                        dataOutputStream.write(2);
                        dataOutputStream.writeShort(KLVUtils.convertAltitude(EGM96.getMSL(centerPoint)));
                    }
                    if (fieldOfViewList != null && fieldOfViewList.size() >= 4) {
                        dataOutputStream.write(cpv.f4802ae);
                        dataOutputStream.write(4);
                        dataOutputStream.writeInt(KLVUtils.convertLatitude(fieldOfViewList.get(0).getLatitude()));
                        dataOutputStream.write(cpv.f4803af);
                        dataOutputStream.write(4);
                        dataOutputStream.writeInt(KLVUtils.convertLongitude(fieldOfViewList.get(0).getLongitude()));
                        dataOutputStream.write(cpv.f4804ag);
                        dataOutputStream.write(4);
                        dataOutputStream.writeInt(KLVUtils.convertLatitude(fieldOfViewList.get(1).getLatitude()));
                        dataOutputStream.write(cpv.f4805ah);
                        dataOutputStream.write(4);
                        dataOutputStream.writeInt(KLVUtils.convertLongitude(fieldOfViewList.get(1).getLongitude()));
                        dataOutputStream.write(cpv.f4806ai);
                        dataOutputStream.write(4);
                        dataOutputStream.writeInt(KLVUtils.convertLatitude(fieldOfViewList.get(2).getLatitude()));
                        dataOutputStream.write(cpv.f4807aj);
                        dataOutputStream.write(4);
                        dataOutputStream.writeInt(KLVUtils.convertLongitude(fieldOfViewList.get(2).getLongitude()));
                        dataOutputStream.write(cpv.f4808ak);
                        dataOutputStream.write(4);
                        dataOutputStream.writeInt(KLVUtils.convertLatitude(fieldOfViewList.get(3).getLatitude()));
                        dataOutputStream.write(cpv.f4809al);
                        dataOutputStream.write(4);
                        dataOutputStream.writeInt(KLVUtils.convertLongitude(fieldOfViewList.get(3).getLongitude()));
                    }
                    dataOutputStream.write(cpv.f4815c);
                    dataOutputStream.write(2);
                    dataOutputStream.flush();
                    if (fVar2 == null || this.klvBuffLength < this.baos.size()) {
                        this.klvBuff = new byte[(this.baos.size() + 2)];
                        this.klvBuffLength = this.baos.size() + 2;
                    }
                    dataOutputStream.writeShort(KLVUtils.calculateChecksum(this.baos.toByteArray(this.klvBuff), this.baos.size()));
                    dataOutputStream.flush();
                    if (fVar2 == null || this.klvBuffLength < this.baos.size()) {
                        this.klvBuff = new byte[this.baos.size()];
                        this.klvBuffLength = this.baos.size();
                    }
                    byte[] byteArray = this.baos.toByteArray(this.klvBuff);
                    if (fVar2 != null) {
                        fVar2.a = byteArray;
                        fVar2.b = this.baos.size();
                    }
                    this.lastTime = j3;
                    return j3 - 1;
                }
            }
            return -1;
        } catch (IOException e2) {
            e = e2;
            j2 = -1;
            Log.e(TAG, "error", e);
            return j2;
        }
    }
}

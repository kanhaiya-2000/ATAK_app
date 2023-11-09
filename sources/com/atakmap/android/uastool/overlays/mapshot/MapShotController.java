package com.atakmap.android.uastool.overlays.mapshot;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.atakmap.android.ipc.AtakBroadcast;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.maps.ae;
import com.atakmap.android.maps.af;
import com.atakmap.android.maps.ai;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.overlays.moasic.GLSurfaceLayer;
import com.atakmap.android.uastool.overlays.moasic.SurfaceLayer;
import com.atakmap.android.uastool.prefs.CameraPreferenceFragment;
import com.atakmap.android.uastool.utils.FieldOfView;
import com.atakmap.android.util.b;
import com.atakmap.coremap.filesystem.FileSystemUtils;
import com.atakmap.map.layer.Layer;
import com.atakmap.map.layer.opengl.GLLayerFactory;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class MapShotController extends BroadcastReceiver implements af.a {
    public static final String LAYER_DELETE = "com.atakmap.android.uastool.LAYER_DELETE";
    private static final String LAYER_LIMIT_MESSAGE = "Exceeded limit, removing oldest layer...";
    public static final String LAYER_VISIBILITY = "com.atakmap.android.uastool.LAYER_VISIBILITY";
    private static final String TAG = "MapShotController";
    public static final String UAS_GROUP_NAME = "UAS";
    private static final String UID_EXTRA_NAME = "uid";
    private static Queue<SurfaceLayer> layers;
    private static int maxLayers;

    public MapShotController() {
        maxLayers = UASToolDropDownReceiver.getSharedPrefs().getInt(CameraPreferenceFragment.PREF_CAMERA_MAX_OPEN_MAPSHOTS, 10);
        layers = new ArrayBlockingQueue(maxLayers, true);
    }

    public void onReceive(Context context, Intent intent) {
        SurfaceLayer containerLayerFromMetaShapeUID;
        String stringExtra;
        SurfaceLayer containerLayerFromMetaShapeUID2;
        String action = intent.getAction();
        action.hashCode();
        if (action.equals(LAYER_DELETE)) {
            String stringExtra2 = intent.getStringExtra("uid");
            if (stringExtra2 != null && (containerLayerFromMetaShapeUID = getContainerLayerFromMetaShapeUID(stringExtra2)) != null) {
                removeLayer(containerLayerFromMetaShapeUID);
            }
        } else if (action.equals(LAYER_VISIBILITY) && (stringExtra = intent.getStringExtra("uid")) != null && (containerLayerFromMetaShapeUID2 = getContainerLayerFromMetaShapeUID(stringExtra)) != null) {
            containerLayerFromMetaShapeUID2.setVisible(!containerLayerFromMetaShapeUID2.isVisible());
        }
    }

    private SurfaceLayer getContainerLayerFromMetaShapeUID(String str) {
        for (SurfaceLayer surfaceLayer : layers) {
            if (surfaceLayer.getMetaShape().getUID().equals(str)) {
                return surfaceLayer;
            }
        }
        return null;
    }

    public static void toggleOrWriteLayer(String str) {
        SurfaceLayer surfaceLayer;
        boolean z;
        if (str != null) {
            Iterator it = layers.iterator();
            while (true) {
                if (!it.hasNext()) {
                    surfaceLayer = null;
                    z = false;
                    break;
                }
                surfaceLayer = (SurfaceLayer) it.next();
                if (surfaceLayer.getName().equals(str)) {
                    surfaceLayer.setVisible(!surfaceLayer.isVisible());
                    z = true;
                    break;
                }
            }
            if (!z) {
                addLayer(str, true);
                surfaceLayer = getLayerFromQueue(str);
            }
            if (surfaceLayer != null && surfaceLayer.isVisible()) {
                b.b(surfaceLayer.getMetaShape());
            }
        }
    }

    private static SurfaceLayer getLayerFromImage(String str) {
        String str2;
        String str3;
        Bitmap decodeFile;
        SurfaceLayer surfaceLayer = null;
        try {
            File item = FileSystemUtils.getItem("attachments/" + str);
            File[] listFiles = item.isDirectory() ? item.listFiles() : null;
            if (listFiles != null) {
                if (listFiles.length != 0) {
                    str2 = UASToolDropDownReceiver.sanitizeForWinTAK(listFiles[listFiles.length - 1].getPath());
                    str3 = UASToolDropDownReceiver.sanitizeForWinTAK(listFiles[listFiles.length - 1].getName());
                    ExifInterface exifInterface = new ExifInterface(str2);
                    decodeFile = BitmapFactory.decodeFile(str2);
                    FieldOfView computeFOVFromEXIF = FieldOfView.computeFOVFromEXIF(exifInterface);
                    if (decodeFile == null || decodeFile.isRecycled() || computeFOVFromEXIF == null || !computeFOVFromEXIF.isValid()) {
                        return null;
                    }
                    SurfaceLayer surfaceLayer2 = new SurfaceLayer(UASToolDropDownReceiver.getInstance().getPluginContext(), computeFOVFromEXIF, str, decodeFile);
                    try {
                        String str4 = exifInterface.getAttribute("Model") + "\n" + str3.replaceAll("\\..*", "");
                        surfaceLayer2.setFriendlyName(str4);
                        surfaceLayer2.getMetaShape().setTitle(str4);
                        decodeFile.recycle();
                        return surfaceLayer2;
                    } catch (IOException e) {
                        e = e;
                        surfaceLayer = surfaceLayer2;
                        Log.d(TAG, "Unable to load bitmap or EXIF data", e);
                        return surfaceLayer;
                    }
                }
            }
            str3 = "";
            str2 = str3;
            ExifInterface exifInterface2 = new ExifInterface(str2);
            decodeFile = BitmapFactory.decodeFile(str2);
            FieldOfView computeFOVFromEXIF2 = FieldOfView.computeFOVFromEXIF(exifInterface2);
            return (decodeFile == null || decodeFile.isRecycled()) ? null : null;
        } catch (IOException e2) {
            e = e2;
            Log.d(TAG, "Unable to load bitmap or EXIF data", e);
            return surfaceLayer;
        }
    }

    private static void removeLayer(SurfaceLayer surfaceLayer) {
        MapView.getMapView().b(MapView.a.c, surfaceLayer);
        AtakBroadcast.a().a(new Intent("com.atakmap.android.maps.REFRESH_HIERARCHY"));
        surfaceLayer.setVisible(false);
        layers.remove(surfaceLayer);
    }

    public static Layer getLayerFromMapView(String str) {
        Layer layer = null;
        for (Layer layer2 : MapView.getMapView().c(MapView.a.c)) {
            if (layer2.getName().equals(str)) {
                layer = layer2;
            }
        }
        return layer;
    }

    public static Layer getLayerFromQueue(String str) {
        for (SurfaceLayer surfaceLayer : layers) {
            if (surfaceLayer.getName().equals(str)) {
                return surfaceLayer;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static void addLayer(String str, boolean z) {
        SurfaceLayer peek;
        if (str != null) {
            SurfaceLayer layerFromImage = getLayerFromImage(str);
            if (layerFromImage != null) {
                if (layers.size() >= maxLayers && (peek = layers.peek()) != null) {
                    if (peek.isVisible()) {
                        UASToolDropDownReceiver.toast(LAYER_LIMIT_MESSAGE, 0);
                    }
                    removeLayer(peek);
                }
                boolean z2 = true;
                Iterator it = layers.iterator();
                while (it.hasNext()) {
                    if (((Layer) it.next()).getName().equals(layerFromImage.getName())) {
                        z2 = false;
                    }
                }
                if (z2) {
                    GLLayerFactory.a(GLSurfaceLayer.SPI);
                    MapView.getMapView().a(MapView.a.c, layerFromImage);
                    AtakBroadcast.a().a(new Intent("com.atakmap.android.maps.REFRESH_HIERARCHY"));
                    layerFromImage.setVisible(z);
                    layers.offer(layerFromImage);
                }
            } else if (z) {
                UASToolDropDownReceiver.toast("Insufficient or invalid data to create mapshot overlay...", 0);
            }
        }
    }

    public void onMapEvent(ae aeVar) {
        SurfaceLayer layerFromQueue;
        final ai b = aeVar.b();
        if (b != null && b.getType().equals("b-i-x-i")) {
            String a = aeVar.a();
            a.hashCode();
            if (a.equals("item_added")) {
                if (layers.size() < maxLayers) {
                    Log.d(TAG, "adding layer map event");
                }
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public void run() {
                        MapShotController.addLayer(b.getUID(), false);
                    }
                });
            } else if (a.equals("item_removed") && (layerFromQueue = getLayerFromQueue(b.getUID())) != null) {
                Log.d(TAG, "removing layer map event");
                removeLayer(layerFromQueue);
            }
        }
    }
}

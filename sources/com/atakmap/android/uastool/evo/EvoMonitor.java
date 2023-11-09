package com.atakmap.android.uastool.evo;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.generic.IAircraftItem;
import com.atakmap.android.uastool.plugin.PlatformMonitor;
import com.atakmap.coremap.log.Log;
import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.CallbackWithTwoParams;
import com.autel.common.battery.evo.EvoBatteryInfo;
import com.autel.common.camera.CameraProduct;
import com.autel.common.camera.XT706.DisplayMode;
import com.autel.common.camera.XT706.IrColor;
import com.autel.common.camera.media.CameraAperture;
import com.autel.common.camera.media.PhotoAspectRatio;
import com.autel.common.error.AutelError;
import com.autel.common.flycontroller.evo.EvoAttitudeInfo;
import com.autel.common.flycontroller.evo.EvoFlyControllerInfo;
import com.autel.common.flycontroller.evo.EvoGpsInfo;
import com.autel.common.flycontroller.evo.LocalCoordinateInfo;
import com.autel.common.gimbal.evo.EvoAngleInfo;
import com.autel.common.remotecontroller.RemoteControllerInfo;
import com.autel.internal.camera.xbbasic.xt701.CameraXT701InitializeProxy;
import com.autel.internal.camera.xbbasic.xt705.CameraXT705InitializeProxy;
import com.autel.internal.camera.xbbasic.xt706.CameraXT706InitializeProxy;
import com.autel.sdk.Autel;
import com.autel.sdk.AutelSdkConfig;
import com.autel.sdk.ProductConnectListener;
import com.autel.sdk.camera.AutelBaseCamera;
import com.autel.sdk.flycontroller.Evo2FlyController;
import com.autel.sdk.gimbal.EvoGimbal;
import com.autel.sdk.product.BaseProduct;
import com.autel.sdk.product.Evo2Aircraft;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

public class EvoMonitor extends PlatformMonitor {
    public static final String ACTION_IR_PALETTE = "SET_IR_PALETTE";
    /* access modifiers changed from: private */
    public static final String TAG = "EvoMonitor";
    public static IAircraftItem aci = new IAircraftItem();
    /* access modifiers changed from: private */
    public static AutelBaseCamera autelBaseCamera;
    /* access modifiers changed from: private */
    public static AtomicReference<CameraProduct> cameraProduct = new AtomicReference<>((Object) null);
    public static Evo2Aircraft evoAircraft;
    /* access modifiers changed from: private */
    public static boolean mConnected;
    static boolean runOnce = true;
    private final List<UASItem> uasList = new ArrayList();

    public static double getCurrentZoomLevel() {
        return 0.0d;
    }

    public static double getMaxZoomLevel() {
        return 100.0d;
    }

    public static double getMinZoomLevel() {
        return 0.0d;
    }

    public void setCaptureToStorage(boolean z) {
    }

    public EvoMonitor(Context context) {
        super(context, EvoUASItem.DISPLAY_NAME);
    }

    public boolean monitors(String str) {
        return str.equals(EvoUASItem.DISPLAY_NAME);
    }

    public List<UASItem> getDetectedUasList() {
        String str = "UAS-" + UASToolDropDownReceiver.getInstance().getMapView().getDeviceCallsign();
        if (!mConnected) {
            this.uasList.clear();
            return this.uasList;
        }
        this.uasList.add(new EvoUASItem(str, str, false));
        return this.uasList;
    }

    public void beginMonitoring(boolean z) {
        super.beginMonitoring(z);
        if (runOnce) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MapView.getMapView().getContext());
            builder.setTitle("Evo Platform Warning").setCancelable(false).setMessage("Warning: Evo2 integration is experimental. Some features are not yet implemented. Some may cause erratic behavior.\n\nPlease fly with caution and test functionality in a controlled environment.").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            builder.create().show();
            runOnce = false;
        }
        Autel.init(MapView.getMapView().getContext(), new AutelSdkConfig.AutelSdkConfigBuilder().setAppKey("fb24ccaa2b0b6e733d653661415c92fb").setPostOnUi(true).create(), (CallbackWithNoParam) new CallbackWithNoParam() {
            public void onSuccess() {
                Log.v(EvoMonitor.TAG, "checkAppKeyValidate onSuccess");
            }

            public void onFailure(AutelError autelError) {
                String access$000 = EvoMonitor.TAG;
                Log.v(access$000, "checkAppKeyValidate " + autelError.getDescription());
            }
        });
        Autel.setProductConnectListener(new ProductConnectListener() {
            public void productConnected(BaseProduct baseProduct) {
                String access$000 = EvoMonitor.TAG;
                Log.d(access$000, "Product connected: " + baseProduct.getType().toString());
                int i = C146319.$SwitchMap$com$autel$common$product$AutelProductType[baseProduct.getType().ordinal()];
                if (i == 1 || i == 2 || i == 3) {
                    Log.d(EvoMonitor.TAG, baseProduct.getType().name());
                    UASToolDropDownReceiver.toast(baseProduct.getType().name() + " is not Supported");
                } else if (i == 4) {
                    Log.d(EvoMonitor.TAG, "EVO2");
                    boolean unused = EvoMonitor.mConnected = true;
                    EvoMonitor.onProductConnected((Evo2Aircraft) baseProduct);
                }
            }

            public void productDisconnected() {
                boolean unused = EvoMonitor.mConnected = false;
            }
        });
    }

    public void endMonitoring() {
        this.uasList.clear();
        Autel.destroy();
        super.endMonitoring();
    }

    /* access modifiers changed from: private */
    public static void onProductConnected(Evo2Aircraft evo2Aircraft) {
        evoAircraft = evo2Aircraft;
        aci.UID = UUID.randomUUID().toString();
        IAircraftItem iAircraftItem = aci;
        iAircraftItem.callsign = "UAS-" + UASToolDropDownReceiver.getInstance().getMapView().getDeviceCallsign();
        Evo2FlyController flyController = evoAircraft.getFlyController();
        Log.d(TAG, "Registering controllerListener");
        flyController.setFlyControllerInfoListener(new CallbackWithOneParam<EvoFlyControllerInfo>() {
            public void onSuccess(EvoFlyControllerInfo evoFlyControllerInfo) {
                EvoGpsInfo gpsInfo = evoFlyControllerInfo.getGpsInfo();
                EvoMonitor.aci.hasGPS = evoFlyControllerInfo.getFlyControllerStatus().isGpsValid();
                EvoMonitor.aci.aclat = gpsInfo.getLatitude();
                EvoMonitor.aci.aclon = gpsInfo.getLongitude();
                EvoMonitor.aci.acalt = gpsInfo.getAltitude();
                if (gpsInfo.getFixType() > 1) {
                    EvoMonitor.aci.hasGPS = true;
                    EvoMonitor.aci.acce = (double) gpsInfo.getFixType();
                    EvoMonitor.aci.acle = (double) gpsInfo.getFixType();
                } else {
                    EvoMonitor.aci.hasGPS = false;
                    EvoMonitor.aci.acce = Double.NaN;
                    EvoMonitor.aci.acle = Double.NaN;
                }
                LocalCoordinateInfo localCoordinateInfo = evoFlyControllerInfo.getLocalCoordinateInfo();
                EvoMonitor.aci.homelat = localCoordinateInfo.getHomeLatitude();
                EvoMonitor.aci.homelon = localCoordinateInfo.getHomeLongitude();
                EvoMonitor.aci.homealt = localCoordinateInfo.getHomeAltitude();
                EvoMonitor.aci.speed = (double) localCoordinateInfo.getSpeed();
                EvoMonitor.aci.achal = (double) (localCoordinateInfo.getAltitude() * -1.0f);
                EvoAttitudeInfo attitudeInfo = evoFlyControllerInfo.getAttitudeInfo();
                EvoMonitor.aci.attitudePitch = attitudeInfo.getPitch();
                EvoMonitor.aci.attitudeRoll = attitudeInfo.getRoll();
                double yaw = attitudeInfo.getYaw();
                if (yaw < 0.0d) {
                    yaw += 360.0d;
                }
                EvoMonitor.aci.attitudeYaw = yaw;
                EvoMonitor.aci.acheading = yaw;
            }

            public void onFailure(AutelError autelError) {
                Log.e(EvoMonitor.TAG, autelError.getDescription());
            }
        });
        evoAircraft.getGimbal().setAngleListener(new CallbackWithOneParam<EvoAngleInfo>() {
            public void onFailure(AutelError autelError) {
                Log.e(EvoMonitor.TAG, autelError.getDescription());
            }

            public void onSuccess(EvoAngleInfo evoAngleInfo) {
                EvoMonitor.aci.sensorAzimuth = (double) evoAngleInfo.getYaw();
                EvoMonitor.aci.sensorNorth = (double) evoAngleInfo.getYaw();
                EvoMonitor.aci.sensorRoll = (double) evoAngleInfo.getRoll();
                EvoMonitor.aci.sensorElevation = (double) (evoAngleInfo.getPitch() * -1.0f);
                if (EvoMonitor.cameraProduct.get() == CameraProduct.XT706) {
                    ((CameraXT706InitializeProxy) EvoMonitor.autelBaseCamera).getDigitalZoomScale(new CallbackWithOneParam<Integer>() {
                        public void onFailure(AutelError autelError) {
                        }

                        public void onSuccess(Integer num) {
                            if (num.intValue() >= 200) {
                                EvoMonitor.aci.sensorHFOV = 31.0d;
                                EvoMonitor.aci.sensorVFOV = 18.0d;
                            } else if (num.intValue() >= 175) {
                                EvoMonitor.aci.sensorHFOV = 35.0d;
                                EvoMonitor.aci.sensorVFOV = 21.0d;
                            } else if (num.intValue() >= 150) {
                                EvoMonitor.aci.sensorHFOV = 41.0d;
                                EvoMonitor.aci.sensorVFOV = 23.0d;
                            } else if (num.intValue() >= 125) {
                                EvoMonitor.aci.sensorHFOV = 47.0d;
                                EvoMonitor.aci.sensorVFOV = 28.0d;
                            } else {
                                EvoMonitor.aci.sensorHFOV = 65.0d;
                                EvoMonitor.aci.sensorVFOV = 39.0d;
                            }
                        }
                    });
                } else if (EvoMonitor.cameraProduct.get() == CameraProduct.XT705) {
                    ((CameraXT705InitializeProxy) EvoMonitor.autelBaseCamera).getDigitalZoomScale(new CallbackWithOneParam<Integer>() {
                        public void onFailure(AutelError autelError) {
                        }

                        public void onSuccess(Integer num) {
                            if (num.intValue() >= 200) {
                                EvoMonitor.aci.sensorHFOV = 31.0d;
                                EvoMonitor.aci.sensorVFOV = 18.0d;
                            } else if (num.intValue() >= 175) {
                                EvoMonitor.aci.sensorHFOV = 35.0d;
                                EvoMonitor.aci.sensorVFOV = 21.0d;
                            } else if (num.intValue() >= 150) {
                                EvoMonitor.aci.sensorHFOV = 41.0d;
                                EvoMonitor.aci.sensorVFOV = 23.0d;
                            } else if (num.intValue() >= 125) {
                                EvoMonitor.aci.sensorHFOV = 47.0d;
                                EvoMonitor.aci.sensorVFOV = 28.0d;
                            } else {
                                EvoMonitor.aci.sensorHFOV = 65.0d;
                                EvoMonitor.aci.sensorVFOV = 39.0d;
                            }
                        }
                    });
                } else if (EvoMonitor.cameraProduct.get() == CameraProduct.XT701) {
                    ((CameraXT701InitializeProxy) EvoMonitor.autelBaseCamera).getDigitalZoomScale(new CallbackWithOneParam<Integer>() {
                        public void onFailure(AutelError autelError) {
                        }

                        public void onSuccess(Integer num) {
                            if (num.intValue() >= 200) {
                                EvoMonitor.aci.sensorHFOV = 31.0d;
                                EvoMonitor.aci.sensorVFOV = 18.0d;
                            } else if (num.intValue() >= 175) {
                                EvoMonitor.aci.sensorHFOV = 35.0d;
                                EvoMonitor.aci.sensorVFOV = 21.0d;
                            } else if (num.intValue() >= 150) {
                                EvoMonitor.aci.sensorHFOV = 41.0d;
                                EvoMonitor.aci.sensorVFOV = 23.0d;
                            } else if (num.intValue() >= 125) {
                                EvoMonitor.aci.sensorHFOV = 47.0d;
                                EvoMonitor.aci.sensorVFOV = 28.0d;
                            } else {
                                EvoMonitor.aci.sensorHFOV = 65.0d;
                                EvoMonitor.aci.sensorVFOV = 39.0d;
                            }
                        }
                    });
                }
            }
        });
        evoAircraft.getBattery().setBatteryStateListener(new CallbackWithOneParam<EvoBatteryInfo>() {
            public void onSuccess(EvoBatteryInfo evoBatteryInfo) {
                EvoMonitor.aci.battRem = evoBatteryInfo.getRemainingPercent();
                EvoMonitor.aci.battMax = 100;
                int i = 0;
                for (int i2 : evoBatteryInfo.getVoltageCells()) {
                    i += i2;
                }
                EvoMonitor.aci.battVolt = (double) (i / 1000);
            }

            public void onFailure(AutelError autelError) {
                Log.e(EvoMonitor.TAG, autelError.getDescription());
            }
        });
        evoAircraft.getRemoteController().setInfoDataListener(new CallbackWithOneParam<RemoteControllerInfo>() {
            public void onFailure(AutelError autelError) {
            }

            public void onSuccess(RemoteControllerInfo remoteControllerInfo) {
                EvoMonitor.aci.signalQuality = remoteControllerInfo.getControllerSignalPercentage();
            }
        });
        evoAircraft.getCameraManager().setCameraChangeListener(new CallbackWithTwoParams<CameraProduct, AutelBaseCamera>() {
            public void onFailure(AutelError autelError) {
            }

            public void onSuccess(CameraProduct cameraProduct, AutelBaseCamera autelBaseCamera) {
                AutelBaseCamera unused = EvoMonitor.autelBaseCamera = autelBaseCamera;
                EvoMonitor.cameraProduct.set(cameraProduct);
                if (cameraProduct == CameraProduct.XT706 || cameraProduct == CameraProduct.XT705) {
                    EvoMonitor.aci.getThermal = true;
                } else {
                    EvoMonitor.aci.getThermal = false;
                }
                EvoMonitor.aci.sensorModel = cameraProduct.getValue();
            }
        });
    }

    public static void switchToNextCamera() {
        String str = TAG;
        Log.d(str, "switchToNextCamera()");
        if (cameraProduct.get() != CameraProduct.XT706) {
            Log.e(str, "Cannot change camera of " + autelBaseCamera.getProduct());
            return;
        }
        final CameraXT706InitializeProxy cameraXT706InitializeProxy = (CameraXT706InitializeProxy) autelBaseCamera;
        cameraXT706InitializeProxy.getDisplayMode(new CallbackWithOneParam<DisplayMode>() {
            public void onFailure(AutelError autelError) {
            }

            public void onSuccess(DisplayMode displayMode) {
                DisplayMode displayMode2;
                int i = C146319.$SwitchMap$com$autel$common$camera$XT706$DisplayMode[displayMode.ordinal()];
                if (i == 1) {
                    displayMode2 = DisplayMode.OVERLAP;
                } else if (i == 2) {
                    displayMode2 = DisplayMode.PICTURE_IN_PICTURE;
                } else if (i != 3) {
                    displayMode2 = DisplayMode.VISIBLE;
                } else {
                    displayMode2 = DisplayMode.IR;
                }
                CameraXT706InitializeProxy.this.setDisplayMode(displayMode2, new CallbackWithNoParam() {
                    public void onFailure(AutelError autelError) {
                        String access$000 = EvoMonitor.TAG;
                        Log.e(access$000, "setDisplayMode.onFailure() " + autelError.getDescription());
                    }

                    public void onSuccess() {
                        Log.d(EvoMonitor.TAG, "setDisplayMode.onSuccess()");
                    }
                });
            }
        });
    }

    /* renamed from: com.atakmap.android.uastool.evo.EvoMonitor$19 */
    /* synthetic */ class C146319 {
        static final /* synthetic */ int[] $SwitchMap$com$autel$common$camera$XT706$DisplayMode;
        static final /* synthetic */ int[] $SwitchMap$com$autel$common$product$AutelProductType;

        /* JADX WARNING: Can't wrap try/catch for region: R(21:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|17|19|20|21|22|23|24|25|26|28) */
        /* JADX WARNING: Can't wrap try/catch for region: R(23:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|16|17|19|20|21|22|23|24|25|26|28) */
        /* JADX WARNING: Can't wrap try/catch for region: R(24:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|19|20|21|22|23|24|25|26|28) */
        /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0059 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0063 */
        static {
            /*
                com.autel.common.camera.XT706.DisplayMode[] r0 = com.autel.common.camera.XT706.DisplayMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$autel$common$camera$XT706$DisplayMode = r0
                r1 = 1
                com.autel.common.camera.XT706.DisplayMode r2 = com.autel.common.camera.XT706.DisplayMode.IR     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$com$autel$common$camera$XT706$DisplayMode     // Catch:{ NoSuchFieldError -> 0x001d }
                com.autel.common.camera.XT706.DisplayMode r3 = com.autel.common.camera.XT706.DisplayMode.OVERLAP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$com$autel$common$camera$XT706$DisplayMode     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.autel.common.camera.XT706.DisplayMode r4 = com.autel.common.camera.XT706.DisplayMode.VISIBLE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = $SwitchMap$com$autel$common$camera$XT706$DisplayMode     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.autel.common.camera.XT706.DisplayMode r5 = com.autel.common.camera.XT706.DisplayMode.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r4 = $SwitchMap$com$autel$common$camera$XT706$DisplayMode     // Catch:{ NoSuchFieldError -> 0x003e }
                com.autel.common.camera.XT706.DisplayMode r5 = com.autel.common.camera.XT706.DisplayMode.PICTURE_IN_PICTURE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r6 = 5
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                com.autel.common.product.AutelProductType[] r4 = com.autel.common.product.AutelProductType.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                $SwitchMap$com$autel$common$product$AutelProductType = r4
                com.autel.common.product.AutelProductType r5 = com.autel.common.product.AutelProductType.X_STAR     // Catch:{ NoSuchFieldError -> 0x004f }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x004f }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x004f }
            L_0x004f:
                int[] r1 = $SwitchMap$com$autel$common$product$AutelProductType     // Catch:{ NoSuchFieldError -> 0x0059 }
                com.autel.common.product.AutelProductType r4 = com.autel.common.product.AutelProductType.PREMIUM     // Catch:{ NoSuchFieldError -> 0x0059 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0059 }
                r1[r4] = r0     // Catch:{ NoSuchFieldError -> 0x0059 }
            L_0x0059:
                int[] r0 = $SwitchMap$com$autel$common$product$AutelProductType     // Catch:{ NoSuchFieldError -> 0x0063 }
                com.autel.common.product.AutelProductType r1 = com.autel.common.product.AutelProductType.EVO     // Catch:{ NoSuchFieldError -> 0x0063 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0063 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0063 }
            L_0x0063:
                int[] r0 = $SwitchMap$com$autel$common$product$AutelProductType     // Catch:{ NoSuchFieldError -> 0x006d }
                com.autel.common.product.AutelProductType r1 = com.autel.common.product.AutelProductType.EVO_2     // Catch:{ NoSuchFieldError -> 0x006d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006d }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x006d }
            L_0x006d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.evo.EvoMonitor.C146319.<clinit>():void");
        }
    }

    public static String getAttribute(String str) {
        if (str.equals("IR_PALETTE")) {
            return getIRColorMode().value();
        }
        if (str.equals("ASPECT_RATIO")) {
            String str2 = TAG;
            Log.d(str2, "Aspect: " + cameraProduct.get().getValue());
            return getAspectRatio().value(cameraProduct.get());
        } else if (!str.equals("CAMERA_APERTURE")) {
            return null;
        } else {
            Log.d(TAG, "aspect camera aperture: ");
            return getCameraAperture().getValue();
        }
    }

    public static IrColor getIRColorMode() {
        final Object obj = new Object();
        final AtomicReference atomicReference = new AtomicReference(IrColor.UNKNOWN);
        if (cameraProduct.get() != CameraProduct.XT706) {
            String str = TAG;
            Log.e(str, "Cannot get Color Mode of " + autelBaseCamera.getProduct());
            return IrColor.UNKNOWN;
        }
        new Thread(new Runnable() {
            public void run() {
                ((CameraXT706InitializeProxy) EvoMonitor.autelBaseCamera).getIrColor(new CallbackWithOneParam<IrColor>() {
                    public void onFailure(AutelError autelError) {
                        UASToolDropDownReceiver.toast("Failed To retrieve IR Mode");
                        synchronized (obj) {
                            obj.notify();
                        }
                    }

                    public void onSuccess(IrColor irColor) {
                        atomicReference.set(irColor);
                        synchronized (obj) {
                            obj.notify();
                        }
                    }
                });
            }
        }).start();
        try {
            synchronized (obj) {
                obj.wait();
            }
        } catch (Exception unused) {
            Log.e(TAG, "Error");
        }
        return (IrColor) atomicReference.get();
    }

    public static PhotoAspectRatio getAspectRatio() {
        final Object obj = new Object();
        final AtomicReference atomicReference = new AtomicReference(PhotoAspectRatio.UNKNOWN);
        String str = TAG;
        Log.d(str, "Creating New Thread");
        new Thread(new Runnable() {
            public void run() {
                Log.d(EvoMonitor.TAG, "Thread Running");
                C14551 r0 = new CallbackWithOneParam<PhotoAspectRatio>() {
                    public void onFailure(AutelError autelError) {
                        UASToolDropDownReceiver.toast("Failed To retrieve aspect ratio");
                        Log.d(EvoMonitor.TAG, "getAspectRatio() failure ");
                        synchronized (obj) {
                            obj.notifyAll();
                        }
                    }

                    public void onSuccess(PhotoAspectRatio photoAspectRatio) {
                        String access$000 = EvoMonitor.TAG;
                        Log.d(access$000, "getAspectRatio() success " + photoAspectRatio.value((CameraProduct) EvoMonitor.cameraProduct.get()));
                        atomicReference.set(photoAspectRatio);
                        synchronized (obj) {
                            obj.notifyAll();
                        }
                    }
                };
                if (EvoMonitor.cameraProduct.get() == CameraProduct.XT706) {
                    ((CameraXT706InitializeProxy) EvoMonitor.autelBaseCamera).getAspectRatio(r0);
                } else if (EvoMonitor.cameraProduct.get() == CameraProduct.XT705) {
                    ((CameraXT705InitializeProxy) EvoMonitor.autelBaseCamera).getAspectRatio(r0);
                } else if (EvoMonitor.cameraProduct.get() == CameraProduct.XT701) {
                    Log.d(EvoMonitor.TAG, "701 Request");
                    ((CameraXT701InitializeProxy) EvoMonitor.autelBaseCamera).getAspectRatio(r0);
                } else {
                    synchronized (obj) {
                        Log.d(EvoMonitor.TAG, "Unknown Camera");
                        obj.notifyAll();
                    }
                }
            }
        }).start();
        Log.d(str, "Thread started");
        try {
            synchronized (obj) {
                Log.d(str, "Waiting");
                obj.wait();
            }
        } catch (Exception unused) {
            Log.e(TAG, "Error");
        }
        return (PhotoAspectRatio) atomicReference.get();
    }

    public static CameraAperture getCameraAperture() {
        final AtomicReference atomicReference = new AtomicReference(CameraAperture.UNKNOWN);
        new CallbackWithOneParam<CameraAperture>() {
            public void onFailure(AutelError autelError) {
                UASToolDropDownReceiver.toast("Failed To retrieve aspect ratio");
                Log.d(EvoMonitor.TAG, "Aperture() failure ");
            }

            public void onSuccess(CameraAperture cameraAperture) {
                atomicReference.set(cameraAperture);
                String access$000 = EvoMonitor.TAG;
                Log.d(access$000, "Aperture() success " + cameraAperture.getValue());
            }
        };
        new Thread(new Runnable() {
            public void run() {
            }
        }).start();
        return (CameraAperture) atomicReference.get();
    }

    public static void resetGimbal() {
        EvoGimbal gimbal;
        Log.d(TAG, "resetGimbal()");
        Evo2Aircraft evo2Aircraft = evoAircraft;
        if (evo2Aircraft != null && (gimbal = evo2Aircraft.getGimbal()) != null) {
            gimbal.setGimbalAngle(0.0f, (float) aci.sensorAzimuth, 0.0f);
            doZoom(-100);
        }
    }

    public static void pitchYawGimbal(double d, double d2) {
        EvoGimbal gimbal;
        String str = TAG;
        Log.d(str, "yawGimbal()" + d2);
        Evo2Aircraft evo2Aircraft = evoAircraft;
        if (evo2Aircraft != null && (gimbal = evo2Aircraft.getGimbal()) != null) {
            gimbal.setGimbalAngle((float) (d * -1.0d), (float) d2, 0.0f);
        }
    }

    public static void pitchGimbal(double d) {
        EvoGimbal gimbal;
        String str = TAG;
        Log.d(str, "pitchGimbal()" + d);
        Evo2Aircraft evo2Aircraft = evoAircraft;
        if (evo2Aircraft != null && (gimbal = evo2Aircraft.getGimbal()) != null) {
            gimbal.setGimbalAngle((float) d, (float) aci.sensorAzimuth, 0.0f);
        }
    }

    public static void yawGimbal(double d) {
        EvoGimbal gimbal;
        String str = TAG;
        Log.d(str, "yawGimbal()" + d);
        Evo2Aircraft evo2Aircraft = evoAircraft;
        if (evo2Aircraft != null && (gimbal = evo2Aircraft.getGimbal()) != null) {
            gimbal.setGimbalAngle((float) (aci.sensorElevation * -1.0d), (float) d, 0.0f);
        }
    }

    public static int getNumCameras() {
        Log.d(TAG, "getNumCameras()");
        return cameraProduct.get() == CameraProduct.XT706 ? 2 : 1;
    }

    public static void actionCustom(String str, String str2) {
        String str3 = TAG;
        Log.d(str3, "actionCustom(" + str + "," + str2 + ")");
        if (str != null && str2 != null && str.equals(ACTION_IR_PALETTE) && autelBaseCamera != null && cameraProduct.get() == CameraProduct.XT706) {
            CameraXT706InitializeProxy cameraXT706InitializeProxy = (CameraXT706InitializeProxy) autelBaseCamera;
            IrColor find = IrColor.find(str2);
            if (find == IrColor.UNKNOWN) {
                Log.e(str3, "Could not set IRColor, Unknown mode: " + str2);
                return;
            }
            cameraXT706InitializeProxy.setIrColor(find, new CallbackWithNoParam() {
                public void onFailure(AutelError autelError) {
                }

                public void onSuccess() {
                }
            });
        }
    }

    public static void zoomIn() {
        Log.d(TAG, "zoomIn()");
        doZoom(25);
    }

    public static void zoomOut() {
        Log.d(TAG, "zoomOut()");
        doZoom(-25);
    }

    private static void doZoom(final int i) {
        final C145915 r0 = new CallbackWithNoParam() {
            public void onSuccess() {
                Log.d(EvoMonitor.TAG, "Set Zoom: Completed");
            }

            public void onFailure(AutelError autelError) {
                String access$000 = EvoMonitor.TAG;
                Log.d(access$000, "Failed to set Zoom: " + autelError.getDescription());
            }
        };
        if (cameraProduct.get() == CameraProduct.XT706) {
            ((CameraXT706InitializeProxy) autelBaseCamera).getDigitalZoomScale(new CallbackWithOneParam<Integer>() {
                public void onFailure(AutelError autelError) {
                }

                public void onSuccess(Integer num) {
                    String access$000 = EvoMonitor.TAG;
                    Log.d(access$000, "Current Zoom: " + num);
                    Integer valueOf = Integer.valueOf(num.intValue() + i);
                    if (valueOf.intValue() > 200) {
                        valueOf = 200;
                    } else if (valueOf.intValue() < 100) {
                        valueOf = 100;
                    }
                    ((CameraXT706InitializeProxy) EvoMonitor.autelBaseCamera).setDigitalZoomScale(valueOf.intValue(), r0);
                }
            });
        } else if (cameraProduct.get() == CameraProduct.XT705) {
            ((CameraXT705InitializeProxy) autelBaseCamera).getDigitalZoomScale(new CallbackWithOneParam<Integer>() {
                public void onFailure(AutelError autelError) {
                }

                public void onSuccess(Integer num) {
                    String access$000 = EvoMonitor.TAG;
                    Log.d(access$000, "Current Zoom: " + num);
                    Integer valueOf = Integer.valueOf(num.intValue() + i);
                    if (valueOf.intValue() > 200) {
                        valueOf = 200;
                    } else if (valueOf.intValue() < 100) {
                        valueOf = 100;
                    }
                    ((CameraXT705InitializeProxy) EvoMonitor.autelBaseCamera).setDigitalZoomScale(valueOf.intValue(), r0);
                }
            });
        } else if (cameraProduct.get() == CameraProduct.XT701) {
            ((CameraXT701InitializeProxy) autelBaseCamera).getDigitalZoomScale(new CallbackWithOneParam<Integer>() {
                public void onFailure(AutelError autelError) {
                }

                public void onSuccess(Integer num) {
                    String access$000 = EvoMonitor.TAG;
                    Log.d(access$000, "Current Zoom: " + num);
                    Integer valueOf = Integer.valueOf(num.intValue() + i);
                    if (valueOf.intValue() > 200) {
                        valueOf = 200;
                    } else if (valueOf.intValue() < 100) {
                        valueOf = 100;
                    }
                    ((CameraXT701InitializeProxy) EvoMonitor.autelBaseCamera).setDigitalZoomScale(valueOf.intValue(), r0);
                }
            });
        }
    }

    public static boolean isConnected() {
        return mConnected;
    }
}

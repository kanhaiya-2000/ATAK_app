package com.atakmap.android.uastool.quickbar;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.maps.av;
import com.atakmap.android.uastool.FollowEudController;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASItemCapabilities;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.dji.DJIUASItem;
import com.atakmap.android.uastool.mavlink.MAVLinkUASItem;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.MoreMenu;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.TaskProgressListener;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.VideoUIButton;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.quickbar.QuickTaskTool;
import com.atakmap.coremap.log.Log;
import com.atakmap.coremap.maps.coords.GeoPoint;

public class Quickbar extends RelativeLayout implements FollowEudController.FollowEudCallback, TaskProgressListener {
    private static final String TAG = "Quickbar";
    /* access modifiers changed from: private */
    public VideoUIButton altButton;
    private final String[] altFormats = {"HAL", "HAE", "MSL"};
    private int altFormatsIndex;
    private final String[] altUnits = {"ft", "m"};
    private int altUnitsIndex;
    /* access modifiers changed from: private */
    public VideoUIButton backButton;
    /* access modifiers changed from: private */
    public boolean backIsClose = true;
    private RelativeLayout.LayoutParams flightButtonParams;
    /* access modifiers changed from: private */
    public VideoUIButton followButton;
    /* access modifiers changed from: private */
    public MODE mode = MODE.LANDING;
    /* access modifiers changed from: private */
    public VideoUIButton moreButton;
    /* access modifiers changed from: private */
    public MoreMenu morePopupMenu;
    /* access modifiers changed from: private */
    public AlertDialog quickAltDialog;
    /* access modifiers changed from: private */
    public VideoUIButton rthButton;
    /* access modifiers changed from: private */
    public VideoUIButton stopButton;
    /* access modifiers changed from: private */
    public VideoUIButton taskButton;
    /* access modifiers changed from: private */
    public UASItem uasItem;

    public enum MODE {
        LANDING,
        OPERATOR,
        OBSERVER,
        OBSERVER_CONTROL
    }

    interface QuickBarQuickTaskCallback {
        void onTaskComplete(boolean z, double d, double d2, boolean z2);
    }

    public void taskStageCompleted(int i, String str) {
    }

    public void taskStageStarted(int i, String str) {
    }

    public void taskStageUpdate(int i, int i2, String str) {
    }

    public void taskStarted(String str) {
    }

    public void dispose() {
        MoreMenu moreMenu = this.morePopupMenu;
        if (moreMenu != null) {
            moreMenu.dispose();
        }
    }

    public Quickbar(Context context) {
        super(context);
    }

    public Quickbar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Quickbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.flightButtonParams = (RelativeLayout.LayoutParams) ((RelativeLayout) findViewById(C1877R.C1878id.quick_flight_layout)).getLayoutParams();
        VideoUIButton videoUIButton = (VideoUIButton) findViewById(C1877R.C1878id.quick_back_button);
        this.backButton = videoUIButton;
        videoUIButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Quickbar.this.onBackButton();
            }
        });
        this.backButton.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                UASToolDropDownReceiver.getInstance().helpPopup("Back", "Sends the UI to the previous screen");
                return true;
            }
        });
        VideoUIButton videoUIButton2 = (VideoUIButton) findViewById(C1877R.C1878id.quick_alt_button);
        this.altButton = videoUIButton2;
        videoUIButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Quickbar.this.onAltButton();
            }
        });
        this.altButton.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                UASToolDropDownReceiver.getInstance().helpPopup("Altitude", "Tells the connected UAS to takeoff, go to the given altitude, or land");
                return true;
            }
        });
        VideoUIButton videoUIButton3 = (VideoUIButton) findViewById(C1877R.C1878id.quick_stop_button);
        this.stopButton = videoUIButton3;
        videoUIButton3.setEnabled(true);
        this.stopButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Quickbar.this.onStopButton();
            }
        });
        this.stopButton.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                UASToolDropDownReceiver.getInstance().helpPopup("Stop", "Tells the connected UAS to stop all actions immediately");
                return true;
            }
        });
        VideoUIButton videoUIButton4 = (VideoUIButton) findViewById(C1877R.C1878id.quick_rth_button);
        this.rthButton = videoUIButton4;
        videoUIButton4.setEnabled(false);
        this.rthButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Quickbar.this.onRTHButton();
            }
        });
        this.rthButton.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                UASToolDropDownReceiver.getInstance().helpPopup("Return To Home", "Tells the connected UAS to return to home");
                return true;
            }
        });
        VideoUIButton videoUIButton5 = (VideoUIButton) findViewById(C1877R.C1878id.quick_task_button);
        this.taskButton = videoUIButton5;
        videoUIButton5.setEnabled(false);
        this.taskButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Quickbar.this.onTaskButton();
            }
        });
        this.taskButton.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                UASToolDropDownReceiver.getInstance().helpPopup("Move the UAS", "Quickly task the UAS to move or orbit");
                return true;
            }
        });
        VideoUIButton videoUIButton6 = (VideoUIButton) findViewById(C1877R.C1878id.quick_follow_button);
        this.followButton = videoUIButton6;
        videoUIButton6.setEnabled(false);
        this.followButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Quickbar.this.onFollowButton();
            }
        });
        this.followButton.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                Quickbar.this.onFollowLongClick();
                return true;
            }
        });
        VideoUIButton videoUIButton7 = (VideoUIButton) findViewById(C1877R.C1878id.quick_more_button);
        this.moreButton = videoUIButton7;
        videoUIButton7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Quickbar.this.onMoreButton();
            }
        });
        this.moreButton.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                UASToolDropDownReceiver.getInstance().helpPopup("More", "Opens a menu to show more options");
                return true;
            }
        });
        this.morePopupMenu = new MoreMenu(new ContextThemeWrapper(getContext(), C1877R.style.moreMenuStyle), this.moreButton);
        if (UASToolDropDownReceiver.getInstance() != null) {
            if (UASToolDropDownReceiver.useAglAltitude()) {
                this.altFormatsIndex = 0;
            } else if (UASToolDropDownReceiver.getAltitudeDisplayPref().equals("HAE")) {
                this.altFormatsIndex = 1;
            } else {
                this.altFormatsIndex = 2;
            }
            this.altUnitsIndex = UASToolDropDownReceiver.getAltitudeUnits().getType();
            updateUI();
        }
    }

    public void init() {
        this.backButton.init();
        this.altButton.init();
        this.stopButton.init();
        this.rthButton.init();
        this.taskButton.init();
        this.followButton.init();
        this.moreButton.init();
    }

    public void setUASItem(UASItem uASItem) {
        UASItem uASItem2 = this.uasItem;
        if (uASItem2 != null) {
            uASItem2.removeTaskListener(this);
        }
        this.uasItem = uASItem;
        this.morePopupMenu.setUASItem(uASItem);
        updateUI();
        UASItem uASItem3 = this.uasItem;
        if (uASItem3 != null && uASItem3.supportsTaskProgress()) {
            this.uasItem.addTaskListener(this);
        }
    }

    public UASItem getUASItem() {
        return this.uasItem;
    }

    public void setMode(MODE mode2) {
        this.mode = mode2;
        updateUI();
    }

    public void updateUI() {
        MapView.getMapView().post(new Runnable() {
            public void run() {
                try {
                    if (Quickbar.this.backButton != null) {
                        Quickbar.this.backButton.updateSize();
                        Quickbar.this.altButton.updateSize();
                        Quickbar.this.stopButton.updateSize();
                        Quickbar.this.rthButton.updateSize();
                        Quickbar.this.taskButton.updateSize();
                        Quickbar.this.followButton.updateSize();
                        Quickbar.this.moreButton.updateSize();
                        if (Quickbar.this.uasItem != null) {
                            if (UASItem.checkCapability(Quickbar.this.uasItem, Quickbar.this.uasItem.getPlatformType(), UASItemCapabilities.CAPABILITY_QUICK_ALTITUDE).booleanValue()) {
                                int i = C199434.$SwitchMap$com$atakmap$android$uastool$quickbar$Quickbar$MODE[Quickbar.this.mode.ordinal()];
                                if (i == 1) {
                                    Quickbar.this.altButton.setVisibility(8);
                                } else if (i == 2 || i == 3) {
                                    Quickbar.this.altButton.setVisibility(0);
                                } else if (i == 4) {
                                    Quickbar.this.altButton.setVisibility(8);
                                }
                            } else {
                                Quickbar.this.altButton.setVisibility(8);
                            }
                            if (UASItem.checkCapability(Quickbar.this.uasItem, Quickbar.this.uasItem.getPlatformType(), UASItemCapabilities.CAPABILITY_QUICK_STOP).booleanValue()) {
                                int i2 = C199434.$SwitchMap$com$atakmap$android$uastool$quickbar$Quickbar$MODE[Quickbar.this.mode.ordinal()];
                                if (i2 == 1) {
                                    Quickbar.this.stopButton.setVisibility(8);
                                } else if (i2 == 2) {
                                    Quickbar.this.stopButton.setVisibility(0);
                                } else if (i2 == 3) {
                                    Quickbar.this.stopButton.setVisibility(0);
                                } else if (i2 == 4) {
                                    Quickbar.this.stopButton.setVisibility(8);
                                }
                            } else {
                                Quickbar.this.stopButton.setVisibility(8);
                            }
                            if (UASItem.checkCapability(Quickbar.this.uasItem, Quickbar.this.uasItem.getPlatformType(), UASItemCapabilities.CAPABILITY_QUICK_RTH).booleanValue()) {
                                int i3 = C199434.$SwitchMap$com$atakmap$android$uastool$quickbar$Quickbar$MODE[Quickbar.this.mode.ordinal()];
                                if (i3 == 1) {
                                    Quickbar.this.rthButton.setVisibility(8);
                                } else if (i3 == 2) {
                                    Quickbar.this.rthButton.setVisibility(0);
                                    Quickbar.this.rthButton.setEnabled(true);
                                } else if (i3 == 3) {
                                    Quickbar.this.rthButton.setVisibility(0);
                                    Quickbar.this.rthButton.setEnabled(true);
                                } else if (i3 == 4) {
                                    Quickbar.this.rthButton.setVisibility(8);
                                }
                            } else {
                                Quickbar.this.rthButton.setVisibility(8);
                            }
                            if (UASItem.checkCapability(Quickbar.this.uasItem, Quickbar.this.uasItem.getPlatformType(), UASItemCapabilities.CAPABILITY_QUICK_TASK).booleanValue()) {
                                int i4 = C199434.$SwitchMap$com$atakmap$android$uastool$quickbar$Quickbar$MODE[Quickbar.this.mode.ordinal()];
                                if (i4 == 1) {
                                    Quickbar.this.taskButton.setVisibility(8);
                                } else if (i4 == 2) {
                                    Quickbar.this.taskButton.setVisibility(0);
                                    Quickbar.this.taskButton.setEnabled(true);
                                } else if (i4 == 3) {
                                    Quickbar.this.taskButton.setVisibility(0);
                                    Quickbar.this.taskButton.setEnabled(true);
                                } else if (i4 == 4) {
                                    Quickbar.this.taskButton.setVisibility(8);
                                }
                            } else {
                                Quickbar.this.taskButton.setVisibility(8);
                            }
                            if (UASItem.checkCapability(Quickbar.this.uasItem, Quickbar.this.uasItem.getPlatformType(), UASItemCapabilities.CAPABILITY_QUICK_FOLLOW).booleanValue()) {
                                int i5 = C199434.$SwitchMap$com$atakmap$android$uastool$quickbar$Quickbar$MODE[Quickbar.this.mode.ordinal()];
                                if (i5 == 1) {
                                    Quickbar.this.followButton.setVisibility(8);
                                } else if (i5 == 2) {
                                    Quickbar.this.followButton.setVisibility(8);
                                } else if (i5 == 3) {
                                    Quickbar.this.followButton.setVisibility(0);
                                    Quickbar.this.followButton.setEnabled(true);
                                } else if (i5 == 4) {
                                    Quickbar.this.followButton.setVisibility(8);
                                }
                            } else {
                                Quickbar.this.followButton.setVisibility(8);
                            }
                            if (Quickbar.this.uasItem.isFlying()) {
                                Quickbar.this.altButton.setImageDrawable(Quickbar.this.getContext().getDrawable(C1877R.drawable.quick_altitude));
                            } else {
                                Quickbar.this.altButton.setImageDrawable(Quickbar.this.getContext().getDrawable(C1877R.drawable.quick_go));
                            }
                            if (Quickbar.this.uasItem.getFollowEudController().getFollowing() != null) {
                                Quickbar.this.followButton.setOn(true);
                            }
                        } else {
                            Quickbar.this.altButton.setVisibility(8);
                            Quickbar.this.stopButton.setVisibility(8);
                            Quickbar.this.rthButton.setVisibility(8);
                            Quickbar.this.taskButton.setVisibility(8);
                            Quickbar.this.followButton.setVisibility(8);
                        }
                        if (Quickbar.this.morePopupMenu != null) {
                            Quickbar.this.morePopupMenu.updateSize();
                        }
                    }
                } catch (Exception e) {
                    Log.e(Quickbar.TAG, "error", e);
                }
            }
        });
    }

    /* renamed from: com.atakmap.android.uastool.quickbar.Quickbar$34 */
    /* synthetic */ class C199434 {
        static final /* synthetic */ int[] $SwitchMap$com$atakmap$android$uastool$quickbar$Quickbar$MODE;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.atakmap.android.uastool.quickbar.Quickbar$MODE[] r0 = com.atakmap.android.uastool.quickbar.Quickbar.MODE.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$atakmap$android$uastool$quickbar$Quickbar$MODE = r0
                com.atakmap.android.uastool.quickbar.Quickbar$MODE r1 = com.atakmap.android.uastool.quickbar.Quickbar.MODE.LANDING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$atakmap$android$uastool$quickbar$Quickbar$MODE     // Catch:{ NoSuchFieldError -> 0x001d }
                com.atakmap.android.uastool.quickbar.Quickbar$MODE r1 = com.atakmap.android.uastool.quickbar.Quickbar.MODE.OBSERVER_CONTROL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$atakmap$android$uastool$quickbar$Quickbar$MODE     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.atakmap.android.uastool.quickbar.Quickbar$MODE r1 = com.atakmap.android.uastool.quickbar.Quickbar.MODE.OPERATOR     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$atakmap$android$uastool$quickbar$Quickbar$MODE     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.atakmap.android.uastool.quickbar.Quickbar$MODE r1 = com.atakmap.android.uastool.quickbar.Quickbar.MODE.OBSERVER     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.quickbar.Quickbar.C199434.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    public void onBackButton() {
        if (this.backIsClose) {
            UASToolDropDownReceiver.getInstance().askToClose();
        } else {
            UASToolDropDownReceiver.getInstance().onBackButtonPressed();
        }
    }

    /* access modifiers changed from: private */
    public void onAltButton() {
        if (this.uasItem != null) {
            QuickAltitude quickAltitude = (QuickAltitude) LayoutInflater.from(UASToolDropDownReceiver.getInstance().getPluginContext()).inflate(C1877R.layout.quickbar_altitude, (ViewGroup) null);
            quickAltitude.init(this.uasItem, this, new QuickBarQuickTaskCallback() {
                public void onTaskComplete(boolean z, double d, double d2, boolean z2) {
                    int i = (int) d;
                    if (z) {
                        Quickbar.this.takeoff(i);
                    } else if (i == 0) {
                        Quickbar.this.land();
                    } else {
                        Quickbar.this.setAltitude(i);
                    }
                }
            });
            AlertDialog create = new AlertDialog.Builder(MapView.getMapView().getContext()).setView(quickAltitude).create();
            this.quickAltDialog = create;
            create.show();
            return;
        }
        toast("Unable to set altitude - no UAS");
    }

    /* access modifiers changed from: protected */
    public void setAltitude(int i) {
        AlertDialog alertDialog = this.quickAltDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.quickAltDialog = null;
        }
        this.uasItem.quickAltitude(i);
    }

    /* access modifiers changed from: protected */
    public void cancelAltitude() {
        AlertDialog alertDialog = this.quickAltDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.quickAltDialog = null;
        }
    }

    /* access modifiers changed from: protected */
    public void takeoff(int i) {
        AlertDialog alertDialog = this.quickAltDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.quickAltDialog = null;
        }
        if (this.uasItem.isFlying()) {
            toast("UAS is already in the air");
        } else if (!this.uasItem.readyToTakeoff()) {
            toast("UAS is not ready to takeoff (check motors)");
        } else {
            this.uasItem.quickTakeoff(i);
        }
    }

    /* access modifiers changed from: protected */
    public void land() {
        AlertDialog alertDialog = this.quickAltDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.quickAltDialog = null;
        }
        if (this.uasItem.isFlying()) {
            this.uasItem.quickLanding();
        } else if (!this.uasItem.readyToLand()) {
            toast("UAS is not ready to land");
        } else {
            toast("UAS is already on the ground");
        }
    }

    /* access modifiers changed from: private */
    public void onStopButton() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MapView.getMapView().getContext());
        builder.setTitle("Stop?");
        StringBuffer stringBuffer = new StringBuffer("Stop the UAS immediately?");
        UASItem uASItem = this.uasItem;
        if (uASItem != null && uASItem.getPlatformType().equals(DJIUASItem.DISPLAY_NAME)) {
            stringBuffer.append("\n\nWARNING: DJI products may NOT stop immediately");
        }
        builder.setMessage(stringBuffer);
        builder.setCancelable(true);
        builder.setPositiveButton(17039379, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                Quickbar.this.stop();
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.create().show();
    }

    /* access modifiers changed from: private */
    public void stop() {
        this.uasItem.quickStop();
    }

    /* access modifiers changed from: private */
    public void onRTHButton() {
        if (!this.uasItem.isFlying()) {
            toast("UAS is not in the air");
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(MapView.getMapView().getContext());
        builder.setTitle("Return to Home?");
        builder.setMessage("Return the UAS to home immediately?");
        builder.setCancelable(true);
        builder.setPositiveButton(17039379, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                Quickbar.this.returnToHome();
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.create().show();
    }

    /* access modifiers changed from: private */
    public void returnToHome() {
        this.uasItem.quickRTH();
    }

    /* access modifiers changed from: private */
    public void onTaskLocation(final GeoPoint geoPoint) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MapView.getMapView().getContext());
        if (this.uasItem.getGeoPoint() != null) {
            geoPoint = new GeoPoint(geoPoint.getLatitude(), geoPoint.getLongitude(), this.uasItem.getGeoPoint().getAltitude());
        }
        builder.setTitle("Quick Task");
        builder.setMessage("Reposition or Task the UAS");
        builder.setCancelable(true);
        builder.setPositiveButton("Orbit", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                Quickbar.this.quickOrbit(geoPoint);
            }
        });
        builder.setNeutralButton("Go Now", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                Quickbar.this.quickFlyTo(geoPoint);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.create().show();
    }

    /* access modifiers changed from: private */
    public void onTaskButton() {
        if (!this.uasItem.isFlying()) {
            toast("UAS is not in the air");
            return;
        }
        UASToolDropDownReceiver.getInstance().dismissFullscreen();
        QuickTaskTool.begin(new QuickTaskTool.QuickTaskToolCallback() {
            public void onTaskComplete(GeoPoint geoPoint) {
                QuickTaskTool.end();
                Quickbar.this.onTaskLocation(geoPoint);
            }
        });
    }

    public void onFollowButton() {
        MapView.getMapView().getSelfMarker();
        if (this.followButton.isSelected()) {
            toggleFollowMe((av) null, -1.0d);
        } else if (!this.uasItem.isFlying()) {
            toast("UAS is not in the air");
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(MapView.getMapView().getContext());
            builder.setTitle("Follow Me?");
            builder.setMessage("Task the UAS to follow the GCS?");
            builder.setCancelable(true);
            builder.setPositiveButton(17039379, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                    Quickbar.this.toggleFollowMe(MapView.getMapView().getSelfMarker(), -1.0d);
                }
            });
            builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });
            builder.create().show();
        }
    }

    /* access modifiers changed from: private */
    public void onFollowLongClick() {
        new FollowEudController.FollowEudAlertDialog().getAdvancedConfigDialog(this.uasItem, this).show();
    }

    public void toggleFollowMe(final av avVar, double d) {
        VideoUIButton videoUIButton = this.followButton;
        videoUIButton.setSelected(!videoUIButton.isSelected());
        if (this.followButton.isSelected()) {
            this.followButton.setOn(true);
            if (avVar != null) {
                final UASItem uASItem = this.uasItem;
                C198627 r1 = new FollowEudController.QuickItemCallback() {
                    public void moveTo(GeoPoint geoPoint) {
                        if (Quickbar.this.uasItem instanceof MAVLinkUASItem) {
                            ((MAVLinkUASItem) Quickbar.this.uasItem).setGimbalLockOn(true);
                        }
                        UASItem uASItem = uASItem;
                        uASItem.quickFlyTo(geoPoint, uASItem.getAGL_relative());
                    }

                    public GeoPoint getPosition() {
                        return uASItem.getGeoPoint();
                    }

                    public av getTarget() {
                        return avVar;
                    }
                };
                C198728 r2 = new FollowEudController.QuickItemCallback() {
                    public void moveTo(GeoPoint geoPoint) {
                        uASItem.taskSensorToPoint(geoPoint);
                    }

                    public GeoPoint getPosition() {
                        return uASItem.getSPoIPoint();
                    }

                    public av getTarget() {
                        return avVar;
                    }
                };
                this.uasItem.getFollowEudController().startFollowing((FollowEudController.QuickItemCallback) r1);
                this.uasItem.getGimbalFollowController().startFollowing((FollowEudController.QuickItemCallback) r2);
                this.uasItem.getGimbalFollowController().setLeashRange(0.0d);
                this.uasItem.getGimbalFollowController().UNCERTAINTY_RANGE = 5.0d;
                this.uasItem.getGimbalFollowController().minUpdateInterval = 1000;
                if (d >= 0.0d) {
                    this.uasItem.getFollowEudController().setLeashRange(d);
                    return;
                }
                return;
            }
            toast("Could not enable FollowMe - this device does not have a map marker.");
            this.followButton.setSelected(false);
            this.followButton.setOn(false);
            this.uasItem.getFollowEudController().stopFollowing();
            this.uasItem.getGimbalFollowController().stopFollowing();
            return;
        }
        this.followButton.setOn(false);
        this.uasItem.quickStop();
        this.uasItem.getFollowEudController().stopFollowing();
        this.uasItem.getGimbalFollowController().stopFollowing();
    }

    /* access modifiers changed from: private */
    public void onMoreButton() {
        this.morePopupMenu.show();
    }

    /* access modifiers changed from: protected */
    public void toggleAltUnits() {
        int i = this.altUnitsIndex + 1;
        this.altUnitsIndex = i;
        if (i >= this.altUnits.length) {
            this.altUnitsIndex = 0;
        }
    }

    /* access modifiers changed from: protected */
    public String getAltUnitsString() {
        return this.altUnits[this.altUnitsIndex];
    }

    /* access modifiers changed from: protected */
    public void toggleAltFormat() {
        int i = this.altFormatsIndex + 1;
        this.altFormatsIndex = i;
        if (i >= this.altFormats.length) {
            this.altFormatsIndex = 0;
        }
    }

    /* access modifiers changed from: protected */
    public String getAltFormatString() {
        return this.altFormats[this.altFormatsIndex];
    }

    private void toast(String str) {
        UASToolDropDownReceiver.toast(str, 0);
    }

    public void setBackAsClose(final boolean z) {
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                boolean unused = Quickbar.this.backIsClose = z;
                if (Quickbar.this.backButton == null) {
                    Quickbar quickbar = Quickbar.this;
                    VideoUIButton unused2 = quickbar.backButton = (VideoUIButton) quickbar.findViewById(C1877R.C1878id.quick_back_button);
                }
                if (z) {
                    Quickbar.this.backButton.setImageResource(C1877R.drawable.action_close);
                } else {
                    Quickbar.this.backButton.setImageResource(C1877R.drawable.arrow_left);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void quickOrbit(final GeoPoint geoPoint) {
        if (this.uasItem != null) {
            QuickAltitude quickAltitude = (QuickAltitude) LayoutInflater.from(UASToolDropDownReceiver.getInstance().getPluginContext()).inflate(C1877R.layout.quickbar_altitude, (ViewGroup) null);
            quickAltitude.init(this.uasItem, this, new QuickBarQuickTaskCallback() {
                public void onTaskComplete(boolean z, double d, double d2, boolean z2) {
                    Quickbar.this.uasItem.quickOrbit(geoPoint, d2, Double.NaN, z2);
                    Quickbar.this.quickAltDialog.cancel();
                }
            });
            quickAltitude.init_orbit(geoPoint);
            AlertDialog create = new AlertDialog.Builder(MapView.getMapView().getContext()).setView(quickAltitude).create();
            this.quickAltDialog = create;
            create.show();
            return;
        }
        toast("Unable to set altitude - no UAS");
    }

    /* access modifiers changed from: private */
    public void quickFlyTo(GeoPoint geoPoint) {
        this.uasItem.quickFlyTo(geoPoint, Double.NaN);
    }

    public void taskPrepared(int i, String str) {
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                Quickbar.this.altButton.setEnabled(false);
            }
        });
    }

    public void taskRefused(String str) {
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                Quickbar.this.altButton.setEnabled(true);
            }
        });
    }

    public void taskFinished(String str) {
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                Quickbar.this.altButton.setEnabled(true);
            }
        });
    }
}

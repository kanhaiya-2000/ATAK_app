package com.atakmap.android.uastool;

import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import atak.core.rd;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.maps.ae;
import com.atakmap.android.maps.af;
import com.atakmap.android.maps.ai;
import com.atakmap.android.maps.ao;
import com.atakmap.android.maps.av;
import com.atakmap.android.uastool.flightlog.FlightLogger;
import com.atakmap.android.uastool.pagers.ActionButton;
import com.atakmap.android.uastool.utils.Utils;
import com.atakmap.android.util.b;
import com.atakmap.coremap.filesystem.FileSystemUtils;
import com.atakmap.coremap.log.Log;
import com.atakmap.coremap.maps.coords.GeoCalculations;
import com.atakmap.coremap.maps.coords.GeoPoint;
import java.util.concurrent.atomic.AtomicBoolean;

public class FollowEudController implements av.a {
    public static String FOLLOW_EUD_DISTANCE_KEY = "uastool.pref_follow_eud_distance";
    private static final String TAG = "com.atakmap.android.uastool.FollowEudController";
    public double UNCERTAINTY_RANGE = 25.0d;
    private double desiredAlt;
    private final AtomicBoolean followEnabled = new AtomicBoolean(false);
    private av.a followEudListener;
    private av followEudMarker;
    private FollowEudController instance;
    private GeoPoint lastCommandEudLocation;
    private long lastCommandGiven = 0;
    private double leashRange;
    public long minUpdateInterval = 1000;
    private QuickItemCallback quickItemCallback;
    private final UASItem uasItem;

    public interface FollowEudCallback {
        void toggleFollowMe(av avVar, double d);
    }

    public interface QuickItemCallback {
        GeoPoint getPosition();

        av getTarget();

        void moveTo(GeoPoint geoPoint);
    }

    public FollowEudController(UASItem uASItem) {
        this.uasItem = uASItem;
        try {
            this.leashRange = (double) UASToolDropDownReceiver.getSharedPrefs().getFloat(FOLLOW_EUD_DISTANCE_KEY, 50.0f);
        } catch (Exception unused) {
        }
    }

    public synchronized void startFollowing(av avVar) {
        if (this.followEnabled.get()) {
            stopFollowing();
        }
        this.followEudMarker = avVar;
        this.lastCommandEudLocation = avVar.C();
        this.desiredAlt = this.uasItem.getAGL_relative();
        this.leashRange = this.followEudMarker.C().distanceTo(this.uasItem.getGeoPoint());
        this.followEudListener = this;
        this.followEnabled.set(true);
        this.followEudMarker.a(this.followEudListener);
        this.followEudListener.onPointChanged(this.followEudMarker);
    }

    public synchronized void startFollowing(QuickItemCallback quickItemCallback2) {
        if (this.followEnabled.get()) {
            stopFollowing();
        }
        this.quickItemCallback = quickItemCallback2;
        av target = quickItemCallback2.getTarget();
        this.followEudMarker = target;
        this.lastCommandEudLocation = target.C();
        this.leashRange = this.followEudMarker.C().distanceTo(quickItemCallback2.getPosition());
        this.followEudListener = this;
        this.followEnabled.set(true);
        this.followEudMarker.a(this.followEudListener);
        this.followEudListener.onPointChanged(this.followEudMarker);
    }

    public synchronized void stopFollowing() {
        av avVar;
        this.followEnabled.set(false);
        av.a aVar = this.followEudListener;
        if (!(aVar == null || (avVar = this.followEudMarker) == null)) {
            avVar.b(aVar);
        }
        this.followEudListener = null;
        this.followEudMarker = null;
    }

    public av getFollowing() {
        return this.followEudMarker;
    }

    public double getLeashRange() {
        return this.leashRange;
    }

    public void setLeashRange(double d) {
        try {
            SharedPreferences.Editor edit = UASToolDropDownReceiver.getSharedPrefs().edit();
            edit.putFloat(FOLLOW_EUD_DISTANCE_KEY, (float) d);
            edit.apply();
        } catch (Exception unused) {
        }
        this.leashRange = d;
        onPointChanged(this.followEudMarker);
    }

    public void onPointChanged(av avVar) {
        if (this.uasItem != null && this.followEnabled.get() && avVar != null) {
            GeoPoint position = this.quickItemCallback.getPosition();
            GeoPoint C = avVar.C();
            double bearingTo = C.bearingTo(position);
            double distanceTo = position.distanceTo(C);
            long currentTimeMillis = System.currentTimeMillis();
            double distanceTo2 = C.distanceTo(this.lastCommandEudLocation);
            double d = this.UNCERTAINTY_RANGE;
            if (distanceTo2 > d) {
                double d2 = this.leashRange;
                if (distanceTo > d + d2 && currentTimeMillis - this.lastCommandGiven > this.minUpdateInterval) {
                    GeoPoint pointAtDistance = GeoCalculations.pointAtDistance(C, bearingTo, d2);
                    String str = TAG;
                    Log.d(str, "Issuing quickFly to " + pointAtDistance + "at alt " + this.desiredAlt + ".  Target is " + distanceTo + " meters away.");
                    this.lastCommandGiven = currentTimeMillis;
                    this.lastCommandEudLocation = C;
                    this.quickItemCallback.moveTo(pointAtDistance);
                }
            }
        }
    }

    public static class FollowEudAlertDialog {
        av _followMapItem;
        int _followStandoffDistance;
        /* access modifiers changed from: private */
        public View.OnKeyListener _keyListener;
        private ImageButton quickFollowDistMinus;
        private ImageButton quickFollowDistPlus;
        private SeekBar quickFollowDistSeek;
        private TextView quickFollowDistValue;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x001f */
        /* JADX WARNING: Removed duplicated region for block: B:10:0x0033  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public android.app.AlertDialog getAdvancedConfigDialog(com.atakmap.android.uastool.UASItem r6, final com.atakmap.android.uastool.FollowEudController.FollowEudCallback r7) {
            /*
                r5 = this;
                com.atakmap.android.uastool.FollowEudController r0 = r6.getFollowEudController()
                com.atakmap.android.maps.av r0 = r0.getFollowing()
                if (r0 == 0) goto L_0x001f
                com.atakmap.android.uastool.FollowEudController r0 = r6.getFollowEudController()     // Catch:{ Exception -> 0x001f }
                com.atakmap.android.maps.av r0 = r0.getFollowing()     // Catch:{ Exception -> 0x001f }
                r5._followMapItem = r0     // Catch:{ Exception -> 0x001f }
                com.atakmap.android.uastool.FollowEudController r0 = r6.getFollowEudController()     // Catch:{ Exception -> 0x001f }
                double r0 = r0.getLeashRange()     // Catch:{ Exception -> 0x001f }
                int r0 = (int) r0     // Catch:{ Exception -> 0x001f }
                r5._followStandoffDistance = r0     // Catch:{ Exception -> 0x001f }
            L_0x001f:
                com.atakmap.android.uastool.FollowEudController r0 = r6.getFollowEudController()     // Catch:{ Exception -> 0x002b }
                double r0 = r0.getLeashRange()     // Catch:{ Exception -> 0x002b }
                int r0 = (int) r0     // Catch:{ Exception -> 0x002b }
                r5._followStandoffDistance = r0     // Catch:{ Exception -> 0x002b }
                goto L_0x002f
            L_0x002b:
                r0 = 50
                r5._followStandoffDistance = r0
            L_0x002f:
                com.atakmap.android.maps.av r0 = r5._followMapItem
                if (r0 != 0) goto L_0x003d
                com.atakmap.android.maps.MapView r0 = com.atakmap.android.maps.MapView.getMapView()
                com.atakmap.android.maps.ao r0 = r0.getSelfMarker()
                r5._followMapItem = r0
            L_0x003d:
                com.atakmap.android.uastool.UASToolDropDownReceiver r0 = com.atakmap.android.uastool.UASToolDropDownReceiver.getInstance()
                android.content.Context r0 = r0.getPluginContext()
                android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)
                r1 = 2131165208(0x7f070018, float:1.7944627E38)
                r2 = 0
                android.view.View r0 = r0.inflate(r1, r2)
                android.app.AlertDialog$Builder r1 = new android.app.AlertDialog$Builder
                com.atakmap.android.maps.MapView r2 = com.atakmap.android.maps.MapView.getMapView()
                android.content.Context r2 = r2.getContext()
                r1.<init>(r2)
                r1.setView(r0)
                java.lang.String r2 = "Follow Marker Advanced setup"
                r1.setTitle(r2)
                r2 = 1
                r1.setCancelable(r2)
                r2 = 17039379(0x1040013, float:2.4244624E-38)
                com.atakmap.android.uastool.FollowEudController$FollowEudAlertDialog$1 r3 = new com.atakmap.android.uastool.FollowEudController$FollowEudAlertDialog$1
                r3.<init>(r7)
                r1.setPositiveButton(r2, r3)
                r7 = 17039360(0x1040000, float:2.424457E-38)
                com.atakmap.android.uastool.FollowEudController$FollowEudAlertDialog$2 r2 = new com.atakmap.android.uastool.FollowEudController$FollowEudAlertDialog$2
                r2.<init>()
                r1.setNegativeButton(r7, r2)
                r7 = 2131034185(0x7f050049, float:1.767888E38)
                android.view.View r7 = r0.findViewById(r7)
                android.widget.ImageButton r7 = (android.widget.ImageButton) r7
                com.atakmap.android.uastool.pagers.ActionButton r2 = new com.atakmap.android.uastool.pagers.ActionButton
                r3 = 2131034184(0x7f050048, float:1.7678878E38)
                android.view.View r3 = r0.findViewById(r3)
                r2.<init>(r3)
                com.atakmap.android.maps.av r3 = r5._followMapItem
                setButtonText(r3, r2)
                r3 = 0
                r2.setEnabled(r3)
                android.app.AlertDialog r1 = r1.create()
                com.atakmap.android.uastool.FollowEudController$FollowEudAlertDialog$3 r3 = new com.atakmap.android.uastool.FollowEudController$FollowEudAlertDialog$3
                r3.<init>(r1, r2)
                r7.setOnClickListener(r3)
                r7 = 2131034977(0x7f050361, float:1.7680487E38)
                android.view.View r7 = r0.findViewById(r7)
                android.widget.TextView r7 = (android.widget.TextView) r7
                r5.quickFollowDistValue = r7
                r7 = 2131034975(0x7f05035f, float:1.7680483E38)
                android.view.View r7 = r0.findViewById(r7)
                android.widget.SeekBar r7 = (android.widget.SeekBar) r7
                r5.quickFollowDistSeek = r7
                r3 = 250(0xfa, float:3.5E-43)
                r7.setMax(r3)
                android.widget.SeekBar r7 = r5.quickFollowDistSeek
                com.atakmap.android.uastool.FollowEudController r6 = r6.getFollowEudController()
                double r3 = r6.getLeashRange()
                int r6 = (int) r3
                r7.setProgress(r6)
                android.widget.SeekBar r6 = r5.quickFollowDistSeek
                com.atakmap.android.uastool.FollowEudController$FollowEudAlertDialog$4 r7 = new com.atakmap.android.uastool.FollowEudController$FollowEudAlertDialog$4
                r7.<init>()
                r6.setOnSeekBarChangeListener(r7)
                r6 = 2131034973(0x7f05035d, float:1.7680479E38)
                android.view.View r6 = r0.findViewById(r6)
                android.widget.ImageButton r6 = (android.widget.ImageButton) r6
                r5.quickFollowDistMinus = r6
                com.atakmap.android.uastool.FollowEudController$FollowEudAlertDialog$5 r7 = new com.atakmap.android.uastool.FollowEudController$FollowEudAlertDialog$5
                r7.<init>()
                r6.setOnClickListener(r7)
                r6 = 2131034974(0x7f05035e, float:1.768048E38)
                android.view.View r6 = r0.findViewById(r6)
                android.widget.ImageButton r6 = (android.widget.ImageButton) r6
                r5.quickFollowDistPlus = r6
                com.atakmap.android.uastool.FollowEudController$FollowEudAlertDialog$6 r7 = new com.atakmap.android.uastool.FollowEudController$FollowEudAlertDialog$6
                r7.<init>()
                r6.setOnClickListener(r7)
                r5.altitudeChanged()
                com.atakmap.android.maps.av r6 = r5._followMapItem
                setButtonText(r6, r2)
                r1.show()
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.FollowEudController.FollowEudAlertDialog.getAdvancedConfigDialog(com.atakmap.android.uastool.UASItem, com.atakmap.android.uastool.FollowEudController$FollowEudCallback):android.app.AlertDialog");
        }

        /* access modifiers changed from: private */
        public void altitudeChanged() {
            if (this._followStandoffDistance > 0) {
                this.quickFollowDistMinus.setEnabled(true);
            } else {
                this._followStandoffDistance = 0;
                this.quickFollowDistMinus.setEnabled(false);
            }
            if (this._followStandoffDistance < 250) {
                this.quickFollowDistPlus.setEnabled(true);
            } else {
                this._followStandoffDistance = 250;
                this.quickFollowDistPlus.setEnabled(false);
            }
            this.quickFollowDistValue.setText(Utils.formatRange((double) this._followStandoffDistance));
            this.quickFollowDistSeek.setProgress(this._followStandoffDistance);
        }

        /* access modifiers changed from: private */
        public synchronized void select(final AlertDialog alertDialog, ActionButton actionButton) {
            final MapView mapView = MapView.getMapView();
            final af mapEventDispatcher = mapView.getMapEventDispatcher();
            mapEventDispatcher.a();
            mapEventDispatcher.a(false);
            rd.b().a("Select Marker to Follow");
            this._keyListener = new View.OnKeyListener() {
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    boolean z = false;
                    if (i != 4) {
                        return false;
                    }
                    rd.b().d();
                    mapEventDispatcher.b();
                    mapView.b(this);
                    alertDialog.show();
                    Button button = alertDialog.getButton(-1);
                    if (FollowEudAlertDialog.this._followMapItem != null) {
                        z = true;
                    }
                    button.setEnabled(z);
                    return true;
                }
            };
            final ActionButton actionButton2 = actionButton;
            final af afVar = mapEventDispatcher;
            final MapView mapView2 = mapView;
            final AlertDialog alertDialog2 = alertDialog;
            C11288 r0 = new af.a() {
                public void onMapEvent(ae aeVar) {
                    String a = aeVar.a();
                    if ("map_click".equals(a)) {
                        UASToolDropDownReceiver.toast("Please select a marker");
                        FollowEudAlertDialog.this._followMapItem = MapView.getMapView().getSelfMarker();
                        FollowEudAlertDialog.setButtonText(FollowEudAlertDialog.this._followMapItem, actionButton2);
                    } else if ("item_click".equals(a) && (aeVar.b() instanceof av)) {
                        FollowEudAlertDialog.this._followMapItem = aeVar.b();
                        FollowEudAlertDialog.setButtonText(FollowEudAlertDialog.this._followMapItem, actionButton2);
                    }
                    synchronized (FollowEudAlertDialog.this) {
                        rd.b().d();
                        afVar.b();
                        mapView2.b(FollowEudAlertDialog.this._keyListener);
                    }
                    alertDialog2.show();
                }
            };
            mapView.a(this._keyListener);
            mapEventDispatcher.c("item_click", r0);
            mapEventDispatcher.c("map_click", r0);
        }

        /* access modifiers changed from: private */
        public static void setButtonText(ai aiVar, ActionButton actionButton) {
            String str = "";
            if (aiVar == null) {
                actionButton.setText(str);
                return;
            }
            if (aiVar instanceof ao) {
                if (aiVar.getType().contentEquals("b-r-f-h-c") || aiVar.getMetaString(FlightLogger.LOG_CALLSIGN, str).contentEquals(str)) {
                    str = aiVar.getTitle();
                } else {
                    str = aiVar.getMetaString(FlightLogger.LOG_CALLSIGN, str);
                }
            }
            if (FileSystemUtils.isEmpty(str)) {
                str = b.a(aiVar);
            }
            actionButton.setText(str);
        }
    }
}

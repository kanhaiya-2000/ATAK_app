package com.atakmap.android.uastool.utils;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import atak.core.oe;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.prefs.UASToolPreferenceFragment;
import com.atakmap.android.util.b;
import com.atakmap.app.system.FlavorProvider;
import com.atakmap.app.system.e;
import com.atakmap.coremap.conversions.AngleUtilities;
import com.atakmap.coremap.maps.coords.GeoPoint;
import com.atakmap.coremap.maps.coords.NorthReference;
import com.atakmap.map.elevation.ElevationManager;
import java.net.InetAddress;

public class Utils {
    public static int parseInt(String str, int i) {
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return i;
        }
    }

    public static double parseDouble(String str, double d) {
        try {
            return Double.parseDouble(str);
        } catch (Exception unused) {
            return d;
        }
    }

    public static boolean isSecureAtakVersion() {
        FlavorProvider b = e.b();
        return b != null && b.hasMilCapabilities();
    }

    public static void checkInstallDTED() {
        if (UASToolDropDownReceiver.getInstance() != null) {
            final SharedPreferences sharedPrefs = UASToolDropDownReceiver.getSharedPrefs();
            GeoPoint C = MapView.getMapView().getSelfMarker().C();
            Double valueOf = Double.valueOf(ElevationManager.a(C.getLatitude(), C.getLongitude(), (ElevationManager.b) null));
            if (C.getLatitude() != 0.0d && valueOf.isNaN() && !sharedPrefs.getBoolean(UASToolPreferenceFragment.PREF_DTED_DONT_WARN, false)) {
                View inflate = LayoutInflater.from(UASToolDropDownReceiver.getInstance().getPluginContext()).inflate(C1877R.layout.check_install_dted_layout, (ViewGroup) null);
                ((TextView) inflate.findViewById(C1877R.C1878id.check_install_dted_message)).setText("ATTENTION!\n\n You do not have Digital Terrain Elevation Data (DTED) loaded at your location. It is NOT advisable to fly a Drone with ATAK/UAS Tool without DTED.\n\n Please see the ATAK Quick Start Guide on how to load DTED. Utilize the Import Manager to import a zipped DTED folder file on the Internal Storage of the Android device.");
                final CheckBox checkBox = (CheckBox) inflate.findViewById(C1877R.C1878id.check_install_dted_dont_warn);
                AlertDialog.Builder builder = new AlertDialog.Builder(MapView.getMapView().getContext());
                builder.setTitle("Install DTED").setCancelable(false).setView(inflate).setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (checkBox.isChecked()) {
                            SharedPreferences.Editor edit = sharedPrefs.edit();
                            edit.putBoolean(UASToolPreferenceFragment.PREF_DTED_DONT_WARN, true);
                            edit.apply();
                        }
                    }
                });
                builder.create().show();
            }
        }
    }

    public static String formatAlt(double d) {
        if (UASToolDropDownReceiver.getAltitudeUnits().getType() != 1) {
            return Math.round(d * 3.280839895d) + " ft";
        }
        return d + " m";
    }

    public static String formatRange(double d) {
        int rangeFormat = UASToolDropDownReceiver.getRangeFormat();
        if (rangeFormat == 1) {
            return Math.round(d) + " m";
        } else if (rangeFormat != 2) {
            return Math.round(d * 3.280839895d) + " ft";
        } else {
            return Math.round(d * 5.39957E-4d) + " nm";
        }
    }

    public static String formatHeading(GeoPoint geoPoint, double d) {
        NorthReference northReference = UASToolDropDownReceiver.getInstance().getNorthReference();
        if (Double.isNaN(d)) {
            return UASToolConstants.DASHES;
        }
        if (d < 0.0d || d > 360.0d) {
            d %= 360.0d;
        }
        if (geoPoint == null || !(northReference == NorthReference.MAGNETIC || northReference == NorthReference.GRID)) {
            return AngleUtilities.format(d) + " " + NorthReference.TRUE.getAbbrev();
        }
        return AngleUtilities.format(b.b(geoPoint, d)) + " " + NorthReference.MAGNETIC.getAbbrev();
    }

    public static double convertTrueToPrefDisplay(GeoPoint geoPoint, double d) {
        NorthReference northReference = UASToolDropDownReceiver.getInstance().getNorthReference();
        if (geoPoint != null && !Double.isNaN(d)) {
            if (d < 0.0d || d > 360.0d) {
                d %= 360.0d;
            }
            if (northReference == NorthReference.MAGNETIC || northReference == NorthReference.GRID) {
                return b.b(geoPoint, d);
            }
        }
        return d;
    }

    public static boolean isMulticast(String str) {
        try {
            return InetAddress.getByName(str).isMulticastAddress();
        } catch (Exception unused) {
            return false;
        }
    }

    public static int getStatusBarHeight() {
        Resources resources = MapView.getMapView().getContext().getResources();
        int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int getNavigationBarHeight() {
        Resources resources = MapView.getMapView().getContext().getResources();
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    /* renamed from: com.atakmap.android.uastool.utils.Utils$2 */
    /* synthetic */ class C22382 {
        static final /* synthetic */ int[] $SwitchMap$com$atakmap$coremap$conversions$Span;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.atakmap.coremap.conversions.Span[] r0 = com.atakmap.coremap.conversions.Span.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$atakmap$coremap$conversions$Span = r0
                com.atakmap.coremap.conversions.Span r1 = com.atakmap.coremap.conversions.Span.METER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$atakmap$coremap$conversions$Span     // Catch:{ NoSuchFieldError -> 0x001d }
                com.atakmap.coremap.conversions.Span r1 = com.atakmap.coremap.conversions.Span.FOOT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.utils.Utils.C22382.<clinit>():void");
        }
    }

    public static int altitudeConversionMetersIn(int i) {
        double d = C22382.$SwitchMap$com$atakmap$coremap$conversions$Span[UASToolDropDownReceiver.getAltitudeUnits().ordinal()] != 1 ? 3.280839895d : 1.0d;
        double d2 = (double) i;
        if (Double.isNaN(d2)) {
            return -1;
        }
        return (int) Math.round(d * d2);
    }

    public static int altitudeConversionMetersOut(double d) {
        long round;
        if (C22382.$SwitchMap$com$atakmap$coremap$conversions$Span[UASToolDropDownReceiver.getAltitudeUnits().ordinal()] == 1) {
            round = Math.round(d);
        } else if (Double.isNaN(d)) {
            return -1;
        } else {
            round = Math.round(oe.b.a(d));
        }
        return (int) round;
    }
}

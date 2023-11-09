package com.atakmap.android.uastool.prefs;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.widget.EditText;
import android.widget.TextView;
import atak.core.ni;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.comms.j;
import com.atakmap.comms.k;
import com.atakmap.coremap.log.Log;
import java.lang.Thread;
import java.util.List;
import java.util.regex.Pattern;

public class NetworkPreferenceFragment extends ni {
    private static final Pattern IPV4 = Pattern.compile("^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");
    private static final int PORT_MAX = 65535;
    private static final int PORT_MIN = 0;
    private static final int PORT_REQ_PORT = 1936;
    public static final String PREF_AVAHI_SERVICE_LIST = "uastool.pref_avahi_service_list";
    public static final String PREF_BROADCAST_BITRATE = "uastool.pref_video_broadcast_bitrate";
    public static final String PREF_BROADCAST_DESTINATION = "uastool.pref_video_broadcast_destination";
    public static final String PREF_BROADCAST_PATH = "uastool.pref_video_broadcast_path";
    public static final String PREF_BROADCAST_SIZE = "uastool.pref_broadcast_size";
    public static final String PREF_BROADCAST_SSL = "uastool.pref_broadcast_ssl";
    public static final String PREF_BROADCAST_VIDEODATARATE = "uastool.pref_video_broadcast_videodatarate";
    public static final String PREF_DESTINATION_IP = "uastool.pref_video_dest_ip";
    public static final String PREF_DESTINATION_IP_MULTICAST = "uastool.pref_video_dest_ip_multicast";
    public static final String PREF_VIDEO_DEST_ADAPTER = "uastool.pref_video_dest_adapter";
    public static final String PREF_VIDEO_DEST_LASTOCTET = "uastool.pref_video_dest_lastOctet";
    public static final String PREF_VIDEO_DEST_PORT = "uastool.pref_video_dest_port";
    public static final String PREF_VIDEO_DEST_PORT_MULTICAST = "uastool.pref_video_dest_port_multicast";
    public static final String PREF_VIDEO_OBSERVER_URL = "uastool.pref_video_observer_url";
    public static Context staticPluginContext;
    private String errMsg;
    private final SharedPreferences.OnSharedPreferenceChangeListener prefChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() {
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -2098592595:
                    if (str.equals(NetworkPreferenceFragment.PREF_VIDEO_DEST_LASTOCTET)) {
                        c = 0;
                        break;
                    }
                    break;
                case -1999097535:
                    if (str.equals(NetworkPreferenceFragment.PREF_BROADCAST_SSL)) {
                        c = 1;
                        break;
                    }
                    break;
                case -1755444269:
                    if (str.equals(NetworkPreferenceFragment.PREF_DESTINATION_IP)) {
                        c = 2;
                        break;
                    }
                    break;
                case -896657601:
                    if (str.equals(NetworkPreferenceFragment.PREF_BROADCAST_DESTINATION)) {
                        c = 3;
                        break;
                    }
                    break;
                case 876940902:
                    if (str.equals(NetworkPreferenceFragment.PREF_VIDEO_DEST_PORT_MULTICAST)) {
                        c = 4;
                        break;
                    }
                    break;
                case 940416045:
                    if (str.equals(NetworkPreferenceFragment.PREF_VIDEO_DEST_PORT)) {
                        c = 5;
                        break;
                    }
                    break;
                case 1074026004:
                    if (str.equals(NetworkPreferenceFragment.PREF_BROADCAST_PATH)) {
                        c = 6;
                        break;
                    }
                    break;
                case 1700963980:
                    if (str.equals(NetworkPreferenceFragment.PREF_DESTINATION_IP_MULTICAST)) {
                        c = 7;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    NetworkPreferenceFragment.this.setNetworkPreferencesState();
                    NetworkPreferenceFragment.this.setLastOctetSummary();
                    NetworkPreferenceFragment.this.checkUpdateObserverUrl();
                    return;
                case 1:
                    boolean unused = NetworkPreferenceFragment.this.suppressUpdate = true;
                    EditTextPreference editTextPreference = (EditTextPreference) NetworkPreferenceFragment.this.findPreference(NetworkPreferenceFragment.PREF_VIDEO_DEST_PORT);
                    editTextPreference.setText((String) null);
                    editTextPreference.setText(UASToolDropDownReceiver.getInstance().getVideoBroadcastDestinationPort());
                    boolean unused2 = NetworkPreferenceFragment.this.suppressUpdate = false;
                    return;
                case 2:
                case 4:
                case 5:
                case 6:
                case 7:
                    String string = sharedPreferences.getString(str, (String) null);
                    if (!NetworkPreferenceFragment.this.suppressUpdate && string != null && !string.isEmpty()) {
                        NetworkPreferenceFragment.this.checkUpdateObserverUrl();
                        return;
                    }
                    return;
                case 3:
                    NetworkPreferenceFragment.this.setNetworkPreferencesState();
                    NetworkPreferenceFragment.this.setDefaultValues();
                    NetworkPreferenceFragment.this.updateObserverUrl();
                    NetworkPreferenceFragment.this.setLastOctetSummary();
                    return;
                default:
                    return;
            }
        }
    };
    private SharedPreferences sharedPrefs;
    /* access modifiers changed from: private */
    public boolean suppressUpdate = false;

    public boolean validatePort(int i) {
        return i >= 0 && i <= PORT_MAX;
    }

    public NetworkPreferenceFragment() {
        super(staticPluginContext, C1877R.C1879xml.network_prefs);
    }

    public NetworkPreferenceFragment(Context context) {
        super(context, C1877R.C1879xml.network_prefs);
        staticPluginContext = context;
    }

    public void onCreate(Bundle bundle) {
        NetworkPreferenceFragment.super.onCreate((Bundle) null);
        this.sharedPrefs = UASToolDropDownReceiver.getSharedPrefs();
        String[] networkDeviceList = getNetworkDeviceList();
        ListPreference listPreference = (ListPreference) findPreference(PREF_VIDEO_DEST_ADAPTER);
        listPreference.setEntries(networkDeviceList);
        listPreference.setEntryValues(networkDeviceList);
        C19171 r9 = new InputFilter() {
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                while (i < i2) {
                    char charAt = charSequence.charAt(i);
                    if (!Character.isLetterOrDigit(charAt) && charAt != '_' && charAt != '-' && charAt != '/') {
                        return "";
                    }
                    i++;
                }
                return null;
            }
        };
        ((EditTextPreference) findPreference(PREF_BROADCAST_PATH)).getEditText().setFilters(new InputFilter[]{r9});
        HostnameIpFilter hostnameIpFilter = new HostnameIpFilter();
        EditTextPreference editTextPreference = (EditTextPreference) findPreference(PREF_DESTINATION_IP);
        editTextPreference.getEditText().setFilters(new InputFilter[]{hostnameIpFilter});
        EditText editText = editTextPreference.getEditText();
        Context context = staticPluginContext;
        editText.addTextChangedListener(new HostOrIpWatcher(context, editTextPreference, context.getResources().getString(C1877R.string.pref_wowza_dest_ip_sum)));
        EditTextPreference editTextPreference2 = (EditTextPreference) findPreference(PREF_DESTINATION_IP_MULTICAST);
        editTextPreference2.getEditText().setFilters(new InputFilter[]{hostnameIpFilter});
        EditText editText2 = editTextPreference2.getEditText();
        Context context2 = staticPluginContext;
        editText2.addTextChangedListener(new HostOrIpWatcher(context2, editTextPreference2, context2.getResources().getString(C1877R.string.pref_local_dest_ip_sum)));
        setNetworkPreferencesState();
        setDefaultValues();
        setLastOctetSummary();
        this.sharedPrefs.registerOnSharedPreferenceChangeListener(this.prefChangeListener);
    }

    public void onDestroy() {
        NetworkPreferenceFragment.super.onDestroy();
        this.sharedPrefs.unregisterOnSharedPreferenceChangeListener(this.prefChangeListener);
    }

    /* access modifiers changed from: private */
    public void setDefaultValues() {
        EditTextPreference editTextPreference = (EditTextPreference) findPreference(PREF_VIDEO_OBSERVER_URL);
        if (TextUtils.isEmpty(this.sharedPrefs.getString(PREF_VIDEO_OBSERVER_URL, (String) null))) {
            editTextPreference.setText(UASToolDropDownReceiver.getInstance().getVideoBroadcastDestinationUrl());
        }
        EditTextPreference editTextPreference2 = (EditTextPreference) findPreference(PREF_BROADCAST_PATH);
        if (TextUtils.isEmpty(this.sharedPrefs.getString(PREF_BROADCAST_PATH, (String) null))) {
            editTextPreference2.setText(UASToolDropDownReceiver.getInstance().buildDefaultVideoBroadcastPath());
        }
        EditTextPreference editTextPreference3 = (EditTextPreference) findPreference(PREF_VIDEO_DEST_PORT);
        if (editTextPreference3.isEnabled() && TextUtils.isEmpty(this.sharedPrefs.getString(PREF_VIDEO_DEST_PORT, (String) null))) {
            editTextPreference3.setText(UASToolDropDownReceiver.getInstance().getVideoBroadcastDestinationPort());
        }
        EditTextPreference editTextPreference4 = (EditTextPreference) findPreference(PREF_VIDEO_DEST_PORT_MULTICAST);
        if (editTextPreference4.isEnabled() && TextUtils.isEmpty(this.sharedPrefs.getString(PREF_VIDEO_DEST_PORT_MULTICAST, (String) null))) {
            editTextPreference4.setText(UASToolDropDownReceiver.getInstance().getVideoBroadcastDestinationPort());
        }
    }

    public static class HostnameIpFilter implements InputFilter {
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            while (i < i2) {
                if (Character.isWhitespace(charSequence.charAt(i))) {
                    return "";
                }
                i++;
            }
            return null;
        }
    }

    public static class HostOrIpWatcher implements TextWatcher {
        private ColorStateList oldColors;
        private Context pluginContext;
        private EditTextPreference pref;
        private String summary;
        private TextView textView;

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public HostOrIpWatcher(Context context, EditTextPreference editTextPreference, String str) {
            this.pluginContext = context;
            this.pref = editTextPreference;
            this.summary = str;
        }

        public HostOrIpWatcher(TextView textView2) {
            this.textView = textView2;
            this.oldColors = textView2.getTextColors();
        }

        public void afterTextChanged(Editable editable) {
            String obj = editable.toString();
            if (TextUtils.isEmpty(obj) || k.c(obj)) {
                EditTextPreference editTextPreference = this.pref;
                if (editTextPreference != null) {
                    editTextPreference.setSummary(this.summary);
                    return;
                }
                TextView textView2 = this.textView;
                if (textView2 != null) {
                    textView2.setTextColor(this.oldColors);
                }
            } else if (this.pref != null) {
                SpannableString spannableString = new SpannableString(this.pluginContext.getResources().getString(C1877R.string.invalid_hostname_or_ip));
                spannableString.setSpan(new ForegroundColorSpan(-65536), 0, spannableString.length(), 0);
                this.pref.setSummary(spannableString);
            } else {
                TextView textView3 = this.textView;
                if (textView3 != null) {
                    textView3.setTextColor(-65536);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void setLastOctetSummary() {
        String str;
        boolean z = !this.sharedPrefs.getString(PREF_BROADCAST_DESTINATION, this.g.getResources().getStringArray(C1877R.array.video_destination)[0]).contains("Wowza");
        Preference findPreference = findPreference(PREF_VIDEO_DEST_LASTOCTET);
        boolean z2 = this.sharedPrefs.getBoolean(PREF_VIDEO_DEST_LASTOCTET, true);
        if (!z || !z2) {
            str = "";
        } else {
            str = "URL: " + UASToolDropDownReceiver.getInstance().getVideoBroadcastDestinationUrl();
        }
        findPreference.setSummary(str);
    }

    /* access modifiers changed from: private */
    public void checkUpdateObserverUrl() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Observer URL Update");
        builder.setMessage("Preference used in auto-generated observer URL has changed." + "\n\nUpdate Video Observer URL?");
        builder.setPositiveButton("Yes, Update", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                NetworkPreferenceFragment.this.updateObserverUrl();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.show();
    }

    /* access modifiers changed from: private */
    public void updateObserverUrl() {
        EditTextPreference editTextPreference = (EditTextPreference) findPreference(PREF_VIDEO_OBSERVER_URL);
        editTextPreference.setText((String) null);
        editTextPreference.setText(UASToolDropDownReceiver.getInstance().getVideoBroadcastDestinationUrl());
    }

    public static String[] getNetworkDeviceList() {
        List<j.a> a = j.a();
        int i = 1;
        String[] strArr = new String[(a.size() + 1)];
        strArr[0] = "System Default";
        for (j.a aVar : a) {
            strArr[i] = aVar.b;
            i++;
        }
        return strArr;
    }

    /* access modifiers changed from: private */
    public void setNetworkPreferencesState() {
        boolean z = false;
        boolean z2 = !this.sharedPrefs.getString(PREF_BROADCAST_DESTINATION, this.g.getResources().getStringArray(C1877R.array.video_destination)[0]).contains("Wowza");
        boolean z3 = this.sharedPrefs.getBoolean(PREF_VIDEO_DEST_LASTOCTET, true);
        a(findPreference(PREF_DESTINATION_IP), !z2);
        a(findPreference(PREF_VIDEO_DEST_PORT), !z2);
        a(findPreference(PREF_BROADCAST_PATH), !z2);
        a(findPreference(PREF_BROADCAST_SSL), !z2);
        a(findPreference(PREF_VIDEO_DEST_ADAPTER), z2);
        a(findPreference(PREF_VIDEO_DEST_LASTOCTET), z2);
        a(findPreference(PREF_DESTINATION_IP_MULTICAST), z2 && !z3);
        a(findPreference(PREF_VIDEO_DEST_PORT_MULTICAST), z2 && !z3);
        Preference findPreference = findPreference(PREF_VIDEO_OBSERVER_URL);
        if (!z2 || !z3) {
            z = true;
        }
        a(findPreference, z);
    }

    private void videoDestAdapterChanged(String str) {
        ((ListPreference) findPreference(PREF_VIDEO_DEST_ADAPTER)).setValue(str);
        TextUtils.isEmpty(str);
    }

    public boolean validateIP(String str) {
        if (str != null) {
            return IPV4.matcher(str).matches();
        }
        return false;
    }

    private void dynamicPortRequest(final String str) {
        C19215 r0 = new Thread() {
            /* JADX WARNING: Can't wrap try/catch for region: R(2:15|16) */
            /* JADX WARNING: Can't wrap try/catch for region: R(5:0|(12:1|2|3|4|5|6|7|8|(2:10|11)|(1:13)(1:14)|17|18)|19|20|68) */
            /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
                com.atakmap.coremap.log.Log.d("PluginPreferenceFragment", "Number format exception in dynamic port response " + r1);
                com.atakmap.android.uastool.prefs.NetworkPreferenceFragment.access$600(r6.this$0, "An invalid response received during dynamic port request");
             */
            /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
                return;
             */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x004f */
            /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006d */
            /* JADX WARNING: Removed duplicated region for block: B:38:0x0093 A[SYNTHETIC, Splitter:B:38:0x0093] */
            /* JADX WARNING: Removed duplicated region for block: B:49:0x00ad A[SYNTHETIC, Splitter:B:49:0x00ad] */
            /* JADX WARNING: Removed duplicated region for block: B:57:0x00ba A[SYNTHETIC, Splitter:B:57:0x00ba] */
            /* JADX WARNING: Removed duplicated region for block: B:61:0x00c1 A[SYNTHETIC, Splitter:B:61:0x00c1] */
            /* JADX WARNING: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
            /* JADX WARNING: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r6 = this;
                    java.lang.String r0 = "PluginPreferenceFragment"
                    r1 = 0
                    java.net.Socket r2 = new java.net.Socket     // Catch:{ ConnectException -> 0x009b, Exception -> 0x0081, all -> 0x007e }
                    java.lang.String r3 = r4     // Catch:{ ConnectException -> 0x009b, Exception -> 0x0081, all -> 0x007e }
                    r4 = 1936(0x790, float:2.713E-42)
                    r2.<init>(r3, r4)     // Catch:{ ConnectException -> 0x009b, Exception -> 0x0081, all -> 0x007e }
                    java.io.DataOutputStream r3 = new java.io.DataOutputStream     // Catch:{ ConnectException -> 0x009b, Exception -> 0x0081, all -> 0x007e }
                    java.io.OutputStream r4 = r2.getOutputStream()     // Catch:{ ConnectException -> 0x009b, Exception -> 0x0081, all -> 0x007e }
                    r3.<init>(r4)     // Catch:{ ConnectException -> 0x009b, Exception -> 0x0081, all -> 0x007e }
                    java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ ConnectException -> 0x007b, Exception -> 0x0078, all -> 0x0075 }
                    java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ ConnectException -> 0x007b, Exception -> 0x0078, all -> 0x0075 }
                    java.io.InputStream r2 = r2.getInputStream()     // Catch:{ ConnectException -> 0x007b, Exception -> 0x0078, all -> 0x0075 }
                    r5.<init>(r2)     // Catch:{ ConnectException -> 0x007b, Exception -> 0x0078, all -> 0x0075 }
                    r4.<init>(r5)     // Catch:{ ConnectException -> 0x007b, Exception -> 0x0078, all -> 0x0075 }
                    java.lang.String r1 = "0\n"
                    r3.writeBytes(r1)     // Catch:{ ConnectException -> 0x0073, Exception -> 0x0071 }
                    java.lang.String r1 = r4.readLine()     // Catch:{ ConnectException -> 0x0073, Exception -> 0x0071 }
                    com.atakmap.android.uastool.prefs.NetworkPreferenceFragment r2 = com.atakmap.android.uastool.prefs.NetworkPreferenceFragment.this     // Catch:{ ConnectException -> 0x0073, Exception -> 0x0071 }
                    java.lang.String r5 = ""
                    r2.setErrMsg(r5)     // Catch:{ ConnectException -> 0x0073, Exception -> 0x0071 }
                    r2 = 0
                    if (r1 == 0) goto L_0x003a
                    int r2 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x004f }
                L_0x003a:
                    if (r2 != 0) goto L_0x0049
                    java.lang.String r2 = "Dynamic port request received 0 - no available ports"
                    com.atakmap.coremap.log.Log.d(r0, r2)     // Catch:{ NumberFormatException -> 0x004f }
                    com.atakmap.android.uastool.prefs.NetworkPreferenceFragment r2 = com.atakmap.android.uastool.prefs.NetworkPreferenceFragment.this     // Catch:{ NumberFormatException -> 0x004f }
                    java.lang.String r5 = "No available video input ports"
                    r2.setErrMsg(r5)     // Catch:{ NumberFormatException -> 0x004f }
                    goto L_0x006a
                L_0x0049:
                    java.lang.String r2 = "Set dynamic update to true"
                    com.atakmap.coremap.log.Log.d(r0, r2)     // Catch:{ NumberFormatException -> 0x004f }
                    goto L_0x006a
                L_0x004f:
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ ConnectException -> 0x0073, Exception -> 0x0071 }
                    r2.<init>()     // Catch:{ ConnectException -> 0x0073, Exception -> 0x0071 }
                    java.lang.String r5 = "Number format exception in dynamic port response "
                    r2.append(r5)     // Catch:{ ConnectException -> 0x0073, Exception -> 0x0071 }
                    r2.append(r1)     // Catch:{ ConnectException -> 0x0073, Exception -> 0x0071 }
                    java.lang.String r1 = r2.toString()     // Catch:{ ConnectException -> 0x0073, Exception -> 0x0071 }
                    com.atakmap.coremap.log.Log.d(r0, r1)     // Catch:{ ConnectException -> 0x0073, Exception -> 0x0071 }
                    com.atakmap.android.uastool.prefs.NetworkPreferenceFragment r1 = com.atakmap.android.uastool.prefs.NetworkPreferenceFragment.this     // Catch:{ ConnectException -> 0x0073, Exception -> 0x0071 }
                    java.lang.String r2 = "An invalid response received during dynamic port request"
                    r1.setErrMsg(r2)     // Catch:{ ConnectException -> 0x0073, Exception -> 0x0071 }
                L_0x006a:
                    r3.close()     // Catch:{ IOException -> 0x006d }
                L_0x006d:
                    r4.close()     // Catch:{ IOException -> 0x00b5 }
                    goto L_0x00b5
                L_0x0071:
                    r1 = move-exception
                    goto L_0x0085
                L_0x0073:
                    r1 = move-exception
                    goto L_0x009f
                L_0x0075:
                    r0 = move-exception
                    r4 = r1
                    goto L_0x00b7
                L_0x0078:
                    r2 = move-exception
                    r4 = r1
                    goto L_0x0084
                L_0x007b:
                    r2 = move-exception
                    r4 = r1
                    goto L_0x009e
                L_0x007e:
                    r0 = move-exception
                    r4 = r1
                    goto L_0x00b8
                L_0x0081:
                    r2 = move-exception
                    r3 = r1
                    r4 = r3
                L_0x0084:
                    r1 = r2
                L_0x0085:
                    java.lang.String r2 = "Error during dynamic port request"
                    com.atakmap.coremap.log.Log.d(r0, r2, r1)     // Catch:{ all -> 0x00b6 }
                    com.atakmap.android.uastool.prefs.NetworkPreferenceFragment r0 = com.atakmap.android.uastool.prefs.NetworkPreferenceFragment.this     // Catch:{ all -> 0x00b6 }
                    java.lang.String r1 = "An error occurred during dynamic port request"
                    r0.setErrMsg(r1)     // Catch:{ all -> 0x00b6 }
                    if (r3 == 0) goto L_0x0098
                    r3.close()     // Catch:{ IOException -> 0x0097 }
                    goto L_0x0098
                L_0x0097:
                L_0x0098:
                    if (r4 == 0) goto L_0x00b5
                    goto L_0x006d
                L_0x009b:
                    r2 = move-exception
                    r3 = r1
                    r4 = r3
                L_0x009e:
                    r1 = r2
                L_0x009f:
                    java.lang.String r2 = "Connection exception"
                    com.atakmap.coremap.log.Log.d(r0, r2, r1)     // Catch:{ all -> 0x00b6 }
                    com.atakmap.android.uastool.prefs.NetworkPreferenceFragment r0 = com.atakmap.android.uastool.prefs.NetworkPreferenceFragment.this     // Catch:{ all -> 0x00b6 }
                    java.lang.String r1 = "Unable to connect to port request server"
                    r0.setErrMsg(r1)     // Catch:{ all -> 0x00b6 }
                    if (r3 == 0) goto L_0x00b2
                    r3.close()     // Catch:{ IOException -> 0x00b1 }
                    goto L_0x00b2
                L_0x00b1:
                L_0x00b2:
                    if (r4 == 0) goto L_0x00b5
                    goto L_0x006d
                L_0x00b5:
                    return
                L_0x00b6:
                    r0 = move-exception
                L_0x00b7:
                    r1 = r3
                L_0x00b8:
                    if (r1 == 0) goto L_0x00bf
                    r1.close()     // Catch:{ IOException -> 0x00be }
                    goto L_0x00bf
                L_0x00be:
                L_0x00bf:
                    if (r4 == 0) goto L_0x00c4
                    r4.close()     // Catch:{ IOException -> 0x00c4 }
                L_0x00c4:
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.prefs.NetworkPreferenceFragment.C19215.run():void");
            }
        };
        r0.start();
        while (r0.getState() != Thread.State.TERMINATED) {
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                Log.d("PluginPreferenceFragment", "Exception encountered while waiting for dynamic port request to complete", e);
            }
        }
        getErrMsg().isEmpty();
    }

    /* access modifiers changed from: private */
    public void setErrMsg(String str) {
        this.errMsg = str;
    }

    private String getErrMsg() {
        return this.errMsg;
    }
}

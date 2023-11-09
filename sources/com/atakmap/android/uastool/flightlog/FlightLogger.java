package com.atakmap.android.uastool.flightlog;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.JsonWriter;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.maps.ao;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.coremap.filesystem.FileSystemUtils;
import com.atakmap.coremap.locale.LocaleUtil;
import com.atakmap.coremap.log.Log;
import com.atakmap.coremap.maps.coords.GeoPoint;
import com.atakmap.coremap.maps.time.CoordinatedTime;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class FlightLogger {
    public static final String CURRENT_VERSION_NUMBER = "1.0";
    public static final String DIRPATH_LOGS;
    public static final String DIRPATH_TEMP;
    public static final String LOCS_ALTITUDE = "alt";
    public static final String LOCS_COMMAND = "command";
    public static final String LOCS_DATE = "date";
    public static final String LOCS_HEADING = "heading";
    public static final String LOCS_LATITUDE = "lat";
    public static final String LOCS_LONGITUDE = "lon";
    public static final String LOCS_MESSAGE = "message";
    public static final String LOCS_SPEED = "spd";
    public static final String LOG_CALLSIGN = "callsign";
    public static final String LOG_LOCATIONS = "locations";
    private static final long LOG_PERIOD_IN_SECONDS = 2;
    public static final String LOG_PLATFORM = "platform";
    public static final String LOG_TIMESTAMP = "timestamp";
    public static final String LOG_UID = "UID";
    public static final String LOG_VERSION = "version";
    private static final String TAG = FlightLogger.class.getSimpleName();
    private static FlightLogger _instance;
    private final SharedPreferences atakPrefs;
    private String currentFileName;
    private Boolean isLogging = false;
    private Boolean isLoggingEnabled = false;
    private JsonWriter jsonWriter = null;
    private final HashMap<String, FlightLog> loadedLogs;
    private ScheduledExecutorService logScheduledExecutor = null;
    private File logStorage = null;
    private PrintWriter printWriter = null;
    private File tempStorage = null;
    private UASItem uasItem = null;

    static {
        String str = FileSystemUtils.getRoot().getPath() + File.separatorChar + "tools" + File.separatorChar + "uastool" + File.separator + "logs";
        DIRPATH_LOGS = str;
        DIRPATH_TEMP = str + File.separator + "temp";
    }

    private FlightLogger() {
        File file = new File(DIRPATH_LOGS);
        this.logStorage = file;
        if (!file.exists()) {
            this.logStorage.mkdir();
        }
        File file2 = new File(DIRPATH_TEMP);
        this.tempStorage = file2;
        if (!file2.exists()) {
            this.tempStorage.mkdir();
        }
        FileSystemUtils.clearDirectory(this.tempStorage);
        this.isLogging = false;
        this.isLoggingEnabled = false;
        this.uasItem = null;
        this.atakPrefs = PreferenceManager.getDefaultSharedPreferences(MapView.getMapView().getContext());
        this.loadedLogs = new HashMap<>();
    }

    public static synchronized FlightLogger getInstance() {
        FlightLogger flightLogger;
        synchronized (FlightLogger.class) {
            if (_instance == null) {
                _instance = new FlightLogger();
            }
            flightLogger = _instance;
        }
        return flightLogger;
    }

    public boolean isLogging() {
        return this.isLogging.booleanValue();
    }

    public void setFlightLogEnabled(boolean z) {
        this.isLoggingEnabled = Boolean.valueOf(z);
    }

    public void startLogger(UASItem uASItem) {
        if (this.isLoggingEnabled.booleanValue()) {
            String str = TAG;
            Log.d(str, "Starting flight logger....");
            if (uASItem != null) {
                this.uasItem = uASItem;
                if (uASItem.isDefault() && this.uasItem.isConnected()) {
                    Log.d(str, "Connected....");
                    if (this.isLogging.booleanValue()) {
                        stopLogger();
                    }
                    PrintWriter createLogFile = createLogFile(this.uasItem.getCallsign());
                    this.printWriter = createLogFile;
                    if (createLogFile != null) {
                        JsonWriter jsonWriter2 = new JsonWriter(this.printWriter);
                        this.jsonWriter = jsonWriter2;
                        if (jsonWriter2 != null) {
                            createLogHeader();
                            this.isLogging = true;
                            ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
                            this.logScheduledExecutor = newSingleThreadScheduledExecutor;
                            newSingleThreadScheduledExecutor.scheduleAtFixedRate(new Runnable() {
                                public void run() {
                                    FlightLogger.this.writeLogData((String) null, (String) null);
                                }
                            }, 0, LOG_PERIOD_IN_SECONDS, TimeUnit.SECONDS);
                        }
                    }
                }
            }
        }
    }

    public void stopLogger() {
        Log.d(TAG, "Stopping flight logger....");
        if (this.isLogging.booleanValue()) {
            ScheduledExecutorService scheduledExecutorService = this.logScheduledExecutor;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
                this.logScheduledExecutor = null;
            }
            this.isLogging = false;
            try {
                JsonWriter jsonWriter2 = this.jsonWriter;
                if (jsonWriter2 != null) {
                    jsonWriter2.endArray();
                    this.jsonWriter.endObject();
                    this.jsonWriter.close();
                }
                PrintWriter printWriter2 = this.printWriter;
                if (printWriter2 != null) {
                    printWriter2.close();
                }
            } catch (Exception e) {
                Log.e(TAG, "Error stopping flight logger", e);
            } catch (Throwable th) {
                this.jsonWriter = null;
                this.printWriter = null;
                this.isLogging = false;
                throw th;
            }
            this.jsonWriter = null;
            this.printWriter = null;
            this.isLogging = false;
            if (!TextUtils.isEmpty(this.currentFileName)) {
                try {
                    if (!new File(this.tempStorage, this.currentFileName).renameTo(new File(this.logStorage, this.currentFileName))) {
                        Log.w(TAG, "Unable to move flight log");
                        UASToolDropDownReceiver.toast("Unable to move flight log", 0);
                    } else {
                        UASToolDropDownReceiver.getInstance().refreshFlightLogs();
                    }
                    this.currentFileName = null;
                } catch (Exception e2) {
                    Log.e(TAG, "Exception while moving flight log", e2);
                    UASToolDropDownReceiver.toast("Exception while moving flight log: " + e2.getLocalizedMessage(), 0);
                }
            }
        }
    }

    private PrintWriter createLogFile(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", LocaleUtil.getCurrent());
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date currentDate = CoordinatedTime.currentDate();
        this.currentFileName = str + "_" + simpleDateFormat.format(currentDate) + ".json";
        try {
            String str2 = TAG;
            Log.d(str2, "Creating flight log file....");
            File file = new File(this.tempStorage, this.currentFileName);
            FileSystemUtils.deleteFile(file);
            if (file.createNewFile()) {
                return new PrintWriter(new FileWriter(file));
            }
            Log.d(str2, "Error creating flight log file: " + file);
            return null;
        } catch (Exception e) {
            Log.e(TAG, "Error creating flight log file", e);
            return null;
        }
    }

    private void createLogHeader() {
        JsonWriter jsonWriter2 = this.jsonWriter;
        if (jsonWriter2 != null && this.uasItem != null) {
            try {
                jsonWriter2.setIndent("  ");
                this.jsonWriter.beginObject();
                this.jsonWriter.name("UID");
                JsonWriter jsonWriter3 = this.jsonWriter;
                jsonWriter3.value(FlightLogImporter.LOG_FILE_ID + this.uasItem.getUid());
                this.jsonWriter.name(LOG_CALLSIGN);
                this.jsonWriter.value(this.uasItem.getCallsign());
                this.jsonWriter.name("platform");
                this.jsonWriter.value(this.uasItem.getPlatformType());
                this.jsonWriter.name(LOG_TIMESTAMP);
                this.jsonWriter.value(new CoordinatedTime().getMilliseconds());
                this.jsonWriter.name("version");
                this.jsonWriter.value("1.0");
                this.jsonWriter.name(LOG_LOCATIONS);
                this.jsonWriter.beginArray();
            } catch (Exception e) {
                Log.e(TAG, "Error creating flight log header", e);
            }
        }
    }

    public void writeCommandLog(String str) {
        writeLogData((String) null, str);
    }

    public void writeMessageLog(String str) {
        writeLogData(str, (String) null);
    }

    /* access modifiers changed from: private */
    public void writeLogData(String str, String str2) {
        if (this.jsonWriter != null && this.isLogging.booleanValue() && this.isLoggingEnabled.booleanValue() && this.uasItem != null) {
            try {
                UASItem findUASItem = UASToolDropDownReceiver.getInstance().findUASItem(this.uasItem.getUid());
                if (findUASItem != null) {
                    if (!findUASItem.isDefault() || !findUASItem.isConnected()) {
                        stopLogger();
                        return;
                    }
                    ao marker = findUASItem.getMarker();
                    if (marker != null) {
                        double metaDouble = marker.getMetaDouble("track:speed", 0.0d);
                        double metaDouble2 = marker.getMetaDouble("track:course", 0.0d);
                        GeoPoint C = marker.C();
                        if (C != null) {
                            this.jsonWriter.beginObject();
                            this.jsonWriter.name(LOCS_DATE);
                            this.jsonWriter.value(CoordinatedTime.currentDate().toString());
                            this.jsonWriter.name(LOCS_LATITUDE);
                            this.jsonWriter.value(Double.toString(C.getLatitude()));
                            this.jsonWriter.name(LOCS_LONGITUDE);
                            this.jsonWriter.value(Double.toString(C.getLongitude()));
                            this.jsonWriter.name(LOCS_ALTITUDE);
                            this.jsonWriter.value(Double.toString(C.getAltitude()));
                            this.jsonWriter.name(LOCS_SPEED);
                            this.jsonWriter.value(Double.toString(metaDouble));
                            this.jsonWriter.name("heading");
                            this.jsonWriter.value(Double.toString(metaDouble2));
                            if (!TextUtils.isEmpty(str2)) {
                                this.jsonWriter.name(LOCS_COMMAND);
                                this.jsonWriter.value(str2);
                            }
                            if (!TextUtils.isEmpty(str)) {
                                this.jsonWriter.name("message");
                                this.jsonWriter.value(str);
                            }
                            this.jsonWriter.endObject();
                        }
                    }
                } else if (isLogging()) {
                    stopLogger();
                }
            } catch (Exception e) {
                if (isLogging()) {
                    stopLogger();
                }
                Log.e(TAG, "Error logging flight data", e);
            }
        }
    }

    public void deleteAllLogFiles() {
        for (FlightLog fileName : getLogs(false)) {
            deleteLogFile(fileName.getFileName());
        }
    }

    public boolean deleteLogFile(String str) {
        File[] listFiles;
        try {
            if (!this.logStorage.exists() || (listFiles = this.logStorage.listFiles()) == null) {
                return false;
            }
            int length = listFiles.length;
            int i = 0;
            while (i < length) {
                File file = listFiles[i];
                if (!file.getName().equals(str)) {
                    i++;
                } else if (file.delete()) {
                    return true;
                } else {
                    String str2 = TAG;
                    Log.d(str2, "Error deleting flight log: " + file.getName());
                    return false;
                }
            }
            return false;
        } catch (Exception e) {
            Log.e(TAG, "Error deleting flight log", e);
            return false;
        }
    }

    public List<FlightLog> getLogs(boolean z) {
        File[] listFiles;
        ArrayList arrayList = new ArrayList();
        File file = new File(DIRPATH_LOGS);
        if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    arrayList.add(new FlightLog(file2.getAbsolutePath()));
                }
            }
        }
        if (z) {
            Collections.sort(arrayList, Collections.reverseOrder());
        } else {
            Collections.sort(arrayList);
        }
        return arrayList;
    }

    public ArrayList<String> getLogNames(boolean z) {
        File[] listFiles;
        ArrayList<String> arrayList = new ArrayList<>();
        File file = new File(DIRPATH_LOGS);
        if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    arrayList.add(file2.getName());
                }
            }
        }
        if (z) {
            Collections.sort(arrayList, Collections.reverseOrder());
        } else {
            Collections.sort(arrayList);
        }
        return arrayList;
    }

    public FlightLog getLogByName(String str) {
        File[] listFiles;
        FlightLog flightLog = this.loadedLogs.get(str);
        if (flightLog != null) {
            return flightLog;
        }
        File file = new File(DIRPATH_LOGS);
        if (!file.exists() || (listFiles = file.listFiles()) == null || listFiles.length <= 0) {
            return flightLog;
        }
        int length = listFiles.length;
        int i = 0;
        while (i < length) {
            File file2 = listFiles[i];
            if (!file2.isFile() || !file2.getName().equals(str)) {
                i++;
            } else {
                FlightLog flightLog2 = new FlightLog(file2.getAbsolutePath());
                this.loadedLogs.put(str, flightLog2);
                return flightLog2;
            }
        }
        return flightLog;
    }
}

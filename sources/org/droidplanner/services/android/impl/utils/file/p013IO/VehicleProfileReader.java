package org.droidplanner.services.android.impl.utils.file.p013IO;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Xml;
import com.o3dr.android.client.utils.FileUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.droidplanner.services.android.impl.core.drone.profiles.VehicleProfile;
import org.droidplanner.services.android.impl.core.firmware.FirmwareType;
import org.droidplanner.services.android.impl.utils.file.AssetUtil;
import org.droidplanner.services.android.impl.utils.file.DirectoryPath;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: org.droidplanner.services.android.impl.utils.file.IO.VehicleProfileReader */
public class VehicleProfileReader {
    private static final String ATTR_MAX_ALTITUDE = "maxAltitude";
    private static final String ATTR_TYPE = "type";
    private static final String ATTR_WPNAV_SPEED = "wpNavSpeed";
    private static final String TAG_DEFAULT = "Default";
    private static final String TAG_METADATATYPE = "ParameterMetadataType";
    private static final String VEHICLEPROFILE_PATH = "VehicleProfiles";

    public static VehicleProfile load(Context context, FirmwareType firmwareType) {
        String str = firmwareType + FileUtils.CAMERA_FILENAME_EXT;
        String str2 = VEHICLEPROFILE_PATH + File.separator + str;
        try {
            VehicleProfile vehicleProfile = new VehicleProfile();
            File file = new File(DirectoryPath.getPublicDataPath(context) + str2);
            if (file.exists()) {
                loadProfileFromFile(vehicleProfile, file);
            } else {
                loadProfileFromResources(context, str, str2, vehicleProfile);
            }
            return vehicleProfile;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void loadProfileFromFile(VehicleProfile vehicleProfile, File file) {
        open(new FileInputStream(file), vehicleProfile);
    }

    private static void loadProfileFromResources(Context context, String str, String str2, VehicleProfile vehicleProfile) {
        AssetManager assets = context.getAssets();
        if (AssetUtil.exists(assets, VEHICLEPROFILE_PATH, str)) {
            open(assets.open(str2), vehicleProfile);
        }
    }

    private static void open(InputStream inputStream, VehicleProfile vehicleProfile) {
        try {
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
            newPullParser.setInput(inputStream, (String) null);
            parse(newPullParser, vehicleProfile);
        } finally {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    private static void parse(XmlPullParser xmlPullParser, VehicleProfile vehicleProfile) {
        int eventType = xmlPullParser.getEventType();
        while (eventType != 1) {
            String name = xmlPullParser.getName();
            if (eventType == 2) {
                if (name.equals(TAG_METADATATYPE)) {
                    String attributeValue = xmlPullParser.getAttributeValue((String) null, ATTR_TYPE);
                    if (attributeValue != null) {
                        vehicleProfile.setParameterMetadataType(attributeValue);
                    }
                } else if (name.equals(TAG_DEFAULT)) {
                    parseDefault(xmlPullParser, vehicleProfile.getDefault());
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    private static void parseDefault(XmlPullParser xmlPullParser, VehicleProfile.Default defaultR) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, ATTR_WPNAV_SPEED);
        if (attributeValue != null) {
            defaultR.setWpNavSpeed(parseInt(attributeValue));
        }
        String attributeValue2 = xmlPullParser.getAttributeValue((String) null, ATTR_MAX_ALTITUDE);
        if (attributeValue2 != null) {
            defaultR.setMaxAltitude(parseInt(attributeValue2));
        }
    }

    private static int parseInt(String str) {
        if (str == null) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }
}

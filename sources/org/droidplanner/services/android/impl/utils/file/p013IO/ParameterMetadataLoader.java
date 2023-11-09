package org.droidplanner.services.android.impl.utils.file.p013IO;

import android.content.Context;
import android.util.Xml;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import org.droidplanner.services.android.impl.core.drone.profiles.ParameterMetadata;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: org.droidplanner.services.android.impl.utils.file.IO.ParameterMetadataLoader */
public class ParameterMetadataLoader {
    private static final String METADATA_DESCRIPTION = "Description";
    private static final String METADATA_DISPLAYNAME = "DisplayName";
    private static final String METADATA_RANGE = "Range";
    private static final String METADATA_UNITS = "Units";
    private static final String METADATA_VALUES = "Values";
    private static final String PARAMETERMETADATA_PATH = "Parameters/ParameterMetaData.xml";

    public static void load(Context context, String str, Map<String, ParameterMetadata> map) {
        open(context.getAssets().open(PARAMETERMETADATA_PATH), str, map);
    }

    private static void open(InputStream inputStream, String str, Map<String, ParameterMetadata> map) {
        try {
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
            newPullParser.setInput(inputStream, (String) null);
            parseMetadata(newPullParser, str, map);
        } finally {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    private static void parseMetadata(XmlPullParser xmlPullParser, String str, Map<String, ParameterMetadata> map) {
        map.clear();
        int eventType = xmlPullParser.getEventType();
        boolean z = false;
        ParameterMetadata parameterMetadata = null;
        while (eventType != 1) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (str.equals(name)) {
                    z = true;
                } else if (z) {
                    if (parameterMetadata == null) {
                        parameterMetadata = new ParameterMetadata();
                        parameterMetadata.setName(name);
                    } else {
                        addMetaDataProperty(parameterMetadata, name, xmlPullParser.nextText());
                    }
                }
            } else if (eventType != 3) {
                continue;
            } else {
                String name2 = xmlPullParser.getName();
                if (!str.equals(name2)) {
                    if (parameterMetadata != null && parameterMetadata.getName().equals(name2)) {
                        map.put(parameterMetadata.getName(), parameterMetadata);
                        parameterMetadata = null;
                    }
                } else {
                    return;
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    private static void addMetaDataProperty(ParameterMetadata parameterMetadata, String str, String str2) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1739945662:
                if (str.equals(METADATA_VALUES)) {
                    c = 0;
                    break;
                }
                break;
            case -912949683:
                if (str.equals(METADATA_DISPLAYNAME)) {
                    c = 1;
                    break;
                }
                break;
            case -56677412:
                if (str.equals(METADATA_DESCRIPTION)) {
                    c = 2;
                    break;
                }
                break;
            case 78727453:
                if (str.equals("Range")) {
                    c = 3;
                    break;
                }
                break;
            case 81880911:
                if (str.equals(METADATA_UNITS)) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                parameterMetadata.setValues(str2);
                return;
            case 1:
                parameterMetadata.setDisplayName(str2);
                return;
            case 2:
                parameterMetadata.setDescription(str2);
                return;
            case 3:
                parameterMetadata.setRange(str2);
                return;
            case 4:
                parameterMetadata.setUnits(str2);
                return;
            default:
                return;
        }
    }
}

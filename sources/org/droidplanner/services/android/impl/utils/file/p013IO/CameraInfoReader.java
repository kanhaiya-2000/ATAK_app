package org.droidplanner.services.android.impl.utils.file.p013IO;

import android.util.Xml;
import java.io.InputStream;
import org.droidplanner.services.android.impl.core.survey.CameraInfo;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: org.droidplanner.services.android.impl.utils.file.IO.CameraInfoReader */
public class CameraInfoReader {
    private CameraInfo cameraInfo = new CameraInfo();
    private XmlPullParser parser;

    public void openFile(InputStream inputStream) {
        parse(inputStream);
        inputStream.close();
    }

    public CameraInfo getCameraInfo() {
        return this.cameraInfo;
    }

    public void parse(InputStream inputStream) {
        XmlPullParser newPullParser = Xml.newPullParser();
        this.parser = newPullParser;
        newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
        this.parser.setInput(inputStream, (String) null);
        this.parser.nextTag();
        readCameraInfo();
    }

    private void readCameraInfo() {
        this.parser.require(2, (String) null, "cameraInfo");
        while (this.parser.next() != 3) {
            if (this.parser.getEventType() == 2) {
                String name = this.parser.getName();
                if (name.equals("SensorWidth")) {
                    this.cameraInfo.sensorWidth = readDouble("SensorWidth");
                } else if (name.equals("SensorHeight")) {
                    this.cameraInfo.sensorHeight = readDouble("SensorHeight");
                } else if (name.equals("SensorResolution")) {
                    this.cameraInfo.sensorResolution = readDouble("SensorResolution");
                } else if (name.equals("FocalLength")) {
                    this.cameraInfo.focalLength = readDouble("FocalLength");
                } else if (name.equals("Overlap")) {
                    this.cameraInfo.overlap = readDouble("Overlap");
                } else if (name.equals("Sidelap")) {
                    this.cameraInfo.sidelap = readDouble("Sidelap");
                } else if (name.equals("Name")) {
                    this.cameraInfo.name = readString("Name");
                } else if (name.equals("Orientation")) {
                    this.cameraInfo.isInLandscapeOrientation = !readText().equals("Portrait");
                } else {
                    skip();
                }
            }
        }
    }

    private String readString(String str) {
        this.parser.require(2, (String) null, str);
        String readText = readText();
        this.parser.require(3, (String) null, str);
        return readText;
    }

    private Double readDouble(String str) {
        this.parser.require(2, (String) null, str);
        Double valueOf = Double.valueOf(readText());
        this.parser.require(3, (String) null, str);
        return valueOf;
    }

    private String readText() {
        if (this.parser.next() != 4) {
            return "";
        }
        String text = this.parser.getText();
        this.parser.nextTag();
        return text;
    }

    private void skip() {
        if (this.parser.getEventType() == 2) {
            int i = 1;
            while (i != 0) {
                int next = this.parser.next();
                if (next == 2) {
                    i++;
                } else if (next == 3) {
                    i--;
                }
            }
            return;
        }
        throw new IllegalStateException();
    }
}

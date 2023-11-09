package atakplugin.UASTool;

import com.atakmap.android.uastool.tasks.route.UASPoint;
import com.autel.util.log.LogTask;
import java.util.Locale;

public class byw extends byu {

    /* renamed from: a */
    private static final String f4308a = "111111";

    /* renamed from: b */
    public String mo4075b(String str) {
        if (str == null || str.length() == 0) {
            return f4308a;
        }
        String replaceAll = str.toLowerCase(Locale.ENGLISH).replaceAll("[^a-z]", "").replaceAll("^cough", "cou2f").replaceAll("^rough", "rou2f").replaceAll("^tough", "tou2f").replaceAll("^enough", "enou2f").replaceAll("^gn", "2n").replaceAll("mb$", "m2").replaceAll("cq", "2q").replaceAll("ci", "si").replaceAll(UASPoint.COTDETAIL_CE, "se").replaceAll("cy", "sy").replaceAll("tch", "2ch").replaceAll("c", "k").replaceAll("q", "k").replaceAll("x", "k").replaceAll("v", "f").replaceAll("dg", "2g").replaceAll("tio", "sio").replaceAll("tia", "sia").replaceAll(LogTask.LOG_TYPE_DEBUG, "t").replaceAll("ph", "fh").replaceAll("b", "p").replaceAll("sh", "s2").replaceAll("z", "s").replaceAll("^[aeiou]", "A").replaceAll("[aeiou]", "3").replaceAll("3gh3", "3kh3").replaceAll("gh", "22").replaceAll("g", "k").replaceAll("s+", "S").replaceAll("t+", "T").replaceAll("p+", "P").replaceAll("k+", "K").replaceAll("f+", "F").replaceAll("m+", "M").replaceAll("n+", "N").replaceAll("w3", "W3").replaceAll("wy", "Wy").replaceAll("wh3", "Wh3").replaceAll("why", "Why").replaceAll(LogTask.LOG_TYPE_WARN, "2").replaceAll("^h", "A").replaceAll("h", "2").replaceAll("r3", "R3").replaceAll("ry", "Ry").replaceAll("r", "2").replaceAll("l3", "L3").replaceAll("ly", "Ly").replaceAll("l", "2").replaceAll("j", "y").replaceAll("y3", "Y3").replaceAll("y", "2").replaceAll("2", "").replaceAll("3", "");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(replaceAll);
        stringBuffer.append(f4308a);
        return stringBuffer.toString().substring(0, 6);
    }
}
